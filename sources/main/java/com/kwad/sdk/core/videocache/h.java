package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import com.kwad.sdk.core.network.r;
import com.kwad.sdk.utils.ax;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class h extends p {
    private final com.kwad.sdk.core.videocache.d.c aKN;
    private final com.kwad.sdk.core.videocache.b.b aKO;
    private n aLl;
    private HttpURLConnection aLm;
    private InputStream aLn;

    public h(String str, com.kwad.sdk.core.videocache.d.c cVar, com.kwad.sdk.core.videocache.b.b bVar) {
        this.aKN = (com.kwad.sdk.core.videocache.d.c) ax.checkNotNull(cVar);
        this.aKO = (com.kwad.sdk.core.videocache.b.b) ax.checkNotNull(bVar);
        n eS = cVar.eS(str);
        this.aLl = eS == null ? new n(str, -2147483648L, l.eQ(str)) : eS;
    }

    private long a(HttpURLConnection httpURLConnection, long j6, int i6) {
        long d6 = d(httpURLConnection);
        return i6 == 200 ? d6 : i6 == 206 ? d6 + j6 : this.aLl.aLB;
    }

    @Override // com.kwad.sdk.core.videocache.p
    public final synchronized String Ku() {
        try {
            if (TextUtils.isEmpty(this.aLl.aLC)) {
                Kv();
            }
            if (TextUtils.isEmpty(this.aLl.aLC)) {
                Kt();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.aLl.aLC;
    }

    @Override // com.kwad.sdk.core.videocache.m
    public final void aK(long j6) {
        try {
            HttpURLConnection e6 = e(j6, -1);
            this.aLm = e6;
            String contentType = e6.getContentType();
            this.aLn = new BufferedInputStream(this.aLm.getInputStream(), 1024);
            HttpURLConnection httpURLConnection = this.aLm;
            n nVar = new n(this.aLl.url, a(httpURLConnection, j6, httpURLConnection.getResponseCode()), contentType);
            this.aLl = nVar;
            this.aKN.a(nVar.url, nVar);
        } catch (IOException e7) {
            throw new ProxyCacheException("Error opening connection for " + this.aLl.url + " with offset " + j6, e7);
        }
    }

    @Override // com.kwad.sdk.core.videocache.m
    public final synchronized long length() {
        try {
            if (this.aLl.aLB == -2147483648L) {
                Kv();
            }
            if (this.aLl.aLB == -2147483648L) {
                Kt();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.aLl.aLB;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.net.URLConnection] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.net.URLConnection] */
    private void Kt() {
        HttpURLConnection httpURLConnection;
        com.kwad.sdk.core.d.c.d("HttpUrlSource", "Read content info from " + this.aLl.url);
        ?? r02 = 10000;
        InputStream inputStream = null;
        try {
            try {
                httpURLConnection = e(0L, 10000);
            } catch (IOException unused) {
                httpURLConnection = null;
            } catch (Throwable th) {
                th = th;
                r02 = 0;
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly((URLConnection) r02);
                throw th;
            }
            try {
                long d6 = d(httpURLConnection);
                String contentType = httpURLConnection.getContentType();
                inputStream = httpURLConnection.getInputStream();
                n nVar = new n(this.aLl.url, d6, contentType);
                this.aLl = nVar;
                this.aKN.a(nVar.url, nVar);
                com.kwad.sdk.core.d.c.d("HttpUrlSource", "Source info fetched: " + this.aLl);
                r02 = httpURLConnection;
            } catch (IOException unused2) {
                com.kwad.sdk.core.d.c.e("HttpUrlSource", "Error fetching info from " + this.aLl.url);
                r02 = httpURLConnection;
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly((URLConnection) r02);
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            com.kwad.sdk.crash.utils.b.closeQuietly((URLConnection) r02);
        } catch (Throwable th2) {
            th = th2;
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            com.kwad.sdk.crash.utils.b.closeQuietly((URLConnection) r02);
            throw th;
        }
    }

    private void Kv() {
        n eS;
        com.kwad.sdk.core.videocache.d.c cVar = this.aKN;
        if (cVar == null || !(cVar instanceof com.kwad.sdk.core.videocache.d.b) || (eS = cVar.eS(getUrl())) == null || TextUtils.isEmpty(eS.aLC) || eS.aLB == -2147483648L) {
            return;
        }
        this.aLl = eS;
    }

    private static long d(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (headerField == null) {
            return -1L;
        }
        return Long.parseLong(headerField);
    }

    private HttpURLConnection e(long j6, int i6) {
        String str;
        HttpURLConnection httpURLConnection;
        boolean z5;
        String str2 = this.aLl.url;
        int i7 = 0;
        do {
            StringBuilder sb = new StringBuilder("Open connection ");
            if (j6 > 0) {
                str = " with offset " + j6;
            } else {
                str = "";
            }
            sb.append(str);
            sb.append(" to ");
            sb.append(str2);
            com.kwad.sdk.core.d.c.d("HttpUrlSource", sb.toString());
            httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            r.wrapHttpURLConnection(httpURLConnection);
            a(httpURLConnection, str2);
            if (j6 > 0) {
                httpURLConnection.setRequestProperty("Range", "bytes=" + j6 + "-");
            }
            if (i6 > 0) {
                httpURLConnection.setConnectTimeout(i6);
                httpURLConnection.setReadTimeout(i6);
            }
            com.kwad.sdk.core.network.p.b(httpURLConnection);
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

    @Override // com.kwad.sdk.core.videocache.m
    public final void close() {
        HttpURLConnection httpURLConnection = this.aLm;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (ArrayIndexOutOfBoundsException unused) {
                com.kwad.sdk.core.d.c.e("HttpUrlSource", "Error closing connection correctly. Should happen only on Android L. If anybody know how to fix it, please visit https://github.com/danikula/AndroidVideoCache/issues/88. Until good solution is not know, just ignore this issue.");
            } catch (IllegalArgumentException e6) {
                e = e6;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            } catch (NullPointerException e7) {
                e = e7;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            }
        }
    }

    @Override // com.kwad.sdk.core.videocache.p
    public final String getUrl() {
        return this.aLl.url;
    }

    @Override // com.kwad.sdk.core.videocache.m
    public final int read(byte[] bArr) {
        InputStream inputStream = this.aLn;
        if (inputStream == null) {
            throw new ProxyCacheException("Error reading data from " + this.aLl.url + ": connection is absent!");
        }
        try {
            return inputStream.read(bArr, 0, 1024);
        } catch (InterruptedIOException e6) {
            throw new InterruptedProxyCacheException("Reading source " + this.aLl.url + " is interrupted", e6);
        } catch (IOException e7) {
            throw new ProxyCacheException("Error reading data from " + this.aLl.url, e7);
        }
    }

    @Override // com.kwad.sdk.core.videocache.p
    public final String toString() {
        return "HttpUrlSource{sourceInfo='" + this.aLl + "}";
    }

    private void a(HttpURLConnection httpURLConnection, String str) {
        for (Map.Entry<String, String> entry : this.aKO.KC().entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    public h(h hVar) {
        this.aLl = hVar.aLl;
        this.aKN = hVar.aKN;
        this.aKO = hVar.aKO;
    }
}
