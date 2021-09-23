

package menuCLI

import manager.LibreriaManager
import libreria.TipoArticolo
import libreria.Rivista
import libreria.Audio
import libreria.Libro
import customException.ArticoloNotFoundException

object Menu {
  def inizializzaMenu = {
    //inizializza la libreria facendo il load di LibreriaInitializer tramite LibreriaManager
    LibreriaManager.vettArticoli

    val nomeApp =
      "  _      _ _                   _         _____  _       _ _        _      \n" +
        " | |    (_) |                 (_)       |  __ \\(_)     (_) |      | |     \n" +
        " | |     _| |__  _ __ ___ _ __ _  __ _  | |  | |_  __ _ _| |_ __ _| | ___ \n" +
        " | |    | | '_ \\| '__/ _ \\ '__| |/ _` | | |  | | |/ _` | | __/ _` | |/ _ \\\n" +
        " | |____| | |_) | | |  __/ |  | | (_| | | |__| | | (_| | | || (_| | |  __/\n" +
        " |______|_|_.__/|_|  \\___|_|  |_|\\__,_| |_____/|_|\\__, |_|\\__\\__,_|_|\\___|\n" +
        "                                                   __/ |                  \n" +
        "                                                  |___/                   "

    val nomeAutore =
      "\t\t  _                      _                              \n" +
        "\t\t |_)     |       _  _.  |_) _. ._ o ._ _  |_   _  | | o \n" +
        "\t\t |_) \\/  |_ |_| (_ (_|  |  (_| |  | | | | |_) (/_ | | | \n" +
        "\t\t     /                                                  "

    println(nomeApp)
    println()
    println(nomeAutore)
    println()

  }

  def startMenuScelta: Unit = {
    val menu: String =
      "*******************************************************************\n" +
        "***\t\t\t    Fai la tua scelta:\t\t\t***\n" +
        "*** 1] Visualizza libreria\t\t\t\t\t***\n" +
        "*** 2] Noleggia articolo\t\t\t\t\t***\n" +
        "*** 3] Restituisci articolo\t\t\t\t\t***\n" +
        "*** 4] Cerca articolo\t\t\t\t\t\t***\n" +
        "*** 5] Inserisci nuovo articolo\t\t\t\t\t***\n" +
        "*** 6] Rimuovi articolo\t\t\t\t\t\t***\n" +
        "***\t\t\t\t\t\t\t\t***\n" +
        "*** 0] Termina il programma\t\t\t\t\t***\n" +
        "***\t\t\t\t\t\t\t\t***\n" +
        "*******************************************************************";

    println(menu)
    println()

    var scelta: Int = -1;
    while (!(scelta >= 0 && scelta <= 6)) {
      print("Scelta >> ")
      scelta = scala.io.StdIn.readInt()
    }

    println("\n")

    scelta match {
      case 0 => println("Termino il programma.");//esce dal menu
      case 1 => visualizzaLibreria; startMenuScelta
      case 2 => noleggiaArticolo; startMenuScelta
      case 3 => restituisciArticolo; startMenuScelta
      case 4 => cercaArticolo; startMenuScelta
      case 5 => inserisciArticolo; startMenuScelta
      case 6 => rimuoviArticolo; startMenuScelta
    }
  }

  private def visualizzaLibreria = {
    val menuVisLib: String =
      "*******************************************************************\n" +
        "***\t\t\t    Fai la tua scelta:\t\t\t***\n" +
        "*** 1] Visualizza tutti gli articoli\t\t\t\t***\n" +
        "*** 2] Visualizza libri \t\t\t\t\t***\n" +
        "*** 3] Visualizza riviste\t\t\t\t\t***\n" +
        "*** 4] Visualizza audio\t\t\t\t\t\t***\n" +
        "***\t\t\t\t\t\t\t\t***\n" +
        "*** 0] Torna al menu principale\t\t\t\t\t***\n" +
        "***\t\t\t\t\t\t\t\t***\n" +
        "*******************************************************************";

    println(menuVisLib)
    println()

    var scelta: Int = -1;
    while (!(scelta >= 0 && scelta <= 4)) {
      print("Scelta >> ")
      scelta = scala.io.StdIn.readInt()
    }

    println("\n")

    scelta match {
      case 0 =>
      case 1 => visualizzaTuttiArticoli; backToMenuScelta
      case 2 => visualizzaLibri; backToMenuScelta
      case 3 => visualizzaRiviste; backToMenuScelta
      case 4 => visualizzaAudio; backToMenuScelta
    }

 
  }

  private def visualizzaTuttiArticoli = {
    val titolo: String =
      "*************** Articoli presenti nella libreria:  ****************";
    println(titolo)

    LibreriaManager.printAllArticoli;

    println()
  }

  private def visualizzaRiviste = {
    val titolo: String =
      "*************** Riviste presenti nella libreria:  *****************";
    println(titolo)

    LibreriaManager.printSottocategoria[Rivista](TipoArticolo.RIVISTA);

    println();

  }

  private def visualizzaAudio = {
    val titolo: String =
      "*************** Audio presenti nella libreria:  *******************";
    println(titolo)

    LibreriaManager.printSottocategoria[Audio](TipoArticolo.AUDIO);

    println();

  }

  private def visualizzaLibri = {
    val titolo: String =
      "***************** Libri presenti nella libreria:  *****************";
    println(titolo)

    LibreriaManager.printSottocategoria[Libro](TipoArticolo.LIBRO);

    println();
  }

  private def noleggiaArticolo = {
    print("Inserisci ID dell'articolo che si vuole noleggiare >> ")
    val articoloID = scala.io.StdIn.readInt()
    println()

    try {
      LibreriaManager.noleggiaArticolo(articoloID);
    } catch {
      case e: ArticoloNotFoundException =>
        println("Errore. Articolo con ID_" + articoloID + " non trovato.")
    }

    println("\n")

    backToMenuScelta
  }

  private def restituisciArticolo = {
    print("Inserisci ID dell'articolo che si vuole restituire >> ")
    val articoloID = scala.io.StdIn.readInt()
    println()

    try {
      LibreriaManager.restituisciArticolo(articoloID);
    } catch {
      case e: ArticoloNotFoundException =>
        println("Errore. Articolo con ID_" + articoloID + " non trovato.")
    }

    println("\n")

    backToMenuScelta

  }

  private def cercaArticolo = {
    val menuCerca: String =
      "*******************************************************************\n" +
        "***\t\t\t    Fai la tua scelta:\t\t\t***\n" +
        "*** 1] Cerca per ID\t\t\t\t\t\t***\n" +
        "*** 2] Cerca per nome\t\t\t\t\t\t***\n" +
        "***\t\t\t\t\t\t\t\t***\n" +
        "*** 0] Torna al menu principale\t\t\t\t\t***\n" +
        "***\t\t\t\t\t\t\t\t***\n" +
        "*******************************************************************";

    println(menuCerca)
    println()

    var scelta: Int = -1;
    while (!(scelta >= 0 && scelta <= 2)) {
      print("Scelta >> ")
      scelta = scala.io.StdIn.readInt()
    }

    scelta match {
      case 0 =>
      case 1 => {
        print("Inserisci ID dell'articolo che si vuole cercare >> ")
        val articoloID = scala.io.StdIn.readInt()
        println()

        LibreriaManager.printArticolo(articoloID);
        backToMenuScelta
      }

      case 2 =>
        {
          print("Inserisci nome dell'articolo che si vuole cercare >> ")
          val nomeArticolo = scala.io.StdIn.readLine().asInstanceOf[String]
          println()

          LibreriaManager.printArticolo(nomeArticolo);
          backToMenuScelta
        }

        println()
    }

   
  }

  private def inserisciArticolo = {
    val menuInserisci: String =
      "*******************************************************************\n" +
        "***\t\t\t    Fai la tua scelta:\t\t\t***\n" +
        "*** 1] Inserisci nuovo libro\t\t\t\t\t***\n" +
        "*** 2] Inserisci nuovo audio\t\t\t\t\t***\n" +
        "*** 3] Inserisci nuova rivista\t\t\t\t\t***\n" +
        "***\t\t\t\t\t\t\t\t***\n" +
        "*** 0] Termina il programma\t\t\t\t\t***\n" +
        "***\t\t\t\t\t\t\t\t***\n" +
        "*******************************************************************";

    println(menuInserisci)
    println()

    var scelta: Int = -1;
    while (!(scelta >= 0 && scelta <= 3)) {
      print("Scelta >> ")
      scelta = scala.io.StdIn.readInt()
    }

    scelta match {
      case 0 => 
      case 1 => inserisciLibro
      case 2 => inserisciAudio
      case 3 => inserisciRivista

    }
  }

  private def inserisciLibro = {
    var titolo: String = ""
    var autore: String = ""
    var casaEditrice: String = ""
    var numPagine: Int = 0

    print("Titolo >>")
    titolo = scala.io.StdIn.readLine().asInstanceOf[String]
    print("Autore >>")
    autore = scala.io.StdIn.readLine().asInstanceOf[String]
    print("Casa editrice >>")
    casaEditrice = scala.io.StdIn.readLine().asInstanceOf[String]
    print("Numero pagine >>")
    numPagine = scala.io.StdIn.readInt()
    
    println()

    val lib: Libro = new Libro(titolo, autore, casaEditrice, numPagine)

    LibreriaManager.aggiungiArticolo(lib);

    println("Il seguente libro è stato aggiunto correttamente alla libreria:\n")
    LibreriaManager.printArticolo(titolo);

    println()
    backToMenuScelta

  }

  private def inserisciRivista = {

    var titolo: String = ""
    var data: String = ""
    var autore: String = ""
    var casaEditrice: String = ""

    print("Titolo >>")
    titolo = scala.io.StdIn.readLine().asInstanceOf[String]
    print("Autore >>")
    autore = scala.io.StdIn.readLine().asInstanceOf[String]
    print("Casa editrice >>")
    casaEditrice = scala.io.StdIn.readLine().asInstanceOf[String]
    
    println()

    val riv: Rivista = new Rivista(titolo, casaEditrice);

    LibreriaManager.aggiungiArticolo(riv);

    println("La seguente rivista è stata aggiunta correttamente alla libreria:\n")
    LibreriaManager.printArticolo(titolo);

    println()
    backToMenuScelta;

  }

  private def inserisciAudio = {

    var titolo: String = ""
    var autore: String = ""
    var casaDiscografica: String = ""

    print("Titolo >>")
    titolo = scala.io.StdIn.readLine().asInstanceOf[String]
    print("Autore >>")
    autore = scala.io.StdIn.readLine().asInstanceOf[String]
    print("Casa discografica >>")
    casaDiscografica = scala.io.StdIn.readLine().asInstanceOf[String]
    
    println()

    val aud: Audio = new Audio(titolo, autore, casaDiscografica);

    LibreriaManager.aggiungiArticolo(aud);

    println("Il seguente audio è stato aggiunto correttamente alla libreria:\n")
    LibreriaManager.printArticolo(titolo);

    println()
    backToMenuScelta

  }

  private def rimuoviArticolo = {
    print("Inserisci ID dell'articolo che si vuole rimuovere >> ")
    val articoloID = scala.io.StdIn.readInt()

    println()

    try {
      LibreriaManager.rimuoviArticolo(articoloID);
    } catch {
      case e: ArticoloNotFoundException =>
        println("Errore. Articolo con ID_" + articoloID + " non trovato.")
    }

    println("\n")

    backToMenuScelta
  }

  private def backToMenuScelta = {
    var scelta: Int = -1;
    while (scelta != 0) {
      print("0 per tornare al menu principale >> ")
      scelta = scala.io.StdIn.readInt()
    }

    println()
  }

}