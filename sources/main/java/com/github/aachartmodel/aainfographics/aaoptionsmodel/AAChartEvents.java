package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import com.github.aachartmodel.aainfographics.aatools.AAJSStringPurer;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AAChartEvents {

    @Nullable
    private String load;

    @Nullable
    private String redraw;

    @Nullable
    private String render;

    @Nullable
    private String selection;

    @Nullable
    public final String getLoad() {
        return this.load;
    }

    @Nullable
    public final String getRedraw() {
        return this.redraw;
    }

    @Nullable
    public final String getRender() {
        return this.render;
    }

    @Nullable
    public final String getSelection() {
        return this.selection;
    }

    @NotNull
    public final AAChartEvents load(@NotNull String prop) {
        g0.p(prop, "prop");
        this.load = AAJSStringPurer.INSTANCE.pureAnonymousJSFunctionString(prop);
        return this;
    }

    @NotNull
    public final AAChartEvents redraw(@NotNull String prop) {
        g0.p(prop, "prop");
        this.redraw = AAJSStringPurer.INSTANCE.pureAnonymousJSFunctionString(prop);
        return this;
    }

    @NotNull
    public final AAChartEvents render(@NotNull String prop) {
        g0.p(prop, "prop");
        this.render = AAJSStringPurer.INSTANCE.pureAnonymousJSFunctionString(prop);
        return this;
    }

    @NotNull
    public final AAChartEvents selection(@NotNull String prop) {
        g0.p(prop, "prop");
        this.selection = AAJSStringPurer.INSTANCE.pureAnonymousJSFunctionString(prop);
        return this;
    }

    public final void setLoad(@Nullable String str) {
        this.load = str;
    }

    public final void setRedraw(@Nullable String str) {
        this.redraw = str;
    }

    public final void setRender(@Nullable String str) {
        this.render = str;
    }

    public final void setSelection(@Nullable String str) {
        this.selection = str;
    }
}
