package com.bxkj.student.v2.common.db.dao;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final /* synthetic */ class a {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.common.db.dao.EnvironmentDao", f = "EnvironmentDao.kt", i = {0, 0}, l = {56}, m = "getEnvironment$suspendImpl", n = {"$this", "deviceId"}, s = {"L$0", "L$1"})
    /* renamed from: com.bxkj.student.v2.common.db.dao.a$a, reason: collision with other inner class name */
    static final class C0276a extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f20725a;

        /* renamed from: b, reason: collision with root package name */
        Object f20726b;

        /* renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f20727c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.bxkj.student.v2.common.db.dao.b f20728d;

        /* renamed from: e, reason: collision with root package name */
        int f20729e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0276a(com.bxkj.student.v2.common.db.dao.b bVar, kotlin.coroutines.e<? super C0276a> eVar) {
            super(eVar);
            this.f20728d = bVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20727c = obj;
            this.f20729e |= Integer.MIN_VALUE;
            return a.g(this.f20728d, this);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.common.db.dao.EnvironmentDao", f = "EnvironmentDao.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {45, 47}, m = "upsertOppo$suspendImpl", n = {"$this", "oppo", "deviceId", "$this", "oppo", "deviceId", "rowsUpdated"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "I$0"})
    static final class b extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f20730a;

        /* renamed from: b, reason: collision with root package name */
        Object f20731b;

        /* renamed from: c, reason: collision with root package name */
        Object f20732c;

        /* renamed from: d, reason: collision with root package name */
        int f20733d;

        /* renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f20734e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.bxkj.student.v2.common.db.dao.b f20735f;

        /* renamed from: g, reason: collision with root package name */
        int f20736g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(com.bxkj.student.v2.common.db.dao.b bVar, kotlin.coroutines.e<? super b> eVar) {
            super(eVar);
            this.f20735f = bVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20734e = obj;
            this.f20736g |= Integer.MIN_VALUE;
            return a.h(this.f20735f, null, this);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.common.db.dao.EnvironmentDao", f = "EnvironmentDao.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {35, 38}, m = "upsertSafe$suspendImpl", n = {"$this", "safe", "deviceId", "$this", "safe", "deviceId", "rowsUpdated"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "I$0"})
    static final class c extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f20737a;

        /* renamed from: b, reason: collision with root package name */
        Object f20738b;

        /* renamed from: c, reason: collision with root package name */
        Object f20739c;

        /* renamed from: d, reason: collision with root package name */
        int f20740d;

        /* renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f20741e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.bxkj.student.v2.common.db.dao.b f20742f;

        /* renamed from: g, reason: collision with root package name */
        int f20743g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(com.bxkj.student.v2.common.db.dao.b bVar, kotlin.coroutines.e<? super c> eVar) {
            super(eVar);
            this.f20742f = bVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20741e = obj;
            this.f20743g |= Integer.MIN_VALUE;
            return a.i(this.f20742f, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.Object g(com.bxkj.student.v2.common.db.dao.b r5, kotlin.coroutines.e<? super m0.a> r6) {
        /*
            boolean r0 = r6 instanceof com.bxkj.student.v2.common.db.dao.a.C0276a
            if (r0 == 0) goto L13
            r0 = r6
            com.bxkj.student.v2.common.db.dao.a$a r0 = (com.bxkj.student.v2.common.db.dao.a.C0276a) r0
            int r1 = r0.f20729e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f20729e = r1
            goto L18
        L13:
            com.bxkj.student.v2.common.db.dao.a$a r0 = new com.bxkj.student.v2.common.db.dao.a$a
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f20727c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f20729e
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r5 = r0.f20726b
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r5 = r0.f20725a
            com.bxkj.student.v2.common.db.dao.b r5 = (com.bxkj.student.v2.common.db.dao.b) r5
            kotlin.g0.n(r6)
            goto L60
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            kotlin.g0.n(r6)
            com.bxkj.base.v2.common.utils.f r6 = com.bxkj.base.v2.common.utils.f.f16889a
            com.bxkj.base.BaseApp r2 = com.bxkj.base.BaseApp.c()
            java.lang.String r4 = "getApp(...)"
            kotlin.jvm.internal.g0.o(r2, r4)
            java.lang.String r6 = r6.d(r2)
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.j.a(r5)
            r0.f20725a = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.j.a(r6)
            r0.f20726b = r2
            r0.f20729e = r3
            java.lang.Object r6 = r5.b(r6, r0)
            if (r6 != r1) goto L60
            return r1
        L60:
            java.util.List r6 = (java.util.List) r6
            if (r6 == 0) goto L6b
            java.lang.Object r5 = kotlin.collections.f0.L2(r6)
            m0.a r5 = (m0.a) r5
            return r5
        L6b:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.common.db.dao.a.g(com.bxkj.student.v2.common.db.dao.b, kotlin.coroutines.e):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x009e, code lost:
    
        if (r7.insert(r4, r0) == r1) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00a0, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0072, code lost:
    
        if (r2 == r1) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.Object h(com.bxkj.student.v2.common.db.dao.b r7, java.lang.String r8, kotlin.coroutines.e<? super kotlin.n1> r9) {
        /*
            boolean r0 = r9 instanceof com.bxkj.student.v2.common.db.dao.a.b
            if (r0 == 0) goto L13
            r0 = r9
            com.bxkj.student.v2.common.db.dao.a$b r0 = (com.bxkj.student.v2.common.db.dao.a.b) r0
            int r1 = r0.f20736g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f20736g = r1
            goto L18
        L13:
            com.bxkj.student.v2.common.db.dao.a$b r0 = new com.bxkj.student.v2.common.db.dao.a$b
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.f20734e
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f20736g
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L54
            if (r2 == r4) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r7 = r0.f20732c
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r7 = r0.f20731b
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r7 = r0.f20730a
            com.bxkj.student.v2.common.db.dao.b r7 = (com.bxkj.student.v2.common.db.dao.b) r7
            kotlin.g0.n(r9)
            goto La1
        L38:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L40:
            java.lang.Object r7 = r0.f20732c
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = r0.f20731b
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r2 = r0.f20730a
            com.bxkj.student.v2.common.db.dao.b r2 = (com.bxkj.student.v2.common.db.dao.b) r2
            kotlin.g0.n(r9)
            r6 = r9
            r9 = r7
            r7 = r2
            r2 = r6
            goto L75
        L54:
            kotlin.g0.n(r9)
            com.bxkj.base.v2.common.utils.f r9 = com.bxkj.base.v2.common.utils.f.f16889a
            com.bxkj.base.BaseApp r2 = com.bxkj.base.BaseApp.c()
            java.lang.String r5 = "getApp(...)"
            kotlin.jvm.internal.g0.o(r2, r5)
            java.lang.String r9 = r9.d(r2)
            r0.f20730a = r7
            r0.f20731b = r8
            r0.f20732c = r9
            r0.f20736g = r4
            java.lang.Object r2 = r7.c(r9, r8, r0)
            if (r2 != r1) goto L75
            goto La0
        L75:
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            if (r2 != 0) goto La4
            m0.a r4 = new m0.a
            java.lang.String r5 = ""
            r4.<init>(r9, r5, r8)
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.j.a(r7)
            r0.f20730a = r5
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.j.a(r8)
            r0.f20731b = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.j.a(r9)
            r0.f20732c = r8
            r0.f20733d = r2
            r0.f20736g = r3
            java.lang.Object r7 = r7.insert(r4, r0)
            if (r7 != r1) goto La1
        La0:
            return r1
        La1:
            kotlin.n1 r7 = kotlin.n1.f44123a
            return r7
        La4:
            kotlin.n1 r7 = kotlin.n1.f44123a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.common.db.dao.a.h(com.bxkj.student.v2.common.db.dao.b, java.lang.String, kotlin.coroutines.e):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x009e, code lost:
    
        if (r7.insert(r4, r0) == r1) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00a0, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0072, code lost:
    
        if (r2 == r1) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.Object i(com.bxkj.student.v2.common.db.dao.b r7, java.lang.String r8, kotlin.coroutines.e<? super kotlin.n1> r9) {
        /*
            boolean r0 = r9 instanceof com.bxkj.student.v2.common.db.dao.a.c
            if (r0 == 0) goto L13
            r0 = r9
            com.bxkj.student.v2.common.db.dao.a$c r0 = (com.bxkj.student.v2.common.db.dao.a.c) r0
            int r1 = r0.f20743g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f20743g = r1
            goto L18
        L13:
            com.bxkj.student.v2.common.db.dao.a$c r0 = new com.bxkj.student.v2.common.db.dao.a$c
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.f20741e
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f20743g
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L54
            if (r2 == r4) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r7 = r0.f20739c
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r7 = r0.f20738b
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r7 = r0.f20737a
            com.bxkj.student.v2.common.db.dao.b r7 = (com.bxkj.student.v2.common.db.dao.b) r7
            kotlin.g0.n(r9)
            goto La1
        L38:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L40:
            java.lang.Object r7 = r0.f20739c
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = r0.f20738b
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r2 = r0.f20737a
            com.bxkj.student.v2.common.db.dao.b r2 = (com.bxkj.student.v2.common.db.dao.b) r2
            kotlin.g0.n(r9)
            r6 = r9
            r9 = r7
            r7 = r2
            r2 = r6
            goto L75
        L54:
            kotlin.g0.n(r9)
            com.bxkj.base.v2.common.utils.f r9 = com.bxkj.base.v2.common.utils.f.f16889a
            com.bxkj.base.BaseApp r2 = com.bxkj.base.BaseApp.c()
            java.lang.String r5 = "getApp(...)"
            kotlin.jvm.internal.g0.o(r2, r5)
            java.lang.String r9 = r9.d(r2)
            r0.f20737a = r7
            r0.f20738b = r8
            r0.f20739c = r9
            r0.f20743g = r4
            java.lang.Object r2 = r7.d(r9, r8, r0)
            if (r2 != r1) goto L75
            goto La0
        L75:
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            if (r2 != 0) goto La4
            m0.a r4 = new m0.a
            java.lang.String r5 = ""
            r4.<init>(r9, r8, r5)
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.j.a(r7)
            r0.f20737a = r5
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.j.a(r8)
            r0.f20738b = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.j.a(r9)
            r0.f20739c = r8
            r0.f20740d = r2
            r0.f20743g = r3
            java.lang.Object r7 = r7.insert(r4, r0)
            if (r7 != r1) goto La1
        La0:
            return r1
        La1:
            kotlin.n1 r7 = kotlin.n1.f44123a
            return r7
        La4:
            kotlin.n1 r7 = kotlin.n1.f44123a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.common.db.dao.a.i(com.bxkj.student.v2.common.db.dao.b, java.lang.String, kotlin.coroutines.e):java.lang.Object");
    }

    @Nullable
    public static Object a(com.bxkj.student.v2.common.db.dao.b bVar, @NotNull kotlin.coroutines.e eVar) {
        return g(bVar, eVar);
    }

    @Nullable
    public static Object b(com.bxkj.student.v2.common.db.dao.b bVar, @NotNull String str, @NotNull kotlin.coroutines.e eVar) {
        return h(bVar, str, eVar);
    }

    @Nullable
    public static Object c(com.bxkj.student.v2.common.db.dao.b bVar, @NotNull String str, @NotNull kotlin.coroutines.e eVar) {
        return i(bVar, str, eVar);
    }
}
