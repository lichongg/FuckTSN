package d4;

import java.util.List;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.types.s1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nTypeAttributeTranslators.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeAttributeTranslators.kt\norg/jetbrains/kotlin/types/extensions/TypeAttributeTranslators\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,31:1\n1563#2:32\n1634#2,3:33\n1563#2:36\n1634#2,3:37\n*S KotlinDebug\n*F\n+ 1 TypeAttributeTranslators.kt\norg/jetbrains/kotlin/types/extensions/TypeAttributeTranslators\n*L\n18#1:32\n18#1:33,3\n25#1:36\n25#1:37,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final List<s1> f42989a;

    /* JADX WARN: Multi-variable type inference failed */
    public a(@NotNull List<? extends s1> translators) {
        g0.p(translators, "translators");
        this.f42989a = translators;
    }

    @NotNull
    public final List<s1> a() {
        return this.f42989a;
    }
}
