package models

import org.joda.time.DateTime
import play.api.libs.json.{Format, Json}
import reactivemongo.play.json._
import reactivemongo.bson.BSONObjectID
import reactivemongo.bson._
import play.api.libs.json.JodaWrites._
import play.api.libs.json.JodaReads._
import play.api.libs.json._


case class Todb(
                _id:Option[BSONObjectID],
                user_agent:String,
                message:String,
                tags:String,
                slugs:String
                )

object Todb{
  implicit val fmt : Format[Todb] = Json.format[Todb]
  implicit object TodbBSONReader extends BSONDocumentReader[Todb] {
    def read(doc: BSONDocument): Todb = {
      Todb(
        doc.getAs[BSONObjectID]("_id"),
        doc.getAs[String]("user_agent").get,
        doc.getAs[String]("message").get,
        doc.getAs[String]("tags").get,
        doc.getAs[String]("slugs").get
        )
    }
  }

  implicit object TodbBSONWriter extends BSONDocumentWriter[Todb] {
    def write(todb: Todb): BSONDocument = {
      BSONDocument(
        "_id" -> todb._id,
        "user_agent" ->todb.user_agent,
        "message" -> todb.message,
        "tags" -> todb.tags,
        "slugs" -> todb.slugs
      )
    }
  }
}
