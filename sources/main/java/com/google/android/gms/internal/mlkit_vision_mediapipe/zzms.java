package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
class zzms extends AbstractMap {
    private Object[] zza;
    private int zzb;
    private Map zzc;
    private boolean zzd;
    private volatile zzmq zze;
    private Map zzf;

    private zzms() {
        Map map = Collections.EMPTY_MAP;
        this.zzc = map;
        this.zzf = map;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzms)) {
            return super.equals(obj);
        }
        zzms zzmsVar = (zzms) obj;
        int size = size();
        if (size != zzmsVar.size()) {
            return false;
        }
        int i6 = this.zzb;
        if (i6 != zzmsVar.zzb) {
            return entrySet().equals(zzmsVar.entrySet());
        }
        for (int i7 = 0; i7 < i6; i7++) {
            if (!zzg(i7).equals(zzmsVar.zzg(i7))) {
                return false;
            }
        }
        if (i6 != size) {
            return this.zzc.equals(zzmsVar.zzc);
        }
        return true;
    }

    private final int zzl(Comparable comparable) {
        int i6 = this.zzb;
        int i7 = i6 - 1;
        int i8 = 0;
        if (i7 >= 0) {
            int compareTo = comparable.compareTo(((zzmm) this.zza[i7]).zza());
            if (compareTo > 0) {
                return -(i6 + 1);
            }
            if (compareTo == 0) {
                return i7;
            }
        }
        while (i8 <= i7) {
            int i9 = (i8 + i7) / 2;
            int compareTo2 = comparable.compareTo(((zzmm) this.zza[i9]).zza());
            if (compareTo2 < 0) {
                i7 = i9 - 1;
            } else {
                if (compareTo2 <= 0) {
                    return i9;
                }
                i8 = i9 + 1;
            }
        }
        return -(i8 + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzo() {
        if (this.zzd) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zzl(comparable) >= 0 || this.zzc.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (this.zze == null) {
            this.zze = new zzmq(this, null);
        }
        return this.zze;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zzl = zzl(comparable);
        return zzl >= 0 ? ((zzmm) this.zza[zzl]).getValue() : this.zzc.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int i6 = this.zzb;
        int i7 = 0;
        for (int i8 = 0; i8 < i6; i8++) {
            i7 += this.zza[i8].hashCode();
        }
        return this.zzc.size() > 0 ? i7 + this.zzc.hashCode() : i7;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.zzb + this.zzc.size();
    }

    public void zza() {
        if (this.zzd) {
            return;
        }
        this.zzc = this.zzc.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.zzc);
        this.zzf = this.zzf.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.zzf);
        this.zzd = true;
    }

    public final int zzc() {
        return this.zzb;
    }

    public final Iterable zzd() {
        return this.zzc.isEmpty() ? Collections.EMPTY_SET : this.zzc.entrySet();
    }

    public final Map.Entry zzg(int i6) {
        if (i6 < this.zzb) {
            return (zzmm) this.zza[i6];
        }
        throw new ArrayIndexOutOfBoundsException(i6);
    }

    public final boolean zzj() {
        return this.zzd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object zzm(int i6) {
        zzo();
        Object value = ((zzmm) this.zza[i6]).getValue();
        Object[] objArr = this.zza;
        System.arraycopy(objArr, i6 + 1, objArr, i6, (this.zzb - i6) - 1);
        this.zzb--;
        if (!this.zzc.isEmpty()) {
            Iterator it = zzn().entrySet().iterator();
            Object[] objArr2 = this.zza;
            int i7 = this.zzb;
            Map.Entry entry = (Map.Entry) it.next();
            objArr2[i7] = new zzmm(this, (Comparable) entry.getKey(), entry.getValue());
            this.zzb++;
            it.remove();
        }
        return value;
    }

    private final SortedMap zzn() {
        zzo();
        if (this.zzc.isEmpty() && !(this.zzc instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zzc = treeMap;
            this.zzf = treeMap.descendingMap();
        }
        return (SortedMap) this.zzc;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        zzo();
        if (this.zzb != 0) {
            this.zza = null;
            this.zzb = 0;
        }
        if (!this.zzc.isEmpty()) {
            this.zzc.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        zzo();
        Comparable comparable = (Comparable) obj;
        int zzl = zzl(comparable);
        if (zzl >= 0) {
            return zzm(zzl);
        }
        if (this.zzc.isEmpty()) {
            return null;
        }
        return this.zzc.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public final Object put(Comparable comparable, Object obj) {
        zzo();
        int zzl = zzl(comparable);
        if (zzl >= 0) {
            return ((zzmm) this.zza[zzl]).setValue(obj);
        }
        zzo();
        if (this.zza == null) {
            this.zza = new Object[16];
        }
        int i6 = -(zzl + 1);
        if (i6 >= 16) {
            return zzn().put(comparable, obj);
        }
        if (this.zzb == 16) {
            zzmm zzmmVar = (zzmm) this.zza[15];
            this.zzb = 15;
            zzn().put(zzmmVar.zza(), zzmmVar.getValue());
        }
        Object[] objArr = this.zza;
        int length = objArr.length;
        System.arraycopy(objArr, i6, objArr, i6 + 1, 15 - i6);
        this.zza[i6] = new zzmm(this, comparable, obj);
        this.zzb++;
        return null;
    }

    /* synthetic */ zzms(zzmr zzmrVar) {
        Map map = Collections.EMPTY_MAP;
        this.zzc = map;
        this.zzf = map;
    }
}
