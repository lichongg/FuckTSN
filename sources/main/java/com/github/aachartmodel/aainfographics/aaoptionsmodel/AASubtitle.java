package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import com.github.aachartmodel.aainfographics.aachartcreator.AAChartAlignType;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartVerticalAlignType;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AASubtitle {
    private String align;
    private AAStyle style;
    private String text;
    private Boolean userHTML;
    private String verticalAlign;

    /* renamed from: x, reason: collision with root package name */
    private Number f32554x;

    /* renamed from: y, reason: collision with root package name */
    private Number f32555y;

    @NotNull
    public final AASubtitle align(@Nullable AAChartAlignType aAChartAlignType) {
        this.align = aAChartAlignType != null ? aAChartAlignType.getValue() : null;
        return this;
    }

    @NotNull
    public final AASubtitle style(@Nullable AAStyle aAStyle) {
        this.style = aAStyle;
        return this;
    }

    @NotNull
    public final AASubtitle text(@Nullable String str) {
        this.text = str;
        return this;
    }

    @NotNull
    public final AASubtitle userHTML(@Nullable Boolean bool) {
        this.userHTML = bool;
        return this;
    }

    @NotNull
    public final AASubtitle verticalAlign(@NotNull AAChartVerticalAlignType prop) {
        g0.p(prop, "prop");
        this.verticalAlign = prop.toString();
        return this;
    }

    @NotNull
    public final AASubtitle x(@Nullable Number number) {
        this.f32554x = number;
        return this;
    }

    @NotNull
    public final AASubtitle y(@Nullable Number number) {
        this.f32555y = number;
        return this;
    }
}
