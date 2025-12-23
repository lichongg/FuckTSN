package kotlin.reflect.jvm.internal.impl.utils;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class b {

    /* JADX INFO: Add missing generic type declarations: [N] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a<N> extends AbstractC0925b<N, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1 f47471a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean[] f47472b;

        a(Function1 function1, boolean[] zArr) {
            this.f47471a = function1;
            this.f47472b = zArr;
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b.AbstractC0925b, kotlin.reflect.jvm.internal.impl.utils.b.e
        public boolean b(N n6) {
            if (((Boolean) this.f47471a.invoke(n6)).booleanValue()) {
                this.f47472b[0] = true;
            }
            return !this.f47472b[0];
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Boolean a() {
            return Boolean.valueOf(this.f47472b[0]);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class c<N, R, C extends Iterable<R>> extends AbstractC0925b<N, C> {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        protected final C f47473a;

        private static /* synthetic */ void d(int i6) {
            String str = i6 != 1 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i6 != 1 ? 3 : 2];
            if (i6 != 1) {
                objArr[0] = "result";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/DFS$CollectingNodeHandler";
            }
            if (i6 != 1) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/DFS$CollectingNodeHandler";
            } else {
                objArr[1] = "result";
            }
            if (i6 != 1) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i6 == 1) {
                throw new IllegalStateException(format);
            }
        }

        protected c(@NotNull C c6) {
            if (c6 == null) {
                d(0);
            }
            this.f47473a = c6;
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b.e
        @NotNull
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public C a() {
            C c6 = this.f47473a;
            if (c6 == null) {
                d(1);
            }
            return c6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface d<N> {
        @NotNull
        Iterable<? extends N> a(N n6);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface e<N, R> {
        R a();

        boolean b(N n6);

        void c(N n6);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class f<N, R> extends c<N, R, LinkedList<R>> {
        protected f() {
            super(new LinkedList());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface g<N> {
        boolean a(N n6);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class h<N> implements g<N> {

        /* renamed from: a, reason: collision with root package name */
        private final Set<N> f47474a;

        public h() {
            this(new HashSet());
        }

        private static /* synthetic */ void b(int i6) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "visited", "kotlin/reflect/jvm/internal/impl/utils/DFS$VisitedWithSet", "<init>"));
        }

        public h(@NotNull Set<N> set) {
            if (set == null) {
                b(0);
            }
            this.f47474a = set;
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b.g
        public boolean a(N n6) {
            return this.f47474a.add(n6);
        }
    }

    private static /* synthetic */ void a(int i6) {
        Object[] objArr = new Object[3];
        switch (i6) {
            case 1:
            case 5:
            case 8:
            case 11:
            case 15:
            case 18:
            case 21:
            case 23:
                objArr[0] = "neighbors";
                break;
            case 2:
            case 12:
            case 16:
            case 19:
            case 24:
                objArr[0] = "visited";
                break;
            case 3:
            case 6:
            case 13:
            case 25:
                objArr[0] = "handler";
                break;
            case 4:
            case 7:
            case 17:
            case 20:
            default:
                objArr[0] = "nodes";
                break;
            case 9:
                objArr[0] = "predicate";
                break;
            case 10:
            case 14:
                objArr[0] = "node";
                break;
            case 22:
                objArr[0] = "current";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/DFS";
        switch (i6) {
            case 7:
            case 8:
            case 9:
                objArr[2] = "ifAny";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
                objArr[2] = "dfsFromNode";
                break;
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                objArr[2] = "topologicalOrder";
                break;
            case 22:
            case 23:
            case 24:
            case 25:
                objArr[2] = "doDfs";
                break;
            default:
                objArr[2] = "dfs";
                break;
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public static <N, R> R b(@NotNull Collection<N> collection, @NotNull d<N> dVar, @NotNull e<N, R> eVar) {
        if (collection == null) {
            a(4);
        }
        if (dVar == null) {
            a(5);
        }
        if (eVar == null) {
            a(6);
        }
        return (R) c(collection, dVar, new h(), eVar);
    }

    public static <N, R> R c(@NotNull Collection<N> collection, @NotNull d<N> dVar, @NotNull g<N> gVar, @NotNull e<N, R> eVar) {
        if (collection == null) {
            a(0);
        }
        if (dVar == null) {
            a(1);
        }
        if (gVar == null) {
            a(2);
        }
        if (eVar == null) {
            a(3);
        }
        Iterator<N> it = collection.iterator();
        while (it.hasNext()) {
            d(it.next(), dVar, gVar, eVar);
        }
        return eVar.a();
    }

    public static <N> void d(@NotNull N n6, @NotNull d<N> dVar, @NotNull g<N> gVar, @NotNull e<N, ?> eVar) {
        if (n6 == null) {
            a(22);
        }
        if (dVar == null) {
            a(23);
        }
        if (gVar == null) {
            a(24);
        }
        if (eVar == null) {
            a(25);
        }
        if (gVar.a(n6) && eVar.b(n6)) {
            Iterator<? extends N> it = dVar.a(n6).iterator();
            while (it.hasNext()) {
                d(it.next(), dVar, gVar, eVar);
            }
            eVar.c(n6);
        }
    }

    public static <N> Boolean e(@NotNull Collection<N> collection, @NotNull d<N> dVar, @NotNull Function1<N, Boolean> function1) {
        if (collection == null) {
            a(7);
        }
        if (dVar == null) {
            a(8);
        }
        if (function1 == null) {
            a(9);
        }
        return (Boolean) b(collection, dVar, new a(function1, new boolean[1]));
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: kotlin.reflect.jvm.internal.impl.utils.b$b, reason: collision with other inner class name */
    public static abstract class AbstractC0925b<N, R> implements e<N, R> {
        @Override // kotlin.reflect.jvm.internal.impl.utils.b.e
        public boolean b(N n6) {
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b.e
        public void c(N n6) {
        }
    }
}
