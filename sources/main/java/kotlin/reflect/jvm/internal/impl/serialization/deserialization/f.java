package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.d1;
import kotlin.collections.i1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.q1;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nAnnotationDeserializer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnnotationDeserializer.kt\norg/jetbrains/kotlin/serialization/deserialization/AnnotationDeserializer\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,127:1\n121#1:147\n121#1:148\n121#1:149\n121#1:150\n1208#2,2:128\n1236#2,4:130\n1617#2,9:134\n1869#2:143\n1870#2:145\n1626#2:146\n1563#2:151\n1634#2,3:152\n1740#2,3:155\n1#3:144\n*S KotlinDebug\n*F\n+ 1 AnnotationDeserializer.kt\norg/jetbrains/kotlin/serialization/deserialization/AnnotationDeserializer\n*L\n74#1:147\n76#1:148\n77#1:149\n78#1:150\n47#1:128,2\n47#1:130,4\n48#1:134,9\n48#1:143\n48#1:145\n48#1:146\n87#1:151\n87#1:152,3\n112#1:155,3\n48#1:144\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.descriptors.f0 f46960a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.descriptors.k0 f46961b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f46962a;

        static {
            int[] iArr = new int[ProtoBuf.Annotation.Argument.Value.Type.values().length];
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.BYTE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.CHAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.SHORT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.INT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.LONG.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.FLOAT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.DOUBLE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.BOOLEAN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.STRING.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.CLASS.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.ENUM.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.ANNOTATION.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.ARRAY.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            f46962a = iArr;
        }
    }

    public f(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.f0 module, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k0 notFoundClasses) {
        kotlin.jvm.internal.g0.p(module, "module");
        kotlin.jvm.internal.g0.p(notFoundClasses, "notFoundClasses");
        this.f46960a = module;
        this.f46961b = notFoundClasses;
    }

    private final kotlin.reflect.jvm.internal.impl.builtins.j c() {
        return this.f46960a.p();
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.d e(kotlin.reflect.jvm.internal.impl.name.b bVar) {
        return kotlin.reflect.jvm.internal.impl.descriptors.x.d(this.f46960a, bVar, this.f46961b);
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.descriptors.annotations.c a(@NotNull ProtoBuf.Annotation proto, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.d nameResolver) {
        kotlin.jvm.internal.g0.p(proto, "proto");
        kotlin.jvm.internal.g0.p(nameResolver, "nameResolver");
        kotlin.reflect.jvm.internal.impl.descriptors.d e6 = e(k0.a(nameResolver, proto.getId()));
        Map z5 = i1.z();
        if (proto.getArgumentCount() != 0 && !kotlin.reflect.jvm.internal.impl.types.error.i.m(e6) && kotlin.reflect.jvm.internal.impl.resolve.i.t(e6)) {
            Collection<kotlin.reflect.jvm.internal.impl.descriptors.c> f6 = e6.f();
            kotlin.jvm.internal.g0.o(f6, "getConstructors(...)");
            kotlin.reflect.jvm.internal.impl.descriptors.c cVar = (kotlin.reflect.jvm.internal.impl.descriptors.c) kotlin.collections.f0.n5(f6);
            if (cVar != null) {
                List<q1> g6 = cVar.g();
                kotlin.jvm.internal.g0.o(g6, "getValueParameters(...)");
                List<q1> list = g6;
                LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.t.u(i1.j(kotlin.collections.f0.d0(list, 10)), 16));
                for (Object obj : list) {
                    linkedHashMap.put(((q1) obj).getName(), obj);
                }
                List<ProtoBuf.Annotation.Argument> argumentList = proto.getArgumentList();
                kotlin.jvm.internal.g0.o(argumentList, "getArgumentList(...)");
                ArrayList arrayList = new ArrayList();
                for (ProtoBuf.Annotation.Argument argument : argumentList) {
                    kotlin.jvm.internal.g0.m(argument);
                    Pair<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> d6 = d(argument, linkedHashMap, nameResolver);
                    if (d6 != null) {
                        arrayList.add(d6);
                    }
                }
                z5 = i1.B0(arrayList);
            }
        }
        return new kotlin.reflect.jvm.internal.impl.descriptors.annotations.d(e6.s(), z5, e1.f44683a);
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> f(@NotNull kotlin.reflect.jvm.internal.impl.types.t0 expectedType, @NotNull ProtoBuf.Annotation.Argument.Value value, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.d nameResolver) {
        kotlin.jvm.internal.g0.p(expectedType, "expectedType");
        kotlin.jvm.internal.g0.p(value, "value");
        kotlin.jvm.internal.g0.p(nameResolver, "nameResolver");
        Boolean d6 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.P.d(value.getFlags());
        kotlin.jvm.internal.g0.o(d6, "get(...)");
        boolean booleanValue = d6.booleanValue();
        ProtoBuf.Annotation.Argument.Value.Type type = value.getType();
        switch (type == null ? -1 : a.f46962a[type.ordinal()]) {
            case 1:
                byte intValue = (byte) value.getIntValue();
                return booleanValue ? new kotlin.reflect.jvm.internal.impl.resolve.constants.b0(intValue) : new kotlin.reflect.jvm.internal.impl.resolve.constants.d(intValue);
            case 2:
                return new kotlin.reflect.jvm.internal.impl.resolve.constants.e((char) value.getIntValue());
            case 3:
                short intValue2 = (short) value.getIntValue();
                return booleanValue ? new kotlin.reflect.jvm.internal.impl.resolve.constants.e0(intValue2) : new kotlin.reflect.jvm.internal.impl.resolve.constants.x(intValue2);
            case 4:
                int intValue3 = (int) value.getIntValue();
                return booleanValue ? new kotlin.reflect.jvm.internal.impl.resolve.constants.c0(intValue3) : new kotlin.reflect.jvm.internal.impl.resolve.constants.n(intValue3);
            case 5:
                long intValue4 = value.getIntValue();
                return booleanValue ? new kotlin.reflect.jvm.internal.impl.resolve.constants.d0(intValue4) : new kotlin.reflect.jvm.internal.impl.resolve.constants.u(intValue4);
            case 6:
                return new kotlin.reflect.jvm.internal.impl.resolve.constants.m(value.getFloatValue());
            case 7:
                return new kotlin.reflect.jvm.internal.impl.resolve.constants.j(value.getDoubleValue());
            case 8:
                return new kotlin.reflect.jvm.internal.impl.resolve.constants.c(value.getIntValue() != 0);
            case 9:
                return new kotlin.reflect.jvm.internal.impl.resolve.constants.y(nameResolver.getString(value.getStringValue()));
            case 10:
                return new kotlin.reflect.jvm.internal.impl.resolve.constants.t(k0.a(nameResolver, value.getClassId()), value.getArrayDimensionCount());
            case 11:
                return new kotlin.reflect.jvm.internal.impl.resolve.constants.k(k0.a(nameResolver, value.getClassId()), k0.b(nameResolver, value.getEnumValueId()));
            case 12:
                ProtoBuf.Annotation annotation = value.getAnnotation();
                kotlin.jvm.internal.g0.o(annotation, "getAnnotation(...)");
                return new kotlin.reflect.jvm.internal.impl.resolve.constants.a(a(annotation, nameResolver));
            case 13:
                kotlin.reflect.jvm.internal.impl.resolve.constants.i iVar = kotlin.reflect.jvm.internal.impl.resolve.constants.i.f46667a;
                List<ProtoBuf.Annotation.Argument.Value> arrayElementList = value.getArrayElementList();
                kotlin.jvm.internal.g0.o(arrayElementList, "getArrayElementList(...)");
                List<ProtoBuf.Annotation.Argument.Value> list = arrayElementList;
                ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(list, 10));
                for (ProtoBuf.Annotation.Argument.Value value2 : list) {
                    kotlin.reflect.jvm.internal.impl.types.e1 i6 = c().i();
                    kotlin.jvm.internal.g0.o(i6, "getAnyType(...)");
                    kotlin.jvm.internal.g0.m(value2);
                    arrayList.add(f(i6, value2, nameResolver));
                }
                return iVar.c(arrayList, expectedType);
            default:
                throw new IllegalStateException(("Unsupported annotation argument type: " + value.getType() + " (expected " + expectedType + ')').toString());
        }
    }

    private final boolean b(kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> gVar, kotlin.reflect.jvm.internal.impl.types.t0 t0Var, ProtoBuf.Annotation.Argument.Value value) {
        int i6;
        kotlin.reflect.jvm.internal.impl.descriptors.d dVar;
        ProtoBuf.Annotation.Argument.Value.Type type = value.getType();
        if (type == null) {
            i6 = -1;
        } else {
            i6 = a.f46962a[type.ordinal()];
        }
        if (i6 != 10) {
            if (i6 != 13) {
                return kotlin.jvm.internal.g0.g(gVar.getType(this.f46960a), t0Var);
            }
            if ((gVar instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.b) && ((kotlin.reflect.jvm.internal.impl.resolve.constants.b) gVar).a().size() == value.getArrayElementList().size()) {
                kotlin.reflect.jvm.internal.impl.types.t0 l6 = c().l(t0Var);
                if (l6 == null) {
                    return false;
                }
                kotlin.reflect.jvm.internal.impl.resolve.constants.b bVar = (kotlin.reflect.jvm.internal.impl.resolve.constants.b) gVar;
                Iterable K = kotlin.collections.f0.K(bVar.a());
                if ((K instanceof Collection) && ((Collection) K).isEmpty()) {
                    return true;
                }
                Iterator it = K.iterator();
                while (it.hasNext()) {
                    int nextInt = ((d1) it).nextInt();
                    kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> gVar2 = bVar.a().get(nextInt);
                    ProtoBuf.Annotation.Argument.Value arrayElement = value.getArrayElement(nextInt);
                    kotlin.jvm.internal.g0.o(arrayElement, "getArrayElement(...)");
                    if (!b(gVar2, l6, arrayElement)) {
                        return false;
                    }
                }
                return true;
            }
            throw new IllegalStateException(("Deserialized ArrayValue should have the same number of elements as the original array value: " + gVar).toString());
        }
        kotlin.reflect.jvm.internal.impl.descriptors.f c6 = t0Var.I0().c();
        if (c6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
            dVar = (kotlin.reflect.jvm.internal.impl.descriptors.d) c6;
        } else {
            dVar = null;
        }
        if (dVar == null || kotlin.reflect.jvm.internal.impl.builtins.j.m0(dVar)) {
            return true;
        }
        return false;
    }

    private final Pair<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> d(ProtoBuf.Annotation.Argument argument, Map<kotlin.reflect.jvm.internal.impl.name.f, ? extends q1> map, kotlin.reflect.jvm.internal.impl.metadata.deserialization.d dVar) {
        q1 q1Var = map.get(k0.b(dVar, argument.getNameId()));
        if (q1Var == null) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.name.f b6 = k0.b(dVar, argument.getNameId());
        kotlin.reflect.jvm.internal.impl.types.t0 type = q1Var.getType();
        kotlin.jvm.internal.g0.o(type, "getType(...)");
        ProtoBuf.Annotation.Argument.Value value = argument.getValue();
        kotlin.jvm.internal.g0.o(value, "getValue(...)");
        return new Pair<>(b6, g(type, value, dVar));
    }

    private final kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> g(kotlin.reflect.jvm.internal.impl.types.t0 t0Var, ProtoBuf.Annotation.Argument.Value value, kotlin.reflect.jvm.internal.impl.metadata.deserialization.d dVar) {
        kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> f6 = f(t0Var, value, dVar);
        if (!b(f6, t0Var, value)) {
            f6 = null;
        }
        if (f6 == null) {
            return kotlin.reflect.jvm.internal.impl.resolve.constants.l.f46670b.a("Unexpected argument value: actual type " + value.getType() + " != expected type " + t0Var);
        }
        return f6;
    }
}
