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
      LayoutItem(x = 0, y = 0, w = 6, h  = 9, i = "tpe"),
      LayoutItem(x = 6, y = 0, w = 6, h  = 9, i = "coords"),
      LayoutItem(x = 0, y = 10, w = 12, h = 8, i = "doc", isDraggable = false)
    ))

  val layoutMd: Layout = Layout(
    List(
      LayoutItem(x = 0, y = 0, w = 5, h  = 5, i = "tpe"),
      LayoutItem(x = 6, y = 0, w = 5, h  = 5, i = "coords"),
      LayoutItem(x = 0, y = 6, w = 10, h = 6, i = "doc", isDraggable = false)
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
      .initialState(0)
      .renderPS { ($, _, i) =>
        <.div(
          ^.cls := "rgl-area",
          AutoSizer(
            AutoSizer.props(
              disableHeight = true,
              children = s => {
                <.div(ResponsiveReactGridLayout(
                  ResponsiveReactGridLayout
                    .props(s.width,
                           margin           = (5: JsNumber, 5: JsNumber),
                           containerPadding = (5: JsNumber, 5: JsNumber),
                           className        = "layout",
                           rowHeight        = 30,
                           draggableHandle  = ".tileTitle",
                           onLayoutChange = (_, _) => $.modState(_ + 1),
                           layouts          = layouts),
                  <.div(^.key := "tpe",  ^.cls := "tile",    Tile(Tile.Props("Sample"), Form())),
                  <.div(^.key := "coords", ^.cls := "tile", Tile(Tile.Props("Coordinates"), Imag())),
                  <.div(^.key := "doc", ^.cls := "tile", Tile(Tile.Props("Target Position"), Tpe(i)))
                ).unless(s.width == 0))
              }
            ))
        )
      }
      .build

  def apply() = component()
}
