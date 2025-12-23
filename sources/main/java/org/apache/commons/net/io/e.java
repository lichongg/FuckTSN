package org.apache.commons.net.io;

import java.io.IOException;
import java.io.Writer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class e extends Writer {

    /* renamed from: c, reason: collision with root package name */
    private static final int f50844c = 0;

    /* renamed from: d, reason: collision with root package name */
    private static final int f50845d = 1;

    /* renamed from: e, reason: collision with root package name */
    private static final int f50846e = 2;

    /* renamed from: a, reason: collision with root package name */
    private int f50847a;

    /* renamed from: b, reason: collision with root package name */
    private Writer f50848b;

    @Override // java.io.Writer
    public void write(int i6) throws IOException {
        synchronized (((Writer) this).lock) {
            try {
                if (i6 == 10) {
                    if (this.f50847a != 1) {
                        this.f50848b.write(13);
                    }
                    this.f50848b.write(10);
                    this.f50847a = 2;
                    return;
                }
                if (i6 == 13) {
                    this.f50847a = 1;
                    this.f50848b.write(13);
                    return;
                }
                if (i6 == 46 && this.f50847a == 2) {
                    this.f50848b.write(46);
                }
                this.f50847a = 0;
                this.f50848b.write(i6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (((Writer) this).lock) {
            try {
                Writer writer = this.f50848b;
                if (writer == null) {
                    return;
                }
                int i6 = this.f50847a;
                if (i6 == 1) {
                    writer.write(10);
                } else if (i6 != 2) {
                    writer.write(org.apache.commons.net.g.f50795q);
                }
                this.f50848b.write(".\r\n");
                this.f50848b.flush();
                this.f50848b = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        synchronized (((Writer) this).lock) {
            this.f50848b.flush();
        }
    }

    public e(Writer writer) {
        super(writer);
        this.f50848b = writer;
        this.f50847a = 0;
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i6, int i7) throws IOException {
        synchronized (((Writer) this).lock) {
            while (true) {
                int i8 = i7 - 1;
                if (i7 > 0) {
                    int i9 = i6 + 1;
                    try {
                        write(cArr[i6]);
                        i6 = i9;
                        i7 = i8;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                throw th;
            }
        }
    }

    @Override // java.io.Writer
    public void write(char[] cArr) throws IOException {
        write(cArr, 0, cArr.length);
    }

    @Override // java.io.Writer
    public void write(String str) throws IOException {
        write(str.toCharArray());
    }

    @Override // java.io.Writer
    public void write(String str, int i6, int i7) throws IOException {
        write(str.toCharArray(), i6, i7);
    }
}
