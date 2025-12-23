package org.apache.commons.net.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class d extends BufferedReader {

    /* renamed from: d, reason: collision with root package name */
    private static final char f50838d = '\n';

    /* renamed from: e, reason: collision with root package name */
    private static final char f50839e = '\r';

    /* renamed from: f, reason: collision with root package name */
    private static final int f50840f = 46;

    /* renamed from: a, reason: collision with root package name */
    private boolean f50841a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f50842b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f50843c;

    @Override // java.io.BufferedReader, java.io.Reader
    public int read() throws IOException {
        synchronized (((BufferedReader) this).lock) {
            try {
                if (this.f50842b) {
                    return -1;
                }
                int read = super.read();
                if (read == -1) {
                    this.f50842b = true;
                    return -1;
                }
                if (this.f50841a) {
                    this.f50841a = false;
                    if (read == 46) {
                        mark(2);
                        int read2 = super.read();
                        if (read2 == -1) {
                            this.f50842b = true;
                            return 46;
                        }
                        if (read2 == 46) {
                            return read2;
                        }
                        if (read2 == 13) {
                            int read3 = super.read();
                            if (read3 == -1) {
                                reset();
                                return 46;
                            }
                            if (read3 == 10) {
                                this.f50841a = true;
                                this.f50842b = true;
                                return -1;
                            }
                        }
                        reset();
                        return 46;
                    }
                }
                if (this.f50843c) {
                    this.f50843c = false;
                    if (read == 10) {
                        this.f50841a = true;
                    }
                }
                if (read == 13) {
                    this.f50843c = true;
                }
                return read;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.io.BufferedReader, java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (((BufferedReader) this).lock) {
            try {
                if (!this.f50842b) {
                    while (read() != -1) {
                    }
                }
                this.f50842b = true;
                this.f50841a = false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.io.BufferedReader
    public String readLine() throws IOException {
        StringBuilder sb = new StringBuilder();
        synchronized (((BufferedReader) this).lock) {
            while (true) {
                try {
                    int read = read();
                    if (read == -1) {
                        String sb2 = sb.toString();
                        if (sb2.length() == 0) {
                            return null;
                        }
                        return sb2;
                    }
                    if (read == 10 && this.f50841a) {
                        return sb.substring(0, sb.length() - 1);
                    }
                    sb.append((char) read);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public d(Reader reader) {
        super(reader);
        this.f50841a = true;
        this.f50842b = false;
    }

    @Override // java.io.Reader
    public int read(char[] cArr) throws IOException {
        return read(cArr, 0, cArr.length);
    }

    @Override // java.io.BufferedReader, java.io.Reader
    public int read(char[] cArr, int i6, int i7) throws IOException {
        int i8;
        if (i7 < 1) {
            return 0;
        }
        synchronized (((BufferedReader) this).lock) {
            try {
                int read = read();
                if (read == -1) {
                    return -1;
                }
                int i9 = i6;
                while (true) {
                    i8 = i9 + 1;
                    cArr[i9] = (char) read;
                    i7--;
                    if (i7 <= 0 || (read = read()) == -1) {
                        break;
                    }
                    i9 = i8;
                }
                return i8 - i6;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
