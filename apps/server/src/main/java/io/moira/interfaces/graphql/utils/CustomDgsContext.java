package io.moira.interfaces.graphql.utils;

public class CustomDgsContext {
  private Object authenticationPrincipal;

  public CustomDgsContext() {
    this.authenticationPrincipal = null;
  }

  public void setAuthenticationPrincipal(Object authenticationPrincipal) {
    this.authenticationPrincipal = authenticationPrincipal;
  }

  public Object getAuthenticationPrincipal() {
    return authenticationPrincipal;
  }
}
