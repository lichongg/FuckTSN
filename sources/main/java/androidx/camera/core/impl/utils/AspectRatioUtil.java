package androidx.camera.core.impl.utils;

import android.graphics.RectF;
import android.util.Rational;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.internal.utils.SizeUtil;
import androidx.core.util.Preconditions;
import java.util.Comparator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public final class AspectRatioUtil {
    private static final int ALIGN16 = 16;
    public static final Rational ASPECT_RATIO_4_3 = new Rational(4, 3);
    public static final Rational ASPECT_RATIO_3_4 = new Rational(3, 4);
    public static final Rational ASPECT_RATIO_16_9 = new Rational(16, 9);
    public static final Rational ASPECT_RATIO_9_16 = new Rational(9, 16);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(21)
    public static final class CompareAspectRatiosByMappingAreaInFullFovAspectRatioSpace implements Comparator<Rational> {
        private final Rational mFullFovRatio;
        private final Rational mTargetRatio;
        private final RectF mTransformedMappingArea;

        @Override // java.util.Comparator
        public int compare(Rational rational, Rational rational2) {
            if (rational.equals(rational2)) {
                return 0;
            }
            RectF transformedMappingArea = getTransformedMappingArea(rational);
            RectF transformedMappingArea2 = getTransformedMappingArea(rational2);
            boolean isMappingAreaCovered = isMappingAreaCovered(transformedMappingArea, this.mTransformedMappingArea);
            boolean isMappingAreaCovered2 = isMappingAreaCovered(transformedMappingArea2, this.mTransformedMappingArea);
            if (isMappingAreaCovered && isMappingAreaCovered2) {
                return (int) Math.signum(getMappingAreaSize(transformedMappingArea) - getMappingAreaSize(transformedMappingArea2));
            }
            if (isMappingAreaCovered) {
                return -1;
            }
            if (isMappingAreaCovered2) {
                return 1;
            }
            return -((int) Math.signum(getOverlappingAreaSize(transformedMappingArea, this.mTransformedMappingArea) - getOverlappingAreaSize(transformedMappingArea2, this.mTransformedMappingArea)));
        }

        public CompareAspectRatiosByMappingAreaInFullFovAspectRatioSpace(@NonNull Rational rational, @Nullable Rational rational2) {
            this.mTargetRatio = rational;
            this.mFullFovRatio = rational2 == null ? new Rational(4, 3) : rational2;
            this.mTransformedMappingArea = getTransformedMappingArea(rational);
        }

        private float getMappingAreaSize(RectF rectF) {
            return rectF.width() * rectF.height();
        }

        private float getOverlappingAreaSize(RectF rectF, RectF rectF2) {
            float width;
            float height;
            if (rectF.width() < rectF2.width()) {
                width = rectF.width();
            } else {
                width = rectF2.width();
            }
            if (rectF.height() < rectF2.height()) {
                height = rectF.height();
            } else {
                height = rectF2.height();
            }
            return width * height;
        }

        private RectF getTransformedMappingArea(Rational rational) {
            if (rational.floatValue() == this.mFullFovRatio.floatValue()) {
                return new RectF(0.0f, 0.0f, this.mFullFovRatio.getNumerator(), this.mFullFovRatio.getDenominator());
            }
            if (rational.floatValue() > this.mFullFovRatio.floatValue()) {
                return new RectF(0.0f, 0.0f, this.mFullFovRatio.getNumerator(), (rational.getDenominator() * this.mFullFovRatio.getNumerator()) / rational.getNumerator());
            }
            return new RectF(0.0f, 0.0f, (rational.getNumerator() * this.mFullFovRatio.getDenominator()) / rational.getDenominator(), this.mFullFovRatio.getDenominator());
        }

        private boolean isMappingAreaCovered(RectF rectF, RectF rectF2) {
            if (rectF.width() >= rectF2.width() && rectF.height() >= rectF2.height()) {
                return true;
            }
            return false;
        }
    }

    public static boolean hasMatchingAspectRatio(@NonNull Size size, @Nullable Rational rational) {
        return hasMatchingAspectRatio(size, rational, SizeUtil.RESOLUTION_VGA);
    }

    public static boolean hasMatchingAspectRatio(@NonNull Size size, @Nullable Rational rational, @NonNull Size size2) {
        if (rational == null) {
            return false;
        }
        if (rational.equals(new Rational(size.getWidth(), size.getHeight()))) {
            return true;
        }
        if (SizeUtil.getArea(size) >= SizeUtil.getArea(size2)) {
            return isPossibleMod16FromAspectRatio(size, rational);
        }
        return false;
    }

    private static boolean ratioIntersectsMod16Segment(int i6, int i7, Rational rational) {
        Preconditions.checkArgument(i7 % 16 == 0);
        double numerator = (i6 * rational.getNumerator()) / rational.getDenominator();
        return numerator > ((double) Math.max(0, i7 + (-16))) && numerator < ((double) (i7 + 16));
    }

    private AspectRatioUtil() {
    }

    private static boolean isPossibleMod16FromAspectRatio(@NonNull Size size, @NonNull Rational rational) {
        int width = size.getWidth();
        int height = size.getHeight();
        Rational rational2 = new Rational(rational.getDenominator(), rational.getNumerator());
        int i6 = width % 16;
        if (i6 == 0 && height % 16 == 0) {
            if (!ratioIntersectsMod16Segment(Math.max(0, height - 16), width, rational) && !ratioIntersectsMod16Segment(Math.max(0, width - 16), height, rational2)) {
                return false;
            }
            return true;
        }
        if (i6 == 0) {
            return ratioIntersectsMod16Segment(height, width, rational);
        }
        if (height % 16 != 0) {
            return false;
        }
        return ratioIntersectsMod16Segment(width, height, rational2);
    }
}
