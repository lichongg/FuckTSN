package javax.mail;

import java.util.Vector;
import javax.mail.event.FolderEvent;
import javax.mail.event.FolderListener;
import javax.mail.event.StoreEvent;
import javax.mail.event.StoreListener;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class Store extends Service {
    private volatile Vector folderListeners;
    private volatile Vector storeListeners;

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

    public synchronized void addStoreListener(StoreListener storeListener) {
        try {
            if (this.storeListeners == null) {
                this.storeListeners = new Vector();
            }
            this.storeListeners.addElement(storeListener);
        } catch (Throwable th) {
            throw th;
        }
    }

    public abstract Folder getDefaultFolder() throws MessagingException;

    public abstract Folder getFolder(String str) throws MessagingException;

    public abstract Folder getFolder(URLName uRLName) throws MessagingException;

    public Folder[] getSharedNamespaces() throws MessagingException {
        return new Folder[0];
    }

    public Folder[] getUserNamespaces(String str) throws MessagingException {
        return new Folder[0];
    }

    public synchronized void removeFolderListener(FolderListener folderListener) {
        if (this.folderListeners != null) {
            this.folderListeners.removeElement(folderListener);
        }
    }

    public synchronized void removeStoreListener(StoreListener storeListener) {
        if (this.storeListeners != null) {
            this.storeListeners.removeElement(storeListener);
        }
    }

    protected void notifyFolderListeners(int i6, Folder folder) {
        if (this.folderListeners == null) {
            return;
        }
        queueEvent(new FolderEvent(this, folder, i6), this.folderListeners);
    }

    protected void notifyFolderRenamedListeners(Folder folder, Folder folder2) {
        if (this.folderListeners == null) {
            return;
        }
        queueEvent(new FolderEvent(this, folder, folder2, 3), this.folderListeners);
    }

    protected void notifyStoreListeners(int i6, String str) {
        if (this.storeListeners == null) {
            return;
        }
        queueEvent(new StoreEvent(this, i6, str), this.storeListeners);
    }

    protected Store(Session session, URLName uRLName) {
        super(session, uRLName);
        this.storeListeners = null;
        this.folderListeners = null;
    }

    public Folder[] getPersonalNamespaces() throws MessagingException {
        return new Folder[]{getDefaultFolder()};
    }
}
