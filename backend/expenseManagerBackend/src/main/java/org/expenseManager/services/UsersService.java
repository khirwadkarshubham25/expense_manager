package org.expenseManager.services;

import org.expenseManager.dto.LoginDto;
import org.expenseManager.dto.LoginResponseDto;
import org.expenseManager.dto.RegisterDto;
import org.expenseManager.models.Users;
import org.expenseManager.repositories.UsersRepository;
import org.expenseManager.dto.AuthenticatedUserDto;
import org.expenseManager.security.JWTTokensManager;
import org.expenseManager.validations.UserValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Service
public class UsersService {

    final UsersRepository usersRepository;
    @Autowired
    private UserValidations userValidations;

    @Autowired
    private JWTTokensManager jwtTokensManager;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public LoginResponseDto getUser(LoginDto loginDto){
        userValidations.validateLoginUsers(loginDto);
        final Users users = usersRepository.findUsersByEmail(loginDto.getEmail());
        final String token = jwtTokensManager.generateToken(new AuthenticatedUserDto(users));
        return new LoginResponseDto(token, "Successfully Logged In!");

    }

    public void saveUsers(RegisterDto registerDto){
        userValidations.validateRegisterUsers(registerDto);
        Users users = new Users(registerDto.getFirstName(), registerDto.getLastName(), registerDto.getEmail(), registerDto.getPassword());
        users.setCreatedAt(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(Calendar.getInstance().getTime()));
        users.setUpdatedAt(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(Calendar.getInstance().getTime()));
        users.setStatus(1);
        usersRepository.save(users);
    }
}
