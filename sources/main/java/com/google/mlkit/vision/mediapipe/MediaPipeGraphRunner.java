package com.google.mlkit.vision.mediapipe;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zziq;
import com.google.mlkit.common.MlKitException;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public class MediaPipeGraphRunner {
    private final MediaPipeGraphRunnerConfig zza;

    @Nullable
    private zzg zzb;
    private final AtomicBoolean zzc = new AtomicBoolean(false);

    private final void zza() throws MlKitException {
        if (this.zzc.get()) {
            throw new MlKitException("close() already called, can't send any more inputs.", 13);
        }
        if (this.zzb == null) {
            load();
        }
    }

    @KeepForSdk
    public void close() {
        this.zzc.set(true);
        zzg zzgVar = this.zzb;
        if (zzgVar != null) {
            zzgVar.zzc();
            this.zzb = null;
        }
    }

    @KeepForSdk
    public void load() throws MlKitException {
        if (this.zzc.get()) {
            throw new MlKitException("close() already called, can't call load().", 13);
        }
        if (this.zzb == null) {
            zzg zzgVar = new zzg(this.zza);
            this.zzb = zzgVar;
            zzgVar.zzd();
            this.zzb.zze();
        }
    }

    @KeepForSdk
    public MediaPipeGraphRunner(@NonNull MediaPipeGraphRunnerConfig mediaPipeGraphRunnerConfig) {
        this.zza = mediaPipeGraphRunnerConfig;
    }

    @NonNull
    @KeepForSdk
    public <ResultT> ResultT run(@NonNull List<MediaPipeInput> list, @NonNull Converter<ResultT> converter) throws MlKitException {
        zza();
        zziq zze = zziq.zze("MediaPipeGraphRunner#run");
        zze.zzb();
        try {
            ResultT resultt = (ResultT) ((zzg) Preconditions.checkNotNull(this.zzb)).zza(list, converter);
            zze.close();
            return resultt;
        } catch (Throwable th) {
            try {
                zze.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @KeepForSdk
    public void sendToInputStream(@NonNull String str, @NonNull MediaPipeInput mediaPipeInput) throws MlKitException {
        zza();
        ((zzg) Preconditions.checkNotNull(this.zzb)).zzf(str, mediaPipeInput);
    }
}
