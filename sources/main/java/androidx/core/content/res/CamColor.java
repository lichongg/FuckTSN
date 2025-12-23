package androidx.core.content.res;

import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.Size;
import androidx.core.graphics.ColorUtils;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import kotlin.jvm.internal.w;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public class CamColor {
    private static final float CHROMA_SEARCH_ENDPOINT = 0.4f;
    private static final float DE_MAX = 1.0f;
    private static final float DL_MAX = 0.2f;
    private static final float LIGHTNESS_SEARCH_ENDPOINT = 0.01f;
    private final float mAstar;
    private final float mBstar;
    private final float mChroma;
    private final float mHue;
    private final float mJ;
    private final float mJstar;
    private final float mM;
    private final float mQ;
    private final float mS;

    @Nullable
    private static CamColor findCamByJ(@FloatRange(from = 0.0d, to = 360.0d) float f6, @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false) float f7, @FloatRange(from = 0.0d, to = 100.0d) float f8) {
        float f9 = 100.0f;
        float f10 = 1000.0f;
        CamColor camColor = null;
        float f11 = 1000.0f;
        float f12 = 0.0f;
        while (Math.abs(f12 - f9) > LIGHTNESS_SEARCH_ENDPOINT) {
            float f13 = ((f9 - f12) / 2.0f) + f12;
            int viewedInSrgb = fromJch(f13, f7, f6).viewedInSrgb();
            float lStarFromInt = CamUtils.lStarFromInt(viewedInSrgb);
            float abs = Math.abs(f8 - lStarFromInt);
            if (abs < 0.2f) {
                CamColor fromColor = fromColor(viewedInSrgb);
                float distance = fromColor.distance(fromJch(fromColor.getJ(), fromColor.getChroma(), f6));
                if (distance <= 1.0f) {
                    camColor = fromColor;
                    f10 = abs;
                    f11 = distance;
                }
            }
            if (f10 == 0.0f && f11 == 0.0f) {
                return camColor;
            }
            if (lStarFromInt < f8) {
                f12 = f13;
            } else {
                f9 = f13;
            }
        }
        return camColor;
    }

    @NonNull
    static CamColor fromColor(@ColorInt int i6) {
        float[] fArr = new float[7];
        float[] fArr2 = new float[3];
        fromColorInViewingConditions(i6, ViewingConditions.DEFAULT, fArr, fArr2);
        return new CamColor(fArr2[0], fArr2[1], fArr[0], fArr[1], fArr[2], fArr[3], fArr[4], fArr[5], fArr[6]);
    }

    public static int toColor(@FloatRange(from = 0.0d, to = 360.0d) float f6, @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false) float f7, @FloatRange(from = 0.0d, to = 100.0d) float f8) {
        return toColor(f6, f7, f8, ViewingConditions.DEFAULT);
    }

    static void fromColorInViewingConditions(@ColorInt int i6, @NonNull ViewingConditions viewingConditions, @Nullable @Size(7) float[] fArr, @NonNull @Size(3) float[] fArr2) {
        CamUtils.xyzFromInt(i6, fArr2);
        float[][] fArr3 = CamUtils.XYZ_TO_CAM16RGB;
        float f6 = fArr2[0];
        float[] fArr4 = fArr3[0];
        float f7 = fArr4[0] * f6;
        float f8 = fArr2[1];
        float f9 = f7 + (fArr4[1] * f8);
        float f10 = fArr2[2];
        float f11 = f9 + (fArr4[2] * f10);
        float[] fArr5 = fArr3[1];
        float f12 = (fArr5[0] * f6) + (fArr5[1] * f8) + (fArr5[2] * f10);
        float[] fArr6 = fArr3[2];
        float f13 = (f6 * fArr6[0]) + (f8 * fArr6[1]) + (f10 * fArr6[2]);
        float f14 = viewingConditions.getRgbD()[0] * f11;
        float f15 = viewingConditions.getRgbD()[1] * f12;
        float f16 = viewingConditions.getRgbD()[2] * f13;
        float pow = (float) Math.pow((viewingConditions.getFl() * Math.abs(f14)) / 100.0d, 0.42d);
        float pow2 = (float) Math.pow((viewingConditions.getFl() * Math.abs(f15)) / 100.0d, 0.42d);
        float pow3 = (float) Math.pow((viewingConditions.getFl() * Math.abs(f16)) / 100.0d, 0.42d);
        float signum = ((Math.signum(f14) * 400.0f) * pow) / (pow + 27.13f);
        float signum2 = ((Math.signum(f15) * 400.0f) * pow2) / (pow2 + 27.13f);
        float signum3 = ((Math.signum(f16) * 400.0f) * pow3) / (pow3 + 27.13f);
        double d6 = signum3;
        float f17 = ((float) (((signum * 11.0d) + (signum2 * (-12.0d))) + d6)) / 11.0f;
        float f18 = ((float) ((signum + signum2) - (d6 * 2.0d))) / 9.0f;
        float f19 = signum2 * 20.0f;
        float f20 = (((signum * 20.0f) + f19) + (21.0f * signum3)) / 20.0f;
        float f21 = (((signum * 40.0f) + f19) + signum3) / 20.0f;
        float atan2 = (((float) Math.atan2(f18, f17)) * 180.0f) / 3.1415927f;
        if (atan2 < 0.0f) {
            atan2 += 360.0f;
        } else if (atan2 >= 360.0f) {
            atan2 -= 360.0f;
        }
        float f22 = (3.1415927f * atan2) / 180.0f;
        float pow4 = ((float) Math.pow((f21 * viewingConditions.getNbb()) / viewingConditions.getAw(), viewingConditions.getC() * viewingConditions.getZ())) * 100.0f;
        float c6 = (4.0f / viewingConditions.getC()) * ((float) Math.sqrt(pow4 / 100.0f)) * (viewingConditions.getAw() + 4.0f) * viewingConditions.getFlRoot();
        float sqrt = ((float) Math.sqrt(pow4 / 100.0d)) * ((float) Math.pow(1.64d - Math.pow(0.29d, viewingConditions.getN()), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos((((((double) atan2) < 20.14d ? 360.0f + atan2 : atan2) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * viewingConditions.getNc()) * viewingConditions.getNcb()) * ((float) Math.sqrt((f17 * f17) + (f18 * f18)))) / (f20 + 0.305f), 0.9d));
        float flRoot = viewingConditions.getFlRoot() * sqrt;
        float sqrt2 = ((float) Math.sqrt((r4 * viewingConditions.getC()) / (viewingConditions.getAw() + 4.0f))) * 50.0f;
        float f23 = (1.7f * pow4) / ((0.007f * pow4) + 1.0f);
        float log = ((float) Math.log((0.0228f * flRoot) + 1.0f)) * 43.85965f;
        double d7 = f22;
        float cos = ((float) Math.cos(d7)) * log;
        float sin = log * ((float) Math.sin(d7));
        fArr2[0] = atan2;
        fArr2[1] = sqrt;
        if (fArr != null) {
            fArr[0] = pow4;
            fArr[1] = c6;
            fArr[2] = flRoot;
            fArr[3] = sqrt2;
            fArr[4] = f23;
            fArr[5] = cos;
            fArr[6] = sin;
        }
    }

    @NonNull
    private static CamColor fromJch(@FloatRange(from = 0.0d, to = 100.0d) float f6, @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false) float f7, @FloatRange(from = 0.0d, to = 360.0d) float f8) {
        return fromJchInFrame(f6, f7, f8, ViewingConditions.DEFAULT);
    }

    public static void getM3HCTfromColor(@ColorInt int i6, @NonNull @Size(3) float[] fArr) {
        fromColorInViewingConditions(i6, ViewingConditions.DEFAULT, null, fArr);
        fArr[2] = CamUtils.lStarFromInt(i6);
    }

    @ColorInt
    static int toColor(@FloatRange(from = 0.0d, to = 360.0d) float f6, @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false) float f7, @FloatRange(from = 0.0d, to = 100.0d) float f8, @NonNull ViewingConditions viewingConditions) {
        if (f7 < 1.0d || Math.round(f8) <= 0.0d || Math.round(f8) >= 100.0d) {
            return CamUtils.intFromLStar(f8);
        }
        float min = f6 < 0.0f ? 0.0f : Math.min(360.0f, f6);
        float f9 = f7;
        CamColor camColor = null;
        float f10 = 0.0f;
        boolean z5 = true;
        while (Math.abs(f10 - f7) >= 0.4f) {
            CamColor findCamByJ = findCamByJ(min, f9, f8);
            if (!z5) {
                if (findCamByJ == null) {
                    f7 = f9;
                } else {
                    f10 = f9;
                    camColor = findCamByJ;
                }
                f9 = ((f7 - f10) / 2.0f) + f10;
            } else {
                if (findCamByJ != null) {
                    return findCamByJ.viewed(viewingConditions);
                }
                f9 = ((f7 - f10) / 2.0f) + f10;
                z5 = false;
            }
        }
        return camColor == null ? CamUtils.intFromLStar(f8) : camColor.viewed(viewingConditions);
    }

    @FloatRange(from = w.f44076e, fromInclusive = false, to = w.f44075d, toInclusive = false)
    float getAStar() {
        return this.mAstar;
    }

    @FloatRange(from = w.f44076e, fromInclusive = false, to = w.f44075d, toInclusive = false)
    float getBStar() {
        return this.mBstar;
    }

    @FloatRange(from = 0.0d, to = w.f44075d, toInclusive = false)
    float getChroma() {
        return this.mChroma;
    }

    @FloatRange(from = 0.0d, to = VirtualEarthProjection.MAX_LONGITUDE, toInclusive = false)
    float getHue() {
        return this.mHue;
    }

    @FloatRange(from = 0.0d, to = 100.0d)
    float getJ() {
        return this.mJ;
    }

    @FloatRange(from = 0.0d, to = 100.0d)
    float getJStar() {
        return this.mJstar;
    }

    @FloatRange(from = 0.0d, to = w.f44075d, toInclusive = false)
    float getM() {
        return this.mM;
    }

    @FloatRange(from = 0.0d, to = w.f44075d, toInclusive = false)
    float getQ() {
        return this.mQ;
    }

    @FloatRange(from = 0.0d, to = w.f44075d, toInclusive = false)
    float getS() {
        return this.mS;
    }

    @ColorInt
    int viewedInSrgb() {
        return viewed(ViewingConditions.DEFAULT);
    }

    CamColor(float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14) {
        this.mHue = f6;
        this.mChroma = f7;
        this.mJ = f8;
        this.mQ = f9;
        this.mM = f10;
        this.mS = f11;
        this.mJstar = f12;
        this.mAstar = f13;
        this.mBstar = f14;
    }

    @NonNull
    private static CamColor fromJchInFrame(@FloatRange(from = 0.0d, to = 100.0d) float f6, @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false) float f7, @FloatRange(from = 0.0d, to = 360.0d) float f8, ViewingConditions viewingConditions) {
        float c6 = (4.0f / viewingConditions.getC()) * ((float) Math.sqrt(f6 / 100.0d)) * (viewingConditions.getAw() + 4.0f) * viewingConditions.getFlRoot();
        float flRoot = viewingConditions.getFlRoot() * f7;
        float sqrt = ((float) Math.sqrt(((f7 / ((float) Math.sqrt(r4))) * viewingConditions.getC()) / (viewingConditions.getAw() + 4.0f))) * 50.0f;
        float f9 = (1.7f * f6) / ((0.007f * f6) + 1.0f);
        float log = ((float) Math.log((flRoot * 0.0228d) + 1.0d)) * 43.85965f;
        double d6 = (3.1415927f * f8) / 180.0f;
        return new CamColor(f8, f7, f6, c6, flRoot, sqrt, f9, ((float) Math.cos(d6)) * log, log * ((float) Math.sin(d6)));
    }

    float distance(@NonNull CamColor camColor) {
        float jStar = getJStar() - camColor.getJStar();
        float aStar = getAStar() - camColor.getAStar();
        float bStar = getBStar() - camColor.getBStar();
        return (float) (Math.pow(Math.sqrt((jStar * jStar) + (aStar * aStar) + (bStar * bStar)), 0.63d) * 1.41d);
    }

    @ColorInt
    int viewed(@NonNull ViewingConditions viewingConditions) {
        float f6;
        if (getChroma() != 0.0d && getJ() != 0.0d) {
            f6 = getChroma() / ((float) Math.sqrt(getJ() / 100.0d));
        } else {
            f6 = 0.0f;
        }
        float pow = (float) Math.pow(f6 / Math.pow(1.64d - Math.pow(0.29d, viewingConditions.getN()), 0.73d), 1.1111111111111112d);
        double hue = (getHue() * 3.1415927f) / 180.0f;
        float cos = ((float) (Math.cos(2.0d + hue) + 3.8d)) * 0.25f;
        float aw = viewingConditions.getAw() * ((float) Math.pow(getJ() / 100.0d, (1.0d / viewingConditions.getC()) / viewingConditions.getZ()));
        float nc = cos * 3846.1538f * viewingConditions.getNc() * viewingConditions.getNcb();
        float nbb = aw / viewingConditions.getNbb();
        float sin = (float) Math.sin(hue);
        float cos2 = (float) Math.cos(hue);
        float f7 = (((0.305f + nbb) * 23.0f) * pow) / (((nc * 23.0f) + ((11.0f * pow) * cos2)) + ((pow * 108.0f) * sin));
        float f8 = cos2 * f7;
        float f9 = f7 * sin;
        float f10 = nbb * 460.0f;
        float f11 = (((451.0f * f8) + f10) + (288.0f * f9)) / 1403.0f;
        float f12 = ((f10 - (891.0f * f8)) - (261.0f * f9)) / 1403.0f;
        float signum = Math.signum(f11) * (100.0f / viewingConditions.getFl()) * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f11) * 27.13d) / (400.0d - Math.abs(f11))), 2.380952380952381d));
        float signum2 = Math.signum(f12) * (100.0f / viewingConditions.getFl()) * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f12) * 27.13d) / (400.0d - Math.abs(f12))), 2.380952380952381d));
        float signum3 = Math.signum(((f10 - (f8 * 220.0f)) - (f9 * 6300.0f)) / 1403.0f) * (100.0f / viewingConditions.getFl()) * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(r8) * 27.13d) / (400.0d - Math.abs(r8))), 2.380952380952381d));
        float f13 = signum / viewingConditions.getRgbD()[0];
        float f14 = signum2 / viewingConditions.getRgbD()[1];
        float f15 = signum3 / viewingConditions.getRgbD()[2];
        float[][] fArr = CamUtils.CAM16RGB_TO_XYZ;
        float[] fArr2 = fArr[0];
        float f16 = (fArr2[0] * f13) + (fArr2[1] * f14) + (fArr2[2] * f15);
        float[] fArr3 = fArr[1];
        float f17 = (fArr3[0] * f13) + (fArr3[1] * f14) + (fArr3[2] * f15);
        float[] fArr4 = fArr[2];
        return ColorUtils.XYZToColor(f16, f17, (f13 * fArr4[0]) + (f14 * fArr4[1]) + (f15 * fArr4[2]));
    }
}
