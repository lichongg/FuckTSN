package com.bxkj.student.v2.repository.face;

import kotlin.coroutines.e;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class a {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.repository.face.FaceCheckRepository", f = "FaceCheckRepository.kt", i = {0}, l = {14}, m = "faceCheck", n = {master.flame.danmaku.danmaku.parser.b.f50156c}, s = {"L$0"})
    /* renamed from: com.bxkj.student.v2.repository.face.a$a, reason: collision with other inner class name */
    static final class C0284a extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f21139a;

        /* renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f21140b;

        /* renamed from: d, reason: collision with root package name */
        int f21142d;

        C0284a(e<? super C0284a> eVar) {
            super(eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f21140b = obj;
            this.f21142d |= Integer.MIN_VALUE;
            return a.this.a(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0058 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(@org.jetbrains.annotations.Nullable okhttp3.MultipartBody.Part r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super java.lang.Boolean> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.bxkj.student.v2.repository.face.a.C0284a
            if (r0 == 0) goto L13
            r0 = r6
            com.bxkj.student.v2.repository.face.a$a r0 = (com.bxkj.student.v2.repository.face.a.C0284a) r0
            int r1 = r0.f21142d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f21142d = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.face.a$a r0 = new com.bxkj.student.v2.repository.face.a$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f21140b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f21142d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.f21139a
            okhttp3.MultipartBody$Part r5 = (okhttp3.MultipartBody.Part) r5
            kotlin.g0.n(r6)
            goto L4d
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.g0.n(r6)
            com.bxkj.student.v2.retrofit.e r6 = com.bxkj.student.v2.retrofit.e.f21288a
            com.bxkj.student.v2.retrofit.b r6 = r6.c()
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.j.a(r5)
            r0.f21139a = r2
            r0.f21142d = r3
            java.lang.Object r6 = r6.E(r5, r0)
            if (r6 != r1) goto L4d
            return r1
        L4d:
            com.bxkj.base.v2.http.result.ApiResult r6 = (com.bxkj.base.v2.http.result.ApiResult) r6
            if (r6 == 0) goto L58
            java.lang.Object r5 = r6.apiData()
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            return r5
        L58:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.repository.face.a.a(okhttp3.MultipartBody$Part, kotlin.coroutines.e):java.lang.Object");
    }
}
