#!/bin/sh

REPOSITORY=../repositories/maven
SOURCE_PATH=src/main/java


java -cp .:${SOURCE_PATH}:${REPOSITORY}/com/olek/com.olek.app.commons/0.0.1/com.olek.app.commons-0.0.1.jar:${REPOSITORY}/xjtlu/cpt108/xjtlu.cpt108.commons/0.0.1/xjtlu.cpt108.commons-0.0.1.jar:${REPOSITORY}/xjtlu/cpt108/xjtlu.cpt108.util.sort/0.0.1/xjtlu.cpt108.util.sort-0.0.1.jar xjtlu.cpt108.complexity.SortingSamples


