package repositories

import models.Todb
import javax.inject._
import reactivemongo.api.bson.collection.BSONCollection
import play.modules.reactivemongo.ReactiveMongoApi
import scala.concurrent.{ExecutionContext, Future}
import reactivemongo.api.{Cursor, ReadPreference}
import reactivemongo.bson.{BSONDocument, BSONObjectID}
import org.joda.time.DateTime
import reactivemongo.api.commands.WriteResult


@Singleton
class MessagesRepository @Inject()(
                                 implicit executionContext: ExecutionContext,
                                 reactiveMongoApi: ReactiveMongoApi
                               ) {
  def collection: Future[BSONCollection] = reactiveMongoApi.database.map(db => db.collection("deneme"))

 def findAll(tag:Option[String],count:String): Future[Seq[Todb]] = {
    collection.flatMap(
      _.find(BSONDocument("tags" -> tag), Option.empty[Todb])
        .cursor[Todb](ReadPreference.Primary)
        .collect[Seq](count.toInt, Cursor.FailOnError[Seq[Todb]]())
    )
  }

  def create(todb: Todb): Future[WriteResult] = {

    collection.flatMap(_.insert(ordered = false)
      .one(todb.copy()))
  }

    def findOne(id: BSONObjectID): Future[Option[Todb]] = {
    collection.flatMap(_.find(BSONDocument("_id" -> id), Option.empty[Todb]).one[Todb])
  }

    def delete(id: BSONObjectID):Future[WriteResult] = {
    collection.flatMap(
      _.delete().one(BSONDocument("_id" -> id), Some(1))
    )
  }
}

