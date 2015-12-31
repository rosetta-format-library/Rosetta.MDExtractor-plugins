# Rosetta.MDExtractor-plugins

Steps for creating new MDExtractor plugins with a new JHOVE version:
1)	Download the new JHOVE version. You must have all of the three following jars:
•	jhove.jar
•	jhove-handler.jar
•	jhove-moudle.jar
2)	Open your MDExtractor-plugins java project. Place the new jars under lib. The jars names should have the new JHOVE version suffix. (e.g. jhove-1.10.jar) 
3)	Update the build.xml- 
•	Change the jar dependencies to the updated version 
•	All JHOVE Plugin jars created by the build.xml  names should be updated with the current version (destfile name)
4)	Update the getAgentName() method in the java files to hold the correct version.
5)	Update metadata*.xml  files- the plugin deploy name should have the current version as it’s suffix. (e.g. xml-hul-1.10)
