package kotlin.reflect.jvm.internal.impl.util;

import java.util.Arrays;
import java.util.Iterator;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nArrayMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ArrayMap.kt\norg/jetbrains/kotlin/util/ArrayMapImpl\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,145:1\n11408#2,11:146\n13537#2,2:157\n13539#2:160\n11419#2:161\n1#3:159\n*S KotlinDebug\n*F\n+ 1 ArrayMap.kt\norg/jetbrains/kotlin/util/ArrayMapImpl\n*L\n140#1:146,11\n140#1:157,2\n140#1:160\n140#1:161\n140#1:159\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class d<T> extends c<T> {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f47387c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private Object[] f47388a;

    /* renamed from: b, reason: collision with root package name */
    private int f47389b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b extends kotlin.collections.c<T> {

        /* renamed from: c, reason: collision with root package name */
        private int f47390c = -1;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d<T> f47391d;

        b(d<T> dVar) {
            this.f47391d = dVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.collections.c
        protected void a() {
            do {
                int i6 = this.f47390c + 1;
                this.f47390c = i6;
                if (i6 >= ((d) this.f47391d).f47388a.length) {
                    break;
                }
            } while (((d) this.f47391d).f47388a[this.f47390c] == null);
            if (this.f47390c >= ((d) this.f47391d).f47388a.length) {
                c();
                return;
            }
            Object obj = ((d) this.f47391d).f47388a[this.f47390c];
            g0.n(obj, "null cannot be cast to non-null type T of org.jetbrains.kotlin.util.ArrayMapImpl");
            e(obj);
        }
    }

    private d(Object[] objArr, int i6) {
        super(null);
        this.f47388a = objArr;
        this.f47389b = i6;
    }

    private final void f(int i6) {
        Object[] objArr = this.f47388a;
        if (objArr.length > i6) {
            return;
        }
        int length = objArr.length;
        do {
            length *= 2;
        } while (length <= i6);
        Object[] copyOf = Arrays.copyOf(this.f47388a, length);
        g0.o(copyOf, "copyOf(...)");
        this.f47388a = copyOf;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.c
    public int a() {
        return this.f47389b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.c
    public void d(int i6, @NotNull T value) {
        g0.p(value, "value");
        f(i6);
        if (this.f47388a[i6] == null) {
            this.f47389b = a() + 1;
        }
        this.f47388a[i6] = value;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.c
    @Nullable
    public T get(int i6) {
        return (T) kotlin.collections.n.hf(this.f47388a, i6);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.c, java.lang.Iterable
    @NotNull
    public Iterator<T> iterator() {
        return new b(this);
    }

    public d() {
        this(new Object[20], 0);
    }
}
