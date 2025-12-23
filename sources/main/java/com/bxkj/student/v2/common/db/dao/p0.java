package com.bxkj.student.v2.common.db.dao;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final /* synthetic */ class p0 {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.common.db.dao.SportsSetDao", f = "SportsSetDao.kt", i = {0, 0}, l = {21}, m = "getSportsSet$suspendImpl", n = {"$this", "type"}, s = {"L$0", "L$1"})
    static final class a extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f20820a;

        /* renamed from: b, reason: collision with root package name */
        Object f20821b;

        /* renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f20822c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ q0 f20823d;

        /* renamed from: e, reason: collision with root package name */
        int f20824e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(q0 q0Var, kotlin.coroutines.e<? super a> eVar) {
            super(eVar);
            this.f20823d = q0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20822c = obj;
            this.f20824e |= Integer.MIN_VALUE;
            return p0.c(this.f20823d, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.Object c(com.bxkj.student.v2.common.db.dao.q0 r4, java.lang.String r5, kotlin.coroutines.e<? super java.lang.String> r6) {
        /*
            boolean r0 = r6 instanceof com.bxkj.student.v2.common.db.dao.p0.a
            if (r0 == 0) goto L13
            r0 = r6
            com.bxkj.student.v2.common.db.dao.p0$a r0 = (com.bxkj.student.v2.common.db.dao.p0.a) r0
            int r1 = r0.f20824e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f20824e = r1
            goto L18
        L13:
            com.bxkj.student.v2.common.db.dao.p0$a r0 = new com.bxkj.student.v2.common.db.dao.p0$a
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f20822c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f20824e
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r4 = r0.f20821b
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r4 = r0.f20820a
            com.bxkj.student.v2.common.db.dao.q0 r4 = (com.bxkj.student.v2.common.db.dao.q0) r4
            kotlin.g0.n(r6)
            goto L5b
        L31:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L39:
            kotlin.g0.n(r6)
            com.bxkj.base.v2.data.b$a r6 = com.bxkj.base.v2.data.b.f16998d
            com.bxkj.base.v2.data.b r6 = r6.a()
            java.lang.String r6 = r6.R()
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.j.a(r4)
            r0.f20820a = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.j.a(r5)
            r0.f20821b = r2
            r0.f20824e = r3
            java.lang.Object r6 = r4.a(r6, r5, r0)
            if (r6 != r1) goto L5b
            return r1
        L5b:
            java.util.List r6 = (java.util.List) r6
            if (r6 == 0) goto L6f
            java.lang.Object r4 = kotlin.collections.f0.L2(r6)
            m0.e r4 = (m0.e) r4
            if (r4 == 0) goto L6f
            java.lang.String r4 = r4.f()
            if (r4 != 0) goto L6e
            goto L6f
        L6e:
            return r4
        L6f:
            java.lang.String r4 = ""
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.common.db.dao.p0.c(com.bxkj.student.v2.common.db.dao.q0, java.lang.String, kotlin.coroutines.e):java.lang.Object");
    }

    @Nullable
    public static Object a(q0 q0Var, @NotNull String str, @NotNull kotlin.coroutines.e eVar) {
        return c(q0Var, str, eVar);
    }
}
