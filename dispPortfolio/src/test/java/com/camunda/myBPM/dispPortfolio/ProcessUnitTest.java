package com.camunda.myBPM.dispPortfolio;

import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.apache.ibatis.logging.LogFactory;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.engine.test.ProcessEngineRule;
import org.camunda.bpm.extension.process_test_coverage.junit.rules.TestCoverageProcessEngineRuleBuilder;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import com.camunda.myBPM.dispPortfolio.CheckAmountDelegate;
import com.camunda.myBPM.dispPortfolio.CheckEligibilityDelegate;
import com.camunda.myBPM.dispPortfolio.GetReplyDelegate;

import static org.camunda.bpm.engine.test.assertions.ProcessEngineTests.*;
import static org.junit.Assert.*;

public class ProcessUnitTest {
	
	@Test //check amount delegate test
	public void verifyAmountDelegateSetsVariable() {
		// Set up class under test
		CheckAmountDelegate delegate = new CheckAmountDelegate();
		
		// Set up mock of Camunda execution environment
		DelegateExecution mockExecution = mock(DelegateExecution.class);
		
		// Run the delegate behaviour
		try {
			delegate.execute(mockExecution);
		} catch (Exception e) {
			e.printStackTrace();
			fail("throw exception: " + e.getMessage());
		}
		
		// Now verify that the mock was called.
		verify(mockExecution, times(1))
		    .setVariable(eq("over10000"), 
		    		     any(Boolean.class));
	}
	
	@Test //get reply delegate test
	public void verifyReplyDelegateSetsVariable() {
		// Set up class under test
		GetReplyDelegate delegate = new GetReplyDelegate();
		
		// Set up mock of Camunda execution environment
		DelegateExecution mockExecution = mock(DelegateExecution.class);
		
		// Run the delegate behaviour
		try {
			delegate.execute(mockExecution);
		} catch (Exception e) {
			e.printStackTrace();
			fail("throw exception: " + e.getMessage());
		}
		
		// Now verify that the mock was called.
		verify(mockExecution, times(1))
		    .setVariable(eq("replyOK"), 
		    		     any(Boolean.class));
	}

	@Test //check eligibility delegate test
	public void verifyEligibilityDelegateSetsVariable() {
		// Set up class under test
		CheckEligibilityDelegate delegate = new CheckEligibilityDelegate();
		
		// Set up mock of Camunda execution environment
		DelegateExecution mockExecution = mock(DelegateExecution.class);
		
		// Run the delegate behaviour
		try {
			delegate.execute(mockExecution);
		} catch (Exception e) {
			e.printStackTrace();
			fail("throw exception: " + e.getMessage());
		}
		
		// Now verify that the mock was called.
		verify(mockExecution, times(1))
		    .setVariable(eq("eligibleOK"), 
		    		     any(Boolean.class));
	}
}
