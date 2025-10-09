package io.moira.interfaces.graphql.utils;

import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import com.netflix.graphql.dgs.context.DgsContext;
import com.netflix.graphql.dgs.internal.DgsWebMvcRequestData;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.ServletWebRequest;

public class DgsUtils {

  private DgsUtils() {}

  public static HttpServletRequest getHttpServletRequest(DgsDataFetchingEnvironment dfe) {
    DgsWebMvcRequestData dgsWebMvcRequestData =
        (DgsWebMvcRequestData) DgsContext.getRequestData(dfe);
    ServletWebRequest servletWebRequest = (ServletWebRequest) dgsWebMvcRequestData.getWebRequest();
    HttpServletRequest httpServletRequest = servletWebRequest.getRequest();
    return httpServletRequest;
  }
}
