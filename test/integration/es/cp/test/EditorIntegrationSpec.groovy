package es.cp.test

import grails.test.spock.IntegrationSpec
import org.codehaus.groovy.grails.web.servlet.mvc.GrailsWebRequest
import test.CustomDateEditor

class EditorIntegrationSpec extends IntegrationSpec {

    void 'test that the expected editor is found'() {
        given:
        def webRequest = GrailsWebRequest.lookup()
        def registry = webRequest.getPropertyEditorRegistry()
        def editor = registry.findCustomEditor(Date, 'bookReleaseDate')

        expect:
        editor instanceof CustomDateEditor
    }
}
