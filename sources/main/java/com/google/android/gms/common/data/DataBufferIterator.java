package com.google.android.gms.common.data;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public class DataBufferIterator<T> implements Iterator<T> {

    @NonNull
    protected final DataBuffer zaa;
    protected int zab = -1;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zab < this.zaa.getCount() + (-1);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }

    public DataBufferIterator(@NonNull DataBuffer dataBuffer) {
        this.zaa = (DataBuffer) Preconditions.checkNotNull(dataBuffer);
    }

    @Override // java.util.Iterator
    @NonNull
    public Object next() {
        if (hasNext()) {
            DataBuffer dataBuffer = this.zaa;
            int i6 = this.zab + 1;
            this.zab = i6;
            return dataBuffer.get(i6);
        }
        throw new NoSuchElementException("Cannot advance the iterator beyond " + this.zab);
    }
}
