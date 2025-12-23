package com.bxkj.student.common.jpush;

import android.content.Context;
import android.content.Intent;
import cn.jpush.android.api.CmdMessage;
import cn.jpush.android.api.CustomMessage;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.JPushMessage;
import cn.jpush.android.api.NotificationMessage;
import cn.jpush.android.service.JPushMessageReceiver;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class PushMessageService extends JPushMessageReceiver {

    /* renamed from: a, reason: collision with root package name */
    private static final String f17745a = "JPush";

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public void onRegister(Context context, String registrationId) {
        context.sendBroadcast(new Intent("com.jiguang.demo.register"));
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public void onAliasOperatorResult(Context context, JPushMessage jPushMessage) {
        super.onAliasOperatorResult(context, jPushMessage);
        jPushMessage.getSequence();
        jPushMessage.getAlias();
        if (jPushMessage.getErrorCode() == 0) {
            return;
        }
        jPushMessage.getErrorCode();
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public void onCheckTagOperatorResult(Context context, JPushMessage jPushMessage) {
        super.onCheckTagOperatorResult(context, jPushMessage);
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public void onCommandResult(Context context, CmdMessage cmdMessage) {
        Objects.toString(cmdMessage);
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public void onMessage(Context context, CustomMessage customMessage) {
        Objects.toString(customMessage);
        Intent intent = new Intent("com.jiguang.demo.message");
        intent.putExtra("msg", customMessage.message);
        context.sendBroadcast(intent);
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public void onMobileNumberOperatorResult(Context context, JPushMessage jPushMessage) {
        super.onMobileNumberOperatorResult(context, jPushMessage);
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public void onMultiActionClicked(Context context, Intent intent) {
        String string = intent.getExtras().getString(JPushInterface.EXTRA_NOTIFICATION_ACTION_EXTRA);
        if (string == null || string.equals("my_extra1") || string.equals("my_extra2")) {
            return;
        }
        string.equals("my_extra3");
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public void onNotificationSettingsCheck(Context context, boolean isOn, int source) {
        super.onNotificationSettingsCheck(context, isOn, source);
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public void onNotifyMessageArrived(Context context, NotificationMessage message) {
        Objects.toString(message);
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public void onNotifyMessageDismiss(Context context, NotificationMessage message) {
        Objects.toString(message);
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public void onNotifyMessageOpened(Context context, NotificationMessage message) {
        Objects.toString(message);
        super.onNotifyMessageOpened(context, message);
        Objects.toString(message);
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public void onTagOperatorResult(Context context, JPushMessage jPushMessage) {
        super.onTagOperatorResult(context, jPushMessage);
        jPushMessage.getSequence();
        Objects.toString(jPushMessage.getTags());
        jPushMessage.getTags().size();
        if (jPushMessage.getErrorCode() == 0) {
            return;
        }
        if (jPushMessage.getErrorCode() == 6018) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to modify tags");
            sb.append(", tags is exceed limit need to clean");
        }
        jPushMessage.getErrorCode();
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public void onConnected(Context context, boolean isConnected) {
    }
}
