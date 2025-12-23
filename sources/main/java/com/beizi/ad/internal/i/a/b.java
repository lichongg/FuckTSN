package com.beizi.ad.internal.i.a;

import com.beizi.ad.internal.i.m;
import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class b implements com.beizi.ad.internal.i.a {

    /* renamed from: a, reason: collision with root package name */
    public File f12199a;

    /* renamed from: b, reason: collision with root package name */
    private final a f12200b;

    /* renamed from: c, reason: collision with root package name */
    private RandomAccessFile f12201c;

    @Override // com.beizi.ad.internal.i.a
    public synchronized int a() throws m {
        try {
        } catch (IOException e6) {
            throw new m("Error reading length of file " + this.f12199a, e6);
        }
        return (int) this.f12201c.length();
    }

    @Override // com.beizi.ad.internal.i.a
    public synchronized void b() throws m {
        try {
            this.f12201c.close();
            this.f12200b.a(this.f12199a);
        } catch (IOException e6) {
            throw new m("Error closing file " + this.f12199a, e6);
        }
    }

    @Override // com.beizi.ad.internal.i.a
    public synchronized void c() throws m {
        if (d()) {
            return;
        }
        b();
        File file = new File(this.f12199a.getParentFile(), this.f12199a.getName().substring(0, this.f12199a.getName().length() - 9));
        if (!this.f12199a.renameTo(file)) {
            throw new m("Error renaming file " + this.f12199a + " to " + file + " for completion!");
        }
        this.f12199a = file;
        try {
            this.f12201c = new RandomAccessFile(this.f12199a, t.f36150k);
        } catch (IOException e6) {
            throw new m("Error opening " + this.f12199a + " as disc cache", e6);
        }
    }

    @Override // com.beizi.ad.internal.i.a
    public synchronized boolean d() {
        return !a(this.f12199a);
    }

    public b(File file, a aVar) throws m {
        File file2;
        String str;
        try {
            if (aVar != null) {
                this.f12200b = aVar;
                d.a(file.getParentFile());
                boolean exists = file.exists();
                if (exists) {
                    file2 = file;
                } else {
                    file2 = new File(file.getParentFile(), file.getName() + ".download");
                }
                this.f12199a = file2;
                File file3 = this.f12199a;
                if (exists) {
                    str = t.f36150k;
                } else {
                    str = "rw";
                }
                this.f12201c = new RandomAccessFile(file3, str);
                return;
            }
            throw new NullPointerException();
        } catch (IOException e6) {
            throw new m("Error using file " + file + " as disc cache", e6);
        }
    }

    @Override // com.beizi.ad.internal.i.a
    public synchronized int a(byte[] bArr, long j6, int i6) throws m {
        try {
            this.f12201c.seek(j6);
        } catch (IOException e6) {
            throw new m(String.format("Error reading %d bytes with offset %d failFrom file[%d bytes] to buffer[%d bytes]", Integer.valueOf(i6), Long.valueOf(j6), Integer.valueOf(a()), Integer.valueOf(bArr.length)), e6);
        }
        return this.f12201c.read(bArr, 0, i6);
    }

    @Override // com.beizi.ad.internal.i.a
    public synchronized void a(byte[] bArr, int i6) throws m {
        try {
            if (!d()) {
                this.f12201c.seek(a());
                this.f12201c.write(bArr, 0, i6);
            } else {
                throw new m("Error append cache: cache file " + this.f12199a + " is completed!");
            }
        } catch (IOException e6) {
            throw new m(String.format("Error writing %d bytes to %s failFrom buffer with size %d", Integer.valueOf(i6), this.f12201c, Integer.valueOf(bArr.length)), e6);
        }
    }

    private boolean a(File file) {
        return file.getName().endsWith(".download");
    }
}
