package es.cp.test

import grails.test.spock.IntegrationSpec
import org.codehaus.groovy.grails.plugins.web.taglib.ApplicationTagLib

class BookIntegrationSpec extends IntegrationSpec {

    ApplicationTagLib g

    def setup() {
        g = new org.codehaus.groovy.grails.plugins.web.taglib.ApplicationTagLib()
    }

    def cleanup() {
    }

    void "field value return should be formatted with CustomDateEditor"() {
        given: "A New Book"
            Book bookInstance = new Book(name: null, bookReleaseDate: new Date(100000))

        when:
            bookInstance.validate()

        then:
            g.fieldValue(bean: bookInstance, field: 'bookReleaseDate') == '12/31/1969 19:01'
    }
}
