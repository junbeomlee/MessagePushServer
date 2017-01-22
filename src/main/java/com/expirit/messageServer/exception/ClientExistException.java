package com.expirit.messageServer.exception;

public class ClientExistException extends Exception {

	private static final long serialVersionUID = -5137068818056202092L;

	public ClientExistException(String message){
		super(message);
	}
}
