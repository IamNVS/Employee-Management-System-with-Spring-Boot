package org.jsp.emp.ResponceBody;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeResponceBody<T> {

	private int status;
	private String msg;
	private T block;
}
