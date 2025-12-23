package com.bytedance.sdk.openadsdk.live;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.android.live.base.api.ILiveHostContextParam;
import com.bytedance.android.live.base.api.ILiveInitCallback;
import com.bytedance.android.live.base.api.IOuterLiveService;
import com.bytedance.android.openliveplugin.LivePluginHelper;
import com.bytedance.sdk.openadsdk.api.m;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {
    public static boolean j(Context context, String str, ILiveHostContextParam.Builder builder, ILiveInitCallback iLiveInitCallback, boolean z5) {
        try {
            LivePluginHelper.initLive((Application) context, str, builder, iLiveInitCallback, z5);
            return true;
        } catch (Throwable th) {
            m.j(th);
            cw.j("initLivePlugin", th);
            return false;
        }
    }

    public static boolean j() {
        try {
            LivePluginHelper.initLiveCommerce();
            return true;
        } catch (Exception e6) {
            m.j(e6);
            cw.j("initLiveCommerce", e6);
            return false;
        }
    }

    public static boolean j(Context context, Bundle bundle) {
        if (context != null && bundle != null && bundle.containsKey("room_id")) {
            long j6 = bundle.getLong("room_id");
            try {
                IOuterLiveService liveRoomService = LivePluginHelper.getLiveRoomService();
                if (liveRoomService == null) {
                    return false;
                }
                liveRoomService.enterLiveRoom(context, j6, bundle);
                return true;
            } catch (Throwable th) {
                m.j(th);
                cw.j("openLive", th);
            }
        }
        return false;
    }

    public static boolean j(Context context, Uri uri) {
        if (context != null && uri != null) {
            try {
                IOuterLiveService liveRoomService = LivePluginHelper.getLiveRoomService();
                if (liveRoomService != null) {
                    return liveRoomService.handleSchema(context, uri);
                }
                return false;
            } catch (Throwable th) {
                m.j(th);
                cw.j("handleScheme", th);
            }
        }
        return false;
    }
}
