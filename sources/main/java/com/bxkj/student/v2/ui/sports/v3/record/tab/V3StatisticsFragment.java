package com.bxkj.student.v2.ui.sports.v3.record.tab;

import android.content.Context;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import cn.bluemobi.dylan.base.utils.u;
import com.bxkj.base.v2.base.BaseFragment;
import com.bxkj.base.v2.common.utils.c0;
import com.bxkj.base.v2.data.b;
import com.bxkj.student.R;
import com.bxkj.student.databinding.FmV3RecordListTotalBinding;
import com.bxkj.student.v2.ui.sports.set.statistics.tab.StatisticsFragment;
import com.bxkj.student.v2.vm.sports.set.SportsStatisticsVM;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartModel;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartType;
import com.github.aachartmodel.aainfographics.aachartcreator.AASeriesElement;
import com.github.aachartmodel.aainfographics.aatools.AAColorKt;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.f0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nV3StatisticsFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 V3StatisticsFragment.kt\ncom/bxkj/student/v2/ui/sports/v3/record/tab/V3StatisticsFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,202:1\n1878#2,3:203\n1878#2,3:206\n1878#2,3:209\n37#3,2:212\n37#3,2:214\n*S KotlinDebug\n*F\n+ 1 V3StatisticsFragment.kt\ncom/bxkj/student/v2/ui/sports/v3/record/tab/V3StatisticsFragment\n*L\n131#1:203,3\n148#1:206,3\n165#1:209,3\n185#1:212,2\n195#1:214,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class V3StatisticsFragment extends BaseFragment<FmV3RecordListTotalBinding, SportsStatisticsVM> {

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    private List<Double> f21867l = f0.J();

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private List<String> f21868m = new ArrayList();

    /* renamed from: n, reason: collision with root package name */
    @Nullable
    private StatisticsFragment f21869n;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements TabLayout.OnTabSelectedListener {
        a() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            Map<String, Object> value = V3StatisticsFragment.this.D().v().getValue();
            if (value != null) {
                V3StatisticsFragment v3StatisticsFragment = V3StatisticsFragment.this;
                if (tab != null) {
                    v3StatisticsFragment.j(tab.getPosition(), value);
                }
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b implements Observer, b0 {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f21871a;

        b(Function1 function) {
            g0.p(function, "function");
            this.f21871a = function;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof b0)) {
                return g0.g(getFunctionDelegate(), ((b0) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.b0
        @NotNull
        public final kotlin.n<?> getFunctionDelegate() {
            return this.f21871a;
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21871a.invoke(obj);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(int i6, Map<String, Object> map) {
        this.f21868m.clear();
        int i7 = 0;
        if (i6 == 0) {
            TextView textView = L().tvDay;
            c0 c0Var = c0.f16887a;
            textView.setText(c0Var.t(map, "weekDay"));
            TextView textView2 = L().tvAvgDistance;
            com.bxkj.base.v2.common.utils.h hVar = com.bxkj.base.v2.common.utils.h.f16899a;
            textView2.setText(hVar.a(c0Var.f(map, "weekAvgRange")));
            L().tvAvgCount.setText(c0Var.t(map, "weekAvgCount"));
            L().tvAvgTime.setText(c0Var.t(map, "weekAvgTime"));
            L().tvDistance.setText(hVar.a(c0Var.f(map, "weekTotalMileage")));
            L().tvCount.setText(c0Var.t(map, "weekNum"));
            L().tvTime.setText(c0Var.t(map, "weekTime"));
            L().tvHeart.setText(c0Var.t(map, "weekCalorie"));
            L().tvPace.setText(c0Var.t(map, "weekAvgSpeed"));
            L().tvStep.setText(c0Var.t(map, "weekAvgstep"));
            L().tvStepDistance.setText(c0Var.t(map, "weekStride"));
            List<Double> h6 = c0Var.h(map, "week");
            this.f21867l = h6;
            for (Object obj : h6) {
                int i8 = i7 + 1;
                if (i7 < 0) {
                    f0.b0();
                }
                ((Number) obj).doubleValue();
                List<String> list = this.f21868m;
                String n6 = u.n(i8);
                g0.o(n6, "changeWeekToHanzi(...)");
                list.add(n6);
                i7 = i8;
            }
        } else if (i6 != 1) {
            TextView textView3 = L().tvDay;
            c0 c0Var2 = c0.f16887a;
            textView3.setText(c0Var2.t(map, "sysTermDay"));
            TextView textView4 = L().tvAvgDistance;
            com.bxkj.base.v2.common.utils.h hVar2 = com.bxkj.base.v2.common.utils.h.f16899a;
            textView4.setText(hVar2.a(c0Var2.f(map, "sysTermAvgRange")));
            L().tvAvgCount.setText(c0Var2.t(map, "sysTermAvgCount"));
            L().tvAvgTime.setText(c0Var2.t(map, "sysTermAvgTime"));
            L().tvDistance.setText(hVar2.a(c0Var2.f(map, "sysTermTotalMileage")));
            L().tvCount.setText(c0Var2.t(map, "sysTermNum"));
            L().tvTime.setText(c0Var2.t(map, "sysTermTime"));
            L().tvPace.setText(c0Var2.t(map, "sysTermAvgSpeed"));
            L().tvHeart.setText(c0Var2.t(map, "sysTermCalorie"));
            L().tvStep.setText(c0Var2.t(map, "sysTermAvgstep"));
            L().tvStepDistance.setText(c0Var2.t(map, "sysTermStride"));
            List<Double> h7 = c0Var2.h(map, "sysTerm");
            this.f21867l = h7;
            for (Object obj2 : h7) {
                int i9 = i7 + 1;
                if (i7 < 0) {
                    f0.b0();
                }
                ((Number) obj2).doubleValue();
                this.f21868m.add(i9 + "周");
                i7 = i9;
            }
        } else {
            TextView textView5 = L().tvDay;
            c0 c0Var3 = c0.f16887a;
            textView5.setText(c0Var3.t(map, "monthDay"));
            TextView textView6 = L().tvAvgDistance;
            com.bxkj.base.v2.common.utils.h hVar3 = com.bxkj.base.v2.common.utils.h.f16899a;
            textView6.setText(hVar3.a(c0Var3.f(map, "monthAvgRange")));
            L().tvAvgCount.setText(c0Var3.t(map, "monthAvgCount"));
            L().tvAvgTime.setText(c0Var3.t(map, "monthAvgTime"));
            L().tvDistance.setText(hVar3.a(c0Var3.f(map, "monthTotalMileage")));
            L().tvCount.setText(c0Var3.t(map, "monthNum"));
            L().tvTime.setText(c0Var3.t(map, "monthTime"));
            L().tvPace.setText(c0Var3.t(map, "monthAvgSpeed"));
            L().tvHeart.setText(c0Var3.t(map, "monthCalorie"));
            L().tvStep.setText(c0Var3.t(map, "monthAvgstep"));
            L().tvStepDistance.setText(c0Var3.t(map, "monthStride"));
            List<Double> h8 = c0Var3.h(map, "month");
            this.f21867l = h8;
            for (Object obj3 : h8) {
                int i10 = i7 + 1;
                if (i7 < 0) {
                    f0.b0();
                }
                ((Number) obj3).doubleValue();
                this.f21868m.add(i10 + "日");
                i7 = i10;
            }
        }
        StatisticsFragment statisticsFragment = this.f21869n;
        if (statisticsFragment != null) {
            statisticsFragment.h(i6 + 1, map);
        }
    }

    private final void k() {
        AAChartModel yAxisTitle = new AAChartModel(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 4095, null).chartType(AAChartType.Column).title("").subtitle("").yAxisTitle("");
        Boolean bool = Boolean.FALSE;
        AAChartModel dataLabelsEnabled = yAxisTitle.dataLabelsEnabled(bool);
        Boolean bool2 = Boolean.TRUE;
        L().AAChartView.aa_drawChartWithChartModel(dataLabelsEnabled.yAxisLabelsEnabled(bool2).xAxisLabelsEnabled(bool2).legendEnabled(bool).tooltipEnabled(bool).yAxisGridLineWidth(0).categories((String[]) this.f21868m.toArray(new String[0])).yAxisVisible(bool2).series(new Object[]{new AASeriesElement().name("").lineWidth(0).enableMouseTracking(bool2).borderRadius(Float.valueOf(8.0f)).color(AAColorKt.AARgba(0, 203, MediaPlayer.MEDIA_PLAYER_OPTION_SET_MAX_FPS, 1.0f)).data(this.f21867l.toArray(new Object[0]))}));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 h(V3StatisticsFragment v3StatisticsFragment, Map map) {
        int selectedTabPosition = v3StatisticsFragment.L().tbType.getSelectedTabPosition();
        g0.m(map);
        v3StatisticsFragment.j(selectedTabPosition, map);
        if (map.containsKey("qualifyTotalRangeSunRun")) {
            v3StatisticsFragment.L().cardSunRun.setVisibility(0);
            TextView textView = v3StatisticsFragment.L().tvYxlc;
            com.bxkj.base.v2.common.utils.h hVar = com.bxkj.base.v2.common.utils.h.f16899a;
            c0 c0Var = c0.f16887a;
            textView.setText(hVar.a(c0Var.f(map, "totalRangeZongSunRun")));
            v3StatisticsFragment.L().tvDblc.setText(c0Var.t(map, "qualifyTotalRangeSunRun"));
            v3StatisticsFragment.L().tvSylc.setText(c0Var.t(map, "leaveTotalRangeZongSunRun"));
            double d6 = 1000;
            v3StatisticsFragment.L().pbDistance.setMax((int) (c0Var.f(map, "qualifyTotalRangeSunRun") * d6));
            v3StatisticsFragment.L().pbDistance.setProgress((int) (c0Var.f(map, "totalRangeZongSunRun") * d6));
            v3StatisticsFragment.L().tvYxcs.setText(c0Var.t(map, "totalCountZongSunRun"));
            v3StatisticsFragment.L().tvDbcs.setText(c0Var.t(map, "qualifyTotalCountSunRun"));
            v3StatisticsFragment.L().tvSycs.setText(c0Var.t(map, "leaveTotalCountZongSunRun"));
            v3StatisticsFragment.L().pbCount.setMax(c0Var.k(map, "qualifyTotalCountSunRun"));
            v3StatisticsFragment.L().pbCount.setProgress(c0Var.k(map, "totalCountZongSunRun"));
        } else {
            v3StatisticsFragment.L().cardSunRun.setVisibility(8);
        }
        if (map.containsKey("qualifyTotalRangeMorningRun")) {
            v3StatisticsFragment.L().cardMorningRun.setVisibility(0);
            TextView textView2 = v3StatisticsFragment.L().tvYxlcMorning;
            com.bxkj.base.v2.common.utils.h hVar2 = com.bxkj.base.v2.common.utils.h.f16899a;
            c0 c0Var2 = c0.f16887a;
            textView2.setText(hVar2.a(c0Var2.f(map, "totalRangeZongMorningRun")));
            v3StatisticsFragment.L().tvDblcMorning.setText(c0Var2.t(map, "qualifyTotalRangeMorningRun"));
            v3StatisticsFragment.L().tvSylcMorning.setText(c0Var2.t(map, "leaveTotalRangeZongMorningRun"));
            double d7 = 1000;
            v3StatisticsFragment.L().pbDistanceMorning.setMax((int) (c0Var2.f(map, "qualifyTotalRangeMorningRun") * d7));
            v3StatisticsFragment.L().pbDistanceMorning.setProgress((int) (c0Var2.f(map, "totalRangeZongMorningRun") * d7));
            v3StatisticsFragment.L().tvYxcsMorning.setText(c0Var2.t(map, "totalCountZongMorningRun"));
            v3StatisticsFragment.L().tvDbcsMorning.setText(c0Var2.t(map, "qualifyTotalCountMorningRun"));
            v3StatisticsFragment.L().tvSycsMorning.setText(c0Var2.t(map, "leaveTotalCountZongMorningRun"));
            v3StatisticsFragment.L().pbCountMorning.setMax(c0Var2.k(map, "qualifyTotalCountMorningRun"));
            v3StatisticsFragment.L().pbCountMorning.setProgress(c0Var2.k(map, "totalCountZongMorningRun"));
        } else {
            v3StatisticsFragment.L().cardMorningRun.setVisibility(8);
        }
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 i(V3StatisticsFragment v3StatisticsFragment, Map map) {
        Context H = v3StatisticsFragment.H();
        c0 c0Var = c0.f16887a;
        cn.bluemobi.dylan.base.utils.o.f(H, c0Var.t(map, "imageRouteUrl"), v3StatisticsFragment.L().ivHead, R.mipmap.v3_head_icon, R.mipmap.v3_head_icon);
        b.a aVar = com.bxkj.base.v2.data.b.f16998d;
        aVar.a().X0(c0Var.t(map, "nickName"));
        v3StatisticsFragment.L().tvName.setText(aVar.a().U());
        v3StatisticsFragment.L().tvAccount.setText(aVar.a().S());
        return n1.f44123a;
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
        Fragment findFragmentById = getChildFragmentManager().findFragmentById(R.id.fm_chat);
        g0.n(findFragmentById, "null cannot be cast to non-null type com.bxkj.student.v2.ui.sports.set.statistics.tab.StatisticsFragment");
        this.f21869n = (StatisticsFragment) findFragmentById;
        L().tbType.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new a());
        D().v().observe(r(), new b(new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.record.tab.n
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 h6;
                h6 = V3StatisticsFragment.h(V3StatisticsFragment.this, (Map) obj);
                return h6;
            }
        }));
        D().z().observe(requireActivity(), new b(new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.record.tab.o
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 i6;
                i6 = V3StatisticsFragment.i(V3StatisticsFragment.this, (Map) obj);
                return i6;
            }
        }));
    }

    @Override // com.bxkj.base.v2.base.a
    public void t() {
        D().w();
        D().y();
    }
}
