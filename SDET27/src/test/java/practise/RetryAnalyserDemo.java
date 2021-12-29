package practise;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserDemo {
	@Test (retryAnalyzer = com.vtiger.comcast.genericUtility.RetryAnalyzerImpl.class)
	
	public void retryAnalyserDemoTest()
	{
		System.out.println("RetryAnalyser");
		Assert.fail();
	}

}
