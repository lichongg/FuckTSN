package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.f0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nMemberScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MemberScope.kt\norg/jetbrains/kotlin/resolve/scopes/MemberScopeKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 addToStdlib.kt\norg/jetbrains/kotlin/utils/addToStdlib/AddToStdlibKt\n*L\n1#1,261:1\n230#2,2:262\n295#2,2:264\n774#2:271\n865#2,2:272\n211#3,5:266\n*S KotlinDebug\n*F\n+ 1 MemberScope.kt\norg/jetbrains/kotlin/resolve/scopes/MemberScopeKt\n*L\n71#1:262,2\n74#1:264,2\n87#1:271\n87#1:272,2\n77#1:266,5\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class m {
    @Nullable
    public static final Set<kotlin.reflect.jvm.internal.impl.name.f> a(@NotNull Iterable<? extends k> iterable) {
        g0.p(iterable, "<this>");
        HashSet hashSet = new HashSet();
        Iterator<? extends k> it = iterable.iterator();
        while (it.hasNext()) {
            Set<kotlin.reflect.jvm.internal.impl.name.f> f6 = it.next().f();
            if (f6 == null) {
                return null;
            }
            f0.s0(hashSet, f6);
        }
        return hashSet;
    }
}
