/**
 * Scaffolding file used to store all the setups needed to run 
 * tests automatically generated by EvoSuite
 * Thu Jan 24 16:05:08 GMT 2019
 */

package org.apache.commons.lang3.time;

import org.evosuite.runtime.annotation.EvoSuiteClassExclude;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.junit.AfterClass;
import org.evosuite.runtime.sandbox.Sandbox;
import org.evosuite.runtime.sandbox.Sandbox.SandboxMode;

@EvoSuiteClassExclude
public class FastDateParser_ESTest_scaffolding {

  @org.junit.Rule 
  public org.evosuite.runtime.vnet.NonFunctionalRequirementRule nfr = new org.evosuite.runtime.vnet.NonFunctionalRequirementRule();

  private static final java.util.Properties defaultProperties = (java.util.Properties) java.lang.System.getProperties().clone(); 

  private org.evosuite.runtime.thread.ThreadStopper threadStopper =  new org.evosuite.runtime.thread.ThreadStopper (org.evosuite.runtime.thread.KillSwitchHandler.getInstance(), 3000);


  @BeforeClass 
  public static void initEvoSuiteFramework() { 
    org.evosuite.runtime.RuntimeSettings.className = "org.apache.commons.lang3.time.FastDateParser"; 
    org.evosuite.runtime.GuiSupport.initialize(); 
    org.evosuite.runtime.RuntimeSettings.maxNumberOfThreads = 100; 
    org.evosuite.runtime.RuntimeSettings.maxNumberOfIterationsPerLoop = 10000; 
    org.evosuite.runtime.RuntimeSettings.mockSystemIn = true; 
    org.evosuite.runtime.RuntimeSettings.sandboxMode = org.evosuite.runtime.sandbox.Sandbox.SandboxMode.RECOMMENDED; 
    org.evosuite.runtime.sandbox.Sandbox.initializeSecurityManagerForSUT(); 
    org.evosuite.runtime.classhandling.JDKClassResetter.init();
    setSystemProperties();
    initializeClasses();
    org.evosuite.runtime.Runtime.getInstance().resetRuntime(); 
  } 

  @AfterClass 
  public static void clearEvoSuiteFramework(){ 
    Sandbox.resetDefaultSecurityManager(); 
    java.lang.System.setProperties((java.util.Properties) defaultProperties.clone()); 
  } 

  @Before 
  public void initTestCase(){ 
    threadStopper.storeCurrentThreads();
    threadStopper.startRecordingTime();
    org.evosuite.runtime.jvm.ShutdownHookHandler.getInstance().initHandler(); 
    org.evosuite.runtime.sandbox.Sandbox.goingToExecuteSUTCode(); 
    setSystemProperties(); 
    org.evosuite.runtime.GuiSupport.setHeadless(); 
    org.evosuite.runtime.Runtime.getInstance().resetRuntime(); 
    org.evosuite.runtime.agent.InstrumentingAgent.activate(); 
  } 

  @After 
  public void doneWithTestCase(){ 
    threadStopper.killAndJoinClientThreads();
    org.evosuite.runtime.jvm.ShutdownHookHandler.getInstance().safeExecuteAddedHooks(); 
    org.evosuite.runtime.classhandling.JDKClassResetter.reset(); 
    resetClasses(); 
    org.evosuite.runtime.sandbox.Sandbox.doneWithExecutingSUTCode(); 
    org.evosuite.runtime.agent.InstrumentingAgent.deactivate(); 
    org.evosuite.runtime.GuiSupport.restoreHeadlessMode(); 
  } 

  public static void setSystemProperties() {
 
    java.lang.System.setProperties((java.util.Properties) defaultProperties.clone()); 
    java.lang.System.setProperty("file.encoding", "UTF-8"); 
    java.lang.System.setProperty("java.io.tmpdir", "/var/folders/t4/0qd1kfm97tz9g17z439t2gmm0000gn/T/"); 
    java.lang.System.setProperty("user.country", "NL"); 
    java.lang.System.setProperty("user.dir", "/Users/pooria/Desktop/botsing-demo"); 
    java.lang.System.setProperty("user.home", "/Users/pooria"); 
    java.lang.System.setProperty("user.language", "en"); 
    java.lang.System.setProperty("user.name", "pooria"); 
    java.lang.System.setProperty("user.timezone", "Europe/Amsterdam"); 
    java.lang.System.setProperty("sun.java.launcher", "SUN_STANDARD"); 
  }

  private static void initializeClasses() {
    org.evosuite.runtime.classhandling.ClassStateSupport.initializeClasses(FastDateParser_ESTest_scaffolding.class.getClassLoader() ,
      "org.apache.commons.io.filefilter.IOFileFilter",
      "org.apache.commons.lang3.time.FastDateParser$5",
      "org.apache.commons.lang3.time.FastDateParser$4",
      "org.apache.commons.io.filefilter.DelegateFileFilter",
      "org.apache.commons.lang3.time.FastDateParser$3",
      "org.apache.commons.io.filefilter.AndFileFilter",
      "org.apache.commons.io.filefilter.MagicNumberFileFilter",
      "org.apache.commons.io.IOCase",
      "org.apache.commons.lang3.time.FastDateParser$2",
      "org.apache.commons.lang3.time.FastDateParser$1",
      "org.apache.commons.lang3.time.FastDateParser$NumberStrategy",
      "org.apache.commons.lang3.time.DateParser",
      "org.apache.commons.lang3.time.FastDateParser$CopyQuotedStrategy",
      "org.apache.commons.lang3.time.FastDateParser$KeyValue",
      "org.apache.commons.io.filefilter.SizeFileFilter",
      "org.apache.commons.io.filefilter.OrFileFilter",
      "org.apache.commons.io.filefilter.EmptyFileFilter",
      "org.apache.commons.io.filefilter.NameFileFilter",
      "org.apache.commons.io.filefilter.NotFileFilter",
      "org.apache.commons.io.filefilter.TrueFileFilter",
      "org.apache.commons.io.filefilter.RegexFileFilter",
      "org.apache.commons.lang3.time.FastDateParser$TimeZoneStrategy",
      "org.apache.commons.io.filefilter.AgeFileFilter",
      "org.apache.commons.lang3.time.FastDateParser$Strategy",
      "org.apache.commons.lang3.time.FastDateParser$TextStrategy",
      "org.apache.commons.io.filefilter.AbstractFileFilter",
      "org.apache.commons.io.filefilter.ConditionalFileFilter",
      "org.apache.commons.io.filefilter.FileFileFilter",
      "org.apache.commons.io.filefilter.DirectoryFileFilter",
      "org.apache.commons.io.filefilter.PrefixFileFilter",
      "org.apache.commons.io.filefilter.HiddenFileFilter",
      "org.apache.commons.io.filefilter.SuffixFileFilter",
      "org.apache.commons.io.filefilter.FalseFileFilter",
      "org.apache.commons.io.filefilter.WildcardFilter",
      "org.apache.commons.io.filefilter.WildcardFileFilter",
      "org.apache.commons.lang3.time.FastDateParser",
      "org.apache.commons.io.filefilter.CanReadFileFilter",
      "org.apache.commons.io.filefilter.CanWriteFileFilter"
    );
  } 

  private static void resetClasses() {
    org.evosuite.runtime.classhandling.ClassResetter.getInstance().setClassLoader(FastDateParser_ESTest_scaffolding.class.getClassLoader()); 

    org.evosuite.runtime.classhandling.ClassStateSupport.resetClasses(
      "org.apache.commons.lang3.time.FastDateParser"
    );
  }
}
