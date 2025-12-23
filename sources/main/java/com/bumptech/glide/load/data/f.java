package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.data.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class f {

    /* renamed from: b, reason: collision with root package name */
    private static final e.a<?> f14931b = new a();

    /* renamed from: a, reason: collision with root package name */
    private final Map<Class<?>, e.a<?>> f14932a = new HashMap();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements e.a<Object> {
        @Override // com.bumptech.glide.load.data.e.a
        @NonNull
        public Class<Object> a() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override // com.bumptech.glide.load.data.e.a
        @NonNull
        public e<Object> b(@NonNull Object obj) {
            return new b(obj);
        }

        a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class b implements e<Object> {

        /* renamed from: a, reason: collision with root package name */
        private final Object f14933a;

        @Override // com.bumptech.glide.load.data.e
        @NonNull
        public Object a() {
            return this.f14933a;
        }

        b(@NonNull Object obj) {
            this.f14933a = obj;
        }

        @Override // com.bumptech.glide.load.data.e
        public void b() {
        }
    }

    @NonNull
    public synchronized <T> e<T> a(@NonNull T t5) {
        e.a<?> aVar;
        try {
            com.bumptech.glide.util.k.d(t5);
            aVar = this.f14932a.get(t5.getClass());
            if (aVar == null) {
                Iterator<e.a<?>> it = this.f14932a.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    e.a<?> next = it.next();
                    if (next.a().isAssignableFrom(t5.getClass())) {
                        aVar = next;
                        break;
                    }
                }
            }
            if (aVar == null) {
                aVar = f14931b;
            }
        } catch (Throwable th) {
            throw th;
        }
        return (e<T>) aVar.b(t5);
    }

    public synchronized void b(@NonNull e.a<?> aVar) {
        this.f14932a.put(aVar.a(), aVar);
    }
}
