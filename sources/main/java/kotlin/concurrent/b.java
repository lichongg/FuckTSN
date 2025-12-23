package kotlin.concurrent;

import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "ThreadsKt")
@SourceDebugExtension({"SMAP\nThread.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Thread.kt\nkotlin/concurrent/ThreadsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,61:1\n1#2:62\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class b {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a extends Thread {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0<n1> f43757a;

        a(Function0<n1> function0) {
            this.f43757a = function0;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            this.f43757a.invoke();
        }
    }

    @InlineOnly
    private static final <T> T a(ThreadLocal<T> threadLocal, Function0<? extends T> function0) {
        g0.p(threadLocal, "<this>");
        g0.p(function0, "default");
        T t5 = threadLocal.get();
        if (t5 != null) {
            return t5;
        }
        T invoke = function0.invoke();
        threadLocal.set(invoke);
        return invoke;
    }

    @NotNull
    public static final Thread b(boolean z5, boolean z6, @Nullable ClassLoader classLoader, @Nullable String str, int i6, @NotNull Function0<n1> block) {
        g0.p(block, "block");
        a aVar = new a(block);
        if (z6) {
            aVar.setDaemon(true);
        }
        if (i6 > 0) {
            aVar.setPriority(i6);
        }
        if (str != null) {
            aVar.setName(str);
        }
        if (classLoader != null) {
            aVar.setContextClassLoader(classLoader);
        }
        if (z5) {
            aVar.start();
        }
        return aVar;
    }

    public static /* synthetic */ Thread c(boolean z5, boolean z6, ClassLoader classLoader, String str, int i6, Function0 function0, int i7, Object obj) {
        Function0 function02;
        int i8;
        if ((i7 & 1) != 0) {
            z5 = true;
        }
        if ((i7 & 2) != 0) {
            z6 = false;
        }
        if ((i7 & 4) != 0) {
            classLoader = null;
        }
        if ((i7 & 8) != 0) {
            str = null;
        }
        if ((i7 & 16) != 0) {
            function02 = function0;
            i8 = -1;
        } else {
            function02 = function0;
            i8 = i6;
        }
        String str2 = str;
        return b(z5, z6, classLoader, str2, i8, function02);
    }
}
