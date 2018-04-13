# diceDiscordBot

Before attempting to deploy the bot create an app on discord's website in order to get a token for your bot. There is plenty of documentation online about how to do this, so I won't go into too many details here. Once you have the token, create a file named *token.txt* and place it in the same dir as the deploy scripts. Once this is in place you should be good to deploy the bot. 

To deploy this bot execute the following:

```
mvn package
deployBot.bat (or deployBot.sh on linux)
```
