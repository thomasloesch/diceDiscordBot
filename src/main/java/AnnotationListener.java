import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.ReadyEvent;
import sx.blah.discord.handle.impl.events.guild.channel.message.MentionEvent;

public class AnnotationListener {
    @EventSubscriber
    public void onReadyEvent(ReadyEvent event) {
    	System.out.println("Starting Bot...");
    }

    @EventSubscriber
    public void onMessageReceivedEvent(MentionEvent event) {
        System.out.println(event.getMessage());
        
    }
}
