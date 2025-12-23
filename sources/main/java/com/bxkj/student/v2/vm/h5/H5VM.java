package com.bxkj.student.v2.vm.h5;

import com.bxkj.base.user.LoginUser;
import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.student.v2.vm.LoginViewModel;
import java.util.Map;
import kotlin.coroutines.e;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.n1;
import kotlin.s;
import kotlin.t;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class H5VM extends LoginViewModel {

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    private final s f22327o = t.c(new Function0() { // from class: com.bxkj.student.v2.vm.h5.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            p0.a W;
            W = H5VM.W();
            return W;
        }
    });

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.h5.H5VM$loginFromOldSystemToNew$1", f = "H5VM.kt", i = {}, l = {16}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function1<e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22328a;

        a(e<? super a> eVar) {
            super(1, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final e<n1> create(e<?> eVar) {
            return H5VM.this.new a(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(e<? super n1> eVar) {
            return ((a) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22328a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                p0.a V = H5VM.this.V();
                String account = LoginUser.getLoginUser().getAccount();
                kotlin.jvm.internal.g0.o(account, "getAccount(...)");
                this.f22328a = 1;
                obj = V.a(account, this);
                if (obj == l6) {
                    return l6;
                }
            }
            H5VM.this.L((Map) obj);
            return n1.f44123a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final p0.a V() {
        return (p0.a) this.f22327o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final p0.a W() {
        return new p0.a();
    }

    public final void X() {
        BaseViewModel.j(this, new a(null), null, null, null, null, null, null, null, 254, null);
    }
}
