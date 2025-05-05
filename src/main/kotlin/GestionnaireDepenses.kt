package org.example

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.time.format.ResolverStyle

class GestionnaireDepenses {
    val depenses = mutableListOf<Depense>()

    fun ajouterDepense(dep : Depense){
        depenses.add(dep)
    }

    fun trouveMontant() :  Double{
        println("\nEntrez le montant")
        val montant = readln()
        try {
            montant.toDouble()
        } catch (_: NumberFormatException) {
            println("Le format du montant que vous avez donné n'est pas correct")
            return trouveMontant()
        }
        var result = montant.toDouble()
        var bool = false
        while (bool == false){
            if (result <= 0){
                println("La valeur donnée n'est pas positive")
                println("\nEntrez le montant")
                bool = false
                result = readln().toDouble()
            } else {
                bool = true
            }
        }
        return result
    }

    fun choixCategorie() : String{
        val logement = "Logement"
        val alimentationResto = "Alimentation / Restaurant"
        val achatShopping = "Achat / Shopping"
        val voitureTransport = "Voiture / Transport"
        val retraitChequeVirement = "Retrait / Chèque / Virement"
        val loisirsSorties = "Loisirs / Sorties"
        val abonnement = "Abonnement"
        val banque = "Frais bancaires"
        val divers = "Divers"
        val esthethiqueSoins = "Esthethique / Soins"
        val impotsTaxes = "Impots / Taxes"
        val sante = "Santé"
        val scolariteEnfant = "Scolarité / Enfants"

        while (true) {
            println("\nCHOIX CATÉGORIE")
            println("1  - $logement")
            println("2  - $alimentationResto")
            println("3  - $achatShopping")
            println("4  - $voitureTransport")
            println("5  - $retraitChequeVirement")
            println("6  - $loisirsSorties")
            println("7  - $abonnement")
            println("8  - $banque")
            println("9  - $esthethiqueSoins")
            println("10 - $impotsTaxes")
            println("11 - $sante")
            println("12 - $scolariteEnfant")
            println("13 - $divers")

            when(readln()) {
                "1" -> return logement
                "2" -> return alimentationResto
                "3" -> return achatShopping
                "4" -> return voitureTransport
                "5" -> return retraitChequeVirement
                "6" -> return loisirsSorties
                "7" -> return abonnement
                "8" -> return banque
                "9" -> return esthethiqueSoins
                "10" -> return impotsTaxes
                "11" -> return sante
                "12" -> return scolariteEnfant
                "13" -> return divers

                else -> {
                    println("Choix invalide veuillez recommencer")
                }
            }
        }
    }

    fun choixDate() : String{
        val formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT)

        while (true) {
            println("\nEntrez la date en format jj/mm/aaaa")
            val date = readln()

            try {
                LocalDate.parse(date, formatter)
                return date
            } catch (_ : DateTimeParseException) {
                println("La date saisie n'est pas valide veuillez recommencer")
            }
        }
    }

    fun afficherDepense(){
        if (depenses.isEmpty()){
            println("\nAucune dépense enregistrée")
        } else {
            for (i in 0 until depenses.size){
                println("Montant : ${depenses[i].montant}, Catégorie : ${depenses[i].categorie}, Date: ${depenses[i].date}")
            }
        }
    }

    fun calculerTotal() : Double {
				if (depenses.isEmpty()){
            println("Aucune dépense enregistrée")
            return 0.0
        }
        var total = 0.0
        for (i in 0 until depenses.size){
            total += depenses[i].montant
        }
        return total
    }

    fun calculerTotalParCategorie() : Double {
        if (depenses.isEmpty()){
            println("Aucune dépense enregistrée")
            return 0.0
        }
        val cat = choixCategorie()
        var total = 0.0
        for (i in 0 until depenses.size){
            if (cat == depenses[i].categorie){
                total += depenses[i].montant
            }
        }

        println("Montant des dépenses dans la catégorie $cat : $total")
        return total
    }

    fun supprimerDepense(){
        if (depenses.isEmpty()){
            println("\nAucunes dépense n'a été enregistrée")
            return
        }
        println("\nChoisissez une dépense à supprimer")
        afficherDepense()
        println("Entrez son montant")
        val mont = readln().toDouble()
        println("Entrez sa categorie")
        val type = choixCategorie()
        println("Entrez la date de la dépense")
        val date = choixDate()
        for (i in 0 until depenses.size){
            if (mont == depenses[i].montant && type == depenses[i].categorie && date == depenses[i].date){
                depenses.remove(depenses[i])
                return
            } else {
                println("La dépense que vous avez choisi n'existe pas")
                return supprimerDepense()
            }
        }
    }


}