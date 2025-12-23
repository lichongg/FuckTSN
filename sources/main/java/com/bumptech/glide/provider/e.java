package com.bumptech.glide.provider;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final List<String> f15842a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, List<a<?, ?>>> f15843b = new HashMap();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a<T, R> {

        /* renamed from: a, reason: collision with root package name */
        private final Class<T> f15844a;

        /* renamed from: b, reason: collision with root package name */
        final Class<R> f15845b;

        /* renamed from: c, reason: collision with root package name */
        final g<T, R> f15846c;

        public boolean a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return this.f15844a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f15845b);
        }

        public a(@NonNull Class<T> cls, @NonNull Class<R> cls2, g<T, R> gVar) {
            this.f15844a = cls;
            this.f15845b = cls2;
            this.f15846c = gVar;
        }
    }

    @NonNull
    private synchronized List<a<?, ?>> c(@NonNull String str) {
        List<a<?, ?>> list;
        try {
            if (!this.f15842a.contains(str)) {
                this.f15842a.add(str);
            }
            list = this.f15843b.get(str);
            if (list == null) {
                list = new ArrayList<>();
                this.f15843b.put(str, list);
            }
        } catch (Throwable th) {
            throw th;
        }
        return list;
    }

    public synchronized <T, R> void a(@NonNull String str, @NonNull g<T, R> gVar, @NonNull Class<T> cls, @NonNull Class<R> cls2) {
        c(str).add(new a<>(cls, cls2, gVar));
    }

    @NonNull
    public synchronized <T, R> List<g<T, R>> b(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<String> it = this.f15842a.iterator();
        while (it.hasNext()) {
            List<a<?, ?>> list = this.f15843b.get(it.next());
            if (list != null) {
                for (a<?, ?> aVar : list) {
                    if (aVar.a(cls, cls2)) {
                        arrayList.add(aVar.f15846c);
                    }
                }
            }
        }
        return arrayList;
    }

    @NonNull
    public synchronized <T, R> List<Class<R>> d(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<String> it = this.f15842a.iterator();
        while (it.hasNext()) {
            List<a<?, ?>> list = this.f15843b.get(it.next());
            if (list != null) {
                for (a<?, ?> aVar : list) {
                    if (aVar.a(cls, cls2) && !arrayList.contains(aVar.f15845b)) {
                        arrayList.add(aVar.f15845b);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized <T, R> void e(@NonNull String str, @NonNull g<T, R> gVar, @NonNull Class<T> cls, @NonNull Class<R> cls2) {
        c(str).add(0, new a<>(cls, cls2, gVar));
    }

    public synchronized void f(@NonNull List<String> list) {
        try {
            ArrayList<String> arrayList = new ArrayList(this.f15842a);
            this.f15842a.clear();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                this.f15842a.add(it.next());
            }
            for (String str : arrayList) {
                if (!list.contains(str)) {
                    this.f15842a.add(str);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
