package org.domain.delegator.session;

public enum StatusesEnum {
	STATUS_1("Active"),
	STATUS_2("Suspended"),
	STATUS_3("Finished");
	
	private String status;
	
	private StatusesEnum(String status){this.status = status;}
	
	public String toString() {return status;}
}
