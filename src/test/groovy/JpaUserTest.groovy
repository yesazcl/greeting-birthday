import com.test.cleanarchitecture.database.JpaUser
import com.test.cleanarchitecture.entity.UserDataMapper
import com.test.cleanarchitecture.model.UserDsResponseModel
import com.test.cleanarchitecture.repository.JpaUserRepository
import spock.lang.Specification

import java.time.LocalDate

class JpaUserTest extends Specification {
    JpaUserRepository repository = Mock(JpaUserRepository)

    def "test get by birthday"() {
        String birthday = "08"
        String birthMonth = "08"
        JpaUser jpaUser = new JpaUser(repository);
        List<UserDataMapper> userDataMapperList = new ArrayList<>()
        UserDataMapper userDataMapper = new UserDataMapper(1L, "Yen", "Robert", "Male", LocalDate.parse("1985-" + birthMonth + "-" + birthday), "robert.yen@linecorp.com");
        userDataMapperList.add(userDataMapper);
        given:
        repository.findBirthdayByDate(birthMonth, birthday) >> userDataMapperList
        when:
        List<UserDsResponseModel> userDsResponseModelList = jpaUser.findBirthdayByDate("08", "08")
        then:
        userDsResponseModelList.size() == 1

    }

    def "test get by birthday not found"() {
        String birthday = "08"
        String birthMonth = "08"
        JpaUser jpaUser = new JpaUser(repository);
        List<UserDataMapper> userDataMapperList = new ArrayList<>()

        given:
        repository.findBirthdayByDate(birthMonth, birthday) >> userDataMapperList
        when:
        List<UserDsResponseModel> userDsResponseModelList = jpaUser.findBirthdayByDate("08", "08")
        then:
        userDsResponseModelList.size() == 0

    }
}
