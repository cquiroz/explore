package demo

import japgolly.scalajs.react._
import japgolly.scalajs.react.raw.JsNumber
import japgolly.scalajs.react.vdom.html_<^._
import react.virtualized.AutoSizer
import react.gridlayout._

object HomeComponent {

  val layout: Layout = Layout(
    List(
      LayoutItem(x = 0, y = 0, w = 6, h = 2, i = "a", static = true),
      LayoutItem(x = 1, y = 0, w = 3, h = 2, i = "b", minW = 2, maxW = 4),
      LayoutItem(x = 4, y = 0, w = 1, h = 2, i = "c")
    ))

  val layouts: Map[BreakpointName, (JsNumber, JsNumber, Layout)] =
    Map(
      (BreakpointName.lg, (1200, 12, layout)),
      (BreakpointName.md, (996, 10, layout)),
      (BreakpointName.sm, (768, 8, layout)),
      (BreakpointName.xs, (480, 6, layout))
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
              children = s =>
                <.div(ResponsiveReactGridLayout(
                  ResponsiveReactGridLayout
                    .props(s.width,
                           margin           = (10: JsNumber, 10: JsNumber),
                           containerPadding = (10: JsNumber, 10: JsNumber),
                           className        = "layout",
                           rowHeight        = 30,
                           layouts          = layouts),
                  <.div(^.key := "a", "a"),
                  <.div(^.key := "c", "c"),
                  <.div(^.key := "b", "b")
                ).unless(s.width == 0))
            ))
        )
      }
      .build

  def apply() = component()
}
