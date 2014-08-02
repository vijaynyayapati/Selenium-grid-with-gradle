webdriver-with-gradle
=====================

This is a framework I created for Selenium with gradle. The framework uses the page object pattern and the tests are influenced by the fluent interface. I have used the fluentlenium framework for user interactions. The framework is quite barebones at the moment.

To run the tests you need to launch the Hub and the node. You can do so by running the following commands

-gradle startWebDriverGridHub

-On another terminal type gradle startWebDriverGridNode

-Note that you will need to change the permissions of two shell scripts to be able to run these gradle tasks

-you can do so by running the following command

-chmod 755 startWebDriverGridHub.sh (Same for the Node shell script)

-To run the tests, use the following commands
--gradle runAllTestsInFirefox
or
--gradle runAllTestsInChrome

-There is also a shutDownNodeAndHub task which can be invoked as a gradle task.

-I would like to automate the starting and stopping of the hub and nodes via gradle tasks. Will do that soon.

