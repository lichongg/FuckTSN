package com.ss.android.socialbase.appdownloader.up;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AppOpsManager;
import android.app.FragmentManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.view.KeyEvent;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.vl;
import com.ss.android.socialbase.appdownloader.view.DownloadHandleNotificationActivity;
import com.ss.android.socialbase.downloader.downloader.cw;
import com.ss.android.socialbase.downloader.jy.j;
import com.stub.StubApp;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes6.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final String f38537a = "c";

    /* renamed from: b, reason: collision with root package name */
    private static List<x2.c> f38538b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private static com.ss.android.socialbase.appdownloader.view.b f38539c;

    /* renamed from: d, reason: collision with root package name */
    private static AlertDialog f38540d;

    /* renamed from: com.ss.android.socialbase.appdownloader.up.c$c, reason: collision with other inner class name */
    static class DialogInterfaceOnClickListenerC0774c implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f38541a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ x2.c f38542b;

        DialogInterfaceOnClickListenerC0774c(Activity activity, x2.c cVar) {
            this.f38541a = activity;
            this.f38542b = cVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i6) {
            c.f(this.f38541a, this.f38542b);
            dialogInterface.cancel();
            AlertDialog unused = c.f38540d = null;
        }
    }

    static class a implements DialogInterface.OnKeyListener {
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i6, KeyEvent keyEvent) {
            if (i6 != 4) {
                return false;
            }
            if (keyEvent.getAction() == 1) {
                c.d(false);
            }
            return true;
        }

        a() {
        }
    }

    static class b implements DialogInterface.OnClickListener {
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i6) {
            c.d(false);
        }

        b() {
        }
    }

    public static void b(int i6) {
        if (Build.VERSION.SDK_INT < 33 || j.j(i6).xt("enable_target_34") <= 0 || e()) {
            return;
        }
        Context nd = cw.nd();
        try {
            Intent intent = new Intent(nd, (Class<?>) DownloadHandleNotificationActivity.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_REQUEST_PERMISSION");
            intent.addFlags(268435456);
            nd.startActivity(intent);
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.m.j.up(f38537a, "requestNotificationPermissionError2:".concat(String.valueOf(th)));
        }
    }

    public static synchronized void c(@NonNull Activity activity, @NonNull x2.c cVar) {
        synchronized (c.class) {
            if (cVar == null) {
                return;
            }
            if (activity != null) {
                try {
                    if (!activity.isFinishing()) {
                        int b6 = com.ss.android.socialbase.appdownloader.c.b(cw.nd(), "tt_appdownloader_notification_request_title");
                        int b7 = com.ss.android.socialbase.appdownloader.c.b(cw.nd(), "tt_appdownloader_notification_request_message");
                        int b8 = com.ss.android.socialbase.appdownloader.c.b(cw.nd(), "tt_appdownloader_notification_request_btn_yes");
                        int b9 = com.ss.android.socialbase.appdownloader.c.b(cw.nd(), "tt_appdownloader_notification_request_btn_no");
                        f38538b.add(cVar);
                        AlertDialog alertDialog = f38540d;
                        if (alertDialog != null) {
                            if (!alertDialog.isShowing()) {
                            }
                            return;
                        }
                        f38540d = new AlertDialog.Builder(activity).setTitle(b6).setMessage(b7).setPositiveButton(b8, new DialogInterfaceOnClickListenerC0774c(activity, cVar)).setNegativeButton(b9, new b()).setOnKeyListener(new a()).setCancelable(false).show();
                        return;
                    }
                } catch (Throwable th) {
                    vl.j(th);
                    d(false);
                    return;
                }
            }
            cVar.xt();
        }
    }

    public static synchronized void d(boolean z5) {
        synchronized (c.class) {
            try {
                AlertDialog alertDialog = f38540d;
                if (alertDialog != null) {
                    alertDialog.cancel();
                    f38540d = null;
                }
                for (x2.c cVar : f38538b) {
                    if (cVar != null) {
                        if (z5) {
                            cVar.j();
                        } else {
                            cVar.xt();
                        }
                    }
                }
            } catch (Throwable th) {
                vl.j(th);
            }
        }
    }

    public static void f(@NonNull Activity activity, @NonNull x2.c cVar) {
        if (activity != null) {
            try {
                if (!activity.isFinishing()) {
                    FragmentManager fragmentManager = activity.getFragmentManager();
                    String str = f38537a;
                    com.ss.android.socialbase.appdownloader.view.b bVar = (com.ss.android.socialbase.appdownloader.view.b) fragmentManager.findFragmentByTag(str);
                    f38539c = bVar;
                    if (bVar == null) {
                        f38539c = new com.ss.android.socialbase.appdownloader.view.b();
                        fragmentManager.beginTransaction().add(f38539c, str).commitAllowingStateLoss();
                        try {
                            fragmentManager.executePendingTransactions();
                        } catch (Throwable th) {
                            vl.j(th);
                        }
                    }
                    f38539c.b();
                    return;
                }
            } catch (Throwable th2) {
                try {
                    vl.j(th2);
                    cVar.j();
                    return;
                } catch (Throwable th3) {
                    vl.j(th3);
                    return;
                }
            }
        }
        cVar.j();
    }

    public static boolean e() {
        try {
            return g();
        } catch (Throwable th) {
            vl.j(th);
            return true;
        }
    }

    private static boolean g() {
        boolean areNotificationsEnabled;
        Context nd = cw.nd();
        NotificationManager notificationManager = (NotificationManager) nd.getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 24) {
            areNotificationsEnabled = notificationManager.areNotificationsEnabled();
            return areNotificationsEnabled;
        }
        AppOpsManager appOpsManager = (AppOpsManager) nd.getSystemService("appops");
        ApplicationInfo applicationInfo = nd.getApplicationInfo();
        String packageName = StubApp.getOrigApplicationContext(nd.getApplicationContext()).getPackageName();
        int i6 = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class<?> cls2 = Integer.TYPE;
            Method method = cls.getMethod("checkOpNoThrow", cls2, cls2, String.class);
            Integer num = (Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class);
            num.intValue();
            if (((Integer) method.invoke(appOpsManager, num, Integer.valueOf(i6), packageName)).intValue() == 0) {
                return true;
            }
            return false;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        }
    }
}
