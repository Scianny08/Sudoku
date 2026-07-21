
import customtkinter as ctk
import bridge

# ==========================================
# CONFIGURAZIONE COSTANTI DI STILE (THEME)
# ==========================================
# Colori Principali
COLOR_BG_APP = "#240047"
COLOR_CARD_BG = "#1E1E2E"
COLOR_CARD_BORDER = "#7700FF"
COLOR_TEXT_PRIMARY = "#FFFFFF"
COLOR_TEXT_SECONDARY = "#A6ADC8"

# Colori Pulsanti
COLOR_BTN_PRIMARY = "#5800B1"
COLOR_BTN_PRIMARY_HOVER = "#420085"
COLOR_BTN_CUSTOM_BORDER = "#5D96FF"

# Padding Standard per pulizia layout
PAD_OUTER = 20
PAD_INNER = 40
PAD_ELEM_Y = 8

# ==========================================
# INIZIALIZZAZIONE FINESTRA
# ==========================================
app = ctk.CTk()
app.title("Sudoku")
app.geometry("600x500")
app.minsize(400, 300)
app.configure(fg_color=COLOR_BG_APP)


def avvia_gui():
    menu_iniziale()
    app.mainloop()


# ==========================================
# SCHERMATA: MENU INIZIALE
# ==========================================
def menu_iniziale():
    for widget in app.winfo_children():
        widget.destroy()

    # Scheda Centrale (Card)
    card_frame = ctk.CTkFrame(
        master=app,
        fg_color=COLOR_CARD_BG,
        corner_radius=15,
        border_width=2,
        border_color=COLOR_CARD_BORDER,
    )
    card_frame.pack(expand=True, padx=PAD_INNER, pady=PAD_OUTER)

    # --- INTESTAZIONE (Sempre Visibile) ---
    nome_gioco = ctk.CTkLabel(
        master=card_frame,
        text="SUDOKU!",
        text_color=COLOR_TEXT_PRIMARY,
        font=("Helvetica", 32, "bold"),
    )
    nome_gioco.pack(padx=PAD_INNER, pady=(25, 5))

    autore = ctk.CTkLabel(
        master=card_frame,
        text="programmed with love by Scianny",
        text_color=COLOR_TEXT_SECONDARY,
        font=("Helvetica", 12, "italic"),
    )
    autore.pack(padx=PAD_INNER, pady=(0, 15))

    # --- CONTENITORE DINAMICO (Cambia contenuto) ---
    content_frame = ctk.CTkFrame(master=card_frame, fg_color="transparent")
    content_frame.pack(fill="both", expand=True, padx=PAD_OUTER, pady=(0, 15))

    btn_nuova_partita = ctk.CTkButton(
        master=content_frame,
        text="Nuova Partita",
        fg_color=COLOR_BTN_PRIMARY,
        hover_color=COLOR_BTN_PRIMARY_HOVER,
        text_color=COLOR_TEXT_PRIMARY,
        font=("Helvetica", 14, "bold"),
        height=40,
        corner_radius=10,
        command=lambda: difficolta(content_frame),
    )
    btn_nuova_partita.pack(padx=PAD_OUTER, pady=(10, 15), fill="x")


# ==========================================
# SCHERMATA: SELEZIONE DIFFICOLTÀ
# ==========================================
def difficolta(frame):
    for widget in frame.winfo_children():
        widget.destroy()

    # Titolo Sezione
    label = ctk.CTkLabel(
        master=frame,
        text="Scegli la Difficoltà",
        font=("Helvetica", 18, "bold"),
        text_color=COLOR_TEXT_PRIMARY,
    )
    label.pack(pady=(5, 15))

    # Lista Opzioni: [Testo, Colore, Hover, Colore Testo]
    opzioni_difficolta = [
        ["Facile", "#2FA572", "#288B60", "white"],
        ["Media", "#E5A900", "#C89400", "white"],
        ["Difficile", "#D32F2F", "#B71C1C", "white"],
    ]

    # Generazione Pulsanti Standard
    for testo, colore, hover_col, testo_col in opzioni_difficolta:
        btn = ctk.CTkButton(
            master=frame,
            text=testo,
            fg_color=colore,
            hover_color=hover_col,
            text_color=testo_col,
            font=("Helvetica", 15, "bold"),
            height=42,
            corner_radius=8,
            command=lambda t=testo: print(f"Selezionata: {t}"),
        )
        btn.pack(padx=PAD_OUTER, pady=PAD_ELEM_Y, fill="x")

    # Pulsante Personalizzata (Outline)
    btn_custom = ctk.CTkButton(
        master=frame,
        text="⚙️ Personalizzata",
        fg_color="transparent",
        border_color=COLOR_BTN_CUSTOM_BORDER,
        border_width=2,
        hover_color=("#E8F0FE", "#1E2A3A"),
        text_color=COLOR_BTN_CUSTOM_BORDER,
        font=("Helvetica", 14, "bold"),
        height=40,
        corner_radius=20,
        command=lambda: print("Selezionata: Personalizzata"),
    )
    btn_custom.pack(padx=PAD_OUTER, pady=(12, 10), fill="x")
