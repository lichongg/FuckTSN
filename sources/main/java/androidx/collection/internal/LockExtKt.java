package androidx.collection.internal;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nLockExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LockExt.kt\nandroidx/collection/internal/LockExtKt\n+ 2 Lock.jvm.kt\nandroidx/collection/internal/Lock\n*L\n1#1,27:1\n26#2:28\n*S KotlinDebug\n*F\n+ 1 LockExt.kt\nandroidx/collection/internal/LockExtKt\n*L\n25#1:28\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class LockExtKt {
    /* renamed from: synchronized, reason: not valid java name */
    public static final <T> T m27synchronized(@NotNull Lock lock, @NotNull Function0<? extends T> block) {
        T invoke;
        g0.p(lock, "<this>");
        g0.p(block, "block");
        synchronized (lock) {
            try {
                invoke = block.invoke();
                d0.d(1);
            } catch (Throwable th) {
                d0.d(1);
                d0.c(1);
                throw th;
            }
        }
        d0.c(1);
        return invoke;
    }
}
