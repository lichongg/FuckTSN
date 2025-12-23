package com.bytedance.sdk.component.m.xt;

import com.bytedance.sdk.component.utils.vl;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements com.bytedance.sdk.component.m.r<r> {
    private Map<String, String> j(HttpURLConnection httpURLConnection) {
        HashMap hashMap = new HashMap();
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        for (String str : headerFields.keySet()) {
            List<String> list = headerFields.get(str);
            if (list != null && list.size() > 0) {
                hashMap.put(str, list.get(0));
            }
        }
        return hashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v7 */
    @Override // com.bytedance.sdk.component.m.r
    public r call(com.bytedance.sdk.component.m.up upVar) {
        Closeable closeable;
        InputStream inputStream;
        byte[] bArr;
        ByteArrayOutputStream byteArrayOutputStream;
        String message;
        Closeable closeable2;
        HttpURLConnection httpURLConnection;
        InputStream inputStream2 = null;
        Map<String, String> map = null;
        int i6 = 0;
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL(upVar.j()).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.connect();
                inputStream = httpURLConnection.getInputStream();
            } catch (MalformedURLException e6) {
                e = e6;
                inputStream = null;
                bArr = null;
            } catch (IOException e7) {
                e = e7;
                inputStream = null;
                bArr = null;
            } catch (Throwable th) {
                th = th;
                closeable = null;
                com.bytedance.sdk.component.m.cw.cw.xt.j(inputStream2);
                com.bytedance.sdk.component.m.cw.cw.xt.j(closeable);
                throw th;
            }
            try {
                byte[] bArr2 = new byte[1024];
                byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    try {
                        int read = inputStream.read(bArr2);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (MalformedURLException e8) {
                        e = e8;
                        bArr = null;
                    } catch (IOException e9) {
                        e = e9;
                        bArr = null;
                    }
                }
                i6 = 200;
                bArr = byteArrayOutputStream.toByteArray();
            } catch (MalformedURLException e10) {
                e = e10;
                bArr = null;
                byteArrayOutputStream = bArr;
                vl.xt("InternalHttpClient", "MalformedURLException:" + e.getMessage());
                message = e.getMessage();
                closeable2 = byteArrayOutputStream;
                com.bytedance.sdk.component.m.cw.cw.xt.j(inputStream);
                com.bytedance.sdk.component.m.cw.cw.xt.j(closeable2);
                return new r(i6, bArr, message, map);
            } catch (IOException e11) {
                e = e11;
                bArr = null;
                byteArrayOutputStream = bArr;
                vl.xt("InternalHttpClient", "IOException:" + e.getMessage());
                message = e.getMessage();
                closeable2 = byteArrayOutputStream;
                com.bytedance.sdk.component.m.cw.cw.xt.j(inputStream);
                com.bytedance.sdk.component.m.cw.cw.xt.j(closeable2);
                return new r(i6, bArr, message, map);
            } catch (Throwable th2) {
                th = th2;
                closeable = null;
                inputStream2 = inputStream;
                com.bytedance.sdk.component.m.cw.cw.xt.j(inputStream2);
                com.bytedance.sdk.component.m.cw.cw.xt.j(closeable);
                throw th;
            }
            try {
                map = upVar.xt() ? j(httpURLConnection) : null;
                com.bytedance.sdk.component.m.cw.cw.xt.j(inputStream);
                com.bytedance.sdk.component.m.cw.cw.xt.j(byteArrayOutputStream);
                message = "success";
            } catch (MalformedURLException e12) {
                e = e12;
                vl.xt("InternalHttpClient", "MalformedURLException:" + e.getMessage());
                message = e.getMessage();
                closeable2 = byteArrayOutputStream;
                com.bytedance.sdk.component.m.cw.cw.xt.j(inputStream);
                com.bytedance.sdk.component.m.cw.cw.xt.j(closeable2);
                return new r(i6, bArr, message, map);
            } catch (IOException e13) {
                e = e13;
                vl.xt("InternalHttpClient", "IOException:" + e.getMessage());
                message = e.getMessage();
                closeable2 = byteArrayOutputStream;
                com.bytedance.sdk.component.m.cw.cw.xt.j(inputStream);
                com.bytedance.sdk.component.m.cw.cw.xt.j(closeable2);
                return new r(i6, bArr, message, map);
            }
            return new r(i6, bArr, message, map);
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
