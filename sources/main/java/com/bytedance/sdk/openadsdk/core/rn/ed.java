package com.bytedance.sdk.openadsdk.core.rn;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ActivityOptions;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.bytedance.pangle.annotations.ForbidWrapParam;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.ats.AutoService;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ed {
    private static int ae = 13;
    private static volatile int cw = -1;

    /* renamed from: j, reason: collision with root package name */
    public static volatile int f30063j = -1;

    /* renamed from: m, reason: collision with root package name */
    private static volatile int f30064m = -1;

    /* renamed from: r, reason: collision with root package name */
    private static volatile float f30065r = -1.0f;
    private static float tl = 0.0f;
    private static volatile int up = -1;
    private static volatile float xt = -1.0f;

    public interface j {
        void j(View view);
    }

    public static float ae(Context context) {
        j(context);
        return f30065r;
    }

    public static int cw(Context context, float f6) {
        j(context);
        return (int) ((f6 * mi(context)) + 0.5f);
    }

    public static int g(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.v.getContext();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int j(float f6, float f7) {
        return (int) ((f7 * f6) + 0.5f);
    }

    public static boolean jy(Context context) {
        try {
            if ("V1938CT".equals(com.bytedance.sdk.openadsdk.core.kt.v())) {
                return false;
            }
            Class<?> loadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            return ((Boolean) loadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(loadClass, 32)).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static float m(Context context) {
        j(context);
        return xt;
    }

    public static int oq(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.v.getContext();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static float qv(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.v.getContext();
        }
        try {
            if (StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getIdentifier("status_bar_height", "dimen", FaceEnvironment.OS) > 0) {
                return StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getDimensionPixelSize(r1);
            }
            return 0.0f;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.xt("TTUtils", "Get StatusBarHeight failed:" + th.getMessage());
            return 0.0f;
        }
    }

    private static boolean r() {
        return xt < 0.0f || cw < 0 || f30065r < 0.0f || up < 0 || f30064m < 0;
    }

    public static int tl(Context context) {
        j(context);
        return cw;
    }

    public static int up(Context context) {
        j(context);
        return f30064m;
    }

    public static boolean vl(Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) loadClass.getMethod("hasNotchInScreen", null).invoke(loadClass, null)).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int xt(float f6, float f7) {
        if (f6 <= 0.0f) {
            f6 = 1.0f;
        }
        return (int) ((f7 / f6) + 0.5f);
    }

    public static boolean av(Context context) {
        return Build.MANUFACTURER.equals("samsung");
    }

    public static TextView i(Context context) {
        if (context == null) {
            return null;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor("#CC000000"));
        gradientDrawable.setCornerRadius(com.bytedance.sdk.openadsdk.core.dislike.j.j.xt().j(context, 4.0f));
        TextView textView = new TextView(context);
        textView.setClickable(false);
        textView.setFocusable(false);
        textView.setBackground(gradientDrawable);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.topMargin = (int) (up(context) * (-0.3d));
        int cw2 = cw(context, 20.0f);
        int cw3 = cw(context, 11.0f);
        textView.setPadding(cw2, cw3, cw2, cw3);
        textView.setLayoutParams(layoutParams);
        textView.setTextColor(-1);
        textView.setTextSize(ae);
        textView.setGravity(17);
        return textView;
    }

    private static boolean j(int i6) {
        return i6 == 0 || i6 == 8 || i6 == 4;
    }

    private static float mi(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.v.getContext();
        }
        return context.getResources().getDisplayMetrics().density;
    }

    public static int r(Context context, float f6) {
        j(context);
        float mi = mi(context);
        if (mi <= 0.0f) {
            mi = 1.0f;
        }
        return (int) ((f6 / mi) + 0.5f);
    }

    public static boolean ws(Context context) {
        String oq = uf.oq("com.kllk.feature.screen.heteromorphism");
        if (context == null || context.getPackageManager() == null) {
            return false;
        }
        try {
            return context.getPackageManager().hasSystemFeature(oq);
        } catch (Throwable unused) {
            return true;
        }
    }

    public static int xt(Context context, float f6) {
        j(context);
        float ae2 = ae(context);
        if (ae2 <= 0.0f) {
            ae2 = 1.0f;
        }
        return (int) ((f6 / ae2) + 0.5f);
    }

    public static Bitmap ae(View view) {
        if (view == null) {
            return null;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        Bitmap createBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        view.draw(canvas);
        canvas.save();
        return createBitmap;
    }

    public static boolean az(Context context) {
        String v5 = com.bytedance.sdk.openadsdk.core.kt.v();
        if (!v5.equals("IN2010") && !v5.equals("IN2020") && !v5.equals("KB2000")) {
            return false;
        }
        return true;
    }

    public static int[] cw(Context context) {
        j(context);
        return new int[]{up, f30064m};
    }

    public static void j(Context context) {
        Resources resources;
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.v.getContext();
        }
        if (context == null || (resources = context.getResources()) == null) {
            return;
        }
        if (r()) {
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            xt = displayMetrics.density;
            cw = displayMetrics.densityDpi;
            f30065r = displayMetrics.scaledDensity;
            up = displayMetrics.widthPixels;
            f30064m = displayMetrics.heightPixels;
        }
        if (resources.getConfiguration() != null) {
            if (resources.getConfiguration().orientation == 1) {
                if (up > f30064m) {
                    int i6 = up;
                    up = f30064m;
                    f30064m = i6;
                    return;
                }
                return;
            }
            if (up < f30064m) {
                int i7 = up;
                up = f30064m;
                f30064m = i7;
            }
        }
    }

    public static void m(View view) {
        if (view == null) {
            return;
        }
        j(view, 0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.rn.ed.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationEnd(animator);
            }
        });
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    public static void tl(Activity activity) {
        try {
            Class<?> cls = null;
            for (Class<?> cls2 : Activity.class.getDeclaredClasses()) {
                if (cls2.getSimpleName().contains("TranslucentConversionListener")) {
                    cls = cls2;
                }
            }
            Method declaredMethod = Activity.class.getDeclaredMethod("convertToTranslucent", cls);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(activity, null);
        } catch (Throwable unused) {
        }
    }

    public static void up(final View view) {
        if (view == null) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.rn.ed.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ed.j(view, 8);
                ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f).setDuration(0L).start();
            }
        });
        ofFloat.setDuration(800L);
        ofFloat.start();
    }

    public static int w(Context context) {
        int identifier = context.getResources().getIdentifier("navigation_bar_height", "dimen", FaceEnvironment.OS);
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int r(Context context) {
        j(context);
        return up;
    }

    public static int[] xt(Context context) {
        WindowMetrics currentWindowMetrics;
        Rect bounds;
        WindowManager windowManager = null;
        if (context == null) {
            return null;
        }
        try {
            windowManager = (WindowManager) context.getSystemService("window");
        } catch (Exception unused) {
        }
        int[] iArr = new int[2];
        if (windowManager != null) {
            try {
                if (Build.VERSION.SDK_INT >= 30) {
                    currentWindowMetrics = windowManager.getCurrentWindowMetrics();
                    bounds = currentWindowMetrics.getBounds();
                    iArr[0] = bounds.width();
                    iArr[1] = bounds.height();
                } else {
                    DisplayMetrics displayMetrics = new DisplayMetrics();
                    windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                    iArr[0] = displayMetrics.widthPixels;
                    iArr[1] = displayMetrics.heightPixels;
                }
            } catch (Throwable unused2) {
            }
        }
        if (iArr[0] <= 0 || iArr[1] <= 0) {
            DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
            iArr[0] = displayMetrics2.widthPixels;
            iArr[1] = displayMetrics2.heightPixels;
        }
        return iArr;
    }

    public static int[] cw(View view) {
        if (view != null) {
            return new int[]{view.getWidth(), view.getHeight()};
        }
        return null;
    }

    private static void qv(Activity activity) {
        Object obj;
        try {
            Method declaredMethod = Activity.class.getDeclaredMethod("getActivityOptions", null);
            declaredMethod.setAccessible(true);
            obj = declaredMethod.invoke(activity, null);
        } catch (Throwable unused) {
            obj = null;
        }
        try {
            Class<?> cls = null;
            for (Class<?> cls2 : Activity.class.getDeclaredClasses()) {
                if (cls2.getSimpleName().startsWith("TranslucentConversionListener")) {
                    cls = cls2;
                }
            }
            Method declaredMethod2 = Activity.class.getDeclaredMethod("convertToTranslucent", cls, ActivityOptions.class);
            declaredMethod2.setAccessible(true);
            declaredMethod2.invoke(activity, null, obj);
        } catch (Throwable unused2) {
        }
    }

    public static boolean r(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public static boolean g(Activity activity) {
        return (activity.isFinishing() || activity.isDestroyed()) ? false : true;
    }

    private static boolean oq(Activity activity) {
        try {
            if (Build.VERSION.SDK_INT >= 26 && activity.getWindow().getDecorView().getHeight() > 0 && activity.getWindow().getDecorView().getWidth() > 0) {
                if (g((Context) activity) - activity.getWindow().getDecorView().getHeight() <= 0) {
                    return oq((Context) activity) - activity.getWindow().getDecorView().getWidth() > 0;
                }
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean r(Activity activity) {
        return m(activity) || j("ro.miui.notch", activity) == 1 || vl(activity) || jy(activity) || az(activity) || av(activity) || oq(activity) || ws(activity);
    }

    public static void up(@ForbidWrapParam Activity activity) {
        if (cw()) {
            return;
        }
        try {
            final WeakReference weakReference = new WeakReference(activity);
            activity.getWindow().getDecorView().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rn.ed.4
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.l.ae.j(new com.bytedance.sdk.component.oq.g("check_notch") { // from class: com.bytedance.sdk.openadsdk.core.rn.ed.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                Activity activity2 = (Activity) weakReference.get();
                                if (activity2 != null && !ed.cw()) {
                                    ed.f30063j = ed.r(activity2) ? 1 : 0;
                                }
                            } catch (Throwable unused) {
                            }
                        }
                    });
                }
            });
        } catch (Throwable unused) {
        }
    }

    public static void cw(Activity activity) {
        try {
            activity.getWindow().getDecorView().setSystemUiVisibility(com.umeng.analytics.pro.i.f41296b);
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    public static boolean m(Activity activity) {
        WindowInsets rootWindowInsets;
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        try {
            rootWindowInsets = activity.getWindow().getDecorView().getRootWindowInsets();
            return (rootWindowInsets != null ? rootWindowInsets.getDisplayCutout() : null) != null;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
            return false;
        }
    }

    public static void tl(View view) {
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
        }
    }

    public static boolean cw() {
        return f30063j != -1;
    }

    public static void ae(Activity activity) {
        try {
            qv(activity);
        } catch (Throwable unused) {
        }
    }

    public static int[] xt(View view) {
        if (view == null) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    public static float j(Context context, float f6) {
        j(context);
        return TypedValue.applyDimension(2, f6, context.getResources().getDisplayMetrics());
    }

    public static void xt(View view, int i6, int i7, int i8, int i9) {
        ViewGroup.LayoutParams layoutParams;
        if (view == null || (layoutParams = view.getLayoutParams()) == null || !(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        j(view, (ViewGroup.MarginLayoutParams) layoutParams, i6, i7, i8, i9);
    }

    public static void j(View view, int i6, int i7, int i8, int i9) {
        Rect rect = new Rect();
        view.getHitRect(rect);
        rect.top -= i6;
        rect.bottom += i7;
        rect.left -= i8;
        rect.right += i9;
        ((View) view.getParent()).setTouchDelegate(new com.bytedance.sdk.component.utils.ae(rect, view));
    }

    public static void xt(Activity activity) {
        try {
            cw(activity);
            activity.getWindow().addFlags(AMapEngineUtils.HALF_MAX_P20_WIDTH);
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    public static boolean xt() {
        return f30063j == 1 || f30063j == -1;
    }

    public static void xt(View view, final float f6) {
        if (view != null && f6 > 0.0f) {
            view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.bytedance.sdk.openadsdk.core.rn.ed.7
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view2, Outline outline) {
                    if (outline == null) {
                        return;
                    }
                    outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), f6);
                }
            });
            view.setClipToOutline(true);
        }
    }

    public static int[] j(View view) {
        if (view == null || view.getVisibility() != 0) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    public static void j(View view, int i6) {
        if (view == null || view.getVisibility() == i6 || !j(i6)) {
            return;
        }
        view.setVisibility(i6);
    }

    public static void j(View view, float f6) {
        if (view == null) {
            return;
        }
        view.setAlpha(f6);
    }

    public static boolean j(SSWebView sSWebView) {
        if (sSWebView == null || !sSWebView.canGoBack()) {
            return false;
        }
        sSWebView.goBack();
        return true;
    }

    public static void j(final com.bytedance.sdk.component.jy.cw cwVar) {
        if (cwVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.l.ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rn.ed.1
            @Override // java.lang.Runnable
            public void run() {
                WebSettings settings;
                WebView webView = com.bytedance.sdk.component.jy.cw.this.getWebView();
                if (webView == null || (settings = webView.getSettings()) == null) {
                    return;
                }
                settings.setTextZoom(100);
            }
        });
    }

    public static void j(TextView textView, CharSequence charSequence) {
        if (textView == null || TextUtils.isEmpty(charSequence)) {
            return;
        }
        textView.setText(charSequence);
    }

    private static void j(View view, ViewGroup.MarginLayoutParams marginLayoutParams, int i6, int i7, int i8, int i9) {
        if (view == null || marginLayoutParams == null) {
            return;
        }
        if (marginLayoutParams.leftMargin == i6 && marginLayoutParams.topMargin == i7 && marginLayoutParams.rightMargin == i8 && marginLayoutParams.bottomMargin == i9) {
            return;
        }
        if (i6 != -3) {
            marginLayoutParams.leftMargin = i6;
        }
        if (i7 != -3) {
            marginLayoutParams.topMargin = i7;
        }
        if (i8 != -3) {
            marginLayoutParams.rightMargin = i8;
        }
        if (i9 != -3) {
            marginLayoutParams.bottomMargin = i9;
        }
        view.setLayoutParams(marginLayoutParams);
    }

    public static boolean j() {
        try {
            return !((KeyguardManager) com.bytedance.sdk.openadsdk.core.v.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static JSONObject j(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            if (!jSONObject.has("app_scene")) {
                jSONObject.put("app_scene", com.bytedance.sdk.openadsdk.core.oq.i().j() ? 1 : 0);
            }
            if (!jSONObject.has("lock_scene")) {
                jSONObject.put("lock_scene", !j() ? 1 : 0);
            }
            if (str != null && !str.isEmpty() && !jSONObject.has("auto_show_check")) {
                jSONObject.put("auto_show_check", str);
            }
            return jSONObject;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.cw("addShowScene error " + th.toString());
            return jSONObject;
        }
    }

    public static void j(Activity activity) {
        if (activity == null) {
            return;
        }
        try {
            activity.getWindow().getDecorView().setSystemUiVisibility(3846);
            xt(activity);
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    public static void j(View view, View view2) {
        WindowInsets rootWindowInsets;
        int safeInsetTop;
        if (view == null || view2 == null) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT >= 28 && tl == 0.0f) {
                rootWindowInsets = view.getRootWindowInsets();
                DisplayCutout displayCutout = rootWindowInsets != null ? rootWindowInsets.getDisplayCutout() : null;
                if (displayCutout != null) {
                    safeInsetTop = displayCutout.getSafeInsetTop();
                    tl = safeInsetTop;
                }
            }
            if (tl == 0.0f) {
                return;
            }
            float max = Math.max(qv(view2.getContext()), tl);
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) layoutParams).topMargin = (int) (r1.topMargin + max);
            }
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).topMargin = (int) (r1.topMargin + max);
            }
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).topMargin = (int) (r1.topMargin + max);
            }
            view2.setLayoutParams(layoutParams);
        } catch (Throwable unused) {
        }
    }

    public static int j(String str, Activity activity) {
        com.bytedance.sdk.component.r.up upVar;
        if (!ch.av() || (upVar = (com.bytedance.sdk.component.r.up) AutoService.j(com.bytedance.sdk.component.r.up.class)) == null) {
            return 0;
        }
        return upVar.xt(str);
    }

    public static void j(View view, View.OnClickListener onClickListener, String str) {
        if (view == null) {
            com.bytedance.sdk.component.utils.vl.r("OnclickListener ", str + " is null , can not set OnClickListener !!!");
            return;
        }
        view.setOnClickListener(onClickListener);
    }

    public static void j(View view, View.OnTouchListener onTouchListener, String str) {
        if (view == null) {
            com.bytedance.sdk.component.utils.vl.r("OnTouchListener ", str + " is null , can not set OnTouchListener !!!");
            return;
        }
        view.setOnTouchListener(onTouchListener);
    }

    public static void j(final View view, final j jVar) {
        if (view == null) {
            return;
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.core.rn.ed.5
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                view.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                j jVar2 = jVar;
                if (jVar2 != null) {
                    jVar2.j(view);
                }
            }
        });
    }

    public static void j(View view, final com.bytedance.sdk.openadsdk.core.tj.n nVar) {
        if (view == null || nVar == null) {
            return;
        }
        view.setClickable(true);
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.rn.ed.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                m.j(com.bytedance.sdk.openadsdk.core.v.getContext(), com.bytedance.sdk.openadsdk.core.tj.n.this);
            }
        });
    }

    public static void j(TextView textView, String str, Context context) {
        if (textView == null || TextUtils.isEmpty(str) || context == null) {
            return;
        }
        textView.setText(str);
        textView.setTextSize(2, 8.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#1F161823"));
        gradientDrawable.setCornerRadius(cw(context, 3.0f));
        textView.setBackgroundDrawable(gradientDrawable);
        textView.setTextColor(com.bytedance.sdk.component.utils.kt.oq(context, "tt_adx_logo_desc"));
        textView.setGravity(17);
        textView.setPadding(cw(context, 2.0f), cw(context, 3.0f), cw(context, 2.0f), cw(context, 3.0f));
    }

    public static void j(TextView textView, com.bytedance.sdk.openadsdk.core.tj.n nVar) {
        if (textView != null && nVar != null) {
            String ek = nVar.ek();
            if (TextUtils.isEmpty(ek)) {
                j(textView);
                j((View) textView, nVar);
                return;
            } else {
                j(textView, ek, com.bytedance.sdk.openadsdk.core.v.getContext());
                return;
            }
        }
        j(textView);
    }

    public static void j(TextView textView, com.bytedance.sdk.openadsdk.core.tj.n nVar, int i6, int i7) {
        if (textView != null && nVar != null) {
            String ek = nVar.ek();
            if (TextUtils.isEmpty(ek)) {
                j(textView, i6, i7);
                j((View) textView, nVar);
                return;
            } else {
                j(textView, ek, com.bytedance.sdk.openadsdk.core.v.getContext());
                return;
            }
        }
        j(textView, i6, i7);
    }

    private static void j(TextView textView) {
        if (textView == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        layoutParams.width = cw(com.bytedance.sdk.openadsdk.core.v.getContext(), 32.0f);
        layoutParams.height = cw(com.bytedance.sdk.openadsdk.core.v.getContext(), 14.0f);
        textView.setLayoutParams(layoutParams);
    }

    private static void j(TextView textView, int i6, int i7) {
        if (i6 <= 0) {
            i6 = 32;
        }
        if (i7 <= 0) {
            i7 = 14;
        }
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        layoutParams.width = cw(com.bytedance.sdk.openadsdk.core.v.getContext(), i6);
        layoutParams.height = cw(com.bytedance.sdk.openadsdk.core.v.getContext(), i7);
        textView.setLayoutParams(layoutParams);
    }

    @Deprecated
    public static void j(Context context, String str, int i6) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        Toast toast = new Toast(context);
        LinearLayout linearLayout = new LinearLayout(context);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor("#CC000000"));
        gradientDrawable.setCornerRadius(com.bytedance.sdk.openadsdk.core.dislike.j.j.xt().j(context, 4.0f));
        linearLayout.setBackground(gradientDrawable);
        TextView textView = new TextView(context);
        textView.setClickable(false);
        textView.setFocusable(false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        int cw2 = cw(context, 20.0f);
        int cw3 = cw(context, 11.0f);
        textView.setPadding(cw2, cw3, cw2, cw3);
        textView.setLayoutParams(layoutParams);
        textView.setTextColor(-1);
        textView.setTextSize(ae);
        textView.setGravity(17);
        textView.setText(str);
        linearLayout.addView(textView);
        toast.setView(linearLayout);
        toast.setGravity(17, 0, 0);
        toast.setDuration(i6);
        toast.show();
    }
}
