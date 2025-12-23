package androidx.vectordrawable.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: D:\Downloads\app\classes.dex */
public class PathInterpolatorCompat implements Interpolator {
    public static final double EPSILON = 1.0E-5d;
    public static final int MAX_NUM_POINTS = 3000;
    private static final float PRECISION = 0.002f;
    private float[] mX;
    private float[] mY;

    public PathInterpolatorCompat(Context context, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        this(context.getResources(), context.getTheme(), attributeSet, xmlPullParser);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f6) {
        if (f6 <= 0.0f) {
            return 0.0f;
        }
        if (f6 >= 1.0f) {
            return 1.0f;
        }
        int length = this.mX.length - 1;
        int i6 = 0;
        while (length - i6 > 1) {
            int i7 = (i6 + length) / 2;
            if (f6 < this.mX[i7]) {
                length = i7;
            } else {
                i6 = i7;
            }
        }
        float[] fArr = this.mX;
        float f7 = fArr[length];
        float f8 = fArr[i6];
        float f9 = f7 - f8;
        if (f9 == 0.0f) {
            return this.mY[i6];
        }
        float f10 = (f6 - f8) / f9;
        float[] fArr2 = this.mY;
        float f11 = fArr2[i6];
        return f11 + (f10 * (fArr2[length] - f11));
    }

    public PathInterpolatorCompat(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_PATH_INTERPOLATOR);
        parseInterpolatorFromTypeArray(obtainAttributes, xmlPullParser);
        obtainAttributes.recycle();
    }

    private void initCubic(float f6, float f7, float f8, float f9) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f6, f7, f8, f9, 1.0f, 1.0f);
        initPath(path);
    }

    private void initPath(Path path) {
        int i6 = 0;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int min = Math.min(3000, ((int) (length / 0.002f)) + 1);
        if (min <= 0) {
            throw new IllegalArgumentException("The Path has a invalid length " + length);
        }
        this.mX = new float[min];
        this.mY = new float[min];
        float[] fArr = new float[2];
        for (int i7 = 0; i7 < min; i7++) {
            pathMeasure.getPosTan((i7 * length) / (min - 1), fArr, null);
            this.mX[i7] = fArr[0];
            this.mY[i7] = fArr[1];
        }
        if (Math.abs(this.mX[0]) <= 1.0E-5d && Math.abs(this.mY[0]) <= 1.0E-5d) {
            int i8 = min - 1;
            if (Math.abs(this.mX[i8] - 1.0f) <= 1.0E-5d && Math.abs(this.mY[i8] - 1.0f) <= 1.0E-5d) {
                float f6 = 0.0f;
                int i9 = 0;
                while (i6 < min) {
                    float[] fArr2 = this.mX;
                    int i10 = i9 + 1;
                    float f7 = fArr2[i9];
                    if (f7 < f6) {
                        throw new IllegalArgumentException("The Path cannot loop back on itself, x :" + f7);
                    }
                    fArr2[i6] = f7;
                    i6++;
                    f6 = f7;
                    i9 = i10;
                }
                if (pathMeasure.nextContour()) {
                    throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
                }
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("The Path must start at (0,0) and end at (1,1) start: ");
        sb.append(this.mX[0]);
        sb.append(",");
        sb.append(this.mY[0]);
        sb.append(" end:");
        int i11 = min - 1;
        sb.append(this.mX[i11]);
        sb.append(",");
        sb.append(this.mY[i11]);
        throw new IllegalArgumentException(sb.toString());
    }

    private void initQuad(float f6, float f7) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f6, f7, 1.0f, 1.0f);
        initPath(path);
    }

    private void parseInterpolatorFromTypeArray(TypedArray typedArray, XmlPullParser xmlPullParser) {
        if (TypedArrayUtils.hasAttribute(xmlPullParser, "pathData")) {
            String namedString = TypedArrayUtils.getNamedString(typedArray, xmlPullParser, "pathData", 4);
            Path createPathFromPathData = PathParser.createPathFromPathData(namedString);
            if (createPathFromPathData != null) {
                initPath(createPathFromPathData);
                return;
            }
            throw new InflateException("The path is null, which is created from " + namedString);
        }
        if (!TypedArrayUtils.hasAttribute(xmlPullParser, "controlX1")) {
            throw new InflateException("pathInterpolator requires the controlX1 attribute");
        }
        if (!TypedArrayUtils.hasAttribute(xmlPullParser, "controlY1")) {
            throw new InflateException("pathInterpolator requires the controlY1 attribute");
        }
        float namedFloat = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "controlX1", 0, 0.0f);
        float namedFloat2 = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "controlY1", 1, 0.0f);
        boolean hasAttribute = TypedArrayUtils.hasAttribute(xmlPullParser, "controlX2");
        if (hasAttribute != TypedArrayUtils.hasAttribute(xmlPullParser, "controlY2")) {
            throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
        }
        if (hasAttribute) {
            initCubic(namedFloat, namedFloat2, TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "controlX2", 2, 0.0f), TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "controlY2", 3, 0.0f));
        } else {
            initQuad(namedFloat, namedFloat2);
        }
    }
}
