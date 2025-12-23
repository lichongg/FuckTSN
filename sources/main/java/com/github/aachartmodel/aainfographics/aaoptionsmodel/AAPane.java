package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AAPane {

    @Nullable
    private AABackground background;

    @Nullable
    private Object[] center;

    @Nullable
    private Number endAngle;

    @Nullable
    private Number size;

    @Nullable
    private Number startAngle;

    @NotNull
    public final AAPane background(@Nullable AABackground aABackground) {
        this.background = aABackground;
        return this;
    }

    @NotNull
    public final AAPane center(@NotNull Object[] prop) {
        g0.p(prop, "prop");
        this.center = prop;
        return this;
    }

    @NotNull
    public final AAPane endAngle(@Nullable Number number) {
        this.endAngle = number;
        return this;
    }

    @Nullable
    public final AABackground getBackground() {
        return this.background;
    }

    @Nullable
    public final Object[] getCenter() {
        return this.center;
    }

    @Nullable
    public final Number getEndAngle() {
        return this.endAngle;
    }

    @Nullable
    public final Number getSize() {
        return this.size;
    }

    @Nullable
    public final Number getStartAngle() {
        return this.startAngle;
    }

    public final void setBackground(@Nullable AABackground aABackground) {
        this.background = aABackground;
    }

    public final void setCenter(@Nullable Object[] objArr) {
        this.center = objArr;
    }

    public final void setEndAngle(@Nullable Number number) {
        this.endAngle = number;
    }

    public final void setSize(@Nullable Number number) {
        this.size = number;
    }

    public final void setStartAngle(@Nullable Number number) {
        this.startAngle = number;
    }

    @NotNull
    public final AAPane size(@Nullable Number number) {
        this.size = number;
        return this;
    }

    @NotNull
    public final AAPane startAngle(@Nullable Number number) {
        this.startAngle = number;
        return this;
    }
}
