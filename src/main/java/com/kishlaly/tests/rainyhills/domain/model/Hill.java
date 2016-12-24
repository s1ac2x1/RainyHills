package com.kishlaly.tests.rainyhills.domain.model;

import java.util.Arrays;

/**
 * The main domain object which represents a landspace with different heights.
 *
 * @author Vladimir Kishlaly
 * @since 17.12.2016
 */
public class Hill {

    private final int[] landscape;

    public Hill(int[] landscape) {
        this.landscape = landscape;
    }

    /**
     * @return the integer representation of landscape heights
     */
    public int[] getLandscape() {
        return landscape;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hill hill = (Hill) o;
        return Arrays.equals(landscape, hill.landscape);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(landscape);
    }
}
