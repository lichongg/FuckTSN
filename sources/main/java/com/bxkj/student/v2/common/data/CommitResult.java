package com.bxkj.student.v2.common.data;

import com.bxkj.base.v2.http.exception.ApiException;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class CommitResult<T> {

    @Nullable
    private final Integer code;

    @Nullable
    private final T data;

    @Nullable
    private final String exerciseRecordId;

    @Nullable
    private final String msg;

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommitResult)) {
            return false;
        }
        CommitResult commitResult = (CommitResult) obj;
        return g0.g(this.code, commitResult.code) && g0.g(this.msg, commitResult.msg) && g0.g(this.data, commitResult.data) && g0.g(this.exerciseRecordId, commitResult.exerciseRecordId);
    }

    private final T component3() {
        return this.data;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CommitResult copy$default(CommitResult commitResult, Integer num, String str, Object obj, String str2, int i6, Object obj2) {
        if ((i6 & 1) != 0) {
            num = commitResult.code;
        }
        if ((i6 & 2) != 0) {
            str = commitResult.msg;
        }
        if ((i6 & 4) != 0) {
            obj = commitResult.data;
        }
        if ((i6 & 8) != 0) {
            str2 = commitResult.exerciseRecordId;
        }
        return commitResult.copy(num, str, obj, str2);
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

    @Nullable
    public final String component4() {
        return this.exerciseRecordId;
    }

    @NotNull
    public final CommitResult<T> copy(@Nullable Integer num, @Nullable String str, @Nullable T t5, @Nullable String str2) {
        return new CommitResult<>(num, str, t5, str2);
    }

    @Nullable
    public final Integer getCode() {
        return this.code;
    }

    @Nullable
    public final String getExerciseRecordId() {
        return this.exerciseRecordId;
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
        int hashCode3 = (hashCode2 + (t5 == null ? 0 : t5.hashCode())) * 31;
        String str2 = this.exerciseRecordId;
        return hashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "CommitResult(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ", exerciseRecordId=" + this.exerciseRecordId + ")";
    }

    public CommitResult(@Nullable Integer num, @Nullable String str, @Nullable T t5, @Nullable String str2) {
        this.code = num;
        this.msg = str;
        this.data = t5;
        this.exerciseRecordId = str2;
    }
}
