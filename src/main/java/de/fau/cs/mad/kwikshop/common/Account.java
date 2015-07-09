package de.fau.cs.mad.kwikshop.common;

public abstract class Account {

  private int id;

  private String name;

  private Boolean loggedIn;

  public abstract Boolean delete();

  public abstract Boolean login();

  public abstract String create();

}
