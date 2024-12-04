trait DollarConversion {
  def get: BigDecimal
  def toRub(exchangeRate: BigDecimal) = new Ruble(this.get * exchangeRate)
  def toDin(exchangeRate: BigDecimal) = new Dinar(this.get * exchangeRate)
}
trait DinarConversion {
  def get: BigDecimal
  def toRub(exchangeRate: BigDecimal) = new Ruble(this.get * exchangeRate)
  def toDol(exchangeRate: BigDecimal) = new Dollar(this.get * exchangeRate)
}
class Ruble(private val value: BigDecimal) {
  def get: BigDecimal = value
  override def toString: String = s"Ruble($value)"
}
class Dollar(private val value: BigDecimal) extends DollarConversion {
  def get: BigDecimal = value
  override def toString: String = s"Dollar($value)"
}
class Dinar(private val value: BigDecimal) extends DinarConversion {
  def get: BigDecimal = value
  override def toString: String = s"Dinar($value)"
}

object TestConversions extends App {
  println(new Dollar(10).toRub(104.47))
  println(new Dollar(10).toDin(0.38).toRub(277.6))
}
