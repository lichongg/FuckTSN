package kotlin.reflect;

import java.util.List;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "1.1")
/* loaded from: D:\Downloads\app\classes8.dex */
public interface s extends g {
    @NotNull
    String getName();

    @NotNull
    List<r> getUpperBounds();

    boolean j();

    @NotNull
    KVariance l();
}
