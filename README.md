# 🎮 Sudoku - Java

Un'implementazione del classico gioco **Sudoku** sviluppata in Java, con interfaccia CLI.

---

## 📋 Descrizione

Il progetto consiste in un'applicazione desktop che permette all'utente di giocare a Sudoku. Il programma gestisce la generazione della griglia, il controllo della validità delle mosse e la verifica della soluzione finale.

---

## 📁 Struttura del progetto

```
sudoku-java/
├── src/
│   └── main/
│       └── java/
│           └── ...        # Classi Java del progetto
├── .gitignore
└── README.md
```

---

## ▶️ Come eseguire il progetto

### Prerequisiti
- Java JDK 17 o superiore installato

### Compilazione ed esecuzione

```bash
# Clona la repository
git clone https://github.com/Scianny08/sudoku-java.git

# Entra nella cartella
cd sudoku-java

# Compila il progetto
javac -d out src/main/java/**/*.java

# Avvia il gioco
java -cp out Main
```

---

## 🎯 Come si gioca

1. Avvia l'applicazione
2. Viene generata automaticamente una griglia 9x9 con alcuni numeri precompilati
3. Inserisci i numeri mancanti rispettando le regole del Sudoku:
   - Ogni riga deve contenere i numeri da 1 a 9 senza ripetizioni
   - Ogni colonna deve contenere i numeri da 1 a 9 senza ripetizioni
   - Ogni sottoquadrato 3x3 deve contenere i numeri da 1 a 9 senza ripetizioni
4. Il gioco segnala le mosse non valide
5. Completa la griglia per vincere!

---

## 👤 Autore

**Scianny08**  
Progetto realizzato nell'ambito del percorso universitario presso **UNICA** (Università degli Studi di Cagliari).

---

## 📄 Licenza

Questo progetto è a scopo didattico.
