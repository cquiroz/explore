// Copyright (c) 2016-2019 Association of Universities for Research in Astronomy, Inc. (AURA)
// For license information see LICENSE or https://opensource.org/licenses/BSD-3-Clause

package explore

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import scala.scalajs.js

object Tpe {
  trait AladinOpts extends js.Object {
    var fov: Double
    var target: String
  }

  private val component =
    ScalaComponent
      .builder[Int]("TPE")
      .render { _ =>
        <.div(
          ^.height := 28.pc,
          ^.id := "tpe-aladin"
        )
      }
      .componentDidMount { _ =>
        Callback {
          val opt = new AladinOpts() {
            var fov    = 1
            var target = "M81"
          }
          js.Dynamic.global.console.log(js.Dynamic.global.A)
          js.Dynamic.global.A.aladin("#tpe-aladin", opt)
        }
      }
      .componentDidUpdate { _ =>
        Callback {
          val opt = new AladinOpts() {
            var fov    = 1
            var target = "M81"
          }
          js.Dynamic.global.console.log(js.Dynamic.global.A)
          js.Dynamic.global.A.aladin("#tpe-aladin", opt)
        }
      }
      .build

  def apply(i: Int) = component(i)
}
