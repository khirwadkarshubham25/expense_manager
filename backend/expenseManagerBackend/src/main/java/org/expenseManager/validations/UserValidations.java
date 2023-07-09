package org.expenseManager.validations;

import org.expenseManager.dto.LoginDto;
import org.expenseManager.dto.RegisterDto;
import org.expenseManager.models.Users;
import org.expenseManager.repositories.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class UserValidations {

    private final UsersRepository usersRepository;

    public UserValidations(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public void validateRegisterUsers(RegisterDto registerDto){
        final String email = registerDto.getEmail();
        final String password = registerDto.getPassword();
        final String confirm_password = registerDto.getConfirmPassword();

        checkEmail(email);
        checkPasswords(password, confirm_password);
    }

    public void checkEmail(String email){
        final boolean existsEmail = usersRepository.existsByEmail(email);
        if(existsEmail){
            throw new RuntimeException("Email Id already exists");
        }
    }

    public void checkPasswords(String password, String confirm_password){
        if(!password.equals(confirm_password)){
            throw new RuntimeException("Confirm Password does not match");
        }
        if (!password.matches(".*[A-Z].*") || !password.matches(".*[a-z].*") || (!password.matches(".*\\d.*")) || !password.matches(".*[@$#!].*")){
            throw new RuntimeException("Password does not meet criteria");
        }
    }


    public void validateLoginUsers(LoginDto loginDto){
        final String email = loginDto.getEmail();
        final String password = loginDto.getPassword();

        final Users users = usersRepository.findUsersByEmail(email);

        if (users == null || !users.getPassword().equals(password)){
            throw new RuntimeException("Invalid email/password");
        }
    }
}
