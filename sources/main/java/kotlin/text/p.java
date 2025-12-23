package kotlin.text;

import java.util.List;
import kotlin.internal.InlineOnly;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface p {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        @NotNull
        public static b a(@NotNull p pVar) {
            return new b(pVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final p f47935a;

        public b(@NotNull p match) {
            kotlin.jvm.internal.g0.p(match, "match");
            this.f47935a = match;
        }

        @NotNull
        public final p k() {
            return this.f47935a;
        }

        @NotNull
        public final List<String> l() {
            return this.f47935a.c().subList(1, this.f47935a.c().size());
        }

        @InlineOnly
        private final String a() {
            return k().c().get(1);
        }

        @InlineOnly
        private final String b() {
            return k().c().get(10);
        }

        @InlineOnly
        private final String c() {
            return k().c().get(2);
        }

        @InlineOnly
        private final String d() {
            return k().c().get(3);
        }

        @InlineOnly
        private final String e() {
            return k().c().get(4);
        }

        @InlineOnly
        private final String f() {
            return k().c().get(5);
        }

        @InlineOnly
        private final String g() {
            return k().c().get(6);
        }

        @InlineOnly
        private final String h() {
            return k().c().get(7);
        }

        @InlineOnly
        private final String i() {
            return k().c().get(8);
        }

        @InlineOnly
        private final String j() {
            return k().c().get(9);
        }
    }

    @NotNull
    b a();

    @NotNull
    n b();

    @NotNull
    List<String> c();

    @NotNull
    kotlin.ranges.m d();

    @NotNull
    String getValue();

    @Nullable
    p next();
}
