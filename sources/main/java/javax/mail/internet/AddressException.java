package javax.mail.internet;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class AddressException extends ParseException {
    private static final long serialVersionUID = 9134583443539323120L;
    protected int pos;
    protected String ref;

    public AddressException() {
        this.ref = null;
        this.pos = -1;
    }

    public int getPos() {
        return this.pos;
    }

    public String getRef() {
        return this.ref;
    }

    @Override // javax.mail.MessagingException, java.lang.Throwable
    public String toString() {
        String messagingException = super.toString();
        if (this.ref == null) {
            return messagingException;
        }
        String str = String.valueOf(messagingException) + " in string ``" + this.ref + "''";
        if (this.pos < 0) {
            return str;
        }
        return String.valueOf(str) + " at position " + this.pos;
    }

    public AddressException(String str) {
        super(str);
        this.ref = null;
        this.pos = -1;
    }

    public AddressException(String str, String str2) {
        super(str);
        this.pos = -1;
        this.ref = str2;
    }

    public AddressException(String str, String str2, int i6) {
        super(str);
        this.ref = str2;
        this.pos = i6;
    }
}
