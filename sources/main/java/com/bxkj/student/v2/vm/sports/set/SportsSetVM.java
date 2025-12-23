package com.bxkj.student.v2.vm.sports.set;

import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.base.v2.http.result.ApiResult;
import java.util.Map;
import kotlin.coroutines.e;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlin.s;
import kotlin.t;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class SportsSetVM extends BaseViewModel {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private final s f22751h = t.c(new Function0() { // from class: com.bxkj.student.v2.vm.sports.set.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            com.bxkj.student.v2.repository.a v5;
            v5 = SportsSetVM.v();
            return v5;
        }
    });

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.set.SportsSetVM$rankingExerciseRecordV2$1", f = "SportsSetVM.kt", i = {}, l = {15}, m = "invokeSuspend", n = {}, s = {})
    @SourceDebugExtension({"SMAP\nSportsSetVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SportsSetVM.kt\ncom/bxkj/student/v2/vm/sports/set/SportsSetVM$rankingExerciseRecordV2$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,18:1\n1#2:19\n*E\n"})
    static final class a extends SuspendLambda implements Function1<e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22752a;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function1<Map<String, Object>, n1> f22754c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(Function1<? super Map<String, Object>, n1> function1, e<? super a> eVar) {
            super(1, eVar);
            this.f22754c = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final e<n1> create(e<?> eVar) {
            return SportsSetVM.this.new a(this.f22754c, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(e<? super n1> eVar) {
            return ((a) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Map<String, Object> map;
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22752a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                com.bxkj.student.v2.repository.a w5 = SportsSetVM.this.w();
                this.f22752a = 1;
                obj = w5.a(this);
                if (obj == l6) {
                    return l6;
                }
            }
            ApiResult apiResult = (ApiResult) obj;
            if (apiResult != null && (map = (Map) apiResult.apiData()) != null) {
                this.f22754c.invoke(map);
            }
            return n1.f44123a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.bxkj.student.v2.repository.a v() {
        return new com.bxkj.student.v2.repository.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.bxkj.student.v2.repository.a w() {
        return (com.bxkj.student.v2.repository.a) this.f22751h.getValue();
    }

    public final void x(@NotNull Function1<? super Map<String, Object>, n1> result) {
        kotlin.jvm.internal.g0.p(result, "result");
        BaseViewModel.j(this, new a(result, null), null, null, null, null, null, null, null, 254, null);
    }
}
