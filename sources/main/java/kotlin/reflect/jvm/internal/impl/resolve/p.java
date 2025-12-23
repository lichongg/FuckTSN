package kotlin.reflect.jvm.internal.impl.resolve;

import defpackage.H5BaseWebChromeClient;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.collections.f0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\noverridingUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 overridingUtils.kt\norg/jetbrains/kotlin/resolve/OverridingUtilsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,84:1\n1634#2,3:85\n855#2,2:88\n*S KotlinDebug\n*F\n+ 1 overridingUtils.kt\norg/jetbrains/kotlin/resolve/OverridingUtilsKt\n*L\n40#1:85,3\n72#1:88,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class p {
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <H> Collection<H> b(@NotNull Collection<? extends H> collection, @NotNull Function1<? super H, ? extends kotlin.reflect.jvm.internal.impl.descriptors.a> descriptorByHandle) {
        g0.p(collection, "<this>");
        g0.p(descriptorByHandle, "descriptorByHandle");
        if (collection.size() <= 1) {
            return collection;
        }
        LinkedList linkedList = new LinkedList(collection);
        kotlin.reflect.jvm.internal.impl.utils.k a6 = kotlin.reflect.jvm.internal.impl.utils.k.f47493c.a();
        while (!linkedList.isEmpty()) {
            Object G2 = f0.G2(linkedList);
            kotlin.reflect.jvm.internal.impl.utils.k a7 = kotlin.reflect.jvm.internal.impl.utils.k.f47493c.a();
            Collection<H5BaseWebChromeClient> p5 = OverridingUtil.p(G2, linkedList, descriptorByHandle, new o(a7));
            g0.o(p5, "extractMembersOverridableInBothWays(...)");
            if (p5.size() == 1 && a7.isEmpty()) {
                Object k52 = f0.k5(p5);
                g0.o(k52, "single(...)");
                a6.add(k52);
            } else {
                H5BaseWebChromeClient h5BaseWebChromeClient = (Object) OverridingUtil.L(p5, descriptorByHandle);
                kotlin.reflect.jvm.internal.impl.descriptors.a invoke = descriptorByHandle.invoke(h5BaseWebChromeClient);
                for (H5BaseWebChromeClient h5BaseWebChromeClient2 : p5) {
                    g0.m(h5BaseWebChromeClient2);
                    if (!OverridingUtil.B(invoke, descriptorByHandle.invoke(h5BaseWebChromeClient2))) {
                        a7.add(h5BaseWebChromeClient2);
                    }
                }
                if (!a7.isEmpty()) {
                    a6.addAll(a7);
                }
                a6.add(h5BaseWebChromeClient);
            }
        }
        return a6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 c(kotlin.reflect.jvm.internal.impl.utils.k kVar, Object obj) {
        g0.m(obj);
        kVar.add(obj);
        return n1.f44123a;
    }
}
