package com.bxkj.base.v2.http;

import com.bxkj.base.v2.http.interceptor.Test;
import com.bxkj.base.v2.http.result.ApiResult;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public interface b {
    @Test(demo = "f2cefb5799dbc3a2fca980a7c30b8b09")
    @GET("app/getSocket")
    @Nullable
    Object a(@Nullable @Query("basUserId") String str, @NotNull kotlin.coroutines.e<? super ApiResult<Map<String, Object>>> eVar);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
    }
}
