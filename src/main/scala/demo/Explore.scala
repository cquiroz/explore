package demo

import cats.effect.ExitCode
import cats.effect.IO
import cats.effect.IOApp
import cats.effect.ConcurrentEffect
import org.scalajs.dom
import scala.scalajs.js
import js.annotation._
import japgolly.scalajs.react.extra.router._

@JSExportTopLevel("Explore")
object ExploreMain extends IOApp {
  val Instance = ConcurrentEffect[IO]
  // println(Aladin.aladin("#abc"))
  @JSExport
  def runIOApp(): Unit = main(Array.empty)

  override def run(args: List[String]): IO[ExitCode] = IO {

    val container = Option(dom.document.getElementById("root")).getOrElse {
      val elem = dom.document.createElement("div")
      elem.id = "root"
      dom.document.body.appendChild(elem)
      elem
    }

    val router = Router(BaseUrl.fromWindowOrigin, Routing.config)
    router().renderIntoDOM(container)

    ExitCode.Success
  }
}
