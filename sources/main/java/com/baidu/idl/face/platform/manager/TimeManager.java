package com.baidu.idl.face.platform.manager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class TimeManager {
    private static TimeManager instance;
    private int mActiveAnimTime;

    public static TimeManager getInstance() {
        if (instance == null) {
            synchronized (TimeManager.class) {
                try {
                    if (instance == null) {
                        instance = new TimeManager();
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    public int getActiveAnimTime() {
        return this.mActiveAnimTime;
    }

    public void setActiveAnimTime(int i6) {
        this.mActiveAnimTime = i6;
    }

    private TimeManager() {
    }
}
