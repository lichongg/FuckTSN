package kotlinx.coroutines;

import kotlin.coroutines.EmptyCoroutineContext;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@DelicateCoroutinesApi
/* loaded from: D:\Downloads\app\classes8.dex */
public final class w1 implements r0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final w1 f49676a = new w1();

    @Override // kotlinx.coroutines.r0
    @NotNull
    public kotlin.coroutines.i getCoroutineContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    private w1() {
    }
}
