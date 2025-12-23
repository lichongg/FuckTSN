package com.bxkj.base.v2.netty4android.client.heart;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.bxkj.base.BaseApp;
import com.bxkj.base.v2.data.b;
import com.bxkj.base.v2.netty4android.service.NettySocketService;
import com.orhanobut.logger.j;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class AlarmNettyService extends Service {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private a f17130a;

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(@Nullable Intent intent) {
        return null;
    }

    private final void a() {
        try {
            BaseApp.c().startService(new Intent(BaseApp.c(), (Class<?>) NettySocketService.class).putExtra(com.umeng.ccg.a.f41544t, 1));
        } catch (Exception e6) {
            j.e("AlarmChatService心跳检测服务重连失败:" + e6.getMessage(), new Object[0]);
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        j.d("AlarmChatService心跳检测服务重新创建", new Object[0]);
    }

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent intent, int i6, int i7) {
        long currentTimeMillis = System.currentTimeMillis();
        a aVar = this.f17130a;
        if (aVar == null) {
            aVar = new a(this);
        }
        this.f17130a = aVar;
        aVar.b();
        b.a aVar2 = b.f16998d;
        if (aVar2.a().Y() && currentTimeMillis - aVar2.a().u() > 180000) {
            j.e("超过60秒3次未收到心跳回调重连", new Object[0]);
            a();
        }
        return super.onStartCommand(intent, i6, i7);
    }
}
