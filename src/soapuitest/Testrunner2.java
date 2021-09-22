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

public class Testrunner2 {
	
	//running single testcase using testcase name
	@Test
	public void testcase() throws XmlException, IOException, SoapUIException
	{
	
	        //grab the project
			WsdlProject project=new WsdlProject("C:\\Users\\91933\\Downloads\\9781789134926_Code\\Section 8\\Employee.xml");
			//grab the testsuite present in the project
	        WsdlTestSuite testsuite=project.getTestSuiteByName("Testing");
	        WsdlTestCase testcase=testsuite.getTestCaseByName("GetEmployee");
	        TestRunner runner=testcase.run(new PropertiesMap(), false);
        	//check the testcases status
        	Assert.assertEquals(Status.FINISHED, runner.getStatus());

	}
}
