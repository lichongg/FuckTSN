package androidx.core.graphics;

import android.graphics.Matrix;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nMatrix.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Matrix.kt\nandroidx/core/graphics/MatrixKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,54:1\n1#2:55\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class MatrixKt {
    @NotNull
    public static final Matrix rotationMatrix(float f6, float f7, float f8) {
        Matrix matrix = new Matrix();
        matrix.setRotate(f6, f7, f8);
        return matrix;
    }

    public static /* synthetic */ Matrix rotationMatrix$default(float f6, float f7, float f8, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            f7 = 0.0f;
        }
        if ((i6 & 4) != 0) {
            f8 = 0.0f;
        }
        return rotationMatrix(f6, f7, f8);
    }

    @NotNull
    public static final Matrix scaleMatrix(float f6, float f7) {
        Matrix matrix = new Matrix();
        matrix.setScale(f6, f7);
        return matrix;
    }

    public static /* synthetic */ Matrix scaleMatrix$default(float f6, float f7, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            f6 = 1.0f;
        }
        if ((i6 & 2) != 0) {
            f7 = 1.0f;
        }
        return scaleMatrix(f6, f7);
    }

    @NotNull
    public static final Matrix times(@NotNull Matrix matrix, @NotNull Matrix matrix2) {
        Matrix matrix3 = new Matrix(matrix);
        matrix3.preConcat(matrix2);
        return matrix3;
    }

    @NotNull
    public static final Matrix translationMatrix(float f6, float f7) {
        Matrix matrix = new Matrix();
        matrix.setTranslate(f6, f7);
        return matrix;
    }

    public static /* synthetic */ Matrix translationMatrix$default(float f6, float f7, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            f6 = 0.0f;
        }
        if ((i6 & 2) != 0) {
            f7 = 0.0f;
        }
        return translationMatrix(f6, f7);
    }

    @NotNull
    public static final float[] values(@NotNull Matrix matrix) {
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        return fArr;
    }
}
