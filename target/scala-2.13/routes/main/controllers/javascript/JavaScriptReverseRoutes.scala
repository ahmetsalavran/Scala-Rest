// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:4
package controllers.javascript {

  // @LINE:4
  class ReverseMessagesController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:4
    def check: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MessagesController.check",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "healthcheck"})
        }
      """
    )
  
    // @LINE:8
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MessagesController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "messages"})
        }
      """
    )
  
    // @LINE:6
    def findOne: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MessagesController.findOne",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "messages/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:14
    def findAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MessagesController.findAll",
      """
        function(tag0,page1,count2) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "messages" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[Option[String]]].javascriptUnbind + """)("tag", tag0), (page1 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("page", page1)), (count2 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("count", count2))])})
        }
      """
    )
  
    // @LINE:10
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MessagesController.delete",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "messages/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
  }


}
