cpEntry="$(cat results/classpath.txt):../evosuite-standalone-runtime-1.1.0.jar"

cd results
javac -cp $cpEntry org/apache/commons/lang3/time/FastDateFormat_ESTest_scaffolding.java
javac -cp $cpEntry:"org.apache.commons.lang3.time.FastDateFormat_ESTest_scaffolding" org/apache/commons/lang3/time/FastDateFormat_ESTest.java

java -cp $cpEntry org.junit.runner.JUnitCore org.apache.commons.lang3.time.FastDateFormat_ESTest
cd ../
