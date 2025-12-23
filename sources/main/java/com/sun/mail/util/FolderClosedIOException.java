package com.sun.mail.util;

import java.io.IOException;
import javax.mail.Folder;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class FolderClosedIOException extends IOException {
    private static final long serialVersionUID = 4281122580365555735L;
    private transient Folder folder;

    public FolderClosedIOException(Folder folder) {
        this(folder, null);
    }

    public FolderClosedIOException(Folder folder, String str) {
        super(str);
        this.folder = folder;
    }

    public Folder getFolder() {
        return this.folder;
    }
}
