package demo

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import react.semanticui.elements.button._
import react.semanticui.colors._

object Form {

  private val component =
    ScalaComponent
      .builder[Unit]("Form")
      .render { _ =>
        <.div(
          Button("Button", "Home"),
          Button(color = Blue)("Button", "Btn"),
          Button("Button", "Dec")
        )
      }
      .build

  def apply() = component()
}
