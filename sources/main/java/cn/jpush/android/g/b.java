package cn.jpush.android.g;

import android.content.Intent;
import android.text.TextUtils;
import cn.asus.push.DataBuffer;
import cn.asus.push.IAIDLCallback;
import cn.jiguang.push.asus.PushMessageReceiver;

/* loaded from: D:\Downloads\app\classes2.dex */
public final class b extends IAIDLCallback.Stub {
    @Override // cn.asus.push.IAIDLCallback
    public final void call(DataBuffer dataBuffer) {
        try {
            cn.jpush.android.i.b.a("ClientAIDLCallBack", "[call] data:" + String.valueOf(dataBuffer) + ",cmd:" + dataBuffer.f1075a);
            String str = dataBuffer.f1075a;
            long j6 = dataBuffer.f1076b.getLong("message_rid", -1L);
            String string = dataBuffer.f1076b.getString("message_content");
            String b6 = cn.jpush.android.f.c.b(cn.jpush.android.f.c.f3645a);
            if (!TextUtils.isEmpty(b6)) {
                ((PushMessageReceiver) Class.forName(b6).newInstance()).a(cn.jpush.android.f.c.f3645a, j6, str, string);
                return;
            }
            Intent intent = new Intent();
            dataBuffer.f1076b.putString("message_cmd", dataBuffer.f1075a);
            intent.putExtras(dataBuffer.f1076b);
            intent.setAction("com.ups.push.PUSH_RESPONSE");
            intent.setPackage(cn.jpush.android.f.c.f3647c);
            cn.jpush.android.f.c.f3645a.sendBroadcast(intent);
        } catch (Throwable unused) {
        }
    }
}
