package bootstrap
import play.jobs._

@OnApplicationStart class SnippetBootStrap extends Job {

  override def doJob {

    import models._
    import play.test._

    // Import initial data if the database is empty
    if (SnippetType.count().single() == 0) {
      Yaml[List[Any]]("snippet-type-initial-data.yml").foreach {
        _ match {
          case u: SnippetType => SnippetType.create(u)
        }
      }
    }
    
     if (Snippet.count().single() == 0) {
      Yaml[List[Any]]("snippet-initial-data.yml").foreach {
        _ match {
          case u: Snippet => Snippet.create(u)
        }
      }
    }
  }
}