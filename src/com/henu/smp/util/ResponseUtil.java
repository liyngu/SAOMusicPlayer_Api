package com.henu.smp.util;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

public class ResponseUtil {

    public static Response format(Object object) {
        ResponseBuilder responseBuilder = Response.ok().entity(JSONUtil.parseToString(object));
        responseBuilder.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON + ";charset=UTF-8");
        return responseBuilder.build();
    }
}
