package kotlinx.coroutines.internal;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.p2;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nMainDispatchers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainDispatchers.kt\nkotlinx/coroutines/internal/MainDispatcherLoader\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,134:1\n1963#2,14:135\n*S KotlinDebug\n*F\n+ 1 MainDispatchers.kt\nkotlinx/coroutines/internal/MainDispatcherLoader\n*L\n38#1:135,14\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class d0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d0 f49246a;

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f49247b = false;

    /* renamed from: c, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final p2 f49248c;

    static {
        d0 d0Var = new d0();
        f49246a = d0Var;
        v0.f("kotlinx.coroutines.fast.service.loader", true);
        f49248c = d0Var.a();
    }

    private final p2 a() {
        Object next;
        p2 f6;
        try {
            List I3 = kotlin.sequences.p.I3(kotlin.sequences.p.j(ServiceLoader.load(c0.class, c0.class.getClassLoader()).iterator()));
            Iterator it = I3.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    int a6 = ((c0) next).a();
                    do {
                        Object next2 = it.next();
                        int a7 = ((c0) next2).a();
                        if (a6 < a7) {
                            next = next2;
                            a6 = a7;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            c0 c0Var = (c0) next;
            if (c0Var != null && (f6 = e0.f(c0Var, I3)) != null) {
                return f6;
            }
            return e0.b(null, null, 3, null);
        } catch (Throwable th) {
            return e0.b(th, null, 2, null);
        }
    }

    private d0() {
    }
}
