package kotlin.text;

import java.util.Iterator;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.jvm.functions.Function1;
import kotlin.text.p;
import kotlin.text.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class q implements p {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final Matcher f47936a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final CharSequence f47937b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final n f47938c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private List<String> f47939d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a extends kotlin.collections.d<String> {
        @Override // kotlin.collections.b, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof String) {
                return contains((String) obj);
            }
            return false;
        }

        a() {
        }

        public /* bridge */ boolean contains(String str) {
            return super.contains((Object) str);
        }

        @Override // kotlin.collections.d, java.util.List
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public String get(int i6) {
            String group = q.this.f().group(i6);
            return group == null ? "" : group;
        }

        @Override // kotlin.collections.d, kotlin.collections.b
        public int getSize() {
            return q.this.f().groupCount() + 1;
        }

        @Override // kotlin.collections.d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof String) {
                return f((String) obj);
            }
            return -1;
        }

        @Override // kotlin.collections.d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof String) {
                return g((String) obj);
            }
            return -1;
        }

        public /* bridge */ int f(String str) {
            return super.indexOf(str);
        }

        public /* bridge */ int g(String str) {
            return super.lastIndexOf(str);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b extends kotlin.collections.b<m> implements o {
        @Override // kotlin.text.n
        public m get(int i6) {
            kotlin.ranges.m j6;
            j6 = t.j(q.this.f(), i6);
            if (j6.getStart().intValue() < 0) {
                return null;
            }
            String group = q.this.f().group(i6);
            kotlin.jvm.internal.g0.o(group, "group(...)");
            return new m(group, j6);
        }

        @Override // kotlin.collections.b, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        b() {
        }

        @Override // kotlin.collections.b, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj == null ? true : obj instanceof m) {
                return f((m) obj);
            }
            return false;
        }

        @Override // kotlin.collections.b
        public int getSize() {
            return q.this.f().groupCount() + 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final m g(b bVar, int i6) {
            return bVar.get(i6);
        }

        public /* bridge */ boolean f(m mVar) {
            return super.contains(mVar);
        }

        @Override // kotlin.collections.b, java.util.Collection, java.lang.Iterable
        public Iterator<m> iterator() {
            return kotlin.sequences.p.N1(kotlin.collections.f0.E1(kotlin.collections.f0.K(this)), new Function1() { // from class: kotlin.text.r
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    m g6;
                    g6 = q.b.g(q.b.this, ((Integer) obj).intValue());
                    return g6;
                }
            }).iterator();
        }

        @Override // kotlin.text.o
        public m get(String name) {
            kotlin.jvm.internal.g0.p(name, "name");
            return kotlin.internal.b.f43804a.c(q.this.f(), name);
        }
    }

    public q(@NotNull Matcher matcher, @NotNull CharSequence input) {
        kotlin.jvm.internal.g0.p(matcher, "matcher");
        kotlin.jvm.internal.g0.p(input, "input");
        this.f47936a = matcher;
        this.f47937b = input;
        this.f47938c = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MatchResult f() {
        return this.f47936a;
    }

    @Override // kotlin.text.p
    @NotNull
    public n b() {
        return this.f47938c;
    }

    @Override // kotlin.text.p
    @NotNull
    public List<String> c() {
        if (this.f47939d == null) {
            this.f47939d = new a();
        }
        List<String> list = this.f47939d;
        kotlin.jvm.internal.g0.m(list);
        return list;
    }

    @Override // kotlin.text.p
    @NotNull
    public /* bridge */ p.b a() {
        return p.a.a(this);
    }

    @Override // kotlin.text.p
    @NotNull
    public kotlin.ranges.m d() {
        kotlin.ranges.m i6;
        i6 = t.i(f());
        return i6;
    }

    @Override // kotlin.text.p
    @NotNull
    public String getValue() {
        String group = f().group();
        kotlin.jvm.internal.g0.o(group, "group(...)");
        return group;
    }

    @Override // kotlin.text.p
    @Nullable
    public p next() {
        int i6;
        p f6;
        int end = f().end();
        if (f().end() == f().start()) {
            i6 = 1;
        } else {
            i6 = 0;
        }
        int i7 = end + i6;
        if (i7 <= this.f47937b.length()) {
            Matcher matcher = this.f47936a.pattern().matcher(this.f47937b);
            kotlin.jvm.internal.g0.o(matcher, "matcher(...)");
            f6 = t.f(matcher, i7, this.f47937b);
            return f6;
        }
        return null;
    }
}
