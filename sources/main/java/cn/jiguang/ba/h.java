package cn.jiguang.ba;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.bz.w;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static final String f1928a;

    /* renamed from: b, reason: collision with root package name */
    private static final String f1929b;

    /* renamed from: c, reason: collision with root package name */
    private static AtomicBoolean f1930c;

    /* renamed from: d, reason: collision with root package name */
    private static long f1931d;

    /* renamed from: e, reason: collision with root package name */
    private static Boolean f1932e;

    /* renamed from: f, reason: collision with root package name */
    private static LinkedList<String> f1933f;

    /* renamed from: g, reason: collision with root package name */
    private static Boolean f1934g;

    /* renamed from: h, reason: collision with root package name */
    private static int f1935h;

    /* renamed from: i, reason: collision with root package name */
    private static int f1936i;

    private static class a extends cn.jiguang.by.b {

        /* renamed from: a, reason: collision with root package name */
        private Context f1937a;

        private int a(Context context) {
            String a6;
            String str;
            try {
                a6 = cn.jiguang.ba.a.a(context);
            } catch (Throwable unused) {
            }
            if (TextUtils.isEmpty(a6)) {
                cn.jiguang.bb.f.i("JSDKBannedHelper", "request bannedConfig failed because can't get appKey");
                return -1;
            }
            long longValue = ((Long) cn.jiguang.e.b.a(context, cn.jiguang.e.a.B())).longValue();
            w.a(context, h.f1933f);
            Iterator it = h.f1933f.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                String uuid = UUID.randomUUID().toString();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appkey", a6);
                jSONObject.put("uid", longValue);
                jSONObject.put("stoken", uuid);
                jSONObject.put("ver", 2);
                jSONObject.put("platform", "a");
                cn.jiguang.bb.f.c("JSDKBannedHelper", "request url: " + str2 + ", param json:" + jSONObject.toString());
                if (TextUtils.isEmpty(str2)) {
                    cn.jiguang.bb.f.i("JSDKBannedHelper", "can't get url, give up upload");
                    return -1;
                }
                cn.jiguang.bd.g a7 = cn.jiguang.bd.b.a(str2, jSONObject.toString(), context, false, 3, 3);
                int a8 = a7.a();
                String b6 = a7.b();
                cn.jiguang.bb.f.c("JSDKBannedHelper", "code: " + a8 + ", responseBody:" + b6);
                int a9 = a7.a();
                if (a9 == -3) {
                    return -2;
                }
                if (a9 != 3006) {
                    if (a9 == -1) {
                        str = "upload" + jSONObject.toString() + " error:" + a7.b();
                    } else {
                        if (a9 == 0) {
                            if (TextUtils.isEmpty(b6)) {
                                return 0;
                            }
                            String optString = new JSONObject(b6).optString("stoken");
                            if (uuid.equals(optString)) {
                                h.b(context, new JSONObject(b6));
                                return 0;
                            }
                            cn.jiguang.bb.f.i("JSDKBannedHelper", "banned config uuid not match, reqUuid: " + uuid + ", resUuid: " + optString);
                            return 0;
                        }
                        str = "upload" + jSONObject.toString() + " failed";
                    }
                    cn.jiguang.bb.f.c("JSDKBannedHelper", str);
                } else {
                    Boolean unused2 = h.f1932e = null;
                }
            }
            return -1;
        }

        @Override // cn.jiguang.by.b
        public void a() {
            cn.jiguang.bb.f.c("JSDKBannedHelper", "start request sdk banned config");
            int a6 = a(this.f1937a);
            if (a6 != 0) {
                cn.jiguang.bb.f.i("JSDKBannedHelper", "request banned config failed, code: " + a6);
            }
        }

        a(Context context) {
            this.f1937a = context;
            this.f2653h = "JBannedConfig";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004d A[Catch: all -> 0x0020, TryCatch #0 {all -> 0x0020, blocks: (B:7:0x000f, B:9:0x0013, B:13:0x0023, B:15:0x004d, B:16:0x0064), top: B:6:0x000f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void b(android.content.Context r6) {
        /*
            java.lang.String r0 = "updateImmediately start"
            java.lang.String r1 = "JSDKBannedHelper"
            cn.jiguang.bb.f.c(r1, r0)
            if (r6 != 0) goto Lf
            java.lang.String r6 = "updateImmediately failed: context is null"
            cn.jiguang.bb.f.i(r1, r6)
            return
        Lf:
            java.lang.Boolean r0 = cn.jiguang.ba.h.f1932e     // Catch: java.lang.Throwable -> L20
            if (r0 != 0) goto L22
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L20
            long r4 = cn.jiguang.ba.h.f1931d     // Catch: java.lang.Throwable -> L20
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 > 0) goto L1e
            goto L22
        L1e:
            r0 = 0
            goto L23
        L20:
            r6 = move-exception
            goto L68
        L22:
            r0 = 1
        L23:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L20
            r2.<init>()     // Catch: java.lang.Throwable -> L20
            java.lang.String r3 = "updateImmediately: needReset="
            r2.append(r3)     // Catch: java.lang.Throwable -> L20
            r2.append(r0)     // Catch: java.lang.Throwable -> L20
            java.lang.String r3 = ", gIsConfigRequested="
            r2.append(r3)     // Catch: java.lang.Throwable -> L20
            java.lang.Boolean r3 = cn.jiguang.ba.h.f1932e     // Catch: java.lang.Throwable -> L20
            r2.append(r3)     // Catch: java.lang.Throwable -> L20
            java.lang.String r3 = ", gNextReqTime="
            r2.append(r3)     // Catch: java.lang.Throwable -> L20
            long r3 = cn.jiguang.ba.h.f1931d     // Catch: java.lang.Throwable -> L20
            r2.append(r3)     // Catch: java.lang.Throwable -> L20
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L20
            cn.jiguang.bb.f.c(r1, r2)     // Catch: java.lang.Throwable -> L20
            if (r0 == 0) goto L64
            java.lang.String r0 = "Reset request status and continue update"
            cn.jiguang.bb.f.c(r1, r0)     // Catch: java.lang.Throwable -> L20
            r0 = 0
            cn.jiguang.ba.h.f1932e = r0     // Catch: java.lang.Throwable -> L20
            r2 = 0
            cn.jiguang.ba.h.f1931d = r2     // Catch: java.lang.Throwable -> L20
            java.util.concurrent.atomic.AtomicBoolean r0 = cn.jiguang.ba.h.f1930c     // Catch: java.lang.Throwable -> L20
            boolean r0 = r0.get()     // Catch: java.lang.Throwable -> L20
            long r2 = cn.jiguang.ba.h.f1931d     // Catch: java.lang.Throwable -> L20
            a(r6, r0, r2)     // Catch: java.lang.Throwable -> L20
        L64:
            a(r6)     // Catch: java.lang.Throwable -> L20
            return
        L68:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "updateImmediately failed: "
            r0.append(r2)
            java.lang.String r6 = r6.getMessage()
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            cn.jiguang.bb.f.l(r1, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.ba.h.b(android.content.Context):void");
    }

    public static Integer c() {
        return 2;
    }

    static {
        String b6 = cn.jiguang.bz.l.b(new byte[]{126, 101, 68, 80, 106, 50, 57, 62, 83, 79, 119, 110, Byte.MAX_VALUE, 118, 30, 74, 105, 125, 101, 121, 30, 67, 119, 39, 96, 32, Ascii.US, 83, 109, 105, 98, 100, 67});
        f1928a = b6;
        String b7 = cn.jiguang.bz.l.b(new byte[]{96, 98, 101, SignedBytes.MAX_POWER_OF_TWO, 83, BinaryMemcacheOpcodes.GATK, 39, 57, 114, 95, 78, Byte.MAX_VALUE, 97, 113, 60, 89, 80, 111, 62, 56, 123, SignedBytes.MAX_POWER_OF_TWO, 85, 106, 96, 56, 114, 94, 15, 111, 57, 57, 98, 68, 65, 109, 125, 101});
        f1929b = b7;
        f1930c = new AtomicBoolean(false);
        f1931d = 0L;
        f1932e = null;
        LinkedList<String> linkedList = new LinkedList<>();
        f1933f = linkedList;
        f1934g = null;
        f1935h = 1;
        f1936i = 2;
        linkedList.clear();
        f1933f.add(b6);
        f1933f.add(b7);
    }

    private static void a(Context context, int i6) {
        f1934g = Boolean.valueOf(i6 == f1935h);
    }

    private static void b(Context context, int i6) {
        try {
            cn.jiguang.bb.f.c("JSDKBannedHelper", "save sdk regFinger: " + i6);
            context.getSharedPreferences("cn.jiguang.prefs", 0).edit().putInt("sdk_reg_finger", i6).apply();
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("JSDKBannedHelper", "[saveSdkRegFinger] error, " + th);
        }
    }

    private static boolean c(Context context) {
        try {
            String string = context.getSharedPreferences("cn.jiguang.prefs", 0).getString("sdk_banned_status", "");
            cn.jiguang.bb.f.f("JSDKBannedHelper", "local sdk banned config: " + string);
            if (!TextUtils.isEmpty(string)) {
                String[] split = string.split(",");
                boolean parseBoolean = Boolean.parseBoolean(split[0]);
                long parseLong = Long.parseLong(split[1]);
                cn.jiguang.bb.f.c("JSDKBannedHelper", "local banned config, isBanned: " + parseBoolean + ", nextReqTime: " + parseLong);
                f1931d = parseLong;
                f1930c = new AtomicBoolean(parseBoolean);
                return true;
            }
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("JSDKBannedHelper", "read config json from cache failed !! error:" + th);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("values");
            if (optJSONObject != null) {
                boolean equals = "banned".equals(optJSONObject.optString(NotificationCompat.CATEGORY_STATUS));
                long optLong = optJSONObject.optLong("nexttime", 43200L);
                cn.jiguang.bb.f.c("JSDKBannedHelper", "from server sdk banned status: " + equals + ", next request time: " + optLong);
                if (optLong <= 0) {
                    optLong = 0;
                }
                if (optLong >= 86400) {
                    optLong = 86400;
                }
                a(context, equals, System.currentTimeMillis() + (optLong * 1000));
            }
            int optInt = jSONObject.optInt("reg_finger", f1936i);
            b(context, optInt);
            a(context, optInt);
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("JSDKBannedHelper", "parse sdk banned config failed, " + th.getMessage());
        }
    }

    private static void a(Context context, boolean z5, long j6) {
        b(context, z5, j6);
        f1931d = j6;
        if (f1930c.get() != z5) {
            cn.jiguang.bb.f.c("JSDKBannedHelper", "sdk banned status changed, update status, sdkBanned: " + z5);
            if (!z5) {
                f1930c = new AtomicBoolean(z5);
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("sdk_banned", z5);
            JCoreManager.onEvent(context, "", 81, null, bundle, new Object[0]);
        }
        if (z5) {
            cn.jiguang.bb.f.l("JSDKBannedHelper", "[key-step]Your sdk is disabled already. If you want to enable it, please contact us.");
        }
        f1930c = new AtomicBoolean(z5);
        cn.jiguang.bb.f.f("JSDKBannedHelper", "sdk banned status, banned: " + z5 + ", nextTime: " + f1931d);
    }

    private static void b(Context context, boolean z5, long j6) {
        try {
            String str = z5 + "," + j6;
            cn.jiguang.bb.f.c("JSDKBannedHelper", "save sdk banned status: " + str);
            context.getSharedPreferences("cn.jiguang.prefs", 0).edit().putString("sdk_banned_status", str).apply();
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("JSDKBannedHelper", "[saveBannedConfigJson] parse json error, " + th.getMessage());
        }
    }

    public static boolean a() {
        if (f1934g == null) {
            Context a6 = cn.jiguang.bz.d.a(null);
            if (a6 == null) {
                return false;
            }
            a(a6, a6.getSharedPreferences("cn.jiguang.prefs", 0).getInt("sdk_reg_finger", f1936i));
        }
        Boolean bool = f1934g;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static boolean b() {
        Context a6 = cn.jiguang.bz.d.a(null);
        if (a6 != null && cn.jiguang.bz.b.a() && cn.jiguang.bq.b.a().a(a6)) {
            return f1932e == null ? a(a6) : f1930c.get();
        }
        return false;
    }

    public static synchronized boolean a(Context context) {
        synchronized (h.class) {
            if (!cn.jiguang.bz.b.a()) {
                return f1930c.get();
            }
            if (TextUtils.isEmpty(cn.jiguang.ba.a.a(context))) {
                return f1930c.get();
            }
            if (f1932e != null) {
                return f1930c.get();
            }
            f1932e = Boolean.TRUE;
            cn.jiguang.bb.f.c("JSDKBannedHelper", "[isSDKBanned] first request banned config");
            c(context);
            if (System.currentTimeMillis() > f1931d) {
                cn.jiguang.by.d.a("FUTURE_TASK", new a(context), 0, false);
            } else {
                if (f1930c.get()) {
                    cn.jiguang.bb.f.l("JSDKBannedHelper", "[key-step]Your sdk is disabled already. If you want to enable it, please contact us.");
                }
                cn.jiguang.bb.f.c("JSDKBannedHelper", "request sdk banned config not time up, not request");
            }
            return f1930c.get();
        }
    }
}
