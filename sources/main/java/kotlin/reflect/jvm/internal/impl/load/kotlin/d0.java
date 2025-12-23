package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface d0 {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements d0 {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f45875a = new a();

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.d0
        @NotNull
        public List<String> a(@NotNull String packageFqName) {
            kotlin.jvm.internal.g0.p(packageFqName, "packageFqName");
            return kotlin.collections.f0.J();
        }

        private a() {
        }
    }

    @NotNull
    List<String> a(@NotNull String str);
}
