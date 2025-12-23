package kotlinx.coroutines.scheduling;

import kotlin.PublishedApi;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@PublishedApi
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    @JvmField
    public long f49503a;

    /* renamed from: b, reason: collision with root package name */
    @JvmField
    @NotNull
    public k f49504b;

    public j(long j6, @NotNull k kVar) {
        this.f49503a = j6;
        this.f49504b = kVar;
    }

    public final int c() {
        return this.f49504b.q();
    }

    public j() {
        this(0L, n.f49515i);
    }
}
