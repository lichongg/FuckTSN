package com.umeng.socialize.bean;

import com.kwad.library.solder.lib.ext.PluginError;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public enum UmengErrorCode {
    UnKnowCode(2000),
    AuthorizeFailed(2002),
    ShareFailed(2003),
    RequestForUserProfileFailed(PluginError.ERROR_UPD_EXTRACT),
    ShareDataNil(PluginError.ERROR_UPD_EXTRACT),
    ShareDataTypeIllegal(PluginError.ERROR_UPD_EXTRACT),
    NotInstall(PluginError.ERROR_UPD_NO_DOWNLOADER);


    /* renamed from: a, reason: collision with root package name */
    private final int f42310a;

    private String a() {
        return "错误码：" + this.f42310a + " 错误信息：";
    }

    public String getMessage() {
        if (this == UnKnowCode) {
            return a() + "未知错误----";
        }
        if (this == AuthorizeFailed) {
            return a() + "授权失败----";
        }
        if (this == ShareFailed) {
            return a() + "分享失败----";
        }
        if (this == RequestForUserProfileFailed) {
            return a() + "获取用户资料失败----";
        }
        if (this == ShareDataNil) {
            return a() + "分享内容为空";
        }
        if (this == ShareDataTypeIllegal) {
            return a() + "分享内容不合法----";
        }
        if (this != NotInstall) {
            return "unkonw";
        }
        return a() + "没有安装应用";
    }

    UmengErrorCode(int i6) {
        this.f42310a = i6;
    }
}
