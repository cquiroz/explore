package demo

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import react.semanticui.collections.menu._
import react.semanticui.sizes._

object Tile {
  final case class Props(title: String)

  private val component =
    ScalaComponent
      .builder[Props]("Tile")
      .render_PC { (p, c) =>
        <.div(
          Menu(
            Menu.props(
              size = Mini,
              attached   = MenuAttached.Top,
              compact    = true,
              borderless = true,
              tabular    = MenuTabular.Right
            ),
            MenuItem(
              MenuItem.props(as = "a"),
              Icons.BarsIcon,
              p.title),
          ),
          ^.cls := "tileTitle",
          c
        )
        // <.div(
        //   ^.height := 20.px,
        //   ^.cls := "tilemenu",
        //   c
        // )
      }
      .build

  def apply(p: Props, c: VdomNode*) = component(p)(c: _*)
}
