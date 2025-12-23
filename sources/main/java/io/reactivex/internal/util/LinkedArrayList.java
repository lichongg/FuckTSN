package io.reactivex.internal.util;

import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class LinkedArrayList {
    final int capacityHint;
    Object[] head;
    int indexInTail;
    volatile int size;
    Object[] tail;

    public void add(Object obj) {
        if (this.size == 0) {
            Object[] objArr = new Object[this.capacityHint + 1];
            this.head = objArr;
            this.tail = objArr;
            objArr[0] = obj;
            this.indexInTail = 1;
            this.size = 1;
            return;
        }
        int i6 = this.indexInTail;
        int i7 = this.capacityHint;
        if (i6 != i7) {
            this.tail[i6] = obj;
            this.indexInTail = i6 + 1;
            this.size++;
        } else {
            Object[] objArr2 = new Object[i7 + 1];
            objArr2[0] = obj;
            this.tail[i7] = objArr2;
            this.tail = objArr2;
            this.indexInTail = 1;
            this.size++;
        }
    }

    public Object[] head() {
        return this.head;
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        int i6 = this.capacityHint;
        int i7 = this.size;
        ArrayList arrayList = new ArrayList(i7 + 1);
        Object[] head = head();
        int i8 = 0;
        while (true) {
            int i9 = 0;
            while (i8 < i7) {
                arrayList.add(head[i9]);
                i8++;
                i9++;
                if (i9 == i6) {
                    break;
                }
            }
            return arrayList.toString();
            head = head[i6];
        }
    }

    public LinkedArrayList(int i6) {
        this.capacityHint = i6;
    }
}
