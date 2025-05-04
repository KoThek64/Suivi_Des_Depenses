package org.example

fun main() {
    val gestion = GestionnaireDepenses()

    while(true) {
        println("\nMENU")
        println("1 - Ajouter une dépense")
        println("2 - Afficher les dépenses")
        println("3 - Afficher le total de toutes les dépenses")
        println("4 - Afficher le total des dépenses par catégorie")
        println("5 - Supprimer une dépense")
        println("6 - Quitter")

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
                println("Entrez la catégorie")
                val categorie = readln()
                println("Total des dépenses dans la catégorie $categorie : ${gestion.calculerTotalParCategorie(categorie)}")
            }

            "5" -> {
                gestion.supprimerDepense()
            }

            "6" -> {
                break
            }

            else -> println("Choix invalide veuillez recommencer")
        }
    }
}