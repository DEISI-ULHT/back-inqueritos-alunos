package com.deisi.inqueritos.filter;

import org.springframework.web.filter.AbstractRequestLoggingFilter;
import javax.servlet.http.HttpServletRequest;

public class ControllerRequestsLoggingFilter extends AbstractRequestLoggingFilter {

    public ControllerRequestsLoggingFilter() {
        setAfterMessagePrefix("[REQ] ");
        setIncludeClientInfo(true);
    }

    @Override
    protected void beforeRequest(HttpServletRequest httpServletRequest, String message) {
        // do nothing
    }

    @Override
    protected void afterRequest(HttpServletRequest httpServletRequest, String message) {
        logger.info(message);
    }

    @Override
    protected boolean shouldLog(HttpServletRequest request) {
        return logger.isInfoEnabled();
    }
}
