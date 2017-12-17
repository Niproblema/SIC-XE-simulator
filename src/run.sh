#!/bin/bash
javac -d ./build *.java
cd ./build
echo Main-Class: SimForm > manifest.txt
jar cvfm Sic-XE_Sim-63140001.jar manifest.txt *.class
chmod 777 Sic-XE_Sim-63140001.jar
cd ..
mv ./build/Sic-XE_Sim-63140001.jar Sic-XE_Sim-63140001.jar
rm -rf ./build
java -jar Sic-XE_Sim-63140001.jar
