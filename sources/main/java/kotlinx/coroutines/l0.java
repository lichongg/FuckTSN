package kotlinx.coroutines;

import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.i;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class l0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final String f49345a = " @";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a extends Lambda implements Function2<kotlin.coroutines.i, i.b, kotlin.coroutines.i> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f49346a = new a();

        a() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final kotlin.coroutines.i invoke(@NotNull kotlin.coroutines.i iVar, @NotNull i.b bVar) {
            return bVar instanceof j0 ? iVar.plus(((j0) bVar).l()) : iVar.plus(bVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b extends Lambda implements Function2<kotlin.coroutines.i, i.b, kotlin.coroutines.i> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<kotlin.coroutines.i> f49347a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f49348b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Ref.ObjectRef<kotlin.coroutines.i> objectRef, boolean z5) {
            super(2);
            this.f49347a = objectRef;
            this.f49348b = z5;
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [T, kotlin.coroutines.i] */
        @Override // kotlin.jvm.functions.Function2
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final kotlin.coroutines.i invoke(@NotNull kotlin.coroutines.i iVar, @NotNull i.b bVar) {
            if (!(bVar instanceof j0)) {
                return iVar.plus(bVar);
            }
            i.b bVar2 = this.f49347a.element.get(bVar.getKey());
            if (bVar2 != null) {
                Ref.ObjectRef<kotlin.coroutines.i> objectRef = this.f49347a;
                objectRef.element = objectRef.element.minusKey(bVar.getKey());
                return iVar.plus(((j0) bVar).e(bVar2));
            }
            j0 j0Var = (j0) bVar;
            if (this.f49348b) {
                j0Var = j0Var.l();
            }
            return iVar.plus(j0Var);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class c extends Lambda implements Function2<Boolean, i.b, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public static final c f49349a = new c();

        c() {
            super(2);
        }

        @NotNull
        public final Boolean a(boolean z5, @NotNull i.b bVar) {
            return Boolean.valueOf(z5 || (bVar instanceof j0));
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool, i.b bVar) {
            return a(bool.booleanValue(), bVar);
        }
    }

    @Nullable
    public static final String b(@NotNull kotlin.coroutines.i iVar) {
        return null;
    }

    private static final boolean c(kotlin.coroutines.i iVar) {
        return ((Boolean) iVar.fold(Boolean.FALSE, c.f49349a)).booleanValue();
    }

    @Nullable
    public static final p3<?> f(@NotNull kotlin.coroutines.jvm.internal.c cVar) {
        while (!(cVar instanceof c1) && (cVar = cVar.getCallerFrame()) != null) {
            if (cVar instanceof p3) {
                return (p3) cVar;
            }
        }
        return null;
    }

    @Nullable
    public static final p3<?> g(@NotNull kotlin.coroutines.e<?> eVar, @NotNull kotlin.coroutines.i iVar, @Nullable Object obj) {
        if (!(eVar instanceof kotlin.coroutines.jvm.internal.c) || iVar.get(q3.f49427a) == null) {
            return null;
        }
        p3<?> f6 = f((kotlin.coroutines.jvm.internal.c) eVar);
        if (f6 != null) {
            f6.B1(iVar, obj);
        }
        return f6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.Object] */
    private static final kotlin.coroutines.i a(kotlin.coroutines.i iVar, kotlin.coroutines.i iVar2, boolean z5) {
        boolean c6 = c(iVar);
        boolean c7 = c(iVar2);
        if (!c6 && !c7) {
            return iVar.plus(iVar2);
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = iVar2;
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        kotlin.coroutines.i iVar3 = (kotlin.coroutines.i) iVar.fold(emptyCoroutineContext, new b(objectRef, z5));
        if (c7) {
            objectRef.element = ((kotlin.coroutines.i) objectRef.element).fold(emptyCoroutineContext, a.f49346a);
        }
        return iVar3.plus((kotlin.coroutines.i) objectRef.element);
    }

    @InternalCoroutinesApi
    @NotNull
    public static final kotlin.coroutines.i d(@NotNull kotlin.coroutines.i iVar, @NotNull kotlin.coroutines.i iVar2) {
        if (!c(iVar2)) {
            return iVar.plus(iVar2);
        }
        return a(iVar, iVar2, false);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final kotlin.coroutines.i e(@NotNull r0 r0Var, @NotNull kotlin.coroutines.i iVar) {
        kotlin.coroutines.i a6 = a(r0Var.getCoroutineContext(), iVar, true);
        if (a6 != g1.a() && a6.get(kotlin.coroutines.f.f43765o0) == null) {
            return a6.plus(g1.a());
        }
        return a6;
    }

    public static final <T> T h(@NotNull kotlin.coroutines.e<?> eVar, @Nullable Object obj, @NotNull Function0<? extends T> function0) {
        p3<?> p3Var;
        kotlin.coroutines.i context = eVar.getContext();
        Object c6 = kotlinx.coroutines.internal.y0.c(context, obj);
        if (c6 != kotlinx.coroutines.internal.y0.f49325a) {
            p3Var = g(eVar, context, c6);
        } else {
            p3Var = null;
        }
        try {
            return function0.invoke();
        } finally {
            kotlin.jvm.internal.d0.d(1);
            if (p3Var == null || p3Var.A1()) {
                kotlinx.coroutines.internal.y0.a(context, c6);
            }
            kotlin.jvm.internal.d0.c(1);
        }
    }

    public static final <T> T i(@NotNull kotlin.coroutines.i iVar, @Nullable Object obj, @NotNull Function0<? extends T> function0) {
        Object c6 = kotlinx.coroutines.internal.y0.c(iVar, obj);
        try {
            return function0.invoke();
        } finally {
            kotlin.jvm.internal.d0.d(1);
            kotlinx.coroutines.internal.y0.a(iVar, c6);
            kotlin.jvm.internal.d0.c(1);
        }
    }
}
