package org.expenseManager.restController;

import org.expenseManager.dto.LoginDto;
import org.expenseManager.dto.LoginResponseDto;
import org.expenseManager.dto.RegisterDto;
import org.expenseManager.services.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/users")
public class UsersController {
    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/login")
    public ResponseEntity<LoginResponseDto> getUsers(@RequestBody LoginDto loginDto){
        return ResponseEntity.ok(usersService.getUser(loginDto));
    }
    @PostMapping("/register")
    public ResponseEntity<String> saveUsers(@RequestBody RegisterDto registerDto){
        usersService.saveUsers(registerDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Successfully Created new user");
    }
}
