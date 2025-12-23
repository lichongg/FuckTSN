package javax.mail;

import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Date;
import javax.mail.Flags;
import javax.mail.search.SearchTerm;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class Message implements Part {
    protected boolean expunged;
    protected Folder folder;
    protected int msgnum;
    protected Session session;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class RecipientType implements Serializable {
        private static final long serialVersionUID = -7479791750606340008L;
        protected String type;
        public static final RecipientType TO = new RecipientType("To");
        public static final RecipientType CC = new RecipientType("Cc");
        public static final RecipientType BCC = new RecipientType("Bcc");

        protected Object readResolve() throws ObjectStreamException {
            if (this.type.equals("To")) {
                return TO;
            }
            if (this.type.equals("Cc")) {
                return CC;
            }
            if (this.type.equals("Bcc")) {
                return BCC;
            }
            throw new InvalidObjectException("Attempt to resolve unknown RecipientType: " + this.type);
        }

        public String toString() {
            return this.type;
        }

        protected RecipientType(String str) {
            this.type = str;
        }
    }

    protected Message() {
        this.msgnum = 0;
        this.expunged = false;
        this.folder = null;
        this.session = null;
    }

    public abstract void addFrom(Address[] addressArr) throws MessagingException;

    public void addRecipient(RecipientType recipientType, Address address) throws MessagingException {
        addRecipients(recipientType, new Address[]{address});
    }

    public abstract void addRecipients(RecipientType recipientType, Address[] addressArr) throws MessagingException;

    public abstract Flags getFlags() throws MessagingException;

    public abstract Address[] getFrom() throws MessagingException;

    public abstract Date getReceivedDate() throws MessagingException;

    public abstract Address[] getRecipients(RecipientType recipientType) throws MessagingException;

    public abstract Date getSentDate() throws MessagingException;

    public abstract String getSubject() throws MessagingException;

    public abstract Message reply(boolean z5) throws MessagingException;

    public abstract void saveChanges() throws MessagingException;

    public abstract void setFlags(Flags flags, boolean z5) throws MessagingException;

    public abstract void setFrom() throws MessagingException;

    public abstract void setFrom(Address address) throws MessagingException;

    public void setRecipient(RecipientType recipientType, Address address) throws MessagingException {
        setRecipients(recipientType, new Address[]{address});
    }

    public abstract void setRecipients(RecipientType recipientType, Address[] addressArr) throws MessagingException;

    public abstract void setSentDate(Date date) throws MessagingException;

    public abstract void setSubject(String str) throws MessagingException;

    public Address[] getAllRecipients() throws MessagingException {
        int i6;
        Address[] recipients = getRecipients(RecipientType.TO);
        Address[] recipients2 = getRecipients(RecipientType.CC);
        Address[] recipients3 = getRecipients(RecipientType.BCC);
        if (recipients2 == null && recipients3 == null) {
            return recipients;
        }
        Address[] addressArr = new Address[(recipients != null ? recipients.length : 0) + (recipients2 != null ? recipients2.length : 0) + (recipients3 != null ? recipients3.length : 0)];
        if (recipients != null) {
            System.arraycopy(recipients, 0, addressArr, 0, recipients.length);
            i6 = recipients.length;
        } else {
            i6 = 0;
        }
        if (recipients2 != null) {
            System.arraycopy(recipients2, 0, addressArr, i6, recipients2.length);
            i6 += recipients2.length;
        }
        if (recipients3 != null) {
            System.arraycopy(recipients3, 0, addressArr, i6, recipients3.length);
        }
        return addressArr;
    }

    public Folder getFolder() {
        return this.folder;
    }

    public int getMessageNumber() {
        return this.msgnum;
    }

    public boolean isExpunged() {
        return this.expunged;
    }

    protected void setExpunged(boolean z5) {
        this.expunged = z5;
    }

    public void setFlag(Flags.Flag flag, boolean z5) throws MessagingException {
        setFlags(new Flags(flag), z5);
    }

    protected void setMessageNumber(int i6) {
        this.msgnum = i6;
    }

    public void setReplyTo(Address[] addressArr) throws MessagingException {
        throw new MethodNotSupportedException("setReplyTo not supported");
    }

    public Address[] getReplyTo() throws MessagingException {
        return getFrom();
    }

    public boolean isSet(Flags.Flag flag) throws MessagingException {
        return getFlags().contains(flag);
    }

    public boolean match(SearchTerm searchTerm) throws MessagingException {
        return searchTerm.match(this);
    }

    protected Message(Folder folder, int i6) {
        this.expunged = false;
        this.session = null;
        this.folder = folder;
        this.msgnum = i6;
        this.session = folder.store.session;
    }

    protected Message(Session session) {
        this.msgnum = 0;
        this.expunged = false;
        this.folder = null;
        this.session = session;
    }
}
