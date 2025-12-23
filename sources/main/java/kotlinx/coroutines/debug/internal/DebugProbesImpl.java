package kotlinx.coroutines.debug.internal;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.collections.f0;
import kotlin.collections.i1;
import kotlin.collections.n;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.u0;
import kotlin.jvm.internal.v;
import kotlin.n1;
import kotlin.o0;
import kotlin.ranges.t;
import kotlin.sequences.p;
import kotlin.text.u;
import kotlinx.coroutines.debug.internal.DebugProbesImpl;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.h2;
import kotlinx.coroutines.l2;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.p0;
import kotlinx.coroutines.q0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@PublishedApi
@SourceDebugExtension({"SMAP\nDebugProbesImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugProbesImpl.kt\nkotlinx/coroutines/debug/internal/DebugProbesImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 5 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 6 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,620:1\n150#1:638\n151#1,4:640\n156#1,5:645\n150#1:650\n151#1,4:652\n156#1,5:657\n1#2:621\n1#2:639\n1#2:651\n766#3:622\n857#3,2:623\n1208#3,2:625\n1238#3,4:627\n1855#3,2:665\n350#3,7:673\n1819#3,8:680\n603#4:631\n603#4:644\n603#4:656\n603#4:662\n1295#4,2:663\n37#5,2:632\n37#5,2:634\n37#5,2:636\n1627#6,6:667\n1735#6,6:688\n*S KotlinDebug\n*F\n+ 1 DebugProbesImpl.kt\nkotlinx/coroutines/debug/internal/DebugProbesImpl\n*L\n245#1:638\n245#1:640,4\n245#1:645,5\n252#1:650\n252#1:652,4\n252#1:657,5\n245#1:639\n252#1:651\n110#1:622\n110#1:623,2\n111#1:625,2\n111#1:627,4\n307#1:665,2\n416#1:673,7\n506#1:680,8\n154#1:631\n245#1:644\n252#1:656\n287#1:662\n288#1:663,2\n211#1:632,2\n212#1:634,2\n213#1:636,2\n355#1:667,6\n558#1:688,6\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class DebugProbesImpl {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final DebugProbesImpl f48479a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final StackTraceElement f48480b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final SimpleDateFormat f48481c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private static Thread f48482d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final kotlinx.coroutines.debug.internal.b<a<?>, Boolean> f48483e;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f48484f;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f48485g;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f48486h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    private static final Function1<Boolean, n1> f48487i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private static final kotlinx.coroutines.debug.internal.b<kotlin.coroutines.jvm.internal.c, kotlinx.coroutines.debug.internal.e> f48488j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    private static final b f48489k;

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    private static final c f48490l;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a<T> implements kotlin.coroutines.e<T>, kotlin.coroutines.jvm.internal.c {

        /* renamed from: a, reason: collision with root package name */
        @JvmField
        @NotNull
        public final kotlin.coroutines.e<T> f48491a;

        /* renamed from: b, reason: collision with root package name */
        @JvmField
        @NotNull
        public final kotlinx.coroutines.debug.internal.e f48492b;

        private final k b() {
            return this.f48492b.c();
        }

        @Override // kotlin.coroutines.e
        @NotNull
        public kotlin.coroutines.i getContext() {
            return this.f48491a.getContext();
        }

        @Override // kotlin.coroutines.e
        public void resumeWith(@NotNull Object obj) {
            DebugProbesImpl.f48479a.F(this);
            this.f48491a.resumeWith(obj);
        }

        @NotNull
        public String toString() {
            return this.f48491a.toString();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull kotlin.coroutines.e<? super T> eVar, @NotNull kotlinx.coroutines.debug.internal.e eVar2) {
            this.f48491a = eVar;
            this.f48492b = eVar2;
        }

        @Override // kotlin.coroutines.jvm.internal.c
        @Nullable
        public kotlin.coroutines.jvm.internal.c getCallerFrame() {
            k b6 = b();
            if (b6 != null) {
                return b6.getCallerFrame();
            }
            return null;
        }

        @Override // kotlin.coroutines.jvm.internal.c
        @Nullable
        public StackTraceElement getStackTraceElement() {
            k b6 = b();
            if (b6 != null) {
                return b6.getStackTraceElement();
            }
            return null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private static final AtomicIntegerFieldUpdater f48493a = AtomicIntegerFieldUpdater.newUpdater(b.class, "installations");

        @Volatile
        private volatile int installations;

        private b() {
        }

        public /* synthetic */ b(v vVar) {
            this();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class c {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private static final AtomicLongFieldUpdater f48494a = AtomicLongFieldUpdater.newUpdater(c.class, "sequenceNumber");

        @Volatile
        private volatile long sequenceNumber;

        private c() {
        }

        public /* synthetic */ c(v vVar) {
            this();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2\n+ 2 DebugProbesImpl.kt\nkotlinx/coroutines/debug/internal/DebugProbesImpl\n*L\n1#1,328:1\n154#2:329\n*E\n"})
    public static final class d<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t5, T t6) {
            return kotlin.comparisons.a.l(Long.valueOf(((a) t5).f48492b.f48534b), Long.valueOf(((a) t6).f48492b.f48534b));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2\n+ 2 DebugProbesImpl.kt\nkotlinx/coroutines/debug/internal/DebugProbesImpl\n*L\n1#1,328:1\n287#2:329\n*E\n"})
    public static final class e<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t5, T t6) {
            return kotlin.comparisons.a.l(Long.valueOf(((a) t5).f48492b.f48534b), Long.valueOf(((a) t6).f48492b.f48534b));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class f extends Lambda implements Function1<a<?>, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public static final f f48495a = new f();

        f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(@NotNull a<?> aVar) {
            return Boolean.valueOf(!DebugProbesImpl.f48479a.z(aVar));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class g extends Lambda implements Function0<n1> {

        /* renamed from: a, reason: collision with root package name */
        public static final g f48496a = new g();

        g() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ n1 invoke() {
            invoke2();
            return n1.f44123a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            DebugProbesImpl.f48488j.m();
        }
    }

    private final Pair<Integer, Integer> o(int i6, StackTraceElement[] stackTraceElementArr, List<StackTraceElement> list) {
        for (int i7 = 0; i7 < 3; i7++) {
            int p5 = f48479a.p((i6 - 1) - i7, stackTraceElementArr, list);
            if (p5 != -1) {
                return o0.a(Integer.valueOf(p5), Integer.valueOf(i7));
            }
        }
        return o0.a(-1, 0);
    }

    private final Function1<Boolean, n1> t() {
        Object m130constructorimpl;
        try {
            Result.a aVar = Result.Companion;
            Object newInstance = Class.forName("kotlinx.coroutines.debug.internal.ByteBuddyDynamicAttach").getConstructors()[0].newInstance(null);
            g0.n(newInstance, "null cannot be cast to non-null type kotlin.Function1<kotlin.Boolean, kotlin.Unit>");
            m130constructorimpl = Result.m130constructorimpl((Function1) u0.q(newInstance, 1));
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            m130constructorimpl = Result.m130constructorimpl(kotlin.g0.a(th));
        }
        return (Function1) (Result.m136isFailureimpl(m130constructorimpl) ? null : m130constructorimpl);
    }

    @JvmName(name = "dumpCoroutines")
    public final void f(@NotNull PrintStream printStream) {
        synchronized (printStream) {
            f48479a.j(printStream);
            n1 n1Var = n1.f44123a;
        }
    }

    static {
        DebugProbesImpl debugProbesImpl = new DebugProbesImpl();
        f48479a = debugProbesImpl;
        f48480b = new _COROUTINE.a().b();
        f48481c = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        v vVar = null;
        f48483e = new kotlinx.coroutines.debug.internal.b<>(false, 1, null);
        f48484f = true;
        f48485g = true;
        f48486h = true;
        f48487i = debugProbesImpl.t();
        f48488j = new kotlinx.coroutines.debug.internal.b<>(true);
        f48489k = new b(vVar);
        f48490l = new c(vVar);
    }

    private final a<?> C(kotlin.coroutines.e<?> eVar) {
        kotlin.coroutines.jvm.internal.c cVar = eVar instanceof kotlin.coroutines.jvm.internal.c ? (kotlin.coroutines.jvm.internal.c) eVar : null;
        if (cVar != null) {
            return D(cVar);
        }
        return null;
    }

    private final a<?> D(kotlin.coroutines.jvm.internal.c cVar) {
        while (!(cVar instanceof a)) {
            cVar = cVar.getCallerFrame();
            if (cVar == null) {
                return null;
            }
        }
        return (a) cVar;
    }

    private final void E(PrintStream printStream, List<StackTraceElement> list) {
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Objects.toString((StackTraceElement) it.next());
            printStream.getClass();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F(a<?> aVar) {
        kotlin.coroutines.jvm.internal.c J;
        f48483e.remove(aVar);
        kotlin.coroutines.jvm.internal.c e6 = aVar.f48492b.e();
        if (e6 == null || (J = J(e6)) == null) {
            return;
        }
        f48488j.remove(J);
    }

    private final void O() {
        f48482d = kotlin.concurrent.b.c(false, true, null, "Coroutines Debugger Cleaner", 0, g.f48496a, 21, null);
    }

    private final void P() {
        Thread thread = f48482d;
        if (thread == null) {
            return;
        }
        f48482d = null;
        thread.interrupt();
        thread.join();
    }

    private final List<StackTraceElement> n(String str, Thread thread, List<StackTraceElement> list) {
        Object m130constructorimpl;
        if (g0.g(str, kotlinx.coroutines.debug.internal.f.f48548b) && thread != null) {
            try {
                Result.a aVar = Result.Companion;
                m130constructorimpl = Result.m130constructorimpl(thread.getStackTrace());
            } catch (Throwable th) {
                Result.a aVar2 = Result.Companion;
                m130constructorimpl = Result.m130constructorimpl(kotlin.g0.a(th));
            }
            if (Result.m136isFailureimpl(m130constructorimpl)) {
                m130constructorimpl = null;
            }
            StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) m130constructorimpl;
            if (stackTraceElementArr != null) {
                int length = stackTraceElementArr.length;
                int i6 = 0;
                while (true) {
                    if (i6 >= length) {
                        i6 = -1;
                        break;
                    }
                    StackTraceElement stackTraceElement = stackTraceElementArr[i6];
                    if (g0.g(stackTraceElement.getClassName(), "kotlin.coroutines.jvm.internal.BaseContinuationImpl") && g0.g(stackTraceElement.getMethodName(), "resumeWith") && g0.g(stackTraceElement.getFileName(), "ContinuationImpl.kt")) {
                        break;
                    }
                    i6++;
                }
                Pair<Integer, Integer> o5 = o(i6, stackTraceElementArr, list);
                int intValue = o5.component1().intValue();
                int intValue2 = o5.component2().intValue();
                if (intValue != -1) {
                    ArrayList arrayList = new ArrayList((((list.size() + i6) - intValue) - 1) - intValue2);
                    int i7 = i6 - intValue2;
                    for (int i8 = 0; i8 < i7; i8++) {
                        arrayList.add(stackTraceElementArr[i8]);
                    }
                    int size = list.size();
                    for (int i9 = intValue + 1; i9 < size; i9++) {
                        arrayList.add(list.get(i9));
                    }
                    return arrayList;
                }
            }
        }
        return list;
    }

    private final Set<a<?>> q() {
        return f48483e.keySet();
    }

    private final String r(e2 e2Var) {
        return e2Var instanceof l2 ? ((l2) e2Var).p1() : e2Var.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean z(a<?> aVar) {
        e2 e2Var;
        kotlin.coroutines.i context = aVar.f48492b.getContext();
        if (context == null || (e2Var = (e2) context.get(e2.f48569s0)) == null || !e2Var.isCompleted()) {
            return false;
        }
        f48483e.remove(aVar);
        return true;
    }

    public final void H(@NotNull kotlin.coroutines.e<?> eVar) {
        U(eVar, kotlinx.coroutines.debug.internal.f.f48548b);
    }

    public final void I(@NotNull kotlin.coroutines.e<?> eVar) {
        U(eVar, kotlinx.coroutines.debug.internal.f.f48549c);
    }

    public final void L(boolean z5) {
        f48485g = z5;
    }

    public final void M(boolean z5) {
        f48486h = z5;
    }

    public final void N(boolean z5) {
        f48484f = z5;
    }

    public final boolean u() {
        return f48485g;
    }

    public final boolean v() {
        return f48486h;
    }

    public final boolean w() {
        return f48484f;
    }

    private DebugProbesImpl() {
    }

    private final boolean B(StackTraceElement stackTraceElement) {
        return u.H2(stackTraceElement.getClassName(), "kotlinx.coroutines", false, 2, null);
    }

    private final kotlin.coroutines.jvm.internal.c J(kotlin.coroutines.jvm.internal.c cVar) {
        do {
            cVar = cVar.getCallerFrame();
            if (cVar == null) {
                return null;
            }
        } while (cVar.getStackTraceElement() == null);
        return cVar;
    }

    private final <T extends Throwable> List<StackTraceElement> K(T t5) {
        StackTraceElement[] stackTrace = t5.getStackTrace();
        int length = stackTrace.length;
        int i6 = -1;
        int length2 = stackTrace.length - 1;
        if (length2 >= 0) {
            while (true) {
                int i7 = length2 - 1;
                if (g0.g(stackTrace[length2].getClassName(), "kotlin.coroutines.jvm.internal.DebugProbesKt")) {
                    i6 = length2;
                    break;
                }
                if (i7 < 0) {
                    break;
                }
                length2 = i7;
            }
        }
        int i8 = i6 + 1;
        if (!f48484f) {
            int i9 = length - i8;
            ArrayList arrayList = new ArrayList(i9);
            for (int i10 = 0; i10 < i9; i10++) {
                arrayList.add(stackTrace[i10 + i8]);
            }
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList((length - i8) + 1);
        while (i8 < length) {
            if (B(stackTrace[i8])) {
                arrayList2.add(stackTrace[i8]);
                int i11 = i8 + 1;
                while (i11 < length && B(stackTrace[i11])) {
                    i11++;
                }
                int i12 = i11 - 1;
                int i13 = i12;
                while (i13 > i8 && stackTrace[i13].getFileName() == null) {
                    i13--;
                }
                if (i13 > i8 && i13 < i12) {
                    arrayList2.add(stackTrace[i13]);
                }
                arrayList2.add(stackTrace[i12]);
                i8 = i11;
            } else {
                arrayList2.add(stackTrace[i8]);
                i8++;
            }
        }
        return arrayList2;
    }

    private final k Q(List<StackTraceElement> list) {
        k kVar = null;
        if (!list.isEmpty()) {
            ListIterator<StackTraceElement> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                kVar = new k(kVar, listIterator.previous());
            }
        }
        return new k(kVar, f48480b);
    }

    private final String R(Object obj) {
        String b6;
        b6 = kotlinx.coroutines.debug.internal.g.b(obj.toString());
        return b6;
    }

    private final void T(kotlin.coroutines.jvm.internal.c cVar, String str) {
        kotlin.coroutines.jvm.internal.c cVar2;
        boolean z5;
        if (A()) {
            kotlinx.coroutines.debug.internal.b<kotlin.coroutines.jvm.internal.c, kotlinx.coroutines.debug.internal.e> bVar = f48488j;
            kotlinx.coroutines.debug.internal.e remove = bVar.remove(cVar);
            if (remove != null) {
                z5 = false;
            } else {
                a<?> D = D(cVar);
                if (D != null && (remove = D.f48492b) != null) {
                    kotlin.coroutines.jvm.internal.c e6 = remove.e();
                    if (e6 != null) {
                        cVar2 = J(e6);
                    } else {
                        cVar2 = null;
                    }
                    if (cVar2 != null) {
                        bVar.remove(cVar2);
                    }
                    z5 = true;
                } else {
                    return;
                }
            }
            g0.n(cVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<*>");
            remove.i(str, (kotlin.coroutines.e) cVar, z5);
            kotlin.coroutines.jvm.internal.c J = J(cVar);
            if (J != null) {
                bVar.put(J, remove);
            }
        }
    }

    private final void U(kotlin.coroutines.e<?> eVar, String str) {
        kotlin.coroutines.jvm.internal.c cVar;
        if (A()) {
            if (!f48486h || eVar.getContext() != EmptyCoroutineContext.INSTANCE) {
                if (g0.g(str, kotlinx.coroutines.debug.internal.f.f48548b)) {
                    if (eVar instanceof kotlin.coroutines.jvm.internal.c) {
                        cVar = (kotlin.coroutines.jvm.internal.c) eVar;
                    } else {
                        cVar = null;
                    }
                    if (cVar != null) {
                        T(cVar, str);
                        return;
                    }
                    return;
                }
                a<?> C = C(eVar);
                if (C == null) {
                    return;
                }
                V(C, eVar, str);
            }
        }
    }

    private final void V(a<?> aVar, kotlin.coroutines.e<?> eVar, String str) {
        if (!A()) {
            return;
        }
        aVar.f48492b.i(str, eVar, true);
    }

    private final void d(e2 e2Var, Map<e2, kotlinx.coroutines.debug.internal.e> map, StringBuilder sb, String str) {
        kotlinx.coroutines.debug.internal.e eVar = map.get(e2Var);
        if (eVar == null) {
            if (!(e2Var instanceof kotlinx.coroutines.internal.o0)) {
                sb.append(str + r(e2Var) + '\n');
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append('\t');
                str = sb2.toString();
            }
        } else {
            StackTraceElement stackTraceElement = (StackTraceElement) f0.L2(eVar.g());
            sb.append(str + r(e2Var) + ", continuation is " + eVar.f() + " at line " + stackTraceElement + '\n');
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append('\t');
            str = sb3.toString();
        }
        Iterator<e2> it = e2Var.E().iterator();
        while (it.hasNext()) {
            d(it.next(), map, sb, str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <T> kotlin.coroutines.e<T> e(kotlin.coroutines.e<? super T> eVar, k kVar) {
        if (!A()) {
            return eVar;
        }
        a<?> aVar = new a<>(eVar, new kotlinx.coroutines.debug.internal.e(eVar.getContext(), kVar, c.f48494a.incrementAndGet(f48490l)));
        kotlinx.coroutines.debug.internal.b<a<?>, Boolean> bVar = f48483e;
        bVar.put(aVar, Boolean.TRUE);
        if (!A()) {
            bVar.clear();
        }
        return aVar;
    }

    private final <R> List<R> i(final Function2<? super a<?>, ? super kotlin.coroutines.i, ? extends R> function2) {
        if (A()) {
            return p.I3(p.S1(p.q3(f0.E1(q()), new d()), new Function1<a<?>, R>() { // from class: kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesInfoImpl$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final R invoke(@NotNull DebugProbesImpl.a<?> aVar) {
                    kotlin.coroutines.i context;
                    if (DebugProbesImpl.f48479a.z(aVar) || (context = aVar.f48492b.getContext()) == null) {
                        return null;
                    }
                    return function2.invoke(aVar, context);
                }
            }));
        }
        throw new IllegalStateException("Debug probes are not installed");
    }

    private final void j(PrintStream printStream) {
        if (A()) {
            f48481c.format(Long.valueOf(System.currentTimeMillis()));
            printStream.getClass();
            for (a aVar : p.q3(p.P0(f0.E1(q()), f.f48495a), new e())) {
                kotlinx.coroutines.debug.internal.e eVar = aVar.f48492b;
                List<StackTraceElement> g6 = eVar.g();
                DebugProbesImpl debugProbesImpl = f48479a;
                List<StackTraceElement> n6 = debugProbesImpl.n(eVar.f(), eVar.lastObservedThread, g6);
                if (g0.g(eVar.f(), kotlinx.coroutines.debug.internal.f.f48548b) && n6 == g6) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(eVar.f());
                    sb.append(" (Last suspension stacktrace, not an actual stacktrace)");
                } else {
                    eVar.f();
                }
                Objects.toString(aVar.f48491a);
                if (g6.isEmpty()) {
                    Objects.toString(f48480b);
                    debugProbesImpl.E(printStream, eVar.d());
                } else {
                    debugProbesImpl.E(printStream, n6);
                }
            }
            return;
        }
        throw new IllegalStateException("Debug probes are not installed");
    }

    private final int p(int i6, StackTraceElement[] stackTraceElementArr, List<StackTraceElement> list) {
        StackTraceElement stackTraceElement = (StackTraceElement) n.hf(stackTraceElementArr, i6);
        if (stackTraceElement == null) {
            return -1;
        }
        int i7 = 0;
        for (StackTraceElement stackTraceElement2 : list) {
            if (g0.g(stackTraceElement2.getFileName(), stackTraceElement.getFileName()) && g0.g(stackTraceElement2.getClassName(), stackTraceElement.getClassName()) && g0.g(stackTraceElement2.getMethodName(), stackTraceElement.getMethodName())) {
                return i7;
            }
            i7++;
        }
        return -1;
    }

    @JvmName(name = "isInstalled$kotlinx_coroutines_debug")
    public final boolean A() {
        if (b.f48493a.get(f48489k) > 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final <T> kotlin.coroutines.e<T> G(@NotNull kotlin.coroutines.e<? super T> eVar) {
        k kVar;
        if (A()) {
            if (f48486h && eVar.getContext() == EmptyCoroutineContext.INSTANCE) {
                return eVar;
            }
            if (C(eVar) == null) {
                if (f48485g) {
                    kVar = Q(K(new Exception()));
                } else {
                    kVar = null;
                }
                return e(eVar, kVar);
            }
        }
        return eVar;
    }

    public final void S() {
        Function1<Boolean, n1> function1;
        if (A()) {
            if (b.f48493a.decrementAndGet(f48489k) == 0) {
                P();
                f48483e.clear();
                f48488j.clear();
                if (!kotlinx.coroutines.debug.internal.a.f48497a.a() && (function1 = f48487i) != null) {
                    function1.invoke(Boolean.FALSE);
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("Agent was not installed");
    }

    @NotNull
    public final List<kotlinx.coroutines.debug.internal.d> g() {
        if (A()) {
            return p.I3(p.S1(p.q3(f0.E1(q()), new d()), new Function1<a<?>, kotlinx.coroutines.debug.internal.d>() { // from class: kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesInfo$$inlined$dumpCoroutinesInfoImpl$1
                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final d invoke(@NotNull DebugProbesImpl.a<?> aVar) {
                    kotlin.coroutines.i context;
                    if (DebugProbesImpl.f48479a.z(aVar) || (context = aVar.f48492b.getContext()) == null) {
                        return null;
                    }
                    return new d(aVar.f48492b, context);
                }
            }));
        }
        throw new IllegalStateException("Debug probes are not installed");
    }

    @NotNull
    public final Object[] h() {
        String str;
        String str2;
        String w5;
        List<kotlinx.coroutines.debug.internal.d> g6 = g();
        int size = g6.size();
        ArrayList arrayList = new ArrayList(size);
        ArrayList arrayList2 = new ArrayList(size);
        ArrayList arrayList3 = new ArrayList(size);
        for (kotlinx.coroutines.debug.internal.d dVar : g6) {
            kotlin.coroutines.i context = dVar.getContext();
            q0 q0Var = (q0) context.get(q0.f49425b);
            Long l6 = null;
            if (q0Var != null && (w5 = q0Var.w()) != null) {
                str = R(w5);
            } else {
                str = null;
            }
            m0 m0Var = (m0) context.get(m0.Key);
            if (m0Var != null) {
                str2 = R(m0Var);
            } else {
                str2 = null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("\n                {\n                    \"name\": ");
            sb.append(str);
            sb.append(",\n                    \"id\": ");
            p0 p0Var = (p0) context.get(p0.f49417b);
            if (p0Var != null) {
                l6 = Long.valueOf(p0Var.w());
            }
            sb.append(l6);
            sb.append(",\n                    \"dispatcher\": ");
            sb.append(str2);
            sb.append(",\n                    \"sequenceNumber\": ");
            sb.append(dVar.e());
            sb.append(",\n                    \"state\": \"");
            sb.append(dVar.f());
            sb.append("\"\n                } \n                ");
            arrayList3.add(u.v(sb.toString()));
            arrayList2.add(dVar.c());
            arrayList.add(dVar.d());
        }
        return new Object[]{'[' + f0.r3(arrayList3, null, null, null, 0, null, null, 63, null) + ']', arrayList.toArray(new Thread[0]), arrayList2.toArray(new kotlin.coroutines.jvm.internal.c[0]), g6.toArray(new kotlinx.coroutines.debug.internal.d[0])};
    }

    @NotNull
    public final List<DebuggerInfo> k() {
        if (A()) {
            return p.I3(p.S1(p.q3(f0.E1(q()), new d()), new Function1<a<?>, DebuggerInfo>() { // from class: kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpDebuggerInfo$$inlined$dumpCoroutinesInfoImpl$1
                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final DebuggerInfo invoke(@NotNull DebugProbesImpl.a<?> aVar) {
                    kotlin.coroutines.i context;
                    if (DebugProbesImpl.f48479a.z(aVar) || (context = aVar.f48492b.getContext()) == null) {
                        return null;
                    }
                    return new DebuggerInfo(aVar.f48492b, context);
                }
            }));
        }
        throw new IllegalStateException("Debug probes are not installed");
    }

    @NotNull
    public final List<StackTraceElement> l(@NotNull kotlinx.coroutines.debug.internal.d dVar, @NotNull List<StackTraceElement> list) {
        return n(dVar.f(), dVar.d(), list);
    }

    @NotNull
    public final String m(@NotNull kotlinx.coroutines.debug.internal.d dVar) {
        String str;
        List<StackTraceElement> l6 = l(dVar, dVar.g());
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : l6) {
            StringBuilder sb = new StringBuilder();
            sb.append("\n                {\n                    \"declaringClass\": \"");
            sb.append(stackTraceElement.getClassName());
            sb.append("\",\n                    \"methodName\": \"");
            sb.append(stackTraceElement.getMethodName());
            sb.append("\",\n                    \"fileName\": ");
            String fileName = stackTraceElement.getFileName();
            if (fileName != null) {
                str = R(fileName);
            } else {
                str = null;
            }
            sb.append(str);
            sb.append(",\n                    \"lineNumber\": ");
            sb.append(stackTraceElement.getLineNumber());
            sb.append("\n                }\n                ");
            arrayList.add(u.v(sb.toString()));
        }
        return '[' + f0.r3(arrayList, null, null, null, 0, null, null, 63, null) + ']';
    }

    @NotNull
    public final String x(@NotNull e2 e2Var) {
        if (A()) {
            Set<a<?>> q5 = q();
            ArrayList<a> arrayList = new ArrayList();
            for (Object obj : q5) {
                if (((a) obj).f48491a.getContext().get(e2.f48569s0) != null) {
                    arrayList.add(obj);
                }
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(t.u(i1.j(f0.d0(arrayList, 10)), 16));
            for (a aVar : arrayList) {
                linkedHashMap.put(h2.B(aVar.f48491a.getContext()), aVar.f48492b);
            }
            StringBuilder sb = new StringBuilder();
            f48479a.d(e2Var, linkedHashMap, sb, "");
            String sb2 = sb.toString();
            g0.o(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }
        throw new IllegalStateException("Debug probes are not installed");
    }

    public final void y() {
        Function1<Boolean, n1> function1;
        if (b.f48493a.incrementAndGet(f48489k) <= 1) {
            O();
            if (!kotlinx.coroutines.debug.internal.a.f48497a.a() && (function1 = f48487i) != null) {
                function1.invoke(Boolean.TRUE);
            }
        }
    }

    private static /* synthetic */ void s(e2 e2Var) {
    }
}
