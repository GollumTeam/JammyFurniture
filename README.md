JammyFurniture
==============

It's the sources of Jammy Furniture mod.

They have been modified and rewritten to the migration and use 1.7.2 and 1.7.10
 
 
For install :

<pre>
git submodule update --init
cd GollumCoreLib
./gradlew setupDecompWorkspace
./gradlew jar
cd..
./gradlew setupDecompWorkspace
./gradlew eclipse
./gradlew build
<pre>
