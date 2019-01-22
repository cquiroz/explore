package demo

import cats.effect.ExitCode
import cats.effect.IO
import cats.effect.IOApp
import cats.effect.ConcurrentEffect
import org.scalajs.dom
import scala.scalajs.js
import js.annotation._
import japgolly.scalajs.react.extra.router._
import com.olegpy.shironeko._
import japgolly.scalajs.react.vdom.html_<^._

object Store
    extends StoreBase[IO](OTMain.Instance)
    with ImpureIntegration[IO]
    with ScalaJSReactIntegration[IO] {
  val counter = Cell(0)
}

object Actions {
  val increment: IO[Unit] = Store.counter.update(_ + 1)
  val decrement: IO[Unit] = Store.counter.update(_ - 1)
}

object App extends Store.Container(Store.counter.listen) {
  override def render(a: Int) = ??? // TestComponent(a)
}
@JSExportTopLevel("OT")
object OTMain extends IOApp {
  val Instance = ConcurrentEffect[IO]

  @JSImport("react-grid-layout/css/styles.css", JSImport.Default)
  @js.native
  object ReactGridLayoutStyles extends js.Object

  @JSImport("react-resizable/css/styles.css", JSImport.Default)
  @js.native
  object ReactResizableStyles extends js.Object

  @JSExport
  def runIOApp(): Unit = main(Array.empty)

  override def run(args: List[String]): IO[ExitCode] = IO {
    ReactGridLayoutStyles
    ReactResizableStyles

    val container = Option(dom.document.getElementById("root")).getOrElse {
      val elem = dom.document.createElement("div")
      elem.id = "root"
      dom.document.body.appendChild(elem)
      elem
    }

    Router(BaseUrl.fromWindowOrigin, Routing.config)().renderIntoDOM(
      container
    )

    ExitCode.Success
  }
}
