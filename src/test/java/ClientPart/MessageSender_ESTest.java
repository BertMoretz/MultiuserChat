/*
 * This file was automatically generated by EvoSuite
 * Sat Dec 01 14:14:56 GMT 2018
 */

package ClientPart;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import ClientPart.MessageSender;
import java.io.ObjectOutputStream;
import java.util.NoSuchElementException;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.mock.java.io.MockFileOutputStream;
import org.evosuite.runtime.util.SystemInUtil;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class MessageSender_ESTest extends MessageSender_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      MockFileOutputStream mockFileOutputStream0 = new MockFileOutputStream("@@^:.KPi", false);
      ObjectOutputStream objectOutputStream0 = new ObjectOutputStream(mockFileOutputStream0);
      MessageSender messageSender0 = new MessageSender(objectOutputStream0);
      // Undeclared exception!
      try { 
        messageSender0.run();
        fail("Expecting exception: NoSuchElementException");
      
      } catch(NoSuchElementException e) {
         //
         // No line found
         //
         verifyException("java.util.Scanner", e);
      }
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      SystemInUtil.addInputLine("@@^:.KPi");
      MockFileOutputStream mockFileOutputStream0 = new MockFileOutputStream("@@^:.KPi", false);
      ObjectOutputStream objectOutputStream0 = new ObjectOutputStream(mockFileOutputStream0);
      MessageSender messageSender0 = new MessageSender(objectOutputStream0);
      mockFileOutputStream0.close();
      // Undeclared exception!
      try { 
        messageSender0.run();
        fail("Expecting exception: NoSuchElementException");
      
      } catch(NoSuchElementException e) {
         //
         // No line found
         //
         verifyException("java.util.Scanner", e);
      }
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      SystemInUtil.addInputLine("1!WkWwA!");
      MessageSender messageSender0 = new MessageSender((ObjectOutputStream) null);
      // Undeclared exception!
      try { 
        messageSender0.run();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("ClientPart.MessageSender", e);
      }
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      MockFileOutputStream mockFileOutputStream0 = new MockFileOutputStream("@@^:.KPi", false);
      SystemInUtil.addInputLine("exit");
      ObjectOutputStream objectOutputStream0 = new ObjectOutputStream(mockFileOutputStream0);
      MessageSender messageSender0 = new MessageSender(objectOutputStream0);
      // Undeclared exception!
      try { 
        messageSender0.run();
        fail("Expecting exception: NoSuchElementException");
      
      } catch(NoSuchElementException e) {
         //
         // No line found
         //
         verifyException("java.util.Scanner", e);
      }
  }
}
