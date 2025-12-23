package com.bxkj.student.v2.repository.splash;

import com.umeng.socialize.net.dplus.CommonNetImpl;
import kotlin.coroutines.e;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class a {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.repository.splash.SelectSchoolRepository", f = "SelectSchoolRepository.kt", i = {0}, l = {14}, m = "searchSchool", n = {CommonNetImpl.NAME}, s = {"L$0"})
    /* renamed from: com.bxkj.student.v2.repository.splash.a$a, reason: collision with other inner class name */
    static final class C0286a extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f21168a;

        /* renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f21169b;

        /* renamed from: d, reason: collision with root package name */
        int f21171d;

        C0286a(e<? super C0286a> eVar) {
            super(eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f21169b = obj;
            this.f21171d |= Integer.MIN_VALUE;
            return a.this.a(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(@org.jetbrains.annotations.NotNull java.lang.String r8, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.bxkj.student.v2.repository.splash.a.C0286a
            if (r0 == 0) goto L14
            r0 = r9
            com.bxkj.student.v2.repository.splash.a$a r0 = (com.bxkj.student.v2.repository.splash.a.C0286a) r0
            int r1 = r0.f21171d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f21171d = r1
        L12:
            r4 = r0
            goto L1a
        L14:
            com.bxkj.student.v2.repository.splash.a$a r0 = new com.bxkj.student.v2.repository.splash.a$a
            r0.<init>(r9)
            goto L12
        L1a:
            java.lang.Object r9 = r4.f21169b
            java.lang.Object r0 = kotlin.coroutines.intrinsics.a.l()
            int r1 = r4.f21171d
            r2 = 1
            if (r1 == 0) goto L37
            if (r1 != r2) goto L2f
            java.lang.Object r8 = r4.f21168a
            java.lang.String r8 = (java.lang.String) r8
            kotlin.g0.n(r9)
            goto L53
        L2f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L37:
            kotlin.g0.n(r9)
            com.bxkj.student.v2.retrofit.e r9 = com.bxkj.student.v2.retrofit.e.f21288a
            com.bxkj.student.v2.retrofit.b r1 = r9.c()
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.j.a(r8)
            r4.f21168a = r9
            r4.f21171d = r2
            r3 = 0
            r5 = 2
            r6 = 0
            r2 = r8
            java.lang.Object r9 = com.bxkj.student.v2.retrofit.a.o(r1, r2, r3, r4, r5, r6)
            if (r9 != r0) goto L53
            return r0
        L53:
            com.bxkj.base.v2.http.result.OldApiResult r9 = (com.bxkj.base.v2.http.result.OldApiResult) r9
            if (r9 == 0) goto L5e
            java.lang.Object r8 = r9.apiData()
            java.util.List r8 = (java.util.List) r8
            return r8
        L5e:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.repository.splash.a.a(java.lang.String, kotlin.coroutines.e):java.lang.Object");
    }
}
