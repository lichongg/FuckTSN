package retrofit2;

import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.Method;
import kotlin.KotlinNullPointerException;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "KotlinExtensions")
/* loaded from: D:\Downloads\app\classes7.dex */
public final class m {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a extends Lambda implements Function1<Throwable, n1> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ retrofit2.b f52153a;

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ n1 invoke(Throwable th) {
            invoke2(th);
            return n1.f44123a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(retrofit2.b bVar) {
            super(1);
            this.f52153a = bVar;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@Nullable Throwable th) {
            this.f52153a.cancel();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b extends Lambda implements Function1<Throwable, n1> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ retrofit2.b f52154a;

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ n1 invoke(Throwable th) {
            invoke2(th);
            return n1.f44123a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(retrofit2.b bVar) {
            super(1);
            this.f52154a = bVar;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@Nullable Throwable th) {
            this.f52154a.cancel();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class c<T> implements retrofit2.d<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.p f52155a;

        c(kotlinx.coroutines.p pVar) {
            this.f52155a = pVar;
        }

        @Override // retrofit2.d
        public void a(@NotNull retrofit2.b<T> call, @NotNull Throwable t5) {
            kotlin.jvm.internal.g0.q(call, "call");
            kotlin.jvm.internal.g0.q(t5, "t");
            kotlinx.coroutines.p pVar = this.f52155a;
            Result.a aVar = Result.Companion;
            pVar.resumeWith(Result.m130constructorimpl(kotlin.g0.a(t5)));
        }

        @Override // retrofit2.d
        public void b(@NotNull retrofit2.b<T> call, @NotNull c0<T> response) {
            kotlin.jvm.internal.g0.q(call, "call");
            kotlin.jvm.internal.g0.q(response, "response");
            if (!response.g()) {
                kotlinx.coroutines.p pVar = this.f52155a;
                HttpException httpException = new HttpException(response);
                Result.a aVar = Result.Companion;
                pVar.resumeWith(Result.m130constructorimpl(kotlin.g0.a(httpException)));
                return;
            }
            T a6 = response.a();
            if (a6 != null) {
                kotlinx.coroutines.p pVar2 = this.f52155a;
                Result.a aVar2 = Result.Companion;
                pVar2.resumeWith(Result.m130constructorimpl(a6));
                return;
            }
            Object tag = call.request().tag(l.class);
            if (tag == null) {
                kotlin.jvm.internal.g0.L();
            }
            kotlin.jvm.internal.g0.h(tag, "call.request().tag(Invocation::class.java)!!");
            Method method = ((l) tag).b();
            StringBuilder sb = new StringBuilder();
            sb.append("Response from ");
            kotlin.jvm.internal.g0.h(method, "method");
            Class<?> declaringClass = method.getDeclaringClass();
            kotlin.jvm.internal.g0.h(declaringClass, "method.declaringClass");
            sb.append(declaringClass.getName());
            sb.append('.');
            sb.append(method.getName());
            sb.append(" was null but response body type was declared as non-null");
            KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException(sb.toString());
            kotlinx.coroutines.p pVar3 = this.f52155a;
            Result.a aVar3 = Result.Companion;
            pVar3.resumeWith(Result.m130constructorimpl(kotlin.g0.a(kotlinNullPointerException)));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class d<T> implements retrofit2.d<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.p f52156a;

        d(kotlinx.coroutines.p pVar) {
            this.f52156a = pVar;
        }

        @Override // retrofit2.d
        public void a(@NotNull retrofit2.b<T> call, @NotNull Throwable t5) {
            kotlin.jvm.internal.g0.q(call, "call");
            kotlin.jvm.internal.g0.q(t5, "t");
            kotlinx.coroutines.p pVar = this.f52156a;
            Result.a aVar = Result.Companion;
            pVar.resumeWith(Result.m130constructorimpl(kotlin.g0.a(t5)));
        }

        @Override // retrofit2.d
        public void b(@NotNull retrofit2.b<T> call, @NotNull c0<T> response) {
            kotlin.jvm.internal.g0.q(call, "call");
            kotlin.jvm.internal.g0.q(response, "response");
            if (response.g()) {
                kotlinx.coroutines.p pVar = this.f52156a;
                T a6 = response.a();
                Result.a aVar = Result.Companion;
                pVar.resumeWith(Result.m130constructorimpl(a6));
                return;
            }
            kotlinx.coroutines.p pVar2 = this.f52156a;
            HttpException httpException = new HttpException(response);
            Result.a aVar2 = Result.Companion;
            pVar2.resumeWith(Result.m130constructorimpl(kotlin.g0.a(httpException)));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class e extends Lambda implements Function1<Throwable, n1> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ retrofit2.b f52157a;

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ n1 invoke(Throwable th) {
            invoke2(th);
            return n1.f44123a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(retrofit2.b bVar) {
            super(1);
            this.f52157a = bVar;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@Nullable Throwable th) {
            this.f52157a.cancel();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class f<T> implements retrofit2.d<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.p f52158a;

        f(kotlinx.coroutines.p pVar) {
            this.f52158a = pVar;
        }

        @Override // retrofit2.d
        public void a(@NotNull retrofit2.b<T> call, @NotNull Throwable t5) {
            kotlin.jvm.internal.g0.q(call, "call");
            kotlin.jvm.internal.g0.q(t5, "t");
            kotlinx.coroutines.p pVar = this.f52158a;
            Result.a aVar = Result.Companion;
            pVar.resumeWith(Result.m130constructorimpl(kotlin.g0.a(t5)));
        }

        @Override // retrofit2.d
        public void b(@NotNull retrofit2.b<T> call, @NotNull c0<T> response) {
            kotlin.jvm.internal.g0.q(call, "call");
            kotlin.jvm.internal.g0.q(response, "response");
            kotlinx.coroutines.p pVar = this.f52158a;
            Result.a aVar = Result.Companion;
            pVar.resumeWith(Result.m130constructorimpl(response));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlin.coroutines.e f52159a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Exception f52160b;

        g(kotlin.coroutines.e eVar, Exception exc) {
            this.f52159a = eVar;
            this.f52160b = exc;
        }

        @Override // java.lang.Runnable
        public final void run() {
            kotlin.coroutines.e e6 = kotlin.coroutines.intrinsics.a.e(this.f52159a);
            Exception exc = this.f52160b;
            Result.a aVar = Result.Companion;
            e6.resumeWith(Result.m130constructorimpl(kotlin.g0.a(exc)));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "retrofit2.KotlinExtensions", f = "KotlinExtensions.kt", i = {0}, l = {113}, m = "suspendAndThrow", n = {"$this$suspendAndThrow"}, s = {"L$0"})
    static final class h extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f52161a;

        /* renamed from: b, reason: collision with root package name */
        int f52162b;

        /* renamed from: c, reason: collision with root package name */
        Object f52163c;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f52161a = obj;
            this.f52162b |= Integer.MIN_VALUE;
            return m.e(null, this);
        }

        h(kotlin.coroutines.e eVar) {
            super(eVar);
        }
    }

    @Nullable
    public static final <T> Object a(@NotNull retrofit2.b<T> bVar, @NotNull kotlin.coroutines.e<? super T> eVar) {
        kotlinx.coroutines.q qVar = new kotlinx.coroutines.q(kotlin.coroutines.intrinsics.a.e(eVar), 1);
        qVar.I(new a(bVar));
        bVar.j(new c(qVar));
        Object x5 = qVar.x();
        if (x5 == kotlin.coroutines.intrinsics.a.l()) {
            kotlin.coroutines.jvm.internal.e.c(eVar);
        }
        return x5;
    }

    @JvmName(name = "awaitNullable")
    @Nullable
    public static final <T> Object b(@NotNull retrofit2.b<T> bVar, @NotNull kotlin.coroutines.e<? super T> eVar) {
        kotlinx.coroutines.q qVar = new kotlinx.coroutines.q(kotlin.coroutines.intrinsics.a.e(eVar), 1);
        qVar.I(new b(bVar));
        bVar.j(new d(qVar));
        Object x5 = qVar.x();
        if (x5 == kotlin.coroutines.intrinsics.a.l()) {
            kotlin.coroutines.jvm.internal.e.c(eVar);
        }
        return x5;
    }

    @Nullable
    public static final <T> Object c(@NotNull retrofit2.b<T> bVar, @NotNull kotlin.coroutines.e<? super c0<T>> eVar) {
        kotlinx.coroutines.q qVar = new kotlinx.coroutines.q(kotlin.coroutines.intrinsics.a.e(eVar), 1);
        qVar.I(new e(bVar));
        bVar.j(new f(qVar));
        Object x5 = qVar.x();
        if (x5 == kotlin.coroutines.intrinsics.a.l()) {
            kotlin.coroutines.jvm.internal.e.c(eVar);
        }
        return x5;
    }

    public static final /* synthetic */ <T> T d(@NotNull d0 create) {
        kotlin.jvm.internal.g0.q(create, "$this$create");
        kotlin.jvm.internal.g0.y(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) create.g(Object.class);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object e(@org.jetbrains.annotations.NotNull java.lang.Exception r4, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<?> r5) {
        /*
            boolean r0 = r5 instanceof retrofit2.m.h
            if (r0 == 0) goto L13
            r0 = r5
            retrofit2.m$h r0 = (retrofit2.m.h) r0
            int r1 = r0.f52162b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f52162b = r1
            goto L18
        L13:
            retrofit2.m$h r0 = new retrofit2.m$h
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f52161a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f52162b
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.f52163c
            java.lang.Exception r4 = (java.lang.Exception) r4
            kotlin.g0.n(r5)
            goto L5c
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.g0.n(r5)
            r0.f52163c = r4
            r0.f52162b = r3
            kotlinx.coroutines.m0 r5 = kotlinx.coroutines.g1.a()
            kotlin.coroutines.i r2 = r0.getContext()
            retrofit2.m$g r3 = new retrofit2.m$g
            r3.<init>(r0, r4)
            r5.dispatch(r2, r3)
            java.lang.Object r4 = kotlin.coroutines.intrinsics.a.l()
            java.lang.Object r5 = kotlin.coroutines.intrinsics.a.l()
            if (r4 != r5) goto L59
            kotlin.coroutines.jvm.internal.e.c(r0)
        L59:
            if (r4 != r1) goto L5c
            return r1
        L5c:
            kotlin.n1 r4 = kotlin.n1.f44123a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: retrofit2.m.e(java.lang.Exception, kotlin.coroutines.e):java.lang.Object");
    }
}
