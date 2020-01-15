package explore.model

import cats.effect._
import crystal._

object Views {
  import explore.ExploreMain.rootModel

  val targetView: View[IO, Target] = rootModel.view(RootModel.target)
}
