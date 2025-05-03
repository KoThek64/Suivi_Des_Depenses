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
        println("Entrez le montant")
        val montant = readLine()!!
        try {
            montant.toDouble()
        } catch (e: NumberFormatException) {
            println("Le format du montant que vous avez donné n'est pas correct")
            return trouveMontant()
        }
        var result = montant.toDouble()
        var bool = false
        while (bool == false){
            if (result <= 0){
                println("La valeur donnée n'est pas positive")
                println("Entrez le montant")
                bool = false
                result = readLine()!!.toDouble()
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

        val categorie : String = ""

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

            when(readLine()!!) {
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
            println("Entrez la date en format jj/mm/aaaa")
            val date = readLine()!!

            try {
                LocalDate.parse(date, formatter)
                return date
            } catch (e : DateTimeParseException) {
                println("La date saisie n'est pas valide veuillez recommencer")
            }
        }
    }

    fun afficherDepense(){
        if (depenses.isEmpty()){
            println("Aucune dépense enregistrée")
        } else {
            for (i in 0 until depenses.size){
                println("Montant : ${depenses[i].montant}, Catégorie : ${depenses[i].categorie}, Date: ${depenses[i].date}")
            }
        }
    }

    fun calculerTotal() : Double {
        var total = 0.0
        for (i in 0 until depenses.size){
            total += depenses[i].montant
        }
        return total
    }

    fun calculerTotalParCategorie(cat : String) : Double {
        return depenses.filter { it.categorie == cat }.sumOf { it.montant }
    }

    fun supprimerDepense(dep : Depense){
        depenses.remove(dep)
    }


}