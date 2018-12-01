/*
 * This file was automatically generated by EvoSuite
 * Sat Dec 01 14:13:45 GMT 2018
 */

package Loader;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import Loader.JarLoader;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.testdata.EvoSuiteFile;
import org.evosuite.runtime.testdata.FileSystemHandling;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class JarLoader_ESTest extends JarLoader_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      JarLoader jarLoader0 = new JarLoader((String) null);
      // Undeclared exception!
      try { 
        jarLoader0.findClass((String) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.io.File", e);
      }
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      EvoSuiteFile evoSuiteFile0 = new EvoSuiteFile("N4qE-9u9O5<D:,~");
      FileSystemHandling.createFolder(evoSuiteFile0);
      JarLoader jarLoader0 = new JarLoader("");
      try { 
        jarLoader0.findClass("O4rD.8w9S5>");
        fail("Expecting exception: ClassNotFoundException");
      
      } catch(ClassNotFoundException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("Loader.JarLoader", e);
      }
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      JarLoader jarLoader0 = new JarLoader("\n");
      try { 
        jarLoader0.findClass("\n");
        fail("Expecting exception: ClassNotFoundException");
      
      } catch(ClassNotFoundException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("Loader.JarLoader", e);
      }
  }
}