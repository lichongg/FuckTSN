package androidx.lifecycle.viewmodel;

import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class MutableCreationExtras extends CreationExtras {
    public MutableCreationExtras() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public MutableCreationExtras(@NotNull CreationExtras initialExtras) {
        g0.p(initialExtras, "initialExtras");
        getMap$lifecycle_viewmodel_release().putAll(initialExtras.getMap$lifecycle_viewmodel_release());
    }

    @Override // androidx.lifecycle.viewmodel.CreationExtras
    @Nullable
    public <T> T get(@NotNull CreationExtras.Key<T> key) {
        g0.p(key, "key");
        return (T) getMap$lifecycle_viewmodel_release().get(key);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> void set(@NotNull CreationExtras.Key<T> key, T t5) {
        g0.p(key, "key");
        getMap$lifecycle_viewmodel_release().put(key, t5);
    }

    public /* synthetic */ MutableCreationExtras(CreationExtras creationExtras, int i6, v vVar) {
        this((i6 & 1) != 0 ? CreationExtras.Empty.INSTANCE : creationExtras);
    }
}
