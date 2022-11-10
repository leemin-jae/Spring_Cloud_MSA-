package com.cos.userserive.Controller;

import com.cos.userserive.dto.UserDto;
import com.cos.userserive.service.UserService;
import com.cos.userserive.vo.RequestUser;
import com.cos.userserive.vo.ResponseUser;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
public class UserController {

    private Environment env;
    private UserService userService;

    @Autowired
    UserController(Environment env, UserService userService){
        this.env = env;
        this.userService = userService;
    }


    @GetMapping("/heath_check")
    public String status(){
        return String.format("It's working in User Service"
                + ", port(local.server.port)=" +env.getProperty("local.server.port")
                + ", port(server.port)=" +env.getProperty("server.port")
                + ", token secret=" +env.getProperty("token.secret")
                + ", token expiration time=" +env.getProperty("token.expiration_time")

        );
    }

    @PostMapping("/users")
    public ResponseEntity<?> createUser(@RequestBody RequestUser user){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserDto userDto = mapper.map(user, UserDto.class);
        userService.createUser(userDto);

        ResponseUser responseUser = mapper.map(userDto, ResponseUser.class);



        return ResponseEntity.status(HttpStatus.CREATED).body(responseUser);
    }
}
