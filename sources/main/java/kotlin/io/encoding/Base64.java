package kotlin.io.encoding;

import java.nio.charset.Charset;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import okio.Utf8;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "2.2")
@WasExperimental(markerClass = {ExperimentalEncodingApi.class})
/* loaded from: D:\Downloads\app\classes8.dex */
public class Base64 {

    /* renamed from: g, reason: collision with root package name */
    private static final int f43817g = 8;

    /* renamed from: h, reason: collision with root package name */
    private static final int f43818h = 6;

    /* renamed from: i, reason: collision with root package name */
    public static final int f43819i = 3;

    /* renamed from: j, reason: collision with root package name */
    public static final int f43820j = 4;

    /* renamed from: k, reason: collision with root package name */
    public static final byte f43821k = 61;

    /* renamed from: l, reason: collision with root package name */
    private static final int f43822l = 76;

    /* renamed from: m, reason: collision with root package name */
    private static final int f43823m = 64;

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    private static final Base64 f43825o;

    /* renamed from: p, reason: collision with root package name */
    @NotNull
    private static final Base64 f43826p;

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    private static final Base64 f43827q;

    /* renamed from: a, reason: collision with root package name */
    private final boolean f43828a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f43829b;

    /* renamed from: c, reason: collision with root package name */
    private final int f43830c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final PaddingOption f43831d;

    /* renamed from: e, reason: collision with root package name */
    private final int f43832e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final a f43816f = new a(null);

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    private static final byte[] f43824n = {13, 10};

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SinceKotlin(version = "2.0")
    public static final class PaddingOption {
        private static final /* synthetic */ kotlin.enums.a $ENTRIES;
        private static final /* synthetic */ PaddingOption[] $VALUES;
        public static final PaddingOption PRESENT = new PaddingOption("PRESENT", 0);
        public static final PaddingOption ABSENT = new PaddingOption("ABSENT", 1);
        public static final PaddingOption PRESENT_OPTIONAL = new PaddingOption("PRESENT_OPTIONAL", 2);
        public static final PaddingOption ABSENT_OPTIONAL = new PaddingOption("ABSENT_OPTIONAL", 3);

        private static final /* synthetic */ PaddingOption[] $values() {
            return new PaddingOption[]{PRESENT, ABSENT, PRESENT_OPTIONAL, ABSENT_OPTIONAL};
        }

        static {
            PaddingOption[] $values = $values();
            $VALUES = $values;
            $ENTRIES = kotlin.enums.c.c($values);
        }

        @NotNull
        public static kotlin.enums.a<PaddingOption> getEntries() {
            return $ENTRIES;
        }

        public static PaddingOption valueOf(String str) {
            return (PaddingOption) Enum.valueOf(PaddingOption.class, str);
        }

        public static PaddingOption[] values() {
            return (PaddingOption[]) $VALUES.clone();
        }

        private PaddingOption(String str, int i6) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a extends Base64 {
        public /* synthetic */ a(v vVar) {
            this();
        }

        private a() {
            super(false, false, -1, PaddingOption.PRESENT, null);
        }

        @NotNull
        public final Base64 M() {
            return Base64.f43826p;
        }

        @NotNull
        public final byte[] N() {
            return Base64.f43824n;
        }

        @NotNull
        public final Base64 O() {
            return Base64.f43827q;
        }

        @NotNull
        public final Base64 P() {
            return Base64.f43825o;
        }
    }

    public /* synthetic */ Base64(boolean z5, boolean z6, int i6, PaddingOption paddingOption, v vVar) {
        this(z5, z6, i6, paddingOption);
    }

    private final int G(byte[] bArr, int i6, int i7, int i8) {
        if (i8 == -8) {
            throw new IllegalArgumentException("Redundant pad character at index " + i6);
        }
        if (i8 == -6) {
            h(i6);
            return i6 + 1;
        }
        if (i8 != -4) {
            if (i8 == -2) {
                return i6 + 1;
            }
            throw new IllegalStateException("Unreachable");
        }
        h(i6);
        int K = K(bArr, i6 + 1, i7);
        if (K != i7 && bArr[K] == 61) {
            return K + 1;
        }
        throw new IllegalArgumentException("Missing one pad character at index " + K);
    }

    static {
        PaddingOption paddingOption = PaddingOption.PRESENT;
        f43825o = new Base64(true, false, -1, paddingOption);
        f43826p = new Base64(false, true, 76, paddingOption);
        f43827q = new Base64(false, true, 64, paddingOption);
    }

    private Base64(boolean z5, boolean z6, int i6, PaddingOption paddingOption) {
        this.f43828a = z5;
        this.f43829b = z6;
        this.f43830c = i6;
        this.f43831d = paddingOption;
        if (z5 && z6) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        this.f43832e = i6 / 4;
    }

    public static /* synthetic */ Appendable A(Base64 base64, byte[] bArr, Appendable appendable, int i6, int i7, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeToAppendable");
        }
        if ((i8 & 4) != 0) {
            i6 = 0;
        }
        if ((i8 & 8) != 0) {
            i7 = bArr.length;
        }
        return base64.z(bArr, appendable, i6, i7);
    }

    public static /* synthetic */ byte[] C(Base64 base64, byte[] bArr, int i6, int i7, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeToByteArray");
        }
        if ((i8 & 2) != 0) {
            i6 = 0;
        }
        if ((i8 & 4) != 0) {
            i7 = bArr.length;
        }
        return base64.B(bArr, i6, i7);
    }

    private final boolean J() {
        PaddingOption paddingOption = this.f43831d;
        return paddingOption == PaddingOption.PRESENT || paddingOption == PaddingOption.PRESENT_OPTIONAL;
    }

    private final int K(byte[] bArr, int i6, int i7) {
        int[] iArr;
        if (!this.f43829b) {
            return i6;
        }
        while (i6 < i7) {
            int i8 = bArr[i6] & 255;
            iArr = b.f43834b;
            if (iArr[i8] != -1) {
                break;
            }
            i6++;
        }
        return i6;
    }

    private final void g(int i6, int i7, int i8) {
        if (i7 < 0 || i7 > i6) {
            throw new IndexOutOfBoundsException("destination offset: " + i7 + ", destination size: " + i6);
        }
        int i9 = i7 + i8;
        if (i9 < 0 || i9 > i6) {
            throw new IndexOutOfBoundsException("The destination array does not have enough capacity, destination offset: " + i7 + ", destination size: " + i6 + ", capacity needed: " + i8);
        }
    }

    private final void h(int i6) {
        if (this.f43831d != PaddingOption.ABSENT) {
            return;
        }
        throw new IllegalArgumentException("The padding option is set to ABSENT, but the input has a pad character at index " + i6);
    }

    public static /* synthetic */ byte[] l(Base64 base64, CharSequence charSequence, int i6, int i7, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decode");
        }
        if ((i8 & 2) != 0) {
            i6 = 0;
        }
        if ((i8 & 4) != 0) {
            i7 = charSequence.length();
        }
        return base64.j(charSequence, i6, i7);
    }

    public static /* synthetic */ byte[] m(Base64 base64, byte[] bArr, int i6, int i7, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decode");
        }
        if ((i8 & 2) != 0) {
            i6 = 0;
        }
        if ((i8 & 4) != 0) {
            i7 = bArr.length;
        }
        return base64.k(bArr, i6, i7);
    }

    private final int n(byte[] bArr, byte[] bArr2, int i6, int i7, int i8) {
        int i9;
        boolean z5;
        int i10;
        int[] iArr = this.f43828a ? b.f43836d : b.f43834b;
        int i11 = -8;
        int i12 = i6;
        int i13 = i7;
        int i14 = -8;
        int i15 = 0;
        while (true) {
            if (i13 >= i8) {
                i9 = 8;
                z5 = false;
                break;
            }
            if (i14 != i11 || i13 + 3 >= i8) {
                i9 = 8;
                i10 = 1;
            } else {
                i9 = 8;
                i10 = 1;
                int i16 = i13 + 4;
                int i17 = (iArr[bArr[i13 + 1] & 255] << 12) | (iArr[bArr[i13] & 255] << 18) | (iArr[bArr[i13 + 2] & 255] << 6) | iArr[bArr[i13 + 3] & 255];
                if (i17 >= 0) {
                    bArr2[i12] = (byte) (i17 >> 16);
                    int i18 = i12 + 2;
                    bArr2[i12 + 1] = (byte) (i17 >> 8);
                    i12 += 3;
                    bArr2[i18] = (byte) i17;
                    i13 = i16;
                    i11 = -8;
                }
            }
            int i19 = bArr[i13] & 255;
            int i20 = iArr[i19];
            if (i20 >= 0) {
                i13++;
                i15 = (i15 << 6) | i20;
                int i21 = i14 + 6;
                if (i21 >= 0) {
                    bArr2[i12] = (byte) (i15 >>> i21);
                    i15 &= (i10 << i21) - 1;
                    i14 -= 2;
                    i12++;
                } else {
                    i14 = i21;
                }
            } else {
                if (i20 == -2) {
                    i13 = G(bArr, i13, i8, i14);
                    z5 = true;
                    break;
                }
                if (!this.f43829b) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Invalid symbol '");
                    sb.append((char) i19);
                    sb.append("'(");
                    String num = Integer.toString(i19, kotlin.text.b.a(i9));
                    g0.o(num, "toString(...)");
                    sb.append(num);
                    sb.append(") at index ");
                    sb.append(i13);
                    throw new IllegalArgumentException(sb.toString());
                }
                i13++;
            }
            i11 = -8;
        }
        if (i14 == -2) {
            throw new IllegalArgumentException("The last unit of input does not have enough bits");
        }
        if (i14 != -8 && !z5 && this.f43831d == PaddingOption.PRESENT) {
            throw new IllegalArgumentException("The padding option is set to PRESENT, but the input is not properly padded");
        }
        if (i15 != 0) {
            throw new IllegalArgumentException("The pad bits must be zeros");
        }
        int K = K(bArr, i13, i8);
        if (K >= i8) {
            return i12 - i6;
        }
        int i22 = bArr[K] & 255;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Symbol '");
        sb2.append((char) i22);
        sb2.append("'(");
        String num2 = Integer.toString(i22, kotlin.text.b.a(i9));
        g0.o(num2, "toString(...)");
        sb2.append(num2);
        sb2.append(") at index ");
        sb2.append(K - 1);
        sb2.append(" is prohibited after the pad character");
        throw new IllegalArgumentException(sb2.toString());
    }

    public static /* synthetic */ int q(Base64 base64, CharSequence charSequence, byte[] bArr, int i6, int i7, int i8, int i9, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeIntoByteArray");
        }
        if ((i9 & 4) != 0) {
            i6 = 0;
        }
        if ((i9 & 8) != 0) {
            i7 = 0;
        }
        if ((i9 & 16) != 0) {
            i8 = charSequence.length();
        }
        return base64.o(charSequence, bArr, i6, i7, i8);
    }

    public static /* synthetic */ int r(Base64 base64, byte[] bArr, byte[] bArr2, int i6, int i7, int i8, int i9, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeIntoByteArray");
        }
        if ((i9 & 4) != 0) {
            i6 = 0;
        }
        if ((i9 & 8) != 0) {
            i7 = 0;
        }
        if ((i9 & 16) != 0) {
            i8 = bArr.length;
        }
        return base64.p(bArr, bArr2, i6, i7, i8);
    }

    public static /* synthetic */ String u(Base64 base64, byte[] bArr, int i6, int i7, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encode");
        }
        if ((i8 & 2) != 0) {
            i6 = 0;
        }
        if ((i8 & 4) != 0) {
            i7 = bArr.length;
        }
        return base64.t(bArr, i6, i7);
    }

    public static /* synthetic */ int w(Base64 base64, byte[] bArr, byte[] bArr2, int i6, int i7, int i8, int i9, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeIntoByteArray");
        }
        if ((i9 & 4) != 0) {
            i6 = 0;
        }
        if ((i9 & 8) != 0) {
            i7 = 0;
        }
        if ((i9 & 16) != 0) {
            i8 = bArr.length;
        }
        return base64.v(bArr, bArr2, i6, i7, i8);
    }

    @NotNull
    public final byte[] B(@NotNull byte[] source, int i6, int i7) {
        g0.p(source, "source");
        return D(source, i6, i7);
    }

    @NotNull
    public final byte[] D(@NotNull byte[] source, int i6, int i7) {
        g0.p(source, "source");
        i(source.length, i6, i7);
        byte[] bArr = new byte[y(i7 - i6)];
        x(source, bArr, 0, i6, i7);
        return bArr;
    }

    public final int E() {
        return this.f43830c;
    }

    @NotNull
    public final PaddingOption F() {
        return this.f43831d;
    }

    public final boolean H() {
        return this.f43829b;
    }

    public final boolean I() {
        return this.f43828a;
    }

    @SinceKotlin(version = "2.0")
    @NotNull
    public final Base64 L(@NotNull PaddingOption option) {
        g0.p(option, "option");
        return this.f43831d == option ? this : new Base64(this.f43828a, this.f43829b, this.f43830c, option);
    }

    @NotNull
    public final String e(@NotNull byte[] source) {
        g0.p(source, "source");
        StringBuilder sb = new StringBuilder(source.length);
        for (byte b6 : source) {
            sb.append((char) b6);
        }
        return sb.toString();
    }

    @NotNull
    public final byte[] f(@NotNull CharSequence source, int i6, int i7) {
        g0.p(source, "source");
        i(source.length(), i6, i7);
        byte[] bArr = new byte[i7 - i6];
        int i8 = 0;
        while (i6 < i7) {
            char charAt = source.charAt(i6);
            if (charAt <= 255) {
                bArr[i8] = (byte) charAt;
                i8++;
            } else {
                bArr[i8] = Utf8.REPLACEMENT_BYTE;
                i8++;
            }
            i6++;
        }
        return bArr;
    }

    public final void i(int i6, int i7, int i8) {
        kotlin.collections.d.Companion.a(i7, i8, i6);
    }

    @NotNull
    public final byte[] j(@NotNull CharSequence source, int i6, int i7) {
        byte[] f6;
        g0.p(source, "source");
        if (source instanceof String) {
            String str = (String) source;
            i(str.length(), i6, i7);
            String substring = str.substring(i6, i7);
            g0.o(substring, "substring(...)");
            Charset charset = kotlin.text.e.f47856g;
            g0.n(substring, "null cannot be cast to non-null type java.lang.String");
            f6 = substring.getBytes(charset);
            g0.o(f6, "getBytes(...)");
        } else {
            f6 = f(source, i6, i7);
        }
        return m(this, f6, 0, 0, 6, null);
    }

    @NotNull
    public final byte[] k(@NotNull byte[] source, int i6, int i7) {
        g0.p(source, "source");
        i(source.length, i6, i7);
        int s5 = s(source, i6, i7);
        byte[] bArr = new byte[s5];
        if (n(source, bArr, 0, i6, i7) == s5) {
            return bArr;
        }
        throw new IllegalStateException("Check failed.");
    }

    public final int o(@NotNull CharSequence source, @NotNull byte[] destination, int i6, int i7, int i8) {
        byte[] f6;
        g0.p(source, "source");
        g0.p(destination, "destination");
        if (source instanceof String) {
            String str = (String) source;
            i(str.length(), i7, i8);
            String substring = str.substring(i7, i8);
            g0.o(substring, "substring(...)");
            Charset charset = kotlin.text.e.f47856g;
            g0.n(substring, "null cannot be cast to non-null type java.lang.String");
            f6 = substring.getBytes(charset);
            g0.o(f6, "getBytes(...)");
        } else {
            f6 = f(source, i7, i8);
        }
        return r(this, f6, destination, i6, 0, 0, 24, null);
    }

    public final int p(@NotNull byte[] source, @NotNull byte[] destination, int i6, int i7, int i8) {
        g0.p(source, "source");
        g0.p(destination, "destination");
        i(source.length, i7, i8);
        g(destination.length, i6, s(source, i7, i8));
        return n(source, destination, i6, i7, i8);
    }

    public final int s(@NotNull byte[] source, int i6, int i7) {
        int[] iArr;
        g0.p(source, "source");
        int i8 = i7 - i6;
        if (i8 == 0) {
            return 0;
        }
        if (i8 == 1) {
            throw new IllegalArgumentException("Input should have at least 2 symbols for Base64 decoding, startIndex: " + i6 + ", endIndex: " + i7);
        }
        if (this.f43829b) {
            while (true) {
                if (i6 >= i7) {
                    break;
                }
                int i9 = source[i6] & 255;
                iArr = b.f43834b;
                int i10 = iArr[i9];
                if (i10 < 0) {
                    if (i10 == -2) {
                        i8 -= i7 - i6;
                        break;
                    }
                    i8--;
                }
                i6++;
            }
        } else if (source[i7 - 1] == 61) {
            i8 = source[i7 + (-2)] == 61 ? i8 - 2 : i8 - 1;
        }
        return (int) ((i8 * 6) / 8);
    }

    @NotNull
    public final String t(@NotNull byte[] source, int i6, int i7) {
        g0.p(source, "source");
        return new String(D(source, i6, i7), kotlin.text.e.f47856g);
    }

    public final int v(@NotNull byte[] source, @NotNull byte[] destination, int i6, int i7, int i8) {
        g0.p(source, "source");
        g0.p(destination, "destination");
        return x(source, destination, i6, i7, i8);
    }

    public final int x(@NotNull byte[] source, @NotNull byte[] destination, int i6, int i7, int i8) {
        int i9 = i7;
        g0.p(source, "source");
        g0.p(destination, "destination");
        i(source.length, i9, i8);
        g(destination.length, i6, y(i8 - i9));
        byte[] bArr = this.f43828a ? b.f43835c : b.f43833a;
        int i10 = this.f43829b ? this.f43832e : Integer.MAX_VALUE;
        int i11 = i6;
        while (i9 + 2 < i8) {
            int min = Math.min((i8 - i9) / 3, i10);
            for (int i12 = 0; i12 < min; i12++) {
                int i13 = source[i9] & 255;
                int i14 = i9 + 2;
                int i15 = source[i9 + 1] & 255;
                i9 += 3;
                int i16 = (i15 << 8) | (i13 << 16) | (source[i14] & 255);
                destination[i11] = bArr[i16 >>> 18];
                destination[i11 + 1] = bArr[(i16 >>> 12) & 63];
                int i17 = i11 + 3;
                destination[i11 + 2] = bArr[(i16 >>> 6) & 63];
                i11 += 4;
                destination[i17] = bArr[i16 & 63];
            }
            if (min == i10 && i9 != i8) {
                int i18 = i11 + 1;
                byte[] bArr2 = f43824n;
                destination[i11] = bArr2[0];
                i11 += 2;
                destination[i18] = bArr2[1];
            }
        }
        int i19 = i8 - i9;
        if (i19 == 1) {
            int i20 = i9 + 1;
            int i21 = (source[i9] & 255) << 4;
            destination[i11] = bArr[i21 >>> 6];
            int i22 = i11 + 2;
            destination[i11 + 1] = bArr[i21 & 63];
            if (J()) {
                int i23 = i11 + 3;
                destination[i22] = 61;
                i11 += 4;
                destination[i23] = 61;
                i9 = i20;
            } else {
                i9 = i20;
                i11 = i22;
            }
        } else if (i19 == 2) {
            int i24 = i9 + 1;
            int i25 = source[i9] & 255;
            i9 += 2;
            int i26 = ((source[i24] & 255) << 2) | (i25 << 10);
            destination[i11] = bArr[i26 >>> 12];
            destination[i11 + 1] = bArr[(i26 >>> 6) & 63];
            int i27 = i11 + 3;
            destination[i11 + 2] = bArr[i26 & 63];
            if (J()) {
                i11 += 4;
                destination[i27] = 61;
            } else {
                i11 = i27;
            }
        }
        if (i9 == i8) {
            return i11 - i6;
        }
        throw new IllegalStateException("Check failed.");
    }

    public final int y(int i6) {
        int i7 = i6 / 3;
        int i8 = i6 % 3;
        int i9 = i7 * 4;
        if (i8 != 0) {
            i9 += J() ? 4 : i8 + 1;
        }
        if (i9 < 0) {
            throw new IllegalArgumentException("Input is too big");
        }
        if (this.f43829b) {
            i9 += ((i9 - 1) / this.f43830c) * 2;
        }
        if (i9 >= 0) {
            return i9;
        }
        throw new IllegalArgumentException("Input is too big");
    }

    @NotNull
    public final <A extends Appendable> A z(@NotNull byte[] source, @NotNull A destination, int i6, int i7) {
        g0.p(source, "source");
        g0.p(destination, "destination");
        destination.append(new String(D(source, i6, i7), kotlin.text.e.f47856g));
        return destination;
    }
}
