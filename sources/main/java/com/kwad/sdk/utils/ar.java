package com.kwad.sdk.utils;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.widget.e;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ar {
    private static Handler aRF = new Handler(Looper.getMainLooper());
    private com.kwad.sdk.core.config.d aZV;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a {
        private static final ar aZZ = new ar();
    }

    private static int Re() {
        try {
            return ag.c("ksadsdk_perf", "install_permission_times", 0);
        } catch (Exception unused) {
            return 0;
        }
    }

    private com.kwad.sdk.core.config.d QY() {
        if (this.aZV == null) {
            this.aZV = new com.kwad.sdk.core.config.d();
        }
        return this.aZV;
    }

    private static int Rb() {
        String h6 = ag.h("ksadsdk_perf", "install_permission_times_per_day", "");
        if (TextUtils.isEmpty(h6)) {
            return 0;
        }
        String[] split = h6.split("_");
        try {
            if (split[0].equals(Rf())) {
                return Integer.parseInt(split[1]);
            }
            return 0;
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.w("PackageInstallHelper", Log.getStackTraceString(e6));
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Rc() {
        try {
            String h6 = ag.h("ksadsdk_perf", "install_permission_times_per_day", "");
            if (TextUtils.isEmpty(h6)) {
                ag.g("ksadsdk_perf", "install_permission_times_per_day", Rf() + "_1");
                return;
            }
            String[] split = h6.split("_");
            if (!split[0].equals(Rf())) {
                ag.g("ksadsdk_perf", "install_permission_times_per_day", Rf() + "_1");
                return;
            }
            ag.g("ksadsdk_perf", "install_permission_times_per_day", Rf() + "_" + (Integer.parseInt(split[1]) + 1));
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.w("PackageInstallHelper", Log.getStackTraceString(e6));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Rd() {
        try {
            ag.b("ksadsdk_perf", "install_permission_times", ag.c("ksadsdk_perf", "install_permission_times", 0) + 1);
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.w("PackageInstallHelper", Log.getStackTraceString(e6));
        }
    }

    private static String Rf() {
        return new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(new Date());
    }

    private static boolean m(Activity activity) {
        return Build.VERSION.SDK_INT >= 26 ? activity.getPackageManager().canRequestPackageInstalls() : Settings.Secure.getInt(activity.getContentResolver(), "install_non_market_apps", 0) == 1;
    }

    public static ar QX() {
        return a.aZZ;
    }

    private static boolean Ra() {
        if (!j.PK() && !j.PL()) {
            return false;
        }
        return true;
    }

    private boolean a(com.kwad.sdk.core.config.d dVar) {
        int Rb = Rb();
        if (Rb <= dVar.aCe) {
            return false;
        }
        com.kwad.sdk.core.d.c.d("PackageInstallHelper", "todayShow:" + Rb + " > showTimesPerDay:" + dVar.aCe);
        return true;
    }

    public static com.kwad.sdk.core.config.d hd(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            com.kwad.sdk.core.config.d dVar = new com.kwad.sdk.core.config.d();
            dVar.parseJson(jSONObject);
            return dVar;
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.w("PackageInstallHelper", e6);
            return null;
        }
    }

    public final void QZ() {
        try {
            com.kwad.sdk.core.c.b.Ho();
            com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.sdk.utils.ar.2
                @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
                /* renamed from: onActivityStopped */
                public final void e(Activity activity) {
                    super.e(activity);
                    com.kwad.sdk.core.d.c.d("PackageInstallHelper", "onActivityStopped:" + activity);
                    if (ar.aRF != null) {
                        ar.aRF.removeCallbacksAndMessages(null);
                    }
                }

                @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
                public final void onBackToBackground() {
                    super.onBackToBackground();
                    com.kwad.sdk.core.d.c.d("PackageInstallHelper", "onBackToBackground:");
                    if (ar.aRF != null) {
                        ar.aRF.removeCallbacksAndMessages(null);
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public final void cS(final String str) {
        GlobalThreadPools.Jy().execute(new Runnable() { // from class: com.kwad.sdk.utils.ar.1
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.d.c.d("PackageInstallHelper", "init configStr:" + str);
                if (TextUtils.isEmpty(str)) {
                    com.kwad.sdk.core.d.c.w("PackageInstallHelper", "config is empty");
                } else {
                    ar.this.aZV = ar.hd(str);
                }
            }
        });
    }

    public final void l(final Activity activity) {
        com.kwad.sdk.core.config.d QY = QY();
        if (QY != null && QY.aCc != 0) {
            int i6 = QY.aCd;
            if (i6 >= 0) {
                if (!Ra()) {
                    com.kwad.sdk.core.d.c.d("PackageInstallHelper", "not support");
                    return;
                }
                if (!a(QY)) {
                    if (Re() >= QY.aCf) {
                        com.kwad.sdk.core.d.c.d("PackageInstallHelper", "show times is over max");
                        return;
                    }
                    if (m(activity)) {
                        com.kwad.sdk.core.d.c.d("PackageInstallHelper", "has install permission");
                        return;
                    }
                    Handler handler = aRF;
                    if (handler != null) {
                        handler.removeCallbacksAndMessages(null);
                        aRF.postDelayed(new Runnable() { // from class: com.kwad.sdk.utils.ar.3
                            @Override // java.lang.Runnable
                            public final void run() {
                                try {
                                    final Activity activity2 = (Activity) com.kwad.sdk.o.m.wrapContextIfNeed(activity);
                                    if (!activity2.isFinishing() && !activity2.isDestroyed()) {
                                        com.kwad.sdk.core.d.c.d("PackageInstallHelper", "show dialog");
                                        e.a aVar = new e.a(activity2);
                                        aVar.hK("去授权").hL("残忍拒绝").hJ("需要授予安装其他应用权限");
                                        aVar.a(new e.b() { // from class: com.kwad.sdk.utils.ar.3.1
                                            @Override // com.kwad.sdk.widget.e.b
                                            public final void a(DialogInterface dialogInterface) {
                                                bw.e(dialogInterface);
                                                j.cA(activity2);
                                            }

                                            @Override // com.kwad.sdk.widget.e.b
                                            public final void b(DialogInterface dialogInterface) {
                                                bw.e(dialogInterface);
                                            }

                                            @Override // com.kwad.sdk.widget.e.b
                                            public final void c(DialogInterface dialogInterface) {
                                                bw.e(dialogInterface);
                                            }
                                        });
                                        try {
                                            aVar.SO().show();
                                            ar arVar = ar.this;
                                            ar.Rc();
                                            ar arVar2 = ar.this;
                                            ar.Rd();
                                        } catch (Exception unused) {
                                        }
                                    }
                                } catch (Exception e6) {
                                    ServiceProvider.reportSdkCaughtException(e6);
                                }
                            }
                        }, i6);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        com.kwad.sdk.core.d.c.d("PackageInstallHelper", "config is null or enableDialog is false");
    }
}
