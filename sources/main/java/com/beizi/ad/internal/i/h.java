package com.beizi.ad.internal.i;

import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class h implements o {

    /* renamed from: a, reason: collision with root package name */
    private final com.beizi.ad.internal.i.b.c f12243a;

    /* renamed from: b, reason: collision with root package name */
    private p f12244b;

    /* renamed from: c, reason: collision with root package name */
    private HttpURLConnection f12245c;

    /* renamed from: d, reason: collision with root package name */
    private InputStream f12246d;

    public h(String str) {
        this(str, com.beizi.ad.internal.i.b.d.a());
    }

    private void e() throws m {
        HttpURLConnection httpURLConnection;
        InputStream inputStream = null;
        try {
            httpURLConnection = a(0, 10000);
            try {
                int contentLength = httpURLConnection.getContentLength();
                String contentType = httpURLConnection.getContentType();
                inputStream = httpURLConnection.getInputStream();
                p pVar = new p(this.f12244b.f12260a, contentLength, contentType);
                this.f12244b = pVar;
                this.f12243a.a(pVar.f12260a, pVar);
                n.a(inputStream);
                httpURLConnection.disconnect();
            } catch (IOException unused) {
                n.a(inputStream);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            } catch (Throwable th) {
                th = th;
                n.a(inputStream);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (IOException unused2) {
            httpURLConnection = null;
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection = null;
        }
    }

    @Override // com.beizi.ad.internal.i.o
    public synchronized int a() throws m {
        try {
            if (this.f12244b.f12261b == Integer.MIN_VALUE) {
                e();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f12244b.f12261b;
    }

    public synchronized String c() throws m {
        try {
            if (TextUtils.isEmpty(this.f12244b.f12262c)) {
                e();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f12244b.f12262c;
    }

    public h(String str, com.beizi.ad.internal.i.b.c cVar) {
        this.f12243a = (com.beizi.ad.internal.i.b.c) k.a(cVar);
        p a6 = cVar.a(str);
        this.f12244b = a6 == null ? new p(str, Integer.MIN_VALUE, n.a(str)) : a6;
    }

    @Override // com.beizi.ad.internal.i.o
    public void b() throws m {
        HttpURLConnection httpURLConnection = this.f12245c;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (IllegalArgumentException | NullPointerException e6) {
                throw new RuntimeException("Wait... but why? WTF!? ", e6);
            }
        }
    }

    public String d() {
        return this.f12244b.f12260a;
    }

    public String toString() {
        return "HttpUrlSource{sourceInfo='" + this.f12244b + "}";
    }

    @Override // com.beizi.ad.internal.i.o
    public void a(int i6) throws m {
        try {
            HttpURLConnection a6 = a(i6, -1);
            this.f12245c = a6;
            String contentType = a6.getContentType();
            this.f12246d = new BufferedInputStream(this.f12245c.getInputStream(), 8192);
            HttpURLConnection httpURLConnection = this.f12245c;
            p pVar = new p(this.f12244b.f12260a, a(httpURLConnection, i6, httpURLConnection.getResponseCode()), contentType);
            this.f12244b = pVar;
            this.f12243a.a(pVar.f12260a, pVar);
        } catch (IOException e6) {
            throw new m("Error opening connection for " + this.f12244b.f12260a + " with offset " + i6, e6);
        }
    }

    public h(h hVar) {
        this.f12244b = hVar.f12244b;
        this.f12243a = hVar.f12243a;
    }

    private int a(HttpURLConnection httpURLConnection, int i6, int i7) throws IOException {
        int contentLength = httpURLConnection.getContentLength();
        return i7 == 200 ? contentLength : i7 == 206 ? contentLength + i6 : this.f12244b.f12261b;
    }

    @Override // com.beizi.ad.internal.i.o
    public int a(byte[] bArr) throws m {
        InputStream inputStream = this.f12246d;
        if (inputStream != null) {
            try {
                return inputStream.read(bArr, 0, bArr.length);
            } catch (InterruptedIOException e6) {
                throw new i("Reading source " + this.f12244b.f12260a + " is interrupted", e6);
            } catch (IOException e7) {
                throw new m("Error reading data failFrom " + this.f12244b.f12260a, e7);
            }
        }
        throw new m("Error reading data failFrom " + this.f12244b.f12260a + ": connection is absent!");
    }

    private HttpURLConnection a(int i6, int i7) throws IOException, m {
        HttpURLConnection httpURLConnection;
        boolean z5;
        String str = this.f12244b.f12260a;
        int i8 = 0;
        do {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            if (i6 > 0) {
                httpURLConnection.setRequestProperty("Range", "bytes=" + i6 + "-");
            }
            if (i7 > 0) {
                httpURLConnection.setConnectTimeout(i7);
                httpURLConnection.setReadTimeout(i7);
            }
            int responseCode = httpURLConnection.getResponseCode();
            z5 = responseCode == 301 || responseCode == 302 || responseCode == 303;
            if (z5) {
                str = httpURLConnection.getHeaderField("Location");
                i8++;
                httpURLConnection.disconnect();
            }
            if (i8 > 5) {
                throw new m("Too many redirects: " + i8);
            }
        } while (z5);
        return httpURLConnection;
    }
}
