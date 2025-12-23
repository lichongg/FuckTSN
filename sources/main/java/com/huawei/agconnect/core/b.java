package com.huawei.agconnect.core;

import com.huawei.agconnect.annotation.AutoCreated;
import com.huawei.agconnect.annotation.SharedInstance;
import com.huawei.agconnect.annotation.Singleton;
import java.lang.reflect.Modifier;

/* loaded from: D:\Downloads\app\classes5.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final Class<?> f32977a;

    /* renamed from: b, reason: collision with root package name */
    private final Class<?> f32978b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f32979c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f32980d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f32981e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f32982f;

    static /* synthetic */ class a {
    }

    /* renamed from: com.huawei.agconnect.core.b$b, reason: collision with other inner class name */
    public static class C0539b {

        /* renamed from: a, reason: collision with root package name */
        Class<?> f32983a;

        /* renamed from: b, reason: collision with root package name */
        Class<?> f32984b;

        /* renamed from: c, reason: collision with root package name */
        Object f32985c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f32986d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f32987e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f32988f;

        public b a() {
            Class<?> cls = this.f32983a;
            if (cls == null) {
                throw new IllegalArgumentException("the interface parameter cannot be NULL");
            }
            Class<?> cls2 = this.f32984b;
            a aVar = null;
            if (cls2 == null) {
                Object obj = this.f32985c;
                if (obj == null) {
                    throw new IllegalArgumentException("the clazz or object parameter must set one");
                }
                b bVar = new b(cls, obj, aVar);
                bVar.f32980d = this.f32986d;
                return bVar;
            }
            if (cls2.isInterface() || !Modifier.isPublic(this.f32984b.getModifiers())) {
                throw new IllegalArgumentException("the clazz parameter cant be interface type or not public");
            }
            b bVar2 = new b((Class) this.f32983a, (Class) this.f32984b, aVar);
            bVar2.f32980d = this.f32986d;
            bVar2.f32981e = this.f32987e;
            bVar2.f32982f = this.f32988f;
            return bVar2;
        }

        public C0539b b(boolean z5) {
            this.f32988f = z5;
            return this;
        }

        public C0539b c(boolean z5) {
            this.f32987e = z5;
            return this;
        }

        public C0539b d(boolean z5) {
            this.f32986d = z5;
            return this;
        }

        public C0539b e(Class<?> cls) {
            this.f32984b = cls;
            return this;
        }

        public C0539b f(Class<?> cls) {
            this.f32983a = cls;
            return this;
        }

        public C0539b g(Object obj) {
            this.f32985c = obj;
            return this;
        }
    }

    private b(Class<?> cls, Class<?> cls2) {
        this.f32977a = cls;
        this.f32978b = cls2;
        this.f32979c = null;
    }

    /* synthetic */ b(Class cls, Class cls2, a aVar) {
        this((Class<?>) cls, (Class<?>) cls2);
    }

    public static C0539b c(Class<?> cls) {
        return new C0539b().f(cls).e(cls).d(cls.isAnnotationPresent(Singleton.class)).c(cls.isAnnotationPresent(SharedInstance.class)).b(cls.isAnnotationPresent(AutoCreated.class));
    }

    public static C0539b d(Class<?> cls, Class<?> cls2) {
        return new C0539b().f(cls).e(cls2).d(cls2.isAnnotationPresent(Singleton.class)).c(cls2.isAnnotationPresent(SharedInstance.class)).b(cls2.isAnnotationPresent(AutoCreated.class));
    }

    public static C0539b e(Class<?> cls, Object obj) {
        return new C0539b().f(cls).g(obj).d(true).c(cls.isAnnotationPresent(SharedInstance.class)).b(cls.isAnnotationPresent(AutoCreated.class));
    }

    public Object g() {
        return this.f32979c;
    }

    public Class<?> getType() {
        return this.f32978b;
    }

    public Class<?> h() {
        return this.f32977a;
    }

    public boolean i() {
        return this.f32982f;
    }

    public boolean j() {
        return this.f32981e;
    }

    public boolean k() {
        return this.f32980d;
    }

    private b(Class<?> cls, Object obj) {
        this.f32977a = cls;
        this.f32978b = null;
        this.f32979c = obj;
    }

    /* synthetic */ b(Class cls, Object obj, a aVar) {
        this((Class<?>) cls, obj);
    }
}
