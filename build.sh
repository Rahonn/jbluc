#!/usr/bin bash

javac $(find src -name "*.java") -d bin/
jar cvfe JBLUC.jar main.Main -C bin .