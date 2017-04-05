package com.lotte.exception;

/**
 * 파일 미 존재시 예외 처리 클래스
 */
public class NotExistException extends Exception{
	public NotExistException(){}
	public NotExistException(String message){
		super(message);
	}
}
