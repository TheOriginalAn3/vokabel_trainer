import speech_recognition as sr
import sys

# obtain audio from the microphone
r = sr.Recognizer()
with sr.Microphone() as source:
    audio = r.listen(source)
    try:
        # recognize speech using Google Speech Recognition
        transcription = r.recognize_google(audio)
        
        # transcription = r.recognize_google(audio, language='de-DE') #For german recognition
        # transcription = r.recognize_google(audio, language='en-US') # For American English recognition
        
        sys.stdout.write(transcription)
        sys.stdout.flush
    except sr.UnknownValueError:
        sys.stdout.write("Google Speech Recognition could not understand audio")
        sys.stdout.flush
    except sr.RequestError as e:
        sys.stdout.write("Could not request results from Google Speech Recognition service")
        sys.stdout.flush
sys.exit(0)