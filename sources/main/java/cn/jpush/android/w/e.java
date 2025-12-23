package cn.jpush.android.w;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.ad.m;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import okio.Utf8;

/* loaded from: D:\Downloads\app\classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static final String f3965a = cn.jpush.android.ad.d.b(new byte[]{32, 0, 14, 41, 38, 38, Utf8.REPLACEMENT_BYTE, 1, 23, 43});

    public static d a(Context context, c cVar) {
        return a(context, cVar, true, false);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(18:(6:14|15|17|18|19|(6:123|124|(1:126)|127|(1:129)(1:132)|130))|(3:(1:107)(1:122)|108|(19:110|112|113|114|24|25|26|27|28|29|30|(9:33|34|(3:50|51|(1:53))|(1:41)|(1:43)(1:49)|44|45|46|47)|58|(3:37|39|41)|(0)(0)|44|45|46|47))|23|24|25|26|27|28|29|30|(9:33|34|(0)|(0)|(0)(0)|44|45|46|47)|58|(0)|(0)(0)|44|45|46|47) */
    /* JADX WARN: Can't wrap try/catch for region: R(23:14|15|17|18|19|(6:123|124|(1:126)|127|(1:129)(1:132)|130)|(3:(1:107)(1:122)|108|(19:110|112|113|114|24|25|26|27|28|29|30|(9:33|34|(3:50|51|(1:53))|(1:41)|(1:43)(1:49)|44|45|46|47)|58|(3:37|39|41)|(0)(0)|44|45|46|47))|23|24|25|26|27|28|29|30|(9:33|34|(0)|(0)|(0)(0)|44|45|46|47)|58|(0)|(0)(0)|44|45|46|47) */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x01d1, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01d2, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01cc, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01cd, code lost:
    
        r1 = null;
        r14 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01c9, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01ca, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0195, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0196, code lost:
    
        r1 = r2;
        r2 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x02ad, code lost:
    
        if (r5 != null) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0191, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0192, code lost:
    
        r1 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00ed, code lost:
    
        r2 = r5;
        r1 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0232, code lost:
    
        r3.a(3001);
        r4 = "请求超时";
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x027e, code lost:
    
        r2.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0244, code lost:
    
        if ((r0 instanceof java.net.UnknownHostException) != false) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0246, code lost:
    
        r3.a(3003);
        r4 = "域名无效";
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0251, code lost:
    
        if ((r0 instanceof javax.net.ssl.SSLHandshakeException) != false) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0253, code lost:
    
        r3.a(3005);
        r4 = "SSL失败";
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x018c, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x018d, code lost:
    
        r1 = r2;
        r2 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x021d, code lost:
    
        if (r5 != null) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0140, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0141, code lost:
    
        cn.jpush.android.helper.Logger.d("HttpUtils", "get input stream error:" + r0.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0159, code lost:
    
        r14 = null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x019c A[Catch: all -> 0x018c, IOException -> 0x0191, MalformedURLException -> 0x0195, TryCatch #16 {MalformedURLException -> 0x0195, IOException -> 0x0191, all -> 0x018c, blocks: (B:30:0x015a, B:39:0x017d, B:41:0x0183, B:43:0x019c, B:44:0x01aa), top: B:29:0x015a }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0168 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0232 A[Catch: all -> 0x023e, TryCatch #20 {all -> 0x023e, blocks: (B:69:0x0225, B:71:0x0232, B:72:0x023a, B:73:0x025b, B:78:0x0242, B:80:0x0246, B:81:0x024f, B:83:0x0253), top: B:68:0x0225 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0242 A[Catch: all -> 0x023e, TryCatch #20 {all -> 0x023e, blocks: (B:69:0x0225, B:71:0x0232, B:72:0x023a, B:73:0x025b, B:78:0x0242, B:80:0x0246, B:81:0x024f, B:83:0x0253), top: B:68:0x0225 }] */
    /* JADX WARN: Type inference failed for: r1v0, types: [cn.jpush.android.w.c] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static cn.jpush.android.w.d a(android.content.Context r15, cn.jpush.android.w.c r16, boolean r17, boolean r18) {
        /*
            Method dump skipped, instructions count: 705
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.w.e.a(android.content.Context, cn.jpush.android.w.c, boolean, boolean):cn.jpush.android.w.d");
    }

    public static String a(Map<String, String> map) {
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

    public static HttpURLConnection a(Context context, String str) {
        return (HttpURLConnection) new URL(str).openConnection();
    }

    private static void a(c cVar, HttpURLConnection httpURLConnection) {
        if (cVar == null || httpURLConnection == null) {
            return;
        }
        a(cVar.i(), httpURLConnection);
        if (cVar.b() >= 0) {
            httpURLConnection.setConnectTimeout(cVar.b());
        }
        if (cVar.c() >= 0) {
            httpURLConnection.setReadTimeout(cVar.c());
        }
    }

    private static void a(HttpURLConnection httpURLConnection, d dVar) {
        if (dVar == null || httpURLConnection == null) {
            return;
        }
        dVar.a(httpURLConnection.getResponseCode());
        dVar.b(httpURLConnection.getResponseCode());
        dVar.a("expires", httpURLConnection.getHeaderField("Expires"));
        dVar.a("cache-control", httpURLConnection.getHeaderField("Cache-Control"));
    }

    public static void a(Map<String, String> map, HttpURLConnection httpURLConnection) {
        if (map == null || map.size() == 0 || httpURLConnection == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey())) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    public static byte[] a(InputStream inputStream) {
        return m.b(inputStream);
    }
}
