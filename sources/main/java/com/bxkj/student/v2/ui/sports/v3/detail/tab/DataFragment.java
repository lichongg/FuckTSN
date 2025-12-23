package com.bxkj.student.v2.ui.sports.v3.detail.tab;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import cn.bluemobi.dylan.base.utils.o;
import com.bxkj.base.v2.base.BaseFragment;
import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.base.v2.common.utils.c0;
import com.bxkj.base.v2.data.b;
import com.bxkj.student.R;
import com.bxkj.student.databinding.V3FmDataBinding;
import com.bxkj.student.v2.common.utils.r;
import com.bxkj.student.v2.ui.sports.v3.detail.V3RecordDetailActivity;
import com.bxkj.student.v2.vm.sports.record.RecordDetailVM;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
public final class DataFragment extends BaseFragment<V3FmDataBinding, RecordDetailVM> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a implements Observer, b0 {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f21621a;

        a(Function1 function) {
            g0.p(function, "function");
            this.f21621a = function;
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
            return this.f21621a;
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21621a.invoke(obj);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }
    }

    @NotNull
    public final Bitmap g() {
        r rVar = r.f20922a;
        Context H = H();
        ConstraintLayout clRoot = L().clRoot;
        g0.o(clRoot, "clRoot");
        return rVar.a(H, clRoot);
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
        FragmentActivity requireActivity = requireActivity();
        g0.o(requireActivity, "requireActivity(...)");
        x((BaseViewModel) new ViewModelProvider(requireActivity).get(RecordDetailVM.class));
        V3FmDataBinding L = L();
        FragmentActivity r5 = r();
        g0.n(r5, "null cannot be cast to non-null type com.bxkj.student.v2.ui.sports.v3.detail.V3RecordDetailActivity");
        L.setMActivity((V3RecordDetailActivity) r5);
        D().w().observe(requireActivity(), new a(new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.detail.tab.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 h6;
                h6 = DataFragment.h(DataFragment.this, (Map) obj);
                return h6;
            }
        }));
        D().F().observe(requireActivity(), new a(new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.detail.tab.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 i6;
                i6 = DataFragment.i(DataFragment.this, (Map) obj);
                return i6;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 h(DataFragment dataFragment, Map map) {
        dataFragment.L().setMap(map);
        TextView textView = dataFragment.L().tvYxlc;
        com.bxkj.base.v2.common.utils.h hVar = com.bxkj.base.v2.common.utils.h.f16899a;
        c0 c0Var = c0.f16887a;
        textView.setText(hVar.a(c0Var.f(map, "totalRangeZong")));
        dataFragment.L().tvDblc.setText(c0Var.t(map, "qualifyTotalRange"));
        dataFragment.L().tvSylc.setText(c0Var.t(map, "leaveTotalRangeZong"));
        double d6 = 1000;
        dataFragment.L().pbDistance.setMax((int) (c0Var.f(map, "qualifyTotalRange") * d6));
        dataFragment.L().pbDistance.setProgress((int) (c0Var.f(map, "totalRangeZong") * d6));
        dataFragment.L().tvYxcs.setText(c0Var.t(map, "totalCountZong"));
        dataFragment.L().tvDbcs.setText(c0Var.t(map, "qualifyTotalCount"));
        dataFragment.L().tvSycs.setText(c0Var.t(map, "leaveTotalCountZong"));
        dataFragment.L().pbCount.setMax(c0Var.k(map, "qualifyTotalCount"));
        dataFragment.L().pbCount.setProgress(c0Var.k(map, "totalCountZong"));
        TextView textView2 = dataFragment.L().tvLjsc;
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(c0Var.f(map, "totalTimeZong")));
        BigDecimal bigDecimal2 = new BigDecimal(60);
        RoundingMode roundingMode = RoundingMode.HALF_EVEN;
        BigDecimal divide = bigDecimal.divide(bigDecimal2, roundingMode);
        g0.o(divide, "divide(...)");
        BigDecimal divide2 = divide.divide(new BigDecimal(60), roundingMode);
        g0.o(divide2, "divide(...)");
        textView2.setText(String.valueOf(divide2.setScale(2).doubleValue()));
        dataFragment.L().tvPbts.setText(c0Var.t(map, "totalDay"));
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 i(DataFragment dataFragment, Map map) {
        Context H = dataFragment.H();
        c0 c0Var = c0.f16887a;
        o.f(H, c0Var.t(map, "imageRouteUrl"), dataFragment.L().ivHead, R.mipmap.v3_head_icon, R.mipmap.v3_head_icon);
        b.a aVar = com.bxkj.base.v2.data.b.f16998d;
        aVar.a().X0(c0Var.t(map, "nickName"));
        dataFragment.L().tvName.setText(aVar.a().U());
        dataFragment.L().tvAccount.setText(aVar.a().S());
        return n1.f44123a;
    }

    @Override // com.bxkj.base.v2.base.a
    public void t() {
    }
}
