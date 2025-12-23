package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AACredits {

    @Nullable
    private Boolean enabled;

    @Nullable
    private String href;

    @Nullable
    private AAPosition position;

    @Nullable
    private AAStyle style;

    @Nullable
    private String text;

    @Nullable
    public final Boolean getEnabled() {
        return this.enabled;
    }

    @Nullable
    public final String getHref() {
        return this.href;
    }

    @Nullable
    public final AAPosition getPosition() {
        return this.position;
    }

    @Nullable
    public final AAStyle getStyle() {
        return this.style;
    }

    @Nullable
    public final String getText() {
        return this.text;
    }

    @NotNull
    public final AACredits href(@Nullable String str) {
        this.href = str;
        return this;
    }

    @NotNull
    public final AACredits position(@Nullable AAPosition aAPosition) {
        this.position = aAPosition;
        return this;
    }

    public final void setEnabled(@Nullable Boolean bool) {
        this.enabled = bool;
    }

    public final void setHref(@Nullable String str) {
        this.href = str;
    }

    public final void setPosition(@Nullable AAPosition aAPosition) {
        this.position = aAPosition;
    }

    public final void setStyle(@Nullable AAStyle aAStyle) {
        this.style = aAStyle;
    }

    public final void setText(@Nullable String str) {
        this.text = str;
    }

    @NotNull
    public final AACredits style(@Nullable AAStyle aAStyle) {
        this.style = aAStyle;
        return this;
    }

    @NotNull
    public final AACredits text(@Nullable String str) {
        this.text = str;
        return this;
    }

    @NotNull
    public final AACredits enabled(boolean z5) {
        this.enabled = Boolean.valueOf(z5);
        return this;
    }
}
