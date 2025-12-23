package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.f0;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.b;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.d;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nJvmProtoBufUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JvmProtoBufUtil.kt\norg/jetbrains/kotlin/metadata/jvm/deserialization/JvmProtoBufUtil\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,141:1\n1563#2:142\n1634#2,3:143\n1563#2:146\n1634#2,3:147\n1563#2:150\n1634#2,3:151\n1#3:154\n*S KotlinDebug\n*F\n+ 1 JvmProtoBufUtil.kt\norg/jetbrains/kotlin/metadata/jvm/deserialization/JvmProtoBufUtil\n*L\n79#1:142\n79#1:143,3\n81#1:146\n81#1:147,3\n103#1:150\n103#1:151,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f46317a = new h();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.protobuf.f f46318b;

    static {
        kotlin.reflect.jvm.internal.impl.protobuf.f d6 = kotlin.reflect.jvm.internal.impl.protobuf.f.d();
        JvmProtoBuf.a(d6);
        g0.o(d6, "apply(...)");
        f46318b = d6;
    }

    public static /* synthetic */ d.a d(h hVar, ProtoBuf.Property property, kotlin.reflect.jvm.internal.impl.metadata.deserialization.d dVar, kotlin.reflect.jvm.internal.impl.metadata.deserialization.h hVar2, boolean z5, int i6, Object obj) {
        if ((i6 & 8) != 0) {
            z5 = true;
        }
        return hVar.c(property, dVar, hVar2, z5);
    }

    @JvmStatic
    public static final boolean f(@NotNull ProtoBuf.Property proto) {
        g0.p(proto, "proto");
        b.C0902b a6 = c.f46300a.a();
        Object extension = proto.getExtension(JvmProtoBuf.f46263e);
        g0.o(extension, "getExtension(...)");
        Boolean d6 = a6.d(((Number) extension).intValue());
        g0.o(d6, "get(...)");
        return d6.booleanValue();
    }

    @JvmStatic
    @NotNull
    public static final Pair<e, ProtoBuf.Class> h(@NotNull byte[] bytes, @NotNull String[] strings) {
        g0.p(bytes, "bytes");
        g0.p(strings, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        return new Pair<>(f46317a.k(byteArrayInputStream, strings), ProtoBuf.Class.parseFrom(byteArrayInputStream, f46318b));
    }

    @JvmStatic
    @NotNull
    public static final Pair<e, ProtoBuf.Class> i(@NotNull String[] data, @NotNull String[] strings) {
        g0.p(data, "data");
        g0.p(strings, "strings");
        byte[] e6 = a.e(data);
        g0.o(e6, "decodeBytes(...)");
        return h(e6, strings);
    }

    @JvmStatic
    @NotNull
    public static final Pair<e, ProtoBuf.Function> j(@NotNull String[] data, @NotNull String[] strings) {
        g0.p(data, "data");
        g0.p(strings, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(a.e(data));
        return new Pair<>(f46317a.k(byteArrayInputStream, strings), ProtoBuf.Function.parseFrom(byteArrayInputStream, f46318b));
    }

    private final e k(InputStream inputStream, String[] strArr) {
        JvmProtoBuf.StringTableTypes parseDelimitedFrom = JvmProtoBuf.StringTableTypes.parseDelimitedFrom(inputStream, f46318b);
        g0.o(parseDelimitedFrom, "parseDelimitedFrom(...)");
        return new e(parseDelimitedFrom, strArr);
    }

    @JvmStatic
    @NotNull
    public static final Pair<e, ProtoBuf.Package> l(@NotNull byte[] bytes, @NotNull String[] strings) {
        g0.p(bytes, "bytes");
        g0.p(strings, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        return new Pair<>(f46317a.k(byteArrayInputStream, strings), ProtoBuf.Package.parseFrom(byteArrayInputStream, f46318b));
    }

    @JvmStatic
    @NotNull
    public static final Pair<e, ProtoBuf.Package> m(@NotNull String[] data, @NotNull String[] strings) {
        g0.p(data, "data");
        g0.p(strings, "strings");
        byte[] e6 = a.e(data);
        g0.o(e6, "decodeBytes(...)");
        return l(e6, strings);
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.protobuf.f a() {
        return f46318b;
    }

    @Nullable
    public final d.b b(@NotNull ProtoBuf.Constructor proto, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.d nameResolver, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.h typeTable) {
        String r32;
        g0.p(proto, "proto");
        g0.p(nameResolver, "nameResolver");
        g0.p(typeTable, "typeTable");
        GeneratedMessageLite.f<ProtoBuf.Constructor, JvmProtoBuf.JvmMethodSignature> constructorSignature = JvmProtoBuf.f46259a;
        g0.o(constructorSignature, "constructorSignature");
        JvmProtoBuf.JvmMethodSignature jvmMethodSignature = (JvmProtoBuf.JvmMethodSignature) kotlin.reflect.jvm.internal.impl.metadata.deserialization.f.a(proto, constructorSignature);
        String string = (jvmMethodSignature == null || !jvmMethodSignature.hasName()) ? "<init>" : nameResolver.getString(jvmMethodSignature.getName());
        if (jvmMethodSignature == null || !jvmMethodSignature.hasDesc()) {
            List<ProtoBuf.ValueParameter> valueParameterList = proto.getValueParameterList();
            g0.o(valueParameterList, "getValueParameterList(...)");
            List<ProtoBuf.ValueParameter> list = valueParameterList;
            ArrayList arrayList = new ArrayList(f0.d0(list, 10));
            for (ProtoBuf.ValueParameter valueParameter : list) {
                h hVar = f46317a;
                g0.m(valueParameter);
                String g6 = hVar.g(kotlin.reflect.jvm.internal.impl.metadata.deserialization.g.r(valueParameter, typeTable), nameResolver);
                if (g6 == null) {
                    return null;
                }
                arrayList.add(g6);
            }
            r32 = f0.r3(arrayList, "", "(", ")V", 0, null, null, 56, null);
        } else {
            r32 = nameResolver.getString(jvmMethodSignature.getDesc());
        }
        return new d.b(string, r32);
    }

    @Nullable
    public final d.a c(@NotNull ProtoBuf.Property proto, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.d nameResolver, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.h typeTable, boolean z5) {
        String g6;
        g0.p(proto, "proto");
        g0.p(nameResolver, "nameResolver");
        g0.p(typeTable, "typeTable");
        GeneratedMessageLite.f<ProtoBuf.Property, JvmProtoBuf.JvmPropertySignature> propertySignature = JvmProtoBuf.f46262d;
        g0.o(propertySignature, "propertySignature");
        JvmProtoBuf.JvmPropertySignature jvmPropertySignature = (JvmProtoBuf.JvmPropertySignature) kotlin.reflect.jvm.internal.impl.metadata.deserialization.f.a(proto, propertySignature);
        if (jvmPropertySignature == null) {
            return null;
        }
        JvmProtoBuf.JvmFieldSignature field = jvmPropertySignature.hasField() ? jvmPropertySignature.getField() : null;
        if (field == null && z5) {
            return null;
        }
        int name = (field == null || !field.hasName()) ? proto.getName() : field.getName();
        if (field == null || !field.hasDesc()) {
            g6 = g(kotlin.reflect.jvm.internal.impl.metadata.deserialization.g.o(proto, typeTable), nameResolver);
            if (g6 == null) {
                return null;
            }
        } else {
            g6 = nameResolver.getString(field.getDesc());
        }
        return new d.a(nameResolver.getString(name), g6);
    }

    @Nullable
    public final d.b e(@NotNull ProtoBuf.Function proto, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.d nameResolver, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.h typeTable) {
        String str;
        g0.p(proto, "proto");
        g0.p(nameResolver, "nameResolver");
        g0.p(typeTable, "typeTable");
        GeneratedMessageLite.f<ProtoBuf.Function, JvmProtoBuf.JvmMethodSignature> methodSignature = JvmProtoBuf.f46260b;
        g0.o(methodSignature, "methodSignature");
        JvmProtoBuf.JvmMethodSignature jvmMethodSignature = (JvmProtoBuf.JvmMethodSignature) kotlin.reflect.jvm.internal.impl.metadata.deserialization.f.a(proto, methodSignature);
        int name = (jvmMethodSignature == null || !jvmMethodSignature.hasName()) ? proto.getName() : jvmMethodSignature.getName();
        if (jvmMethodSignature == null || !jvmMethodSignature.hasDesc()) {
            List R = f0.R(kotlin.reflect.jvm.internal.impl.metadata.deserialization.g.l(proto, typeTable));
            List<ProtoBuf.ValueParameter> valueParameterList = proto.getValueParameterList();
            g0.o(valueParameterList, "getValueParameterList(...)");
            List<ProtoBuf.ValueParameter> list = valueParameterList;
            ArrayList arrayList = new ArrayList(f0.d0(list, 10));
            for (ProtoBuf.ValueParameter valueParameter : list) {
                g0.m(valueParameter);
                arrayList.add(kotlin.reflect.jvm.internal.impl.metadata.deserialization.g.r(valueParameter, typeTable));
            }
            List I4 = f0.I4(R, arrayList);
            ArrayList arrayList2 = new ArrayList(f0.d0(I4, 10));
            Iterator it = I4.iterator();
            while (it.hasNext()) {
                String g6 = f46317a.g((ProtoBuf.Type) it.next(), nameResolver);
                if (g6 == null) {
                    return null;
                }
                arrayList2.add(g6);
            }
            String g7 = g(kotlin.reflect.jvm.internal.impl.metadata.deserialization.g.n(proto, typeTable), nameResolver);
            if (g7 == null) {
                return null;
            }
            str = f0.r3(arrayList2, "", "(", ")", 0, null, null, 56, null) + g7;
        } else {
            str = nameResolver.getString(jvmMethodSignature.getDesc());
        }
        return new d.b(nameResolver.getString(name), str);
    }

    private h() {
    }

    private final String g(ProtoBuf.Type type, kotlin.reflect.jvm.internal.impl.metadata.deserialization.d dVar) {
        if (type.hasClassName()) {
            return b.b(dVar.a(type.getClassName()));
        }
        return null;
    }
}
