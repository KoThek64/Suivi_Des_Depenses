<h1 align="center">💸 Suivi Des Dépenses</h1>
<p align="center"><em>Application Kotlin de suivi et de visualisation de dépenses personnelles, disponible en version terminal et en version GUI JavaFX.</em></p>

<p align="center">
  <img src="https://img.shields.io/badge/Kotlin-7F52FF?logo=kotlin&logoColor=white" alt="Kotlin">
  <img src="https://img.shields.io/badge/JavaFX-007396?logo=java&logoColor=white" alt="JavaFX">
  <img src="https://img.shields.io/badge/Gradle-02303A?logo=gradle&logoColor=white" alt="Gradle">
  <img src="https://img.shields.io/badge/JDK-23-ED8B00?logo=openjdk&logoColor=white" alt="JDK 23">
  <img src="https://img.shields.io/badge/Architecture-MVVM-6DB33F" alt="MVVM">
</p>

---

## 📋 Contexte du projet

**Suivi Des Dépenses** est un projet personnel réalisé pour apprendre et pratiquer le développement Kotlin, en explorant à la fois les interfaces en ligne de commande et les interfaces graphiques avec JavaFX.

| | |
|---|---|
| **Type** | Projet personnel |
| **Auteur** | Mattys Lachaise |
| **Année** | 2025 |

---

## 💡 Présentation

**Suivi Des Dépenses** est une application de gestion de finances personnelles permettant de suivre, filtrer et analyser ses dépenses du quotidien. Elle existe en deux versions : une interface terminal (CLI) et une interface graphique (JavaFX).

### Fonctionnalités principales

- 🧾 **Ajout et suppression** de dépenses (montant, catégorie, date)
- 📅 **Tri par date** au format `jj/mm/aaaa`
- 🔍 **Filtrage et totaux** par catégorie
- 💾 **Sauvegarde locale** via fichiers CSV (import & export)
- 🖥️ **Double interface** : terminal (CLI) et fenêtre graphique (JavaFX)
- ✅ **Validation des données** : montant, date et catégorie vérifiés à la saisie

### Catégories disponibles

| # | Catégorie |
|---|-----------|
| 1 | Logement |
| 2 | Alimentation / Restaurant |
| 3 | Achat / Shopping |
| 4 | Voiture / Transport |
| 5 | Retrait / Chèque / Virement |
| 6 | Loisirs / Sorties |
| 7 | Abonnement |
| 8 | Frais bancaires |
| 9 | Esthétique / Soins |
| 10 | Impôts / Taxes |
| 11 | Santé |
| 12 | Scolarité / Enfants |
| 13 | Divers |

---

## 🖼️ Aperçu de l'application

### Version Terminal

| Screen 1 | Screen 2 | Screen 3 |
|----------|----------|----------|
| ![](assets/screenshot1.png) | ![](assets/screenshot2.png) | ![](assets/screenshot3.png) |

### Version Application (JavaFX)

| Screen 1 | Screen 2 | Screen 3 |
|----------|----------|----------|
| ![](assets/screenshot4.png) | ![](assets/screenshot5.png) | ![](assets/screenshot6.png) |

| Screen 4 | Screen 5 |
|----------|----------|
| ![](assets/screenshot7.png) | ![](assets/screenshot8.png) |

---

## 🛠️ Stack technique

| Composant | Technologie |
|-----------|-------------|
| **Langage** | Kotlin 2.1.10 |
| **Interface graphique** | JavaFX 24.0.1 |
| **Interface terminal** | CLI (Kotlin stdlib) |
| **Build tool** | Gradle 8.10 (Kotlin DSL) |
| **Runtime** | JDK 23 |
| **Persistance** | Fichiers CSV (import & export) |
| **Architecture** | MVVM |

---

## 📁 Architecture du projet

```
Suivi_Des_Depenses/
├── assets/                         # Captures d'écran (screenshot1-8.png)
├── gradle/                         # Gradle wrapper
├── src/
│   └── main/
│       └── kotlin/
│           ├── Depense.kt                  # Modèle de données (montant, catégorie, date)
│           ├── GestionnaireDepenses.kt     # Logique métier (ajout, suppression, filtrage, CSV)
│           ├── GestionnaireDepensesGUI.kt  # Interface graphique JavaFX
│           └── Main.kt                     # Interface terminal (CLI)
├── build.gradle.kts                # Configuration Gradle (Kotlin DSL)
├── settings.gradle.kts             # Nom du projet et dépôts
├── gradle.properties               # Propriétés Gradle
├── gradlew / gradlew.bat           # Scripts Gradle wrapper
├── .gitignore
└── LICENSE
```

| Fichier | Description |
|---------|-------------|
| `Depense.kt` | Data class représentant une dépense avec montant, catégorie et date |
| `GestionnaireDepenses.kt` | Cœur du projet : gestion des dépenses, calculs, import/export CSV |
| `Main.kt` | Interface en ligne de commande avec menu numéroté |
| `GestionnaireDepensesGUI.kt` | Interface JavaFX : tableau de bord, dialogues, boutons stylisés |

---

## 🚀 Installation & Lancement

### Prérequis

- [IntelliJ IDEA](https://www.jetbrains.com/idea/) (Community ou Ultimate)
- JDK 23+

### Étapes

```bash
# 1. Cloner le dépôt
git clone https://github.com/KoThek64/Suivi_Des_Depenses.git
```

1. **Ouvrir le projet** dans IntelliJ IDEA.

2. **Sélectionner le point d'entrée** en haut à droite avant de lancer :
   - `MainKt` → lance la **version terminal** (CLI)
   - `GestionnaireDepensesGUIKt` → lance la **version graphique** (JavaFX)

3. **Cliquer sur Run ▶️** pour démarrer l'application.

> **Note :** Gradle téléchargera automatiquement les dépendances au premier lancement.

---

## 🧑‍💻 Auteur

Développé par **Mattys Lachaise** — [mattys.contact@gmail.com](mailto:mattys.contact@gmail.com)

---

## 📃 Licence

Ce projet est distribué sous licence **MIT**. Vous êtes libre de l'utiliser, le modifier et le redistribuer.

---

<p align="center">
  Projet réalisé avec ❤️ pour apprendre le développement Kotlin
</p>
