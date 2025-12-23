package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class g implements kotlin.sequences.m<kotlin.ranges.m> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final CharSequence f47860a;

    /* renamed from: b, reason: collision with root package name */
    private final int f47861b;

    /* renamed from: c, reason: collision with root package name */
    private final int f47862c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final Function2<CharSequence, Integer, Pair<Integer, Integer>> f47863d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements Iterator<kotlin.ranges.m>, m3.a {

        /* renamed from: a, reason: collision with root package name */
        private int f47864a = -1;

        /* renamed from: b, reason: collision with root package name */
        private int f47865b;

        /* renamed from: c, reason: collision with root package name */
        private int f47866c;

        /* renamed from: d, reason: collision with root package name */
        private kotlin.ranges.m f47867d;

        /* renamed from: e, reason: collision with root package name */
        private int f47868e;

        a() {
            int I = kotlin.ranges.t.I(g.this.f47861b, 0, g.this.f47860a.length());
            this.f47865b = I;
            this.f47866c = I;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0020, code lost:
        
            if (r0 < r6.f47869f.f47862c) goto L10;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final void a() {
            /*
                r6 = this;
                int r0 = r6.f47866c
                r1 = 0
                if (r0 >= 0) goto Lb
                r6.f47864a = r1
                r0 = 0
                r6.f47867d = r0
                return
            Lb:
                kotlin.text.g r0 = kotlin.text.g.this
                int r0 = kotlin.text.g.e(r0)
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L22
                int r0 = r6.f47868e
                int r0 = r0 + r3
                r6.f47868e = r0
                kotlin.text.g r4 = kotlin.text.g.this
                int r4 = kotlin.text.g.e(r4)
                if (r0 >= r4) goto L30
            L22:
                int r0 = r6.f47866c
                kotlin.text.g r4 = kotlin.text.g.this
                java.lang.CharSequence r4 = kotlin.text.g.d(r4)
                int r4 = r4.length()
                if (r0 <= r4) goto L46
            L30:
                kotlin.ranges.m r0 = new kotlin.ranges.m
                int r1 = r6.f47865b
                kotlin.text.g r4 = kotlin.text.g.this
                java.lang.CharSequence r4 = kotlin.text.g.d(r4)
                int r4 = kotlin.text.l0.y3(r4)
                r0.<init>(r1, r4)
                r6.f47867d = r0
                r6.f47866c = r2
                goto L9b
            L46:
                kotlin.text.g r0 = kotlin.text.g.this
                kotlin.jvm.functions.Function2 r0 = kotlin.text.g.c(r0)
                kotlin.text.g r4 = kotlin.text.g.this
                java.lang.CharSequence r4 = kotlin.text.g.d(r4)
                int r5 = r6.f47866c
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.invoke(r4, r5)
                kotlin.Pair r0 = (kotlin.Pair) r0
                if (r0 != 0) goto L76
                kotlin.ranges.m r0 = new kotlin.ranges.m
                int r1 = r6.f47865b
                kotlin.text.g r4 = kotlin.text.g.this
                java.lang.CharSequence r4 = kotlin.text.g.d(r4)
                int r4 = kotlin.text.l0.y3(r4)
                r0.<init>(r1, r4)
                r6.f47867d = r0
                r6.f47866c = r2
                goto L9b
            L76:
                java.lang.Object r2 = r0.component1()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.component2()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.f47865b
                kotlin.ranges.m r4 = kotlin.ranges.t.W1(r4, r2)
                r6.f47867d = r4
                int r2 = r2 + r0
                r6.f47865b = r2
                if (r0 != 0) goto L98
                r1 = 1
            L98:
                int r2 = r2 + r1
                r6.f47866c = r2
            L9b:
                r6.f47864a = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.text.g.a.a():void");
        }

        public final int c() {
            return this.f47868e;
        }

        public final int e() {
            return this.f47865b;
        }

        public final kotlin.ranges.m f() {
            return this.f47867d;
        }

        public final int g() {
            return this.f47866c;
        }

        public final int h() {
            return this.f47864a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f47864a == -1) {
                a();
            }
            return this.f47864a == 1;
        }

        @Override // java.util.Iterator
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public kotlin.ranges.m next() {
            if (this.f47864a == -1) {
                a();
            }
            if (this.f47864a == 0) {
                throw new NoSuchElementException();
            }
            kotlin.ranges.m mVar = this.f47867d;
            kotlin.jvm.internal.g0.n(mVar, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.f47867d = null;
            this.f47864a = -1;
            return mVar;
        }

        public final void j(int i6) {
            this.f47868e = i6;
        }

        public final void k(int i6) {
            this.f47865b = i6;
        }

        public final void m(kotlin.ranges.m mVar) {
            this.f47867d = mVar;
        }

        public final void n(int i6) {
            this.f47866c = i6;
        }

        public final void o(int i6) {
            this.f47864a = i6;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(@NotNull CharSequence input, int i6, int i7, @NotNull Function2<? super CharSequence, ? super Integer, Pair<Integer, Integer>> getNextMatch) {
        kotlin.jvm.internal.g0.p(input, "input");
        kotlin.jvm.internal.g0.p(getNextMatch, "getNextMatch");
        this.f47860a = input;
        this.f47861b = i6;
        this.f47862c = i7;
        this.f47863d = getNextMatch;
    }

    @Override // kotlin.sequences.m
    @NotNull
    public Iterator<kotlin.ranges.m> iterator() {
        return new a();
    }
}
