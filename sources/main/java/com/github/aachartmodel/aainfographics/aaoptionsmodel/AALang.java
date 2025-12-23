package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AALang {

    @Nullable
    private String resetZoom;

    @Nullable
    private String thousandsSep;

    @Nullable
    public final String getResetZoom() {
        return this.resetZoom;
    }

    @Nullable
    public final String getThousandsSep() {
        return this.thousandsSep;
    }

    @NotNull
    public final AALang resetZoom(@Nullable String str) {
        this.resetZoom = str;
        return this;
    }

    public final void setResetZoom(@Nullable String str) {
        this.resetZoom = str;
    }

    public final void setThousandsSep(@Nullable String str) {
        this.thousandsSep = str;
    }

    @NotNull
    public final AALang thousandsSep(@Nullable String str) {
        this.thousandsSep = str;
        return this;
    }
}
