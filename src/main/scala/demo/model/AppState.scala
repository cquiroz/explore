package demo.model

import cats.effect._

import crystal._
import monocle.macros.Lenses

import scala.concurrent.ExecutionContext.global

object AppState {
  implicit private val timerIO: Timer[IO] = cats.effect.IO.timer(global)
  implicit private val csIO: ContextShift[IO] = IO.contextShift(global)

  @Lenses
  case class RootModel(
                        target: Target
                      )

  val rootModel = Model[IO, RootModel](RootModel(Target.M81))

  val targetView: View[IO, Target] = rootModel.view(RootModel.target)
}