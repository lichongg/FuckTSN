package com.google.android.gms.internal.mlkit_vision_pose_common;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzdo extends AbstractMap implements Serializable {
    private static final Comparator zze = new zzdh();
    zzdn zza;
    int zzb;
    int zzc;
    final zzdn zzd;
    private final Comparator zzf;
    private final boolean zzg;
    private zzdj zzh;
    private zzdl zzi;

    public zzdo() {
        this(zze, true);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        this.zza = null;
        this.zzb = 0;
        this.zzc++;
        zzdn zzdnVar = this.zzd;
        zzdnVar.zze = zzdnVar;
        zzdnVar.zzd = zzdnVar;
    }

    final zzdn zzc(Object obj) {
        if (obj != null) {
            try {
                return zza(obj, false);
            } catch (ClassCastException unused) {
            }
        }
        return null;
    }

    public zzdo(Comparator comparator, boolean z5) {
        this.zzb = 0;
        this.zzc = 0;
        this.zzf = comparator;
        this.zzg = z5;
        this.zzd = new zzdn(z5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002f, code lost:
    
        if (r10 == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x005a, code lost:
    
        if (r10 == false) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0084 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0080 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0084 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0080 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzf(com.google.android.gms.internal.mlkit_vision_pose_common.zzdn r9, boolean r10) {
        /*
            r8 = this;
        L0:
            if (r9 == 0) goto L84
            com.google.android.gms.internal.mlkit_vision_pose_common.zzdn r0 = r9.zzb
            com.google.android.gms.internal.mlkit_vision_pose_common.zzdn r1 = r9.zzc
            r2 = 0
            if (r0 == 0) goto Lc
            int r3 = r0.zzi
            goto Ld
        Lc:
            r3 = 0
        Ld:
            if (r1 == 0) goto L12
            int r4 = r1.zzi
            goto L13
        L12:
            r4 = 0
        L13:
            int r5 = r3 - r4
            r6 = -2
            r7 = 1
            if (r5 != r6) goto L42
            com.google.android.gms.internal.mlkit_vision_pose_common.zzdn r0 = r1.zzb
            com.google.android.gms.internal.mlkit_vision_pose_common.zzdn r3 = r1.zzc
            if (r3 == 0) goto L22
            int r3 = r3.zzi
            goto L23
        L22:
            r3 = 0
        L23:
            if (r0 == 0) goto L28
            int r0 = r0.zzi
            goto L29
        L28:
            r0 = 0
        L29:
            int r0 = r0 - r3
            r3 = -1
            if (r0 == r3) goto L3a
            if (r0 != 0) goto L32
            if (r10 != 0) goto L33
            goto L3b
        L32:
            r7 = r10
        L33:
            r8.zzi(r1)
            r8.zzh(r9)
            goto L3f
        L3a:
            r2 = r10
        L3b:
            r8.zzh(r9)
            r7 = r2
        L3f:
            if (r7 != 0) goto L84
            goto L80
        L42:
            r1 = 2
            if (r5 != r1) goto L6d
            com.google.android.gms.internal.mlkit_vision_pose_common.zzdn r1 = r0.zzb
            com.google.android.gms.internal.mlkit_vision_pose_common.zzdn r3 = r0.zzc
            if (r3 == 0) goto L4e
            int r3 = r3.zzi
            goto L4f
        L4e:
            r3 = 0
        L4f:
            if (r1 == 0) goto L54
            int r1 = r1.zzi
            goto L55
        L54:
            r1 = 0
        L55:
            int r1 = r1 - r3
            if (r1 == r7) goto L65
            if (r1 != 0) goto L5d
            if (r10 != 0) goto L5e
            goto L66
        L5d:
            r7 = r10
        L5e:
            r8.zzh(r0)
            r8.zzi(r9)
            goto L6a
        L65:
            r2 = r10
        L66:
            r8.zzi(r9)
            r7 = r2
        L6a:
            if (r7 == 0) goto L80
            goto L84
        L6d:
            if (r5 != 0) goto L76
            int r3 = r3 + 1
            r9.zzi = r3
            if (r10 == 0) goto L80
            goto L84
        L76:
            int r0 = java.lang.Math.max(r3, r4)
            int r0 = r0 + r7
            r9.zzi = r0
            if (r10 != 0) goto L80
            goto L84
        L80:
            com.google.android.gms.internal.mlkit_vision_pose_common.zzdn r9 = r9.zza
            goto L0
        L84:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_pose_common.zzdo.zzf(com.google.android.gms.internal.mlkit_vision_pose_common.zzdn, boolean):void");
    }

    private final void zzg(zzdn zzdnVar, zzdn zzdnVar2) {
        zzdn zzdnVar3 = zzdnVar.zza;
        zzdnVar.zza = null;
        if (zzdnVar2 != null) {
            zzdnVar2.zza = zzdnVar3;
        }
        if (zzdnVar3 == null) {
            this.zza = zzdnVar2;
        } else if (zzdnVar3.zzb == zzdnVar) {
            zzdnVar3.zzb = zzdnVar2;
        } else {
            zzdnVar3.zzc = zzdnVar2;
        }
    }

    private final void zzh(zzdn zzdnVar) {
        zzdn zzdnVar2 = zzdnVar.zzb;
        zzdn zzdnVar3 = zzdnVar.zzc;
        zzdn zzdnVar4 = zzdnVar3.zzb;
        zzdn zzdnVar5 = zzdnVar3.zzc;
        zzdnVar.zzc = zzdnVar4;
        if (zzdnVar4 != null) {
            zzdnVar4.zza = zzdnVar;
        }
        zzg(zzdnVar, zzdnVar3);
        zzdnVar3.zzb = zzdnVar;
        zzdnVar.zza = zzdnVar3;
        int max = Math.max(zzdnVar2 != null ? zzdnVar2.zzi : 0, zzdnVar4 != null ? zzdnVar4.zzi : 0) + 1;
        zzdnVar.zzi = max;
        zzdnVar3.zzi = Math.max(max, zzdnVar5 != null ? zzdnVar5.zzi : 0) + 1;
    }

    private final void zzi(zzdn zzdnVar) {
        zzdn zzdnVar2 = zzdnVar.zzb;
        zzdn zzdnVar3 = zzdnVar.zzc;
        zzdn zzdnVar4 = zzdnVar2.zzb;
        zzdn zzdnVar5 = zzdnVar2.zzc;
        zzdnVar.zzb = zzdnVar5;
        if (zzdnVar5 != null) {
            zzdnVar5.zza = zzdnVar;
        }
        zzg(zzdnVar, zzdnVar2);
        zzdnVar2.zzc = zzdnVar;
        zzdnVar.zza = zzdnVar2;
        int max = Math.max(zzdnVar3 != null ? zzdnVar3.zzi : 0, zzdnVar5 != null ? zzdnVar5.zzi : 0) + 1;
        zzdnVar.zzi = max;
        zzdnVar2.zzi = Math.max(max, zzdnVar4 != null ? zzdnVar4.zzi : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        zzdj zzdjVar = this.zzh;
        if (zzdjVar != null) {
            return zzdjVar;
        }
        zzdj zzdjVar2 = new zzdj(this);
        this.zzh = zzdjVar2;
        return zzdjVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        zzdl zzdlVar = this.zzi;
        if (zzdlVar != null) {
            return zzdlVar;
        }
        zzdl zzdlVar2 = new zzdl(this);
        this.zzi = zzdlVar2;
        return zzdlVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("key == null");
        }
        if (obj2 == null && !this.zzg) {
            throw new NullPointerException("value == null");
        }
        zzdn zza = zza(obj, true);
        Object obj3 = zza.zzh;
        zza.zzh = obj2;
        return obj3;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.zzb;
    }

    final zzdn zza(Object obj, boolean z5) {
        int i6;
        zzdn zzdnVar;
        Comparator comparator = this.zzf;
        zzdn zzdnVar2 = this.zza;
        if (zzdnVar2 != null) {
            Comparable comparable = comparator == zze ? (Comparable) obj : null;
            while (true) {
                int compareTo = comparable != null ? comparable.compareTo(zzdnVar2.zzf) : comparator.compare(obj, zzdnVar2.zzf);
                if (compareTo == 0) {
                    return zzdnVar2;
                }
                zzdn zzdnVar3 = compareTo < 0 ? zzdnVar2.zzb : zzdnVar2.zzc;
                if (zzdnVar3 == null) {
                    i6 = compareTo;
                    break;
                }
                zzdnVar2 = zzdnVar3;
            }
        } else {
            i6 = 0;
        }
        if (!z5) {
            return null;
        }
        zzdn zzdnVar4 = this.zzd;
        if (zzdnVar2 != null) {
            zzdn zzdnVar5 = zzdnVar2;
            zzdnVar = new zzdn(this.zzg, zzdnVar5, obj, zzdnVar4, zzdnVar4.zze);
            if (i6 < 0) {
                zzdnVar5.zzb = zzdnVar;
            } else {
                zzdnVar5.zzc = zzdnVar;
            }
            zzf(zzdnVar5, true);
        } else {
            if (comparator == zze && !(obj instanceof Comparable)) {
                throw new ClassCastException(obj.getClass().getName().concat(" is not Comparable"));
            }
            zzdnVar = new zzdn(this.zzg, null, obj, zzdnVar4, zzdnVar4.zze);
            this.zza = zzdnVar;
        }
        this.zzb++;
        this.zzc++;
        return zzdnVar;
    }

    final void zze(zzdn zzdnVar, boolean z5) {
        zzdn zzdnVar2;
        zzdn zzdnVar3;
        int i6;
        if (z5) {
            zzdn zzdnVar4 = zzdnVar.zze;
            zzdnVar4.zzd = zzdnVar.zzd;
            zzdnVar.zzd.zze = zzdnVar4;
        }
        zzdn zzdnVar5 = zzdnVar.zzb;
        zzdn zzdnVar6 = zzdnVar.zzc;
        zzdn zzdnVar7 = zzdnVar.zza;
        int i7 = 0;
        if (zzdnVar5 == null || zzdnVar6 == null) {
            if (zzdnVar5 != null) {
                zzg(zzdnVar, zzdnVar5);
                zzdnVar.zzb = null;
            } else if (zzdnVar6 != null) {
                zzg(zzdnVar, zzdnVar6);
                zzdnVar.zzc = null;
            } else {
                zzg(zzdnVar, null);
            }
            zzf(zzdnVar7, false);
            this.zzb--;
            this.zzc++;
            return;
        }
        if (zzdnVar5.zzi > zzdnVar6.zzi) {
            do {
                zzdnVar3 = zzdnVar5;
                zzdnVar5 = zzdnVar5.zzc;
            } while (zzdnVar5 != null);
        } else {
            do {
                zzdnVar2 = zzdnVar6;
                zzdnVar6 = zzdnVar6.zzb;
            } while (zzdnVar6 != null);
            zzdnVar3 = zzdnVar2;
        }
        zze(zzdnVar3, false);
        zzdn zzdnVar8 = zzdnVar.zzb;
        if (zzdnVar8 != null) {
            i6 = zzdnVar8.zzi;
            zzdnVar3.zzb = zzdnVar8;
            zzdnVar8.zza = zzdnVar3;
            zzdnVar.zzb = null;
        } else {
            i6 = 0;
        }
        zzdn zzdnVar9 = zzdnVar.zzc;
        if (zzdnVar9 != null) {
            i7 = zzdnVar9.zzi;
            zzdnVar3.zzc = zzdnVar9;
            zzdnVar9.zza = zzdnVar3;
            zzdnVar.zzc = null;
        }
        zzdnVar3.zzi = Math.max(i6, i7) + 1;
        zzg(zzdnVar, zzdnVar3);
    }

    public zzdo(boolean z5) {
        this(zze, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        if (zzc(obj) != null) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        zzdn zzc = zzc(obj);
        if (zzc != null) {
            return zzc.zzh;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        zzdn zzd = zzd(obj);
        if (zzd != null) {
            return zzd.zzh;
        }
        return null;
    }

    final zzdn zzb(Map.Entry entry) {
        zzdn zzc = zzc(entry.getKey());
        if (zzc != null && Objects.equals(zzc.zzh, entry.getValue())) {
            return zzc;
        }
        return null;
    }

    final zzdn zzd(Object obj) {
        zzdn zzc = zzc(obj);
        if (zzc != null) {
            zze(zzc, true);
        }
        return zzc;
    }
}
