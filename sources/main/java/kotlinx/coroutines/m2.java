package kotlinx.coroutines;

import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class m2 {

    /* renamed from: e, reason: collision with root package name */
    private static final int f49387e = -1;

    /* renamed from: f, reason: collision with root package name */
    private static final int f49388f = 0;

    /* renamed from: g, reason: collision with root package name */
    private static final int f49389g = 1;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final kotlinx.coroutines.internal.s0 f49383a = new kotlinx.coroutines.internal.s0("COMPLETING_ALREADY");

    /* renamed from: b, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final kotlinx.coroutines.internal.s0 f49384b = new kotlinx.coroutines.internal.s0("COMPLETING_WAITING_CHILDREN");

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final kotlinx.coroutines.internal.s0 f49385c = new kotlinx.coroutines.internal.s0("COMPLETING_RETRY");

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final kotlinx.coroutines.internal.s0 f49386d = new kotlinx.coroutines.internal.s0("TOO_LATE_TO_CANCEL");

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final kotlinx.coroutines.internal.s0 f49390h = new kotlinx.coroutines.internal.s0("SEALED");

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final m1 f49391i = new m1(false);

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private static final m1 f49392j = new m1(true);

    @Nullable
    public static final Object g(@Nullable Object obj) {
        return obj instanceof y1 ? new z1((y1) obj) : obj;
    }

    @Nullable
    public static final Object h(@Nullable Object obj) {
        y1 y1Var;
        z1 z1Var = obj instanceof z1 ? (z1) obj : null;
        return (z1Var == null || (y1Var = z1Var.f49682a) == null) ? obj : y1Var;
    }
}
