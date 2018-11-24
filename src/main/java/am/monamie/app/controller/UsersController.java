package am.monamie.app.controller;

import am.monamie.app.models.User;
import am.monamie.app.models.UserLoginPost;
import am.monamie.app.models.UserRegisterPost;
import am.monamie.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("ALL")
@RestController
public class UsersController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/a")
    public String showA() {
        return "a";
    }


    @PostMapping(value = "/register")
    public Map<String, Object> registerUser(@RequestBody UserRegisterPost userRegisterPost) {
        Map<String, Object> map = new HashMap<>();
        if (userService.findByLogin(userRegisterPost.getLogin()).isPresent()) {
            map.put("success", "false");
            map.put("message", "Incorrect email or password. Please try again");
            map.put("data", null);
        } else {
            User user = new User();
            user.setFirstName(userRegisterPost.getFirstName());
            user.setLastName(userRegisterPost.getLastName());
            user.setLogin(userRegisterPost.getLogin());
            user.setPassword(userRegisterPost.getPassword());
            userService.saveAndFlush(user);
            map.put("success", "true");
            map.put("message", "Registration Successfully");
            map.put("data", user);

        }
        return map;
    }


    @PostMapping(value = "/login")
    public Map<String, Object> registerUser(@RequestBody UserLoginPost userLoginPost) {
        Map<String, Object> map = new HashMap<>();
        if (userService.findByLoginAndPassword(userLoginPost.getLogin(), userLoginPost.getPassword()).isPresent()) {
            map.put("success", String.valueOf(true));
            map.put("message", "Login Successfuly");
            map.put("data", userService.findByLoginAndPassword(userLoginPost.getLogin(), userLoginPost.getPassword()));
        } else {
            map.put("success", String.valueOf(false));
            map.put("message", "Login Failed");
            map.put("data", null);
        }
        return map;
    }


}
