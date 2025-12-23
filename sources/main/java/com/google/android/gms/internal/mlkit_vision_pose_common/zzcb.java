package com.google.android.gms.internal.mlkit_vision_pose_common;

import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
abstract class zzcb implements Iterator {
    final Iterator zza;

    abstract Object zza(Object obj);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return zza(this.zza.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.zza.remove();
    }

    zzcb(Iterator it) {
        it.getClass();
        this.zza = it;
    }
}
