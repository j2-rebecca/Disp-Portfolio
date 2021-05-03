package com.camunda.myBPM.dispPortfolio;

import java.util.Random;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class CheckAmountDelegate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		Random rando = new Random();
		execution.setVariable("over10000", rando.nextBoolean());

	}

}
