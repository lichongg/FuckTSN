package com.bumptech.glide;

import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final Map<Class<?>, b> f14787a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final Map<Class<?>, b> f14788a = new HashMap();

        a b(b bVar) {
            this.f14788a.put(bVar.getClass(), bVar);
            return this;
        }

        e c() {
            return new e(this);
        }

        a update(b bVar, boolean z5) {
            if (z5) {
                b(bVar);
                return this;
            }
            this.f14788a.remove(bVar.getClass());
            return this;
        }

        a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface b {
    }

    @Nullable
    <T extends b> T a(Class<T> cls) {
        return (T) this.f14787a.get(cls);
    }

    public boolean b(Class<? extends b> cls) {
        return this.f14787a.containsKey(cls);
    }

    e(a aVar) {
        this.f14787a = Collections.unmodifiableMap(new HashMap(aVar.f14788a));
    }
}
