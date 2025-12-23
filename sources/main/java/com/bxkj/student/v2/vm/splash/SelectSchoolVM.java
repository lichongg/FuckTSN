package com.bxkj.student.v2.vm.splash;

import com.bxkj.base.v2.base.BaseViewModel;
import java.util.List;
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
public final class SelectSchoolVM extends BaseViewModel {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private final s f22354h = t.c(new Function0() { // from class: com.bxkj.student.v2.vm.splash.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            com.bxkj.student.v2.repository.splash.a x5;
            x5 = SelectSchoolVM.x();
            return x5;
        }
    });

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.splash.SelectSchoolVM$searchSchool$1", f = "SelectSchoolVM.kt", i = {}, l = {17}, m = "invokeSuspend", n = {}, s = {})
    @SourceDebugExtension({"SMAP\nSelectSchoolVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SelectSchoolVM.kt\ncom/bxkj/student/v2/vm/splash/SelectSchoolVM$searchSchool$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,22:1\n1#2:23\n*E\n"})
    static final class a extends SuspendLambda implements Function1<e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22355a;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f22357c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function1<List<Map<String, Object>>, n1> f22358d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(String str, Function1<? super List<Map<String, Object>>, n1> function1, e<? super a> eVar) {
            super(1, eVar);
            this.f22357c = str;
            this.f22358d = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final e<n1> create(e<?> eVar) {
            return SelectSchoolVM.this.new a(this.f22357c, this.f22358d, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(e<? super n1> eVar) {
            return ((a) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22355a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                com.bxkj.student.v2.repository.splash.a v5 = SelectSchoolVM.this.v();
                String str = this.f22357c;
                this.f22355a = 1;
                obj = v5.a(str, this);
                if (obj == l6) {
                    return l6;
                }
            }
            List<Map<String, Object>> list = (List) obj;
            if (list != null) {
                this.f22358d.invoke(list);
            }
            return n1.f44123a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.bxkj.student.v2.repository.splash.a v() {
        return (com.bxkj.student.v2.repository.splash.a) this.f22354h.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.bxkj.student.v2.repository.splash.a x() {
        return new com.bxkj.student.v2.repository.splash.a();
    }

    public final void w(@NotNull String name, @NotNull Function1<? super List<Map<String, Object>>, n1> finish) {
        kotlin.jvm.internal.g0.p(name, "name");
        kotlin.jvm.internal.g0.p(finish, "finish");
        BaseViewModel.l(this, new a(name, finish, null), null, null, null, null, null, 62, null);
    }
}
