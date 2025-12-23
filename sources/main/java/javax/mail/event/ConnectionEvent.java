package javax.mail.event;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class ConnectionEvent extends MailEvent {
    public static final int CLOSED = 3;
    public static final int DISCONNECTED = 2;
    public static final int OPENED = 1;
    private static final long serialVersionUID = -1855480171284792957L;
    protected int type;

    @Override // javax.mail.event.MailEvent
    public void dispatch(Object obj) {
        int i6 = this.type;
        if (i6 == 1) {
            ((ConnectionListener) obj).opened(this);
        } else if (i6 == 2) {
            ((ConnectionListener) obj).disconnected(this);
        } else if (i6 == 3) {
            ((ConnectionListener) obj).closed(this);
        }
    }

    public int getType() {
        return this.type;
    }

    public ConnectionEvent(Object obj, int i6) {
        super(obj);
        this.type = i6;
    }
}
