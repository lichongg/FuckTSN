package kotlin.reflect.full;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.SinceKotlin;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.reflect.KParameter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "KCallables")
@SourceDebugExtension({"SMAP\nKCallables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KCallables.kt\nkotlin/reflect/full/KCallables\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,82:1\n669#2,11:83\n669#2,11:94\n774#2:105\n865#2,2:106\n669#2,11:108\n1#3:119\n*S KotlinDebug\n*F\n+ 1 KCallables.kt\nkotlin/reflect/full/KCallables\n*L\n23#1:83,11\n31#1:94,11\n38#1:105\n38#1:106,2\n45#1:108,11\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class c {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<R> extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f44218a;

        /* renamed from: b, reason: collision with root package name */
        Object f44219b;

        /* renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f44220c;

        /* renamed from: d, reason: collision with root package name */
        int f44221d;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f44220c = obj;
            this.f44221d |= Integer.MIN_VALUE;
            return c.a(null, null, this);
        }

        a(kotlin.coroutines.e<? super a> eVar) {
            super(eVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b<R> extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f44222a;

        /* renamed from: b, reason: collision with root package name */
        Object f44223b;

        /* renamed from: c, reason: collision with root package name */
        Object f44224c;

        /* renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f44225d;

        /* renamed from: e, reason: collision with root package name */
        int f44226e;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f44225d = obj;
            this.f44226e |= Integer.MIN_VALUE;
            return c.b(null, null, this);
        }

        b(kotlin.coroutines.e<? super b> eVar) {
            super(eVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @kotlin.SinceKotlin(version = "1.3")
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <R> java.lang.Object a(@org.jetbrains.annotations.NotNull kotlin.reflect.c<? extends R> r4, @org.jetbrains.annotations.NotNull java.lang.Object[] r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super R> r6) {
        /*
            boolean r0 = r6 instanceof kotlin.reflect.full.c.a
            if (r0 == 0) goto L13
            r0 = r6
            kotlin.reflect.full.c$a r0 = (kotlin.reflect.full.c.a) r0
            int r1 = r0.f44221d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f44221d = r1
            goto L18
        L13:
            kotlin.reflect.full.c$a r0 = new kotlin.reflect.full.c$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f44220c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f44221d
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r4 = r0.f44219b
            java.lang.Object[] r4 = (java.lang.Object[]) r4
            java.lang.Object r4 = r0.f44218a
            kotlin.reflect.c r4 = (kotlin.reflect.c) r4
            kotlin.g0.n(r6)
            goto L7c
        L31:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L39:
            kotlin.g0.n(r6)
            boolean r6 = r4.isSuspend()
            if (r6 != 0) goto L4c
            int r6 = r5.length
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r5, r6)
            java.lang.Object r4 = r4.call(r5)
            return r4
        L4c:
            boolean r6 = r4 instanceof kotlin.reflect.i
            if (r6 == 0) goto La0
            r0.f44218a = r4
            r0.f44219b = r5
            r0.f44221d = r3
            kotlin.jvm.internal.s0 r6 = new kotlin.jvm.internal.s0
            r2 = 2
            r6.<init>(r2)
            r6.b(r5)
            r6.a(r0)
            int r5 = r6.c()
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.Object[] r5 = r6.d(r5)
            java.lang.Object r6 = r4.call(r5)
            java.lang.Object r5 = kotlin.coroutines.intrinsics.a.l()
            if (r6 != r5) goto L79
            kotlin.coroutines.jvm.internal.e.c(r0)
        L79:
            if (r6 != r1) goto L7c
            return r1
        L7c:
            kotlin.reflect.i r4 = (kotlin.reflect.i) r4
            kotlin.reflect.r r5 = r4.getReturnType()
            kotlin.reflect.g r5 = r5.n()
            java.lang.Class<kotlin.n1> r0 = kotlin.n1.class
            kotlin.reflect.d r0 = kotlin.jvm.internal.o0.d(r0)
            boolean r5 = kotlin.jvm.internal.g0.g(r5, r0)
            if (r5 == 0) goto L9f
            kotlin.reflect.r r4 = r4.getReturnType()
            boolean r4 = r4.q()
            if (r4 != 0) goto L9f
            kotlin.n1 r4 = kotlin.n1.f44123a
            return r4
        L9f:
            return r6
        La0:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "Cannot callSuspend on a property "
            r6.append(r0)
            r6.append(r4)
            java.lang.String r4 = ": suspend properties are not supported yet"
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            r5.<init>(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.full.c.a(kotlin.reflect.c, java.lang.Object[], kotlin.coroutines.e):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @kotlin.SinceKotlin(version = "1.3")
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <R> java.lang.Object b(@org.jetbrains.annotations.NotNull kotlin.reflect.c<? extends R> r4, @org.jetbrains.annotations.NotNull java.util.Map<kotlin.reflect.KParameter, ? extends java.lang.Object> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super R> r6) {
        /*
            boolean r0 = r6 instanceof kotlin.reflect.full.c.b
            if (r0 == 0) goto L13
            r0 = r6
            kotlin.reflect.full.c$b r0 = (kotlin.reflect.full.c.b) r0
            int r1 = r0.f44226e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f44226e = r1
            goto L18
        L13:
            kotlin.reflect.full.c$b r0 = new kotlin.reflect.full.c$b
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f44225d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f44226e
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r4 = r0.f44224c
            kotlin.reflect.jvm.internal.e0 r4 = (kotlin.reflect.jvm.internal.e0) r4
            java.lang.Object r4 = r0.f44223b
            java.util.Map r4 = (java.util.Map) r4
            java.lang.Object r4 = r0.f44222a
            kotlin.reflect.c r4 = (kotlin.reflect.c) r4
            kotlin.g0.n(r6)
            goto L6d
        L35:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3d:
            kotlin.g0.n(r6)
            boolean r6 = r4.isSuspend()
            if (r6 != 0) goto L4b
            java.lang.Object r4 = r4.callBy(r5)
            return r4
        L4b:
            boolean r6 = r4 instanceof kotlin.reflect.i
            if (r6 == 0) goto La8
            kotlin.reflect.jvm.internal.e0 r6 = kotlin.reflect.jvm.internal.p3.b(r4)
            if (r6 == 0) goto L91
            r0.f44222a = r4
            r0.f44223b = r5
            r0.f44224c = r6
            r0.f44226e = r3
            java.lang.Object r6 = r6.S(r5, r0)
            java.lang.Object r5 = kotlin.coroutines.intrinsics.a.l()
            if (r6 != r5) goto L6a
            kotlin.coroutines.jvm.internal.e.c(r0)
        L6a:
            if (r6 != r1) goto L6d
            return r1
        L6d:
            kotlin.reflect.i r4 = (kotlin.reflect.i) r4
            kotlin.reflect.r r5 = r4.getReturnType()
            kotlin.reflect.g r5 = r5.n()
            java.lang.Class<kotlin.n1> r0 = kotlin.n1.class
            kotlin.reflect.d r0 = kotlin.jvm.internal.o0.d(r0)
            boolean r5 = kotlin.jvm.internal.g0.g(r5, r0)
            if (r5 == 0) goto L90
            kotlin.reflect.r r4 = r4.getReturnType()
            boolean r4 = r4.q()
            if (r4 != 0) goto L90
            kotlin.n1 r4 = kotlin.n1.f44123a
            return r4
        L90:
            return r6
        L91:
            kotlin.reflect.jvm.internal.KotlinReflectionInternalError r5 = new kotlin.reflect.jvm.internal.KotlinReflectionInternalError
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "This callable does not support a default call: "
            r6.append(r0)
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            r5.<init>(r4)
            throw r5
        La8:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "Cannot callSuspendBy on a property "
            r6.append(r0)
            r6.append(r4)
            java.lang.String r4 = ": suspend properties are not supported yet"
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            r5.<init>(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.full.c.b(kotlin.reflect.c, java.util.Map, kotlin.coroutines.e):java.lang.Object");
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static final KParameter c(@NotNull kotlin.reflect.c<?> cVar, @NotNull String name) {
        g0.p(cVar, "<this>");
        g0.p(name, "name");
        Iterator<T> it = cVar.getParameters().iterator();
        Object obj = null;
        boolean z5 = false;
        Object obj2 = null;
        while (true) {
            if (it.hasNext()) {
                Object next = it.next();
                if (g0.g(((KParameter) next).getName(), name)) {
                    if (z5) {
                        break;
                    }
                    z5 = true;
                    obj2 = next;
                }
            } else if (z5) {
                obj = obj2;
            }
        }
        return (KParameter) obj;
    }

    @Nullable
    public static final KParameter d(@NotNull kotlin.reflect.c<?> cVar) {
        g0.p(cVar, "<this>");
        Iterator<T> it = cVar.getParameters().iterator();
        Object obj = null;
        boolean z5 = false;
        Object obj2 = null;
        while (true) {
            if (it.hasNext()) {
                Object next = it.next();
                if (((KParameter) next).h() == KParameter.Kind.EXTENSION_RECEIVER) {
                    if (z5) {
                        break;
                    }
                    z5 = true;
                    obj2 = next;
                }
            } else if (z5) {
                obj = obj2;
            }
        }
        return (KParameter) obj;
    }

    @Nullable
    public static final KParameter f(@NotNull kotlin.reflect.c<?> cVar) {
        g0.p(cVar, "<this>");
        Iterator<T> it = cVar.getParameters().iterator();
        Object obj = null;
        boolean z5 = false;
        Object obj2 = null;
        while (true) {
            if (it.hasNext()) {
                Object next = it.next();
                if (((KParameter) next).h() == KParameter.Kind.INSTANCE) {
                    if (z5) {
                        break;
                    }
                    z5 = true;
                    obj2 = next;
                }
            } else if (z5) {
                obj = obj2;
            }
        }
        return (KParameter) obj;
    }

    @NotNull
    public static final List<KParameter> h(@NotNull kotlin.reflect.c<?> cVar) {
        g0.p(cVar, "<this>");
        List<KParameter> parameters = cVar.getParameters();
        ArrayList arrayList = new ArrayList();
        for (Object obj : parameters) {
            if (((KParameter) obj).h() == KParameter.Kind.VALUE) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void e(kotlin.reflect.c cVar) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void g(kotlin.reflect.c cVar) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void i(kotlin.reflect.c cVar) {
    }
}
