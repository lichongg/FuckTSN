package com.bxkj.student.run.app.my;

import android.graphics.Matrix;
import android.view.View;
import androidx.core.content.ContextCompat;
import cn.bluemobi.dylan.base.BaseFragment;
import cn.bluemobi.dylan.base.utils.u;
import com.bxkj.student.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class RunStaticsFragment extends BaseFragment {

    /* renamed from: j, reason: collision with root package name */
    private BarChart f19889j;

    /* renamed from: k, reason: collision with root package name */
    private int f19890k;

    /* renamed from: l, reason: collision with root package name */
    private float[] f19891l;

    /* renamed from: m, reason: collision with root package name */
    private float f19892m = 0.13333334f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends ValueFormatter {
        @Override // com.github.mikephil.charting.formatter.ValueFormatter
        public String getFormattedValue(float value) {
            int i6 = (int) value;
            if (RunStaticsFragment.this.f19890k == 1) {
                return u.n(i6);
            }
            if (RunStaticsFragment.this.f19890k == 2) {
                return i6 + "日";
            }
            if (RunStaticsFragment.this.f19890k == 3) {
                return i6 + "周";
            }
            return i6 + "";
        }

        a() {
        }
    }

    private float P(int xCount) {
        return xCount * this.f19892m;
    }

    private void O() {
        Description description = new Description();
        description.setText("");
        this.f19889j.setDescription(description);
        this.f19889j.setNoDataText("暂无数据");
        this.f19889j.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        this.f19889j.getXAxis().setDrawGridLines(false);
        this.f19889j.getAxisRight().setEnabled(false);
        this.f19889j.getAxisLeft().setDrawGridLines(false);
        this.f19889j.getAxisRight().setDrawGridLines(false);
        this.f19889j.getXAxis().setDrawGridLines(false);
        this.f19889j.getLegend().setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        this.f19889j.getLegend().setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        Matrix matrix = new Matrix();
        matrix.postScale(P(this.f19891l.length), 1.0f);
        this.f19889j.getViewPortHandler().refresh(matrix, this.f19889j, false);
        this.f19889j.setPinchZoom(false);
        this.f19889j.setDoubleTapToZoomEnabled(false);
    }

    private void Q() {
        ArrayList arrayList = new ArrayList();
        int i6 = 0;
        while (i6 < this.f19891l.length) {
            int i7 = i6 + 1;
            arrayList.add(new BarEntry(i7, this.f19891l[i6]));
            i6 = i7;
        }
        BarDataSet barDataSet = new BarDataSet(arrayList, "里程(KM)");
        barDataSet.setColor(ContextCompat.getColor(this.f1096g, 2131100565));
        barDataSet.setDrawValues(true);
        barDataSet.setHighLightAlpha(37);
        XAxis xAxis = this.f19889j.getXAxis();
        xAxis.setGranularity(1.0f);
        xAxis.setValueFormatter(new a());
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(barDataSet);
        this.f19889j.setData(new BarData(arrayList2));
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void e() {
        if (getArguments().containsKey("type")) {
            this.f19890k = getArguments().getInt("type");
        }
        if (getArguments().containsKey("listData")) {
            this.f19891l = getArguments().getFloatArray("listData");
        }
        O();
        Q();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void f(View view) {
        this.f19889j = (BarChart) c(R.id.barChart);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected int i() {
        return R.layout.fm_statistics;
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void b() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
