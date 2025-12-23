package cn.jpush.android.ac;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.cache.Key;
import cn.jpush.android.cache.Sp;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.helper.f;
import cn.jpush.android.local.JPushConstants;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes2.dex */
public class c {

    /* renamed from: d, reason: collision with root package name */
    private static volatile c f3375d;

    /* renamed from: a, reason: collision with root package name */
    private Map<Byte, a> f3376a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private Map<Byte, HashMap<String, Boolean>> f3377b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private Map<Byte, String> f3378c = new HashMap();

    private class a {

        /* renamed from: a, reason: collision with root package name */
        public byte f3379a;

        /* renamed from: b, reason: collision with root package name */
        public String f3380b;

        /* renamed from: c, reason: collision with root package name */
        public long f3381c;

        /* renamed from: d, reason: collision with root package name */
        public byte[] f3382d;

        /* renamed from: e, reason: collision with root package name */
        public int f3383e = 0;

        public a(byte b6, String str, long j6, byte[] bArr) {
            this.f3379a = b6;
            this.f3380b = str;
            this.f3381c = j6;
            this.f3382d = bArr;
        }

        public String toString() {
            return "PluginPlatformRegIDBean{pluginPlatformType=" + ((int) this.f3379a) + ", regid='" + this.f3380b + "', rid=" + this.f3381c + ", retryCount=" + this.f3383e + '}';
        }
    }

    private a a(long j6) {
        for (Map.Entry<Byte, a> entry : this.f3376a.entrySet()) {
            if (entry.getValue().f3381c == j6) {
                return entry.getValue();
            }
        }
        Logger.d("PluginPlatformRidUpdate", "can not find uploadBean by rid");
        return null;
    }

    private void b(Context context, byte b6, String str, boolean z5) {
        long a6 = f.a();
        Logger.v("PluginPlatformRidUpdate", "sendRidRequst regid:" + str + ",rid:" + a6 + ",whichPlatform:" + ((int) b6) + " unBindToken:" + z5);
        a aVar = new a(b6, str, a6, cn.jpush.android.z.b.a(str, b6, z5));
        this.f3376a.put(Byte.valueOf(b6), aVar);
        a(context, aVar);
    }

    public static c a() {
        if (f3375d == null) {
            synchronized (c.class) {
                try {
                    if (f3375d == null) {
                        f3375d = new c();
                    }
                } finally {
                }
            }
        }
        return f3375d;
    }

    public void b(Context context, long j6) {
        a a6 = a(j6);
        Logger.ki("PluginPlatformRidUpdate", "onUpdateRidTimeout rid:" + j6 + " ,pluginPlatformRegIDBean:" + a6);
        if (a6 != null) {
            int i6 = a6.f3383e;
            if (i6 < 3) {
                a6.f3383e = i6 + 1;
                a(context, a6);
            } else {
                Logger.d("PluginPlatformRidUpdate", "updateRegId failed by timeout");
                this.f3376a.remove(Byte.valueOf(a6.f3379a));
            }
        }
    }

    private c() {
    }

    public void a(Context context) {
        try {
            Logger.d("PluginPlatformRidUpdate", "reUploadToken cache size=" + this.f3377b.size() + " map=" + this.f3377b);
            if (this.f3377b.isEmpty()) {
                return;
            }
            for (Map.Entry<Byte, HashMap<String, Boolean>> entry : this.f3377b.entrySet()) {
                Byte key = entry.getKey();
                for (Map.Entry<String, Boolean> entry2 : entry.getValue().entrySet()) {
                    String key2 = entry2.getKey();
                    Boolean value = entry2.getValue();
                    Logger.d("PluginPlatformRidUpdate", "reUploadToken platform=" + key + " regID=" + key2 + " unBindToken=" + value);
                    a(context, key.byteValue(), key2, value.booleanValue());
                }
            }
        } catch (Throwable unused) {
        }
    }

    public synchronized void a(Context context, byte b6, String str, boolean z5) {
        if (b6 == 0) {
            Logger.w("PluginPlatformRidUpdate", "unknown plugin platform type");
        } else {
            if (!JPushConstants.isTcpConnected()) {
                HashMap<String, Boolean> hashMap = new HashMap<>();
                hashMap.put(str, Boolean.valueOf(z5));
                this.f3377b.put(Byte.valueOf(b6), hashMap);
                cn.jpush.android.helper.c.a("99999363732041973", 1109L, context);
                Logger.d("PluginPlatformRidUpdate", "tcp disconnected,cache data=" + this.f3377b);
                Logger.d("PluginPlatformRidUpdate", "tcp disconnected,cache size=" + this.f3377b.size());
                return;
            }
            if (this.f3376a.containsKey(Byte.valueOf(b6)) && TextUtils.equals(this.f3376a.get(Byte.valueOf(b6)).f3380b, str)) {
                Logger.d("PluginPlatformRidUpdate", "same regid request, drop it");
                return;
            }
            if (this.f3378c.containsKey(Byte.valueOf(b6)) && TextUtils.equals(this.f3378c.get(Byte.valueOf(b6)), str)) {
                Logger.ke("PluginPlatformRidUpdate", "rom is " + ((int) b6) + " regId had report success,not need report again");
                return;
            }
            b(context, b6, str, z5);
        }
    }

    public void a(Context context, long j6) {
        a a6 = a(j6);
        Logger.ki("PluginPlatformRidUpdate", "onUpdateRidSuccess rid:" + j6 + " ,pluginPlatformRegIDBean:" + a6);
        if (a6 != null) {
            Sp.set(context, Key.ThirdPush_RegID(a6.f3379a).set(a6.f3380b));
            Sp.set(context, Key.ThirdPush_RegUpload(a6.f3379a).set(Boolean.TRUE));
            e.a().a(context, a6.f3379a);
            this.f3376a.remove(Byte.valueOf(a6.f3379a));
            this.f3377b.remove(Byte.valueOf(a6.f3379a));
            this.f3378c.put(Byte.valueOf(a6.f3379a), a6.f3380b);
            e.a().b(context, a6.f3379a, a6.f3380b);
        }
    }

    public void a(Context context, long j6, int i6) {
        a a6 = a(j6);
        Logger.ki("PluginPlatformRidUpdate", "onUpdateRidFailed rid:" + j6 + ",errorCode:" + i6 + " ,pluginPlatformRegIDBean:" + a6);
        if (a6 != null) {
            int i7 = a6.f3383e;
            if (i7 < 3) {
                a6.f3383e = i7 + 1;
                a(context, a6);
            } else {
                Logger.d("PluginPlatformRidUpdate", "updateRegId failed");
                this.f3376a.remove(Byte.valueOf(a6.f3379a));
            }
        }
    }

    private synchronized void a(Context context, a aVar) {
        JCoreHelper.sendRequest(context, JPushConstants.SDK_TYPE, 27, 2, aVar.f3381c, 10000L, aVar.f3382d);
    }
}
