package com.bxkj.student.v2.repository.sports;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class h {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.repository.sports.SportsStatisticsRepository", f = "SportsStatisticsRepository.kt", i = {}, l = {12}, m = "getSportsStatistics", n = {}, s = {})
    static final class a extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f21272a;

        /* renamed from: c, reason: collision with root package name */
        int f21274c;

        a(kotlin.coroutines.e<? super a> eVar) {
            super(eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f21272a = obj;
            this.f21274c |= Integer.MIN_VALUE;
            return h.this.a(this);
        }
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
            boolean r0 = r5 instanceof com.bxkj.student.v2.repository.sports.h.a
            if (r0 == 0) goto L13
            r0 = r5
            com.bxkj.student.v2.repository.sports.h$a r0 = (com.bxkj.student.v2.repository.sports.h.a) r0
            int r1 = r0.f21274c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f21274c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.sports.h$a r0 = new com.bxkj.student.v2.repository.sports.h$a
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f21272a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f21274c
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
            r0.f21274c = r3
            java.lang.Object r5 = r5.G(r0)
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
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.repository.sports.h.a(kotlin.coroutines.e):java.lang.Object");
    }
}
