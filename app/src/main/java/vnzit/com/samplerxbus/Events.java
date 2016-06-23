package vnzit.com.samplerxbus;

/**
 * Created by sh on 6/23/16.
 */
public class Events {
    private Events(){}

    public static class Message {
        public final String message;

        public Message(String message) {
            this.message = message;
        }
    }
}
