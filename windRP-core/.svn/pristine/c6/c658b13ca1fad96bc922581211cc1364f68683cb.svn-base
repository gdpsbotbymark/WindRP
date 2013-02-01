package org.jinghouyu.windRP.exception;

/**
 *
 * @author Simsir.L
 * modified by <person></person> on <data></date>
 *
 * |  created date  | modified date  |  modified person |
 * |         |           |        |
 * @description
 *
 * @since 1.0.0
 */
public class ResourceException extends Exception {

	private static final long serialVersionUID = 1107645496199093366L;
	
	private Exception sourceException;

	public ResourceException(String arg0, Exception sourceException) {
		super(arg0, sourceException);
		this.sourceException = sourceException;
	}
	
	public ResourceException(Exception sourceException) {
		super(sourceException);
		this.sourceException = sourceException;
	}
	
	public Exception getSourceException() {
		return sourceException == null ? new Exception() : sourceException;
	}
}
