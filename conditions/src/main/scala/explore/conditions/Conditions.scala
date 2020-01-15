// Copyright (c) 2016-2019 Association of Universities for Research in Astronomy, Inc. (AURA)
// For license information see LICENSE or https://opensource.org/licenses/BSD-3-Clause

package explore.conditions

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import react.semanticui.elements.button._
import react.semanticui.colors._

object Conditions {

  private val component =
    ScalaComponent
      .builder[Unit]("Conditions")
      .render { _ =>
        <.div(
          Button("IQ"),
          Button(color = Blue)("Button", "Btn"),
          Button("Button", "Dec")
        )
      }
      .build

  def apply() = component()
}
