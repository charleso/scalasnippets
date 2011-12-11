package controllers

import play._
import play.mvc._
import models._
import play.db.anorm.NotAssigned
import play.templates.Html$
import play.utils.HTML
import models.SnippetType
import play.db.anorm.Pk
import play.db.anorm.Id
import play.data.validation.Validation

object Application extends Controller {

  import views.Application._

  def index() = {
    val snippets = Snippet.all
    html.index("Snippets", snippets)
  }

  def createSnippet() = {
    html.create()
  }

  def create() = {
    def get(s:String) = {
        val value = params.get(s)
        Validation.required(s, value)
        value
    }
    val title = get("title")
    val desc = get("desc")
    val code = get("code")
    val result = get("result")
    if (Validation.hasErrors) {
        Action(createSnippet())
    } else {
        val snippet = Snippet.create(new Snippet(NotAssigned, title, desc, code, result, false, 0, 1))
        if (snippet.e.isLeft) {
            flash += ("error" -> snippet.e.left.get.toString)
            Action(index)
        } else {
            html.byType(List(snippet.e.right.get))
        }
    }
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
