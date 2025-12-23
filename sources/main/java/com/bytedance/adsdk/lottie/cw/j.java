package com.bytedance.adsdk.lottie.cw;

import com.bytedance.component.sdk.annotation.RestrictTo;
import com.snail.antifake.deviceid.e;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: D:\Downloads\app\classes3.dex */
public class j implements r {

    /* renamed from: j, reason: collision with root package name */
    private final HttpURLConnection f23223j;

    @Override // com.bytedance.adsdk.lottie.cw.r
    public boolean j() {
        try {
            return this.f23223j.getResponseCode() / 100 == 2;
        } catch (IOException unused) {
            return false;
        }
    }

    private String j(HttpURLConnection httpURLConnection) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                    sb.append('\n');
                } else {
                    try {
                        break;
                    } catch (Exception unused) {
                    }
                }
            } finally {
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
            }
        }
        return sb.toString();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f23223j.disconnect();
    }

    @Override // com.bytedance.adsdk.lottie.cw.r
    public String cw() {
        return this.f23223j.getContentType();
    }

    @Override // com.bytedance.adsdk.lottie.cw.r
    public InputStream xt() throws IOException {
        return this.f23223j.getInputStream();
    }

    public j(HttpURLConnection httpURLConnection) {
        this.f23223j = httpURLConnection;
    }

    @Override // com.bytedance.adsdk.lottie.cw.r
    public String r() {
        try {
            if (j()) {
                return null;
            }
            return "Unable to fetch " + this.f23223j.getURL() + ". Failed with " + this.f23223j.getResponseCode() + e.f37542d + j(this.f23223j);
        } catch (IOException e6) {
            com.bytedance.adsdk.lottie.up.up.j("get error failed ", e6);
            return e6.getMessage();
        }
    }
}
