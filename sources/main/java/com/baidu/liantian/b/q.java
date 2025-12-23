package com.baidu.liantian.b;

import android.content.Context;
import android.os.Process;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class q {
    public static boolean a(Context context) {
        try {
            return context.checkPermission(com.kuaishou.weapon.p0.g.f36043c, Process.myPid(), Process.myUid()) != -1;
        } catch (Throwable unused) {
            e.a();
            return false;
        }
    }
}
