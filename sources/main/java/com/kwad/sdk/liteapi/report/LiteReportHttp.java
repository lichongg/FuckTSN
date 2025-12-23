package com.kwad.sdk.liteapi.report;

import android.content.Context;
import androidx.annotation.Keep;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.kwad.sdk.api.core.RequestParamsUtils;
import com.kwad.sdk.api.core.TLSConnectionUtils;
import com.kwad.sdk.liteapi.LiteApiLogger;
import com.kwad.sdk.liteapi.encrypt.LiteEncryptHelper;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
class LiteReportHttp {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int CONNECTION_TIME_OUT = 10000;
    private static final int MAX_REDIRECTS = 21;
    private static final int READ_WRITE_TIME_OUT = 30000;
    private static final String TAG = "LiteReportHttp";
    private int currentNum;
    private String mCurrentUrl;
    private final String mUrl;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a(LiteApiReportResponse liteApiReportResponse);

        void b(Exception exc);
    }

    private boolean disableEncrypt() {
        return false;
    }

    private Map<String, String> buildHeader() {
        HashMap hashMap = new HashMap();
        hashMap.put("Accept-Language", "zh-CN");
        hashMap.put("Connection", "keep-alive");
        hashMap.put("Charset", "UTF-8");
        hashMap.put("Content-Type", "application/json; charset=UTF-8");
        hashMap.put("User-Agent", RequestParamsUtils.getUserAgent());
        return hashMap;
    }

    private HttpURLConnection createUrlConnection(String str) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        TLSConnectionUtils.wrapHttpURLConnection(httpURLConnection);
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(30000);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(true);
        return httpURLConnection;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0058 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x004e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String inputStream2String(java.io.InputStream r5) {
        /*
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]
            r1 = 0
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L32
            r2.<init>()     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L32
        La:
            int r3 = r5.read(r0)     // Catch: java.lang.Throwable -> L16 java.io.IOException -> L19
            r4 = -1
            if (r3 == r4) goto L1b
            r4 = 0
            r2.write(r0, r4, r3)     // Catch: java.lang.Throwable -> L16 java.io.IOException -> L19
            goto La
        L16:
            r0 = move-exception
            r1 = r2
            goto L4c
        L19:
            r0 = move-exception
            goto L34
        L1b:
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L16 java.io.IOException -> L19
            r5.close()     // Catch: java.io.IOException -> L23
            goto L27
        L23:
            r5 = move-exception
            r5.printStackTrace()
        L27:
            r2.close()     // Catch: java.io.IOException -> L2b
            goto L2f
        L2b:
            r5 = move-exception
            r5.printStackTrace()
        L2f:
            return r0
        L30:
            r0 = move-exception
            goto L4c
        L32:
            r0 = move-exception
            r2 = r1
        L34:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L16
            if (r5 == 0) goto L41
            r5.close()     // Catch: java.io.IOException -> L3d
            goto L41
        L3d:
            r5 = move-exception
            r5.printStackTrace()
        L41:
            if (r2 == 0) goto L4b
            r2.close()     // Catch: java.io.IOException -> L47
            goto L4b
        L47:
            r5 = move-exception
            r5.printStackTrace()
        L4b:
            return r1
        L4c:
            if (r5 == 0) goto L56
            r5.close()     // Catch: java.io.IOException -> L52
            goto L56
        L52:
            r5 = move-exception
            r5.printStackTrace()
        L56:
            if (r1 == 0) goto L60
            r1.close()     // Catch: java.io.IOException -> L5c
            goto L60
        L5c:
            r5 = move-exception
            r5.printStackTrace()
        L60:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.liteapi.report.LiteReportHttp.inputStream2String(java.io.InputStream):java.lang.String");
    }

    private void setConnectionHeader(HttpURLConnection httpURLConnection, Map<String, String> map) {
        if (map == null || httpURLConnection == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    public void request(Context context, LiteApiReportRequest liteApiReportRequest, a aVar) {
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                LiteApiLogger.w(TAG, "request start ");
                Map<String, String> buildHeader = buildHeader();
                String buildBody = buildBody(context, liteApiReportRequest, buildHeader);
                LiteApiLogger.w(TAG, "request start bodyParams: " + buildBody);
                LiteApiLogger.w(TAG, "request start mCurrentUrl: " + this.mCurrentUrl);
                HttpURLConnection createUrlConnection = createUrlConnection(this.mCurrentUrl);
                setConnectionHeader(createUrlConnection, buildHeader);
                createUrlConnection.connect();
                new DataOutputStream(createUrlConnection.getOutputStream()).write(buildBody.getBytes());
                int responseCode = createUrlConnection.getResponseCode();
                LiteApiLogger.w(TAG, "response responseCode :  " + responseCode);
                if (responseCode == 200) {
                    String inputStream2String = inputStream2String(createUrlConnection.getInputStream());
                    LiteApiLogger.w(TAG, "response resultStr :  " + inputStream2String);
                    LiteApiReportResponse liteApiReportResponse = new LiteApiReportResponse();
                    liteApiReportResponse.parseJson(new JSONObject(inputStream2String));
                    aVar.a(liteApiReportResponse);
                } else {
                    if (responseCode / 100 != 3) {
                        throw new RuntimeException("response code = " + responseCode);
                    }
                    if (this.currentNum < 21) {
                        this.mCurrentUrl = createUrlConnection.getHeaderField("Location");
                        this.currentNum++;
                        request(context, liteApiReportRequest, aVar);
                    }
                }
                try {
                    createUrlConnection.disconnect();
                } catch (Exception unused) {
                }
            } catch (Exception e6) {
                LiteApiLogger.w(TAG, "request Exception e: " + e6.getMessage());
                e6.printStackTrace();
                aVar.b(e6);
                if (0 != 0) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Exception unused2) {
                    }
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    httpURLConnection.disconnect();
                } catch (Exception unused3) {
                }
            }
            throw th;
        }
    }

    LiteReportHttp(String str) {
        this.mUrl = str;
        this.mCurrentUrl = str;
    }

    private String buildBody(Context context, LiteApiReportRequest liteApiReportRequest, Map<String, String> map) {
        String jSONObject = liteApiReportRequest.toJson().toString();
        if (disableEncrypt()) {
            map.put("x-ksad-ignore-decrypt", "true");
            return jSONObject;
        }
        LiteEncryptHelper.addHeaderParams(context, map);
        JSONObject jSONObject2 = new JSONObject();
        LiteJsonUtil.putValue(jSONObject2, "version", liteApiReportRequest.sdkApiVersion);
        LiteJsonUtil.putValue(jSONObject2, "appId", liteApiReportRequest.getAppId());
        LiteJsonUtil.putValue(jSONObject2, CrashHianalyticsData.MESSAGE, LiteEncryptHelper.getRequestMessage(context, jSONObject));
        LiteEncryptHelper.sigRequest(context, this.mUrl, map, jSONObject2.toString());
        return jSONObject2.toString();
    }
}
