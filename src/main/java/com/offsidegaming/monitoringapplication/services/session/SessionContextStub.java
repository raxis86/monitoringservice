package com.offsidegaming.monitoringapplication.services.session;

import com.offsidegaming.monitoringapplication.utils.SessionContextUtil;

/**
 * Stub for SessionContext
 */
//todo create real implementation of this service
public class SessionContextStub implements SessionContext {

    @Override
    public int getUserId() throws SessionContextException {
        String sessionId = SessionContextUtil.getUserSession();
        if (sessionId != null) {
            try {
                return Integer.parseInt(sessionId);
            } catch (NumberFormatException e) {
                throw new SessionContextException(e);
            }
        } else {
            throw new SessionContextException();
        }
    }
}
