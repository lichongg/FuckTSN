package kotlin.io;

import java.io.BufferedReader;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class q implements kotlin.sequences.m<String> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final BufferedReader f43979a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements Iterator<String>, m3.a {

        /* renamed from: a, reason: collision with root package name */
        private String f43980a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f43981b;

        a() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f43980a == null && !this.f43981b) {
                String readLine = q.this.f43979a.readLine();
                this.f43980a = readLine;
                if (readLine == null) {
                    this.f43981b = true;
                }
            }
            return this.f43980a != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String next() {
            if (hasNext()) {
                String str = this.f43980a;
                this.f43980a = null;
                g0.m(str);
                return str;
            }
            throw new NoSuchElementException();
        }
    }

    public q(@NotNull BufferedReader reader) {
        g0.p(reader, "reader");
        this.f43979a = reader;
    }

    @Override // kotlin.sequences.m
    @NotNull
    public Iterator<String> iterator() {
        return new a();
    }
}
