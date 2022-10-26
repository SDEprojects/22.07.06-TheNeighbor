#!/usr/bin/env sh
javac -d classes -classpath "lib/*" src/main/java/*.java
jar --create --file neighbour-1.0.jar -C classes .
