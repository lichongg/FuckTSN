package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
final class Count implements Serializable {
    private int value;

    public void add(int i6) {
        this.value += i6;
    }

    public int addAndGet(int i6) {
        int i7 = this.value + i6;
        this.value = i7;
        return i7;
    }

    public boolean equals(@NullableDecl Object obj) {
        return (obj instanceof Count) && ((Count) obj).value == this.value;
    }

    public int get() {
        return this.value;
    }

    public int getAndSet(int i6) {
        int i7 = this.value;
        this.value = i6;
        return i7;
    }

    public int hashCode() {
        return this.value;
    }

    public void set(int i6) {
        this.value = i6;
    }

    public String toString() {
        return Integer.toString(this.value);
    }

    Count(int i6) {
        this.value = i6;
    }
}
