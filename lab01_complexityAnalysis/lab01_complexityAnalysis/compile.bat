

set REPOSITORY=..\repositories\maven
set SOURCE_PATH=src\main\java


javac -sourcepath %SOURCE_PATH% -p .;%REPOSITORY%\com\olek\com.olek.app.commons\0.0.1\com.olek.app.commons-0.0.1.jar;%REPOSITORY%\xjtlu\cpt108\xjtlu.cpt108.commons\0.0.1\xjtlu.cpt108.commons-0.0.1.jar;%REPOSITORY%\xjtlu\cpt108\xjtlu.cpt108.util.sort\0.0.1\xjtlu.cpt108.util.sort-0.0.1.jar %SOURCE_PATH%\xjtlu\cpt108\complexity\SortingSamples.java


