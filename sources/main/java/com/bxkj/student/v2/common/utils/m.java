package com.bxkj.student.v2.common.utils;

import java.net.InetAddress;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function2;
import kotlin.n1;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final m f20909a = new m();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.common.utils.NtpTimeSync$getNtpTime$2", f = "NtpTimeSync.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super Long>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f20910a;

        a(kotlin.coroutines.e<? super a> eVar) {
            super(2, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return new a(eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super Long> eVar) {
            return ((a) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a.l();
            if (this.f20910a == 0) {
                g0.n(obj);
                org.apache.commons.net.ntp.a aVar = new org.apache.commons.net.ntp.a();
                try {
                    try {
                        aVar.i();
                        return kotlin.coroutines.jvm.internal.a.g(aVar.p(InetAddress.getByName("cn.pool.ntp.org")).f().C().getTime());
                    } catch (Exception e6) {
                        com.orhanobut.logger.j.e(com.bxkj.base.v2.common.ext.e.a(e6), new Object[0]);
                        aVar.a();
                        return null;
                    }
                } finally {
                    aVar.a();
                }
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private m() {
    }

    @Nullable
    public final Object a(@NotNull kotlin.coroutines.e<? super Long> eVar) {
        return kotlinx.coroutines.i.h(g1.c(), new a(null), eVar);
    }
}
