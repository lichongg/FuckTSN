package javax.mail;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class MessageContext {
    private Part part;

    public Message getMessage() {
        try {
            return getMessage(this.part);
        } catch (MessagingException unused) {
            return null;
        }
    }

    private static Message getMessage(Part part) throws MessagingException {
        while (part != null) {
            if (part instanceof Message) {
                return (Message) part;
            }
            Multipart parent = ((BodyPart) part).getParent();
            if (parent == null) {
                return null;
            }
            part = parent.getParent();
        }
        return null;
    }

    public Part getPart() {
        return this.part;
    }

    public MessageContext(Part part) {
        this.part = part;
    }

    public Session getSession() {
        Message message = getMessage();
        if (message != null) {
            return message.session;
        }
        return null;
    }
}
