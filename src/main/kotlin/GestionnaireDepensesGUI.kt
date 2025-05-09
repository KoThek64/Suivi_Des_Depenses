package org.example

import java.awt.BorderLayout
import javax.swing.JFrame
import javax.swing.JTable
import javax.swing.table.DefaultTableModel

class GestionnaireDepensesGUI : JFrame() {
    private val gestion = GestionnaireDepenses()
    private val tableModel = DefaultTableModel()
    private val table = JTable(tableModel)

    private val categories = gestion.categories

    init {
        // Configuration de la fenêtre principale
        title = "Gestionnaire de Dépenses"
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setSize(800, 600)
        layout = BorderLayout(10, 10)
    }
}