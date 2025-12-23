package javax.mail.event;

import javax.mail.Folder;
import javax.mail.Message;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class MessageCountEvent extends MailEvent {
    public static final int ADDED = 1;
    public static final int REMOVED = 2;
    private static final long serialVersionUID = -7447022340837897369L;
    protected transient Message[] msgs;
    protected boolean removed;
    protected int type;

    @Override // javax.mail.event.MailEvent
    public void dispatch(Object obj) {
        if (this.type == 1) {
            ((MessageCountListener) obj).messagesAdded(this);
        } else {
            ((MessageCountListener) obj).messagesRemoved(this);
        }
    }

    public Message[] getMessages() {
        return this.msgs;
    }

    public int getType() {
        return this.type;
    }

    public boolean isRemoved() {
        return this.removed;
    }

    public MessageCountEvent(Folder folder, int i6, boolean z5, Message[] messageArr) {
        super(folder);
        this.type = i6;
        this.removed = z5;
        this.msgs = messageArr;
    }
}
