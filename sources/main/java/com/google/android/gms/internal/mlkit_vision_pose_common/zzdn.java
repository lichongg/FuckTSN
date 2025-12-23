package com.google.android.gms.internal.mlkit_vision_pose_common;

import com.huawei.hms.framework.common.ContainerUtils;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzdn implements Map.Entry {
    zzdn zza;
    zzdn zzb;
    zzdn zzc;
    zzdn zzd;
    zzdn zze;
    final Object zzf;
    final boolean zzg;
    Object zzh;
    int zzi;

    zzdn(boolean z5) {
        this.zzf = null;
        this.zzg = z5;
        this.zze = this;
        this.zzd = this;
    }

    zzdn(boolean z5, zzdn zzdnVar, Object obj, zzdn zzdnVar2, zzdn zzdnVar3) {
        this.zza = zzdnVar;
        this.zzf = obj;
        this.zzg = z5;
        this.zzi = 1;
        this.zzd = zzdnVar2;
        this.zze = zzdnVar3;
        zzdnVar3.zzd = this;
        zzdnVar2.zze = this;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = this.zzf;
            if (obj2 != null ? obj2.equals(entry.getKey()) : entry.getKey() == null) {
                Object obj3 = this.zzh;
                if (obj3 == null) {
                    if (entry.getValue() == null) {
                        return true;
                    }
                } else if (obj3.equals(entry.getValue())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.zzf;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.zzh;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Object obj = this.zzf;
        int hashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.zzh;
        return hashCode ^ (obj2 != null ? obj2.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj == null && !this.zzg) {
            throw new NullPointerException("value == null");
        }
        Object obj2 = this.zzh;
        this.zzh = obj;
        return obj2;
    }

    public final String toString() {
        return String.valueOf(this.zzf) + ContainerUtils.KEY_VALUE_DELIMITER + String.valueOf(this.zzh);
    }
}
