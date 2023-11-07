package org.example;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.ZoneId;
import java.util.Set;

@WebFilter("/time")
public class TimezoneValidateFilter extends HttpFilter {

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        try {
            String timezoneParam = request.getParameter("timezone");

            if (!isValidTimezone(timezoneParam)) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().println("Invalid timezone");
                response.getWriter().println("Please write zone in valid format");
                response.getWriter().close();
            } else {
                chain.doFilter(request, response);
            }
        } catch (NullPointerException e) {
            chain.doFilter(request, response);
        }
    }

    private boolean isValidTimezone(String timezone) {
        String zone = timezone.replace("UTC+", "Etc/GMT-").replace("UTC-", "Etc/GMT+");
        Set<String> availableTimezones = ZoneId.getAvailableZoneIds();

        return availableTimezones.contains(zone);
    }
}