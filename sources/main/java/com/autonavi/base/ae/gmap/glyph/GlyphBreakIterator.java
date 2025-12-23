package com.autonavi.base.ae.gmap.glyph;

import java.text.BreakIterator;
import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class GlyphBreakIterator {
    public static final int BREAK_BY_CHARACTER_SEQUENCES = 2;
    public static final int BREAK_BY_WORDS = 1;
    public ArrayList<Integer> breakResult = new ArrayList<>();
    public int mBreakMode;

    public GlyphBreakIterator(int i6) {
        this.mBreakMode = i6;
    }

    public int[] setText(String str) {
        BreakIterator breakIterator = null;
        if (str.isEmpty()) {
            return null;
        }
        if (!this.breakResult.isEmpty()) {
            this.breakResult.clear();
        }
        int i6 = this.mBreakMode;
        if (i6 != 1) {
            if (i6 == 2) {
                breakIterator = BreakIterator.getCharacterInstance();
            }
        } else {
            breakIterator = BreakIterator.getWordInstance();
        }
        breakIterator.setText(str);
        int first = breakIterator.first();
        while (true) {
            int i7 = first;
            first = breakIterator.next();
            if (first == -1) {
                break;
            }
            this.breakResult.add(Integer.valueOf(i7));
        }
        this.breakResult.add(Integer.valueOf(str.length()));
        int size = this.breakResult.size();
        Integer[] numArr = new Integer[size];
        this.breakResult.toArray(numArr);
        int[] iArr = new int[size];
        for (int i8 = 0; i8 < size; i8++) {
            iArr[i8] = numArr[i8].intValue();
        }
        return iArr;
    }
}
