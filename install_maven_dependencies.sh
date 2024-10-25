#!/bin/sh
# To make this project work with maven, execute this batch file to install dependencies which are not in the central repository

mvn install:install-file -DgroupId=commons-io -DartifactId=commons-io -Dversion=2.0.1 -Dpackaging=jar -Dfile=./lib/commons-io-2.0.1.jar
mvn install:install-file -DgroupId=net.lingala.zip4j -DartifactId=zip4j -Dversion=1.3.2 -Dpackaging=jar -Dfile=./lib/zip4j-1.3.2.jar
mvn install:install-file -DgroupId=com.exlibris -DartifactId=dps-sdk -Dversion=4.2.1 -Dpackaging=jar -Dfile=./lib/dps-sdk-4.2.1.jar
