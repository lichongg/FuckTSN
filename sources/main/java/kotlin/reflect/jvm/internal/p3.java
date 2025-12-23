package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.PropertyReference;
import kotlin.jvm.internal.RepeatableContainer;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KVisibility;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.l;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.resolve.constants.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nutil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 util.kt\nkotlin/reflect/jvm/internal/UtilKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,333:1\n1617#2,9:334\n1869#2:343\n1870#2:345\n1626#2:346\n1761#2,3:347\n1374#2:350\n1460#2,5:351\n1617#2,9:356\n1869#2:365\n1870#2:368\n1626#2:369\n1563#2:370\n1634#2,3:371\n1#3:344\n1#3:366\n1#3:367\n1#3:374\n*S KotlinDebug\n*F\n+ 1 util.kt\nkotlin/reflect/jvm/internal/UtilKt\n*L\n137#1:334,9\n137#1:343\n137#1:345\n137#1:346\n146#1:347,3\n147#1:350\n147#1:351,5\n167#1:356,9\n167#1:365\n167#1:368\n167#1:369\n197#1:370\n197#1:371,3\n137#1:344\n167#1:367\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class p3 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.name.c f47558a = new kotlin.reflect.jvm.internal.impl.name.c("kotlin.jvm.JvmStatic");

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f47559a;

        static {
            int[] iArr = new int[PrimitiveType.values().length];
            try {
                iArr[PrimitiveType.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PrimitiveType.CHAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PrimitiveType.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PrimitiveType.SHORT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PrimitiveType.INT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PrimitiveType.FLOAT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PrimitiveType.LONG.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[PrimitiveType.DOUBLE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            f47559a = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final Object a(kotlin.reflect.jvm.internal.impl.resolve.constants.b bVar, ClassLoader classLoader) {
        kotlin.reflect.jvm.internal.impl.types.t0 type;
        Class q5;
        kotlin.reflect.jvm.internal.impl.resolve.constants.a0 a0Var = bVar instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.a0 ? (kotlin.reflect.jvm.internal.impl.resolve.constants.a0) bVar : null;
        if (a0Var == null || (type = a0Var.getType()) == null) {
            return null;
        }
        List<? extends kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> a6 = bVar.a();
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(a6, 10));
        Iterator<T> it = a6.iterator();
        while (it.hasNext()) {
            arrayList.add(u((kotlin.reflect.jvm.internal.impl.resolve.constants.g) it.next(), classLoader));
        }
        PrimitiveType O = kotlin.reflect.jvm.internal.impl.builtins.j.O(type);
        int i6 = 0;
        switch (O == null ? -1 : a.f47559a[O.ordinal()]) {
            case -1:
                if (!kotlin.reflect.jvm.internal.impl.builtins.j.d0(type)) {
                    throw new IllegalStateException(("Not an array type: " + type).toString());
                }
                kotlin.reflect.jvm.internal.impl.types.t0 type2 = ((kotlin.reflect.jvm.internal.impl.types.c2) kotlin.collections.f0.m5(type.G0())).getType();
                kotlin.jvm.internal.g0.o(type2, "getType(...)");
                kotlin.reflect.jvm.internal.impl.descriptors.f c6 = type2.I0().c();
                kotlin.reflect.jvm.internal.impl.descriptors.d dVar = c6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d ? (kotlin.reflect.jvm.internal.impl.descriptors.d) c6 : null;
                if (dVar == null) {
                    throw new IllegalStateException(("Not a class type: " + type2).toString());
                }
                if (kotlin.reflect.jvm.internal.impl.builtins.j.w0(type2)) {
                    int size = bVar.a().size();
                    String[] strArr = new String[size];
                    while (i6 < size) {
                        Object obj = arrayList.get(i6);
                        kotlin.jvm.internal.g0.n(obj, "null cannot be cast to non-null type kotlin.String");
                        strArr[i6] = obj;
                        i6++;
                    }
                    return strArr;
                }
                if (kotlin.reflect.jvm.internal.impl.builtins.j.m0(dVar)) {
                    int size2 = bVar.a().size();
                    Class[] clsArr = new Class[size2];
                    while (i6 < size2) {
                        Object obj2 = arrayList.get(i6);
                        kotlin.jvm.internal.g0.n(obj2, "null cannot be cast to non-null type java.lang.Class<*>");
                        clsArr[i6] = obj2;
                        i6++;
                    }
                    return clsArr;
                }
                kotlin.reflect.jvm.internal.impl.name.b n6 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.n(dVar);
                if (n6 == null || (q5 = q(classLoader, n6, 0, 2, null)) == null) {
                    return null;
                }
                Object newInstance = Array.newInstance((Class<?>) q5, bVar.a().size());
                kotlin.jvm.internal.g0.n(newInstance, "null cannot be cast to non-null type kotlin.Array<in kotlin.Any?>");
                Object[] objArr = (Object[]) newInstance;
                int size3 = arrayList.size();
                while (i6 < size3) {
                    objArr[i6] = arrayList.get(i6);
                    i6++;
                }
                return objArr;
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
                int size4 = bVar.a().size();
                boolean[] zArr = new boolean[size4];
                while (i6 < size4) {
                    Object obj3 = arrayList.get(i6);
                    kotlin.jvm.internal.g0.n(obj3, "null cannot be cast to non-null type kotlin.Boolean");
                    zArr[i6] = ((Boolean) obj3).booleanValue();
                    i6++;
                }
                return zArr;
            case 2:
                int size5 = bVar.a().size();
                char[] cArr = new char[size5];
                while (i6 < size5) {
                    Object obj4 = arrayList.get(i6);
                    kotlin.jvm.internal.g0.n(obj4, "null cannot be cast to non-null type kotlin.Char");
                    cArr[i6] = ((Character) obj4).charValue();
                    i6++;
                }
                return cArr;
            case 3:
                int size6 = bVar.a().size();
                byte[] bArr = new byte[size6];
                while (i6 < size6) {
                    Object obj5 = arrayList.get(i6);
                    kotlin.jvm.internal.g0.n(obj5, "null cannot be cast to non-null type kotlin.Byte");
                    bArr[i6] = ((Byte) obj5).byteValue();
                    i6++;
                }
                return bArr;
            case 4:
                int size7 = bVar.a().size();
                short[] sArr = new short[size7];
                while (i6 < size7) {
                    Object obj6 = arrayList.get(i6);
                    kotlin.jvm.internal.g0.n(obj6, "null cannot be cast to non-null type kotlin.Short");
                    sArr[i6] = ((Short) obj6).shortValue();
                    i6++;
                }
                return sArr;
            case 5:
                int size8 = bVar.a().size();
                int[] iArr = new int[size8];
                while (i6 < size8) {
                    Object obj7 = arrayList.get(i6);
                    kotlin.jvm.internal.g0.n(obj7, "null cannot be cast to non-null type kotlin.Int");
                    iArr[i6] = ((Integer) obj7).intValue();
                    i6++;
                }
                return iArr;
            case 6:
                int size9 = bVar.a().size();
                float[] fArr = new float[size9];
                while (i6 < size9) {
                    Object obj8 = arrayList.get(i6);
                    kotlin.jvm.internal.g0.n(obj8, "null cannot be cast to non-null type kotlin.Float");
                    fArr[i6] = ((Float) obj8).floatValue();
                    i6++;
                }
                return fArr;
            case 7:
                int size10 = bVar.a().size();
                long[] jArr = new long[size10];
                while (i6 < size10) {
                    Object obj9 = arrayList.get(i6);
                    kotlin.jvm.internal.g0.n(obj9, "null cannot be cast to non-null type kotlin.Long");
                    jArr[i6] = ((Long) obj9).longValue();
                    i6++;
                }
                return jArr;
            case 8:
                int size11 = bVar.a().size();
                double[] dArr = new double[size11];
                while (i6 < size11) {
                    Object obj10 = arrayList.get(i6);
                    kotlin.jvm.internal.g0.n(obj10, "null cannot be cast to non-null type kotlin.Double");
                    dArr[i6] = ((Double) obj10).doubleValue();
                    i6++;
                }
                return dArr;
        }
    }

    @Nullable
    public static final e0<?> b(@Nullable Object obj) {
        e0<?> e0Var = obj instanceof e0 ? (e0) obj : null;
        if (e0Var != null) {
            return e0Var;
        }
        m1 c6 = c(obj);
        return c6 != null ? c6 : d(obj);
    }

    @Nullable
    public static final m1 c(@Nullable Object obj) {
        m1 m1Var = obj instanceof m1 ? (m1) obj : null;
        if (m1Var != null) {
            return m1Var;
        }
        FunctionReference functionReference = obj instanceof FunctionReference ? (FunctionReference) obj : null;
        kotlin.reflect.c compute = functionReference != null ? functionReference.compute() : null;
        if (compute instanceof m1) {
            return (m1) compute;
        }
        return null;
    }

    @Nullable
    public static final p2<?> d(@Nullable Object obj) {
        p2<?> p2Var = obj instanceof p2 ? (p2) obj : null;
        if (p2Var != null) {
            return p2Var;
        }
        PropertyReference propertyReference = obj instanceof PropertyReference ? (PropertyReference) obj : null;
        kotlin.reflect.c compute = propertyReference != null ? propertyReference.compute() : null;
        if (compute instanceof p2) {
            return (p2) compute;
        }
        return null;
    }

    @NotNull
    public static final List<Annotation> e(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.a aVar) {
        Annotation r5;
        kotlin.jvm.internal.g0.p(aVar, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations = aVar.getAnnotations();
        ArrayList arrayList = new ArrayList();
        for (kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar : annotations) {
            kotlin.reflect.jvm.internal.impl.descriptors.e1 source = cVar.getSource();
            if (source instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.b) {
                r5 = ((kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.b) source).d();
            } else if (source instanceof l.a) {
                kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.u c6 = ((l.a) source).c();
                kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.g gVar = c6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.g ? (kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.g) c6 : null;
                r5 = gVar != null ? gVar.M() : null;
            } else {
                r5 = r(cVar);
            }
            if (r5 != null) {
                arrayList.add(r5);
            }
        }
        return v(arrayList);
    }

    @NotNull
    public static final Class<?> f(@NotNull Class<?> cls) {
        kotlin.jvm.internal.g0.p(cls, "<this>");
        return Array.newInstance(cls, 0).getClass();
    }

    @Nullable
    public static final Object g(@NotNull Type type) {
        kotlin.jvm.internal.g0.p(type, "type");
        if (!(type instanceof Class)) {
            return null;
        }
        Class cls = (Class) type;
        if (!cls.isPrimitive()) {
            return null;
        }
        if (kotlin.jvm.internal.g0.g(cls, Boolean.TYPE)) {
            return Boolean.FALSE;
        }
        if (kotlin.jvm.internal.g0.g(cls, Character.TYPE)) {
            return (char) 0;
        }
        if (kotlin.jvm.internal.g0.g(cls, Byte.TYPE)) {
            return (byte) 0;
        }
        if (kotlin.jvm.internal.g0.g(cls, Short.TYPE)) {
            return (short) 0;
        }
        if (kotlin.jvm.internal.g0.g(cls, Integer.TYPE)) {
            return 0;
        }
        if (kotlin.jvm.internal.g0.g(cls, Float.TYPE)) {
            return Float.valueOf(0.0f);
        }
        if (kotlin.jvm.internal.g0.g(cls, Long.TYPE)) {
            return 0L;
        }
        if (kotlin.jvm.internal.g0.g(cls, Double.TYPE)) {
            return Double.valueOf(0.0d);
        }
        if (kotlin.jvm.internal.g0.g(cls, Void.TYPE)) {
            throw new IllegalStateException("Parameter with void type is illegal");
        }
        throw new UnsupportedOperationException("Unknown primitive: " + type);
    }

    @NotNull
    public static final <M extends kotlin.reflect.jvm.internal.impl.protobuf.n, D extends kotlin.reflect.jvm.internal.impl.descriptors.a> D h(@NotNull Class<?> moduleAnchor, @NotNull M proto, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.d nameResolver, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.h typeTable, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.a metadataVersion, @NotNull Function2<? super kotlin.reflect.jvm.internal.impl.serialization.deserialization.j0, ? super M, ? extends D> createDescriptor) {
        List<ProtoBuf.TypeParameter> typeParameterList;
        kotlin.jvm.internal.g0.p(moduleAnchor, "moduleAnchor");
        kotlin.jvm.internal.g0.p(proto, "proto");
        kotlin.jvm.internal.g0.p(nameResolver, "nameResolver");
        kotlin.jvm.internal.g0.p(typeTable, "typeTable");
        kotlin.jvm.internal.g0.p(metadataVersion, "metadataVersion");
        kotlin.jvm.internal.g0.p(createDescriptor, "createDescriptor");
        kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.k b6 = e3.b(moduleAnchor);
        if (proto instanceof ProtoBuf.Function) {
            typeParameterList = ((ProtoBuf.Function) proto).getTypeParameterList();
        } else {
            if (!(proto instanceof ProtoBuf.Property)) {
                throw new IllegalStateException(("Unsupported message: " + proto).toString());
            }
            typeParameterList = ((ProtoBuf.Property) proto).getTypeParameterList();
        }
        List<ProtoBuf.TypeParameter> list = typeParameterList;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.m a6 = b6.a();
        kotlin.reflect.jvm.internal.impl.descriptors.f0 b7 = b6.b();
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.j b8 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.j.f46256b.b();
        kotlin.jvm.internal.g0.m(list);
        return createDescriptor.invoke(new kotlin.reflect.jvm.internal.impl.serialization.deserialization.j0(new kotlin.reflect.jvm.internal.impl.serialization.deserialization.o(a6, nameResolver, b7, typeTable, b8, metadataVersion, null, null, list)), proto);
    }

    @Nullable
    public static final Field i(@NotNull Class<?> cls, @NotNull String name) {
        kotlin.jvm.internal.g0.p(cls, "<this>");
        kotlin.jvm.internal.g0.p(name, "name");
        try {
            return cls.getDeclaredField(name);
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }

    @Nullable
    public static final Method j(@NotNull Class<?> cls, @NotNull String name, @NotNull Class<?>... parameterTypes) {
        kotlin.jvm.internal.g0.p(cls, "<this>");
        kotlin.jvm.internal.g0.p(name, "name");
        kotlin.jvm.internal.g0.p(parameterTypes, "parameterTypes");
        try {
            return cls.getDeclaredMethod(name, (Class[]) Arrays.copyOf(parameterTypes, parameterTypes.length));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    @Nullable
    public static final kotlin.reflect.jvm.internal.impl.descriptors.z0 k(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a aVar) {
        kotlin.jvm.internal.g0.p(aVar, "<this>");
        if (aVar.c0() == null) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.k b6 = aVar.b();
        kotlin.jvm.internal.g0.n(b6, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        return ((kotlin.reflect.jvm.internal.impl.descriptors.d) b6).V();
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.c l() {
        return f47558a;
    }

    public static final boolean m(@NotNull kotlin.reflect.r rVar) {
        kotlin.reflect.jvm.internal.impl.types.t0 type;
        kotlin.jvm.internal.g0.p(rVar, "<this>");
        z2 z2Var = rVar instanceof z2 ? (z2) rVar : null;
        return (z2Var == null || (type = z2Var.getType()) == null || !kotlin.reflect.jvm.internal.impl.resolve.j.i(type)) ? false : true;
    }

    public static final boolean n(@NotNull kotlin.reflect.r rVar) {
        kotlin.reflect.jvm.internal.impl.types.t0 type;
        kotlin.jvm.internal.g0.p(rVar, "<this>");
        z2 z2Var = rVar instanceof z2 ? (z2) rVar : null;
        return (z2Var == null || (type = z2Var.getType()) == null || !kotlin.reflect.jvm.internal.impl.resolve.j.c(type)) ? false : true;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    private static final Class<?> o(ClassLoader classLoader, String str, String str2, int i6) {
        if (kotlin.jvm.internal.g0.g(str, "kotlin")) {
            switch (str2.hashCode()) {
                case -901856463:
                    if (str2.equals("BooleanArray")) {
                        return boolean[].class;
                    }
                    break;
                case -763279523:
                    if (str2.equals("ShortArray")) {
                        return short[].class;
                    }
                    break;
                case -755911549:
                    if (str2.equals("CharArray")) {
                        return char[].class;
                    }
                    break;
                case -74930671:
                    if (str2.equals("ByteArray")) {
                        return byte[].class;
                    }
                    break;
                case 22374632:
                    if (str2.equals("DoubleArray")) {
                        return double[].class;
                    }
                    break;
                case 63537721:
                    if (str2.equals("Array")) {
                        return Object[].class;
                    }
                    break;
                case 601811914:
                    if (str2.equals("IntArray")) {
                        return int[].class;
                    }
                    break;
                case 948852093:
                    if (str2.equals("FloatArray")) {
                        return float[].class;
                    }
                    break;
                case 2104330525:
                    if (str2.equals("LongArray")) {
                        return long[].class;
                    }
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (i6 > 0) {
            for (int i7 = 0; i7 < i6; i7++) {
                sb.append("[");
            }
            sb.append("L");
        }
        if (str.length() > 0) {
            sb.append(str + '.');
        }
        sb.append(kotlin.text.u.w2(str2, '.', kotlin.text.v0.f47959c, false, 4, null));
        if (i6 > 0) {
            sb.append(";");
        }
        return kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.e.a(classLoader, sb.toString());
    }

    @Nullable
    public static final Class<?> p(@NotNull ClassLoader classLoader, @NotNull kotlin.reflect.jvm.internal.impl.name.b kotlinClassId, int i6) {
        kotlin.jvm.internal.g0.p(classLoader, "<this>");
        kotlin.jvm.internal.g0.p(kotlinClassId, "kotlinClassId");
        kotlin.reflect.jvm.internal.impl.name.b n6 = kotlin.reflect.jvm.internal.impl.builtins.jvm.c.f44463a.n(kotlinClassId.a().i());
        if (n6 == null) {
            n6 = kotlinClassId;
        }
        if (!kotlin.jvm.internal.g0.g(n6, kotlinClassId)) {
            classLoader = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.f.j(kotlin.n1.class);
        }
        return o(classLoader, n6.f().a(), n6.g().a(), i6);
    }

    public static /* synthetic */ Class q(ClassLoader classLoader, kotlin.reflect.jvm.internal.impl.name.b bVar, int i6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i6 = 0;
        }
        return p(classLoader, bVar, i6);
    }

    @Nullable
    public static final Class<?> s(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        kotlin.jvm.internal.g0.p(dVar, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.e1 source = dVar.getSource();
        kotlin.jvm.internal.g0.o(source, "getSource(...)");
        if (source instanceof kotlin.reflect.jvm.internal.impl.load.kotlin.z) {
            kotlin.reflect.jvm.internal.impl.load.kotlin.x d6 = ((kotlin.reflect.jvm.internal.impl.load.kotlin.z) source).d();
            kotlin.jvm.internal.g0.n(d6, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.components.ReflectKotlinClass");
            return ((kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.f) d6).a();
        }
        if (source instanceof l.a) {
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.u c6 = ((l.a) source).c();
            kotlin.jvm.internal.g0.n(c6, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.structure.ReflectJavaClass");
            return ((kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.q) c6).getElement();
        }
        kotlin.reflect.jvm.internal.impl.name.b n6 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.n(dVar);
        if (n6 == null) {
            return null;
        }
        return q(kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.f.j(dVar.getClass()), n6, 0, 2, null);
    }

    @Nullable
    public static final KVisibility t(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.s sVar) {
        kotlin.jvm.internal.g0.p(sVar, "<this>");
        if (kotlin.jvm.internal.g0.g(sVar, kotlin.reflect.jvm.internal.impl.descriptors.r.f44948e)) {
            return KVisibility.PUBLIC;
        }
        if (kotlin.jvm.internal.g0.g(sVar, kotlin.reflect.jvm.internal.impl.descriptors.r.f44946c)) {
            return KVisibility.PROTECTED;
        }
        if (kotlin.jvm.internal.g0.g(sVar, kotlin.reflect.jvm.internal.impl.descriptors.r.f44947d)) {
            return KVisibility.INTERNAL;
        }
        if (kotlin.jvm.internal.g0.g(sVar, kotlin.reflect.jvm.internal.impl.descriptors.r.f44944a) || kotlin.jvm.internal.g0.g(sVar, kotlin.reflect.jvm.internal.impl.descriptors.r.f44945b)) {
            return KVisibility.PRIVATE;
        }
        return null;
    }

    private static final Object u(kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> gVar, ClassLoader classLoader) {
        if (gVar instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.a) {
            return r(((kotlin.reflect.jvm.internal.impl.resolve.constants.a) gVar).a());
        }
        if (gVar instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.b) {
            return a((kotlin.reflect.jvm.internal.impl.resolve.constants.b) gVar, classLoader);
        }
        if (gVar instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.k) {
            Pair<? extends kotlin.reflect.jvm.internal.impl.name.b, ? extends kotlin.reflect.jvm.internal.impl.name.f> a6 = ((kotlin.reflect.jvm.internal.impl.resolve.constants.k) gVar).a();
            kotlin.reflect.jvm.internal.impl.name.b component1 = a6.component1();
            kotlin.reflect.jvm.internal.impl.name.f component2 = a6.component2();
            Class q5 = q(classLoader, component1, 0, 2, null);
            if (q5 != null) {
                return o3.a(q5, component2.b());
            }
            return null;
        }
        if (!(gVar instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.t)) {
            if ((gVar instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.l) || (gVar instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.v)) {
                return null;
            }
            return gVar.a();
        }
        t.b a7 = ((kotlin.reflect.jvm.internal.impl.resolve.constants.t) gVar).a();
        if (a7 instanceof t.b.C0913b) {
            t.b.C0913b c0913b = (t.b.C0913b) a7;
            return p(classLoader, c0913b.b(), c0913b.a());
        }
        if (!(a7 instanceof t.b.a)) {
            throw new NoWhenBranchMatchedException();
        }
        kotlin.reflect.jvm.internal.impl.descriptors.f c6 = ((t.b.a) a7).getType().I0().c();
        kotlin.reflect.jvm.internal.impl.descriptors.d dVar = c6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d ? (kotlin.reflect.jvm.internal.impl.descriptors.d) c6 : null;
        if (dVar != null) {
            return s(dVar);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Object, java.util.List<? extends java.lang.annotation.Annotation>, java.util.List<java.lang.annotation.Annotation>] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.util.List<java.lang.annotation.Annotation>] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.util.ArrayList, java.util.Collection] */
    @NotNull
    public static final List<Annotation> v(@NotNull List<? extends Annotation> list) {
        List l6;
        kotlin.jvm.internal.g0.p(list, "<this>");
        Iterable<Annotation> iterable = (Iterable) list;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return list;
        }
        Iterator it = iterable.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            if (kotlin.jvm.internal.g0.g(l3.a.e(l3.a.a((Annotation) it.next())).getSimpleName(), "Container")) {
                list = new ArrayList<>();
                for (Annotation annotation : iterable) {
                    Class e6 = l3.a.e(l3.a.a(annotation));
                    if (!kotlin.jvm.internal.g0.g(e6.getSimpleName(), "Container") || e6.getAnnotation(RepeatableContainer.class) == null) {
                        l6 = kotlin.collections.f0.l(annotation);
                    } else {
                        Object invoke = e6.getDeclaredMethod("value", null).invoke(annotation, null);
                        kotlin.jvm.internal.g0.n(invoke, "null cannot be cast to non-null type kotlin.Array<out kotlin.Annotation>");
                        l6 = kotlin.collections.n.t((Annotation[]) invoke);
                    }
                    kotlin.collections.f0.s0(list, l6);
                }
            }
        }
        return list;
    }

    private static final Annotation r(kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar) {
        Class<?> cls;
        Pair pair;
        kotlin.reflect.jvm.internal.impl.descriptors.d l6 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.l(cVar);
        if (l6 != null) {
            cls = s(l6);
        } else {
            cls = null;
        }
        if (!androidx.activity.k.a(cls)) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        Set<Map.Entry<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>>> entrySet = cVar.a().entrySet();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            kotlin.reflect.jvm.internal.impl.name.f fVar = (kotlin.reflect.jvm.internal.impl.name.f) entry.getKey();
            kotlin.reflect.jvm.internal.impl.resolve.constants.g gVar = (kotlin.reflect.jvm.internal.impl.resolve.constants.g) entry.getValue();
            ClassLoader classLoader = cls.getClassLoader();
            kotlin.jvm.internal.g0.o(classLoader, "getClassLoader(...)");
            Object u5 = u(gVar, classLoader);
            if (u5 != null) {
                pair = kotlin.o0.a(fVar.b(), u5);
            } else {
                pair = null;
            }
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        return (Annotation) kotlin.reflect.jvm.internal.calls.e.h(cls, kotlin.collections.i1.B0(arrayList), null, 4, null);
    }
}
