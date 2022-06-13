package com.test.cleanarchitecture;

import com.test.cleanarchitecture.model.UserDsResponseModel;
import com.test.cleanarchitecture.model.UserRequestModel;
import com.test.cleanarchitecture.usercases.UserInputBoundary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserInputBoundary userInput;

    public UserController(UserInputBoundary accountGateway) {
        this.userInput = accountGateway;
    }

    @GetMapping("/user")
    public String getUserByBirthday(@RequestParam String birthdayOfMonth, @RequestParam String birthdayOfDay,
                                    @RequestParam(required = false) String version,
                                    @RequestParam(required = false) String format) {
        UserRequestModel userRequestModel = new UserRequestModel();
        userRequestModel.setBirthMonth(birthdayOfMonth);
        userRequestModel.setBirthDay(birthdayOfDay);
        return userInput.findByBirthday(userRequestModel, version, format);
    }

    @GetMapping("/user/all")
    public List<UserDsResponseModel> getAll() {
        return userInput.getAllUser();
    }
}
