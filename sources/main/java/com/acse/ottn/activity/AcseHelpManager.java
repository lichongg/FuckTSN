package com.acse.ottn.activity;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import androidx.activity.k;
import com.acse.ottn.b;
import com.acse.ottn.g1;
import com.acse.ottn.h;
import com.acse.ottn.h1;
import com.acse.ottn.io.reactivex.functions.Consumer;
import com.acse.ottn.io.reactivex.functions.c;
import com.acse.ottn.io.reactivex.schedulers.Schedulers;
import com.acse.ottn.j1;
import com.acse.ottn.k0;
import com.acse.ottn.m1;
import com.acse.ottn.p0;
import com.acse.ottn.s0;
import com.acse.ottn.s3;
import com.acse.ottn.util.HelpShopAppUtil;
import com.acse.ottn.w4;
import com.acse.ottn.x4;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.TreeMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class AcseHelpManager {
    private static Application mContext;
    public static boolean mIsDebug;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.acse.ottn.activity.AcseHelpManager$3, reason: invalid class name */
    public class AnonymousClass3 implements OnOpenPermission {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f4133a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Activity f4134b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ OnCurrentStateCallBack f4135c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f4136d;

        public AnonymousClass3(boolean z5, Activity activity, OnCurrentStateCallBack onCurrentStateCallBack, boolean z6) {
            this.f4133a = z5;
            this.f4134b = activity;
            this.f4135c = onCurrentStateCallBack;
            this.f4136d = z6;
        }

        @Override // com.acse.ottn.activity.AcseHelpManager.OnOpenPermission
        public void openPermission(boolean z5) {
            if (!z5 && !this.f4133a) {
                OnCurrentStateCallBack onCurrentStateCallBack = this.f4135c;
                if (onCurrentStateCallBack != null) {
                    onCurrentStateCallBack.onState("0");
                    return;
                }
                return;
            }
            if (!AcseHelpManager.isOPenPermission()) {
                AcseHelpManager.showRunningDialog(this.f4134b, new OnClickCallBack() { // from class: com.acse.ottn.activity.AcseHelpManager.3.1
                    @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                    public void onClose() {
                        OnCurrentStateCallBack onCurrentStateCallBack2 = AnonymousClass3.this.f4135c;
                        if (onCurrentStateCallBack2 != null) {
                            onCurrentStateCallBack2.onState("4");
                        }
                    }

                    @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                    public void onDismiss() {
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        if (anonymousClass3.f4136d) {
                            AcseHelpManager.showWarningDialog(anonymousClass3.f4134b, new OnClickCallBack() { // from class: com.acse.ottn.activity.AcseHelpManager.3.1.1
                                @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                                public void onClose() {
                                    OnCurrentStateCallBack onCurrentStateCallBack2 = AnonymousClass3.this.f4135c;
                                    if (onCurrentStateCallBack2 != null) {
                                        onCurrentStateCallBack2.onState("4");
                                    }
                                }

                                @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                                public void onDismiss() {
                                    OnCurrentStateCallBack onCurrentStateCallBack2 = AnonymousClass3.this.f4135c;
                                    if (onCurrentStateCallBack2 != null) {
                                        onCurrentStateCallBack2.onState("3");
                                    }
                                }

                                @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                                public void onOpen() {
                                    OnCurrentStateCallBack onCurrentStateCallBack2 = AnonymousClass3.this.f4135c;
                                    if (onCurrentStateCallBack2 != null) {
                                        onCurrentStateCallBack2.onState("2");
                                    }
                                }
                            });
                            return;
                        }
                        OnCurrentStateCallBack onCurrentStateCallBack2 = anonymousClass3.f4135c;
                        if (onCurrentStateCallBack2 != null) {
                            onCurrentStateCallBack2.onState("0");
                        }
                    }

                    @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                    public void onOpen() {
                        OnCurrentStateCallBack onCurrentStateCallBack2 = AnonymousClass3.this.f4135c;
                        if (onCurrentStateCallBack2 != null) {
                            onCurrentStateCallBack2.onState("1");
                        }
                    }
                });
                return;
            }
            OnCurrentStateCallBack onCurrentStateCallBack2 = this.f4135c;
            if (onCurrentStateCallBack2 != null) {
                onCurrentStateCallBack2.onState("0");
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.acse.ottn.activity.AcseHelpManager$4, reason: invalid class name */
    public class AnonymousClass4 implements OnOpenPermission {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f4139a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f4140b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f4141c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f4142d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f4143e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ OnCurrentStateCallBack f4144f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ boolean f4145g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ String f4146h;

        /* renamed from: i, reason: collision with root package name */
        public final /* synthetic */ String f4147i;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ String f4148j;

        /* renamed from: k, reason: collision with root package name */
        public final /* synthetic */ String f4149k;

        public AnonymousClass4(Activity activity, String str, String str2, String str3, String str4, OnCurrentStateCallBack onCurrentStateCallBack, boolean z5, String str5, String str6, String str7, String str8) {
            this.f4139a = activity;
            this.f4140b = str;
            this.f4141c = str2;
            this.f4142d = str3;
            this.f4143e = str4;
            this.f4144f = onCurrentStateCallBack;
            this.f4145g = z5;
            this.f4146h = str5;
            this.f4147i = str6;
            this.f4148j = str7;
            this.f4149k = str8;
        }

        @Override // com.acse.ottn.activity.AcseHelpManager.OnOpenPermission
        public void openPermission(boolean z5) {
            if (!z5) {
                OnCurrentStateCallBack onCurrentStateCallBack = this.f4144f;
                if (onCurrentStateCallBack != null) {
                    onCurrentStateCallBack.onState("0");
                    return;
                }
                return;
            }
            if (!AcseHelpManager.isOPenPermission()) {
                s3.a(this.f4139a, this.f4140b, this.f4141c, this.f4142d, this.f4143e, new OnClickCallBack() { // from class: com.acse.ottn.activity.AcseHelpManager.4.1
                    @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                    public void onClose() {
                        OnCurrentStateCallBack onCurrentStateCallBack2 = AnonymousClass4.this.f4144f;
                        if (onCurrentStateCallBack2 != null) {
                            onCurrentStateCallBack2.onState("4");
                        }
                    }

                    @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                    public void onDismiss() {
                        AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                        if (anonymousClass4.f4145g) {
                            AcseHelpManager.showWarningDialog(anonymousClass4.f4139a, anonymousClass4.f4146h, anonymousClass4.f4147i, anonymousClass4.f4148j, anonymousClass4.f4149k, new OnClickCallBack() { // from class: com.acse.ottn.activity.AcseHelpManager.4.1.1
                                @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                                public void onClose() {
                                    OnCurrentStateCallBack onCurrentStateCallBack2 = AnonymousClass4.this.f4144f;
                                    if (onCurrentStateCallBack2 != null) {
                                        onCurrentStateCallBack2.onState("4");
                                    }
                                }

                                @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                                public void onDismiss() {
                                    OnCurrentStateCallBack onCurrentStateCallBack2 = AnonymousClass4.this.f4144f;
                                    if (onCurrentStateCallBack2 != null) {
                                        onCurrentStateCallBack2.onState("3");
                                    }
                                }

                                @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                                public void onOpen() {
                                    OnCurrentStateCallBack onCurrentStateCallBack2 = AnonymousClass4.this.f4144f;
                                    if (onCurrentStateCallBack2 != null) {
                                        onCurrentStateCallBack2.onState("2");
                                    }
                                }
                            });
                            return;
                        }
                        OnCurrentStateCallBack onCurrentStateCallBack2 = anonymousClass4.f4144f;
                        if (onCurrentStateCallBack2 != null) {
                            onCurrentStateCallBack2.onState("0");
                        }
                    }

                    @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                    public void onOpen() {
                        OnCurrentStateCallBack onCurrentStateCallBack2 = AnonymousClass4.this.f4144f;
                        if (onCurrentStateCallBack2 != null) {
                            onCurrentStateCallBack2.onState("1");
                        }
                    }
                });
                return;
            }
            OnCurrentStateCallBack onCurrentStateCallBack2 = this.f4144f;
            if (onCurrentStateCallBack2 != null) {
                onCurrentStateCallBack2.onState("0");
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class InitSdk {

        /* renamed from: a, reason: collision with root package name */
        public Application f4155a;

        public void build() {
            new AcseHelpManager(this);
            HelpShopAppUtil.init(AcseHelpManager.mContext);
            AcseHelpManager.isApkInDebug();
            if (!k.a(AcseHelpManager.mContext)) {
                throw new Error("shophelp SDK init activity manager throw a Error");
            }
            h1.a(AcseHelpManager.mContext);
        }

        public InitSdk setContext(Application application) {
            this.f4155a = application;
            return this;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface OnAccessiblityStateCallBack {
        void onSuccess(String str);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface OnClickCallBack {
        void onClose();

        void onDismiss();

        void onOpen();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface OnCurrentStateCallBack {
        void onState(String str);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface OnIndividuationCallBack {
        void onIndividuationState(boolean z5);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface OnOpenPermission {
        void openPermission(boolean z5);
    }

    public static void closeAccessiblityPlugIn(Activity activity, OnClickCallBack onClickCallBack) {
        if (HelpShopAppUtil.getContext() == null) {
            new InitSdk().setContext(activity.getApplication()).build();
        }
        p0.a(activity, "关闭辅助功能:", "关闭辅助功能不会影响软件正常使用。但辅助功能可以优化运动轨迹，并能提高软件的稳定性，以及自动查找优惠信息。是否仍要关闭？", "保持开启", "关闭辅助", onClickCallBack);
    }

    public static void getGoodsWelfare(OnIndividuationCallBack onIndividuationCallBack) {
        if (HelpShopAppUtil.getContext() == null) {
            return;
        }
        m1.c().a(onIndividuationCallBack);
    }

    public static String getPluninId() {
        return HelpShopAppUtil.getContext() == null ? "" : b.c().d();
    }

    private static String getProcessName(Context context) {
        if (context == null) {
            return null;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            if (activityManager != null && activityManager.getRunningAppProcesses() != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                    if (runningAppProcessInfo != null && runningAppProcessInfo.pid == Process.myPid()) {
                        return runningAppProcessInfo.processName;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static boolean isOPenPermission() {
        if (HelpShopAppUtil.getContext() == null) {
            return false;
        }
        if (j1.c().f()) {
            return b.c().e();
        }
        return true;
    }

    public static void setGoodsWelfare(String str) {
        if (HelpShopAppUtil.getContext() == null) {
            return;
        }
        m1.c().a(str);
    }

    public static void showRunningDialog(Activity activity, OnClickCallBack onClickCallBack) {
        if (HelpShopAppUtil.getContext() == null) {
            new InitSdk().setContext(activity.getApplication()).build();
        }
        s3.a(activity, onClickCallBack);
    }

    public static void showWarningDialog(Activity activity, OnClickCallBack onClickCallBack) {
        if (HelpShopAppUtil.getContext() == null) {
            new InitSdk().setContext(activity.getApplication()).build();
        }
        w4.a(activity, onClickCallBack);
    }

    public static void startRunning(Activity activity, boolean z5, boolean z6, OnCurrentStateCallBack onCurrentStateCallBack) {
        if (HelpShopAppUtil.getContext() == null) {
            new InitSdk().setContext(activity.getApplication()).build();
        }
        running(activity, z5, z6, onCurrentStateCallBack);
    }

    public static void syncUserIdState(String str, String str2) {
        if (HelpShopAppUtil.getContext() == null) {
            return;
        }
        b.c().a(str);
        b.c().a(str, str2);
    }

    private AcseHelpManager(InitSdk initSdk) {
        mContext = initSdk.f4155a;
    }

    public static boolean checkBatteryPermission() {
        if ("".equals(k0.f4687w) || HelpShopAppUtil.getContext() == null || Build.VERSION.SDK_INT <= 28) {
            return true;
        }
        return x4.a().b(k0.f4687w);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isApkInDebug() {
        try {
            boolean z5 = (mContext.getApplicationInfo().flags & 2) != 0 && mContext.getPackageName().equals(k0.f4679o);
            mIsDebug = z5;
            return z5;
        } catch (Exception unused) {
            return mIsDebug;
        }
    }

    public static void lon_lat() {
        TreeMap treeMap = new TreeMap();
        treeMap.put(SocializeProtocolConstants.PROTOCOL_KEY_AK, HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionExID());
        new g1().h(s0.a().a(treeMap, "")).w5(Schedulers.newThread()).I3(h.a()).u5(new Consumer<String>() { // from class: com.acse.ottn.activity.AcseHelpManager.6
            @Override // com.acse.ottn.io.reactivex.functions.Consumer
            public void accept(String str) throws Exception {
            }

            @Override // com.acse.ottn.io.reactivex.functions.Consumer, rx.functions.b
            public /* synthetic */ void call(Object obj) {
                c.a(this, obj);
            }
        }, new Consumer<Throwable>() { // from class: com.acse.ottn.activity.AcseHelpManager.7
            @Override // com.acse.ottn.io.reactivex.functions.Consumer
            public void accept(Throwable th) throws Exception {
            }

            @Override // com.acse.ottn.io.reactivex.functions.Consumer, rx.functions.b
            public /* synthetic */ void call(Object obj) {
                c.a(this, obj);
            }
        });
    }

    public static void openAccessiblityView(Activity activity) {
        activity.startActivity(new Intent("android.settings.ACCESSIBILITY_SETTINGS"));
    }

    public static void openFloatWindow(Activity activity) {
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        intent.setData(Uri.parse("package:" + activity.getPackageName()));
        activity.startActivity(intent);
    }

    private static void running(Activity activity, boolean z5, boolean z6, OnCurrentStateCallBack onCurrentStateCallBack) {
        isShowRunningDialog(activity, new AnonymousClass3(z6, activity, onCurrentStateCallBack, z5));
    }

    public static void startAccessibilityIntroduceActivityForResult(Activity activity, int i6) {
        activity.startActivityForResult(new Intent(activity, (Class<?>) AccessibiltyTsnPermissionGreenActivity.class), i6);
    }

    public static boolean checkAccessiblityState() {
        if (HelpShopAppUtil.getContext() == null) {
            return false;
        }
        return b.c().e();
    }

    public static boolean checkFloatWindow() {
        if (HelpShopAppUtil.getContext() == null) {
            return false;
        }
        return b.c().a();
    }

    public static void close_remind() {
        if (HelpShopAppUtil.getContext() == null) {
            return;
        }
        m1.c().b();
    }

    public static void customDialog(Activity activity, String str, String str2, String str3, String str4, OnClickCallBack onClickCallBack) {
        if (HelpShopAppUtil.getContext() == null) {
            new InitSdk().setContext(activity.getApplication()).build();
        }
        p0.a(activity, str, str2, str3, str4, onClickCallBack);
    }

    public static void getGoodsWelfare(Activity activity, OnIndividuationCallBack onIndividuationCallBack) {
        if (HelpShopAppUtil.getContext() == null) {
            new InitSdk().setContext(activity.getApplication()).build();
        }
        m1.c().a(onIndividuationCallBack);
    }

    private static void isShowRunningDialog(Activity activity, OnOpenPermission onOpenPermission) {
        if (HelpShopAppUtil.getContext() == null) {
            new InitSdk().setContext(activity.getApplication()).build();
        }
        m1.c().a(activity, onOpenPermission);
    }

    public static boolean isTargetProcess(Application application) {
        try {
            if (HelpShopAppUtil.getContext() == null) {
                new InitSdk().setContext(application).build();
            }
            if (getProcessName(application).equals(".LoadingActivity")) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void openAccessiblityDialog(Activity activity, OnClickCallBack onClickCallBack) {
        if (HelpShopAppUtil.getContext() == null) {
            new InitSdk().setContext(activity.getApplication()).build();
        }
        p0.a(activity, "提示:", "需要启用辅助功能，才能为您一键开启必要权限。", "立即开启", "再想想", onClickCallBack);
    }

    public static void openBatteryPermission(Activity activity) {
        if (HelpShopAppUtil.getContext() == null) {
            new InitSdk().setContext(activity.getApplication()).build();
        }
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts(WiseOpenHianalyticsData.UNION_PACKAGE, k0.f4687w, null));
        try {
            activity.startActivity(intent);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public static void openWithOneButton(final Activity activity, final int i6, final OnCurrentStateCallBack onCurrentStateCallBack) {
        if (HelpShopAppUtil.getContext() == null) {
            new InitSdk().setContext(activity.getApplication()).build();
        }
        if (!isOPenPermission()) {
            if (k0.f4674j.equals(Boolean.valueOf(b.c().e()))) {
                openAccessiblityDialog(activity, new OnClickCallBack() { // from class: com.acse.ottn.activity.AcseHelpManager.5
                    @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                    public void onClose() {
                        OnCurrentStateCallBack onCurrentStateCallBack2 = OnCurrentStateCallBack.this;
                        if (onCurrentStateCallBack2 != null) {
                            onCurrentStateCallBack2.onState("02");
                        }
                    }

                    @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                    public void onDismiss() {
                        OnCurrentStateCallBack onCurrentStateCallBack2 = OnCurrentStateCallBack.this;
                        if (onCurrentStateCallBack2 != null) {
                            onCurrentStateCallBack2.onState("03");
                        }
                    }

                    @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                    public void onOpen() {
                        OnCurrentStateCallBack onCurrentStateCallBack2 = OnCurrentStateCallBack.this;
                        if (onCurrentStateCallBack2 != null) {
                            onCurrentStateCallBack2.onState("01");
                        }
                        AcseHelpManager.setGoodsWelfare(k0.f4673i);
                        AcseHelpManager.startAccessibilityIntroduceActivityForResult(activity, i6);
                    }
                });
                return;
            }
            if (onCurrentStateCallBack != null) {
                onCurrentStateCallBack.onState("4");
            }
            startAccessibilityIntroduceActivityForResult(activity, i6);
            return;
        }
        if (onCurrentStateCallBack != null) {
            onCurrentStateCallBack.onState("5");
        }
    }

    public static void setGoodsWelfare(Activity activity, String str) {
        if (HelpShopAppUtil.getContext() == null) {
            new InitSdk().setContext(activity.getApplication()).build();
        }
        m1.c().a(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void setOpenWithOneButtonColorState(android.app.Activity r2, com.acse.ottn.activity.AcseHelpManager.OnCurrentStateCallBack r3) {
        /*
            android.content.Context r0 = com.acse.ottn.util.HelpShopAppUtil.getContext()
            if (r0 != 0) goto L16
            com.acse.ottn.activity.AcseHelpManager$InitSdk r0 = new com.acse.ottn.activity.AcseHelpManager$InitSdk
            r0.<init>()
            android.app.Application r1 = r2.getApplication()
            com.acse.ottn.activity.AcseHelpManager$InitSdk r0 = r0.setContext(r1)
            r0.build()
        L16:
            com.acse.ottn.b r0 = com.acse.ottn.b.c()     // Catch: java.lang.Throwable -> L2b
            boolean r0 = r0.e()     // Catch: java.lang.Throwable -> L2b
            if (r0 == 0) goto L2d
            com.acse.ottn.b r0 = com.acse.ottn.b.c()     // Catch: java.lang.Throwable -> L2b
            boolean r0 = r0.a()     // Catch: java.lang.Throwable -> L2b
            if (r0 != 0) goto L37
            goto L2d
        L2b:
            goto L37
        L2d:
            android.content.Intent r0 = new android.content.Intent     // Catch: java.lang.Throwable -> L2b
            java.lang.Class<com.acse.ottn.service.StartProcreeService> r1 = com.acse.ottn.service.StartProcreeService.class
            r0.<init>(r2, r1)     // Catch: java.lang.Throwable -> L2b
            r2.startService(r0)     // Catch: java.lang.Throwable -> L2b
        L37:
            int r2 = android.os.Build.VERSION.SDK_INT
            r0 = 28
            java.lang.String r1 = "0"
            if (r2 <= r0) goto L53
            boolean r2 = isOPenPermission()
            if (r2 != 0) goto L4d
            if (r3 == 0) goto L58
            java.lang.String r2 = "1"
            r3.onState(r2)
            goto L58
        L4d:
            if (r3 == 0) goto L58
            r3.onState(r1)
            goto L58
        L53:
            if (r3 == 0) goto L58
            r3.onState(r1)
        L58:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.acse.ottn.activity.AcseHelpManager.setOpenWithOneButtonColorState(android.app.Activity, com.acse.ottn.activity.AcseHelpManager$OnCurrentStateCallBack):void");
    }

    public static void showFrequentOperationDialog(Activity activity, OnClickCallBack onClickCallBack) {
        if (HelpShopAppUtil.getContext() == null) {
            new InitSdk().setContext(activity.getApplication()).build();
        }
        w4.a(activity, onClickCallBack);
    }

    public static void closeAccessiblityPlugIn(Activity activity, String str, String str2, String str3, String str4, OnClickCallBack onClickCallBack) {
        if (HelpShopAppUtil.getContext() == null) {
            new InitSdk().setContext(activity.getApplication()).build();
        }
        p0.a(activity, str, str2, str3, str4, onClickCallBack);
    }

    public static String getPluninId(Activity activity) {
        if (HelpShopAppUtil.getContext() == null) {
            new InitSdk().setContext(activity.getApplication()).build();
        }
        return b.c().d();
    }

    public static void isOPenPermission(Activity activity, final OnOpenPermission onOpenPermission) {
        if (HelpShopAppUtil.getContext() == null) {
            new InitSdk().setContext(activity.getApplication()).build();
        }
        isShowRunningDialog(activity, new OnOpenPermission() { // from class: com.acse.ottn.activity.AcseHelpManager.1
            @Override // com.acse.ottn.activity.AcseHelpManager.OnOpenPermission
            public void openPermission(boolean z5) {
                if (!z5) {
                    OnOpenPermission.this.openPermission(true);
                } else if (j1.c().f()) {
                    OnOpenPermission.this.openPermission(b.c().e() && b.c().a());
                } else {
                    OnOpenPermission.this.openPermission(true);
                }
            }
        });
    }

    public static void showRunningDialog(Activity activity, String str, String str2, String str3, String str4, OnClickCallBack onClickCallBack) {
        if (HelpShopAppUtil.getContext() == null) {
            new InitSdk().setContext(activity.getApplication()).build();
        }
        s3.a(activity, str, str2, str3, str4, onClickCallBack);
    }

    public static void showWarningDialog(Activity activity, String str, String str2, String str3, String str4, OnClickCallBack onClickCallBack) {
        if (HelpShopAppUtil.getContext() == null) {
            new InitSdk().setContext(activity.getApplication()).build();
        }
        w4.a(activity, str, str2, str3, str4, onClickCallBack);
    }

    public static void startRunning(Activity activity, boolean z5, OnCurrentStateCallBack onCurrentStateCallBack) {
        if (HelpShopAppUtil.getContext() == null) {
            new InitSdk().setContext(activity.getApplication()).build();
        }
        running(activity, z5, false, onCurrentStateCallBack);
    }

    public static void syncUserIdState(Activity activity, String str, String str2) {
        if (HelpShopAppUtil.getContext() == null) {
            new InitSdk().setContext(activity.getApplication()).build();
        }
        b.c().a(str);
        b.c().a(str, str2);
    }

    public static String getGoodsWelfare() {
        if (HelpShopAppUtil.getContext() == null) {
            return "1";
        }
        return j1.c().a();
    }

    public static void isOPenPermission(final OnOpenPermission onOpenPermission) {
        if (HelpShopAppUtil.getContext() == null) {
            return;
        }
        isShowRunningDialog(null, new OnOpenPermission() { // from class: com.acse.ottn.activity.AcseHelpManager.2
            @Override // com.acse.ottn.activity.AcseHelpManager.OnOpenPermission
            public void openPermission(boolean z5) {
                if (!z5) {
                    OnOpenPermission.this.openPermission(true);
                } else if (j1.c().f()) {
                    OnOpenPermission.this.openPermission(b.c().e() && b.c().a());
                } else {
                    OnOpenPermission.this.openPermission(true);
                }
            }
        });
    }

    public static void startRunning(Activity activity, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z5, OnCurrentStateCallBack onCurrentStateCallBack) {
        if (HelpShopAppUtil.getContext() == null) {
            new InitSdk().setContext(activity.getApplication()).build();
        }
        isShowRunningDialog(activity, new AnonymousClass4(activity, str, str2, str3, str4, onCurrentStateCallBack, z5, str5, str6, str7, str8));
    }

    public static void syncUserIdState(String str) {
        if (HelpShopAppUtil.getContext() == null) {
            return;
        }
        syncUserIdState(str, "0");
    }

    public static void syncUserIdState(Activity activity, String str) {
        if (HelpShopAppUtil.getContext() == null) {
            new InitSdk().setContext(activity.getApplication()).build();
        }
        syncUserIdState(str, "0");
    }
}
