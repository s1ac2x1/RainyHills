package com.kishlaly.tests.rainyhills.application.web;

import com.kishlaly.tests.rainyhills.application.HillUtils;
import com.kishlaly.tests.rainyhills.domain.model.Hill;
import com.kishlaly.tests.rainyhills.domain.service.HillWaterCalculator;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Vladimir Kishlaly
 * @since 17.12.2016
 */
@WebServlet("/calculate")
public class HillWaterCalculatorServlet extends HttpServlet {

    @EJB
    HillWaterCalculator calculator;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Hill hill = HillUtils.parseFromString(request.getParameter("landscape"));
            int result = calculator.calculateWaterUnits(hill);
            response.getWriter().print(result);
        } catch (NumberFormatException exception) {
            response.getWriter().print("ERROR: Too big numbers.");
        }
    }
}
