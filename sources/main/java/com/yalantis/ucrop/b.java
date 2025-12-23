package com.yalantis.ucrop;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.yalantis.ucrop.model.AspectRatio;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class b {

    /* renamed from: c, reason: collision with root package name */
    public static final int f42693c = 69;

    /* renamed from: d, reason: collision with root package name */
    public static final int f42694d = 96;

    /* renamed from: e, reason: collision with root package name */
    public static final int f42695e = 10;

    /* renamed from: f, reason: collision with root package name */
    private static final String f42696f = "com.yalantis.ucrop";

    /* renamed from: g, reason: collision with root package name */
    public static final String f42697g = "com.yalantis.ucrop.InputUri";

    /* renamed from: h, reason: collision with root package name */
    public static final String f42698h = "com.yalantis.ucrop.OutputUri";

    /* renamed from: i, reason: collision with root package name */
    public static final String f42699i = "com.yalantis.ucrop.CropAspectRatio";

    /* renamed from: j, reason: collision with root package name */
    public static final String f42700j = "com.yalantis.ucrop.ImageWidth";

    /* renamed from: k, reason: collision with root package name */
    public static final String f42701k = "com.yalantis.ucrop.ImageHeight";

    /* renamed from: l, reason: collision with root package name */
    public static final String f42702l = "com.yalantis.ucrop.OffsetX";

    /* renamed from: m, reason: collision with root package name */
    public static final String f42703m = "com.yalantis.ucrop.OffsetY";

    /* renamed from: n, reason: collision with root package name */
    public static final String f42704n = "com.yalantis.ucrop.Error";

    /* renamed from: o, reason: collision with root package name */
    public static final String f42705o = "com.yalantis.ucrop.AspectRatioX";

    /* renamed from: p, reason: collision with root package name */
    public static final String f42706p = "com.yalantis.ucrop.AspectRatioY";

    /* renamed from: q, reason: collision with root package name */
    public static final String f42707q = "com.yalantis.ucrop.MaxSizeX";

    /* renamed from: r, reason: collision with root package name */
    public static final String f42708r = "com.yalantis.ucrop.MaxSizeY";

    /* renamed from: a, reason: collision with root package name */
    private Intent f42709a = new Intent();

    /* renamed from: b, reason: collision with root package name */
    private Bundle f42710b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {
        public static final String A = "com.yalantis.ucrop.HideBottomControls";
        public static final String B = "com.yalantis.ucrop.FreeStyleCrop";
        public static final String C = "com.yalantis.ucrop.AspectRatioSelectedByDefault";
        public static final String D = "com.yalantis.ucrop.AspectRatioOptions";
        public static final String E = "com.yalantis.ucrop.UcropRootViewBackgroundColor";

        /* renamed from: b, reason: collision with root package name */
        public static final String f42711b = "com.yalantis.ucrop.CompressionFormatName";

        /* renamed from: c, reason: collision with root package name */
        public static final String f42712c = "com.yalantis.ucrop.CompressionQuality";

        /* renamed from: d, reason: collision with root package name */
        public static final String f42713d = "com.yalantis.ucrop.AllowedGestures";

        /* renamed from: e, reason: collision with root package name */
        public static final String f42714e = "com.yalantis.ucrop.MaxBitmapSize";

        /* renamed from: f, reason: collision with root package name */
        public static final String f42715f = "com.yalantis.ucrop.MaxScaleMultiplier";

        /* renamed from: g, reason: collision with root package name */
        public static final String f42716g = "com.yalantis.ucrop.ImageToCropBoundsAnimDuration";

        /* renamed from: h, reason: collision with root package name */
        public static final String f42717h = "com.yalantis.ucrop.DimmedLayerColor";

        /* renamed from: i, reason: collision with root package name */
        public static final String f42718i = "com.yalantis.ucrop.CircleDimmedLayer";

        /* renamed from: j, reason: collision with root package name */
        public static final String f42719j = "com.yalantis.ucrop.ShowCropFrame";

        /* renamed from: k, reason: collision with root package name */
        public static final String f42720k = "com.yalantis.ucrop.CropFrameColor";

        /* renamed from: l, reason: collision with root package name */
        public static final String f42721l = "com.yalantis.ucrop.CropFrameStrokeWidth";

        /* renamed from: m, reason: collision with root package name */
        public static final String f42722m = "com.yalantis.ucrop.ShowCropGrid";

        /* renamed from: n, reason: collision with root package name */
        public static final String f42723n = "com.yalantis.ucrop.CropGridRowCount";

        /* renamed from: o, reason: collision with root package name */
        public static final String f42724o = "com.yalantis.ucrop.CropGridColumnCount";

        /* renamed from: p, reason: collision with root package name */
        public static final String f42725p = "com.yalantis.ucrop.CropGridColor";

        /* renamed from: q, reason: collision with root package name */
        public static final String f42726q = "com.yalantis.ucrop.CropGridStrokeWidth";

        /* renamed from: r, reason: collision with root package name */
        public static final String f42727r = "com.yalantis.ucrop.ToolbarColor";

        /* renamed from: s, reason: collision with root package name */
        public static final String f42728s = "com.yalantis.ucrop.StatusBarColor";

        /* renamed from: t, reason: collision with root package name */
        public static final String f42729t = "com.yalantis.ucrop.UcropColorWidgetActive";

        /* renamed from: u, reason: collision with root package name */
        public static final String f42730u = "com.yalantis.ucrop.UcropColorControlsWidgetActive";

        /* renamed from: v, reason: collision with root package name */
        public static final String f42731v = "com.yalantis.ucrop.UcropToolbarWidgetColor";

        /* renamed from: w, reason: collision with root package name */
        public static final String f42732w = "com.yalantis.ucrop.UcropToolbarTitleText";

        /* renamed from: x, reason: collision with root package name */
        public static final String f42733x = "com.yalantis.ucrop.UcropToolbarCancelDrawable";

        /* renamed from: y, reason: collision with root package name */
        public static final String f42734y = "com.yalantis.ucrop.UcropToolbarCropDrawable";

        /* renamed from: z, reason: collision with root package name */
        public static final String f42735z = "com.yalantis.ucrop.UcropLogoColor";

        /* renamed from: a, reason: collision with root package name */
        private final Bundle f42736a = new Bundle();

        public void e(int i6, AspectRatio... aspectRatioArr) {
            if (i6 > aspectRatioArr.length) {
                throw new IllegalArgumentException(String.format(Locale.US, "Index [selectedByDefault = %d] cannot be higher than aspect ratio options count [count = %d].", Integer.valueOf(i6), Integer.valueOf(aspectRatioArr.length)));
            }
            this.f42736a.putInt(C, i6);
            this.f42736a.putParcelableArrayList(D, new ArrayList<>(Arrays.asList(aspectRatioArr)));
        }

        public void A(@ColorInt int i6) {
            this.f42736a.putInt(f42727r, i6);
        }

        public void B(@DrawableRes int i6) {
            this.f42736a.putInt(f42734y, i6);
        }

        public void C(@Nullable String str) {
            this.f42736a.putString(f42732w, str);
        }

        public void D(@ColorInt int i6) {
            this.f42736a.putInt(f42731v, i6);
        }

        public void E() {
            this.f42736a.putFloat(b.f42705o, 0.0f);
            this.f42736a.putFloat(b.f42706p, 0.0f);
        }

        public void F(float f6, float f7) {
            this.f42736a.putFloat(b.f42705o, f6);
            this.f42736a.putFloat(b.f42706p, f7);
        }

        public void G(@IntRange(from = 10) int i6, @IntRange(from = 10) int i7) {
            this.f42736a.putInt(b.f42707q, i6);
            this.f42736a.putInt(b.f42708r, i7);
        }

        @NonNull
        public Bundle a() {
            return this.f42736a;
        }

        public void b(@ColorInt int i6) {
            this.f42736a.putInt(f42730u, i6);
        }

        public void c(@ColorInt int i6) {
            this.f42736a.putInt(f42729t, i6);
        }

        public void d(int i6, int i7, int i8) {
            this.f42736a.putIntArray(f42713d, new int[]{i6, i7, i8});
        }

        public void f(boolean z5) {
            this.f42736a.putBoolean(f42718i, z5);
        }

        public void g(@NonNull Bitmap.CompressFormat compressFormat) {
            this.f42736a.putString(f42711b, compressFormat.name());
        }

        public void h(@IntRange(from = 0) int i6) {
            this.f42736a.putInt(f42712c, i6);
        }

        public void i(@ColorInt int i6) {
            this.f42736a.putInt(f42720k, i6);
        }

        public void j(@IntRange(from = 0) int i6) {
            this.f42736a.putInt(f42721l, i6);
        }

        public void k(@ColorInt int i6) {
            this.f42736a.putInt(f42725p, i6);
        }

        public void l(@IntRange(from = 0) int i6) {
            this.f42736a.putInt(f42724o, i6);
        }

        public void m(@IntRange(from = 0) int i6) {
            this.f42736a.putInt(f42723n, i6);
        }

        public void n(@IntRange(from = 0) int i6) {
            this.f42736a.putInt(f42726q, i6);
        }

        public void o(@ColorInt int i6) {
            this.f42736a.putInt(f42717h, i6);
        }

        public void p(boolean z5) {
            this.f42736a.putBoolean(B, z5);
        }

        public void q(boolean z5) {
            this.f42736a.putBoolean(A, z5);
        }

        public void r(@IntRange(from = 10) int i6) {
            this.f42736a.putInt(f42716g, i6);
        }

        public void s(@ColorInt int i6) {
            this.f42736a.putInt(f42735z, i6);
        }

        public void t(@IntRange(from = 10) int i6) {
            this.f42736a.putInt(f42714e, i6);
        }

        public void u(@FloatRange(from = 1.0d, fromInclusive = false) float f6) {
            this.f42736a.putFloat(f42715f, f6);
        }

        public void v(@ColorInt int i6) {
            this.f42736a.putInt(E, i6);
        }

        public void w(boolean z5) {
            this.f42736a.putBoolean(f42719j, z5);
        }

        public void x(boolean z5) {
            this.f42736a.putBoolean(f42722m, z5);
        }

        public void y(@ColorInt int i6) {
            this.f42736a.putInt(f42728s, i6);
        }

        public void z(@DrawableRes int i6) {
            this.f42736a.putInt(f42733x, i6);
        }
    }

    @Nullable
    public static Throwable a(@NonNull Intent intent) {
        return (Throwable) intent.getSerializableExtra(f42704n);
    }

    @Nullable
    public static Uri e(@NonNull Intent intent) {
        return (Uri) intent.getParcelableExtra(f42698h);
    }

    public static float f(@NonNull Intent intent) {
        return intent.getFloatExtra(f42699i, 0.0f);
    }

    public static int g(@NonNull Intent intent) {
        return intent.getIntExtra(f42701k, -1);
    }

    public static int h(@NonNull Intent intent) {
        return intent.getIntExtra(f42700j, -1);
    }

    public static b i(@NonNull Uri uri, @NonNull Uri uri2) {
        return new b(uri, uri2);
    }

    public UCropFragment b() {
        return UCropFragment.P(this.f42710b);
    }

    public UCropFragment c(Bundle bundle) {
        this.f42710b = bundle;
        return b();
    }

    public Intent d(@NonNull Context context) {
        this.f42709a.setClass(context, UCropActivity.class);
        this.f42709a.putExtras(this.f42710b);
        return this.f42709a;
    }

    public void j(@NonNull Activity activity) {
        k(activity, 69);
    }

    public void l(@NonNull Context context, @NonNull Fragment fragment) {
        m(context, fragment, 69);
    }

    public void n(@NonNull Context context, @NonNull androidx.fragment.app.Fragment fragment) {
        o(context, fragment, 69);
    }

    public b p() {
        this.f42710b.putFloat(f42705o, 0.0f);
        this.f42710b.putFloat(f42706p, 0.0f);
        return this;
    }

    public b q(float f6, float f7) {
        this.f42710b.putFloat(f42705o, f6);
        this.f42710b.putFloat(f42706p, f7);
        return this;
    }

    public b r(@IntRange(from = 10) int i6, @IntRange(from = 10) int i7) {
        if (i6 < 10) {
            i6 = 10;
        }
        if (i7 < 10) {
            i7 = 10;
        }
        this.f42710b.putInt(f42707q, i6);
        this.f42710b.putInt(f42708r, i7);
        return this;
    }

    public b s(@NonNull a aVar) {
        this.f42710b.putAll(aVar.a());
        return this;
    }

    private b(@NonNull Uri uri, @NonNull Uri uri2) {
        Bundle bundle = new Bundle();
        this.f42710b = bundle;
        bundle.putParcelable(f42697g, uri);
        this.f42710b.putParcelable(f42698h, uri2);
    }

    public void k(@NonNull Activity activity, int i6) {
        activity.startActivityForResult(d(activity), i6);
    }

    @TargetApi(11)
    public void m(@NonNull Context context, @NonNull Fragment fragment, int i6) {
        fragment.startActivityForResult(d(context), i6);
    }

    public void o(@NonNull Context context, @NonNull androidx.fragment.app.Fragment fragment, int i6) {
        fragment.startActivityForResult(d(context), i6);
    }
}
