package androidx.camera.core;

import android.graphics.PointF;
import android.util.Rational;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class MeteringPointFactory {

    @Nullable
    private Rational mSurfaceAspectRatio;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public MeteringPointFactory() {
        this(null);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected abstract PointF convertPoint(float f6, float f7);

    @NonNull
    public final MeteringPoint createPoint(float f6, float f7) {
        return createPoint(f6, f7, getDefaultPointSize());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public MeteringPointFactory(@Nullable Rational rational) {
        this.mSurfaceAspectRatio = rational;
    }

    @NonNull
    public final MeteringPoint createPoint(float f6, float f7, float f8) {
        PointF convertPoint = convertPoint(f6, f7);
        return new MeteringPoint(convertPoint.x, convertPoint.y, f8, this.mSurfaceAspectRatio);
    }

    public static float getDefaultPointSize() {
        return 0.15f;
    }
}
