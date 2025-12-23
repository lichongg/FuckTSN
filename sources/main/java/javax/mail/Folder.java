package javax.mail;

import java.util.Vector;
import javax.mail.Flags;
import javax.mail.event.ConnectionEvent;
import javax.mail.event.ConnectionListener;
import javax.mail.event.FolderEvent;
import javax.mail.event.FolderListener;
import javax.mail.event.MailEvent;
import javax.mail.event.MessageChangedEvent;
import javax.mail.event.MessageChangedListener;
import javax.mail.event.MessageCountEvent;
import javax.mail.event.MessageCountListener;
import javax.mail.search.SearchTerm;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class Folder {
    public static final int HOLDS_FOLDERS = 2;
    public static final int HOLDS_MESSAGES = 1;
    public static final int READ_ONLY = 1;
    public static final int READ_WRITE = 2;

    /* renamed from: q, reason: collision with root package name */
    private EventQueue f43456q;
    protected Store store;
    protected int mode = -1;
    private volatile Vector connectionListeners = null;
    private volatile Vector folderListeners = null;
    private volatile Vector messageCountListeners = null;
    private volatile Vector messageChangedListeners = null;
    private Object qLock = new Object();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class TerminatorEvent extends MailEvent {
        private static final long serialVersionUID = 3765761925441296565L;

        TerminatorEvent() {
            super(new Object());
        }

        @Override // javax.mail.event.MailEvent
        public void dispatch(Object obj) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized void addConnectionListener(ConnectionListener connectionListener) {
        try {
            if (this.connectionListeners == null) {
                this.connectionListeners = new Vector();
            }
            this.connectionListeners.addElement(connectionListener);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void addFolderListener(FolderListener folderListener) {
        try {
            if (this.folderListeners == null) {
                this.folderListeners = new Vector();
            }
            this.folderListeners.addElement(folderListener);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void addMessageChangedListener(MessageChangedListener messageChangedListener) {
        try {
            if (this.messageChangedListeners == null) {
                this.messageChangedListeners = new Vector();
            }
            this.messageChangedListeners.addElement(messageChangedListener);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void addMessageCountListener(MessageCountListener messageCountListener) {
        try {
            if (this.messageCountListeners == null) {
                this.messageCountListeners = new Vector();
            }
            this.messageCountListeners.addElement(messageCountListener);
        } catch (Throwable th) {
            throw th;
        }
    }

    public abstract void appendMessages(Message[] messageArr) throws MessagingException;

    public abstract void close(boolean z5) throws MessagingException;

    public abstract boolean create(int i6) throws MessagingException;

    public abstract boolean delete(boolean z5) throws MessagingException;

    public abstract boolean exists() throws MessagingException;

    public abstract Message[] expunge() throws MessagingException;

    public synchronized int getDeletedMessageCount() throws MessagingException {
        if (!isOpen()) {
            return -1;
        }
        int messageCount = getMessageCount();
        int i6 = 0;
        for (int i7 = 1; i7 <= messageCount; i7++) {
            try {
                if (getMessage(i7).isSet(Flags.Flag.DELETED)) {
                    i6++;
                }
            } catch (MessageRemovedException unused) {
            }
        }
        return i6;
    }

    public abstract Folder getFolder(String str) throws MessagingException;

    public abstract String getFullName();

    public abstract Message getMessage(int i6) throws MessagingException;

    public abstract int getMessageCount() throws MessagingException;

    public synchronized Message[] getMessages(int i6, int i7) throws MessagingException {
        Message[] messageArr;
        messageArr = new Message[(i7 - i6) + 1];
        for (int i8 = i6; i8 <= i7; i8++) {
            messageArr[i8 - i6] = getMessage(i8);
        }
        return messageArr;
    }

    public abstract String getName();

    public synchronized int getNewMessageCount() throws MessagingException {
        if (!isOpen()) {
            return -1;
        }
        int messageCount = getMessageCount();
        int i6 = 0;
        for (int i7 = 1; i7 <= messageCount; i7++) {
            try {
                if (getMessage(i7).isSet(Flags.Flag.RECENT)) {
                    i6++;
                }
            } catch (MessageRemovedException unused) {
            }
        }
        return i6;
    }

    public abstract Folder getParent() throws MessagingException;

    public abstract Flags getPermanentFlags();

    public abstract char getSeparator() throws MessagingException;

    public abstract int getType() throws MessagingException;

    public synchronized int getUnreadMessageCount() throws MessagingException {
        if (!isOpen()) {
            return -1;
        }
        int messageCount = getMessageCount();
        int i6 = 0;
        for (int i7 = 1; i7 <= messageCount; i7++) {
            try {
                if (!getMessage(i7).isSet(Flags.Flag.SEEN)) {
                    i6++;
                }
            } catch (MessageRemovedException unused) {
            }
        }
        return i6;
    }

    public abstract boolean hasNewMessages() throws MessagingException;

    public abstract boolean isOpen();

    public boolean isSubscribed() {
        return true;
    }

    public Folder[] list() throws MessagingException {
        return list("%");
    }

    public abstract Folder[] list(String str) throws MessagingException;

    public Folder[] listSubscribed(String str) throws MessagingException {
        return list(str);
    }

    public abstract void open(int i6) throws MessagingException;

    public synchronized void removeConnectionListener(ConnectionListener connectionListener) {
        if (this.connectionListeners != null) {
            this.connectionListeners.removeElement(connectionListener);
        }
    }

    public synchronized void removeFolderListener(FolderListener folderListener) {
        if (this.folderListeners != null) {
            this.folderListeners.removeElement(folderListener);
        }
    }

    public synchronized void removeMessageChangedListener(MessageChangedListener messageChangedListener) {
        if (this.messageChangedListeners != null) {
            this.messageChangedListeners.removeElement(messageChangedListener);
        }
    }

    public synchronized void removeMessageCountListener(MessageCountListener messageCountListener) {
        if (this.messageCountListeners != null) {
            this.messageCountListeners.removeElement(messageCountListener);
        }
    }

    public abstract boolean renameTo(Folder folder) throws MessagingException;

    public Message[] search(SearchTerm searchTerm) throws MessagingException {
        return search(searchTerm, getMessages());
    }

    public synchronized void setFlags(Message[] messageArr, Flags flags, boolean z5) throws MessagingException {
        for (Message message : messageArr) {
            try {
                message.setFlags(flags, z5);
            } catch (MessageRemovedException unused) {
            }
        }
    }

    private void queueEvent(MailEvent mailEvent, Vector vector) {
        synchronized (this.qLock) {
            try {
                if (this.f43456q == null) {
                    this.f43456q = new EventQueue();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f43456q.enqueue(mailEvent, (Vector) vector.clone());
    }

    private void terminateQueue() {
        synchronized (this.qLock) {
            try {
                if (this.f43456q != null) {
                    Vector vector = new Vector();
                    vector.setSize(1);
                    this.f43456q.enqueue(new TerminatorEvent(), vector);
                    this.f43456q = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Store getStore() {
        return this.store;
    }

    public Folder[] listSubscribed() throws MessagingException {
        return listSubscribed("%");
    }

    protected void notifyConnectionListeners(int i6) {
        if (this.connectionListeners != null) {
            queueEvent(new ConnectionEvent(this, i6), this.connectionListeners);
        }
        if (i6 == 3) {
            terminateQueue();
        }
    }

    protected void notifyFolderListeners(int i6) {
        if (this.folderListeners != null) {
            queueEvent(new FolderEvent(this, this, i6), this.folderListeners);
        }
        this.store.notifyFolderListeners(i6, this);
    }

    protected void notifyFolderRenamedListeners(Folder folder) {
        if (this.folderListeners != null) {
            queueEvent(new FolderEvent(this, this, folder, 3), this.folderListeners);
        }
        this.store.notifyFolderRenamedListeners(this, folder);
    }

    protected void notifyMessageAddedListeners(Message[] messageArr) {
        if (this.messageCountListeners == null) {
            return;
        }
        queueEvent(new MessageCountEvent(this, 1, false, messageArr), this.messageCountListeners);
    }

    protected void notifyMessageChangedListeners(int i6, Message message) {
        if (this.messageChangedListeners == null) {
            return;
        }
        queueEvent(new MessageChangedEvent(this, i6, message), this.messageChangedListeners);
    }

    protected void notifyMessageRemovedListeners(boolean z5, Message[] messageArr) {
        if (this.messageCountListeners == null) {
            return;
        }
        queueEvent(new MessageCountEvent(this, 2, z5, messageArr), this.messageCountListeners);
    }

    public Message[] search(SearchTerm searchTerm, Message[] messageArr) throws MessagingException {
        Vector vector = new Vector();
        for (int i6 = 0; i6 < messageArr.length; i6++) {
            try {
                if (messageArr[i6].match(searchTerm)) {
                    vector.addElement(messageArr[i6]);
                }
            } catch (MessageRemovedException unused) {
            }
        }
        Message[] messageArr2 = new Message[vector.size()];
        vector.copyInto(messageArr2);
        return messageArr2;
    }

    public void setSubscribed(boolean z5) throws MessagingException {
        throw new MethodNotSupportedException();
    }

    protected Folder(Store store) {
        this.store = store;
    }

    public void copyMessages(Message[] messageArr, Folder folder) throws MessagingException {
        if (folder.exists()) {
            folder.appendMessages(messageArr);
        } else {
            throw new FolderNotFoundException(String.valueOf(folder.getFullName()) + " does not exist", folder);
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        terminateQueue();
    }

    public int getMode() {
        if (isOpen()) {
            return this.mode;
        }
        throw new IllegalStateException("Folder not open");
    }

    public URLName getURLName() throws MessagingException {
        URLName uRLName = getStore().getURLName();
        String fullName = getFullName();
        StringBuffer stringBuffer = new StringBuffer();
        getSeparator();
        if (fullName != null) {
            stringBuffer.append(fullName);
        }
        return new URLName(uRLName.getProtocol(), uRLName.getHost(), uRLName.getPort(), stringBuffer.toString(), uRLName.getUsername(), null);
    }

    public String toString() {
        String fullName = getFullName();
        if (fullName != null) {
            return fullName;
        }
        return super.toString();
    }

    public synchronized Message[] getMessages(int[] iArr) throws MessagingException {
        Message[] messageArr;
        int length = iArr.length;
        messageArr = new Message[length];
        for (int i6 = 0; i6 < length; i6++) {
            messageArr[i6] = getMessage(iArr[i6]);
        }
        return messageArr;
    }

    public synchronized void setFlags(int i6, int i7, Flags flags, boolean z5) throws MessagingException {
        while (i6 <= i7) {
            try {
                getMessage(i6).setFlags(flags, z5);
            } catch (MessageRemovedException unused) {
            }
            i6++;
        }
    }

    public synchronized void setFlags(int[] iArr, Flags flags, boolean z5) throws MessagingException {
        for (int i6 : iArr) {
            try {
                getMessage(i6).setFlags(flags, z5);
            } catch (MessageRemovedException unused) {
            }
        }
    }

    public synchronized Message[] getMessages() throws MessagingException {
        Message[] messageArr;
        try {
            if (isOpen()) {
                int messageCount = getMessageCount();
                messageArr = new Message[messageCount];
                for (int i6 = 1; i6 <= messageCount; i6++) {
                    messageArr[i6 - 1] = getMessage(i6);
                }
            } else {
                throw new IllegalStateException("Folder not open");
            }
        } catch (Throwable th) {
            throw th;
        }
        return messageArr;
    }

    public void fetch(Message[] messageArr, FetchProfile fetchProfile) throws MessagingException {
    }
}
