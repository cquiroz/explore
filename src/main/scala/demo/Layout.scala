package demo

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import japgolly.scalajs.react.extra.router._
import react.semanticui.modules.sidebar._
// import react.semanticui.elements.segment._
import react.semanticui.collections.menu._
import react.semanticui.As

object OTLayout {
  final case class Props(c: RouterCtl[Page], r: Resolution[Page])

  final case class State(menu: Boolean)

  private val component =
    ScalaComponent
      .builder[Props]("Demo")
      .initialState(State(false))
      .renderPS { ($, p, s) =>
        <.div(
          ^.cls := "theme dimmable",
          Menu(
            Menu.props(
              attached   = MenuAttached.Top,
              compact    = true,
              borderless = true,
              tabular    = MenuTabular.Right
            ),
            MenuItem(
              MenuItem.props(as = "a", onClick = $.modState((s: State) => s.copy(menu = !s.menu))),
              Icons.BarsIcon,
              "Formerly known as OT")
          ),
          Sidebar.Pushable(
            Sidebar.Pushable.props(className = "maingrid"),
            Sidebar(
              Sidebar.props(
                as = As.Menu(
                  Menu.props(
                    inverted = true,
                    vertical = true,
                    icon     = MenuIcon.Labeled,
                  )),
                width     = SidebarWidth.Thin,
                animation = SidebarAnimation.Push,
                direction = SidebarDirection.Left,
                visible   = s.menu
              ),
              MenuItem(MenuItem.props(as = "a"), Icons.HomeIcon, "P I"),
              MenuItem(MenuItem.props(as = "a"), Icons.HomeIcon, "P II")
            ),
            Sidebar.Pusher(
              Sidebar.Pusher.props(dimmed = s.menu),
              // Segment(
              //   Segment.props(basic = true),
              p.r.render()
              // )
            )
          )
        )
      }
      .build

  def apply(p: Props) = component(p)
}
