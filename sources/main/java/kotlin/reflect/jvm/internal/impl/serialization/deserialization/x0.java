package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.o1;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nValueClassUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ValueClassUtil.kt\norg/jetbrains/kotlin/serialization/deserialization/ValueClassUtilKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,55:1\n1563#2:56\n1634#2,3:57\n1563#2:60\n1634#2,3:61\n1563#2:64\n1634#2,3:65\n*S KotlinDebug\n*F\n+ 1 ValueClassUtil.kt\norg/jetbrains/kotlin/serialization/deserialization/ValueClassUtilKt\n*L\n26#1:56\n26#1:57,3\n44#1:60\n44#1:61,3\n48#1:64\n48#1:65,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class x0 {
    @NotNull
    public static final Pair<List<kotlin.reflect.jvm.internal.impl.name.f>, List<ProtoBuf.Type>> a(@NotNull ProtoBuf.Class r5, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.d nameResolver, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.h typeTable) {
        List<ProtoBuf.Type> multiFieldValueClassUnderlyingTypeList;
        kotlin.jvm.internal.g0.p(r5, "<this>");
        kotlin.jvm.internal.g0.p(nameResolver, "nameResolver");
        kotlin.jvm.internal.g0.p(typeTable, "typeTable");
        List<Integer> multiFieldValueClassUnderlyingNameList = r5.getMultiFieldValueClassUnderlyingNameList();
        kotlin.jvm.internal.g0.o(multiFieldValueClassUnderlyingNameList, "getMultiFieldValueClassUnderlyingNameList(...)");
        List<Integer> list = multiFieldValueClassUnderlyingNameList;
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(list, 10));
        for (Integer num : list) {
            kotlin.jvm.internal.g0.m(num);
            arrayList.add(k0.b(nameResolver, num.intValue()));
        }
        Pair a6 = kotlin.o0.a(Integer.valueOf(r5.getMultiFieldValueClassUnderlyingTypeIdCount()), Integer.valueOf(r5.getMultiFieldValueClassUnderlyingTypeCount()));
        if (kotlin.jvm.internal.g0.g(a6, kotlin.o0.a(Integer.valueOf(arrayList.size()), 0))) {
            List<Integer> multiFieldValueClassUnderlyingTypeIdList = r5.getMultiFieldValueClassUnderlyingTypeIdList();
            kotlin.jvm.internal.g0.o(multiFieldValueClassUnderlyingTypeIdList, "getMultiFieldValueClassUnderlyingTypeIdList(...)");
            List<Integer> list2 = multiFieldValueClassUnderlyingTypeIdList;
            multiFieldValueClassUnderlyingTypeList = new ArrayList<>(kotlin.collections.f0.d0(list2, 10));
            for (Integer num2 : list2) {
                kotlin.jvm.internal.g0.m(num2);
                multiFieldValueClassUnderlyingTypeList.add(typeTable.a(num2.intValue()));
            }
        } else {
            if (!kotlin.jvm.internal.g0.g(a6, kotlin.o0.a(0, Integer.valueOf(arrayList.size())))) {
                throw new IllegalStateException(("class " + k0.b(nameResolver, r5.getFqName()) + " has illegal multi-field value class representation").toString());
            }
            multiFieldValueClassUnderlyingTypeList = r5.getMultiFieldValueClassUnderlyingTypeList();
        }
        return kotlin.o0.a(arrayList, multiFieldValueClassUnderlyingTypeList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static final <T extends e4.h> o1<T> b(@NotNull ProtoBuf.Class r12, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.d nameResolver, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.h typeTable, @NotNull Function1<? super ProtoBuf.Type, ? extends T> typeDeserializer, @NotNull Function1<? super kotlin.reflect.jvm.internal.impl.name.f, ? extends T> typeOfPublicProperty) {
        T invoke;
        kotlin.jvm.internal.g0.p(r12, "<this>");
        kotlin.jvm.internal.g0.p(nameResolver, "nameResolver");
        kotlin.jvm.internal.g0.p(typeTable, "typeTable");
        kotlin.jvm.internal.g0.p(typeDeserializer, "typeDeserializer");
        kotlin.jvm.internal.g0.p(typeOfPublicProperty, "typeOfPublicProperty");
        if (r12.getMultiFieldValueClassUnderlyingNameCount() > 0) {
            Pair<List<kotlin.reflect.jvm.internal.impl.name.f>, List<ProtoBuf.Type>> a6 = a(r12, nameResolver, typeTable);
            List<kotlin.reflect.jvm.internal.impl.name.f> component1 = a6.component1();
            List<ProtoBuf.Type> component2 = a6.component2();
            ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(component2, 10));
            Iterator<T> it = component2.iterator();
            while (it.hasNext()) {
                arrayList.add(typeDeserializer.invoke(it.next()));
            }
            return new kotlin.reflect.jvm.internal.impl.descriptors.g0(kotlin.collections.f0.o6(component1, arrayList));
        }
        if (!r12.hasInlineClassUnderlyingPropertyName()) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.name.f b6 = k0.b(nameResolver, r12.getInlineClassUnderlyingPropertyName());
        ProtoBuf.Type i6 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.g.i(r12, typeTable);
        if ((i6 != null && (invoke = typeDeserializer.invoke(i6)) != null) || (invoke = typeOfPublicProperty.invoke(b6)) != null) {
            return new kotlin.reflect.jvm.internal.impl.descriptors.z(b6, invoke);
        }
        throw new IllegalStateException(("cannot determine underlying type for value class " + k0.b(nameResolver, r12.getFqName()) + " with property " + b6).toString());
    }
}
