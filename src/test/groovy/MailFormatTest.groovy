import com.test.cleanarchitecture.usercases.Mails.V1Mail
import com.test.cleanarchitecture.usercases.Mails.V2Mail
import com.test.cleanarchitecture.usercases.Mails.V3Mail
import com.test.cleanarchitecture.usercases.Mails.V4Mail
import com.test.cleanarchitecture.model.MailInputModel
import spock.lang.Specification

import java.time.LocalDate

class MailFormatTest extends Specification {

    def "test v1 mail"() {
        given:
        MailInputModel mailInputModel = new MailInputModel("L", "F", "Male", LocalDate.parse("1985-08-08"))
        V1Mail v1Mail = new V1Mail();
        v1Mail.setMailInputModel(mailInputModel)
        when:
        String subject = v1Mail.getSubject()
        String content = v1Mail.getContent()
        then:
        subject == "Subject:Happy birthday!"
        content == "Happy birthday, dear L!"
    }

    def "test v2 mail male"() {
        given:
        MailInputModel mailInputModel = new MailInputModel("L", "F", "Male", LocalDate.parse("1985-08-08"))
        V2Mail v2Mail = new V2Mail();
        v2Mail.setMailInputModel(mailInputModel)
        when:
        String subject = v2Mail.getSubject()
        String content = v2Mail.getContent()
        then:
        subject == "Subject:Happy birthday!"
        content == "Happy birthday, dear L!\n" +
                "We offer special discount 20% off for the following items:\n" +
                "White Wine, iPhone X"
    }

    def "test v2 mail female"() {
        given:
        MailInputModel mailInputModel = new MailInputModel("L", "F", "Female", LocalDate.parse("1985-08-08"))
        V2Mail v2Mail = new V2Mail();
        v2Mail.setMailInputModel(mailInputModel)
        when:
        String subject = v2Mail.getSubject()
        String content = v2Mail.getContent()
        then:
        subject == "Subject:Happy birthday!"
        content == "Happy birthday, dear L!\n" +
                "We offer special discount 50% off for the following items:\n" +
                "Cosmetic, LV Handbags"
    }

    def "test v3 mail over 49"() {
        given:
        MailInputModel mailInputModel = new MailInputModel("L", "F", "Female", LocalDate.parse("1950-08-08"))
        V3Mail v3Mail = new V3Mail();
        v3Mail.setMailInputModel(mailInputModel)
        when:
        String subject = v3Mail.getSubject()
        String content = v3Mail.getContent()
        then:
        subject == "Subject:Happy birthday!"
        content == "Happy birthday, dear L! (A greeting picture here)"
    }

    def "test v3 mail not over 49"() {
        given:
        MailInputModel mailInputModel = new MailInputModel("L", "F", "Female", LocalDate.parse("1988-08-08"))
        V3Mail v3Mail = new V3Mail();
        v3Mail.setMailInputModel(mailInputModel)
        when:
        String subject = v3Mail.getSubject()
        String content = v3Mail.getContent()
        then:
        subject == "Subject:Happy birthday!"
        content == "Happy birthday, dear L!"
    }

    def "test v4 mail"() {
        given:
        MailInputModel mailInputModel = new MailInputModel("L", "F", "Male", LocalDate.parse("1985-08-08"))
        V4Mail v4Mail = new V4Mail();
        v4Mail.setMailInputModel(mailInputModel)
        when:
        String subject = v4Mail.getSubject()
        String content = v4Mail.getContent()
        then:
        subject == "Subject:Happy birthday!"
        content == "Happy birthday, dear L F!"
    }
}
