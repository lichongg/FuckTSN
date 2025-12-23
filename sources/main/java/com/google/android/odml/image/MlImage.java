package com.google.android.odml.image;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import java.io.Closeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class MlImage implements Closeable {
    public static final int IMAGE_FORMAT_ALPHA = 8;
    public static final int IMAGE_FORMAT_JPEG = 9;
    public static final int IMAGE_FORMAT_NV12 = 3;
    public static final int IMAGE_FORMAT_NV21 = 4;
    public static final int IMAGE_FORMAT_RGB = 2;
    public static final int IMAGE_FORMAT_RGBA = 1;
    public static final int IMAGE_FORMAT_UNKNOWN = 0;
    public static final int IMAGE_FORMAT_YUV_420_888 = 7;
    public static final int IMAGE_FORMAT_YV12 = 5;
    public static final int IMAGE_FORMAT_YV21 = 6;
    public static final int STORAGE_TYPE_BITMAP = 1;
    public static final int STORAGE_TYPE_BYTEBUFFER = 2;
    public static final int STORAGE_TYPE_MEDIA_IMAGE = 3;
    private final zzg zza;
    private final int zzb;
    private final Rect zzc;
    private final int zzd;
    private final int zze;
    private int zzf;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ImageFormat {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Internal {
        private final MlImage zza;

        public void acquire() {
            this.zza.zzd();
        }

        /* synthetic */ Internal(MlImage mlImage, zzj zzjVar) {
            this.zza = mlImage;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface StorageType {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zzd() {
        this.zzf++;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        int i6 = this.zzf - 1;
        this.zzf = i6;
        if (i6 == 0) {
            this.zza.zzc();
        }
    }

    static void zzc(int i6) {
        if (i6 == 0 || i6 == 90 || i6 == 180 || i6 == 270) {
            return;
        }
        StringBuilder sb = new StringBuilder(68);
        sb.append("Rotation value ");
        sb.append(i6);
        sb.append(" is not valid. Use only 0, 90, 180 or 270.");
        throw new IllegalArgumentException(sb.toString());
    }

    @NonNull
    public List<ImageProperties> getContainedImageProperties() {
        return Collections.singletonList(this.zza.zzb());
    }

    public int getHeight() {
        return this.zze;
    }

    @NonNull
    public Internal getInternal() {
        return new Internal(this, null);
    }

    public int getRotation() {
        return this.zzb;
    }

    public int getWidth() {
        return this.zzd;
    }

    final zzg zza() {
        return this.zza;
    }

    MlImage(zzg zzgVar, int i6, Rect rect, long j6, int i7, int i8) {
        this.zza = zzgVar;
        this.zzb = i6;
        Rect rect2 = new Rect();
        this.zzc = rect2;
        rect2.set(rect);
        this.zzd = i7;
        this.zze = i8;
        this.zzf = 1;
    }
}
