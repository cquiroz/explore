package demo

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import japgolly.scalajs.react.extra.router._
import react.semanticui.modules.sidebar._
import react.semanticui.elements.segment._
import react.semanticui.collections.menu._
// import react.semanticui.As

object Layout {
  final case class Props(c: RouterCtl[Page], r: Resolution[Page])

  private val component =
    ScalaComponent
      .builder[Props]("Demo")
      .render_P { p =>
        <.div(
          ^.cls := "theme dimmable",
          Menu(Menu.props(
                 attached = MenuAttached.Top
               ),
               Menu.Item(Menu.Item.props(as = "a"), Icons.BarsIcon, "Menu")),
          Sidebar.Pushable(
            Sidebar.Pushable.props(),
            Segment(
              Segment.props(basic = true),
              Sidebar(
                Sidebar.props(
                  width     = SidebarWidth.Thin,
                  animation = SidebarAnimation.Push,
                  direction = SidebarDirection.Left,
                  visible   = false
                ),
                Menu(Menu.props(
                       inverted = true,
                       vertical = true,
                       icon     = MenuIcon.Labeled
                     ),
                     Menu.Item(Menu.Item.props(as = "a"), Icons.HomeIcon, "Home"))
              ),
              Sidebar.Pusher(
                Sidebar.Pusher.props(),
                Segment(
                  Segment.props(basic = true),
                  <.h3("Application Content"),
                  <.img(^.src := "https://react.semantic-ui.com/images/wireframe/paragraph.png"))
              )
            )
          )
        )
      }
      .build

  def apply(p: Props) = component(p)
}
