package cn.jiguang.bg;

import android.content.Context;
import android.text.TextUtils;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;

/* loaded from: D:\Downloads\app\classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final Comparator<d> f2077a = new Comparator<d>() { // from class: cn.jiguang.bg.e.1
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(d dVar, d dVar2) {
            if (dVar.equals(dVar2)) {
                return 0;
            }
            int i6 = dVar.f2073b;
            int i7 = dVar2.f2073b;
            if (i6 > i7) {
                return -1;
            }
            if (i6 < i7) {
                return 1;
            }
            int i8 = dVar.f2076e;
            int i9 = dVar2.f2076e;
            if (i8 > i9) {
                return -1;
            }
            if (i8 < i9) {
                return 1;
            }
            long j6 = dVar.f2075d;
            if (j6 != 0) {
                long j7 = dVar2.f2075d;
                if (j7 != 0) {
                    if (j6 < j7) {
                        return -1;
                    }
                    if (j6 > j7) {
                        return 1;
                    }
                }
            }
            long j8 = dVar.f2074c;
            if (j8 != 0) {
                long j9 = dVar2.f2074c;
                if (j9 != 0) {
                    if (j8 > j9 + 180000) {
                        return -1;
                    }
                    if (j8 < j9 - 180000) {
                        return 1;
                    }
                }
            }
            return 0;
        }
    };

    public static LinkedHashSet<g> a(Context context, LinkedHashSet<g> linkedHashSet, long j6) {
        if ((linkedHashSet != null ? linkedHashSet.size() : 0) == 0) {
            return new LinkedHashSet<>();
        }
        LinkedList linkedList = new LinkedList();
        Iterator<g> it = linkedHashSet.iterator();
        boolean z5 = true;
        while (it.hasNext()) {
            g next = it.next();
            if (next.a()) {
                cn.jiguang.e.a<String> f6 = cn.jiguang.e.a.f(next.toString());
                cn.jiguang.e.a<String> g6 = cn.jiguang.e.a.g(next.toString());
                String str = (String) cn.jiguang.e.b.a(context, g6);
                if (TextUtils.isEmpty(str)) {
                    str = (String) cn.jiguang.e.b.a(context, f6);
                }
                d a6 = d.a(str);
                if (a6 == null) {
                    a6 = new d(next);
                }
                if (z5) {
                    a6.f2076e = 1;
                    z5 = false;
                }
                if (j6 > 0) {
                    a6.f2074c = j6;
                    cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{g6.a((cn.jiguang.e.a<String>) a6.a())});
                }
                linkedList.add(a6);
            }
        }
        return a(context, (LinkedList<LinkedList<d>>) a(linkedList, f2077a));
    }

    public static LinkedHashSet<g> a(Context context, LinkedList<LinkedList<d>> linkedList) {
        boolean e6 = cn.jiguang.bz.b.e(context);
        LinkedHashSet<g> linkedHashSet = new LinkedHashSet<>();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<LinkedList<d>> it = linkedList.iterator();
        while (it.hasNext()) {
            Iterator<d> it2 = it.next().iterator();
            while (it2.hasNext()) {
                g gVar = it2.next().f2072a;
                if (gVar.f2081a.contains(":")) {
                    arrayList.add(gVar);
                } else {
                    arrayList2.add(gVar);
                }
            }
        }
        linkedHashSet.clear();
        if (e6) {
            linkedHashSet.addAll(arrayList);
            linkedHashSet.addAll(arrayList2);
            return linkedHashSet;
        }
        linkedHashSet.addAll(arrayList2);
        linkedHashSet.addAll(arrayList);
        return linkedHashSet;
    }

    private static <T> LinkedList<LinkedList<T>> a(Collection<T> collection, Comparator<T> comparator) {
        int size = collection != null ? collection.size() : 0;
        if (size == 0) {
            return new LinkedList<>();
        }
        LinkedList<LinkedList<T>> linkedList = new LinkedList<>();
        if (size == 1) {
            linkedList.add(new LinkedList<>(collection));
            return linkedList;
        }
        SecureRandom secureRandom = new SecureRandom();
        for (T t5 : collection) {
            int i6 = 0;
            while (true) {
                if (i6 >= linkedList.size()) {
                    LinkedList<T> linkedList2 = new LinkedList<>();
                    linkedList2.add(t5);
                    linkedList.add(linkedList2);
                    break;
                }
                LinkedList<T> linkedList3 = linkedList.get(i6);
                int compare = comparator.compare(t5, linkedList3.get(0));
                if (compare == 0) {
                    linkedList3.add(secureRandom.nextInt(linkedList3.size() + 1), t5);
                    break;
                }
                if (compare < 0) {
                    LinkedList<T> linkedList4 = new LinkedList<>();
                    linkedList4.add(t5);
                    linkedList.add(i6, linkedList4);
                    break;
                }
                i6++;
            }
        }
        return linkedList;
    }

    public static void a(Context context, g gVar, int i6, long j6) {
        if (gVar != null) {
            cn.jiguang.e.a<String> f6 = cn.jiguang.e.a.f(gVar.toString());
            cn.jiguang.e.a<String> g6 = cn.jiguang.e.a.g(gVar.toString());
            String str = (String) cn.jiguang.e.b.a(context, g6);
            if (TextUtils.isEmpty(str)) {
                str = (String) cn.jiguang.e.b.a(context, f6);
            }
            d a6 = d.a(str);
            if (a6 == null) {
                a6 = new d(gVar);
            }
            a6.f2075d = j6;
            a6.f2073b = i6;
            cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{g6.a((cn.jiguang.e.a<String>) a6.a())});
        }
    }
}
