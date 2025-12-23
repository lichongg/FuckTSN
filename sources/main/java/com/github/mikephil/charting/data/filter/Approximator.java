package com.github.mikephil.charting.data.filter;

import android.annotation.TargetApi;
import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class Approximator {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class Line {
        private float dx;
        private float dy;
        private float exsy;
        private float length;
        private float[] points;
        private float sxey;

        public Line(float f6, float f7, float f8, float f9) {
            this.dx = f6 - f8;
            this.dy = f7 - f9;
            this.sxey = f6 * f9;
            this.exsy = f8 * f7;
            this.length = (float) Math.sqrt((r3 * r3) + (r0 * r0));
            this.points = new float[]{f6, f7, f8, f9};
        }

        public float distance(float f6, float f7) {
            return Math.abs((((this.dy * f6) - (this.dx * f7)) + this.sxey) - this.exsy) / this.length;
        }

        public float[] getPoints() {
            return this.points;
        }
    }

    float[] concat(float[]... fArr) {
        int i6 = 0;
        for (float[] fArr2 : fArr) {
            i6 += fArr2.length;
        }
        float[] fArr3 = new float[i6];
        int i7 = 0;
        for (float[] fArr4 : fArr) {
            for (float f6 : fArr4) {
                fArr3[i7] = f6;
                i7++;
            }
        }
        return fArr3;
    }

    @TargetApi(9)
    public float[] reduceWithDouglasPeucker(float[] fArr, float f6) {
        Line line = new Line(fArr[0], fArr[1], fArr[fArr.length - 2], fArr[fArr.length - 1]);
        float f7 = 0.0f;
        int i6 = 0;
        for (int i7 = 2; i7 < fArr.length - 2; i7 += 2) {
            float distance = line.distance(fArr[i7], fArr[i7 + 1]);
            if (distance > f7) {
                i6 = i7;
                f7 = distance;
            }
        }
        if (f7 <= f6) {
            return line.getPoints();
        }
        float[] reduceWithDouglasPeucker = reduceWithDouglasPeucker(Arrays.copyOfRange(fArr, 0, i6 + 2), f6);
        float[] reduceWithDouglasPeucker2 = reduceWithDouglasPeucker(Arrays.copyOfRange(fArr, i6, fArr.length), f6);
        return concat(reduceWithDouglasPeucker, Arrays.copyOfRange(reduceWithDouglasPeucker2, 2, reduceWithDouglasPeucker2.length));
    }
}
