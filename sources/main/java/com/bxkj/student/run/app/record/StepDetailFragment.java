package com.bxkj.student.run.app.record;

import android.text.TextUtils;
import android.view.View;
import androidx.core.content.ContextCompat;
import cn.bluemobi.dylan.base.BaseFragment;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
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
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class StepDetailFragment extends BaseFragment {

    /* renamed from: j, reason: collision with root package name */
    private BarChart f19986j;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends ValueFormatter {
        @Override // com.github.mikephil.charting.formatter.ValueFormatter
        public String getFormattedValue(float value) {
            return ((int) value) + "分钟";
        }

        a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends ValueFormatter {
        b() {
        }

        @Override // com.github.mikephil.charting.formatter.ValueFormatter
        public String getFormattedValue(float value) {
            return ((int) value) + "";
        }
    }

    private void N() {
        Description description = new Description();
        description.setText("");
        this.f19986j.setDescription(description);
        this.f19986j.setNoDataText("暂无数据");
        this.f19986j.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        this.f19986j.getXAxis().setDrawGridLines(false);
        this.f19986j.getXAxis().setTextSize(14.0f);
        this.f19986j.getAxisLeft().setTextSize(14.0f);
        this.f19986j.getAxisRight().setEnabled(false);
        this.f19986j.getAxisLeft().setDrawGridLines(false);
        this.f19986j.getAxisRight().setDrawGridLines(false);
        this.f19986j.getXAxis().setDrawGridLines(false);
        this.f19986j.getLegend().setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        this.f19986j.getLegend().setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        this.f19986j.getLegend().setTextSize(14.0f);
        this.f19986j.getXAxis().setGranularity(1.0f);
        this.f19986j.setExtraBottomOffset(20.0f);
        this.f19986j.getAxisLeft().setAxisMinimum(0.0f);
    }

    private void O() {
        if (getArguments().containsKey("step")) {
            String string = getArguments().getString("step");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            List arrayList = new ArrayList();
            int i6 = 0;
            try {
                if (JSON.parse(string) instanceof JSONArray) {
                    arrayList = JSON.parseArray(string, Integer.class);
                } else {
                    String[] split = string.split(",");
                    if (split.length > 0) {
                        for (String str : split) {
                            arrayList.add(Integer.valueOf(Integer.parseInt(str)));
                        }
                    }
                }
            } catch (Exception unused) {
                String[] split2 = string.split(",");
                if (split2.length > 0) {
                    for (String str2 : split2) {
                        arrayList.add(Integer.valueOf(Integer.parseInt(str2)));
                    }
                }
            }
            if (arrayList == null || arrayList.size() == 0) {
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            int i7 = 0;
            while (i6 < arrayList.size()) {
                i7 += ((Integer) arrayList.get(i6)).intValue();
                i6++;
                arrayList2.add(String.valueOf(i6));
                arrayList3.add(new BarEntry(i6, r5.intValue()));
            }
            BarDataSet barDataSet = new BarDataSet(arrayList3, "步数(共" + i7 + ")");
            barDataSet.setColor(ContextCompat.getColor(this.f1096g, 2131100565));
            barDataSet.setDrawValues(true);
            barDataSet.setHighLightAlpha(37);
            XAxis xAxis = this.f19986j.getXAxis();
            xAxis.setGranularity(1.0f);
            xAxis.setValueFormatter(new a());
            barDataSet.setValueFormatter(new b());
            ArrayList arrayList4 = new ArrayList();
            arrayList4.add(barDataSet);
            this.f19986j.setData(new BarData(arrayList4));
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void e() {
        N();
        O();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void f(View view) {
        this.f19986j = (BarChart) c(R.id.chart);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected int i() {
        return R.layout.fm_run_step;
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void b() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
