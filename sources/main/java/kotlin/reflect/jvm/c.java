package kotlin.reflect.jvm;

import java.util.Iterator;
import java.util.List;
import kotlin.SinceKotlin;
import kotlin.collections.f0;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.o0;
import kotlin.reflect.g;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.z2;
import kotlin.reflect.r;
import kotlin.reflect.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "KTypesJvm")
@SourceDebugExtension({"SMAP\nKTypesJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KTypesJvm.kt\nkotlin/reflect/jvm/KTypesJvm\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,52:1\n295#2,2:53\n*S KotlinDebug\n*F\n+ 1 KTypesJvm.kt\nkotlin/reflect/jvm/KTypesJvm\n*L\n44#1:53,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class c {
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final kotlin.reflect.d<?> a(@NotNull g gVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.d dVar;
        kotlin.reflect.d<?> b6;
        g0.p(gVar, "<this>");
        if (gVar instanceof kotlin.reflect.d) {
            return (kotlin.reflect.d) gVar;
        }
        if (!(gVar instanceof s)) {
            throw new KotlinReflectionInternalError("Cannot calculate JVM erasure for type: " + gVar);
        }
        List<r> upperBounds = ((s) gVar).getUpperBounds();
        Iterator<T> it = upperBounds.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            r rVar = (r) next;
            g0.n(rVar, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
            f c6 = ((z2) rVar).getType().I0().c();
            dVar = c6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d ? (kotlin.reflect.jvm.internal.impl.descriptors.d) c6 : null;
            if (dVar != null && dVar.h() != ClassKind.INTERFACE && dVar.h() != ClassKind.ANNOTATION_CLASS) {
                dVar = next;
                break;
            }
        }
        r rVar2 = (r) dVar;
        if (rVar2 == null) {
            rVar2 = (r) f0.L2(upperBounds);
        }
        return (rVar2 == null || (b6 = b(rVar2)) == null) ? o0.d(Object.class) : b6;
    }

    @NotNull
    public static final kotlin.reflect.d<?> b(@NotNull r rVar) {
        kotlin.reflect.d<?> a6;
        g0.p(rVar, "<this>");
        g n6 = rVar.n();
        if (n6 != null && (a6 = a(n6)) != null) {
            return a6;
        }
        throw new KotlinReflectionInternalError("Cannot calculate JVM erasure for type: " + rVar);
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void c(r rVar) {
    }
}
