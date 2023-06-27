import speech_recognition as sr
import sys
import socket

# ******************* DEIN CODE COMMT HIER *******************
#platzhalter ändern


host = "localhost"
port = 65432

with socket.socket(socket.AF_INET, socket.SOCK_STREAM)as sock:
    sock.connect((host, port))
    



# obtain audio from the microphone
r = sr.Recognizer()
with sr.Microphone() as source:
    audio = r.listen(source)
    try:
        # recognize speech using Google Speech Recognition
        transcription = r.recognize_google(audio, language='en-US') # For American English recognition
        print(transcription)
        sock.sendall(b"Hallo Andrei")
    except sr.UnknownValueError:
        print("Google Speech Recognition could not understand audio")
        
    except sr.RequestError as e:
        print("Could not request results from Google Speech Recognition service")
        # ******************* DEIN CODE KOMMT HIER *******************
        
    
    socket.close()  
sys.exit(0) # Programm schliesst von selber. Mit java neustarten falls nötig
# ******************* HIER NICHTS SCHREIBEN *******************
