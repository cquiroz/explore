package explore.model

import cats.effect._

import crystal._
import monocle.macros.Lenses

import scala.concurrent.ExecutionContext.global

@Lenses
case class RootModel(
  target: Target
)

object AppState {
  implicit private lazy val timerIO: Timer[IO] = cats.effect.IO.timer(global)
  implicit private lazy val csIO: ContextShift[IO] = IO.contextShift(global)

  lazy val rootModel = Model[IO, RootModel](RootModel(Target.M81))
}
