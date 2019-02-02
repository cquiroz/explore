package demo

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import scala.scalajs.js
// import scala.scalajs.js.annotation.JSImport
// import scala.scalajs.js.Dynamic.global

// @js.native
// @JSImport("aladin-lite", "A")
// object Aladin extends js.Object {
//   def aladin(id: String): Unit = js.native
// }
//
// @js.native
// @JSImport("aladin-lite", "CooFrameEnum")
// object CooFrameEnum extends js.Object {
//   def aladin(id: String): Unit = js.native
// }
//
object Tpe {
  trait AladinOpts extends js.Object {
    var fov: Double
    var target: String
  }

  private val component =
    ScalaComponent
      .builder[Int]("TPE")
      .render { _ =>
        println("TPE")
        <.div(
          ^.height := 100.pc,
          ^.id := "tpe-aladin"
        )
      }
      .componentDidMount { _ =>
        Callback {
          val opt = new AladinOpts() {
            var fov = 1
            var target = "M81"
          }
          js.Dynamic.global.console.log(js.Dynamic.global.A)
          js.Dynamic.global.A.aladin("#tpe-aladin", opt)
        }
      }
      .componentDidUpdate { _ =>
        Callback {
          val opt = new AladinOpts() {
            var fov = 1
            var target = "M81"
          }
          js.Dynamic.global.console.log(js.Dynamic.global.A)
          js.Dynamic.global.A.aladin("#tpe-aladin", opt)
        }
      }
      .build

  def apply(i:Int) = component(i)
}
