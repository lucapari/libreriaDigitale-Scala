

package manager

import scala.collection.mutable.ListBuffer
import libreria.ArticoloLibreria
import customException.ArticoloNotFoundException
import libreria.TipoArticolo
import TipoArticolo._

object LibreriaManager {
  //campo statico: ce ne è solo uno per tutta la classe
  var vettArticoli: ListBuffer[ArticoloLibreria] = new ListBuffer()

  //vettArticolo inizializzato in fase di load di LibreriaManager
  LibreriaInitializer.inizializzaLibreria();

  def printArticolo(articoloID: Int) = {

    def findArticolo(articoloID: Int) = {
      val tempList = vettArticoli.filter(x => x.getArticoloID == articoloID)
      if (tempList.size == 0)
        throw new ArticoloNotFoundException
      else
        println(tempList(0))
    }

    try {
      findArticolo(articoloID)
    } catch {
      case e: ArticoloNotFoundException =>
        println("Errore. Articolo con ID_" + articoloID + " non trovato.\n")
    }

  }

  def printArticolo(nomeArticolo: String) = {
    def findArticolo(nomeArticolo: String) = {
      val tempList = vettArticoli.filter(x => x.getTitolo == nomeArticolo)
      if (tempList.size == 0)
        throw new ArticoloNotFoundException
      else
        println(tempList(0))
    }

    try {
      findArticolo(nomeArticolo)
    } catch {
      case e: ArticoloNotFoundException =>
        println("Errore. Articolo con nome \"" + nomeArticolo + "\" non trovato.\n")
        null
    }
  }

  def printAllArticoli = {
    vettArticoli.foreach(println)
  }

  def aggiungiArticolo(articolo: ArticoloLibreria) = {
    vettArticoli += articolo
  }

  def rimuoviArticolo(articoloID: Int) = {
    var trovato = false
    for (temp <- vettArticoli) {
      if (temp.getArticoloID == articoloID) {
        println("Articolo \"" + temp.getTitolo + "\" rimosso correttamente! ")
        vettArticoli -= temp
        trovato = true
      }
    }
    if (!trovato) {
      throw new ArticoloNotFoundException
    }
  }

  def noleggiaArticolo(articoloID: Int) = {
    var trovato = false
    for (temp <- vettArticoli) {
      if (temp.getArticoloID == articoloID) {
        trovato = true
        if (temp.getDisponibilita == true) {
          temp.setDisponibilita(false)
          println("Articolo \"" + temp.getTitolo + "\" noleggiato correttamente! ")
        } else
          println("Impossibile prestare articolo. L'articolo non è disponibile.")
      }
    }
    if (!trovato) {
      throw new ArticoloNotFoundException
    }
  }

  def restituisciArticolo(articoloID: Int) = {
    var trovato = false
    for (temp <- vettArticoli) {
      if (temp.getArticoloID == articoloID) {
        trovato = true
        if (temp.getDisponibilita == false) {
          temp.setDisponibilita(true)
          println("Articolo \"" + temp.getTitolo + "\" restituito correttamente! ")
        } else
          println("Impossibile restituire articolo. L'articolo è già stato restituito.")
      }
    }
    if (!trovato) {
      throw new ArticoloNotFoundException
    }
  }
  
  //T sottotipo di ArticoloLibreria
  def printSottocategoria[T <: ArticoloLibreria] ( sottoCategoria : TipoArticolo)  = {
    
    def getVettSottocategoria[T <: ArticoloLibreria] ( sottoCategoria : TipoArticolo) : ListBuffer[T] = {
      var vettSottoCat: ListBuffer[T] = new ListBuffer()
      vettArticoli.foreach(x => if(x.getTipo==sottoCategoria) vettSottoCat += x.asInstanceOf[T])
      vettSottoCat
    }
    
    getVettSottocategoria[T](sottoCategoria).foreach(println)
    
  }

}