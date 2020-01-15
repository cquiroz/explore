package explore.model

import cats.effect._

import crystal._
import monocle.macros.Lenses

@Lenses
case class RootModel(
  target: Target
)

trait AppState {
  protected implicit val concurrentEffectIO: ConcurrentEffect[IO] = implicitly[ConcurrentEffect[IO]]
  protected implicit val timerIO: Timer[IO] = implicitly[Timer[IO]]

  lazy val rootModel = Model[IO, RootModel](RootModel(Target.M81))
}
