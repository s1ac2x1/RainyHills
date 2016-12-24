package com.kishlaly.tests.rainyhills.application.web;

import com.kishlaly.tests.rainyhills.application.cache.WaterCalculatorCache;
import com.kishlaly.tests.rainyhills.domain.model.Hill;
import com.kishlaly.tests.rainyhills.domain.service.HillWaterCalculator;
import com.kishlaly.tests.rainyhills.domain.service.impl.HillWaterCalculatorBean;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author Vladimir Kishlaly
 * @since 17.12.2016
 */
public class HillWaterCalculatorServletTest extends Mockito {

    private static Logger log = Logger.getLogger(HillWaterCalculatorServletTest.class.getName());

    HttpServletRequest request;
    HttpServletResponse response;
    HillWaterCalculator calculator;
    HillWaterCalculatorServlet servlet;
    StringWriter stringWriter;
    PrintWriter writer;

    @Before
    public void setup() {
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        calculator = mock(HillWaterCalculatorBean.class);
        servlet = new HillWaterCalculatorServlet();
        servlet.calculator = calculator;
        stringWriter = new StringWriter();
        writer = new PrintWriter(stringWriter);
    }

    @Test
    public void mainTest() {
        prepare("4,1,1,0,2,3");
        try {
            when(response.getWriter()).thenReturn(writer);
            servlet.doPost(request, response);
            assertEquals("8", stringWriter.toString());
        } catch (Exception e) {
            log.error("This should be happened", e);
        }
    }

    @Test
    public void emptyVolumeTest() {
        prepare("1,2,3,4,5,6,7,8,9,10");
        try {
            when(response.getWriter()).thenReturn(writer);
            servlet.doPost(request, response);
            assertEquals("0", stringWriter.toString());
        } catch (Exception e) {
            log.error("This should be happened", e);
        }
    }

    private void prepare(String landscape) {
        when(request.getParameter("landscape")).thenReturn(landscape);
        int[] src = Stream.of(landscape.split(",")).mapToInt(Integer::parseInt).toArray();
        Hill hill = new Hill(src);
        when(calculator.calculateWaterUnits(hill))
                .thenReturn(WaterCalculatorCache.INSTANCE.resolve(hill));
    }

}
