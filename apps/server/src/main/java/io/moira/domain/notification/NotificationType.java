package io.moira.domain.notification;

public enum NotificationType {
  FRIEND_REQUEST,
  SQUAD_INVITE;

  public static final class Values {

    public static final String FRIEND_REQUEST = "FRIEND_REQUEST";
    public static final String SQUAD_INVITE = "SQUAD_INVITE";
  }
}
