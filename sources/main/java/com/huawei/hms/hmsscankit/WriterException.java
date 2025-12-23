package com.huawei.hms.hmsscankit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class WriterException extends Exception {
    public WriterException() {
    }

    public WriterException(String str, String str2) {
        super(str2 + " Format | " + str);
    }

    public WriterException(String str) {
        super(str);
    }

    public WriterException(Throwable th) {
        super(th);
    }
}
