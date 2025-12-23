package com.bxkj.base.chat.heart;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.BaseApp;
import com.bxkj.base.user.LoginUser;
import com.orhanobut.logger.j;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class AlarmChatService extends Service {

    /* renamed from: a, reason: collision with root package name */
    private com.bxkj.base.chat.heart.b f16477a;

    /* renamed from: b, reason: collision with root package name */
    private long f16478b;

    /* renamed from: c, reason: collision with root package name */
    private BroadcastReceiver f16479c = new a();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equalsIgnoreCase(ChatBroadcastActionType.NOTIFY_HEART_CALLBACK_SUCCESS)) {
                AlarmChatService.this.d(System.currentTimeMillis());
                LoginUser.getLoginUser().setChatConnectStatus(true);
            } else if (intent.getAction().equalsIgnoreCase(ChatBroadcastActionType.NOTIFY_CONNECT_CLOSE) && AlarmChatService.this.f16477a != null) {
                AlarmChatService.this.f16477a.a();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a extends Thread {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Map f16482a;

            a(Map map) {
                this.f16482a = map;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                LoginUser.getLoginUser().setHeadImageUrl(JsonParse.getString(this.f16482a, "collectPhoto"));
                String string = JsonParse.getString(this.f16482a, "school");
                LoginUser.getLoginUser().setSchoolCode(string);
                b3.a.a().g(BaseApp.c());
                String string2 = JsonParse.getString(this.f16482a, "serverIp");
                String string3 = JsonParse.getString(this.f16482a, "port");
                if (!TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3) && !TextUtils.isEmpty(string)) {
                    try {
                        b3.a.a().d(LoginUser.getLoginUser().getUserId(), LoginUser.getLoginUser().getSchoolCode(), string2, string3);
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                    AlarmChatService.this.f16477a = new com.bxkj.base.chat.heart.b(BaseApp.c());
                    AlarmChatService.this.f16477a.b();
                    j.c("连接聊天服务器");
                    return;
                }
                AlarmChatService.this.stopSelf();
                j.c("不进行连接");
            }
        }

        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> map) {
            new a(map).start();
        }
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void d(long j6) {
        this.f16478b = j6;
        LoginUser.getLoginUser().setLastHeartCallBackTime(j6);
    }

    private void c() {
        Http.with(this).hideLoadingDialog().hideSuccessMessage().hideOtherStatusMessage().hideFailMessage().setObservable(((x.a) Http.getApiService(x.a.class)).d()).setDataListener(new b());
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        j.c("AlarmChatService心跳服务重新创建");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ChatBroadcastActionType.NOTIFY_HEART_CALLBACK_SUCCESS);
        intentFilter.addAction(ChatBroadcastActionType.NOTIFY_CONNECT_CLOSE);
        LocalBroadcastManager.getInstance(this).registerReceiver(this.f16479c, intentFilter);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (this.f16479c != null) {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(this.f16479c);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i6, int i7) {
        String str;
        if (LoginUser.getLoginUser().isLogin()) {
            long currentTimeMillis = System.currentTimeMillis();
            boolean g6 = BaseApp.g();
            StringBuilder sb = new StringBuilder();
            sb.append("心跳包");
            if (g6) {
                str = "在后台";
            } else {
                str = "在前台";
            }
            sb.append(str);
            sb.append("运行");
            j.c(sb.toString());
            b3.a.a().g(BaseApp.c());
            if (currentTimeMillis - this.f16478b > 15000) {
                j.c("超过15秒3此未收到心跳回调重连");
                LoginUser.getLoginUser().setChatConnectStatus(false);
                c();
                d(System.currentTimeMillis());
            } else {
                if (BaseApp.g()) {
                    b3.a.a().n();
                } else {
                    b3.a.a().a();
                }
                if (this.f16477a == null) {
                    this.f16477a = new com.bxkj.base.chat.heart.b(this);
                }
                this.f16477a.b();
            }
        }
        return super.onStartCommand(intent, i6, i7);
    }
}
