package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import com.github.aachartmodel.aainfographics.aatools.AAJSStringPurer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AAPointEvents {

    @Nullable
    private String click;

    @Nullable
    private String legendItemClick;

    @Nullable
    private String mouseOut;

    @Nullable
    private String mouseOver;

    @Nullable
    private String remove;

    @Nullable
    private String select;

    @Nullable
    private String unselect;

    @Nullable
    private String update;

    @NotNull
    public final AAPointEvents click(@Nullable String str) {
        this.click = AAJSStringPurer.INSTANCE.pureAnonymousJSFunctionString(str);
        return this;
    }

    @Nullable
    public final String getClick() {
        return this.click;
    }

    @Nullable
    public final String getLegendItemClick() {
        return this.legendItemClick;
    }

    @Nullable
    public final String getMouseOut() {
        return this.mouseOut;
    }

    @Nullable
    public final String getMouseOver() {
        return this.mouseOver;
    }

    @Nullable
    public final String getRemove() {
        return this.remove;
    }

    @Nullable
    public final String getSelect() {
        return this.select;
    }

    @Nullable
    public final String getUnselect() {
        return this.unselect;
    }

    @Nullable
    public final String getUpdate() {
        return this.update;
    }

    @NotNull
    public final AAPointEvents legendItemClick(@Nullable String str) {
        this.legendItemClick = AAJSStringPurer.INSTANCE.pureAnonymousJSFunctionString(str);
        return this;
    }

    @NotNull
    public final AAPointEvents mouseOut(@Nullable String str) {
        this.mouseOut = AAJSStringPurer.INSTANCE.pureAnonymousJSFunctionString(str);
        return this;
    }

    @NotNull
    public final AAPointEvents mouseOver(@Nullable String str) {
        this.mouseOver = AAJSStringPurer.INSTANCE.pureAnonymousJSFunctionString(str);
        return this;
    }

    @NotNull
    public final AAPointEvents remove(@Nullable String str) {
        this.remove = AAJSStringPurer.INSTANCE.pureAnonymousJSFunctionString(str);
        return this;
    }

    @NotNull
    public final AAPointEvents select(@Nullable String str) {
        this.select = AAJSStringPurer.INSTANCE.pureAnonymousJSFunctionString(str);
        return this;
    }

    public final void setClick(@Nullable String str) {
        this.click = str;
    }

    public final void setLegendItemClick(@Nullable String str) {
        this.legendItemClick = str;
    }

    public final void setMouseOut(@Nullable String str) {
        this.mouseOut = str;
    }

    public final void setMouseOver(@Nullable String str) {
        this.mouseOver = str;
    }

    public final void setRemove(@Nullable String str) {
        this.remove = str;
    }

    public final void setSelect(@Nullable String str) {
        this.select = str;
    }

    public final void setUnselect(@Nullable String str) {
        this.unselect = str;
    }

    public final void setUpdate(@Nullable String str) {
        this.update = str;
    }

    @NotNull
    public final AAPointEvents unselect(@Nullable String str) {
        this.unselect = AAJSStringPurer.INSTANCE.pureAnonymousJSFunctionString(str);
        return this;
    }

    @NotNull
    public final AAPointEvents update(@Nullable String str) {
        this.update = AAJSStringPurer.INSTANCE.pureAnonymousJSFunctionString(str);
        return this;
    }
}
