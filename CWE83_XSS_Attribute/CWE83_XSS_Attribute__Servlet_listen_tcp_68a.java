/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE83_XSS_Attribute__Servlet_listen_tcp_68a.java
Label Definition File: CWE83_XSS_Attribute__Servlet.label.xml
Template File: sources-sink-68a.tmpl.java
*/
/*
 * @description
 * CWE: 83 Cross Site Scripting (XSS) in attributes; Examples(replace QUOTE with an actual double quote): ?img_loc=http://www.google.comQUOTE%20onerror=QUOTEalert(1) and ?img_loc=http://www.google.comQUOTE%20onerror=QUOTEjavascript:alert(1)
 * BadSource: listen_tcp Read data using a listening tcp connection
 * GoodSource: A hardcoded string
 * BadSink: printlnServlet XSS in img src attribute
 * Flow Variant: 68 Data flow: data passed as a member variable in the "a" class, which is used by a method in another class in the same package
 *
 * */

package testcases.CWE83_XSS_Attribute;

import testcasesupport.*;

import javax.servlet.http.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;

import java.util.logging.Level;

public class CWE83_XSS_Attribute__Servlet_listen_tcp_68a extends AbstractTestCaseServlet
{
    public static String data;

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        data = ""; /* Initialize data */

        /* Read data using a listening tcp connection */
        {
            ServerSocket listener = null;
            Socket socket = null;
            BufferedReader readerBuffered = null;
            InputStreamReader readerInputStream = null;

            /* Read data using a listening tcp connection */
            try
            {
                listener = new ServerSocket(39543);
                socket = listener.accept();

                /* read input from socket */

                readerInputStream = new InputStreamReader(socket.getInputStream(), "UTF-8");
                readerBuffered = new BufferedReader(readerInputStream);

                /* POTENTIAL FLAW: Read data using a listening tcp connection */
                data = readerBuffered.readLine();
            }       
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", exceptIO);
            }       
            finally
            {
                /* Close stream reading objects */
                try
                {
                    if (readerBuffered != null)
                    {
                        readerBuffered.close();
                    }       
                }       
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing BufferedReader", exceptIO);
                }       

                try
                {
                    if (readerInputStream != null)
                    {
                        readerInputStream.close();
                    }       
                }       
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing InputStreamReader", exceptIO);
                }       

                /* Close socket objects */
                try
                {
                    if (socket != null)
                    {
                        socket.close();
                    }       
                }       
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing Socket", exceptIO);
                }       

                try
                {
                    if (listener != null)
                    {
                        listener.close();
                    }       
                }       
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing ServerSocket", exceptIO);
                }       
            }       
        }       

        (new CWE83_XSS_Attribute__Servlet_listen_tcp_68b()).badSink(request, response);
    }       

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
    }       

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        /* FIX: Use a hardcoded string */
        data = "foo";

        (new CWE83_XSS_Attribute__Servlet_listen_tcp_68b()).goodG2BSink(request, response);
    }       

    /* Below is the main(). It is only used when building this testcase on
     * its own for testing or for building a binary to use in testing binary
     * analysis tools. It is not used when compiling all the testcases as one
     * application, which is how source code analysis tools are tested.
     */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }       
}       
