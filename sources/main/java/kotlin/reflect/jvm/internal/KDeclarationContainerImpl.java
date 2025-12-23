package kotlin.reflect.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.f3;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nKDeclarationContainerImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KDeclarationContainerImpl.kt\nkotlin/reflect/jvm/internal/KDeclarationContainerImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 5 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 6 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,316:1\n1617#2,9:317\n1869#2:326\n1870#2:328\n1626#2:329\n774#2:330\n865#2,2:331\n1491#2:333\n1516#2,3:334\n1519#2,3:344\n774#2:347\n865#2,2:348\n774#2:350\n865#2,2:351\n1#3:327\n1#3:353\n382#4,7:337\n1310#5,2:354\n37#6:356\n36#6,3:357\n37#6:360\n36#6,3:361\n37#6:364\n36#6,3:365\n*S KotlinDebug\n*F\n+ 1 KDeclarationContainerImpl.kt\nkotlin/reflect/jvm/internal/KDeclarationContainerImpl\n*L\n58#1:317,9\n58#1:326\n58#1:328\n58#1:329\n83#1:330\n83#1:331,2\n103#1:333\n103#1:334,3\n103#1:344,3\n128#1:347\n128#1:348,2\n142#1:350\n142#1:351,2\n58#1:327\n103#1:337,7\n197#1:354,2\n207#1:356\n207#1:357,3\n216#1:360\n216#1:361,3\n241#1:364\n241#1:365,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class KDeclarationContainerImpl implements kotlin.jvm.internal.s {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f44235a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final Class<?> f44236b = kotlin.jvm.internal.v.class;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Regex f44237c = new Regex("<v#(\\d+)>");

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    protected static final class MemberBelonginess {
        private static final /* synthetic */ kotlin.enums.a $ENTRIES;
        private static final /* synthetic */ MemberBelonginess[] $VALUES;
        public static final MemberBelonginess DECLARED = new MemberBelonginess("DECLARED", 0);
        public static final MemberBelonginess INHERITED = new MemberBelonginess("INHERITED", 1);

        private static final /* synthetic */ MemberBelonginess[] $values() {
            return new MemberBelonginess[]{DECLARED, INHERITED};
        }

        static {
            MemberBelonginess[] $values = $values();
            $VALUES = $values;
            $ENTRIES = kotlin.enums.c.c($values);
        }

        public static MemberBelonginess valueOf(String str) {
            return (MemberBelonginess) Enum.valueOf(MemberBelonginess.class, str);
        }

        public static MemberBelonginess[] values() {
            return (MemberBelonginess[]) $VALUES.clone();
        }

        public final boolean accept(@NotNull CallableMemberDescriptor member) {
            kotlin.jvm.internal.g0.p(member, "member");
            return member.h().isReal() == (this == DECLARED);
        }

        private MemberBelonginess(String str, int i6) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        @NotNull
        public final Regex a() {
            return KDeclarationContainerImpl.f44237c;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public abstract class b {

        /* renamed from: c, reason: collision with root package name */
        static final /* synthetic */ kotlin.reflect.n<Object>[] f44238c = {kotlin.jvm.internal.o0.u(new PropertyReference1Impl(b.class, "moduleData", "getModuleData()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;", 0))};

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final f3.a f44239a;

        public b() {
            this.f44239a = f3.c(new i1(KDeclarationContainerImpl.this));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public final kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.k b() {
            T b6 = this.f44239a.b(this, f44238c[0]);
            kotlin.jvm.internal.g0.o(b6, "getValue(...)");
            return (kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.k) b6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.k c(KDeclarationContainerImpl kDeclarationContainerImpl) {
            return e3.b(kDeclarationContainerImpl.c());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class c {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final List<Class<?>> f44241a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        private final Class<?> f44242b;

        /* JADX WARN: Multi-variable type inference failed */
        public c(@NotNull List<? extends Class<?>> parameters, @Nullable Class<?> cls) {
            kotlin.jvm.internal.g0.p(parameters, "parameters");
            this.f44241a = parameters;
            this.f44242b = cls;
        }

        @NotNull
        public final List<Class<?>> a() {
            return this.f44241a;
        }

        @Nullable
        public final Class<?> b() {
            return this.f44242b;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class d extends n {
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.o, kotlin.reflect.jvm.internal.impl.descriptors.m
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public e0<?> f(kotlin.reflect.jvm.internal.impl.descriptors.j descriptor, kotlin.n1 data) {
            kotlin.jvm.internal.g0.p(descriptor, "descriptor");
            kotlin.jvm.internal.g0.p(data, "data");
            throw new IllegalStateException("No constructors should appear here: " + descriptor);
        }

        d(KDeclarationContainerImpl kDeclarationContainerImpl) {
            super(kDeclarationContainerImpl);
        }
    }

    private final Method V(Class<?> cls, String str, Class<?>[] clsArr, Class<?> cls2, boolean z5) {
        String str2;
        Class<?>[] clsArr2;
        Class<?> cls3;
        boolean z6;
        if (z5) {
            clsArr[0] = cls;
        }
        Method Z = Z(cls, str, clsArr, cls2);
        if (Z != null) {
            return Z;
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null) {
            Method V = V(superclass, str, clsArr, cls2, z5);
            str2 = str;
            clsArr2 = clsArr;
            cls3 = cls2;
            z6 = z5;
            if (V != null) {
                return V;
            }
        } else {
            str2 = str;
            clsArr2 = clsArr;
            cls3 = cls2;
            z6 = z5;
        }
        Iterator a6 = kotlin.jvm.internal.h.a(cls.getInterfaces());
        while (a6.hasNext()) {
            Class<?> cls4 = (Class) a6.next();
            kotlin.jvm.internal.g0.m(cls4);
            Method V2 = V(cls4, str2, clsArr2, cls3, z6);
            if (V2 != null) {
                return V2;
            }
            if (z6) {
                Class<?> a7 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.e.a(kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.f.j(cls4), cls4.getName() + "$DefaultImpls");
                if (a7 != null) {
                    clsArr2[0] = cls4;
                    Method Z2 = Z(a7, str2, clsArr2, cls3);
                    if (Z2 != null) {
                        return Z2;
                    }
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    private final Method Z(Class<?> cls, String str, Class<?>[] clsArr, Class<?> cls2) {
        Method declaredMethod;
        try {
            declaredMethod = cls.getDeclaredMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
        } catch (NoSuchMethodException unused) {
        }
        if (kotlin.jvm.internal.g0.g(declaredMethod.getReturnType(), cls2)) {
            return declaredMethod;
        }
        Method[] declaredMethods = cls.getDeclaredMethods();
        kotlin.jvm.internal.g0.o(declaredMethods, "getDeclaredMethods(...)");
        for (Method method : declaredMethods) {
            if (kotlin.jvm.internal.g0.g(method.getName(), str) && kotlin.jvm.internal.g0.g(method.getReturnType(), cls2) && Arrays.equals(method.getParameterTypes(), clsArr)) {
                return method;
            }
        }
        return null;
    }

    @NotNull
    public abstract Collection<kotlin.reflect.jvm.internal.impl.descriptors.j> P();

    @NotNull
    public abstract Collection<kotlin.reflect.jvm.internal.impl.descriptors.y> Q(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar);

    @Nullable
    public abstract kotlin.reflect.jvm.internal.impl.descriptors.w0 R(int i6);

    @NotNull
    public abstract Collection<kotlin.reflect.jvm.internal.impl.descriptors.w0> U(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar);

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence J(kotlin.reflect.jvm.internal.impl.descriptors.y descriptor) {
        kotlin.jvm.internal.g0.p(descriptor, "descriptor");
        return kotlin.reflect.jvm.internal.impl.renderer.m.f46584k.N(descriptor) + " | " + k3.f47513a.g(descriptor).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence O(kotlin.reflect.jvm.internal.impl.descriptors.w0 descriptor) {
        kotlin.jvm.internal.g0.p(descriptor, "descriptor");
        return kotlin.reflect.jvm.internal.impl.renderer.m.f46584k.N(descriptor) + " | " + k3.f47513a.f(descriptor).a();
    }

    private final c W(String str, boolean z5) {
        String str2;
        int G3;
        ArrayList arrayList = new ArrayList();
        int i6 = 1;
        while (true) {
            if (str.charAt(i6) == ')') {
                String str3 = str;
                return new c(arrayList, z5 ? X(str3, i6 + 1, str3.length()) : null);
            }
            int i7 = i6;
            while (str.charAt(i7) == '[') {
                i7++;
            }
            char charAt = str.charAt(i7);
            if (kotlin.text.u.k3("VZCBSIFJD", charAt, false, 2, null)) {
                int i8 = i7 + 1;
                str2 = str;
                G3 = i8;
            } else {
                if (charAt != 'L') {
                    throw new KotlinReflectionInternalError("Unknown type prefix in the method signature: " + str);
                }
                str2 = str;
                G3 = kotlin.text.u.G3(str2, ';', i6, false, 4, null) + 1;
            }
            arrayList.add(X(str2, i6, G3));
            i6 = G3;
            str = str2;
        }
    }

    private final Constructor<?> Y(Class<?> cls, List<? extends Class<?>> list) {
        try {
            Class[] clsArr = (Class[]) list.toArray(new Class[0]);
            return cls.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    @Nullable
    public final Constructor<?> F(@NotNull String desc) {
        kotlin.jvm.internal.g0.p(desc, "desc");
        return Y(c(), W(desc, false).a());
    }

    @Nullable
    public final Constructor<?> G(@NotNull String desc) {
        kotlin.jvm.internal.g0.p(desc, "desc");
        Class<?> c6 = c();
        ArrayList arrayList = new ArrayList();
        E(arrayList, W(desc, false).a(), true);
        kotlin.n1 n1Var = kotlin.n1.f44123a;
        return Y(c6, arrayList);
    }

    @Nullable
    public final Method H(@NotNull String name, @NotNull String desc, boolean z5) {
        kotlin.jvm.internal.g0.p(name, "name");
        kotlin.jvm.internal.g0.p(desc, "desc");
        if (kotlin.jvm.internal.g0.g(name, "<init>")) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (z5) {
            arrayList.add(c());
        }
        c W = W(desc, true);
        E(arrayList, W.a(), false);
        Class<?> T = T();
        String str = name + "$default";
        Class<?>[] clsArr = (Class[]) arrayList.toArray(new Class[0]);
        Class<?> b6 = W.b();
        kotlin.jvm.internal.g0.m(b6);
        return V(T, str, clsArr, b6, z5);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00bd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x002a A[SYNTHETIC] */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final kotlin.reflect.jvm.internal.impl.descriptors.y I(@org.jetbrains.annotations.NotNull java.lang.String r14, @org.jetbrains.annotations.NotNull java.lang.String r15) {
        /*
            Method dump skipped, instructions count: 357
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.KDeclarationContainerImpl.I(java.lang.String, java.lang.String):kotlin.reflect.jvm.internal.impl.descriptors.y");
    }

    @Nullable
    public final Method K(@NotNull String name, @NotNull String desc) {
        Method V;
        kotlin.jvm.internal.g0.p(name, "name");
        kotlin.jvm.internal.g0.p(desc, "desc");
        if (kotlin.jvm.internal.g0.g(name, "<init>")) {
            return null;
        }
        c W = W(desc, true);
        Class<?>[] clsArr = (Class[]) W.a().toArray(new Class[0]);
        Class<?> b6 = W.b();
        kotlin.jvm.internal.g0.m(b6);
        Method V2 = V(T(), name, clsArr, b6, false);
        if (V2 != null) {
            return V2;
        }
        if (!T().isInterface() || (V = V(Object.class, name, clsArr, b6, false)) == null) {
            return null;
        }
        return V;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.descriptors.w0 L(@NotNull String name, @NotNull String signature) {
        kotlin.jvm.internal.g0.p(name, "name");
        kotlin.jvm.internal.g0.p(signature, "signature");
        kotlin.text.p matchEntire = f44237c.matchEntire(signature);
        if (matchEntire != null) {
            String str = matchEntire.a().k().c().get(1);
            kotlin.reflect.jvm.internal.impl.descriptors.w0 R = R(Integer.parseInt(str));
            if (R != null) {
                return R;
            }
            throw new KotlinReflectionInternalError("Local property #" + str + " not found in " + c());
        }
        kotlin.reflect.jvm.internal.impl.name.f h6 = kotlin.reflect.jvm.internal.impl.name.f.h(name);
        kotlin.jvm.internal.g0.o(h6, "identifier(...)");
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.w0> U = U(h6);
        ArrayList arrayList = new ArrayList();
        for (Object obj : U) {
            if (kotlin.jvm.internal.g0.g(k3.f47513a.f((kotlin.reflect.jvm.internal.impl.descriptors.w0) obj).a(), signature)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            throw new KotlinReflectionInternalError("Property '" + name + "' (JVM signature: " + signature + ") not resolved in " + this);
        }
        if (arrayList.size() == 1) {
            return (kotlin.reflect.jvm.internal.impl.descriptors.w0) kotlin.collections.f0.m5(arrayList);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj2 : arrayList) {
            kotlin.reflect.jvm.internal.impl.descriptors.s visibility = ((kotlin.reflect.jvm.internal.impl.descriptors.w0) obj2).getVisibility();
            Object obj3 = linkedHashMap.get(visibility);
            if (obj3 == null) {
                obj3 = new ArrayList();
                linkedHashMap.put(visibility, obj3);
            }
            ((List) obj3).add(obj2);
        }
        Collection values = kotlin.collections.i1.r(linkedHashMap, new f1(e1.f44340a)).values();
        kotlin.jvm.internal.g0.o(values, "<get-values>(...)");
        List list = (List) kotlin.collections.f0.s3(values);
        if (list.size() == 1) {
            kotlin.jvm.internal.g0.m(list);
            return (kotlin.reflect.jvm.internal.impl.descriptors.w0) kotlin.collections.f0.G2(list);
        }
        kotlin.reflect.jvm.internal.impl.name.f h7 = kotlin.reflect.jvm.internal.impl.name.f.h(name);
        kotlin.jvm.internal.g0.o(h7, "identifier(...)");
        String r32 = kotlin.collections.f0.r3(U(h7), com.snail.antifake.deviceid.e.f37542d, null, null, 0, null, g1.f44352a, 30, null);
        StringBuilder sb = new StringBuilder();
        sb.append("Property '");
        sb.append(name);
        sb.append("' (JVM signature: ");
        sb.append(signature);
        sb.append(") not resolved in ");
        sb.append(this);
        sb.append(':');
        sb.append(r32.length() == 0 ? " no members found" : '\n' + r32);
        throw new KotlinReflectionInternalError(sb.toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0051 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0020 A[SYNTHETIC] */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final java.util.Collection<kotlin.reflect.jvm.internal.e0<?>> S(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.k r8, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.KDeclarationContainerImpl.MemberBelonginess r9) {
        /*
            r7 = this;
            java.lang.String r0 = "scope"
            kotlin.jvm.internal.g0.p(r8, r0)
            java.lang.String r0 = "belonginess"
            kotlin.jvm.internal.g0.p(r9, r0)
            kotlin.reflect.jvm.internal.KDeclarationContainerImpl$d r0 = new kotlin.reflect.jvm.internal.KDeclarationContainerImpl$d
            r0.<init>(r7)
            r1 = 3
            r2 = 0
            java.util.Collection r8 = kotlin.reflect.jvm.internal.impl.resolve.scopes.n.a.a(r8, r2, r2, r1, r2)
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r8 = r8.iterator()
        L20:
            boolean r3 = r8.hasNext()
            if (r3 == 0) goto L55
            java.lang.Object r3 = r8.next()
            kotlin.reflect.jvm.internal.impl.descriptors.k r3 = (kotlin.reflect.jvm.internal.impl.descriptors.k) r3
            boolean r4 = r3 instanceof kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
            if (r4 == 0) goto L4e
            r4 = r3
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r4
            kotlin.reflect.jvm.internal.impl.descriptors.s r5 = r4.getVisibility()
            kotlin.reflect.jvm.internal.impl.descriptors.s r6 = kotlin.reflect.jvm.internal.impl.descriptors.r.f44951h
            boolean r5 = kotlin.jvm.internal.g0.g(r5, r6)
            if (r5 != 0) goto L4e
            boolean r4 = r9.accept(r4)
            if (r4 == 0) goto L4e
            kotlin.n1 r4 = kotlin.n1.f44123a
            java.lang.Object r3 = r3.W(r0, r4)
            kotlin.reflect.jvm.internal.e0 r3 = (kotlin.reflect.jvm.internal.e0) r3
            goto L4f
        L4e:
            r3 = r2
        L4f:
            if (r3 == 0) goto L20
            r1.add(r3)
            goto L20
        L55:
            java.util.List r8 = kotlin.collections.f0.a6(r1)
            java.util.Collection r8 = (java.util.Collection) r8
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.KDeclarationContainerImpl.S(kotlin.reflect.jvm.internal.impl.resolve.scopes.k, kotlin.reflect.jvm.internal.KDeclarationContainerImpl$MemberBelonginess):java.util.Collection");
    }

    private final void E(List<Class<?>> list, List<? extends Class<?>> list2, boolean z5) {
        Class<?> cls;
        if (kotlin.jvm.internal.g0.g(kotlin.collections.f0.A3(list2), f44236b)) {
            list2 = list2.subList(0, list2.size() - 1);
        }
        list.addAll(list2);
        int size = (list2.size() + 31) / 32;
        for (int i6 = 0; i6 < size; i6++) {
            Class<?> TYPE = Integer.TYPE;
            kotlin.jvm.internal.g0.o(TYPE, "TYPE");
            list.add(TYPE);
        }
        if (z5) {
            cls = f44236b;
        } else {
            cls = Object.class;
        }
        kotlin.jvm.internal.g0.m(cls);
        list.add(cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int M(kotlin.reflect.jvm.internal.impl.descriptors.s sVar, kotlin.reflect.jvm.internal.impl.descriptors.s sVar2) {
        Integer d6 = kotlin.reflect.jvm.internal.impl.descriptors.r.d(sVar, sVar2);
        if (d6 != null) {
            return d6.intValue();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int N(Function2 function2, Object obj, Object obj2) {
        return ((Number) function2.invoke(obj, obj2)).intValue();
    }

    private final Class<?> X(String str, int i6, int i7) {
        char charAt = str.charAt(i6);
        if (charAt != 'F') {
            if (charAt != 'L') {
                if (charAt != 'S') {
                    if (charAt != 'V') {
                        if (charAt != 'I') {
                            if (charAt != 'J') {
                                if (charAt != 'Z') {
                                    if (charAt != '[') {
                                        switch (charAt) {
                                            case 'B':
                                                return Byte.TYPE;
                                            case 'C':
                                                return Character.TYPE;
                                            case 'D':
                                                return Double.TYPE;
                                            default:
                                                throw new KotlinReflectionInternalError("Unknown type prefix in the method signature: " + str);
                                        }
                                    }
                                    return p3.f(X(str, i6 + 1, i7));
                                }
                                return Boolean.TYPE;
                            }
                            return Long.TYPE;
                        }
                        return Integer.TYPE;
                    }
                    Class<?> TYPE = Void.TYPE;
                    kotlin.jvm.internal.g0.o(TYPE, "TYPE");
                    return TYPE;
                }
                return Short.TYPE;
            }
            ClassLoader j6 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.f.j(c());
            String substring = str.substring(i6 + 1, i7 - 1);
            kotlin.jvm.internal.g0.o(substring, "substring(...)");
            Class<?> loadClass = j6.loadClass(kotlin.text.u.w2(substring, '/', '.', false, 4, null));
            kotlin.jvm.internal.g0.o(loadClass, "loadClass(...)");
            return loadClass;
        }
        return Float.TYPE;
    }

    @NotNull
    protected Class<?> T() {
        Class<?> k6 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.f.k(c());
        if (k6 == null) {
            return c();
        }
        return k6;
    }
}
