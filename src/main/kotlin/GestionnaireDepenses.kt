package org.example

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