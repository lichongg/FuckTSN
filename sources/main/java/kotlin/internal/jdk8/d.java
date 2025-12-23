package kotlin.internal.jdk8;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import k4.h;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.random.Random;
import kotlin.text.m;
import kotlin.time.ExperimentalTime;
import kotlin.time.Instant;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class d extends kotlin.internal.jdk7.a {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nJDK8PlatformImplementations.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JDK8PlatformImplementations.kt\nkotlin/internal/jdk8/JDK8PlatformImplementations$ReflectSdkVersion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,76:1\n1#2:77\n*E\n"})
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f43807a = new a();

        /* renamed from: b, reason: collision with root package name */
        @JvmField
        @Nullable
        public static final Integer f43808b;

        static {
            Integer num;
            Object obj;
            Integer num2 = null;
            try {
                obj = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
            } catch (Throwable unused) {
            }
            if (obj instanceof Integer) {
                num = (Integer) obj;
                if (num != null && num.intValue() > 0) {
                    num2 = num;
                }
                f43808b = num2;
            }
            num = null;
            if (num != null) {
                num2 = num;
            }
            f43808b = num2;
        }

        private a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class c implements kotlin.time.e {
        @Override // kotlin.time.e
        public Instant a() {
            return Instant.Companion.a(System.currentTimeMillis());
        }

        c() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b implements kotlin.time.e {
        b() {
        }

        @Override // kotlin.time.e
        public Instant a() {
            java.time.Instant now;
            now = java.time.Instant.now();
            g0.o(now, "now(...)");
            return h.b(now);
        }
    }

    private final boolean f(int i6) {
        Integer num = a.f43808b;
        return num == null || num.intValue() >= i6;
    }

    @Override // kotlin.internal.a
    @NotNull
    public Random b() {
        return f(34) ? new q3.a() : super.b();
    }

    @Override // kotlin.internal.a
    @Nullable
    public m c(@NotNull MatchResult matchResult, @NotNull String name) {
        int start;
        int end;
        String group;
        g0.p(matchResult, "matchResult");
        g0.p(name, "name");
        Matcher matcher = matchResult instanceof Matcher ? (Matcher) matchResult : null;
        if (matcher == null) {
            throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
        }
        start = matcher.start(name);
        end = matcher.end(name);
        kotlin.ranges.m mVar = new kotlin.ranges.m(start, end - 1);
        if (mVar.getStart().intValue() < 0) {
            return null;
        }
        group = matcher.group(name);
        g0.o(group, "group(...)");
        return new m(group, mVar);
    }

    @Override // kotlin.internal.a
    @ExperimentalTime
    @NotNull
    public kotlin.time.e e() {
        return f(26) ? new b() : new c();
    }
}
