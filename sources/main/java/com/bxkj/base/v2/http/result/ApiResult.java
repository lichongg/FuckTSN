package com.bxkj.base.v2.http.result;

import com.bxkj.base.v2.http.exception.ApiException;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class ApiResult<T> {

    @Nullable
    private final Integer code;

    @Nullable
    private final T data;

    @Nullable
    private final String msg;

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ApiResult)) {
            return false;
        }
        ApiResult apiResult = (ApiResult) obj;
        return g0.g(this.code, apiResult.code) && g0.g(this.msg, apiResult.msg) && g0.g(this.data, apiResult.data);
    }

    private final T component3() {
        return this.data;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ApiResult copy$default(ApiResult apiResult, Integer num, String str, Object obj, int i6, Object obj2) {
        if ((i6 & 1) != 0) {
            num = apiResult.code;
        }
        if ((i6 & 2) != 0) {
            str = apiResult.msg;
        }
        if ((i6 & 4) != 0) {
            obj = apiResult.data;
        }
        return apiResult.copy(num, str, obj);
    }

    @Nullable
    public final T apiData() {
        Integer num = this.code;
        if (num == null || num.intValue() != 0) {
            throw new ApiException(this.code, this.msg);
        }
        return this.data;
    }

    @Nullable
    public final Integer component1() {
        return this.code;
    }

    @Nullable
    public final String component2() {
        return this.msg;
    }

    @NotNull
    public final ApiResult<T> copy(@Nullable Integer num, @Nullable String str, @Nullable T t5) {
        return new ApiResult<>(num, str, t5);
    }

    @Nullable
    public final Integer getCode() {
        return this.code;
    }

    @Nullable
    public final String getMsg() {
        return this.msg;
    }

    public int hashCode() {
        Integer num = this.code;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.msg;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        T t5 = this.data;
        return hashCode2 + (t5 != null ? t5.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ApiResult(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ")";
    }

    public ApiResult(@Nullable Integer num, @Nullable String str, @Nullable T t5) {
        this.code = num;
        this.msg = str;
        this.data = t5;
    }
}
