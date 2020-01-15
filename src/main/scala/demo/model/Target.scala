package demo.model

sealed trait Target
object Target {
  final case object M81 extends Target
  final case object M51 extends Target
}