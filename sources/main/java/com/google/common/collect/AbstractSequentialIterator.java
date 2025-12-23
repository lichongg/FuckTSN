package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class AbstractSequentialIterator<T> extends UnmodifiableIterator<T> {

    @NullableDecl
    private T nextOrNull;

    @NullableDecl
    protected abstract T computeNext(T t5);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.nextOrNull != null;
    }

    protected AbstractSequentialIterator(@NullableDecl T t5) {
        this.nextOrNull = t5;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (hasNext()) {
            try {
                T t5 = this.nextOrNull;
                this.nextOrNull = computeNext(t5);
                return t5;
            } catch (Throwable th) {
                this.nextOrNull = computeNext(this.nextOrNull);
                throw th;
            }
        }
        throw new NoSuchElementException();
    }
}
