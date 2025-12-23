package javax.mail.event;

import javax.mail.Store;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class StoreEvent extends MailEvent {
    public static final int ALERT = 1;
    public static final int NOTICE = 2;
    private static final long serialVersionUID = 1938704919992515330L;
    protected String message;
    protected int type;

    @Override // javax.mail.event.MailEvent
    public void dispatch(Object obj) {
        ((StoreListener) obj).notification(this);
    }

    public String getMessage() {
        return this.message;
    }

    public int getMessageType() {
        return this.type;
    }

    public StoreEvent(Store store, int i6, String str) {
        super(store);
        this.type = i6;
        this.message = str;
    }
}
