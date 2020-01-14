package demo.model

import crystal._

trait TargetActions[F[_]] {
  def set(newTarget: Target): F[Unit]
}

class TargetActionsInterpreter[F[_]](lens: FixedLens[F, Target]) extends TargetActions[F] {
  override def set(newTarget: Target): F[Unit] = lens.set(newTarget)
}
