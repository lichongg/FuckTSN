package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.SurfaceConfig;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final class AutoValue_SurfaceConfig extends SurfaceConfig {
    private final SurfaceConfig.ConfigSize configSize;
    private final SurfaceConfig.ConfigType configType;
    private final long streamUseCase;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SurfaceConfig) {
            SurfaceConfig surfaceConfig = (SurfaceConfig) obj;
            if (this.configType.equals(surfaceConfig.getConfigType()) && this.configSize.equals(surfaceConfig.getConfigSize()) && this.streamUseCase == surfaceConfig.getStreamUseCase()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.core.impl.SurfaceConfig
    @NonNull
    public SurfaceConfig.ConfigSize getConfigSize() {
        return this.configSize;
    }

    @Override // androidx.camera.core.impl.SurfaceConfig
    @NonNull
    public SurfaceConfig.ConfigType getConfigType() {
        return this.configType;
    }

    @Override // androidx.camera.core.impl.SurfaceConfig
    public long getStreamUseCase() {
        return this.streamUseCase;
    }

    public int hashCode() {
        int hashCode = (((this.configType.hashCode() ^ 1000003) * 1000003) ^ this.configSize.hashCode()) * 1000003;
        long j6 = this.streamUseCase;
        return hashCode ^ ((int) (j6 ^ (j6 >>> 32)));
    }

    public String toString() {
        return "SurfaceConfig{configType=" + this.configType + ", configSize=" + this.configSize + ", streamUseCase=" + this.streamUseCase + "}";
    }

    AutoValue_SurfaceConfig(SurfaceConfig.ConfigType configType, SurfaceConfig.ConfigSize configSize, long j6) {
        if (configType != null) {
            this.configType = configType;
            if (configSize != null) {
                this.configSize = configSize;
                this.streamUseCase = j6;
                return;
            }
            throw new NullPointerException("Null configSize");
        }
        throw new NullPointerException("Null configType");
    }
}
