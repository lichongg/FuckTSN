package javax.mail.event;

import javax.mail.Message;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class MessageChangedEvent extends MailEvent {
    public static final int ENVELOPE_CHANGED = 2;
    public static final int FLAGS_CHANGED = 1;
    private static final long serialVersionUID = -4974972972105535108L;
    protected transient Message msg;
    protected int type;

    @Override // javax.mail.event.MailEvent
    public void dispatch(Object obj) {
        ((MessageChangedListener) obj).messageChanged(this);
    }

    public Message getMessage() {
        return this.msg;
    }

    public int getMessageChangeType() {
        return this.type;
    }

    public MessageChangedEvent(Object obj, int i6, Message message) {
        super(obj);
        this.msg = message;
        this.type = i6;
    }
}
