package kotlin.collections;

import java.util.Enumeration;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class j0 extends i0 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a<T> implements Iterator<T>, m3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Enumeration<T> f43650a;

        a(Enumeration<T> enumeration) {
            this.f43650a = enumeration;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f43650a.hasMoreElements();
        }

        @Override // java.util.Iterator
        public T next() {
            return this.f43650a.nextElement();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @NotNull
    public static <T> Iterator<T> h0(@NotNull Enumeration<T> enumeration) {
        kotlin.jvm.internal.g0.p(enumeration, "<this>");
        return new a(enumeration);
    }
}
