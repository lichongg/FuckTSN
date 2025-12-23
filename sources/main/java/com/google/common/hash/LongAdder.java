package com.google.common.hash;

import com.google.common.hash.Striped64;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class LongAdder extends Striped64 implements Serializable, LongAddable {
    private static final long serialVersionUID = 7249069246863182397L;

    @Override // com.google.common.hash.Striped64
    final long fn(long j6, long j7) {
        return j6 + j7;
    }

    @Override // com.google.common.hash.LongAddable
    public void add(long j6) {
        int length;
        Striped64.Cell cell;
        Striped64.Cell[] cellArr = this.cells;
        if (cellArr == null) {
            long j7 = this.base;
            if (casBase(j7, j7 + j6)) {
                return;
            }
        }
        int[] iArr = Striped64.threadHashCode.get();
        boolean z5 = true;
        if (iArr != null && cellArr != null && (length = cellArr.length) >= 1 && (cell = cellArr[(length - 1) & iArr[0]]) != null) {
            long j8 = cell.value;
            z5 = cell.cas(j8, j8 + j6);
            if (z5) {
                return;
            }
        }
        retryUpdate(j6, iArr, z5);
    }

    public void decrement() {
        add(-1L);
    }

    @Override // com.google.common.hash.LongAddable
    public void increment() {
        add(1L);
    }

    public void reset() {
        internalReset(0L);
    }

    @Override // com.google.common.hash.LongAddable
    public long sum() {
        long j6 = this.base;
        Striped64.Cell[] cellArr = this.cells;
        if (cellArr != null) {
            for (Striped64.Cell cell : cellArr) {
                if (cell != null) {
                    j6 += cell.value;
                }
            }
        }
        return j6;
    }

    public long sumThenReset() {
        long j6 = this.base;
        Striped64.Cell[] cellArr = this.cells;
        this.base = 0L;
        if (cellArr != null) {
            for (Striped64.Cell cell : cellArr) {
                if (cell != null) {
                    j6 += cell.value;
                    cell.value = 0L;
                }
            }
        }
        return j6;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.busy = 0;
        this.cells = null;
        this.base = objectInputStream.readLong();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeLong(sum());
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return sum();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return sum();
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) sum();
    }

    @Override // java.lang.Number
    public long longValue() {
        return sum();
    }

    public String toString() {
        return Long.toString(sum());
    }
}
