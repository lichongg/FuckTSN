package cn.jiguang.al;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* loaded from: D:\Downloads\app\classes2.dex */
public class i<E> {

    /* renamed from: a, reason: collision with root package name */
    private Comparator<E> f1622a;

    /* renamed from: b, reason: collision with root package name */
    private int f1623b;

    public List<E> a(List<E> list, List<E> list2) {
        if (this.f1622a == null || list == null || list.isEmpty() || list2 == null || list2.isEmpty()) {
            return null;
        }
        int size = list.size();
        int size2 = list2.size();
        int i6 = size - 1;
        int i7 = size2 - 1;
        ArrayList arrayList = new ArrayList();
        int i8 = 0;
        int i9 = 0;
        while (i8 < size && i9 < size2) {
            E e6 = list.get(i8);
            E e7 = list2.get(i9);
            int compare = this.f1622a.compare(e6, e7);
            if (compare == 0) {
                arrayList.add(e6);
            } else if (compare >= 0) {
                if (a(list2, i9 + 1, i7, e6)) {
                    arrayList.add(e6);
                    i9 = this.f1623b + 1;
                } else {
                    i9 = this.f1623b;
                }
                i8++;
            } else if (a(list, i8 + 1, i6, e7)) {
                arrayList.add(e7);
                i8 = this.f1623b;
            } else {
                i8 = this.f1623b;
                i9++;
            }
            i8++;
            i9++;
        }
        return arrayList;
    }

    public void a(Comparator<E> comparator) {
        this.f1622a = comparator;
    }

    public i(Comparator<E> comparator) {
        a(comparator);
    }

    private boolean a(List<E> list, int i6, int i7, E e6) {
        while (i6 <= i7) {
            int i8 = (i6 + i7) >> 1;
            int compare = this.f1622a.compare(list.get(i8), e6);
            if (compare == 0) {
                this.f1623b = i8;
                return true;
            }
            if (compare < 0) {
                i6 = i8 + 1;
            } else {
                i7 = i8 - 1;
            }
        }
        this.f1623b = i6;
        return false;
    }
}
