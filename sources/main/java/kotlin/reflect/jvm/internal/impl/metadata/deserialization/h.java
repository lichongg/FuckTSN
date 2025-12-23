package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.f0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nTypeTable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeTable.kt\norg/jetbrains/kotlin/metadata/deserialization/TypeTable\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,36:1\n1573#2:37\n1604#2,4:38\n*S KotlinDebug\n*F\n+ 1 TypeTable.kt\norg/jetbrains/kotlin/metadata/deserialization/TypeTable\n*L\n26#1:37\n26#1:38,4\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final List<ProtoBuf.Type> f46243a;

    public h(@NotNull ProtoBuf.TypeTable typeTable) {
        g0.p(typeTable, "typeTable");
        List<ProtoBuf.Type> typeList = typeTable.getTypeList();
        if (typeTable.hasFirstNullable()) {
            int firstNullable = typeTable.getFirstNullable();
            List<ProtoBuf.Type> typeList2 = typeTable.getTypeList();
            g0.o(typeList2, "getTypeList(...)");
            List<ProtoBuf.Type> list = typeList2;
            ArrayList arrayList = new ArrayList(f0.d0(list, 10));
            int i6 = 0;
            for (Object obj : list) {
                int i7 = i6 + 1;
                if (i6 < 0) {
                    f0.b0();
                }
                ProtoBuf.Type type = (ProtoBuf.Type) obj;
                if (i6 >= firstNullable) {
                    type = type.toBuilder().Z(true).build();
                }
                arrayList.add(type);
                i6 = i7;
            }
            typeList = arrayList;
        }
        g0.o(typeList, "run(...)");
        this.f46243a = typeList;
    }

    @NotNull
    public final ProtoBuf.Type a(int i6) {
        return this.f46243a.get(i6);
    }
}
