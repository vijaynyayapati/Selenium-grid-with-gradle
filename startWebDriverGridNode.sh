#!/bin/bash

echo "WebDriver Grid Hub on 4444"
echo ""
 
echo "*********************************************"
echo "*"
echo "* WebDriver Grid Node"
echo "* It requires that a WebDriver JSON Hub is already running, usually on port 5555."
echo "* You can run more than one of these if each has its own JSON config file."
echo "*"
echo "*********************************************"
echo ""

export run_directory=./test_lib
 
jarfile=selenium-server-standalone-2.41.0.jar
chromedriverbin=../src/test/tools/chromedriver 

if [ -z "${JAVA_HOME+xxx}" ]; then
  echo JAVA_HOME is not set at all;
  exit 1  
fi

echo $JAVA_HOME
export PATH="$JAVA_HOME/bin:$PATH"
echo $PATH

cd $run_directory

nohup $JAVA_HOME/bin/java -jar $jarfile -role node -nodeConfig ../nodeConfigMacOSX.json -Dwebdriver.chrome.driver=$chromedriverbin

echo 'Done'
exit