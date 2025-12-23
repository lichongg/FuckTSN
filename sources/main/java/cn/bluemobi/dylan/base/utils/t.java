package cn.bluemobi.dylan.base.utils;

import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.acse.ottn.l3;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.baidu.idl.face.platform.FaceEnvironment;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class t {

    /* renamed from: h, reason: collision with root package name */
    public static final int f1245h = -1728053248;

    /* renamed from: i, reason: collision with root package name */
    private static String f1246i;

    /* renamed from: a, reason: collision with root package name */
    private final b f1247a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f1248b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f1249c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f1250d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f1251e;

    /* renamed from: f, reason: collision with root package name */
    private View f1252f;

    /* renamed from: g, reason: collision with root package name */
    private View f1253g;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b {

        /* renamed from: j, reason: collision with root package name */
        private static final String f1254j = "status_bar_height";

        /* renamed from: k, reason: collision with root package name */
        private static final String f1255k = "navigation_bar_height";

        /* renamed from: l, reason: collision with root package name */
        private static final String f1256l = "navigation_bar_height_landscape";

        /* renamed from: m, reason: collision with root package name */
        private static final String f1257m = "navigation_bar_width";

        /* renamed from: n, reason: collision with root package name */
        private static final String f1258n = "config_showNavigationBar";

        /* renamed from: a, reason: collision with root package name */
        private final boolean f1259a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f1260b;

        /* renamed from: c, reason: collision with root package name */
        private final int f1261c;

        /* renamed from: d, reason: collision with root package name */
        private final int f1262d;

        /* renamed from: e, reason: collision with root package name */
        private final boolean f1263e;

        /* renamed from: f, reason: collision with root package name */
        private final int f1264f;

        /* renamed from: g, reason: collision with root package name */
        private final int f1265g;

        /* renamed from: h, reason: collision with root package name */
        private final boolean f1266h;

        /* renamed from: i, reason: collision with root package name */
        private final float f1267i;

        /* synthetic */ b(Activity activity, boolean z5, boolean z6, a aVar) {
            this(activity, z5, z6);
        }

        private b(Activity activity, boolean z5, boolean z6) {
            Resources resources = activity.getResources();
            this.f1266h = resources.getConfiguration().orientation == 1;
            this.f1267i = k(activity);
            this.f1261c = c(resources, f1254j);
            this.f1262d = b(activity);
            int e6 = e(activity);
            this.f1264f = e6;
            this.f1265g = g(activity);
            this.f1263e = e6 > 0;
            this.f1259a = z5;
            this.f1260b = z6;
        }

        @TargetApi(14)
        private int b(Context context) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true);
            return TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
        }

        private int c(Resources resources, String str) {
            int identifier = resources.getIdentifier(str, "dimen", FaceEnvironment.OS);
            if (identifier > 0) {
                return resources.getDimensionPixelSize(identifier);
            }
            return 0;
        }

        @SuppressLint({"NewApi"})
        private float k(Activity activity) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
            float f6 = displayMetrics.widthPixels;
            float f7 = displayMetrics.density;
            return Math.min(f6 / f7, displayMetrics.heightPixels / f7);
        }

        public int a() {
            return this.f1262d;
        }

        public int d() {
            return this.f1264f;
        }

        public int f() {
            return this.f1265g;
        }

        public int h() {
            if (this.f1260b && o()) {
                return this.f1264f;
            }
            return 0;
        }

        public int i() {
            if (!this.f1260b || o()) {
                return 0;
            }
            return this.f1265g;
        }

        public int j(boolean z5) {
            return (this.f1259a ? this.f1261c : 0) + (z5 ? this.f1262d : 0);
        }

        public int l() {
            return this.f1261c;
        }

        public boolean n() {
            return this.f1263e;
        }

        public boolean o() {
            return this.f1267i >= 600.0f || this.f1266h;
        }

        @TargetApi(14)
        private int e(Context context) {
            String str;
            Resources resources = context.getResources();
            if (m(context)) {
                if (this.f1266h) {
                    str = f1255k;
                } else {
                    str = f1256l;
                }
                return c(resources, str);
            }
            return 0;
        }

        @TargetApi(14)
        private int g(Context context) {
            Resources resources = context.getResources();
            if (m(context)) {
                return c(resources, f1257m);
            }
            return 0;
        }

        @TargetApi(14)
        private boolean m(Context context) {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier(f1258n, "bool", FaceEnvironment.OS);
            if (identifier != 0) {
                boolean z5 = resources.getBoolean(identifier);
                if ("1".equals(t.f1246i)) {
                    return false;
                }
                if ("0".equals(t.f1246i)) {
                    return true;
                }
                return z5;
            }
            return !ViewConfiguration.get(context).hasPermanentMenuKey();
        }
    }

    static {
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod(l3.f4736f, String.class);
            declaredMethod.setAccessible(true);
            f1246i = (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
        } catch (Throwable unused) {
            f1246i = null;
        }
    }

    private void s(Context context, ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams;
        this.f1253g = new View(context);
        if (this.f1247a.o()) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.f1247a.d());
            layoutParams.gravity = 80;
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.f1247a.f(), -1);
            layoutParams.gravity = 5;
        }
        this.f1253g.setLayoutParams(layoutParams);
        this.f1253g.setBackgroundColor(f1245h);
        this.f1253g.setVisibility(8);
        viewGroup.addView(this.f1253g);
    }

    private void t(Context context, ViewGroup viewGroup) {
        this.f1252f = new View(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.f1247a.l());
        layoutParams.gravity = 48;
        if (this.f1249c && !this.f1247a.o()) {
            layoutParams.rightMargin = this.f1247a.f();
        }
        this.f1252f.setLayoutParams(layoutParams);
        this.f1252f.setBackgroundColor(f1245h);
        this.f1252f.setVisibility(8);
        viewGroup.addView(this.f1252f);
    }

    public b b() {
        return this.f1247a;
    }

    public boolean c() {
        return this.f1251e;
    }

    public boolean d() {
        return this.f1250d;
    }

    @TargetApi(11)
    public void e(float f6) {
        if (this.f1249c) {
            this.f1253g.setAlpha(f6);
        }
    }

    public void f(int i6) {
        if (this.f1249c) {
            this.f1253g.setBackgroundColor(i6);
        }
    }

    public void g(Drawable drawable) {
        if (this.f1249c) {
            this.f1253g.setBackgroundDrawable(drawable);
        }
    }

    public void h(boolean z5) {
        this.f1251e = z5;
        if (this.f1249c) {
            this.f1253g.setVisibility(z5 ? 0 : 8);
        }
    }

    public void i(int i6) {
        if (this.f1249c) {
            this.f1253g.setBackgroundResource(i6);
        }
    }

    @TargetApi(11)
    public void j(float f6) {
        if (this.f1248b) {
            this.f1252f.setAlpha(f6);
        }
    }

    public void k(int i6) {
        if (this.f1248b) {
            this.f1252f.setBackgroundColor(i6);
        }
    }

    public void l(Drawable drawable) {
        if (this.f1248b) {
            this.f1252f.setBackgroundDrawable(drawable);
        }
    }

    public void m(boolean z5) {
        this.f1250d = z5;
        if (this.f1248b) {
            this.f1252f.setVisibility(z5 ? 0 : 8);
        }
    }

    public void n(int i6) {
        if (this.f1248b) {
            this.f1252f.setBackgroundResource(i6);
        }
    }

    @TargetApi(19)
    public t(Activity activity) {
        Window window = activity.getWindow();
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        activity.obtainStyledAttributes(new int[]{R.attr.windowTranslucentStatus, R.attr.windowTranslucentNavigation}).recycle();
        int i6 = window.getAttributes().flags;
        if ((67108864 & i6) != 0) {
            this.f1248b = true;
        }
        if ((i6 & AMapEngineUtils.HALF_MAX_P20_WIDTH) != 0) {
            this.f1249c = true;
        }
        b bVar = new b(activity, this.f1248b, this.f1249c, null);
        this.f1247a = bVar;
        if (!bVar.n()) {
            this.f1249c = false;
        }
        if (this.f1248b) {
            t(activity, viewGroup);
        }
        if (this.f1249c) {
            s(activity, viewGroup);
        }
    }

    public void o(float f6) {
        j(f6);
        e(f6);
    }

    public void p(int i6) {
        k(i6);
        f(i6);
    }

    public void q(Drawable drawable) {
        l(drawable);
        g(drawable);
    }

    public void r(int i6) {
        n(i6);
        i(i6);
    }
}
