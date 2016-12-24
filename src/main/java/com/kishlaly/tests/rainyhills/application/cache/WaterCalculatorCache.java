package com.kishlaly.tests.rainyhills.application.cache;

import com.kishlaly.tests.rainyhills.domain.model.Hill;
import com.kishlaly.tests.rainyhills.domain.service.MathUtils;

import java.util.concurrent.ConcurrentHashMap;

/**
 * In-memory cache for calculated water volumes on {@link Hill hills}.
 *
 * @author Vladimir Kishlaly
 * @since 17.12.2016
 */
public enum WaterCalculatorCache {

    INSTANCE;

    private ConcurrentHashMap<Hill, Integer> calculated = new ConcurrentHashMap<>();

    /**
     * Returns already calculated water volume for the same hill or performs calculation.
     *
     * @param hill the {@link Hill hill} to be calculated
     * @return water volume based on hill landscape
     */
    public Integer resolve(Hill hill) {
        return calculated.computeIfAbsent(hill, MathUtils.computeWaterVolume());
    }

    /**
     * @return current cache size
     */
    public int getSize() {
        return calculated.size();
    }

}
