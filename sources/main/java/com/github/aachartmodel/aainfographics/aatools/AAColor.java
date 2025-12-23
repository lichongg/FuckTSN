package com.github.aachartmodel.aainfographics.aatools;

import io.netty.util.internal.StringUtil;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AAColor {

    @NotNull
    private static final String Black;

    @NotNull
    private static final String Blue;

    @NotNull
    private static final String Brown;

    @NotNull
    private static final String Clear;

    @NotNull
    private static final String Cyan;

    @NotNull
    private static final String DarkGray;

    @NotNull
    private static final String Gray;

    @NotNull
    private static final String Green;
    public static final AAColor INSTANCE;

    @NotNull
    private static final String LightGray;

    @NotNull
    private static final String Magenta;

    @NotNull
    private static final String Orange;

    @NotNull
    private static final String Purple;

    @NotNull
    private static final String Red;

    @NotNull
    private static final String White;

    @NotNull
    private static final String Yellow;

    static {
        AAColor aAColor = new AAColor();
        INSTANCE = aAColor;
        Black = aAColor.blackColor();
        DarkGray = aAColor.darkGrayColor();
        LightGray = aAColor.lightGrayColor();
        White = aAColor.whiteColor();
        Gray = aAColor.grayColor();
        Red = aAColor.redColor();
        Green = aAColor.greenColor();
        Blue = aAColor.blueColor();
        Cyan = aAColor.cyanColor();
        Yellow = aAColor.yellowColor();
        Magenta = aAColor.magentaColor();
        Orange = aAColor.orangeColor();
        Purple = aAColor.purpleColor();
        Brown = aAColor.brownColor();
        Clear = aAColor.clearColor();
    }

    private final String blackColor() {
        return "black";
    }

    private final String blueColor() {
        return "blue";
    }

    private final String brownColor() {
        return "brown";
    }

    private final String clearColor() {
        return "clear";
    }

    private final String cyanColor() {
        return "cyan";
    }

    private final String darkGrayColor() {
        return "darkGray";
    }

    private final String grayColor() {
        return "gray";
    }

    private final String greenColor() {
        return "green";
    }

    private final String lightGrayColor() {
        return "lightGray";
    }

    private final String magentaColor() {
        return "magenta";
    }

    private final String orangeColor() {
        return "orange";
    }

    private final String purpleColor() {
        return "purple";
    }

    private final String redColor() {
        return "red";
    }

    public static /* synthetic */ String rgbaColor$default(AAColor aAColor, int i6, int i7, int i8, float f6, int i9, Object obj) {
        if ((i9 & 8) != 0) {
            f6 = 1.0f;
        }
        return aAColor.rgbaColor(i6, i7, i8, f6);
    }

    private final String whiteColor() {
        return "white";
    }

    private final String yellowColor() {
        return "yellow";
    }

    @NotNull
    public final String getBlack() {
        return Black;
    }

    @NotNull
    public final String getBlue() {
        return Blue;
    }

    @NotNull
    public final String getBrown() {
        return Brown;
    }

    @NotNull
    public final String getClear() {
        return Clear;
    }

    @NotNull
    public final String getCyan() {
        return Cyan;
    }

    @NotNull
    public final String getDarkGray() {
        return DarkGray;
    }

    @NotNull
    public final String getGray() {
        return Gray;
    }

    @NotNull
    public final String getGreen() {
        return Green;
    }

    @NotNull
    public final String getLightGray() {
        return LightGray;
    }

    @NotNull
    public final String getMagenta() {
        return Magenta;
    }

    @NotNull
    public final String getOrange() {
        return Orange;
    }

    @NotNull
    public final String getPurple() {
        return Purple;
    }

    @NotNull
    public final String getRed() {
        return Red;
    }

    @NotNull
    public final String getWhite() {
        return White;
    }

    @NotNull
    public final String getYellow() {
        return Yellow;
    }

    @NotNull
    public final String rgbaColor(int i6, int i7, int i8, float f6) {
        return "rgba(" + i6 + StringUtil.COMMA + i7 + StringUtil.COMMA + i8 + StringUtil.COMMA + f6 + ')';
    }

    private AAColor() {
    }
}
