package com.ss.android.socialbase.appdownloader.m.j;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: D:\Downloads\app\classes6.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private InputStream f38521a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f38522b;

    /* renamed from: c, reason: collision with root package name */
    private int f38523c;

    public e() {
    }

    public final void a() throws IOException {
        b(4);
    }

    public final int g() throws IOException {
        return c(4);
    }

    public e(InputStream inputStream, boolean z5) {
        e(inputStream, z5);
    }

    public final void b(int i6) throws IOException {
        if (i6 > 0) {
            long j6 = i6;
            long skip = this.f38521a.skip(j6);
            this.f38523c = (int) (this.f38523c + skip);
            if (skip != j6) {
                throw new EOFException();
            }
        }
    }

    public final int c(int i6) throws IOException {
        if (i6 < 0 || i6 > 4) {
            throw new IllegalArgumentException();
        }
        int i7 = 0;
        if (this.f38522b) {
            for (int i8 = (i6 - 1) * 8; i8 >= 0; i8 -= 8) {
                int read = this.f38521a.read();
                if (read == -1) {
                    throw new EOFException();
                }
                this.f38523c++;
                i7 |= read << i8;
            }
            return i7;
        }
        int i9 = i6 * 8;
        int i10 = 0;
        while (i7 != i9) {
            int read2 = this.f38521a.read();
            if (read2 == -1) {
                throw new EOFException();
            }
            this.f38523c++;
            i10 |= read2 << i7;
            i7 += 8;
        }
        return i10;
    }

    public final void d() {
        InputStream inputStream = this.f38521a;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
            e(null, false);
        }
    }

    public final void e(InputStream inputStream, boolean z5) {
        this.f38521a = inputStream;
        this.f38522b = z5;
        this.f38523c = 0;
    }

    public final void f(int[] iArr, int i6, int i7) throws IOException {
        while (i7 > 0) {
            iArr[i6] = g();
            i7--;
            i6++;
        }
    }

    public final int[] h(int i6) throws IOException {
        int[] iArr = new int[i6];
        f(iArr, 0, i6);
        return iArr;
    }
}
