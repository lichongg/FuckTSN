package javax.mail;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Vector;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class Multipart {
    protected Part parent;
    protected Vector parts = new Vector();
    protected String contentType = "multipart/mixed";

    public synchronized void addBodyPart(BodyPart bodyPart) throws MessagingException {
        try {
            if (this.parts == null) {
                this.parts = new Vector();
            }
            this.parts.addElement(bodyPart);
            bodyPart.setParent(this);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized BodyPart getBodyPart(int i6) throws MessagingException {
        Vector vector;
        vector = this.parts;
        if (vector == null) {
            throw new IndexOutOfBoundsException("No such BodyPart");
        }
        return (BodyPart) vector.elementAt(i6);
    }

    public synchronized int getCount() throws MessagingException {
        Vector vector = this.parts;
        if (vector == null) {
            return 0;
        }
        return vector.size();
    }

    public synchronized Part getParent() {
        return this.parent;
    }

    public synchronized boolean removeBodyPart(BodyPart bodyPart) throws MessagingException {
        boolean removeElement;
        Vector vector = this.parts;
        if (vector == null) {
            throw new MessagingException("No such body part");
        }
        removeElement = vector.removeElement(bodyPart);
        bodyPart.setParent(null);
        return removeElement;
    }

    protected synchronized void setMultipartDataSource(MultipartDataSource multipartDataSource) throws MessagingException {
        this.contentType = multipartDataSource.getContentType();
        int count = multipartDataSource.getCount();
        for (int i6 = 0; i6 < count; i6++) {
            addBodyPart(multipartDataSource.getBodyPart(i6));
        }
    }

    public synchronized void setParent(Part part) {
        this.parent = part;
    }

    public abstract void writeTo(OutputStream outputStream) throws IOException, MessagingException;

    public String getContentType() {
        return this.contentType;
    }

    protected Multipart() {
    }

    public synchronized void addBodyPart(BodyPart bodyPart, int i6) throws MessagingException {
        try {
            if (this.parts == null) {
                this.parts = new Vector();
            }
            this.parts.insertElementAt(bodyPart, i6);
            bodyPart.setParent(this);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void removeBodyPart(int i6) throws MessagingException {
        Vector vector = this.parts;
        if (vector != null) {
            BodyPart bodyPart = (BodyPart) vector.elementAt(i6);
            this.parts.removeElementAt(i6);
            bodyPart.setParent(null);
        } else {
            throw new IndexOutOfBoundsException("No such BodyPart");
        }
    }
}
