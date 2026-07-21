import os
import jpype
import gui

# Cartella dove si trova main.py (cioè "python/")
BASE_DIR = os.path.dirname(os.path.abspath(__file__))

# Risali di 1 livello (esci da python/) ed entra in java/bin
CLASSPATH = os.path.join(BASE_DIR, "..", "java", "bin")

jpype.startJVM(classpath=[CLASSPATH])

gui.avvia_gui()
