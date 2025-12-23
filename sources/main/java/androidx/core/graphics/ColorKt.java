package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.ColorSpace;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class ColorKt {
    public static final int component1(@ColorInt int i6) {
        return (i6 >> 24) & 255;
    }

    public static final int component2(@ColorInt int i6) {
        return (i6 >> 16) & 255;
    }

    public static final int component3(@ColorInt int i6) {
        return (i6 >> 8) & 255;
    }

    public static final int component4(@ColorInt int i6) {
        return i6 & 255;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final long convertTo(@ColorInt int i6, @NotNull ColorSpace.Named named) {
        ColorSpace colorSpace;
        long convert;
        colorSpace = ColorSpace.get(named);
        convert = Color.convert(i6, colorSpace);
        return convert;
    }

    public static final int getAlpha(@ColorInt int i6) {
        return (i6 >> 24) & 255;
    }

    public static final int getBlue(@ColorInt int i6) {
        return i6 & 255;
    }

    public static final int getGreen(@ColorInt int i6) {
        return (i6 >> 8) & 255;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float getLuminance(@ColorInt int i6) {
        float luminance;
        luminance = Color.luminance(i6);
        return luminance;
    }

    public static final int getRed(@ColorInt int i6) {
        return (i6 >> 16) & 255;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    @NotNull
    public static final Color toColor(@ColorInt int i6) {
        Color valueOf;
        valueOf = Color.valueOf(i6);
        return valueOf;
    }

    @ColorInt
    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final int toColorInt(long j6) {
        int argb;
        argb = Color.toArgb(j6);
        return argb;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float component1(@NotNull Color color) {
        float component;
        component = color.getComponent(0);
        return component;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float component2(@NotNull Color color) {
        float component;
        component = color.getComponent(1);
        return component;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float component3(@NotNull Color color) {
        float component;
        component = color.getComponent(2);
        return component;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float component4(@NotNull Color color) {
        float component;
        component = color.getComponent(3);
        return component;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final long convertTo(@ColorInt int i6, @NotNull ColorSpace colorSpace) {
        long convert;
        convert = Color.convert(i6, colorSpace);
        return convert;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float getAlpha(long j6) {
        float alpha;
        alpha = Color.alpha(j6);
        return alpha;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float getBlue(long j6) {
        float blue;
        blue = Color.blue(j6);
        return blue;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float getGreen(long j6) {
        float green;
        green = Color.green(j6);
        return green;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float getLuminance(long j6) {
        float luminance;
        luminance = Color.luminance(j6);
        return luminance;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float getRed(long j6) {
        float red;
        red = Color.red(j6);
        return red;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    @NotNull
    public static final Color toColor(long j6) {
        Color valueOf;
        valueOf = Color.valueOf(j6);
        return valueOf;
    }

    @ColorInt
    public static final int toColorInt(@NotNull String str) {
        return Color.parseColor(str);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float component1(long j6) {
        float red;
        red = Color.red(j6);
        return red;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float component2(long j6) {
        float green;
        green = Color.green(j6);
        return green;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float component3(long j6) {
        float blue;
        blue = Color.blue(j6);
        return blue;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float component4(long j6) {
        float alpha;
        alpha = Color.alpha(j6);
        return alpha;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final long convertTo(long j6, @NotNull ColorSpace.Named named) {
        ColorSpace colorSpace;
        long convert;
        colorSpace = ColorSpace.get(named);
        convert = Color.convert(j6, colorSpace);
        return convert;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    @NotNull
    public static final ColorSpace getColorSpace(long j6) {
        ColorSpace colorSpace;
        colorSpace = Color.colorSpace(j6);
        return colorSpace;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final boolean isSrgb(long j6) {
        boolean isSrgb;
        isSrgb = Color.isSrgb(j6);
        return isSrgb;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final boolean isWideGamut(long j6) {
        boolean isWideGamut;
        isWideGamut = Color.isWideGamut(j6);
        return isWideGamut;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    @NotNull
    public static final Color plus(@NotNull Color color, @NotNull Color color2) {
        return ColorUtils.compositeColors(color2, color);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final long toColorLong(@ColorInt int i6) {
        long pack;
        pack = Color.pack(i6);
        return pack;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final long convertTo(long j6, @NotNull ColorSpace colorSpace) {
        long convert;
        convert = Color.convert(j6, colorSpace);
        return convert;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    @NotNull
    public static final Color convertTo(@NotNull Color color, @NotNull ColorSpace.Named named) {
        ColorSpace colorSpace;
        Color convert;
        colorSpace = ColorSpace.get(named);
        convert = color.convert(colorSpace);
        return convert;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    @NotNull
    public static final Color convertTo(@NotNull Color color, @NotNull ColorSpace colorSpace) {
        Color convert;
        convert = color.convert(colorSpace);
        return convert;
    }
}
