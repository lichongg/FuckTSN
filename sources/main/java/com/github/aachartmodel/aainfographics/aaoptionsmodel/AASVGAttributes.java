package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AASVGAttributes {

    @Nullable
    private String fill;

    @Nullable
    private String stroke;

    @Nullable
    private Number strokeWidth;

    @NotNull
    public final AASVGAttributes fill(@Nullable String str) {
        this.fill = str;
        return this;
    }

    @Nullable
    public final String getFill() {
        return this.fill;
    }

    @Nullable
    public final String getStroke() {
        return this.stroke;
    }

    @Nullable
    public final Number getStrokeWidth() {
        return this.strokeWidth;
    }

    public final void setFill(@Nullable String str) {
        this.fill = str;
    }

    public final void setStroke(@Nullable String str) {
        this.stroke = str;
    }

    public final void setStrokeWidth(@Nullable Number number) {
        this.strokeWidth = number;
    }

    @NotNull
    public final AASVGAttributes stroke(@Nullable String str) {
        this.stroke = str;
        return this;
    }

    @NotNull
    public final AASVGAttributes strokeWidth(@Nullable Number number) {
        this.strokeWidth = number;
        return this;
    }

    @NotNull
    public final Map<String, Object> toDic() {
        HashMap hashMap = new HashMap();
        Number number = this.strokeWidth;
        if (number != null) {
            hashMap.put("stroke-width", number);
        }
        String str = this.fill;
        if (str != null) {
            hashMap.put("fill", str);
        }
        String str2 = this.stroke;
        if (str2 != null) {
            hashMap.put("stroke", str2);
        }
        return hashMap;
    }
}
