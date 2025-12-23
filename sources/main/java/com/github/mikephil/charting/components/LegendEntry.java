package com.github.mikephil.charting.components;

import android.graphics.DashPathEffect;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.utils.ColorTemplate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class LegendEntry {
    public Legend.LegendForm form;
    public int formColor;
    public DashPathEffect formLineDashEffect;
    public float formLineWidth;
    public float formSize;
    public String label;

    public LegendEntry() {
        this.form = Legend.LegendForm.DEFAULT;
        this.formSize = Float.NaN;
        this.formLineWidth = Float.NaN;
        this.formLineDashEffect = null;
        this.formColor = ColorTemplate.COLOR_NONE;
    }

    public LegendEntry(String str, Legend.LegendForm legendForm, float f6, float f7, DashPathEffect dashPathEffect, int i6) {
        Legend.LegendForm legendForm2 = Legend.LegendForm.DEFAULT;
        this.label = str;
        this.form = legendForm;
        this.formSize = f6;
        this.formLineWidth = f7;
        this.formLineDashEffect = dashPathEffect;
        this.formColor = i6;
    }
}
