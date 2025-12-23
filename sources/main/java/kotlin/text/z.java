package kotlin.text;

import com.huawei.hms.common.util.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.internal.IntrinsicConstEvaluation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nIndent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Indent.kt\nkotlin/text/StringsKt__IndentKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,129:1\n119#1,2:131\n121#1,4:146\n126#1,2:159\n119#1,2:168\n121#1,4:183\n126#1,2:190\n1#2:130\n1#2:156\n1#2:187\n1#2:211\n1583#3,11:133\n1878#3,2:144\n1880#3:157\n1594#3:158\n774#3:161\n865#3,2:162\n1563#3:164\n1634#3,3:165\n1583#3,11:170\n1878#3,2:181\n1880#3:188\n1594#3:189\n1583#3,11:198\n1878#3,2:209\n1880#3:212\n1594#3:213\n158#4,6:150\n158#4,6:192\n*S KotlinDebug\n*F\n+ 1 Indent.kt\nkotlin/text/StringsKt__IndentKt\n*L\n42#1:131,2\n42#1:146,4\n42#1:159,2\n83#1:168,2\n83#1:183,4\n83#1:190,2\n42#1:156\n83#1:187\n120#1:211\n42#1:133,11\n42#1:144,2\n42#1:157\n42#1:158\n79#1:161\n79#1:162,2\n80#1:164\n80#1:165,3\n83#1:170,11\n83#1:181,2\n83#1:188\n83#1:189\n120#1:198,11\n120#1:209,2\n120#1:212\n120#1:213\n43#1:150,6\n107#1:192,6\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public class z extends v {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String k(String line) {
        kotlin.jvm.internal.g0.p(line, "line");
        return line;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String l(String str, String line) {
        kotlin.jvm.internal.g0.p(line, "line");
        return str + line;
    }

    @NotNull
    public static final String n(@NotNull String str, @NotNull final String indent) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(indent, "indent");
        return kotlin.sequences.p.H1(kotlin.sequences.p.N1(l0.b4(str), new Function1() { // from class: kotlin.text.w
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                String p5;
                p5 = z.p(indent, (String) obj);
                return p5;
            }
        }), com.snail.antifake.deviceid.e.f37542d, null, null, 0, null, null, 62, null);
    }

    public static /* synthetic */ String o(String str, String str2, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str2 = "    ";
        }
        return n(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String p(String str, String it) {
        kotlin.jvm.internal.g0.p(it, "it");
        if (l0.M3(it)) {
            return it.length() < str.length() ? str : it;
        }
        return str + it;
    }

    @NotNull
    public static final String r(@NotNull String str, @NotNull String newIndent) {
        Appendable o32;
        String invoke;
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(newIndent, "newIndent");
        List<String> c42 = l0.c4(str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : c42) {
            if (!l0.M3((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(kotlin.collections.f0.d0(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf(m((String) it.next())));
        }
        Integer num = (Integer) kotlin.collections.f0.m4(arrayList2);
        int i6 = 0;
        int intValue = num != null ? num.intValue() : 0;
        int length = str.length() + (newIndent.length() * c42.size());
        Function1<String, String> j6 = j(newIndent);
        int L = kotlin.collections.f0.L(c42);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : c42) {
            int i7 = i6 + 1;
            if (i6 < 0) {
                kotlin.collections.f0.b0();
            }
            String str2 = (String) obj2;
            if ((i6 == 0 || i6 == L) && l0.M3(str2)) {
                str2 = null;
            } else {
                String b7 = s0.b7(str2, intValue);
                if (b7 != null && (invoke = j6.invoke(b7)) != null) {
                    str2 = invoke;
                }
            }
            if (str2 != null) {
                arrayList3.add(str2);
            }
            i6 = i7;
        }
        o32 = kotlin.collections.r0.o3(arrayList3, new StringBuilder(length), (r14 & 2) != 0 ? ", " : com.snail.antifake.deviceid.e.f37542d, (r14 & 4) != 0 ? "" : null, (r14 & 8) == 0 ? null : "", (r14 & 16) != 0 ? -1 : 0, (r14 & 32) != 0 ? "..." : null, (r14 & 64) != 0 ? null : null);
        return ((StringBuilder) o32).toString();
    }

    public static /* synthetic */ String s(String str, String str2, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str2 = "";
        }
        return r(str, str2);
    }

    @NotNull
    public static final String t(@NotNull String str, @NotNull String newIndent, @NotNull String marginPrefix) {
        Appendable o32;
        String str2;
        String invoke;
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(newIndent, "newIndent");
        kotlin.jvm.internal.g0.p(marginPrefix, "marginPrefix");
        if (l0.M3(marginPrefix)) {
            throw new IllegalArgumentException("marginPrefix must be non-blank string.");
        }
        List<String> c42 = l0.c4(str);
        int length = str.length() + (newIndent.length() * c42.size());
        Function1<String, String> j6 = j(newIndent);
        int L = kotlin.collections.f0.L(c42);
        ArrayList arrayList = new ArrayList();
        int i6 = 0;
        for (Object obj : c42) {
            int i7 = i6 + 1;
            if (i6 < 0) {
                kotlin.collections.f0.b0();
            }
            String str3 = (String) obj;
            String str4 = null;
            if ((i6 == 0 || i6 == L) && l0.M3(str3)) {
                str2 = marginPrefix;
                str3 = null;
            } else {
                int length2 = str3.length();
                int i8 = 0;
                while (true) {
                    if (i8 >= length2) {
                        i8 = -1;
                        break;
                    }
                    if (!c.r(str3.charAt(i8))) {
                        break;
                    }
                    i8++;
                }
                if (i8 == -1) {
                    str2 = marginPrefix;
                } else {
                    int i9 = i8;
                    str2 = marginPrefix;
                    if (g0.G2(str3, str2, i9, false, 4, null)) {
                        int length3 = str2.length() + i9;
                        kotlin.jvm.internal.g0.n(str3, "null cannot be cast to non-null type java.lang.String");
                        str4 = str3.substring(length3);
                        kotlin.jvm.internal.g0.o(str4, "substring(...)");
                    }
                }
                if (str4 != null && (invoke = j6.invoke(str4)) != null) {
                    str3 = invoke;
                }
            }
            if (str3 != null) {
                arrayList.add(str3);
            }
            i6 = i7;
            marginPrefix = str2;
        }
        o32 = kotlin.collections.r0.o3(arrayList, new StringBuilder(length), (r14 & 2) != 0 ? ", " : com.snail.antifake.deviceid.e.f37542d, (r14 & 4) != 0 ? "" : null, (r14 & 8) == 0 ? null : "", (r14 & 16) != 0 ? -1 : 0, (r14 & 32) != 0 ? "..." : null, (r14 & 64) != 0 ? null : null);
        return ((StringBuilder) o32).toString();
    }

    public static /* synthetic */ String u(String str, String str2, String str3, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str2 = "";
        }
        if ((i6 & 2) != 0) {
            str3 = Logger.f33116c;
        }
        return t(str, str2, str3);
    }

    @IntrinsicConstEvaluation
    @NotNull
    public static String v(@NotNull String str) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        return r(str, "");
    }

    @IntrinsicConstEvaluation
    @NotNull
    public static final String w(@NotNull String str, @NotNull String marginPrefix) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        kotlin.jvm.internal.g0.p(marginPrefix, "marginPrefix");
        return t(str, "", marginPrefix);
    }

    public static /* synthetic */ String x(String str, String str2, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str2 = Logger.f33116c;
        }
        return w(str, str2);
    }

    private static final Function1<String, String> j(final String str) {
        if (str.length() == 0) {
            return new Function1() { // from class: kotlin.text.x
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    String k6;
                    k6 = z.k((String) obj);
                    return k6;
                }
            };
        }
        return new Function1() { // from class: kotlin.text.y
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                String l6;
                l6 = z.l(str, (String) obj);
                return l6;
            }
        };
    }

    private static final int m(String str) {
        int length = str.length();
        int i6 = 0;
        while (true) {
            if (i6 < length) {
                if (!c.r(str.charAt(i6))) {
                    break;
                }
                i6++;
            } else {
                i6 = -1;
                break;
            }
        }
        if (i6 == -1) {
            return str.length();
        }
        return i6;
    }

    private static final String q(List<String> list, int i6, Function1<? super String, String> function1, Function1<? super String, String> function12) {
        Appendable o32;
        String invoke;
        int L = kotlin.collections.f0.L(list);
        ArrayList arrayList = new ArrayList();
        int i7 = 0;
        for (Object obj : list) {
            int i8 = i7 + 1;
            if (i7 < 0) {
                kotlin.collections.f0.b0();
            }
            String str = (String) obj;
            if ((i7 == 0 || i7 == L) && l0.M3(str)) {
                str = null;
            } else {
                String invoke2 = function12.invoke(str);
                if (invoke2 != null && (invoke = function1.invoke(invoke2)) != null) {
                    str = invoke;
                }
            }
            if (str != null) {
                arrayList.add(str);
            }
            i7 = i8;
        }
        o32 = kotlin.collections.r0.o3(arrayList, new StringBuilder(i6), (r14 & 2) != 0 ? ", " : com.snail.antifake.deviceid.e.f37542d, (r14 & 4) != 0 ? "" : null, (r14 & 8) == 0 ? null : "", (r14 & 16) != 0 ? -1 : 0, (r14 & 32) != 0 ? "..." : null, (r14 & 64) != 0 ? null : null);
        return ((StringBuilder) o32).toString();
    }
}
