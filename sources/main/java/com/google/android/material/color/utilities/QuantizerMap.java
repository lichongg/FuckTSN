package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes5.dex */
public final class QuantizerMap implements Quantizer {
    Map<Integer, Integer> colorToCount;

    public Map<Integer, Integer> getColorToCount() {
        return this.colorToCount;
    }

    @Override // com.google.android.material.color.utilities.Quantizer
    public QuantizerResult quantize(int[] iArr, int i6) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i7 : iArr) {
            Integer num = (Integer) linkedHashMap.get(Integer.valueOf(i7));
            int i8 = 1;
            if (num != null) {
                i8 = 1 + num.intValue();
            }
            linkedHashMap.put(Integer.valueOf(i7), Integer.valueOf(i8));
        }
        this.colorToCount = linkedHashMap;
        return new QuantizerResult(linkedHashMap);
    }
}
