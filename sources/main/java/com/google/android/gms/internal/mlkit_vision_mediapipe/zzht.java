package com.google.android.gms.internal.mlkit_vision_mediapipe;

import com.umeng.commonsdk.framework.UMModuleRegister;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public enum zzht {
    OK("ok"),
    CANCELLED("canceled"),
    UNKNOWN("unknown"),
    INVALID_ARGUMENT("invalid argument"),
    DEADLINE_EXCEEDED("deadline exceeded"),
    NOT_FOUND("not found"),
    ALREADY_EXISTS("already exists"),
    PERMISSION_DENIED("permission denied"),
    RESOURCE_EXHAUSTED("resource exhausted"),
    FAILED_PRECONDITION("failed precondition"),
    ABORTED("aborted"),
    OUT_OF_RANGE("out of range"),
    UNIMPLEMENTED("unimplemented"),
    INTERNAL(UMModuleRegister.INNER),
    UNAVAILABLE("unavailable"),
    DATA_LOSS("data loss"),
    UNAUTHENTICATED("unauthenticated"),
    IO_EXCEPTION("i/o exception");

    private final String zzt;

    public final String zza() {
        return this.zzt;
    }

    zzht(String str) {
        this.zzt = str;
    }
}
