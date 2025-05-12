package org.example

import javafx.application.Application
import javafx.beans.property.SimpleDoubleProperty
import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.*
import javafx.scene.layout.*
import javafx.stage.Stage
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.ResolverStyle


class GestionnaireDepensesGUI : Application() {
    private val gestion = GestionnaireDepenses()
    private val tableView = TableView<Depense>()

    override fun start(stage : Stage?) {
        stage?.title = "Gestionnaire des dépenses"

        val montantCol = TableColumn<Depense, Number>("Montant")
        montantCol.setCellValueFactory { SimpleDoubleProperty(it.value.montant) }

        val categorieCol = TableColumn<Depense, String>("Catégorie")
        categorieCol.setCellValueFactory { SimpleStringProperty(it.value.categorie) }

        val dateCol = TableColumn<Depense, String>("Date")
        dateCol.setCellValueFactory { SimpleStringProperty(it.value.date) }

        montantCol.setCellFactory { column ->
            object : TableCell<Depense, Number>() {
                override fun updateItem(item: Number?, empty: Boolean) {
                    super.updateItem(item, empty)
                    if (empty || item == null) {
                        text = null
                    } else {
                        text = String.format("%.2f €", item.toDouble())
                    }
                }
            }
        }

        tableView.columns.addAll(montantCol, categorieCol, dateCol)
        tableView.columnResizePolicy = TableView.CONSTRAINED_RESIZE_POLICY

        val btnAjouter = Button("Ajouter une dépense")
        val btnSupprimer = Button("Supprimer une dépense")
        val btnTotal = Button("Afficher le total")
        val btnTotalParCat = Button("Total par catégorie")
        val btnQuitter = Button("Quitter")

        val buttonBox = VBox(10.0)
        buttonBox.children.addAll(btnAjouter, btnSupprimer, btnTotal, btnTotalParCat, btnQuitter)

        val root = BorderPane()
        root.left = buttonBox
        root.center = tableView
        BorderPane.setMargin(tableView, Insets(10.0))

        btnAjouter.setOnAction {
            val montant = gestion.trouveMontant()
            println("Choisissez la catégorie")
            val categorie = gestion.choixCategorie()
            val date = gestion.choixDate()
            gestion.ajouterDepense(Depense(montant, categorie, date))
        }
        btnSupprimer.setOnAction {
            gestion.supprimerDepense()
        }
        btnTotal.setOnAction {
            println("Le total de toutes les dépenses est de ${gestion.calculerTotal()}")
        }
        btnTotalParCat.setOnAction {
            gestion.calculerTotalParCategorie()
        }
        btnQuitter.setOnAction {
            stage?.close()
        }

        val scene = Scene(root, 800.0, 600.0)
        stage?.scene = scene
        stage?.show()

        mettreAJourTableau()

    }

    private fun afficherDialogueAjout(){
        val dialog = Stage()
        dialog.title = "Ajouter une dépense"

        val gridPane = GridPane()
        gridPane.padding = Insets(10.0)
        gridPane.hgap = 10.0
        gridPane.vgap = 10.0

        val textMontant = TextField()
        val comboCategorie = ComboBox<String>()
        comboCategorie.items.addAll(gestion.categories)
        val datePicker = DatePicker()
        datePicker.value = LocalDate.now()

        gridPane.add(Label("Montant :"), 0, 0)
        gridPane.add(textMontant, 1, 0)
        gridPane.add(Label("Catégorie :"), 0, 1)
        gridPane.add(comboCategorie, 1, 1)
        gridPane.add(Label("Date :"), 0, 2)
        gridPane.add(datePicker, 1, 2)

        val btnBox = HBox(10.0)
        btnBox.alignment = Pos.CENTER_RIGHT

        val btnValider = Button("Valider")
        val btnAnnuler = Button("Annuler")
        btnBox.children.addAll(btnValider, btnAnnuler)

        btnValider.setOnAction {
            try {
                val montant = textMontant.text.toDouble()
                val categorie = comboCategorie.value
                val date = datePicker.value.format(DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT))

                if (montant > 0 && categorie != null && date != null) {
                    gestion.ajouterDepense(Depense(montant,categorie,date))
                    mettreAJourTableau()
                    dialog.close()
                } else {
                    afficherErreur("Veuillez remplir tout les champs correctement")
                }
            } catch (_: NumberFormatException) {
                afficherErreur("Le montant doit être un nombre valide")
            }
        }
        btnAnnuler.setOnAction { dialog.close() }

        val vbox = VBox(10.0)
        vbox.children.addAll(gridPane, btnBox)
        vbox.padding = Insets(10.0)

        dialog.scene = Scene(vbox)
        dialog.showAndWait()
    }

    private fun mettreAJourTableau() {
        tableView.items.clear()
        tableView.items.addAll(gestion.depenses)
    }

    private fun afficherErreur(message : String){
        val alert = Alert(Alert.AlertType.ERROR)
        alert.title = "Erreur"
        alert.headerText = null
        alert.contentText = message
        alert.showAndWait()
    }


}

fun main() {
    Application.launch(GestionnaireDepensesGUI::class.java)
}