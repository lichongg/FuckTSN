package kotlin.io;

import java.io.File;
import java.util.List;
import kotlin.collections.f0;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final File f43853a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final List<File> f43854b;

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return g0.g(this.f43853a, gVar.f43853a) && g0.g(this.f43854b, gVar.f43854b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(@NotNull File root, @NotNull List<? extends File> segments) {
        g0.p(root, "root");
        g0.p(segments, "segments");
        this.f43853a = root;
        this.f43854b = segments;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ g d(g gVar, File file, List list, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            file = gVar.f43853a;
        }
        if ((i6 & 2) != 0) {
            list = gVar.f43854b;
        }
        return gVar.c(file, list);
    }

    @NotNull
    public final File a() {
        return this.f43853a;
    }

    @NotNull
    public final List<File> b() {
        return this.f43854b;
    }

    @NotNull
    public final g c(@NotNull File root, @NotNull List<? extends File> segments) {
        g0.p(root, "root");
        g0.p(segments, "segments");
        return new g(root, segments);
    }

    @NotNull
    public final File e() {
        return this.f43853a;
    }

    @NotNull
    public final String f() {
        String path = this.f43853a.getPath();
        g0.o(path, "getPath(...)");
        return path;
    }

    @NotNull
    public final List<File> g() {
        return this.f43854b;
    }

    public final int h() {
        return this.f43854b.size();
    }

    public int hashCode() {
        return (this.f43853a.hashCode() * 31) + this.f43854b.hashCode();
    }

    public final boolean i() {
        String path = this.f43853a.getPath();
        g0.o(path, "getPath(...)");
        return path.length() > 0;
    }

    @NotNull
    public final File j(int i6, int i7) {
        if (i6 < 0 || i6 > i7 || i7 > h()) {
            throw new IllegalArgumentException();
        }
        List<File> subList = this.f43854b.subList(i6, i7);
        String separator = File.separator;
        g0.o(separator, "separator");
        return new File(f0.r3(subList, separator, null, null, 0, null, null, 62, null));
    }

    @NotNull
    public String toString() {
        return "FilePathComponents(root=" + this.f43853a + ", segments=" + this.f43854b + ')';
    }
}
