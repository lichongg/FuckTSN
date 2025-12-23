package com.bxkj.student.v2.vm.sports.set;

import androidx.lifecycle.MutableLiveData;
import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.student.v2.repository.c;
import com.bxkj.student.v2.repository.sports.h;
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
public final class SportsStatisticsVM extends BaseViewModel {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private final s f22755h = t.c(new Function0() { // from class: com.bxkj.student.v2.vm.sports.set.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            c A;
            A = SportsStatisticsVM.A();
            return A;
        }
    });

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private MutableLiveData<Map<String, Object>> f22756i = new MutableLiveData<>();

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private MutableLiveData<Map<String, Object>> f22757j = new MutableLiveData<>();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.set.SportsStatisticsVM$getLoginUserInfo$1", f = "SportsStatisticsVM.kt", i = {}, l = {31}, m = "invokeSuspend", n = {}, s = {})
    @SourceDebugExtension({"SMAP\nSportsStatisticsVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SportsStatisticsVM.kt\ncom/bxkj/student/v2/vm/sports/set/SportsStatisticsVM$getLoginUserInfo$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,36:1\n1#2:37\n*E\n"})
    static final class a extends SuspendLambda implements Function1<e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22758a;

        a(e<? super a> eVar) {
            super(1, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final e<n1> create(e<?> eVar) {
            return SportsStatisticsVM.this.new a(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(e<? super n1> eVar) {
            return ((a) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22758a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                c x5 = SportsStatisticsVM.this.x();
                this.f22758a = 1;
                obj = x5.g(this);
                if (obj == l6) {
                    return l6;
                }
            }
            Map<String, Object> map = (Map) obj;
            if (map != null) {
                SportsStatisticsVM.this.z().postValue(map);
            }
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.set.SportsStatisticsVM$getSportsStatistics$1", f = "SportsStatisticsVM.kt", i = {}, l = {20}, m = "invokeSuspend", n = {}, s = {})
    static final class b extends SuspendLambda implements Function1<e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22760a;

        b(e<? super b> eVar) {
            super(1, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final e<n1> create(e<?> eVar) {
            return SportsStatisticsVM.this.new b(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(e<? super n1> eVar) {
            return ((b) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22760a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                h hVar = new h();
                this.f22760a = 1;
                obj = hVar.a(this);
                if (obj == l6) {
                    return l6;
                }
            }
            Map<String, Object> map = (Map) obj;
            if (map != null) {
                SportsStatisticsVM.this.v().postValue(map);
            }
            return n1.f44123a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final c A() {
        return new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final c x() {
        return (c) this.f22755h.getValue();
    }

    public final void B(@NotNull MutableLiveData<Map<String, Object>> mutableLiveData) {
        kotlin.jvm.internal.g0.p(mutableLiveData, "<set-?>");
        this.f22757j = mutableLiveData;
    }

    public final void C(@NotNull MutableLiveData<Map<String, Object>> mutableLiveData) {
        kotlin.jvm.internal.g0.p(mutableLiveData, "<set-?>");
        this.f22756i = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<Map<String, Object>> v() {
        return this.f22757j;
    }

    public final void w() {
        BaseViewModel.j(this, new a(null), null, null, null, null, null, null, null, 254, null);
    }

    public final void y() {
        BaseViewModel.j(this, new b(null), null, null, null, null, null, null, null, 254, null);
    }

    @NotNull
    public final MutableLiveData<Map<String, Object>> z() {
        return this.f22756i;
    }
}
