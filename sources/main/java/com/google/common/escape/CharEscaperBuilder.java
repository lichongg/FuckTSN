package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Beta
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public final class CharEscaperBuilder {
    private int max = -1;
    private final Map<Character, String> map = new HashMap();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class CharArrayDecorator extends CharEscaper {
        private final int replaceLength;
        private final char[][] replacements;

        @Override // com.google.common.escape.CharEscaper, com.google.common.escape.Escaper
        public String escape(String str) {
            int length = str.length();
            for (int i6 = 0; i6 < length; i6++) {
                char charAt = str.charAt(i6);
                char[][] cArr = this.replacements;
                if (charAt < cArr.length && cArr[charAt] != null) {
                    return escapeSlow(str, i6);
                }
            }
            return str;
        }

        CharArrayDecorator(char[][] cArr) {
            this.replacements = cArr;
            this.replaceLength = cArr.length;
        }

        @Override // com.google.common.escape.CharEscaper
        protected char[] escape(char c6) {
            if (c6 < this.replaceLength) {
                return this.replacements[c6];
            }
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @CanIgnoreReturnValue
    public CharEscaperBuilder addEscape(char c6, String str) {
        this.map.put(Character.valueOf(c6), Preconditions.checkNotNull(str));
        if (c6 > this.max) {
            this.max = c6;
        }
        return this;
    }

    public char[][] toArray() {
        char[][] cArr = new char[this.max + 1][];
        for (Map.Entry<Character, String> entry : this.map.entrySet()) {
            cArr[entry.getKey().charValue()] = entry.getValue().toCharArray();
        }
        return cArr;
    }

    public Escaper toEscaper() {
        return new CharArrayDecorator(toArray());
    }

    @CanIgnoreReturnValue
    public CharEscaperBuilder addEscapes(char[] cArr, String str) {
        Preconditions.checkNotNull(str);
        for (char c6 : cArr) {
            addEscape(c6, str);
        }
        return this;
    }
}
