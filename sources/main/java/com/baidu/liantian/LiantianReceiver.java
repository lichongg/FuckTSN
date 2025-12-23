package com.baidu.liantian;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.liantian.ac.Callback;
import com.baidu.liantian.ac.U;
import com.baidu.liantian.b.r;
import com.baidu.liantian.core.ApkInfo;
import com.baidu.liantian.core.g;
import com.baidu.liantian.core.h;
import com.baidu.liantian.rp.Report;
import com.kuaishou.weapon.p0.t;
import com.stub.StubApp;
import com.umeng.analytics.pro.bi;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class LiantianReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    Callback f10319a = new Callback() { // from class: com.baidu.liantian.LiantianReceiver.1
        @Override // com.baidu.liantian.ac.Callback
        public final Object onEnd(Object... objArr) {
            return super.onEnd(objArr);
        }
    };

    /* renamed from: b, reason: collision with root package name */
    private boolean f10320b = false;

    /* renamed from: c, reason: collision with root package name */
    private long f10321c = 0;

    public final LiantianReceiver a() {
        try {
            this.f10321c = System.currentTimeMillis();
            this.f10320b = true;
            return this;
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
            return this;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, final Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            if (!this.f10320b || System.currentTimeMillis() - this.f10321c >= 2000) {
                intent.toString();
                b.a();
                final boolean z5 = this.f10320b;
                r.a().a(new Runnable() { // from class: com.baidu.liantian.LiantianReceiver.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        boolean z6;
                        ApkInfo d6;
                        try {
                            intent.toString();
                            b.a();
                            System.currentTimeMillis();
                            if (t.f36150k.equals(intent.getStringExtra(bi.aL))) {
                                String stringExtra = intent.getStringExtra("c");
                                Intent intent2 = new Intent();
                                intent2.putExtra(bi.aL, t.f36150k);
                                intent2.putExtra("c", stringExtra);
                                a.a(context, intent2);
                            }
                            String action = intent.getAction();
                            if (!TextUtils.isEmpty(action) && action.equals("android.intent.action.BOOT_COMPLETED")) {
                                com.baidu.liantian.b.e.d(context);
                                com.baidu.liantian.b.b.a(context, true);
                                Report.getInstance(context).r(true);
                                com.baidu.liantian.core.d.a(2);
                                com.baidu.liantian.core.d.a(StubApp.getOrigApplicationContext(context.getApplicationContext())).a(new Callback() { // from class: com.baidu.liantian.LiantianReceiver.2.1
                                    @Override // com.baidu.liantian.ac.Callback
                                    public final Object onEnd(Object... objArr) {
                                        g a6 = g.a();
                                        if (a6 == null) {
                                            return null;
                                        }
                                        List<ApkInfo> b6 = a6.b();
                                        if (b6 == null) {
                                            b6 = new ArrayList<>();
                                        }
                                        com.baidu.liantian.a.a a7 = com.baidu.liantian.a.a.a(StubApp.getOrigApplicationContext(context.getApplicationContext()));
                                        for (ApkInfo apkInfo : b6) {
                                            String[] b7 = a7.b(apkInfo.packageName);
                                            if (b7 != null) {
                                                try {
                                                    Class<?> loadClass = apkInfo.classLoader.loadClass(b7[0]);
                                                    loadClass.getDeclaredMethod(b7[1], Context.class, Intent.class).invoke(loadClass.newInstance(), StubApp.getOrigApplicationContext(context.getApplicationContext()), intent);
                                                } catch (Throwable th) {
                                                    th.getMessage();
                                                    b.b();
                                                }
                                            }
                                        }
                                        return super.onEnd(objArr);
                                    }
                                });
                                return;
                            }
                            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action) && com.baidu.liantian.b.e.f(context) && U.sMonitorNetworkWhenUpgradeNoNet) {
                                new U(StubApp.getOrigApplicationContext(context.getApplicationContext()), 3, false).start();
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action) && com.baidu.liantian.b.e.f10342a && !z6 && com.baidu.liantian.b.e.e(context)) {
                                new U(StubApp.getOrigApplicationContext(context.getApplicationContext()), 3, false).start();
                            }
                            if (z5) {
                                return;
                            }
                            if (!TextUtils.isEmpty(action) && action.equals("android.intent.action.PACKAGE_REMOVED")) {
                                com.baidu.liantian.b.e.a(context, intent);
                            }
                            String stringExtra2 = intent.getStringExtra("from_plugin_package");
                            if (!TextUtils.isEmpty(stringExtra2)) {
                                if (context.getPackageName().equals(stringExtra2)) {
                                    LiantianReceiver.a(context.getClassLoader(), intent, context);
                                    return;
                                }
                                g a6 = g.a();
                                if (a6 == null || (d6 = a6.d(stringExtra2)) == null) {
                                    return;
                                }
                                LiantianReceiver.a(d6.classLoader, intent, context);
                                System.currentTimeMillis();
                                intent.toString();
                                b.a();
                                return;
                            }
                            g a7 = g.a();
                            if (a7 == null) {
                                return;
                            }
                            List<ApkInfo> b6 = a7.b();
                            if (b6 != null) {
                                for (int i6 = 0; i6 < b6.size(); i6++) {
                                    ApkInfo apkInfo = b6.get(i6);
                                    if (apkInfo.intentFilters != null) {
                                        for (int i7 = 0; i7 < apkInfo.intentFilters.size(); i7++) {
                                            try {
                                                h hVar = apkInfo.intentFilters.get(i7);
                                                if (hVar.f10450d.match(intent.getAction(), intent.getType(), intent.getScheme(), intent.getData(), intent.getCategories(), "PIF") >= 0) {
                                                    apkInfo.toString();
                                                    b.a();
                                                    Class<?> loadClass = apkInfo.classLoader.loadClass(hVar.f10448b);
                                                    loadClass.getDeclaredMethod(hVar.f10449c, Context.class, Intent.class).invoke(loadClass.newInstance(), StubApp.getOrigApplicationContext(context.getApplicationContext()), intent);
                                                }
                                            } catch (Throwable unused) {
                                                com.baidu.liantian.b.e.a();
                                            }
                                        }
                                    }
                                }
                            }
                            System.currentTimeMillis();
                            intent.toString();
                            b.a();
                        } catch (Throwable unused2) {
                            com.baidu.liantian.b.e.a();
                        }
                    }
                });
            }
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
        }
    }

    static /* synthetic */ void a(ClassLoader classLoader, Intent intent, Context context) {
        try {
            Class<?> loadClass = classLoader.loadClass(intent.getStringExtra("target_class"));
            loadClass.getDeclaredMethod(intent.getStringExtra("target_method"), Context.class, Intent.class).invoke(loadClass.newInstance(), StubApp.getOrigApplicationContext(context.getApplicationContext()), intent);
        } catch (Throwable th) {
            th.getMessage();
            b.b();
        }
    }
}
