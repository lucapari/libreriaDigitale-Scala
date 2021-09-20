

package manager

import libreria.ArticoloLibreria
import scala.collection.mutable.ListBuffer
import libreria.Audio
import libreria.Rivista
import libreria.Libro

object LibreriaInitializer {

  //private[manager] = visibilità package -> solo LibreriaManagar potrà richiamare questo metodo
  private[manager] def inizializzaLibreria() {
    val r1: Rivista = new Rivista("Focus Storia", "Mondadori");
    val a1: Audio = new Audio("The best of Vivaldi", "Antonio Vivaldi", "Classic Lbl");
    val l1: Libro = new Libro("I Malavoglia", "Giovanni Verga", "Einaudi", 320);

    val r2: Rivista = new Rivista("Wired", "Conde Nast Publications");
    val a2: Audio = new Audio("West End Blues", "Louis Armstrong", "Columbia Jazz Classics");
    val l2: Libro = new Libro("Anna Karenina", "Lev Tolstoj", "Feltrinelli", 1107);

    //inizializzo il campo statico di vettArticoli
    LibreriaManager.vettArticoli += r1
    LibreriaManager.vettArticoli += a1
    LibreriaManager.vettArticoli += l1
    LibreriaManager.vettArticoli += r2
    LibreriaManager.vettArticoli += a2
    LibreriaManager.vettArticoli += l2
  }
}