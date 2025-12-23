package com.umeng.socialize.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.stub.StubApp;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.ShareContent;
import com.umeng.socialize.SocializeException;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareConfig;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.HandlerRequestCode;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.bean.UmengErrorCode;
import com.umeng.socialize.common.QueuedWork;
import com.umeng.socialize.handler.UMMoreHandler;
import com.umeng.socialize.handler.UMSSOHandler;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMVideo;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.media.UMusic;
import com.umeng.socialize.net.analytics.SocialAnalytics;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.net.dplus.DplusApi;
import com.umeng.socialize.net.dplus.cache1.DplusCacheApi;
import com.umeng.socialize.net.utils.SocializeNetUtils;
import com.umeng.socialize.utils.CommonUtil;
import com.umeng.socialize.utils.ContextUtil;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.SocializeUtils;
import com.umeng.socialize.utils.UmengText;
import com.umeng.socialize.utils.UrlUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    private static final String f42241b = "umeng_share_platform";

    /* renamed from: c, reason: collision with root package name */
    private static final String f42242c = "share_action";

    /* renamed from: a, reason: collision with root package name */
    private SHARE_MEDIA f42243a;

    /* renamed from: d, reason: collision with root package name */
    private final Map<SHARE_MEDIA, UMSSOHandler> f42244d;

    /* renamed from: e, reason: collision with root package name */
    private final List<Pair<SHARE_MEDIA, String>> f42245e;

    /* renamed from: f, reason: collision with root package name */
    private final C0837a f42246f;

    /* renamed from: g, reason: collision with root package name */
    private Context f42247g;

    /* renamed from: h, reason: collision with root package name */
    private final SparseArray<UMAuthListener> f42248h;

    /* renamed from: i, reason: collision with root package name */
    private final SparseArray<UMShareListener> f42249i;

    /* renamed from: j, reason: collision with root package name */
    private final SparseArray<UMAuthListener> f42250j;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.umeng.socialize.b.a$a, reason: collision with other inner class name */
    private static class C0837a {

        /* renamed from: a, reason: collision with root package name */
        private final Map<SHARE_MEDIA, UMSSOHandler> f42309a;

        private boolean a(Context context) {
            return context != null;
        }

        public boolean a(Context context, SHARE_MEDIA share_media) {
            if (CommonUtil.isSilentMode(context) || !a(context) || !a(share_media)) {
                return false;
            }
            if (this.f42309a.get(share_media).isSupportAuth()) {
                return true;
            }
            SLog.E(share_media.toString() + UmengText.AUTH.NOT_SUPPORT_PLATFROM);
            return false;
        }

        public C0837a(Map<SHARE_MEDIA, UMSSOHandler> map) {
            this.f42309a = map;
        }

        public boolean a(ShareAction shareAction, Activity activity) {
            SHARE_MEDIA platform;
            if (CommonUtil.isSilentMode(activity) || (platform = shareAction.getPlatform()) == null) {
                return false;
            }
            if ((platform == SHARE_MEDIA.SINA || platform == SHARE_MEDIA.QQ) && !PlatformConfig.configs.get(platform).isConfigured()) {
                SLog.E(UmengText.CHECK.noKey(platform));
                return false;
            }
            return a(platform);
        }

        private boolean a(SHARE_MEDIA share_media) {
            if (this.f42309a.get(share_media) != null) {
                return true;
            }
            SLog.mutlE(UmengText.CHECK.noJar(share_media), UrlUtil.ALL_NO_JAR);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized UMShareListener e(int i6) {
        UMShareListener uMShareListener;
        uMShareListener = this.f42249i.get(i6, null);
        if (uMShareListener != null) {
            this.f42249i.remove(i6);
        }
        return uMShareListener;
    }

    public boolean d(Activity activity, SHARE_MEDIA share_media) {
        if (!this.f42246f.a(activity, share_media)) {
            return false;
        }
        this.f42244d.get(share_media).onCreate(activity, PlatformConfig.getPlatform(share_media));
        return this.f42244d.get(share_media).isAuthorize();
    }

    private void b(Context context) {
        String appkey = SocializeUtils.getAppkey(context);
        if (TextUtils.isEmpty(appkey)) {
            throw new SocializeException(UmengText.errorWithUrl(UmengText.CHECK.APPKEY_NOT_FOUND, UrlUtil.ALL_NO_APPKEY));
        }
        if (SocializeNetUtils.isConSpeCharacters(appkey)) {
            throw new SocializeException(UmengText.errorWithUrl(UmengText.CHECK.APPKEY_NOT_FOUND, UrlUtil.ALL_ERROR_APPKEY));
        }
        if (SocializeNetUtils.isSelfAppkey(appkey)) {
            throw new SocializeException(UmengText.errorWithUrl(UmengText.CHECK.APPKEY_NOT_FOUND, UrlUtil.ALL_ERROR_APPKEY));
        }
    }

    public String c(Activity activity, SHARE_MEDIA share_media) {
        if (!this.f42246f.a(activity, share_media)) {
            return "";
        }
        this.f42244d.get(share_media).onCreate(activity, PlatformConfig.getPlatform(share_media));
        return this.f42244d.get(share_media).getSDKVersion();
    }

    public a(Context context) {
        HashMap hashMap = new HashMap();
        this.f42244d = hashMap;
        ArrayList arrayList = new ArrayList();
        this.f42245e = arrayList;
        arrayList.add(Pair.create(SHARE_MEDIA.SINA, "com.umeng.socialize.handler.SinaSsoHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.QQ, "com.umeng.socialize.handler.UMQQSsoHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.QZONE, "com.umeng.socialize.handler.QZoneSsoHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.WEIXIN, "com.umeng.socialize.handler.UMWXHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.WEIXIN_CIRCLE, ""));
        arrayList.add(Pair.create(SHARE_MEDIA.WEIXIN_FAVORITE, ""));
        arrayList.add(Pair.create(SHARE_MEDIA.PINTEREST, "com.umeng.socialize.handler.UMPinterestHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.WXWORK, "com.umeng.socialize.handler.UMWXWorkHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.YIXIN, "com.umeng.socialize.handler.UMYXHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.YIXIN_CIRCLE, ""));
        arrayList.add(Pair.create(SHARE_MEDIA.EMAIL, "com.umeng.socialize.handler.EmailHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.EVERNOTE, "com.umeng.socialize.handler.UMEvernoteHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.FACEBOOK, "com.umeng.socialize.handler.UMFacebookHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.FACEBOOK_MESSAGER, ""));
        arrayList.add(Pair.create(SHARE_MEDIA.FLICKR, "com.umeng.socialize.handler.UMFlickrHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.FOURSQUARE, "com.umeng.socialize.handler.UMFourSquareHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.INSTAGRAM, "com.umeng.socialize.handler.UMInstagramHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.KAKAO, "com.umeng.socialize.handler.UMKakaoHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.LINE, "com.umeng.socialize.handler.UMLineHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.LINKEDIN, "com.umeng.socialize.handler.UMLinkedInHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.POCKET, "com.umeng.socialize.handler.UMPocketHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.WHATSAPP, "com.umeng.socialize.handler.UMWhatsAppHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.YNOTE, "com.umeng.socialize.handler.UMYNoteHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.SMS, "com.umeng.socialize.handler.SmsHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.DOUBAN, "com.umeng.socialize.handler.DoubanHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.TUMBLR, "com.umeng.socialize.handler.UMTumblrHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.TWITTER, "com.umeng.socialize.handler.TwitterHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.ALIPAY, "com.umeng.socialize.handler.AlipayHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.MORE, "com.umeng.socialize.handler.UMMoreHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.DINGTALK, "com.umeng.socialize.handler.UMDingSSoHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.VKONTAKTE, "com.umeng.socialize.handler.UMVKHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.DROPBOX, "com.umeng.socialize.handler.UMDropBoxHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.BYTEDANCE, "com.umeng.socialize.handler.UMDYHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.BYTEDANCE_PUBLISH, ""));
        arrayList.add(Pair.create(SHARE_MEDIA.BYTEDANCE_FRIENDS, ""));
        arrayList.add(Pair.create(SHARE_MEDIA.HONOR, "com.umeng.socialize.handler.UMHonorHandler"));
        this.f42246f = new C0837a(hashMap);
        this.f42248h = new SparseArray<>();
        this.f42249i = new SparseArray<>();
        this.f42250j = new SparseArray<>();
        this.f42247g = context;
        b();
    }

    public void a(Context context) {
        if (context != null) {
            this.f42247g = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
    }

    private UMSSOHandler a(String str) {
        try {
            return (UMSSOHandler) Class.forName(str).newInstance();
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized UMAuthListener d(int i6) {
        UMAuthListener uMAuthListener;
        uMAuthListener = this.f42250j.get(i6, null);
        if (uMAuthListener != null) {
            this.f42250j.remove(i6);
        }
        return uMAuthListener;
    }

    public UMSSOHandler a(SHARE_MEDIA share_media) {
        UMSSOHandler uMSSOHandler = this.f42244d.get(share_media);
        if (uMSSOHandler != null) {
            uMSSOHandler.onCreate(this.f42247g, PlatformConfig.getPlatform(share_media));
        }
        return uMSSOHandler;
    }

    public void c(Activity activity, final SHARE_MEDIA share_media, final UMAuthListener uMAuthListener) {
        if (this.f42246f.a(activity, share_media)) {
            UMSSOHandler uMSSOHandler = this.f42244d.get(share_media);
            uMSSOHandler.onCreate(activity, PlatformConfig.getPlatform(share_media));
            String valueOf = String.valueOf(System.currentTimeMillis());
            if (ContextUtil.getContext() != null) {
                SocialAnalytics.authstart(ContextUtil.getContext(), share_media, uMSSOHandler.getSDKVersion(), uMSSOHandler.isInstall(), valueOf);
            }
            int ordinal = share_media.ordinal();
            a(ordinal, uMAuthListener);
            UMAuthListener a6 = a(ordinal, valueOf, uMSSOHandler.isInstall());
            QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        uMAuthListener.onStart(share_media);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            uMSSOHandler.authorize(a6);
            this.f42243a = share_media;
        }
    }

    public void a(int i6, int i7, Intent intent) {
        UMSSOHandler a6 = a(i6);
        if (a6 != null) {
            a6.onActivityResult(i6, i7, intent);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void b() {
        UMSSOHandler a6;
        for (Pair<SHARE_MEDIA, String> pair : this.f42245e) {
            Object obj = pair.first;
            if (obj == SHARE_MEDIA.WEIXIN_CIRCLE) {
                a6 = this.f42244d.get(SHARE_MEDIA.WEIXIN);
            } else if (obj == SHARE_MEDIA.WEIXIN_FAVORITE) {
                a6 = this.f42244d.get(SHARE_MEDIA.WEIXIN);
            } else if (obj == SHARE_MEDIA.FACEBOOK_MESSAGER) {
                a6 = this.f42244d.get(SHARE_MEDIA.FACEBOOK);
            } else if (obj == SHARE_MEDIA.BYTEDANCE_PUBLISH) {
                a6 = this.f42244d.get(SHARE_MEDIA.BYTEDANCE);
            } else if (obj == SHARE_MEDIA.BYTEDANCE_FRIENDS) {
                a6 = this.f42244d.get(SHARE_MEDIA.BYTEDANCE);
            } else if (obj == SHARE_MEDIA.YIXIN_CIRCLE) {
                a6 = this.f42244d.get(SHARE_MEDIA.YIXIN);
            } else if (obj == SHARE_MEDIA.MORE) {
                a6 = new UMMoreHandler();
            } else {
                a6 = a((String) pair.second);
            }
            this.f42244d.put(pair.first, a6);
        }
    }

    @Deprecated
    public void a(Activity activity, int i6, UMAuthListener uMAuthListener) {
        UMSSOHandler a6 = a(i6);
        if (a6 != null) {
            if (i6 == 10103 || i6 == 11101) {
                a6.onCreate(activity, PlatformConfig.getPlatform(b(i6)));
                a(SHARE_MEDIA.QQ, uMAuthListener, a6, String.valueOf(System.currentTimeMillis()));
            }
        }
    }

    private UMSSOHandler a(int i6) {
        int i7 = 10103;
        if (i6 != 10103 && i6 != 11101) {
            i7 = i6;
        }
        if (i6 == 64207 || i6 == 64206 || i6 == 64208) {
            i7 = HandlerRequestCode.FACEBOOK_REQUEST_AUTH_CODE;
        }
        if (i6 == 32973 || i6 == 765) {
            i7 = 10001;
        }
        if (i6 == 5650) {
            i7 = HandlerRequestCode.SINA_REQUEST_CODE;
        }
        for (UMSSOHandler uMSSOHandler : this.f42244d.values()) {
            if (uMSSOHandler != null && i7 == uMSSOHandler.getRequestCode()) {
                return uMSSOHandler;
            }
        }
        return null;
    }

    public void a(Activity activity, SHARE_MEDIA share_media, UMAuthListener uMAuthListener) {
        if (this.f42246f.a(activity, share_media)) {
            if (uMAuthListener == null) {
                uMAuthListener = new UMAuthListener() { // from class: com.umeng.socialize.b.a.1
                    @Override // com.umeng.socialize.UMAuthListener
                    public void onStart(SHARE_MEDIA share_media2) {
                    }

                    @Override // com.umeng.socialize.UMAuthListener
                    public void onCancel(SHARE_MEDIA share_media2, int i6) {
                    }

                    @Override // com.umeng.socialize.UMAuthListener
                    public void onComplete(SHARE_MEDIA share_media2, int i6, Map<String, String> map) {
                    }

                    @Override // com.umeng.socialize.UMAuthListener
                    public void onError(SHARE_MEDIA share_media2, int i6, Throwable th) {
                    }
                };
            }
            this.f42244d.get(share_media).onCreate(activity, PlatformConfig.getPlatform(share_media));
            this.f42244d.get(share_media).deleteAuth(uMAuthListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized UMAuthListener c(int i6) {
        UMAuthListener uMAuthListener;
        this.f42243a = null;
        uMAuthListener = this.f42248h.get(i6, null);
        if (uMAuthListener != null) {
            this.f42248h.remove(i6);
        }
        return uMAuthListener;
    }

    public boolean a(Activity activity, SHARE_MEDIA share_media) {
        this.f42244d.get(share_media).onCreate(activity, PlatformConfig.getPlatform(share_media));
        return this.f42244d.get(share_media).isInstall();
    }

    private UMAuthListener a(final int i6, final String str, final boolean z5) {
        return new UMAuthListener() { // from class: com.umeng.socialize.b.a.5
            @Override // com.umeng.socialize.UMAuthListener
            public void onCancel(final SHARE_MEDIA share_media, final int i7) {
                QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.5.4
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                            UMAuthListener c6 = a.this.c(i6);
                            if (c6 != null) {
                                c6.onCancel(share_media, i7);
                            }
                            if (ContextUtil.getContext() != null) {
                                Context context = ContextUtil.getContext();
                                SHARE_MEDIA share_media2 = share_media;
                                AnonymousClass5 anonymousClass52 = AnonymousClass5.this;
                                SocialAnalytics.authendt(context, share_media2, CommonNetImpl.CANCEL, z5, "", str, null);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }

            @Override // com.umeng.socialize.UMAuthListener
            public void onComplete(final SHARE_MEDIA share_media, final int i7, final Map<String, String> map) {
                QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.5.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                            UMAuthListener c6 = a.this.c(i6);
                            if (c6 != null) {
                                c6.onComplete(share_media, i7, map);
                            }
                            if (ContextUtil.getContext() != null) {
                                Context context = ContextUtil.getContext();
                                SHARE_MEDIA share_media2 = share_media;
                                AnonymousClass5 anonymousClass52 = AnonymousClass5.this;
                                SocialAnalytics.authendt(context, share_media2, "success", z5, "", str, a.this.a(share_media2, (Map<String, String>) map));
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }

            @Override // com.umeng.socialize.UMAuthListener
            public void onError(final SHARE_MEDIA share_media, final int i7, final Throwable th) {
                QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.5.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                            UMAuthListener c6 = a.this.c(i6);
                            if (c6 != null) {
                                c6.onError(share_media, i7, th);
                            }
                            Throwable th2 = th;
                            if (th2 != null) {
                                SLog.E(th2.getMessage());
                                SLog.runtimePrint(th.getMessage());
                            } else {
                                SLog.E("null");
                                SLog.runtimePrint("null");
                            }
                            if (ContextUtil.getContext() == null || th == null) {
                                return;
                            }
                            SocialAnalytics.authendt(ContextUtil.getContext(), share_media, CommonNetImpl.FAIL, z5, th.getMessage(), str, null);
                        } catch (Throwable th3) {
                            th3.printStackTrace();
                        }
                    }
                });
            }

            @Override // com.umeng.socialize.UMAuthListener
            public void onStart(final SHARE_MEDIA share_media) {
                QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                            UMAuthListener c6 = a.this.c(i6);
                            if (c6 != null) {
                                c6.onStart(share_media);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }
        };
    }

    private synchronized void c() {
        this.f42248h.clear();
        this.f42249i.clear();
        this.f42250j.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> a(SHARE_MEDIA share_media, Map<String, String> map) {
        String str;
        String str2;
        String str3;
        if (PlatformConfig.getPlatform(share_media) != null) {
            str = PlatformConfig.getPlatform(share_media).getAppid();
            str3 = PlatformConfig.getPlatform(share_media).getAppSecret();
            str2 = PlatformConfig.getPlatform(share_media).getClick_key();
        } else {
            str = "";
            str2 = "";
            str3 = str2;
        }
        map.put(CommonNetImpl.AID, str);
        map.put(CommonNetImpl.AS, str3);
        map.put("at", str2);
        return map;
    }

    private SHARE_MEDIA b(int i6) {
        if (i6 == 10103 || i6 == 11101) {
            return SHARE_MEDIA.QQ;
        }
        if (i6 != 32973 && i6 != 765) {
            return SHARE_MEDIA.QQ;
        }
        return SHARE_MEDIA.SINA;
    }

    public void b(Activity activity, final SHARE_MEDIA share_media, final UMAuthListener uMAuthListener) {
        if (this.f42246f.a(activity, share_media)) {
            UMSSOHandler uMSSOHandler = this.f42244d.get(share_media);
            uMSSOHandler.onCreate(activity, PlatformConfig.getPlatform(share_media));
            final String valueOf = String.valueOf(System.currentTimeMillis());
            if (ContextUtil.getContext() != null) {
                SocialAnalytics.getInfostart(ContextUtil.getContext(), share_media, valueOf);
            }
            final int ordinal = share_media.ordinal();
            b(ordinal, uMAuthListener);
            UMAuthListener uMAuthListener2 = new UMAuthListener() { // from class: com.umeng.socialize.b.a.2
                @Override // com.umeng.socialize.UMAuthListener
                public void onCancel(final SHARE_MEDIA share_media2, final int i6) {
                    QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.2.4
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                UMAuthListener d6 = a.this.d(ordinal);
                                if (d6 != null) {
                                    d6.onCancel(share_media2, i6);
                                }
                                if (ContextUtil.getContext() != null) {
                                    SocialAnalytics.getInfoendt(ContextUtil.getContext(), share_media2, CommonNetImpl.CANCEL, "", valueOf, null);
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }

                @Override // com.umeng.socialize.UMAuthListener
                public void onComplete(final SHARE_MEDIA share_media2, final int i6, final Map<String, String> map) {
                    QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                UMAuthListener d6 = a.this.d(ordinal);
                                if (d6 != null) {
                                    d6.onComplete(share_media2, i6, map);
                                }
                                if (ContextUtil.getContext() != null) {
                                    SocialAnalytics.getInfoendt(ContextUtil.getContext(), share_media2, "success", "", valueOf, map);
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }

                @Override // com.umeng.socialize.UMAuthListener
                public void onError(final SHARE_MEDIA share_media2, final int i6, final Throwable th) {
                    QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.2.3
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                UMAuthListener d6 = a.this.d(ordinal);
                                if (d6 != null) {
                                    d6.onError(share_media2, i6, th);
                                }
                                Throwable th2 = th;
                                if (th2 != null) {
                                    SLog.E(th2.getMessage());
                                    SLog.E(UmengText.SOLVE + UrlUtil.ALL_AUTHFAIL);
                                    SLog.runtimePrint(th.getMessage());
                                } else {
                                    SLog.E(UmengText.SOLVE + UrlUtil.ALL_AUTHFAIL);
                                }
                                if (ContextUtil.getContext() == null || th == null) {
                                    return;
                                }
                                SocialAnalytics.getInfoendt(ContextUtil.getContext(), share_media2, CommonNetImpl.FAIL, th.getMessage(), valueOf, null);
                            } catch (Throwable th3) {
                                th3.printStackTrace();
                            }
                        }
                    });
                }

                @Override // com.umeng.socialize.UMAuthListener
                public void onStart(final SHARE_MEDIA share_media2) {
                    QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                UMAuthListener d6 = a.this.d(ordinal);
                                if (d6 != null) {
                                    d6.onStart(share_media2);
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }
            };
            QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        uMAuthListener.onStart(share_media);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            uMSSOHandler.getPlatformInfo(uMAuthListener2);
        }
    }

    private void a(ShareAction shareAction) {
        ShareContent shareContent = shareAction.getShareContent();
        ArrayList arrayList = new ArrayList();
        arrayList.add(UmengText.SHARE.INFO);
        arrayList.add(UmengText.SHARE.SHAREPLAT + shareAction.getPlatform().toString());
        arrayList.add(UmengText.SHARE.SHARESTYLE + shareAction.getShareContent().getShareType());
        arrayList.add(UmengText.SHARE.SHARETEXT + shareContent.mText);
        UMediaObject uMediaObject = shareContent.mMedia;
        if (uMediaObject != null) {
            if (uMediaObject instanceof UMImage) {
                UMImage uMImage = (UMImage) uMediaObject;
                if (uMImage.isUrlMedia()) {
                    arrayList.add(UmengText.SHARE.URLIMAGE + uMImage.asUrlImage());
                } else {
                    byte[] asBinImage = uMImage.asBinImage();
                    StringBuilder sb = new StringBuilder();
                    sb.append(UmengText.SHARE.LOCALIMAGE);
                    sb.append(asBinImage == null ? 0 : asBinImage.length);
                    arrayList.add(sb.toString());
                }
                if (uMImage.getThumbImage() != null) {
                    UMImage thumbImage = uMImage.getThumbImage();
                    if (thumbImage.isUrlMedia()) {
                        arrayList.add(UmengText.SHARE.URLTHUMB + thumbImage.asUrlImage());
                    } else {
                        byte[] asBinImage2 = thumbImage.asBinImage();
                        if (asBinImage2 != null) {
                            arrayList.add(UmengText.SHARE.LOCALTHUMB + asBinImage2.length);
                        }
                    }
                }
            }
            UMediaObject uMediaObject2 = shareContent.mMedia;
            if (uMediaObject2 instanceof UMVideo) {
                UMVideo uMVideo = (UMVideo) uMediaObject2;
                arrayList.add(UmengText.SHARE.VIDEOURL + uMVideo.toUrl());
                arrayList.add(UmengText.SHARE.VIDEOTITLE + uMVideo.getTitle());
                arrayList.add(UmengText.SHARE.VIDEODES + uMVideo.getDescription());
                if (uMVideo.getThumbImage() != null) {
                    if (uMVideo.getThumbImage().isUrlMedia()) {
                        if (uMVideo.getThumbImage().asUrlImage() != null) {
                            arrayList.add(UmengText.SHARE.URLTHUMB + uMVideo.getThumbImage().asUrlImage());
                        }
                    } else {
                        byte[] asBinImage3 = uMVideo.getThumbImage().asBinImage();
                        if (asBinImage3 != null) {
                            arrayList.add(UmengText.SHARE.LOCALTHUMB + asBinImage3.length);
                        }
                    }
                }
            }
            UMediaObject uMediaObject3 = shareContent.mMedia;
            if (uMediaObject3 instanceof UMusic) {
                UMusic uMusic = (UMusic) uMediaObject3;
                arrayList.add(UmengText.SHARE.MUSICURL + uMusic.toUrl() + "   " + uMusic.getmTargetUrl());
                StringBuilder sb2 = new StringBuilder();
                sb2.append(UmengText.SHARE.MUSICTITLE);
                sb2.append(uMusic.getTitle());
                arrayList.add(sb2.toString());
                arrayList.add(UmengText.SHARE.MUSICDES + uMusic.getDescription());
                if (uMusic.getThumbImage() != null) {
                    if (uMusic.getThumbImage().isUrlMedia()) {
                        arrayList.add(UmengText.SHARE.URLTHUMB + uMusic.getThumbImage().asUrlImage());
                    } else {
                        byte[] asBinImage4 = uMusic.getThumbImage().asBinImage();
                        if (asBinImage4 != null) {
                            arrayList.add(UmengText.SHARE.LOCALTHUMB + asBinImage4.length);
                        }
                    }
                }
            }
            UMediaObject uMediaObject4 = shareContent.mMedia;
            if (uMediaObject4 instanceof UMWeb) {
                UMWeb uMWeb = (UMWeb) uMediaObject4;
                arrayList.add(UmengText.SHARE.URLURL + uMWeb.toUrl());
                arrayList.add(UmengText.SHARE.URLTITLE + uMWeb.getTitle());
                arrayList.add(UmengText.SHARE.URLDES + uMWeb.getDescription());
                if (uMWeb.getThumbImage() != null) {
                    if (uMWeb.getThumbImage().isUrlMedia()) {
                        arrayList.add(UmengText.SHARE.URLTHUMB + uMWeb.getThumbImage().asUrlImage());
                    } else {
                        byte[] asBinImage5 = uMWeb.getThumbImage().asBinImage();
                        if (asBinImage5 != null) {
                            arrayList.add(UmengText.SHARE.LOCALTHUMB + asBinImage5.length);
                        }
                    }
                }
            }
        }
        if (shareContent.file != null) {
            arrayList.add(UmengText.SHARE.FILENAME + shareContent.file.getName());
        }
        SLog.mutlI((String[]) arrayList.toArray(new String[1]));
    }

    public boolean b(Activity activity, SHARE_MEDIA share_media) {
        if (!this.f42246f.a(activity, share_media)) {
            return false;
        }
        this.f42244d.get(share_media).onCreate(activity, PlatformConfig.getPlatform(share_media));
        return this.f42244d.get(share_media).isSupport();
    }

    private synchronized void b(int i6, UMAuthListener uMAuthListener) {
        this.f42250j.put(i6, uMAuthListener);
    }

    public void a(Activity activity, final ShareAction shareAction, final UMShareListener uMShareListener) {
        b(activity);
        WeakReference weakReference = new WeakReference(activity);
        if (this.f42246f.a(shareAction, activity)) {
            if (SLog.isDebug()) {
                SLog.E(UmengText.SHARE.VERSION + "7.3.2");
                a(shareAction);
            }
            SHARE_MEDIA platform = shareAction.getPlatform();
            UMSSOHandler uMSSOHandler = this.f42244d.get(platform);
            uMSSOHandler.onCreate((Context) weakReference.get(), PlatformConfig.getPlatform(platform));
            final String valueOf = String.valueOf(System.currentTimeMillis());
            if (ContextUtil.getContext() != null) {
                DplusApi.uploadShare(ContextUtil.getContext(), shareAction.getShareContent(), uMSSOHandler.isInstall(), platform, valueOf, shareAction.getShareContent().mMedia instanceof UMImage ? ((UMImage) shareAction.getShareContent().mMedia).isHasWaterMark() : false);
            }
            final int ordinal = platform.ordinal();
            a(ordinal, uMShareListener);
            final UMShareListener uMShareListener2 = new UMShareListener() { // from class: com.umeng.socialize.b.a.6
                @Override // com.umeng.socialize.UMShareListener
                public void onCancel(final SHARE_MEDIA share_media) {
                    QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.6.4
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (ContextUtil.getContext() != null) {
                                    SocialAnalytics.shareend(ContextUtil.getContext(), share_media, CommonNetImpl.CANCEL, "", valueOf);
                                }
                                AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                                UMShareListener e6 = a.this.e(ordinal);
                                if (e6 != null) {
                                    e6.onCancel(share_media);
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }

                @Override // com.umeng.socialize.UMShareListener
                public void onError(final SHARE_MEDIA share_media, final Throwable th) {
                    QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.6.3
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (ContextUtil.getContext() != null && th != null) {
                                    SocialAnalytics.shareend(ContextUtil.getContext(), share_media, CommonNetImpl.FAIL, th.getMessage(), valueOf);
                                }
                                AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                                UMShareListener e6 = a.this.e(ordinal);
                                if (e6 != null) {
                                    e6.onError(share_media, th);
                                }
                                Throwable th2 = th;
                                if (th2 != null) {
                                    SLog.E(th2.getMessage());
                                    SLog.E(UmengText.SOLVE + UrlUtil.ALL_SHAREFAIL);
                                    SLog.runtimePrint(th.getMessage());
                                    return;
                                }
                                SLog.E("null");
                                SLog.E(UmengText.SOLVE + UrlUtil.ALL_SHAREFAIL);
                                SLog.runtimePrint("null");
                            } catch (Throwable th3) {
                                th3.printStackTrace();
                            }
                        }
                    });
                }

                @Override // com.umeng.socialize.UMShareListener
                public void onResult(final SHARE_MEDIA share_media) {
                    QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.6.2
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (ContextUtil.getContext() != null) {
                                    SocialAnalytics.shareend(ContextUtil.getContext(), share_media, "success", "", valueOf);
                                }
                                AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                                UMShareListener e6 = a.this.e(ordinal);
                                if (e6 != null) {
                                    e6.onResult(share_media);
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }

                @Override // com.umeng.socialize.UMShareListener
                public void onStart(final SHARE_MEDIA share_media) {
                    QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                                UMShareListener e6 = a.this.e(ordinal);
                                if (e6 != null) {
                                    e6.onStart(share_media);
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }
            };
            if (!shareAction.getUrlValid()) {
                QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.7
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            uMShareListener2.onError(shareAction.getPlatform(), new Throwable(UmengErrorCode.ShareFailed.getMessage() + UmengText.SHARE.WEB_HTTP));
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
                return;
            }
            QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.8
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        UMShareListener uMShareListener3 = uMShareListener;
                        if (uMShareListener3 != null) {
                            uMShareListener3.onStart(shareAction.getPlatform());
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            try {
                uMSSOHandler.share(shareAction.getShareContent(), uMShareListener2);
            } catch (Throwable th) {
                SLog.error(th);
            }
        }
    }

    private synchronized void a(int i6, UMAuthListener uMAuthListener) {
        this.f42248h.put(i6, uMAuthListener);
    }

    private synchronized void a(int i6, UMShareListener uMShareListener) {
        this.f42249i.put(i6, uMShareListener);
    }

    private void a(SHARE_MEDIA share_media, UMAuthListener uMAuthListener, UMSSOHandler uMSSOHandler, String str) {
        if (uMSSOHandler.isHasAuthListener()) {
            return;
        }
        int ordinal = share_media.ordinal();
        a(ordinal, uMAuthListener);
        uMSSOHandler.setAuthListener(a(ordinal, str, uMSSOHandler.isInstall()));
    }

    public void a() {
        c();
        DplusCacheApi.getInstance().cleanCache(ContextUtil.getContext());
        UMSSOHandler uMSSOHandler = this.f42244d.get(SHARE_MEDIA.SINA);
        if (uMSSOHandler != null) {
            uMSSOHandler.release();
        }
        UMSSOHandler uMSSOHandler2 = this.f42244d.get(SHARE_MEDIA.MORE);
        if (uMSSOHandler2 != null) {
            uMSSOHandler2.release();
        }
        UMSSOHandler uMSSOHandler3 = this.f42244d.get(SHARE_MEDIA.DINGTALK);
        if (uMSSOHandler3 != null) {
            uMSSOHandler3.release();
        }
        UMSSOHandler uMSSOHandler4 = this.f42244d.get(SHARE_MEDIA.WEIXIN);
        if (uMSSOHandler4 != null) {
            uMSSOHandler4.release();
        }
        UMSSOHandler uMSSOHandler5 = this.f42244d.get(SHARE_MEDIA.QQ);
        if (uMSSOHandler5 != null) {
            uMSSOHandler5.release();
        }
        this.f42243a = null;
        DplusCacheApi.getInstance().closeDBConnection(ContextUtil.getContext());
    }

    public void a(Bundle bundle) {
        String str;
        int i6;
        SHARE_MEDIA share_media = this.f42243a;
        if (share_media != null && (share_media == SHARE_MEDIA.WEIXIN || share_media == SHARE_MEDIA.QQ || share_media == SHARE_MEDIA.SINA)) {
            str = share_media.toString();
            i6 = 0;
        } else {
            str = "";
            i6 = -1;
        }
        bundle.putString(f42241b, str);
        bundle.putInt(f42242c, i6);
        this.f42243a = null;
    }

    public void a(Activity activity, Bundle bundle, UMAuthListener uMAuthListener) {
        SHARE_MEDIA convertToEmun;
        UMSSOHandler a6;
        if (bundle == null || uMAuthListener == null) {
            return;
        }
        String string = bundle.getString(f42241b, null);
        if (bundle.getInt(f42242c, -1) != 0 || TextUtils.isEmpty(string) || (convertToEmun = SHARE_MEDIA.convertToEmun(string)) == null) {
            return;
        }
        if (convertToEmun == SHARE_MEDIA.QQ) {
            a6 = this.f42244d.get(convertToEmun);
            a6.onCreate(activity, PlatformConfig.getPlatform(convertToEmun));
        } else {
            a6 = a(convertToEmun);
        }
        if (a6 != null) {
            a(convertToEmun, uMAuthListener, a6, String.valueOf(System.currentTimeMillis()));
        }
    }

    public void a(UMShareConfig uMShareConfig) {
        if (this.f42244d.isEmpty()) {
            return;
        }
        Iterator<Map.Entry<SHARE_MEDIA, UMSSOHandler>> it = this.f42244d.entrySet().iterator();
        while (it.hasNext()) {
            UMSSOHandler value = it.next().getValue();
            if (value != null) {
                value.setShareConfig(uMShareConfig);
            }
        }
    }
}
