package org.jinghouyu.wind.ftp;

import java.io.IOException;

public class FtpException extends IOException {

	private static final long serialVersionUID = -7218818478466445408L;
	
	private int code;
	
	public FtpException(int code, String reason) {
		super(reason);
		this.code = code;
	}
	
	public FtpException(int code, String reason, Throwable t) {
		super(reason, t);
	}
	
	public int getErrorCode() {
		return this.code;
	}
}
