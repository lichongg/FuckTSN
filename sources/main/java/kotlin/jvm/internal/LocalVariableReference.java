package kotlin.jvm.internal;

import kotlin.KotlinNothingValueException;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "1.1")
/* loaded from: D:\Downloads\app\classes8.dex */
public class LocalVariableReference extends PropertyReference0 {
    @Override // kotlin.reflect.o
    @Nullable
    public Object get() {
        i0.b();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.jvm.internal.CallableReference
    @NotNull
    public kotlin.reflect.h getOwner() {
        i0.b();
        throw new KotlinNothingValueException();
    }
}
