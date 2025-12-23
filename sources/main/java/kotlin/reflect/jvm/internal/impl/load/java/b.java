package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.collections.u1;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.o;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nAbstractAnnotationTypeQualifierResolver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractAnnotationTypeQualifierResolver.kt\norg/jetbrains/kotlin/load/java/AbstractAnnotationTypeQualifierResolver\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 MapsJVM.kt\nkotlin/collections/MapsKt__MapsJVMKt\n+ 5 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,234:1\n1#2:235\n1#2:241\n1#2:246\n1#2:268\n1761#3,3:236\n295#3,2:242\n1625#3:244\n1869#3:245\n1870#3:247\n1626#3:248\n1761#3,3:249\n1803#3,3:252\n1803#3,3:255\n1617#3,9:258\n1869#3:267\n1870#3:269\n1626#3:270\n72#4,2:239\n382#5,7:271\n*S KotlinDebug\n*F\n+ 1 AbstractAnnotationTypeQualifierResolver.kt\norg/jetbrains/kotlin/load/java/AbstractAnnotationTypeQualifierResolver\n*L\n42#1:241\n83#1:246\n164#1:268\n30#1:236,3\n81#1:242,2\n83#1:244\n83#1:245\n83#1:247\n83#1:248\n90#1:249,3\n126#1:252,3\n138#1:255,3\n164#1:258,9\n164#1:267\n164#1:269\n164#1:270\n42#1:239,2\n229#1:271,7\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class b<TAnnotation> {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final a f45363c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final Map<String, AnnotationQualifierApplicabilityType> f45364d;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final d0 f45365a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final ConcurrentHashMap<Object, TAnnotation> f45366b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }
    }

    @NotNull
    protected abstract Iterable<String> c(@NotNull TAnnotation tannotation, boolean z5);

    @Nullable
    protected abstract kotlin.reflect.jvm.internal.impl.name.c k(@NotNull TAnnotation tannotation);

    @NotNull
    protected abstract Object l(@NotNull TAnnotation tannotation);

    @NotNull
    protected abstract Iterable<TAnnotation> m(@NotNull TAnnotation tannotation);

    public abstract boolean o();

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType : AnnotationQualifierApplicabilityType.values()) {
            String javaTarget = annotationQualifierApplicabilityType.getJavaTarget();
            if (linkedHashMap.get(javaTarget) == null) {
                linkedHashMap.put(javaTarget, annotationQualifierApplicabilityType);
            }
        }
        f45364d = linkedHashMap;
    }

    public b(@NotNull d0 javaTypeEnhancementState) {
        kotlin.jvm.internal.g0.p(javaTypeEnhancementState, "javaTypeEnhancementState");
        this.f45365a = javaTypeEnhancementState;
        this.f45366b = new ConcurrentHashMap<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Set<AnnotationQualifierApplicabilityType> b(Set<? extends AnnotationQualifierApplicabilityType> set) {
        return set.contains(AnnotationQualifierApplicabilityType.TYPE_USE) ? u1.C(u1.y(kotlin.collections.n.Fz(AnnotationQualifierApplicabilityType.values()), AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS), set) : set;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean f(Object extractNullability) {
        kotlin.jvm.internal.g0.p(extractNullability, "$this$extractNullability");
        return false;
    }

    private final ReportLevel t(TAnnotation tannotation) {
        Iterable<String> c6;
        String str;
        ReportLevel reportLevel = this.f45365a.c().e().get(k(tannotation));
        if (reportLevel != null) {
            return reportLevel;
        }
        TAnnotation j6 = j(tannotation, j0.p());
        if (j6 == null || (c6 = c(j6, false)) == null || (str = (String) kotlin.collections.f0.J2(c6)) == null) {
            return null;
        }
        ReportLevel d6 = this.f45365a.c().d();
        if (d6 != null) {
            return d6;
        }
        int hashCode = str.hashCode();
        if (hashCode != -2137067054) {
            if (hashCode != -1838656823) {
                if (hashCode == 2656902 && str.equals("WARN")) {
                    return ReportLevel.WARN;
                }
            } else if (str.equals("STRICT")) {
                return ReportLevel.STRICT;
            }
        } else if (str.equals("IGNORE")) {
            return ReportLevel.IGNORE;
        }
        return null;
    }

    private final v u(TAnnotation tannotation) {
        v vVar;
        if (this.f45365a.a() || (vVar = w.a().get(k(tannotation))) == null) {
            return null;
        }
        ReportLevel r5 = r(tannotation);
        if (r5 == ReportLevel.IGNORE) {
            r5 = null;
        }
        if (r5 == null) {
            return null;
        }
        return v.b(vVar, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.j.b(vVar.d(), null, r5.isWarning(), 1, null), null, false, 6, null);
    }

    private final Pair<TAnnotation, Set<AnnotationQualifierApplicabilityType>> w(TAnnotation tannotation) {
        TAnnotation j6;
        TAnnotation tannotation2;
        if (this.f45365a.c().f() || (j6 = j(tannotation, j0.g())) == null) {
            return null;
        }
        Iterator<TAnnotation> it = m(tannotation).iterator();
        while (true) {
            if (!it.hasNext()) {
                tannotation2 = null;
                break;
            }
            tannotation2 = it.next();
            if (v(tannotation2) != null) {
                break;
            }
        }
        if (tannotation2 == null) {
            return null;
        }
        Iterable<String> c6 = c(j6, true);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<String> it2 = c6.iterator();
        while (it2.hasNext()) {
            AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType = f45364d.get(it2.next());
            if (annotationQualifierApplicabilityType != null) {
                linkedHashSet.add(annotationQualifierApplicabilityType);
            }
        }
        return new Pair<>(tannotation2, b(linkedHashSet));
    }

    @Nullable
    public final e0 d(@Nullable e0 e0Var, @NotNull Iterable<? extends TAnnotation> annotations) {
        EnumMap<AnnotationQualifierApplicabilityType, v> b6;
        kotlin.jvm.internal.g0.p(annotations, "annotations");
        if (!this.f45365a.a()) {
            ArrayList<v> arrayList = new ArrayList();
            Iterator<? extends TAnnotation> it = annotations.iterator();
            while (it.hasNext()) {
                v e6 = e(it.next());
                if (e6 != null) {
                    arrayList.add(e6);
                }
            }
            if (!arrayList.isEmpty()) {
                EnumMap enumMap = new EnumMap(AnnotationQualifierApplicabilityType.class);
                for (v vVar : arrayList) {
                    for (AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType : vVar.e()) {
                        if (enumMap.containsKey(annotationQualifierApplicabilityType) && o()) {
                            v vVar2 = (v) enumMap.get(annotationQualifierApplicabilityType);
                            if (vVar2 != null) {
                                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.j d6 = vVar2.d();
                                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.j d7 = vVar.d();
                                if (!kotlin.jvm.internal.g0.g(d7, d6) && (!d7.d() || d6.d())) {
                                    vVar2 = (d7.d() || !d6.d()) ? null : vVar;
                                }
                                enumMap.put((EnumMap) annotationQualifierApplicabilityType, (AnnotationQualifierApplicabilityType) vVar2);
                            }
                        } else {
                            enumMap.put((EnumMap) annotationQualifierApplicabilityType, (AnnotationQualifierApplicabilityType) vVar);
                        }
                    }
                }
                EnumMap enumMap2 = (e0Var == null || (b6 = e0Var.b()) == null) ? new EnumMap(AnnotationQualifierApplicabilityType.class) : new EnumMap((EnumMap) b6);
                boolean z5 = false;
                for (Map.Entry entry : enumMap.entrySet()) {
                    AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType2 = (AnnotationQualifierApplicabilityType) entry.getKey();
                    v vVar3 = (v) entry.getValue();
                    if (vVar3 != null) {
                        enumMap2.put((EnumMap) annotationQualifierApplicabilityType2, (AnnotationQualifierApplicabilityType) vVar3);
                        z5 = true;
                    }
                }
                if (z5) {
                    return new e0(enumMap2);
                }
            }
        }
        return e0Var;
    }

    @Nullable
    public final MutabilityQualifier g(@NotNull Iterable<? extends TAnnotation> annotations) {
        MutabilityQualifier mutabilityQualifier;
        kotlin.jvm.internal.g0.p(annotations, "annotations");
        Iterator<? extends TAnnotation> it = annotations.iterator();
        MutabilityQualifier mutabilityQualifier2 = null;
        while (it.hasNext()) {
            kotlin.reflect.jvm.internal.impl.name.c k6 = k(it.next());
            if (kotlin.collections.f0.a2(j0.o(), k6)) {
                mutabilityQualifier = MutabilityQualifier.READ_ONLY;
            } else if (kotlin.collections.f0.a2(j0.l(), k6)) {
                mutabilityQualifier = MutabilityQualifier.MUTABLE;
            } else {
                continue;
            }
            if (mutabilityQualifier2 != null && mutabilityQualifier2 != mutabilityQualifier) {
                return null;
            }
            mutabilityQualifier2 = mutabilityQualifier;
        }
        return mutabilityQualifier2;
    }

    @Nullable
    public final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.j h(@NotNull Iterable<? extends TAnnotation> annotations, @NotNull Function1<? super TAnnotation, Boolean> forceWarning) {
        kotlin.jvm.internal.g0.p(annotations, "annotations");
        kotlin.jvm.internal.g0.p(forceWarning, "forceWarning");
        Iterator<? extends TAnnotation> it = annotations.iterator();
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.j jVar = null;
        while (it.hasNext()) {
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.j i6 = i(it.next(), forceWarning);
            if (jVar != null) {
                if (i6 != null && !kotlin.jvm.internal.g0.g(i6, jVar) && (!i6.d() || jVar.d())) {
                    if (i6.d() || !jVar.d()) {
                        return null;
                    }
                }
            }
            jVar = i6;
        }
        return jVar;
    }

    public final boolean p(@NotNull TAnnotation annotation) {
        kotlin.jvm.internal.g0.p(annotation, "annotation");
        TAnnotation j6 = j(annotation, o.a.H);
        if (j6 == null) {
            return false;
        }
        Iterable<String> c6 = c(j6, false);
        if ((c6 instanceof Collection) && ((Collection) c6).isEmpty()) {
            return false;
        }
        Iterator<String> it = c6.iterator();
        while (it.hasNext()) {
            if (kotlin.jvm.internal.g0.g(it.next(), "TYPE")) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public final TAnnotation v(@NotNull TAnnotation annotation) {
        TAnnotation tannotation;
        kotlin.jvm.internal.g0.p(annotation, "annotation");
        if (this.f45365a.c().f()) {
            return null;
        }
        if (kotlin.collections.f0.a2(j0.a(), k(annotation)) || n(annotation, j0.f())) {
            return annotation;
        }
        if (!n(annotation, j0.h())) {
            return null;
        }
        ConcurrentHashMap<Object, TAnnotation> concurrentHashMap = this.f45366b;
        Object l6 = l(annotation);
        TAnnotation tannotation2 = concurrentHashMap.get(l6);
        if (tannotation2 != null) {
            return tannotation2;
        }
        Iterator<TAnnotation> it = m(annotation).iterator();
        while (true) {
            if (!it.hasNext()) {
                tannotation = null;
                break;
            }
            tannotation = v(it.next());
            if (tannotation != null) {
                break;
            }
        }
        if (tannotation == null) {
            return null;
        }
        TAnnotation putIfAbsent = concurrentHashMap.putIfAbsent(l6, tannotation);
        return putIfAbsent == null ? tannotation : putIfAbsent;
    }

    private final v e(TAnnotation tannotation) {
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.j i6;
        v u5 = u(tannotation);
        if (u5 != null) {
            return u5;
        }
        Pair<TAnnotation, Set<AnnotationQualifierApplicabilityType>> w5 = w(tannotation);
        if (w5 == null) {
            return null;
        }
        TAnnotation component1 = w5.component1();
        Set<AnnotationQualifierApplicabilityType> component2 = w5.component2();
        ReportLevel t5 = t(tannotation);
        if (t5 == null) {
            t5 = s(component1);
        }
        if (t5.isIgnore() || (i6 = i(component1, kotlin.reflect.jvm.internal.impl.load.java.a.f45354a)) == null) {
            return null;
        }
        return new v(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.j.b(i6, null, t5.isWarning(), 1, null), component2, false, 4, null);
    }

    private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.j i(TAnnotation tannotation, Function1<? super TAnnotation, Boolean> function1) {
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.j q5;
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.j q6 = q(tannotation, function1.invoke(tannotation).booleanValue());
        if (q6 != null) {
            return q6;
        }
        TAnnotation v5 = v(tannotation);
        if (v5 == null) {
            return null;
        }
        ReportLevel s5 = s(tannotation);
        if (s5.isIgnore() || (q5 = q(v5, function1.invoke(v5).booleanValue())) == null) {
            return null;
        }
        return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.j.b(q5, null, s5.isWarning(), 1, null);
    }

    private final TAnnotation j(TAnnotation tannotation, kotlin.reflect.jvm.internal.impl.name.c cVar) {
        for (TAnnotation tannotation2 : m(tannotation)) {
            if (kotlin.jvm.internal.g0.g(k(tannotation2), cVar)) {
                return tannotation2;
            }
        }
        return null;
    }

    private final boolean n(TAnnotation tannotation, kotlin.reflect.jvm.internal.impl.name.c cVar) {
        Iterable<TAnnotation> m6 = m(tannotation);
        if ((m6 instanceof Collection) && ((Collection) m6).isEmpty()) {
            return false;
        }
        Iterator<TAnnotation> it = m6.iterator();
        while (it.hasNext()) {
            if (kotlin.jvm.internal.g0.g(k(it.next()), cVar)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0067, code lost:
    
        if (r6.equals("ALWAYS") != false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007c, code lost:
    
        if (r6.equals("NEVER") == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0088, code lost:
    
        r6 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0085, code lost:
    
        if (r6.equals("MAYBE") == false) goto L36;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.j q(TAnnotation r6, boolean r7) {
        /*
            r5 = this;
            kotlin.reflect.jvm.internal.impl.name.c r0 = r5.k(r6)
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            kotlin.reflect.jvm.internal.impl.load.java.d0 r2 = r5.f45365a
            kotlin.jvm.functions.Function1 r2 = r2.b()
            java.lang.Object r2 = r2.invoke(r0)
            kotlin.reflect.jvm.internal.impl.load.java.ReportLevel r2 = (kotlin.reflect.jvm.internal.impl.load.java.ReportLevel) r2
            boolean r3 = r2.isIgnore()
            if (r3 == 0) goto L1b
            return r1
        L1b:
            java.util.Set r3 = kotlin.reflect.jvm.internal.impl.load.java.j0.m()
            boolean r3 = r3.contains(r0)
            r4 = 0
            if (r3 == 0) goto L29
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r6 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL
            goto L8d
        L29:
            java.util.Set r3 = kotlin.reflect.jvm.internal.impl.load.java.j0.n()
            boolean r3 = r3.contains(r0)
            if (r3 == 0) goto L36
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r6 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE
            goto L8d
        L36:
            java.util.Set r3 = kotlin.reflect.jvm.internal.impl.load.java.j0.b()
            boolean r3 = r3.contains(r0)
            if (r3 == 0) goto L43
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r6 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.FORCE_FLEXIBILITY
            goto L8d
        L43:
            kotlin.reflect.jvm.internal.impl.name.c r3 = kotlin.reflect.jvm.internal.impl.load.java.j0.c()
            boolean r0 = kotlin.jvm.internal.g0.g(r0, r3)
            if (r0 == 0) goto L9c
            java.lang.Iterable r6 = r5.c(r6, r4)
            java.lang.Object r6 = kotlin.collections.f0.J2(r6)
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L8b
            int r0 = r6.hashCode()
            switch(r0) {
                case 73135176: goto L7f;
                case 74175084: goto L76;
                case 433141802: goto L6a;
                case 1933739535: goto L61;
                default: goto L60;
            }
        L60:
            goto L87
        L61:
            java.lang.String r0 = "ALWAYS"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L87
            goto L8b
        L6a:
            java.lang.String r0 = "UNKNOWN"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L73
            goto L87
        L73:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r6 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.FORCE_FLEXIBILITY
            goto L8d
        L76:
            java.lang.String r0 = "NEVER"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L88
            goto L87
        L7f:
            java.lang.String r0 = "MAYBE"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L88
        L87:
            return r1
        L88:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r6 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE
            goto L8d
        L8b:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r6 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL
        L8d:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.j r0 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.j
            boolean r1 = r2.isWarning()
            if (r1 != 0) goto L97
            if (r7 == 0) goto L98
        L97:
            r4 = 1
        L98:
            r0.<init>(r6, r4)
            return r0
        L9c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.b.q(java.lang.Object, boolean):kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.j");
    }

    private final ReportLevel r(TAnnotation tannotation) {
        kotlin.reflect.jvm.internal.impl.name.c k6 = k(tannotation);
        if (k6 != null && w.b().containsKey(k6)) {
            return this.f45365a.b().invoke(k6);
        }
        return s(tannotation);
    }

    private final ReportLevel s(TAnnotation tannotation) {
        ReportLevel t5 = t(tannotation);
        if (t5 != null) {
            return t5;
        }
        return this.f45365a.c().c();
    }
}
