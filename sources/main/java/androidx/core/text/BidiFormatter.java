package androidx.core.text;

import android.text.SpannableStringBuilder;
import java.util.Locale;
import kotlin.text.v0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class BidiFormatter {
    private static final int DEFAULT_FLAGS = 2;
    static final BidiFormatter DEFAULT_LTR_INSTANCE;
    static final BidiFormatter DEFAULT_RTL_INSTANCE;
    static final TextDirectionHeuristicCompat DEFAULT_TEXT_DIRECTION_HEURISTIC;
    private static final int DIR_LTR = -1;
    private static final int DIR_RTL = 1;
    private static final int DIR_UNKNOWN = 0;
    private static final String EMPTY_STRING = "";
    private static final int FLAG_STEREO_RESET = 2;
    private static final char LRE = 8234;
    private static final char LRM = 8206;
    private static final String LRM_STRING;
    private static final char PDF = 8236;
    private static final char RLE = 8235;
    private static final char RLM = 8207;
    private static final String RLM_STRING;
    private final TextDirectionHeuristicCompat mDefaultTextDirectionHeuristicCompat;
    private final int mFlags;
    private final boolean mIsRtlContext;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Builder {
        private int mFlags;
        private boolean mIsRtlContext;
        private TextDirectionHeuristicCompat mTextDirectionHeuristicCompat;

        public Builder() {
            initialize(BidiFormatter.isRtlLocale(Locale.getDefault()));
        }

        private static BidiFormatter getDefaultInstanceFromContext(boolean z5) {
            return z5 ? BidiFormatter.DEFAULT_RTL_INSTANCE : BidiFormatter.DEFAULT_LTR_INSTANCE;
        }

        private void initialize(boolean z5) {
            this.mIsRtlContext = z5;
            this.mTextDirectionHeuristicCompat = BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC;
            this.mFlags = 2;
        }

        public BidiFormatter build() {
            return (this.mFlags == 2 && this.mTextDirectionHeuristicCompat == BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC) ? getDefaultInstanceFromContext(this.mIsRtlContext) : new BidiFormatter(this.mIsRtlContext, this.mFlags, this.mTextDirectionHeuristicCompat);
        }

        public Builder setTextDirectionHeuristic(TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
            this.mTextDirectionHeuristicCompat = textDirectionHeuristicCompat;
            return this;
        }

        public Builder stereoReset(boolean z5) {
            if (z5) {
                this.mFlags |= 2;
                return this;
            }
            this.mFlags &= -3;
            return this;
        }

        public Builder(boolean z5) {
            initialize(z5);
        }

        public Builder(Locale locale) {
            initialize(BidiFormatter.isRtlLocale(locale));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class DirectionalityEstimator {
        private int charIndex;
        private final boolean isHtml;
        private char lastChar;
        private final int length;
        private final CharSequence text;
        private static final int DIR_TYPE_CACHE_SIZE = 1792;
        private static final byte[] DIR_TYPE_CACHE = new byte[DIR_TYPE_CACHE_SIZE];

        int getEntryDir() {
            this.charIndex = 0;
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            while (this.charIndex < this.length && i6 == 0) {
                byte dirTypeForward = dirTypeForward();
                if (dirTypeForward != 0) {
                    if (dirTypeForward == 1 || dirTypeForward == 2) {
                        if (i8 == 0) {
                            return 1;
                        }
                    } else if (dirTypeForward != 9) {
                        switch (dirTypeForward) {
                            case 14:
                            case 15:
                                i8++;
                                i7 = -1;
                                continue;
                            case 16:
                            case 17:
                                i8++;
                                i7 = 1;
                                continue;
                            case 18:
                                i8--;
                                i7 = 0;
                                continue;
                        }
                    }
                } else if (i8 == 0) {
                    return -1;
                }
                i6 = i8;
            }
            if (i6 == 0) {
                return 0;
            }
            if (i7 != 0) {
                return i7;
            }
            while (this.charIndex > 0) {
                switch (dirTypeBackward()) {
                    case 14:
                    case 15:
                        if (i6 == i8) {
                            return -1;
                        }
                        break;
                    case 16:
                    case 17:
                        if (i6 == i8) {
                            return 1;
                        }
                        break;
                    case 18:
                        i8++;
                        continue;
                }
                i8--;
            }
            return 0;
        }

        static {
            for (int i6 = 0; i6 < DIR_TYPE_CACHE_SIZE; i6++) {
                DIR_TYPE_CACHE[i6] = Character.getDirectionality(i6);
            }
        }

        private static byte getCachedDirectionality(char c6) {
            return c6 < DIR_TYPE_CACHE_SIZE ? DIR_TYPE_CACHE[c6] : Character.getDirectionality(c6);
        }

        private byte skipEntityBackward() {
            char charAt;
            int i6 = this.charIndex;
            do {
                int i7 = this.charIndex;
                if (i7 <= 0) {
                    break;
                }
                CharSequence charSequence = this.text;
                int i8 = i7 - 1;
                this.charIndex = i8;
                charAt = charSequence.charAt(i8);
                this.lastChar = charAt;
                if (charAt == '&') {
                    return (byte) 12;
                }
            } while (charAt != ';');
            this.charIndex = i6;
            this.lastChar = ';';
            return (byte) 13;
        }

        private byte skipEntityForward() {
            char charAt;
            do {
                int i6 = this.charIndex;
                if (i6 >= this.length) {
                    return (byte) 12;
                }
                CharSequence charSequence = this.text;
                this.charIndex = i6 + 1;
                charAt = charSequence.charAt(i6);
                this.lastChar = charAt;
            } while (charAt != ';');
            return (byte) 12;
        }

        private byte skipTagBackward() {
            char charAt;
            int i6 = this.charIndex;
            while (true) {
                int i7 = this.charIndex;
                if (i7 <= 0) {
                    break;
                }
                CharSequence charSequence = this.text;
                int i8 = i7 - 1;
                this.charIndex = i8;
                char charAt2 = charSequence.charAt(i8);
                this.lastChar = charAt2;
                if (charAt2 == '<') {
                    return (byte) 12;
                }
                if (charAt2 == '>') {
                    break;
                }
                if (charAt2 == '\"' || charAt2 == '\'') {
                    do {
                        int i9 = this.charIndex;
                        if (i9 > 0) {
                            CharSequence charSequence2 = this.text;
                            int i10 = i9 - 1;
                            this.charIndex = i10;
                            charAt = charSequence2.charAt(i10);
                            this.lastChar = charAt;
                        }
                    } while (charAt != charAt2);
                }
            }
            this.charIndex = i6;
            this.lastChar = v0.f47962f;
            return (byte) 13;
        }

        private byte skipTagForward() {
            char charAt;
            int i6 = this.charIndex;
            while (true) {
                int i7 = this.charIndex;
                if (i7 >= this.length) {
                    this.charIndex = i6;
                    this.lastChar = v0.f47961e;
                    return (byte) 13;
                }
                CharSequence charSequence = this.text;
                this.charIndex = i7 + 1;
                char charAt2 = charSequence.charAt(i7);
                this.lastChar = charAt2;
                if (charAt2 == '>') {
                    return (byte) 12;
                }
                if (charAt2 == '\"' || charAt2 == '\'') {
                    do {
                        int i8 = this.charIndex;
                        if (i8 < this.length) {
                            CharSequence charSequence2 = this.text;
                            this.charIndex = i8 + 1;
                            charAt = charSequence2.charAt(i8);
                            this.lastChar = charAt;
                        }
                    } while (charAt != charAt2);
                }
            }
        }

        byte dirTypeBackward() {
            char charAt = this.text.charAt(this.charIndex - 1);
            this.lastChar = charAt;
            if (Character.isLowSurrogate(charAt)) {
                int codePointBefore = Character.codePointBefore(this.text, this.charIndex);
                this.charIndex -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.charIndex--;
            byte cachedDirectionality = getCachedDirectionality(this.lastChar);
            if (!this.isHtml) {
                return cachedDirectionality;
            }
            char c6 = this.lastChar;
            return c6 == '>' ? skipTagBackward() : c6 == ';' ? skipEntityBackward() : cachedDirectionality;
        }

        byte dirTypeForward() {
            char charAt = this.text.charAt(this.charIndex);
            this.lastChar = charAt;
            if (Character.isHighSurrogate(charAt)) {
                int codePointAt = Character.codePointAt(this.text, this.charIndex);
                this.charIndex += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.charIndex++;
            byte cachedDirectionality = getCachedDirectionality(this.lastChar);
            if (!this.isHtml) {
                return cachedDirectionality;
            }
            char c6 = this.lastChar;
            return c6 == '<' ? skipTagForward() : c6 == '&' ? skipEntityForward() : cachedDirectionality;
        }

        int getExitDir() {
            this.charIndex = this.length;
            int i6 = 0;
            int i7 = 0;
            while (this.charIndex > 0) {
                byte dirTypeBackward = dirTypeBackward();
                if (dirTypeBackward != 0) {
                    if (dirTypeBackward == 1 || dirTypeBackward == 2) {
                        if (i6 == 0) {
                            return 1;
                        }
                        if (i7 == 0) {
                            i7 = i6;
                        }
                    } else if (dirTypeBackward != 9) {
                        switch (dirTypeBackward) {
                            case 14:
                            case 15:
                                if (i7 == i6) {
                                    return -1;
                                }
                                i6--;
                                break;
                            case 16:
                            case 17:
                                if (i7 == i6) {
                                    return 1;
                                }
                                i6--;
                                break;
                            case 18:
                                i6++;
                                break;
                            default:
                                if (i7 != 0) {
                                    break;
                                } else {
                                    i7 = i6;
                                    break;
                                }
                        }
                    } else {
                        continue;
                    }
                } else {
                    if (i6 == 0) {
                        return -1;
                    }
                    if (i7 == 0) {
                        i7 = i6;
                    }
                }
            }
            return 0;
        }

        DirectionalityEstimator(CharSequence charSequence, boolean z5) {
            this.text = charSequence;
            this.isHtml = z5;
            this.length = charSequence.length();
        }
    }

    public static BidiFormatter getInstance() {
        return new Builder().build();
    }

    private String markAfter(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        return (this.mIsRtlContext || !(isRtl || getExitDir(charSequence) == 1)) ? this.mIsRtlContext ? (!isRtl || getExitDir(charSequence) == -1) ? RLM_STRING : "" : "" : LRM_STRING;
    }

    private String markBefore(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        return (this.mIsRtlContext || !(isRtl || getEntryDir(charSequence) == 1)) ? this.mIsRtlContext ? (!isRtl || getEntryDir(charSequence) == -1) ? RLM_STRING : "" : "" : LRM_STRING;
    }

    public boolean isRtl(String str) {
        return isRtl((CharSequence) str);
    }

    public String unicodeWrap(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z5) {
        if (str == null) {
            return null;
        }
        return unicodeWrap((CharSequence) str, textDirectionHeuristicCompat, z5).toString();
    }

    static {
        TextDirectionHeuristicCompat textDirectionHeuristicCompat = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
        DEFAULT_TEXT_DIRECTION_HEURISTIC = textDirectionHeuristicCompat;
        LRM_STRING = Character.toString(LRM);
        RLM_STRING = Character.toString(RLM);
        DEFAULT_LTR_INSTANCE = new BidiFormatter(false, 2, textDirectionHeuristicCompat);
        DEFAULT_RTL_INSTANCE = new BidiFormatter(true, 2, textDirectionHeuristicCompat);
    }

    private static int getEntryDir(CharSequence charSequence) {
        return new DirectionalityEstimator(charSequence, false).getEntryDir();
    }

    private static int getExitDir(CharSequence charSequence) {
        return new DirectionalityEstimator(charSequence, false).getExitDir();
    }

    public static BidiFormatter getInstance(boolean z5) {
        return new Builder(z5).build();
    }

    public boolean getStereoReset() {
        return (this.mFlags & 2) != 0;
    }

    public boolean isRtl(CharSequence charSequence) {
        return this.mDefaultTextDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
    }

    public boolean isRtlContext() {
        return this.mIsRtlContext;
    }

    public CharSequence unicodeWrap(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z5) {
        if (charSequence == null) {
            return null;
        }
        boolean isRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (getStereoReset() && z5) {
            spannableStringBuilder.append((CharSequence) markBefore(charSequence, isRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR));
        }
        if (isRtl != this.mIsRtlContext) {
            spannableStringBuilder.append(isRtl ? RLE : LRE);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append(PDF);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z5) {
            spannableStringBuilder.append((CharSequence) markAfter(charSequence, isRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR));
        }
        return spannableStringBuilder;
    }

    BidiFormatter(boolean z5, int i6, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        this.mIsRtlContext = z5;
        this.mFlags = i6;
        this.mDefaultTextDirectionHeuristicCompat = textDirectionHeuristicCompat;
    }

    public static BidiFormatter getInstance(Locale locale) {
        return new Builder(locale).build();
    }

    static boolean isRtlLocale(Locale locale) {
        if (TextUtilsCompat.getLayoutDirectionFromLocale(locale) == 1) {
            return true;
        }
        return false;
    }

    public String unicodeWrap(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        return unicodeWrap(str, textDirectionHeuristicCompat, true);
    }

    public CharSequence unicodeWrap(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        return unicodeWrap(charSequence, textDirectionHeuristicCompat, true);
    }

    public String unicodeWrap(String str, boolean z5) {
        return unicodeWrap(str, this.mDefaultTextDirectionHeuristicCompat, z5);
    }

    public CharSequence unicodeWrap(CharSequence charSequence, boolean z5) {
        return unicodeWrap(charSequence, this.mDefaultTextDirectionHeuristicCompat, z5);
    }

    public String unicodeWrap(String str) {
        return unicodeWrap(str, this.mDefaultTextDirectionHeuristicCompat, true);
    }

    public CharSequence unicodeWrap(CharSequence charSequence) {
        return unicodeWrap(charSequence, this.mDefaultTextDirectionHeuristicCompat, true);
    }
}
