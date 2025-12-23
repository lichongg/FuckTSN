package okhttp3;

import java.io.IOException;
import kotlin.jvm.functions.Function0;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface Call extends Cloneable {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface Factory {
        @NotNull
        Call newCall(@NotNull Request request);
    }

    void cancel();

    @NotNull
    /* renamed from: clone */
    Call mo292clone();

    void enqueue(@NotNull Callback callback);

    @NotNull
    Response execute() throws IOException;

    boolean isCanceled();

    boolean isExecuted();

    @NotNull
    Request request();

    @Nullable
    <T> T tag(@NotNull Class<? extends T> cls);

    @NotNull
    <T> T tag(@NotNull Class<T> cls, @NotNull Function0<? extends T> function0);

    @Nullable
    <T> T tag(@NotNull kotlin.reflect.d<T> dVar);

    @NotNull
    <T> T tag(@NotNull kotlin.reflect.d<T> dVar, @NotNull Function0<? extends T> function0);

    @NotNull
    Timeout timeout();
}
