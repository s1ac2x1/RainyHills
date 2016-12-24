package com.kishlaly.tests.rainyhills.domain.service;

import com.kishlaly.tests.rainyhills.domain.model.Hill;

import javax.ejb.Local;

/**
 * Local EJB interface for {@link com.kishlaly.tests.rainyhills.domain.service.impl.HillWaterCalculatorBean HillWaterCalculatorBean}
 *
 * @author Vladimir Kishlaly
 * @since 17.12.2016
 */
@Local
public interface HillWaterCalculator {

    /**
     * Calculates possible water volume on given Hill
     *
     * @param hill {@link Hill hill} domain object
     * @return water volume
     */
    int calculateWaterUnits(Hill hill);

}
