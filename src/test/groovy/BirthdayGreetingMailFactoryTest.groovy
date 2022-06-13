import com.test.cleanarchitecture.usercases.Mails.V1Mail
import com.test.cleanarchitecture.usercases.Mails.V2Mail
import com.test.cleanarchitecture.usercases.Mails.V3Mail
import com.test.cleanarchitecture.usercases.Mails.V4Mail
import com.test.cleanarchitecture.entity.Mail
import com.test.cleanarchitecture.factory.BirthdayGreetingMailFactory
import com.test.cleanarchitecture.factory.MailFactory
import com.test.cleanarchitecture.model.UserDsResponseModel
import spock.lang.Specification

import java.time.LocalDate

class BirthdayGreetingMailFactoryTest extends Specification {

    MailFactory mailFactory = new BirthdayGreetingMailFactory();

    def "test get v1 mail"() {
        given:
        UserDsResponseModel userDsResponseModel = new UserDsResponseModel("L", "F", "Male", LocalDate.parse("1985-08-08"), "robert.yen@linecorp.com");
        when:
        Mail mail = mailFactory.create(userDsResponseModel, "v1")
        then:
        mail instanceof V1Mail

    }

    def "test get v2 mail"() {
        given:
        UserDsResponseModel userDsResponseModel = new UserDsResponseModel("L", "F", "Male", LocalDate.parse("1985-08-08"), "robert.yen@linecorp.com");
        when:
        Mail mail = mailFactory.create(userDsResponseModel, "v2")
        then:
        mail instanceof V2Mail

    }

    def "test get v3 mail"() {
        given:
        UserDsResponseModel userDsResponseModel = new UserDsResponseModel("L", "F", "Male", LocalDate.parse("1985-08-08"), "robert.yen@linecorp.com");
        when:
        Mail mail = mailFactory.create(userDsResponseModel, "v3")
        then:
        mail instanceof V3Mail

    }

    def "test get v4 mail"() {
        given:
        UserDsResponseModel userDsResponseModel = new UserDsResponseModel("L", "F", "Male", LocalDate.parse("1985-08-08"), "robert.yen@linecorp.com");
        when:
        Mail mail = mailFactory.create(userDsResponseModel, "v4")
        then:
        mail instanceof V4Mail

    }

    def "test get no version mail"() {
        given:
        UserDsResponseModel userDsResponseModel = new UserDsResponseModel("L", "F", "Male", LocalDate.parse("1985-08-08"), "robert.yen@linecorp.com");
        when:
        Mail mail = mailFactory.create(userDsResponseModel, "v5")
        then:
        mail == null

    }
}
