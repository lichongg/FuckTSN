package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.jvm.functions.Function1;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class w extends y {
    @Override // kotlinx.coroutines.internal.y
    public boolean q() {
        return false;
    }

    @Override // kotlinx.coroutines.internal.y
    @Nullable
    protected y t() {
        return null;
    }

    @NotNull
    public final Void B() {
        throw new IllegalStateException("head cannot be removed");
    }

    public final boolean A() {
        if (n() == this) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlinx.coroutines.internal.y] */
    public final void C() {
        Object n6 = n();
        kotlin.jvm.internal.g0.n(n6, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        w wVar = this;
        w wVar2 = (y) n6;
        while (!kotlin.jvm.internal.g0.g(wVar2, this)) {
            y o5 = wVar2.o();
            wVar2.y(wVar, o5);
            wVar = wVar2;
            wVar2 = o5;
        }
        Object n7 = n();
        kotlin.jvm.internal.g0.n(n7, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        y(wVar, (y) n7);
    }

    @Override // kotlinx.coroutines.internal.y
    public /* bridge */ /* synthetic */ boolean u() {
        return ((Boolean) B()).booleanValue();
    }

    public final /* synthetic */ <T extends y> void z(Function1<? super T, n1> function1) {
        Object n6 = n();
        kotlin.jvm.internal.g0.n(n6, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        for (y yVar = (y) n6; !kotlin.jvm.internal.g0.g(yVar, this); yVar = yVar.o()) {
            kotlin.jvm.internal.g0.y(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (androidx.activity.k.a(yVar)) {
                function1.invoke(yVar);
            }
        }
    }
}
