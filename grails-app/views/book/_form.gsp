<%@ page import="es.cp.test.Book" %>



<div class="fieldcontain ${hasErrors(bean: bookInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="book.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" value="${bookInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: bookInstance, field: 'bookReleaseDate', 'error')} required">
	<label for="bookReleaseDate">
		<g:message code="book.bookReleaseDate.label" default="Book Release Date" />
		<span class="required-indicator">*</span>
	</label>

	<input type="text" name="bookReleaseDate" value="${fieldValue(bean: bookInstance, field: 'bookReleaseDate') ?: '07/16/2015 14:00'}"

</div>

