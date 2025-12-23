package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes5.dex */
public final class TemperatureCache {
    private final Hct input;
    private Hct precomputedComplement;
    private List<Hct> precomputedHctsByHue;
    private List<Hct> precomputedHctsByTemp;
    private Map<Hct, Double> precomputedTempsByHct;

    private TemperatureCache() {
        throw new UnsupportedOperationException();
    }

    private static boolean isBetween(double d6, double d7, double d8) {
        return d7 < d8 ? d7 <= d6 && d6 <= d8 : d7 <= d6 || d6 <= d8;
    }

    public List<Hct> getAnalogousColors() {
        return getAnalogousColors(5, 12);
    }

    private List<Hct> getHctsByHue() {
        List<Hct> list = this.precomputedHctsByHue;
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (double d6 = 0.0d; d6 <= 360.0d; d6 += 1.0d) {
            arrayList.add(Hct.from(d6, this.input.getChroma(), this.input.getTone()));
        }
        List<Hct> unmodifiableList = Collections.unmodifiableList(arrayList);
        this.precomputedHctsByHue = unmodifiableList;
        return unmodifiableList;
    }

    private List<Hct> getHctsByTemp() {
        Comparator comparing;
        List<Hct> list = this.precomputedHctsByTemp;
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList(getHctsByHue());
        arrayList.add(this.input);
        comparing = Comparator.comparing(new Function() { // from class: com.google.android.material.color.utilities.s5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double d6;
                d6 = TemperatureCache.this.getTempsByHct().get((Hct) obj);
                return d6;
            }
        }, new Comparator() { // from class: com.google.android.material.color.utilities.t5
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((Double) obj).compareTo((Double) obj2);
            }
        });
        Collections.sort(arrayList, comparing);
        this.precomputedHctsByTemp = arrayList;
        return arrayList;
    }

    private Map<Hct, Double> getTempsByHct() {
        Map<Hct, Double> map = this.precomputedTempsByHct;
        if (map != null) {
            return map;
        }
        ArrayList<Hct> arrayList = new ArrayList(getHctsByHue());
        arrayList.add(this.input);
        HashMap hashMap = new HashMap();
        for (Hct hct : arrayList) {
            hashMap.put(hct, Double.valueOf(rawTemperature(hct)));
        }
        this.precomputedTempsByHct = hashMap;
        return hashMap;
    }

    public List<Hct> getAnalogousColors(int i6, int i7) {
        int round = (int) Math.round(this.input.getHue());
        Hct hct = getHctsByHue().get(round);
        double relativeTemperature = getRelativeTemperature(hct);
        ArrayList arrayList = new ArrayList();
        arrayList.add(hct);
        double d6 = 0.0d;
        double d7 = 0.0d;
        int i8 = 0;
        while (i8 < 360) {
            double relativeTemperature2 = getRelativeTemperature(getHctsByHue().get(MathUtils.sanitizeDegreesInt(round + i8)));
            d7 += Math.abs(relativeTemperature2 - relativeTemperature);
            i8++;
            relativeTemperature = relativeTemperature2;
        }
        double d8 = d7 / i7;
        double relativeTemperature3 = getRelativeTemperature(hct);
        int i9 = 1;
        while (true) {
            if (arrayList.size() >= i7) {
                break;
            }
            Hct hct2 = getHctsByHue().get(MathUtils.sanitizeDegreesInt(round + i9));
            double relativeTemperature4 = getRelativeTemperature(hct2);
            d6 += Math.abs(relativeTemperature4 - relativeTemperature3);
            boolean z5 = d6 >= ((double) arrayList.size()) * d8;
            int i10 = 1;
            while (z5 && arrayList.size() < i7) {
                arrayList.add(hct2);
                int i11 = i9;
                z5 = d6 >= ((double) (arrayList.size() + i10)) * d8;
                i10++;
                i9 = i11;
            }
            i9++;
            if (i9 > 360) {
                while (arrayList.size() < i7) {
                    arrayList.add(hct2);
                }
            } else {
                relativeTemperature3 = relativeTemperature4;
            }
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(this.input);
        int floor = (int) Math.floor((i6 - 1.0d) / 2.0d);
        for (int i12 = 1; i12 < floor + 1; i12++) {
            int i13 = 0 - i12;
            while (i13 < 0) {
                i13 += arrayList.size();
            }
            if (i13 >= arrayList.size()) {
                i13 %= arrayList.size();
            }
            arrayList2.add(0, (Hct) arrayList.get(i13));
        }
        int i14 = i6 - floor;
        for (int i15 = 1; i15 < i14; i15++) {
            int i16 = i15;
            while (i16 < 0) {
                i16 += arrayList.size();
            }
            if (i16 >= arrayList.size()) {
                i16 %= arrayList.size();
            }
            arrayList2.add((Hct) arrayList.get(i16));
        }
        return arrayList2;
    }

    public Hct getComplement() {
        double d6;
        Hct hct = this.precomputedComplement;
        if (hct != null) {
            return hct;
        }
        double hue = getColdest().getHue();
        double doubleValue = getTempsByHct().get(getColdest()).doubleValue();
        double hue2 = getWarmest().getHue();
        double doubleValue2 = getTempsByHct().get(getWarmest()).doubleValue() - doubleValue;
        boolean isBetween = isBetween(this.input.getHue(), hue, hue2);
        double d7 = isBetween ? hue2 : hue;
        double d8 = isBetween ? hue : hue2;
        Hct hct2 = getHctsByHue().get((int) Math.round(this.input.getHue()));
        double d9 = 1.0d;
        double relativeTemperature = 1.0d - getRelativeTemperature(this.input);
        double d10 = 1000.0d;
        double d11 = 0.0d;
        while (d11 <= 360.0d) {
            double sanitizeDegreesDouble = MathUtils.sanitizeDegreesDouble((d9 * d11) + d7);
            if (isBetween(sanitizeDegreesDouble, d7, d8)) {
                d6 = d9;
                Hct hct3 = getHctsByHue().get((int) Math.round(sanitizeDegreesDouble));
                double abs = Math.abs(relativeTemperature - ((getTempsByHct().get(hct3).doubleValue() - doubleValue) / doubleValue2));
                if (abs < d10) {
                    hct2 = hct3;
                    d10 = abs;
                }
            } else {
                d6 = d9;
            }
            d11 += d6;
            d9 = d6;
        }
        this.precomputedComplement = hct2;
        return hct2;
    }

    public TemperatureCache(Hct hct) {
        this.input = hct;
    }

    private Hct getColdest() {
        return getHctsByTemp().get(0);
    }

    private Hct getWarmest() {
        return getHctsByTemp().get(getHctsByTemp().size() - 1);
    }

    public static double rawTemperature(Hct hct) {
        double[] labFromArgb = ColorUtils.labFromArgb(hct.toInt());
        return ((Math.pow(Math.hypot(labFromArgb[1], labFromArgb[2]), 1.07d) * 0.02d) * Math.cos(Math.toRadians(MathUtils.sanitizeDegreesDouble(MathUtils.sanitizeDegreesDouble(Math.toDegrees(Math.atan2(labFromArgb[2], labFromArgb[1]))) - 50.0d)))) - 0.5d;
    }

    public double getRelativeTemperature(Hct hct) {
        double doubleValue = getTempsByHct().get(getWarmest()).doubleValue() - getTempsByHct().get(getColdest()).doubleValue();
        double doubleValue2 = getTempsByHct().get(hct).doubleValue() - getTempsByHct().get(getColdest()).doubleValue();
        if (doubleValue == 0.0d) {
            return 0.5d;
        }
        return doubleValue2 / doubleValue;
    }
}
