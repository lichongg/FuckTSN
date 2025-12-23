package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes5.dex */
public final class QuantizerWu implements Quantizer {
    private static final int INDEX_BITS = 5;
    private static final int INDEX_COUNT = 33;
    private static final int TOTAL_SIZE = 35937;
    Box[] cubes;
    double[] moments;
    int[] momentsB;
    int[] momentsG;
    int[] momentsR;
    int[] weights;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private enum Direction {
        RED,
        GREEN,
        BLUE
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.google.android.material.color.utilities.QuantizerWu$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$android$material$color$utilities$QuantizerWu$Direction;

        static {
            int[] iArr = new int[Direction.values().length];
            $SwitchMap$com$google$android$material$color$utilities$QuantizerWu$Direction = iArr;
            try {
                iArr[Direction.RED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$android$material$color$utilities$QuantizerWu$Direction[Direction.GREEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$android$material$color$utilities$QuantizerWu$Direction[Direction.BLUE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class CreateBoxesResult {
        int resultCount;

        CreateBoxesResult(int i6, int i7) {
            this.resultCount = i7;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class MaximizeResult {
        int cutLocation;
        double maximum;

        MaximizeResult(int i6, double d6) {
            this.cutLocation = i6;
            this.maximum = d6;
        }
    }

    static int bottom(Box box, Direction direction, int[] iArr) {
        int i6;
        int i7;
        int i8 = AnonymousClass1.$SwitchMap$com$google$android$material$color$utilities$QuantizerWu$Direction[direction.ordinal()];
        if (i8 == 1) {
            i6 = (-iArr[getIndex(box.f32591r0, box.f32590g1, box.f32588b1)]) + iArr[getIndex(box.f32591r0, box.f32590g1, box.f32587b0)] + iArr[getIndex(box.f32591r0, box.f32589g0, box.f32588b1)];
            i7 = iArr[getIndex(box.f32591r0, box.f32589g0, box.f32587b0)];
        } else if (i8 == 2) {
            i6 = (-iArr[getIndex(box.f32592r1, box.f32589g0, box.f32588b1)]) + iArr[getIndex(box.f32592r1, box.f32589g0, box.f32587b0)] + iArr[getIndex(box.f32591r0, box.f32589g0, box.f32588b1)];
            i7 = iArr[getIndex(box.f32591r0, box.f32589g0, box.f32587b0)];
        } else {
            if (i8 != 3) {
                throw new IllegalArgumentException("unexpected direction " + direction);
            }
            i6 = (-iArr[getIndex(box.f32592r1, box.f32590g1, box.f32587b0)]) + iArr[getIndex(box.f32592r1, box.f32589g0, box.f32587b0)] + iArr[getIndex(box.f32591r0, box.f32590g1, box.f32587b0)];
            i7 = iArr[getIndex(box.f32591r0, box.f32589g0, box.f32587b0)];
        }
        return i6 - i7;
    }

    static int getIndex(int i6, int i7, int i8) {
        return (i6 << 10) + (i6 << 6) + i6 + (i7 << 5) + i7 + i8;
    }

    static int top(Box box, Direction direction, int i6, int[] iArr) {
        int i7;
        int i8;
        int i9 = AnonymousClass1.$SwitchMap$com$google$android$material$color$utilities$QuantizerWu$Direction[direction.ordinal()];
        if (i9 == 1) {
            i7 = (iArr[getIndex(i6, box.f32590g1, box.f32588b1)] - iArr[getIndex(i6, box.f32590g1, box.f32587b0)]) - iArr[getIndex(i6, box.f32589g0, box.f32588b1)];
            i8 = iArr[getIndex(i6, box.f32589g0, box.f32587b0)];
        } else if (i9 == 2) {
            i7 = (iArr[getIndex(box.f32592r1, i6, box.f32588b1)] - iArr[getIndex(box.f32592r1, i6, box.f32587b0)]) - iArr[getIndex(box.f32591r0, i6, box.f32588b1)];
            i8 = iArr[getIndex(box.f32591r0, i6, box.f32587b0)];
        } else {
            if (i9 != 3) {
                throw new IllegalArgumentException("unexpected direction " + direction);
            }
            i7 = (iArr[getIndex(box.f32592r1, box.f32590g1, i6)] - iArr[getIndex(box.f32592r1, box.f32589g0, i6)]) - iArr[getIndex(box.f32591r0, box.f32590g1, i6)];
            i8 = iArr[getIndex(box.f32591r0, box.f32589g0, i6)];
        }
        return i7 + i8;
    }

    static int volume(Box box, int[] iArr) {
        return ((((((iArr[getIndex(box.f32592r1, box.f32590g1, box.f32588b1)] - iArr[getIndex(box.f32592r1, box.f32590g1, box.f32587b0)]) - iArr[getIndex(box.f32592r1, box.f32589g0, box.f32588b1)]) + iArr[getIndex(box.f32592r1, box.f32589g0, box.f32587b0)]) - iArr[getIndex(box.f32591r0, box.f32590g1, box.f32588b1)]) + iArr[getIndex(box.f32591r0, box.f32590g1, box.f32587b0)]) + iArr[getIndex(box.f32591r0, box.f32589g0, box.f32588b1)]) - iArr[getIndex(box.f32591r0, box.f32589g0, box.f32587b0)];
    }

    CreateBoxesResult createBoxes(int i6) {
        int i7;
        this.cubes = new Box[i6];
        for (int i8 = 0; i8 < i6; i8++) {
            this.cubes[i8] = new Box(null);
        }
        double[] dArr = new double[i6];
        Box box = this.cubes[0];
        box.f32592r1 = 32;
        box.f32590g1 = 32;
        box.f32588b1 = 32;
        int i9 = 1;
        int i10 = 0;
        while (true) {
            if (i9 >= i6) {
                i7 = i6;
                break;
            }
            Box[] boxArr = this.cubes;
            if (cut(boxArr[i10], boxArr[i9]).booleanValue()) {
                Box box2 = this.cubes[i10];
                dArr[i10] = box2.vol > 1 ? variance(box2) : 0.0d;
                Box box3 = this.cubes[i9];
                dArr[i9] = box3.vol > 1 ? variance(box3) : 0.0d;
            } else {
                dArr[i10] = 0.0d;
                i9--;
            }
            double d6 = dArr[0];
            int i11 = 0;
            for (int i12 = 1; i12 <= i9; i12++) {
                double d7 = dArr[i12];
                if (d7 > d6) {
                    i11 = i12;
                    d6 = d7;
                }
            }
            if (d6 <= 0.0d) {
                i7 = i9 + 1;
                break;
            }
            i9++;
            i10 = i11;
        }
        return new CreateBoxesResult(i6, i7);
    }

    void createMoments() {
        int i6 = 1;
        while (true) {
            int i7 = 33;
            if (i6 >= 33) {
                return;
            }
            int[] iArr = new int[33];
            int[] iArr2 = new int[33];
            int[] iArr3 = new int[33];
            int[] iArr4 = new int[33];
            double[] dArr = new double[33];
            int i8 = 1;
            while (i8 < i7) {
                int i9 = 0;
                double d6 = 0.0d;
                int i10 = 1;
                int i11 = 0;
                int i12 = 0;
                int i13 = 0;
                while (i10 < i7) {
                    int index = getIndex(i6, i8, i10);
                    i9 += this.weights[index];
                    i11 += this.momentsR[index];
                    i12 += this.momentsG[index];
                    i13 += this.momentsB[index];
                    d6 += this.moments[index];
                    iArr[i10] = iArr[i10] + i9;
                    iArr2[i10] = iArr2[i10] + i11;
                    iArr3[i10] = iArr3[i10] + i12;
                    iArr4[i10] = iArr4[i10] + i13;
                    dArr[i10] = dArr[i10] + d6;
                    int index2 = getIndex(i6 - 1, i8, i10);
                    int i14 = i10;
                    int[] iArr5 = this.weights;
                    iArr5[index] = iArr5[index2] + iArr[i14];
                    int[] iArr6 = this.momentsR;
                    iArr6[index] = iArr6[index2] + iArr2[i14];
                    int[] iArr7 = this.momentsG;
                    iArr7[index] = iArr7[index2] + iArr3[i14];
                    int[] iArr8 = this.momentsB;
                    iArr8[index] = iArr8[index2] + iArr4[i14];
                    double[] dArr2 = this.moments;
                    dArr2[index] = dArr2[index2] + dArr[i14];
                    i10 = i14 + 1;
                    i7 = 33;
                }
                i8++;
                i7 = 33;
            }
            i6++;
        }
    }

    List<Integer> createResult(int i6) {
        ArrayList arrayList = new ArrayList();
        for (int i7 = 0; i7 < i6; i7++) {
            Box box = this.cubes[i7];
            int volume = volume(box, this.weights);
            if (volume > 0) {
                int volume2 = volume(box, this.momentsR) / volume;
                int volume3 = volume(box, this.momentsG) / volume;
                arrayList.add(Integer.valueOf(((volume(box, this.momentsB) / volume) & 255) | ((volume2 & 255) << 16) | ViewCompat.MEASURED_STATE_MASK | ((volume3 & 255) << 8)));
            }
        }
        return arrayList;
    }

    Boolean cut(Box box, Box box2) {
        int volume = volume(box, this.momentsR);
        int volume2 = volume(box, this.momentsG);
        int volume3 = volume(box, this.momentsB);
        int volume4 = volume(box, this.weights);
        Direction direction = Direction.RED;
        MaximizeResult maximize = maximize(box, direction, box.f32591r0 + 1, box.f32592r1, volume, volume2, volume3, volume4);
        Direction direction2 = Direction.GREEN;
        MaximizeResult maximize2 = maximize(box, direction2, box.f32589g0 + 1, box.f32590g1, volume, volume2, volume3, volume4);
        Direction direction3 = Direction.BLUE;
        MaximizeResult maximize3 = maximize(box, direction3, box.f32587b0 + 1, box.f32588b1, volume, volume2, volume3, volume4);
        double d6 = maximize.maximum;
        double d7 = maximize2.maximum;
        double d8 = maximize3.maximum;
        if (d6 < d7 || d6 < d8) {
            if (d7 >= d6 && d7 >= d8) {
                direction3 = direction2;
            }
        } else {
            if (maximize.cutLocation < 0) {
                return Boolean.FALSE;
            }
            direction3 = direction;
        }
        box2.f32592r1 = box.f32592r1;
        box2.f32590g1 = box.f32590g1;
        box2.f32588b1 = box.f32588b1;
        int i6 = AnonymousClass1.$SwitchMap$com$google$android$material$color$utilities$QuantizerWu$Direction[direction3.ordinal()];
        if (i6 == 1) {
            int i7 = maximize.cutLocation;
            box.f32592r1 = i7;
            box2.f32591r0 = i7;
            box2.f32589g0 = box.f32589g0;
            box2.f32587b0 = box.f32587b0;
        } else if (i6 == 2) {
            int i8 = maximize2.cutLocation;
            box.f32590g1 = i8;
            box2.f32591r0 = box.f32591r0;
            box2.f32589g0 = i8;
            box2.f32587b0 = box.f32587b0;
        } else if (i6 == 3) {
            int i9 = maximize3.cutLocation;
            box.f32588b1 = i9;
            box2.f32591r0 = box.f32591r0;
            box2.f32589g0 = box.f32589g0;
            box2.f32587b0 = i9;
        }
        box.vol = (box.f32592r1 - box.f32591r0) * (box.f32590g1 - box.f32589g0) * (box.f32588b1 - box.f32587b0);
        box2.vol = (box2.f32592r1 - box2.f32591r0) * (box2.f32590g1 - box2.f32589g0) * (box2.f32588b1 - box2.f32587b0);
        return Boolean.TRUE;
    }

    MaximizeResult maximize(Box box, Direction direction, int i6, int i7, int i8, int i9, int i10, int i11) {
        QuantizerWu quantizerWu = this;
        Box box2 = box;
        int bottom = bottom(box2, direction, quantizerWu.momentsR);
        int bottom2 = bottom(box2, direction, quantizerWu.momentsG);
        int bottom3 = bottom(box2, direction, quantizerWu.momentsB);
        int bottom4 = bottom(box2, direction, quantizerWu.weights);
        double d6 = 0.0d;
        int i12 = -1;
        int i13 = i6;
        while (i13 < i7) {
            int pVar = top(box2, direction, i13, quantizerWu.momentsR) + bottom;
            int pVar2 = top(box2, direction, i13, quantizerWu.momentsG) + bottom2;
            int pVar3 = top(box2, direction, i13, quantizerWu.momentsB) + bottom3;
            int pVar4 = top(box2, direction, i13, quantizerWu.weights) + bottom4;
            if (pVar4 != 0) {
                double d7 = (((pVar * pVar) + (pVar2 * pVar2)) + (pVar3 * pVar3)) / pVar4;
                int i14 = i8 - pVar;
                int i15 = i9 - pVar2;
                int i16 = i10 - pVar3;
                int i17 = i11 - pVar4;
                if (i17 != 0) {
                    double d8 = d7 + ((((i14 * i14) + (i15 * i15)) + (i16 * i16)) / i17);
                    if (d8 > d6) {
                        d6 = d8;
                        i12 = i13;
                    }
                }
            }
            i13++;
            quantizerWu = this;
            box2 = box;
        }
        return new MaximizeResult(i12, d6);
    }

    @Override // com.google.android.material.color.utilities.Quantizer
    public QuantizerResult quantize(int[] iArr, int i6) {
        constructHistogram(new QuantizerMap().quantize(iArr, i6).colorToCount);
        createMoments();
        List<Integer> createResult = createResult(createBoxes(i6).resultCount);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Integer num : createResult) {
            num.intValue();
            linkedHashMap.put(num, 0);
        }
        return new QuantizerResult(linkedHashMap);
    }

    double variance(Box box) {
        int volume = volume(box, this.momentsR);
        int volume2 = volume(box, this.momentsG);
        int volume3 = volume(box, this.momentsB);
        return (((((((this.moments[getIndex(box.f32592r1, box.f32590g1, box.f32588b1)] - this.moments[getIndex(box.f32592r1, box.f32590g1, box.f32587b0)]) - this.moments[getIndex(box.f32592r1, box.f32589g0, box.f32588b1)]) + this.moments[getIndex(box.f32592r1, box.f32589g0, box.f32587b0)]) - this.moments[getIndex(box.f32591r0, box.f32590g1, box.f32588b1)]) + this.moments[getIndex(box.f32591r0, box.f32590g1, box.f32587b0)]) + this.moments[getIndex(box.f32591r0, box.f32589g0, box.f32588b1)]) - this.moments[getIndex(box.f32591r0, box.f32589g0, box.f32587b0)]) - ((((volume * volume) + (volume2 * volume2)) + (volume3 * volume3)) / volume(box, this.weights));
    }

    void constructHistogram(Map<Integer, Integer> map) {
        this.weights = new int[TOTAL_SIZE];
        this.momentsR = new int[TOTAL_SIZE];
        this.momentsG = new int[TOTAL_SIZE];
        this.momentsB = new int[TOTAL_SIZE];
        this.moments = new double[TOTAL_SIZE];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int intValue = entry.getKey().intValue();
            int intValue2 = entry.getValue().intValue();
            int redFromArgb = ColorUtils.redFromArgb(intValue);
            int greenFromArgb = ColorUtils.greenFromArgb(intValue);
            int blueFromArgb = ColorUtils.blueFromArgb(intValue);
            int index = getIndex((redFromArgb >> 3) + 1, (greenFromArgb >> 3) + 1, (blueFromArgb >> 3) + 1);
            int[] iArr = this.weights;
            iArr[index] = iArr[index] + intValue2;
            int[] iArr2 = this.momentsR;
            iArr2[index] = iArr2[index] + (redFromArgb * intValue2);
            int[] iArr3 = this.momentsG;
            iArr3[index] = iArr3[index] + (greenFromArgb * intValue2);
            int[] iArr4 = this.momentsB;
            iArr4[index] = iArr4[index] + (blueFromArgb * intValue2);
            double[] dArr = this.moments;
            dArr[index] = dArr[index] + (intValue2 * ((redFromArgb * redFromArgb) + (greenFromArgb * greenFromArgb) + (blueFromArgb * blueFromArgb)));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class Box {

        /* renamed from: b0, reason: collision with root package name */
        int f32587b0;

        /* renamed from: b1, reason: collision with root package name */
        int f32588b1;

        /* renamed from: g0, reason: collision with root package name */
        int f32589g0;

        /* renamed from: g1, reason: collision with root package name */
        int f32590g1;

        /* renamed from: r0, reason: collision with root package name */
        int f32591r0;

        /* renamed from: r1, reason: collision with root package name */
        int f32592r1;
        int vol;

        private Box() {
            this.f32591r0 = 0;
            this.f32592r1 = 0;
            this.f32589g0 = 0;
            this.f32590g1 = 0;
            this.f32587b0 = 0;
            this.f32588b1 = 0;
            this.vol = 0;
        }

        /* synthetic */ Box(AnonymousClass1 anonymousClass1) {
            this();
        }
    }
}
