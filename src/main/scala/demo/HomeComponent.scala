package demo

import japgolly.scalajs.react._
import japgolly.scalajs.react.raw.JsNumber
import japgolly.scalajs.react.vdom.html_<^._
import react.virtualized.AutoSizer
import react.gridlayout._
// import scala.scalajs.js.Dynamic.global

object HomeComponent {

  val layoutLg: Layout = Layout(
    List(
      LayoutItem(x = 0, y = 0, w = 6, h  = 4, i = "tpe"),
      LayoutItem(x = 6, y = 0, w = 6, h  = 4, i = "coords"),
      LayoutItem(x = 0, y = 5, w = 12, h = 6, i = "doc")
    ))

  val layoutMd: Layout = Layout(
    List(
      LayoutItem(x = 0, y = 0, w = 5, h  = 4, i = "tpe"),
      LayoutItem(x = 6, y = 0, w = 5, h  = 4, i = "coords"),
      LayoutItem(x = 0, y = 5, w = 10, h = 6, i = "doc")
    ))

  val layouts: Map[BreakpointName, (JsNumber, JsNumber, Layout)] =
    Map(
      (BreakpointName.lg, (1200, 12, layoutLg)),
      (BreakpointName.md, (996, 10, layoutMd)),
      // (BreakpointName.sm, (768, 8, layout)),
      // (BreakpointName.xs, (480, 6, layout))
    )

  private val component =
    ScalaComponent
      .builder[Unit]("Home")
      .render { _ =>
        <.div(
          ^.cls := "rgl-area",
          AutoSizer(
            AutoSizer.props(
              disableHeight = true,
              children = s => {
                println(s.width)
                <.div(ResponsiveReactGridLayout(
                  ResponsiveReactGridLayout
                    .props(s.width,
                           margin           = (5: JsNumber, 5: JsNumber),
                           containerPadding = (5: JsNumber, 5: JsNumber),
                           className        = "layout",
                           rowHeight        = 30,
                           layouts          = layouts),
                  <.div(^.key := "tpe",    ^.cls := "tile", "tpe"),
                  <.div(^.key := "coords", ^.cls := "tile", "coords"),
                  <.div(^.key := "doc",    ^.cls := "tile", "doc")
                ).unless(s.width == 0))
              }
            ))
        )
      }
      .build

  def apply() = component()
}
