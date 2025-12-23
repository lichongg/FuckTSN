package kotlin.collections;

import java.util.List;
import java.util.RandomAccess;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class o1<E> extends d<E> implements RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final List<E> f43661a;

    /* renamed from: b, reason: collision with root package name */
    private int f43662b;

    /* renamed from: c, reason: collision with root package name */
    private int f43663c;

    /* JADX WARN: Multi-variable type inference failed */
    public o1(@NotNull List<? extends E> list) {
        kotlin.jvm.internal.g0.p(list, "list");
        this.f43661a = list;
    }

    public final void e(int i6, int i7) {
        d.Companion.d(i6, i7, this.f43661a.size());
        this.f43662b = i6;
        this.f43663c = i7 - i6;
    }

    @Override // kotlin.collections.d, java.util.List
    public E get(int i6) {
        d.Companion.b(i6, this.f43663c);
        return this.f43661a.get(this.f43662b + i6);
    }

    @Override // kotlin.collections.d, kotlin.collections.b
    public int getSize() {
        return this.f43663c;
    }
}
