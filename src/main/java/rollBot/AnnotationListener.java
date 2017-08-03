package rollBot;
import java.util.Date;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;

import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.ReadyEvent;
import sx.blah.discord.handle.impl.events.guild.channel.message.MentionEvent;

public class AnnotationListener {
	Random rand;
	
	public AnnotationListener() {
		rand = new Random(new Date().getTime());
	}
	
    @EventSubscriber
    public void onReadyEvent(ReadyEvent event) {
    	System.out.println("Starting Bot...");
    }

    @EventSubscriber
    public void onMessageReceivedEvent(MentionEvent event) {
    	String message = event.getMessage().getContent();
        System.out.println(message);
               
        if(StringUtils.contains(message, "/roll"))
        event.getChannel().sendMessage(Integer.toString(rand.nextInt(20) + 1));
    }
}
