package com.github.aachartmodel.aainfographics.aachartcreator;

import com.github.aachartmodel.aainfographics.aaoptionsmodel.AADataLabels;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AAMarker;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AADataElement {
    private Object color;
    private AADataLabels dataLabels;
    private AAMarker marker;
    private String name;

    /* renamed from: x, reason: collision with root package name */
    private Number f32539x;

    /* renamed from: y, reason: collision with root package name */
    private Number f32540y;

    @NotNull
    public final AADataElement color(@NotNull Object prop) {
        g0.p(prop, "prop");
        this.color = prop;
        return this;
    }

    @NotNull
    public final AADataElement dataLabels(@NotNull AADataLabels prop) {
        g0.p(prop, "prop");
        this.dataLabels = prop;
        return this;
    }

    @NotNull
    public final AADataElement marker(@NotNull AAMarker prop) {
        g0.p(prop, "prop");
        this.marker = prop;
        return this;
    }

    @NotNull
    public final AADataElement name(@NotNull String prop) {
        g0.p(prop, "prop");
        this.name = prop;
        return this;
    }

    @NotNull
    public final AADataElement x(@NotNull Number prop) {
        g0.p(prop, "prop");
        this.f32539x = prop;
        return this;
    }

    @NotNull
    public final AADataElement y(@Nullable Number number) {
        this.f32540y = number;
        return this;
    }
}
