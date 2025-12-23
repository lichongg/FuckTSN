package com.github.aachartmodel.aainfographics.aachartcreator;

import com.google.gson.internal.LinkedTreeMap;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AAMoveOverEventMessageModel {

    @Nullable
    private String category;

    @Nullable
    private Integer index;

    @Nullable
    private String name;

    @Nullable
    private LinkedTreeMap<String, Object> offset;

    /* renamed from: x, reason: collision with root package name */
    @Nullable
    private Double f32541x;

    /* renamed from: y, reason: collision with root package name */
    @Nullable
    private Double f32542y;

    @Nullable
    public final String getCategory() {
        return this.category;
    }

    @Nullable
    public final Integer getIndex() {
        return this.index;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final LinkedTreeMap<String, Object> getOffset() {
        return this.offset;
    }

    @Nullable
    public final Double getX() {
        return this.f32541x;
    }

    @Nullable
    public final Double getY() {
        return this.f32542y;
    }

    public final void setCategory(@Nullable String str) {
        this.category = str;
    }

    public final void setIndex(@Nullable Integer num) {
        this.index = num;
    }

    public final void setName(@Nullable String str) {
        this.name = str;
    }

    public final void setOffset(@Nullable LinkedTreeMap<String, Object> linkedTreeMap) {
        this.offset = linkedTreeMap;
    }

    public final void setX(@Nullable Double d6) {
        this.f32541x = d6;
    }

    public final void setY(@Nullable Double d6) {
        this.f32542y = d6;
    }
}
