package com.acse.ottn;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.acse.ottn.w0;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class d1 {

    /* renamed from: b, reason: collision with root package name */
    public static final String f4400b = "FloatWindowManager";

    /* renamed from: c, reason: collision with root package name */
    public static volatile d1 f4401c;

    /* renamed from: a, reason: collision with root package name */
    public AlertDialog f4402a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements i {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppCompatActivity f4403a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f4404b;

        public a(AppCompatActivity appCompatActivity, int i6) {
            this.f4403a = appCompatActivity;
            this.f4404b = i6;
        }

        @Override // com.acse.ottn.d1.i
        public void a(boolean z5) {
            if (!z5) {
                l2.b().a("cancle_flow_window_list");
                c2.b(d1.f4400b, "ROM:360, user manually refuse OVERLAY_PERMISSION");
                return;
            }
            l2.b().a("open_flow_window_list");
            try {
                String a6 = j3.a().a("flow_window_state", "1");
                if ((j4.b().equals("xiaomi") || j4.b().equals("redmi") || j4.b().equals("blackshark")) && !a6.equals("2")) {
                    j3.a().b("flow_window_state", "2");
                    j3.a().b("OpenPermissionName", "显示悬浮窗");
                    Intent intent = new Intent();
                    j3.a().a("battery_white", Boolean.TRUE);
                    ComponentName componentName = new ComponentName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
                    intent.putExtra("extra_pkgname", this.f4403a.getPackageName());
                    intent.setComponent(componentName);
                    intent.addFlags(268435456);
                    this.f4403a.startActivityForResult(intent, this.f4404b);
                    return;
                }
                if (j4.b().equals("vivo") && !a6.equals("2")) {
                    j3.a().b("flow_window_state", "2");
                    j3.a().a("battery_white", Boolean.TRUE);
                    Intent intent2 = new Intent();
                    intent2.setClassName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity");
                    intent2.putExtra("packagename", k0.f4687w);
                    intent2.putExtra("tabId", "1");
                    this.f4403a.startActivity(intent2);
                    return;
                }
                Intent intent3 = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
                j3.a().b("flow_window_state", "3");
                intent3.setData(Uri.parse("package:" + this.f4403a.getPackageName()));
                j3.a().a("battery_white", Boolean.TRUE);
                this.f4403a.startActivityForResult(intent3, this.f4404b);
            } catch (Exception unused) {
                Intent intent4 = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
                j3.a().b("flow_window_state", "3");
                intent4.setData(Uri.parse("package:" + this.f4403a.getPackageName()));
                j3.a().a("battery_white", Boolean.TRUE);
                this.f4403a.startActivityForResult(intent4, this.f4404b);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b implements i {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppCompatActivity f4406a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f4407b;

        public b(AppCompatActivity appCompatActivity, int i6) {
            this.f4406a = appCompatActivity;
            this.f4407b = i6;
        }

        @Override // com.acse.ottn.d1.i
        public void a(boolean z5) {
            if (z5) {
                i3.a((Activity) this.f4406a, this.f4407b);
            } else {
                c2.b(d1.f4400b, "ROM:360, user manually refuse OVERLAY_PERMISSION");
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class c implements i {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppCompatActivity f4409a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f4410b;

        public c(AppCompatActivity appCompatActivity, int i6) {
            this.f4409a = appCompatActivity;
            this.f4410b = i6;
        }

        @Override // com.acse.ottn.d1.i
        public void a(boolean z5) {
            if (z5) {
                n1.a((Activity) this.f4409a, this.f4410b);
            } else {
                c2.b(d1.f4400b, "ROM:huawei, user manually refuse OVERLAY_PERMISSION");
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class d implements i {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppCompatActivity f4412a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f4413b;

        public d(AppCompatActivity appCompatActivity, int i6) {
            this.f4412a = appCompatActivity;
            this.f4413b = i6;
        }

        @Override // com.acse.ottn.d1.i
        public void a(boolean z5) {
            if (z5) {
                j2.a(this.f4412a, this.f4413b);
            } else {
                c2.b(d1.f4400b, "ROM:meizu, user manually refuse OVERLAY_PERMISSION");
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class e implements i {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppCompatActivity f4415a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f4416b;

        public e(AppCompatActivity appCompatActivity, int i6) {
            this.f4415a = appCompatActivity;
            this.f4416b = i6;
        }

        @Override // com.acse.ottn.d1.i
        public void a(boolean z5) {
            if (z5) {
                k2.a((Activity) this.f4415a, this.f4416b);
            } else {
                c2.b(d1.f4400b, "ROM:miui, user manually refuse OVERLAY_PERMISSION");
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class f implements i {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppCompatActivity f4418a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f4419b;

        public f(AppCompatActivity appCompatActivity, int i6) {
            this.f4418a = appCompatActivity;
            this.f4419b = i6;
        }

        @Override // com.acse.ottn.d1.i
        public void a(boolean z5) {
            if (z5) {
                d3.a((Activity) this.f4418a, this.f4419b);
            } else {
                c2.b(d1.f4400b, "ROM:miui, user manually refuse OVERLAY_PERMISSION");
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class g implements i {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppCompatActivity f4421a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f4422b;

        public g(AppCompatActivity appCompatActivity, int i6) {
            this.f4421a = appCompatActivity;
            this.f4422b = i6;
        }

        @Override // com.acse.ottn.d1.i
        public void a(boolean z5) {
            if (!z5) {
                c2.a(d1.f4400b, "user manually refuse OVERLAY_PERMISSION");
                return;
            }
            try {
                d1.e(this.f4421a, this.f4422b);
            } catch (Exception e6) {
                c2.b(d1.f4400b, Log.getStackTraceString(e6));
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class h implements w0.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f4424a;

        public h(i iVar) {
            this.f4424a = iVar;
        }

        @Override // com.acse.ottn.w0.c
        public void a() {
            d1.this.f4402a.dismiss();
            this.f4424a.a(false);
        }

        @Override // com.acse.ottn.w0.c
        public void b() {
            this.f4424a.a(true);
            d1.this.f4402a.dismiss();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface i {
        void a(boolean z5);
    }

    public static d1 b() {
        if (f4401c == null) {
            synchronized (d1.class) {
                try {
                    if (f4401c == null) {
                        f4401c = new d1();
                    }
                } finally {
                }
            }
        }
        return f4401c;
    }

    public final boolean c(Context context) {
        return n1.a(context);
    }

    public final boolean d(Context context) {
        return j2.a(context);
    }

    public final boolean e(Context context) {
        return k2.a(context);
    }

    public final boolean f(Context context) {
        return d3.a(context);
    }

    public final boolean g(Context context) {
        return i3.a(context);
    }

    public static Boolean a(Context context, String str) {
        Iterator<ActivityManager.RunningServiceInfo> it = ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningServices(100).iterator();
        while (it.hasNext()) {
            if (str.equals(it.next().service.getClassName())) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    public static void e(AppCompatActivity appCompatActivity, int i6) throws NoSuchFieldException, IllegalAccessException {
        Intent intent = new Intent(Settings.class.getDeclaredField("ACTION_MANAGE_OVERLAY_PERMISSION").get(null).toString());
        intent.setFlags(268435456);
        intent.setData(Uri.parse("package:" + appCompatActivity.getPackageName()));
        appCompatActivity.startActivityForResult(intent, i6);
    }

    public final void c(AppCompatActivity appCompatActivity, int i6) {
        if (Build.VERSION.SDK_INT >= 23) {
            d(appCompatActivity, i6);
            return;
        }
        if (n3.d()) {
            h(appCompatActivity, i6);
            return;
        }
        if (n3.c()) {
            g(appCompatActivity, i6);
            return;
        }
        if (n3.b()) {
            f(appCompatActivity, i6);
        } else if (n3.a()) {
            a(appCompatActivity, i6);
        } else if (n3.e()) {
            i(appCompatActivity, i6);
        }
    }

    public final void d(AppCompatActivity appCompatActivity, int i6) {
        if (n3.c()) {
            g(appCompatActivity, i6);
        } else if (Build.VERSION.SDK_INT >= 23) {
            a(appCompatActivity, new g(appCompatActivity, i6));
        }
    }

    public final void f(AppCompatActivity appCompatActivity, int i6) {
        a(appCompatActivity, new c(appCompatActivity, i6));
    }

    public final void g(AppCompatActivity appCompatActivity, int i6) {
        a(appCompatActivity, new d(appCompatActivity, i6));
    }

    public final void h(AppCompatActivity appCompatActivity, int i6) {
        a(appCompatActivity, new e(appCompatActivity, i6));
    }

    public final void i(AppCompatActivity appCompatActivity, int i6) {
        a(appCompatActivity, new f(appCompatActivity, i6));
    }

    public void b(AppCompatActivity appCompatActivity, int i6) {
        com.acse.ottn.b.c().a(false);
        a(appCompatActivity, new a(appCompatActivity, i6));
    }

    public boolean a(Context context) {
        boolean canDrawOverlays;
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        canDrawOverlays = Settings.canDrawOverlays(context);
        return canDrawOverlays;
    }

    public final boolean b(Context context) {
        if (n3.c()) {
            return d(context);
        }
        Boolean bool = Boolean.TRUE;
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                bool = (Boolean) Settings.class.getDeclaredMethod("canDrawOverlays", Context.class).invoke(null, context);
            } catch (Exception e6) {
                c2.b(f4400b, Log.getStackTraceString(e6));
            }
        }
        return bool.booleanValue();
    }

    public final void a(AppCompatActivity appCompatActivity, int i6) {
        a(appCompatActivity, new b(appCompatActivity, i6));
    }

    public final void a(AppCompatActivity appCompatActivity, i iVar) {
        a(appCompatActivity, "您的手机没有授予悬浮窗权限，请开启后再试", iVar);
    }

    public boolean a() {
        AlertDialog alertDialog = this.f4402a;
        return alertDialog != null && alertDialog.isShowing();
    }

    public final void a(AppCompatActivity appCompatActivity, String str, i iVar) {
        AlertDialog alertDialog = this.f4402a;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.f4402a.dismiss();
        }
        this.f4402a = w0.a(appCompatActivity, appCompatActivity.getResources().getString(R.string.dialog_flow_title), appCompatActivity.getResources().getString(R.string.dialog_flow_message), "好的", false, new h(iVar));
    }

    public void a(Activity activity, int i6) {
        l2.b().a("open_flow_window_list");
        try {
            String a6 = j3.a().a("flow_window_state", "1");
            if ((j4.b().equals("xiaomi") || j4.b().equals("redmi") || j4.b().equals("blackshark")) && !a6.equals("2")) {
                j3.a().b("flow_window_state", "2");
                j3.a().b("OpenPermissionName", "显示悬浮窗");
                Intent intent = new Intent();
                j3.a().a("battery_white", Boolean.TRUE);
                ComponentName componentName = new ComponentName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
                intent.putExtra("extra_pkgname", activity.getPackageName());
                intent.setComponent(componentName);
                intent.addFlags(268435456);
                activity.startActivityForResult(intent, i6);
                return;
            }
            if (j4.b().equals("vivo") && !a6.equals("2")) {
                j3.a().b("flow_window_state", "2");
                j3.a().a("battery_white", Boolean.TRUE);
                Intent intent2 = new Intent();
                intent2.setClassName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity");
                intent2.putExtra("packagename", k0.f4687w);
                intent2.putExtra("tabId", "1");
                activity.startActivity(intent2);
                return;
            }
            Intent intent3 = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
            j3.a().b("flow_window_state", "3");
            intent3.setData(Uri.parse("package:" + activity.getPackageName()));
            j3.a().a("battery_white", Boolean.TRUE);
            activity.startActivityForResult(intent3, i6);
        } catch (Exception unused) {
            Intent intent4 = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
            j3.a().b("flow_window_state", "3");
            intent4.setData(Uri.parse("package:" + activity.getPackageName()));
            j3.a().a("battery_white", Boolean.TRUE);
            activity.startActivityForResult(intent4, i6);
        }
    }
}
