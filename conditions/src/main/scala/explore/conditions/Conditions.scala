// Copyright (c) 2016-2019 Association of Universities for Research in Astronomy, Inc. (AURA)
// For license information see LICENSE or https://opensource.org/licenses/BSD-3-Clause

package explore.conditions

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import react.semanticui.elements.button._
import react.semanticui.colors._
import react.common._
import crystal.react.io.implicits._
import explore.model._
import scala.scalajs.js
import js.JSConverters._
import js.UndefOr._

object Conditions {
  private val targetFlow = Views.target.flow

  private def renderButton(forTarget: Target, selected: Option[Target]) = {
    val color = selected.filter(_ == forTarget).map(_ => Blue).orUndefined
    Button(onClick = Actions.TargetActionsIO.set(forTarget), color = color)(forTarget.toString)
  }

  private val component =
    ScalaComponent
      .builder[Unit]("Conditions")
      .render { _ =>
        <.div(
          <.div(
            Button("IQ"),
            Button(color = Blue)("Button", "Btn"),
            Button("Button", "Dec")
          ),
          targetFlow(selected =>
            <.div(
              List(Target.M81, Target.M51).toTagMod(target => renderButton(target, selected))
            )
          )
        )
      }
      .build

  def apply() = component()
}
