/*
 * This file was automatically generated by EvoSuite
 * Sat Dec 01 14:16:53 GMT 2018
 */

package ServerPart;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import ServerPart.Chat;
import ServerPart.CommandProc;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class CommandProc_ESTest extends CommandProc_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
      ObjectOutputStream objectOutputStream0 = new ObjectOutputStream(byteArrayOutputStream0);
      Chat chat0 = new Chat();
      CommandProc commandProc0 = new CommandProc("", (String[]) null, objectOutputStream0, chat0);
      commandProc0.run();
      assertEquals(31, byteArrayOutputStream0.size());
      assertEquals("\uFFFD\uFFFD\u0000\u0005w\u0019\u0000\u0017Result:\tNo such command", byteArrayOutputStream0.toString());
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      String[] stringArray0 = new String[8];
      Chat chat0 = new Chat();
      CommandProc commandProc0 = new CommandProc("p^QWSp!)a15~kRNv", stringArray0, (ObjectOutputStream) null, chat0);
      // Undeclared exception!
      try { 
        commandProc0.run();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("ServerPart.Chat", e);
      }
  }
}
