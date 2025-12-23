package org.apache.commons.net.io;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class k extends FilterOutputStream {

    /* renamed from: a, reason: collision with root package name */
    private boolean f50860a;

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public synchronized void write(int i6) throws IOException {
        if (i6 != 10) {
            if (i6 == 13) {
                this.f50860a = true;
                ((FilterOutputStream) this).out.write(13);
                return;
            }
        } else if (!this.f50860a) {
            ((FilterOutputStream) this).out.write(13);
        }
        this.f50860a = false;
        ((FilterOutputStream) this).out.write(i6);
    }

    public k(OutputStream outputStream) {
        super(outputStream);
        this.f50860a = false;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr, int i6, int i7) throws IOException {
        while (true) {
            int i8 = i7 - 1;
            if (i7 > 0) {
                int i9 = i6 + 1;
                write(bArr[i6]);
                i6 = i9;
                i7 = i8;
            }
        }
    }
}
