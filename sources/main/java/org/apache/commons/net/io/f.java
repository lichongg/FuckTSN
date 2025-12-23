package org.apache.commons.net.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.io.UnsupportedEncodingException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class f extends PushbackInputStream {

    /* renamed from: b, reason: collision with root package name */
    static final boolean f50849b;

    /* renamed from: c, reason: collision with root package name */
    static final String f50850c;

    /* renamed from: d, reason: collision with root package name */
    static final byte[] f50851d;

    /* renamed from: a, reason: collision with root package name */
    private int f50852a;

    @Override // java.io.PushbackInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        return f50849b ? super.read() : a();
    }

    static {
        String property = System.getProperty("line.separator");
        f50850c = property;
        f50849b = property.equals(org.apache.commons.net.g.f50795q);
        try {
            f50851d = property.getBytes("US-ASCII");
        } catch (UnsupportedEncodingException e6) {
            throw new RuntimeException("Broken JVM - cannot find US-ASCII charset!", e6);
        }
    }

    public f(InputStream inputStream) {
        super(inputStream, f50851d.length + 1);
        this.f50852a = 0;
    }

    public static final boolean b() {
        return !f50849b;
    }

    @Override // java.io.PushbackInputStream, java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        if (((PushbackInputStream) this).in != null) {
            return (((PushbackInputStream) this).buf.length - ((PushbackInputStream) this).pos) + ((PushbackInputStream) this).in.available();
        }
        throw new IOException("Stream closed");
    }

    private int a() throws IOException {
        int read = super.read();
        if (read == 13) {
            int read2 = super.read();
            if (read2 == 10) {
                unread(f50851d);
                this.f50852a--;
                return super.read();
            }
            if (read2 != -1) {
                unread(read2);
            }
            return 13;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.PushbackInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i6, int i7) throws IOException {
        int i8;
        if (f50849b) {
            return super.read(bArr, i6, i7);
        }
        if (i7 < 1) {
            return 0;
        }
        int available = available();
        if (i7 > available) {
            i7 = available;
        }
        this.f50852a = i7;
        if (i7 < 1) {
            this.f50852a = 1;
        }
        int a6 = a();
        if (a6 == -1) {
            return -1;
        }
        int i9 = i6;
        while (true) {
            i8 = i9 + 1;
            bArr[i9] = (byte) a6;
            int i10 = this.f50852a - 1;
            this.f50852a = i10;
            if (i10 <= 0 || (a6 = a()) == -1) {
                break;
            }
            i9 = i8;
        }
        return i8 - i6;
    }
}
