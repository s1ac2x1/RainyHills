package com.kishlaly.tests.rainyhills.domain.service;

import com.kishlaly.tests.rainyhills.domain.model.Hill;

import java.util.function.Function;

/**
 * @author Vladimir Kishlaly
 * @since 17.12.2016
 */
public class MathUtils {

    /**
     * <p>Simple algorithm of traversing the {@link Hill#getLandscape() landscape} from the both sides.
     * <p>O(n) time/memory complexity.
     * <p>The main idea is walking along the landscape from the left and right towards each other,
     * considering height difference.
     *
     * @return mapping from {@link Hill Hill} domain object to its water volume after the rain.
     */
    public static Function<Hill, Integer> computeWaterVolume() {
        return hill -> {
            int leftSlopeHeight = 0;
            int rightSlopeHeight = 0;
            int leftWalker = 0;
            int[] landscape = hill.getLandscape();
            int rightWalker = landscape.length - 1;
            int waterVolume = 0;

            while (leftWalker < rightWalker) {
                if (landscape[leftWalker] > leftSlopeHeight) {
                    leftSlopeHeight = landscape[leftWalker];
                }
                if (landscape[rightWalker] > rightSlopeHeight) {
                    rightSlopeHeight = landscape[rightWalker];
                }
                if (leftSlopeHeight >= rightSlopeHeight) {
                    waterVolume += rightSlopeHeight - landscape[rightWalker];
                    rightWalker--;
                } else {
                    waterVolume += leftSlopeHeight - landscape[leftWalker];
                    leftWalker++;
                }
            }
            return waterVolume;
        };
    }


}
