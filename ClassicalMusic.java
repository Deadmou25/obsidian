package org.example;

public class ClassicalMusic implements Music {

  public void init() {
    System.out.println("ClassicalMusic init");
  }

  public void destroy() {
    System.out.println("ClassicalMusic destroy");
  }

  @Override
  public String getSong() {
    return "classic music";
  }
}
