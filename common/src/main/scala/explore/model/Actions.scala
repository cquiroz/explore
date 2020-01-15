package explore.conditions

import explore.model._
import cats.effect._

object Actions {
    implicit object TargetActionsIO extends TargetActionsInterpreter[IO](Views.target)
}