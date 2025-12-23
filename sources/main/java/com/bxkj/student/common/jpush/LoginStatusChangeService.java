package com.bxkj.student.common.jpush;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bxkj.base.v2.data.b;
import com.orhanobut.logger.j;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class LoginStatusChangeService extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        b.a aVar = b.f16998d;
        j.m("LoginOutService->登录状态发生变化：" + aVar.a().Y(), new Object[0]);
        a.f17746a.d(aVar.a().R(), aVar.a().Y());
    }
}
