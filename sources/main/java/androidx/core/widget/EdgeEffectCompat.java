package androidx.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.EdgeEffect;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class EdgeEffectCompat {
    private final EdgeEffect mEdgeEffect;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(31)
    private static class Api31Impl {
        @DoNotInline
        public static EdgeEffect create(Context context, AttributeSet attributeSet) {
            try {
                return new EdgeEffect(context, attributeSet);
            } catch (Throwable unused) {
                return new EdgeEffect(context);
            }
        }

        private Api31Impl() {
        }

        @DoNotInline
        public static float getDistance(EdgeEffect edgeEffect) {
            try {
                return edgeEffect.getDistance();
            } catch (Throwable unused) {
                return 0.0f;
            }
        }

        @DoNotInline
        public static float onPullDistance(EdgeEffect edgeEffect, float f6, float f7) {
            try {
                return edgeEffect.onPullDistance(f6, f7);
            } catch (Throwable unused) {
                edgeEffect.onPull(f6, f7);
                return 0.0f;
            }
        }
    }

    @Deprecated
    public boolean onPull(float f6) {
        this.mEdgeEffect.onPull(f6);
        return true;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static void onPull(EdgeEffect edgeEffect, float f6, float f7) {
            edgeEffect.onPull(f6, f7);
        }
    }

    @NonNull
    public static EdgeEffect create(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        return Build.VERSION.SDK_INT >= 31 ? Api31Impl.create(context, attributeSet) : new EdgeEffect(context);
    }

    public static float getDistance(@NonNull EdgeEffect edgeEffect) {
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.getDistance(edgeEffect);
        }
        return 0.0f;
    }

    public static float onPullDistance(@NonNull EdgeEffect edgeEffect, float f6, float f7) {
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.onPullDistance(edgeEffect, f6, f7);
        }
        onPull(edgeEffect, f6, f7);
        return f6;
    }

    @Deprecated
    public boolean draw(Canvas canvas) {
        return this.mEdgeEffect.draw(canvas);
    }

    @Deprecated
    public void finish() {
        this.mEdgeEffect.finish();
    }

    @Deprecated
    public boolean isFinished() {
        return this.mEdgeEffect.isFinished();
    }

    @Deprecated
    public boolean onAbsorb(int i6) {
        this.mEdgeEffect.onAbsorb(i6);
        return true;
    }

    @Deprecated
    public boolean onPull(float f6, float f7) {
        onPull(this.mEdgeEffect, f6, f7);
        return true;
    }

    @Deprecated
    public boolean onRelease() {
        this.mEdgeEffect.onRelease();
        return this.mEdgeEffect.isFinished();
    }

    @Deprecated
    public void setSize(int i6, int i7) {
        this.mEdgeEffect.setSize(i6, i7);
    }

    @Deprecated
    public EdgeEffectCompat(Context context) {
        this.mEdgeEffect = new EdgeEffect(context);
    }

    public static void onPull(@NonNull EdgeEffect edgeEffect, float f6, float f7) {
        Api21Impl.onPull(edgeEffect, f6, f7);
    }
}
