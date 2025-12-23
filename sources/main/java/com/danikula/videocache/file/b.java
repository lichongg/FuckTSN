package com.danikula.videocache.file;

import com.danikula.videocache.ProxyCacheException;
import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class b implements com.danikula.videocache.d {

    /* renamed from: d, reason: collision with root package name */
    private static final String f32162d = ".download";

    /* renamed from: a, reason: collision with root package name */
    private final a f32163a;

    /* renamed from: b, reason: collision with root package name */
    public File f32164b;

    /* renamed from: c, reason: collision with root package name */
    private RandomAccessFile f32165c;

    public b(File file) throws ProxyCacheException {
        this(file, new i());
    }

    @Override // com.danikula.videocache.d
    public synchronized void a(byte[] bArr, int i6) throws ProxyCacheException {
        try {
            if (isCompleted()) {
                throw new ProxyCacheException("Error append cache: cache file " + this.f32164b + " is completed!");
            }
            this.f32165c.seek(available());
            this.f32165c.write(bArr, 0, i6);
        } catch (IOException e6) {
            throw new ProxyCacheException(String.format("Error writing %d bytes to %s from buffer with size %d", Integer.valueOf(i6), this.f32165c, Integer.valueOf(bArr.length)), e6);
        }
    }

    @Override // com.danikula.videocache.d
    public synchronized long available() throws ProxyCacheException {
        try {
        } catch (IOException e6) {
            throw new ProxyCacheException("Error reading length of file " + this.f32164b, e6);
        }
        return (int) this.f32165c.length();
    }

    @Override // com.danikula.videocache.d
    public synchronized int b(byte[] bArr, long j6, int i6) throws ProxyCacheException {
        try {
            this.f32165c.seek(j6);
        } catch (IOException e6) {
            throw new ProxyCacheException(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", Integer.valueOf(i6), Long.valueOf(j6), Long.valueOf(available()), Integer.valueOf(bArr.length)), e6);
        }
        return this.f32165c.read(bArr, 0, i6);
    }

    @Override // com.danikula.videocache.d
    public synchronized void close() throws ProxyCacheException {
        try {
            this.f32165c.close();
            this.f32163a.a(this.f32164b);
        } catch (IOException e6) {
            throw new ProxyCacheException("Error closing file " + this.f32164b, e6);
        }
    }

    @Override // com.danikula.videocache.d
    public synchronized void complete() throws ProxyCacheException {
        if (isCompleted()) {
            return;
        }
        close();
        File file = new File(this.f32164b.getParentFile(), this.f32164b.getName().substring(0, this.f32164b.getName().length() - 9));
        if (!this.f32164b.renameTo(file)) {
            throw new ProxyCacheException("Error renaming file " + this.f32164b + " to " + file + " for completion!");
        }
        this.f32164b = file;
        try {
            this.f32165c = new RandomAccessFile(this.f32164b, t.f36150k);
            this.f32163a.a(this.f32164b);
        } catch (IOException e6) {
            throw new ProxyCacheException("Error opening " + this.f32164b + " as disc cache", e6);
        }
    }

    @Override // com.danikula.videocache.d
    public synchronized boolean isCompleted() {
        return !d(this.f32164b);
    }

    public b(File file, a aVar) throws ProxyCacheException {
        File file2;
        try {
            if (aVar == null) {
                throw new NullPointerException();
            }
            this.f32163a = aVar;
            d.b(file.getParentFile());
            boolean exists = file.exists();
            if (exists) {
                file2 = file;
            } else {
                file2 = new File(file.getParentFile(), file.getName() + f32162d);
            }
            this.f32164b = file2;
            this.f32165c = new RandomAccessFile(this.f32164b, exists ? t.f36150k : "rw");
        } catch (IOException e6) {
            throw new ProxyCacheException("Error using file " + file + " as disc cache", e6);
        }
    }

    public File c() {
        return this.f32164b;
    }

    private boolean d(File file) {
        return file.getName().endsWith(f32162d);
    }
}
