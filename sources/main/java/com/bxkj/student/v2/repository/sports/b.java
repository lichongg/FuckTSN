package com.bxkj.student.v2.repository.sports;

import androidx.core.app.NotificationCompat;
import com.bxkj.student.v2.common.db.AppDatabase;
import com.bxkj.student.v2.common.db.dao.x;
import java.util.List;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class b {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.repository.sports.RecordRepository", f = "RecordRepository.kt", i = {0, 0, 0, 0}, l = {17}, m = "v3GetSportsResult", n = {NotificationCompat.CATEGORY_STATUS, "date", "isFeedback", "datePageIndex"}, s = {"L$0", "L$1", "L$2", "I$0"})
    static final class a extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f21191a;

        /* renamed from: b, reason: collision with root package name */
        Object f21192b;

        /* renamed from: c, reason: collision with root package name */
        Object f21193c;

        /* renamed from: d, reason: collision with root package name */
        int f21194d;

        /* renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f21195e;

        /* renamed from: g, reason: collision with root package name */
        int f21197g;

        a(kotlin.coroutines.e<? super a> eVar) {
            super(eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f21195e = obj;
            this.f21197g |= Integer.MIN_VALUE;
            return b.this.g(null, null, 0, null, this);
        }
    }

    public static /* synthetic */ Object h(b bVar, String str, String str2, int i6, String str3, kotlin.coroutines.e eVar, int i7, Object obj) {
        if ((i7 & 8) != 0) {
            str3 = null;
        }
        return bVar.g(str, str2, i6, str3, eVar);
    }

    @Nullable
    public final Object a(@NotNull String str, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        com.bxkj.student.v2.common.db.dao.g v5 = AppDatabase.f20686a.a().v();
        if (v5 == null) {
            return null;
        }
        Object deleteByIdentify = v5.deleteByIdentify(str, eVar);
        return deleteByIdentify == kotlin.coroutines.intrinsics.a.l() ? deleteByIdentify : n1.f44123a;
    }

    @Nullable
    public final Object b(@NotNull String str, @NotNull kotlin.coroutines.e<? super List<m0.b>> eVar) {
        com.bxkj.student.v2.common.db.dao.g v5 = AppDatabase.f20686a.a().v();
        if (v5 == null) {
            return null;
        }
        Object b6 = v5.b(str, eVar);
        return b6 == kotlin.coroutines.intrinsics.a.l() ? b6 : (List) b6;
    }

    @Nullable
    public final Object c(@NotNull String str, @NotNull kotlin.coroutines.e<? super List<m0.d>> eVar) {
        x x5 = AppDatabase.f20686a.a().x();
        if (x5 != null) {
            return x5.getLocalRecordById(str, eVar);
        }
        return null;
    }

    @Nullable
    public final Object d(@NotNull String str, long j6, long j7, @NotNull kotlin.coroutines.e<? super List<m0.d>> eVar) {
        x x5 = AppDatabase.f20686a.a().x();
        if (x5 != null) {
            return x5.d(str, j6, j7, eVar);
        }
        return null;
    }

    @Nullable
    public final Object e(@NotNull String str, @NotNull kotlin.coroutines.e<? super List<m0.d>> eVar) {
        x x5 = AppDatabase.f20686a.a().x();
        if (x5 != null) {
            return x5.f(str, eVar);
        }
        return null;
    }

    @Nullable
    public final Object f(@NotNull String str, long j6, long j7, @NotNull kotlin.coroutines.e<? super List<l0.a>> eVar) {
        x x5 = AppDatabase.f20686a.a().x();
        if (x5 != null) {
            return x5.m(str, j6, j7, eVar);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0074 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object g(@org.jetbrains.annotations.NotNull java.lang.String r8, @org.jetbrains.annotations.NotNull java.lang.String r9, int r10, @org.jetbrains.annotations.Nullable java.lang.String r11, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super java.util.Map<java.lang.String, java.lang.Object>> r12) {
        /*
            r7 = this;
            boolean r0 = r12 instanceof com.bxkj.student.v2.repository.sports.b.a
            if (r0 == 0) goto L14
            r0 = r12
            com.bxkj.student.v2.repository.sports.b$a r0 = (com.bxkj.student.v2.repository.sports.b.a) r0
            int r1 = r0.f21197g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f21197g = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            com.bxkj.student.v2.repository.sports.b$a r0 = new com.bxkj.student.v2.repository.sports.b$a
            r0.<init>(r12)
            goto L12
        L1a:
            java.lang.Object r12 = r6.f21195e
            java.lang.Object r0 = kotlin.coroutines.intrinsics.a.l()
            int r1 = r6.f21197g
            r2 = 1
            if (r1 == 0) goto L3f
            if (r1 != r2) goto L37
            java.lang.Object r8 = r6.f21193c
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r8 = r6.f21192b
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r8 = r6.f21191a
            java.lang.String r8 = (java.lang.String) r8
            kotlin.g0.n(r12)
            goto L69
        L37:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3f:
            kotlin.g0.n(r12)
            com.bxkj.student.v2.retrofit.e r12 = com.bxkj.student.v2.retrofit.e.f21288a
            com.bxkj.student.v2.retrofit.b r1 = r12.c()
            java.lang.Object r12 = kotlin.coroutines.jvm.internal.j.a(r8)
            r6.f21191a = r12
            java.lang.Object r12 = kotlin.coroutines.jvm.internal.j.a(r9)
            r6.f21192b = r12
            java.lang.Object r12 = kotlin.coroutines.jvm.internal.j.a(r11)
            r6.f21193c = r12
            r6.f21194d = r10
            r6.f21197g = r2
            r2 = r8
            r3 = r9
            r4 = r10
            r5 = r11
            java.lang.Object r12 = r1.q(r2, r3, r4, r5, r6)
            if (r12 != r0) goto L69
            return r0
        L69:
            com.bxkj.base.v2.http.result.ApiResult r12 = (com.bxkj.base.v2.http.result.ApiResult) r12
            if (r12 == 0) goto L74
            java.lang.Object r8 = r12.apiData()
            java.util.Map r8 = (java.util.Map) r8
            return r8
        L74:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.repository.sports.b.g(java.lang.String, java.lang.String, int, java.lang.String, kotlin.coroutines.e):java.lang.Object");
    }
}
