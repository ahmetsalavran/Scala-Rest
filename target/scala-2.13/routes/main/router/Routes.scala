// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:4
  MessagesController_0: controllers.MessagesController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:4
    MessagesController_0: controllers.MessagesController
  ) = this(errorHandler, MessagesController_0, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, MessagesController_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """healthcheck""", """controllers.MessagesController.check()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """messages/""" + "$" + """id<[^/]+>""", """controllers.MessagesController.findOne(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """messages""", """controllers.MessagesController.create()"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """messages/""" + "$" + """id<[^/]+>""", """controllers.MessagesController.delete(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """messages""", """controllers.MessagesController.findAll(tag:Option[String], page:String ?= "2", count:String ?= "10")"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:4
  private[this] lazy val controllers_MessagesController_check0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("healthcheck")))
  )
  private[this] lazy val controllers_MessagesController_check0_invoker = createInvoker(
    MessagesController_0.check(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MessagesController",
      "check",
      Nil,
      "GET",
      this.prefix + """healthcheck""",
      """""",
      Seq()
    )
  )

  // @LINE:6
  private[this] lazy val controllers_MessagesController_findOne1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("messages/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_MessagesController_findOne1_invoker = createInvoker(
    MessagesController_0.findOne(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MessagesController",
      "findOne",
      Seq(classOf[String]),
      "GET",
      this.prefix + """messages/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_MessagesController_create2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("messages")))
  )
  private[this] lazy val controllers_MessagesController_create2_invoker = createInvoker(
    MessagesController_0.create(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MessagesController",
      "create",
      Nil,
      "POST",
      this.prefix + """messages""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_MessagesController_delete3_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("messages/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_MessagesController_delete3_invoker = createInvoker(
    MessagesController_0.delete(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MessagesController",
      "delete",
      Seq(classOf[String]),
      "DELETE",
      this.prefix + """messages/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_MessagesController_findAll4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("messages")))
  )
  private[this] lazy val controllers_MessagesController_findAll4_invoker = createInvoker(
    MessagesController_0.findAll(fakeValue[Option[String]], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MessagesController",
      "findAll",
      Seq(classOf[Option[String]], classOf[String], classOf[String]),
      "GET",
      this.prefix + """messages""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:4
    case controllers_MessagesController_check0_route(params@_) =>
      call { 
        controllers_MessagesController_check0_invoker.call(MessagesController_0.check())
      }
  
    // @LINE:6
    case controllers_MessagesController_findOne1_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_MessagesController_findOne1_invoker.call(MessagesController_0.findOne(id))
      }
  
    // @LINE:8
    case controllers_MessagesController_create2_route(params@_) =>
      call { 
        controllers_MessagesController_create2_invoker.call(MessagesController_0.create())
      }
  
    // @LINE:10
    case controllers_MessagesController_delete3_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_MessagesController_delete3_invoker.call(MessagesController_0.delete(id))
      }
  
    // @LINE:14
    case controllers_MessagesController_findAll4_route(params@_) =>
      call(params.fromQuery[Option[String]]("tag", None), params.fromQuery[String]("page", Some("2")), params.fromQuery[String]("count", Some("10"))) { (tag, page, count) =>
        controllers_MessagesController_findAll4_invoker.call(MessagesController_0.findAll(tag, page, count))
      }
  }
}
