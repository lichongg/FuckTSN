package com.amap.api.col.p0003l;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class k8 {

    /* renamed from: b, reason: collision with root package name */
    private k9 f6694b;

    /* renamed from: a, reason: collision with root package name */
    private List<l9> f6693a = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<l9> f6695c = new ArrayList<>();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a implements Comparator<l9> {
        a() {
        }

        private static int a(l9 l9Var, l9 l9Var2) {
            return l9Var2.f6747c - l9Var.f6747c;
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(l9 l9Var, l9 l9Var2) {
            return a(l9Var, l9Var2);
        }
    }

    private static boolean e(List<l9> list, List<l9> list2) {
        if (list != null && list2 != null) {
            int size = list.size();
            int size2 = list2.size();
            int i6 = size + size2;
            if (size <= size2) {
                list2 = list;
                list = list2;
            }
            HashMap hashMap = new HashMap(list.size());
            Iterator<l9> it = list.iterator();
            while (it.hasNext()) {
                hashMap.put(Long.valueOf(it.next().f6745a), 1);
            }
            Iterator<l9> it2 = list2.iterator();
            int i7 = 0;
            while (it2.hasNext()) {
                if (((Integer) hashMap.get(Long.valueOf(it2.next().f6745a))) != null) {
                    i7++;
                }
            }
            if (i7 * 2.0d >= i6 * 0.5d) {
                return true;
            }
        }
        return false;
    }

    private boolean h(k9 k9Var, List<l9> list, boolean z5, long j6, long j7) {
        if (!z5 || !d(k9Var, j6, j7) || list == null || list.size() <= 0) {
            return false;
        }
        if (this.f6694b == null) {
            return true;
        }
        boolean c6 = c(k9Var);
        return !c6 ? !e(list, this.f6693a) : c6;
    }

    private static List<l9> b(List<l9> list) {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        for (int i6 = 0; i6 < list.size(); i6++) {
            l9 l9Var = list.get(i6);
            hashMap.put(Integer.valueOf(l9Var.f6747c), l9Var);
        }
        arrayList.addAll(hashMap.values());
        return arrayList;
    }

    private boolean c(k9 k9Var) {
        float f6 = k9Var.f6659g;
        float f7 = 10.0f;
        if (f6 > 10.0f) {
            f7 = 200.0f;
        } else if (f6 > 2.0f) {
            f7 = 50.0f;
        }
        return k9Var.a(this.f6694b) > ((double) f7);
    }

    private static boolean d(k9 k9Var, long j6, long j7) {
        return j6 > 0 && j7 - j6 < ((long) ((k9Var.f6659g > 10.0f ? 1 : (k9Var.f6659g == 10.0f ? 0 : -1)) >= 0 ? 2000 : 3500));
    }

    private List<l9> f(List<l9> list) {
        Collections.sort(list, new a());
        return list;
    }

    private void g(List<l9> list, List<l9> list2) {
        list.clear();
        if (list2 != null) {
            List<l9> f6 = f(b(list2));
            int size = f6.size();
            if (size > 40) {
                size = 40;
            }
            for (int i6 = 0; i6 < size; i6++) {
                list.add(f6.get(i6));
            }
        }
    }

    final List<l9> a(k9 k9Var, List<l9> list, boolean z5, long j6, long j7) {
        if (h(k9Var, list, z5, j6, j7)) {
            g(this.f6695c, list);
            this.f6693a.clear();
            this.f6693a.addAll(list);
            this.f6694b = k9Var;
            return this.f6695c;
        }
        return null;
    }
}
