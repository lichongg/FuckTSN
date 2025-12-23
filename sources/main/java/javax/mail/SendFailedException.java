package javax.mail;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class SendFailedException extends MessagingException {
    private static final long serialVersionUID = -6457531621682372913L;
    protected transient Address[] invalid;
    protected transient Address[] validSent;
    protected transient Address[] validUnsent;

    public SendFailedException() {
    }

    public SendFailedException(String str) {
        super(str);
    }

    public Address[] getInvalidAddresses() {
        return this.invalid;
    }

    public Address[] getValidSentAddresses() {
        return this.validSent;
    }

    public Address[] getValidUnsentAddresses() {
        return this.validUnsent;
    }

    public SendFailedException(String str, Exception exc) {
        super(str, exc);
    }

    public SendFailedException(String str, Exception exc, Address[] addressArr, Address[] addressArr2, Address[] addressArr3) {
        super(str, exc);
        this.validSent = addressArr;
        this.validUnsent = addressArr2;
        this.invalid = addressArr3;
    }
}
