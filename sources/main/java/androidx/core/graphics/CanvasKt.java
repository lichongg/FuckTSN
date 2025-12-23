package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.d0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class CanvasKt {
    public static final void withClip(@NotNull Canvas canvas, @NotNull Rect rect, @NotNull Function1<? super Canvas, n1> function1) {
        int save = canvas.save();
        canvas.clipRect(rect);
        try {
            function1.invoke(canvas);
        } finally {
            d0.d(1);
            canvas.restoreToCount(save);
            d0.c(1);
        }
    }

    public static /* synthetic */ void withMatrix$default(Canvas canvas, Matrix matrix, Function1 function1, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            matrix = new Matrix();
        }
        int save = canvas.save();
        canvas.concat(matrix);
        try {
            function1.invoke(canvas);
        } finally {
            d0.d(1);
            canvas.restoreToCount(save);
            d0.c(1);
        }
    }

    public static /* synthetic */ void withRotation$default(Canvas canvas, float f6, float f7, float f8, Function1 function1, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            f6 = 0.0f;
        }
        if ((i6 & 2) != 0) {
            f7 = 0.0f;
        }
        if ((i6 & 4) != 0) {
            f8 = 0.0f;
        }
        int save = canvas.save();
        canvas.rotate(f6, f7, f8);
        try {
            function1.invoke(canvas);
        } finally {
            d0.d(1);
            canvas.restoreToCount(save);
            d0.c(1);
        }
    }

    public static /* synthetic */ void withScale$default(Canvas canvas, float f6, float f7, float f8, float f9, Function1 function1, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            f6 = 1.0f;
        }
        if ((i6 & 2) != 0) {
            f7 = 1.0f;
        }
        if ((i6 & 4) != 0) {
            f8 = 0.0f;
        }
        if ((i6 & 8) != 0) {
            f9 = 0.0f;
        }
        int save = canvas.save();
        canvas.scale(f6, f7, f8, f9);
        try {
            function1.invoke(canvas);
        } finally {
            d0.d(1);
            canvas.restoreToCount(save);
            d0.c(1);
        }
    }

    public static /* synthetic */ void withSkew$default(Canvas canvas, float f6, float f7, Function1 function1, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            f6 = 0.0f;
        }
        if ((i6 & 2) != 0) {
            f7 = 0.0f;
        }
        int save = canvas.save();
        canvas.skew(f6, f7);
        try {
            function1.invoke(canvas);
        } finally {
            d0.d(1);
            canvas.restoreToCount(save);
            d0.c(1);
        }
    }

    public static /* synthetic */ void withTranslation$default(Canvas canvas, float f6, float f7, Function1 function1, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            f6 = 0.0f;
        }
        if ((i6 & 2) != 0) {
            f7 = 0.0f;
        }
        int save = canvas.save();
        canvas.translate(f6, f7);
        try {
            function1.invoke(canvas);
        } finally {
            d0.d(1);
            canvas.restoreToCount(save);
            d0.c(1);
        }
    }

    public static final void withMatrix(@NotNull Canvas canvas, @NotNull Matrix matrix, @NotNull Function1<? super Canvas, n1> function1) {
        int save = canvas.save();
        canvas.concat(matrix);
        try {
            function1.invoke(canvas);
        } finally {
            d0.d(1);
            canvas.restoreToCount(save);
            d0.c(1);
        }
    }

    public static final void withRotation(@NotNull Canvas canvas, float f6, float f7, float f8, @NotNull Function1<? super Canvas, n1> function1) {
        int save = canvas.save();
        canvas.rotate(f6, f7, f8);
        try {
            function1.invoke(canvas);
        } finally {
            d0.d(1);
            canvas.restoreToCount(save);
            d0.c(1);
        }
    }

    public static final void withSave(@NotNull Canvas canvas, @NotNull Function1<? super Canvas, n1> function1) {
        int save = canvas.save();
        try {
            function1.invoke(canvas);
        } finally {
            d0.d(1);
            canvas.restoreToCount(save);
            d0.c(1);
        }
    }

    public static final void withScale(@NotNull Canvas canvas, float f6, float f7, float f8, float f9, @NotNull Function1<? super Canvas, n1> function1) {
        int save = canvas.save();
        canvas.scale(f6, f7, f8, f9);
        try {
            function1.invoke(canvas);
        } finally {
            d0.d(1);
            canvas.restoreToCount(save);
            d0.c(1);
        }
    }

    public static final void withSkew(@NotNull Canvas canvas, float f6, float f7, @NotNull Function1<? super Canvas, n1> function1) {
        int save = canvas.save();
        canvas.skew(f6, f7);
        try {
            function1.invoke(canvas);
        } finally {
            d0.d(1);
            canvas.restoreToCount(save);
            d0.c(1);
        }
    }

    public static final void withTranslation(@NotNull Canvas canvas, float f6, float f7, @NotNull Function1<? super Canvas, n1> function1) {
        int save = canvas.save();
        canvas.translate(f6, f7);
        try {
            function1.invoke(canvas);
        } finally {
            d0.d(1);
            canvas.restoreToCount(save);
            d0.c(1);
        }
    }

    public static final void withClip(@NotNull Canvas canvas, @NotNull RectF rectF, @NotNull Function1<? super Canvas, n1> function1) {
        int save = canvas.save();
        canvas.clipRect(rectF);
        try {
            function1.invoke(canvas);
        } finally {
            d0.d(1);
            canvas.restoreToCount(save);
            d0.c(1);
        }
    }

    public static final void withClip(@NotNull Canvas canvas, int i6, int i7, int i8, int i9, @NotNull Function1<? super Canvas, n1> function1) {
        int save = canvas.save();
        canvas.clipRect(i6, i7, i8, i9);
        try {
            function1.invoke(canvas);
        } finally {
            d0.d(1);
            canvas.restoreToCount(save);
            d0.c(1);
        }
    }

    public static final void withClip(@NotNull Canvas canvas, float f6, float f7, float f8, float f9, @NotNull Function1<? super Canvas, n1> function1) {
        int save = canvas.save();
        canvas.clipRect(f6, f7, f8, f9);
        try {
            function1.invoke(canvas);
        } finally {
            d0.d(1);
            canvas.restoreToCount(save);
            d0.c(1);
        }
    }

    public static final void withClip(@NotNull Canvas canvas, @NotNull Path path, @NotNull Function1<? super Canvas, n1> function1) {
        int save = canvas.save();
        canvas.clipPath(path);
        try {
            function1.invoke(canvas);
        } finally {
            d0.d(1);
            canvas.restoreToCount(save);
            d0.c(1);
        }
    }
}
