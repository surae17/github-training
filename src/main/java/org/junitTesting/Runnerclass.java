package org.junitTesting;

import java.util.List;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Runnerclass {
	@Test
	public void tc() {
		Result rc = JUnitCore.runClasses(B.class,SampleProject.class,A.class);
		System.out.println("Total test case run count : " +  rc.getRunCount());
		System.out.println("Total test run time : "+ rc.getRunTime());
		System.out.println("Total test case Failes count : " + rc.getFailureCount());
		System.out.println("Toatl test case Ignore count : " + rc.getIgnoreCount());
		
		List<Failure> f = rc.getFailures();
		
		for (Failure Fails : f) {
			System.out.println(Fails);

		}
	

	}

}
