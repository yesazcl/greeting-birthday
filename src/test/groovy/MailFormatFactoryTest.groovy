import com.test.cleanarchitecture.mailformat.JsonMailFormat
import com.test.cleanarchitecture.mailformat.MailFormat
import com.test.cleanarchitecture.mailformat.RawStringMailFormat
import com.test.cleanarchitecture.mailformat.XMLMailFormat
import com.test.cleanarchitecture.factory.FormatFactory
import com.test.cleanarchitecture.factory.MailFormatFactory
import spock.lang.Specification

class MailFormatFactoryTest extends Specification {
    FormatFactory formatFactory = new MailFormatFactory()

    def "test get json format"() {
        when:
        MailFormat mailFormat = formatFactory.create("json")
        then:
        mailFormat instanceof JsonMailFormat

    }

    def "test get xml format"() {
        when:
        MailFormat mailFormat = formatFactory.create("xml")
        then:
        mailFormat instanceof XMLMailFormat

    }

    def "test get raw format"() {
        when:
        MailFormat mailFormat = formatFactory.create("")
        then:
        mailFormat instanceof RawStringMailFormat

    }
}
