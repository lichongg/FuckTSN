package com.kwad.sdk.core.videocache.a;

import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.core.videocache.ProxyCacheException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b implements com.kwad.sdk.core.videocache.a {
    private final a aKM;
    private RandomAccessFile aLD;
    public File file;

    @Override // com.kwad.sdk.core.videocache.a
    public final synchronized long Kk() {
        try {
        } catch (IOException e6) {
            throw new ProxyCacheException("Error reading length of file " + this.file, e6);
        }
        return (int) this.aLD.length();
    }

    @Override // com.kwad.sdk.core.videocache.a
    public final synchronized int a(byte[] bArr, long j6, int i6) {
        try {
            this.aLD.seek(j6);
        } catch (IOException e6) {
            throw new ProxyCacheException(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", Integer.valueOf(i6), Long.valueOf(j6), Long.valueOf(Kk()), Integer.valueOf(bArr.length)), e6);
        }
        return this.aLD.read(bArr, 0, i6);
    }

    @Override // com.kwad.sdk.core.videocache.a
    public final synchronized void close() {
        try {
            this.aLD.close();
            this.aKM.s(this.file);
        } catch (IOException e6) {
            throw new ProxyCacheException("Error closing file " + this.file, e6);
        }
    }

    @Override // com.kwad.sdk.core.videocache.a
    public final synchronized void complete() {
        if (isCompleted()) {
            return;
        }
        close();
        File file = new File(this.file.getParentFile(), this.file.getName().substring(0, this.file.getName().length() - 9));
        if (!this.file.renameTo(file)) {
            throw new ProxyCacheException("Error renaming file " + this.file + " to " + file + " for completion!");
        }
        this.file = file;
        try {
            this.aLD = new RandomAccessFile(this.file, t.f36150k);
            this.aKM.s(this.file);
        } catch (IOException e6) {
            throw new ProxyCacheException("Error opening " + this.file + " as disc cache", e6);
        }
    }

    @Override // com.kwad.sdk.core.videocache.a
    public final synchronized void d(byte[] bArr, int i6) {
        try {
            if (isCompleted()) {
                throw new ProxyCacheException("Error append cache: cache file " + this.file + " is completed!");
            }
            this.aLD.seek(Kk());
            this.aLD.write(bArr, 0, i6);
        } catch (IOException e6) {
            throw new ProxyCacheException(String.format("Error writing %d bytes to %s from buffer with size %d", Integer.valueOf(i6), this.aLD, 1024), e6);
        }
    }

    @Override // com.kwad.sdk.core.videocache.a
    public final synchronized boolean isCompleted() {
        return !t(this.file);
    }

    public b(File file, a aVar) {
        File file2;
        String str;
        try {
            if (aVar != null) {
                this.aKM = aVar;
                d.u(file.getParentFile());
                boolean exists = file.exists();
                if (exists) {
                    file2 = file;
                } else {
                    file2 = new File(file.getParentFile(), file.getName() + ".download");
                }
                this.file = file2;
                File file3 = this.file;
                if (exists) {
                    str = t.f36150k;
                } else {
                    str = "rw";
                }
                this.aLD = new RandomAccessFile(file3, str);
                return;
            }
            throw new NullPointerException();
        } catch (IOException e6) {
            throw new ProxyCacheException("Error using file " + file + " as disc cache", e6);
        }
    }

    private static boolean t(File file) {
        return file.getName().endsWith(".download");
    }
}
