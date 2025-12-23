package com.google.mlkit.vision.mediapipe;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public class MediaPipeInputFactory {
    @NonNull
    @KeepForSdk
    public static MediaPipeInput getMediaPipeInput(float f6, long j6) {
        return new zzk(f6, j6);
    }

    @NonNull
    @KeepForSdk
    public static MediaPipeInput getDelegateInputSidePacketGpu(boolean z5, boolean z6, @NonNull String str, @NonNull String str2) {
        return new zzb(z5, z6, str, str2);
    }

    @NonNull
    @KeepForSdk
    public static MediaPipeInput getDelegateInputSidePacketNnapi(@NonNull String str, @NonNull String str2) {
        return new zzc(str, str2);
    }

    @NonNull
    @KeepForSdk
    public static MediaPipeInput getMediaPipeInput(int i6, long j6) {
        return new zzl(i6, j6);
    }

    private MediaPipeInputFactory() {
    }

    @NonNull
    @KeepForSdk
    public static MediaPipeInput getMediaPipeInput(@NonNull Bitmap bitmap, long j6) {
        return new zzh(bitmap, j6);
    }

    @NonNull
    @KeepForSdk
    public static MediaPipeInput getMediaPipeInput(@NonNull String str, long j6) {
        return new zzm(str, j6);
    }

    @NonNull
    @KeepForSdk
    public static MediaPipeInput getMediaPipeInput(@NonNull ByteBuffer byteBuffer, int i6, int i7, long j6) {
        return new zzj(byteBuffer, i6, i7, j6);
    }

    @NonNull
    @KeepForSdk
    public static MediaPipeInput getMediaPipeInput(boolean z5, long j6) {
        return new zzi(z5, j6);
    }
}
