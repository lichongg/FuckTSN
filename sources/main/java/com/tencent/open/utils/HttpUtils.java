package com.tencent.open.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.connect.auth.QQToken;
import com.tencent.open.log.SLog;
import com.tencent.tauth.IRequestListener;
import java.io.CharConversionException;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.InvalidObjectException;
import java.io.NotActiveException;
import java.io.NotSerializableException;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.io.SyncFailedException;
import java.io.UTFDataFormatException;
import java.io.UnsupportedEncodingException;
import java.io.WriteAbortedException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileLockInterruptionException;
import java.nio.charset.MalformedInputException;
import java.nio.charset.UnmappableCharacterException;
import java.util.HashMap;
import java.util.InvalidPropertiesFormatException;
import java.util.Map;
import java.util.zip.ZipException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class HttpUtils {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f40633a;

        /* renamed from: b, reason: collision with root package name */
        public final int f40634b;

        private a(String str, int i6) {
            this.f40633a = str;
            this.f40634b = i6;
        }
    }

    private static void a(Context context, QQToken qQToken, String str) {
        if (str.indexOf("add_share") > -1 || str.indexOf("upload_pic") > -1 || str.indexOf("add_topic") > -1 || str.indexOf("set_user_face") > -1 || str.indexOf("add_t") > -1 || str.indexOf("add_pic_t") > -1 || str.indexOf("add_pic_url") > -1 || str.indexOf("add_video") > -1) {
            com.tencent.connect.a.a.a(context, qQToken, "requireApi", str);
        }
    }

    private static Map<String, byte[]> b(Bundle bundle) {
        HashMap hashMap = new HashMap(0);
        if (bundle != null && bundle.size() != 0) {
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj instanceof byte[]) {
                    hashMap.put(str, (byte[]) obj);
                }
            }
        }
        return hashMap;
    }

    public static String encodeUrl(Bundle bundle) {
        return encodeUrl(a(bundle));
    }

    public static a getProxy(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo networkInfo;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return null;
        }
        try {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Exception unused) {
            networkInfo = null;
        }
        if (networkInfo != null && networkInfo.getType() == 0) {
            String b6 = b(context);
            int a6 = a(context);
            if (!TextUtils.isEmpty(b6) && a6 >= 0) {
                return new a(b6, a6);
            }
        }
        return null;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class HttpStatusException extends Exception {
        public static final String ERROR_INFO = "http status code error:";
        public final int statusCode;

        public HttpStatusException(String str) {
            super(str);
            this.statusCode = -1;
        }

        public HttpStatusException(int i6) {
            super(ERROR_INFO + i6);
            this.statusCode = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class NetworkUnavailableException extends Exception {
        public static final String ERROR_INFO = "network unavailable";

        public NetworkUnavailableException(String str) {
            super(str);
        }
    }

    public static int getErrorCodeFromException(IOException iOException) {
        if (iOException instanceof CharConversionException) {
            return -20;
        }
        if (iOException instanceof MalformedInputException) {
            return -21;
        }
        if (iOException instanceof UnmappableCharacterException) {
            return -22;
        }
        if (iOException instanceof ClosedChannelException) {
            return -24;
        }
        if (iOException instanceof EOFException) {
            return -26;
        }
        if (iOException instanceof FileLockInterruptionException) {
            return -27;
        }
        if (iOException instanceof FileNotFoundException) {
            return -28;
        }
        if (iOException instanceof HttpRetryException) {
            return -29;
        }
        if (iOException instanceof SocketTimeoutException) {
            return -8;
        }
        if (iOException instanceof InvalidPropertiesFormatException) {
            return -30;
        }
        if (iOException instanceof MalformedURLException) {
            return -3;
        }
        if (iOException instanceof InvalidClassException) {
            return -33;
        }
        if (iOException instanceof InvalidObjectException) {
            return -34;
        }
        if (iOException instanceof NotActiveException) {
            return -35;
        }
        if (iOException instanceof NotSerializableException) {
            return -36;
        }
        if (iOException instanceof OptionalDataException) {
            return -37;
        }
        if (iOException instanceof StreamCorruptedException) {
            return -38;
        }
        if (iOException instanceof WriteAbortedException) {
            return -39;
        }
        if (iOException instanceof ProtocolException) {
            return -40;
        }
        if (iOException instanceof SSLHandshakeException) {
            return -41;
        }
        if (iOException instanceof SSLKeyException) {
            return -42;
        }
        if (iOException instanceof SSLPeerUnverifiedException) {
            return -43;
        }
        if (iOException instanceof SSLProtocolException) {
            return -44;
        }
        if (iOException instanceof BindException) {
            return -45;
        }
        if (iOException instanceof ConnectException) {
            return -46;
        }
        if (iOException instanceof NoRouteToHostException) {
            return -47;
        }
        if (iOException instanceof PortUnreachableException) {
            return -48;
        }
        if (iOException instanceof SyncFailedException) {
            return -49;
        }
        if (iOException instanceof UTFDataFormatException) {
            return -50;
        }
        if (iOException instanceof UnknownHostException) {
            return -51;
        }
        if (iOException instanceof UnknownServiceException) {
            return -52;
        }
        if (iOException instanceof UnsupportedEncodingException) {
            return -53;
        }
        return iOException instanceof ZipException ? -54 : -2;
    }

    public static JSONObject request(QQToken qQToken, Context context, String str, Bundle bundle, String str2) throws IOException, JSONException, NetworkUnavailableException, HttpStatusException {
        String str3;
        String str4;
        int i6;
        long j6;
        long j7;
        int i7;
        SLog.i("openSDK_LOG.HttpUtils", "OpenApi request");
        if (!m.b(context)) {
            throw new NetworkUnavailableException(NetworkUnavailableException.ERROR_INFO);
        }
        if (str.toLowerCase().startsWith(master.flame.danmaku.danmaku.parser.b.f50154a)) {
            str3 = str;
            str4 = str3;
        } else {
            str3 = j.a().a(context, "https://openmobile.qq.com/") + str;
            str4 = j.a().a(context, "https://openmobile.qq.com/") + str;
        }
        a(context, qQToken, str);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int a6 = i.a(context, qQToken.getAppId()).a("Common_HttpRetryCount");
        SLog.v("OpenConfig_test", "config 1:Common_HttpRetryCount            config_value:" + a6 + "   appid:" + qQToken.getAppId() + "     url:" + str4);
        int i8 = a6 == 0 ? 3 : a6;
        SLog.v("OpenConfig_test", "config 1:Common_HttpRetryCount            result_value:" + i8 + "   appid:" + qQToken.getAppId() + "     url:" + str4);
        int i9 = 0;
        JSONObject jSONObject = null;
        while (true) {
            int i10 = i9 + 1;
            try {
                try {
                    try {
                        com.tencent.open.a.g a7 = a(str3, str2, bundle);
                        int d6 = a7.d();
                        SLog.i("openSDK_LOG.HttpUtils", "request statusCode " + d6);
                        if (d6 != 200) {
                            com.tencent.open.b.h.a().a(str4, elapsedRealtime, 0L, 0L, d6);
                            throw new HttpStatusException(d6);
                        }
                        JSONObject d7 = m.d(a7.a());
                        try {
                            try {
                                i7 = d7.getInt("ret");
                            } catch (SocketTimeoutException e6) {
                                e = e6;
                                jSONObject = d7;
                                e.printStackTrace();
                                i6 = -8;
                                j6 = 0;
                                j7 = 0;
                                if (i10 >= i8) {
                                    com.tencent.open.b.h.a().a(str4, elapsedRealtime, 0L, 0L, -8);
                                    throw e;
                                }
                                elapsedRealtime = SystemClock.elapsedRealtime();
                                if (i10 >= i8) {
                                    com.tencent.open.b.h.a().a(str4, elapsedRealtime, j6, j7, i6);
                                    return jSONObject;
                                }
                                i9 = i10;
                            }
                        } catch (JSONException unused) {
                            i7 = -4;
                        }
                        jSONObject = d7;
                        i6 = i7;
                        j6 = a7.c();
                        j7 = a7.b();
                        break;
                    } catch (MalformedURLException e7) {
                        e7.printStackTrace();
                        com.tencent.open.b.h.a().a(str4, elapsedRealtime, 0L, 0L, -3);
                        throw e7;
                    } catch (IOException e8) {
                        e8.printStackTrace();
                        com.tencent.open.b.h.a().a(str4, elapsedRealtime, 0L, 0L, getErrorCodeFromException(e8));
                        throw e8;
                    }
                } catch (JSONException e9) {
                    e9.printStackTrace();
                    com.tencent.open.b.h.a().a(str4, elapsedRealtime, 0L, 0L, -4);
                    throw e9;
                }
            } catch (SocketTimeoutException e10) {
                e = e10;
            }
            i9 = i10;
        }
        com.tencent.open.b.h.a().a(str4, elapsedRealtime, j6, j7, i6);
        return jSONObject;
    }

    public static void requestAsync(final QQToken qQToken, final Context context, final String str, final Bundle bundle, final String str2, final IRequestListener iRequestListener) {
        SLog.i("openSDK_LOG.HttpUtils", "OpenApi requestAsync");
        l.a(new Runnable() { // from class: com.tencent.open.utils.HttpUtils.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject request = HttpUtils.request(QQToken.this, context, str, bundle, str2);
                    IRequestListener iRequestListener2 = iRequestListener;
                    if (iRequestListener2 != null) {
                        iRequestListener2.onComplete(request);
                        SLog.i("openSDK_LOG.HttpUtils", "OpenApi onComplete");
                    }
                } catch (HttpStatusException e6) {
                    IRequestListener iRequestListener3 = iRequestListener;
                    if (iRequestListener3 != null) {
                        iRequestListener3.onHttpStatusException(e6);
                        SLog.e("openSDK_LOG.HttpUtils", "OpenApi requestAsync onHttpStatusException" + e6.toString());
                    }
                } catch (NetworkUnavailableException e7) {
                    IRequestListener iRequestListener4 = iRequestListener;
                    if (iRequestListener4 != null) {
                        iRequestListener4.onNetworkUnavailableException(e7);
                        SLog.e("openSDK_LOG.HttpUtils", "OpenApi requestAsync onNetworkUnavailableException" + e7.toString());
                    }
                } catch (MalformedURLException e8) {
                    IRequestListener iRequestListener5 = iRequestListener;
                    if (iRequestListener5 != null) {
                        iRequestListener5.onMalformedURLException(e8);
                        SLog.e("openSDK_LOG.HttpUtils", "OpenApi requestAsync MalformedURLException" + e8.toString());
                    }
                } catch (SocketTimeoutException e9) {
                    IRequestListener iRequestListener6 = iRequestListener;
                    if (iRequestListener6 != null) {
                        iRequestListener6.onSocketTimeoutException(e9);
                        SLog.e("openSDK_LOG.HttpUtils", "OpenApi requestAsync onSocketTimeoutException" + e9.toString());
                    }
                } catch (IOException e10) {
                    IRequestListener iRequestListener7 = iRequestListener;
                    if (iRequestListener7 != null) {
                        iRequestListener7.onIOException(e10);
                        SLog.e("openSDK_LOG.HttpUtils", "OpenApi requestAsync IOException" + e10.toString());
                    }
                } catch (JSONException e11) {
                    IRequestListener iRequestListener8 = iRequestListener;
                    if (iRequestListener8 != null) {
                        iRequestListener8.onJSONException(e11);
                        SLog.e("openSDK_LOG.HttpUtils", "OpenApi requestAsync JSONException" + e11.toString());
                    }
                } catch (Exception e12) {
                    IRequestListener iRequestListener9 = iRequestListener;
                    if (iRequestListener9 != null) {
                        iRequestListener9.onUnknowException(e12);
                        SLog.e("openSDK_LOG.HttpUtils", "OpenApi requestAsync onUnknowException" + e12.toString());
                    }
                }
            }
        });
    }

    private HttpUtils() {
    }

    public static String encodeUrl(Map<String, String> map) {
        if (map != null && map.size() != 0) {
            StringBuilder sb = new StringBuilder();
            boolean z5 = true;
            for (String str : map.keySet()) {
                if (z5) {
                    z5 = false;
                } else {
                    sb.append(ContainerUtils.FIELD_DELIMITER);
                }
                sb.append(URLEncoder.encode(str));
                sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb.append(URLEncoder.encode(map.get(str)));
            }
            return sb.toString();
        }
        return "";
    }

    private static String b(Context context) {
        return System.getProperty("http.proxyHost");
    }

    private static com.tencent.open.a.g a(String str, String str2, Bundle bundle) throws IOException {
        Bundle bundle2;
        if (bundle != null) {
            bundle2 = new Bundle(bundle);
        } else {
            bundle2 = new Bundle();
        }
        if (str2.equalsIgnoreCase("GET")) {
            Map<String, String> a6 = a(bundle2);
            Bundle b6 = com.tencent.open.log.d.b(bundle2);
            if (b6 != bundle2) {
                SLog.i("openSDK_LOG.HttpUtils", "-->openUrl encodedParam =" + b6.toString() + " -- url = " + str);
            } else {
                SLog.i("openSDK_LOG.HttpUtils", "-->openUrl encodedParam =" + a6.toString() + " -- url = " + str);
            }
            return com.tencent.open.a.f.a().a(str, a6);
        }
        if (str2.equalsIgnoreCase("POST")) {
            Map<String, String> a7 = a(bundle2);
            Map<String, byte[]> b7 = b(bundle2);
            if (b7 != null && b7.size() != 0) {
                SLog.w("openSDK_LOG.HttpUtils", "openUrl: has binary " + b7.size());
                return com.tencent.open.a.f.a().a(str, a7, b7);
            }
            return com.tencent.open.a.f.a().b(str, a7);
        }
        SLog.e("openSDK_LOG.HttpUtils", "openUrl: http method " + str2 + " is not supported.");
        throw new IOException("http method is not supported.");
    }

    private static Map<String, String> a(Bundle bundle) {
        HashMap hashMap = new HashMap();
        if (bundle != null && bundle.size() != 0) {
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (!(obj instanceof String) && !(obj instanceof String[])) {
                    SLog.w("openSDK_LOG.HttpUtils", "parseBundleToMap: the type " + obj.getClass() + " is unsupported");
                } else if (obj instanceof String[]) {
                    String[] strArr = (String[]) obj;
                    StringBuilder sb = new StringBuilder();
                    for (int i6 = 0; i6 < strArr.length; i6++) {
                        if (i6 != 0) {
                            sb.append(",");
                        }
                        sb.append(strArr[i6]);
                    }
                    hashMap.put(str, sb.toString());
                } else {
                    hashMap.put(str, (String) obj);
                }
            }
        }
        return hashMap;
    }

    private static int a(Context context) {
        String property = System.getProperty("http.proxyPort");
        if (TextUtils.isEmpty(property)) {
            return -1;
        }
        try {
            return Integer.parseInt(property);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }
}
