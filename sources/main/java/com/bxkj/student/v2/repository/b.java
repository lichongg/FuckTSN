package com.bxkj.student.v2.repository;

import com.bxkj.student.v2.vm.LoginViewModel;
import java.net.URLEncoder;
import java.util.Map;
import kotlin.coroutines.e;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nLoginRepository.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LoginRepository.kt\ncom/bxkj/student/v2/repository/LoginRepository\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,39:1\n1#2:40\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private LoginViewModel f21100a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.repository.LoginRepository", f = "LoginRepository.kt", i = {}, l = {37}, m = "getLoginNeedAuth", n = {}, s = {})
    static final class a extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f21101a;

        /* renamed from: c, reason: collision with root package name */
        int f21103c;

        a(e<? super a> eVar) {
            super(eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f21101a = obj;
            this.f21103c |= Integer.MIN_VALUE;
            return b.this.a(this);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.repository.LoginRepository", f = "LoginRepository.kt", i = {0, 0}, l = {26}, m = "loginThirdCheck", n = {"openId", "type"}, s = {"L$0", "L$1"})
    /* renamed from: com.bxkj.student.v2.repository.b$b, reason: collision with other inner class name */
    static final class C0282b extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f21104a;

        /* renamed from: b, reason: collision with root package name */
        Object f21105b;

        /* renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f21106c;

        /* renamed from: e, reason: collision with root package name */
        int f21108e;

        C0282b(e<? super C0282b> eVar) {
            super(eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f21106c = obj;
            this.f21108e |= Integer.MIN_VALUE;
            return b.this.e(null, null, this);
        }
    }

    public b(@NotNull LoginViewModel loginViewModel) {
        g0.p(loginViewModel, "loginViewModel");
        this.f21100a = loginViewModel;
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
    public final java.lang.Object a(@org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super java.util.Map<java.lang.String, java.lang.Object>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.bxkj.student.v2.repository.b.a
            if (r0 == 0) goto L13
            r0 = r5
            com.bxkj.student.v2.repository.b$a r0 = (com.bxkj.student.v2.repository.b.a) r0
            int r1 = r0.f21103c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f21103c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.b$a r0 = new com.bxkj.student.v2.repository.b$a
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f21101a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f21103c
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
            r0.f21103c = r3
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
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.repository.b.a(kotlin.coroutines.e):java.lang.Object");
    }

    @NotNull
    public final LoginViewModel b() {
        return this.f21100a;
    }

    @Nullable
    public final Object c(@NotNull e<? super Map<String, ? extends Object>> eVar) {
        com.bxkj.student.v2.retrofit.b c6 = com.bxkj.student.v2.retrofit.e.f21288a.c();
        String str = this.f21100a.I().get();
        String str2 = this.f21100a.G().get();
        return com.bxkj.student.v2.retrofit.a.l(c6, str, str2 != null ? URLEncoder.encode(com.bxkj.base.v2.common.utils.a.f16871a.c(str2), "UTF-8") : null, null, null, null, null, eVar, 60, null);
    }

    @Nullable
    public final Object d(@NotNull String str, @NotNull String str2, @NotNull e<? super Map<String, ? extends Object>> eVar) {
        return com.bxkj.student.v2.retrofit.a.n(com.bxkj.student.v2.retrofit.e.f21288a.c(), str, null, null, str2, eVar, 6, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0062 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object e(@org.jetbrains.annotations.NotNull java.lang.String r5, @org.jetbrains.annotations.NotNull java.lang.String r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super java.util.Map<java.lang.String, java.lang.Object>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.bxkj.student.v2.repository.b.C0282b
            if (r0 == 0) goto L13
            r0 = r7
            com.bxkj.student.v2.repository.b$b r0 = (com.bxkj.student.v2.repository.b.C0282b) r0
            int r1 = r0.f21108e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f21108e = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.b$b r0 = new com.bxkj.student.v2.repository.b$b
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f21106c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f21108e
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r5 = r0.f21105b
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r5 = r0.f21104a
            java.lang.String r5 = (java.lang.String) r5
            kotlin.g0.n(r7)
            goto L57
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            kotlin.g0.n(r7)
            com.bxkj.student.v2.retrofit.e r7 = com.bxkj.student.v2.retrofit.e.f21288a
            com.bxkj.student.v2.retrofit.b r7 = r7.c()
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.j.a(r5)
            r0.f21104a = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.j.a(r6)
            r0.f21105b = r2
            r0.f21108e = r3
            java.lang.Object r7 = r7.J(r5, r6, r0)
            if (r7 != r1) goto L57
            return r1
        L57:
            com.bxkj.base.v2.http.result.ApiResult r7 = (com.bxkj.base.v2.http.result.ApiResult) r7
            if (r7 == 0) goto L62
            java.lang.Object r5 = r7.apiData()
            java.util.Map r5 = (java.util.Map) r5
            return r5
        L62:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.repository.b.e(java.lang.String, java.lang.String, kotlin.coroutines.e):java.lang.Object");
    }

    public final void f(@NotNull LoginViewModel loginViewModel) {
        g0.p(loginViewModel, "<set-?>");
        this.f21100a = loginViewModel;
    }
}
