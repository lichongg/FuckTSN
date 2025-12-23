package com.github.aachartmodel.aainfographics.aachartcreator;

import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public enum AAChartType {
    Column("column"),
    Bar("bar"),
    Area("area"),
    Areaspline("areaspline"),
    Line("line"),
    Spline("spline"),
    Scatter("scatter"),
    Pie("pie"),
    Bubble("bubble"),
    Pyramid("pyramid"),
    Funnel("funnel"),
    Columnrange("columnrange"),
    Arearange("arearange"),
    Areasplinerange("areasplinerange"),
    Boxplot("boxplot"),
    Waterfall("waterfall"),
    Polygon("polygon"),
    Gauge("gauge"),
    Errorbar("errorbar");


    @NotNull
    private final String value;

    @NotNull
    public final String getValue() {
        return this.value;
    }

    AAChartType(String str) {
        this.value = str;
    }
}
