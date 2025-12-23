package okhttp3.internal.connection;

import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface ExchangeFinder {
    @NotNull
    RealConnection find();

    @NotNull
    RoutePlanner getRoutePlanner();
}
