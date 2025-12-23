package com.stub.stub09;

import android.content.Context;
import com.stub.StubApp;
import com.stub.stub09.HttpUtils;

@TYVMProtect
/* loaded from: D:\Downloads\app\classes10.dex */
public class RU {
    public static Context mContext;

    /* renamed from: com.stub.stub09.RU$1, reason: invalid class name */
    static class AnonymousClass1 implements HttpUtils.DownloadListener {
        static {
            StubApp.interface11(56938);
        }

        AnonymousClass1() {
        }

        @Override // com.stub.stub09.HttpUtils.DownloadListener
        @TYVMProtect
        public native void onFail();

        @Override // com.stub.stub09.HttpUtils.DownloadListener
        @TYVMProtect
        public native void onSuccess(String str);
    }

    /* renamed from: com.stub.stub09.RU$2, reason: invalid class name */
    static class AnonymousClass2 implements Runnable {
        final /* synthetic */ int val$isSuccess;

        static {
            StubApp.interface11(56939);
        }

        AnonymousClass2(int i6) {
            this.val$isSuccess = i6;
        }

        @Override // java.lang.Runnable
        @TYVMProtect
        public native void run();
    }

    static {
        StubApp.interface11(56940);
    }

    public static native void A(Context context);

    public static native void B(int i6);

    private static native boolean C();

    private static native int hasPermission(String str);

    public static native void interface110();

    public static native boolean interface111(boolean z5);
}
