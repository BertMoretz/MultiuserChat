/*
 * This file was automatically generated by EvoSuite
 * Sat Dec 01 14:13:56 GMT 2018
 */

package ServerPart;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import ServerPart.Chat;
import ServerPart.User;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.mock.java.io.MockFileOutputStream;
import org.evosuite.runtime.mock.java.io.MockPrintStream;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class Chat_ESTest extends Chat_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Chat chat0 = new Chat();
      MockFileOutputStream mockFileOutputStream0 = new MockFileOutputStream("/R)WdI;Zr", false);
      ObjectOutputStream objectOutputStream0 = new ObjectOutputStream(mockFileOutputStream0);
      mockFileOutputStream0.close();
      chat0.sendCommandResults("/R)WdI;Zr", objectOutputStream0);
      assertTrue(chat0.isEmpty());
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      Chat chat0 = new Chat();
      User user0 = new User(0, ":\t");
      chat0.addUser(user0);
      boolean boolean0 = chat0.isEmpty();
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      Chat chat0 = new Chat();
      ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
      chat0.addOutputStream((ObjectOutputStream) null);
      ObjectOutputStream objectOutputStream0 = new ObjectOutputStream(byteArrayOutputStream0);
      chat0.addOutputStream(objectOutputStream0);
      User user0 = new User((-4296), "ServerPart.Chat");
      chat0.addUser(user0);
      chat0.addUser(user0);
      // Undeclared exception!
      try { 
        chat0.sendMessage("/D|yqbeRL1}i", objectOutputStream0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("ServerPart.Chat", e);
      }
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      Chat chat0 = new Chat();
      MockPrintStream mockPrintStream0 = new MockPrintStream("YZ `");
      ObjectOutputStream objectOutputStream0 = new ObjectOutputStream(mockPrintStream0);
      // Undeclared exception!
      try { 
        chat0.sendMessage("2Gz!bxqI2", objectOutputStream0);
        fail("Expecting exception: ArrayIndexOutOfBoundsException");
      
      } catch(ArrayIndexOutOfBoundsException e) {
         //
         // -1
         //
         verifyException("java.util.Vector", e);
      }
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      Chat chat0 = new Chat();
      // Undeclared exception!
      try { 
        chat0.sendCommandResults(")ZVl~!wu&j", (ObjectOutputStream) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("ServerPart.Chat", e);
      }
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      Chat chat0 = new Chat();
      ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
      chat0.addOutputStream((ObjectOutputStream) null);
      ObjectOutputStream objectOutputStream0 = new ObjectOutputStream(byteArrayOutputStream0);
      chat0.addOutputStream(objectOutputStream0);
      User user0 = new User((-4296), "ServerPart.Chat");
      chat0.addUser(user0);
      chat0.sendMessage("", (ObjectOutputStream) null);
      assertEquals(1, chat0.usersLength());
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      Chat chat0 = new Chat();
      boolean boolean0 = chat0.isEmpty();
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      Chat chat0 = new Chat();
      User user0 = new User((-4296), "ServerPart.Chat");
      chat0.addUser(user0);
      int int0 = chat0.usersLength();
      assertEquals(1, int0);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      Chat chat0 = new Chat();
      chat0.removeOutputStream((ObjectOutputStream) null);
      assertEquals(0, chat0.usersLength());
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      Chat chat0 = new Chat();
      ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
      ObjectOutputStream objectOutputStream0 = new ObjectOutputStream(byteArrayOutputStream0);
      chat0.sendCommandResults("", objectOutputStream0);
      assertEquals(16, byteArrayOutputStream0.size());
      assertEquals("\uFFFD\uFFFD\u0000\u0005w\n\u0000\bResult:\t", byteArrayOutputStream0.toString());
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      Chat chat0 = new Chat();
      User user0 = new User((-4296), "ServerPart.Chat");
      chat0.removeUser(user0);
      assertEquals((-4296), user0.getId());
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      Chat chat0 = new Chat();
      int int0 = chat0.usersLength();
      assertEquals(0, int0);
  }
}
