package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.q;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Beta
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public final class Escapers {
    private static final Escaper NULL_ESCAPER = new CharEscaper() { // from class: com.google.common.escape.Escapers.1
        @Override // com.google.common.escape.CharEscaper
        protected char[] escape(char c6) {
            return null;
        }

        @Override // com.google.common.escape.CharEscaper, com.google.common.escape.Escaper
        public String escape(String str) {
            return (String) Preconditions.checkNotNull(str);
        }
    };

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Beta
    public static final class Builder {
        private final Map<Character, String> replacementMap;
        private char safeMax;
        private char safeMin;
        private String unsafeReplacement;

        private Builder() {
            this.replacementMap = new HashMap();
            this.safeMin = (char) 0;
            this.safeMax = q.f44042c;
            this.unsafeReplacement = null;
        }

        public Escaper build() {
            return new ArrayBasedCharEscaper(this.replacementMap, this.safeMin, this.safeMax) { // from class: com.google.common.escape.Escapers.Builder.1
                private final char[] replacementChars;

                {
                    this.replacementChars = Builder.this.unsafeReplacement != null ? Builder.this.unsafeReplacement.toCharArray() : null;
                }

                @Override // com.google.common.escape.ArrayBasedCharEscaper
                protected char[] escapeUnsafe(char c6) {
                    return this.replacementChars;
                }
            };
        }

        @CanIgnoreReturnValue
        public Builder setSafeRange(char c6, char c7) {
            this.safeMin = c6;
            this.safeMax = c7;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setUnsafeReplacement(@NullableDecl String str) {
            this.unsafeReplacement = str;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder addEscape(char c6, String str) {
            Preconditions.checkNotNull(str);
            this.replacementMap.put(Character.valueOf(c6), str);
            return this;
        }
    }

    public static String computeReplacement(CharEscaper charEscaper, char c6) {
        return stringOrNull(charEscaper.escape(c6));
    }

    public static Builder builder() {
        return new Builder();
    }

    public static String computeReplacement(UnicodeEscaper unicodeEscaper, int i6) {
        return stringOrNull(unicodeEscaper.escape(i6));
    }

    public static Escaper nullEscaper() {
        return NULL_ESCAPER;
    }

    private static String stringOrNull(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        return new String(cArr);
    }

    private static UnicodeEscaper wrap(final CharEscaper charEscaper) {
        return new UnicodeEscaper() { // from class: com.google.common.escape.Escapers.2
            @Override // com.google.common.escape.UnicodeEscaper
            protected char[] escape(int i6) {
                if (i6 < 65536) {
                    return CharEscaper.this.escape((char) i6);
                }
                char[] cArr = new char[2];
                Character.toChars(i6, cArr, 0);
                char[] escape = CharEscaper.this.escape(cArr[0]);
                char[] escape2 = CharEscaper.this.escape(cArr[1]);
                if (escape == null && escape2 == null) {
                    return null;
                }
                int length = escape != null ? escape.length : 1;
                char[] cArr2 = new char[(escape2 != null ? escape2.length : 1) + length];
                if (escape != null) {
                    for (int i7 = 0; i7 < escape.length; i7++) {
                        cArr2[i7] = escape[i7];
                    }
                } else {
                    cArr2[0] = cArr[0];
                }
                if (escape2 == null) {
                    cArr2[length] = cArr[1];
                    return cArr2;
                }
                for (int i8 = 0; i8 < escape2.length; i8++) {
                    cArr2[length + i8] = escape2[i8];
                }
                return cArr2;
            }
        };
    }

    private Escapers() {
    }

    static UnicodeEscaper asUnicodeEscaper(Escaper escaper) {
        Preconditions.checkNotNull(escaper);
        if (escaper instanceof UnicodeEscaper) {
            return (UnicodeEscaper) escaper;
        }
        if (escaper instanceof CharEscaper) {
            return wrap((CharEscaper) escaper);
        }
        throw new IllegalArgumentException("Cannot create a UnicodeEscaper from: " + escaper.getClass().getName());
    }
}
