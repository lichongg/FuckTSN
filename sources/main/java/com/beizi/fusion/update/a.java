package com.beizi.fusion.update;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.c.l;
import com.beizi.fusion.model.GlobalConfig;
import com.beizi.fusion.model.IncentiveConfig;
import com.beizi.fusion.model.ResponseInfo;
import com.beizi.fusion.tool.an;
import com.beizi.fusion.tool.t;
import com.beizi.fusion.tool.y;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private Context f13805a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f13806b = true;

    private void a(String str) {
        try {
            String b6 = com.beizi.fusion.tool.b.b(y.a(), str);
            if (TextUtils.isEmpty(b6)) {
                this.f13806b = false;
                return;
            }
            String b7 = t.b(b6);
            if (!TextUtils.isEmpty(b7) && !b7.equalsIgnoreCase("null")) {
                String str2 = (String) an.b(this.f13805a, "globalConfig", "");
                if (TextUtils.isEmpty(str2)) {
                    an.a(this.f13805a, "globalConfig", (Object) com.beizi.fusion.tool.b.a(y.a(), b7));
                }
                String b8 = com.beizi.fusion.tool.b.b(y.a(), str2);
                GlobalConfig objectFromData = GlobalConfig.objectFromData(b7);
                GlobalConfig objectFromData2 = GlobalConfig.objectFromData(b8);
                if (objectFromData != null) {
                    ResponseInfo.getInstance(this.f13805a).setGlobalConfig(objectFromData);
                    if (!TextUtils.isEmpty(objectFromData.getConfigVersion())) {
                        if (objectFromData2 != null) {
                            objectFromData2.setConfigVersion(objectFromData.getConfigVersion());
                        }
                        if (ResponseInfo.getInstance(this.f13805a).getManager() == null) {
                            ResponseInfo.getInstance(this.f13805a).setConfigVersion(objectFromData.getConfigVersion());
                        }
                    }
                    if (objectFromData.getExpireTime() > 0) {
                        if (objectFromData2 != null) {
                            objectFromData2.setExpireTime(objectFromData.getExpireTime());
                        }
                        ResponseInfo.getInstance(this.f13805a).setExpireTime(objectFromData.getExpireTime());
                    }
                    if (objectFromData.getMaxValidTime() > 0) {
                        if (objectFromData2 != null) {
                            objectFromData2.setMaxValidTime(objectFromData.getMaxValidTime());
                        }
                        ResponseInfo.getInstance(this.f13805a).setMaxValidTime(objectFromData.getMaxValidTime());
                    }
                    if (objectFromData.getConfigurator() != null) {
                        if (objectFromData2 != null) {
                            objectFromData2.setConfigurator(objectFromData.getConfigurator());
                        }
                        if (ResponseInfo.getInstance(this.f13805a).getManager() == null) {
                            ResponseInfo.getInstance(this.f13805a).setConfigurator(objectFromData.getConfigurator());
                        }
                    }
                    if (objectFromData.getMessenger() != null) {
                        if (objectFromData2 != null) {
                            objectFromData2.setMessenger(objectFromData.getMessenger());
                        }
                        if (ResponseInfo.getInstance(this.f13805a).getManager() == null) {
                            ResponseInfo.getInstance(this.f13805a).setMessenger(objectFromData.getMessenger());
                        }
                    }
                    if (objectFromData.getManager() != null) {
                        if (objectFromData2 != null) {
                            objectFromData2.setManager(objectFromData.getManager());
                        }
                        if (ResponseInfo.getInstance(this.f13805a).getManager() == null) {
                            ResponseInfo.getInstance(this.f13805a).setManager(objectFromData.getManager());
                        }
                    }
                    if (objectFromData.getTaskConfig() != null) {
                        if (objectFromData2 != null) {
                            objectFromData2.setTaskConfig(objectFromData.getTaskConfig());
                        }
                        ResponseInfo.getInstance(this.f13805a).setTaskConfig(objectFromData.getTaskConfig());
                    }
                    if (objectFromData.getAdPlusConfig() != null) {
                        if (objectFromData2 != null) {
                            objectFromData2.setAdPlusConfig(objectFromData.getAdPlusConfig());
                        }
                        ResponseInfo.getInstance(this.f13805a).setAdPlusConfig(objectFromData.getAdPlusConfig());
                        l.a(this.f13805a);
                    }
                    IncentiveConfig incentiveConfig = objectFromData.getIncentiveConfig();
                    if (incentiveConfig != null) {
                        if (objectFromData2 != null) {
                            objectFromData2.setIncentiveConfig(incentiveConfig);
                        }
                        ResponseInfo.getInstance(this.f13805a).setIncentiveConfig(incentiveConfig);
                    }
                    if (!TextUtils.isEmpty(objectFromData.getCrashUrl())) {
                        if (objectFromData2 != null) {
                            objectFromData2.setCrashUrl(objectFromData.getCrashUrl());
                        }
                        ResponseInfo.getInstance(this.f13805a).setCrashUrl(objectFromData.getCrashUrl());
                    }
                    String objectToJson = GlobalConfig.objectToJson(objectFromData2);
                    if (TextUtils.isEmpty(objectToJson)) {
                        return;
                    }
                    an.a(this.f13805a, "globalConfig", (Object) com.beizi.fusion.tool.b.a(y.a(), objectToJson));
                    return;
                }
                return;
            }
            this.f13806b = false;
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    a(Context context, String str) {
        if (str == null) {
            return;
        }
        this.f13805a = context;
        a(str);
    }

    public boolean a() {
        return this.f13806b;
    }
}
