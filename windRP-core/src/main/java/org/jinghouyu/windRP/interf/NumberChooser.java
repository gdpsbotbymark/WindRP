package org.jinghouyu.windRP.interf;

import org.jinghouyu.windRP.RPConfig;

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
public interface NumberChooser {

	int choose(RPConfig config);
	
	int next(RPConfig config, int current, int first);
}