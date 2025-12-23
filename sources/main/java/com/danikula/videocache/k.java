package com.danikula.videocache;

import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class k implements q {

    /* renamed from: e, reason: collision with root package name */
    private static final org.slf4j.c f32210e = org.slf4j.d.j("HttpUrlSource");

    /* renamed from: f, reason: collision with root package name */
    private static final int f32211f = 5;

    /* renamed from: a, reason: collision with root package name */
    private final com.danikula.videocache.sourcestorage.c f32212a;

    /* renamed from: b, reason: collision with root package name */
    private s f32213b;

    /* renamed from: c, reason: collision with root package name */
    private HttpURLConnection f32214c;

    /* renamed from: d, reason: collision with root package name */
    private InputStream f32215d;

    public k(String str) {
        this(str, com.danikula.videocache.sourcestorage.d.a());
    }

    @Override // com.danikula.videocache.q
    public void a(long j6) throws ProxyCacheException {
        try {
            HttpURLConnection f6 = f(j6, -1);
            this.f32214c = f6;
            String contentType = f6.getContentType();
            this.f32215d = new BufferedInputStream(this.f32214c.getInputStream(), 8192);
            HttpURLConnection httpURLConnection = this.f32214c;
            s sVar = new s(this.f32213b.f32241a, g(httpURLConnection, j6, httpURLConnection.getResponseCode()), contentType);
            this.f32213b = sVar;
            this.f32212a.a(sVar.f32241a, sVar);
        } catch (IOException e6) {
            throw new ProxyCacheException("Error opening connection for " + this.f32213b.f32241a + " with offset " + j6, e6);
        }
    }

    public synchronized String d() throws ProxyCacheException {
        try {
            if (TextUtils.isEmpty(this.f32213b.f32243c)) {
                b();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f32213b.f32243c;
    }

    @Override // com.danikula.videocache.q
    public synchronized long length() throws ProxyCacheException {
        try {
            if (this.f32213b.f32242b == -2147483648L) {
                b();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f32213b.f32242b;
    }

    public k(String str, com.danikula.videocache.sourcestorage.c cVar) {
        this.f32212a = (com.danikula.videocache.sourcestorage.c) n.d(cVar);
        s sVar = cVar.get(str);
        this.f32213b = sVar == null ? new s(str, -2147483648L, p.g(str)) : sVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b() throws com.danikula.videocache.ProxyCacheException {
        /*
            r8 = this;
            org.slf4j.c r0 = com.danikula.videocache.k.f32210e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Read content info from "
            r1.append(r2)
            com.danikula.videocache.s r2 = r8.f32213b
            java.lang.String r2 = r2.f32241a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.debug(r1)
            r1 = 0
            r3 = 10000(0x2710, float:1.4013E-41)
            r4 = 0
            java.net.HttpURLConnection r1 = r8.f(r1, r3)     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L65
            long r2 = r8.c(r1)     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L60
            java.lang.String r5 = r1.getContentType()     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L60
            java.io.InputStream r4 = r1.getInputStream()     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L60
            com.danikula.videocache.s r6 = new com.danikula.videocache.s     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L60
            com.danikula.videocache.s r7 = r8.f32213b     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L60
            java.lang.String r7 = r7.f32241a     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L60
            r6.<init>(r7, r2, r5)     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L60
            r8.f32213b = r6     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L60
            com.danikula.videocache.sourcestorage.c r2 = r8.f32212a     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L60
            java.lang.String r3 = r6.f32241a     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L60
            r2.a(r3, r6)     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L60
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L60
            r2.<init>()     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L60
            java.lang.String r3 = "Source info fetched: "
            r2.append(r3)     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L60
            com.danikula.videocache.s r3 = r8.f32213b     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L60
            r2.append(r3)     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L60
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L60
            r0.debug(r2)     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L60
            com.danikula.videocache.p.c(r4)
            r1.disconnect()
            return
        L5e:
            r0 = move-exception
            goto L8a
        L60:
            r0 = move-exception
            goto L67
        L62:
            r0 = move-exception
            r1 = r4
            goto L8a
        L65:
            r0 = move-exception
            r1 = r4
        L67:
            org.slf4j.c r2 = com.danikula.videocache.k.f32210e     // Catch: java.lang.Throwable -> L5e
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5e
            r3.<init>()     // Catch: java.lang.Throwable -> L5e
            java.lang.String r5 = "Error fetching info from "
            r3.append(r5)     // Catch: java.lang.Throwable -> L5e
            com.danikula.videocache.s r5 = r8.f32213b     // Catch: java.lang.Throwable -> L5e
            java.lang.String r5 = r5.f32241a     // Catch: java.lang.Throwable -> L5e
            r3.append(r5)     // Catch: java.lang.Throwable -> L5e
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L5e
            r2.error(r3, r0)     // Catch: java.lang.Throwable -> L5e
            com.danikula.videocache.p.c(r4)
            if (r1 == 0) goto L89
            r1.disconnect()
        L89:
            return
        L8a:
            com.danikula.videocache.p.c(r4)
            if (r1 == 0) goto L92
            r1.disconnect()
        L92:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.danikula.videocache.k.b():void");
    }

    private long c(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (headerField == null) {
            return -1L;
        }
        return Long.parseLong(headerField);
    }

    private HttpURLConnection f(long j6, int i6) throws IOException, ProxyCacheException {
        String str;
        HttpURLConnection httpURLConnection;
        boolean z5;
        String str2 = this.f32213b.f32241a;
        int i7 = 0;
        do {
            org.slf4j.c cVar = f32210e;
            StringBuilder sb = new StringBuilder();
            sb.append("Open connection ");
            if (j6 > 0) {
                str = " with offset " + j6;
            } else {
                str = "";
            }
            sb.append(str);
            sb.append(" to ");
            sb.append(str2);
            cVar.debug(sb.toString());
            httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            if (j6 > 0) {
                httpURLConnection.setRequestProperty("Range", "bytes=" + j6 + "-");
            }
            if (i6 > 0) {
                httpURLConnection.setConnectTimeout(i6);
                httpURLConnection.setReadTimeout(i6);
            }
            int responseCode = httpURLConnection.getResponseCode();
            z5 = responseCode == 301 || responseCode == 302 || responseCode == 303;
            if (z5) {
                str2 = httpURLConnection.getHeaderField("Location");
                i7++;
                httpURLConnection.disconnect();
            }
            if (i7 > 5) {
                throw new ProxyCacheException("Too many redirects: " + i7);
            }
        } while (z5);
        return httpURLConnection;
    }

    @Override // com.danikula.videocache.q
    public void close() throws ProxyCacheException {
        HttpURLConnection httpURLConnection = this.f32214c;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (ArrayIndexOutOfBoundsException e6) {
                f32210e.error("Error closing connection correctly. Should happen only on Android L. If anybody know how to fix it, please visit https://github.com/danikula/AndroidVideoCache/issues/88. Until good solution is not know, just ignore this issue :(", (Throwable) e6);
            } catch (IllegalArgumentException e7) {
                e = e7;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            } catch (NullPointerException e8) {
                e = e8;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            }
        }
    }

    public String e() {
        return this.f32213b.f32241a;
    }

    @Override // com.danikula.videocache.q
    public int read(byte[] bArr) throws ProxyCacheException {
        InputStream inputStream = this.f32215d;
        if (inputStream == null) {
            throw new ProxyCacheException("Error reading data from " + this.f32213b.f32241a + ": connection is absent!");
        }
        try {
            return inputStream.read(bArr, 0, bArr.length);
        } catch (InterruptedIOException e6) {
            throw new InterruptedProxyCacheException("Reading source " + this.f32213b.f32241a + " is interrupted", e6);
        } catch (IOException e7) {
            throw new ProxyCacheException("Error reading data from " + this.f32213b.f32241a, e7);
        }
    }

    public String toString() {
        return "HttpUrlSource{sourceInfo='" + this.f32213b + "}";
    }

    private long g(HttpURLConnection httpURLConnection, long j6, int i6) throws IOException {
        long c6 = c(httpURLConnection);
        if (i6 == 200) {
            return c6;
        }
        if (i6 == 206) {
            return c6 + j6;
        }
        return this.f32213b.f32242b;
    }

    public k(k kVar) {
        this.f32213b = kVar.f32213b;
        this.f32212a = kVar.f32212a;
    }
}
