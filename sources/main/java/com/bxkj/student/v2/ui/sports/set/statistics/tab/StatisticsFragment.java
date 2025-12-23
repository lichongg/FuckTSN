package com.bxkj.student.v2.ui.sports.set.statistics.tab;

import android.graphics.Matrix;
import androidx.core.content.ContextCompat;
import cn.bluemobi.dylan.base.utils.u;
import com.bxkj.base.v2.base.BaseFragment;
import com.bxkj.student.databinding.FmV2SportsStatisticsBinding;
import com.bxkj.student.v2.common.view.CustomBarChart;
import com.bxkj.student.v2.vm.sports.set.SportsStatisticsVM;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.u0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class StatisticsFragment extends BaseFragment<FmV2SportsStatisticsBinding, SportsStatisticsVM> {

    /* renamed from: l, reason: collision with root package name */
    private BarChart f21534l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    private List<Float> f21535m;

    /* renamed from: n, reason: collision with root package name */
    private final float f21536n = 0.13333334f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a extends ValueFormatter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f21537a;

        @Override // com.github.mikephil.charting.formatter.ValueFormatter
        public String getFormattedValue(float f6) {
            int i6 = (int) f6;
            int i7 = this.f21537a;
            if (i7 == 1) {
                String n6 = u.n(i6);
                g0.m(n6);
                return n6;
            }
            if (i7 == 2) {
                return i6 + "日";
            }
            if (i7 != 3) {
                StringBuilder sb = new StringBuilder();
                sb.append(i6);
                return sb.toString();
            }
            return i6 + "周";
        }

        a(int i6) {
            this.f21537a = i6;
        }
    }

    private final float f(int i6) {
        return i6 * this.f21536n;
    }

    private final void e() {
        Description description = new Description();
        description.setText("");
        BarChart barChart = this.f21534l;
        BarChart barChart2 = null;
        if (barChart == null) {
            g0.S("barChart");
            barChart = null;
        }
        barChart.setDescription(description);
        BarChart barChart3 = this.f21534l;
        if (barChart3 == null) {
            g0.S("barChart");
            barChart3 = null;
        }
        barChart3.setNoDataText("暂无数据");
        BarChart barChart4 = this.f21534l;
        if (barChart4 == null) {
            g0.S("barChart");
            barChart4 = null;
        }
        barChart4.getAxisLeft().setAxisMinimum(0.0f);
        BarChart barChart5 = this.f21534l;
        if (barChart5 == null) {
            g0.S("barChart");
            barChart5 = null;
        }
        barChart5.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        BarChart barChart6 = this.f21534l;
        if (barChart6 == null) {
            g0.S("barChart");
            barChart6 = null;
        }
        barChart6.getXAxis().setDrawGridLines(false);
        BarChart barChart7 = this.f21534l;
        if (barChart7 == null) {
            g0.S("barChart");
            barChart7 = null;
        }
        barChart7.getAxisRight().setEnabled(false);
        BarChart barChart8 = this.f21534l;
        if (barChart8 == null) {
            g0.S("barChart");
            barChart8 = null;
        }
        barChart8.getAxisLeft().setDrawGridLines(false);
        BarChart barChart9 = this.f21534l;
        if (barChart9 == null) {
            g0.S("barChart");
            barChart9 = null;
        }
        barChart9.getAxisRight().setDrawGridLines(false);
        BarChart barChart10 = this.f21534l;
        if (barChart10 == null) {
            g0.S("barChart");
            barChart10 = null;
        }
        barChart10.getXAxis().setDrawGridLines(false);
        BarChart barChart11 = this.f21534l;
        if (barChart11 == null) {
            g0.S("barChart");
            barChart11 = null;
        }
        barChart11.dispatchSetSelected(false);
        BarChart barChart12 = this.f21534l;
        if (barChart12 == null) {
            g0.S("barChart");
            barChart12 = null;
        }
        barChart12.getLegend().setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        BarChart barChart13 = this.f21534l;
        if (barChart13 == null) {
            g0.S("barChart");
            barChart13 = null;
        }
        barChart13.getLegend().setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        BarChart barChart14 = this.f21534l;
        if (barChart14 == null) {
            g0.S("barChart");
            barChart14 = null;
        }
        barChart14.setTouchEnabled(true);
        Matrix matrix = new Matrix();
        List<Float> list = this.f21535m;
        g0.m(list);
        matrix.postScale(f(list.size()), 1.0f);
        BarChart barChart15 = this.f21534l;
        if (barChart15 == null) {
            g0.S("barChart");
            barChart15 = null;
        }
        ViewPortHandler viewPortHandler = barChart15.getViewPortHandler();
        BarChart barChart16 = this.f21534l;
        if (barChart16 == null) {
            g0.S("barChart");
            barChart16 = null;
        }
        viewPortHandler.refresh(matrix, barChart16, false);
        BarChart barChart17 = this.f21534l;
        if (barChart17 == null) {
            g0.S("barChart");
            barChart17 = null;
        }
        barChart17.setPinchZoom(false);
        BarChart barChart18 = this.f21534l;
        if (barChart18 == null) {
            g0.S("barChart");
        } else {
            barChart2 = barChart18;
        }
        barChart2.setDoubleTapToZoomEnabled(false);
    }

    private final void g(int i6) {
        ArrayList arrayList = new ArrayList();
        List<Float> list = this.f21535m;
        g0.m(list);
        int size = list.size();
        for (int i7 = 0; i7 < size; i7++) {
            List<Float> list2 = this.f21535m;
            g0.m(list2);
            arrayList.add(new BarEntry(i7 + 1.0f, list2.get(i7).floatValue()));
        }
        BarDataSet barDataSet = new BarDataSet(arrayList, "里程(KM)");
        barDataSet.setColor(ContextCompat.getColor(H(), 2131100565));
        barDataSet.setBarBorderColor(ContextCompat.getColor(H(), 2131099737));
        barDataSet.setDrawValues(false);
        barDataSet.setHighLightAlpha(37);
        BarChart barChart = this.f21534l;
        BarChart barChart2 = null;
        if (barChart == null) {
            g0.S("barChart");
            barChart = null;
        }
        XAxis xAxis = barChart.getXAxis();
        g0.o(xAxis, "getXAxis(...)");
        xAxis.setGranularity(1.0f);
        xAxis.setValueFormatter(new a(i6));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(barDataSet);
        BarData barData = new BarData(arrayList2);
        barData.setBarWidth(0.2f);
        BarChart barChart3 = this.f21534l;
        if (barChart3 == null) {
            g0.S("barChart");
        } else {
            barChart2 = barChart3;
        }
        barChart2.setData(barData);
    }

    public final void h(int i6, @NotNull Map<String, Object> it) {
        g0.p(it, "it");
        if (i6 == 1) {
            Object obj = it.get("week");
            if (obj instanceof List) {
                this.f21535m = u0.g(obj);
            }
        } else if (i6 == 2) {
            Object obj2 = it.get("month");
            if (obj2 instanceof List) {
                this.f21535m = u0.g(obj2);
            }
        } else if (i6 == 3) {
            Object obj3 = it.get("sysTerm");
            if (obj3 instanceof List) {
                this.f21535m = u0.g(obj3);
            }
        }
        e();
        g(i6);
        BarChart barChart = this.f21534l;
        if (barChart == null) {
            g0.S("barChart");
            barChart = null;
        }
        barChart.animateY(1000);
    }

    @Override // com.bxkj.base.v2.base.a
    public void t() {
        CustomBarChart barChart = L().barChart;
        g0.o(barChart, "barChart");
        this.f21534l = barChart;
        if (barChart == null) {
            g0.S("barChart");
            barChart = null;
        }
        barChart.setNoDataText("暂无数据");
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
    }
}
