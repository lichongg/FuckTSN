package com.bxkj.student.v2.repository.my;

import com.bxkj.base.user.LoginUser;
import com.bxkj.base.v2.http.result.OldApiResult;
import com.bxkj.student.App;
import java.util.Map;
import kotlin.coroutines.e;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class a {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.repository.my.AboutUsRepository", f = "AboutUsRepository.kt", i = {}, l = {15}, m = "getPgyerAppVersion", n = {}, s = {})
    /* renamed from: com.bxkj.student.v2.repository.my.a$a, reason: collision with other inner class name */
    static final class C0285a extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f21165a;

        /* renamed from: c, reason: collision with root package name */
        int f21167c;

        C0285a(e<? super C0285a> eVar) {
            super(eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f21165a = obj;
            this.f21167c |= Integer.MIN_VALUE;
            return a.this.a(this);
        }
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
    public final java.lang.Object a(@org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super java.util.Map<java.lang.String, java.lang.Object>> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.bxkj.student.v2.repository.my.a.C0285a
            if (r0 == 0) goto L14
            r0 = r8
            com.bxkj.student.v2.repository.my.a$a r0 = (com.bxkj.student.v2.repository.my.a.C0285a) r0
            int r1 = r0.f21167c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f21167c = r1
        L12:
            r4 = r0
            goto L1a
        L14:
            com.bxkj.student.v2.repository.my.a$a r0 = new com.bxkj.student.v2.repository.my.a$a
            r0.<init>(r8)
            goto L12
        L1a:
            java.lang.Object r8 = r4.f21165a
            java.lang.Object r0 = kotlin.coroutines.intrinsics.a.l()
            int r1 = r4.f21167c
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
            r4.f21167c = r2
            r2 = 0
            r3 = 0
            r5 = 3
            r6 = 0
            java.lang.Object r8 = com.bxkj.student.v2.retrofit.a.i(r1, r2, r3, r4, r5, r6)
            if (r8 != r0) goto L49
            return r0
        L49:
            com.bxkj.base.v2.http.result.PgyerApiResult r8 = (com.bxkj.base.v2.http.result.PgyerApiResult) r8
            if (r8 == 0) goto L54
            java.lang.Object r8 = r8.apiData()
            java.util.Map r8 = (java.util.Map) r8
            return r8
        L54:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.repository.my.a.a(kotlin.coroutines.e):java.lang.Object");
    }

    @Nullable
    public final Object b(@NotNull e<? super OldApiResult<Map<String, Object>>> eVar) {
        return com.bxkj.student.v2.retrofit.e.f21288a.c().y(LoginUser.getLoginUser().getSchoolId(), c0.b.f1042a.f(App.f17573d.a()), eVar);
    }
}
