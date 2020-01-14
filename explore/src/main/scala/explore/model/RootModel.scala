package explore.model

import cats.effect._

import crystal._
import monocle.macros.Lenses

@Lenses
case class RootModel(
                      target: Target
                    )

trait AppState { self: IOApp =>
  val rootModel = Model[IO, RootModel](RootModel(Target.M81))
}
