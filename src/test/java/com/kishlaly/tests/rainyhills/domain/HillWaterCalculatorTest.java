package com.kishlaly.tests.rainyhills.domain;

import com.kishlaly.tests.rainyhills.domain.model.Hill;
import com.kishlaly.tests.rainyhills.domain.service.MathUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Vladimir Kishlaly
 * @since 17.12.2016
 */
public class HillWaterCalculatorTest {

    @Test
    public void simpleArrayTest() {
        Hill hill = new Hill(new int[]{4, 1, 1, 0, 2, 3});
        assertEquals(8, MathUtils.computeWaterVolume().apply(hill).intValue());

        Hill hill2 = new Hill(new int[]{3, 2, 4, 1, 2});
        assertEquals(2, MathUtils.computeWaterVolume().apply(hill2).intValue());

        Hill hill3 = new Hill(new int[]{10, 10, 10, 10, 9, 10, 10, 10});
        assertEquals(1, MathUtils.computeWaterVolume().apply(hill3).intValue());
    }

    @Test
    public void emptySlopesTest() {
        Hill hill = new Hill(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        assertEquals(0, MathUtils.computeWaterVolume().apply(hill).intValue());

        Hill hill2 = new Hill(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1});
        assertEquals(0, MathUtils.computeWaterVolume().apply(hill2).intValue());
    }

    @Test
    public void strangeSlopesTest() {
        Hill hill = new Hill(new int[]{100, 1, 99});
        assertEquals(98, MathUtils.computeWaterVolume().apply(hill).intValue());

        Hill hill2 = new Hill(new int[]{1000, 2, 10000});
        assertEquals(998, MathUtils.computeWaterVolume().apply(hill2).intValue());
    }

}
