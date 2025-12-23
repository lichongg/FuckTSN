package com.amap.api.col.p0003l;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
final class t0 {

    /* renamed from: a, reason: collision with root package name */
    RandomAccessFile f7254a;

    public t0() throws IOException {
        this("", 0L);
    }

    public final synchronized int a(byte[] bArr) throws IOException {
        this.f7254a.write(bArr);
        return bArr.length;
    }

    public t0(String str, long j6) throws IOException {
        File file = new File(str);
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
            } catch (IOException e6) {
                v5.p(e6, "FileAccessI", "create");
                e6.printStackTrace();
            }
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "rw");
        this.f7254a = randomAccessFile;
        randomAccessFile.seek(j6);
    }

    public final void b() {
        RandomAccessFile randomAccessFile = this.f7254a;
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
            } catch (IOException e6) {
                e6.printStackTrace();
            }
            this.f7254a = null;
        }
    }
}
