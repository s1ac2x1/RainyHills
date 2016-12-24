package com.kishlaly.tests.rainyhills.application;

import com.kishlaly.tests.rainyhills.domain.model.Hill;

import java.util.stream.Stream;

/**
 * Util class for convenient creation of the {@link Hill Hill} domain object.
 *
 * @author Vladimir Kishlaly
 * @since 17.12.2016
 */
public class HillUtils {

    /**
     * @param input {@link String string} representation of landscape
     * @return {@link Hill Hill} object based on given landscape
     */
    public static Hill parseFromString(String input) throws NumberFormatException {
        int[] landscape = Stream
                .of(input.split(","))
                .map(param -> param.trim())
                .filter(param -> !param.isEmpty())
                .mapToInt(Integer::valueOf).toArray();
        return new Hill(landscape);
    }

}
