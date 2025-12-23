package kotlin.reflect.jvm.internal.impl.metadata.serialization;

import java.util.HashMap;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nInterner.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Interner.kt\norg/jetbrains/kotlin/metadata/serialization/Interner\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,30:1\n1#2:31\n1056#3:32\n*S KotlinDebug\n*F\n+ 1 Interner.kt\norg/jetbrains/kotlin/metadata/serialization/Interner\n*L\n13#1:32\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a<T> {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final a<T> f46319a;

    /* renamed from: b, reason: collision with root package name */
    private final int f46320b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final HashMap<T, Integer> f46321c;

    private final Integer a(T t5) {
        Integer a6;
        a<T> aVar = this.f46319a;
        if (aVar != null) {
            int size = aVar.f46321c.size() + this.f46319a.f46320b;
            int i6 = this.f46320b;
        }
        a<T> aVar2 = this.f46319a;
        return (aVar2 == null || (a6 = aVar2.a(t5)) == null) ? this.f46321c.get(t5) : a6;
    }

    public final int b(T t5) {
        Integer a6 = a(t5);
        if (a6 != null) {
            return a6.intValue();
        }
        int size = this.f46320b + this.f46321c.size();
        this.f46321c.put(t5, Integer.valueOf(size));
        return size;
    }
}
