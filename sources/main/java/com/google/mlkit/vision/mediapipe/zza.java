package com.google.mlkit.vision.mediapipe;

import androidx.annotation.Nullable;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zza extends MediaPipeGraphRunnerConfig {
    private final MlKitContext zza;
    private final String zzb;
    private final List zzc;
    private final List zzd;

    @Nullable
    private final Map zze;

    @Nullable
    private final Map zzf;

    public final boolean equals(Object obj) {
        Map map;
        Map map2;
        if (obj == this) {
            return true;
        }
        if (obj instanceof MediaPipeGraphRunnerConfig) {
            MediaPipeGraphRunnerConfig mediaPipeGraphRunnerConfig = (MediaPipeGraphRunnerConfig) obj;
            if (this.zza.equals(mediaPipeGraphRunnerConfig.zza()) && this.zzb.equals(mediaPipeGraphRunnerConfig.zzb()) && this.zzc.equals(mediaPipeGraphRunnerConfig.zzc()) && this.zzd.equals(mediaPipeGraphRunnerConfig.zzd()) && ((map = this.zze) != null ? map.equals(mediaPipeGraphRunnerConfig.zze()) : mediaPipeGraphRunnerConfig.zze() == null) && ((map2 = this.zzf) != null ? map2.equals(mediaPipeGraphRunnerConfig.zzf()) : mediaPipeGraphRunnerConfig.zzf() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = ((((((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb.hashCode()) * 1000003) ^ this.zzc.hashCode()) * 1000003) ^ this.zzd.hashCode();
        Map map = this.zze;
        int hashCode2 = ((hashCode * 1000003) ^ (map == null ? 0 : map.hashCode())) * 1000003;
        Map map2 = this.zzf;
        return hashCode2 ^ (map2 != null ? map2.hashCode() : 0);
    }

    public final String toString() {
        Map map = this.zzf;
        Map map2 = this.zze;
        List list = this.zzd;
        List list2 = this.zzc;
        return "MediaPipeGraphRunnerConfig{mlKitContext=" + this.zza.toString() + ", graphConfigPath=" + this.zzb + ", inputFrameStreamNameList=" + list2.toString() + ", outputStreamNameList=" + list.toString() + ", assetRegistry=" + String.valueOf(map2) + ", inputSidePackets=" + String.valueOf(map) + "}";
    }

    @Override // com.google.mlkit.vision.mediapipe.MediaPipeGraphRunnerConfig
    final MlKitContext zza() {
        return this.zza;
    }

    @Override // com.google.mlkit.vision.mediapipe.MediaPipeGraphRunnerConfig
    final String zzb() {
        return this.zzb;
    }

    @Override // com.google.mlkit.vision.mediapipe.MediaPipeGraphRunnerConfig
    final List zzc() {
        return this.zzc;
    }

    @Override // com.google.mlkit.vision.mediapipe.MediaPipeGraphRunnerConfig
    final List zzd() {
        return this.zzd;
    }

    @Override // com.google.mlkit.vision.mediapipe.MediaPipeGraphRunnerConfig
    @Nullable
    final Map zze() {
        return this.zze;
    }

    @Override // com.google.mlkit.vision.mediapipe.MediaPipeGraphRunnerConfig
    @Nullable
    final Map zzf() {
        return this.zzf;
    }

    zza(MlKitContext mlKitContext, String str, List list, List list2, @Nullable Map map, @Nullable Map map2) {
        if (mlKitContext != null) {
            this.zza = mlKitContext;
            if (str != null) {
                this.zzb = str;
                if (list != null) {
                    this.zzc = list;
                    if (list2 != null) {
                        this.zzd = list2;
                        this.zze = map;
                        this.zzf = map2;
                        return;
                    }
                    throw new NullPointerException("Null outputStreamNameList");
                }
                throw new NullPointerException("Null inputFrameStreamNameList");
            }
            throw new NullPointerException("Null graphConfigPath");
        }
        throw new NullPointerException("Null mlKitContext");
    }
}
