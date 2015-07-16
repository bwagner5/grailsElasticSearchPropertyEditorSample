

import org.apache.commons.lang.time.DateUtils
import org.springframework.beans.PropertyEditorRegistrar
import org.springframework.beans.PropertyEditorRegistry

import java.beans.PropertyEditorSupport
import java.text.ParseException

class CustomPropertyEditorRegistrar implements PropertyEditorRegistrar {

    /** The date editor. */
    def dateEditor

    /* (non-Javadoc)
     * @see org.springframework.beans.PropertyEditorRegistrar#registerCustomEditors(org.springframework.beans.PropertyEditorRegistry)
     */

    void registerCustomEditors(PropertyEditorRegistry registry) {
        println "REGISTERING BEAN!!"
        registry.registerCustomEditor(Date.class, new CustomDateEditor(allowEmpty: false, formats: ['MM/dd/yyyy HH:mm']))
    }
}

class CustomDateEditor extends PropertyEditorSupport {
    boolean allowEmpty
    String[] formats

    /**
     * Parse the Date from the given text
     */
    void setAsText(String text) throws IllegalArgumentException {

        if (this.allowEmpty && !text) {
            // Treat empty String as null value.
            setValue(null)
        } else {
            try {
                setValue(DateUtils.parseDate(text, formats))
            }
            catch (ParseException ex) {
                throw new IllegalArgumentException("Could not parse date: " + ex.getMessage(), ex)
            }
        }
    }

    /**
     * Format the Date as String, using the first specified format
     */
    String getAsText() {
        def val = getValue()
        val?.respondsTo('format') ? val.format(formats[0]) : ''
    }
}