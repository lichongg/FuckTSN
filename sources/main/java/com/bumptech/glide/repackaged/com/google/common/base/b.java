package com.bumptech.glide.repackaged.com.google.common.base;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final String f15850a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15851b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(b bVar, String str) {
            super(bVar, null);
            this.f15851b = str;
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.base.b
        CharSequence h(Object obj) {
            return obj == null ? this.f15851b : b.this.h(obj);
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.base.b
        public b i(String str) {
            throw new UnsupportedOperationException("already specified useForNull");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.bumptech.glide.repackaged.com.google.common.base.b$b, reason: collision with other inner class name */
    public static final class C0168b {

        /* renamed from: a, reason: collision with root package name */
        private final b f15853a;

        /* renamed from: b, reason: collision with root package name */
        private final String f15854b;

        /* synthetic */ C0168b(b bVar, String str, a aVar) {
            this(bVar, str);
        }

        private C0168b(b bVar, String str) {
            this.f15853a = bVar;
            this.f15854b = (String) d.i(str);
        }

        public <A extends Appendable> A a(A a6, Iterator<? extends Map.Entry<?, ?>> it) throws IOException {
            d.i(a6);
            if (it.hasNext()) {
                Map.Entry<?, ?> next = it.next();
                a6.append(this.f15853a.h(next.getKey()));
                a6.append(this.f15854b);
                a6.append(this.f15853a.h(next.getValue()));
                while (it.hasNext()) {
                    a6.append(this.f15853a.f15850a);
                    Map.Entry<?, ?> next2 = it.next();
                    a6.append(this.f15853a.h(next2.getKey()));
                    a6.append(this.f15854b);
                    a6.append(this.f15853a.h(next2.getValue()));
                }
            }
            return a6;
        }

        public StringBuilder b(StringBuilder sb, Iterable<? extends Map.Entry<?, ?>> iterable) {
            return c(sb, iterable.iterator());
        }

        public StringBuilder c(StringBuilder sb, Iterator<? extends Map.Entry<?, ?>> it) {
            try {
                a(sb, it);
                return sb;
            } catch (IOException e6) {
                throw new AssertionError(e6);
            }
        }

        public StringBuilder d(StringBuilder sb, Map<?, ?> map) {
            return b(sb, map.entrySet());
        }
    }

    /* synthetic */ b(b bVar, a aVar) {
        this(bVar);
    }

    private b(String str) {
        this.f15850a = (String) d.i(str);
    }

    public static b f(char c6) {
        return new b(String.valueOf(c6));
    }

    public static b g(String str) {
        return new b(str);
    }

    public final String e(Iterator<?> it) {
        return c(new StringBuilder(), it).toString();
    }

    public C0168b j(String str) {
        return new C0168b(this, str, null);
    }

    public <A extends Appendable> A b(A a6, Iterator<?> it) throws IOException {
        d.i(a6);
        if (it.hasNext()) {
            a6.append(h(it.next()));
            while (it.hasNext()) {
                a6.append(this.f15850a);
                a6.append(h(it.next()));
            }
        }
        return a6;
    }

    public final StringBuilder c(StringBuilder sb, Iterator<?> it) {
        try {
            b(sb, it);
            return sb;
        } catch (IOException e6) {
            throw new AssertionError(e6);
        }
    }

    public final String d(Iterable<?> iterable) {
        return e(iterable.iterator());
    }

    CharSequence h(Object obj) {
        d.i(obj);
        if (obj instanceof CharSequence) {
            return (CharSequence) obj;
        }
        return obj.toString();
    }

    public b i(String str) {
        d.i(str);
        return new a(this, str);
    }

    private b(b bVar) {
        this.f15850a = bVar.f15850a;
    }
}
