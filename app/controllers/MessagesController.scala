package controllers

import javax.inject._
import play.api.mvc._
import repositories.MessagesRepository
import reactivemongo.bson.BSONObjectID
import play.api.libs.json.{Json, __}
import scala.util.{Failure, Success}
import scala.concurrent.{ExecutionContext, Future}
import scala.collection.mutable.ListBuffer


import models.Todb

import play.api.libs.json._


@Singleton
class MessagesController @Inject()(
                                 implicit executionContext: ExecutionContext,
                                 val messagesRepository: MessagesRepository,
                                 val controllerComponents: ControllerComponents)
  extends BaseController {

  def check = Action { request =>
         Ok(Json.toJson(Seq(
        "status"     -> JsString("ok"))))}

  def create():Action[JsValue] = Action.async(controllerComponents.parsers.json) { 

    implicit request => {
    val uuid:String = java.util.UUID.randomUUID.toString
    val user_agent:String = request.headers.get("User-Agent").get
    val req:String = s"${request.body}"
    val message:String = req.substring(12, req.length-2)
    var tags = new ListBuffer[String]()
    val words = message.split(" ").toList

    for (word <- words){
     if ( word contains "#"){tags+=word.substring(1)}}
    tags.toList

    val json: JsValue = JsObject(
      Seq(
        "id"     -> JsString(uuid),
        "user_agent" ->JsString(user_agent),
        "message" -> JsString(message),
        "tags" -> JsString(tags.mkString(",")),
        "slugs" -> JsString(tags.mkString(",").toLowerCase())
            ))

    json.validate[Todb].fold(
          _ => Future.successful(BadRequest("Cannot create a message")),
          todb => messagesRepository.create(todb).map { _ => Created(Json.toJson(todb))})            
    }}

  def findOne(id:String):Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
  { val objectIdTryResult = BSONObjectID.parse(id)
      objectIdTryResult match {
        case Success(objectId) => messagesRepository.findOne(objectId).map {
           messages => Ok(Json.toJson(messages))
        }
        case Failure(_) => Future.successful(BadRequest("There is no message in that id"))
      }}}
  
  def delete(id: String):Action[AnyContent]  = Action.async { implicit request => 
    { val objectIdTryResult = BSONObjectID.parse(id)
      objectIdTryResult match {
        case Success(objectId) => messagesRepository.delete(objectId).map {
          _ => Ok(Json.toJson("delete has been succesfull"))
        }
        case Failure(_) => Future.successful(BadRequest("Cannot delete the message"))
      }
  }
}

    def findAll(tag:Option[String],page:String,count:String):Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    messagesRepository.findAll(tag,count).map {
      messages => Ok(Json.toJson(messages))
    }
  }

}


/* 
fetch(tag:String,page:Int)

Ok(Json.toJson(Seq(
        "status"     -> JsString(s"tag: $tag"))))


 BUNUN İÇİN MODEL FALANDA AYARLANMALI
    val json: JsValue = JsObject(
      Seq(
        "id"     -> JsString(uuid),
        "user_agent" ->JsString(user_agent),
        "message" -> JsString(message),
            "tags" -> JsArray(
      IndexedSeq(
        JsObject(
          Seq(
            "tug" -> JsString(tags(0)),
            "slug"  -> JsString(tags(0).toLowerCase())
          )
        ),
        JsObject(
          Seq(
            "tug" -> JsString(tags(1)),
            "slug"  -> JsString(tags(1).toLowerCase())
          ))))))

        println(json)
    json.validate[Todb].fold(
          _ => Future.successful(BadRequest("Cannot create a message")),
          todb => messagesRepository.create(todb).map { _ => Created(Json.toJson(todb))})
*/