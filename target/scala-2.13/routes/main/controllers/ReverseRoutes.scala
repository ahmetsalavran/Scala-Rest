// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:4
package controllers {

  // @LINE:4
  class ReverseMessagesController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:4
    def check(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "healthcheck")
    }
  
    // @LINE:8
    def create(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "messages")
    }
  
    // @LINE:6
    def findOne(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "messages/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:14
    def findAll(tag:Option[String], page:String = "2", count:String = "10"): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "messages" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[Option[String]]].unbind("tag", tag)), if(page == "2") None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("page", page)), if(count == "10") None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("count", count)))))
    }
  
    // @LINE:10
    def delete(id:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "messages/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
  }


}
