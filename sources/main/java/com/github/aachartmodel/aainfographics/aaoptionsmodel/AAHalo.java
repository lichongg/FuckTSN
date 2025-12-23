package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AAHalo {

    @Nullable
    private Map<String, ?> attributes;

    @Nullable
    private Float opacity;

    @Nullable
    private Number size;

    @NotNull
    public final AAHalo attributes(@Nullable AASVGAttributes aASVGAttributes) {
        this.attributes = aASVGAttributes != null ? aASVGAttributes.toDic() : null;
        return this;
    }

    @Nullable
    public final Map<String, ?> getAttributes() {
        return this.attributes;
    }

    @Nullable
    public final Float getOpacity() {
        return this.opacity;
    }

    @Nullable
    public final Number getSize() {
        return this.size;
    }

    @NotNull
    public final AAHalo opacity(@Nullable Float f6) {
        this.opacity = f6;
        return this;
    }

    public final void setAttributes(@Nullable Map<String, ?> map) {
        this.attributes = map;
    }

    public final void setOpacity(@Nullable Float f6) {
        this.opacity = f6;
    }

    public final void setSize(@Nullable Number number) {
        this.size = number;
    }

    @NotNull
    public final AAHalo size(@Nullable Number number) {
        this.size = number;
        return this;
    }
}
