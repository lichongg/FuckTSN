package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Map;
import kotlin.jvm.internal.q;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Beta
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class ArrayBasedCharEscaper extends CharEscaper {
    private final char[][] replacements;
    private final int replacementsLength;
    private final char safeMax;
    private final char safeMin;

    protected ArrayBasedCharEscaper(Map<Character, String> map, char c6, char c7) {
        this(ArrayBasedEscaperMap.create(map), c6, c7);
    }

    @Override // com.google.common.escape.CharEscaper, com.google.common.escape.Escaper
    public final String escape(String str) {
        Preconditions.checkNotNull(str);
        for (int i6 = 0; i6 < str.length(); i6++) {
            char charAt = str.charAt(i6);
            if ((charAt < this.replacementsLength && this.replacements[charAt] != null) || charAt > this.safeMax || charAt < this.safeMin) {
                return escapeSlow(str, i6);
            }
        }
        return str;
    }

    protected abstract char[] escapeUnsafe(char c6);

    protected ArrayBasedCharEscaper(ArrayBasedEscaperMap arrayBasedEscaperMap, char c6, char c7) {
        Preconditions.checkNotNull(arrayBasedEscaperMap);
        char[][] replacementArray = arrayBasedEscaperMap.getReplacementArray();
        this.replacements = replacementArray;
        this.replacementsLength = replacementArray.length;
        if (c7 < c6) {
            c7 = 0;
            c6 = q.f44042c;
        }
        this.safeMin = c6;
        this.safeMax = c7;
    }

    @Override // com.google.common.escape.CharEscaper
    protected final char[] escape(char c6) {
        char[] cArr;
        if (c6 < this.replacementsLength && (cArr = this.replacements[c6]) != null) {
            return cArr;
        }
        if (c6 < this.safeMin || c6 > this.safeMax) {
            return escapeUnsafe(c6);
        }
        return null;
    }
}
