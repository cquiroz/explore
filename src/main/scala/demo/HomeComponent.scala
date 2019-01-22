package demo

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import react.semanticui.elements.header._
import react.semanticui.elements.image._

object HomeComponent {

  private val component =
    ScalaComponent
      .builder[Unit]("Home")
      .render { _ =>
        <.div(
                Header(Header.props(as = "h3"), "Application Content"),
                Image(Image.props(src = "https://react.semantic-ui.com/images/wireframe/paragraph.png"))

        )
      }
      .build

  def apply() = component()
}
