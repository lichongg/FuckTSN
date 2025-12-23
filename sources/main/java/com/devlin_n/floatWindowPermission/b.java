package com.devlin_n.floatWindowPermission;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private static final String f32260b = "FloatWindowManager";

    /* renamed from: c, reason: collision with root package name */
    public static final int f32261c = 1;

    /* renamed from: d, reason: collision with root package name */
    private static volatile b f32262d;

    /* renamed from: a, reason: collision with root package name */
    private Dialog f32263a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f32264a;

        a(Context context) {
            this.f32264a = context;
        }

        @Override // com.devlin_n.floatWindowPermission.b.h
        public void a(boolean z5) {
            if (z5) {
                com.devlin_n.floatWindowPermission.f.a(this.f32264a);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.devlin_n.floatWindowPermission.b$b, reason: collision with other inner class name */
    class C0514b implements h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f32266a;

        C0514b(Context context) {
            this.f32266a = context;
        }

        @Override // com.devlin_n.floatWindowPermission.b.h
        public void a(boolean z5) {
            if (z5) {
                com.devlin_n.floatWindowPermission.c.a(this.f32266a);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f32268a;

        c(Context context) {
            this.f32268a = context;
        }

        @Override // com.devlin_n.floatWindowPermission.b.h
        public void a(boolean z5) {
            if (z5) {
                com.devlin_n.floatWindowPermission.d.a(this.f32268a);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f32270a;

        d(Context context) {
            this.f32270a = context;
        }

        @Override // com.devlin_n.floatWindowPermission.b.h
        public void a(boolean z5) {
            if (z5) {
                com.devlin_n.floatWindowPermission.e.a(this.f32270a);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e implements h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f32272a;

        e(Context context) {
            this.f32272a = context;
        }

        @Override // com.devlin_n.floatWindowPermission.b.h
        public void a(boolean z5) {
            if (z5) {
                try {
                    Intent intent = new Intent(Settings.class.getDeclaredField("ACTION_MANAGE_OVERLAY_PERMISSION").get(null).toString());
                    intent.setData(Uri.parse("package:" + this.f32272a.getPackageName()));
                    com.devlin_n.floatWindowPermission.h.a(this.f32272a).startActivityForResult(intent, 1);
                } catch (Exception e6) {
                    Log.getStackTraceString(e6);
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class f implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f32274a;

        f(h hVar) {
            this.f32274a = hVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i6) {
            this.f32274a.a(false);
            dialogInterface.dismiss();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class g implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f32276a;

        g(h hVar) {
            this.f32276a = hVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i6) {
            this.f32276a.a(true);
            dialogInterface.dismiss();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private interface h {
        void a(boolean z5);
    }

    private void a(Context context) {
        n(context, new a(context));
    }

    public static b f() {
        if (f32262d == null) {
            synchronized (b.class) {
                try {
                    if (f32262d == null) {
                        f32262d = new b();
                    }
                } finally {
                }
            }
        }
        return f32262d;
    }

    private void h(Context context) {
        n(context, new C0514b(context));
    }

    private void j(Context context) {
        n(context, new c(context));
    }

    private void l(Context context) {
        n(context, new d(context));
    }

    private void n(Context context, h hVar) {
        o(context, "您的手机没有授予悬浮窗权限，开启后才能正常使用此功能", hVar);
    }

    private void o(Context context, String str, h hVar) {
        Dialog dialog = this.f32263a;
        if (dialog != null && dialog.isShowing()) {
            this.f32263a.dismiss();
        }
        AlertDialog create = new AlertDialog.Builder(context).setCancelable(true).setTitle("").setMessage(str).setPositiveButton("现在去开启", new g(hVar)).setNegativeButton("暂不开启", new f(hVar)).create();
        this.f32263a = create;
        create.show();
    }

    public void b(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            if (com.devlin_n.floatWindowPermission.g.d()) {
                l(context);
            } else if (com.devlin_n.floatWindowPermission.g.c()) {
                j(context);
            } else if (com.devlin_n.floatWindowPermission.g.b()) {
                h(context);
            } else if (com.devlin_n.floatWindowPermission.g.a()) {
                a(context);
            }
        }
        d(context);
    }

    public boolean c(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            if (com.devlin_n.floatWindowPermission.g.d()) {
                return k(context);
            }
            if (com.devlin_n.floatWindowPermission.g.c()) {
                return i(context);
            }
            if (com.devlin_n.floatWindowPermission.g.b()) {
                return g(context);
            }
            if (com.devlin_n.floatWindowPermission.g.a()) {
                return m(context);
            }
        }
        return e(context);
    }

    private void d(Context context) {
        if (com.devlin_n.floatWindowPermission.g.c()) {
            j(context);
        } else if (Build.VERSION.SDK_INT >= 23) {
            n(context, new e(context));
        }
    }

    private boolean e(Context context) {
        if (com.devlin_n.floatWindowPermission.g.c()) {
            return i(context);
        }
        Boolean bool = Boolean.TRUE;
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                bool = (Boolean) Settings.class.getDeclaredMethod("canDrawOverlays", Context.class).invoke(null, context);
            } catch (Exception e6) {
                Log.getStackTraceString(e6);
            }
        }
        return bool.booleanValue();
    }

    private boolean g(Context context) {
        return com.devlin_n.floatWindowPermission.c.b(context);
    }

    private boolean i(Context context) {
        return com.devlin_n.floatWindowPermission.d.b(context);
    }

    private boolean k(Context context) {
        return com.devlin_n.floatWindowPermission.e.b(context);
    }

    private boolean m(Context context) {
        return com.devlin_n.floatWindowPermission.f.b(context);
    }
}
