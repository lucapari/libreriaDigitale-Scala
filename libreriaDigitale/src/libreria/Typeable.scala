package libreria

trait Typeable {
  
  import TipoArticolo._
  
  val tipo : TipoArticolo
  
  //metodo già implementato
  def getTipo = tipo
  
  //metodo da implementare nelle classi che implementano il trait
  def getStrTipoClasse : String
  
}