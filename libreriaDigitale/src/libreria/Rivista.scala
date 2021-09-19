package libreria

class Rivista(titolo: String, val casaEditrice: String) extends ArticoloLibreria(titolo) {

   //overload del costruttore
  def this(titolo:String) = this(titolo, null)   
    
  //implementazione campo e metodo trait
  import TipoArticolo._
  val tipo: TipoArticolo = TipoArticolo.RIVISTA
  override def getStrTipoClasse: String = "Rivista"

  def getCasaEditrice: String = casaEditrice

  override def toString = {
    val sTipo: String = getTipo + " (ID_" + getArticoloID + ") :";
    val sTitolo: String = "Titolo = " + getTitolo;
    val sCasaEditrice: String = "Casa editrice = " + getCasaEditrice
    val sDisponibilita: String = "Disponibile = " + getDisponibilita;
    val sRes: String = sTipo + "\n" + sTitolo + "\n" + sCasaEditrice + "\n" + sDisponibilita + "\n"

    sRes
  }

}