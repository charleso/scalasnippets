package controllers

import play._
import play.mvc._
import models._
import play.db.anorm.NotAssigned
import play.templates.Html$
import play.utils.HTML
import models.SnippetType
import play.db.anorm.Pk

object Application extends Controller {

  import views.Application._

  def index() = {
    val snippets = Snippet.all
    html.index("Snippets", snippets)
  }

  def topBar() = {
    val snippetTypes = SnippetType.all()
    html.topBar(snippetTypes)
  }

  def viewAllSnippets() = {
    Snippet.all
  }

  def showByTypeId(typeId: Pk[Long]) = {
    val snippets = Snippet.findByTypeId(typeId)
    html.byType(snippets)

  }
  
  def randomSnippet = {
    val snippet = Snippet.random
    html.byType(snippet)
  }

}
