package com.kwad.sdk.i;

import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
class l {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static int aTe;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void onSuccess();
    }

    @WorkerThread
    public static void a(List<k> list, a aVar) {
        if (aTe > 10) {
            j.ak("LogReportUtil", "request error");
            return;
        }
        g Nh = h.Nd().Nh();
        Map<String, String> requestHeader = Nh.getRequestHeader();
        JSONObject Nc = Nh.Nc();
        c.putValue(Nc, "actionList", list);
        c.putValue(Nc, "timestamp", System.currentTimeMillis());
        a(Nh.Nb(), requestHeader, a(requestHeader, Nc), aVar);
    }

    private static String c(Map<String, String> map, String str) {
        g Nh = h.Nd().Nh();
        JSONObject jSONObject = new JSONObject();
        c.putValue(jSONObject, "version", Nh.getSdkVersion());
        c.putValue(jSONObject, "appId", Nh.getAppId());
        c.putValue(jSONObject, CrashHianalyticsData.MESSAGE, com.kwad.sdk.i.a.as(str));
        com.kwad.sdk.i.a.a(Nh.Nb(), map, jSONObject.toString());
        return jSONObject.toString();
    }

    private static void setConnectionHeader(HttpURLConnection httpURLConnection, Map<String, String> map) {
        if (map == null || httpURLConnection == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    l() {
    }

    private static String inputStream2String(InputStream inputStream) {
        try {
            try {
                return c(inputStream);
            } catch (IOException unused) {
                j.Nn();
                j.closeQuietly(inputStream);
                return null;
            }
        } finally {
            j.closeQuietly(inputStream);
        }
    }

    private static String c(InputStream inputStream) {
        InputStreamReader inputStreamReader;
        Throwable th;
        BufferedReader bufferedReader;
        try {
            inputStreamReader = new InputStreamReader(inputStream);
            try {
                bufferedReader = new BufferedReader(inputStreamReader, 1024);
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (Throwable th3) {
            inputStreamReader = null;
            th = th3;
            bufferedReader = null;
        }
        try {
            String a6 = a(bufferedReader);
            j.closeQuietly(bufferedReader);
            j.closeQuietly(inputStreamReader);
            return a6;
        } catch (Throwable th4) {
            th = th4;
            j.closeQuietly(bufferedReader);
            j.closeQuietly(inputStreamReader);
            throw th;
        }
    }

    private static String a(Map<String, String> map, JSONObject jSONObject) {
        if (h.Nd().Nh().Na()) {
            return jSONObject.toString();
        }
        return c(map, jSONObject.toString());
    }

    private static void a(String str, Map<String, String> map, String str2, a aVar) {
        Closeable closeable;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2 = null;
        OutputStream outputStream = null;
        httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        } catch (Exception unused) {
            closeable = null;
        } catch (Throwable th) {
            th = th;
            closeable = null;
        }
        try {
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(KSImageLoader.InnerImageLoadingListener.MAX_DURATION);
            httpURLConnection.setUseCaches(false);
            setConnectionHeader(httpURLConnection, map);
            httpURLConnection.connect();
            if (!TextUtils.isEmpty(str2)) {
                outputStream = httpURLConnection.getOutputStream();
                outputStream.write(str2.getBytes());
                outputStream.flush();
            }
            if (httpURLConnection.getResponseCode() == 200) {
                String inputStream2String = inputStream2String(httpURLConnection.getInputStream());
                j.No();
                if (!TextUtils.isEmpty(inputStream2String)) {
                    if (new JSONObject(inputStream2String).optInt("result") == 1) {
                        aTe = 0;
                        aVar.onSuccess();
                    } else {
                        aTe++;
                        j.No();
                    }
                } else {
                    aTe++;
                    j.No();
                }
            } else {
                aTe++;
                j.No();
            }
            j.closeQuietly(httpURLConnection);
            j.closeQuietly(outputStream);
        } catch (Exception unused2) {
            httpURLConnection2 = httpURLConnection;
            closeable = null;
            try {
                aTe++;
                j.Nn();
                j.closeQuietly(httpURLConnection2);
                j.closeQuietly(closeable);
            } catch (Throwable th2) {
                th = th2;
                j.closeQuietly(httpURLConnection2);
                j.closeQuietly(closeable);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection2 = httpURLConnection;
            closeable = null;
            j.closeQuietly(httpURLConnection2);
            j.closeQuietly(closeable);
            throw th;
        }
    }

    private static String a(Reader reader) {
        StringWriter stringWriter;
        Throwable th;
        StringWriter stringWriter2 = new StringWriter();
        try {
            stringWriter = new StringWriter();
            try {
                char[] cArr = new char[1024];
                while (true) {
                    int read = reader.read(cArr);
                    if (read != -1) {
                        stringWriter.write(cArr, 0, read);
                    } else {
                        String stringWriter3 = stringWriter.toString();
                        j.closeQuietly(reader);
                        j.closeQuietly(stringWriter);
                        return stringWriter3;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                j.closeQuietly(reader);
                j.closeQuietly(stringWriter);
                throw th;
            }
        } catch (Throwable th3) {
            stringWriter = stringWriter2;
            th = th3;
        }
    }
}
