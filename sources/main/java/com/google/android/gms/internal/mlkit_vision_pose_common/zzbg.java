package com.google.android.gms.internal.mlkit_vision_pose_common;

import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class zzbg implements Map, Serializable {

    @CheckForNull
    private transient zzbh zza;

    @CheckForNull
    private transient zzbh zzb;

    @CheckForNull
    private transient zzay zzc;

    @Override // java.util.Map
    @CheckForNull
    public abstract Object get(@CheckForNull Object obj);

    abstract zzay zza();

    abstract zzbh zze();

    abstract zzbh zzf();

    public static zzbg zzc() {
        return zzby.zza;
    }

    public static zzbg zzd(Object obj, Object obj2) {
        zzaj.zzb("optional-module-barcode", OptionalModuleUtils.BARCODE_MODULE_ID);
        return zzby.zzh(1, new Object[]{"optional-module-barcode", OptionalModuleUtils.BARCODE_MODULE_ID}, null);
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final boolean equals(@CheckForNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Set keySet() {
        zzbh zzbhVar = this.zzb;
        if (zzbhVar != null) {
            return zzbhVar;
        }
        zzbh zzf = zzf();
        this.zzb = zzf;
        return zzf;
    }

    @Override // java.util.Map
    @CheckForNull
    @Deprecated
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @CheckForNull
    @Deprecated
    public final Object remove(@CheckForNull Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzay values() {
        zzay zzayVar = this.zzc;
        if (zzayVar != null) {
            return zzayVar;
        }
        zzay zza = zza();
        this.zzc = zza;
        return zza;
    }

    @Override // java.util.Map
    /* renamed from: zzg, reason: merged with bridge method [inline-methods] */
    public final zzbh entrySet() {
        zzbh zzbhVar = this.zza;
        if (zzbhVar != null) {
            return zzbhVar;
        }
        zzbh zze = zze();
        this.zza = zze;
        return zze;
    }

    zzbg() {
    }

    @Override // java.util.Map
    public final boolean containsKey(@CheckForNull Object obj) {
        if (get(obj) != null) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map
    public final boolean containsValue(@CheckForNull Object obj) {
        return values().contains(obj);
    }

    @Override // java.util.Map
    @CheckForNull
    public final Object getOrDefault(@CheckForNull Object obj, @CheckForNull Object obj2) {
        Object obj3 = get(obj);
        if (obj3 != null) {
            return obj3;
        }
        return obj2;
    }

    @Override // java.util.Map
    public final int hashCode() {
        return zzca.zza(entrySet());
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public final String toString() {
        int size = size();
        zzaj.zza(size, "size");
        StringBuilder sb = new StringBuilder((int) Math.min(size * 8, IjkMediaMeta.AV_CH_STEREO_RIGHT));
        sb.append('{');
        boolean z5 = true;
        for (Map.Entry entry : entrySet()) {
            if (!z5) {
                sb.append(", ");
            }
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
            z5 = false;
        }
        sb.append('}');
        return sb.toString();
    }
}
