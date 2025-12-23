package com.umeng.socialize.net.dplus.cache1;

import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class AtomicFile {

    /* renamed from: a, reason: collision with root package name */
    private final File f42434a;

    /* renamed from: b, reason: collision with root package name */
    private final File f42435b;

    private static void a(File file, File file2) throws IOException {
        FileOutputStream fileOutputStream;
        System.currentTimeMillis();
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = fileInputStream2.read(bArr);
                        if (read <= 0) {
                            fileInputStream2.close();
                            fileOutputStream.close();
                            System.currentTimeMillis();
                            return;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    public void delete() {
        this.f42434a.delete();
        this.f42435b.delete();
    }

    public void failWrite(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            a(fileOutputStream);
            try {
                fileOutputStream.close();
                this.f42434a.delete();
                this.f42435b.renameTo(this.f42434a);
            } catch (IOException e6) {
                SLog.error(UmengText.CACHE.CACHEFILE, e6);
            }
        }
    }

    public void finishWrite(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            a(fileOutputStream);
            try {
                fileOutputStream.close();
                this.f42435b.delete();
            } catch (IOException e6) {
                SLog.error(UmengText.CACHE.CACHEFILE, e6);
            }
        }
    }

    public File getBaseFile() {
        return this.f42434a;
    }

    public FileInputStream openRead() throws FileNotFoundException {
        if (this.f42435b.exists()) {
            this.f42434a.delete();
            this.f42435b.renameTo(this.f42434a);
        }
        return new FileInputStream(this.f42434a);
    }

    public FileOutputStream startWrite(boolean z5) throws IOException {
        if (this.f42434a.exists()) {
            if (this.f42435b.exists()) {
                this.f42434a.delete();
            } else if (this.f42434a.renameTo(this.f42435b)) {
                a(this.f42435b, this.f42434a);
            } else {
                Objects.toString(this.f42434a);
                Objects.toString(this.f42435b);
            }
        }
        try {
            return new FileOutputStream(this.f42434a, z5);
        } catch (FileNotFoundException e6) {
            if (!this.f42434a.getParentFile().mkdirs()) {
                SLog.error(UmengText.CACHE.CACHEFILE, e6);
            }
            try {
                return new FileOutputStream(this.f42434a, z5);
            } catch (FileNotFoundException unused) {
                SLog.error(UmengText.CACHE.CACHEFILE, e6);
                return null;
            }
        }
    }

    public AtomicFile(File file) {
        this.f42434a = file;
        this.f42435b = new File(file.getPath() + ".bak");
    }

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

    static boolean a(FileOutputStream fileOutputStream) {
        if (fileOutputStream == null) {
            return true;
        }
        try {
            fileOutputStream.getFD().sync();
            return true;
        } catch (IOException e6) {
            SLog.error(UmengText.CACHE.CACHEFILE, e6);
            return false;
        }
    }
}
