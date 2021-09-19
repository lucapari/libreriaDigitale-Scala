

package libreria

class Libro(titolo: String, val autore: String, val casaEditrice: String, val numPagine: Int) extends ArticoloLibreria(titolo) {

  import TipoArticolo._
  val tipo: TipoArticolo = TipoArticolo.LIBRO

  //implementazione metodo trait
  override def getStrTipoClasse: String = "Libro"

  def getAutore: String = autore
  def getCasaEditrice: String = casaEditrice
  def getNumPagine: Int = numPagine

  override def toString = {
    val sTipo: String = getTipo + " (ID_" + getArticoloID + ") :"
    val sTitolo: String = "Titolo = " + getTitolo
    val sAutore: String = "Autore = " + getAutore
    val sCasaEditrice: String = "Casa editrice = " + getCasaEditrice
    val sNumPagine : String = "Pagine = " + getNumPagine
    val sDisponibilita: String = "Disponibile = " + getDisponibilita
    val sRes: String = sTipo + "\n" + sTitolo + "\n" + sAutore + "\n" + sCasaEditrice + "\n" + sNumPagine + "\n" + sDisponibilita + "\n"

    sRes
  }

}