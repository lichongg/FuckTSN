package cn.bluemobi.dylan.http;

import android.content.Context;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.c0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public interface CustomResponse {
    void onError(@NotNull Context context, @NotNull HttpRequest httpRequest, @NotNull HttpResponse httpResponse, @Nullable Throwable th);

    void onNext(@NotNull Context context, @NotNull HttpRequest httpRequest, @NotNull HttpResponse httpResponse, @Nullable c0<ResponseBody> c0Var);
}
