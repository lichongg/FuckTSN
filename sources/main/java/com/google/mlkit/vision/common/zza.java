package com.google.mlkit.vision.common;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zza extends PointF3D {
    private final float zza;
    private final float zzb;
    private final float zzc;

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PointF3D) {
            PointF3D pointF3D = (PointF3D) obj;
            if (Float.floatToIntBits(this.zza) == Float.floatToIntBits(pointF3D.getX()) && Float.floatToIntBits(this.zzb) == Float.floatToIntBits(pointF3D.getY()) && Float.floatToIntBits(this.zzc) == Float.floatToIntBits(pointF3D.getZ())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.mlkit.vision.common.PointF3D
    public final float getX() {
        return this.zza;
    }

    @Override // com.google.mlkit.vision.common.PointF3D
    public final float getY() {
        return this.zzb;
    }

    @Override // com.google.mlkit.vision.common.PointF3D
    public final float getZ() {
        return this.zzc;
    }

    public final int hashCode() {
        return ((((Float.floatToIntBits(this.zza) ^ 1000003) * 1000003) ^ Float.floatToIntBits(this.zzb)) * 1000003) ^ Float.floatToIntBits(this.zzc);
    }

    public final String toString() {
        return "PointF3D{x=" + this.zza + ", y=" + this.zzb + ", z=" + this.zzc + "}";
    }

    zza(float f6, float f7, float f8) {
        this.zza = f6;
        this.zzb = f7;
        this.zzc = f8;
    }
}
