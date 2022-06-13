import com.test.cleanarchitecture.database.MongoUser
import com.test.cleanarchitecture.entity.UserDataMapper
import com.test.cleanarchitecture.model.UserDsResponseModel
import com.test.cleanarchitecture.repository.MongodbUserRepository
import spock.lang.Specification

import java.time.LocalDate

class MongoUserTest extends Specification {
    MongodbUserRepository repository = Mock(MongodbUserRepository)

    def "test get by birthday"() {
        String birthday = "08"
        String birthMonth = "08"
        MongoUser mongoUser = new MongoUser(repository);
        List<UserDataMapper> userDataMapperList = new ArrayList<>()
        UserDataMapper userDataMapper = new UserDataMapper(1L, "Yen", "Robert", "Male", LocalDate.parse("1985-" + birthMonth + "-" + birthday), "robert.yen@linecorp.com");
        userDataMapperList.add(userDataMapper);
        given:
        repository.findAllUserById(Integer.parseInt(birthMonth), Integer.parseInt(birthday) - 1) >> userDataMapperList
        when:
        List<UserDsResponseModel> userDsResponseModelList = mongoUser.findBirthdayByDate("08", "08")
        then:
        userDsResponseModelList.size() == 1

    }

    def "test get by birthday not found"() {
        String birthday = "08"
        String birthMonth = "08"
        MongoUser mongoUser = new MongoUser(repository);
        List<UserDataMapper> userDataMapperList = new ArrayList<>()

        given:
        repository.findAllUserById(Integer.parseInt(birthMonth), Integer.parseInt(birthday) - 1) >> userDataMapperList
        when:
        List<UserDsResponseModel> userDsResponseModelList = mongoUser.findBirthdayByDate("08", "08")
        then:
        userDsResponseModelList.size() == 0

    }
}
