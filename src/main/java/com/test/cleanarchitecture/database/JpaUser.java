package com.test.cleanarchitecture.database;


import com.test.cleanarchitecture.entity.UserDataMapper;
import com.test.cleanarchitecture.model.UserDsRequestModel;
import com.test.cleanarchitecture.model.UserDsResponseModel;
import com.test.cleanarchitecture.repository.JpaUserRepository;


import java.util.List;
import java.util.stream.Collectors;

public class JpaUser implements UserDsGateway {

    private final JpaUserRepository repository;

    public JpaUser(JpaUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(UserDsRequestModel requestModel) {
        UserDataMapper accountDataMapper = new UserDataMapper(requestModel.getId(), requestModel.getLastName(), requestModel.getFirstName(), requestModel.getGender(), requestModel.getBirthday(), requestModel.getEmail());
        repository.save(accountDataMapper);
    }

    @Override
    public List<UserDsResponseModel> findBirthdayByDate(String birthMonth, String birthDay) {
        List<UserDataMapper> result = repository.findBirthdayByDate(birthMonth, birthDay);
        return result.stream().map(s -> new UserDsResponseModel(s.getLastName(), s.getFirstName(), s.getGender(), s.getBirthday(), s.getEmail())).collect(Collectors.toList());

    }

    @Override
    public List<UserDsResponseModel> findAll() {
        List<UserDataMapper> result = repository.findAll();
        return result.stream().map(s -> new UserDsResponseModel(s.getLastName(), s.getFirstName(), s.getGender(), s.getBirthday(), s.getEmail())).collect(Collectors.toList());
    }
}
