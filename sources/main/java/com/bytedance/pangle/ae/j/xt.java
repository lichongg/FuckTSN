package com.bytedance.pangle.ae.j;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt {

    /* renamed from: j, reason: collision with root package name */
    private InputStream f25384j;
    private int xt;

    public final void j(InputStream inputStream) {
        this.f25384j = inputStream;
        this.xt = 0;
    }

    public final int xt() throws IOException {
        int i6 = 0;
        for (int i7 = 0; i7 != 32; i7 += 8) {
            int read = this.f25384j.read();
            if (read == -1) {
                throw new EOFException();
            }
            this.xt++;
            i6 |= read << i7;
        }
        return i6;
    }

    public final void cw() throws IOException {
        long skip = this.f25384j.skip(4L);
        this.xt = (int) (this.xt + skip);
        if (skip != 4) {
            throw new EOFException();
        }
    }

    public xt(InputStream inputStream) {
        j(inputStream);
    }

    public final void j() {
        InputStream inputStream = this.f25384j;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
            j((InputStream) null);
        }
    }

    public void xt(int i6) throws IOException {
        int xt = xt();
        if (xt != i6) {
            throw new IOException(String.format("Expected: 0x%08x got: 0x%08x", Integer.valueOf(i6), Integer.valueOf(xt)));
        }
    }

    public final int[] j(int i6) throws IOException {
        int[] iArr = new int[i6];
        int i7 = 0;
        while (i6 > 0) {
            iArr[i7] = xt();
            i6--;
            i7++;
        }
        return iArr;
    }
}
