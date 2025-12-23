package com.autonavi.base.ae.gmap.maploader;

import com.autonavi.base.ae.gmap.maploader.Pools;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class ProcessingTile {
    private static final Pools.SynchronizedPool<ProcessingTile> M_POOL = new Pools.SynchronizedPool<>(30);
    public long mCreateTime = 0;
    public String mKeyName;

    public void recycle() {
        this.mKeyName = null;
        this.mCreateTime = 0L;
        M_POOL.release(this);
    }

    public static ProcessingTile obtain(String str) {
        ProcessingTile acquire = M_POOL.acquire();
        if (acquire == null) {
            return new ProcessingTile(str);
        }
        acquire.setParams(str);
        return acquire;
    }

    private void setParams(String str) {
        this.mKeyName = str;
        this.mCreateTime = System.currentTimeMillis() / 1000;
    }

    public ProcessingTile(String str) {
        setParams(str);
    }
}
