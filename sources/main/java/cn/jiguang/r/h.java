package cn.jiguang.r;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import cn.jiguang.bz.s;
import com.huawei.hms.common.util.Logger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class h extends cn.jiguang.m.a {

    /* renamed from: a, reason: collision with root package name */
    public static String f3230a = ".permission.JPUSH_MESSAGE";

    /* renamed from: c, reason: collision with root package name */
    private static boolean f3231c;

    /* renamed from: b, reason: collision with root package name */
    final ReentrantLock f3232b;

    /* renamed from: d, reason: collision with root package name */
    private Context f3233d;

    /* renamed from: e, reason: collision with root package name */
    private BroadcastReceiver f3234e;

    /* renamed from: cn.jiguang.r.h$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class a extends BroadcastReceiver {
        private a() {
        }

        /* synthetic */ a(h hVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(final Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            try {
                final String action = intent.getAction();
                cn.jiguang.bb.f.c("JDeviceScreen", "onReceive Action:" + action);
                cn.jiguang.be.b.e(new Runnable() { // from class: cn.jiguang.r.h.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        h hVar;
                        String str;
                        try {
                            if (cn.jiguang.bz.b.a()) {
                                boolean a6 = cn.jiguang.m.b.a(2900);
                                boolean z5 = false;
                                if (cn.jiguang.g.a.a().a(2900)) {
                                    if ("android.intent.action.SCREEN_ON".equals(action)) {
                                        cn.jiguang.a.a.a(context, false, 0L);
                                    }
                                    if (!a6) {
                                        h.this.h(context);
                                        return;
                                    }
                                    str = "in background,no can report";
                                } else {
                                    try {
                                        boolean tryLock = h.this.f3232b.tryLock(10L, TimeUnit.SECONDS);
                                        try {
                                            if (!h.f3231c) {
                                                if (tryLock) {
                                                    hVar = h.this;
                                                    hVar.f3232b.unlock();
                                                    return;
                                                }
                                                cn.jiguang.bb.f.l("JDeviceScreen", "onReceive hasLock false");
                                                return;
                                            }
                                            cn.jiguang.bb.f.c("JDeviceScreen", "server had close");
                                            BroadcastReceiver broadcastReceiver = h.this.f3234e;
                                            boolean unused = h.f3231c = false;
                                            if (broadcastReceiver != null) {
                                                cn.jiguang.bz.d.a().unregisterReceiver(broadcastReceiver);
                                            }
                                            if (tryLock) {
                                                hVar = h.this;
                                                hVar.f3232b.unlock();
                                                return;
                                            }
                                            cn.jiguang.bb.f.l("JDeviceScreen", "onReceive hasLock false");
                                            return;
                                        } catch (Throwable th) {
                                            th = th;
                                            z5 = tryLock;
                                            if (z5) {
                                                h.this.f3232b.unlock();
                                            } else {
                                                cn.jiguang.bb.f.l("JDeviceScreen", "onReceive hasLock false");
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                    }
                                }
                            } else {
                                str = "no auth";
                            }
                            cn.jiguang.bb.f.c("JDeviceScreen", str);
                        } catch (Throwable unused2) {
                        }
                    }
                });
            } catch (Throwable unused) {
            }
        }
    }

    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        private static final h f3239a = new h(null);
    }

    private h() {
        this.f3232b = new ReentrantLock();
    }

    /* synthetic */ h(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static h a() {
        return b.f3239a;
    }

    public void b(Context context) {
        boolean z5 = false;
        try {
            z5 = this.f3232b.tryLock(10L, TimeUnit.SECONDS);
            if (!f3231c) {
                f3231c = true;
                this.f3234e = new a(this, null);
                String str = context.getPackageName() + f3230a;
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                s.a(context, this.f3234e, intentFilter, str, null, false);
                if (!z5) {
                    cn.jiguang.bb.f.l("JDeviceScreen", "registerReceiver hasLock false");
                    return;
                }
            } else if (!z5) {
                cn.jiguang.bb.f.l("JDeviceScreen", "registerReceiver hasLock false");
                return;
            }
            this.f3232b.unlock();
        } catch (Throwable unused) {
            if (z5) {
                this.f3232b.unlock();
            } else {
                cn.jiguang.bb.f.l("JDeviceScreen", "registerReceiver hasLock false");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(Context context) {
        boolean z5;
        String str;
        String str2;
        String str3;
        try {
            boolean c6 = cn.jiguang.m.b.c(context, "JDeviceScreen");
            cn.jiguang.bb.f.c("JDeviceScreen", "onReceive isReport:" + c6);
            if (c6) {
                boolean isScreenOn = ((PowerManager) context.getSystemService("power")).isScreenOn();
                cn.jiguang.bb.f.c("JDeviceScreen", "onReceive isScreenOn:" + isScreenOn);
                boolean inKeyguardRestrictedInputMode = ((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
                cn.jiguang.bb.f.c("JDeviceScreen", "onReceive flag:" + inKeyguardRestrictedInputMode);
                int i6 = 1;
                if (isScreenOn && !inKeyguardRestrictedInputMode) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (!isScreenOn || inKeyguardRestrictedInputMode) {
                    if (isScreenOn && inKeyguardRestrictedInputMode) {
                        i6 = 2;
                    } else {
                        i6 = 3;
                    }
                }
                StringBuilder sb = new StringBuilder();
                sb.append("onReceive status:");
                if (z5) {
                    str = "开";
                } else {
                    str = "锁";
                }
                sb.append(str);
                cn.jiguang.bb.f.c("JDeviceScreen", sb.toString());
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(NotificationCompat.CATEGORY_STATUS, z5);
                jSONObject.put("state", i6);
                String a6 = cn.jiguang.bz.a.a().a(context, "", false);
                JSONObject a7 = cn.jiguang.x.a.a(context, false);
                if (a7 == null) {
                    str3 = "";
                    str2 = str3;
                } else {
                    try {
                        str2 = a7.optString("joad");
                    } catch (Throwable unused) {
                        str2 = "";
                    }
                    try {
                        str3 = a7.optString("jgad");
                    } catch (Throwable unused2) {
                        str3 = "";
                        if (!TextUtils.isEmpty(a6)) {
                        }
                        jSONObject.put("dev_id", a6 + Logger.f33116c + str2 + Logger.f33116c + str3);
                        cn.jiguang.be.b.a(context, jSONObject, "sc_status");
                        cn.jiguang.m.b.h(context, "JDeviceScreen");
                    }
                }
                if (!TextUtils.isEmpty(a6) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
                    jSONObject.put("dev_id", "");
                } else {
                    jSONObject.put("dev_id", a6 + Logger.f33116c + str2 + Logger.f33116c + str3);
                }
                cn.jiguang.be.b.a(context, jSONObject, "sc_status");
                cn.jiguang.m.b.h(context, "JDeviceScreen");
            }
        } catch (Throwable unused3) {
        }
    }

    @Override // cn.jiguang.m.a
    protected String a(Context context) {
        this.f3233d = context;
        return "JDeviceScreen";
    }

    @Override // cn.jiguang.m.a
    protected void c(Context context, String str) {
        if (cn.jiguang.g.a.a().g(2900)) {
            return;
        }
        try {
            b(context);
            super.c(context, str);
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("JDeviceScreen", "packageJson exception: " + th.getMessage());
        }
    }

    @Override // cn.jiguang.m.a
    protected void d(Context context, String str) {
    }
}
