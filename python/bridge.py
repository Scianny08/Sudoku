import jpype

def motore_gioco():
    return jpype.JClass("MotoreGioco")

def partita():
    return jpype.JClass("Partita")

def tempo():
    return jpype.JClass("Tempo")
