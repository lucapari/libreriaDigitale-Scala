package libreria

class Audio(titolo: String, val autore: String, val casaDiscografica: String) extends ArticoloLibreria(titolo) {

  //overload del costruttore
  def this(titolo:String, autore:String) = this(titolo, autore, null)   
  
  //implementazione campo e metodo trait
  import TipoArticolo._
  val tipo: TipoArticolo = TipoArticolo.AUDIO
  override def getStrTipoClasse: String = "Audio"

  def getAutore : String = autore
  def getCasaDiscografica : String = casaDiscografica
  
  
  override def toString = {
    val sTipo: String = getTipo + " (ID_" + getArticoloID + ") :";
    val sTitolo: String = "Titolo = " + getTitolo;
    val sAutore: String = "Autore = " + getAutore;
    val sCasaDiscografica: String = "Casa discografica = " + getCasaDiscografica;
    val sDisponibilita: String = "Disponibile = " + getDisponibilita;
    val sRes: String = sTipo + "\n" + sTitolo + "\n" + sAutore + "\n" + sCasaDiscografica+"\n" + sDisponibilita + "\n"
    
    sRes
  }
}