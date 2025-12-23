package javax.mail.event;

import java.util.EventObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class MailEvent extends EventObject {
    private static final long serialVersionUID = 1846275636325456631L;

    public abstract void dispatch(Object obj);

    public MailEvent(Object obj) {
        super(obj);
    }
}
