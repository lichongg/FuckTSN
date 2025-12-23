package com.bxkj.student.v2.repository.splash;

import java.util.Map;
import kotlin.coroutines.e;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class b {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.repository.splash.SplashRepository", f = "SplashRepository.kt", i = {}, l = {14}, m = "getAppId", n = {}, s = {})
    static final class a extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f21172a;

        /* renamed from: c, reason: collision with root package name */
        int f21174c;

        a(e<? super a> eVar) {
            super(eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f21172a = obj;
            this.f21174c |= Integer.MIN_VALUE;
            return b.this.b(this);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.repository.splash.SplashRepository", f = "SplashRepository.kt", i = {}, l = {12}, m = "getSchoolInfo", n = {}, s = {})
    /* renamed from: com.bxkj.student.v2.repository.splash.b$b, reason: collision with other inner class name */
    static final class C0287b extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f21175a;

        /* renamed from: c, reason: collision with root package name */
        int f21177c;

        C0287b(e<? super C0287b> eVar) {
            super(eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f21175a = obj;
            this.f21177c |= Integer.MIN_VALUE;
            return b.this.c(this);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.repository.splash.SplashRepository", f = "SplashRepository.kt", i = {}, l = {25}, m = "getSchoolLogo", n = {}, s = {})
    static final class c extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f21178a;

        /* renamed from: c, reason: collision with root package name */
        int f21180c;

        c(e<? super c> eVar) {
            super(eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f21178a = obj;
            this.f21180c |= Integer.MIN_VALUE;
            return b.this.d(this);
        }
    }

    @Nullable
    public final Object a(@NotNull String str, @NotNull e<? super Map<String, ? extends Object>> eVar) {
        return com.bxkj.student.v2.retrofit.a.a(com.bxkj.student.v2.retrofit.e.f21288a.c(), str, null, null, null, null, eVar, 30, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(@org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super java.lang.String> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.bxkj.student.v2.repository.splash.b.a
            if (r0 == 0) goto L13
            r0 = r5
            com.bxkj.student.v2.repository.splash.b$a r0 = (com.bxkj.student.v2.repository.splash.b.a) r0
            int r1 = r0.f21174c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f21174c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.splash.b$a r0 = new com.bxkj.student.v2.repository.splash.b$a
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f21172a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f21174c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.g0.n(r5)
            goto L43
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            kotlin.g0.n(r5)
            com.bxkj.student.v2.retrofit.e r5 = com.bxkj.student.v2.retrofit.e.f21288a
            com.bxkj.student.v2.retrofit.b r5 = r5.c()
            r0.f21174c = r3
            java.lang.Object r5 = r5.g(r0)
            if (r5 != r1) goto L43
            return r1
        L43:
            com.bxkj.base.v2.http.result.ApiResult r5 = (com.bxkj.base.v2.http.result.ApiResult) r5
            if (r5 == 0) goto L4e
            java.lang.Object r5 = r5.apiData()
            java.lang.String r5 = (java.lang.String) r5
            return r5
        L4e:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.repository.splash.b.b(kotlin.coroutines.e):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0054 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object c(@org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super java.util.Map<java.lang.String, java.lang.Object>> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.bxkj.student.v2.repository.splash.b.C0287b
            if (r0 == 0) goto L14
            r0 = r8
            com.bxkj.student.v2.repository.splash.b$b r0 = (com.bxkj.student.v2.repository.splash.b.C0287b) r0
            int r1 = r0.f21177c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f21177c = r1
        L12:
            r4 = r0
            goto L1a
        L14:
            com.bxkj.student.v2.repository.splash.b$b r0 = new com.bxkj.student.v2.repository.splash.b$b
            r0.<init>(r8)
            goto L12
        L1a:
            java.lang.Object r8 = r4.f21175a
            java.lang.Object r0 = kotlin.coroutines.intrinsics.a.l()
            int r1 = r4.f21177c
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            kotlin.g0.n(r8)
            goto L49
        L2b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L33:
            kotlin.g0.n(r8)
            com.bxkj.student.v2.retrofit.e r8 = com.bxkj.student.v2.retrofit.e.f21288a
            com.bxkj.student.v2.retrofit.b r1 = r8.c()
            r4.f21177c = r2
            r2 = 0
            r3 = 0
            r5 = 3
            r6 = 0
            java.lang.Object r8 = com.bxkj.student.v2.retrofit.a.j(r1, r2, r3, r4, r5, r6)
            if (r8 != r0) goto L49
            return r0
        L49:
            com.bxkj.base.v2.http.result.OldApiResult r8 = (com.bxkj.base.v2.http.result.OldApiResult) r8
            if (r8 == 0) goto L54
            java.lang.Object r8 = r8.apiData()
            java.util.Map r8 = (java.util.Map) r8
            return r8
        L54:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.repository.splash.b.c(kotlin.coroutines.e):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object d(@org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super java.util.Map<java.lang.String, java.lang.Object>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.bxkj.student.v2.repository.splash.b.c
            if (r0 == 0) goto L13
            r0 = r5
            com.bxkj.student.v2.repository.splash.b$c r0 = (com.bxkj.student.v2.repository.splash.b.c) r0
            int r1 = r0.f21180c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f21180c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.splash.b$c r0 = new com.bxkj.student.v2.repository.splash.b$c
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f21178a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f21180c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.g0.n(r5)
            goto L43
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            kotlin.g0.n(r5)
            com.bxkj.student.v2.retrofit.e r5 = com.bxkj.student.v2.retrofit.e.f21288a
            com.bxkj.student.v2.retrofit.b r5 = r5.c()
            r0.f21180c = r3
            java.lang.Object r5 = r5.v(r0)
            if (r5 != r1) goto L43
            return r1
        L43:
            com.bxkj.base.v2.http.result.ApiResult r5 = (com.bxkj.base.v2.http.result.ApiResult) r5
            if (r5 == 0) goto L4e
            java.lang.Object r5 = r5.apiData()
            java.util.Map r5 = (java.util.Map) r5
            return r5
        L4e:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.repository.splash.b.d(kotlin.coroutines.e):java.lang.Object");
    }
}
