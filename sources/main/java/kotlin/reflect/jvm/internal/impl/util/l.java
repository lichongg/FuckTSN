package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface l {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements l {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f47411a = new a();

        @Override // kotlin.reflect.jvm.internal.impl.util.l
        public boolean a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k what, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k from) {
            g0.p(what, "what");
            g0.p(from, "from");
            return true;
        }

        private a() {
        }
    }

    boolean a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar2);
}
