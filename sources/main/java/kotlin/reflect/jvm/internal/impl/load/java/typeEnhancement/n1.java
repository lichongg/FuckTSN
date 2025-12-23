package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\npredefinedEnhancementInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 predefinedEnhancementInfo.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/TypeEnhancementInfo\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,347:1\n463#2:348\n413#2:349\n1252#3,4:350\n*S KotlinDebug\n*F\n+ 1 predefinedEnhancementInfo.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/TypeEnhancementInfo\n*L\n28#1:348\n28#1:349\n28#1:350,4\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class n1 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final Map<Integer, h> f45818a;

    public n1(@NotNull Map<Integer, h> map) {
        kotlin.jvm.internal.g0.p(map, "map");
        this.f45818a = map;
    }

    @NotNull
    public final n1 a() {
        Map<Integer, h> map = this.f45818a;
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.collections.i1.j(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), h.c((h) entry.getValue(), null, null, false, true, 7, null));
        }
        return new n1(linkedHashMap);
    }

    @NotNull
    public final Map<Integer, h> b() {
        return this.f45818a;
    }
}
