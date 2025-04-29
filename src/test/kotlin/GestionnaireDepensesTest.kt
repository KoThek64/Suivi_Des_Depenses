import org.example.Depense
import org.example.GestionnaireDepenses
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class GestionnaireDepensesTest {

 private val gestionnaire = GestionnaireDepenses()

 @Test
 fun `test ajouter depense`() {
  // Ajouter une dépense
  val depense = Depense(50.0, "Nourriture", "25/04/2025")
  gestionnaire.ajouterDepense(depense)

  // Vérifier si la dépense a bien été ajoutée
  assertEquals(1, gestionnaire.depenses.size)
  assertTrue(gestionnaire.depenses.contains(depense))
 }

 @Test
 fun `test calculer total des depenses`() {
  // Ajouter des dépenses
  gestionnaire.ajouterDepense(Depense(50.0, "Nourriture", "25/04/2025"))
  gestionnaire.ajouterDepense(Depense(20.0, "Loisirs", "26/04/2025"))

  // Vérifier si le total est correct
  assertEquals(70.0, gestionnaire.calculerTotal())
 }

 @Test
 fun `test calculer total par categorie`() {
  // Ajouter des dépenses
  gestionnaire.ajouterDepense(Depense(50.0, "Nourriture", "25/04/2025"))
  gestionnaire.ajouterDepense(Depense(30.0, "Nourriture", "26/04/2025"))
  gestionnaire.ajouterDepense(Depense(20.0, "Loisirs", "26/04/2025"))

  // Vérifier si le total pour "Nourriture" est correct
  assertEquals(80.0, gestionnaire.calculerTotalParCategorie("Nourriture"))

  // Vérifier si le total pour "Loisirs" est correct
  assertEquals(20.0, gestionnaire.calculerTotalParCategorie("Loisirs"))
 }

 @Test
 fun `test supprimer depense`() {
  // Ajouter une dépense
  val depense = Depense(50.0, "Nourriture", "25/04/2025")
  gestionnaire.ajouterDepense(depense)

  // Vérifier que la dépense est présente
  assertEquals(1, gestionnaire.depenses.size)

  // Supprimer la dépense
  gestionnaire.supprimerDepense(depense)

  // Vérifier que la dépense a bien été supprimée
  assertEquals(0, gestionnaire.depenses.size)
 }

 @Test
 fun `test afficher depenses vide`() {
  // Vérifier que la liste des dépenses est vide
  gestionnaire.afficherDepense()
  // Il n'y a pas de dépenses, donc rien ne devrait s'afficher, mais c'est plus pour vérifier le comportement
 }

 @Test
 fun `test afficher depenses avec donnees`() {
  // Ajouter des dépenses
  gestionnaire.ajouterDepense(Depense(50.0, "Nourriture", "25/04/2025"))
  gestionnaire.ajouterDepense(Depense(20.0, "Loisirs", "26/04/2025"))

  // Vérifier l'affichage des dépenses
  gestionnaire.afficherDepense()
  // Cette méthode affiche directement, donc ici il faut s'assurer visuellement que l'affichage est correct.
  // Pour automatiser cela, il faudrait rediriger la sortie, mais pour le moment, ça sert à tester visuellement.
 }
}
