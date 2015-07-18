package es.cp.test

import grails.test.spock.IntegrationSpec
import org.codehaus.groovy.grails.plugins.web.taglib.ApplicationTagLib

import java.text.SimpleDateFormat

class BookIntegrationSpec extends IntegrationSpec {

    ApplicationTagLib g

    def setup() {
        g = new org.codehaus.groovy.grails.plugins.web.taglib.ApplicationTagLib()
    }

    def cleanup() {
    }

    void "field value return should be formatted with CustomDateEditor"() {
        given: "A New Book"
            def now = new Date()
            def formatter = new SimpleDateFormat('MM/dd/yyyy HH:mm')
            def expectedString = formatter.format(now)
            Book bookInstance = new Book(name: null, bookReleaseDate: now)

        when:
            bookInstance.validate()

        then:
            g.fieldValue(bean: bookInstance, field: 'bookReleaseDate') == expectedString
    }
}
