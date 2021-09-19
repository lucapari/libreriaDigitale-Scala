package libreria

class Audio(titolo: String, val autore: String, val casaDiscografica: String) extends ArticoloLibreria(titolo) {

  import TipoArticolo._
  val tipo: TipoArticolo = TipoArticolo.AUDIO

  //implementazione metodo trait
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