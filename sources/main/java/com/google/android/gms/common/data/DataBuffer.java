package com.google.android.gms.common.data;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Releasable;
import java.io.Closeable;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public interface DataBuffer<T> extends Iterable<T>, Releasable, Closeable {
    void close();

    @NonNull
    T get(int i6);

    int getCount();

    @Nullable
    @KeepForSdk
    Bundle getMetadata();

    @Deprecated
    boolean isClosed();

    @Override // java.lang.Iterable
    @NonNull
    Iterator<T> iterator();

    void release();

    @NonNull
    Iterator<T> singleRefIterator();
}
