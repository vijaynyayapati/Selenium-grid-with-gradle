webdriver-with-gradle
=====================

This is a framework I created for webdriver with gradle. The framework uses the page object pattern and the tests are influenced by the fluent interface. I have used the fluentlenium framework for user interactions. The framework is quite barebones at the moment.

You can run the sample test with the following command

build functional

The default browser is Chrome, but if you would like to run using Firefox, run the following command

build functional -Dbrowser='Firefox'
