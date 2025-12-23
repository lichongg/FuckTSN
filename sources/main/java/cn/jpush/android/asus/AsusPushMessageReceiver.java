package cn.jpush.android.asus;

import android.content.Context;
import cn.jiguang.push.asus.PushMessageReceiver;
import cn.jpush.android.ac.e;

/* loaded from: D:\Downloads\app\classes2.dex */
public class AsusPushMessageReceiver extends PushMessageReceiver {
    @Override // cn.jiguang.push.asus.PushMessageReceiver
    public void a(Context context, cn.jpush.android.c.a aVar) {
        if (aVar != null) {
            a.a(context, aVar.a());
        }
    }

    @Override // cn.jiguang.push.asus.PushMessageReceiver
    public void a(Context context, String str) {
        e.a().a(context, (byte) 6, str);
    }
}
