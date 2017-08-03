package rollBot;
import sx.blah.discord.api.*;
import sx.blah.discord.api.events.EventDispatcher;

public class Main {
    public static void main(String[] args) {
        IDiscordClient client = createClient(args[0], true);
        EventDispatcher dispatcher = client.getDispatcher();
        //dispatcher.registerListener(new InterfaceListener());
        dispatcher.registerListener(new AnnotationListener());
        
        
    }

    private static IDiscordClient createClient(String token, boolean login){
        ClientBuilder clientBuilder = new ClientBuilder();
        clientBuilder.withToken(token);
        try {
            if(login) {
                return clientBuilder.login();
            } else {
                return clientBuilder.build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
