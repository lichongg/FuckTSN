package cn.jiguang.api;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import java.nio.ByteBuffer;

/* loaded from: D:\Downloads\app\classes2.dex */
public interface JAction {
    long dispatchMessage(Context context, long j6, int i6, Object obj, ByteBuffer byteBuffer);

    void dispatchTimeOutMessage(Context context, long j6, long j7, int i6);

    IBinder getBinderByType(String str);

    String getSdkVersion();

    void handleMessage(Context context, long j6, Object obj);

    boolean isSupportedCMD(int i6);

    void onActionRun(Context context, long j6, Bundle bundle, Object obj);

    void onEvent(Context context, long j6, int i6);
}
