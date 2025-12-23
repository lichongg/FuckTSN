package com.github.aachartmodel.aainfographics.aachartcreator;

import com.acse.ottn.adapter.AutoScrollViewPager;
import com.beizi.fusion.widget.ScrollClickView;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public enum AAChartAlignType {
    Left(ScrollClickView.DIR_LEFT),
    Center(AutoScrollViewPager.f4187g),
    Right("right");


    @NotNull
    private final String value;

    @NotNull
    public final String getValue() {
        return this.value;
    }

    AAChartAlignType(String str) {
        this.value = str;
    }
}
