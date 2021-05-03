package com.camunda.myBPM.dispPortfolio;

import java.util.Random;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class CheckEligibilityDelegate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		Random rando = new Random();
		execution.setVariable("eligibleOK", rando.nextBoolean());

	}

}
