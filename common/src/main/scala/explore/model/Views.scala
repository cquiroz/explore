package explore.model

import cats.effect._
import crystal._

object Views {
  import AppState.rootModel

  lazy val target: View[IO, Target] = rootModel.view(RootModel.target)
}
