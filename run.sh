#!/bin/sh

echo
echo "== Compiling the code =="
mvn package

echo
echo "== Running with classpath =="
java --class-path app/target/classes:lib/target/classes com.example.app.App

echo
echo "== Running with module path =="
mkdir -p jars && rm -rf jars/* && cp */target/*.jar jars/
java --module-path jars -m com.example.app
