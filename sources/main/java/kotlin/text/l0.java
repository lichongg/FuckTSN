package kotlin.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nStrings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Strings.kt\nkotlin/text/StringsKt__StringsKt\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1580:1\n78#1,22:1581\n112#1,5:1603\n129#1,5:1608\n78#1,22:1613\n106#1:1635\n78#1,22:1636\n112#1,5:1658\n123#1:1663\n112#1,5:1664\n129#1,5:1669\n140#1:1674\n129#1,5:1675\n78#1,22:1680\n112#1,5:1702\n129#1,5:1707\n1069#2,2:1712\n13050#3,2:1714\n13050#3,2:1716\n295#4,2:1718\n295#4,2:1720\n1563#4:1723\n1634#4,3:1724\n1563#4:1727\n1634#4,3:1728\n1#5:1722\n*S KotlinDebug\n*F\n+ 1 Strings.kt\nkotlin/text/StringsKt__StringsKt\n*L\n106#1:1581,22\n123#1:1603,5\n140#1:1608,5\n145#1:1613,22\n150#1:1635\n150#1:1636,22\n155#1:1658,5\n160#1:1663\n160#1:1664,5\n165#1:1669,5\n170#1:1674\n170#1:1675,5\n175#1:1680,22\n186#1:1702,5\n197#1:1707,5\n310#1:1712,2\n967#1:1714,2\n991#1:1716,2\n1030#1:1718,2\n1036#1:1720,2\n1401#1:1723\n1401#1:1724,3\n1427#1:1727\n1427#1:1728,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public class l0 extends g0 {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a extends kotlin.collections.e0 {

        /* renamed from: a, reason: collision with root package name */
        private int f47930a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CharSequence f47931b;

        a(CharSequence charSequence) {
            this.f47931b = charSequence;
        }

        @Override // kotlin.collections.e0
        public char c() {
            CharSequence charSequence = this.f47931b;
            int i6 = this.f47930a;
            this.f47930a = i6 + 1;
            return charSequence.charAt(i6);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f47930a < this.f47931b.length();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 Strings.kt\nkotlin/text/StringsKt__StringsKt\n*L\n1#1,731:1\n1487#2:732\n*E\n"})
    public static final class b implements kotlin.sequences.m<String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CharSequence f47932a;

        public b(CharSequence charSequence) {
            this.f47932a = charSequence;
        }

        @Override // kotlin.sequences.m
        public Iterator<String> iterator() {
            return new l(this.f47932a);
        }
    }

    private static final int E3(CharSequence charSequence, CharSequence charSequence2, int i6, int i7, boolean z5, boolean z6) {
        kotlin.ranges.k mVar = !z6 ? new kotlin.ranges.m(kotlin.ranges.t.u(i6, 0), kotlin.ranges.t.B(i7, charSequence.length())) : kotlin.ranges.t.k0(kotlin.ranges.t.B(i6, y3(charSequence)), kotlin.ranges.t.u(i7, 0));
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int e6 = mVar.e();
            int f6 = mVar.f();
            int g6 = mVar.g();
            if ((g6 <= 0 || e6 > f6) && (g6 >= 0 || f6 > e6)) {
                return -1;
            }
            int i8 = e6;
            while (true) {
                String str = (String) charSequence2;
                boolean z7 = z5;
                if (g0.q2(str, 0, (String) charSequence, i8, str.length(), z7)) {
                    return i8;
                }
                if (i8 == f6) {
                    return -1;
                }
                i8 += g6;
                z5 = z7;
            }
        } else {
            boolean z8 = z5;
            int e7 = mVar.e();
            int f7 = mVar.f();
            int g7 = mVar.g();
            if ((g7 <= 0 || e7 > f7) && (g7 >= 0 || f7 > e7)) {
                return -1;
            }
            int i9 = e7;
            while (true) {
                boolean z9 = z8;
                CharSequence charSequence3 = charSequence;
                CharSequence charSequence4 = charSequence2;
                z8 = z9;
                if (t4(charSequence4, 0, charSequence3, i9, charSequence2.length(), z9)) {
                    return i9;
                }
                if (i9 == f7) {
                    return -1;
                }
                i9 += g7;
                charSequence2 = charSequence4;
                charSequence = charSequence3;
            }
        }
    }

    private static final Pair<Integer, String> t3(CharSequence charSequence, Collection<String> collection, int i6, boolean z5, boolean z6) {
        CharSequence charSequence2;
        Object obj;
        boolean z7;
        Object obj2;
        if (!z5 && collection.size() == 1) {
            String str = (String) kotlin.collections.f0.k5(collection);
            int H3 = !z6 ? H3(charSequence, str, i6, false, 4, null) : W3(charSequence, str, i6, false, 4, null);
            if (H3 < 0) {
                return null;
            }
            return kotlin.o0.a(Integer.valueOf(H3), str);
        }
        CharSequence charSequence3 = charSequence;
        kotlin.ranges.k mVar = !z6 ? new kotlin.ranges.m(kotlin.ranges.t.u(i6, 0), charSequence3.length()) : kotlin.ranges.t.k0(kotlin.ranges.t.B(i6, y3(charSequence3)), 0);
        if (charSequence3 instanceof String) {
            int e6 = mVar.e();
            int f6 = mVar.f();
            int g6 = mVar.g();
            if ((g6 > 0 && e6 <= f6) || (g6 < 0 && f6 <= e6)) {
                int i7 = e6;
                while (true) {
                    Iterator<T> it = collection.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z7 = z5;
                            obj2 = null;
                            break;
                        }
                        obj2 = it.next();
                        String str2 = (String) obj2;
                        z7 = z5;
                        if (g0.q2(str2, 0, (String) charSequence3, i7, str2.length(), z7)) {
                            break;
                        }
                        z5 = z7;
                    }
                    String str3 = (String) obj2;
                    if (str3 == null) {
                        if (i7 == f6) {
                            break;
                        }
                        i7 += g6;
                        z5 = z7;
                    } else {
                        return kotlin.o0.a(Integer.valueOf(i7), str3);
                    }
                }
            }
        } else {
            boolean z8 = z5;
            int e7 = mVar.e();
            int f7 = mVar.f();
            int g7 = mVar.g();
            if ((g7 > 0 && e7 <= f7) || (g7 < 0 && f7 <= e7)) {
                int i8 = e7;
                while (true) {
                    Iterator<T> it2 = collection.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            charSequence2 = charSequence3;
                            obj = null;
                            break;
                        }
                        obj = it2.next();
                        String str4 = (String) obj;
                        boolean z9 = z8;
                        charSequence2 = charSequence3;
                        z8 = z9;
                        if (t4(str4, 0, charSequence2, i8, str4.length(), z9)) {
                            break;
                        }
                        charSequence3 = charSequence2;
                    }
                    String str5 = (String) obj;
                    if (str5 == null) {
                        if (i8 == f7) {
                            break;
                        }
                        i8 += g7;
                        charSequence3 = charSequence2;
                    } else {
                        return kotlin.o0.a(Integer.valueOf(i8), str5);
                    }
                }
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <C extends CharSequence & R, R> R A3(C c6, Function0<? extends R> defaultValue) {
        kotlin.jvm.internal.g0.p(defaultValue, "defaultValue");
        return M3(c6) ? defaultValue.invoke() : c6;
    }

    @NotNull
    public static final CharSequence A4(@NotNull CharSequence charSequence, @NotNull CharSequence suffix) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(suffix, "suffix");
        return r3(charSequence, suffix, false, 2, null) ? charSequence.subSequence(0, charSequence.length() - suffix.length()) : charSequence.subSequence(0, charSequence.length());
    }

    public static /* synthetic */ boolean A5(CharSequence charSequence, CharSequence charSequence2, boolean z5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        return x5(charSequence, charSequence2, z5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <C extends CharSequence & R, R> R B3(C c6, Function0<? extends R> defaultValue) {
        kotlin.jvm.internal.g0.p(defaultValue, "defaultValue");
        return c6.length() == 0 ? defaultValue.invoke() : c6;
    }

    @NotNull
    public static String B4(@NotNull String str, @NotNull CharSequence suffix) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(suffix, "suffix");
        if (!r3(str, suffix, false, 2, null)) {
            return str;
        }
        String substring = str.substring(0, str.length() - suffix.length());
        kotlin.jvm.internal.g0.o(substring, "substring(...)");
        return substring;
    }

    @NotNull
    public static final CharSequence B5(@NotNull CharSequence charSequence, @NotNull kotlin.ranges.m range) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(range, "range");
        return charSequence.subSequence(range.getStart().intValue(), range.getEndInclusive().intValue() + 1);
    }

    public static final int C3(@NotNull CharSequence charSequence, char c6, int i6, boolean z5) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        return (z5 || !(charSequence instanceof String)) ? J3(charSequence, new char[]{c6}, i6, z5) : ((String) charSequence).indexOf(c6, i6);
    }

    @NotNull
    public static final CharSequence C4(@NotNull CharSequence charSequence, @NotNull CharSequence delimiter) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(delimiter, "delimiter");
        return D4(charSequence, delimiter, delimiter);
    }

    @Deprecated(message = "Use parameters named startIndex and endIndex.", replaceWith = @ReplaceWith(expression = "subSequence(startIndex = start, endIndex = end)", imports = {}))
    @InlineOnly
    private static final CharSequence C5(String str, int i6, int i7) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        return str.subSequence(i6, i7);
    }

    public static final int D3(@NotNull CharSequence charSequence, @NotNull String string, int i6, boolean z5) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(string, "string");
        return (z5 || !(charSequence instanceof String)) ? F3(charSequence, string, i6, charSequence.length(), z5, false, 16, null) : ((String) charSequence).indexOf(string, i6);
    }

    @NotNull
    public static final CharSequence D4(@NotNull CharSequence charSequence, @NotNull CharSequence prefix, @NotNull CharSequence suffix) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(prefix, "prefix");
        kotlin.jvm.internal.g0.p(suffix, "suffix");
        return (charSequence.length() >= prefix.length() + suffix.length() && A5(charSequence, prefix, false, 2, null) && r3(charSequence, suffix, false, 2, null)) ? charSequence.subSequence(prefix.length(), charSequence.length() - suffix.length()) : charSequence.subSequence(0, charSequence.length());
    }

    @InlineOnly
    private static final String D5(CharSequence charSequence, int i6, int i7) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        return charSequence.subSequence(i6, i7).toString();
    }

    @NotNull
    public static String E4(@NotNull String str, @NotNull CharSequence delimiter) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(delimiter, "delimiter");
        return F4(str, delimiter, delimiter);
    }

    @NotNull
    public static final String E5(@NotNull CharSequence charSequence, @NotNull kotlin.ranges.m range) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(range, "range");
        return charSequence.subSequence(range.getStart().intValue(), range.getEndInclusive().intValue() + 1).toString();
    }

    static /* synthetic */ int F3(CharSequence charSequence, CharSequence charSequence2, int i6, int i7, boolean z5, boolean z6, int i8, Object obj) {
        return E3(charSequence, charSequence2, i6, i7, z5, (i8 & 16) != 0 ? false : z6);
    }

    @NotNull
    public static final String F4(@NotNull String str, @NotNull CharSequence prefix, @NotNull CharSequence suffix) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(prefix, "prefix");
        kotlin.jvm.internal.g0.p(suffix, "suffix");
        if (str.length() < prefix.length() + suffix.length() || !A5(str, prefix, false, 2, null) || !r3(str, suffix, false, 2, null)) {
            return str;
        }
        String substring = str.substring(prefix.length(), str.length() - suffix.length());
        kotlin.jvm.internal.g0.o(substring, "substring(...)");
        return substring;
    }

    @NotNull
    public static final String F5(@NotNull String str, @NotNull kotlin.ranges.m range) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(range, "range");
        String substring = str.substring(range.getStart().intValue(), range.getEndInclusive().intValue() + 1);
        kotlin.jvm.internal.g0.o(substring, "substring(...)");
        return substring;
    }

    public static /* synthetic */ int G3(CharSequence charSequence, char c6, int i6, boolean z5, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i6 = 0;
        }
        if ((i7 & 4) != 0) {
            z5 = false;
        }
        return C3(charSequence, c6, i6, z5);
    }

    @InlineOnly
    private static final String G4(CharSequence charSequence, Regex regex, String replacement) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(regex, "regex");
        kotlin.jvm.internal.g0.p(replacement, "replacement");
        return regex.replace(charSequence, replacement);
    }

    static /* synthetic */ String G5(CharSequence charSequence, int i6, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i7 = charSequence.length();
        }
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        return charSequence.subSequence(i6, i7).toString();
    }

    public static /* synthetic */ int H3(CharSequence charSequence, String str, int i6, boolean z5, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i6 = 0;
        }
        if ((i7 & 4) != 0) {
            z5 = false;
        }
        return D3(charSequence, str, i6, z5);
    }

    @InlineOnly
    private static final String H4(CharSequence charSequence, Regex regex, Function1<? super p, ? extends CharSequence> transform) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(regex, "regex");
        kotlin.jvm.internal.g0.p(transform, "transform");
        return regex.replace(charSequence, transform);
    }

    @NotNull
    public static final String H5(@NotNull String str, char c6, @NotNull String missingDelimiterValue) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(missingDelimiterValue, "missingDelimiterValue");
        int G3 = G3(str, c6, 0, false, 6, null);
        if (G3 == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(G3 + 1, str.length());
        kotlin.jvm.internal.g0.o(substring, "substring(...)");
        return substring;
    }

    public static final int I3(@NotNull CharSequence charSequence, @NotNull Collection<String> strings, int i6, boolean z5) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(strings, "strings");
        Pair<Integer, String> t32 = t3(charSequence, strings, i6, z5, false);
        if (t32 != null) {
            return t32.getFirst().intValue();
        }
        return -1;
    }

    @NotNull
    public static final String I4(@NotNull String str, char c6, @NotNull String replacement, @NotNull String missingDelimiterValue) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(replacement, "replacement");
        kotlin.jvm.internal.g0.p(missingDelimiterValue, "missingDelimiterValue");
        int G3 = G3(str, c6, 0, false, 6, null);
        return G3 == -1 ? missingDelimiterValue : b5(str, G3 + 1, str.length(), replacement).toString();
    }

    @NotNull
    public static final String I5(@NotNull String str, @NotNull String delimiter, @NotNull String missingDelimiterValue) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(delimiter, "delimiter");
        kotlin.jvm.internal.g0.p(missingDelimiterValue, "missingDelimiterValue");
        int H3 = H3(str, delimiter, 0, false, 6, null);
        if (H3 == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(H3 + delimiter.length(), str.length());
        kotlin.jvm.internal.g0.o(substring, "substring(...)");
        return substring;
    }

    public static final int J3(@NotNull CharSequence charSequence, @NotNull char[] chars, int i6, boolean z5) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(chars, "chars");
        if (!z5 && chars.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(kotlin.collections.n.qt(chars), i6);
        }
        int u5 = kotlin.ranges.t.u(i6, 0);
        int y32 = y3(charSequence);
        if (u5 > y32) {
            return -1;
        }
        while (true) {
            char charAt = charSequence.charAt(u5);
            for (char c6 : chars) {
                if (d.J(c6, charAt, z5)) {
                    return u5;
                }
            }
            if (u5 == y32) {
                return -1;
            }
            u5++;
        }
    }

    @NotNull
    public static final String J4(@NotNull String str, @NotNull String delimiter, @NotNull String replacement, @NotNull String missingDelimiterValue) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(delimiter, "delimiter");
        kotlin.jvm.internal.g0.p(replacement, "replacement");
        kotlin.jvm.internal.g0.p(missingDelimiterValue, "missingDelimiterValue");
        int H3 = H3(str, delimiter, 0, false, 6, null);
        return H3 == -1 ? missingDelimiterValue : b5(str, H3 + delimiter.length(), str.length(), replacement).toString();
    }

    public static /* synthetic */ String J5(String str, char c6, String str2, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            str2 = str;
        }
        return H5(str, c6, str2);
    }

    public static /* synthetic */ int K3(CharSequence charSequence, Collection collection, int i6, boolean z5, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i6 = 0;
        }
        if ((i7 & 4) != 0) {
            z5 = false;
        }
        return I3(charSequence, collection, i6, z5);
    }

    public static /* synthetic */ String K4(String str, char c6, String str2, String str3, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            str3 = str;
        }
        return I4(str, c6, str2, str3);
    }

    public static /* synthetic */ String K5(String str, String str2, String str3, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            str3 = str;
        }
        return I5(str, str2, str3);
    }

    public static /* synthetic */ int L3(CharSequence charSequence, char[] cArr, int i6, boolean z5, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i6 = 0;
        }
        if ((i7 & 4) != 0) {
            z5 = false;
        }
        return J3(charSequence, cArr, i6, z5);
    }

    public static /* synthetic */ String L4(String str, String str2, String str3, String str4, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            str4 = str;
        }
        return J4(str, str2, str3, str4);
    }

    @NotNull
    public static String L5(@NotNull String str, char c6, @NotNull String missingDelimiterValue) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(missingDelimiterValue, "missingDelimiterValue");
        int V3 = V3(str, c6, 0, false, 6, null);
        if (V3 == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(V3 + 1, str.length());
        kotlin.jvm.internal.g0.o(substring, "substring(...)");
        return substring;
    }

    public static boolean M3(@NotNull CharSequence charSequence) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        for (int i6 = 0; i6 < charSequence.length(); i6++) {
            if (!c.r(charSequence.charAt(i6))) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public static final String M4(@NotNull String str, char c6, @NotNull String replacement, @NotNull String missingDelimiterValue) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(replacement, "replacement");
        kotlin.jvm.internal.g0.p(missingDelimiterValue, "missingDelimiterValue");
        int V3 = V3(str, c6, 0, false, 6, null);
        return V3 == -1 ? missingDelimiterValue : b5(str, V3 + 1, str.length(), replacement).toString();
    }

    @NotNull
    public static final String M5(@NotNull String str, @NotNull String delimiter, @NotNull String missingDelimiterValue) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(delimiter, "delimiter");
        kotlin.jvm.internal.g0.p(missingDelimiterValue, "missingDelimiterValue");
        int W3 = W3(str, delimiter, 0, false, 6, null);
        if (W3 == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(W3 + delimiter.length(), str.length());
        kotlin.jvm.internal.g0.o(substring, "substring(...)");
        return substring;
    }

    @InlineOnly
    private static final boolean N3(CharSequence charSequence) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        return charSequence.length() == 0;
    }

    @NotNull
    public static final String N4(@NotNull String str, @NotNull String delimiter, @NotNull String replacement, @NotNull String missingDelimiterValue) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(delimiter, "delimiter");
        kotlin.jvm.internal.g0.p(replacement, "replacement");
        kotlin.jvm.internal.g0.p(missingDelimiterValue, "missingDelimiterValue");
        int W3 = W3(str, delimiter, 0, false, 6, null);
        return W3 == -1 ? missingDelimiterValue : b5(str, W3 + delimiter.length(), str.length(), replacement).toString();
    }

    public static /* synthetic */ String N5(String str, char c6, String str2, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            str2 = str;
        }
        return L5(str, c6, str2);
    }

    @InlineOnly
    private static final boolean O3(CharSequence charSequence) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        return !M3(charSequence);
    }

    public static /* synthetic */ String O4(String str, char c6, String str2, String str3, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            str3 = str;
        }
        return M4(str, c6, str2, str3);
    }

    public static /* synthetic */ String O5(String str, String str2, String str3, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            str3 = str;
        }
        return M5(str, str2, str3);
    }

    @InlineOnly
    private static final boolean P3(CharSequence charSequence) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        return charSequence.length() > 0;
    }

    public static /* synthetic */ String P4(String str, String str2, String str3, String str4, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            str4 = str;
        }
        return N4(str, str2, str3, str4);
    }

    @NotNull
    public static final String P5(@NotNull String str, char c6, @NotNull String missingDelimiterValue) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(missingDelimiterValue, "missingDelimiterValue");
        int G3 = G3(str, c6, 0, false, 6, null);
        if (G3 == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(0, G3);
        kotlin.jvm.internal.g0.o(substring, "substring(...)");
        return substring;
    }

    @InlineOnly
    private static final boolean Q3(CharSequence charSequence) {
        return charSequence == null || M3(charSequence);
    }

    @NotNull
    public static final String Q4(@NotNull String str, char c6, @NotNull String replacement, @NotNull String missingDelimiterValue) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(replacement, "replacement");
        kotlin.jvm.internal.g0.p(missingDelimiterValue, "missingDelimiterValue");
        int G3 = G3(str, c6, 0, false, 6, null);
        return G3 == -1 ? missingDelimiterValue : b5(str, 0, G3, replacement).toString();
    }

    @NotNull
    public static final String Q5(@NotNull String str, @NotNull String delimiter, @NotNull String missingDelimiterValue) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(delimiter, "delimiter");
        kotlin.jvm.internal.g0.p(missingDelimiterValue, "missingDelimiterValue");
        int H3 = H3(str, delimiter, 0, false, 6, null);
        if (H3 == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(0, H3);
        kotlin.jvm.internal.g0.o(substring, "substring(...)");
        return substring;
    }

    @InlineOnly
    private static final boolean R3(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    @NotNull
    public static final String R4(@NotNull String str, @NotNull String delimiter, @NotNull String replacement, @NotNull String missingDelimiterValue) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(delimiter, "delimiter");
        kotlin.jvm.internal.g0.p(replacement, "replacement");
        kotlin.jvm.internal.g0.p(missingDelimiterValue, "missingDelimiterValue");
        int H3 = H3(str, delimiter, 0, false, 6, null);
        return H3 == -1 ? missingDelimiterValue : b5(str, 0, H3, replacement).toString();
    }

    public static /* synthetic */ String R5(String str, char c6, String str2, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            str2 = str;
        }
        return P5(str, c6, str2);
    }

    @NotNull
    public static final kotlin.collections.e0 S3(@NotNull CharSequence charSequence) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        return new a(charSequence);
    }

    public static /* synthetic */ String S4(String str, char c6, String str2, String str3, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            str3 = str;
        }
        return Q4(str, c6, str2, str3);
    }

    public static /* synthetic */ String S5(String str, String str2, String str3, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            str3 = str;
        }
        return Q5(str, str2, str3);
    }

    public static final int T3(@NotNull CharSequence charSequence, char c6, int i6, boolean z5) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        return (z5 || !(charSequence instanceof String)) ? Y3(charSequence, new char[]{c6}, i6, z5) : ((String) charSequence).lastIndexOf(c6, i6);
    }

    public static /* synthetic */ String T4(String str, String str2, String str3, String str4, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            str4 = str;
        }
        return R4(str, str2, str3, str4);
    }

    @NotNull
    public static String T5(@NotNull String str, char c6, @NotNull String missingDelimiterValue) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(missingDelimiterValue, "missingDelimiterValue");
        int V3 = V3(str, c6, 0, false, 6, null);
        if (V3 == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(0, V3);
        kotlin.jvm.internal.g0.o(substring, "substring(...)");
        return substring;
    }

    public static final int U3(@NotNull CharSequence charSequence, @NotNull String string, int i6, boolean z5) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(string, "string");
        return (z5 || !(charSequence instanceof String)) ? E3(charSequence, string, i6, 0, z5, true) : ((String) charSequence).lastIndexOf(string, i6);
    }

    @NotNull
    public static final String U4(@NotNull String str, char c6, @NotNull String replacement, @NotNull String missingDelimiterValue) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(replacement, "replacement");
        kotlin.jvm.internal.g0.p(missingDelimiterValue, "missingDelimiterValue");
        int V3 = V3(str, c6, 0, false, 6, null);
        return V3 == -1 ? missingDelimiterValue : b5(str, 0, V3, replacement).toString();
    }

    @NotNull
    public static String U5(@NotNull String str, @NotNull String delimiter, @NotNull String missingDelimiterValue) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(delimiter, "delimiter");
        kotlin.jvm.internal.g0.p(missingDelimiterValue, "missingDelimiterValue");
        int W3 = W3(str, delimiter, 0, false, 6, null);
        if (W3 == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(0, W3);
        kotlin.jvm.internal.g0.o(substring, "substring(...)");
        return substring;
    }

    public static /* synthetic */ int V3(CharSequence charSequence, char c6, int i6, boolean z5, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i6 = y3(charSequence);
        }
        if ((i7 & 4) != 0) {
            z5 = false;
        }
        return T3(charSequence, c6, i6, z5);
    }

    @NotNull
    public static final String V4(@NotNull String str, @NotNull String delimiter, @NotNull String replacement, @NotNull String missingDelimiterValue) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(delimiter, "delimiter");
        kotlin.jvm.internal.g0.p(replacement, "replacement");
        kotlin.jvm.internal.g0.p(missingDelimiterValue, "missingDelimiterValue");
        int W3 = W3(str, delimiter, 0, false, 6, null);
        return W3 == -1 ? missingDelimiterValue : b5(str, 0, W3, replacement).toString();
    }

    public static /* synthetic */ String V5(String str, char c6, String str2, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            str2 = str;
        }
        return T5(str, c6, str2);
    }

    public static /* synthetic */ int W3(CharSequence charSequence, String str, int i6, boolean z5, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i6 = y3(charSequence);
        }
        if ((i7 & 4) != 0) {
            z5 = false;
        }
        return U3(charSequence, str, i6, z5);
    }

    public static /* synthetic */ String W4(String str, char c6, String str2, String str3, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            str3 = str;
        }
        return U4(str, c6, str2, str3);
    }

    public static /* synthetic */ String W5(String str, String str2, String str3, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            str3 = str;
        }
        return U5(str, str2, str3);
    }

    public static final int X3(@NotNull CharSequence charSequence, @NotNull Collection<String> strings, int i6, boolean z5) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(strings, "strings");
        Pair<Integer, String> t32 = t3(charSequence, strings, i6, z5, true);
        if (t32 != null) {
            return t32.getFirst().intValue();
        }
        return -1;
    }

    public static /* synthetic */ String X4(String str, String str2, String str3, String str4, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            str4 = str;
        }
        return V4(str, str2, str3, str4);
    }

    @SinceKotlin(version = "1.5")
    public static final boolean X5(@NotNull String str) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        if (kotlin.jvm.internal.g0.g(str, "true")) {
            return true;
        }
        if (kotlin.jvm.internal.g0.g(str, "false")) {
            return false;
        }
        throw new IllegalArgumentException("The string doesn't represent a boolean value: " + str);
    }

    public static final int Y3(@NotNull CharSequence charSequence, @NotNull char[] chars, int i6, boolean z5) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(chars, "chars");
        if (!z5 && chars.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(kotlin.collections.n.qt(chars), i6);
        }
        for (int B = kotlin.ranges.t.B(i6, y3(charSequence)); -1 < B; B--) {
            char charAt = charSequence.charAt(B);
            for (char c6 : chars) {
                if (d.J(c6, charAt, z5)) {
                    return B;
                }
            }
        }
        return -1;
    }

    @InlineOnly
    private static final String Y4(CharSequence charSequence, Regex regex, String replacement) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(regex, "regex");
        kotlin.jvm.internal.g0.p(replacement, "replacement");
        return regex.replaceFirst(charSequence, replacement);
    }

    @SinceKotlin(version = "1.5")
    @Nullable
    public static final Boolean Y5(@NotNull String str) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        if (kotlin.jvm.internal.g0.g(str, "true")) {
            return Boolean.TRUE;
        }
        if (kotlin.jvm.internal.g0.g(str, "false")) {
            return Boolean.FALSE;
        }
        return null;
    }

    public static /* synthetic */ int Z3(CharSequence charSequence, Collection collection, int i6, boolean z5, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i6 = y3(charSequence);
        }
        if ((i7 & 4) != 0) {
            z5 = false;
        }
        return X3(charSequence, collection, i6, z5);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @JvmName(name = "replaceFirstCharWithChar")
    @OverloadResolutionByLambdaReturnType
    private static final String Z4(String str, Function1<? super Character, Character> transform) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        if (str.length() <= 0) {
            return str;
        }
        char charValue = transform.invoke(Character.valueOf(str.charAt(0))).charValue();
        String substring = str.substring(1);
        kotlin.jvm.internal.g0.o(substring, "substring(...)");
        return charValue + substring;
    }

    @NotNull
    public static CharSequence Z5(@NotNull CharSequence charSequence) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i6 = 0;
        boolean z5 = false;
        while (i6 <= length) {
            boolean r5 = c.r(charSequence.charAt(!z5 ? i6 : length));
            if (z5) {
                if (!r5) {
                    break;
                }
                length--;
            } else if (r5) {
                i6++;
            } else {
                z5 = true;
            }
        }
        return charSequence.subSequence(i6, length + 1);
    }

    public static /* synthetic */ int a4(CharSequence charSequence, char[] cArr, int i6, boolean z5, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i6 = y3(charSequence);
        }
        if ((i7 & 4) != 0) {
            z5 = false;
        }
        return Y3(charSequence, cArr, i6, z5);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @JvmName(name = "replaceFirstCharWithCharSequence")
    @OverloadResolutionByLambdaReturnType
    private static final String a5(String str, Function1<? super Character, ? extends CharSequence> transform) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        if (str.length() <= 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append((Object) transform.invoke(Character.valueOf(str.charAt(0))));
        String substring = str.substring(1);
        kotlin.jvm.internal.g0.o(substring, "substring(...)");
        sb.append(substring);
        return sb.toString();
    }

    @NotNull
    public static final CharSequence a6(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = charSequence.length() - 1;
        int i6 = 0;
        boolean z5 = false;
        while (i6 <= length) {
            boolean booleanValue = predicate.invoke(Character.valueOf(charSequence.charAt(!z5 ? i6 : length))).booleanValue();
            if (z5) {
                if (!booleanValue) {
                    break;
                }
                length--;
            } else if (booleanValue) {
                i6++;
            } else {
                z5 = true;
            }
        }
        return charSequence.subSequence(i6, length + 1);
    }

    @NotNull
    public static final kotlin.sequences.m<String> b4(@NotNull CharSequence charSequence) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        return new b(charSequence);
    }

    @NotNull
    public static final CharSequence b5(@NotNull CharSequence charSequence, int i6, int i7, @NotNull CharSequence replacement) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(replacement, "replacement");
        if (i7 >= i6) {
            StringBuilder sb = new StringBuilder();
            sb.append(charSequence, 0, i6);
            kotlin.jvm.internal.g0.o(sb, "append(...)");
            sb.append(replacement);
            sb.append(charSequence, i7, charSequence.length());
            kotlin.jvm.internal.g0.o(sb, "append(...)");
            return sb;
        }
        throw new IndexOutOfBoundsException("End index (" + i7 + ") is less than start index (" + i6 + ").");
    }

    @NotNull
    public static final CharSequence b6(@NotNull CharSequence charSequence, @NotNull char... chars) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(chars, "chars");
        int length = charSequence.length() - 1;
        int i6 = 0;
        boolean z5 = false;
        while (i6 <= length) {
            boolean w8 = kotlin.collections.n.w8(chars, charSequence.charAt(!z5 ? i6 : length));
            if (z5) {
                if (!w8) {
                    break;
                }
                length--;
            } else if (w8) {
                i6++;
            } else {
                z5 = true;
            }
        }
        return charSequence.subSequence(i6, length + 1);
    }

    @NotNull
    public static List<String> c4(@NotNull CharSequence charSequence) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        return kotlin.sequences.p.I3(b4(charSequence));
    }

    @NotNull
    public static final CharSequence c5(@NotNull CharSequence charSequence, @NotNull kotlin.ranges.m range, @NotNull CharSequence replacement) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(range, "range");
        kotlin.jvm.internal.g0.p(replacement, "replacement");
        return b5(charSequence, range.getStart().intValue(), range.getEndInclusive().intValue() + 1, replacement);
    }

    @InlineOnly
    private static final String c6(String str) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        return Z5(str).toString();
    }

    @NotNull
    public static final String d3(@NotNull CharSequence charSequence, @NotNull CharSequence other, boolean z5) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        int min = Math.min(charSequence.length(), other.length());
        int i6 = 0;
        while (i6 < min && d.J(charSequence.charAt(i6), other.charAt(i6), z5)) {
            i6++;
        }
        int i7 = i6 - 1;
        if (z3(charSequence, i7) || z3(other, i7)) {
            i6--;
        }
        return charSequence.subSequence(0, i6).toString();
    }

    @InlineOnly
    private static final boolean d4(CharSequence charSequence, Regex regex) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(regex, "regex");
        return regex.matches(charSequence);
    }

    @InlineOnly
    private static final String d5(String str, int i6, int i7, CharSequence replacement) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(replacement, "replacement");
        return b5(str, i6, i7, replacement).toString();
    }

    @NotNull
    public static final String d6(@NotNull String str, @NotNull Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = str.length() - 1;
        int i6 = 0;
        boolean z5 = false;
        while (i6 <= length) {
            boolean booleanValue = predicate.invoke(Character.valueOf(str.charAt(!z5 ? i6 : length))).booleanValue();
            if (z5) {
                if (!booleanValue) {
                    break;
                }
                length--;
            } else if (booleanValue) {
                i6++;
            } else {
                z5 = true;
            }
        }
        return str.subSequence(i6, length + 1).toString();
    }

    public static /* synthetic */ String e3(CharSequence charSequence, CharSequence charSequence2, boolean z5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        return d3(charSequence, charSequence2, z5);
    }

    @InlineOnly
    private static final String e4(String str) {
        return str == null ? "" : str;
    }

    @InlineOnly
    private static final String e5(String str, kotlin.ranges.m range, CharSequence replacement) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(range, "range");
        kotlin.jvm.internal.g0.p(replacement, "replacement");
        return c5(str, range, replacement).toString();
    }

    @NotNull
    public static final String e6(@NotNull String str, @NotNull char... chars) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(chars, "chars");
        int length = str.length() - 1;
        int i6 = 0;
        boolean z5 = false;
        while (i6 <= length) {
            boolean w8 = kotlin.collections.n.w8(chars, str.charAt(!z5 ? i6 : length));
            if (z5) {
                if (!w8) {
                    break;
                }
                length--;
            } else if (w8) {
                i6++;
            } else {
                z5 = true;
            }
        }
        return str.subSequence(i6, length + 1).toString();
    }

    @NotNull
    public static final String f3(@NotNull CharSequence charSequence, @NotNull CharSequence other, boolean z5) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        int length = charSequence.length();
        int min = Math.min(length, other.length());
        int i6 = 0;
        while (i6 < min && d.J(charSequence.charAt((length - i6) - 1), other.charAt((r1 - i6) - 1), z5)) {
            i6++;
        }
        if (z3(charSequence, (length - i6) - 1) || z3(other, (r1 - i6) - 1)) {
            i6--;
        }
        return charSequence.subSequence(length - i6, length).toString();
    }

    @NotNull
    public static final CharSequence f4(@NotNull CharSequence charSequence, int i6, char c6) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        if (i6 < 0) {
            throw new IllegalArgumentException("Desired length " + i6 + " is less than zero.");
        }
        if (i6 <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb = new StringBuilder(i6);
        sb.append(charSequence);
        int length = i6 - charSequence.length();
        int i7 = 1;
        if (1 <= length) {
            while (true) {
                sb.append(c6);
                if (i7 == length) {
                    break;
                }
                i7++;
            }
        }
        return sb;
    }

    public static final void f5(int i6) {
        if (i6 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i6).toString());
    }

    @NotNull
    public static final CharSequence f6(@NotNull CharSequence charSequence) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        int length = charSequence.length() - 1;
        if (length < 0) {
            return "";
        }
        while (true) {
            int i6 = length - 1;
            if (!c.r(charSequence.charAt(length))) {
                return charSequence.subSequence(0, length + 1);
            }
            if (i6 < 0) {
                return "";
            }
            length = i6;
        }
    }

    public static /* synthetic */ String g3(CharSequence charSequence, CharSequence charSequence2, boolean z5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        return f3(charSequence, charSequence2, z5);
    }

    @NotNull
    public static final String g4(@NotNull String str, int i6, char c6) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        return f4(str, i6, c6).toString();
    }

    @InlineOnly
    private static final List<String> g5(CharSequence charSequence, Regex regex, int i6) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(regex, "regex");
        return regex.split(charSequence, i6);
    }

    @NotNull
    public static final CharSequence g6(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = charSequence.length() - 1;
        if (length < 0) {
            return "";
        }
        while (true) {
            int i6 = length - 1;
            if (!predicate.invoke(Character.valueOf(charSequence.charAt(length))).booleanValue()) {
                return charSequence.subSequence(0, length + 1);
            }
            if (i6 < 0) {
                return "";
            }
            length = i6;
        }
    }

    public static final boolean h3(@NotNull CharSequence charSequence, char c6, boolean z5) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        return G3(charSequence, c6, 0, z5, 2, null) >= 0;
    }

    public static /* synthetic */ CharSequence h4(CharSequence charSequence, int i6, char c6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            c6 = ' ';
        }
        return f4(charSequence, i6, c6);
    }

    @NotNull
    public static final List<String> h5(@NotNull CharSequence charSequence, @NotNull char[] delimiters, boolean z5, int i6) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(delimiters, "delimiters");
        if (delimiters.length == 1) {
            return j5(charSequence, String.valueOf(delimiters[0]), z5, i6);
        }
        Iterable l02 = kotlin.sequences.p.l0(p4(charSequence, delimiters, 0, z5, i6, 2, null));
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(l02, 10));
        Iterator it = l02.iterator();
        while (it.hasNext()) {
            arrayList.add(E5(charSequence, (kotlin.ranges.m) it.next()));
        }
        return arrayList;
    }

    @NotNull
    public static final CharSequence h6(@NotNull CharSequence charSequence, @NotNull char... chars) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(chars, "chars");
        int length = charSequence.length() - 1;
        if (length < 0) {
            return "";
        }
        while (true) {
            int i6 = length - 1;
            if (!kotlin.collections.n.w8(chars, charSequence.charAt(length))) {
                return charSequence.subSequence(0, length + 1);
            }
            if (i6 < 0) {
                return "";
            }
            length = i6;
        }
    }

    public static boolean i3(@NotNull CharSequence charSequence, @NotNull CharSequence other, boolean z5) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        return other instanceof String ? H3(charSequence, (String) other, 0, z5, 2, null) >= 0 : F3(charSequence, other, 0, charSequence.length(), z5, false, 16, null) >= 0;
    }

    public static /* synthetic */ String i4(String str, int i6, char c6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            c6 = ' ';
        }
        return g4(str, i6, c6);
    }

    @NotNull
    public static final List<String> i5(@NotNull CharSequence charSequence, @NotNull String[] delimiters, boolean z5, int i6) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(delimiters, "delimiters");
        if (delimiters.length == 1) {
            String str = delimiters[0];
            if (str.length() != 0) {
                return j5(charSequence, str, z5, i6);
            }
        }
        Iterable l02 = kotlin.sequences.p.l0(q4(charSequence, delimiters, 0, z5, i6, 2, null));
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(l02, 10));
        Iterator it = l02.iterator();
        while (it.hasNext()) {
            arrayList.add(E5(charSequence, (kotlin.ranges.m) it.next()));
        }
        return arrayList;
    }

    @InlineOnly
    private static final String i6(String str) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        return f6(str).toString();
    }

    @InlineOnly
    private static final boolean j3(CharSequence charSequence, Regex regex) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(regex, "regex");
        return regex.containsMatchIn(charSequence);
    }

    @NotNull
    public static final CharSequence j4(@NotNull CharSequence charSequence, int i6, char c6) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        if (i6 < 0) {
            throw new IllegalArgumentException("Desired length " + i6 + " is less than zero.");
        }
        if (i6 <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb = new StringBuilder(i6);
        int length = i6 - charSequence.length();
        int i7 = 1;
        if (1 <= length) {
            while (true) {
                sb.append(c6);
                if (i7 == length) {
                    break;
                }
                i7++;
            }
        }
        sb.append(charSequence);
        return sb;
    }

    @NotNull
    public static final String j6(@NotNull String str, @NotNull Function1<? super Character, Boolean> predicate) {
        CharSequence charSequence;
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = str.length() - 1;
        if (length >= 0) {
            while (true) {
                int i6 = length - 1;
                if (!predicate.invoke(Character.valueOf(str.charAt(length))).booleanValue()) {
                    charSequence = str.subSequence(0, length + 1);
                    break;
                }
                if (i6 < 0) {
                    break;
                }
                length = i6;
            }
            return charSequence.toString();
        }
        charSequence = "";
        return charSequence.toString();
    }

    public static /* synthetic */ boolean k3(CharSequence charSequence, char c6, boolean z5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        return h3(charSequence, c6, z5);
    }

    @NotNull
    public static String k4(@NotNull String str, int i6, char c6) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        return j4(str, i6, c6).toString();
    }

    static /* synthetic */ List k5(CharSequence charSequence, Regex regex, int i6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i6 = 0;
        }
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(regex, "regex");
        return regex.split(charSequence, i6);
    }

    @NotNull
    public static final String k6(@NotNull String str, @NotNull char... chars) {
        CharSequence charSequence;
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(chars, "chars");
        int length = str.length() - 1;
        if (length >= 0) {
            while (true) {
                int i6 = length - 1;
                if (!kotlin.collections.n.w8(chars, str.charAt(length))) {
                    charSequence = str.subSequence(0, length + 1);
                    break;
                }
                if (i6 < 0) {
                    break;
                }
                length = i6;
            }
            return charSequence.toString();
        }
        charSequence = "";
        return charSequence.toString();
    }

    public static /* synthetic */ boolean l3(CharSequence charSequence, CharSequence charSequence2, boolean z5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        return i3(charSequence, charSequence2, z5);
    }

    public static /* synthetic */ CharSequence l4(CharSequence charSequence, int i6, char c6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            c6 = ' ';
        }
        return j4(charSequence, i6, c6);
    }

    public static /* synthetic */ List l5(CharSequence charSequence, char[] cArr, boolean z5, int i6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            z5 = false;
        }
        if ((i7 & 4) != 0) {
            i6 = 0;
        }
        return h5(charSequence, cArr, z5, i6);
    }

    @NotNull
    public static final CharSequence l6(@NotNull CharSequence charSequence) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        int length = charSequence.length();
        for (int i6 = 0; i6 < length; i6++) {
            if (!c.r(charSequence.charAt(i6))) {
                return charSequence.subSequence(i6, charSequence.length());
            }
        }
        return "";
    }

    public static final boolean m3(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2) {
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return g0.a2((String) charSequence, (String) charSequence2, true);
        }
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        int length = charSequence.length();
        for (int i6 = 0; i6 < length; i6++) {
            if (!d.J(charSequence.charAt(i6), charSequence2.charAt(i6), true)) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ String m4(String str, int i6, char c6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            c6 = ' ';
        }
        return k4(str, i6, c6);
    }

    public static /* synthetic */ List m5(CharSequence charSequence, String[] strArr, boolean z5, int i6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            z5 = false;
        }
        if ((i7 & 4) != 0) {
            i6 = 0;
        }
        return i5(charSequence, strArr, z5, i6);
    }

    @NotNull
    public static final CharSequence m6(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = charSequence.length();
        for (int i6 = 0; i6 < length; i6++) {
            if (!predicate.invoke(Character.valueOf(charSequence.charAt(i6))).booleanValue()) {
                return charSequence.subSequence(i6, charSequence.length());
            }
        }
        return "";
    }

    public static final boolean n3(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2) {
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return kotlin.jvm.internal.g0.g(charSequence, charSequence2);
        }
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        int length = charSequence.length();
        for (int i6 = 0; i6 < length; i6++) {
            if (charSequence.charAt(i6) != charSequence2.charAt(i6)) {
                return false;
            }
        }
        return true;
    }

    @SinceKotlin(version = cn.bluemobi.dylan.photoview.a.f1297f)
    @InlineOnly
    private static final kotlin.sequences.m<String> n5(CharSequence charSequence, Regex regex, int i6) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(regex, "regex");
        return regex.splitToSequence(charSequence, i6);
    }

    @NotNull
    public static final CharSequence n6(@NotNull CharSequence charSequence, @NotNull char... chars) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(chars, "chars");
        int length = charSequence.length();
        for (int i6 = 0; i6 < length; i6++) {
            if (!kotlin.collections.n.w8(chars, charSequence.charAt(i6))) {
                return charSequence.subSequence(i6, charSequence.length());
            }
        }
        return "";
    }

    public static final boolean o3(@NotNull CharSequence charSequence, char c6, boolean z5) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        return charSequence.length() > 0 && d.J(charSequence.charAt(y3(charSequence)), c6, z5);
    }

    @NotNull
    public static final kotlin.sequences.m<String> o5(@NotNull final CharSequence charSequence, @NotNull char[] delimiters, boolean z5, int i6) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(delimiters, "delimiters");
        return kotlin.sequences.p.N1(p4(charSequence, delimiters, 0, z5, i6, 2, null), new Function1() { // from class: kotlin.text.h0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                String u5;
                u5 = l0.u5(charSequence, (kotlin.ranges.m) obj);
                return u5;
            }
        });
    }

    @InlineOnly
    private static final String o6(String str) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        return l6(str).toString();
    }

    public static final boolean p3(@NotNull CharSequence charSequence, @NotNull CharSequence suffix, boolean z5) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(suffix, "suffix");
        return (!z5 && (charSequence instanceof String) && (suffix instanceof String)) ? g0.Z1((String) charSequence, (String) suffix, false, 2, null) : t4(charSequence, charSequence.length() - suffix.length(), suffix, 0, suffix.length(), z5);
    }

    static /* synthetic */ kotlin.sequences.m p4(CharSequence charSequence, char[] cArr, int i6, boolean z5, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i6 = 0;
        }
        if ((i8 & 4) != 0) {
            z5 = false;
        }
        if ((i8 & 8) != 0) {
            i7 = 0;
        }
        return n4(charSequence, cArr, i6, z5, i7);
    }

    @NotNull
    public static final kotlin.sequences.m<String> p5(@NotNull final CharSequence charSequence, @NotNull String[] delimiters, boolean z5, int i6) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(delimiters, "delimiters");
        return kotlin.sequences.p.N1(q4(charSequence, delimiters, 0, z5, i6, 2, null), new Function1() { // from class: kotlin.text.k0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                String t5;
                t5 = l0.t5(charSequence, (kotlin.ranges.m) obj);
                return t5;
            }
        });
    }

    @NotNull
    public static final String p6(@NotNull String str, @NotNull Function1<? super Character, Boolean> predicate) {
        CharSequence charSequence;
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = str.length();
        int i6 = 0;
        while (true) {
            if (i6 >= length) {
                charSequence = "";
                break;
            }
            if (!predicate.invoke(Character.valueOf(str.charAt(i6))).booleanValue()) {
                charSequence = str.subSequence(i6, str.length());
                break;
            }
            i6++;
        }
        return charSequence.toString();
    }

    public static /* synthetic */ boolean q3(CharSequence charSequence, char c6, boolean z5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        return o3(charSequence, c6, z5);
    }

    static /* synthetic */ kotlin.sequences.m q4(CharSequence charSequence, String[] strArr, int i6, boolean z5, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i6 = 0;
        }
        if ((i8 & 4) != 0) {
            z5 = false;
        }
        if ((i8 & 8) != 0) {
            i7 = 0;
        }
        return o4(charSequence, strArr, i6, z5, i7);
    }

    static /* synthetic */ kotlin.sequences.m q5(CharSequence charSequence, Regex regex, int i6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i6 = 0;
        }
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(regex, "regex");
        return regex.splitToSequence(charSequence, i6);
    }

    @NotNull
    public static final String q6(@NotNull String str, @NotNull char... chars) {
        CharSequence charSequence;
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(chars, "chars");
        int length = str.length();
        int i6 = 0;
        while (true) {
            if (i6 >= length) {
                charSequence = "";
                break;
            }
            if (!kotlin.collections.n.w8(chars, str.charAt(i6))) {
                charSequence = str.subSequence(i6, str.length());
                break;
            }
            i6++;
        }
        return charSequence.toString();
    }

    public static /* synthetic */ boolean r3(CharSequence charSequence, CharSequence charSequence2, boolean z5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        return p3(charSequence, charSequence2, z5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair r4(char[] cArr, boolean z5, CharSequence DelimitedRangesSequence, int i6) {
        kotlin.jvm.internal.g0.p(DelimitedRangesSequence, "$this$DelimitedRangesSequence");
        int J3 = J3(DelimitedRangesSequence, cArr, i6, z5);
        if (J3 < 0) {
            return null;
        }
        return kotlin.o0.a(Integer.valueOf(J3), 1);
    }

    public static /* synthetic */ kotlin.sequences.m r5(CharSequence charSequence, char[] cArr, boolean z5, int i6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            z5 = false;
        }
        if ((i7 & 4) != 0) {
            i6 = 0;
        }
        return o5(charSequence, cArr, z5, i6);
    }

    @Nullable
    public static final Pair<Integer, String> s3(@NotNull CharSequence charSequence, @NotNull Collection<String> strings, int i6, boolean z5) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(strings, "strings");
        return t3(charSequence, strings, i6, z5, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair s4(List list, boolean z5, CharSequence DelimitedRangesSequence, int i6) {
        kotlin.jvm.internal.g0.p(DelimitedRangesSequence, "$this$DelimitedRangesSequence");
        Pair<Integer, String> t32 = t3(DelimitedRangesSequence, list, i6, z5, false);
        if (t32 != null) {
            return kotlin.o0.a(t32.getFirst(), Integer.valueOf(t32.getSecond().length()));
        }
        return null;
    }

    public static /* synthetic */ kotlin.sequences.m s5(CharSequence charSequence, String[] strArr, boolean z5, int i6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            z5 = false;
        }
        if ((i7 & 4) != 0) {
            i6 = 0;
        }
        return p5(charSequence, strArr, z5, i6);
    }

    public static final boolean t4(@NotNull CharSequence charSequence, int i6, @NotNull CharSequence other, int i7, int i8, boolean z5) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        if (i7 < 0 || i6 < 0 || i6 > charSequence.length() - i8 || i7 > other.length() - i8) {
            return false;
        }
        for (int i9 = 0; i9 < i8; i9++) {
            if (!d.J(charSequence.charAt(i6 + i9), other.charAt(i7 + i9), z5)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String t5(CharSequence charSequence, kotlin.ranges.m it) {
        kotlin.jvm.internal.g0.p(it, "it");
        return E5(charSequence, it);
    }

    public static /* synthetic */ Pair u3(CharSequence charSequence, Collection collection, int i6, boolean z5, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i6 = 0;
        }
        if ((i7 & 4) != 0) {
            z5 = false;
        }
        return s3(charSequence, collection, i6, z5);
    }

    @NotNull
    public static final CharSequence u4(@NotNull CharSequence charSequence, @NotNull CharSequence prefix) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(prefix, "prefix");
        return A5(charSequence, prefix, false, 2, null) ? charSequence.subSequence(prefix.length(), charSequence.length()) : charSequence.subSequence(0, charSequence.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String u5(CharSequence charSequence, kotlin.ranges.m it) {
        kotlin.jvm.internal.g0.p(it, "it");
        return E5(charSequence, it);
    }

    @Nullable
    public static final Pair<Integer, String> v3(@NotNull CharSequence charSequence, @NotNull Collection<String> strings, int i6, boolean z5) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(strings, "strings");
        return t3(charSequence, strings, i6, z5, true);
    }

    @NotNull
    public static String v4(@NotNull String str, @NotNull CharSequence prefix) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(prefix, "prefix");
        if (!A5(str, prefix, false, 2, null)) {
            return str;
        }
        String substring = str.substring(prefix.length());
        kotlin.jvm.internal.g0.o(substring, "substring(...)");
        return substring;
    }

    public static final boolean v5(@NotNull CharSequence charSequence, char c6, boolean z5) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        return charSequence.length() > 0 && d.J(charSequence.charAt(0), c6, z5);
    }

    public static /* synthetic */ Pair w3(CharSequence charSequence, Collection collection, int i6, boolean z5, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i6 = y3(charSequence);
        }
        if ((i7 & 4) != 0) {
            z5 = false;
        }
        return v3(charSequence, collection, i6, z5);
    }

    @NotNull
    public static final CharSequence w4(@NotNull CharSequence charSequence, int i6, int i7) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        if (i7 < i6) {
            throw new IndexOutOfBoundsException("End index (" + i7 + ") is less than start index (" + i6 + ").");
        }
        if (i7 == i6) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb = new StringBuilder(charSequence.length() - (i7 - i6));
        sb.append(charSequence, 0, i6);
        kotlin.jvm.internal.g0.o(sb, "append(...)");
        sb.append(charSequence, i7, charSequence.length());
        kotlin.jvm.internal.g0.o(sb, "append(...)");
        return sb;
    }

    public static final boolean w5(@NotNull CharSequence charSequence, @NotNull CharSequence prefix, int i6, boolean z5) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(prefix, "prefix");
        return (!z5 && (charSequence instanceof String) && (prefix instanceof String)) ? g0.G2((String) charSequence, (String) prefix, i6, false, 4, null) : t4(charSequence, i6, prefix, 0, prefix.length(), z5);
    }

    @NotNull
    public static kotlin.ranges.m x3(@NotNull CharSequence charSequence) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        return new kotlin.ranges.m(0, charSequence.length() - 1);
    }

    @NotNull
    public static final CharSequence x4(@NotNull CharSequence charSequence, @NotNull kotlin.ranges.m range) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(range, "range");
        return w4(charSequence, range.getStart().intValue(), range.getEndInclusive().intValue() + 1);
    }

    public static final boolean x5(@NotNull CharSequence charSequence, @NotNull CharSequence prefix, boolean z5) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        kotlin.jvm.internal.g0.p(prefix, "prefix");
        return (!z5 && (charSequence instanceof String) && (prefix instanceof String)) ? g0.H2((String) charSequence, (String) prefix, false, 2, null) : t4(charSequence, 0, prefix, 0, prefix.length(), z5);
    }

    public static int y3(@NotNull CharSequence charSequence) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    @InlineOnly
    private static final String y4(String str, int i6, int i7) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        return w4(str, i6, i7).toString();
    }

    public static /* synthetic */ boolean y5(CharSequence charSequence, char c6, boolean z5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        return v5(charSequence, c6, z5);
    }

    public static final boolean z3(@NotNull CharSequence charSequence, int i6) {
        kotlin.jvm.internal.g0.p(charSequence, "<this>");
        return i6 >= 0 && i6 <= charSequence.length() + (-2) && Character.isHighSurrogate(charSequence.charAt(i6)) && Character.isLowSurrogate(charSequence.charAt(i6 + 1));
    }

    @InlineOnly
    private static final String z4(String str, kotlin.ranges.m range) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(range, "range");
        return x4(str, range).toString();
    }

    public static /* synthetic */ boolean z5(CharSequence charSequence, CharSequence charSequence2, int i6, boolean z5, int i7, Object obj) {
        if ((i7 & 4) != 0) {
            z5 = false;
        }
        return w5(charSequence, charSequence2, i6, z5);
    }

    private static final List<String> j5(CharSequence charSequence, String str, boolean z5, int i6) {
        boolean z6;
        f5(i6);
        int i7 = 0;
        int D3 = D3(charSequence, str, 0, z5);
        if (D3 != -1 && i6 != 1) {
            if (i6 > 0) {
                z6 = true;
            } else {
                z6 = false;
            }
            int i8 = 10;
            if (z6) {
                i8 = kotlin.ranges.t.B(i6, 10);
            }
            ArrayList arrayList = new ArrayList(i8);
            do {
                arrayList.add(charSequence.subSequence(i7, D3).toString());
                i7 = str.length() + D3;
                if (z6 && arrayList.size() == i6 - 1) {
                    break;
                }
                D3 = D3(charSequence, str, i7, z5);
            } while (D3 != -1);
            arrayList.add(charSequence.subSequence(i7, charSequence.length()).toString());
            return arrayList;
        }
        return kotlin.collections.f0.l(charSequence.toString());
    }

    private static final kotlin.sequences.m<kotlin.ranges.m> n4(CharSequence charSequence, final char[] cArr, int i6, final boolean z5, int i7) {
        f5(i7);
        return new g(charSequence, i6, i7, new Function2() { // from class: kotlin.text.i0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Pair r42;
                r42 = l0.r4(cArr, z5, (CharSequence) obj, ((Integer) obj2).intValue());
                return r42;
            }
        });
    }

    private static final kotlin.sequences.m<kotlin.ranges.m> o4(CharSequence charSequence, String[] strArr, int i6, final boolean z5, int i7) {
        f5(i7);
        final List t5 = kotlin.collections.n.t(strArr);
        return new g(charSequence, i6, i7, new Function2() { // from class: kotlin.text.j0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Pair s42;
                s42 = l0.s4(t5, z5, (CharSequence) obj, ((Integer) obj2).intValue());
                return s42;
            }
        });
    }
}
