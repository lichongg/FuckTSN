package javax.mail;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class MessagingException extends Exception {
    private static final long serialVersionUID = -7569192289819959253L;
    private Exception next;

    public MessagingException() {
        initCause(null);
    }

    @Override // java.lang.Throwable
    public synchronized Throwable getCause() {
        return this.next;
    }

    public synchronized Exception getNextException() {
        return this.next;
    }

    public synchronized boolean setNextException(Exception exc) {
        Exception exc2 = this;
        while ((exc2 instanceof MessagingException) && ((MessagingException) exc2).next != null) {
            try {
                exc2 = ((MessagingException) exc2).next;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (!(exc2 instanceof MessagingException)) {
            return false;
        }
        ((MessagingException) exc2).next = exc;
        return true;
    }

    @Override // java.lang.Throwable
    public synchronized String toString() {
        try {
            String exc = super.toString();
            Exception exc2 = this.next;
            if (exc2 == null) {
                return exc;
            }
            if (exc == null) {
                exc = "";
            }
            StringBuffer stringBuffer = new StringBuffer(exc);
            while (exc2 != null) {
                stringBuffer.append(";\n  nested exception is:\n\t");
                if (exc2 instanceof MessagingException) {
                    MessagingException messagingException = (MessagingException) exc2;
                    stringBuffer.append(messagingException.superToString());
                    exc2 = messagingException.next;
                } else {
                    stringBuffer.append(exc2.toString());
                    exc2 = null;
                }
            }
            return stringBuffer.toString();
        } catch (Throwable th) {
            throw th;
        }
    }

    public MessagingException(String str) {
        super(str);
        initCause(null);
    }

    private final String superToString() {
        return super.toString();
    }

    public MessagingException(String str, Exception exc) {
        super(str);
        this.next = exc;
        initCause(null);
    }
}
