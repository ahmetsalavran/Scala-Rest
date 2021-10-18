// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseMessagesController MessagesController = new controllers.ReverseMessagesController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseMessagesController MessagesController = new controllers.javascript.ReverseMessagesController(RoutesPrefix.byNamePrefix());
  }

}
