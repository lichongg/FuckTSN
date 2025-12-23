package cn.jiguang.at;

import android.os.HandlerThread;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b extends HandlerThread {
    public b(String str) {
        super(str);
    }

    @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            super.run();
        } catch (Throwable unused) {
        }
    }
}
