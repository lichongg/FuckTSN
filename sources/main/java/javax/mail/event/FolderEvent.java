package javax.mail.event;

import javax.mail.Folder;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class FolderEvent extends MailEvent {
    public static final int CREATED = 1;
    public static final int DELETED = 2;
    public static final int RENAMED = 3;
    private static final long serialVersionUID = 5278131310563694307L;
    protected transient Folder folder;
    protected transient Folder newFolder;
    protected int type;

    public FolderEvent(Object obj, Folder folder, int i6) {
        this(obj, folder, folder, i6);
    }

    public FolderEvent(Object obj, Folder folder, Folder folder2, int i6) {
        super(obj);
        this.folder = folder;
        this.newFolder = folder2;
        this.type = i6;
    }

    @Override // javax.mail.event.MailEvent
    public void dispatch(Object obj) {
        int i6 = this.type;
        if (i6 == 1) {
            ((FolderListener) obj).folderCreated(this);
        } else if (i6 == 2) {
            ((FolderListener) obj).folderDeleted(this);
        } else if (i6 == 3) {
            ((FolderListener) obj).folderRenamed(this);
        }
    }

    public Folder getFolder() {
        return this.folder;
    }

    public Folder getNewFolder() {
        return this.newFolder;
    }

    public int getType() {
        return this.type;
    }
}
