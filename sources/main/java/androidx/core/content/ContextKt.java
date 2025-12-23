package androidx.core.content;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.StyleRes;
import androidx.exifinterface.media.ExifInterface;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class ContextKt {
    public static final /* synthetic */ <T> T getSystemService(Context context) {
        g0.y(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) ContextCompat.getSystemService(context, Object.class);
    }

    public static final void withStyledAttributes(@NotNull Context context, @Nullable AttributeSet attributeSet, @NotNull int[] iArr, @AttrRes int i6, @StyleRes int i7, @NotNull Function1<? super TypedArray, n1> function1) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i6, i7);
        function1.invoke(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    public static final void withStyledAttributes(@NotNull Context context, @StyleRes int i6, @NotNull int[] iArr, @NotNull Function1<? super TypedArray, n1> function1) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i6, iArr);
        function1.invoke(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    public static /* synthetic */ void withStyledAttributes$default(Context context, AttributeSet attributeSet, int[] iArr, int i6, int i7, Function1 function1, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            attributeSet = null;
        }
        if ((i8 & 4) != 0) {
            i6 = 0;
        }
        if ((i8 & 8) != 0) {
            i7 = 0;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i6, i7);
        function1.invoke(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }
}
