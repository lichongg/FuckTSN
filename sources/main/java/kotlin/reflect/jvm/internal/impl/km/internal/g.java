package kotlin.reflect.jvm.internal.impl.km.internal;

import java.util.Iterator;
import java.util.List;
import kotlin.DeprecationLevel;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.f0;
import kotlin.contracts.ExperimentalContracts;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.km.InconsistentKotlinMetadataException;
import kotlin.reflect.jvm.internal.impl.km.KmEffectInvocationKind;
import kotlin.reflect.jvm.internal.impl.km.KmEffectType;
import kotlin.reflect.jvm.internal.impl.km.KmVariance;
import kotlin.reflect.jvm.internal.impl.km.a0;
import kotlin.reflect.jvm.internal.impl.km.h;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.p;
import kotlin.reflect.jvm.internal.impl.km.m;
import kotlin.reflect.jvm.internal.impl.km.n;
import kotlin.reflect.jvm.internal.impl.km.o;
import kotlin.reflect.jvm.internal.impl.km.q;
import kotlin.reflect.jvm.internal.impl.km.s;
import kotlin.reflect.jvm.internal.impl.km.u;
import kotlin.reflect.jvm.internal.impl.km.v;
import kotlin.reflect.jvm.internal.impl.km.w;
import kotlin.reflect.jvm.internal.impl.km.x;
import kotlin.reflect.jvm.internal.impl.km.y;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.j;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nReaders.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Readers.kt\nkotlin/metadata/internal/ReadersKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,424:1\n1634#2,3:425\n1634#2,3:428\n1634#2,3:431\n1634#2,3:434\n1634#2,3:437\n1634#2,3:440\n1634#2,3:443\n1869#2,2:446\n1869#2,2:448\n669#2,11:450\n1869#2,2:461\n1634#2,3:463\n1869#2,2:466\n1634#2,3:468\n1634#2,3:471\n1634#2,3:474\n1634#2,3:477\n1634#2,3:480\n1869#2,2:483\n1634#2,3:485\n1634#2,3:488\n1634#2,3:491\n1634#2,3:494\n1869#2,2:497\n1634#2,3:499\n1634#2,3:502\n1634#2,3:505\n1869#2,2:508\n1634#2,3:510\n1634#2,3:513\n1634#2,3:516\n1869#2,2:519\n1869#2,2:521\n1634#2,3:523\n1869#2,2:526\n1869#2,2:528\n1634#2,3:530\n1634#2,3:533\n1634#2,3:536\n*S KotlinDebug\n*F\n+ 1 Readers.kt\nkotlin/metadata/internal/ReadersKt\n*L\n68#1:425,3\n69#1:428,3\n70#1:431,3\n76#1:434,3\n83#1:437,3\n89#1:440,3\n90#1:443,3\n92#1:446,2\n100#1:448,2\n113#1:450,11\n133#1:461,2\n152#1:463,3\n154#1:466,2\n165#1:468,3\n166#1:471,3\n167#1:474,3\n179#1:477,3\n180#1:480,3\n182#1:483,2\n192#1:485,3\n194#1:488,3\n195#1:491,3\n203#1:494,3\n205#1:497,2\n215#1:499,3\n217#1:502,3\n222#1:505,3\n224#1:508,2\n234#1:510,3\n237#1:513,3\n239#1:516,3\n241#1:519,2\n256#1:521,2\n271#1:523,3\n273#1:526,2\n316#1:528,2\n376#1:530,3\n403#1:533,3\n404#1:536,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class g {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f45193a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f45194b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f45195c;

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int[] f45196d;

        /* renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ int[] f45197e;

        /* renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ int[] f45198f;

        /* renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ int[] f45199g;

        static {
            int[] iArr = new int[ProtoBuf.TypeParameter.Variance.values().length];
            try {
                iArr[ProtoBuf.TypeParameter.Variance.IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProtoBuf.TypeParameter.Variance.OUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProtoBuf.TypeParameter.Variance.INV.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f45193a = iArr;
            int[] iArr2 = new int[ProtoBuf.Type.Argument.Projection.values().length];
            try {
                iArr2[ProtoBuf.Type.Argument.Projection.IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[ProtoBuf.Type.Argument.Projection.OUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[ProtoBuf.Type.Argument.Projection.INV.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[ProtoBuf.Type.Argument.Projection.STAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            f45194b = iArr2;
            int[] iArr3 = new int[ProtoBuf.VersionRequirement.VersionKind.values().length];
            try {
                iArr3[ProtoBuf.VersionRequirement.VersionKind.LANGUAGE_VERSION.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr3[ProtoBuf.VersionRequirement.VersionKind.COMPILER_VERSION.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[ProtoBuf.VersionRequirement.VersionKind.API_VERSION.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            f45195c = iArr3;
            int[] iArr4 = new int[DeprecationLevel.values().length];
            try {
                iArr4[DeprecationLevel.WARNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr4[DeprecationLevel.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr4[DeprecationLevel.HIDDEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused13) {
            }
            f45196d = iArr4;
            int[] iArr5 = new int[ProtoBuf.Effect.EffectType.values().length];
            try {
                iArr5[ProtoBuf.Effect.EffectType.RETURNS_CONSTANT.ordinal()] = 1;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr5[ProtoBuf.Effect.EffectType.CALLS.ordinal()] = 2;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr5[ProtoBuf.Effect.EffectType.RETURNS_NOT_NULL.ordinal()] = 3;
            } catch (NoSuchFieldError unused16) {
            }
            f45197e = iArr5;
            int[] iArr6 = new int[ProtoBuf.Effect.InvocationKind.values().length];
            try {
                iArr6[ProtoBuf.Effect.InvocationKind.AT_MOST_ONCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr6[ProtoBuf.Effect.InvocationKind.EXACTLY_ONCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr6[ProtoBuf.Effect.InvocationKind.AT_LEAST_ONCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused19) {
            }
            f45198f = iArr6;
            int[] iArr7 = new int[ProtoBuf.Expression.ConstantValue.values().length];
            try {
                iArr7[ProtoBuf.Expression.ConstantValue.TRUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr7[ProtoBuf.Expression.ConstantValue.FALSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr7[ProtoBuf.Expression.ConstantValue.NULL.ordinal()] = 3;
            } catch (NoSuchFieldError unused22) {
            }
            f45199g = iArr7;
        }
    }

    public static final int a(int i6) {
        Boolean d6 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46208c.d(i6);
        g0.o(d6, "get(...)");
        return kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.b(d6.booleanValue(), kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46209d.d(i6), kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46210e.d(i6), false, false, false);
    }

    public static final int b(@NotNull ProtoBuf.Property property) {
        g0.p(property, "<this>");
        return property.hasGetterFlags() ? property.getGetterFlags() : a(property.getFlags());
    }

    public static final int c(@NotNull ProtoBuf.Property property) {
        g0.p(property, "<this>");
        return property.hasSetterFlags() ? property.getSetterFlags() : a(property.getFlags());
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final kotlin.reflect.jvm.internal.impl.km.a0 g(int r8, kotlin.reflect.jvm.internal.impl.km.internal.e r9) {
        /*
            kotlin.reflect.jvm.internal.impl.km.a0 r0 = new kotlin.reflect.jvm.internal.impl.km.a0
            r0.<init>()
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.i$a r1 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.i.f46244f
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.d r2 = r9.e()
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.j r3 = r9.h()
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.i r8 = r1.a(r8, r2, r3)
            r1 = 2
            r2 = 0
            if (r8 != 0) goto L26
            boolean r9 = r9.d()
            if (r9 == 0) goto L1e
            goto L26
        L1e:
            kotlin.reflect.jvm.internal.impl.km.InconsistentKotlinMetadataException r8 = new kotlin.reflect.jvm.internal.impl.km.InconsistentKotlinMetadataException
            java.lang.String r9 = "No VersionRequirement with the given id in the table"
            r8.<init>(r9, r2, r1, r2)
            throw r8
        L26:
            if (r8 == 0) goto L2d
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirement$VersionKind r9 = r8.b()
            goto L2e
        L2d:
            r9 = r2
        L2e:
            r3 = -1
            if (r9 != 0) goto L33
            r9 = -1
            goto L3b
        L33:
            int[] r4 = kotlin.reflect.jvm.internal.impl.km.internal.g.a.f45195c
            int r9 = r9.ordinal()
            r9 = r4[r9]
        L3b:
            r4 = 3
            r5 = 1
            if (r9 == r3) goto L54
            if (r9 == r5) goto L51
            if (r9 == r1) goto L4e
            if (r9 != r4) goto L48
            kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementVersionKind r9 = kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementVersionKind.API_VERSION
            goto L56
        L48:
            kotlin.NoWhenBranchMatchedException r8 = new kotlin.NoWhenBranchMatchedException
            r8.<init>()
            throw r8
        L4e:
            kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementVersionKind r9 = kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementVersionKind.COMPILER_VERSION
            goto L56
        L51:
            kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementVersionKind r9 = kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementVersionKind.LANGUAGE_VERSION
            goto L56
        L54:
            kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementVersionKind r9 = kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementVersionKind.UNKNOWN
        L56:
            if (r8 == 0) goto L5d
            kotlin.DeprecationLevel r6 = r8.c()
            goto L5e
        L5d:
            r6 = r2
        L5e:
            if (r6 != 0) goto L62
            r6 = -1
            goto L6a
        L62:
            int[] r7 = kotlin.reflect.jvm.internal.impl.km.internal.g.a.f45196d
            int r6 = r6.ordinal()
            r6 = r7[r6]
        L6a:
            if (r6 == r3) goto L7f
            if (r6 == r5) goto L7c
            if (r6 == r1) goto L79
            if (r6 != r4) goto L73
            goto L7f
        L73:
            kotlin.NoWhenBranchMatchedException r8 = new kotlin.NoWhenBranchMatchedException
            r8.<init>()
            throw r8
        L79:
            kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementLevel r1 = kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementLevel.ERROR
            goto L81
        L7c:
            kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementLevel r1 = kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementLevel.WARNING
            goto L81
        L7f:
            kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementLevel r1 = kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementLevel.HIDDEN
        L81:
            r0.g(r9)
            r0.h(r1)
            if (r8 == 0) goto L8e
            java.lang.Integer r9 = r8.a()
            goto L8f
        L8e:
            r9 = r2
        L8f:
            r0.f(r9)
            if (r8 == 0) goto L98
            java.lang.String r2 = r8.d()
        L98:
            r0.i(r2)
            if (r8 == 0) goto La3
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.i$b r8 = r8.e()
            if (r8 != 0) goto La5
        La3:
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.i$b r8 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.i.b.f46252e
        La5:
            int r9 = r8.b()
            int r1 = r8.c()
            int r8 = r8.d()
            kotlin.reflect.jvm.internal.impl.km.z r2 = new kotlin.reflect.jvm.internal.impl.km.z
            r2.<init>(r9, r1, r8)
            r0.j(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.km.internal.g.g(int, kotlin.reflect.jvm.internal.impl.km.internal.e):kotlin.reflect.jvm.internal.impl.km.a0");
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.km.g h(@NotNull ProtoBuf.Class r10, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.d strings, boolean z5, @NotNull List<? extends Object> contextExtensions) {
        g0.p(r10, "<this>");
        g0.p(strings, "strings");
        g0.p(contextExtensions, "contextExtensions");
        kotlin.reflect.jvm.internal.impl.km.g gVar = new kotlin.reflect.jvm.internal.impl.km.g();
        ProtoBuf.TypeTable typeTable = r10.getTypeTable();
        g0.o(typeTable, "getTypeTable(...)");
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.h hVar = new kotlin.reflect.jvm.internal.impl.metadata.deserialization.h(typeTable);
        j.a aVar = kotlin.reflect.jvm.internal.impl.metadata.deserialization.j.f46256b;
        ProtoBuf.VersionRequirementTable versionRequirementTable = r10.getVersionRequirementTable();
        g0.o(versionRequirementTable, "getVersionRequirementTable(...)");
        e eVar = new e(strings, hVar, aVar.a(versionRequirementTable), z5, null, contextExtensions, 16, null);
        List<ProtoBuf.TypeParameter> typeParameterList = r10.getTypeParameterList();
        g0.o(typeParameterList, "getTypeParameterList(...)");
        e i6 = eVar.i(typeParameterList);
        gVar.r(r10.getFlags());
        gVar.u(i6.a(r10.getFqName()));
        List<ProtoBuf.TypeParameter> typeParameterList2 = r10.getTypeParameterList();
        g0.o(typeParameterList2, "getTypeParameterList(...)");
        List<w> o5 = gVar.o();
        for (ProtoBuf.TypeParameter typeParameter : typeParameterList2) {
            g0.m(typeParameter);
            o5.add(s(typeParameter, i6));
        }
        List<ProtoBuf.Type> p5 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.g.p(r10, i6.g());
        List<u> n6 = gVar.n();
        Iterator<T> it = p5.iterator();
        while (it.hasNext()) {
            n6.add(q((ProtoBuf.Type) it.next(), i6));
        }
        List<ProtoBuf.Constructor> constructorList = r10.getConstructorList();
        g0.o(constructorList, "getConstructorList(...)");
        List<kotlin.reflect.jvm.internal.impl.km.j> e6 = gVar.e();
        for (ProtoBuf.Constructor constructor : constructorList) {
            g0.m(constructor);
            e6.add(j(constructor, i6));
        }
        List<ProtoBuf.Function> functionList = r10.getFunctionList();
        g0.o(functionList, "getFunctionList(...)");
        List<ProtoBuf.Property> propertyList = r10.getPropertyList();
        g0.o(propertyList, "getPropertyList(...)");
        List<ProtoBuf.TypeAlias> typeAliasList = r10.getTypeAliasList();
        g0.o(typeAliasList, "getTypeAliasList(...)");
        u(gVar, functionList, propertyList, typeAliasList, i6);
        if (r10.hasCompanionObjectName()) {
            gVar.q(i6.b(r10.getCompanionObjectName()));
        }
        List<Integer> nestedClassNameList = r10.getNestedClassNameList();
        g0.o(nestedClassNameList, "getNestedClassNameList(...)");
        List<String> l6 = gVar.l();
        for (Integer num : nestedClassNameList) {
            g0.m(num);
            l6.add(i6.b(num.intValue()));
        }
        Iterator<ProtoBuf.EnumEntry> it2 = r10.getEnumEntryList().iterator();
        while (true) {
            if (!it2.hasNext()) {
                List<Integer> sealedSubclassFqNameList = r10.getSealedSubclassFqNameList();
                g0.o(sealedSubclassFqNameList, "getSealedSubclassFqNameList(...)");
                List<String> m6 = gVar.m();
                for (Integer num2 : sealedSubclassFqNameList) {
                    g0.m(num2);
                    m6.add(i6.a(num2.intValue()));
                }
                if (r10.hasInlineClassUnderlyingPropertyName()) {
                    gVar.s(i6.b(r10.getInlineClassUnderlyingPropertyName()));
                }
                ProtoBuf.Type f6 = f(r10, i6);
                gVar.t(f6 != null ? q(f6, i6) : null);
                List<ProtoBuf.Type> b6 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.g.b(r10, i6.g());
                List<u> f7 = gVar.f();
                Iterator<T> it3 = b6.iterator();
                while (it3.hasNext()) {
                    f7.add(q((ProtoBuf.Type) it3.next(), i6));
                }
                List<Integer> versionRequirementList = r10.getVersionRequirementList();
                g0.o(versionRequirementList, "getVersionRequirementList(...)");
                List<a0> p6 = gVar.p();
                for (Integer num3 : versionRequirementList) {
                    g0.m(num3);
                    p6.add(g(num3.intValue(), i6));
                }
                Iterator<T> it4 = i6.c().iterator();
                while (it4.hasNext()) {
                    ((p) it4.next()).r(gVar, r10, i6);
                }
                return gVar;
            }
            ProtoBuf.EnumEntry next = it2.next();
            if (!next.hasName()) {
                throw new InconsistentKotlinMetadataException("No name for EnumEntry", null, 2, null);
            }
            gVar.g().add(i6.b(next.getName()));
            List<o> j6 = gVar.j();
            g0.m(next);
            j6.add(n(next, i6));
        }
    }

    public static /* synthetic */ kotlin.reflect.jvm.internal.impl.km.g i(ProtoBuf.Class r02, kotlin.reflect.jvm.internal.impl.metadata.deserialization.d dVar, boolean z5, List list, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        if ((i6 & 4) != 0) {
            list = f0.J();
        }
        return h(r02, dVar, z5, list);
    }

    private static final kotlin.reflect.jvm.internal.impl.km.j j(ProtoBuf.Constructor constructor, e eVar) {
        kotlin.reflect.jvm.internal.impl.km.j jVar = new kotlin.reflect.jvm.internal.impl.km.j(constructor.getFlags());
        List<ProtoBuf.ValueParameter> valueParameterList = constructor.getValueParameterList();
        g0.o(valueParameterList, "getValueParameterList(...)");
        List<y> d6 = jVar.d();
        for (ProtoBuf.ValueParameter valueParameter : valueParameterList) {
            g0.m(valueParameter);
            d6.add(t(valueParameter, eVar));
        }
        List<Integer> versionRequirementList = constructor.getVersionRequirementList();
        g0.o(versionRequirementList, "getVersionRequirementList(...)");
        List<a0> e6 = jVar.e();
        for (Integer num : versionRequirementList) {
            g0.m(num);
            e6.add(g(num.intValue(), eVar));
        }
        Iterator<T> it = eVar.c().iterator();
        while (it.hasNext()) {
            ((p) it.next()).n(jVar, constructor, eVar);
        }
        return jVar;
    }

    @ExperimentalContracts
    private static final kotlin.reflect.jvm.internal.impl.km.k k(ProtoBuf.Contract contract, e eVar) {
        KmEffectType kmEffectType;
        KmEffectInvocationKind kmEffectInvocationKind;
        kotlin.reflect.jvm.internal.impl.km.k kVar = new kotlin.reflect.jvm.internal.impl.km.k();
        for (ProtoBuf.Effect effect : contract.getEffectList()) {
            if (effect.hasEffectType()) {
                ProtoBuf.Effect.EffectType effectType = effect.getEffectType();
                if (effectType == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                int i6 = a.f45197e[effectType.ordinal()];
                if (i6 == 1) {
                    kmEffectType = KmEffectType.RETURNS_CONSTANT;
                } else if (i6 == 2) {
                    kmEffectType = KmEffectType.CALLS;
                } else {
                    if (i6 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    kmEffectType = KmEffectType.RETURNS_NOT_NULL;
                }
                if (effect.hasKind()) {
                    ProtoBuf.Effect.InvocationKind kind = effect.getKind();
                    if (kind == null) {
                        throw new IllegalArgumentException("Required value was null.");
                    }
                    int i7 = a.f45198f[kind.ordinal()];
                    if (i7 == 1) {
                        kmEffectInvocationKind = KmEffectInvocationKind.AT_MOST_ONCE;
                    } else if (i7 == 2) {
                        kmEffectInvocationKind = KmEffectInvocationKind.EXACTLY_ONCE;
                    } else {
                        if (i7 != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                        kmEffectInvocationKind = KmEffectInvocationKind.AT_LEAST_ONCE;
                    }
                } else {
                    kmEffectInvocationKind = null;
                }
                List<m> a6 = kVar.a();
                g0.m(effect);
                a6.add(l(effect, kmEffectType, kmEffectInvocationKind, eVar));
            }
        }
        return kVar;
    }

    @ExperimentalContracts
    private static final m l(ProtoBuf.Effect effect, KmEffectType kmEffectType, KmEffectInvocationKind kmEffectInvocationKind, e eVar) {
        m mVar = new m(kmEffectType, kmEffectInvocationKind);
        List<ProtoBuf.Expression> effectConstructorArgumentList = effect.getEffectConstructorArgumentList();
        g0.o(effectConstructorArgumentList, "getEffectConstructorArgumentList(...)");
        List<n> a6 = mVar.a();
        for (ProtoBuf.Expression expression : effectConstructorArgumentList) {
            g0.m(expression);
            a6.add(m(expression, eVar));
        }
        if (effect.hasConclusionOfConditionalEffect()) {
            ProtoBuf.Expression conclusionOfConditionalEffect = effect.getConclusionOfConditionalEffect();
            g0.o(conclusionOfConditionalEffect, "getConclusionOfConditionalEffect(...)");
            mVar.b(m(conclusionOfConditionalEffect, eVar));
        }
        return mVar;
    }

    @ExperimentalContracts
    private static final n m(ProtoBuf.Expression expression, e eVar) {
        Boolean bool;
        n nVar = new n();
        nVar.e(expression.getFlags());
        nVar.g(expression.hasValueParameterReference() ? Integer.valueOf(expression.getValueParameterReference()) : null);
        if (expression.hasConstantValue()) {
            ProtoBuf.Expression.ConstantValue constantValue = expression.getConstantValue();
            if (constantValue == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            int i6 = a.f45199g[constantValue.ordinal()];
            if (i6 == 1) {
                bool = Boolean.TRUE;
            } else if (i6 == 2) {
                bool = Boolean.FALSE;
            } else {
                if (i6 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                bool = null;
            }
            nVar.d(new kotlin.reflect.jvm.internal.impl.km.i(bool));
        }
        ProtoBuf.Type j6 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.g.j(expression, eVar.g());
        nVar.f(j6 != null ? q(j6, eVar) : null);
        List<ProtoBuf.Expression> andArgumentList = expression.getAndArgumentList();
        g0.o(andArgumentList, "getAndArgumentList(...)");
        List<n> a6 = nVar.a();
        for (ProtoBuf.Expression expression2 : andArgumentList) {
            g0.m(expression2);
            a6.add(m(expression2, eVar));
        }
        List<ProtoBuf.Expression> orArgumentList = expression.getOrArgumentList();
        g0.o(orArgumentList, "getOrArgumentList(...)");
        List<n> c6 = nVar.c();
        for (ProtoBuf.Expression expression3 : orArgumentList) {
            g0.m(expression3);
            c6.add(m(expression3, eVar));
        }
        return nVar;
    }

    private static final o n(ProtoBuf.EnumEntry enumEntry, e eVar) {
        o oVar = new o(eVar.b(enumEntry.getName()));
        Iterator<T> it = eVar.c().iterator();
        while (it.hasNext()) {
            ((p) it.next()).m(oVar, enumEntry, eVar);
        }
        return oVar;
    }

    private static final q o(ProtoBuf.Function function, e eVar) {
        q qVar = new q(function.getFlags(), eVar.b(function.getName()));
        List<ProtoBuf.TypeParameter> typeParameterList = function.getTypeParameterList();
        g0.o(typeParameterList, "getTypeParameterList(...)");
        e i6 = eVar.i(typeParameterList);
        List<ProtoBuf.TypeParameter> typeParameterList2 = function.getTypeParameterList();
        g0.o(typeParameterList2, "getTypeParameterList(...)");
        List<w> f6 = qVar.f();
        for (ProtoBuf.TypeParameter typeParameter : typeParameterList2) {
            g0.m(typeParameter);
            f6.add(s(typeParameter, i6));
        }
        ProtoBuf.Type l6 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.g.l(function, i6.g());
        qVar.k(l6 != null ? q(l6, i6) : null);
        List<ProtoBuf.Type> c6 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.g.c(function, i6.g());
        List<u> b6 = qVar.b();
        Iterator<T> it = c6.iterator();
        while (it.hasNext()) {
            b6.add(q((ProtoBuf.Type) it.next(), i6));
        }
        List<ProtoBuf.ValueParameter> valueParameterList = function.getValueParameterList();
        g0.o(valueParameterList, "getValueParameterList(...)");
        List<y> g6 = qVar.g();
        for (ProtoBuf.ValueParameter valueParameter : valueParameterList) {
            g0.m(valueParameter);
            g6.add(t(valueParameter, i6));
        }
        qVar.l(q(kotlin.reflect.jvm.internal.impl.metadata.deserialization.g.n(function, i6.g()), i6));
        if (function.hasContract()) {
            ProtoBuf.Contract contract = function.getContract();
            g0.o(contract, "getContract(...)");
            qVar.i(k(contract, i6));
        }
        List<Integer> versionRequirementList = function.getVersionRequirementList();
        g0.o(versionRequirementList, "getVersionRequirementList(...)");
        List<a0> h6 = qVar.h();
        for (Integer num : versionRequirementList) {
            g0.m(num);
            h6.add(g(num.intValue(), i6));
        }
        Iterator<T> it2 = i6.c().iterator();
        while (it2.hasNext()) {
            ((p) it2.next()).v(qVar, function, i6);
        }
        return qVar;
    }

    @NotNull
    public static final s p(@NotNull ProtoBuf.Property property, @NotNull e outer) {
        g0.p(property, "<this>");
        g0.p(outer, "outer");
        s sVar = new s(property.getFlags(), outer.b(property.getName()), b(property), c(property));
        List<ProtoBuf.TypeParameter> typeParameterList = property.getTypeParameterList();
        g0.o(typeParameterList, "getTypeParameterList(...)");
        e i6 = outer.i(typeParameterList);
        List<ProtoBuf.TypeParameter> typeParameterList2 = property.getTypeParameterList();
        g0.o(typeParameterList2, "getTypeParameterList(...)");
        List<w> n6 = sVar.n();
        for (ProtoBuf.TypeParameter typeParameter : typeParameterList2) {
            g0.m(typeParameter);
            n6.add(s(typeParameter, i6));
        }
        ProtoBuf.Type m6 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.g.m(property, i6.g());
        sVar.r(m6 != null ? q(m6, i6) : null);
        List<ProtoBuf.Type> d6 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.g.d(property, i6.g());
        List<u> c6 = sVar.c();
        Iterator<T> it = d6.iterator();
        while (it.hasNext()) {
            c6.add(q((ProtoBuf.Type) it.next(), i6));
        }
        if (property.hasSetterValueParameter()) {
            ProtoBuf.ValueParameter setterValueParameter = property.getSetterValueParameter();
            g0.o(setterValueParameter, "getSetterValueParameter(...)");
            sVar.t(t(setterValueParameter, i6));
        }
        sVar.s(q(kotlin.reflect.jvm.internal.impl.metadata.deserialization.g.o(property, i6.g()), i6));
        List<Integer> versionRequirementList = property.getVersionRequirementList();
        g0.o(versionRequirementList, "getVersionRequirementList(...)");
        List<a0> o5 = sVar.o();
        for (Integer num : versionRequirementList) {
            g0.m(num);
            o5.add(g(num.intValue(), i6));
        }
        Iterator<T> it2 = i6.c().iterator();
        while (it2.hasNext()) {
            ((p) it2.next()).g(sVar, property, i6);
        }
        return sVar;
    }

    private static final u q(ProtoBuf.Type type, e eVar) {
        kotlin.reflect.jvm.internal.impl.km.h cVar;
        u q5;
        KmVariance kmVariance;
        u uVar = new u(d(type));
        kotlin.reflect.jvm.internal.impl.km.p pVar = null;
        pVar = null;
        if (type.hasClassName()) {
            cVar = new h.a(eVar.a(type.getClassName()));
        } else if (type.hasTypeAliasName()) {
            cVar = new h.b(eVar.a(type.getTypeAliasName()));
        } else if (type.hasTypeParameter()) {
            cVar = new h.c(type.getTypeParameter());
        } else {
            if (!type.hasTypeParameterName()) {
                throw new InconsistentKotlinMetadataException("No classifier (class, type alias or type parameter) recorded for Type", null, 2, null);
            }
            Integer f6 = eVar.f(type.getTypeParameterName());
            if (f6 == null) {
                throw new InconsistentKotlinMetadataException("No type parameter id for " + eVar.b(type.getTypeParameterName()), null, 2, null);
            }
            cVar = new h.c(f6.intValue());
        }
        uVar.i(cVar);
        for (ProtoBuf.Type.Argument argument : type.getArgumentList()) {
            ProtoBuf.Type.Argument.Projection projection = argument.getProjection();
            if (projection == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            int i6 = a.f45194b[projection.ordinal()];
            if (i6 == 1) {
                kmVariance = KmVariance.IN;
            } else if (i6 == 2) {
                kmVariance = KmVariance.OUT;
            } else if (i6 == 3) {
                kmVariance = KmVariance.INVARIANT;
            } else {
                if (i6 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                kmVariance = null;
            }
            if (kmVariance != null) {
                g0.m(argument);
                ProtoBuf.Type q6 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.g.q(argument, eVar.g());
                if (q6 == null) {
                    throw new InconsistentKotlinMetadataException("No type argument for non-STAR projection in Type", null, 2, null);
                }
                uVar.b().add(new x(kmVariance, q(q6, eVar)));
            } else {
                uVar.b().add(x.f45322d);
            }
        }
        ProtoBuf.Type a6 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.g.a(type, eVar.g());
        uVar.h(a6 != null ? q(a6, eVar) : null);
        ProtoBuf.Type k6 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.g.k(type, eVar.g());
        uVar.l(k6 != null ? q(k6, eVar) : null);
        ProtoBuf.Type f7 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.g.f(type, eVar.g());
        if (f7 != null && (q5 = q(f7, eVar)) != null) {
            pVar = new kotlin.reflect.jvm.internal.impl.km.p(q5, type.hasFlexibleTypeCapabilitiesId() ? eVar.b(type.getFlexibleTypeCapabilitiesId()) : null);
        }
        uVar.k(pVar);
        Iterator<T> it = eVar.c().iterator();
        while (it.hasNext()) {
            ((p) it.next()).q(uVar, type, eVar);
        }
        return uVar;
    }

    private static final v r(ProtoBuf.TypeAlias typeAlias, e eVar) {
        v vVar = new v(typeAlias.getFlags(), eVar.b(typeAlias.getName()));
        List<ProtoBuf.TypeParameter> typeParameterList = typeAlias.getTypeParameterList();
        g0.o(typeParameterList, "getTypeParameterList(...)");
        e i6 = eVar.i(typeParameterList);
        List<ProtoBuf.TypeParameter> typeParameterList2 = typeAlias.getTypeParameterList();
        g0.o(typeParameterList2, "getTypeParameterList(...)");
        List<w> c6 = vVar.c();
        for (ProtoBuf.TypeParameter typeParameter : typeParameterList2) {
            g0.m(typeParameter);
            c6.add(s(typeParameter, i6));
        }
        vVar.g(q(kotlin.reflect.jvm.internal.impl.metadata.deserialization.g.s(typeAlias, i6.g()), i6));
        vVar.e(q(kotlin.reflect.jvm.internal.impl.metadata.deserialization.g.e(typeAlias, i6.g()), i6));
        List<ProtoBuf.Annotation> annotationList = typeAlias.getAnnotationList();
        g0.o(annotationList, "getAnnotationList(...)");
        List<kotlin.reflect.jvm.internal.impl.km.d> a6 = vVar.a();
        for (ProtoBuf.Annotation annotation : annotationList) {
            g0.m(annotation);
            a6.add(f.b(annotation, i6.e()));
        }
        List<Integer> versionRequirementList = typeAlias.getVersionRequirementList();
        g0.o(versionRequirementList, "getVersionRequirementList(...)");
        List<a0> d6 = vVar.d();
        for (Integer num : versionRequirementList) {
            g0.m(num);
            d6.add(g(num.intValue(), i6));
        }
        Iterator<T> it = i6.c().iterator();
        while (it.hasNext()) {
            ((p) it.next()).l(vVar, typeAlias, i6);
        }
        return vVar;
    }

    private static final y t(ProtoBuf.ValueParameter valueParameter, e eVar) {
        y yVar = new y(valueParameter.getFlags(), eVar.b(valueParameter.getName()));
        yVar.h(q(kotlin.reflect.jvm.internal.impl.metadata.deserialization.g.r(valueParameter, eVar.g()), eVar));
        ProtoBuf.Type u5 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.g.u(valueParameter, eVar.g());
        yVar.i(u5 != null ? q(u5, eVar) : null);
        if (valueParameter.hasAnnotationParameterDefaultValue()) {
            ProtoBuf.Annotation.Argument.Value annotationParameterDefaultValue = valueParameter.getAnnotationParameterDefaultValue();
            g0.o(annotationParameterDefaultValue, "getAnnotationParameterDefaultValue(...)");
            yVar.f(f.c(annotationParameterDefaultValue, eVar.e()));
        }
        Iterator<T> it = eVar.c().iterator();
        while (it.hasNext()) {
            ((p) it.next()).t(yVar, valueParameter, eVar);
        }
        return yVar;
    }

    private static final void u(kotlin.reflect.jvm.internal.impl.km.l lVar, List<ProtoBuf.Function> list, List<ProtoBuf.Property> list2, List<ProtoBuf.TypeAlias> list3, e eVar) {
        List<q> c6 = lVar.c();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            c6.add(o((ProtoBuf.Function) it.next(), eVar));
        }
        List<s> a6 = lVar.a();
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            a6.add(p((ProtoBuf.Property) it2.next(), eVar));
        }
        List<v> b6 = lVar.b();
        Iterator<T> it3 = list3.iterator();
        while (it3.hasNext()) {
            b6.add(r((ProtoBuf.TypeAlias) it3.next(), eVar));
        }
    }

    private static final int d(ProtoBuf.Type type) {
        boolean nullable = type.getNullable();
        return (nullable ? 1 : 0) + (type.getFlags() << 1);
    }

    private static final int e(ProtoBuf.TypeParameter typeParameter) {
        return typeParameter.getReified() ? 1 : 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x005b, code lost:
    
        if (r2 == false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type f(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class r7, kotlin.reflect.jvm.internal.impl.km.internal.e r8) {
        /*
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.h r0 = r8.g()
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r0 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.g.i(r7, r0)
            if (r0 == 0) goto Lb
            return r0
        Lb:
            boolean r0 = r7.hasInlineClassUnderlyingPropertyName()
            r1 = 0
            if (r0 != 0) goto L13
            return r1
        L13:
            java.util.List r0 = r7.getPropertyList()
            java.lang.String r2 = "getPropertyList(...)"
            kotlin.jvm.internal.g0.o(r0, r2)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
            r2 = 0
            r3 = r1
        L24:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L5b
            java.lang.Object r4 = r0.next()
            r5 = r4
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property r5 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property) r5
            kotlin.jvm.internal.g0.m(r5)
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.h r6 = r8.g()
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r6 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.g.m(r5, r6)
            if (r6 != 0) goto L24
            int r5 = r5.getName()
            java.lang.String r5 = r8.b(r5)
            int r6 = r7.getInlineClassUnderlyingPropertyName()
            java.lang.String r6 = r8.b(r6)
            boolean r5 = kotlin.jvm.internal.g0.g(r5, r6)
            if (r5 == 0) goto L24
            if (r2 == 0) goto L58
        L56:
            r3 = r1
            goto L5e
        L58:
            r2 = 1
            r3 = r4
            goto L24
        L5b:
            if (r2 != 0) goto L5e
            goto L56
        L5e:
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property) r3
            if (r3 == 0) goto L6b
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.h r7 = r8.g()
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r7 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.g.o(r3, r7)
            return r7
        L6b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.km.internal.g.f(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class, kotlin.reflect.jvm.internal.impl.km.internal.e):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type");
    }

    private static final w s(ProtoBuf.TypeParameter typeParameter, e eVar) {
        KmVariance kmVariance;
        ProtoBuf.TypeParameter.Variance variance = typeParameter.getVariance();
        if (variance != null) {
            int i6 = a.f45193a[variance.ordinal()];
            if (i6 != 1) {
                if (i6 != 2) {
                    if (i6 == 3) {
                        kmVariance = KmVariance.INVARIANT;
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    kmVariance = KmVariance.OUT;
                }
            } else {
                kmVariance = KmVariance.IN;
            }
            w wVar = new w(e(typeParameter), eVar.b(typeParameter.getName()), typeParameter.getId(), kmVariance);
            List<ProtoBuf.Type> t5 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.g.t(typeParameter, eVar.g());
            List<u> e6 = wVar.e();
            Iterator<T> it = t5.iterator();
            while (it.hasNext()) {
                e6.add(q((ProtoBuf.Type) it.next(), eVar));
            }
            Iterator<T> it2 = eVar.c().iterator();
            while (it2.hasNext()) {
                ((p) it2.next()).d(wVar, typeParameter, eVar);
            }
            return wVar;
        }
        throw new IllegalArgumentException("Required value was null.");
    }
}
