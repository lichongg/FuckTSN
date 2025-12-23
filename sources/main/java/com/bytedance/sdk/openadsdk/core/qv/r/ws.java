package com.bytedance.sdk.openadsdk.core.qv.r;

import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ws {
    public static HttpURLConnection j(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.setRequestProperty("accept", "*/*");
                httpURLConnection.setRequestProperty("connection", "Keep-Alive");
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                httpURLConnection.connect();
                int responseCode = httpURLConnection.getResponseCode();
                return ((responseCode < 200 || responseCode >= 300) && responseCode >= 300 && responseCode < 400) ? j(httpURLConnection.getHeaderField("Location"), map) : httpURLConnection;
            } catch (Exception unused) {
                return httpURLConnection;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    public static class j {
        public int cw;

        /* renamed from: j, reason: collision with root package name */
        public InputStream f29987j;

        /* renamed from: r, reason: collision with root package name */
        public HttpURLConnection f29988r;
        public Map<String, String> xt;

        public j(InputStream inputStream, Map<String, String> map, int i6, HttpURLConnection httpURLConnection) {
            this.f29987j = inputStream;
            this.xt = map;
            this.cw = i6;
            this.f29988r = httpURLConnection;
        }
    }

    public static Map<String, String> j(HttpURLConnection httpURLConnection) {
        HashMap hashMap = new HashMap();
        int size = httpURLConnection.getHeaderFields().size();
        for (int i6 = 0; i6 < size; i6++) {
            hashMap.put(httpURLConnection.getHeaderFieldKey(i6), httpURLConnection.getHeaderField(i6));
        }
        return hashMap;
    }

    public static j j(String str, List<com.ss.android.socialbase.downloader.ae.up> list) throws IOException {
        int responseCode;
        HashMap hashMap = new HashMap();
        if (list != null && !list.isEmpty()) {
            for (com.ss.android.socialbase.downloader.ae.up upVar : list) {
                hashMap.put(upVar.j(), upVar.xt());
            }
        }
        HttpURLConnection j6 = j(str, hashMap);
        if (j6 == null || (responseCode = j6.getResponseCode()) < 200 || responseCode >= 300) {
            return null;
        }
        Map<String, String> j7 = j(j6);
        InputStream inputStream = j6.getInputStream();
        String contentEncoding = j6.getContentEncoding();
        if (!TextUtils.isEmpty(contentEncoding) && contentEncoding.contains("gzip")) {
            inputStream = new GZIPInputStream(inputStream);
        }
        return new j(inputStream, j7, responseCode, j6);
    }
}
