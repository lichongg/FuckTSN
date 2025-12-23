package io.reactivex.internal.util;

import io.reactivex.Observer;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Predicate;
import org.reactivestreams.Subscriber;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class AppendOnlyLinkedArrayList<T> {
    final int capacity;
    final Object[] head;
    int offset;
    Object[] tail;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface NonThrowingPredicate<T> extends Predicate<T> {
        @Override // io.reactivex.functions.Predicate
        boolean test(T t5);
    }

    public <U> boolean accept(Subscriber<? super U> subscriber) {
        int i6;
        Object[] objArr = this.head;
        int i7 = this.capacity;
        while (true) {
            if (objArr == null) {
                return false;
            }
            while (i6 < i7) {
                Object[] objArr2 = objArr[i6];
                i6 = (objArr2 == null || NotificationLite.acceptFull(objArr2, subscriber)) ? 0 : i6 + 1;
                objArr = objArr[i7];
            }
            objArr = objArr[i7];
        }
    }

    public void forEachWhile(NonThrowingPredicate<? super T> nonThrowingPredicate) {
        int i6;
        int i7 = this.capacity;
        for (Object[] objArr = this.head; objArr != null; objArr = (Object[]) objArr[i7]) {
            while (i6 < i7) {
                Object obj = objArr[i6];
                i6 = (obj == null || nonThrowingPredicate.test(obj)) ? 0 : i6 + 1;
            }
        }
    }

    public void add(T t5) {
        int i6 = this.capacity;
        int i7 = this.offset;
        if (i7 == i6) {
            Object[] objArr = new Object[i6 + 1];
            this.tail[i6] = objArr;
            this.tail = objArr;
            i7 = 0;
        }
        this.tail[i7] = t5;
        this.offset = i7 + 1;
    }

    public void setFirst(T t5) {
        this.head[0] = t5;
    }

    public AppendOnlyLinkedArrayList(int i6) {
        this.capacity = i6;
        Object[] objArr = new Object[i6 + 1];
        this.head = objArr;
        this.tail = objArr;
    }

    public <U> boolean accept(Observer<? super U> observer) {
        int i6;
        Object[] objArr = this.head;
        int i7 = this.capacity;
        while (true) {
            if (objArr == null) {
                return false;
            }
            while (i6 < i7) {
                Object[] objArr2 = objArr[i6];
                i6 = (objArr2 == null || NotificationLite.acceptFull(objArr2, observer)) ? 0 : i6 + 1;
                objArr = objArr[i7];
            }
            objArr = objArr[i7];
        }
    }

    public <S> void forEachWhile(S s5, BiPredicate<? super S, ? super T> biPredicate) throws Exception {
        Object[] objArr = this.head;
        int i6 = this.capacity;
        while (true) {
            for (int i7 = 0; i7 < i6; i7++) {
                Object obj = objArr[i7];
                if (obj == null || biPredicate.test(s5, obj)) {
                    return;
                }
            }
            objArr = (Object[]) objArr[i6];
        }
    }
}
