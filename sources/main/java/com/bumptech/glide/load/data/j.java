package com.bumptech.glide.load.data;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.data.d;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class j implements d<InputStream> {

    /* renamed from: g, reason: collision with root package name */
    private static final String f14940g = "HttpUrlFetcher";

    /* renamed from: h, reason: collision with root package name */
    private static final int f14941h = 5;

    /* renamed from: i, reason: collision with root package name */
    @VisibleForTesting
    static final String f14942i = "Location";

    /* renamed from: j, reason: collision with root package name */
    @VisibleForTesting
    static final b f14943j = new a();

    /* renamed from: k, reason: collision with root package name */
    @VisibleForTesting
    static final int f14944k = -1;

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.model.g f14945a;

    /* renamed from: b, reason: collision with root package name */
    private final int f14946b;

    /* renamed from: c, reason: collision with root package name */
    private final b f14947c;

    /* renamed from: d, reason: collision with root package name */
    private HttpURLConnection f14948d;

    /* renamed from: e, reason: collision with root package name */
    private InputStream f14949e;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f14950f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface b {
        HttpURLConnection a(URL url) throws IOException;
    }

    public j(com.bumptech.glide.load.model.g gVar, int i6) {
        this(gVar, i6, f14943j);
    }

    private HttpURLConnection d(URL url, Map<String, String> map) throws HttpException {
        try {
            HttpURLConnection a6 = this.f14947c.a(url);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                a6.addRequestProperty(entry.getKey(), entry.getValue());
            }
            a6.setConnectTimeout(this.f14946b);
            a6.setReadTimeout(this.f14946b);
            a6.setUseCaches(false);
            a6.setDoInput(true);
            a6.setInstanceFollowRedirects(false);
            return a6;
        } catch (IOException e6) {
            throw new HttpException("URL.openConnection threw", 0, e6);
        }
    }

    private InputStream i(URL url, int i6, URL url2, Map<String, String> map) throws HttpException {
        if (i6 >= 5) {
            throw new HttpException("Too many (> 5) redirects!", -1);
        }
        if (url2 != null) {
            try {
                if (url.toURI().equals(url2.toURI())) {
                    throw new HttpException("In re-direct loop", -1);
                }
            } catch (URISyntaxException unused) {
            }
        }
        HttpURLConnection d6 = d(url, map);
        this.f14948d = d6;
        try {
            d6.connect();
            this.f14949e = this.f14948d.getInputStream();
            if (this.f14950f) {
                return null;
            }
            int e6 = e(this.f14948d);
            if (g(e6)) {
                return f(this.f14948d);
            }
            if (!h(e6)) {
                if (e6 == -1) {
                    throw new HttpException(e6);
                }
                try {
                    throw new HttpException(this.f14948d.getResponseMessage(), e6);
                } catch (IOException e7) {
                    throw new HttpException("Failed to get a response message", e6, e7);
                }
            }
            String headerField = this.f14948d.getHeaderField("Location");
            if (TextUtils.isEmpty(headerField)) {
                throw new HttpException("Received empty or null redirect url", e6);
            }
            try {
                URL url3 = new URL(url, headerField);
                b();
                return i(url3, i6 + 1, url, map);
            } catch (MalformedURLException e8) {
                throw new HttpException("Bad redirect url: " + headerField, e6, e8);
            }
        } catch (IOException e9) {
            throw new HttpException("Failed to connect or obtain data", e(this.f14948d), e9);
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public void cancel() {
        this.f14950f = true;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a implements b {
        a() {
        }

        @Override // com.bumptech.glide.load.data.j.b
        public HttpURLConnection a(URL url) throws IOException {
            return (HttpURLConnection) url.openConnection();
        }
    }

    @VisibleForTesting
    j(com.bumptech.glide.load.model.g gVar, int i6, b bVar) {
        this.f14945a = gVar;
        this.f14946b = i6;
        this.f14947c = bVar;
    }

    private static boolean g(int i6) {
        return i6 / 100 == 2;
    }

    private static boolean h(int i6) {
        return i6 / 100 == 3;
    }

    @Override // com.bumptech.glide.load.data.d
    @NonNull
    public Class<InputStream> a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.d
    public void b() {
        InputStream inputStream = this.f14949e;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f14948d;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f14948d = null;
    }

    @Override // com.bumptech.glide.load.data.d
    public void c(@NonNull Priority priority, @NonNull d.a<? super InputStream> aVar) {
        long b6 = com.bumptech.glide.util.g.b();
        try {
            try {
                aVar.d(i(this.f14945a.i(), 0, null, this.f14945a.e()));
                if (Log.isLoggable(f14940g, 2)) {
                    com.bumptech.glide.util.g.a(b6);
                }
            } catch (IOException e6) {
                Log.isLoggable(f14940g, 3);
                aVar.e(e6);
                if (Log.isLoggable(f14940g, 2)) {
                    com.bumptech.glide.util.g.a(b6);
                }
            }
        } catch (Throwable th) {
            if (Log.isLoggable(f14940g, 2)) {
                com.bumptech.glide.util.g.a(b6);
            }
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.data.d
    @NonNull
    public DataSource getDataSource() {
        return DataSource.REMOTE;
    }

    private static int e(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getResponseCode();
        } catch (IOException unused) {
            Log.isLoggable(f14940g, 3);
            return -1;
        }
    }

    private InputStream f(HttpURLConnection httpURLConnection) throws HttpException {
        try {
            if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
                this.f14949e = com.bumptech.glide.util.b.b(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
            } else {
                if (Log.isLoggable(f14940g, 3)) {
                    httpURLConnection.getContentEncoding();
                }
                this.f14949e = httpURLConnection.getInputStream();
            }
            return this.f14949e;
        } catch (IOException e6) {
            throw new HttpException("Failed to obtain InputStream", e(httpURLConnection), e6);
        }
    }
}
