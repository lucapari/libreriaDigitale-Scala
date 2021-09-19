import libreria.ArticoloLibreria
import libreria.Audio
import libreria.Typeable
import libreria.Libro
import libreria.Rivista
import libreria.Rivista

object Main {

  def main(args: Array[String]): Unit = {

    //PROVA AUDIO come ArticoloLibreria
    val aud1: ArticoloLibreria = new Audio("titolo", "AUTORE", "CASA")
    println(aud1.toString())

    println()

    //PROVA AUDIO OVERLOAD COSTRUTTORE
    val aud2: ArticoloLibreria = new Audio("titolo2", "AUTORE2")
    println(aud2.toString())

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
    
    //PROVA AUDIO OVERLOAD COSTRUTTORE
    val lib2: ArticoloLibreria = new Libro("lib2", "libAut2")
    println(lib2.toString())

    println()
    
    //PROVA RIVISTA
    val riv1: ArticoloLibreria = new Rivista("rivTit", "casaRiv")
    println(riv1.toString())
    
    println()
    
    //PROVA RIVISTA overload costruttore
    val riv2: ArticoloLibreria = new Rivista("rivTit2")
    println(riv2.toString())
    
    println()
    
  }
}