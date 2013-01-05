package org.jinghouyu.windRP;

import java.util.Random;
import java.util.UUID;

import org.jinghouyu.windRP.interf.NumberChooser;

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
public class Constant {

	final static NumberChooser defaultNumberChooser = new NumberChooser() {

		public int choose(RPConfig config) {
			Random random = new Random(UUID.randomUUID().hashCode());
			int partitionCount = config.getPartitionCount();
			return random.nextInt(partitionCount);
		}

		public int next(RPConfig config, int current, int first) {
			if(current == first) {
				return 0;
			}
			int result = current + 1;
			if(result > config.getPartitionCount()) {
				return 0;
			}
			return result;
		}
	};
}
