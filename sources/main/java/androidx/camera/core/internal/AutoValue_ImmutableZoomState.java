package androidx.camera.core.internal;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final class AutoValue_ImmutableZoomState extends ImmutableZoomState {
    private final float linearZoom;
    private final float maxZoomRatio;
    private final float minZoomRatio;
    private final float zoomRatio;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImmutableZoomState) {
            ImmutableZoomState immutableZoomState = (ImmutableZoomState) obj;
            if (Float.floatToIntBits(this.zoomRatio) == Float.floatToIntBits(immutableZoomState.getZoomRatio()) && Float.floatToIntBits(this.maxZoomRatio) == Float.floatToIntBits(immutableZoomState.getMaxZoomRatio()) && Float.floatToIntBits(this.minZoomRatio) == Float.floatToIntBits(immutableZoomState.getMinZoomRatio()) && Float.floatToIntBits(this.linearZoom) == Float.floatToIntBits(immutableZoomState.getLinearZoom())) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.core.internal.ImmutableZoomState, androidx.camera.core.ZoomState
    public float getLinearZoom() {
        return this.linearZoom;
    }

    @Override // androidx.camera.core.internal.ImmutableZoomState, androidx.camera.core.ZoomState
    public float getMaxZoomRatio() {
        return this.maxZoomRatio;
    }

    @Override // androidx.camera.core.internal.ImmutableZoomState, androidx.camera.core.ZoomState
    public float getMinZoomRatio() {
        return this.minZoomRatio;
    }

    @Override // androidx.camera.core.internal.ImmutableZoomState, androidx.camera.core.ZoomState
    public float getZoomRatio() {
        return this.zoomRatio;
    }

    public int hashCode() {
        return ((((((Float.floatToIntBits(this.zoomRatio) ^ 1000003) * 1000003) ^ Float.floatToIntBits(this.maxZoomRatio)) * 1000003) ^ Float.floatToIntBits(this.minZoomRatio)) * 1000003) ^ Float.floatToIntBits(this.linearZoom);
    }

    public String toString() {
        return "ImmutableZoomState{zoomRatio=" + this.zoomRatio + ", maxZoomRatio=" + this.maxZoomRatio + ", minZoomRatio=" + this.minZoomRatio + ", linearZoom=" + this.linearZoom + "}";
    }

    AutoValue_ImmutableZoomState(float f6, float f7, float f8, float f9) {
        this.zoomRatio = f6;
        this.maxZoomRatio = f7;
        this.minZoomRatio = f8;
        this.linearZoom = f9;
    }
}
