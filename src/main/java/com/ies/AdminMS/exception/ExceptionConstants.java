package com.ies.AdminMS.exception;

import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:messages.properties")
public enum ExceptionConstants {

	CASEWORKER_NOT_FOUND("caseWorker.not.found"),
	CASE_WORKER_ALREADY_EXISTS("caseWorker.already.exists"),
	PLAN_NOT_FOUND("plan.not.found");

	private final String type;
	
	private ExceptionConstants(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return this.type;
	}
}
