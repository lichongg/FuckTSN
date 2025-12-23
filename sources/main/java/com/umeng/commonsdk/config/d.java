package com.umeng.commonsdk.config;

import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static final long f41624a = 1000;

    /* renamed from: b, reason: collision with root package name */
    public static final String f41625b = "_LAST_FIELD";

    /* renamed from: c, reason: collision with root package name */
    public static final String f41626c = "3749699455";

    /* renamed from: d, reason: collision with root package name */
    public static final String f41627d = "2130669566";

    /* renamed from: e, reason: collision with root package name */
    public static final String f41628e = "262139";

    /* renamed from: f, reason: collision with root package name */
    public static final String f41629f = "1983";

    /* renamed from: g, reason: collision with root package name */
    public static final int f41630g = 64;

    /* renamed from: l, reason: collision with root package name */
    private static Map<String, String[]> f41635l = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    public static String[] f41631h = new String[a.values().length];

    /* renamed from: i, reason: collision with root package name */
    public static String[] f41632i = new String[b.values().length];

    /* renamed from: j, reason: collision with root package name */
    public static String[] f41633j = new String[c.values().length];

    /* renamed from: k, reason: collision with root package name */
    public static String[] f41634k = new String[EnumC0825d.values().length];

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum a {
        header_utoken,
        header_cpu,
        header_mccmnc,
        header_sub_os_name,
        header_sub_os_version,
        header_device_type,
        header_device_id_imei,
        header_device_id_mac,
        header_device_id_android_id,
        header_device_id_serialNo,
        header_bulid,
        header_os_version,
        header_resolution,
        header_mc,
        header_timezone,
        header_local_info,
        header_carrier,
        header_access,
        header_tracking_imei,
        header_tracking_android_id,
        header_tracking_utdid,
        header_tracking_idmd5,
        header_tracking_idfa,
        header_tracking_mac,
        header_tracking_serial,
        header_tracking_uuid,
        header_tracking_uop,
        header_tracking_oldumid,
        header_tracking_newumid,
        header_ekv_send_on_exit,
        header_device_oaid,
        header_local_ip,
        header_foreground_count,
        header_first_resume,
        header_sub_os_info,
        _LAST_FIELD
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum b {
        inner_rs,
        inner_by,
        inner_gp,
        inner_to,
        inner_mo,
        inner_ca,
        inner_fl,
        inner_gdf_r,
        inner_thm_z,
        inner_dsk_s,
        inner_sd,
        inner_build,
        inner_sr,
        inner_scr,
        inner_sinfo,
        inner_winfo,
        inner_input,
        inner_bt,
        inner_mem,
        inner_cpu,
        inner_rom,
        inner_bstn,
        inner_cam,
        inner_appls,
        inner_lbs,
        internal_run_server,
        internal_imsi,
        internal_meid,
        tp_tp,
        inner_imei2,
        inner_iccid,
        inner_batt2,
        inner_build2,
        inner_cpu2,
        ccg_switch,
        check_system_app,
        check_pus_permission,
        _LAST_FIELD
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum c {
        push_cpu,
        push_imei,
        push_mac,
        push_android_id,
        push_serialNo,
        push_settings_android_id,
        push_network_access_mode,
        push_on_line,
        push_time_zone,
        push_locale_info,
        push_resolution,
        push_operator,
        push_utdid,
        push_service_work,
        push_service_name,
        push_intent_exist,
        push_data_data,
        push_notification_enabled,
        _LAST_FIELD
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.umeng.commonsdk.config.d$d, reason: collision with other inner class name */
    public enum EnumC0825d {
        share_device_id,
        share_imsi,
        share_iccid,
        share_sn,
        share_net_accmode,
        share_android_id,
        share_wifi_mac,
        share_sd_size,
        share_ssid,
        share_resolution,
        share_conn_type,
        _LAST_FIELD
    }

    static {
        String[] strArr = f41631h;
        if (strArr != null && strArr.length > 0) {
            for (int i6 = 0; i6 < a.values().length; i6++) {
                f41631h[i6] = a.values()[i6].toString();
            }
            Map<String, String[]> map = f41635l;
            if (map != null) {
                map.put(a.class.getName(), f41631h);
            }
        }
        String[] strArr2 = f41632i;
        if (strArr2 != null && strArr2.length > 0) {
            for (int i7 = 0; i7 < b.values().length; i7++) {
                f41632i[i7] = b.values()[i7].toString();
            }
            Map<String, String[]> map2 = f41635l;
            if (map2 != null) {
                map2.put(b.class.getName(), f41632i);
            }
        }
        String[] strArr3 = f41633j;
        if (strArr3 != null && strArr3.length > 0) {
            for (int i8 = 0; i8 < c.values().length; i8++) {
                f41633j[i8] = c.values()[i8].toString();
            }
            Map<String, String[]> map3 = f41635l;
            if (map3 != null) {
                map3.put(c.class.getName(), f41633j);
            }
        }
        String[] strArr4 = f41634k;
        if (strArr4 == null || strArr4.length <= 0) {
            return;
        }
        for (int i9 = 0; i9 < EnumC0825d.values().length; i9++) {
            f41634k[i9] = EnumC0825d.values()[i9].toString();
        }
        Map<String, String[]> map4 = f41635l;
        if (map4 != null) {
            map4.put(EnumC0825d.class.getName(), f41634k);
        }
    }

    public static boolean a(String str) {
        return (str == null || str.length() <= 0 || f41625b.equalsIgnoreCase(str)) ? false : true;
    }

    public static String[] b(String str) {
        if (str == null || str.length() <= 0 || !f41635l.containsKey(str)) {
            return null;
        }
        return f41635l.get(str);
    }
}
