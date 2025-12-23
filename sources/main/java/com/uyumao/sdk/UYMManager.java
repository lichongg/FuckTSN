package com.uyumao.sdk;

import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.ccg.ActionInfo;
import com.umeng.commonsdk.UMConfigure;
import com.uyumao.b;
import com.uyumao.c;
import com.uyumao.d;
import com.uyumao.e;
import com.uyumao.g;
import com.uyumao.h;
import com.uyumao.l;
import com.uyumao.q;
import com.uyumao.s;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.Future;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class UYMManager {

    /* renamed from: a, reason: collision with root package name */
    public static UYMManager f42633a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements ActionInfo {
        @Override // com.umeng.ccg.ActionInfo
        public String getModule(Context context) {
            return "anti";
        }

        @Override // com.umeng.ccg.ActionInfo
        public String[] getSupportAction(Context context) {
            return new String[]{com.umeng.ccg.a.f41529e, com.umeng.ccg.a.f41528d, com.umeng.ccg.a.f41527c, com.umeng.ccg.a.f41526b};
        }

        @Override // com.umeng.ccg.ActionInfo
        public boolean getSwitchState(Context context, String str) {
            boolean z5 = com.umeng.ccg.a.f41529e.equals(str) ? d.f42569f : false;
            if (com.umeng.ccg.a.f41528d.equals(str)) {
                boolean z6 = d.f42564a;
                boolean z7 = d.f42565b;
                if (z6 || z7) {
                    z5 = true;
                }
            }
            if (com.umeng.ccg.a.f41527c.equals(str)) {
                z5 = d.f42568e;
            }
            if (com.umeng.ccg.a.f41526b.equals(str)) {
                boolean z8 = d.f42566c;
                boolean z9 = d.f42567d;
                if (z8 || z9) {
                    return true;
                }
            }
            return z5;
        }

        @Override // com.umeng.ccg.ActionInfo
        public void onCommand(Context context, String str, Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            boolean z5 = d.f42564a;
            d.f42570g = StubApp.getOrigApplicationContext(context.getApplicationContext());
            if (jSONObject == null) {
                return;
            }
            try {
                if (jSONObject.has("actionName")) {
                    Integer num = d.f42576m.get(jSONObject.optString("actionName"));
                    if (num != null) {
                        g.a(context, num.intValue(), d.e.f42581a, jSONObject);
                    }
                }
            } catch (Throwable unused) {
            }
        }

        public a(UYMManager uYMManager) {
        }
    }

    public synchronized void init(Context context) {
        Future<?> future;
        if (context == null) {
            return;
        }
        try {
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            if (!c.f42562a) {
                c.f42562a = true;
                if (origApplicationContext.getSharedPreferences("uyumao_info", 0).getBoolean(new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(new Date()), false)) {
                    new Thread(new com.uyumao.a(origApplicationContext)).start();
                } else {
                    l.a().b().execute(new b(origApplicationContext));
                }
                try {
                    h hVar = c.f42563b;
                    if (hVar != null) {
                        origApplicationContext.unregisterReceiver(hVar);
                    }
                    c.f42563b = new h();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                    origApplicationContext.registerReceiver(c.f42563b, intentFilter);
                } catch (Throwable unused) {
                }
            }
            e.f42582a = context;
            try {
                if (Class.forName("com.umeng.commonsdk.UMConfigure").getDeclaredMethod("registerActionInfo", ActionInfo.class) != null) {
                    UMConfigure.registerActionInfo(new a(this));
                }
            } catch (Throwable unused2) {
            }
        } catch (Throwable th) {
            th.printStackTrace();
        } finally {
        }
        if (d.f42569f) {
            WeakReference<Future<?>> weakReference = e.f42583b;
            if (weakReference == null || (future = weakReference.get()) == null || future.isDone() || future.isCancelled()) {
                e.f42583b = new WeakReference<>(s.a(new q()));
            }
        }
    }

    public static void enableYm1(Context context, boolean z5) {
        d.f42564a = z5;
    }

    public static void enableYm2(Context context, boolean z5) {
        d.f42565b = z5;
    }

    public static void enableYm3(Context context, boolean z5) {
        d.f42566c = z5;
    }

    public static void enableYm4(Context context, boolean z5) {
        d.f42567d = z5;
    }

    public static void enableYm5(Context context, boolean z5) {
        d.f42568e = z5;
    }

    public static void enableYm6(Context context, boolean z5) {
        d.f42569f = z5;
    }

    public static synchronized UYMManager getInstance() {
        UYMManager uYMManager;
        synchronized (UYMManager.class) {
            try {
                if (f42633a == null) {
                    f42633a = new UYMManager();
                }
                uYMManager = f42633a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return uYMManager;
    }

    public static String getSdkVersion() {
        return "1.1.2";
    }

    public static void processEvent(Context context, String str) {
        boolean z5 = d.f42564a;
        d.f42570g = StubApp.getOrigApplicationContext(context.getApplicationContext());
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("actionName")) {
                Integer num = d.f42576m.get(jSONObject.optString("actionName"));
                if (num != null) {
                    g.a(context, num.intValue(), d.e.f42581a, jSONObject);
                }
            }
        } catch (Throwable unused) {
        }
    }
}
