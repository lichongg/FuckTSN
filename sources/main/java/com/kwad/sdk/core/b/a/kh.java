package com.kwad.sdk.core.b.a;

import androidx.core.app.NotificationCompat;
import com.kwad.components.ad.splashscreen.monitor.SplashMonitorInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class kh implements com.kwad.sdk.core.d<SplashMonitorInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(SplashMonitorInfo splashMonitorInfo, JSONObject jSONObject) {
        a2(splashMonitorInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(SplashMonitorInfo splashMonitorInfo, JSONObject jSONObject) {
        return b2(splashMonitorInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(SplashMonitorInfo splashMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashMonitorInfo.status = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
        splashMonitorInfo.type = jSONObject.optInt("type");
        splashMonitorInfo.preloadId = jSONObject.optString("preload_id");
        if (JSONObject.NULL.toString().equals(splashMonitorInfo.preloadId)) {
            splashMonitorInfo.preloadId = "";
        }
        splashMonitorInfo.checkStatus = jSONObject.optInt("check_status");
        splashMonitorInfo.loadDataTime = jSONObject.optLong("load_data_duration_ms");
        splashMonitorInfo.beforeLoadDataTime = jSONObject.optLong("before_load_data_duration_ms");
        splashMonitorInfo.checkDataTime = jSONObject.optLong("check_data_duration_ms");
        splashMonitorInfo.loadAndCheckDataTime = jSONObject.optLong("load_and_check_data_duration_ms");
        splashMonitorInfo.costTime = jSONObject.optLong("duration_ms");
        splashMonitorInfo.ids = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("ids");
        if (optJSONArray != null) {
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                splashMonitorInfo.ids.add((String) optJSONArray.opt(i6));
            }
        }
        splashMonitorInfo.count = jSONObject.optInt("count");
        splashMonitorInfo.cacheValidTime = jSONObject.optLong("validity_period_ms");
        splashMonitorInfo.size = jSONObject.optLong("size");
        splashMonitorInfo.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(splashMonitorInfo.url)) {
            splashMonitorInfo.url = "";
        }
        splashMonitorInfo.creativeId = jSONObject.optLong("creative_id");
        splashMonitorInfo.materialType = jSONObject.optInt("material_type");
        splashMonitorInfo.totalCount = jSONObject.optInt("total_count");
        splashMonitorInfo.creativeIds = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("creative_ids");
        if (optJSONArray2 != null) {
            for (int i7 = 0; i7 < optJSONArray2.length(); i7++) {
                splashMonitorInfo.creativeIds.add((String) optJSONArray2.opt(i7));
            }
        }
        splashMonitorInfo.preloadIds = new ArrayList();
        JSONArray optJSONArray3 = jSONObject.optJSONArray("preload_ids");
        if (optJSONArray3 != null) {
            for (int i8 = 0; i8 < optJSONArray3.length(); i8++) {
                splashMonitorInfo.preloadIds.add((String) optJSONArray3.opt(i8));
            }
        }
        splashMonitorInfo.materialTypes = new ArrayList();
        JSONArray optJSONArray4 = jSONObject.optJSONArray("material_types");
        if (optJSONArray4 != null) {
            for (int i9 = 0; i9 < optJSONArray4.length(); i9++) {
                splashMonitorInfo.materialTypes.add((Integer) optJSONArray4.opt(i9));
            }
        }
        splashMonitorInfo.updateType = jSONObject.optInt("update_type");
        splashMonitorInfo.clearCount = jSONObject.optInt("clear_count");
        splashMonitorInfo.clearImageCount = jSONObject.optInt("clear_image_count");
        splashMonitorInfo.clearVideoCount = jSONObject.optInt("clear_video_count");
        splashMonitorInfo.requestType = jSONObject.optInt("request_type");
        splashMonitorInfo.loadType = jSONObject.optInt("load_type");
        splashMonitorInfo.posId = jSONObject.optLong("pos_Id");
        splashMonitorInfo.viewSource = jSONObject.optInt("view_source");
        splashMonitorInfo.elementTypes = new ArrayList();
        JSONArray optJSONArray5 = jSONObject.optJSONArray("element_types");
        if (optJSONArray5 != null) {
            for (int i10 = 0; i10 < optJSONArray5.length(); i10++) {
                splashMonitorInfo.elementTypes.add((Integer) optJSONArray5.opt(i10));
            }
        }
        splashMonitorInfo.interactiveStyle = jSONObject.optString("interactive_style");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(splashMonitorInfo.interactiveStyle)) {
            splashMonitorInfo.interactiveStyle = "";
        }
        splashMonitorInfo.interactivityDefaultStyle = jSONObject.optString("interactivity_default_style");
        if (obj.toString().equals(splashMonitorInfo.interactivityDefaultStyle)) {
            splashMonitorInfo.interactivityDefaultStyle = "";
        }
        splashMonitorInfo.showEndTime = jSONObject.optLong("show_end_time");
        splashMonitorInfo.isRotateComposeTimeout = jSONObject.optBoolean("is_rotate_compose_timeout");
        splashMonitorInfo.tkDefaultTimeout = jSONObject.optLong("tk_default_timeout");
        splashMonitorInfo.soSource = jSONObject.optInt("so_source");
        splashMonitorInfo.soLoadTime = jSONObject.optLong("so_load_time");
        splashMonitorInfo.offlineSource = jSONObject.optInt("offline_source");
        splashMonitorInfo.offlineLoadTime = jSONObject.optLong("offline_load_time");
        splashMonitorInfo.tkFileLoadTime = jSONObject.optLong("tk_file_load_time");
        splashMonitorInfo.tkInitTime = jSONObject.optLong("tk_init_time");
        splashMonitorInfo.tkRenderTime = jSONObject.optLong("tk_render_time");
        splashMonitorInfo.nativeLoadTime = jSONObject.optLong("native_load_time");
        splashMonitorInfo.isWebTimeout = jSONObject.optBoolean("is_web_timeout");
        splashMonitorInfo.webLoadTime = jSONObject.optLong("web_load_time");
        splashMonitorInfo.templateId = jSONObject.optString("template_id");
        if (obj.toString().equals(splashMonitorInfo.templateId)) {
            splashMonitorInfo.templateId = "";
        }
        splashMonitorInfo.templateVersionCode = jSONObject.optInt("template_version_code");
        splashMonitorInfo.tkTotalTime = jSONObject.optLong("tk_total_time");
        splashMonitorInfo.actionType = jSONObject.optInt("action_type");
        splashMonitorInfo.callbackType = jSONObject.optInt("callback_type");
        splashMonitorInfo.tkRenderType = jSONObject.optLong("tk_render_type");
        splashMonitorInfo.loadProcessType = jSONObject.optLong("load_process_type");
        splashMonitorInfo.rootVisible = jSONObject.optBoolean("root_visible");
        splashMonitorInfo.parentVisible = jSONObject.optBoolean("parent_visible");
        splashMonitorInfo.addLoadTime = jSONObject.optLong("add_load_time");
        splashMonitorInfo.buriedPointOptimizeType = jSONObject.optInt("buried_point_optimize_type");
        splashMonitorInfo.visibleCheckDelayTime = jSONObject.optLong("visible_check_delay_time");
        splashMonitorInfo.requestLoadTime = jSONObject.optLong("request_load_Time");
        splashMonitorInfo.showType = jSONObject.optInt("show_type");
        splashMonitorInfo.showDurationMs = jSONObject.optLong("show_duration_ms");
        splashMonitorInfo.hasUnbind = jSONObject.optBoolean("has_unbind");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(SplashMonitorInfo splashMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = splashMonitorInfo.status;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, NotificationCompat.CATEGORY_STATUS, i6);
        }
        int i7 = splashMonitorInfo.type;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "type", i7);
        }
        String str = splashMonitorInfo.preloadId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "preload_id", splashMonitorInfo.preloadId);
        }
        int i8 = splashMonitorInfo.checkStatus;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "check_status", i8);
        }
        long j6 = splashMonitorInfo.loadDataTime;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "load_data_duration_ms", j6);
        }
        long j7 = splashMonitorInfo.beforeLoadDataTime;
        if (j7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "before_load_data_duration_ms", j7);
        }
        long j8 = splashMonitorInfo.checkDataTime;
        if (j8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "check_data_duration_ms", j8);
        }
        long j9 = splashMonitorInfo.loadAndCheckDataTime;
        if (j9 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "load_and_check_data_duration_ms", j9);
        }
        long j10 = splashMonitorInfo.costTime;
        if (j10 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "duration_ms", j10);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "ids", splashMonitorInfo.ids);
        int i9 = splashMonitorInfo.count;
        if (i9 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "count", i9);
        }
        long j11 = splashMonitorInfo.cacheValidTime;
        if (j11 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "validity_period_ms", j11);
        }
        long j12 = splashMonitorInfo.size;
        if (j12 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "size", j12);
        }
        String str2 = splashMonitorInfo.url;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "url", splashMonitorInfo.url);
        }
        long j13 = splashMonitorInfo.creativeId;
        if (j13 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "creative_id", j13);
        }
        int i10 = splashMonitorInfo.materialType;
        if (i10 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "material_type", i10);
        }
        int i11 = splashMonitorInfo.totalCount;
        if (i11 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "total_count", i11);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "creative_ids", splashMonitorInfo.creativeIds);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "preload_ids", splashMonitorInfo.preloadIds);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "material_types", splashMonitorInfo.materialTypes);
        int i12 = splashMonitorInfo.updateType;
        if (i12 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "update_type", i12);
        }
        int i13 = splashMonitorInfo.clearCount;
        if (i13 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "clear_count", i13);
        }
        int i14 = splashMonitorInfo.clearImageCount;
        if (i14 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "clear_image_count", i14);
        }
        int i15 = splashMonitorInfo.clearVideoCount;
        if (i15 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "clear_video_count", i15);
        }
        int i16 = splashMonitorInfo.requestType;
        if (i16 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "request_type", i16);
        }
        int i17 = splashMonitorInfo.loadType;
        if (i17 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "load_type", i17);
        }
        long j14 = splashMonitorInfo.posId;
        if (j14 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "pos_Id", j14);
        }
        int i18 = splashMonitorInfo.viewSource;
        if (i18 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "view_source", i18);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "element_types", splashMonitorInfo.elementTypes);
        String str3 = splashMonitorInfo.interactiveStyle;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "interactive_style", splashMonitorInfo.interactiveStyle);
        }
        String str4 = splashMonitorInfo.interactivityDefaultStyle;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "interactivity_default_style", splashMonitorInfo.interactivityDefaultStyle);
        }
        long j15 = splashMonitorInfo.showEndTime;
        if (j15 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "show_end_time", j15);
        }
        boolean z5 = splashMonitorInfo.isRotateComposeTimeout;
        if (z5) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "is_rotate_compose_timeout", z5);
        }
        long j16 = splashMonitorInfo.tkDefaultTimeout;
        if (j16 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "tk_default_timeout", j16);
        }
        int i19 = splashMonitorInfo.soSource;
        if (i19 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "so_source", i19);
        }
        long j17 = splashMonitorInfo.soLoadTime;
        if (j17 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "so_load_time", j17);
        }
        int i20 = splashMonitorInfo.offlineSource;
        if (i20 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "offline_source", i20);
        }
        long j18 = splashMonitorInfo.offlineLoadTime;
        if (j18 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "offline_load_time", j18);
        }
        long j19 = splashMonitorInfo.tkFileLoadTime;
        if (j19 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "tk_file_load_time", j19);
        }
        long j20 = splashMonitorInfo.tkInitTime;
        if (j20 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "tk_init_time", j20);
        }
        long j21 = splashMonitorInfo.tkRenderTime;
        if (j21 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "tk_render_time", j21);
        }
        long j22 = splashMonitorInfo.nativeLoadTime;
        if (j22 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "native_load_time", j22);
        }
        boolean z6 = splashMonitorInfo.isWebTimeout;
        if (z6) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "is_web_timeout", z6);
        }
        long j23 = splashMonitorInfo.webLoadTime;
        if (j23 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "web_load_time", j23);
        }
        String str5 = splashMonitorInfo.templateId;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "template_id", splashMonitorInfo.templateId);
        }
        int i21 = splashMonitorInfo.templateVersionCode;
        if (i21 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "template_version_code", i21);
        }
        long j24 = splashMonitorInfo.tkTotalTime;
        if (j24 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "tk_total_time", j24);
        }
        int i22 = splashMonitorInfo.actionType;
        if (i22 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "action_type", i22);
        }
        int i23 = splashMonitorInfo.callbackType;
        if (i23 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "callback_type", i23);
        }
        long j25 = splashMonitorInfo.tkRenderType;
        if (j25 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "tk_render_type", j25);
        }
        long j26 = splashMonitorInfo.loadProcessType;
        if (j26 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "load_process_type", j26);
        }
        boolean z7 = splashMonitorInfo.rootVisible;
        if (z7) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "root_visible", z7);
        }
        boolean z8 = splashMonitorInfo.parentVisible;
        if (z8) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "parent_visible", z8);
        }
        long j27 = splashMonitorInfo.addLoadTime;
        if (j27 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "add_load_time", j27);
        }
        int i24 = splashMonitorInfo.buriedPointOptimizeType;
        if (i24 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "buried_point_optimize_type", i24);
        }
        long j28 = splashMonitorInfo.visibleCheckDelayTime;
        if (j28 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "visible_check_delay_time", j28);
        }
        long j29 = splashMonitorInfo.requestLoadTime;
        if (j29 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "request_load_Time", j29);
        }
        int i25 = splashMonitorInfo.showType;
        if (i25 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "show_type", i25);
        }
        long j30 = splashMonitorInfo.showDurationMs;
        if (j30 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "show_duration_ms", j30);
        }
        boolean z9 = splashMonitorInfo.hasUnbind;
        if (z9) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "has_unbind", z9);
        }
        return jSONObject;
    }
}
