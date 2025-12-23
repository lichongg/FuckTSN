package com.bxkj.student.v2.vm;

import androidx.lifecycle.MutableLiveData;
import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.base.v2.common.utils.c0;
import java.util.Map;
import kotlin.coroutines.e;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.n1;
import org.apache.commons.net.telnet.f;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class NoticeVM extends BaseViewModel {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private MutableLiveData<Map<String, Object>> f22280h = new MutableLiveData<>();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.NoticeVM$getLatestUnreadNotice$1", f = "NoticeVM.kt", i = {}, l = {19}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function1<e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22281a;

        a(e<? super a> eVar) {
            super(1, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final e<n1> create(e<?> eVar) {
            return NoticeVM.this.new a(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(e<? super n1> eVar) {
            return ((a) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22281a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                com.bxkj.student.v2.repository.c cVar = new com.bxkj.student.v2.repository.c();
                String t5 = c0.f16887a.t((Map) NoticeVM.this.t().getValue(), "id");
                this.f22281a = 1;
                if (cVar.h(t5, this) == l6) {
                    return l6;
                }
            }
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.NoticeVM$getLatestUnreadNotice$2", f = "NoticeVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class b extends SuspendLambda implements Function1<e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22283a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function0<n1> f22284b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Function0<n1> function0, e<? super b> eVar) {
            super(1, eVar);
            this.f22284b = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final e<n1> create(e<?> eVar) {
            return new b(this.f22284b, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(e<? super n1> eVar) {
            return ((b) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a.l();
            if (this.f22283a == 0) {
                g0.n(obj);
                this.f22284b.invoke();
                return n1.f44123a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @NotNull
    public final MutableLiveData<Map<String, Object>> t() {
        return this.f22280h;
    }

    public final void u(@NotNull Function0<n1> complete) {
        kotlin.jvm.internal.g0.p(complete, "complete");
        BaseViewModel.j(this, new a(null), null, null, null, new b(complete, null), null, null, null, f.f51103s, null);
    }

    public final void v(@NotNull MutableLiveData<Map<String, Object>> mutableLiveData) {
        kotlin.jvm.internal.g0.p(mutableLiveData, "<set-?>");
        this.f22280h = mutableLiveData;
    }
}
