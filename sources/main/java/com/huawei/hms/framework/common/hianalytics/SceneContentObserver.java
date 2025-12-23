package com.huawei.hms.framework.common.hianalytics;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class SceneContentObserver extends ContentObserver {
    public native void onChangeForMp();

    public SceneContentObserver(Handler handler) {
        super(handler);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z5) {
        onChangeForMp();
    }
}
