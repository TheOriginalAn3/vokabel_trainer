import os
import speech_recognition as sr
import sys
import socket

# ******************* DEIN CODE COMMT HIER *******************
#platzhalter ändern


host = "localhost"
port = 65432

with open('running.txt', 'w') as f:
    f.write('If you see this the script isnt running')

with socket.socket(socket.AF_INET, socket.SOCK_STREAM)as sock:
    os.remove('running.txt')
    sock.bind((host, port))
    sock.listen()
    conn, addr = sock.accept()
    with conn:
        print('Connected by', addr)
        data = conn.recv(1024)
        print(data.decode())   
        
        # obtain audio from the microphone
        r = sr.Recognizer()
        with sr.Microphone() as source:
            audio = r.listen(source)
            try:
                # recognize speech using Google Speech Recognition
                transcription = r.recognize_google(audio, language='en-US') # For American English recognition
                print(transcription)
                conn.sendall(bytes(transcription, 'utf-8'))
            except sr.UnknownValueError:
                print("Google Speech Recognition could not understand audio")
                
            except sr.RequestError as e:
                print("Could not request results from Google Speech Recognition service")
                # ******************* DEIN CODE KOMMT HIER *******************
                
            
            socket.close()  
        sys.exit(0) # Programm schliesst von selber. Mit java neustarten falls nötig
        # ******************* HIER NICHTS SCHREIBEN *******************
        
    



