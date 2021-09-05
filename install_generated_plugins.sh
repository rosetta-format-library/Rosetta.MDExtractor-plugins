#!/bin/sh
# To make this project work with maven, execute this batch file to install dependencies which are not in the central repository

## Install the other dependencies that exist locally
mvn install:install-file -DgroupId=com.exlibris.plugins -DartifactId=pdfExtractor -Dversion=1.24.0 -Dpackaging=jar -Dfile=./generated-plugins/PDFHULMDExtractor1_24Plugin.jar
mvn install:install-file -DgroupId=com.exlibris.plugins -DartifactId=epubExtractor -Dversion=1.24.0 -Dpackaging=jar -Dfile=./generated-plugins/EPUBPTCMDExtractor1_24Plugin.jar

