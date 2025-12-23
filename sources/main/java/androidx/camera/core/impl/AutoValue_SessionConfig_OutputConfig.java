package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.impl.SessionConfig;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final class AutoValue_SessionConfig_OutputConfig extends SessionConfig.OutputConfig {
    private final DynamicRange dynamicRange;
    private final String physicalCameraId;
    private final List<DeferrableSurface> sharedSurfaces;
    private final DeferrableSurface surface;
    private final int surfaceGroupId;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class Builder extends SessionConfig.OutputConfig.Builder {
        private DynamicRange dynamicRange;
        private String physicalCameraId;
        private List<DeferrableSurface> sharedSurfaces;
        private DeferrableSurface surface;
        private Integer surfaceGroupId;

        @Override // androidx.camera.core.impl.SessionConfig.OutputConfig.Builder
        public SessionConfig.OutputConfig build() {
            String str = "";
            if (this.surface == null) {
                str = " surface";
            }
            if (this.sharedSurfaces == null) {
                str = str + " sharedSurfaces";
            }
            if (this.surfaceGroupId == null) {
                str = str + " surfaceGroupId";
            }
            if (this.dynamicRange == null) {
                str = str + " dynamicRange";
            }
            if (str.isEmpty()) {
                return new AutoValue_SessionConfig_OutputConfig(this.surface, this.sharedSurfaces, this.physicalCameraId, this.surfaceGroupId.intValue(), this.dynamicRange);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // androidx.camera.core.impl.SessionConfig.OutputConfig.Builder
        public SessionConfig.OutputConfig.Builder setDynamicRange(DynamicRange dynamicRange) {
            if (dynamicRange == null) {
                throw new NullPointerException("Null dynamicRange");
            }
            this.dynamicRange = dynamicRange;
            return this;
        }

        @Override // androidx.camera.core.impl.SessionConfig.OutputConfig.Builder
        public SessionConfig.OutputConfig.Builder setPhysicalCameraId(@Nullable String str) {
            this.physicalCameraId = str;
            return this;
        }

        @Override // androidx.camera.core.impl.SessionConfig.OutputConfig.Builder
        public SessionConfig.OutputConfig.Builder setSharedSurfaces(List<DeferrableSurface> list) {
            if (list == null) {
                throw new NullPointerException("Null sharedSurfaces");
            }
            this.sharedSurfaces = list;
            return this;
        }

        @Override // androidx.camera.core.impl.SessionConfig.OutputConfig.Builder
        public SessionConfig.OutputConfig.Builder setSurface(DeferrableSurface deferrableSurface) {
            if (deferrableSurface == null) {
                throw new NullPointerException("Null surface");
            }
            this.surface = deferrableSurface;
            return this;
        }

        Builder() {
        }

        @Override // androidx.camera.core.impl.SessionConfig.OutputConfig.Builder
        public SessionConfig.OutputConfig.Builder setSurfaceGroupId(int i6) {
            this.surfaceGroupId = Integer.valueOf(i6);
            return this;
        }
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof SessionConfig.OutputConfig) {
            SessionConfig.OutputConfig outputConfig = (SessionConfig.OutputConfig) obj;
            if (this.surface.equals(outputConfig.getSurface()) && this.sharedSurfaces.equals(outputConfig.getSharedSurfaces()) && ((str = this.physicalCameraId) != null ? str.equals(outputConfig.getPhysicalCameraId()) : outputConfig.getPhysicalCameraId() == null) && this.surfaceGroupId == outputConfig.getSurfaceGroupId() && this.dynamicRange.equals(outputConfig.getDynamicRange())) {
                return true;
            }
        }
        return false;
    }

    private AutoValue_SessionConfig_OutputConfig(DeferrableSurface deferrableSurface, List<DeferrableSurface> list, @Nullable String str, int i6, DynamicRange dynamicRange) {
        this.surface = deferrableSurface;
        this.sharedSurfaces = list;
        this.physicalCameraId = str;
        this.surfaceGroupId = i6;
        this.dynamicRange = dynamicRange;
    }

    @Override // androidx.camera.core.impl.SessionConfig.OutputConfig
    @NonNull
    public DynamicRange getDynamicRange() {
        return this.dynamicRange;
    }

    @Override // androidx.camera.core.impl.SessionConfig.OutputConfig
    @Nullable
    public String getPhysicalCameraId() {
        return this.physicalCameraId;
    }

    @Override // androidx.camera.core.impl.SessionConfig.OutputConfig
    @NonNull
    public List<DeferrableSurface> getSharedSurfaces() {
        return this.sharedSurfaces;
    }

    @Override // androidx.camera.core.impl.SessionConfig.OutputConfig
    @NonNull
    public DeferrableSurface getSurface() {
        return this.surface;
    }

    @Override // androidx.camera.core.impl.SessionConfig.OutputConfig
    public int getSurfaceGroupId() {
        return this.surfaceGroupId;
    }

    public int hashCode() {
        int hashCode = (((this.surface.hashCode() ^ 1000003) * 1000003) ^ this.sharedSurfaces.hashCode()) * 1000003;
        String str = this.physicalCameraId;
        return ((((hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.surfaceGroupId) * 1000003) ^ this.dynamicRange.hashCode();
    }

    public String toString() {
        return "OutputConfig{surface=" + this.surface + ", sharedSurfaces=" + this.sharedSurfaces + ", physicalCameraId=" + this.physicalCameraId + ", surfaceGroupId=" + this.surfaceGroupId + ", dynamicRange=" + this.dynamicRange + "}";
    }
}
