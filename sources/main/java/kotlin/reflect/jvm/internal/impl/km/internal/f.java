package kotlin.reflect.jvm.internal.impl.km.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.i1;
import kotlin.d1;
import kotlin.j1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.o0;
import kotlin.reflect.jvm.internal.impl.km.e;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.v0;
import kotlin.z0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nReadUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReadUtils.kt\nkotlin/metadata/internal/ReadUtilsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,64:1\n1617#2,9:65\n1869#2:74\n1870#2:76\n1626#2:77\n1617#2,9:78\n1869#2:87\n1870#2:89\n1626#2:90\n1#3:75\n1#3:88\n*S KotlinDebug\n*F\n+ 1 ReadUtils.kt\nkotlin/metadata/internal/ReadUtilsKt\n*L\n19#1:65,9\n19#1:74\n19#1:76\n19#1:77\n55#1:78,9\n55#1:87\n55#1:89\n55#1:90\n19#1:75\n55#1:88\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class f {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f45192a;

        static {
            int[] iArr = new int[ProtoBuf.Annotation.Argument.Value.Type.values().length];
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.BYTE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.SHORT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.INT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.LONG.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.CHAR.ordinal()] = 5;
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
            f45192a = iArr;
        }
    }

    @NotNull
    public static final String a(@NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.d dVar, int i6) {
        g0.p(dVar, "<this>");
        String a6 = dVar.a(i6);
        if (!dVar.b(i6)) {
            return a6;
        }
        return '.' + a6;
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.km.d b(@NotNull ProtoBuf.Annotation annotation, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.d strings) {
        g0.p(annotation, "<this>");
        g0.p(strings, "strings");
        String a6 = a(strings, annotation.getId());
        List<ProtoBuf.Annotation.Argument> argumentList = annotation.getArgumentList();
        g0.o(argumentList, "getArgumentList(...)");
        ArrayList arrayList = new ArrayList();
        for (ProtoBuf.Annotation.Argument argument : argumentList) {
            ProtoBuf.Annotation.Argument.Value value = argument.getValue();
            g0.o(value, "getValue(...)");
            kotlin.reflect.jvm.internal.impl.km.e c6 = c(value, strings);
            Pair a7 = c6 != null ? o0.a(strings.getString(argument.getNameId()), c6) : null;
            if (a7 != null) {
                arrayList.add(a7);
            }
        }
        return new kotlin.reflect.jvm.internal.impl.km.d(a6, i1.B0(arrayList));
    }

    @Nullable
    public static final kotlin.reflect.jvm.internal.impl.km.e c(@NotNull ProtoBuf.Annotation.Argument.Value value, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.d strings) {
        g0.p(value, "<this>");
        g0.p(strings, "strings");
        if (kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.P.d(value.getFlags()).booleanValue()) {
            ProtoBuf.Annotation.Argument.Value.Type type = value.getType();
            int i6 = type != null ? a.f45192a[type.ordinal()] : -1;
            if (i6 == 1) {
                return new e.p(v0.k((byte) value.getIntValue()), null);
            }
            if (i6 == 2) {
                return new e.s(j1.k((short) value.getIntValue()), null);
            }
            if (i6 == 3) {
                return new e.q(z0.k((int) value.getIntValue()), null);
            }
            if (i6 == 4) {
                return new e.r(d1.k(value.getIntValue()), null);
            }
            throw new IllegalStateException(("Cannot read value of unsigned type: " + value.getType()).toString());
        }
        ProtoBuf.Annotation.Argument.Value.Type type2 = value.getType();
        switch (type2 != null ? a.f45192a[type2.ordinal()] : -1) {
            case -1:
                return null;
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
                return new e.C0883e((byte) value.getIntValue());
            case 2:
                return new e.n((short) value.getIntValue());
            case 3:
                return new e.j((int) value.getIntValue());
            case 4:
                return new e.m(value.getIntValue());
            case 5:
                return new e.f((char) value.getIntValue());
            case 6:
                return new e.i(value.getFloatValue());
            case 7:
                return new e.g(value.getDoubleValue());
            case 8:
                return new e.d(value.getIntValue() != 0);
            case 9:
                return new e.o(strings.getString(value.getStringValue()));
            case 10:
                String a6 = a(strings, value.getClassId());
                return value.getArrayDimensionCount() == 0 ? new e.k(a6) : new e.b(a6, value.getArrayDimensionCount());
            case 11:
                return new e.h(a(strings, value.getClassId()), strings.getString(value.getEnumValueId()));
            case 12:
                ProtoBuf.Annotation annotation = value.getAnnotation();
                g0.o(annotation, "getAnnotation(...)");
                return new e.a(b(annotation, strings));
            case 13:
                List<ProtoBuf.Annotation.Argument.Value> arrayElementList = value.getArrayElementList();
                g0.o(arrayElementList, "getArrayElementList(...)");
                ArrayList arrayList = new ArrayList();
                for (ProtoBuf.Annotation.Argument.Value value2 : arrayElementList) {
                    g0.m(value2);
                    kotlin.reflect.jvm.internal.impl.km.e c6 = c(value2, strings);
                    if (c6 != null) {
                        arrayList.add(c6);
                    }
                }
                return new e.c(arrayList);
        }
    }
}
