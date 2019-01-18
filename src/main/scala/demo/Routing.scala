package demo

import japgolly.scalajs.react.vdom.html_<^._
import japgolly.scalajs.react.extra.router._

sealed trait ElementItem
case object IconsElement extends ElementItem
case object LabelsElement extends ElementItem

sealed trait Page
case object HomePage extends Page
final case class ElementPage(e: ElementItem) extends Page

object Routing {
  val config: RouterConfig[Page] = RouterConfigDsl[Page].buildConfig { dsl =>
    import dsl._

    (
      trimSlashes
        | staticRoute(root, HomePage) ~>
          render(HomeComponent.apply)
    ).notFound(redirectToPage(HomePage)(Redirect.Replace))
      .renderWith(layout)
      .logToConsole
  }

  private def layout(c: RouterCtl[Page], r: Resolution[Page]) = Layout(Layout.Props(c, r))
}
