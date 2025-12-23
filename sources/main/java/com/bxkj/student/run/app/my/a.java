package com.bxkj.student.run.app.my;

import androidx.core.internal.view.SupportMenu;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    private static final String f19895c = "BarChartUtils";

    /* renamed from: a, reason: collision with root package name */
    private BarChart f19896a;

    /* renamed from: b, reason: collision with root package name */
    private XAxis f19897b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.bxkj.student.run.app.my.a$a, reason: collision with other inner class name */
    class C0267a implements OnChartValueSelectedListener {
        C0267a() {
        }

        @Override // com.github.mikephil.charting.listener.OnChartValueSelectedListener
        public void onValueSelected(Entry e6, Highlight h6) {
            e6.getX();
        }

        @Override // com.github.mikephil.charting.listener.OnChartValueSelectedListener
        public void onNothingSelected() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends ValueFormatter {
        @Override // com.github.mikephil.charting.formatter.ValueFormatter, com.github.mikephil.charting.formatter.IAxisValueFormatter
        public String getFormattedValue(float value, AxisBase axis) {
            int i6 = (int) value;
            if (i6 == 0) {
                return "";
            }
            return i6 + "%";
        }

        b() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends ValueFormatter {
        @Override // com.github.mikephil.charting.formatter.ValueFormatter, com.github.mikephil.charting.formatter.IAxisValueFormatter
        public String getFormattedValue(float value, AxisBase axis) {
            int i6 = (int) value;
            if (i6 == 0) {
                return "";
            }
            return i6 + "%";
        }

        c() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d extends ValueFormatter {

        /* renamed from: a, reason: collision with root package name */
        private ArrayList<String> f19901a;

        @Override // com.github.mikephil.charting.formatter.ValueFormatter, com.github.mikephil.charting.formatter.IAxisValueFormatter
        public String getFormattedValue(float value, AxisBase axis) {
            int i6 = (int) value;
            return i6 < this.f19901a.size() ? this.f19901a.get(i6) : "";
        }

        public d(ArrayList<String> list) {
            this.f19901a = list;
        }
    }

    private void a() {
        this.f19896a.setDrawGridBackground(false);
        this.f19896a.setTouchEnabled(true);
        this.f19896a.setDragEnabled(true);
        this.f19896a.setScaleEnabled(true);
        this.f19896a.getDescription().setText("");
        this.f19896a.setDrawBorders(false);
        this.f19896a.setExtraBottomOffset(10.0f);
        this.f19896a.setDrawValueAboveBar(true);
        this.f19896a.setDrawBarShadow(false);
        Legend legend = this.f19896a.getLegend();
        legend.setEnabled(true);
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        legend.setDrawInside(false);
        this.f19896a.setPinchZoom(true);
        this.f19896a.setOnChartValueSelectedListener(new C0267a());
        XAxis xAxis = this.f19896a.getXAxis();
        this.f19897b = xAxis;
        xAxis.setDrawAxisLine(true);
        this.f19897b.setDrawGridLines(false);
        this.f19897b.setGranularity(1.0f);
        this.f19897b.setCenterAxisLabels(true);
        this.f19897b.setPosition(XAxis.XAxisPosition.BOTTOM);
        this.f19897b.setTextColor(SupportMenu.CATEGORY_MASK);
    }

    private void b() {
        YAxis axisLeft = this.f19896a.getAxisLeft();
        YAxis axisRight = this.f19896a.getAxisRight();
        axisLeft.setDrawAxisLine(true);
        axisLeft.setTextSize(16.0f);
        axisLeft.setLabelCount(5, false);
        axisLeft.setAxisMinimum(0.0f);
        axisRight.setAxisMinimum(0.0f);
        axisRight.setEnabled(false);
        axisLeft.setValueFormatter(new b());
    }

    public void c(List<BarEntry> yValues, String lable, int color, ArrayList<String> xValues) {
        BarDataSet barDataSet = new BarDataSet(yValues, lable);
        barDataSet.setColor(color);
        barDataSet.setValueTextSize(14.0f);
        barDataSet.setDrawValues(true);
        barDataSet.setHighLightAlpha(37);
        barDataSet.setValueFormatter(new c());
        this.f19897b.setValueFormatter(new d(xValues));
        ArrayList arrayList = new ArrayList();
        arrayList.add(barDataSet);
        this.f19896a.setData(new BarData(arrayList));
    }

    public a(BarChart chart) {
        this.f19896a = chart;
        a();
        b();
    }
}
