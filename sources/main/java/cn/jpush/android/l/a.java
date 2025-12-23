package cn.jpush.android.l;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.internal.JConstants;
import cn.jpush.android.ad.g;
import cn.jpush.android.api.CallBackParams;
import cn.jpush.android.api.CustomMessage;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.NotificationMessage;
import cn.jpush.android.b.d;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushAction;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.local.JPushResponse;
import cn.jpush.android.local.ProxyActivityAction;
import cn.jpush.android.service.JPushMessageReceiver;
import cn.jpush.android.ui.c;
import cn.jpush.android.x.b;
import cn.jpush.android.x.e;
import cn.jpush.android.x.f;
import com.stub.StubApp;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a extends JPushAction {

    /* renamed from: e, reason: collision with root package name */
    private static boolean f3691e = false;

    /* renamed from: f, reason: collision with root package name */
    private static int f3692f = 1000;

    /* renamed from: g, reason: collision with root package name */
    private static int f3693g = 1001;

    /* renamed from: a, reason: collision with root package name */
    private Boolean f3694a;

    /* renamed from: b, reason: collision with root package name */
    private Boolean f3695b;

    /* renamed from: c, reason: collision with root package name */
    private Context f3696c;

    /* renamed from: d, reason: collision with root package name */
    private cn.jpush.android.s.a f3697d = new cn.jpush.android.s.a();

    private static JSONObject a(ByteBuffer byteBuffer) {
        try {
            ByteBuffer wrap = ByteBuffer.wrap(byteBuffer.array());
            wrap.getLong();
            byte[] bArr = new byte[wrap.getShort()];
            wrap.get(bArr);
            String str = new String(bArr, "UTF-8");
            Logger.d("JPushActionImpl", "parseBundle2Json content: " + str);
            return new JSONObject(str);
        } catch (Exception e6) {
            Logger.w("JPushActionImpl", "parseBundle2Json exception:" + e6.getMessage());
            return null;
        }
    }

    private static void b(Context context, Bundle bundle) {
        if (bundle == null) {
            Logger.w("JPushActionImpl", "[setSilenceTime] bundle is bull");
            return;
        }
        String string = bundle.getString("time");
        Logger.dd("JPushActionImpl", "action:setSilenceTime pushTime:" + string);
        cn.jpush.android.cache.a.c(context, string);
    }

    private void c(Context context) {
        Logger.d("JPushActionImpl", "serviceInit...");
        try {
            if (this.f3695b != null) {
                return;
            }
            this.f3695b = Boolean.TRUE;
            b.a(context, 0, true);
            g.a().a(context);
            d(context);
            Logger.d("JPushActionImpl", "google:false");
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:231:0x0524, code lost:
    
        if (r0 == 2001) goto L237;
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x0526, code lost:
    
        if (r0 == 0) goto L237;
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x0528, code lost:
    
        if (r0 != 2002) goto L249;
     */
    /* JADX WARN: Code restructure failed: missing block: B:347:0x07a7, code lost:
    
        a(r8, r12, r18);
     */
    @Override // cn.jpush.android.local.JPushAction
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object handleAction(android.content.Context r17, java.lang.String r18, java.lang.Object r19) {
        /*
            Method dump skipped, instructions count: 1988
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.l.a.handleAction(android.content.Context, java.lang.String, java.lang.Object):java.lang.Object");
    }

    @Override // cn.jpush.android.local.JPushAction
    public void onJPushMessageReceive(Context context, JPushMessageReceiver jPushMessageReceiver, Intent intent) {
        cn.jpush.android.helper.a.a().a(context, jPushMessageReceiver, intent);
    }

    public static void a(Context context) {
        if (f3691e) {
            return;
        }
        f3691e = true;
        if (JPushConstants.SUPPORT_DY && JConstants.SDK_VERSION_INT >= 220) {
            JCoreHelper.updateDy(context, 2);
        }
        int i6 = !TextUtils.isEmpty(JPushConstants.SDK_NAME) ? 2 : 0;
        int i7 = cn.jpush.android.m.a.f3708a == JPushConstants.SDK_VERSION_CODE ? JConstants.SDK_VERSION_INT < 220 ? 0 : 1 : 2;
        Logger.d("JPushActionImpl", "custom:" + i6 + ",dynamic:" + i7);
        e.a().a(context, null);
        JCoreHelper.reportSdkType(context, "push", i6, i7, cn.jpush.android.m.a.f3708a);
        if (JPushConstants.canGetLbsInBackGround(context)) {
            d.a().b();
        }
        cn.jpush.android.p.b.a().a(context);
        cn.jpush.android.ab.a.a(context);
    }

    private boolean b(Context context) {
        Boolean bool = this.f3694a;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (context == null) {
            Logger.ww("JPushActionImpl", "context is null");
            return false;
        }
        this.f3696c = StubApp.getOrigApplicationContext(context.getApplicationContext());
        Boolean valueOf = Boolean.valueOf(cn.jpush.android.ad.a.h(context));
        this.f3694a = valueOf;
        return valueOf.booleanValue();
    }

    private static void c(Context context, Bundle bundle) {
        if (bundle == null) {
            Logger.w("JPushActionImpl", "[setPushTime] bundle is bull");
            return;
        }
        cn.jpush.android.cache.a.c(context, true);
        String string = bundle.getString("time");
        if (!Pattern.compile("([0-6]{0,7})_((([0-9]|1[0-9]|2[0-3])\\^([0-9]|1[0-9]|2[0-3]))|(([0-9]|1[0-9]|2[0-3])\\^([0-9]|1[0-9]|2[0-3])-)+(([0-9]|1[0-9]|2[0-3])\\^([0-9]|1[0-9]|2[0-3])))").matcher(string).matches()) {
            Logger.ee("JPushActionImpl", "Invalid time format - " + string);
            return;
        }
        String h6 = cn.jpush.android.cache.a.h(context);
        if (string.equals(h6)) {
            Logger.dd("JPushActionImpl", "Already SetPushTime, give up - " + h6);
            return;
        }
        Logger.dd("JPushActionImpl", "action:setPushTime pushTime:" + string);
        cn.jpush.android.cache.a.b(context, string);
    }

    private void d(Context context) {
        try {
            Class.forName("cn.jpush.android.dy.JPushThirdDyManager").getDeclaredMethod("update", Context.class).invoke(null, context);
        } catch (Throwable unused) {
        }
    }

    @Override // cn.jpush.android.local.JPushAction
    public ProxyActivityAction getPopWinActivity(Context context) {
        return new cn.jpush.android.ui.b();
    }

    @Override // cn.jpush.android.local.JPushAction
    public ProxyActivityAction getPushActivity(Context context) {
        return new c();
    }

    @Override // cn.jpush.android.local.JPushAction
    public String getSdkVersion(String str) {
        return cn.jpush.android.m.a.f3709b;
    }

    @Override // cn.jpush.android.local.JPushAction
    public void onInAppMessageClick(Context context, NotificationMessage notificationMessage) {
        cn.jpush.android.helper.a.a(context, notificationMessage, JPushInterface.ACTION_IN_APP_MSG_CLICK);
    }

    @Override // cn.jpush.android.local.JPushAction
    public void onInAppMessageShow(Context context, NotificationMessage notificationMessage) {
        cn.jpush.android.helper.a.a(context, notificationMessage, JPushInterface.ACTION_IN_APP_MSG_SHOW);
    }

    @Override // cn.jpush.android.local.JPushAction
    public void onJPushMessageReceive(Context context, String str, String str2, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        try {
            cn.jpush.android.helper.a.a().a(context, JPushConstants.getPushMessageReceiver(context), cn.jpush.android.ad.a.a(bundle));
        } catch (Throwable unused) {
        }
    }

    @Override // cn.jpush.android.local.JPushAction
    public void onNotifyMessageArrived(Context context, NotificationMessage notificationMessage) {
        cn.jpush.android.helper.a.a(context, notificationMessage, JPushInterface.ACTION_NOTIFICATION_RECEIVED);
    }

    @Override // cn.jpush.android.local.JPushAction
    public void onNotifyMessageOpened(Context context, NotificationMessage notificationMessage) {
        cn.jpush.android.helper.a.a(context, notificationMessage, JPushInterface.ACTION_NOTIFICATION_OPENED);
    }

    private static void a(Context context, int i6, long j6) {
        if (i6 != 10) {
            if (i6 == 37) {
                d.a().a(j6, JPushInterface.ErrorCode.TIMEOUT, null);
                return;
            } else if (i6 != 38) {
                switch (i6) {
                    case 26:
                        cn.jpush.android.helper.d.a().a(context, j6, JPushInterface.ErrorCode.TIMEOUT);
                        break;
                    case 27:
                        cn.jpush.android.ac.c.a().b(context, j6);
                        break;
                }
                return;
            }
        }
        cn.jpush.android.ab.b.a(context, cn.jpush.android.ab.c.a().a(j6), JPushInterface.ErrorCode.TIMEOUT, j6);
    }

    @Override // cn.jpush.android.local.JPushAction
    public Object beforLogin(Context context, String str, int i6, String str2) {
        String str3;
        b(context);
        if (context == null) {
            str3 = "context was null";
        } else if (TextUtils.isEmpty(str2)) {
            str3 = " filed name was empty";
        } else {
            if ("platformtype".equals(str2)) {
                if (i6 >= 16) {
                    return Byte.valueOf(cn.jpush.android.ac.e.a().d(context));
                }
            } else if ("platformregid".equals(str2)) {
                return cn.jpush.android.ac.e.a().b(context);
            }
            return null;
        }
        Logger.e("JPushActionImpl", str3);
        return null;
    }

    @Override // cn.jpush.android.local.JPushAction
    public void handleNotificationIntent(Context context, Intent intent) {
        if (!b.a(context, intent)) {
            return;
        }
        cn.jpush.android.d.d b6 = b.b(context, intent);
        Logger.i("JPushActionImpl", "handleNotificationIntent:" + b6);
        if (b6 == null) {
            g.a().a(context, intent);
            Logger.i("JPushActionImpl", "handleNotificationIntent handleOpenClick");
        } else if (JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent.getAction())) {
            g.a().a(context, b6, intent);
        } else {
            b.a(context, intent.getAction(), b6, intent);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    @Override // cn.jpush.android.local.JPushAction
    public void onActivityLifeCallback(Activity activity, String str) {
        try {
            switch (str.hashCode()) {
                case -1897185151:
                    if (str.equals("started")) {
                        this.f3697d.b(activity);
                        break;
                    }
                    break;
                case -1884319283:
                    if (str.equals("stopped")) {
                        this.f3697d.e(activity);
                        break;
                    }
                    break;
                case -995321554:
                    if (str.equals("paused")) {
                        this.f3697d.d(activity);
                        break;
                    }
                    break;
                case 1097547223:
                    if (str.equals("resumed")) {
                        this.f3697d.c(activity);
                        break;
                    }
                    break;
                case 1986762265:
                    if (str.equals("destroyed")) {
                        this.f3697d.f(activity);
                        break;
                    }
                    break;
            }
        } catch (Throwable th) {
            Logger.w("JPushActionImpl", "onActivityLifeCallback failed. " + th.getMessage());
        }
    }

    @Override // cn.jpush.android.local.JPushAction
    public void onMessage(Context context, CustomMessage customMessage) {
        cn.jpush.android.helper.a.a(context, customMessage);
    }

    @Override // cn.jpush.android.local.JPushAction
    public void onMultiAction(Context context, Intent intent) {
        cn.jpush.android.helper.a.b(context, intent);
    }

    @Override // cn.jpush.android.local.JPushAction
    public void onTagAliasResponse(Context context, long j6, int i6, Intent intent) {
        cn.jpush.android.ab.d.a().a(StubApp.getOrigApplicationContext(context.getApplicationContext()), j6, i6, intent);
    }

    @Override // cn.jpush.android.local.JPushAction
    public void setAliasAndTags(Context context, String str, Set<String> set, CallBackParams callBackParams) {
        cn.jpush.android.ab.b.a(context, str, set, callBackParams);
    }

    private static void a(Context context, Bundle bundle) {
        if (bundle == null) {
            Logger.w("JPushActionImpl", "[setMaxNotificationNum] bundle is bull");
            return;
        }
        int i6 = bundle.getInt("num");
        Logger.dd("JPushActionImpl", "action:setMaxNotificationNum :" + i6);
        int b6 = f.b();
        Logger.v("JPushActionImpl", "number in queue: " + b6);
        if (i6 < b6) {
            int i7 = b6 - i6;
            Logger.v("JPushActionImpl", "decreaseNotification:" + i7);
            b.c(context, i7);
        }
        cn.jpush.android.cache.a.c(context, i6);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x004d, code lost:
    
        if (r5 == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x00d3, code lost:
    
        r10 = cn.jpush.android.l.a.f3692f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006d, code lost:
    
        if (r10 == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00d0, code lost:
    
        if (r3 == false) goto L44;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(android.content.Context r8, android.os.Bundle r9, java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 308
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.l.a.a(android.content.Context, android.os.Bundle, java.lang.String):void");
    }

    private static void a(Context context, JPushResponse jPushResponse) {
        Logger.dd("JPushActionImpl", "action:handleMsg:" + jPushResponse);
        if (jPushResponse == null) {
            return;
        }
        int cmd = jPushResponse.getCmd();
        if (cmd == 3) {
            cn.jpush.android.z.c cVar = new cn.jpush.android.z.c(jPushResponse);
            if (cn.jpush.android.cache.a.e(context)) {
                Logger.d("JPushActionImpl", "JPush was stoped");
                if (cVar.a() != 20) {
                    return;
                }
            }
            cn.jpush.android.d.b.a(context, cVar);
            return;
        }
        int i6 = 2;
        if (cmd != 10 && cmd != 40) {
            switch (cmd) {
                case 25:
                    JSONObject a6 = a(jPushResponse.getBody());
                    if (a6 != null) {
                        switch (a6.optInt("cmd")) {
                            case 56:
                                d.a().a(a6);
                                break;
                            case 57:
                                break;
                            case 58:
                            default:
                                Logger.d("JPushActionImpl", "Unknown command for ctrl");
                                break;
                            case 59:
                                a(context, a6);
                                break;
                            case 60:
                                b.a(context, 2, true);
                                break;
                        }
                        return;
                    }
                    return;
                case 26:
                    cn.jpush.android.z.a aVar = new cn.jpush.android.z.a(jPushResponse);
                    cn.jpush.android.helper.d.a().a(context, aVar.getRquestId(), aVar.a());
                    return;
                case 27:
                    cn.jpush.android.z.a aVar2 = new cn.jpush.android.z.a(jPushResponse);
                    if (aVar2.a() == 0) {
                        cn.jpush.android.ac.c.a().a(context, jPushResponse.getRquestId());
                        return;
                    } else {
                        cn.jpush.android.ac.c.a().a(context, jPushResponse.getRquestId(), aVar2.a());
                        return;
                    }
                case 28:
                case 29:
                    break;
                default:
                    switch (cmd) {
                        case 36:
                            d.a().a(new cn.jpush.android.n.b(jPushResponse));
                            break;
                        case 37:
                            d.a().a(jPushResponse.getRquestId(), 0, new cn.jpush.android.n.d(jPushResponse));
                            break;
                        case 38:
                            break;
                        default:
                            Logger.w("JPushActionImpl", "Unknown command for parsing inbound. Union AD cmd: " + jPushResponse.getCmd());
                            break;
                    }
                    return;
            }
        }
        cn.jpush.android.z.e eVar = new cn.jpush.android.z.e(jPushResponse);
        int cmd2 = jPushResponse.getCmd();
        if (cmd2 == 28) {
            i6 = 1;
        } else if (cmd2 == 38) {
            i6 = 3;
        } else if (cmd2 == 40) {
            i6 = 4;
        }
        cn.jpush.android.ab.b.a(context, eVar.a(), i6, jPushResponse.getRquestId(), eVar.f4024a);
    }

    private static void a(Context context, JSONObject jSONObject) {
        Context context2;
        try {
            String optString = jSONObject.getJSONObject("content").optString("ids");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            Logger.d("JPushActionImpl", "dealCancelNotification ids=" + optString);
            String[] split = optString.split(",");
            LinkedList linkedList = new LinkedList();
            int length = split.length;
            int i6 = 0;
            while (i6 < length) {
                String str = split[i6];
                if (TextUtils.isEmpty(str)) {
                    context2 = context;
                } else {
                    if (cn.jpush.android.x.d.a(context, str)) {
                        int a6 = b.a(str, 0);
                        Logger.d("JPushActionImpl", "message id:" + str + " is in local history ,try cancel notificationID : " + a6);
                        if (b.a(context, a6)) {
                            b.d(context, a6);
                            cn.jpush.android.helper.c.a(split.length == 2 ? split[1] : str, 1068L, context);
                        }
                    } else {
                        if (!cn.jpush.android.x.d.a(context, str, null, 1)) {
                            byte d6 = cn.jpush.android.ac.e.a().d(context, str);
                            Logger.d("JPushActionImpl", "message id:" + str + " may be ospush channel,try cancel by sdkType: " + ((int) d6));
                            if (d6 != -1) {
                                context2 = context;
                                cn.jpush.android.helper.c.a(str, "", d6, 1069L, context2);
                            }
                        } else {
                            context2 = context;
                            Logger.d("JPushActionImpl", "dealCancelNotification , do nothing ");
                        }
                        linkedList.add(str);
                    }
                    context2 = context;
                    linkedList.add(str);
                }
                i6++;
                context = context2;
            }
            Context context3 = context;
            cn.jpush.android.q.a.a().a(context3, optString);
            cn.jpush.android.x.d.a(context3, linkedList, -1);
        } catch (Throwable th) {
            Logger.w("JPushActionImpl", "dealCancelNotification e:" + th);
        }
    }
}
