package com.ss.android.socialbase.downloader.impls;

import android.net.Uri;
import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.GZIPInputStream;
import okhttp3.Call;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: D:\Downloads\app\classes6.dex */
public class ae implements com.ss.android.socialbase.downloader.g.oq {

    /* renamed from: j, reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.az.tl<String, OkHttpClient> f38831j = new com.ss.android.socialbase.downloader.az.tl<>(4, 8);

    @Override // com.ss.android.socialbase.downloader.g.oq
    public com.ss.android.socialbase.downloader.g.g j(int i6, String str, List<com.ss.android.socialbase.downloader.ae.up> list) throws IOException {
        String str2;
        Request.Builder url = new Request.Builder().url(str);
        if (list == null || list.size() <= 0) {
            str2 = null;
        } else {
            str2 = null;
            for (com.ss.android.socialbase.downloader.ae.up upVar : list) {
                String j6 = upVar.j();
                if (str2 == null && "ss_d_request_host_ip_114".equals(j6)) {
                    str2 = upVar.xt();
                } else {
                    url.addHeader(j6, com.ss.android.socialbase.downloader.az.m.ae(upVar.xt()));
                }
            }
        }
        OkHttpClient j7 = !TextUtils.isEmpty(str2) ? j(str, str2) : com.ss.android.socialbase.downloader.downloader.cw.w();
        if (j7 == null) {
            throw new IOException("can't get httpClient");
        }
        final Call newCall = j7.newCall(url.build());
        final Response execute = newCall.execute();
        if (execute == null) {
            throw new IOException("can't get response");
        }
        final ResponseBody body = execute.body();
        if (body == null) {
            return null;
        }
        InputStream byteStream = body.byteStream();
        String header = execute.header("Content-Encoding");
        final InputStream gZIPInputStream = (header == null || !"gzip".equalsIgnoreCase(header) || (byteStream instanceof GZIPInputStream)) ? byteStream : new GZIPInputStream(byteStream);
        return new com.ss.android.socialbase.downloader.g.up() { // from class: com.ss.android.socialbase.downloader.impls.ae.1
            @Override // com.ss.android.socialbase.downloader.g.g
            public InputStream j() throws IOException {
                return gZIPInputStream;
            }

            @Override // com.ss.android.socialbase.downloader.g.ae
            public void cw() {
                Call call = newCall;
                if (call == null || call.isCanceled()) {
                    return;
                }
                newCall.cancel();
            }

            @Override // com.ss.android.socialbase.downloader.g.ae
            public String j(String str3) {
                return execute.header(str3);
            }

            @Override // com.ss.android.socialbase.downloader.g.g
            public void r() {
                try {
                    ResponseBody responseBody = body;
                    if (responseBody != null) {
                        responseBody.close();
                    }
                    Call call = newCall;
                    if (call == null || call.isCanceled()) {
                        return;
                    }
                    newCall.cancel();
                } catch (Throwable unused) {
                }
            }

            @Override // com.ss.android.socialbase.downloader.g.j
            public String up() {
                return "";
            }

            @Override // com.ss.android.socialbase.downloader.g.ae
            public int xt() throws IOException {
                return execute.code();
            }
        };
    }

    private OkHttpClient j(String str, final String str2) {
        try {
            final String host = Uri.parse(str).getHost();
            if (!TextUtils.isEmpty(host) && !TextUtils.isEmpty(str2)) {
                String str3 = host + "_" + str2;
                synchronized (this.f38831j) {
                    try {
                        OkHttpClient okHttpClient = this.f38831j.get(str3);
                        if (okHttpClient != null) {
                            return okHttpClient;
                        }
                        OkHttpClient.Builder kt = com.ss.android.socialbase.downloader.downloader.cw.kt();
                        kt.dns(new Dns() { // from class: com.ss.android.socialbase.downloader.impls.ae.2
                        });
                        OkHttpClient build = kt.build();
                        synchronized (this.f38831j) {
                            this.f38831j.put(str3, build);
                        }
                        return build;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.vl.j(th2);
        }
        return com.ss.android.socialbase.downloader.downloader.cw.w();
    }
}
