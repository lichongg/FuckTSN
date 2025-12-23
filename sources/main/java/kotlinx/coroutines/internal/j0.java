package kotlinx.coroutines.internal;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nOnUndeliveredElement.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OnUndeliveredElement.kt\nkotlinx/coroutines/internal/OnUndeliveredElementKt\n+ 2 Exceptions.kt\nkotlinx/coroutines/ExceptionsKt\n*L\n1#1,44:1\n75#2:45\n*S KotlinDebug\n*F\n+ 1 OnUndeliveredElement.kt\nkotlinx/coroutines/internal/OnUndeliveredElementKt\n*L\n22#1:45\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class j0 {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a extends Lambda implements Function1<Throwable, n1> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<E, n1> f49273a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ E f49274b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ kotlin.coroutines.i f49275c;

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ n1 invoke(Throwable th) {
            invoke2(th);
            return n1.f44123a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(Function1<? super E, n1> function1, E e6, kotlin.coroutines.i iVar) {
            super(1);
            this.f49273a = function1;
            this.f49274b = e6;
            this.f49275c = iVar;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Throwable th) {
            j0.b(this.f49273a, this.f49274b, this.f49275c);
        }
    }

    public static final <E> void b(@NotNull Function1<? super E, n1> function1, E e6, @NotNull kotlin.coroutines.i iVar) {
        UndeliveredElementException c6 = c(function1, e6, null);
        if (c6 != null) {
            kotlinx.coroutines.o0.b(iVar, c6);
        }
    }

    @NotNull
    public static final <E> Function1<Throwable, n1> a(@NotNull Function1<? super E, n1> function1, E e6, @NotNull kotlin.coroutines.i iVar) {
        return new a(function1, e6, iVar);
    }

    public static /* synthetic */ UndeliveredElementException d(Function1 function1, Object obj, UndeliveredElementException undeliveredElementException, int i6, Object obj2) {
        if ((i6 & 2) != 0) {
            undeliveredElementException = null;
        }
        return c(function1, obj, undeliveredElementException);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static final <E> UndeliveredElementException c(@NotNull Function1<? super E, n1> function1, E e6, @Nullable UndeliveredElementException undeliveredElementException) {
        try {
            function1.invoke(e6);
            return undeliveredElementException;
        } catch (Throwable th) {
            if (undeliveredElementException != null && undeliveredElementException.getCause() != th) {
                kotlin.l.a(undeliveredElementException, th);
                return undeliveredElementException;
            }
            return new UndeliveredElementException("Exception in undelivered element handler for " + e6, th);
        }
    }
}
