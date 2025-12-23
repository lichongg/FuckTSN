package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import androidx.annotation.AnyRes;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleableRes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class TypedArrayKt {
    private static final void checkAttribute(TypedArray typedArray, @StyleableRes int i6) {
        if (typedArray.hasValue(i6)) {
        } else {
            throw new IllegalArgumentException("Attribute not defined in set.");
        }
    }

    public static final boolean getBooleanOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i6) {
        checkAttribute(typedArray, i6);
        return typedArray.getBoolean(i6, false);
    }

    @ColorInt
    public static final int getColorOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i6) {
        checkAttribute(typedArray, i6);
        return typedArray.getColor(i6, 0);
    }

    @NotNull
    public static final ColorStateList getColorStateListOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i6) {
        checkAttribute(typedArray, i6);
        ColorStateList colorStateList = typedArray.getColorStateList(i6);
        if (colorStateList != null) {
            return colorStateList;
        }
        throw new IllegalStateException("Attribute value was not a color or color state list.");
    }

    public static final float getDimensionOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i6) {
        checkAttribute(typedArray, i6);
        return typedArray.getDimension(i6, 0.0f);
    }

    @Dimension
    public static final int getDimensionPixelOffsetOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i6) {
        checkAttribute(typedArray, i6);
        return typedArray.getDimensionPixelOffset(i6, 0);
    }

    @Dimension
    public static final int getDimensionPixelSizeOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i6) {
        checkAttribute(typedArray, i6);
        return typedArray.getDimensionPixelSize(i6, 0);
    }

    @NotNull
    public static final Drawable getDrawableOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i6) {
        checkAttribute(typedArray, i6);
        Drawable drawable = typedArray.getDrawable(i6);
        g0.m(drawable);
        return drawable;
    }

    public static final float getFloatOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i6) {
        checkAttribute(typedArray, i6);
        return typedArray.getFloat(i6, 0.0f);
    }

    @RequiresApi(26)
    @NotNull
    public static final Typeface getFontOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i6) {
        checkAttribute(typedArray, i6);
        return TypedArrayApi26ImplKt.getFont(typedArray, i6);
    }

    public static final int getIntOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i6) {
        checkAttribute(typedArray, i6);
        return typedArray.getInt(i6, 0);
    }

    public static final int getIntegerOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i6) {
        checkAttribute(typedArray, i6);
        return typedArray.getInteger(i6, 0);
    }

    @AnyRes
    public static final int getResourceIdOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i6) {
        checkAttribute(typedArray, i6);
        return typedArray.getResourceId(i6, 0);
    }

    @NotNull
    public static final String getStringOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i6) {
        checkAttribute(typedArray, i6);
        String string = typedArray.getString(i6);
        if (string != null) {
            return string;
        }
        throw new IllegalStateException("Attribute value could not be coerced to String.");
    }

    @NotNull
    public static final CharSequence[] getTextArrayOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i6) {
        checkAttribute(typedArray, i6);
        return typedArray.getTextArray(i6);
    }

    @NotNull
    public static final CharSequence getTextOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i6) {
        checkAttribute(typedArray, i6);
        CharSequence text = typedArray.getText(i6);
        if (text != null) {
            return text;
        }
        throw new IllegalStateException("Attribute value could not be coerced to CharSequence.");
    }

    public static final <R> R use(@NotNull TypedArray typedArray, @NotNull Function1<? super TypedArray, ? extends R> function1) {
        R invoke = function1.invoke(typedArray);
        typedArray.recycle();
        return invoke;
    }
}
