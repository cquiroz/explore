package demo

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import japgolly.scalajs.react.extra.router._
import react.semanticui.modules.sidebar._
import react.semanticui.elements.segment._
import react.semanticui.elements.header._
import react.semanticui.elements.image._
import react.semanticui.collections.menu._
import react.semanticui.As

object Layout {
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
              attached = MenuAttached.Top
            ),
            Menu.Item(
              Menu.Item.props(as = "a", onClick = $.modState((s: State) => s.copy(menu = !s.menu))),
              Icons.BarsIcon,
              "Menu")),
          Sidebar.Pushable(
            Sidebar.Pushable.props(),
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
              Menu.Item(Menu.Item.props(as = "a"), Icons.HomeIcon, "Home")
            ),
            Sidebar.Pusher(
              Sidebar.Pusher.props(dimmed = s.menu),
              Segment(
                Segment.props(basic = true),
                Header(Header.props(as = "h3"), "Application Content"),
                Image(Image.props(src = "https://react.semantic-ui.com/images/wireframe/paragraph.png"))
              )
            )
          )
        )
      }
      .build

  def apply(p: Props) = component(p)
}
