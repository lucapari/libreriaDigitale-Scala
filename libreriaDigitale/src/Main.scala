import libreria.ArticoloLibreria
import libreria.Audio
import libreria.Typeable
import libreria.Libro

object Main {

  def main(args: Array[String]): Unit = {

    //PROVA AUDIO come ArticoloLibreria
    val aud1: ArticoloLibreria = new Audio("titolo", "AUTORE", "CASA")
    println(aud1.toString())

    println()

    //PROVA INTERFACCIA come Audio
    val traittt: Typeable = new Audio("aaa", "aa", "CASaaA")
    println(traittt.getTipo)
    println(traittt.getStrTipoClasse)
    println(traittt.tipo)
    val aa: Audio = traittt.asInstanceOf[Audio]
    println(aa.getArticoloID)

    println()
    
    //PROVA LIBRO
    val lib1: ArticoloLibreria = new Libro("LibrT", "LibAut", "LibCasa", 33)
    println(lib1.toString())

    println()
    
  }
}