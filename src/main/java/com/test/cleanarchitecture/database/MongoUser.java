package com.test.cleanarchitecture.database;


import com.test.cleanarchitecture.model.UserDsResponseModel;
import com.test.cleanarchitecture.entity.UserDataMapper;
import com.test.cleanarchitecture.model.UserDsRequestModel;
import com.test.cleanarchitecture.repository.MongodbUserRepository;

import java.util.List;
import java.util.stream.Collectors;

public class MongoUser implements UserDsGateway {

    private final MongodbUserRepository repository;

    public MongoUser(MongodbUserRepository repository) {
        this.repository = repository;
    }
    @Override
    public void save(UserDsRequestModel requestModel) {
        UserDataMapper accountDataMapper = new UserDataMapper(requestModel.getId(), requestModel.getLastName(), requestModel.getFirstName(), requestModel.getGender(), requestModel.getBirthday(), requestModel.getEmail());
        repository.save(accountDataMapper);
    }

    @Override
    public List<UserDsResponseModel> findBirthdayByDate(String birthMonth, String birthDay) {
        int month = Integer.parseInt(birthMonth);
        int day = Integer.parseInt(birthDay) - 1;
        List<UserDataMapper> result = repository.findAllUserById(month, day);
        return result.stream().map(s -> new UserDsResponseModel(s.getLastName(), s.getFirstName(), s.getGender(), s.getBirthday(), s.getEmail())).collect(Collectors.toList());

    }

    @Override
    public List<UserDsResponseModel> findAll() {
        List<UserDataMapper> result = repository.findAll();
        return result.stream().map(s -> new UserDsResponseModel(s.getLastName(), s.getFirstName(), s.getGender(), s.getBirthday(), s.getEmail())).collect(Collectors.toList());
    }
}
