package soapuitest;

import java.io.IOException;

import org.apache.xmlbeans.XmlException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestRunner;
import com.eviware.soapui.model.testsuite.TestRunner.Status;
import com.eviware.soapui.support.SoapUIException;



public class Testrunner {
	
	//running all the testcases

	@Test
	public void soaptest() throws XmlException, IOException, SoapUIException
	{
		//grab the project
		WsdlProject project=new WsdlProject("C:\\Users\\91933\\Downloads\\9781789134926_Code\\Section 8\\Employee.xml");
		//grab the testsuite present in the project
        WsdlTestSuite testsuite=project.getTestSuiteByName("Testing");
        //grab the testcases present in the testsuite
        for(int i=0;i<testsuite.getTestCaseCount();i++)
        {
        	WsdlTestCase testcase=testsuite.getTestCaseAt(i);
        	//run the testcases
        	TestRunner runner=testcase.run(new PropertiesMap(), false);
        	//check the testcases status
        	Assert.assertEquals(Status.FINISHED, runner.getStatus());
        }
	}

}
