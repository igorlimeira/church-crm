package br.com.joy.configuration;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsConfig extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        logger.info("Request Header Origin: "+ (Objects.isNull(request.getHeader("Origin")) ?
                "NOT_SPECIFIED" : request.getHeader("Origin")));
        response.addHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        if (request.getHeader("Access-Control-Request-Method") != null
                && "OPTIONS".equals(request.getMethod())) {
            // CORS "pre-flight" request
            response.addHeader("Access-Control-Allow-Methods",
                    "GET, POST, PUT, DELETE");
            response.setHeader("Access-Control-Allow-Headers",
                    "Origin" +
                            "Accept, " +
                            "X-Requested-With, " +
                            "Content-Type, " +
                            "Access-Control-Request-Method, " +
                            "Access-Control-Request-Headers, " +
                            "Authorization");
            response.setHeader("Access-Control-Allow-Credentials", "true");
        }
        filterChain.doFilter(request, response);
    }
}
