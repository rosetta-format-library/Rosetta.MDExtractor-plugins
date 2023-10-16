#!/bin/sh
# To make this project work with maven, execute this batch file to install dependencies which are not in the central repository

## Install the other dependencies that exist locally
mvn install:install-file -DgroupId=commons-io -DartifactId=commons-io -Dversion=2.0.1 -Dpackaging=jar -Dfile=./lib/commons-io-2.0.1.jar
mvn install:install-file -DgroupId=net.lingala.zip4j -DartifactId=zip4j -Dversion=1.3.2 -Dpackaging=jar -Dfile=./lib/zip4j-1.3.2.jar
#mvn install:install-file -DgroupId=org.openpreservation.jhove -DartifactId=jhove -Dversion=1.26.1 -Dpackaging=pom -Dfile=./lib/jhove-1.26.1.pom
#mvn install:install-file -DgroupId=org.openpreservation.jhove -DartifactId=jhove-core -Dversion=1.26.1 -Dpackaging=jar -Dfile=./lib/jhove-core-1.26.1.jar
#mvn install:install-file -DgroupId=org.openpreservation.jhove.modules -DartifactId=utf8-hul -Dversion=1.7.1 -Dpackaging=jar -Dfile=./lib/utf8-hul-1.7.1.jar
#mvn install:install-file -DgroupId=org.openpreservation.jhove.modules -DartifactId=aiff-hul -Dversion=1.6.1 -Dpackaging=jar -Dfile=./lib/aiff-hul-1.6.1.jar
#mvn install:install-file -DgroupId=org.openpreservation.jhove.modules -DartifactId=pdf-hul -Dversion=1.12.2 -Dpackaging=jar -Dfile=./lib/pdf-hul-1.12.2.jar
#mvn install:install-file -DgroupId=org.openpreservation.jhove.modules -DartifactId=ascii-hul -Dversion=1.4.1 -Dpackaging=jar -Dfile=./lib/ascii-hul-1.4.1.jar
#mvn install:install-file -DgroupId=org.openpreservation.jhove.modules -DartifactId=tiff-hul -Dversion=1.9.2 -Dpackaging=jar -Dfile=./lib/tiff-hul-1.9.2.jar
#mvn install:install-file -DgroupId=org.openpreservation.jhove.modules -DartifactId=xml-hul -Dversion=1.5.1 -Dpackaging=jar -Dfile=./lib/xml-hul-1.5.1.jar
#mvn install:install-file -DgroupId=org.openpreservation.jhove.modules -DartifactId=wave-hul -Dversion=1.8.1 -Dpackaging=jar -Dfile=./lib/wave-hul-1.8.1.jar
#mvn install:install-file -DgroupId=org.openpreservation.jhove.modules -DartifactId=html-hul -Dversion=1.4.1 -Dpackaging=jar -Dfile=./lib/html-hul-1.4.1.jar
#mvn install:install-file -DgroupId=org.openpreservation.jhove.modules -DartifactId=jpeg-hul -Dversion=1.5.2 -Dpackaging=jar -Dfile=./lib/jpeg-hul-1.5.2.jar
#mvn install:install-file -DgroupId=org.openpreservation.jhove.modules -DartifactId=jpeg2000-hul -Dversion=1.4.2 -Dpackaging=jar -Dfile=./lib/jpeg2000-hul-1.4.2.jar
#mvn install:install-file -DgroupId=org.openpreservation.jhove.modules -DartifactId=gif-hul -Dversion=1.4.2 -Dpackaging=jar -Dfile=./lib/gif-hul-1.4.2.jar
#mvn install:install-file -DgroupId=org.openpreservation.jhove.modules -DartifactId=jhove-modules -Dversion=1.26.1 -Dpackaging=pom -Dfile=./lib/jhove-modules-1.26.1.pom
#mvn install:install-file -DgroupId=org.openpreservation.jhove -DartifactId=jhove-ext-modules -Dversion=1.26.1 -Dpackaging=jar -Dfile=./lib/jhove-ext-modules-1.26.1.jar
mvn install:install-file -DgroupId=com.exlibris -DartifactId=dps-sdk -Dversion=4.2.1 -Dpackaging=jar -Dfile=./lib/dps-sdk-4.2.1.jar
#mvn install:install-file -DgroupId=log4j -DartifactId=log4j -Dversion=1.2.17 -Dpackaging=jar -Dfile=log4j-1.2.17.jar
