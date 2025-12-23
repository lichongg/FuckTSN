package androidx.core.content.res;

import android.content.res.TypedArray;
import android.graphics.Typeface;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleableRes;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(26)
/* loaded from: D:\Downloads\app\classes.dex */
final class TypedArrayApi26ImplKt {

    @NotNull
    public static final TypedArrayApi26ImplKt INSTANCE = new TypedArrayApi26ImplKt();

    private TypedArrayApi26ImplKt() {
    }

    @JvmStatic
    @DoNotInline
    @NotNull
    public static final Typeface getFont(@NotNull TypedArray typedArray, @StyleableRes int i6) {
        Typeface font = typedArray.getFont(i6);
        g0.m(font);
        return font;
    }
}
