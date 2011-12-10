package models
import play.db.anorm._
import play.db.anorm.SqlParser._
import play.db.anorm.defaults._

case class Snippet(
  id: Pk[Long],
  title: String,
  desc: String,
  code: String,
  result: String,
  accepted: Boolean,
  views: Int,
  typeId: Long)

object Snippet extends Magic[Snippet] {

  def all() = {
    SQL("""
        select * from Snippet s 
        join SnippetType st on s.typeId = st.id
        """).as(Snippet ~< SnippetType ^^ flatten *)
  }
  
  def findByTypeId(typeId: Pk[Long]) = {
    Snippet.find("typeId = " + typeId).on("typeId" -> typeId).as(Snippet *)
  }
}