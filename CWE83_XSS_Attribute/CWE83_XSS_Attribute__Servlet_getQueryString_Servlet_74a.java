/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE83_XSS_Attribute__Servlet_getQueryString_Servlet_74a.java
Label Definition File: CWE83_XSS_Attribute__Servlet.label.xml
Template File: sources-sink-74a.tmpl.java
*/
/*
 * @description
 * CWE: 83 Cross Site Scripting (XSS) in attributes; Examples(replace QUOTE with an actual double quote): ?img_loc=http://www.google.comQUOTE%20onerror=QUOTEalert(1) and ?img_loc=http://www.google.comQUOTE%20onerror=QUOTEjavascript:alert(1)
 * BadSource: getQueryString_Servlet Parse id param out of the URL query string (without using getParameter())
 * GoodSource: A hardcoded string
 * Sinks: printlnServlet
 *    BadSink : XSS in img src attribute
 * Flow Variant: 74 Data flow: data passed in a HashMap from one method to another in different source files in the same package
 *
 * */

package testcases.CWE83_XSS_Attribute;

import testcasesupport.*;
import java.util.HashMap;

import javax.servlet.http.*;

import java.util.StringTokenizer;

public class CWE83_XSS_Attribute__Servlet_getQueryString_Servlet_74a extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        data = ""; /* initialize data in case id is not in query string */

        /* POTENTIAL FLAW: Parse id param out of the URL querystring (without using getParameter()) */
        {
            StringTokenizer tokenizer = new StringTokenizer(request.getQueryString(), "&");
            while (tokenizer.hasMoreTokens())
            {
                String token = tokenizer.nextToken(); /* a token will be like "id=foo" */
                if(token.startsWith("id=")) /* check if we have the "id" parameter" */
                {
                    data = token.substring(3); /* set data to "foo" */
                    break; /* exit while loop */
                }       
            }       
        }       

        HashMap<Integer,String> dataHashMap = new HashMap<Integer,String>();
        dataHashMap.put(0, data);
        dataHashMap.put(1, data);
        dataHashMap.put(2, data);
        (new CWE83_XSS_Attribute__Servlet_getQueryString_Servlet_74b()).badSink(dataHashMap , request, response );
    }       

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
    }       

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        /* FIX: Use a hardcoded string */
        data = "foo";

        HashMap<Integer,String> dataHashMap = new HashMap<Integer,String>();
        dataHashMap.put(0, data);
        dataHashMap.put(1, data);
        dataHashMap.put(2, data);
        (new CWE83_XSS_Attribute__Servlet_getQueryString_Servlet_74b()).goodG2BSink(dataHashMap , request, response );
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
