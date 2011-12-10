package models
import play.db.anorm._
import play.db.anorm.SqlParser._
import play.db.anorm.defaults._

case class SnippetType(
  id: Pk[Long],
  title: String,
  desc: String)

object SnippetType extends Magic[SnippetType] {

  def all(): List[SnippetType] = {
    SQL("select * from SnippetType").as(SnippetType*)
  }

}