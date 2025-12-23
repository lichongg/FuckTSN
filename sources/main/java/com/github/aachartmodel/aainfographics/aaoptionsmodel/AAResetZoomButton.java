package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AAResetZoomButton {

    @Nullable
    private AAPosition position;

    @Nullable
    private String relativeTo;

    @Nullable
    private Map<String, ? extends Object> theme;

    @Nullable
    public final AAPosition getPosition() {
        return this.position;
    }

    @Nullable
    public final String getRelativeTo() {
        return this.relativeTo;
    }

    @Nullable
    public final Map<String, Object> getTheme() {
        return this.theme;
    }

    @NotNull
    public final AAResetZoomButton position(@Nullable AAPosition aAPosition) {
        this.position = aAPosition;
        return this;
    }

    @NotNull
    public final AAResetZoomButton relativeTo(@Nullable String str) {
        this.relativeTo = str;
        return this;
    }

    public final void setPosition(@Nullable AAPosition aAPosition) {
        this.position = aAPosition;
    }

    public final void setRelativeTo(@Nullable String str) {
        this.relativeTo = str;
    }

    public final void setTheme(@Nullable Map<String, ? extends Object> map) {
        this.theme = map;
    }

    @NotNull
    public final AAResetZoomButton theme(@Nullable Map<String, ? extends Object> map) {
        this.theme = map;
        return this;
    }
}
