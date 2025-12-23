package kotlin.reflect;

import com.daimajia.numberprogressbar.BuildConfig;
import java.util.Collection;
import java.util.List;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface d<T> extends h, b, g {
    @Nullable
    T A();

    boolean B();

    @SinceKotlin(version = "1.1")
    boolean C(@Nullable Object obj);

    @Nullable
    String D();

    boolean equals(@Nullable Object obj);

    @NotNull
    Collection<i<T>> f();

    @NotNull
    List<s> getTypeParameters();

    @Nullable
    KVisibility getVisibility();

    int hashCode();

    @NotNull
    List<r> i();

    boolean isAbstract();

    boolean isFinal();

    boolean isOpen();

    boolean k();

    boolean m();

    @Override // kotlin.reflect.h
    @NotNull
    Collection<c<?>> o();

    boolean u();

    boolean v();

    boolean w();

    @Nullable
    String x();

    @NotNull
    Collection<d<?>> y();

    @NotNull
    List<d<? extends T>> z();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        @SinceKotlin(version = "1.3")
        public static /* synthetic */ void a() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void b() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void c() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void d() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void e() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void f() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void g() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void h() {
        }

        @SinceKotlin(version = BuildConfig.VERSION_NAME)
        public static /* synthetic */ void i() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void j() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void k() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void l() {
        }

        @SinceKotlin(version = "1.5")
        public static /* synthetic */ void m() {
        }
    }
}
