package io.moira.interfaces.graphql.utils;

import com.netflix.graphql.dgs.context.DgsCustomContextBuilderWithRequest;
import java.util.Map;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

@Component
public class CustomDgsContextBuilder
    implements DgsCustomContextBuilderWithRequest<CustomDgsContext> {

  @Override
  public CustomDgsContext build(
      Map<String, ? extends Object> arg0, HttpHeaders arg1, WebRequest arg2) {
    return new CustomDgsContext();
  }
}
