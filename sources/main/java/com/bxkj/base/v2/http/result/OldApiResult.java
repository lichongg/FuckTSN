package com.bxkj.base.v2.http.result;

import com.bxkj.base.v2.http.exception.ApiException;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class OldApiResult<T> {

    @Nullable
    private final T data;

    @Nullable
    private final Integer returnCode;

    @Nullable
    private final String returnMsg;

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OldApiResult)) {
            return false;
        }
        OldApiResult oldApiResult = (OldApiResult) obj;
        return g0.g(this.returnCode, oldApiResult.returnCode) && g0.g(this.returnMsg, oldApiResult.returnMsg) && g0.g(this.data, oldApiResult.data);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OldApiResult copy$default(OldApiResult oldApiResult, Integer num, String str, Object obj, int i6, Object obj2) {
        if ((i6 & 1) != 0) {
            num = oldApiResult.returnCode;
        }
        if ((i6 & 2) != 0) {
            str = oldApiResult.returnMsg;
        }
        if ((i6 & 4) != 0) {
            obj = oldApiResult.data;
        }
        return oldApiResult.copy(num, str, obj);
    }

    @Nullable
    public final T apiData() {
        Integer num = this.returnCode;
        if (num == null || num.intValue() != 200) {
            throw new ApiException(this.returnCode, this.returnMsg);
        }
        return this.data;
    }

    @Nullable
    public final Integer component1() {
        return this.returnCode;
    }

    @Nullable
    public final String component2() {
        return this.returnMsg;
    }

    @Nullable
    public final T component3() {
        return this.data;
    }

    @NotNull
    public final OldApiResult<T> copy(@Nullable Integer num, @Nullable String str, @Nullable T t5) {
        return new OldApiResult<>(num, str, t5);
    }

    @Nullable
    public final T getData() {
        return this.data;
    }

    @Nullable
    public final Integer getReturnCode() {
        return this.returnCode;
    }

    @Nullable
    public final String getReturnMsg() {
        return this.returnMsg;
    }

    public int hashCode() {
        Integer num = this.returnCode;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.returnMsg;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        T t5 = this.data;
        return hashCode2 + (t5 != null ? t5.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "OldApiResult(returnCode=" + this.returnCode + ", returnMsg=" + this.returnMsg + ", data=" + this.data + ")";
    }

    public OldApiResult(@Nullable Integer num, @Nullable String str, @Nullable T t5) {
        this.returnCode = num;
        this.returnMsg = str;
        this.data = t5;
    }
}
