# Rosetta.MDExtractor-plugins

Steps for creating new MDExtractor plugins with a new JHOVE version:
1)	Download the new JHOVE version. You must have the two following jars:
-	jhove-core.jar
-	jhove-moudles.jar
2)	Open your MDExtractor-plugins java project. Place the new jars under lib. The jars names should have the new JHOVE version suffix. (e.g. jhove-1.16.6.jar) 
3)  **Copy** the "org" directory from the "jhove-core" jar to the root directory of each MDExtractor plugin, without the .class file.
4)	Update the build.xml- 
    -	Change the jar dependencies to the updated version 
    -	All JHOVE Plugin jars created by the build.xml  names should be updated with the current version (destfile name)
5)	Update the getAgentName() method in the java files to hold the correct version.
6)	Update metadata*.xml  files- the plugin deploy name should have the current version as it’s suffix. (e.g. xml-hul-1.16.6)
