// Copyright (c) 2016-2019 Association of Universities for Research in Astronomy, Inc. (AURA)
// For license information see LICENSE or https://opensource.org/licenses/BSD-3-Clause

package explore

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import scala.scalajs.js
import model.Target
import react.common._

final case class Tpe(target: Target) extends ReactProps {
  @inline def render: VdomElement = Tpe.component(this)
}

object Tpe {
  type Props = Tpe

  trait AladinOpts extends js.Object {
    var fov: Double
    var target: String
  }

  private val component =
    ScalaComponent
      .builder[Props]("TPE")
      .render { _ =>
        <.div(
          ^.height := 28.pc,
          ^.id := "tpe-aladin"
        )
      }
      .componentDidMount { $ =>
        Callback {
          val opt = new AladinOpts() {
            var fov    = 1
            var target = $.props.target.toString
          }
          js.Dynamic.global.console.log(js.Dynamic.global.A)
          js.Dynamic.global.A.aladin("#tpe-aladin", opt)
        }
      }
      .componentDidUpdate { $ =>
        Callback {
          val opt = new AladinOpts() {
            var fov    = 1
            var target = $.currentProps.target.toString
          }
          js.Dynamic.global.console.log(js.Dynamic.global.A)
          js.Dynamic.global.A.aladin("#tpe-aladin", opt)
        }
      }
      .build
}
