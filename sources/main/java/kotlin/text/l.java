package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class l implements Iterator<String>, m3.a {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final a f47921f = new a(null);

    /* renamed from: g, reason: collision with root package name */
    @Deprecated
    public static final int f47922g = 0;

    /* renamed from: h, reason: collision with root package name */
    @Deprecated
    public static final int f47923h = 1;

    /* renamed from: i, reason: collision with root package name */
    @Deprecated
    public static final int f47924i = 2;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final CharSequence f47925a;

    /* renamed from: b, reason: collision with root package name */
    private int f47926b;

    /* renamed from: c, reason: collision with root package name */
    private int f47927c;

    /* renamed from: d, reason: collision with root package name */
    private int f47928d;

    /* renamed from: e, reason: collision with root package name */
    private int f47929e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }
    }

    public l(@NotNull CharSequence string) {
        kotlin.jvm.internal.g0.p(string, "string");
        this.f47925a = string;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        int i6;
        int i7;
        int i8 = this.f47926b;
        if (i8 != 0) {
            return i8 == 1;
        }
        if (this.f47929e < 0) {
            this.f47926b = 2;
            return false;
        }
        int length = this.f47925a.length();
        int length2 = this.f47925a.length();
        for (int i9 = this.f47927c; i9 < length2; i9++) {
            char charAt = this.f47925a.charAt(i9);
            if (charAt == '\n' || charAt == '\r') {
                i6 = (charAt == '\r' && (i7 = i9 + 1) < this.f47925a.length() && this.f47925a.charAt(i7) == '\n') ? 2 : 1;
                length = i9;
                this.f47926b = 1;
                this.f47929e = i6;
                this.f47928d = length;
                return true;
            }
        }
        i6 = -1;
        this.f47926b = 1;
        this.f47929e = i6;
        this.f47928d = length;
        return true;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    @NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String next() {
        if (hasNext()) {
            this.f47926b = 0;
            int i6 = this.f47928d;
            int i7 = this.f47927c;
            this.f47927c = this.f47929e + i6;
            return this.f47925a.subSequence(i7, i6).toString();
        }
        throw new NoSuchElementException();
    }
}
