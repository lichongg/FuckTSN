package com.google.android.gms.internal.mlkit_acceleration;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
class zzfz extends AbstractMap {
    private final int zza;
    private List zzb = Collections.EMPTY_LIST;
    private Map zzc;
    private boolean zzd;
    private volatile zzfx zze;
    private Map zzf;

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfz)) {
            return super.equals(obj);
        }
        zzfz zzfzVar = (zzfz) obj;
        int size = size();
        if (size != zzfzVar.size()) {
            return false;
        }
        int zzb = zzb();
        if (zzb != zzfzVar.zzb()) {
            return entrySet().equals(zzfzVar.entrySet());
        }
        for (int i6 = 0; i6 < zzb; i6++) {
            if (!zzg(i6).equals(zzfzVar.zzg(i6))) {
                return false;
            }
        }
        if (zzb != size) {
            return this.zzc.equals(zzfzVar.zzc);
        }
        return true;
    }

    private final int zzk(Comparable comparable) {
        int size = this.zzb.size();
        int i6 = size - 1;
        int i7 = 0;
        if (i6 >= 0) {
            int compareTo = comparable.compareTo(((zzft) this.zzb.get(i6)).zza());
            if (compareTo > 0) {
                return -(size + 1);
            }
            if (compareTo == 0) {
                return i6;
            }
        }
        while (i7 <= i6) {
            int i8 = (i7 + i6) / 2;
            int compareTo2 = comparable.compareTo(((zzft) this.zzb.get(i8)).zza());
            if (compareTo2 < 0) {
                i6 = i8 - 1;
            } else {
                if (compareTo2 <= 0) {
                    return i8;
                }
                i7 = i8 + 1;
            }
        }
        return -(i7 + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzn() {
        if (this.zzd) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zzk(comparable) >= 0 || this.zzc.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (this.zze == null) {
            this.zze = new zzfx(this, null);
        }
        return this.zze;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zzk = zzk(comparable);
        return zzk >= 0 ? ((zzft) this.zzb.get(zzk)).getValue() : this.zzc.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.zzb.size() + this.zzc.size();
    }

    public void zza() {
        if (this.zzd) {
            return;
        }
        this.zzc = this.zzc.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.zzc);
        this.zzf = this.zzf.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.zzf);
        this.zzd = true;
    }

    public final int zzb() {
        return this.zzb.size();
    }

    public final Iterable zzc() {
        return this.zzc.isEmpty() ? zzfs.zza() : this.zzc.entrySet();
    }

    public final Map.Entry zzg(int i6) {
        return (Map.Entry) this.zzb.get(i6);
    }

    public final boolean zzj() {
        return this.zzd;
    }

    /* synthetic */ zzfz(int i6, zzfy zzfyVar) {
        this.zza = i6;
        Map map = Collections.EMPTY_MAP;
        this.zzc = map;
        this.zzf = map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object zzl(int i6) {
        zzn();
        Object value = ((zzft) this.zzb.remove(i6)).getValue();
        if (!this.zzc.isEmpty()) {
            Iterator it = zzm().entrySet().iterator();
            List list = this.zzb;
            Map.Entry entry = (Map.Entry) it.next();
            list.add(new zzft(this, (Comparable) entry.getKey(), entry.getValue()));
            it.remove();
        }
        return value;
    }

    private final SortedMap zzm() {
        zzn();
        if (this.zzc.isEmpty() && !(this.zzc instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zzc = treeMap;
            this.zzf = treeMap.descendingMap();
        }
        return (SortedMap) this.zzc;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        zzn();
        if (!this.zzb.isEmpty()) {
            this.zzb.clear();
        }
        if (!this.zzc.isEmpty()) {
            this.zzc.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int zzb = zzb();
        int i6 = 0;
        for (int i7 = 0; i7 < zzb; i7++) {
            i6 += ((zzft) this.zzb.get(i7)).hashCode();
        }
        if (this.zzc.size() > 0) {
            return i6 + this.zzc.hashCode();
        }
        return i6;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        zzn();
        Comparable comparable = (Comparable) obj;
        int zzk = zzk(comparable);
        if (zzk >= 0) {
            return zzl(zzk);
        }
        if (this.zzc.isEmpty()) {
            return null;
        }
        return this.zzc.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: zze, reason: merged with bridge method [inline-methods] */
    public final Object put(Comparable comparable, Object obj) {
        zzn();
        int zzk = zzk(comparable);
        if (zzk >= 0) {
            return ((zzft) this.zzb.get(zzk)).setValue(obj);
        }
        zzn();
        if (this.zzb.isEmpty() && !(this.zzb instanceof ArrayList)) {
            this.zzb = new ArrayList(this.zza);
        }
        int i6 = -(zzk + 1);
        if (i6 >= this.zza) {
            return zzm().put(comparable, obj);
        }
        int size = this.zzb.size();
        int i7 = this.zza;
        if (size == i7) {
            zzft zzftVar = (zzft) this.zzb.remove(i7 - 1);
            zzm().put(zzftVar.zza(), zzftVar.getValue());
        }
        this.zzb.add(i6, new zzft(this, comparable, obj));
        return null;
    }
}
