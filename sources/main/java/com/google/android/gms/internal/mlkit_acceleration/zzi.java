package com.google.android.gms.internal.mlkit_acceleration;

import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
abstract class zzi implements Iterator {

    @CheckForNull
    private Object zza;
    private int zzb = 2;

    @CheckForNull
    protected abstract Object zza();

    @CheckForNull
    protected final Object zzb() {
        this.zzb = 3;
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i6 = this.zzb;
        if (i6 == 4) {
            throw new IllegalStateException();
        }
        int i7 = i6 - 1;
        if (i6 == 0) {
            throw null;
        }
        if (i7 == 0) {
            return true;
        }
        if (i7 != 2) {
            this.zzb = 4;
            this.zza = zza();
            if (this.zzb != 3) {
                this.zzb = 1;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    protected zzi() {
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (hasNext()) {
            this.zzb = 2;
            Object obj = this.zza;
            this.zza = null;
            return obj;
        }
        throw new NoSuchElementException();
    }
}
