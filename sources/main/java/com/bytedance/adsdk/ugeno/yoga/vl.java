package com.bytedance.adsdk.ugeno.yoga;

/* loaded from: D:\Downloads\app\classes3.dex */
public class vl extends YogaNodeJNIBase {
    public void jy() {
        long j6 = this.f23900j;
        if (j6 != 0) {
            this.f23900j = 0L;
            YogaNative.jni_YGNodeFinalizeJNI(j6);
        }
    }

    protected void finalize() throws Throwable {
        try {
            jy();
        } finally {
            super.finalize();
        }
    }
}
