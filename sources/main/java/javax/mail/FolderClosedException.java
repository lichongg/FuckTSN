package javax.mail;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class FolderClosedException extends MessagingException {
    private static final long serialVersionUID = 1687879213433302315L;
    private transient Folder folder;

    public FolderClosedException(Folder folder) {
        this(folder, null);
    }

    public FolderClosedException(Folder folder, String str) {
        super(str);
        this.folder = folder;
    }

    public Folder getFolder() {
        return this.folder;
    }
}
