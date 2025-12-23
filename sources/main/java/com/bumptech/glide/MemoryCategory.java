package com.bumptech.glide;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public enum MemoryCategory {
    LOW(0.5f),
    NORMAL(1.0f),
    HIGH(1.5f);

    private final float multiplier;

    public float getMultiplier() {
        return this.multiplier;
    }

    MemoryCategory(float f6) {
        this.multiplier = f6;
    }
}
