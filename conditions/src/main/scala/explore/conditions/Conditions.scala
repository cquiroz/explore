// Copyright (c) 2016-2019 Association of Universities for Research in Astronomy, Inc. (AURA)
// For license information see LICENSE or https://opensource.org/licenses/BSD-3-Clause

package explore.conditions

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import react.semanticui.elements.button._
import react.semanticui.colors._
// import crystal.react.io.implicits._
import explore.model._
import scala.scalajs.js
import js.UndefOr._
import cats.effect._

object Conditions {

  @inline implicit def io2UndefOrCallback[A](io: IO[A]): js.UndefOr[Callback] = Callback {
    io.unsafeRunAsyncAndForget()
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
          <.div(
            Button(onClick = Actions.TargetActionsIO.set(Target.M81)).withChildren(Seq("M81")),
            Button(onClick = Actions.TargetActionsIO.set(Target.M51)).withChildren(Seq("M51"))
          )
        )
      }
      .build

  def apply() = component()
}
