package io.netty.handler.codec.http2;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class HpackDynamicTable {
    private long capacity = -1;
    int head;
    HpackHeaderField[] hpackHeaderFields;
    private long size;
    int tail;

    public long capacity() {
        return this.capacity;
    }

    public void clear() {
        while (true) {
            int i6 = this.tail;
            if (i6 == this.head) {
                this.head = 0;
                this.tail = 0;
                this.size = 0L;
                return;
            } else {
                HpackHeaderField[] hpackHeaderFieldArr = this.hpackHeaderFields;
                int i7 = i6 + 1;
                this.tail = i7;
                hpackHeaderFieldArr[i6] = null;
                if (i7 == hpackHeaderFieldArr.length) {
                    this.tail = 0;
                }
            }
        }
    }

    public HpackHeaderField getEntry(int i6) {
        if (i6 <= 0 || i6 > length()) {
            throw new IndexOutOfBoundsException();
        }
        int i7 = this.head - i6;
        if (i7 >= 0) {
            return this.hpackHeaderFields[i7];
        }
        HpackHeaderField[] hpackHeaderFieldArr = this.hpackHeaderFields;
        return hpackHeaderFieldArr[i7 + hpackHeaderFieldArr.length];
    }

    public int length() {
        int i6 = this.head;
        int i7 = this.tail;
        return i6 < i7 ? (this.hpackHeaderFields.length - i7) + i6 : i6 - i7;
    }

    public HpackHeaderField remove() {
        HpackHeaderField hpackHeaderField = this.hpackHeaderFields[this.tail];
        if (hpackHeaderField == null) {
            return null;
        }
        this.size -= hpackHeaderField.size();
        HpackHeaderField[] hpackHeaderFieldArr = this.hpackHeaderFields;
        int i6 = this.tail;
        int i7 = i6 + 1;
        this.tail = i7;
        hpackHeaderFieldArr[i6] = null;
        if (i7 == hpackHeaderFieldArr.length) {
            this.tail = 0;
        }
        return hpackHeaderField;
    }

    public void setCapacity(long j6) {
        if (j6 < 0 || j6 > 4294967295L) {
            throw new IllegalArgumentException("capacity is invalid: " + j6);
        }
        if (this.capacity == j6) {
            return;
        }
        this.capacity = j6;
        if (j6 == 0) {
            clear();
        } else {
            while (this.size > j6) {
                remove();
            }
        }
        int i6 = (int) (j6 / 32);
        if (j6 % 32 != 0) {
            i6++;
        }
        HpackHeaderField[] hpackHeaderFieldArr = this.hpackHeaderFields;
        if (hpackHeaderFieldArr == null || hpackHeaderFieldArr.length != i6) {
            HpackHeaderField[] hpackHeaderFieldArr2 = new HpackHeaderField[i6];
            int length = length();
            int i7 = this.tail;
            for (int i8 = 0; i8 < length; i8++) {
                HpackHeaderField[] hpackHeaderFieldArr3 = this.hpackHeaderFields;
                int i9 = i7 + 1;
                hpackHeaderFieldArr2[i8] = hpackHeaderFieldArr3[i7];
                i7 = i9 == hpackHeaderFieldArr3.length ? 0 : i9;
            }
            this.tail = 0;
            this.head = length;
            this.hpackHeaderFields = hpackHeaderFieldArr2;
        }
    }

    public long size() {
        return this.size;
    }

    HpackDynamicTable(long j6) {
        setCapacity(j6);
    }

    public void add(HpackHeaderField hpackHeaderField) {
        long j6;
        long size = hpackHeaderField.size();
        if (size > this.capacity) {
            clear();
            return;
        }
        while (true) {
            long j7 = this.capacity;
            j6 = this.size;
            if (j7 - j6 >= size) {
                break;
            } else {
                remove();
            }
        }
        HpackHeaderField[] hpackHeaderFieldArr = this.hpackHeaderFields;
        int i6 = this.head;
        this.head = i6 + 1;
        hpackHeaderFieldArr[i6] = hpackHeaderField;
        this.size = j6 + hpackHeaderField.size();
        if (this.head == this.hpackHeaderFields.length) {
            this.head = 0;
        }
    }
}
