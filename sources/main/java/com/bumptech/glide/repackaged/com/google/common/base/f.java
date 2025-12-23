package com.bumptech.glide.repackaged.com.google.common.base;

import io.netty.util.internal.StringUtil;
import java.io.Serializable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private static final com.bumptech.glide.repackaged.com.google.common.base.b f15855a = com.bumptech.glide.repackaged.com.google.common.base.b.f(StringUtil.COMMA);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b<T> implements e<T>, Serializable {

        /* renamed from: a, reason: collision with root package name */
        private final T f15856a;

        /* synthetic */ b(Object obj, a aVar) {
            this(obj);
        }

        private b(T t5) {
            this.f15856a = t5;
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.base.e
        public boolean apply(T t5) {
            return this.f15856a.equals(t5);
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.f15856a.equals(((b) obj).f15856a);
            }
            return false;
        }

        public int hashCode() {
            return this.f15856a.hashCode();
        }

        public String toString() {
            return "Predicates.equalTo(" + this.f15856a + ")";
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static abstract class c implements e<Object> {

        /* renamed from: a, reason: collision with root package name */
        public static final c f15857a;

        /* renamed from: b, reason: collision with root package name */
        public static final c f15858b;

        /* renamed from: c, reason: collision with root package name */
        public static final c f15859c;

        /* renamed from: d, reason: collision with root package name */
        public static final c f15860d;

        /* renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ c[] f15861e;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        enum a extends c {
            a(String str, int i6) {
                super(str, i6, null);
            }

            @Override // com.bumptech.glide.repackaged.com.google.common.base.e
            public boolean apply(Object obj) {
                return true;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.alwaysTrue()";
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        enum b extends c {
            b(String str, int i6) {
                super(str, i6, null);
            }

            @Override // com.bumptech.glide.repackaged.com.google.common.base.e
            public boolean apply(Object obj) {
                return false;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.alwaysFalse()";
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bumptech.glide.repackaged.com.google.common.base.f$c$c, reason: collision with other inner class name */
        enum C0169c extends c {
            C0169c(String str, int i6) {
                super(str, i6, null);
            }

            @Override // com.bumptech.glide.repackaged.com.google.common.base.e
            public boolean apply(Object obj) {
                return obj == null;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.isNull()";
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        enum d extends c {
            d(String str, int i6) {
                super(str, i6, null);
            }

            @Override // com.bumptech.glide.repackaged.com.google.common.base.e
            public boolean apply(Object obj) {
                return obj != null;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.notNull()";
            }
        }

        private c(String str, int i6) {
        }

        static {
            a aVar = new a("ALWAYS_TRUE", 0);
            f15857a = aVar;
            b bVar = new b("ALWAYS_FALSE", 1);
            f15858b = bVar;
            C0169c c0169c = new C0169c("IS_NULL", 2);
            f15859c = c0169c;
            d dVar = new d("NOT_NULL", 3);
            f15860d = dVar;
            f15861e = new c[]{aVar, bVar, c0169c, dVar};
        }

        /* synthetic */ c(String str, int i6, a aVar) {
            this(str, i6);
        }

        <T> e<T> a() {
            return this;
        }
    }

    public static <T> e<T> a(T t5) {
        return t5 == null ? b() : new b(t5, null);
    }

    public static <T> e<T> b() {
        return c.f15859c.a();
    }

    public static <T> e<T> c() {
        return c.f15860d.a();
    }
}
