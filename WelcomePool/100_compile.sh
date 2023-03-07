#!/bin/sh

## clean previous output
rm -rf out/*

## compile all java files to classes (TODO configure classpath)
javac -d out/classes -cp $(find $SOME_PATH -name "*.jar" | paste -sd ":") $(find ./src/main -name "*.java") 

mkdir -p out/war/WEB-INF

cp -R out/classes/ out/war/WEB-INF

cp -R src/main/webapp/* out/war/

jar -cvf out/war/admin.war -C out/war/ .