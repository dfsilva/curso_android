package dao

import dao.EnqueteDao._
import models._
import slick.driver.PostgresDriver.api._
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object EnqueteDao extends BaseDao{

  def findByUf(uf:String):Future[Seq[Enquete]] = {
    (for{
      enquete <- enqueteTable.filter(enquete => enquete.uf === uf)
    } yield enquete).result
  }

  def findById(userId: EnqueteId, postId: RespostaId, commentId: EnqueteId): Future[Enquete] = {
    (for{
      comment <- enqueteTable.filter(comment => comment.id === commentId)
    } yield comment).result.head
  }

  def create(enquete: Enquete): Future[EnqueteId] = enqueteTable returning enqueteTable.map(_.id) += enquete

  def create2(enquete: Enquete, respostas: List[Resposta]): Future[Unit] = {

    val inserir : DBIOAction[Unit, NoStream, Effect.Write] =
      for {
         eId <- enqueteTable returning enqueteTable.map(_.id) += enquete
         i = respostas.map(_.copy(enqueteId = eId))
         reId <- respostaTable returning respostaTable.map(_.id) ++= i
      } yield (eId, reId)

      db.run(inserir.transactionally) map( _ => ())
  }

  def update(newComment: Enquete, commentId: EnqueteId): Future[Int] = enqueteTable.filter(_.id === commentId)
    .map(comment => comment.titulo)
    .update(newComment.titulo)

  def delete(commentId: EnqueteId): Future[Int] = enqueteTable.filter(_.id === commentId).delete
}
