package com.kishlaly.tests.rainyhills.domain.service.impl;

import com.kishlaly.tests.rainyhills.application.cache.WaterCalculatorCache;
import com.kishlaly.tests.rainyhills.domain.model.Hill;
import com.kishlaly.tests.rainyhills.domain.service.HillWaterCalculator;

import javax.ejb.Stateless;

/**
 * Stateless bean used per request for calculation water volume gathered on {@link Hill Hill} after the rain.
 *
 * @author Vladimir Kishlaly
 * @since 17.12.2016
 */
@Stateless
public class HillWaterCalculatorBean implements HillWaterCalculator {

    @Override
    public int calculateWaterUnits(Hill hill) {
        return WaterCalculatorCache.INSTANCE.resolve(hill);
    }

}
