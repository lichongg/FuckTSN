package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import com.kwad.sdk.utils.ax;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class j extends p {
    private final com.kwad.sdk.core.videocache.d.c aKN;
    private final com.kwad.sdk.core.videocache.b.b aKO;
    private n aLl;
    private InputStream aLn;
    private OkHttpClient aLs = new OkHttpClient();

    public j(String str, com.kwad.sdk.core.videocache.d.c cVar, com.kwad.sdk.core.videocache.b.b bVar) {
        this.aKN = (com.kwad.sdk.core.videocache.d.c) ax.checkNotNull(cVar);
        this.aKO = (com.kwad.sdk.core.videocache.b.b) ax.checkNotNull(bVar);
        n eS = cVar.eS(str);
        this.aLl = eS == null ? new n(str, -2147483648L, l.eQ(str)) : eS;
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
            Response f6 = f(j6, -1);
            String mediaType = f6.body().contentType().toString();
            long a6 = a(f6, j6);
            this.aLn = new BufferedInputStream(f6.body().byteStream(), 1024);
            n nVar = new n(this.aLl.url, a6, mediaType);
            this.aLl = nVar;
            this.aKN.a(nVar.url, nVar);
        } catch (IOException e6) {
            throw new ProxyCacheException("Error opening connection for " + getUrl() + " with offset " + j6, e6);
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

    private void Kt() {
        Response response = null;
        try {
            try {
                response = dP(10000);
            } catch (IOException unused) {
                com.kwad.sdk.core.d.c.e("HttpUrlSource", "Error fetching info from " + this.aLl.url);
                if (0 == 0 || response.body() == null) {
                    return;
                }
            }
            if (response == null || !response.isSuccessful()) {
                throw new ProxyCacheException("Fail to fetchContentInfo: " + getUrl());
            }
            n nVar = new n(this.aLl.url, c(response), response.header("Content-Type"));
            this.aLl = nVar;
            this.aKN.a(nVar.url, nVar);
            com.kwad.sdk.core.d.c.d("HttpUrlSource", "Source info fetched: " + this.aLl);
            if (response.body() == null) {
                return;
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(response.body());
        } catch (Throwable th) {
            if (0 != 0 && response.body() != null) {
                com.kwad.sdk.crash.utils.b.closeQuietly(response.body());
            }
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

    private static long c(Response response) {
        String header = response.header("Content-Length");
        if (header == null) {
            return -1L;
        }
        return Long.parseLong(header);
    }

    private Response dP(int i6) {
        Response execute;
        OkHttpClient.Builder newBuilder = new OkHttpClient().newBuilder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        newBuilder.connectTimeout(10000L, timeUnit);
        newBuilder.readTimeout(10000L, timeUnit);
        newBuilder.writeTimeout(10000L, timeUnit);
        int i7 = 0;
        newBuilder.connectionSpecs(Arrays.asList(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT));
        try {
            newBuilder.dns(new com.kwad.sdk.core.network.a.d());
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
        this.aLs = newBuilder.build();
        String url = getUrl();
        boolean z5 = false;
        do {
            Request.Builder builder = new Request.Builder();
            builder.head();
            builder.url(url);
            execute = this.aLs.newCall(builder.build()).execute();
            if (execute.isRedirect()) {
                url = execute.header("Location");
                z5 = execute.isRedirect();
                i7++;
            }
            if (i7 > 5) {
                throw new ProxyCacheException("Too many redirects: " + i7);
            }
        } while (z5);
        return execute;
    }

    private Response f(long j6, int i6) {
        Response execute;
        OkHttpClient.Builder newBuilder = this.aLs.newBuilder();
        int i7 = 0;
        newBuilder.connectionSpecs(Arrays.asList(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT));
        try {
            newBuilder.dns(new com.kwad.sdk.core.network.a.d());
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
        this.aLs = newBuilder.build();
        String url = getUrl();
        boolean z5 = false;
        do {
            Request.Builder builder = new Request.Builder();
            builder.get();
            builder.url(url);
            if (j6 > 0) {
                builder.addHeader("Range", "bytes=" + j6 + "-");
            }
            execute = this.aLs.newCall(builder.build()).execute();
            if (execute.isRedirect()) {
                url = execute.header("Location");
                z5 = execute.isRedirect();
                i7++;
            }
            if (i7 > 5) {
                throw new ProxyCacheException("Too many redirects: " + i7);
            }
        } while (z5);
        return execute;
    }

    @Override // com.kwad.sdk.core.videocache.m
    public final void close() {
        com.kwad.sdk.crash.utils.b.closeQuietly(this.aLn);
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

    private long a(Response response, long j6) {
        int code = response.code();
        long contentLength = response.body().contentLength();
        if (code == 200) {
            return contentLength;
        }
        if (code == 206) {
            return contentLength + j6;
        }
        return this.aLl.aLB;
    }

    public j(j jVar) {
        this.aLl = jVar.aLl;
        this.aKN = jVar.aKN;
        this.aKO = jVar.aKO;
    }
}
