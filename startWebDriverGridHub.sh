#!/bin/bash

echo "WebDriver Grid Hub on 4444"
echo ""
 
echo "*********************************************"
echo "*"
echo "* WebDriver grid Hub instance."
echo "*"
echo "*  http://localhost:4444/grid/console"
echo "*"
echo "*********************************************"
echo ""
 
jarfile=selenium-server-2.41.0.jar 
 
if [ -z "${JAVA_HOME+xxx}" ]; then
  echo JAVA_HOME is not set at all;
  exit 1  
fi

echo $JAVA_HOME
export PATH="$JAVA_HOME/bin:$PATH"
echo $PATH

$JAVA_HOME/bin/java -jar $jarfile -role hub -hubConfig ./hubConfigMacOSX.json -debug