package kotlinx.coroutines.debug.internal;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class i<T> extends WeakReference<T> {

    /* renamed from: a, reason: collision with root package name */
    @JvmField
    public final int f48550a;

    public i(T t5, @Nullable ReferenceQueue<T> referenceQueue) {
        super(t5, referenceQueue);
        int i6;
        if (t5 != null) {
            i6 = t5.hashCode();
        } else {
            i6 = 0;
        }
        this.f48550a = i6;
    }
}
