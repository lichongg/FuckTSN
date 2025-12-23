package cn.jiguang.net;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import cn.jiguang.bz.f;
import cn.jiguang.bz.l;
import cn.jiguang.bz.y;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import okio.Utf8;

/* loaded from: D:\Downloads\app\classes2.dex */
public class HttpUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final String f3145a = l.b(new byte[]{32, 0, 14, 41, 38, 38, Utf8.REPLACEMENT_BYTE, 1, 23, 43});

    public static abstract class HttpListener {
        protected void a() {
        }

        protected void a(HttpResponse httpResponse) {
        }
    }

    private static class a extends AsyncTask<HttpRequest, Void, HttpResponse> {

        /* renamed from: a, reason: collision with root package name */
        private HttpListener f3146a;

        /* renamed from: b, reason: collision with root package name */
        private Context f3147b;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public HttpResponse doInBackground(HttpRequest... httpRequestArr) {
            if (httpRequestArr == null || httpRequestArr.length == 0) {
                return null;
            }
            return HttpUtils.httpGet(this.f3147b, httpRequestArr[0]);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(HttpResponse httpResponse) {
            HttpListener httpListener = this.f3146a;
            if (httpListener != null) {
                httpListener.a(httpResponse);
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            HttpListener httpListener = this.f3146a;
            if (httpListener != null) {
                httpListener.a();
            }
        }

        public a(Context context, HttpListener httpListener) {
            this.f3146a = httpListener;
            this.f3147b = context;
        }
    }

    private static class b extends AsyncTask<String, Void, HttpResponse> {

        /* renamed from: a, reason: collision with root package name */
        private HttpListener f3148a;

        /* renamed from: b, reason: collision with root package name */
        private Context f3149b;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public HttpResponse doInBackground(String... strArr) {
            if (strArr == null || strArr.length == 0) {
                return null;
            }
            return HttpUtils.httpGet(this.f3149b, strArr[0]);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(HttpResponse httpResponse) {
            HttpListener httpListener = this.f3148a;
            if (httpListener != null) {
                httpListener.a(httpResponse);
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            HttpListener httpListener = this.f3148a;
            if (httpListener != null) {
                httpListener.a();
            }
        }

        public b(HttpListener httpListener, Context context) {
            this.f3148a = httpListener;
            this.f3149b = context;
        }
    }

    private static void a(HttpRequest httpRequest, HttpURLConnection httpURLConnection) {
        if (httpRequest == null || httpURLConnection == null) {
            return;
        }
        setURLConnection(httpRequest.getRequestProperties(), httpURLConnection);
        if (httpRequest.getConnectTimeout() >= 0) {
            httpURLConnection.setConnectTimeout(httpRequest.getConnectTimeout());
        }
        if (httpRequest.getReadTimeout() >= 0) {
            httpURLConnection.setReadTimeout(httpRequest.getReadTimeout());
        }
    }

    public static HttpResponse httpGet(Context context, HttpRequest httpRequest) {
        return httpResponse(context, httpRequest, false);
    }

    public static String httpGetString(Context context, HttpRequest httpRequest) {
        HttpResponse httpGet = httpGet(context, httpRequest);
        if (httpGet == null) {
            return null;
        }
        return httpGet.getResponseBody();
    }

    public static HttpResponse httpPost(Context context, HttpRequest httpRequest) {
        return httpResponse(context, httpRequest, true, false);
    }

    public static String httpPostString(Context context, String str) {
        HttpResponse httpPost = httpPost(context, new HttpRequest(str));
        if (httpPost == null) {
            return null;
        }
        return httpPost.getResponseBody();
    }

    public static HttpResponse httpResponse(Context context, HttpRequest httpRequest, boolean z5) {
        return httpResponse(context, httpRequest, z5, false);
    }

    private static void a(HttpURLConnection httpURLConnection, HttpResponse httpResponse) {
        if (httpResponse == null || httpURLConnection == null) {
            return;
        }
        httpResponse.setResponseCode(httpURLConnection.getResponseCode());
        httpResponse.setStatusCode(httpURLConnection.getResponseCode());
        httpResponse.setResponseHeader("expires", httpURLConnection.getHeaderField("Expires"));
        httpResponse.setResponseHeader("cache-control", httpURLConnection.getHeaderField("Cache-Control"));
    }

    public static HttpURLConnection getHttpURLConnectionWithProxy(String str) {
        try {
            return (HttpURLConnection) new URL(str).openConnection();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getUrlWithParas(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        StringBuilder sb = new StringBuilder(str);
        String joinParas = joinParas(map);
        if (!TextUtils.isEmpty(joinParas)) {
            sb.append("?");
            sb.append(joinParas);
        }
        return sb.toString();
    }

    public static String getUrlWithValueEncodeParas(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        StringBuilder sb = new StringBuilder(str);
        String joinParasWithEncodedValue = joinParasWithEncodedValue(map);
        if (!TextUtils.isEmpty(joinParasWithEncodedValue)) {
            sb.append("?");
            sb.append(joinParasWithEncodedValue);
        }
        return sb.toString();
    }

    public static HttpResponse httpGet(Context context, String str) {
        return httpGet(context, new HttpRequest(str));
    }

    public static String httpGetString(Context context, String str) {
        HttpResponse httpGet = httpGet(context, new HttpRequest(str));
        if (httpGet == null) {
            return null;
        }
        return httpGet.getResponseBody();
    }

    public static HttpResponse httpPost(Context context, String str) {
        return httpPost(context, new HttpRequest(str));
    }

    public static String httpPostString(Context context, String str, Map<String, String> map) {
        HttpResponse httpPost = httpPost(context, new HttpRequest(str, map));
        if (httpPost == null) {
            return null;
        }
        return httpPost.getResponseBody();
    }

    public static HttpResponse httpResponse(Context context, HttpRequest httpRequest, boolean z5, boolean z6) {
        return httpResponse(context, getHttpURLConnectionWithProxy(httpRequest.getUrl()), httpRequest, z5, z6);
    }

    public static String joinParas(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            sb.append(next.getKey());
            sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb.append(next.getValue());
            if (it.hasNext()) {
                sb.append(ContainerUtils.FIELD_DELIMITER);
            }
        }
        return sb.toString();
    }

    public static String joinParasWithEncodedValue(Map<String, String> map) {
        StringBuilder sb = new StringBuilder("");
        if (map != null && map.size() > 0) {
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                try {
                    Map.Entry<String, String> next = it.next();
                    sb.append(next.getKey());
                    sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb.append(URLEncoder.encode(next.getValue(), "UTF-8"));
                    if (it.hasNext()) {
                        sb.append(ContainerUtils.FIELD_DELIMITER);
                    }
                } catch (Exception unused) {
                }
            }
        }
        return sb.toString();
    }

    public static long parseGmtTime(String str) {
        try {
            return f.a("EEE, d MMM yyyy HH:mm:ss z").parse(str).getTime();
        } catch (Exception unused) {
            return -1L;
        }
    }

    public static void setURLConnection(Map<String, String> map, HttpURLConnection httpURLConnection) {
        if (map == null || map.size() == 0 || httpURLConnection == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey())) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    public static String appendParaToUrl(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        if (!str.contains("?")) {
            sb.append("?");
        } else {
            sb.append(ContainerUtils.FIELD_DELIMITER);
        }
        sb.append(str2);
        sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb.append(str3);
        return sb.toString();
    }

    public static void httpGet(Context context, HttpRequest httpRequest, HttpListener httpListener) {
        new a(context, httpListener).execute(httpRequest);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(28:16|(2:146|147)|18|19|(6:133|134|(1:136)|137|(1:139)(1:142)|140)|(3:(1:113)(1:132)|114|(4:116|124|125|(20:30|31|32|(2:35|33)|36|37|38|39|40|41|42|(10:45|46|(3:62|63|(1:65))|(1:53)|(1:55)|56|57|58|59|60)|70|(3:49|51|53)|(0)|56|57|58|59|60)(3:27|28|29)))|23|(1:25)|30|31|32|(1:33)|36|37|38|39|40|41|42|(10:45|46|(0)|(0)|(0)|56|57|58|59|60)|70|(0)|(0)|56|57|58|59|60) */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0192, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0193, code lost:
    
        cn.jiguang.bb.f.c("HttpUtils", "get input stream error:" + r0.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x01ab, code lost:
    
        r9 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01e6, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x01e7, code lost:
    
        r4 = r2;
        r2 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x02cf, code lost:
    
        if (r13 == null) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01e2, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01e3, code lost:
    
        r4 = r2;
        r2 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x02a1, code lost:
    
        if (r13 != null) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01de, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01df, code lost:
    
        r5 = r2;
        r2 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0240, code lost:
    
        if (r13 == null) goto L129;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x017b A[Catch: all -> 0x0189, LOOP:0: B:33:0x0175->B:35:0x017b, LOOP_END, TRY_LEAVE, TryCatch #6 {all -> 0x0189, blocks: (B:32:0x0169, B:33:0x0175, B:35:0x017b), top: B:31:0x0169 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01ed A[Catch: all -> 0x01de, IOException -> 0x01e2, MalformedURLException -> 0x01e6, TryCatch #11 {MalformedURLException -> 0x01e6, IOException -> 0x01e2, all -> 0x01de, blocks: (B:42:0x01ac, B:51:0x01cf, B:53:0x01d5, B:55:0x01ed, B:56:0x01f7), top: B:41:0x01ac }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01ba A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0256 A[Catch: all -> 0x0262, TryCatch #1 {all -> 0x0262, blocks: (B:79:0x0249, B:81:0x0256, B:82:0x025e, B:83:0x0280, B:86:0x0267, B:88:0x026b, B:89:0x0274, B:91:0x0278, B:73:0x02a4), top: B:16:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0267 A[Catch: all -> 0x0262, TryCatch #1 {all -> 0x0262, blocks: (B:79:0x0249, B:81:0x0256, B:82:0x025e, B:83:0x0280, B:86:0x0267, B:88:0x026b, B:89:0x0274, B:91:0x0278, B:73:0x02a4), top: B:16:0x004a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static cn.jiguang.net.HttpResponse httpResponse(android.content.Context r12, java.net.HttpURLConnection r13, cn.jiguang.net.HttpRequest r14, boolean r15, boolean r16) {
        /*
            Method dump skipped, instructions count: 753
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.net.HttpUtils.httpResponse(android.content.Context, java.net.HttpURLConnection, cn.jiguang.net.HttpRequest, boolean, boolean):cn.jiguang.net.HttpResponse");
    }

    public static byte[] readInputStream(InputStream inputStream) {
        return y.a(inputStream);
    }

    public static void httpGet(Context context, String str, HttpListener httpListener) {
        new b(httpListener, context).execute(str);
    }
}
