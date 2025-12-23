package androidx.core.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class AtomicFile {
    private static final String LOG_TAG = "AtomicFile";
    private final File mBaseName;
    private final File mLegacyBackupName;
    private final File mNewName;

    public void delete() {
        this.mBaseName.delete();
        this.mNewName.delete();
        this.mLegacyBackupName.delete();
    }

    public void failWrite(@Nullable FileOutputStream fileOutputStream) {
        if (fileOutputStream == null) {
            return;
        }
        sync(fileOutputStream);
        try {
            fileOutputStream.close();
        } catch (IOException unused) {
        }
        if (this.mNewName.delete()) {
            return;
        }
        Objects.toString(this.mNewName);
    }

    public void finishWrite(@Nullable FileOutputStream fileOutputStream) {
        if (fileOutputStream == null) {
            return;
        }
        sync(fileOutputStream);
        try {
            fileOutputStream.close();
        } catch (IOException unused) {
        }
        rename(this.mNewName, this.mBaseName);
    }

    @NonNull
    public File getBaseFile() {
        return this.mBaseName;
    }

    @NonNull
    public FileInputStream openRead() throws FileNotFoundException {
        if (this.mLegacyBackupName.exists()) {
            rename(this.mLegacyBackupName, this.mBaseName);
        }
        if (this.mNewName.exists() && this.mBaseName.exists() && !this.mNewName.delete()) {
            Objects.toString(this.mNewName);
        }
        return new FileInputStream(this.mBaseName);
    }

    @NonNull
    public FileOutputStream startWrite() throws IOException {
        if (this.mLegacyBackupName.exists()) {
            rename(this.mLegacyBackupName, this.mBaseName);
        }
        try {
            return new FileOutputStream(this.mNewName);
        } catch (FileNotFoundException unused) {
            if (!this.mNewName.getParentFile().mkdirs()) {
                throw new IOException("Failed to create directory for " + this.mNewName);
            }
            try {
                return new FileOutputStream(this.mNewName);
            } catch (FileNotFoundException e6) {
                throw new IOException("Failed to create new file " + this.mNewName, e6);
            }
        }
    }

    public AtomicFile(@NonNull File file) {
        this.mBaseName = file;
        this.mNewName = new File(file.getPath() + ".new");
        this.mLegacyBackupName = new File(file.getPath() + ".bak");
    }

    private static void rename(@NonNull File file, @NonNull File file2) {
        if (file2.isDirectory() && !file2.delete()) {
            file2.toString();
        }
        if (!file.renameTo(file2)) {
            file.toString();
            file2.toString();
        }
    }

    private static boolean sync(@NonNull FileOutputStream fileOutputStream) {
        try {
            fileOutputStream.getFD().sync();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    @NonNull
    public byte[] readFully() throws IOException {
        FileInputStream openRead = openRead();
        try {
            byte[] bArr = new byte[openRead.available()];
            int i6 = 0;
            while (true) {
                int read = openRead.read(bArr, i6, bArr.length - i6);
                if (read <= 0) {
                    return bArr;
                }
                i6 += read;
                int available = openRead.available();
                if (available > bArr.length - i6) {
                    byte[] bArr2 = new byte[available + i6];
                    System.arraycopy(bArr, 0, bArr2, 0, i6);
                    bArr = bArr2;
                }
            }
        } finally {
            openRead.close();
        }
    }
}
