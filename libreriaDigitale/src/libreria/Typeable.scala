package libreria

trait Typeable {
  
  import TipoArticolo._
  
  val tipo : TipoArticolo
  
  def getTipo = tipo
  
  def getStrTipoClasse : String
  
}