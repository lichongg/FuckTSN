package androidx.room;

import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.collections.d1;
import kotlin.collections.f0;
import kotlin.collections.u1;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
@SourceDebugExtension({"SMAP\nAmbiguousColumnResolver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AmbiguousColumnResolver.kt\nandroidx/room/AmbiguousColumnResolver\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,273:1\n37#2:274\n36#2,3:275\n37#2:300\n36#2,3:301\n1#3:278\n13402#4,2:279\n13467#4,3:281\n13467#4,2:284\n11158#4:286\n11493#4,2:287\n11495#4:291\n13469#4:292\n11158#4:306\n11493#4,2:307\n11495#4:311\n1863#5,2:289\n1734#5,3:293\n1557#5:296\n1628#5,3:297\n1863#5,2:304\n295#5,2:309\n*S KotlinDebug\n*F\n+ 1 AmbiguousColumnResolver.kt\nandroidx/room/AmbiguousColumnResolver\n*L\n65#1:274\n65#1:275,3\n171#1:300\n171#1:301,3\n102#1:279,2\n104#1:281,3\n113#1:284,2\n138#1:286\n138#1:287,2\n138#1:291\n113#1:292\n120#1:306\n120#1:307,2\n120#1:311\n140#1:289,2\n161#1:293,3\n171#1:296\n171#1:297,3\n208#1:304,2\n122#1:309,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class AmbiguousColumnResolver {

    @NotNull
    public static final AmbiguousColumnResolver INSTANCE = new AmbiguousColumnResolver();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class Match {

        @NotNull
        private final List<Integer> resultIndices;

        @NotNull
        private final kotlin.ranges.m resultRange;

        public Match(@NotNull kotlin.ranges.m resultRange, @NotNull List<Integer> resultIndices) {
            g0.p(resultRange, "resultRange");
            g0.p(resultIndices, "resultIndices");
            this.resultRange = resultRange;
            this.resultIndices = resultIndices;
        }

        @NotNull
        public final List<Integer> getResultIndices() {
            return this.resultIndices;
        }

        @NotNull
        public final kotlin.ranges.m getResultRange() {
            return this.resultRange;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class ResultColumn {
        private final int index;

        @NotNull
        private final String name;

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ResultColumn)) {
                return false;
            }
            ResultColumn resultColumn = (ResultColumn) obj;
            return g0.g(this.name, resultColumn.name) && this.index == resultColumn.index;
        }

        public ResultColumn(@NotNull String name, int i6) {
            g0.p(name, "name");
            this.name = name;
            this.index = i6;
        }

        public static /* synthetic */ ResultColumn copy$default(ResultColumn resultColumn, String str, int i6, int i7, Object obj) {
            if ((i7 & 1) != 0) {
                str = resultColumn.name;
            }
            if ((i7 & 2) != 0) {
                i6 = resultColumn.index;
            }
            return resultColumn.copy(str, i6);
        }

        @NotNull
        public final String component1() {
            return this.name;
        }

        public final int component2() {
            return this.index;
        }

        @NotNull
        public final ResultColumn copy(@NotNull String name, int i6) {
            g0.p(name, "name");
            return new ResultColumn(name, i6);
        }

        public final int getIndex() {
            return this.index;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + this.index;
        }

        @NotNull
        public String toString() {
            return "ResultColumn(name=" + this.name + ", index=" + this.index + ')';
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class Solution implements Comparable<Solution> {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private static final Solution NO_SOLUTION = new Solution(f0.J(), Integer.MAX_VALUE, Integer.MAX_VALUE);
        private final int coverageOffset;

        @NotNull
        private final List<Match> matches;
        private final int overlaps;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @SourceDebugExtension({"SMAP\nAmbiguousColumnResolver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AmbiguousColumnResolver.kt\nandroidx/room/AmbiguousColumnResolver$Solution$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,273:1\n1#2:274\n1782#3,3:275\n1863#3,2:278\n1785#3:280\n*S KotlinDebug\n*F\n+ 1 AmbiguousColumnResolver.kt\nandroidx/room/AmbiguousColumnResolver$Solution$Companion\n*L\n252#1:275,3\n254#1:278,2\n252#1:280\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.v vVar) {
                this();
            }

            private Companion() {
            }

            @NotNull
            public final Solution build(@NotNull List<Match> matches) {
                g0.p(matches, "matches");
                List<Match> list = matches;
                int i6 = 0;
                int i7 = 0;
                for (Match match : list) {
                    i7 += ((match.getResultRange().f() - match.getResultRange().e()) + 1) - match.getResultIndices().size();
                }
                Iterator<T> it = list.iterator();
                if (!it.hasNext()) {
                    throw new NoSuchElementException();
                }
                int e6 = ((Match) it.next()).getResultRange().e();
                while (it.hasNext()) {
                    int e7 = ((Match) it.next()).getResultRange().e();
                    if (e6 > e7) {
                        e6 = e7;
                    }
                }
                Iterator<T> it2 = list.iterator();
                if (!it2.hasNext()) {
                    throw new NoSuchElementException();
                }
                int f6 = ((Match) it2.next()).getResultRange().f();
                while (it2.hasNext()) {
                    int f7 = ((Match) it2.next()).getResultRange().f();
                    if (f6 < f7) {
                        f6 = f7;
                    }
                }
                Iterable mVar = new kotlin.ranges.m(e6, f6);
                if (!(mVar instanceof Collection) || !((Collection) mVar).isEmpty()) {
                    Iterator it3 = mVar.iterator();
                    int i8 = 0;
                    while (it3.hasNext()) {
                        int nextInt = ((d1) it3).nextInt();
                        Iterator<T> it4 = list.iterator();
                        int i9 = 0;
                        while (true) {
                            if (!it4.hasNext()) {
                                break;
                            }
                            if (((Match) it4.next()).getResultRange().n(nextInt)) {
                                i9++;
                            }
                            if (i9 > 1) {
                                i8++;
                                if (i8 < 0) {
                                    f0.a0();
                                }
                            }
                        }
                    }
                    i6 = i8;
                }
                return new Solution(matches, i7, i6);
            }

            @NotNull
            public final Solution getNO_SOLUTION() {
                return Solution.NO_SOLUTION;
            }
        }

        public Solution(@NotNull List<Match> matches, int i6, int i7) {
            g0.p(matches, "matches");
            this.matches = matches;
            this.coverageOffset = i6;
            this.overlaps = i7;
        }

        @Override // java.lang.Comparable
        public int compareTo(@NotNull Solution other) {
            g0.p(other, "other");
            int t5 = g0.t(this.overlaps, other.overlaps);
            return t5 != 0 ? t5 : g0.t(this.coverageOffset, other.coverageOffset);
        }

        public final int getCoverageOffset() {
            return this.coverageOffset;
        }

        @NotNull
        public final List<Match> getMatches() {
            return this.matches;
        }

        public final int getOverlaps() {
            return this.overlaps;
        }
    }

    private final void rabinKarpSearch(List<ResultColumn> list, String[] strArr, Function3<? super Integer, ? super Integer, ? super List<ResultColumn>, n1> function3) {
        int i6 = 0;
        int i7 = 0;
        for (String str : strArr) {
            i7 += str.hashCode();
        }
        int length = strArr.length;
        Iterator<T> it = list.subList(0, length).iterator();
        int i8 = 0;
        while (it.hasNext()) {
            i8 += ((ResultColumn) it.next()).getName().hashCode();
        }
        while (true) {
            if (i7 == i8) {
                function3.invoke(Integer.valueOf(i6), Integer.valueOf(length), list.subList(i6, length));
            }
            int i9 = i6 + 1;
            int i10 = length + 1;
            if (i10 > list.size()) {
                return;
            }
            i8 = (i8 - list.get(i6).getName().hashCode()) + list.get(length).getName().hashCode();
            i6 = i9;
            length = i10;
        }
    }

    @JvmStatic
    @NotNull
    public static final int[][] resolve(@NotNull List<String> resultColumns, @NotNull String[][] mappings) {
        g0.p(resultColumns, "resultColumns");
        g0.p(mappings, "mappings");
        return resolve((String[]) resultColumns.toArray(new String[0]), mappings);
    }

    static /* synthetic */ void dfs$default(AmbiguousColumnResolver ambiguousColumnResolver, List list, List list2, int i6, Function1 function1, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            list2 = new ArrayList();
        }
        if ((i7 & 4) != 0) {
            i6 = 0;
        }
        ambiguousColumnResolver.dfs(list, list2, i6, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 resolve$lambda$16$lambda$15(List list, int i6, List indices) {
        g0.p(indices, "indices");
        List list2 = indices;
        Iterator it = list2.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        int intValue = ((Number) it.next()).intValue();
        while (it.hasNext()) {
            int intValue2 = ((Number) it.next()).intValue();
            if (intValue > intValue2) {
                intValue = intValue2;
            }
        }
        Iterator it2 = list2.iterator();
        if (!it2.hasNext()) {
            throw new NoSuchElementException();
        }
        int intValue3 = ((Number) it2.next()).intValue();
        while (it2.hasNext()) {
            int intValue4 = ((Number) it2.next()).intValue();
            if (intValue3 < intValue4) {
                intValue3 = intValue4;
            }
        }
        ((List) list.get(i6)).add(new Match(new kotlin.ranges.m(intValue, intValue3), indices));
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 resolve$lambda$16$lambda$7(String[] strArr, List list, int i6, int i7, int i8, List resultColumnsSublist) {
        Object obj;
        g0.p(resultColumnsSublist, "resultColumnsSublist");
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            Iterator it = resultColumnsSublist.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (g0.g(str, ((ResultColumn) obj).component1())) {
                    break;
                }
            }
            ResultColumn resultColumn = (ResultColumn) obj;
            if (resultColumn == null) {
                return n1.f44123a;
            }
            arrayList.add(Integer.valueOf(resultColumn.getIndex()));
        }
        ((List) list.get(i6)).add(new Match(new kotlin.ranges.m(i7, i8 - 1), arrayList));
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, androidx.room.AmbiguousColumnResolver$Solution] */
    public static final n1 resolve$lambda$19(Ref.ObjectRef objectRef, List it) {
        g0.p(it, "it");
        ?? build = Solution.Companion.build(it);
        if (build.compareTo((Solution) objectRef.element) < 0) {
            objectRef.element = build;
        }
        return n1.f44123a;
    }

    private AmbiguousColumnResolver() {
    }

    private final <T> void dfs(List<? extends List<? extends T>> list, List<T> list2, int i6, Function1<? super List<? extends T>, n1> function1) {
        if (i6 == list.size()) {
            function1.invoke(f0.a6(list2));
            return;
        }
        Iterator<T> it = list.get(i6).iterator();
        while (it.hasNext()) {
            list2.add(it.next());
            INSTANCE.dfs(list, list2, i6 + 1, function1);
            list2.remove(f0.L(list2));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [T, androidx.room.AmbiguousColumnResolver$Solution] */
    @JvmStatic
    @NotNull
    public static final int[][] resolve(@NotNull String[] resultColumns, @NotNull String[][] mappings) {
        g0.p(resultColumns, "resultColumns");
        g0.p(mappings, "mappings");
        int length = resultColumns.length;
        for (int i6 = 0; i6 < length; i6++) {
            String str = resultColumns[i6];
            if (str.charAt(0) == '`' && str.charAt(str.length() - 1) == '`') {
                str = str.substring(1, str.length() - 1);
                g0.o(str, "substring(...)");
            }
            String lowerCase = str.toLowerCase(Locale.ROOT);
            g0.o(lowerCase, "toLowerCase(...)");
            resultColumns[i6] = lowerCase;
        }
        int length2 = mappings.length;
        for (int i7 = 0; i7 < length2; i7++) {
            int length3 = mappings[i7].length;
            for (int i8 = 0; i8 < length3; i8++) {
                String[] strArr = mappings[i7];
                String lowerCase2 = strArr[i8].toLowerCase(Locale.ROOT);
                g0.o(lowerCase2, "toLowerCase(...)");
                strArr[i8] = lowerCase2;
            }
        }
        Set d6 = u1.d();
        for (String[] strArr2 : mappings) {
            f0.u0(d6, strArr2);
        }
        Set a6 = u1.a(d6);
        List j6 = f0.j();
        int length4 = resultColumns.length;
        int i9 = 0;
        int i10 = 0;
        while (i9 < length4) {
            String str2 = resultColumns[i9];
            int i11 = i10 + 1;
            if (a6.contains(str2)) {
                j6.add(new ResultColumn(str2, i10));
            }
            i9++;
            i10 = i11;
        }
        List<ResultColumn> b6 = f0.b(j6);
        int length5 = mappings.length;
        final ArrayList arrayList = new ArrayList(length5);
        for (int i12 = 0; i12 < length5; i12++) {
            arrayList.add(new ArrayList());
        }
        int length6 = mappings.length;
        int i13 = 0;
        final int i14 = 0;
        while (i13 < length6) {
            final String[] strArr3 = mappings[i13];
            int i15 = i14 + 1;
            INSTANCE.rabinKarpSearch(b6, strArr3, new Function3() { // from class: androidx.room.a
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    n1 resolve$lambda$16$lambda$7;
                    resolve$lambda$16$lambda$7 = AmbiguousColumnResolver.resolve$lambda$16$lambda$7(strArr3, arrayList, i14, ((Integer) obj).intValue(), ((Integer) obj2).intValue(), (List) obj3);
                    return resolve$lambda$16$lambda$7;
                }
            });
            if (((List) arrayList.get(i14)).isEmpty()) {
                ArrayList arrayList2 = new ArrayList(strArr3.length);
                for (String str3 : strArr3) {
                    List j7 = f0.j();
                    for (ResultColumn resultColumn : b6) {
                        if (g0.g(str3, resultColumn.getName())) {
                            j7.add(Integer.valueOf(resultColumn.getIndex()));
                        }
                    }
                    List b7 = f0.b(j7);
                    if (!b7.isEmpty()) {
                        arrayList2.add(b7);
                    } else {
                        throw new IllegalStateException(("Column " + str3 + " not found in result").toString());
                    }
                }
                dfs$default(INSTANCE, arrayList2, null, 0, new Function1() { // from class: androidx.room.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        n1 resolve$lambda$16$lambda$15;
                        resolve$lambda$16$lambda$15 = AmbiguousColumnResolver.resolve$lambda$16$lambda$15(arrayList, i14, (List) obj);
                        return resolve$lambda$16$lambda$15;
                    }
                }, 6, null);
            }
            i13++;
            i14 = i15;
        }
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (((List) it.next()).isEmpty()) {
                    throw new IllegalStateException("Failed to find matches for all mappings");
                }
            }
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = Solution.Companion.getNO_SOLUTION();
        dfs$default(INSTANCE, arrayList, null, 0, new Function1() { // from class: androidx.room.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 resolve$lambda$19;
                resolve$lambda$19 = AmbiguousColumnResolver.resolve$lambda$19(Ref.ObjectRef.this, (List) obj);
                return resolve$lambda$19;
            }
        }, 6, null);
        List<Match> matches = ((Solution) objectRef.element).getMatches();
        ArrayList arrayList3 = new ArrayList(f0.d0(matches, 10));
        Iterator<T> it2 = matches.iterator();
        while (it2.hasNext()) {
            arrayList3.add(f0.Z5(((Match) it2.next()).getResultIndices()));
        }
        return (int[][]) arrayList3.toArray(new int[0][]);
    }
}
