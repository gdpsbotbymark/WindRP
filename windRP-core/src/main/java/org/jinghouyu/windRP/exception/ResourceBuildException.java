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
public class ResourceBuildException extends Exception {

	private static final long serialVersionUID = 1107645496199093366L;

	public ResourceBuildException() {
		super();
	}

	public ResourceBuildException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public ResourceBuildException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public ResourceBuildException(String arg0) {
		super(arg0);
	}

	public ResourceBuildException(Throwable arg0) {
		super(arg0);
	}
}
