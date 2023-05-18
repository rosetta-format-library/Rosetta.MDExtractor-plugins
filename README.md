<h1 align="center">Rosetta.MDExtractor-plugins</h1>

# 1. Introduction
Rosetta.MDExtractor-plugins are a series of plugins based on JHOVE(https://github.com/openpreserve/jhove) (the JSTOR/Harvard Object Validation Environment, pronounced "jove"), which implemented the APIs according to Rosetta's plugin framework. Rosetta can call the metadata extracting methods of JHOVE via these Rosetta.MDExtractor-plugins.


# 2. Getting started
A unix-like desktop operating system is required for Rosetta.MDExtractor-plugins development. Both physical machine and virtual machine can do work. The installation instruction below are tested on Ubuntu20.04.


## 2.1. Installation
Rosetta.MDExtractor-plugins are Java code plugins. JDK and Ant are required to compile and package the Java codes as JAR files. Absolutely you need Git and an IDE to manage and edit your codes.

### 2.1.1 JDK, Ant, Git, Maven
``` shell script
sudo apt update
sudo apt install openjdk-8-jdk ant git maven -y
```
### 2.1.2 IDE: IntelliJ IDEA and Sublime Text are recommended

#### 2.1.2.1 IntelliJ IDEA installation:
``` shell script
sudo snap install intellij-idea-community --classic
```

#### 2.1.2.2 Sublime Text installation:

- Install the GPG key:
``` shell script
wget -qO - https://download.sublimetext.com/sublimehq-pub.gpg | gpg --dearmor | sudo tee /etc/apt/trusted.gpg.d/sublimehq-archive.gpg > /dev/null
```

- Install the stable version:
``` shell script
echo "deb https://download.sublimetext.com/ apt/stable/" | sudo tee /etc/apt/sources.list.d/sublime-text.list
```

## 2.2 Overall Work Process
### 2.2.1 Get source code: 
- First of all you need to determine which version (tag or branch) is the right base according to the requirements. 
``` shell script
git clone git@github.com:leefrank9527/Rosetta.MDExtractor-plugins.git
```

- Then, you can checkout the branch and start to work on that.
``` shell script
git checkout origin/<The related branch> -b <a new branch>
```

### 2.2.2 Implement and test the requirements locally.

### 2.2.3 Commit the changes.
``` shell script
git add <The new added and changed files>
git commit -m "Some comments"
git push origin <The local branch name>
```

### 2.2.4 Build the plugins. 
You can use the command "ant" to compile and build the souce code. The compiled java classes, the relevant libraries and the metadata files will be packaged into jar files. The "ant" command will collect and package the files based on the rules defined in the "build.xml" file.
``` shell script
cd Rosetta.MDExtractor-plugins
ant
```
If it's succeed you can find the plugins in the folder: generated-plugins.

### 2.2.5 Testing
Test the plugins on the Rosetta based environment.

### 2.2.6 Merge
You can submit a PR(Pull Request) on Github, and merge the changes to the main branch if it passed all the tests.




# 3 Steps for creating new MDExtractor plugins with a new JHOVE version
## 3.1 Download the new JHOVE version. 
You must have the following jars (For JHove 1.26.1):
### 3.1.1 The core modules:
- jhove-core-1.26.1.jar
- aiff-hul-1.6.2.jar
- ascii-hul-1.4.2.jar
- gif-hul-1.4.3.jar
- html-hul-1.4.2.jar
- jpeg2000-hul-1.4.3.jar
- jpeg-hul-1.5.3.jar
- pdf-hul-1.12.3.jar
- tiff-hul-1.9.3.jar
- utf8-hul-1.7.2.jar
- wave-hul-1.8.2.jar
- xml-hul-1.5.2.jar

### 3.1.2 The external modules:
- jhove-ext-modules-1.26.1.jar

The dependencies can be fetched from maven repository. The convenient way is to build the jars from source code and pick up the required jars.
``` shell script
git clone git@github.com:openpreserve/jhove.git
cd jhove
git checkout tags/v1.26.1 -b v1.26.1
mvn package
```

Then you can find the jars in the folders:
- jhove-core/
- jhove-modules/
- jhove-ext-modules/


## 3.2 Update the MDExtractor-plugins project.

### 3.2.1 Copy the jars to your MDExtractor-plugins project.
Open your MDExtractor-plugins java project. Place the new jars under lib folder. The jars names should have the new JHOVE version suffix. (e.g. jhove-core-1.26.1.jar)

### 3.2.2 Copy the "org" directory from the "jhove-core" jar to the root directory of each MDExtractor plugin, without the .class file.


### 3.2.3 Update the build.xml
- Change the jar dependencies to the updated version
- All JHOVE Plugin jars created by the build.xml names should be updated with the current version (destfile name)

### 3.2.4 Update the getAgentName() method in the java files to hold the correct version.

### 3.2.5 Update metadata*.xml files- the plugin deploy name should have the current version as it’s suffix. (e.g. xml-hul-1.26.1)

