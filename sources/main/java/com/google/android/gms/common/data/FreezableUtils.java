package com.google.android.gms.common.data;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class FreezableUtils {
    @NonNull
    public static <T, E extends Freezable<T>> ArrayList<T> freeze(@NonNull ArrayList<E> arrayList) {
        ObservableArrayList observableArrayList = (ArrayList<T>) new ArrayList(arrayList.size());
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            observableArrayList.add(arrayList.get(i6).freeze());
        }
        return observableArrayList;
    }

    @NonNull
    public static <T, E extends Freezable<T>> ArrayList<T> freezeIterable(@NonNull Iterable<E> iterable) {
        ObservableArrayList observableArrayList = (ArrayList<T>) new ArrayList();
        Iterator<E> it = iterable.iterator();
        while (it.hasNext()) {
            observableArrayList.add(it.next().freeze());
        }
        return observableArrayList;
    }

    @NonNull
    public static <T, E extends Freezable<T>> ArrayList<T> freeze(@NonNull E[] eArr) {
        ObservableArrayList observableArrayList = (ArrayList<T>) new ArrayList(eArr.length);
        for (E e6 : eArr) {
            observableArrayList.add(e6.freeze());
        }
        return observableArrayList;
    }
}
