package com.kwad.components.offline.api;

import android.content.Context;
import com.kwad.components.offline.api.IOfflineCompoInitConfig;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public interface IOfflineCompo<T extends IOfflineCompoInitConfig> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface Priority {
        public static final int HIGH = -100;
        public static final int HIGHEST = -200;
        public static final int LOW = 100;
        public static final int LOWEST = 200;
        public static final int NORMAL = 0;
    }

    Class getComponentsType();

    void init(Context context, T t5, InitCallBack initCallBack);

    int priority();
}
