package kotlin.reflect.jvm.internal.impl.km;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.f0;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.o0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.b;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "Attributes")
@SourceDebugExtension({"SMAP\nAttributes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Attributes.kt\nkotlin/metadata/Attributes\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,475:1\n1563#2:476\n1634#2,3:477\n*S KotlinDebug\n*F\n+ 1 Attributes.kt\nkotlin/metadata/Attributes\n*L\n-1#1:476\n-1#1:477,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a {

    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.a A;

    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.a B;

    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.a C;

    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.a D;

    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.a E;

    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.a F;

    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.b G;

    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.b H;

    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.b I;

    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.a J;

    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.a K;

    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.a L;

    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.a M;

    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.a N;

    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.a O;

    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.a P;

    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.b Q;

    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.b R;

    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.a S;

    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.a T;

    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.a U;

    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.a V;

    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.a W;

    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.a X;

    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.a Y;

    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.b Z;

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ kotlin.reflect.n<Object>[] f45062a = {o0.k(new MutablePropertyReference1Impl(a.class, "hasAnnotations", "getHasAnnotations(Lkotlin/metadata/KmClass;)Z", 1)), o0.k(new MutablePropertyReference1Impl(a.class, "hasAnnotations", "getHasAnnotations(Lkotlin/metadata/KmConstructor;)Z", 1)), o0.k(new MutablePropertyReference1Impl(a.class, "hasAnnotations", "getHasAnnotations(Lkotlin/metadata/KmFunction;)Z", 1)), o0.k(new MutablePropertyReference1Impl(a.class, "hasAnnotations", "getHasAnnotations(Lkotlin/metadata/KmProperty;)Z", 1)), o0.k(new MutablePropertyReference1Impl(a.class, "hasAnnotations", "getHasAnnotations(Lkotlin/metadata/KmPropertyAccessorAttributes;)Z", 1)), o0.k(new MutablePropertyReference1Impl(a.class, "hasAnnotations", "getHasAnnotations(Lkotlin/metadata/KmValueParameter;)Z", 1)), o0.k(new MutablePropertyReference1Impl(a.class, "hasAnnotations", "getHasAnnotations(Lkotlin/metadata/KmTypeAlias;)Z", 1)), o0.k(new MutablePropertyReference1Impl(a.class, "modality", "getModality(Lkotlin/metadata/KmClass;)Lkotlin/metadata/Modality;", 1)), o0.k(new MutablePropertyReference1Impl(a.class, "visibility", "getVisibility(Lkotlin/metadata/KmClass;)Lkotlin/metadata/Visibility;", 1)), o0.k(new MutablePropertyReference1Impl(a.class, "kind", "getKind(Lkotlin/metadata/KmClass;)Lkotlin/metadata/ClassKind;", 1)), o0.k(new MutablePropertyReference1Impl(a.class, "isInner", "isInner(Lkotlin/metadata/KmClass;)Z", 1)), o0.k(new MutablePropertyReference1Impl(a.class, "isData", "isData(Lkotlin/metadata/KmClass;)Z", 1)), o0.k(new MutablePropertyReference1Impl(a.class, "isExternal", "isExternal(Lkotlin/metadata/KmClass;)Z", 1)), o0.k(new MutablePropertyReference1Impl(a.class, "isExpect", "isExpect(Lkotlin/metadata/KmClass;)Z", 1)), o0.k(new MutablePropertyReference1Impl(a.class, "isValue", "isValue(Lkotlin/metadata/KmClass;)Z", 1)), o0.k(new MutablePropertyReference1Impl(a.class, "isFunInterface", "isFunInterface(Lkotlin/metadata/KmClass;)Z", 1)), o0.k(new MutablePropertyReference1Impl(a.class, "hasEnumEntries", "getHasEnumEntries(Lkotlin/metadata/KmClass;)Z", 1)), o0.k(new MutablePropertyReference1Impl(a.class, "visibility", "getVisibility(Lkotlin/metadata/KmConstructor;)Lkotlin/metadata/Visibility;", 1)), o0.k(new MutablePropertyReference1Impl(a.class, "isSecondary", "isSecondary(Lkotlin/metadata/KmConstructor;)Z", 1)), o0.k(new MutablePropertyReference1Impl(a.class, "hasNonStableParameterNames", "getHasNonStableParameterNames(Lkotlin/metadata/KmConstructor;)Z", 1)), o0.k(new MutablePropertyReference1Impl(a.class, "kind", "getKind(Lkotlin/metadata/KmFunction;)Lkotlin/metadata/MemberKind;", 1)), o0.k(new MutablePropertyReference1Impl(a.class, "visibility", "getVisibility(Lkotlin/metadata/KmFunction;)Lkotlin/metadata/Visibility;", 1)), o0.k(new MutablePropertyReference1Impl(a.class, "modality", "getModality(Lkotlin/metadata/KmFunction;)Lkotlin/metadata/Modality;", 1)), o0.k(new MutablePropertyReference1Impl(a.class, "isOperator", "isOperator(Lkotlin/metadata/KmFunction;)Z", 1)), o0.k(new MutablePropertyReference1Impl(a.class, "isInfix", "isInfix(Lkotlin/metadata/KmFunction;)Z", 1)), o0.k(new MutablePropertyReference1Impl(a.class, "isInline", "isInline(Lkotlin/metadata/KmFunction;)Z", 1)), o0.k(new MutablePropertyReference1Impl(a.class, "isTailrec", "isTailrec(Lkotlin/metadata/KmFunction;)Z", 1)), o0.k(new MutablePropertyReference1Impl(a.class, "isExternal", "isExternal(Lkotlin/metadata/KmFunction;)Z", 1)), o0.k(new MutablePropertyReference1Impl(a.class, "isSuspend", "isSuspend(Lkotlin/metadata/KmFunction;)Z", 1)), o0.k(new MutablePropertyReference1Impl(a.class, "isExpect", "isExpect(Lkotlin/metadata/KmFunction;)Z", 1)), o0.k(new MutablePropertyReference1Impl(a.class, "hasNonStableParameterNames", "getHasNonStableParameterNames(Lkotlin/metadata/KmFunction;)Z", 1)), o0.k(new MutablePropertyReference1Impl(a.class, "visibility", "getVisibility(Lkotlin/metadata/KmProperty;)Lkotlin/metadata/Visibility;", 1)), o0.k(new MutablePropertyReference1Impl(a.class, "modality", "getModality(Lkotlin/metadata/KmProperty;)Lkotlin/metadata/Modality;", 1)), o0.k(new MutablePropertyReference1Impl(a.class, "kind", "getKind(Lkotlin/metadata/KmProperty;)Lkotlin/metadata/MemberKind;", 1)), o0.k(new MutablePropertyReference1Impl(a.class, "isVar", "isVar(Lkotlin/metadata/KmProperty;)Z", 1)), o0.k(new MutablePropertyReference1Impl(a.class, "isConst", "isConst(Lkotlin/metadata/KmProperty;)Z", 1)), o0.k(new MutablePropertyReference1Impl(a.class, "isLateinit", "isLateinit(Lkotlin/metadata/KmProperty;)Z", 1)), o0.k(new MutablePropertyReference1Impl(a.class, "hasConstant", "getHasConstant(Lkotlin/metadata/KmProperty;)Z", 1)), o0.k(new MutablePropertyReference1Impl(a.class, "isExternal", "isExternal(Lkotlin/metadata/KmProperty;)Z", 1)), o0.k(new MutablePropertyReference1Impl(a.class, "isDelegated", "isDelegated(Lkotlin/metadata/KmProperty;)Z", 1)), o0.k(new MutablePropertyReference1Impl(a.class, "isExpect", "isExpect(Lkotlin/metadata/KmProperty;)Z", 1)), o0.k(new MutablePropertyReference1Impl(a.class, "visibility", "getVisibility(Lkotlin/metadata/KmPropertyAccessorAttributes;)Lkotlin/metadata/Visibility;", 1)), o0.k(new MutablePropertyReference1Impl(a.class, "modality", "getModality(Lkotlin/metadata/KmPropertyAccessorAttributes;)Lkotlin/metadata/Modality;", 1)), o0.k(new MutablePropertyReference1Impl(a.class, "isNotDefault", "isNotDefault(Lkotlin/metadata/KmPropertyAccessorAttributes;)Z", 1)), o0.k(new MutablePropertyReference1Impl(a.class, "isExternal", "isExternal(Lkotlin/metadata/KmPropertyAccessorAttributes;)Z", 1)), o0.k(new MutablePropertyReference1Impl(a.class, "isInline", "isInline(Lkotlin/metadata/KmPropertyAccessorAttributes;)Z", 1)), o0.k(new MutablePropertyReference1Impl(a.class, "isNullable", "isNullable(Lkotlin/metadata/KmType;)Z", 1)), o0.k(new MutablePropertyReference1Impl(a.class, "isSuspend", "isSuspend(Lkotlin/metadata/KmType;)Z", 1)), o0.k(new MutablePropertyReference1Impl(a.class, "isDefinitelyNonNull", "isDefinitelyNonNull(Lkotlin/metadata/KmType;)Z", 1)), o0.k(new MutablePropertyReference1Impl(a.class, "isReified", "isReified(Lkotlin/metadata/KmTypeParameter;)Z", 1)), o0.k(new MutablePropertyReference1Impl(a.class, "visibility", "getVisibility(Lkotlin/metadata/KmTypeAlias;)Lkotlin/metadata/Visibility;", 1)), o0.k(new MutablePropertyReference1Impl(a.class, "declaresDefaultValue", "getDeclaresDefaultValue(Lkotlin/metadata/KmValueParameter;)Z", 1)), o0.k(new MutablePropertyReference1Impl(a.class, "isCrossinline", "isCrossinline(Lkotlin/metadata/KmValueParameter;)Z", 1)), o0.k(new MutablePropertyReference1Impl(a.class, "isNoinline", "isNoinline(Lkotlin/metadata/KmValueParameter;)Z", 1)), o0.k(new MutablePropertyReference1Impl(a.class, "isNegated", "isNegated(Lkotlin/metadata/KmEffectExpression;)Z", 1)), o0.k(new MutablePropertyReference1Impl(a.class, "isNullCheckPredicate", "isNullCheckPredicate(Lkotlin/metadata/KmEffectExpression;)Z", 1))};

    /* renamed from: a0, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.a f45063a0;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.a f45064b;

    /* renamed from: b0, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.a f45065b0;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.a f45066c;

    /* renamed from: c0, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.a f45067c0;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.a f45068d;

    /* renamed from: d0, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.a f45069d0;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.a f45070e;

    /* renamed from: e0, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.a f45071e0;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.a f45072f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.a f45073g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.a f45074h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.b f45075i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.b f45076j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.b f45077k;

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.a f45078l;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.a f45079m;

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.a f45080n;

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.a f45081o;

    /* renamed from: p, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.a f45082p;

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.a f45083q;

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.a f45084r;

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.b f45085s;

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.a f45086t;

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.a f45087u;

    /* renamed from: v, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.b f45088v;

    /* renamed from: w, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.b f45089w;

    /* renamed from: x, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.b f45090x;

    /* renamed from: y, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.a f45091y;

    /* renamed from: z, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.a f45092z;

    static {
        b.C0902b HAS_ANNOTATIONS = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46208c;
        g0.o(HAS_ANNOTATIONS, "HAS_ANNOTATIONS");
        f45064b = kotlin.reflect.jvm.internal.impl.km.internal.c.a(new kotlin.reflect.jvm.internal.impl.km.internal.d(HAS_ANNOTATIONS));
        g0.o(HAS_ANNOTATIONS, "HAS_ANNOTATIONS");
        f45066c = kotlin.reflect.jvm.internal.impl.km.internal.c.b(new kotlin.reflect.jvm.internal.impl.km.internal.d(HAS_ANNOTATIONS));
        g0.o(HAS_ANNOTATIONS, "HAS_ANNOTATIONS");
        f45068d = kotlin.reflect.jvm.internal.impl.km.internal.c.c(new kotlin.reflect.jvm.internal.impl.km.internal.d(HAS_ANNOTATIONS));
        g0.o(HAS_ANNOTATIONS, "HAS_ANNOTATIONS");
        f45070e = kotlin.reflect.jvm.internal.impl.km.internal.c.g(new kotlin.reflect.jvm.internal.impl.km.internal.d(HAS_ANNOTATIONS));
        g0.o(HAS_ANNOTATIONS, "HAS_ANNOTATIONS");
        f45072f = kotlin.reflect.jvm.internal.impl.km.internal.c.f(new kotlin.reflect.jvm.internal.impl.km.internal.d(HAS_ANNOTATIONS));
        g0.o(HAS_ANNOTATIONS, "HAS_ANNOTATIONS");
        f45073g = kotlin.reflect.jvm.internal.impl.km.internal.c.j(new kotlin.reflect.jvm.internal.impl.km.internal.d(HAS_ANNOTATIONS));
        g0.o(HAS_ANNOTATIONS, "HAS_ANNOTATIONS");
        f45074h = kotlin.reflect.jvm.internal.impl.km.internal.c.h(new kotlin.reflect.jvm.internal.impl.km.internal.d(HAS_ANNOTATIONS));
        f45075i = kotlin.reflect.jvm.internal.impl.km.internal.c.e(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.a.i
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.p
            public Object get(Object obj) {
                return Integer.valueOf(((kotlin.reflect.jvm.internal.impl.km.g) obj).i());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.l
            public void set(Object obj, Object obj2) {
                ((kotlin.reflect.jvm.internal.impl.km.g) obj).r(((Number) obj2).intValue());
            }
        });
        f45076j = kotlin.reflect.jvm.internal.impl.km.internal.c.k(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.a.o
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.p
            public Object get(Object obj) {
                return Integer.valueOf(((kotlin.reflect.jvm.internal.impl.km.g) obj).i());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.l
            public void set(Object obj, Object obj2) {
                ((kotlin.reflect.jvm.internal.impl.km.g) obj).r(((Number) obj2).intValue());
            }
        });
        e eVar = new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.a.e
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.p
            public Object get(Object obj) {
                return Integer.valueOf(((kotlin.reflect.jvm.internal.impl.km.g) obj).i());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.l
            public void set(Object obj, Object obj2) {
                ((kotlin.reflect.jvm.internal.impl.km.g) obj).r(((Number) obj2).intValue());
            }
        };
        b.d<ProtoBuf.Class.Kind> CLASS_KIND = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46211f;
        g0.o(CLASS_KIND, "CLASS_KIND");
        kotlin.enums.a<ClassKind> entries = ClassKind.getEntries();
        kotlin.enums.a<ClassKind> entries2 = ClassKind.getEntries();
        ArrayList arrayList = new ArrayList(f0.d0(entries2, 10));
        Iterator<E> it = entries2.iterator();
        while (it.hasNext()) {
            arrayList.add(((ClassKind) it.next()).getFlag$kotlin_metadata());
        }
        f45077k = new kotlin.reflect.jvm.internal.impl.km.internal.b(eVar, CLASS_KIND, entries, arrayList);
        b.C0902b IS_INNER = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46212g;
        g0.o(IS_INNER, "IS_INNER");
        f45078l = kotlin.reflect.jvm.internal.impl.km.internal.c.a(new kotlin.reflect.jvm.internal.impl.km.internal.d(IS_INNER));
        b.C0902b IS_DATA = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46213h;
        g0.o(IS_DATA, "IS_DATA");
        f45079m = kotlin.reflect.jvm.internal.impl.km.internal.c.a(new kotlin.reflect.jvm.internal.impl.km.internal.d(IS_DATA));
        b.C0902b IS_EXTERNAL_CLASS = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46214i;
        g0.o(IS_EXTERNAL_CLASS, "IS_EXTERNAL_CLASS");
        f45080n = kotlin.reflect.jvm.internal.impl.km.internal.c.a(new kotlin.reflect.jvm.internal.impl.km.internal.d(IS_EXTERNAL_CLASS));
        b.C0902b IS_EXPECT_CLASS = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46215j;
        g0.o(IS_EXPECT_CLASS, "IS_EXPECT_CLASS");
        f45081o = kotlin.reflect.jvm.internal.impl.km.internal.c.a(new kotlin.reflect.jvm.internal.impl.km.internal.d(IS_EXPECT_CLASS));
        b.C0902b IS_VALUE_CLASS = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46216k;
        g0.o(IS_VALUE_CLASS, "IS_VALUE_CLASS");
        f45082p = kotlin.reflect.jvm.internal.impl.km.internal.c.a(new kotlin.reflect.jvm.internal.impl.km.internal.d(IS_VALUE_CLASS));
        b.C0902b IS_FUN_INTERFACE = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46217l;
        g0.o(IS_FUN_INTERFACE, "IS_FUN_INTERFACE");
        f45083q = kotlin.reflect.jvm.internal.impl.km.internal.c.a(new kotlin.reflect.jvm.internal.impl.km.internal.d(IS_FUN_INTERFACE));
        b.C0902b HAS_ENUM_ENTRIES = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46218m;
        g0.o(HAS_ENUM_ENTRIES, "HAS_ENUM_ENTRIES");
        f45084r = kotlin.reflect.jvm.internal.impl.km.internal.c.a(new kotlin.reflect.jvm.internal.impl.km.internal.d(HAS_ENUM_ENTRIES));
        f45085s = kotlin.reflect.jvm.internal.impl.km.internal.c.k(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.a.p
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.p
            public Object get(Object obj) {
                return Integer.valueOf(((kotlin.reflect.jvm.internal.impl.km.j) obj).c());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.l
            public void set(Object obj, Object obj2) {
                ((kotlin.reflect.jvm.internal.impl.km.j) obj).f(((Number) obj2).intValue());
            }
        });
        b.C0902b IS_SECONDARY = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46219n;
        g0.o(IS_SECONDARY, "IS_SECONDARY");
        f45086t = kotlin.reflect.jvm.internal.impl.km.internal.c.b(new kotlin.reflect.jvm.internal.impl.km.internal.d(IS_SECONDARY));
        b.C0902b IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46220o;
        g0.o(IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES, "IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES");
        f45087u = kotlin.reflect.jvm.internal.impl.km.internal.c.b(new kotlin.reflect.jvm.internal.impl.km.internal.d(IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES));
        f45088v = kotlin.reflect.jvm.internal.impl.km.internal.c.d(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.a.f
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.p
            public Object get(Object obj) {
                return Integer.valueOf(((q) obj).e());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.l
            public void set(Object obj, Object obj2) {
                ((q) obj).j(((Number) obj2).intValue());
            }
        });
        f45089w = kotlin.reflect.jvm.internal.impl.km.internal.c.k(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.a.k
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.p
            public Object get(Object obj) {
                return Integer.valueOf(((q) obj).e());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.l
            public void set(Object obj, Object obj2) {
                ((q) obj).j(((Number) obj2).intValue());
            }
        });
        f45090x = kotlin.reflect.jvm.internal.impl.km.internal.c.e(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.a.j
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.p
            public Object get(Object obj) {
                return Integer.valueOf(((q) obj).e());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.l
            public void set(Object obj, Object obj2) {
                ((q) obj).j(((Number) obj2).intValue());
            }
        });
        b.C0902b IS_OPERATOR = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46222q;
        g0.o(IS_OPERATOR, "IS_OPERATOR");
        f45091y = kotlin.reflect.jvm.internal.impl.km.internal.c.c(new kotlin.reflect.jvm.internal.impl.km.internal.d(IS_OPERATOR));
        b.C0902b IS_INFIX = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46223r;
        g0.o(IS_INFIX, "IS_INFIX");
        f45092z = kotlin.reflect.jvm.internal.impl.km.internal.c.c(new kotlin.reflect.jvm.internal.impl.km.internal.d(IS_INFIX));
        b.C0902b IS_INLINE = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46224s;
        g0.o(IS_INLINE, "IS_INLINE");
        A = kotlin.reflect.jvm.internal.impl.km.internal.c.c(new kotlin.reflect.jvm.internal.impl.km.internal.d(IS_INLINE));
        b.C0902b IS_TAILREC = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46225t;
        g0.o(IS_TAILREC, "IS_TAILREC");
        B = kotlin.reflect.jvm.internal.impl.km.internal.c.c(new kotlin.reflect.jvm.internal.impl.km.internal.d(IS_TAILREC));
        b.C0902b IS_EXTERNAL_FUNCTION = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46226u;
        g0.o(IS_EXTERNAL_FUNCTION, "IS_EXTERNAL_FUNCTION");
        C = kotlin.reflect.jvm.internal.impl.km.internal.c.c(new kotlin.reflect.jvm.internal.impl.km.internal.d(IS_EXTERNAL_FUNCTION));
        b.C0902b IS_SUSPEND = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46227v;
        g0.o(IS_SUSPEND, "IS_SUSPEND");
        D = kotlin.reflect.jvm.internal.impl.km.internal.c.c(new kotlin.reflect.jvm.internal.impl.km.internal.d(IS_SUSPEND));
        b.C0902b IS_EXPECT_FUNCTION = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46228w;
        g0.o(IS_EXPECT_FUNCTION, "IS_EXPECT_FUNCTION");
        E = kotlin.reflect.jvm.internal.impl.km.internal.c.c(new kotlin.reflect.jvm.internal.impl.km.internal.d(IS_EXPECT_FUNCTION));
        b.C0902b IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46229x;
        g0.o(IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES, "IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES");
        F = kotlin.reflect.jvm.internal.impl.km.internal.c.c(new kotlin.reflect.jvm.internal.impl.km.internal.d(IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES));
        G = kotlin.reflect.jvm.internal.impl.km.internal.c.k(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.a.l
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.p
            public Object get(Object obj) {
                return Integer.valueOf(((s) obj).g());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.l
            public void set(Object obj, Object obj2) {
                ((s) obj).q(((Number) obj2).intValue());
            }
        });
        H = kotlin.reflect.jvm.internal.impl.km.internal.c.e(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.a.g
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.p
            public Object get(Object obj) {
                return Integer.valueOf(((s) obj).g());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.l
            public void set(Object obj, Object obj2) {
                ((s) obj).q(((Number) obj2).intValue());
            }
        });
        I = kotlin.reflect.jvm.internal.impl.km.internal.c.d(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.a.d
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.p
            public Object get(Object obj) {
                return Integer.valueOf(((s) obj).g());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.l
            public void set(Object obj, Object obj2) {
                ((s) obj).q(((Number) obj2).intValue());
            }
        });
        b.C0902b IS_VAR = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46230y;
        g0.o(IS_VAR, "IS_VAR");
        J = kotlin.reflect.jvm.internal.impl.km.internal.c.g(new kotlin.reflect.jvm.internal.impl.km.internal.d(IS_VAR));
        b.C0902b IS_CONST = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.B;
        g0.o(IS_CONST, "IS_CONST");
        K = kotlin.reflect.jvm.internal.impl.km.internal.c.g(new kotlin.reflect.jvm.internal.impl.km.internal.d(IS_CONST));
        b.C0902b IS_LATEINIT = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.C;
        g0.o(IS_LATEINIT, "IS_LATEINIT");
        L = kotlin.reflect.jvm.internal.impl.km.internal.c.g(new kotlin.reflect.jvm.internal.impl.km.internal.d(IS_LATEINIT));
        b.C0902b HAS_CONSTANT = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.D;
        g0.o(HAS_CONSTANT, "HAS_CONSTANT");
        M = kotlin.reflect.jvm.internal.impl.km.internal.c.g(new kotlin.reflect.jvm.internal.impl.km.internal.d(HAS_CONSTANT));
        b.C0902b IS_EXTERNAL_PROPERTY = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.E;
        g0.o(IS_EXTERNAL_PROPERTY, "IS_EXTERNAL_PROPERTY");
        N = kotlin.reflect.jvm.internal.impl.km.internal.c.g(new kotlin.reflect.jvm.internal.impl.km.internal.d(IS_EXTERNAL_PROPERTY));
        b.C0902b IS_DELEGATED = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.F;
        g0.o(IS_DELEGATED, "IS_DELEGATED");
        O = kotlin.reflect.jvm.internal.impl.km.internal.c.g(new kotlin.reflect.jvm.internal.impl.km.internal.d(IS_DELEGATED));
        b.C0902b IS_EXPECT_PROPERTY = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.G;
        g0.o(IS_EXPECT_PROPERTY, "IS_EXPECT_PROPERTY");
        P = kotlin.reflect.jvm.internal.impl.km.internal.c.g(new kotlin.reflect.jvm.internal.impl.km.internal.d(IS_EXPECT_PROPERTY));
        Q = kotlin.reflect.jvm.internal.impl.km.internal.c.k(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.a.m
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.p
            public Object get(Object obj) {
                return Integer.valueOf(((t) obj).b());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.l
            public void set(Object obj, Object obj2) {
                ((t) obj).c(((Number) obj2).intValue());
            }
        });
        R = kotlin.reflect.jvm.internal.impl.km.internal.c.e(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.a.h
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.p
            public Object get(Object obj) {
                return Integer.valueOf(((t) obj).b());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.l
            public void set(Object obj, Object obj2) {
                ((t) obj).c(((Number) obj2).intValue());
            }
        });
        b.C0902b IS_NOT_DEFAULT = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.K;
        g0.o(IS_NOT_DEFAULT, "IS_NOT_DEFAULT");
        S = kotlin.reflect.jvm.internal.impl.km.internal.c.f(new kotlin.reflect.jvm.internal.impl.km.internal.d(IS_NOT_DEFAULT));
        b.C0902b IS_EXTERNAL_ACCESSOR = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.L;
        g0.o(IS_EXTERNAL_ACCESSOR, "IS_EXTERNAL_ACCESSOR");
        T = kotlin.reflect.jvm.internal.impl.km.internal.c.f(new kotlin.reflect.jvm.internal.impl.km.internal.d(IS_EXTERNAL_ACCESSOR));
        b.C0902b IS_INLINE_ACCESSOR = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.M;
        g0.o(IS_INLINE_ACCESSOR, "IS_INLINE_ACCESSOR");
        U = kotlin.reflect.jvm.internal.impl.km.internal.c.f(new kotlin.reflect.jvm.internal.impl.km.internal.d(IS_INLINE_ACCESSOR));
        V = kotlin.reflect.jvm.internal.impl.km.internal.c.i(new kotlin.reflect.jvm.internal.impl.km.internal.d(0, 1, 1));
        b.C0902b c0902b = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46206a;
        W = kotlin.reflect.jvm.internal.impl.km.internal.c.i(new kotlin.reflect.jvm.internal.impl.km.internal.d(c0902b.f46233a + 1, c0902b.f46234b, 1));
        b.C0902b c0902b2 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46207b;
        X = kotlin.reflect.jvm.internal.impl.km.internal.c.i(new kotlin.reflect.jvm.internal.impl.km.internal.d(c0902b2.f46233a + 1, c0902b2.f46234b, 1));
        Y = new kotlin.reflect.jvm.internal.impl.km.internal.a(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.a.c
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.p
            public Object get(Object obj) {
                return Integer.valueOf(((w) obj).b());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.l
            public void set(Object obj, Object obj2) {
                ((w) obj).g(((Number) obj2).intValue());
            }
        }, new kotlin.reflect.jvm.internal.impl.km.internal.d(0, 1, 1));
        Z = kotlin.reflect.jvm.internal.impl.km.internal.c.k(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.a.n
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.p
            public Object get(Object obj) {
                return Integer.valueOf(((v) obj).b());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.l
            public void set(Object obj, Object obj2) {
                ((v) obj).f(((Number) obj2).intValue());
            }
        });
        b.C0902b DECLARES_DEFAULT_VALUE = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.H;
        g0.o(DECLARES_DEFAULT_VALUE, "DECLARES_DEFAULT_VALUE");
        f45063a0 = kotlin.reflect.jvm.internal.impl.km.internal.c.j(new kotlin.reflect.jvm.internal.impl.km.internal.d(DECLARES_DEFAULT_VALUE));
        b.C0902b IS_CROSSINLINE = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.I;
        g0.o(IS_CROSSINLINE, "IS_CROSSINLINE");
        f45065b0 = kotlin.reflect.jvm.internal.impl.km.internal.c.j(new kotlin.reflect.jvm.internal.impl.km.internal.d(IS_CROSSINLINE));
        b.C0902b IS_NOINLINE = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.J;
        g0.o(IS_NOINLINE, "IS_NOINLINE");
        f45067c0 = kotlin.reflect.jvm.internal.impl.km.internal.c.j(new kotlin.reflect.jvm.internal.impl.km.internal.d(IS_NOINLINE));
        C0882a c0882a = new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.a.a
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.p
            public Object get(Object obj) {
                return Integer.valueOf(((kotlin.reflect.jvm.internal.impl.km.n) obj).b());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.l
            public void set(Object obj, Object obj2) {
                ((kotlin.reflect.jvm.internal.impl.km.n) obj).e(((Number) obj2).intValue());
            }
        };
        b.C0902b IS_NEGATED = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.N;
        g0.o(IS_NEGATED, "IS_NEGATED");
        f45069d0 = new kotlin.reflect.jvm.internal.impl.km.internal.a(c0882a, new kotlin.reflect.jvm.internal.impl.km.internal.d(IS_NEGATED));
        b bVar = new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.a.b
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.p
            public Object get(Object obj) {
                return Integer.valueOf(((kotlin.reflect.jvm.internal.impl.km.n) obj).b());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.l
            public void set(Object obj, Object obj2) {
                ((kotlin.reflect.jvm.internal.impl.km.n) obj).e(((Number) obj2).intValue());
            }
        };
        b.C0902b IS_NULL_CHECK_PREDICATE = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.O;
        g0.o(IS_NULL_CHECK_PREDICATE, "IS_NULL_CHECK_PREDICATE");
        f45071e0 = new kotlin.reflect.jvm.internal.impl.km.internal.a(bVar, new kotlin.reflect.jvm.internal.impl.km.internal.d(IS_NULL_CHECK_PREDICATE));
    }

    @NotNull
    public static final ClassKind a(@NotNull kotlin.reflect.jvm.internal.impl.km.g gVar) {
        g0.p(gVar, "<this>");
        return (ClassKind) f45077k.a(gVar, f45062a[9]);
    }

    @NotNull
    public static final Modality b(@NotNull kotlin.reflect.jvm.internal.impl.km.g gVar) {
        g0.p(gVar, "<this>");
        return (Modality) f45075i.a(gVar, f45062a[7]);
    }

    public static final boolean c(@NotNull kotlin.reflect.jvm.internal.impl.km.g gVar) {
        g0.p(gVar, "<this>");
        return f45079m.a(gVar, f45062a[11]);
    }

    public static final boolean d(@NotNull kotlin.reflect.jvm.internal.impl.km.g gVar) {
        g0.p(gVar, "<this>");
        return f45083q.a(gVar, f45062a[15]);
    }

    public static final boolean e(@NotNull kotlin.reflect.jvm.internal.impl.km.g gVar) {
        g0.p(gVar, "<this>");
        return f45078l.a(gVar, f45062a[10]);
    }

    public static final boolean f(@NotNull u uVar) {
        g0.p(uVar, "<this>");
        return V.a(uVar, f45062a[46]);
    }

    public static final boolean g(@NotNull w wVar) {
        g0.p(wVar, "<this>");
        return Y.a(wVar, f45062a[49]);
    }

    public static final boolean h(@NotNull kotlin.reflect.jvm.internal.impl.km.g gVar) {
        g0.p(gVar, "<this>");
        return f45082p.a(gVar, f45062a[14]);
    }
}
