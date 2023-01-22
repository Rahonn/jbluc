#!/usr/bin bash

javac -d bin/ src/**/*.java
cd bin
java main.Main $@
