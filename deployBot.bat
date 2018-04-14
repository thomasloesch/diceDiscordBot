if exist .\token.txt (
    java -jar .\target\rollbot-1.2-SNAPSHOT.jar -f .\token.txt
) else (
    Echo "Please provide a token file!"
)
