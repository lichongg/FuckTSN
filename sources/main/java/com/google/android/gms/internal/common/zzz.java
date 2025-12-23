package com.google.android.gms.internal.common;

import java.util.NoSuchElementException;
import org.jspecify.nullness.NullMarked;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@NullMarked
/* loaded from: D:\Downloads\app\classes5.dex */
abstract class zzz extends zzak {
    private final int zza;
    private int zzb;

    protected abstract Object zza(int i6);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.zzb < this.zza;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.zzb > 0;
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.zzb;
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.zzb - 1;
    }

    protected zzz(int i6, int i7) {
        zzs.zzb(i7, i6, "index");
        this.zza = i6;
        this.zzb = i7;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (hasNext()) {
            int i6 = this.zzb;
            this.zzb = i6 + 1;
            return zza(i6);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (hasPrevious()) {
            int i6 = this.zzb - 1;
            this.zzb = i6;
            return zza(i6);
        }
        throw new NoSuchElementException();
    }
}
