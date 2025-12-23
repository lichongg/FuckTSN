package com.bumptech.glide.request;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class h extends a<h> {

    @Nullable
    private static h V;

    @Nullable
    private static h W;

    @Nullable
    private static h X;

    @Nullable
    private static h Y;

    @Nullable
    private static h Z;

    /* renamed from: a0, reason: collision with root package name */
    @Nullable
    private static h f16172a0;

    /* renamed from: b0, reason: collision with root package name */
    @Nullable
    private static h f16173b0;

    /* renamed from: c0, reason: collision with root package name */
    @Nullable
    private static h f16174c0;

    @NonNull
    @CheckResult
    public static h U0(@NonNull com.bumptech.glide.load.i<Bitmap> iVar) {
        return new h().L0(iVar);
    }

    @NonNull
    @CheckResult
    public static h V0() {
        if (Z == null) {
            Z = new h().h().g();
        }
        return Z;
    }

    @NonNull
    @CheckResult
    public static h W0() {
        if (Y == null) {
            Y = new h().n().g();
        }
        return Y;
    }

    @NonNull
    @CheckResult
    public static h X0() {
        if (f16172a0 == null) {
            f16172a0 = new h().o().g();
        }
        return f16172a0;
    }

    @NonNull
    @CheckResult
    public static h Y0(@NonNull Class<?> cls) {
        return new h().r(cls);
    }

    @NonNull
    @CheckResult
    public static h Z0(@NonNull com.bumptech.glide.load.engine.j jVar) {
        return new h().t(jVar);
    }

    @NonNull
    @CheckResult
    public static h a1(@NonNull DownsampleStrategy downsampleStrategy) {
        return new h().w(downsampleStrategy);
    }

    @NonNull
    @CheckResult
    public static h b1(@NonNull Bitmap.CompressFormat compressFormat) {
        return new h().x(compressFormat);
    }

    @NonNull
    @CheckResult
    public static h c1(@IntRange(from = 0, to = 100) int i6) {
        return new h().y(i6);
    }

    @NonNull
    @CheckResult
    public static h d1(@DrawableRes int i6) {
        return new h().z(i6);
    }

    @NonNull
    @CheckResult
    public static h e1(@Nullable Drawable drawable) {
        return new h().A(drawable);
    }

    @NonNull
    @CheckResult
    public static h f1() {
        if (X == null) {
            X = new h().D().g();
        }
        return X;
    }

    @NonNull
    @CheckResult
    public static h g1(@NonNull DecodeFormat decodeFormat) {
        return new h().E(decodeFormat);
    }

    @NonNull
    @CheckResult
    public static h h1(@IntRange(from = 0) long j6) {
        return new h().F(j6);
    }

    @NonNull
    @CheckResult
    public static h i1() {
        if (f16174c0 == null) {
            f16174c0 = new h().u().g();
        }
        return f16174c0;
    }

    @NonNull
    @CheckResult
    public static h j1() {
        if (f16173b0 == null) {
            f16173b0 = new h().v().g();
        }
        return f16173b0;
    }

    @NonNull
    @CheckResult
    public static <T> h k1(@NonNull com.bumptech.glide.load.e<T> eVar, @NonNull T t5) {
        return new h().F0(eVar, t5);
    }

    @NonNull
    @CheckResult
    public static h m1(int i6, int i7) {
        return new h().x0(i6, i7);
    }

    @NonNull
    @CheckResult
    public static h n1(@DrawableRes int i6) {
        return new h().y0(i6);
    }

    @NonNull
    @CheckResult
    public static h o1(@Nullable Drawable drawable) {
        return new h().z0(drawable);
    }

    @NonNull
    @CheckResult
    public static h p1(@NonNull Priority priority) {
        return new h().A0(priority);
    }

    @NonNull
    @CheckResult
    public static h q1(@NonNull com.bumptech.glide.load.c cVar) {
        return new h().G0(cVar);
    }

    @NonNull
    @CheckResult
    public static h r1(@FloatRange(from = 0.0d, to = 1.0d) float f6) {
        return new h().H0(f6);
    }

    @NonNull
    @CheckResult
    public static h s1(boolean z5) {
        if (z5) {
            if (V == null) {
                V = new h().I0(true).g();
            }
            return V;
        }
        if (W == null) {
            W = new h().I0(false).g();
        }
        return W;
    }

    @NonNull
    @CheckResult
    public static h t1(@IntRange(from = 0) int i6) {
        return new h().K0(i6);
    }

    @NonNull
    @CheckResult
    public static h l1(int i6) {
        return m1(i6, i6);
    }
}
