package org.example

import javafx.application.Application
import javafx.beans.property.SimpleDoubleProperty
import javafx.beans.property.SimpleStringProperty
import javafx.scene.control.Button
import javafx.scene.control.TableCell
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import javafx.stage.Stage


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

    }


}

fun main() {
    Application.launch(GestionnaireDepensesGUI::class.java)
}