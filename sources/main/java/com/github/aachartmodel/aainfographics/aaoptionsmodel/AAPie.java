package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import com.github.aachartmodel.aainfographics.aachartcreator.AAChartType;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AAPie {

    @Nullable
    private Boolean allowPointSelect;

    @Nullable
    private Object center;

    @Nullable
    private String cursor;

    @Nullable
    private Object[] data;

    @Nullable
    private AADataLabels dataLabels;

    @Nullable
    private Number depth;

    @Nullable
    private Number endAngle;

    @Nullable
    private Boolean showInLegend;

    @Nullable
    private Number size;

    @Nullable
    private Number startAngle;

    @Nullable
    private String type;

    @NotNull
    public final AAPie allowPointSelect(@Nullable Boolean bool) {
        this.allowPointSelect = bool;
        return this;
    }

    @NotNull
    public final AAPie center(@Nullable Object obj) {
        this.center = obj;
        return this;
    }

    @NotNull
    public final AAPie cursor(@NotNull String prop) {
        g0.p(prop, "prop");
        this.cursor = prop;
        return this;
    }

    @NotNull
    public final AAPie data(@NotNull Object[] prop) {
        g0.p(prop, "prop");
        this.data = prop;
        return this;
    }

    @NotNull
    public final AAPie dataLabels(@NotNull AADataLabels prop) {
        g0.p(prop, "prop");
        this.dataLabels = prop;
        return this;
    }

    @NotNull
    public final AAPie depth(@Nullable Number number) {
        this.depth = number;
        return this;
    }

    @NotNull
    public final AAPie endAngle(@Nullable Number number) {
        this.endAngle = number;
        return this;
    }

    @Nullable
    public final Boolean getAllowPointSelect() {
        return this.allowPointSelect;
    }

    @Nullable
    public final Object getCenter() {
        return this.center;
    }

    @Nullable
    public final String getCursor() {
        return this.cursor;
    }

    @Nullable
    public final Object[] getData() {
        return this.data;
    }

    @Nullable
    public final AADataLabels getDataLabels() {
        return this.dataLabels;
    }

    @Nullable
    public final Number getDepth() {
        return this.depth;
    }

    @Nullable
    public final Number getEndAngle() {
        return this.endAngle;
    }

    @Nullable
    public final Boolean getShowInLegend() {
        return this.showInLegend;
    }

    @Nullable
    public final Number getSize() {
        return this.size;
    }

    @Nullable
    public final Number getStartAngle() {
        return this.startAngle;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    public final void setAllowPointSelect(@Nullable Boolean bool) {
        this.allowPointSelect = bool;
    }

    public final void setCenter(@Nullable Object obj) {
        this.center = obj;
    }

    public final void setCursor(@Nullable String str) {
        this.cursor = str;
    }

    public final void setData(@Nullable Object[] objArr) {
        this.data = objArr;
    }

    public final void setDataLabels(@Nullable AADataLabels aADataLabels) {
        this.dataLabels = aADataLabels;
    }

    public final void setDepth(@Nullable Number number) {
        this.depth = number;
    }

    public final void setEndAngle(@Nullable Number number) {
        this.endAngle = number;
    }

    public final void setShowInLegend(@Nullable Boolean bool) {
        this.showInLegend = bool;
    }

    public final void setSize(@Nullable Number number) {
        this.size = number;
    }

    public final void setStartAngle(@Nullable Number number) {
        this.startAngle = number;
    }

    public final void setType(@Nullable String str) {
        this.type = str;
    }

    @NotNull
    public final AAPie showInLegend(@Nullable Boolean bool) {
        this.showInLegend = bool;
        return this;
    }

    @NotNull
    public final AAPie size(@Nullable Number number) {
        this.size = number;
        return this;
    }

    @NotNull
    public final AAPie startAngle(@Nullable Number number) {
        this.startAngle = number;
        return this;
    }

    @NotNull
    public final AAPie type(@Nullable AAChartType aAChartType) {
        this.type = aAChartType != null ? aAChartType.getValue() : null;
        return this;
    }
}
