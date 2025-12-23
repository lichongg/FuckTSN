package com.bxkj.student.v2.vm.sports.set;

import androidx.lifecycle.MutableLiveData;
import com.bxkj.base.v2.base.BaseViewModel;
import java.util.Map;
import kotlin.coroutines.e;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function1;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class SportsRankVM extends BaseViewModel {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private MutableLiveData<Map<String, Object>> f22749h = new MutableLiveData<>();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.set.SportsRankVM$getRankData$1", f = "SportsRankVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function1<e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22750a;

        a(e<? super a> eVar) {
            super(1, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final e<n1> create(e<?> eVar) {
            return new a(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(e<? super n1> eVar) {
            return ((a) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a.l();
            if (this.f22750a == 0) {
                g0.n(obj);
                return n1.f44123a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @NotNull
    public final MutableLiveData<Map<String, Object>> t() {
        return this.f22749h;
    }

    public final void u() {
        BaseViewModel.j(this, new a(null), null, null, null, null, null, null, null, 254, null);
    }

    public final void v(@NotNull MutableLiveData<Map<String, Object>> mutableLiveData) {
        kotlin.jvm.internal.g0.p(mutableLiveData, "<set-?>");
        this.f22749h = mutableLiveData;
    }
}
