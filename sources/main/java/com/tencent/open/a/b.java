package com.tencent.open.a;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.tencent.open.log.SLog;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import kotlin.text.v0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class b implements a {

    /* renamed from: a, reason: collision with root package name */
    private int f40488a = 15000;

    /* renamed from: b, reason: collision with root package name */
    private int f40489b = KSImageLoader.InnerImageLoadingListener.MAX_DURATION;

    /* renamed from: c, reason: collision with root package name */
    private final String f40490c;

    @Override // com.tencent.open.a.a
    public void a(long j6, long j7) {
        if (j6 <= 0 || j7 <= 0) {
            return;
        }
        this.f40488a = (int) j6;
        this.f40489b = (int) j7;
    }

    private static void b(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            return;
        }
        try {
            httpURLConnection.disconnect();
        } catch (Exception unused) {
        }
    }

    public b(String str) {
        this.f40490c = str;
    }

    @Override // com.tencent.open.a.a
    public g a(String str, String str2) throws IOException {
        SLog.i("DefaultHttpServiceImpl", "get. ");
        if (!TextUtils.isEmpty(str2)) {
            int indexOf = str2.indexOf("?");
            if (indexOf == -1) {
                str = str + "?";
            } else if (indexOf != str.length() - 1) {
                str = str + ContainerUtils.FIELD_DELIMITER;
            }
            str = str + str2;
        }
        return a(str, str2.length());
    }

    @Override // com.tencent.open.a.a
    public g a(String str, Map<String, String> map) throws IOException {
        SLog.i("DefaultHttpServiceImpl", "post. ");
        StringBuilder sb = new StringBuilder();
        boolean z5 = true;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (z5) {
                z5 = false;
            } else {
                sb.append(v0.f47960d);
            }
            sb.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            sb.append('=');
            sb.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
        }
        String sb2 = sb.toString();
        return a(str, sb2.length(), sb2);
    }

    @Override // com.tencent.open.a.a
    public g a(String str, Map<String, String> map, Map<String, byte[]> map2) throws IOException {
        if (map2 != null && map2.size() > 0) {
            Iterator<Map.Entry<String, byte[]>> it = map2.entrySet().iterator();
            if (!it.hasNext()) {
                return null;
            }
            Map.Entry<String, byte[]> next = it.next();
            return a(str, map, next.getKey(), next.getValue());
        }
        return a(str, map);
    }

    private void a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            return;
        }
        httpURLConnection.setRequestProperty("User-Agent", this.f40490c);
        httpURLConnection.setConnectTimeout(this.f40488a);
        httpURLConnection.setReadTimeout(this.f40489b);
        httpURLConnection.setRequestProperty("Accept-Language", "zh-CN");
        httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
        httpURLConnection.setRequestProperty("Charset", "UTF-8");
    }

    private g a(String str, int i6) throws IOException {
        Throwable th;
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        c cVar;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setRequestMethod("GET");
                a(httpURLConnection);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(false);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.connect();
                if (httpURLConnection.getResponseCode() == 200) {
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        cVar = new c(httpURLConnection, byteArrayOutputStream.toString(), httpURLConnection.getContentLength(), i6, httpURLConnection.getResponseCode(), "");
                        a(byteArrayOutputStream);
                        a(inputStream);
                    } catch (Throwable th3) {
                        th = th3;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        a(byteArrayOutputStream2);
                        a(inputStream);
                        b(httpURLConnection);
                        throw th;
                    }
                } else {
                    String responseMessage = httpURLConnection.getResponseMessage();
                    if (responseMessage == null) {
                        responseMessage = "请求失败 code:" + httpURLConnection.getResponseCode();
                    }
                    cVar = new c(httpURLConnection, "", httpURLConnection.getContentLength(), i6, httpURLConnection.getResponseCode(), responseMessage);
                    a((Closeable) null);
                    a((Closeable) null);
                }
                b(httpURLConnection);
                return cVar;
            } catch (Throwable th4) {
                th = th4;
                inputStream = null;
            }
        } catch (Throwable th5) {
            th = th5;
            httpURLConnection = null;
            inputStream = null;
        }
    }

    private g a(String str, int i6, String str2) throws IOException {
        Throwable th;
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        c cVar;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setRequestMethod("POST");
                a(httpURLConnection);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8");
                outputStreamWriter.write(str2);
                outputStreamWriter.flush();
                httpURLConnection.connect();
                int contentLength = httpURLConnection.getContentLength();
                if (httpURLConnection.getResponseCode() == 200) {
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream2.write(bArr, 0, read);
                            }
                            cVar = new c(httpURLConnection, byteArrayOutputStream2.toString(), contentLength, i6, httpURLConnection.getResponseCode(), "");
                            a(byteArrayOutputStream2);
                            a(inputStream);
                        } catch (Throwable th2) {
                            th = th2;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            a(byteArrayOutputStream);
                            a(inputStream);
                            b(httpURLConnection);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } else {
                    String responseMessage = httpURLConnection.getResponseMessage();
                    if (responseMessage == null) {
                        responseMessage = "Unknown fail: " + httpURLConnection.getResponseCode();
                    }
                    cVar = new c(httpURLConnection, "", 0, i6, httpURLConnection.getResponseCode(), responseMessage);
                    a((Closeable) null);
                    a((Closeable) null);
                }
                b(httpURLConnection);
                return cVar;
            } catch (Throwable th4) {
                th = th4;
                inputStream = null;
            }
        } catch (Throwable th5) {
            th = th5;
            inputStream = null;
            httpURLConnection = null;
        }
    }

    public g a(String str, Map<String, String> map, String str2, byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        DataOutputStream dataOutputStream;
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        DataOutputStream dataOutputStream2;
        int i6;
        String str3;
        InputStream inputStream2;
        ByteArrayOutputStream byteArrayOutputStream2;
        Map<String, String> map2 = map;
        SLog.i("DefaultHttpServiceImpl", "文件上传");
        String uuid = UUID.randomUUID().toString();
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + uuid);
                try {
                    a(httpURLConnection);
                    httpURLConnection.connect();
                    dataOutputStream2 = new DataOutputStream(httpURLConnection.getOutputStream());
                    if (map2 != null) {
                        try {
                            if (map2.size() > 0) {
                                Iterator<String> it = map2.keySet().iterator();
                                while (it.hasNext()) {
                                    StringBuffer stringBuffer = new StringBuffer();
                                    String encode = URLEncoder.encode(it.next(), "UTF-8");
                                    String encode2 = URLEncoder.encode(map2.get(encode), "UTF-8");
                                    stringBuffer.append("--");
                                    stringBuffer.append(uuid);
                                    stringBuffer.append(org.apache.commons.net.g.f50795q);
                                    stringBuffer.append("Content-Disposition: form-data; name=\"");
                                    stringBuffer.append(encode);
                                    stringBuffer.append("\"");
                                    stringBuffer.append(org.apache.commons.net.g.f50795q);
                                    stringBuffer.append(org.apache.commons.net.g.f50795q);
                                    stringBuffer.append(encode2);
                                    stringBuffer.append(org.apache.commons.net.g.f50795q);
                                    String stringBuffer2 = stringBuffer.toString();
                                    SLog.i("DefaultHttpServiceImpl", encode + ContainerUtils.KEY_VALUE_DELIMITER + stringBuffer2 + "##");
                                    dataOutputStream2.write(stringBuffer2.getBytes());
                                    map2 = map;
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            dataOutputStream = dataOutputStream2;
                            byteArrayOutputStream = null;
                            inputStream = null;
                            a(dataOutputStream);
                            a(inputStream);
                            a(byteArrayOutputStream);
                            b(httpURLConnection);
                            throw th;
                        }
                    }
                    if (bArr == null || bArr.length <= 0) {
                        i6 = 0;
                    } else {
                        StringBuffer stringBuffer3 = new StringBuffer();
                        stringBuffer3.append("--");
                        stringBuffer3.append(uuid);
                        stringBuffer3.append(org.apache.commons.net.g.f50795q);
                        stringBuffer3.append("Content-Disposition: form-data; name=\"" + str2 + "\"; filename=\"" + str2 + "\"" + org.apache.commons.net.g.f50795q);
                        StringBuilder sb = new StringBuilder();
                        sb.append("Content-Type: application/octet-stream; charset=UTF-8");
                        sb.append(org.apache.commons.net.g.f50795q);
                        stringBuffer3.append(sb.toString());
                        stringBuffer3.append(org.apache.commons.net.g.f50795q);
                        dataOutputStream2.write(stringBuffer3.toString().getBytes());
                        dataOutputStream2.write(bArr, 0, bArr.length);
                        dataOutputStream2.write(org.apache.commons.net.g.f50795q.getBytes());
                        byte[] bytes = ("--" + uuid + "--" + org.apache.commons.net.g.f50795q).getBytes();
                        dataOutputStream2.write(bytes);
                        int length = bytes.length;
                        dataOutputStream2.flush();
                        i6 = length;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream = null;
                    dataOutputStream = null;
                    inputStream = null;
                    a(dataOutputStream);
                    a(inputStream);
                    a(byteArrayOutputStream);
                    b(httpURLConnection);
                    throw th;
                }
                try {
                    int responseCode = httpURLConnection.getResponseCode();
                    SLog.i("DefaultHttpServiceImpl", responseCode + "");
                    if (responseCode == 200) {
                        InputStream inputStream3 = httpURLConnection.getInputStream();
                        try {
                            byteArrayOutputStream = new ByteArrayOutputStream();
                        } catch (Throwable th3) {
                            th = th3;
                            inputStream = inputStream3;
                            dataOutputStream = dataOutputStream2;
                            byteArrayOutputStream = null;
                        }
                        try {
                            byte[] bArr2 = new byte[1024];
                            while (true) {
                                int read = inputStream3.read(bArr2);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr2, 0, read);
                            }
                            str3 = byteArrayOutputStream.toString();
                            inputStream2 = inputStream3;
                            byteArrayOutputStream2 = byteArrayOutputStream;
                        } catch (Throwable th4) {
                            th = th4;
                            inputStream = inputStream3;
                            dataOutputStream = dataOutputStream2;
                            a(dataOutputStream);
                            a(inputStream);
                            a(byteArrayOutputStream);
                            b(httpURLConnection);
                            throw th;
                        }
                    } else {
                        str3 = httpURLConnection.getResponseCode() + "";
                        inputStream2 = null;
                        byteArrayOutputStream2 = null;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    dataOutputStream = dataOutputStream2;
                    byteArrayOutputStream = null;
                    inputStream = null;
                    a(dataOutputStream);
                    a(inputStream);
                    a(byteArrayOutputStream);
                    b(httpURLConnection);
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Throwable th7) {
            th = th7;
            byteArrayOutputStream = null;
            dataOutputStream = null;
            httpURLConnection = null;
        }
        try {
            c cVar = new c(httpURLConnection, str3, httpURLConnection.getContentLength(), i6, httpURLConnection.getResponseCode(), "");
            a(dataOutputStream2);
            a(inputStream2);
            a(byteArrayOutputStream2);
            b(httpURLConnection);
            return cVar;
        } catch (Throwable th8) {
            th = th8;
            byteArrayOutputStream = byteArrayOutputStream2;
            inputStream = inputStream2;
            dataOutputStream = dataOutputStream2;
            a(dataOutputStream);
            a(inputStream);
            a(byteArrayOutputStream);
            b(httpURLConnection);
            throw th;
        }
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }
}
