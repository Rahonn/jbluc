#!/usr/bin bash

javac $(find src -name "*.java") -d bin/
cd bin
java main.Main $@
