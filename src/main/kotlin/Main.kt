package org.example

fun main() {
    val gestion = GestionnaireDepenses()

    println("Voulez vous récupérer les dépenses depuis un fichier CSV ? (oui/non)")

    if (readln() == "oui") {
        println("Entrez le chemin complet du fichier CSV en enlevant les guillemets")
        val chemin = readln()
        gestion.importerCSV(chemin)
    }

    while(true) {
        println("\nMENU")
        println("1 - Ajouter une dépense")
        println("2 - Afficher les dépenses")
        println("3 - Afficher le total de toutes les dépenses")
        println("4 - Afficher le total des dépenses par catégorie")
        println("5 - Supprimer une dépense")
        println("6 - Sauvegarder les dépenses dans un fichier CSV")
        println("7 - Quitter")

        when (readLine()){
            "1" -> {
                val montant = gestion.trouveMontant()
                println("Choisissez la catégorie")
                val categorie = gestion.choixCategorie()
                val date = gestion.choixDate()
                gestion.ajouterDepense(Depense(montant, categorie, date))
            }

            "2" -> {
                gestion.afficherDepense()
            }

            "3" -> {
                println("Total des dépenses : ${gestion.calculerTotal()}")
            }

            "4" ->{
                gestion.calculerTotalParCategorie()
            }

            "5" -> {
                gestion.supprimerDepense()
            }

            "6" -> {
                gestion.sauvegarderFichier()
            }

            "7" -> {
                break
            }

            else -> println("Choix invalide veuillez recommencer")
        }
    }
}