package io.netty.util;

import io.netty.util.AbstractConstant;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class AbstractConstant<T extends AbstractConstant<T>> implements Constant<T> {
    private static final AtomicLong uniqueIdGenerator = new AtomicLong();
    private final int id;
    private final String name;
    private final long uniquifier = uniqueIdGenerator.getAndIncrement();

    @Override // java.lang.Comparable
    public final int compareTo(T t5) {
        if (this == t5) {
            return 0;
        }
        int hashCode = hashCode() - t5.hashCode();
        if (hashCode != 0) {
            return hashCode;
        }
        long j6 = this.uniquifier;
        long j7 = t5.uniquifier;
        if (j6 < j7) {
            return -1;
        }
        if (j6 > j7) {
            return 1;
        }
        throw new Error("failed to compare two different constants");
    }

    @Override // io.netty.util.Constant
    public final int id() {
        return this.id;
    }

    @Override // io.netty.util.Constant
    public final String name() {
        return this.name;
    }

    protected AbstractConstant(int i6, String str) {
        this.id = i6;
        this.name = str;
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final String toString() {
        return name();
    }
}
