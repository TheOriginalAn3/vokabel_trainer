import os
import speech_recognition as sr
import sys
import socket

# ******************* DEIN CODE COMMT HIER *******************
#platzhalter ändern


host = "localhost"
port = 65432
transcription = ""

# DEBUG: Da keine Konsole zu verfügung
with open('running.txt', 'w') as f:
    f.write('If you see this the script isnt running as intended')

with socket.socket(socket.AF_INET, socket.SOCK_STREAM)as sock:
    os.remove('running.txt')
    sock.bind((host, port))
    sock.listen()
    conn, addr = sock.accept()
    with conn:
        print('Connected by', addr)
        
        # # Eingabe (Java -> Python)
        # data = conn.recv(1024)
        # print(data.decode())   
        
        # Audio vom Mikrofon erhalten
        r = sr.Recognizer()
        with sr.Microphone() as source:
            audio = r.listen(source)
            try:
                # Sprache erkennen mit Google Speech Recognition
                transcription = r.recognize_google(audio, language='en-US') # For English (American) recognition
                # DEBUG
                # f.write(transcription)
                conn.sendall(bytes(transcription, 'utf-8')) # type: ignore
            except sr.UnknownValueError:
                # DEBUG
                # f.write("Google Speech Recognition could not understand audio")
                conn.sendall(bytes("Google Speech Recognition could not understand audio", 'utf-8'))
                
            except sr.RequestError as e:
                # DEBUG
                # f.write("Could not request results from Google Speech Recognition service")
                conn.sendall(bytes("Could not request results from Google Speech Recognition service", 'utf-8'))
            
            socket.close()   # type: ignore
        sys.exit(0) # Programm schliesst von selber. Mit java neustarten falls nötig
        # ******************* HIER NICHTS SCHREIBEN *******************
        
    



