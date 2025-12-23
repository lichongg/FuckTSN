package com.github.mikephil.charting.utils;

import com.github.mikephil.charting.data.Entry;
import java.util.Comparator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class EntryXComparator implements Comparator<Entry> {
    @Override // java.util.Comparator
    public int compare(Entry entry, Entry entry2) {
        float x5 = entry.getX() - entry2.getX();
        if (x5 == 0.0f) {
            return 0;
        }
        return x5 > 0.0f ? 1 : -1;
    }
}
