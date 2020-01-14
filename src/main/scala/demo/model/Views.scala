package demo.model

import cats.effect._
import crystal._

object Views {
  import demo.ExploreMain.rootModel

  val targetView: View[IO, Target] = rootModel.view(RootModel.target)
}