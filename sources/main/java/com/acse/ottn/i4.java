package com.acse.ottn;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class i4 {

    /* renamed from: a, reason: collision with root package name */
    public static final int f4639a = 112;

    /* renamed from: b, reason: collision with root package name */
    public static final int f4640b = R.id.statusbarutil_fake_status_bar_view;

    /* renamed from: c, reason: collision with root package name */
    public static final int f4641c = R.id.statusbarutil_translucent_view;

    /* renamed from: d, reason: collision with root package name */
    public static final int f4642d = -123;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CoordinatorLayout f4643a;

        public a(CoordinatorLayout coordinatorLayout) {
            this.f4643a = coordinatorLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4643a.requestLayout();
        }
    }

    public static int a(@ColorInt int i6, int i7) {
        if (i7 == 0) {
            return i6;
        }
        float f6 = 1.0f - (i7 / 255.0f);
        return ((int) (((i6 & 255) * f6) + 0.5d)) | (((int) ((((i6 >> 16) & 255) * f6) + 0.5d)) << 16) | ViewCompat.MEASURED_STATE_MASK | (((int) ((((i6 >> 8) & 255) * f6) + 0.5d)) << 8);
    }

    public static void b(Activity activity, @ColorInt int i6, @IntRange(from = 0, to = 255) int i7) {
        activity.getWindow().addFlags(Integer.MIN_VALUE);
        activity.getWindow().clearFlags(67108864);
        activity.getWindow().setStatusBarColor(a(i6, i7));
    }

    public static void c(Activity activity, @ColorInt int i6, @IntRange(from = 0, to = 255) int i7) {
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(android.R.id.content);
        View childAt = viewGroup.getChildAt(0);
        int a6 = a((Context) activity);
        if (childAt == null || !(childAt instanceof CoordinatorLayout)) {
            viewGroup.setPadding(0, a6, 0, 0);
            viewGroup.setBackgroundColor(a(i6, i7));
        } else {
            ((CoordinatorLayout) childAt).setStatusBarBackgroundColor(a(i6, i7));
        }
        g(activity);
    }

    public static void d(Activity activity, @ColorInt int i6) {
        b(activity, i6, 112);
    }

    @Deprecated
    public static void e(Activity activity, @ColorInt int i6) {
        h(activity);
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(android.R.id.content);
        View findViewById = viewGroup.findViewById(f4640b);
        if (findViewById != null) {
            if (findViewById.getVisibility() == 8) {
                findViewById.setVisibility(0);
            }
            findViewById.setBackgroundColor(i6);
        } else {
            viewGroup.addView(b(activity, i6));
        }
        c(activity);
    }

    public static void f(Activity activity, int i6) {
        c(activity, i6, 112);
    }

    public static void g(Activity activity, @ColorInt int i6) {
        b(activity, i6, 0);
    }

    public static void h(Activity activity, @IntRange(from = 0, to = 255) int i6) {
        f(activity);
        a(activity, i6);
    }

    public static void a(Activity activity, DrawerLayout drawerLayout, @ColorInt int i6) {
        a(activity, drawerLayout, i6, 112);
    }

    public static void d(Activity activity) {
        h(activity, 112);
    }

    public static void f(Activity activity) {
        h(activity);
        c(activity);
    }

    public static void g(Activity activity) {
        activity.getWindow().setStatusBarColor(0);
        activity.getWindow().getDecorView().setSystemUiVisibility(PredefinedCaptureConfigurations.f35648o);
    }

    public static void a(Activity activity, DrawerLayout drawerLayout, @ColorInt int i6, @IntRange(from = 0, to = 255) int i7) {
        activity.getWindow().addFlags(Integer.MIN_VALUE);
        activity.getWindow().clearFlags(67108864);
        activity.getWindow().setStatusBarColor(0);
        ViewGroup viewGroup = (ViewGroup) drawerLayout.getChildAt(0);
        View findViewById = viewGroup.findViewById(f4640b);
        if (findViewById != null) {
            if (findViewById.getVisibility() == 8) {
                findViewById.setVisibility(0);
            }
            findViewById.setBackgroundColor(i6);
        } else {
            viewGroup.addView(b(activity, i6), 0);
        }
        if (!(viewGroup instanceof LinearLayout) && viewGroup.getChildAt(1) != null) {
            viewGroup.getChildAt(1).setPadding(viewGroup.getPaddingLeft(), a((Context) activity) + viewGroup.getPaddingTop(), viewGroup.getPaddingRight(), viewGroup.getPaddingBottom());
        }
        a(drawerLayout, viewGroup);
        a(activity, i7);
    }

    public static void d(Activity activity, DrawerLayout drawerLayout, @IntRange(from = 0, to = 255) int i6) {
        c(activity, drawerLayout);
        a(activity, i6);
    }

    @TargetApi(19)
    public static void h(Activity activity) {
        activity.getWindow().addFlags(Integer.MIN_VALUE);
        activity.getWindow().clearFlags(67108864);
        activity.getWindow().addFlags(AMapEngineUtils.HALF_MAX_P20_WIDTH);
        activity.getWindow().setStatusBarColor(0);
    }

    public static void i(Activity activity, @IntRange(from = 0, to = 255) int i6) {
        h(activity);
        a(activity, i6);
    }

    @Deprecated
    public static void b(Activity activity, DrawerLayout drawerLayout, @ColorInt int i6) {
        activity.getWindow().addFlags(67108864);
        ViewGroup viewGroup = (ViewGroup) drawerLayout.getChildAt(0);
        View findViewById = viewGroup.findViewById(f4640b);
        if (findViewById != null) {
            if (findViewById.getVisibility() == 8) {
                findViewById.setVisibility(0);
            }
            findViewById.setBackgroundColor(a(i6, 112));
        } else {
            viewGroup.addView(b(activity, i6), 0);
        }
        if (!(viewGroup instanceof LinearLayout) && viewGroup.getChildAt(1) != null) {
            viewGroup.getChildAt(1).setPadding(0, a((Context) activity), 0, 0);
        }
        a(drawerLayout, viewGroup);
    }

    public static void d(Activity activity, View view) {
        b(activity, 0, view);
    }

    @Deprecated
    public static void e(Activity activity) {
        activity.getWindow().addFlags(67108864);
        c(activity);
    }

    public static void c(Activity activity, DrawerLayout drawerLayout, @ColorInt int i6) {
        a(activity, drawerLayout, i6, 0);
    }

    public static void c(Activity activity, DrawerLayout drawerLayout) {
        activity.getWindow().addFlags(Integer.MIN_VALUE);
        activity.getWindow().clearFlags(67108864);
        activity.getWindow().setStatusBarColor(0);
        ViewGroup viewGroup = (ViewGroup) drawerLayout.getChildAt(0);
        if (!(viewGroup instanceof LinearLayout) && viewGroup.getChildAt(1) != null) {
            viewGroup.getChildAt(1).setPadding(0, a((Context) activity), 0, 0);
        }
        a(drawerLayout, viewGroup);
    }

    @Deprecated
    public static void b(Activity activity, DrawerLayout drawerLayout) {
        activity.getWindow().addFlags(67108864);
        ViewGroup viewGroup = (ViewGroup) drawerLayout.getChildAt(0);
        viewGroup.setFitsSystemWindows(true);
        viewGroup.setClipToPadding(true);
        ((ViewGroup) drawerLayout.getChildAt(1)).setFitsSystemWindows(false);
        drawerLayout.setFitsSystemWindows(false);
    }

    public static void a(DrawerLayout drawerLayout, ViewGroup viewGroup) {
        ViewGroup viewGroup2 = (ViewGroup) drawerLayout.getChildAt(1);
        drawerLayout.setFitsSystemWindows(false);
        viewGroup.setFitsSystemWindows(false);
        viewGroup.setClipToPadding(true);
        viewGroup2.setFitsSystemWindows(false);
    }

    public static void c(Activity activity, View view) {
        a(activity, 0, view);
    }

    public static void c(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(android.R.id.content);
        int childCount = viewGroup.getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = viewGroup.getChildAt(i6);
            if (childAt instanceof ViewGroup) {
                childAt.setFitsSystemWindows(true);
                ((ViewGroup) childAt).setClipToPadding(true);
            }
        }
    }

    public static void a(Activity activity, DrawerLayout drawerLayout) {
        d(activity, drawerLayout, 112);
    }

    public static void b(Activity activity, View view) {
        b(activity, 112, view);
    }

    public static void a(Activity activity, View view) {
        a(activity, 112, view);
    }

    public static void b(Activity activity, @IntRange(from = 0, to = 255) int i6, View view) {
        a(activity, i6, view);
    }

    public static void a(Activity activity, @IntRange(from = 0, to = 255) int i6, View view) {
        g(activity);
        a(activity, i6);
        if (view != null) {
            Object tag = view.getTag(f4642d);
            if (tag == null || !((Boolean) tag).booleanValue()) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin + a((Context) activity), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                view.setTag(f4642d, Boolean.TRUE);
            }
        }
    }

    public static void b(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        View findViewById = viewGroup.findViewById(f4640b);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        View findViewById2 = viewGroup.findViewById(f4641c);
        if (findViewById2 != null) {
            findViewById2.setVisibility(8);
        }
    }

    public static View c(Activity activity, int i6) {
        View view = new View(activity);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, a((Context) activity)));
        view.setBackgroundColor(Color.argb(i6, 0, 0, 0));
        view.setId(f4641c);
        return view;
    }

    public static View b(Activity activity, @ColorInt int i6) {
        return a(activity, i6, 0);
    }

    @TargetApi(19)
    public static void a(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        View findViewById = viewGroup.findViewById(f4640b);
        if (findViewById != null) {
            viewGroup.removeView(findViewById);
            ((ViewGroup) ((ViewGroup) activity.findViewById(android.R.id.content)).getChildAt(0)).setPadding(0, 0, 0, 0);
        }
    }

    public static void a(Activity activity, @IntRange(from = 0, to = 255) int i6) {
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(android.R.id.content);
        View findViewById = viewGroup.findViewById(f4641c);
        if (findViewById != null) {
            if (findViewById.getVisibility() == 8) {
                findViewById.setVisibility(0);
            }
            findViewById.setBackgroundColor(Color.argb(i6, 0, 0, 0));
            return;
        }
        viewGroup.addView(c(activity, i6));
    }

    public static View a(Activity activity, @ColorInt int i6, int i7) {
        View view = new View(activity);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, a((Context) activity)));
        view.setBackgroundColor(a(i6, i7));
        view.setId(f4640b);
        return view;
    }

    public static int a(Context context) {
        return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("status_bar_height", "dimen", FaceEnvironment.OS));
    }
}
