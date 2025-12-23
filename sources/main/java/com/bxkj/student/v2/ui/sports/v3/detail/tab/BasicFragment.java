package com.bxkj.student.v2.ui.sports.v3.detail.tab;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
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
import com.bxkj.student.databinding.V3FmBasicBinding;
import com.bxkj.student.v2.common.utils.r;
import com.bxkj.student.v2.common.view.TrackProgressView;
import com.bxkj.student.v2.ui.sports.v3.detail.V3RecordDetailActivity;
import com.bxkj.student.v2.vm.sports.record.RecordDetailVM;
import com.google.android.material.card.MaterialCardView;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.g0;
import kotlin.n;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nBasicFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BasicFragment.kt\ncom/bxkj/student/v2/ui/sports/v3/detail/tab/BasicFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,105:1\n1#2:106\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class BasicFragment extends BaseFragment<V3FmBasicBinding, RecordDetailVM> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a implements Observer, b0 {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f21620a;

        a(Function1 function) {
            g0.p(function, "function");
            this.f21620a = function;
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
            return this.f21620a;
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21620a.invoke(obj);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }
    }

    private final void j() {
        FragmentActivity requireActivity = requireActivity();
        g0.o(requireActivity, "requireActivity(...)");
        x((BaseViewModel) new ViewModelProvider(requireActivity).get(RecordDetailVM.class));
        V3FmBasicBinding L = L();
        FragmentActivity r5 = r();
        g0.n(r5, "null cannot be cast to non-null type com.bxkj.student.v2.ui.sports.v3.detail.V3RecordDetailActivity");
        L.setMActivity((V3RecordDetailActivity) r5);
        D().w().observe(requireActivity(), new a(new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.detail.tab.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 k6;
                k6 = BasicFragment.k(BasicFragment.this, (Map) obj);
                return k6;
            }
        }));
        D().F().observe(requireActivity(), new a(new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.detail.tab.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 l6;
                l6 = BasicFragment.l(BasicFragment.this, (Map) obj);
                return l6;
            }
        }));
    }

    @NotNull
    public final Bitmap h() {
        r rVar = r.f20922a;
        Context H = H();
        ConstraintLayout clRoot = L().clRoot;
        g0.o(clRoot, "clRoot");
        return rVar.a(H, clRoot);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(BasicFragment basicFragment) {
        basicFragment.getChildFragmentManager().beginTransaction().add(2131298030, new V3RecordChartFragment()).commitAllowingStateLoss();
        basicFragment.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 k(BasicFragment basicFragment, Map map) {
        Map map2;
        Map map3;
        basicFragment.L().setMap(map);
        int i6 = 8;
        if (TextUtils.isEmpty(basicFragment.D().z())) {
            basicFragment.L().card2.setVisibility(8);
            basicFragment.L().card3.setVisibility(8);
        } else {
            TextView textView = basicFragment.L().tvResult;
            c0 c0Var = c0.f16887a;
            textView.setText("NO." + c0Var.t(map, "exerciseStatistics"));
            basicFragment.L().tvRank.setText(com.bxkj.base.v2.common.utils.h.f16899a.a(c0Var.f(map, "totalRange")));
            basicFragment.L().card2.setVisibility(0);
            basicFragment.L().tvCj.setText(c0Var.t(map, "recordBreaking"));
            MaterialCardView materialCardView = basicFragment.L().card3;
            if (c0Var.d(map, "isMax")) {
                i6 = 0;
            }
            materialCardView.setVisibility(i6);
        }
        TrackProgressView trackProgressView = basicFragment.L().tpStep;
        c0 c0Var2 = c0.f16887a;
        trackProgressView.setMaxProgress(c0Var2.k(map, "stepSetting"));
        basicFragment.L().tpStep.setProgress(com.bxkj.student.run.app.utils.i.t(c0Var2.t(map, "stepNumbers")));
        if (map != null) {
            if (c0Var2.k(map, "stepSetting") == 0) {
                map3 = map;
            } else {
                map3 = null;
            }
            if (map3 != null) {
                basicFragment.L().tpStep.setMaxProgress(100);
                basicFragment.L().tpStep.setProgress(100);
            }
        }
        double d6 = 1000;
        basicFragment.L().tpDistance.setMaxProgress((int) (c0Var2.f(map, "rangeSetting") * d6));
        basicFragment.L().tpDistance.setProgress((int) (c0Var2.f(map, "sportRange") * d6));
        if (map != null) {
            if (((int) (c0Var2.f(map, "rangeSetting") * d6)) == 0) {
                map2 = map;
            } else {
                map2 = null;
            }
            if (map2 != null) {
                basicFragment.L().tpDistance.setMaxProgress(100);
                basicFragment.L().tpDistance.setProgress(100);
            }
        }
        basicFragment.L().tpTime.setMaxProgress(c0Var2.k(map, "startQualifiedTimeSetting") * 60);
        basicFragment.L().tpTime.setProgress(c0Var2.k(map, "sportTime"));
        if (c0Var2.k(map, "sportTime") > c0Var2.k(map, "endQualifiedTimeSetting") * 60) {
            basicFragment.L().tpTime.setProgress(0);
        }
        if (map != null) {
            if (c0Var2.k(map, "startQualifiedTimeSetting") != 0) {
                map = null;
            }
            if (map != null) {
                basicFragment.L().tpTime.setMaxProgress(100);
                basicFragment.L().tpTime.setProgress(100);
            }
        }
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 l(BasicFragment basicFragment, Map map) {
        Context H = basicFragment.H();
        c0 c0Var = c0.f16887a;
        o.f(H, c0Var.t(map, "imageRouteUrl"), basicFragment.L().ivHead, R.mipmap.v3_head_icon, R.mipmap.v3_head_icon);
        b.a aVar = com.bxkj.base.v2.data.b.f16998d;
        aVar.a().X0(c0Var.t(map, "nickName"));
        basicFragment.L().tvName.setText(aVar.a().U());
        basicFragment.L().tvAccount.setText(aVar.a().S());
        return n1.f44123a;
    }

    @Override // com.bxkj.base.v2.base.a
    public void t() {
        r().getWindow().getDecorView().post(new Runnable() { // from class: com.bxkj.student.v2.ui.sports.v3.detail.tab.a
            @Override // java.lang.Runnable
            public final void run() {
                BasicFragment.i(BasicFragment.this);
            }
        });
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
    }
}
