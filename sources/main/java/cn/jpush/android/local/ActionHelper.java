package cn.jpush.android.local;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.internal.JConstants;
import cn.jpush.android.ad.f;
import cn.jpush.android.api.CallBackParams;
import cn.jpush.android.api.CustomMessage;
import cn.jpush.android.api.NotificationMessage;
import cn.jpush.android.api.TagAliasCallback;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.service.JPushMessageReceiver;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\Downloads\app\classes2.dex */
public class ActionHelper {
    private static final String TAG = "ActionHelper";
    private static volatile ActionHelper actionHelper;
    private static final Object locker = new Object();
    private JPushAction jPushAction;
    private cn.jpush.android.y.a loadedResource;
    int sequence = 10;

    class a extends f {

        /* renamed from: b, reason: collision with root package name */
        private Context f3699b;

        /* renamed from: c, reason: collision with root package name */
        private String f3700c;

        /* renamed from: d, reason: collision with root package name */
        private Object f3701d;

        public a(Context context, String str, Object obj) {
            this.f3699b = context;
            this.f3700c = str;
            this.f3701d = obj;
            this.f3443e = "ActionHelper#Action";
        }

        @Override // cn.jpush.android.ad.f
        public void a() {
            try {
                ActionHelper.this.initLoad(this.f3699b);
                ActionHelper.this.jPushAction.handleAction(this.f3699b, this.f3700c, this.f3701d);
            } catch (Throwable unused) {
            }
        }
    }

    class b extends f {

        /* renamed from: b, reason: collision with root package name */
        private Context f3703b;

        /* renamed from: c, reason: collision with root package name */
        private String f3704c;

        /* renamed from: d, reason: collision with root package name */
        private int f3705d;

        /* renamed from: f, reason: collision with root package name */
        private Set<String> f3706f;

        /* renamed from: g, reason: collision with root package name */
        private CallBackParams f3707g;

        public b(Context context, String str, Set<String> set, int i6, CallBackParams callBackParams) {
            this.f3707g = callBackParams;
            this.f3704c = str;
            this.f3705d = i6;
            this.f3703b = context;
            this.f3706f = set;
            this.f3443e = "ActionHelper#TagAliasAction";
        }

        @Override // cn.jpush.android.ad.f
        public void a() {
            try {
                ActionHelper.this.initLoad(this.f3703b);
                ActionHelper.this.jPushAction.setAliasAndTags(this.f3703b, this.f3704c, this.f3706f, this.f3707g);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void initLoad(Context context) {
        if (this.jPushAction != null) {
            return;
        }
        try {
            if (JPushConstants.SUPPORT_DY && JConstants.SDK_VERSION_INT >= 220) {
                long currentTimeMillis = System.currentTimeMillis();
                this.loadedResource = cn.jpush.android.y.a.a(context);
                Logger.d(TAG, "load use time:" + (System.currentTimeMillis() - currentTimeMillis) + ",lr:" + this.loadedResource);
                cn.jpush.android.y.a aVar = this.loadedResource;
                if (aVar != null) {
                    Class b6 = aVar.b("cn.p.jpush.JPushActionImpl");
                    Logger.d(TAG, "load from cloud");
                    this.jPushAction = (JPushAction) b6.newInstance();
                }
            }
        } catch (Throwable th) {
            Logger.ww(TAG, "try l p failed:" + th.getMessage());
        }
        if (this.jPushAction == null) {
            Logger.d(TAG, "load from local");
            this.jPushAction = new cn.jpush.android.l.a();
        }
    }

    public void onEvent(Thread thread, Throwable th) {
        JCoreManager.onEvent(null, JPushConstants.SDK_TYPE, 93, null, null, thread, th);
    }

    public void onJPushMessageReceive(Context context, JPushMessageReceiver jPushMessageReceiver, Intent intent) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            jPushAction.onJPushMessageReceive(context, jPushMessageReceiver, intent);
        }
    }

    public static ActionHelper getInstance() {
        if (actionHelper == null) {
            synchronized (locker) {
                try {
                    if (actionHelper == null) {
                        actionHelper = new ActionHelper();
                    }
                } finally {
                }
            }
        }
        return actionHelper;
    }

    public void doAction(Context context, String str, Object obj) {
        Logger.dd(TAG, "doAction:" + str);
        JCoreHelper.majorExecutor(context, TAG, new a(context, str, obj));
    }

    public void doSingleAction(Context context, String str, Object obj) {
        Logger.dd(TAG, "doSingleAction: " + str);
        JCoreHelper.futureExecutor(context, TAG, new a(context, str, obj));
    }

    public Class getClassInPlugin(String str) {
        try {
            cn.jpush.android.y.a aVar = this.loadedResource;
            if (aVar == null) {
                return null;
            }
            Class b6 = aVar.b(str);
            Logger.d(TAG, "load class from p");
            if (b6 != null) {
                return b6;
            }
            return null;
        } catch (Throwable th) {
            Logger.w(TAG, "[getClassInPlugin] error:" + th);
            return null;
        }
    }

    public int getResourceID(Context context, String str, String str2, String str3) {
        int identifier;
        StringBuilder sb;
        String str4;
        cn.jpush.android.y.a aVar = this.loadedResource;
        if (aVar != null) {
            identifier = aVar.a(str2, str);
            sb = new StringBuilder();
            str4 = "[getResourceID] try load:";
        } else {
            identifier = context.getResources().getIdentifier(str, str2, str3);
            sb = new StringBuilder();
            str4 = "[getResourceID]:";
        }
        sb.append(str4);
        sb.append(identifier);
        Logger.d(TAG, sb.toString());
        return identifier;
    }

    public String getSdkVersion(String str) {
        JPushAction jPushAction = this.jPushAction;
        return jPushAction != null ? jPushAction.getSdkVersion(str) : JPushConstants.SDK_VERSION_NAME;
    }

    public boolean isSupportedCMD(String str, int i6) {
        JPushAction jPushAction = this.jPushAction;
        return jPushAction != null ? jPushAction.isSupportedCMD(str, i6) : i6 == 3 || i6 == 29 || i6 == 28 || i6 == 27 || i6 == 10 || i6 == 26 || i6 == 25 || i6 == 34 || i6 == 36 || i6 == 37;
    }

    public void onActivityLifeCallback(Activity activity, String str) {
        JPushAction jPushAction;
        if (activity == null || (jPushAction = this.jPushAction) == null) {
            return;
        }
        jPushAction.onActivityLifeCallback(activity, str);
    }

    public void onJPushMessageReceive(Context context, String str, String str2, Bundle bundle) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            jPushAction.onJPushMessageReceive(context, str, str2, bundle);
        }
    }

    public void setAliasAndTagsWithCallBack(Context context, String str, Set<String> set, TagAliasCallback tagAliasCallback, int i6, int i7) {
        JCoreHelper.majorExecutor(context, TAG, new b(context, str, set, 0, new CallBackParams(str, set, tagAliasCallback, System.currentTimeMillis(), i6, i7)));
    }

    public void setAliasWithCallBack(Context context, int i6, String str, int i7, int i8) {
        JCoreHelper.majorExecutor(context, TAG, new b(context, str, null, i6, new CallBackParams(i6, str, System.currentTimeMillis(), i7, i8)));
    }

    public void setPropertyWithCallBack(Context context, int i6, Map<String, Object> map, int i7, int i8) {
        JCoreHelper.majorExecutor(context, TAG, new b(context, null, null, i6, new CallBackParams(i6, map, System.currentTimeMillis(), i7, i8)));
    }

    public void setPushStatusWithCallBack(Context context, int i6, int i7) {
        int i8 = this.sequence + 1;
        this.sequence = i8;
        JCoreHelper.majorExecutor(context, TAG, new b(context, null, null, this.sequence, new CallBackParams(i8, System.currentTimeMillis(), i6, i7)));
    }

    public void setTagsWithCallBack(Context context, int i6, Set<String> set, int i7, int i8) {
        JCoreHelper.majorExecutor(context, TAG, new b(context, null, set, i6, new CallBackParams(i6, set, System.currentTimeMillis(), i7, i8)));
    }

    private ActionHelper() {
    }

    public Object beforLogin(Context context, String str, int i6, String str2) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            return jPushAction.beforLogin(context, str, i6, str2);
        }
        return null;
    }

    public ProxyActivityAction getPopWinActivity(Context context) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            return jPushAction.getPopWinActivity(context);
        }
        return null;
    }

    public ProxyActivityAction getPushActivity(Context context) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            return jPushAction.getPushActivity(context);
        }
        return null;
    }

    public void handleNotificationIntent(Context context, Intent intent) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            jPushAction.handleNotificationIntent(context, intent);
        }
    }

    public void onInAppMessageClick(Context context, NotificationMessage notificationMessage) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            jPushAction.onInAppMessageClick(context, notificationMessage);
        }
    }

    public void onInAppMessageShow(Context context, NotificationMessage notificationMessage) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            jPushAction.onInAppMessageShow(context, notificationMessage);
        }
    }

    public void onMessage(Context context, CustomMessage customMessage) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            jPushAction.onMessage(context, customMessage);
        }
    }

    public void onMultiAction(Context context, Intent intent) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            jPushAction.onMultiAction(context, intent);
        }
    }

    public void onNotifyMessageArrived(Context context, NotificationMessage notificationMessage) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            jPushAction.onNotifyMessageArrived(context, notificationMessage);
        }
    }

    public void onNotifyMessageOpened(Context context, NotificationMessage notificationMessage) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            jPushAction.onNotifyMessageOpened(context, notificationMessage);
        }
    }

    public void onTagAliasResponse(Context context, long j6, int i6, Intent intent) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            jPushAction.onTagAliasResponse(context, j6, i6, intent);
        }
    }
}
