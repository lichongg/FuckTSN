package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Map;
import kotlin.jvm.internal.q;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Beta
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class ArrayBasedUnicodeEscaper extends UnicodeEscaper {
    private final char[][] replacements;
    private final int replacementsLength;
    private final int safeMax;
    private final char safeMaxChar;
    private final int safeMin;
    private final char safeMinChar;

    protected ArrayBasedUnicodeEscaper(Map<Character, String> map, int i6, int i7, @NullableDecl String str) {
        this(ArrayBasedEscaperMap.create(map), i6, i7, str);
    }

    @Override // com.google.common.escape.UnicodeEscaper, com.google.common.escape.Escaper
    public final String escape(String str) {
        Preconditions.checkNotNull(str);
        for (int i6 = 0; i6 < str.length(); i6++) {
            char charAt = str.charAt(i6);
            if ((charAt < this.replacementsLength && this.replacements[charAt] != null) || charAt > this.safeMaxChar || charAt < this.safeMinChar) {
                return escapeSlow(str, i6);
            }
        }
        return str;
    }

    protected abstract char[] escapeUnsafe(int i6);

    protected ArrayBasedUnicodeEscaper(ArrayBasedEscaperMap arrayBasedEscaperMap, int i6, int i7, @NullableDecl String str) {
        Preconditions.checkNotNull(arrayBasedEscaperMap);
        char[][] replacementArray = arrayBasedEscaperMap.getReplacementArray();
        this.replacements = replacementArray;
        this.replacementsLength = replacementArray.length;
        if (i7 < i6) {
            i7 = -1;
            i6 = Integer.MAX_VALUE;
        }
        this.safeMin = i6;
        this.safeMax = i7;
        if (i6 >= 55296) {
            this.safeMinChar = q.f44042c;
            this.safeMaxChar = (char) 0;
        } else {
            this.safeMinChar = (char) i6;
            this.safeMaxChar = (char) Math.min(i7, 55295);
        }
    }

    @Override // com.google.common.escape.UnicodeEscaper
    protected final int nextEscapeIndex(CharSequence charSequence, int i6, int i7) {
        while (i6 < i7) {
            char charAt = charSequence.charAt(i6);
            if ((charAt < this.replacementsLength && this.replacements[charAt] != null) || charAt > this.safeMaxChar || charAt < this.safeMinChar) {
                break;
            }
            i6++;
        }
        return i6;
    }

    @Override // com.google.common.escape.UnicodeEscaper
    protected final char[] escape(int i6) {
        char[] cArr;
        if (i6 < this.replacementsLength && (cArr = this.replacements[i6]) != null) {
            return cArr;
        }
        if (i6 < this.safeMin || i6 > this.safeMax) {
            return escapeUnsafe(i6);
        }
        return null;
    }
}
