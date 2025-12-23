package com.sun.mail.imap;

import com.sun.mail.iap.ConnectionException;
import com.sun.mail.iap.ProtocolException;
import com.sun.mail.util.FolderClosedIOException;
import com.sun.mail.util.MessageRemovedIOException;
import java.io.IOException;
import java.io.InputStream;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.FolderClosedException;
import javax.mail.MessagingException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class f extends InputStream {

    /* renamed from: k, reason: collision with root package name */
    private static final int f39297k = 64;

    /* renamed from: a, reason: collision with root package name */
    private g f39298a;

    /* renamed from: b, reason: collision with root package name */
    private String f39299b;

    /* renamed from: c, reason: collision with root package name */
    private int f39300c = 0;

    /* renamed from: d, reason: collision with root package name */
    private int f39301d;

    /* renamed from: e, reason: collision with root package name */
    private int f39302e;

    /* renamed from: f, reason: collision with root package name */
    private byte[] f39303f;

    /* renamed from: g, reason: collision with root package name */
    private int f39304g;

    /* renamed from: h, reason: collision with root package name */
    private int f39305h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f39306i;

    /* renamed from: j, reason: collision with root package name */
    private com.sun.mail.iap.d f39307j;

    @Override // java.io.InputStream
    public synchronized int available() throws IOException {
        return this.f39304g - this.f39305h;
    }

    @Override // java.io.InputStream
    public synchronized int read() throws IOException {
        if (this.f39305h >= this.f39304g) {
            b();
            if (this.f39305h >= this.f39304g) {
                return -1;
            }
        }
        byte[] bArr = this.f39303f;
        int i6 = this.f39305h;
        this.f39305h = i6 + 1;
        return bArr[i6] & 255;
    }

    private void a() {
        if (this.f39306i) {
            return;
        }
        try {
            Folder folder = this.f39298a.getFolder();
            if (folder == null || folder.getMode() == 1) {
                return;
            }
            g gVar = this.f39298a;
            Flags.Flag flag = Flags.Flag.SEEN;
            if (gVar.isSet(flag)) {
                return;
            }
            this.f39298a.setFlag(flag, true);
        } catch (MessagingException unused) {
        }
    }

    private void b() throws IOException {
        com.sun.mail.iap.d a6;
        int i6;
        int i7 = this.f39302e;
        if (i7 != -1 && (i6 = this.f39300c) >= i7) {
            if (i6 == 0) {
                a();
            }
            this.f39307j = null;
            return;
        }
        if (this.f39307j == null) {
            this.f39307j = new com.sun.mail.iap.d(this.f39301d + 64);
        }
        synchronized (this.f39298a.t()) {
            try {
                try {
                    com.sun.mail.imap.protocol.h v5 = this.f39298a.v();
                    if (this.f39298a.isExpunged()) {
                        throw new MessageRemovedIOException("No content for expunged message");
                    }
                    int w5 = this.f39298a.w();
                    int i8 = this.f39301d;
                    int i9 = this.f39302e;
                    if (i9 != -1) {
                        int i10 = this.f39300c;
                        if (i10 + i8 > i9) {
                            i8 = i9 - i10;
                        }
                    }
                    int i11 = i8;
                    com.sun.mail.imap.protocol.c w02 = this.f39306i ? v5.w0(w5, this.f39299b, this.f39300c, i11, this.f39307j) : v5.O(w5, this.f39299b, this.f39300c, i11, this.f39307j);
                    if (w02 == null || (a6 = w02.a()) == null) {
                        c();
                        throw new IOException("No content");
                    }
                } catch (ProtocolException e6) {
                    c();
                    throw new IOException(e6.getMessage());
                } catch (FolderClosedException e7) {
                    throw new FolderClosedIOException(e7.getFolder(), e7.getMessage());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (this.f39300c == 0) {
            a();
        }
        this.f39303f = a6.a();
        this.f39305h = a6.d();
        int b6 = a6.b();
        this.f39304g = this.f39305h + b6;
        this.f39300c += b6;
    }

    private void c() throws MessageRemovedIOException, FolderClosedIOException {
        synchronized (this.f39298a.t()) {
            try {
                try {
                    this.f39298a.v().r0();
                } catch (ProtocolException unused) {
                } catch (FolderClosedException e6) {
                    throw new FolderClosedIOException(e6.getFolder(), e6.getMessage());
                }
            } catch (ConnectionException e7) {
                throw new FolderClosedIOException(this.f39298a.getFolder(), e7.getMessage());
            }
        }
        if (this.f39298a.isExpunged()) {
            throw new MessageRemovedIOException();
        }
    }

    public f(g gVar, String str, int i6, boolean z5) {
        this.f39298a = gVar;
        this.f39299b = str;
        this.f39302e = i6;
        this.f39306i = z5;
        this.f39301d = gVar.r();
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] bArr, int i6, int i7) throws IOException {
        int i8 = this.f39304g - this.f39305h;
        if (i8 <= 0) {
            b();
            i8 = this.f39304g - this.f39305h;
            if (i8 <= 0) {
                return -1;
            }
        }
        if (i8 < i7) {
            i7 = i8;
        }
        System.arraycopy(this.f39303f, this.f39305h, bArr, i6, i7);
        this.f39305h += i7;
        return i7;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }
}
