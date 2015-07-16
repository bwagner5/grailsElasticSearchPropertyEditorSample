*This is a sample debug app for an issue where Custom Property Editors do not work when the Elastic Search Grails plugin is used.*

The last two commits show case the behavior.
- Commit 66ee3ab shows the code not working (when ElasticSearch is included)
- Commit c946a4d shows the code working (when ElasticSeach is commented out in the BuildConfig)


*To Test:*

1) grails run-app
2) go to BookController -> Create New Book -> Click Save (without filling the form out)
    - This will cause a validation error on the non-nullable 'name' property (a date is pre-filled in the correct format)