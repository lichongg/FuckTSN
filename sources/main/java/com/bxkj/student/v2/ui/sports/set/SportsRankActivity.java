package com.bxkj.student.v2.ui.sports.set;

import androidx.lifecycle.Observer;
import com.bxkj.base.v2.base.BaseActivity;
import com.bxkj.student.databinding.AcV2SportsRankBinding;
import com.bxkj.student.v2.vm.sports.set.SportsRankVM;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.g0;
import kotlin.n;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class SportsRankActivity extends BaseActivity<AcV2SportsRankBinding, SportsRankVM> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a implements Observer, b0 {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f21528a;

        a(Function1 function) {
            g0.p(function, "function");
            this.f21528a = function;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof b0)) {
                return g0.g(getFunctionDelegate(), ((b0) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.b0
        @NotNull
        public final n<?> getFunctionDelegate() {
            return this.f21528a;
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21528a.invoke(obj);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 f(SportsRankActivity sportsRankActivity, Map map) {
        sportsRankActivity.L().setDataMap(map);
        return n1.f44123a;
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
        D().t().observe(r(), new a(new Function1() { // from class: com.bxkj.student.v2.ui.sports.set.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 f6;
                f6 = SportsRankActivity.f(SportsRankActivity.this, (Map) obj);
                return f6;
            }
        }));
    }

    @Override // com.bxkj.base.v2.base.a
    public void t() {
        L().setMActvity(this);
        D().u();
    }
}
