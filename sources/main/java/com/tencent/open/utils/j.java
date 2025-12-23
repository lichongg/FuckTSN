package com.tencent.open.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.open.log.SLog;
import java.lang.ref.WeakReference;
import java.net.URL;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private static j f40666a;

    /* renamed from: b, reason: collision with root package name */
    private volatile WeakReference<SharedPreferences> f40667b = null;

    public static synchronized j a() {
        j jVar;
        synchronized (j.class) {
            try {
                if (f40666a == null) {
                    f40666a = new j();
                }
                jVar = f40666a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return jVar;
    }

    public String a(Context context, String str) {
        if (this.f40667b == null || this.f40667b.get() == null) {
            this.f40667b = new WeakReference<>(context.getSharedPreferences("ServerPrefs", 0));
        }
        try {
            String host = new URL(str).getHost();
            if (host == null) {
                SLog.e("openSDK_LOG.ServerSetting", "Get host error. url=" + str);
                return str;
            }
            String string = this.f40667b.get().getString(host, null);
            if (string != null && !host.equals(string)) {
                String replace = str.replace(host, string);
                SLog.v("openSDK_LOG.ServerSetting", "return environment url : " + replace);
                return replace;
            }
            SLog.v("openSDK_LOG.ServerSetting", "host=" + host + ", envHost=" + string);
            return str;
        } catch (Exception e6) {
            SLog.e("openSDK_LOG.ServerSetting", "getEnvUrl url=" + str + "error.: " + e6.getMessage());
            return str;
        }
    }
}
