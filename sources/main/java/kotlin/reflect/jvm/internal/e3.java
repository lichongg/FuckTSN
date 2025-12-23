package kotlin.reflect.jvm.internal;

import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nmoduleByClassLoader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 moduleByClassLoader.kt\nkotlin/reflect/jvm/internal/ModuleByClassLoaderKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,75:1\n1#2:76\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class e3 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final ConcurrentMap<q3, WeakReference<kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.k>> f44342a = new ConcurrentHashMap();

    public static final void a() {
        f44342a.clear();
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.k b(@NotNull Class<?> cls) {
        kotlin.jvm.internal.g0.p(cls, "<this>");
        ClassLoader j6 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.f.j(cls);
        q3 q3Var = new q3(j6);
        ConcurrentMap<q3, WeakReference<kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.k>> concurrentMap = f44342a;
        WeakReference<kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.k> weakReference = concurrentMap.get(q3Var);
        if (weakReference != null) {
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.k kVar = weakReference.get();
            if (kVar != null) {
                return kVar;
            }
            concurrentMap.remove(q3Var, weakReference);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.k a6 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.k.f44974c.a(j6);
        while (true) {
            try {
                ConcurrentMap<q3, WeakReference<kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.k>> concurrentMap2 = f44342a;
                WeakReference<kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.k> putIfAbsent = concurrentMap2.putIfAbsent(q3Var, new WeakReference<>(a6));
                if (putIfAbsent == null) {
                    return a6;
                }
                kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.k kVar2 = putIfAbsent.get();
                if (kVar2 != null) {
                    return kVar2;
                }
                concurrentMap2.remove(q3Var, putIfAbsent);
            } finally {
                q3Var.a(null);
            }
        }
    }
}
