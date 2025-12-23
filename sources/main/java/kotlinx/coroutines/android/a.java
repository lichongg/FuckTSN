package kotlinx.coroutines.android;

import android.os.Looper;
import java.util.List;
import kotlinx.coroutines.internal.a0;
import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.p2;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a implements c0 {
    @Override // kotlinx.coroutines.internal.c0
    @NotNull
    public String b() {
        return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
    }

    @Override // kotlinx.coroutines.internal.c0
    public int a() {
        return a0.f49221j;
    }

    @Override // kotlinx.coroutines.internal.c0
    @NotNull
    public p2 c(@NotNull List<? extends c0> list) {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            return new d(g.e(mainLooper, true), null, 2, null);
        }
        throw new IllegalStateException("The main looper is not available");
    }
}
