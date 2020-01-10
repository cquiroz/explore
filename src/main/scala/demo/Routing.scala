package demo

import japgolly.scalajs.react.extra.router._

sealed trait ElementItem extends Product with Serializable
case object IconsElement extends ElementItem
case object LabelsElement extends ElementItem

sealed trait Page extends Product with Serializable
case object HomePage extends Page
final case class ElementPage(e: ElementItem) extends Page

object Routing {
  val config: RouterConfig[Page] = RouterConfigDsl[Page].buildConfig { dsl =>
    import dsl._

    (
      staticRoute(root, HomePage) ~>
        render(HomeComponent.component())
    ).notFound(redirectToPage(HomePage)(SetRouteVia.HistoryPush))
      .renderWith(layout)
      .logToConsole
  }

  private def layout(c: RouterCtl[Page], r: Resolution[Page]) = OTLayout(c, r)
}
