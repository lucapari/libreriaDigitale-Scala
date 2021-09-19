

package libreria

abstract class ArticoloLibreria(val titolo: String) extends Typeable {
 
  val articoloID: Int = {
    ArticoloLibreria.staticID = ArticoloLibreria.staticID + 1
    ArticoloLibreria.staticID
  }

  //campo di default settato a true
  var disponibilita: Boolean = true
  
  def getArticoloID: Int = articoloID
  def getDisponibilita: Boolean = disponibilita
  def getTitolo: String = titolo
  def setDisponibilita(disponibilita: Boolean) = { this.disponibilita = disponibilita }
  
}

//companion object per membro statico
object ArticoloLibreria {
  var staticID: Int = 0
}