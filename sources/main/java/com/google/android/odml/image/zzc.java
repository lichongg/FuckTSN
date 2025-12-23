package com.google.android.odml.image;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzc extends ImageProperties {
    private final int zza;
    private final int zzb;

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImageProperties) {
            ImageProperties imageProperties = (ImageProperties) obj;
            if (this.zza == imageProperties.getImageFormat() && this.zzb == imageProperties.getStorageType()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.odml.image.ImageProperties
    public final int getImageFormat() {
        return this.zza;
    }

    @Override // com.google.android.odml.image.ImageProperties
    public final int getStorageType() {
        return this.zzb;
    }

    public final int hashCode() {
        return ((this.zza ^ 1000003) * 1000003) ^ this.zzb;
    }

    public final String toString() {
        int i6 = this.zza;
        int i7 = this.zzb;
        StringBuilder sb = new StringBuilder(65);
        sb.append("ImageProperties{imageFormat=");
        sb.append(i6);
        sb.append(", storageType=");
        sb.append(i7);
        sb.append("}");
        return sb.toString();
    }

    /* synthetic */ zzc(int i6, int i7, zza zzaVar) {
        this.zza = i6;
        this.zzb = i7;
    }
}
