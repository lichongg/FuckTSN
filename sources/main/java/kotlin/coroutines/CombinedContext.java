package kotlin.coroutines;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import kotlin.SinceKotlin;
import kotlin.coroutines.i;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "1.3")
@SourceDebugExtension({"SMAP\nCoroutineContextImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineContextImpl.kt\nkotlin/coroutines/CombinedContext\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,200:1\n1#2:201\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class CombinedContext implements i, Serializable {

    @NotNull
    private final i.b element;

    @NotNull
    private final i left;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nCoroutineContextImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineContextImpl.kt\nkotlin/coroutines/CombinedContext$Serialized\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,200:1\n13216#2,3:201\n*S KotlinDebug\n*F\n+ 1 CoroutineContextImpl.kt\nkotlin/coroutines/CombinedContext$Serialized\n*L\n197#1:201,3\n*E\n"})
    private static final class a implements Serializable {

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public static final C0862a f43759b = new C0862a(null);
        private static final long serialVersionUID = 0;

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final i[] f43760a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: kotlin.coroutines.CombinedContext$a$a, reason: collision with other inner class name */
        public static final class C0862a {
            public /* synthetic */ C0862a(v vVar) {
                this();
            }

            private C0862a() {
            }
        }

        public a(@NotNull i[] elements) {
            g0.p(elements, "elements");
            this.f43760a = elements;
        }

        private final Object readResolve() {
            i[] iVarArr = this.f43760a;
            i iVar = EmptyCoroutineContext.INSTANCE;
            for (i iVar2 : iVarArr) {
                iVar = iVar.plus(iVar2);
            }
            return iVar;
        }

        @NotNull
        public final i[] a() {
            return this.f43760a;
        }
    }

    private final int size() {
        int i6 = 2;
        CombinedContext combinedContext = this;
        while (true) {
            i iVar = combinedContext.left;
            combinedContext = iVar instanceof CombinedContext ? (CombinedContext) iVar : null;
            if (combinedContext == null) {
                return i6;
            }
            i6++;
        }
    }

    public CombinedContext(@NotNull i left, @NotNull i.b element) {
        g0.p(left, "left");
        g0.p(element, "element");
        this.left = left;
        this.element = element;
    }

    private final boolean containsAll(CombinedContext combinedContext) {
        while (contains(combinedContext.element)) {
            i iVar = combinedContext.left;
            if (!(iVar instanceof CombinedContext)) {
                g0.n(iVar, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                return contains((i.b) iVar);
            }
            combinedContext = (CombinedContext) iVar;
        }
        return false;
    }

    private final void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String toString$lambda$0(String acc, i.b element) {
        g0.p(acc, "acc");
        g0.p(element, "element");
        if (acc.length() == 0) {
            return element.toString();
        }
        return acc + ", " + element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 writeReplace$lambda$0(i[] iVarArr, Ref.IntRef intRef, n1 n1Var, i.b element) {
        g0.p(n1Var, "<unused var>");
        g0.p(element, "element");
        int i6 = intRef.element;
        intRef.element = i6 + 1;
        iVarArr[i6] = element;
        return n1.f44123a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CombinedContext)) {
            return false;
        }
        CombinedContext combinedContext = (CombinedContext) obj;
        return combinedContext.size() == size() && combinedContext.containsAll(this);
    }

    @Override // kotlin.coroutines.i
    public <R> R fold(R r5, @NotNull Function2<? super R, ? super i.b, ? extends R> operation) {
        g0.p(operation, "operation");
        return operation.invoke((Object) this.left.fold(r5, operation), this.element);
    }

    @Override // kotlin.coroutines.i
    @Nullable
    public <E extends i.b> E get(@NotNull i.c<E> key) {
        g0.p(key, "key");
        CombinedContext combinedContext = this;
        while (true) {
            E e6 = (E) combinedContext.element.get(key);
            if (e6 != null) {
                return e6;
            }
            i iVar = combinedContext.left;
            if (!(iVar instanceof CombinedContext)) {
                return (E) iVar.get(key);
            }
            combinedContext = (CombinedContext) iVar;
        }
    }

    public int hashCode() {
        return this.left.hashCode() + this.element.hashCode();
    }

    @Override // kotlin.coroutines.i
    @NotNull
    public i minusKey(@NotNull i.c<?> key) {
        g0.p(key, "key");
        if (this.element.get(key) != null) {
            return this.left;
        }
        i minusKey = this.left.minusKey(key);
        return minusKey == this.left ? this : minusKey == EmptyCoroutineContext.INSTANCE ? this.element : new CombinedContext(minusKey, this.element);
    }

    @NotNull
    public String toString() {
        return '[' + ((String) fold("", new Function2() { // from class: kotlin.coroutines.d
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                String string$lambda$0;
                string$lambda$0 = CombinedContext.toString$lambda$0((String) obj, (i.b) obj2);
                return string$lambda$0;
            }
        })) + ']';
    }

    private final boolean contains(i.b bVar) {
        return g0.g(get(bVar.getKey()), bVar);
    }

    private final Object writeReplace() {
        int size = size();
        final i[] iVarArr = new i[size];
        final Ref.IntRef intRef = new Ref.IntRef();
        fold(n1.f44123a, new Function2() { // from class: kotlin.coroutines.c
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                n1 writeReplace$lambda$0;
                writeReplace$lambda$0 = CombinedContext.writeReplace$lambda$0(iVarArr, intRef, (n1) obj, (i.b) obj2);
                return writeReplace$lambda$0;
            }
        });
        if (intRef.element == size) {
            return new a(iVarArr);
        }
        throw new IllegalStateException("Check failed.");
    }

    @Override // kotlin.coroutines.i
    @NotNull
    public /* bridge */ i plus(@NotNull i iVar) {
        return i.a.b(this, iVar);
    }
}
