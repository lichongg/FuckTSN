package com.bxkj.student.v2.vm.sports;

import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.base.v2.common.utils.c0;
import com.bxkj.base.v2.http.result.ApiResult;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Map;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.n1;
import kotlin.s;
import kotlin.t;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class PermissionSetVM extends BaseViewModel {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private final s f22383h = t.c(new Function0() { // from class: com.bxkj.student.v2.vm.sports.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            com.bxkj.student.v2.repository.a v5;
            v5 = PermissionSetVM.v();
            return v5;
        }
    });

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.PermissionSetVM$getPhonePermissionUrl$1", f = "PermissionSetVM.kt", i = {}, l = {16}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22384a;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function2<String, String, n1> f22386c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(Function2<? super String, ? super String, n1> function2, kotlin.coroutines.e<? super a> eVar) {
            super(1, eVar);
            this.f22386c = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return PermissionSetVM.this.new a(this.f22386c, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((a) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Map<String, ? extends Object> map;
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22384a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                com.bxkj.student.v2.repository.a w5 = PermissionSetVM.this.w();
                this.f22384a = 1;
                obj = w5.e(this);
                if (obj == l6) {
                    return l6;
                }
            }
            ApiResult apiResult = (ApiResult) obj;
            if (apiResult != null) {
                map = (Map) apiResult.apiData();
            } else {
                map = null;
            }
            c0 c0Var = c0.f16887a;
            this.f22386c.invoke(c0Var.t(map, CommonNetImpl.NAME), c0Var.t(map, "linkUrl"));
            return n1.f44123a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.bxkj.student.v2.repository.a v() {
        return new com.bxkj.student.v2.repository.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.bxkj.student.v2.repository.a w() {
        return (com.bxkj.student.v2.repository.a) this.f22383h.getValue();
    }

    public final void x(@NotNull Function2<? super String, ? super String, n1> success) {
        kotlin.jvm.internal.g0.p(success, "success");
        BaseViewModel.j(this, new a(success, null), null, null, null, null, null, null, null, 254, null);
    }
}
