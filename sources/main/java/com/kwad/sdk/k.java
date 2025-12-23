package com.kwad.sdk;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.kwad.framework.filedownloader.f.c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.w;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class k implements com.kwad.framework.filedownloader.a.b {
    private final OkHttpClient ask;
    private final Request.Builder asl;
    private Request asm;
    private Response asn;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a implements c.b {
        private volatile OkHttpClient ask;
        private OkHttpClient.Builder aso;

        public a() {
        }

        public a(boolean z5) {
            if (z5) {
                this.aso = k.Cc();
            } else {
                this.aso = k.Cb();
            }
        }

        @Override // com.kwad.framework.filedownloader.f.c.b
        public final com.kwad.framework.filedownloader.a.b bo(String str) {
            if (this.ask == null) {
                synchronized (a.class) {
                    try {
                        if (this.ask == null) {
                            OkHttpClient.Builder builder = this.aso;
                            this.ask = builder != null ? builder.build() : new OkHttpClient();
                            this.aso = null;
                        }
                    } finally {
                    }
                }
            }
            return new k(str, this.ask, (byte) 0);
        }
    }

    /* synthetic */ k(String str, OkHttpClient okHttpClient, byte b6) {
        this(str, okHttpClient);
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final void xS() {
        this.asm = null;
        Response response = this.asn;
        if (response != null && response.body() != null) {
            com.kwad.sdk.crash.utils.b.closeQuietly(this.asn.body());
        }
        this.asn = null;
    }

    private k(Request.Builder builder, OkHttpClient okHttpClient) {
        this.asl = builder;
        this.ask = okHttpClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static OkHttpClient.Builder Cb() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return builder.connectTimeout(10000L, timeUnit).addInterceptor(new com.kwad.sdk.k.a()).readTimeout(0L, timeUnit).connectionPool(new ConnectionPool(6, 60000L, timeUnit)).retryOnConnectionFailure(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static OkHttpClient.Builder Cc() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return builder.connectTimeout(10000L, timeUnit).addInterceptor(new com.kwad.sdk.k.a()).protocols(Util.immutableList(new Protocol[]{Protocol.HTTP_1_1})).readTimeout(0L, timeUnit).connectionPool(new ConnectionPool(6, 60000L, timeUnit)).retryOnConnectionFailure(true);
    }

    private String cj(String str) {
        String bn = bn("Content-Type");
        String extension = w.getExtension(str);
        String str2 = ".apk";
        if (TextUtils.isEmpty(bn) || !TextUtils.isEmpty(extension)) {
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            return System.currentTimeMillis() + ".apk";
        }
        String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(bn);
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        if (!TextUtils.isEmpty(extensionFromMimeType)) {
            str2 = "." + extensionFromMimeType;
        }
        sb.append(str2);
        return sb.toString();
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final void addHeader(String str, String str2) {
        this.asl.addHeader(str, str2);
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final String bn(String str) {
        String str2;
        if (!"Content-Disposition".equals(str)) {
            Response response = this.asn;
            if (response == null) {
                return null;
            }
            return response.header(str);
        }
        try {
        } catch (Exception unused) {
            str2 = "";
        }
        if (!TextUtils.isEmpty(com.kwad.framework.filedownloader.f.f.bE(this.asn.header(str)))) {
            return this.asn.header(str);
        }
        str2 = this.asn.request().url().pathSegments().get(r3.size() - 1);
        return "attachment; filename=\"" + cj(str2) + "\"";
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final void execute() {
        if (this.asm == null) {
            this.asm = this.asl.build();
        }
        this.asn = this.ask.newCall(this.asm).execute();
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final InputStream getInputStream() {
        Response response = this.asn;
        if (response == null) {
            throw new IllegalStateException("Please invoke #execute first!");
        }
        return ((com.kwad.sdk.service.a.j) ServiceProvider.get(com.kwad.sdk.service.a.j.class)).wrapInputStream(response.body().byteStream());
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final int getResponseCode() {
        Response response = this.asn;
        if (response != null) {
            return response.code();
        }
        throw new IllegalStateException("Please invoke #execute first!");
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final Map<String, List<String>> xQ() {
        if (this.asm == null) {
            this.asm = this.asl.build();
        }
        return this.asm.headers().toMultimap();
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final Map<String, List<String>> xR() {
        Response response = this.asn;
        if (response == null) {
            return null;
        }
        return response.headers().toMultimap();
    }

    private k(String str, OkHttpClient okHttpClient) {
        this(new Request.Builder().url(str), okHttpClient);
    }
}
