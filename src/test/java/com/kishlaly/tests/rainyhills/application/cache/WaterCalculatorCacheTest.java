package com.kishlaly.tests.rainyhills.application.cache;

import com.kishlaly.tests.rainyhills.domain.model.Hill;
import org.junit.Test;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author Vladimir Kishlaly
 * @since 17.12.2016
 */
public class WaterCalculatorCacheTest {

    @Test
    public void cacheSizeTest1() {
        Stream<Hill> mountains = Stream.generate(() -> new Hill(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10})).limit(1000);
        mountains.forEach(WaterCalculatorCache.INSTANCE::resolve);
        assertEquals(1, WaterCalculatorCache.INSTANCE.getSize());
    }

}
