package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.mobads.sdk.api.IBasicCPUData;
import com.baidu.mobads.sdk.internal.ae;
import com.baidu.mobads.sdk.internal.ao;
import com.baidu.mobads.sdk.internal.at;
import com.baidu.mobads.sdk.internal.au;
import com.baidu.mobads.sdk.internal.av;
import com.baidu.mobads.sdk.internal.az;
import com.baidu.mobads.sdk.internal.bt;
import com.baidu.mobads.sdk.internal.z;
import com.stub.StubApp;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class NativeCPUAdData implements IBasicCPUData, Observer {
    private static final String CLASS_NAME = z.f11222l;
    private final ClassLoader classLoader;
    private IBasicCPUData.CpuNativeStatusCB mCpuNativeStatusCBListener;
    private final Context mCtx;
    public Object mInstance;
    private final HashMap<String, Object> mSettings;
    public au remoteUtils;

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCanClickView(View view) {
        HashMap<String, Object> hashMap = this.mSettings;
        if (hashMap != null) {
            this.remoteUtils.a(this.mInstance, "setConfigParams", hashMap);
        }
        if (view instanceof CpuVideoView) {
            this.remoteUtils.a(this.mInstance, "handClickVideo", 1, 0);
        } else if (view instanceof TextView) {
            this.remoteUtils.a(this.mInstance, "handClickVideo", 2, 0);
        }
        this.remoteUtils.a(this.mInstance, "handleCanClickView", view);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void handleCreativeView(View view) {
        HashMap<String, Object> hashMap = this.mSettings;
        if (hashMap != null) {
            this.remoteUtils.a(this.mInstance, "setConfigParams", hashMap);
        }
        if (view instanceof CpuVideoView) {
            this.remoteUtils.a(this.mInstance, "handClickVideo", 1, 0);
        } else if (view instanceof TextView) {
            this.remoteUtils.a(this.mInstance, "handClickVideo", 2, 0);
        }
        this.remoteUtils.a(this.mInstance, "handleCreativeView", view);
    }

    private String getAdid() {
        return this.remoteUtils.c(this.mInstance, "getAdid", new Object[0]);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void cancelAppDownload() {
        if (this.mCtx == null || !isNeedDownloadApp()) {
            return;
        }
        at.a(StubApp.getOrigApplicationContext(this.mCtx.getApplicationContext())).b(getAppPackageName());
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void clickHotItem(View view) {
        this.remoteUtils.a(this.mInstance, "clickHotItem", view);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getActionType() {
        Object b6 = this.remoteUtils.b(this.mInstance, "getActionType", new Object[0]);
        if (b6 instanceof Integer) {
            return ((Integer) b6).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getAdHeight() {
        Object b6 = this.remoteUtils.b(this.mInstance, "getAdHeight", new Object[0]);
        if (b6 instanceof Integer) {
            return ((Integer) b6).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getAdLogoUrl() {
        Object b6 = this.remoteUtils.b(this.mInstance, "getAdLogoUrl", new Object[0]);
        return b6 instanceof String ? (String) b6 : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getAdWidth() {
        Object b6 = this.remoteUtils.b(this.mInstance, "getAdWidth", new Object[0]);
        if (b6 instanceof Integer) {
            return ((Integer) b6).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getAppPackageName() {
        Object b6 = this.remoteUtils.b(this.mInstance, "getPackageName", new Object[0]);
        return b6 instanceof String ? (String) b6 : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getAppPermissionUrl() {
        return this.remoteUtils.c(this.mInstance, "getAppPermissionUrl", new Object[0]);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getAppPrivacyUrl() {
        return this.remoteUtils.c(this.mInstance, "getAppPrivacyUrl", new Object[0]);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getAppPublisher() {
        return this.remoteUtils.c(this.mInstance, "getAppPublisher", new Object[0]);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getAppVersion() {
        return this.remoteUtils.c(this.mInstance, "getAppVersion", new Object[0]);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getAttribute() {
        Object b6 = this.remoteUtils.b(this.mInstance, "getAttribute", new Object[0]);
        if (b6 instanceof Integer) {
            return ((Integer) b6).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getAuthor() {
        Object b6 = this.remoteUtils.b(this.mInstance, "getAuthor", new Object[0]);
        return b6 instanceof String ? (String) b6 : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getBaiduLogoUrl() {
        Object b6 = this.remoteUtils.b(this.mInstance, "getBaiduLogoUrl", new Object[0]);
        return b6 instanceof String ? (String) b6 : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getBrandName() {
        Object b6 = this.remoteUtils.b(this.mInstance, "getBrandName", new Object[0]);
        return b6 instanceof String ? (String) b6 : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getChannelId() {
        Object b6 = this.remoteUtils.b(this.mInstance, "getCatId", new Object[0]);
        return b6 instanceof String ? (String) b6 : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getChannelName() {
        Object b6 = this.remoteUtils.b(this.mInstance, "getCatName", new Object[0]);
        return b6 instanceof String ? (String) b6 : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getCommentCounts() {
        Object b6 = this.remoteUtils.b(this.mInstance, "getCommentCounts", new Object[0]);
        if (b6 instanceof Integer) {
            return ((Integer) b6).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public List<Integer> getContentAttributesList() {
        Object b6 = this.remoteUtils.b(this.mInstance, "getContentAttributesList", new Object[0]);
        if (b6 instanceof List) {
            return (List) b6;
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getContentClickUrl() {
        Object b6 = this.remoteUtils.b(this.mInstance, "getContentClickUrl", new Object[0]);
        return b6 instanceof String ? (String) b6 : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public long getCtime() {
        Object b6 = this.remoteUtils.b(this.mInstance, "getCtime", new Object[0]);
        if (b6 instanceof Long) {
            return ((Long) b6).longValue();
        }
        return 0L;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getDesc() {
        Object b6 = this.remoteUtils.b(this.mInstance, "getContent", new Object[0]);
        return b6 instanceof String ? (String) b6 : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public JSONArray getDislikeReasons() {
        return (JSONArray) this.remoteUtils.b(this.mInstance, "getDislikeReasons", new Object[0]);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getDownloadStatus() {
        Object b6 = this.remoteUtils.b(this.mInstance, "getDownloadStatus", new Object[0]);
        if (b6 instanceof Integer) {
            return ((Integer) b6).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getDuration() {
        Object b6 = this.remoteUtils.b(this.mInstance, "getDuration", new Object[0]);
        if (b6 instanceof Integer) {
            return ((Integer) b6).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public JSONObject getExtra() {
        return (JSONObject) this.remoteUtils.b(this.mInstance, "getExtra", new Object[0]);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public long getHotId() {
        Object b6 = this.remoteUtils.b(this.mInstance, "getHotId", new Object[0]);
        if (b6 instanceof Long) {
            return ((Long) b6).longValue();
        }
        return 0L;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getHotWord() {
        return this.remoteUtils.c(this.mInstance, "getHotWord", new Object[0]);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getIconUrl() {
        Object b6 = this.remoteUtils.b(this.mInstance, "getAvatar", new Object[0]);
        return b6 instanceof String ? (String) b6 : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getImage() {
        return this.remoteUtils.c(this.mInstance, "getImage", new Object[0]);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public List<String> getImageUrls() {
        Object b6 = this.remoteUtils.b(this.mInstance, "getImageList", new Object[0]);
        if (b6 instanceof List) {
            return (List) b6;
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getLabel() {
        return this.remoteUtils.c(this.mInstance, "getLabel", new Object[0]);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getPlayCounts() {
        Object b6 = this.remoteUtils.b(this.mInstance, "getPlayCounts", new Object[0]);
        if (b6 instanceof Integer) {
            return ((Integer) b6).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getPresentationType() {
        Object b6 = this.remoteUtils.b(this.mInstance, "getPresentationType", new Object[0]);
        if (b6 instanceof Integer) {
            return ((Integer) b6).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getReadCounts() {
        Object b6 = this.remoteUtils.b(this.mInstance, "getReadCounts", new Object[0]);
        if (b6 instanceof Integer) {
            return ((Integer) b6).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public double getScore() {
        Object b6 = this.remoteUtils.b(this.mInstance, "getScore", new Object[0]);
        if (b6 instanceof Double) {
            return ((Double) b6).doubleValue();
        }
        return 0.0d;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public List<String> getSmallImageUrls() {
        Object b6 = this.remoteUtils.b(this.mInstance, "getSmallImageList", new Object[0]);
        if (b6 instanceof List) {
            return (List) b6;
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getStyleTypeCpu() {
        Object b6 = this.remoteUtils.b(this.mInstance, "getStyleTypeCpu", new Object[0]);
        if (b6 instanceof Integer) {
            return ((Integer) b6).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getThumbHeight() {
        Object b6 = this.remoteUtils.b(this.mInstance, "getThumbHeight", new Object[0]);
        if (b6 instanceof Integer) {
            return ((Integer) b6).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getThumbUrl() {
        Object b6 = this.remoteUtils.b(this.mInstance, "getThumbUrl", new Object[0]);
        return b6 instanceof String ? (String) b6 : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getThumbWidth() {
        Object b6 = this.remoteUtils.b(this.mInstance, "getThumbWidth", new Object[0]);
        if (b6 instanceof Integer) {
            return ((Integer) b6).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getTitle() {
        Object b6 = this.remoteUtils.b(this.mInstance, "getTitle", new Object[0]);
        return b6 instanceof String ? (String) b6 : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getType() {
        Object b6 = this.remoteUtils.b(this.mInstance, "getType", new Object[0]);
        return b6 instanceof String ? (String) b6 : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getUpdateTime() {
        Object b6 = this.remoteUtils.b(this.mInstance, "getUpdateTime", new Object[0]);
        return b6 instanceof String ? (String) b6 : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getVUrl() {
        Object b6 = this.remoteUtils.b(this.mInstance, "getVUrl", new Object[0]);
        return b6 instanceof String ? (String) b6 : "";
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0044  */
    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void handleClick(android.view.View r9, java.lang.Object... r10) {
        /*
            r8 = this;
            java.util.HashMap<java.lang.String, java.lang.Object> r0 = r8.mSettings
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L13
            com.baidu.mobads.sdk.internal.au r3 = r8.remoteUtils
            java.lang.Object r4 = r8.mInstance
            java.lang.Object[] r5 = new java.lang.Object[r2]
            r5[r1] = r0
            java.lang.String r0 = "setConfigParams"
            r3.a(r4, r0, r5)
        L13:
            if (r10 == 0) goto L25
            int r0 = r10.length
            if (r0 <= 0) goto L25
            r10 = r10[r1]
            boolean r0 = r10 instanceof java.lang.Long
            if (r0 == 0) goto L25
            java.lang.Long r10 = (java.lang.Long) r10
            long r3 = r10.longValue()
            goto L27
        L25:
            r3 = 0
        L27:
            boolean r10 = r9 instanceof com.baidu.mobads.sdk.api.CpuVideoView
            r0 = 2
            java.lang.String r5 = "handClickVideo"
            if (r10 == 0) goto L44
            com.baidu.mobads.sdk.internal.au r10 = r8.remoteUtils
            java.lang.Object r6 = r8.mInstance
            java.lang.Integer r7 = java.lang.Integer.valueOf(r2)
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r1] = r7
            r0[r2] = r3
            r10.a(r6, r5, r0)
            goto L5d
        L44:
            boolean r10 = r9 instanceof android.widget.TextView
            if (r10 == 0) goto L5d
            com.baidu.mobads.sdk.internal.au r10 = r8.remoteUtils
            java.lang.Object r6 = r8.mInstance
            java.lang.Integer r7 = java.lang.Integer.valueOf(r0)
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r1] = r7
            r0[r2] = r3
            r10.a(r6, r5, r0)
        L5d:
            com.baidu.mobads.sdk.internal.au r10 = r8.remoteUtils
            java.lang.Object r0 = r8.mInstance
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r1] = r9
            java.lang.String r9 = "handleClick"
            r10.a(r0, r9, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.api.NativeCPUAdData.handleClick(android.view.View, java.lang.Object[]):void");
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void handleDislikeClick(View view, int i6) {
        this.remoteUtils.a(this.mInstance, "handleDislikeClick", view, Integer.valueOf(i6));
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public boolean isAutoplay() {
        Object b6 = this.remoteUtils.b(this.mInstance, "isAutoplay", new Object[0]);
        if (b6 instanceof Boolean) {
            return ((Boolean) b6).booleanValue();
        }
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public boolean isCanGoLp() {
        Object b6 = this.remoteUtils.b(this.mInstance, "isCanGoLp", new Object[0]);
        if (b6 instanceof Boolean) {
            return ((Boolean) b6).booleanValue();
        }
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public boolean isNeedDownloadApp() {
        return ((Boolean) this.remoteUtils.b(this.mInstance, "isDownloadApp", new Object[0])).booleanValue();
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public boolean isTop() {
        Object b6 = this.remoteUtils.b(this.mInstance, "isTop", new Object[0]);
        if (b6 instanceof Boolean) {
            return ((Boolean) b6).booleanValue();
        }
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void markDislike(String[] strArr) {
        this.remoteUtils.a(this.mInstance, "markDislike", strArr);
    }

    public void monitorVisibleTime(View view) {
        HashMap<String, Object> hashMap = this.mSettings;
        if (hashMap != null) {
            this.remoteUtils.a(this.mInstance, "setConfigParams", hashMap);
        }
        this.remoteUtils.a(this.mInstance, "monitorVisibleTime", view);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void onImpression(View view) {
        HashMap<String, Object> hashMap = this.mSettings;
        if (hashMap != null) {
            this.remoteUtils.a(this.mInstance, "setConfigParams", hashMap);
        }
        this.remoteUtils.a(this.mInstance, "onImpression", view);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void pauseAppDownload() {
        if (this.mCtx == null || !isNeedDownloadApp()) {
            return;
        }
        at.a(StubApp.getOrigApplicationContext(this.mCtx.getApplicationContext())).a(getAppPackageName());
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void setStatusListener(final IBasicCPUData.CpuNativeStatusCB cpuNativeStatusCB) {
        this.mCpuNativeStatusCBListener = cpuNativeStatusCB;
        try {
            this.remoteUtils.a(this.mInstance, "setStatusListener", Proxy.newProxyInstance(this.classLoader, new Class[]{av.a(z.f11224n, this.classLoader)}, new InvocationHandler() { // from class: com.baidu.mobads.sdk.api.NativeCPUAdData.3
                @Override // java.lang.reflect.InvocationHandler
                public Object invoke(Object obj, Method method, Object[] objArr) {
                    az.h("NativeCPUAdData").c("invoke: " + method.getName());
                    if (cpuNativeStatusCB == null) {
                        return null;
                    }
                    String name = method.getName();
                    if ("onAdDownloadWindowShow".equals(name)) {
                        cpuNativeStatusCB.onAdDownloadWindowShow();
                    } else if ("onPermissionShow".equals(name)) {
                        cpuNativeStatusCB.onPermissionShow();
                    } else if ("onPermissionClose".equals(name)) {
                        cpuNativeStatusCB.onPermissionClose();
                    } else if ("onPrivacyClick".equals(name)) {
                        cpuNativeStatusCB.onPrivacyClick();
                    } else if ("onPrivacyLpClose".equals(name)) {
                        cpuNativeStatusCB.onPrivacyLpClose();
                    } else if ("onNotifyPerformance".equals(name)) {
                        if (objArr != null && objArr.length >= 1) {
                            Object obj2 = objArr[0];
                            if (obj2 instanceof String) {
                                cpuNativeStatusCB.onNotifyPerformance((String) obj2);
                            }
                        }
                    } else if ("startRouter".equals(name)) {
                        ao.a((Context) objArr[0], (String) objArr[1]);
                    }
                    return null;
                }
            }));
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if ((observable instanceof ae) && this.mCpuNativeStatusCBListener != null && isNeedDownloadApp() && (obj instanceof IOAdEvent)) {
            IOAdEvent iOAdEvent = (IOAdEvent) obj;
            String message = iOAdEvent.getMessage();
            Map<String, Object> data = iOAdEvent.getData();
            if (data != null) {
                Object obj2 = data.get("adid");
                if ((obj2 instanceof String) && ((String) obj2).equals(getAdid())) {
                    this.mCpuNativeStatusCBListener.onAdStatusChanged(message, getDownloadStatus());
                }
            }
        }
    }

    public NativeCPUAdData(Context context, Object obj, HashMap<String, Object> hashMap) {
        this.mCtx = context;
        this.mInstance = obj;
        this.mSettings = hashMap;
        this.remoteUtils = au.a(context, CLASS_NAME);
        this.classLoader = bt.a(context);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void registerViewForInteraction(View view, final List<View> list, List<View> list2, IBasicCPUData.CpuNativeStatusCB cpuNativeStatusCB) {
        setStatusListener(cpuNativeStatusCB);
        onImpression(view);
        monitorVisibleTime(view);
        if (list != null && list.size() > 0) {
            for (final View view2 : list) {
                if (view2 != null) {
                    view2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.mobads.sdk.api.NativeCPUAdData.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            NativeCPUAdData.this.handleCanClickView(view3);
                            view2.setClickable(false);
                            view2.postDelayed(new Runnable() { // from class: com.baidu.mobads.sdk.api.NativeCPUAdData.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    View view4 = view2;
                                    if (view4 != null) {
                                        view4.setClickable(true);
                                    }
                                }
                            }, 1000L);
                        }
                    });
                }
            }
        }
        if (list2 != null && list2.size() > 0) {
            for (final View view3 : list2) {
                if (view3 != null) {
                    view3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.mobads.sdk.api.NativeCPUAdData.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view4) {
                            NativeCPUAdData.this.handleCreativeView(view4);
                            view3.setClickable(false);
                            view3.postDelayed(new Runnable() { // from class: com.baidu.mobads.sdk.api.NativeCPUAdData.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                    if (list != null) {
                                        view3.setClickable(true);
                                    }
                                }
                            }, 1000L);
                        }
                    });
                }
            }
        }
    }
}
