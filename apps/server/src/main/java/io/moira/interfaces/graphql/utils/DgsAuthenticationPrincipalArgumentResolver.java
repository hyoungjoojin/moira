package io.moira.interfaces.graphql.utils;

import com.netflix.graphql.dgs.context.DgsContext;
import com.netflix.graphql.dgs.internal.DgsWebMvcRequestData;
import com.netflix.graphql.dgs.internal.method.ArgumentResolver;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.core.MethodParameter;
import org.springframework.security.web.method.annotation.AuthenticationPrincipalArgumentResolver;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.NativeWebRequest;

@Component
public class DgsAuthenticationPrincipalArgumentResolver implements ArgumentResolver {

  private final AuthenticationPrincipalArgumentResolver authenticationPrincipalArgumentResolver =
      new AuthenticationPrincipalArgumentResolver();

  @Override
  public Object resolveArgument(MethodParameter parameter, DataFetchingEnvironment dfe) {
    DgsWebMvcRequestData dgsWebMvcRequestData =
        (DgsWebMvcRequestData) DgsContext.getRequestData(dfe);
    NativeWebRequest request =
        dgsWebMvcRequestData == null
            ? null
            : (NativeWebRequest) dgsWebMvcRequestData.getWebRequest();
    return authenticationPrincipalArgumentResolver.resolveArgument(parameter, null, request, null);
  }

  @Override
  public boolean supportsParameter(MethodParameter arg0) {
    return authenticationPrincipalArgumentResolver.supportsParameter(arg0);
  }
}
