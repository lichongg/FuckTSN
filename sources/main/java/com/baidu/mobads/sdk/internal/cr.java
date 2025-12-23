package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class cr {

    /* renamed from: a, reason: collision with root package name */
    private static volatile cr f10961a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f10962b;

    public static cr a() {
        if (f10961a == null) {
            synchronized (cr.class) {
                try {
                    if (f10961a == null) {
                        f10961a = new cr();
                    }
                } finally {
                }
            }
        }
        return f10961a;
    }

    public boolean b() {
        return this.f10962b;
    }

    public String h(String str) {
        if (str == null) {
            return null;
        }
        String[] split = (a(str).booleanValue() || b(str).booleanValue()) ? str.split("\\?") : null;
        if (split == null || split.length < 2) {
            return null;
        }
        return split[1];
    }

    public Boolean b(String str) {
        return a(str, "https:");
    }

    public Boolean d(String str) {
        return Boolean.valueOf(a(str, "sms:").booleanValue() || a(str, "smsto:").booleanValue() || a(str, "mms:").booleanValue());
    }

    public String e(String str) {
        try {
            String path = new URI(str).getPath();
            return path.substring(path.lastIndexOf(47) + 1, path.length());
        } catch (URISyntaxException unused) {
            return "";
        }
    }

    public String g(String str) {
        if (str == null) {
            return null;
        }
        return (a(str).booleanValue() || b(str).booleanValue()) ? str.split("\\?")[0] : str;
    }

    public void i(String str) {
        new an(str).b();
    }

    private cr() {
    }

    public String c(String str) {
        if (a(str).booleanValue()) {
            return str.replaceFirst("(?i)http", master.flame.danmaku.danmaku.parser.b.f50155b);
        }
        return str;
    }

    public boolean f(String str) {
        if (!TextUtils.isEmpty(str) && str.contains("/thefatherofsalmon.com")) {
            return false;
        }
        return true;
    }

    public void a(boolean z5) {
        this.f10962b = z5;
    }

    public Boolean a(String str) {
        return a(str, "http:");
    }

    private Boolean a(String str, String str2) {
        boolean z5 = false;
        if (str != null && str.trim().toLowerCase(Locale.getDefault()).indexOf(str2) == 0) {
            z5 = true;
        }
        return Boolean.valueOf(z5);
    }

    public HttpURLConnection a(URL url) {
        if (url.getProtocol().toLowerCase().equals(master.flame.danmaku.danmaku.parser.b.f50155b)) {
            return (HttpsURLConnection) url.openConnection();
        }
        return (HttpURLConnection) url.openConnection();
    }

    public String a(String str, HashMap<String, String> hashMap) {
        StringBuilder sb = new StringBuilder(str);
        if (hashMap != null && !hashMap.isEmpty()) {
            sb.append("?");
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                try {
                    sb.append(entry.getKey());
                    sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb.append(entry.getValue());
                    sb.append(ContainerUtils.FIELD_DELIMITER);
                } catch (Exception e6) {
                    bu.a().c(e6);
                }
            }
            return sb.toString().substring(0, r3.length() - 1);
        }
        return sb.toString();
    }

    public void a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            try {
                httpURLConnection.getInputStream().close();
            } catch (Throwable unused) {
            }
            try {
                httpURLConnection.getOutputStream().close();
            } catch (Throwable unused2) {
            }
            try {
                httpURLConnection.disconnect();
            } catch (Throwable unused3) {
            }
        }
    }
}
