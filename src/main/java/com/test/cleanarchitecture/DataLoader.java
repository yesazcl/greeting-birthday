package com.test.cleanarchitecture;

import com.test.cleanarchitecture.database.UserDsGateway;
import com.test.cleanarchitecture.model.UserDsRequestModel;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.time.LocalDate;

public class DataLoader implements ApplicationRunner {

    private UserDsGateway userRepository;

    public DataLoader(UserDsGateway userRepository) {
        this.userRepository = userRepository;
    }

    public void run(ApplicationArguments args) {
        userRepository.save(new UserDsRequestModel(1L,"Yen", "Robert", "Male", LocalDate.parse("1985-08-08"), "robert.yen@linecorp.com"));
        userRepository.save(new UserDsRequestModel(2L,"Change", "Cid", "Male", LocalDate.parse("1990-10-10"), "cid.change@linecorp.com"));
        userRepository.save(new UserDsRequestModel(3L,"Lai", "Miki", "Female", LocalDate.parse("1993-04-05"), "miki.lai@linecorp.com"));
        userRepository.save(new UserDsRequestModel(4L,"Chen", "Sherry", "Female", LocalDate.parse("1993-08-08"), "sherry.lai@linecorp.com"));
        userRepository.save(new UserDsRequestModel(5L,"Wang", "Peter", "Male", LocalDate.parse("1950-12-22"), "peter.wang@linecorp.com"));
    }
}

