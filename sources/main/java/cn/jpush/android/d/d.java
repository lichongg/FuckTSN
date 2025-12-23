package cn.jpush.android.d;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import cn.jpush.android.ad.m;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.api.NotificationMessage;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.tencent.open.SocialConstants;
import com.umeng.analytics.pro.bi;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.LineNumberReader;
import java.io.Serializable;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class d implements Serializable {
    private static HashMap<String, String> bX = new HashMap<>();
    private static Map<String, String> bY = new HashMap();
    private static HashMap<String, String> bZ = new HashMap<>();
    private static final long serialVersionUID = 8407025843324043625L;
    public String A;
    public String B;
    public String C;
    public int D;
    public int E;
    public String F;
    public String G;
    public String J;
    public String K;
    public String L;
    public String M;
    public String N;
    public String O;
    public int P;
    public String Q;
    public String R;
    public int T;
    public String U;
    public String V;
    public int W;
    public String Z;
    public String aa;
    public String ab;
    public int ac;
    public int ae;
    public Integer aj;
    public String ak;
    public long al;
    public String am;
    public boolean an;
    public boolean ao;
    public long ap;
    public String as;
    public String at;
    public String au;
    public String av;
    public String aw;
    public String ax;
    public int ay;
    public int az;

    /* renamed from: b, reason: collision with root package name */
    public String f3586b;
    public String bA;
    public int bD;
    public int bE;
    public int bF;
    public String bJ;
    public int bM;
    public int bN;
    public long bO;
    public long bP;
    public long bQ;
    public long bR;
    public String bS;
    public String bT;
    public String bU;
    public JSONObject bV;
    public JSONObject bW;
    public String bh;
    public int bt;
    public int bu;
    public boolean bv;
    public boolean bw;
    public String bx;
    public String by;

    /* renamed from: c, reason: collision with root package name */
    public String f3587c;

    /* renamed from: d, reason: collision with root package name */
    public String f3588d;

    /* renamed from: e, reason: collision with root package name */
    public int f3589e;

    /* renamed from: f, reason: collision with root package name */
    public int f3590f;

    /* renamed from: g, reason: collision with root package name */
    public String f3591g;

    /* renamed from: h, reason: collision with root package name */
    public String f3592h;

    /* renamed from: i, reason: collision with root package name */
    public String f3593i;

    /* renamed from: j, reason: collision with root package name */
    public int f3594j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f3595k;

    /* renamed from: l, reason: collision with root package name */
    public int f3596l;

    /* renamed from: n, reason: collision with root package name */
    public String f3598n;

    /* renamed from: o, reason: collision with root package name */
    public String f3599o;

    /* renamed from: p, reason: collision with root package name */
    public String f3600p;

    /* renamed from: q, reason: collision with root package name */
    public String f3601q;

    /* renamed from: r, reason: collision with root package name */
    public int f3602r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f3603s;

    /* renamed from: t, reason: collision with root package name */
    public int f3604t;

    /* renamed from: u, reason: collision with root package name */
    public String f3605u;

    /* renamed from: v, reason: collision with root package name */
    public String f3606v;

    /* renamed from: w, reason: collision with root package name */
    public JSONArray f3607w;

    /* renamed from: x, reason: collision with root package name */
    public String f3608x;

    /* renamed from: y, reason: collision with root package name */
    public String f3609y;

    /* renamed from: z, reason: collision with root package name */
    public int f3610z;

    /* renamed from: a, reason: collision with root package name */
    public int f3585a = -1;

    /* renamed from: m, reason: collision with root package name */
    public int f3597m = 0;
    public int H = -1;
    public String I = "";
    public int S = 0;
    public boolean X = false;
    public boolean Y = false;
    public int ad = 0;
    public ArrayList<String> af = new ArrayList<>();
    public String ag = "";
    public String ah = "";
    public byte ai = 0;
    public double aq = 200.0d;
    public double ar = 200.0d;
    public String aA = "";
    public String aB = "";
    public String aC = "";
    public String aD = "";
    public String aE = "";
    public int aF = 1;
    public int aG = 2;
    public int aH = 0;
    public int aI = 0;
    public int aJ = 0;
    public int aK = 0;
    public int aL = 1;
    public int aM = 0;
    public String aN = "";
    public int aO = 0;
    public long aP = 0;
    public int aQ = 0;
    public int aR = 0;
    public int aS = 0;
    public int aT = 1;
    public int aU = 1;
    public String aV = "#FFFFFFFF";
    public String aW = "#FF000000";
    public String aX = "#FF000000";
    public int aY = 14;
    public int aZ = 14;
    public int ba = 9;
    public int bb = 5;
    public float bc = 1.0f;
    public float bd = 1.0f;
    public String be = "";
    public int bf = 2;
    public int bg = 2;
    public String bi = "";
    public String bj = "";
    public float bk = 0.6f;
    public String bl = "";
    public String bm = "";
    public ArrayList<String> bn = new ArrayList<>();
    public int bo = 0;
    public int bp = 180;
    public int bq = 0;
    public int br = 0;
    public String bs = "";
    public String bz = "";
    public String bB = "";
    public ArrayList<Float> bC = new ArrayList<>();
    public int bG = 0;
    public int bH = 0;
    public float bI = -1.0f;
    public int bK = 1;
    public int bL = 1;

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final Map<String, String> f3611a;

        static {
            HashMap hashMap = new HashMap();
            f3611a = hashMap;
            hashMap.put("google", "fc");
            hashMap.put("huawei", "hw");
            hashMap.put("honor", "hn");
            hashMap.put("meizu", "mz");
            hashMap.put("vivo", "vi");
            hashMap.put("oppo", "op");
            hashMap.put("realme", "op");
            hashMap.put("oneplus", "op");
            hashMap.put("xiaomi", "xm");
            hashMap.put("blackshark", "xm");
        }

        public static int a(JSONObject jSONObject) {
            int b6;
            int optInt = jSONObject.optInt("n_priority", 0);
            int c6 = c(jSONObject);
            return (-1 != c6 && optInt > (b6 = cn.jpush.android.x.a.b(c6))) ? b6 : optInt;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int c(JSONObject jSONObject) {
            String str;
            JSONObject optJSONObject = jSONObject.optJSONObject("n_importance");
            if (optJSONObject == null || (str = Build.MANUFACTURER) == null) {
                return -1;
            }
            String str2 = f3611a.get(str.toLowerCase());
            if (str2 != null) {
                int optInt = optJSONObject.optInt(str2, -1);
                Logger.d("PushEntity", "im_v:" + optInt);
                return optInt;
            }
            return -1;
        }
    }

    private static int b(int i6) {
        String valueOf = String.valueOf(i6);
        if (valueOf.startsWith("1")) {
            return 2;
        }
        if (valueOf.startsWith("2")) {
            return 3;
        }
        return valueOf.startsWith("3") ? 4 : -1;
    }

    public cn.jpush.android.d.a a() {
        return new cn.jpush.android.d.a(this);
    }

    public String c() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("msgType", this.f3585a);
            jSONObject.put("appId", this.f3586b);
            jSONObject.put("senderId", this.f3587c);
            jSONObject.put("messageId", this.f3588d);
            jSONObject.put("_j_data_", this.f3591g);
            jSONObject.put("notificationId", this.f3589e);
            jSONObject.put("messageType", this.f3590f);
            jSONObject.put("overrideMessageId", this.f3592h);
            jSONObject.put("messageVersion", this.f3594j);
            jSONObject.put("notificationOnly", this.f3595k);
            jSONObject.put("notificationBuilderId", this.f3596l);
            jSONObject.put("notificationType", this.f3597m);
            jSONObject.put(CrashHianalyticsData.MESSAGE, this.f3598n);
            jSONObject.put("originalMessage", this.f3593i);
            jSONObject.put("contentType", this.f3599o);
            jSONObject.put("title", this.f3600p);
            jSONObject.put("extras", this.f3601q);
            jSONObject.put("type", this.f3602r);
            jSONObject.put("isFullScreen", this.f3603s);
            jSONObject.put("notificationRemoveMode", this.f3604t);
            jSONObject.put("notificationTitle", this.f3606v);
            jSONObject.put("notificationBgColor", this.f3605u);
            jSONObject.put("notificationTargetEvent", this.f3607w);
            jSONObject.put("notificationAppName", this.f3608x);
            jSONObject.put("notificationContent", this.f3609y);
            jSONObject.put("notificationStyle", this.f3610z);
            jSONObject.put("notificationBigText", this.A);
            jSONObject.put("notificationBigPicPath", this.B);
            jSONObject.put("notificationInbox", this.C);
            jSONObject.put("notificationPriority", this.D);
            jSONObject.put("notificationImportance", this.E);
            jSONObject.put("notificationCategory", this.F);
            jSONObject.put("notificationExtra", this.G);
            jSONObject.put("notificationAlertType", this.H);
            jSONObject.put("notificationChannelId", this.I);
            jSONObject.put("displayForeground", this.J);
            jSONObject.put(SocialConstants.PARAM_SOURCE, this.K);
            jSONObject.put("smallIcon", this.L);
            jSONObject.put("largeIcon", this.M);
            jSONObject.put("normalSmallIcon", this.N);
            jSONObject.put("deeplink", this.O);
            jSONObject.put("failedAction", this.P);
            jSONObject.put("failedLink", this.Q);
            jSONObject.put("targetPkgName", this.R);
            jSONObject.put("deeplinkBuilderId", this.T);
            jSONObject.put("isRichPush", this.Y);
            jSONObject.put("showUrl", this.Z);
            jSONObject.put("showTitle", this.aa);
            jSONObject.put("_webPagePath", this.ab);
            jSONObject.put("jumpMode", this.ac);
            jSONObject.put("richType", this.ad);
            jSONObject.put("showMode", this.ae);
            jSONObject.put("showResourceList", m.a(this.af, ","));
            jSONObject.put("fromNum", this.ag);
            jSONObject.put("toNum", this.ah);
            jSONObject.put("platform", (int) this.ai);
            jSONObject.put("badgeAddNum", this.aj);
            jSONObject.put("geofenceid", this.ak);
            jSONObject.put("radius", this.al);
            jSONObject.put(NotificationCompat.CATEGORY_STATUS, this.am);
            jSONObject.put("repeat", this.an);
            jSONObject.put("hasShow", this.ao);
            jSONObject.put("expiration", this.ap);
            jSONObject.put("longitude", this.aq);
            jSONObject.put("latitude", this.ar);
            jSONObject.put("lastGeoStatus", this.as);
            jSONObject.put("developerArg0", this.at);
            jSONObject.put("sound", this.au);
            jSONObject.put("showBeginTime", this.av);
            jSONObject.put("showEndTime", this.aw);
            jSONObject.put("isWmDeepLink", this.X);
            jSONObject.put("wxAppId", this.U);
            jSONObject.put("miniOriginid", this.V);
            jSONObject.put("miniType", this.W);
            jSONObject.put("inAppMsgContent", this.aC);
            jSONObject.put("inAppIntent", this.aB);
            jSONObject.put("inAppMsgTitle", this.aD);
            jSONObject.put("inAppMsgContentBody", this.aE);
            jSONObject.put("target", this.bS);
            jSONObject.put("clickAction", this.bU);
            jSONObject.put("extras", this.f3601q);
            jSONObject.put("inAppMsgType", this.aF);
            jSONObject.put("inAppMsgShowType", this.aG);
            jSONObject.put("inAppMsgShowPos", this.aH);
            jSONObject.put("inAppMsgShowAniAction", this.aI);
            jSONObject.put("inSupportNotifyAni", this.bq);
            jSONObject.put("inSupportVibration", this.br);
            jSONObject.put("inAppIcon", this.bs);
            jSONObject.put("inAppMsgDismissAniAction", this.aJ);
            jSONObject.put("inAppMsgShowBackground", this.aK);
            jSONObject.put("inAppMsgAllowIntercept", this.aL);
            jSONObject.put("inAppMsgFilterMsg", this.aM);
            jSONObject.put("inAppMsgPicPath", this.aN);
            jSONObject.put("inAppMsgCountLmt", this.aO);
            jSONObject.put("inAppMsgGap", this.aP);
            jSONObject.put("inAppMsgToUser", this.aQ);
            jSONObject.put("inAppMsgDelayDisplayTime", this.aR);
            jSONObject.put("inAppMsgPageDelayDisplayTime", this.aS);
            jSONObject.put("inAppMsgReportPageName", this.aT);
            jSONObject.put("inAppUseSysAlert", this.aU);
            jSONObject.put("inAppMsgBackgroundColor", this.aV);
            jSONObject.put("inAppMsgTitleColor", this.aW);
            jSONObject.put("inAppMsgContentColor", this.aX);
            jSONObject.put("inAppMsgTitleSize", this.aY);
            jSONObject.put("inAppMsgContentSize", this.aZ);
            jSONObject.put("inAppMsgCircularSize", this.ba);
            jSONObject.put("inAppMsgShowTime", this.bb);
            jSONObject.put("inAppMsgShowElapseTime", this.bc);
            jSONObject.put("inAppMsgDismissElapseTime", this.bd);
            jSONObject.put("inAppWebPageUrl", this.be);
            jSONObject.put("inAppProtocolVer", this.bf);
            jSONObject.put("inAppSSPGap", this.bp);
            jSONObject.put("inAppCheckIntent", this.bg);
            jSONObject.put("inAppTplContent", this.bh);
            jSONObject.put("inAppTplId", this.bi);
            jSONObject.put("inAppTplUrl", this.bj);
            jSONObject.put("inAppMarginY", this.bk);
            jSONObject.put("inAppTplData", this.bl);
            jSONObject.put("inAppIntentActions", this.bm);
            jSONObject.put("inAppShowResList", m.a(this.bn, ","));
            jSONObject.put("inAppType", this.bt);
            jSONObject.put("expired", this.bP);
            jSONObject.put("notifyInAppCacheNumb", this.ay);
            jSONObject.put("notifyInAppMsgType", this.az);
            jSONObject.put("inAppPriority", this.bu);
            jSONObject.put("inAppIsDisplayDirect", this.bv);
            jSONObject.put("inAppFixed", this.bw);
            jSONObject.put("inAppBlackConf", this.bx);
            jSONObject.put("inAppAnimatorConf", this.by);
            jSONObject.put("inAppAdPosition", this.bz);
            jSONObject.put("inAppFragment", this.bA);
            jSONObject.put("inAppAdPosId", this.bB);
            jSONObject.put("inAppCoordinateType", this.bD);
            jSONObject.put("inAppWinWidth", this.bE);
            jSONObject.put("inAppWinHeight", this.bF);
            JSONArray jSONArray = new JSONArray();
            Iterator<Float> it = this.bC.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().floatValue());
            }
            jSONObject.put("inAppShowCoordinate", jSONArray);
            jSONObject.put("inAppPosMsgCountLmt", this.bG);
            jSONObject.put("inAppPosMsgGap", this.bH);
            jSONObject.put("inAppSizeRatio", this.bI);
            jSONObject.put("sequenceId", this.aA);
            jSONObject.put("unionADExtras", this.bJ);
            jSONObject.put("swipeDismiss", this.bK);
            jSONObject.put("adSspSvrVer", this.bL);
            jSONObject.put("inAppMsgStyle", this.bM);
            jSONObject.put("inAppMsgStyleGap", this.bN);
            jSONObject.put("target", this.bS);
            jSONObject.put("msgTime", this.bO);
            jSONObject.put("delay", this.bQ);
            jSONObject.put(bi.aX, this.bR);
            jSONObject.put("inAppPriority", this.bu);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static d a(Context context, d dVar) {
        try {
            JSONObject optJSONObject = new JSONObject(dVar.f3593i).optJSONObject("inapp");
            if (optJSONObject == null) {
                return null;
            }
            dVar.a(context);
            dVar.aD = dVar.f3606v;
            dVar.aE = dVar.f3609y;
            dVar.aR = optJSONObject.optInt("inapp_delay_display_time", 10) * 1000;
            dVar.bj = optJSONObject.optString("inapp_h5_tpl_url", "");
            dVar.bu = 1;
            dVar.bv = optJSONObject.optInt("inapp_display_direct", 0) == 1;
            dVar.aH = optJSONObject.optInt("inapp_show_pos", 0);
            dVar.bb = optJSONObject.optInt("inapp_show_threshold_time", 5);
            String str = dVar.M;
            if (!TextUtils.isEmpty(str)) {
                dVar.bn.add(str);
            }
            dVar.bO = System.currentTimeMillis();
            dVar.bP = cn.jpush.android.ad.b.b(optJSONObject.optString("inapp_end_time", ""));
            dVar.ay = optJSONObject.optInt("inapp_max_cache_numb", 10);
            dVar.aQ = optJSONObject.optInt("inapp_msg_to_user", 1);
            dVar.bt = 40;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("in_title", dVar.aD);
            jSONObject.put("in_body_content", dVar.aE);
            jSONObject.put("in_pic_path1", str);
            dVar.bl = jSONObject.toString();
            return dVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String c(String str) {
        HashMap<String, String> hashMap = bX;
        return hashMap != null ? hashMap.get(str) : "";
    }

    public static String d(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                LineNumberReader lineNumberReader = new LineNumberReader(new StringReader(str));
                String readLine = lineNumberReader.readLine();
                String readLine2 = lineNumberReader.readLine();
                if (readLine == null) {
                    Logger.e("PushEntity", "NO appId");
                    return null;
                }
                if (readLine2 == null) {
                    Logger.e("PushEntity", "NO senderId");
                    return null;
                }
                int length = readLine.length() + readLine2.length();
                int i6 = length + 2;
                if (str.length() <= length + 3) {
                    Logger.d("PushEntity", "No msgContent");
                    return null;
                }
                String optString = new JSONObject(str.substring(i6)).optString("_j_data_", "");
                Logger.d("PushEntity", "get jdata from push msg:" + optString);
                return optString;
            } catch (Throwable th) {
                Logger.d("PushEntity", "get jdata from push msg error:" + th.getMessage());
            }
        }
        return null;
    }

    public NotificationMessage b() {
        NotificationMessage notificationMessage = new NotificationMessage();
        notificationMessage.appkey = this.f3587c;
        notificationMessage.msgId = this.f3588d;
        notificationMessage.notificationAlertType = this.H;
        notificationMessage.notificationBigPicPath = this.B;
        notificationMessage.notificationBigText = this.A;
        notificationMessage.notificationBuilderId = this.f3596l;
        notificationMessage.notificationCategory = this.F;
        notificationMessage.notificationContent = this.f3609y;
        notificationMessage.notificationExtras = this.G;
        notificationMessage.notificationId = this.f3589e;
        notificationMessage.notificationInbox = this.C;
        notificationMessage.notificationLargeIcon = this.M;
        notificationMessage.notificationPriority = this.D;
        notificationMessage.notificationImportance = this.E;
        notificationMessage.notificationSmallIcon = this.L;
        notificationMessage.notificationStyle = this.f3610z;
        notificationMessage.notificationTitle = this.f3606v;
        notificationMessage.notificationTargetEvent = this.f3607w;
        notificationMessage.appId = this.f3586b;
        notificationMessage.notificationType = this.f3597m;
        notificationMessage.developerArg0 = this.at;
        notificationMessage.notificationChannelId = this.I;
        notificationMessage.isRichPush = this.Y;
        notificationMessage.richType = this.ad;
        notificationMessage._webPagePath = this.ab;
        notificationMessage.showResourceList = this.af;
        notificationMessage.platform = this.ai;
        try {
            notificationMessage.deeplink = this.O;
            notificationMessage.failedAction = this.P;
            notificationMessage.failedLink = this.Q;
            notificationMessage.targetPkgName = this.R;
            notificationMessage.displayForeground = this.J;
            notificationMessage.sspWxAppId = this.U;
            notificationMessage.sspWmOriginId = this.V;
            notificationMessage.sspWmType = this.W;
            notificationMessage.isWmDeepLink = this.X;
            notificationMessage.inAppMsgTitle = this.aD;
            notificationMessage.inAppMsgContentBody = this.aE;
            notificationMessage.inAppMsgType = this.aF;
            notificationMessage.inAppMsgShowType = this.aG;
            notificationMessage.inAppMsgShowPos = this.aH;
            notificationMessage.inAppShowTarget = this.bS;
            notificationMessage.inAppExtras = this.f3601q;
            notificationMessage.inAppClickAction = this.bU;
            if (JPushConstants.SDK_VERSION_CODE < 408) {
                return notificationMessage;
            }
            notificationMessage.notificationNormalSmallIcon = this.N;
            return notificationMessage;
        } catch (Throwable th) {
            Logger.w("PushEntity", "pushEntry toNotificationMessage error" + th.getMessage());
            return notificationMessage;
        }
    }

    public String toString() {
        return "PushEntity{appId='" + this.f3586b + "', senderId='" + this.f3587c + "', messageId='" + this.f3588d + "', jData='" + this.f3591g + "', notificationId=" + this.f3589e + ", messageType=" + this.f3590f + ", overrideMessageId='" + this.f3592h + "', originalMessage='" + this.f3593i + "', messageVersion=" + this.f3594j + ", notificationOnly=" + this.f3595k + ", notificationBuilderId=" + this.f3596l + ", notificationType=" + this.f3597m + ", message='" + this.f3598n + "', contentType='" + this.f3599o + "', title='" + this.f3600p + "', extras='" + this.f3601q + "', type=" + this.f3602r + ", isFullScreen=" + this.f3603s + ", notificationRemoveMode=" + this.f3604t + ", notificationTitle='" + this.f3606v + "', notificationBgColor='" + this.f3605u + "', notificationAppName='" + this.f3608x + "', notificationContent='" + this.f3609y + "', notificationStyle=" + this.f3610z + ", notificationBigText='" + this.A + "', notificationBigPicPath='" + this.B + "', notificationInbox='" + this.C + "', notificationPriority=" + this.D + ", notificationImportance=" + this.E + ", notificationCategory='" + this.F + "', notificationExtra='" + this.G + "', notificationAlertType=" + this.H + ", notificationChannelId='" + this.I + "', displayForeground='" + this.J + "', source='" + this.K + "', smallIcon='" + this.L + "', largeIcon='" + this.M + "', normalSmallIcon='" + this.N + "', deeplink='" + this.O + "', failedAction=" + this.P + ", failedLink='" + this.Q + "', targetPkgName='" + this.R + "', deeplinkBuilderId=" + this.T + ", isRichPush=" + this.Y + ", showUrl='" + this.Z + "', showTitle='" + this.aa + "', _webPagePath='" + this.ab + "', jumpMode=" + this.ac + ", richType=" + this.ad + ", showMode=" + this.ae + ", showResourceList=" + this.af + ", fromNum='" + this.ag + "', toNum='" + this.ah + "', platform=" + ((int) this.ai) + ", badgeAddNum=" + this.aj + ", geofenceid='" + this.ak + "', radius=" + this.al + ", status='" + this.am + "', repeat=" + this.an + ", hasShow=" + this.ao + ", expiration=" + this.ap + ", longitude=" + this.aq + ", latitude=" + this.ar + ", lastGeoStatus='" + this.as + "', developerArg0='" + this.at + "', sound='" + this.au + "', showBeginTime='" + this.av + "', showEndTime='" + this.aw + "', inAppMsgContent='" + this.aC + "', inAppIntent='" + this.aB + ", inAppWebPageUrl = '" + this.be + "', inAppProtocolVer = '" + this.bf + "', inAppSSPGap = '" + this.bp + "', inAppCheckIntent = '" + this.bg + "', inAppTplContent = '" + this.bh + "', inAppTplId = '" + this.bi + "', inAppTplUrl = '" + this.bj + "', inAppMarginY  = '" + this.bk + "', inAppTplData = '" + this.bl + "', inAppIntentActions = '" + this.bm + "', inAppType= '" + this.bt + "', notifyInAppEndTime= '" + this.ax + "', notifyInAppEndTime= '" + this.ay + "', notifyInAppMsgType= '" + this.az + "', inAppPriority= '" + this.bu + "', msgTime= '" + this.bO + "', inAppIsDisplayDirect= '" + this.bv + "', inAppFixed= '" + this.bw + "', inAppBlackConf= '" + this.bx + "', inAppAnimatorConf= '" + this.by + "', inAppAdPosition= '" + this.bz + "', inAppAdPosId= '" + this.bB + "', inAppFragment= '" + this.bA + "', inAppShowCoordinate= '" + this.bC + "', inAppCoordinateType= '" + this.bD + "', inAppWinWidth= '" + this.bE + "', inAppWinHeight= '" + this.bF + "', sequenceId= '" + this.aA + "', swipeDismiss= '" + this.bK + "'}";
    }

    public static d a(Context context, String str, String str2) {
        String str3;
        byte b6;
        d dVar = new d();
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("_jmsgid_");
            dVar.f3588d = optString;
            if (optString.isEmpty()) {
                dVar.f3588d = jSONObject.optString(JThirdPlatFormInterface.KEY_MSG_ID);
            }
            dVar.f3591g = a(dVar.f3588d, jSONObject);
            dVar.ai = (byte) jSONObject.optInt(JThirdPlatFormInterface.KEY_ROM_TYPE);
            int optInt = jSONObject.optInt("show_type", -1);
            JSONObject optJSONObject = jSONObject.optJSONObject("m_content");
            if (optJSONObject != null) {
                dVar.f3609y = optJSONObject.optString("n_content");
                dVar.f3606v = optJSONObject.optString("n_title");
                dVar.f3605u = optJSONObject.optString("n_bg_color");
                dVar.G = optJSONObject.optString("n_extras");
                dVar.I = optJSONObject.optString("n_channel_id");
                dVar.J = optJSONObject.optString("n_display_foreground");
                dVar.H = optJSONObject.optInt("n_alert_type");
                dVar.D = a.a(optJSONObject);
                dVar.E = a.c(optJSONObject);
                dVar.J = optJSONObject.optString("n_display_foreground");
                dVar.au = optJSONObject.optString("n_sound");
                dVar.f3604t = optJSONObject.optInt("n_flag", 1);
                dVar.f3607w = optJSONObject.optJSONArray("n_target_event");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("rich_content");
                if (optJSONObject2 != null) {
                    dVar.Y = true;
                    dVar.a(optJSONObject2);
                    dVar.f3594j = 3;
                } else {
                    dVar.f3594j = 4;
                    dVar.ad = -1;
                }
            } else {
                dVar.f3609y = jSONObject.optString("n_content");
                dVar.f3606v = jSONObject.optString("n_title");
                dVar.f3605u = jSONObject.optString("n_bg_color");
                dVar.f3607w = jSONObject.optJSONArray("n_target_event");
                dVar.G = jSONObject.optString("n_extras");
                dVar.I = jSONObject.optString("n_channel_id");
                dVar.J = jSONObject.optString("n_display_foreground");
                dVar.H = jSONObject.optInt("n_alert_type");
                dVar.D = a.a(jSONObject);
                dVar.E = a.c(jSONObject);
                dVar.J = jSONObject.optString("n_display_foreground");
                dVar.ai = (byte) jSONObject.optInt(JThirdPlatFormInterface.KEY_ROM_TYPE);
                dVar.f3592h = jSONObject.optString("override_msg_id");
                dVar.au = jSONObject.optString("n_sound");
            }
            if (optInt != -1) {
                dVar.f3594j = optInt;
            }
            try {
                dVar.f3602r = 0;
                dVar.f3603s = true;
                dVar.f3586b = context.getPackageName();
                return dVar;
            } catch (Throwable th) {
                th = th;
                Logger.e("PushEntity", "parseContent error:" + th);
                if (TextUtils.isEmpty(dVar.f3588d)) {
                    str3 = "NO MSGID";
                    b6 = 0;
                } else {
                    str3 = dVar.f3588d;
                    b6 = dVar.ai;
                }
                cn.jpush.android.helper.c.a(str3, str2, b6, 996L, context);
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static d b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            d dVar = new d();
            dVar.f3585a = jSONObject.optInt("msgType", -1);
            dVar.f3586b = jSONObject.optString("appId");
            dVar.f3587c = jSONObject.optString("senderId");
            String optString = jSONObject.optString("messageId");
            dVar.f3588d = optString;
            dVar.f3591g = a(optString, jSONObject);
            dVar.f3589e = jSONObject.optInt("notificationId");
            dVar.f3590f = jSONObject.optInt("messageType");
            dVar.f3592h = jSONObject.optString("overrideMessageId");
            dVar.f3593i = jSONObject.optString("originalMessage");
            dVar.f3594j = jSONObject.optInt("messageVersion");
            dVar.f3595k = jSONObject.optBoolean("notificationOnly");
            dVar.f3596l = jSONObject.optInt("notificationBuilderId");
            dVar.f3597m = jSONObject.optInt("notificationType");
            dVar.f3598n = jSONObject.optString(CrashHianalyticsData.MESSAGE);
            dVar.f3599o = jSONObject.optString("contentType");
            dVar.f3600p = jSONObject.optString("title");
            dVar.f3601q = jSONObject.optString("extras");
            dVar.f3602r = jSONObject.optInt("type");
            dVar.f3603s = jSONObject.optBoolean("isFullScreen");
            dVar.f3604t = jSONObject.optInt("notificationRemoveMode");
            dVar.f3606v = jSONObject.optString("notificationTitle");
            dVar.f3605u = jSONObject.optString("notificationBgColor");
            dVar.f3607w = jSONObject.optJSONArray("notificationTargetEvent");
            dVar.f3608x = jSONObject.optString("notificationAppName");
            dVar.f3609y = jSONObject.optString("notificationContent");
            dVar.f3610z = jSONObject.optInt("notificationStyle");
            dVar.A = jSONObject.optString("notificationBigText");
            dVar.B = jSONObject.optString("notificationBigPicPath");
            dVar.C = jSONObject.optString("notificationInbox");
            dVar.D = jSONObject.optInt("notificationPriority");
            dVar.E = jSONObject.optInt("notificationImportance");
            dVar.F = jSONObject.optString("notificationCategory");
            dVar.G = jSONObject.optString("notificationExtra");
            dVar.H = jSONObject.optInt("notificationAlertType");
            dVar.I = jSONObject.optString("notificationChannelId");
            dVar.J = jSONObject.optString("displayForeground");
            dVar.K = jSONObject.optString(SocialConstants.PARAM_SOURCE);
            dVar.L = jSONObject.optString("smallIcon");
            dVar.M = jSONObject.optString("largeIcon");
            dVar.N = jSONObject.optString("normalSmallIcon");
            dVar.O = jSONObject.optString("deeplink");
            dVar.P = jSONObject.optInt("failedAction");
            dVar.Q = jSONObject.optString("failedLink");
            dVar.R = jSONObject.optString("targetPkgName");
            dVar.T = jSONObject.optInt("deeplinkBuilderId");
            dVar.Y = jSONObject.optBoolean("isRichPush");
            dVar.Z = jSONObject.optString("showUrl");
            dVar.aa = jSONObject.optString("showTitle");
            dVar.ab = jSONObject.optString("_webPagePath");
            dVar.ac = jSONObject.optInt("jumpMode");
            dVar.ad = jSONObject.optInt("richType");
            dVar.ae = jSONObject.optInt("showMode");
            try {
                String optString2 = jSONObject.optString("showResourceList");
                if (!TextUtils.isEmpty(optString2)) {
                    dVar.af = new ArrayList<>(Arrays.asList(optString2.split(",")));
                }
            } catch (Throwable th) {
                Logger.e("PushEntity", "showResourceList e:" + th);
            }
            dVar.ag = jSONObject.optString("fromNum");
            dVar.ah = jSONObject.optString("toNum");
            dVar.ai = (byte) jSONObject.optInt("platform");
            if (jSONObject.has("badgeAddNum")) {
                dVar.aj = Integer.valueOf(jSONObject.optInt("badgeAddNum"));
            }
            dVar.ak = jSONObject.optString("geofenceid");
            dVar.al = jSONObject.optLong("radius");
            dVar.am = jSONObject.optString(NotificationCompat.CATEGORY_STATUS);
            dVar.an = jSONObject.optBoolean("repeat");
            dVar.ao = jSONObject.optBoolean("hasShow");
            dVar.ap = jSONObject.optLong("expiration");
            dVar.aq = jSONObject.optDouble("longitude");
            dVar.ar = jSONObject.optDouble("latitude");
            dVar.as = jSONObject.optString("lastGeoStatus");
            dVar.at = jSONObject.optString("developerArg0");
            dVar.au = jSONObject.optString("sound");
            dVar.av = jSONObject.optString("showBeginTime");
            dVar.aw = jSONObject.optString("showEndTime");
            dVar.X = jSONObject.optBoolean("isWmDeepLink");
            dVar.U = jSONObject.optString("wxAppId");
            dVar.V = jSONObject.optString("miniOriginid");
            dVar.W = jSONObject.optInt("miniType");
            dVar.aC = jSONObject.optString("inAppMsgContent");
            dVar.aB = jSONObject.optString("inAppIntent");
            dVar.aD = jSONObject.optString("inAppMsgTitle");
            dVar.aE = jSONObject.optString("inAppMsgContentBody");
            dVar.bS = jSONObject.optString("target");
            dVar.bU = jSONObject.optString("clickAction");
            dVar.f3601q = jSONObject.optString("extras");
            dVar.aF = jSONObject.optInt("inAppMsgType");
            dVar.aG = jSONObject.optInt("inAppMsgShowType");
            dVar.aH = jSONObject.optInt("inAppMsgShowPos");
            dVar.aI = jSONObject.optInt("inAppMsgShowAniAction");
            dVar.bq = jSONObject.optInt("inSupportNotifyAni");
            dVar.br = jSONObject.optInt("inSupportVibration");
            dVar.bs = jSONObject.optString("inAppIcon");
            dVar.aJ = jSONObject.optInt("inAppMsgDismissAniAction");
            dVar.aK = jSONObject.optInt("inAppMsgShowBackground");
            dVar.aL = jSONObject.optInt("inAppMsgAllowIntercept");
            dVar.aM = jSONObject.optInt("inAppMsgFilterMsg");
            dVar.aN = jSONObject.optString("inAppMsgPicPath");
            dVar.aO = jSONObject.optInt("inAppMsgCountLmt");
            dVar.aP = jSONObject.optInt("inAppMsgGap");
            dVar.aQ = jSONObject.optInt("inAppMsgToUser");
            dVar.aR = jSONObject.optInt("inAppMsgDelayDisplayTime");
            dVar.aS = jSONObject.optInt("inAppMsgPageDelayDisplayTime");
            dVar.aT = jSONObject.optInt("inAppMsgReportPageName");
            dVar.aU = jSONObject.optInt("inAppUseSysAlert");
            dVar.aV = jSONObject.optString("inAppMsgBackgroundColor");
            dVar.aW = jSONObject.optString("inAppMsgTitleColor");
            dVar.aX = jSONObject.optString("inAppMsgContentColor");
            dVar.aY = jSONObject.optInt("inAppMsgTitleSize");
            dVar.aZ = jSONObject.optInt("inAppMsgContentSize");
            dVar.ba = jSONObject.optInt("inAppMsgCircularSize");
            dVar.bb = jSONObject.optInt("inAppMsgShowTime");
            dVar.bc = (float) jSONObject.optDouble("inAppMsgShowElapseTime");
            dVar.bd = (float) jSONObject.optDouble("inAppMsgDismissElapseTime");
            dVar.be = jSONObject.optString("inAppWebPageUrl");
            dVar.bf = jSONObject.optInt("inAppProtocolVer");
            dVar.bp = jSONObject.optInt("inAppSSPGap");
            dVar.bg = jSONObject.optInt("inAppCheckIntent");
            dVar.bh = jSONObject.optString("inAppTplContent");
            dVar.bi = jSONObject.optString("inAppTplId");
            dVar.bj = jSONObject.optString("inAppTplUrl");
            dVar.bk = (float) jSONObject.optDouble("inAppMarginY");
            dVar.bl = jSONObject.optString("inAppTplData");
            dVar.bm = jSONObject.optString("inAppIntentActions");
            dVar.bt = jSONObject.optInt("inAppType");
            dVar.bP = jSONObject.optLong("expired");
            dVar.ay = jSONObject.optInt("notifyInAppCacheNumb");
            dVar.az = jSONObject.optInt("notifyInAppMsgType");
            dVar.bu = jSONObject.optInt("inAppPriority");
            dVar.bv = jSONObject.optBoolean("inAppIsDisplayDirect");
            dVar.bx = jSONObject.optString("inAppBlackConf");
            dVar.by = jSONObject.optString("inAppAnimatorConf");
            dVar.bz = jSONObject.optString("inAppAdPosition");
            dVar.bA = jSONObject.optString("inAppFragment");
            dVar.bB = jSONObject.optString("inAppAdPosId");
            dVar.bD = jSONObject.optInt("inAppCoordinateType");
            dVar.bE = jSONObject.optInt("inAppWinWidth");
            dVar.bF = jSONObject.optInt("inAppWinHeight");
            JSONArray optJSONArray = jSONObject.optJSONArray("inAppShowCoordinate");
            dVar.bC = new ArrayList<>();
            if (optJSONArray != null) {
                for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                    dVar.bC.add(Float.valueOf((float) optJSONArray.getDouble(i6)));
                }
            }
            dVar.bG = jSONObject.optInt("inAppPosMsgCountLmt");
            dVar.bH = jSONObject.optInt("inAppPosMsgGap");
            dVar.bI = (float) jSONObject.optDouble("inAppSizeRatio");
            dVar.aA = jSONObject.optString("sequenceId");
            dVar.bw = jSONObject.optBoolean("inAppFixed");
            try {
                String optString3 = jSONObject.optString("inAppShowResList");
                if (!TextUtils.isEmpty(optString3)) {
                    dVar.bn = new ArrayList<>(Arrays.asList(optString3.split(",")));
                }
            } catch (Throwable th2) {
                Logger.e("PushEntity", "inAppShowResList e:" + th2);
            }
            dVar.bJ = jSONObject.optString("unionADExtras");
            dVar.bK = jSONObject.optInt("swipeDismiss");
            dVar.bL = jSONObject.optInt("adSspSvrVer");
            dVar.bM = jSONObject.optInt("inAppMsgStyle");
            dVar.bN = jSONObject.optInt("inAppMsgStyleGap");
            dVar.bS = jSONObject.optString("target");
            dVar.bO = jSONObject.optLong("msgTime");
            dVar.bQ = jSONObject.optInt("delay");
            dVar.bR = jSONObject.optInt(bi.aX);
            return dVar;
        } catch (Throwable th3) {
            Logger.w("PushEntity", "parseJSONString e:" + th3);
            return null;
        }
    }

    public static d a(d dVar) {
        try {
            JSONObject jSONObject = new JSONObject(dVar.f3593i);
            int i6 = jSONObject.getInt("type");
            if (!a(i6)) {
                Logger.ke("PushEntity", "parseInApp not support type=" + i6);
                return null;
            }
            if (jSONObject.has("target")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("target");
                if (optJSONArray.length() > 0) {
                    dVar.bS = optJSONArray.optString(0);
                }
            }
            dVar.bO = System.currentTimeMillis();
            dVar.bQ = jSONObject.getInt("delay");
            dVar.bP = Long.parseLong(jSONObject.getString("expired"));
            dVar.bR = jSONObject.getInt(bi.aX);
            dVar.bu = b(i6);
            dVar.bt = i6;
            dVar.f3601q = jSONObject.optString("extras");
            dVar.f3607w = jSONObject.optJSONArray("target_event");
            if (jSONObject.has("banner")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("banner");
                if (10 == i6) {
                    dVar.bV = jSONObject2.getJSONObject("title");
                    dVar.bW = jSONObject2.getJSONObject("content");
                    dVar.aD = dVar.bV.optString(com.baidu.mobads.sdk.internal.a.f10501b);
                    dVar.aE = dVar.bW.optString(com.baidu.mobads.sdk.internal.a.f10501b);
                }
                if (11 == i6) {
                    String string = jSONObject.getString(SocializeProtocolConstants.IMAGE);
                    if (TextUtils.isEmpty(string)) {
                        Logger.ke("PushEntity", "parseInApp image value is null");
                        return null;
                    }
                    dVar.bT = string;
                }
                if (jSONObject2 != null && jSONObject2.has("duration")) {
                    dVar.bb = jSONObject2.getInt("duration") / 1000;
                }
                if (jSONObject2 != null && jSONObject2.has(SocializeConstants.KEY_LOCATION)) {
                    dVar.aH = jSONObject2.getInt(SocializeConstants.KEY_LOCATION);
                }
            }
            if (jSONObject.has("full")) {
                String string2 = jSONObject.getString(SocializeProtocolConstants.IMAGE);
                if (TextUtils.isEmpty(string2)) {
                    Logger.ke("PushEntity", "parseInApp image value is null");
                    return null;
                }
                dVar.bT = string2;
                JSONObject jSONObject3 = jSONObject.getJSONObject("full");
                if (jSONObject3 != null && jSONObject3.has("duration")) {
                    dVar.bb = jSONObject3.getInt("duration") / 1000;
                }
            }
            if (jSONObject.has(MediationConstant.RIT_TYPE_INTERSTITIAL)) {
                if (21 == i6) {
                    String string3 = jSONObject.getString(SocializeProtocolConstants.IMAGE);
                    if (TextUtils.isEmpty(string3)) {
                        Logger.ke("PushEntity", "parseInApp image value is null");
                        return null;
                    }
                    dVar.bT = string3;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject(MediationConstant.RIT_TYPE_INTERSTITIAL);
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("title");
                if (optJSONObject2 != null) {
                    dVar.aD = optJSONObject2.optString(com.baidu.mobads.sdk.internal.a.f10501b);
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("content");
                if (optJSONObject3 != null) {
                    dVar.aE = optJSONObject3.optString(com.baidu.mobads.sdk.internal.a.f10501b);
                }
            }
            return dVar;
        } catch (Throwable th) {
            Logger.ke("PushEntity", "parseInApp Throwable=" + th);
            return null;
        }
    }

    public static void b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        bY.put(str, str2);
    }

    public static d a(String str, String str2, String str3, long j6) {
        d dVar = null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            d dVar2 = new d();
            try {
                String optString = jSONObject.optString(JThirdPlatFormInterface.KEY_MSG_ID, "");
                if (TextUtils.isEmpty(optString)) {
                    optString = jSONObject.optString(MediationConstant.EXTRA_ADID, "");
                }
                if (TextUtils.isEmpty(optString)) {
                    optString = jSONObject.optString("_jmsgid_", "");
                }
                if (TextUtils.isEmpty(optString)) {
                    optString = j6 + "";
                }
                Logger.d("PushEntity", "preParseOriginalMsgMessage msgId = " + optString);
                dVar2.f3588d = optString;
                dVar2.f3586b = str2;
                dVar2.f3587c = str3;
                dVar2.f3591g = a(optString, jSONObject);
                String optString2 = jSONObject.optString("sequence_id", "");
                dVar2.aA = optString2;
                b(optString, optString2);
                boolean z5 = true;
                if (jSONObject.optInt("n_only", 0) != 1) {
                    z5 = false;
                }
                int optInt = z5 ? jSONObject.optInt("n_builder_id", 0) : 0;
                dVar2.f3595k = z5;
                dVar2.f3596l = optInt;
                dVar2.f3593i = str;
                dVar2.f3594j = jSONObject.optInt("show_type", 3);
                dVar2.ai = (byte) jSONObject.optInt(JThirdPlatFormInterface.KEY_ROM_TYPE);
                dVar2.f3597m = jSONObject.optInt("notificaion_type", 0);
                dVar2.f3592h = jSONObject.optString("override_msg_id", "");
                dVar2.f3598n = jSONObject.optString(CrashHianalyticsData.MESSAGE, "");
                dVar2.f3599o = jSONObject.optString("content_type", "");
                dVar2.f3600p = jSONObject.optString("title", "");
                dVar2.f3601q = jSONObject.optString("extras", "");
                return dVar2;
            } catch (Throwable th) {
                th = th;
                dVar = dVar2;
                Logger.w("PushEntity", "processMessage failed:" + th.getMessage());
                return dVar;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String a(String str, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str) && jSONObject != null) {
            try {
                String optString = jSONObject.optString("_j_data_", "");
                Logger.d("PushEntity", "parse jdata:" + optString);
                a(str, optString);
                return optString;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public void a(Context context) {
        try {
            JSONObject optJSONObject = new JSONObject(this.f3593i).optJSONObject("m_content");
            int optInt = optJSONObject.optInt("ad_t", 0);
            this.f3602r = optInt;
            if (optInt != 0) {
                return;
            }
            this.f3603s = optJSONObject.optInt("full_screen", 0) >= 1;
            this.f3604t = optJSONObject.optInt("n_flag", 1);
            this.f3606v = optJSONObject.optString("n_title", "");
            this.f3605u = optJSONObject.optString("n_bg_color", "");
            this.f3608x = optJSONObject.optString("n_app_name", "");
            this.f3609y = optJSONObject.optString("n_content", "");
            this.f3610z = optJSONObject.optInt("n_style", 0);
            this.A = optJSONObject.optString("n_big_text", "");
            this.B = optJSONObject.optString("n_big_pic_path", "");
            this.C = optJSONObject.optString("n_inbox", "");
            this.G = optJSONObject.optString("n_extras", "");
            this.D = a.a(optJSONObject);
            this.E = a.c(optJSONObject);
            this.F = optJSONObject.optString("n_category", "");
            this.H = optJSONObject.optInt("n_alert_type", -1);
            this.I = optJSONObject.optString("n_channel_id");
            this.J = optJSONObject.optString("n_display_foreground");
            this.L = optJSONObject.optString("n_small_icon", "");
            this.M = optJSONObject.optString("n_large_icon", "");
            this.K = optJSONObject.optString("n_source", "");
            this.N = optJSONObject.optString("n_small_icon_uri", "");
            this.aB = optJSONObject.optString("n_intent");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("n_intent");
            if (optJSONObject2 != null) {
                this.O = optJSONObject2.optString("n_url", "");
                this.P = optJSONObject2.optInt("n_fail_handle_type", 0);
                this.Q = optJSONObject2.optString("n_fail_handle_url", "");
                this.R = optJSONObject2.optString("n_package_name", "");
                this.T = optJSONObject2.optInt("n_builder_id", 0);
                this.U = optJSONObject2.optString("wx_app_id", "");
                this.V = optJSONObject2.optString("mini_originid", "");
                this.W = optJSONObject2.optInt("mini_type", 0);
            }
            if (TextUtils.isEmpty(this.f3606v)) {
                Logger.dd("PushEntity", "Not found notificaiton title for developer mode. Use the application name.");
                this.f3606v = cn.jpush.android.ad.a.b(context);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("ad_content");
            if (!optJSONObject.isNull("ad_content") && optJSONObject3 != null) {
                a(optJSONObject3);
            }
            if (optJSONObject.has("n_badge_add_num")) {
                this.aj = Integer.valueOf(optJSONObject.optInt("n_badge_add_num"));
            } else {
                this.aj = null;
            }
            this.au = optJSONObject.optString("n_sound");
            this.av = optJSONObject.optString("n_show_begin_time");
            this.aw = optJSONObject.optString("n_show_end_time");
            this.f3607w = optJSONObject.optJSONArray("n_target_event");
        } catch (Throwable th) {
            Logger.ww("PushEntity", "parse notification failed:" + th.getMessage());
        }
    }

    public void a(String str) {
        this.bU = str;
    }

    public static void a(String str, String str2) {
        if (bX == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        bX.put(str, str2);
    }

    private void a(JSONObject jSONObject) {
        this.Y = true;
        this.Z = jSONObject.optString("e_url", "").trim();
        this.aa = jSONObject.optString("e_title", "").trim();
        if (!TextUtils.isEmpty(this.Z) && !cn.jpush.android.ad.a.c(this.Z)) {
            this.Z = JPushConstants.HTTPS_PRE + this.Z;
            Logger.i("PushEntity", "Add http to non-prefix url: " + this.Z);
        }
        this.ad = jSONObject.optInt("e_rich_type", 0);
        this.ac = jSONObject.optInt("e_jump_mode", 0);
        this.ae = jSONObject.optInt("e_show", 0);
        int i6 = this.ad;
        if (3 == i6 || 2 == i6 || 1 == i6) {
            this.af = m.a(jSONObject.optJSONArray("e_eres"));
        }
        this.ag = jSONObject.optString("from_num", "");
        this.ah = jSONObject.optString("to_num", "");
    }

    private static boolean a(int i6) {
        return 10 == i6 || 11 == i6 || 20 == i6 || 21 == i6 || 31 == i6 || 30 == i6;
    }
}
