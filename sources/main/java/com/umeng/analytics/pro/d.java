package com.umeng.analytics.pro;

import cn.jpush.android.api.JThirdPlatFormInterface;
import com.amap.api.services.district.DistrictSearchQuery;
import com.huawei.hms.mlsdk.common.AgConnectInfo;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class d {
    public static final String A = "ts";
    public static final String B = "locations";
    public static final String C = "lat";
    public static final String D = "lng";
    public static final String E = "ts";
    public static final String F = "traffic";
    public static final String G = "upload_traffic";
    public static final String H = "download_traffic";
    public static final String I = "activate_msg";
    public static final String J = "ts";
    public static final String K = "group_info";
    public static final String L = "active_user";
    public static final String M = "provider";
    public static final String N = "puid";
    public static final String O = "_$!mobile";
    public static final String P = "_$!email";
    public static final String Q = "_#$$$";
    public static final String R = "up";
    public static final String S = "pk";
    public static final String T = "pv";
    public static final String U = "error";
    public static final String V = "ts";
    public static final String W = "error_source";
    public static final String X = "context";
    public static final String Y = "ekv";
    public static final String Z = "gkv";

    /* renamed from: a, reason: collision with root package name */
    public static final String f41182a = "appkey";
    public static final String aB = "_$pp";
    public static final String aC = "session";
    public static final String aD = "pageview";
    public static final String aE = "versioncode";
    public static final String aF = "versionname";
    public static final String aG = "userlevel";
    public static final String aH = "eof";
    public static final String aI = "exception";
    public static final String aa = "id";
    public static final String ab = "ts";
    public static final String ad = "userlevel";
    public static final String af = "dplus";
    public static final String ag = "analytics";
    public static final String ah = "push";
    public static final String ai = "share";
    public static final String aj = "content";
    public static final String ak = "header";
    public static final String al = "ds";
    public static final String am = "pn";
    public static final String an = "pro_ver";
    public static final String ao = "1.0.0";
    public static final String ap = "atm";
    public static final String aq = "st";
    public static final String at = "ekv_bl_ver";
    public static final String au = "ekv_wl_ver";
    public static final String av = "$ekv_bl_ver";
    public static final String aw = "$ekv_wl_ver";
    public static final String ax = "events";

    /* renamed from: b, reason: collision with root package name */
    public static final String f41183b = "channel";

    /* renamed from: c, reason: collision with root package name */
    public static final String f41184c = "secret";

    /* renamed from: d, reason: collision with root package name */
    public static final String f41185d = "app_version";

    /* renamed from: e, reason: collision with root package name */
    public static final String f41186e = "version_code";

    /* renamed from: f, reason: collision with root package name */
    public static final String f41187f = "wrapper_type";

    /* renamed from: g, reason: collision with root package name */
    public static final String f41188g = "wrapper_version";

    /* renamed from: h, reason: collision with root package name */
    public static final String f41189h = "sdk_version";

    /* renamed from: i, reason: collision with root package name */
    public static final String f41190i = "vertical_type";

    /* renamed from: j, reason: collision with root package name */
    public static final String f41191j = "device_id";

    /* renamed from: k, reason: collision with root package name */
    public static final String f41192k = "device_model";

    /* renamed from: l, reason: collision with root package name */
    public static final String f41193l = "$pr_ve";

    /* renamed from: m, reason: collision with root package name */
    public static final String f41194m = "$ud_da";

    /* renamed from: n, reason: collision with root package name */
    public static final String f41195n = "sessions";

    /* renamed from: o, reason: collision with root package name */
    public static final String f41196o = "id";

    /* renamed from: p, reason: collision with root package name */
    public static final String f41197p = "start_time";

    /* renamed from: q, reason: collision with root package name */
    public static final String f41198q = "end_time";

    /* renamed from: r, reason: collision with root package name */
    public static final String f41199r = "duration";

    /* renamed from: s, reason: collision with root package name */
    public static final String f41200s = "duration_old";

    /* renamed from: t, reason: collision with root package name */
    public static final String f41201t = "pages";

    /* renamed from: u, reason: collision with root package name */
    public static final String f41202u = "autopages";

    /* renamed from: v, reason: collision with root package name */
    public static final String f41203v = "page_name";

    /* renamed from: w, reason: collision with root package name */
    public static final String f41204w = "duration";

    /* renamed from: x, reason: collision with root package name */
    public static final String f41205x = "page_start";

    /* renamed from: y, reason: collision with root package name */
    public static final String f41206y = "type";

    /* renamed from: z, reason: collision with root package name */
    public static final String f41207z = "$page_num";
    public static final String ar = au.b().b(au.f40915t);
    public static final String as = au.b().b(au.f40916u);
    public static final String aJ = "_$!deep_link";
    public static final String aK = "_$!link";
    public static final String[] aL = {aJ, aK};
    public static final String ac = "du";
    public static final String ae = "$st_fl";
    public static final String aA = "_$sp";
    public static final String[] aM = {"id", "ts", ac, ae, "ds", "pn", aA};
    public static final String ay = "_$!ts";
    public static final String az = "_$!id";
    public static final String[] aN = {ay, az, "_$!du", "_$!c", ae, "_$!sp", "event_name", JThirdPlatFormInterface.KEY_TOKEN, "time", IjkMediaPlayer.OnNativeInvokeListener.ARG_IP, "country", AgConnectInfo.AgConnectKey.REGION, DistrictSearchQuery.KEYWORDS_CITY, "browser", "os", bi.F, "device_version", bi.ai, "screen_width", "screen_height", "referrer", "referrer_domain", "initial_referrer", "initial_referrer_domain", "initial_view_time", "search_engine", "keyword", "ali_lib", "utm_source", "utm_medium", "utm_term", "utm_content", "utm_campaign", "date", "hour", "minute", "app_version", "sp"};
}
