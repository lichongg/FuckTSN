package com.kwad.sdk.core.network.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.export.proxy.AdHttpBodyBuilder;
import com.kwad.sdk.export.proxy.AdHttpFormDataBuilder;
import com.kwad.sdk.export.proxy.AdHttpResponseHelper;
import com.kwad.sdk.export.proxy.AdHttpResponseListener;
import com.kwad.sdk.utils.bw;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import okhttp3.ConnectionSpec;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c {
    private static final Pattern aFn = Pattern.compile("Unexpected response code for CONNECT: ([0-9]+)", 2);
    public static String aFo = "UTF-8";
    private static OkHttpClient aFp = null;
    public static OkHttpClient aFq = HE();

    public static com.kwad.sdk.core.network.c a(String str, @Nullable Map<String, String> map, boolean z5, boolean z6) {
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        try {
            Request.Builder url = new Request.Builder().url(str);
            if (z6) {
                a(url);
            }
            a(url, map);
            Response execute = HD().newCall(url.build()).execute();
            int code = execute.code();
            cVar.code = code;
            cVar.aEi = code;
            cVar.aEk = z5 ? a(execute) : "";
            return cVar;
        } catch (Exception e6) {
            a(cVar, e6);
            return cVar;
        }
    }

    private static void b(Request.Builder builder, Map<String, String> map) {
        FormBody formBody;
        if (map == null || map.isEmpty()) {
            formBody = null;
        } else {
            FormBody.Builder builder2 = new FormBody.Builder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry != null) {
                    try {
                        builder2.addEncoded(entry.getKey(), encode(entry.getValue()));
                    } catch (Exception unused) {
                    }
                }
            }
            formBody = builder2.build();
        }
        if (builder == null || formBody == null) {
            return;
        }
        builder.post(formBody);
    }

    public static com.kwad.sdk.core.network.c doGet(String str, @Nullable Map<String, String> map) {
        return a(str, map, true, true);
    }

    public static com.kwad.sdk.core.network.c doPost(String str, Map<String, String> map, JSONObject jSONObject) {
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        try {
            Request.Builder url = new Request.Builder().url(str);
            a(url);
            a(url, map);
            a(url, jSONObject);
            Response execute = HD().newCall(url.build()).execute();
            int code = execute.code();
            cVar.code = code;
            cVar.aEi = code;
            cVar.aEk = a(execute);
            return cVar;
        } catch (Exception e6) {
            a(cVar, e6);
            return cVar;
        }
    }

    public static OkHttpClient HD() {
        if (!com.kwad.framework.a.a.oz.booleanValue()) {
            return aFq;
        }
        if (aFp == null) {
            aFp = aFq.newBuilder().build();
        }
        return aFp;
    }

    private static OkHttpClient HE() {
        if (aFq == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            OkHttpClient.Builder connectionSpecs = builder.connectTimeout(3000L, timeUnit).readTimeout(6000L, timeUnit).connectionSpecs(Arrays.asList(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT));
            try {
                connectionSpecs.dns(new d());
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTrace(th);
            }
            aFq = connectionSpecs.build();
        }
        return aFq;
    }

    public static boolean downloadUrlToStream(String str, OutputStream outputStream, long j6, boolean z5, @Nullable AdHttpResponseListener adHttpResponseListener) {
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        Request.Builder url = new Request.Builder().url(str);
        HashMap hashMap = new HashMap();
        hashMap.put("Accept-Language", "zh-CN");
        if (z5) {
            hashMap.put("Connection", "keep-alive");
        } else {
            hashMap.put("Connection", "close");
        }
        hashMap.put("Charset", "UTF-8");
        a(url);
        a(url, hashMap);
        Response execute = HD().newCall(url.build()).execute();
        int code = execute.code();
        cVar.code = code;
        cVar.aEi = code;
        if (execute.code() != 200) {
            throw new FileNotFoundException(str);
        }
        a(execute, outputStream, j6, adHttpResponseListener);
        return true;
    }

    private static String encode(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e6) {
            com.kwad.sdk.core.d.c.printStackTrace(e6);
            return "";
        }
    }

    private static long b(Response response) {
        try {
            return Long.parseLong(response.header("content-length"));
        } catch (Throwable unused) {
            return -1L;
        }
    }

    private static void a(Request.Builder builder) {
        builder.addHeader("User-Agent", p.getUserAgent());
        builder.addHeader("BrowserUa", p.HA());
        builder.addHeader("SystemUa", p.Hz());
    }

    public static com.kwad.sdk.core.network.c doPost(String str, Map<String, String> map, Map<String, String> map2) {
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        try {
            Request.Builder url = new Request.Builder().url(str);
            a(url);
            a(url, map);
            b(url, map2);
            Response execute = HD().newCall(url.build()).execute();
            int code = execute.code();
            cVar.code = code;
            cVar.aEi = code;
            cVar.aEk = a(execute);
            return cVar;
        } catch (Exception e6) {
            a(cVar, e6);
            return cVar;
        }
    }

    private static void a(@NonNull com.kwad.sdk.core.network.c cVar, Exception exc) {
        String message;
        cVar.aEj = exc;
        if (cVar.aEi == -1 && (exc instanceof IOException) && (message = exc.getMessage()) != null) {
            Matcher matcher = aFn.matcher(message);
            if (matcher.find()) {
                try {
                    cVar.aEi = Integer.parseInt(matcher.group(1));
                } catch (Exception unused) {
                }
            }
        }
        if (exc instanceof SocketTimeoutException) {
            e eVar = e.aEl;
            cVar.code = eVar.errorCode;
            cVar.aEk = eVar.msg;
        } else {
            cVar.code = e.aEm.errorCode;
            cVar.aEk = e.aEm.msg + "/" + bw.s(exc);
        }
        if (com.kwad.framework.a.a.oz.booleanValue()) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(exc);
        }
    }

    public static com.kwad.sdk.core.network.c doPost(String str, Map<String, String> map, AdHttpBodyBuilder adHttpBodyBuilder) {
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        try {
            final MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
            if (adHttpBodyBuilder != null) {
                adHttpBodyBuilder.buildFormData(new AdHttpFormDataBuilder() { // from class: com.kwad.sdk.core.network.a.c.1
                    @Override // com.kwad.sdk.export.proxy.AdHttpFormDataBuilder
                    public final void addFormDataPart(String str2, String str3) {
                        MultipartBody.Builder.this.addFormDataPart(str2, str3);
                    }

                    @Override // com.kwad.sdk.export.proxy.AdHttpFormDataBuilder
                    public final void addFormDataPart(String str2, String str3, String str4, byte[] bArr) {
                        MultipartBody.Builder.this.addFormDataPart(str2, str3, RequestBody.create(MediaType.parse(str4), bArr));
                    }
                });
            }
            Request.Builder post = new Request.Builder().url(str).post(type.build());
            a(post, map);
            Response execute = HD().newCall(post.build()).execute();
            int code = execute.code();
            cVar.code = code;
            cVar.aEi = code;
            cVar.aEk = a(execute);
            return cVar;
        } catch (Exception e6) {
            a(cVar, e6);
            return cVar;
        }
    }

    private static void a(Request.Builder builder, @Nullable Map<String, String> map) {
        if (builder == null || map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry != null) {
                try {
                    builder.removeHeader(entry.getKey());
                    builder.addHeader(entry.getKey(), entry.getValue());
                } catch (Exception unused) {
                }
            }
        }
    }

    private static void a(Request.Builder builder, JSONObject jSONObject) {
        builder.post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jSONObject.toString()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.Closeable, java.io.InputStreamReader, java.io.Reader] */
    private static String a(Response response) {
        InputStream inputStream;
        InputStream inputStream2;
        ?? r42;
        InputStream inputStream3;
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            inputStream = response.body().byteStream();
        } catch (Throwable th) {
            th = th;
            inputStream = null;
            inputStream2 = null;
        }
        try {
            List<String> headers = response.headers("Content-Encoding");
            if (headers != null) {
                Iterator<String> it = headers.iterator();
                while (it.hasNext()) {
                    if ("gzip".equalsIgnoreCase(it.next())) {
                        inputStream3 = new GZIPInputStream(inputStream);
                        inputStream2 = inputStream3;
                        break;
                    }
                }
            }
            inputStream2 = null;
            inputStream3 = inputStream;
            try {
                r42 = new InputStreamReader(inputStream3, aFo);
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(r42, 8);
                    while (true) {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine != null) {
                                sb.append(readLine);
                            } else {
                                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) r42);
                                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream2);
                                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                                return sb.toString();
                            }
                        } catch (Throwable th2) {
                            bufferedReader = bufferedReader2;
                            th = th2;
                            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                            com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) r42);
                            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream2);
                            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Throwable th4) {
                th = th4;
                r42 = 0;
            }
        } catch (Throwable th5) {
            th = th5;
            inputStream2 = null;
            r42 = inputStream2;
            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
            com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) r42);
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream2);
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.io.BufferedInputStream, java.io.Closeable, java.io.InputStream] */
    private static boolean a(Response response, OutputStream outputStream, long j6, AdHttpResponseListener adHttpResponseListener) {
        Closeable closeable;
        InputStream inputStream;
        InputStream inputStream2;
        InputStream inputStream3;
        try {
            AdHttpResponseHelper.notifyResponseStart(adHttpResponseListener);
            inputStream = response.body().byteStream();
            try {
                List<String> headers = response.headers("Content-Encoding");
                long b6 = b(response);
                if (headers != null) {
                    Iterator<String> it = headers.iterator();
                    while (it.hasNext()) {
                        if ("gzip".equalsIgnoreCase(it.next())) {
                            inputStream3 = new GZIPInputStream(inputStream);
                            inputStream2 = inputStream3;
                            break;
                        }
                    }
                }
                inputStream2 = null;
                inputStream3 = inputStream;
                try {
                    ?? bufferedInputStream = new BufferedInputStream(inputStream3);
                    try {
                        byte[] bArr = new byte[1024];
                        long j7 = 0;
                        if (j6 > 0) {
                            do {
                                int read = bufferedInputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                j7 += read;
                                AdHttpResponseHelper.notifyResponseProgress(adHttpResponseListener, j7, b6);
                            } while (j7 <= j6);
                        } else if (j6 < 0) {
                            r0 = outputStream != null ? new BufferedOutputStream(outputStream) : null;
                            do {
                                int read2 = bufferedInputStream.read(bArr);
                                if (read2 == -1) {
                                    break;
                                }
                                if (r0 != null) {
                                    r0.write(bArr, 0, read2);
                                }
                                j7 += read2;
                            } while (!AdHttpResponseHelper.notifyResponseProgress(adHttpResponseListener, j7, b6));
                            if (r0 != null) {
                                r0.flush();
                            }
                        }
                        com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) bufferedInputStream);
                        com.kwad.sdk.crash.utils.b.closeQuietly(r0);
                        com.kwad.sdk.crash.utils.b.closeQuietly(inputStream2);
                        com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                        return true;
                    } catch (Throwable th) {
                        th = th;
                        closeable = null;
                        r0 = bufferedInputStream;
                        com.kwad.sdk.crash.utils.b.closeQuietly(r0);
                        com.kwad.sdk.crash.utils.b.closeQuietly(closeable);
                        com.kwad.sdk.crash.utils.b.closeQuietly(inputStream2);
                        com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    closeable = null;
                }
            } catch (Throwable th3) {
                th = th3;
                closeable = null;
                inputStream2 = null;
            }
        } catch (Throwable th4) {
            th = th4;
            closeable = null;
            inputStream = null;
            inputStream2 = null;
        }
    }
}
