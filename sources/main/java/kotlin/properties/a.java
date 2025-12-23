package kotlin.properties;

import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import kotlin.reflect.n;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f44133a = new a();

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nDelegates.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delegates.kt\nkotlin/properties/Delegates$observable$1\n*L\n1#1,73:1\n*E\n"})
    /* renamed from: kotlin.properties.a$a, reason: collision with other inner class name */
    public static final class C0869a<T> extends c<T> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function3<n<?>, T, T, n1> f44134b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C0869a(T t5, Function3<? super n<?>, ? super T, ? super T, n1> function3) {
            super(t5);
            this.f44134b = function3;
        }

        @Override // kotlin.properties.c
        protected void c(n<?> property, T t5, T t6) {
            g0.p(property, "property");
            this.f44134b.invoke(property, t5, t6);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nDelegates.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delegates.kt\nkotlin/properties/Delegates$vetoable$1\n*L\n1#1,73:1\n*E\n"})
    public static final class b<T> extends c<T> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function3<n<?>, T, T, Boolean> f44135b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(T t5, Function3<? super n<?>, ? super T, ? super T, Boolean> function3) {
            super(t5);
            this.f44135b = function3;
        }

        @Override // kotlin.properties.c
        protected boolean d(n<?> property, T t5, T t6) {
            g0.p(property, "property");
            return this.f44135b.invoke(property, t5, t6).booleanValue();
        }
    }

    @NotNull
    public final <T> f<Object, T> a() {
        return new kotlin.properties.b();
    }

    @NotNull
    public final <T> f<Object, T> b(T t5, @NotNull Function3<? super n<?>, ? super T, ? super T, n1> onChange) {
        g0.p(onChange, "onChange");
        return new C0869a(t5, onChange);
    }

    @NotNull
    public final <T> f<Object, T> c(T t5, @NotNull Function3<? super n<?>, ? super T, ? super T, Boolean> onChange) {
        g0.p(onChange, "onChange");
        return new b(t5, onChange);
    }

    private a() {
    }
}
