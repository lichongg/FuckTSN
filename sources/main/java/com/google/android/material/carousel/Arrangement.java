package com.google.android.material.carousel;

import androidx.annotation.NonNull;
import androidx.core.math.MathUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class Arrangement {
    private static final float MEDIUM_ITEM_FLEX_PERCENTAGE = 0.1f;
    final float cost;
    final int largeCount;
    float largeSize;
    final int mediumCount;
    float mediumSize;
    final int priority;
    final int smallCount;
    float smallSize;

    private float calculateLargeSize(float f6, int i6, float f7, int i7, int i8) {
        if (i6 <= 0) {
            f7 = 0.0f;
        }
        float f8 = i7 / 2.0f;
        return (f6 - ((i6 + f8) * f7)) / (i8 + f8);
    }

    static Arrangement findLowestCostArrangement(float f6, float f7, float f8, float f9, int[] iArr, float f10, int[] iArr2, float f11, int[] iArr3) {
        Arrangement arrangement = null;
        int i6 = 1;
        for (int i7 : iArr3) {
            int length = iArr2.length;
            int i8 = 0;
            while (i8 < length) {
                int i9 = iArr2[i8];
                int length2 = iArr.length;
                int i10 = 0;
                while (i10 < length2) {
                    int i11 = length;
                    int i12 = i8;
                    int i13 = i6;
                    int i14 = length2;
                    int i15 = i10;
                    Arrangement arrangement2 = new Arrangement(i13, f7, f8, f9, iArr[i10], f10, i9, f11, i7, f6);
                    if (arrangement == null || arrangement2.cost < arrangement.cost) {
                        if (arrangement2.cost == 0.0f) {
                            return arrangement2;
                        }
                        arrangement = arrangement2;
                    }
                    int i16 = i13 + 1;
                    i10 = i15 + 1;
                    i8 = i12;
                    i6 = i16;
                    length = i11;
                    length2 = i14;
                }
                i8++;
                i6 = i6;
                length = length;
            }
        }
        return arrangement;
    }

    private float getSpace() {
        return (this.largeSize * this.largeCount) + (this.mediumSize * this.mediumCount) + (this.smallSize * this.smallCount);
    }

    private boolean isValid() {
        int i6 = this.largeCount;
        if (i6 <= 0 || this.smallCount <= 0 || this.mediumCount <= 0) {
            return i6 <= 0 || this.smallCount <= 0 || this.largeSize > this.smallSize;
        }
        float f6 = this.largeSize;
        float f7 = this.mediumSize;
        return f6 > f7 && f7 > this.smallSize;
    }

    @NonNull
    public String toString() {
        return "Arrangement [priority=" + this.priority + ", smallCount=" + this.smallCount + ", smallSize=" + this.smallSize + ", mediumCount=" + this.mediumCount + ", mediumSize=" + this.mediumSize + ", largeCount=" + this.largeCount + ", largeSize=" + this.largeSize + ", cost=" + this.cost + "]";
    }

    Arrangement(int i6, float f6, float f7, float f8, int i7, float f9, int i8, float f10, int i9, float f11) {
        this.priority = i6;
        this.smallSize = MathUtils.clamp(f6, f7, f8);
        this.smallCount = i7;
        this.mediumSize = f9;
        this.mediumCount = i8;
        this.largeSize = f10;
        this.largeCount = i9;
        fit(f11, f7, f8, f10);
        this.cost = cost(f10);
    }

    private float cost(float f6) {
        if (!isValid()) {
            return Float.MAX_VALUE;
        }
        return Math.abs(f6 - this.largeSize) * this.priority;
    }

    private void fit(float f6, float f7, float f8, float f9) {
        float space = f6 - getSpace();
        int i6 = this.smallCount;
        if (i6 > 0 && space > 0.0f) {
            float f10 = this.smallSize;
            this.smallSize = f10 + Math.min(space / i6, f8 - f10);
        } else if (i6 > 0 && space < 0.0f) {
            float f11 = this.smallSize;
            this.smallSize = f11 + Math.max(space / i6, f7 - f11);
        }
        float calculateLargeSize = calculateLargeSize(f6, this.smallCount, this.smallSize, this.mediumCount, this.largeCount);
        this.largeSize = calculateLargeSize;
        float f12 = (this.smallSize + calculateLargeSize) / 2.0f;
        this.mediumSize = f12;
        int i7 = this.mediumCount;
        if (i7 > 0 && calculateLargeSize != f9) {
            float f13 = (f9 - calculateLargeSize) * this.largeCount;
            float min = Math.min(Math.abs(f13), f12 * 0.1f * i7);
            if (f13 > 0.0f) {
                this.mediumSize -= min / this.mediumCount;
                this.largeSize += min / this.largeCount;
            } else {
                this.mediumSize += min / this.mediumCount;
                this.largeSize -= min / this.largeCount;
            }
        }
    }
}
