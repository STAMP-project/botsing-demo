# Botsing Demo

## Download Botsing
Download the latest version of `botsing-reproduction.jar` from [here](https://github.com/STAMP-project/botsing/releases).

## Prepare data for running Botsing
For using Botsing, you need to provide two data:
 - **The compiled version of the software under test (SUT):** a folder containing all the  `.jar` files required to run the software under test. As an example, you can see `applications/LANG-9b`.
 - **Crash Log:** the file with the stack trace. The stack trace should be clean (no error message) and cannot contain any nested exceptions. As an example, you can see `crashes/LANG-9b.log`.

## Run Botsing
 Run botsing with the following command:

```
java -jar <Path_to_botsing-reproduction.jar> -project_cp <Path_to_Directory_with_SUT_jars> -crash_log <Path_to_crash_log> -target_frame <Level_of_target_frame> -Dsearch_budget=<time_in_second> -D<property=value>  
```

`<Path_to_botsing-reproduction.jar>` Path to the latest version of the botsing-reproduction jar file.

`<Path_to_Directory_with_SUT_jars>` Path to the compiled version of the software under test.

`<Path_to_crash_log>` Path to a file File with the stack trace.

`<Level_of_target_frame>` This argument indicates that the user wants to replicate the first `n` lines of the stack trace.

`-Dsearch_budget=<time_in_second>` Maximum search duration in seconds.

`-D<property=value>` Since Botsing uses EvoSuite during the search process, the user can set the evosuite properties through Botsing. For more information about the EvoSuite options click [here](https://github.com/EvoSuite/evosuite/blob/master/client/src/main/java/org/evosuite/Properties.java).



As an example, you can run the following sample command in this demo:


```
java -jar botsing-reproduction-1.0.6.jar -project_cp applications/LANG-9b -crash_log crashes/LANG-9b.log -target_frame 5 -Dcatch_undeclared_exceptions=true -Dno_runtime_dependency=true
```

After running this command, Botsing strives to generate a replicator test, which throws a `java.lang.ArrayIndexOutOfBoundsException` (as is indicated in `crashes/LANG-9b.log`) including first 5 frames of this stack trace, for 2 minutes.

Botsing stops searching either when it reaches the replicator test or when its search budget is finished.

## The generated test by Botsing

If Botsing achieves to the replicator test, it will save it in the output directory (`CrashReproduction-tests` by default).
If we run this test on the software under test, it throws the same stack trace as the given one.

For instance, one of the result of the sample command, which we mentioned in the previous section, is the following test (The generated test is different everytime):
```java
@Test(timeout = 4000)
 public void test0()  throws Throwable  {
     Locale locale0 = FastDateParser.JAPANESE_IMPERIAL;
     TimeZone timeZone0 = TimeZone.getDefault();
     FastDateParser fastDateParser0 = null;
     try {
       fastDateParser0 = new FastDateParser("GMTJST", timeZone0, locale0);
       fail("Expecting exception: ArrayIndexOutOfBoundsException");

     } catch(ArrayIndexOutOfBoundsException e) {
        //
        // 4
        //
     }
 }
```

## Running the generated test by bash

Remove try/catch from the generated test:

```java
@Test(timeout = 4000)
 public void test0()  throws Throwable  {
     Locale locale0 = FastDateParser.JAPANESE_IMPERIAL;
     TimeZone timeZone0 = TimeZone.getDefault();
     FastDateParser fastDateParser0 = null;
     fastDateParser0 = new FastDateParser("GMTJST", timeZone0, locale0);
     fail("Expecting exception: ArrayIndexOutOfBoundsException");
 }
```



Go to the the generated test directory

```
cd crash-reproduction-tests
```

Collect the classpaths

```
for i in ../applications/LANG-9b/*.jar; do echo -n $i":"; done > classpath.txt
```
Compile test

```
javac -cp $(cat classpath.txt) org/apache/commons/lang3/time/FastDateParser_ESTest.java
```

 Run the generated test

 ```
 java -cp $(cat classpath.txt) org.junit.runner.JUnitCore org.apache.commons.lang3.time.FastDateParser_ESTest
 ```
The test should throw the following exception:
 ```
 java.lang.ArrayIndexOutOfBoundsException: 4
 	at org.apache.commons.lang3.time.FastDateParser.toArray(FastDateParser.java:413)
 	at org.apache.commons.lang3.time.FastDateParser.getDisplayNames(FastDateParser.java:381)
 	at org.apache.commons.lang3.time.FastDateParser$TextStrategy.addRegex(FastDateParser.java:664)
 	at org.apache.commons.lang3.time.FastDateParser.init(FastDateParser.java:138)
 	at org.apache.commons.lang3.time.FastDateParser.<init>(FastDateParser.java:108)
 	at org.apache.commons.lang3.time.FastDateParser_ESTest.test0(FastDateParser_ESTest.java:21)
 ```
