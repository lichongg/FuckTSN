package com.ss.android.socialbase.downloader.ae;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.bytedance.sdk.component.utils.vl;
import com.huawei.hms.mlsdk.common.MLApplicationSetting;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.ss.android.socialbase.downloader.xt.g;
import com.umeng.analytics.pro.bm;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import master.flame.danmaku.danmaku.parser.b;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class cw implements Parcelable {
    public static final Parcelable.Creator<cw> CREATOR = new Parcelable.Creator<cw>() { // from class: com.ss.android.socialbase.downloader.ae.cw.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public cw createFromParcel(Parcel parcel) {
            return new cw(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public cw[] newArray(int i6) {
            return new cw[i6];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private boolean f38573a;
    private boolean ae;
    private boolean aq;
    private boolean av;
    private boolean az;

    /* renamed from: b, reason: collision with root package name */
    private boolean f38574b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f38575c;
    private String ch;
    private String cw;

    /* renamed from: d, reason: collision with root package name */
    private String f38576d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f38577e;
    private boolean ed;
    private ConcurrentHashMap<String, Object> et;

    /* renamed from: f, reason: collision with root package name */
    private boolean f38578f;
    private AtomicLong ff;
    private JSONObject fx;

    /* renamed from: g, reason: collision with root package name */
    private List<up> f38579g;
    private int gq;
    private String gr;
    private boolean gx;

    /* renamed from: h, reason: collision with root package name */
    private boolean f38580h;
    private String hh;
    private boolean hl;

    /* renamed from: i, reason: collision with root package name */
    private int f38581i;
    private int ik;
    private int im;

    /* renamed from: j, reason: collision with root package name */
    private int f38582j;
    private int jy;

    /* renamed from: k, reason: collision with root package name */
    private int f38583k;
    private String ka;
    private boolean kc;
    private com.ss.android.socialbase.downloader.xt.xt ki;
    private boolean kt;

    /* renamed from: l, reason: collision with root package name */
    private String f38584l;
    private String la;
    private int ll;
    private long ln;

    /* renamed from: m, reason: collision with root package name */
    private String f38585m;
    private List<String> mi;

    /* renamed from: n, reason: collision with root package name */
    private boolean f38586n;
    private JSONObject na;
    private String nd;
    private boolean nt;
    private boolean nu;
    private boolean ol;
    private SoftReference<PackageInfo> om;
    private int oq;
    private int ov;
    private long oy;

    /* renamed from: p, reason: collision with root package name */
    private boolean f38587p;
    private boolean px;
    private boolean pz;

    /* renamed from: q, reason: collision with root package name */
    private boolean f38588q;
    private boolean qa;
    private boolean qb;
    private boolean qe;
    private Boolean qg;
    private boolean qo;
    private String[] qv;

    /* renamed from: r, reason: collision with root package name */
    private String f38589r;
    private String rh;
    private List<String> ri;
    private g rn;
    private long rr;
    private long ry;

    /* renamed from: s, reason: collision with root package name */
    private AtomicLong f38590s;
    private int sm;
    private long st;

    /* renamed from: t, reason: collision with root package name */
    private com.ss.android.socialbase.downloader.xt.ae f38591t;
    private String tj;

    @Deprecated
    private int tk;
    private String tl;

    /* renamed from: u, reason: collision with root package name */
    private AtomicLong f38592u;
    private boolean uc;
    private com.ss.android.socialbase.downloader.xt.j uf;
    private String up;
    private String uq;

    /* renamed from: v, reason: collision with root package name */
    private String f38593v;
    private int[] vl;

    /* renamed from: w, reason: collision with root package name */
    private int f38594w;
    private long wf;
    private com.ss.android.socialbase.downloader.up.j wi;
    private volatile boolean wo;
    private boolean wq;
    private int ws;

    /* renamed from: x, reason: collision with root package name */
    private String f38595x;
    private StringBuffer xp;
    private int xq;
    private String xt;
    private boolean xw;

    /* renamed from: y, reason: collision with root package name */
    private boolean f38596y;
    private String ya;
    private boolean yl;

    /* renamed from: z, reason: collision with root package name */
    private int[] f38597z;
    private long zs;
    private AtomicInteger zz;

    public static class j {

        /* renamed from: a, reason: collision with root package name */
        private String f38598a;
        private String ae;
        private int av;

        /* renamed from: b, reason: collision with root package name */
        private int f38599b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f38600c;
        private String cw;

        /* renamed from: e, reason: collision with root package name */
        private boolean f38601e;
        private boolean ed;

        /* renamed from: f, reason: collision with root package name */
        private boolean f38602f;

        /* renamed from: g, reason: collision with root package name */
        private int f38603g;
        private boolean gq;
        private String gx;

        /* renamed from: h, reason: collision with root package name */
        private boolean f38604h;
        private int[] hl;

        /* renamed from: i, reason: collision with root package name */
        private int f38605i;

        /* renamed from: j, reason: collision with root package name */
        private String f38606j;
        private int jy;

        /* renamed from: l, reason: collision with root package name */
        private String f38607l;
        private String la;

        /* renamed from: m, reason: collision with root package name */
        private boolean f38608m;
        private boolean mi;

        /* renamed from: n, reason: collision with root package name */
        private long f38609n;
        private boolean nd;
        private JSONObject ol;
        private String[] oq;

        /* renamed from: p, reason: collision with root package name */
        private long f38610p;

        /* renamed from: q, reason: collision with root package name */
        private boolean f38611q;
        private long qb;
        private int[] qv;

        /* renamed from: r, reason: collision with root package name */
        private String f38612r;
        private boolean rh;
        private boolean rn;

        /* renamed from: s, reason: collision with root package name */
        private boolean f38613s;
        private String sm;
        private String tj;
        private List<up> tl;
        private boolean uf;
        private String up;

        /* renamed from: v, reason: collision with root package name */
        private boolean f38614v;
        private int vl;

        /* renamed from: w, reason: collision with root package name */
        private List<String> f38615w;
        private boolean ws;

        /* renamed from: x, reason: collision with root package name */
        private boolean f38616x;
        private String xt;
        private boolean ya;

        /* renamed from: z, reason: collision with root package name */
        private String f38617z;
        private boolean az = true;
        private boolean kt = true;
        private boolean ch = true;
        private com.ss.android.socialbase.downloader.xt.ae wq = com.ss.android.socialbase.downloader.xt.ae.ENQUEUE_NONE;
        private boolean hh = true;

        public j() {
        }

        public j ae(String str) {
            this.tj = str;
            return this;
        }

        public j av(boolean z5) {
            this.kt = z5;
            return this;
        }

        public j az(boolean z5) {
            this.ya = z5;
            return this;
        }

        public j cw(String str) {
            this.cw = str;
            return this;
        }

        public j g(String str) {
            this.f38607l = str;
            return this;
        }

        public j j(String str) {
            this.f38606j = str;
            return this;
        }

        public j jy(boolean z5) {
            this.f38600c = z5;
            return this;
        }

        public j m(String str) {
            this.ae = str;
            return this;
        }

        public j oq(String str) {
            this.la = str;
            return this;
        }

        public j qv(boolean z5) {
            this.rn = z5;
            return this;
        }

        public j r(String str) {
            this.sm = str;
            return this;
        }

        public j tl(boolean z5) {
            this.f38613s = z5;
            return this;
        }

        public j up(String str) {
            this.f38612r = str;
            return this;
        }

        public j vl(boolean z5) {
            this.uf = z5;
            return this;
        }

        public j ws(boolean z5) {
            this.hh = z5;
            return this;
        }

        public j xt(String str) {
            this.xt = str;
            return this;
        }

        public j ae(boolean z5) {
            this.ch = z5;
            return this;
        }

        public j cw(int i6) {
            this.av = i6;
            return this;
        }

        public j g(boolean z5) {
            this.f38604h = z5;
            return this;
        }

        public j j(boolean z5) {
            this.f38608m = z5;
            return this;
        }

        public j m(boolean z5) {
            this.f38616x = z5;
            return this;
        }

        public j oq(boolean z5) {
            this.gq = z5;
            return this;
        }

        public j qv(String str) {
            this.f38617z = str;
            return this;
        }

        public j r(int i6) {
            this.f38605i = i6;
            return this;
        }

        public j tl(String str) {
            this.f38598a = str;
            return this;
        }

        public j up(boolean z5) {
            this.f38614v = z5;
            return this;
        }

        public j vl(String str) {
            this.gx = str;
            return this;
        }

        public j xt(int i6) {
            this.jy = i6;
            return this;
        }

        public j cw(boolean z5) {
            this.f38602f = z5;
            return this;
        }

        public j j(List<up> list) {
            this.tl = list;
            return this;
        }

        public j r(boolean z5) {
            this.mi = z5;
            return this;
        }

        public j up(int i6) {
            this.f38599b = i6;
            return this;
        }

        public j xt(boolean z5) {
            this.ws = z5;
            return this;
        }

        public j j(int i6) {
            this.vl = i6;
            return this;
        }

        public j xt(List<String> list) {
            this.f38615w = list;
            return this;
        }

        public j j(long j6) {
            this.f38610p = j6;
            return this;
        }

        public j xt(long j6) {
            this.f38609n = j6;
            return this;
        }

        public j(String str) {
            this.cw = str;
        }

        public j j(com.ss.android.socialbase.downloader.xt.ae aeVar) {
            this.wq = aeVar;
            return this;
        }

        public j j(JSONObject jSONObject) {
            this.ol = jSONObject;
            return this;
        }

        public j j(int[] iArr) {
            this.hl = iArr;
            return this;
        }

        public cw j() {
            return new cw(this);
        }
    }

    private void az(String str) {
        if (TextUtils.isEmpty(str) || i() == -3) {
            return;
        }
        this.f38576d = str;
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                    String optString = jSONArray.optString(i6);
                    if (!TextUtils.isEmpty(optString)) {
                        arrayList.add(optString);
                    }
                }
                this.mi = arrayList;
            }
        } catch (Exception e6) {
            vl.j(e6);
        }
    }

    private void mi(int i6) {
        g gVar = g.DELAY_RETRY_WAITING;
        if (i6 == gVar.ordinal()) {
            this.rn = gVar;
            return;
        }
        g gVar2 = g.DELAY_RETRY_DOWNLOADING;
        if (i6 == gVar2.ordinal()) {
            this.rn = gVar2;
            return;
        }
        g gVar3 = g.DELAY_RETRY_DOWNLOADED;
        if (i6 == gVar3.ordinal()) {
            this.rn = gVar3;
        } else {
            this.rn = g.DELAY_RETRY_NONE;
        }
    }

    private void w(int i6) {
        com.ss.android.socialbase.downloader.xt.ae aeVar = com.ss.android.socialbase.downloader.xt.ae.ENQUEUE_HEAD;
        if (i6 == aeVar.ordinal()) {
            this.f38591t = aeVar;
            return;
        }
        com.ss.android.socialbase.downloader.xt.ae aeVar2 = com.ss.android.socialbase.downloader.xt.ae.ENQUEUE_TAIL;
        if (i6 == aeVar2.ordinal()) {
            this.f38591t = aeVar2;
        } else {
            this.f38591t = com.ss.android.socialbase.downloader.xt.ae.ENQUEUE_NONE;
        }
    }

    public int ae() {
        if (this.f38582j == 0) {
            this.f38582j = com.ss.android.socialbase.downloader.downloader.cw.j(this);
        }
        return this.f38582j;
    }

    public boolean av() {
        return this.f38580h;
    }

    public String cw() {
        return this.uq;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String g() {
        return TextUtils.isEmpty(this.cw) ? this.xt : this.cw;
    }

    public void gr() {
        this.qo = true;
    }

    public int i() {
        AtomicInteger atomicInteger = this.zz;
        if (atomicInteger == null) {
            return 0;
        }
        int i6 = atomicInteger.get();
        if (i6 == -5) {
            return -2;
        }
        return i6;
    }

    public void j(boolean z5) {
        this.qe = z5;
    }

    public String jy() {
        return com.ss.android.socialbase.downloader.az.m.cw(this.xt);
    }

    public int m() {
        return this.im;
    }

    public String oq() {
        return this.f38589r;
    }

    public String qv() {
        return this.up;
    }

    public String r() {
        StringBuffer stringBuffer = this.xp;
        return (stringBuffer == null || stringBuffer.length() == 0) ? "" : this.xp.toString();
    }

    public String tl() {
        return this.xt;
    }

    public ContentValues up() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(bm.f41039d, Integer.valueOf(this.f38582j));
        contentValues.put("url", this.f38589r);
        contentValues.put("savePath", this.up);
        contentValues.put("tempPath", this.f38585m);
        contentValues.put(CommonNetImpl.NAME, this.xt);
        contentValues.put("chunkCount", Integer.valueOf(this.f38583k));
        contentValues.put(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(i()));
        contentValues.put("curBytes", Long.valueOf(uq()));
        contentValues.put("totalBytes", Long.valueOf(this.ry));
        contentValues.put("eTag", this.la);
        contentValues.put("onlyWifi", Integer.valueOf(this.ae ? 1 : 0));
        contentValues.put("force", Integer.valueOf(this.az ? 1 : 0));
        contentValues.put("retryCount", Integer.valueOf(this.jy));
        contentValues.put(JThirdPlatFormInterface.KEY_EXTRA, this.tl);
        contentValues.put("mimeType", this.tj);
        contentValues.put("title", this.cw);
        contentValues.put("notificationEnable", Integer.valueOf(this.kt ? 1 : 0));
        contentValues.put("notificationVisibility", Integer.valueOf(this.xq));
        contentValues.put("isFirstDownload", Integer.valueOf(this.kc ? 1 : 0));
        contentValues.put("isFirstSuccess", Integer.valueOf(this.aq ? 1 : 0));
        contentValues.put("needHttpsToHttpRetry", Integer.valueOf(this.f38578f ? 1 : 0));
        contentValues.put("downloadTime", Long.valueOf(this.rr));
        contentValues.put(MLApplicationSetting.BundleKeyConstants.AppInfo.PACKAGE_NAME, this.f38593v);
        contentValues.put(TKDownloadReason.KSAD_TK_MD5, this.ch);
        contentValues.put("retryDelay", Integer.valueOf(this.f38573a ? 1 : 0));
        contentValues.put("curRetryTime", Integer.valueOf(this.gq));
        contentValues.put("retryDelayStatus", Integer.valueOf(this.rn.ordinal()));
        contentValues.put("defaultHttpServiceBackUp", Integer.valueOf(this.f38587p ? 1 : 0));
        contentValues.put("chunkRunnableReuse", Integer.valueOf(this.f38580h ? 1 : 0));
        contentValues.put("retryDelayTimeArray", this.f38584l);
        contentValues.put("chunkDowngradeRetry", Integer.valueOf(this.px ? 1 : 0));
        contentValues.put("backUpUrlsStr", zi());
        contentValues.put("backUpUrlRetryCount", Integer.valueOf(this.ws));
        contentValues.put("realDownloadTime", Long.valueOf(this.st));
        contentValues.put("retryScheduleMinutes", Integer.valueOf(this.tk));
        contentValues.put("independentProcess", Integer.valueOf(this.gx ? 1 : 0));
        contentValues.put("auxiliaryJsonobjectString", fj());
        contentValues.put("iconUrl", this.nd);
        contentValues.put("appVersionCode", Integer.valueOf(this.ll));
        contentValues.put("taskId", this.rh);
        return contentValues;
    }

    public String vl() {
        return com.ss.android.socialbase.downloader.az.m.xt(this.up, this.f38585m);
    }

    public boolean wi() {
        return false;
    }

    public String ws() {
        return com.ss.android.socialbase.downloader.az.m.j(this.up, this.xt);
    }

    public void xt() {
        this.f38592u.set(SystemClock.uptimeMillis());
    }

    public cw() {
        this.f38587p = true;
        this.rn = g.DELAY_RETRY_NONE;
        this.wq = false;
        this.uf = com.ss.android.socialbase.downloader.xt.j.ASYNC_HANDLE_NONE;
        this.f38586n = true;
        this.ol = true;
        this.hl = false;
        this.f38574b = false;
        this.f38577e = false;
        this.f38583k = 1;
        this.kc = true;
        this.aq = true;
        this.ki = com.ss.android.socialbase.downloader.xt.xt.BYTE_INVALID_RETRY_STATUS_NONE;
        this.f38591t = com.ss.android.socialbase.downloader.xt.ae.ENQUEUE_NONE;
        this.f38592u = new AtomicLong(0L);
        this.qg = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void av(boolean z5) {
        List<String> list = this.ri;
        if (list == null || list.size() <= z5) {
            return;
        }
        List<String> list2 = this.mi;
        if (list2 == null) {
            this.mi = new ArrayList();
        } else {
            list2.clear();
        }
        this.pz = false;
        this.sm = 0;
        for (int i6 = z5; i6 < this.ri.size(); i6++) {
            this.mi.add(this.ri.get(i6));
        }
    }

    private String fj() {
        String jSONObject;
        String str = this.gr;
        if (str != null) {
            return str;
        }
        uo();
        synchronized (this.na) {
            jSONObject = this.na.toString();
            this.gr = jSONObject;
        }
        return jSONObject;
    }

    private void lw() {
        if (this.et == null) {
            synchronized (this) {
                try {
                    if (this.et == null) {
                        this.et = new ConcurrentHashMap<>();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private void nv() {
        if (this.fx == null) {
            Context nd = com.ss.android.socialbase.downloader.downloader.cw.nd();
            if (nd != null) {
                String string = com.bytedance.sdk.openadsdk.api.plugin.xt.xt(nd, "sp_download_info", 0).getString(Long.toString(ae()), "");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        this.fx = new JSONObject(string);
                    } catch (JSONException e6) {
                        vl.j(e6);
                    }
                }
            }
            if (this.fx == null) {
                this.fx = new JSONObject();
            }
        }
    }

    private void ua() {
        j("need_sdk_monitor", Boolean.valueOf(this.ol));
        j("monitor_scene", this.hh);
        try {
            JSONArray jSONArray = new JSONArray();
            int[] iArr = this.f38597z;
            if (iArr != null && iArr.length > 0) {
                int i6 = 0;
                while (true) {
                    int[] iArr2 = this.f38597z;
                    if (i6 >= iArr2.length) {
                        break;
                    }
                    jSONArray.put(iArr2[i6]);
                    i6++;
                }
            }
            j("extra_monitor_status", jSONArray);
        } catch (Throwable th) {
            vl.j(th);
        }
    }

    private void uo() {
        if (this.na == null) {
            synchronized (this) {
                try {
                    if (this.na == null) {
                        if (TextUtils.isEmpty(this.gr)) {
                            this.na = new JSONObject();
                        } else {
                            this.na = new JSONObject(this.gr);
                            this.gr = null;
                        }
                    }
                } catch (Throwable unused) {
                    this.na = new JSONObject();
                } finally {
                }
            }
        }
    }

    private String zi() {
        List<String> list;
        if (this.f38576d == null && (list = this.mi) != null && !list.isEmpty()) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (String str : this.mi) {
                    if (!TextUtils.isEmpty(str)) {
                        jSONArray.put(str);
                    }
                }
                this.f38576d = jSONArray.toString();
            } catch (Exception e6) {
                vl.j(e6);
            }
        }
        if (this.f38576d == null) {
            this.f38576d = "";
        }
        return this.f38576d;
    }

    public boolean aq() {
        return this.ol;
    }

    public void ay() {
        Context nd;
        if (this.fx == null || (nd = com.ss.android.socialbase.downloader.downloader.cw.nd()) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.api.plugin.xt.xt(nd, "sp_download_info", 0).edit().putString(Integer.toString(ae()), this.fx.toString()).apply();
    }

    public int by() {
        int i6 = this.f38594w;
        if (i6 < 1000) {
            return 1000;
        }
        return i6;
    }

    public int c() {
        return this.jy;
    }

    public int cb() {
        return this.ov;
    }

    public void cw(boolean z5) {
        this.uc = z5;
    }

    public boolean d() {
        return this.f38578f;
    }

    public boolean e() {
        return this.nu;
    }

    public int ed() {
        return this.oq;
    }

    public boolean ej() {
        return !TextUtils.isEmpty(this.f38589r) && this.f38589r.startsWith(b.f50155b) && this.f38578f && !this.qa;
    }

    public String et() {
        return this.nd;
    }

    public boolean f() {
        return this.uc;
    }

    public boolean fp() {
        return this.kc;
    }

    public int fs() {
        return this.f38581i;
    }

    public int fx() {
        return this.gq;
    }

    public boolean fz() {
        return (!this.kc || TextUtils.isEmpty(vl()) || TextUtils.isEmpty(jy()) || new File(vl(), jy()).exists()) ? false : true;
    }

    public String gq() {
        return this.f38595x;
    }

    public int gx() {
        return this.ws;
    }

    public String h() {
        return this.tl;
    }

    public boolean hh() {
        return this.pz;
    }

    public com.ss.android.socialbase.downloader.up.j hk() {
        return this.wi;
    }

    public long hu() {
        return this.rr;
    }

    public PackageInfo ij() {
        SoftReference<PackageInfo> softReference = this.om;
        if (softReference == null) {
            return null;
        }
        return softReference.get();
    }

    public com.ss.android.socialbase.downloader.xt.xt ik() {
        return this.ki;
    }

    public boolean im() {
        return this.f38574b;
    }

    public void j(Parcel parcel) {
        this.f38582j = parcel.readInt();
        this.xt = parcel.readString();
        this.cw = parcel.readString();
        this.f38589r = parcel.readString();
        this.up = parcel.readString();
        this.f38585m = parcel.readString();
        this.ae = parcel.readByte() != 0;
        this.tl = parcel.readString();
        this.f38579g = parcel.createTypedArrayList(up.CREATOR);
        this.oq = parcel.readInt();
        this.qv = parcel.createStringArray();
        this.vl = parcel.createIntArray();
        this.jy = parcel.readInt();
        this.ws = parcel.readInt();
        this.az = parcel.readByte() != 0;
        this.av = parcel.readByte() != 0;
        this.f38581i = parcel.readInt();
        this.f38594w = parcel.readInt();
        this.mi = parcel.createStringArrayList();
        this.kt = parcel.readByte() != 0;
        this.tj = parcel.readString();
        this.f38578f = parcel.readByte() != 0;
        this.f38593v = parcel.readString();
        this.ch = parcel.readString();
        this.f38573a = parcel.readByte() != 0;
        this.f38587p = parcel.readByte() != 0;
        this.f38580h = parcel.readByte() != 0;
        this.f38584l = parcel.readString();
        this.la = parcel.readString();
        this.gq = parcel.readInt();
        mi(parcel.readInt());
        this.wq = parcel.readByte() != 0;
        this.qb = parcel.readByte() != 0;
        this.ya = parcel.readString();
        this.sm = parcel.readInt();
        this.xq = parcel.readInt();
        this.f38583k = parcel.readInt();
        up(parcel.readLong());
        this.ry = parcel.readLong();
        r(parcel.readInt());
        this.rr = parcel.readLong();
        this.st = parcel.readLong();
        this.pz = parcel.readByte() != 0;
        this.qa = parcel.readByte() != 0;
        try {
            StringBuffer stringBuffer = this.xp;
            if (stringBuffer == null) {
                this.xp = new StringBuffer(parcel.readString());
            } else {
                stringBuffer.delete(0, stringBuffer.length()).append(parcel.readString());
            }
        } catch (Exception e6) {
            vl.j(e6);
        }
        this.f38596y = parcel.readByte() != 0;
        this.nt = parcel.readByte() != 0;
        this.uc = parcel.readByte() != 0;
        this.ri = parcel.createStringArrayList();
        this.gx = parcel.readByte() != 0;
        w(parcel.readInt());
        this.ed = parcel.readByte() != 0;
        this.ik = parcel.readInt();
        this.ka = parcel.readString();
        this.wo = parcel.readByte() != 0;
        this.qo = parcel.readByte() != 0;
        this.qe = parcel.readByte() != 0;
        this.px = parcel.readByte() != 0;
        this.xw = parcel.readByte() != 0;
        this.wi = (com.ss.android.socialbase.downloader.up.j) parcel.readParcelable(com.ss.android.socialbase.downloader.up.j.class.getClassLoader());
        this.tk = parcel.readInt();
        this.gr = parcel.readString();
        this.f38586n = parcel.readByte() != 0;
        this.nd = parcel.readString();
        this.ll = parcel.readInt();
        this.rh = parcel.readString();
        this.hl = parcel.readByte() != 0;
        this.f38574b = parcel.readByte() != 0;
        this.f38577e = parcel.readByte() != 0;
        mm();
    }

    public List<String> ja() {
        return this.mi;
    }

    public com.ss.android.socialbase.downloader.xt.j jl() {
        return this.uf;
    }

    public void jy(boolean z5) {
        this.qa = z5;
    }

    public long ka() {
        return this.ry;
    }

    public int kj() {
        return this.f38583k;
    }

    public boolean kk() {
        if (this.nu) {
            return qb() && com.ss.android.socialbase.downloader.az.m.xt(com.ss.android.socialbase.downloader.downloader.cw.nd());
        }
        return true;
    }

    public boolean kt() {
        return this.qa;
    }

    public String la() {
        return this.f38593v;
    }

    public int ll() {
        return this.ik;
    }

    public boolean ln() {
        return this.wq;
    }

    public long lv() {
        return this.zs;
    }

    public long lx() {
        return TimeUnit.NANOSECONDS.toMillis(this.st);
    }

    public void m(boolean z5) {
        j("rw_concurrent", Integer.valueOf(z5 ? 1 : 0));
    }

    public boolean mz() {
        return this.yl;
    }

    public int n() {
        int i6 = this.jy;
        List<String> list = this.mi;
        return (list == null || list.isEmpty()) ? i6 : i6 + (this.ws * this.mi.size());
    }

    public boolean na() {
        return this.qo;
    }

    public int nd() {
        int i6 = this.gq;
        if (!this.pz) {
            return i6;
        }
        int i7 = i6 + this.jy;
        int i8 = this.sm;
        return i8 > 0 ? i7 + (i8 * this.ws) : i7;
    }

    public boolean nt() {
        return this.f38575c;
    }

    public String nu() {
        return this.rh;
    }

    public String ol() {
        List<String> list;
        int i6;
        List<String> list2;
        String str = this.f38589r;
        if (i() == 8 && (list2 = this.ri) != null && !list2.isEmpty() && !this.pz) {
            return this.ri.get(0);
        }
        if (!this.pz || (list = this.mi) == null || list.size() <= 0 || (i6 = this.sm) < 0 || i6 >= this.mi.size()) {
            return (!TextUtils.isEmpty(this.f38589r) && this.f38589r.startsWith(b.f50155b) && this.f38578f && this.qa) ? this.f38589r.replaceFirst(b.f50155b, b.f50154a) : str;
        }
        String str2 = this.mi.get(this.sm);
        return !TextUtils.isEmpty(str2) ? str2 : str;
    }

    public void oq(boolean z5) {
        this.aq = z5;
    }

    public boolean os() {
        if (this.pz) {
            this.sm++;
        }
        List<String> list = this.mi;
        if (list != null && list.size() != 0 && this.sm >= 0) {
            while (this.sm < this.mi.size()) {
                if (!TextUtils.isEmpty(this.mi.get(this.sm))) {
                    this.pz = true;
                    return true;
                }
                this.sm++;
            }
        }
        return false;
    }

    public void ot() {
        j(0L, true);
        this.ry = 0L;
        this.f38583k = 1;
        this.rr = 0L;
        this.ln = 0L;
        this.st = 0L;
        this.gq = 0;
        this.kc = true;
        this.aq = true;
        this.pz = false;
        this.qa = false;
        this.la = null;
        this.wi = null;
        this.et = null;
        this.om = null;
    }

    public int ov() {
        return this.ll;
    }

    public boolean oy() {
        boolean z5 = this.f38596y;
        if (!z5 && this.kt) {
            return true;
        }
        if (z5) {
            return this.nt || this.uc;
        }
        return false;
    }

    public void pz() {
        if (this.wf == 0) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis() - this.wf;
        if (this.rr < 0) {
            this.rr = 0L;
        }
        if (uptimeMillis > 0) {
            this.rr = uptimeMillis;
        }
    }

    public void qa() {
        if (this.ln == 0) {
            this.ln = System.nanoTime();
        }
    }

    public boolean qe() {
        if (this.qg == null) {
            if (!TextUtils.isEmpty(this.tl)) {
                try {
                    this.qg = Boolean.valueOf(new JSONObject(this.tl).optBoolean("auto_install_without_notification", false));
                } catch (JSONException unused) {
                }
            }
            this.qg = Boolean.FALSE;
        }
        return this.qg.booleanValue();
    }

    public boolean qg() {
        return this.xw;
    }

    public int qo() {
        return this.xq;
    }

    public void qv(boolean z5) {
        this.f38586n = z5;
    }

    public List<String> rh() {
        return this.ri;
    }

    public boolean ri() {
        return this.az;
    }

    public String rn() {
        return this.ch;
    }

    public String rr() {
        return this.hh;
    }

    public g rs() {
        return this.rn;
    }

    public boolean sf() {
        return this.av;
    }

    public long sh() {
        return this.oy;
    }

    public void so() {
        j(0L, true);
        this.ry = 0L;
        this.f38583k = 1;
        this.rr = 0L;
        this.ln = 0L;
        this.st = 0L;
    }

    public int[] st() {
        return this.f38597z;
    }

    public boolean t() {
        return this.f38577e;
    }

    public boolean tj() {
        return this.f38596y;
    }

    public String tk() {
        return this.f38584l;
    }

    public void tl(boolean z5) {
        this.f38577e = z5;
    }

    public boolean to() {
        int i6;
        List<String> list = this.mi;
        if (list == null || list.size() <= 0) {
            return false;
        }
        return !this.pz || ((i6 = this.sm) >= 0 && i6 < this.mi.size() - 1);
    }

    public String toString() {
        return "DownloadInfo{id=" + this.f38582j + ", name='" + this.xt + "', title='" + this.cw + "', url='" + this.f38589r + "', savePath='" + this.up + "'}";
    }

    public String u() {
        return this.la;
    }

    public boolean uc() {
        return this.qe;
    }

    public List<up> uf() {
        return this.f38579g;
    }

    public long uq() {
        AtomicLong atomicLong = this.ff;
        if (atomicLong != null) {
            return atomicLong.get();
        }
        return 0L;
    }

    public int v() {
        AtomicInteger atomicInteger = this.zz;
        if (atomicInteger != null) {
            return atomicInteger.get();
        }
        return 0;
    }

    public boolean ve() {
        com.ss.android.socialbase.downloader.downloader.vl x5;
        if (this.f38583k > 1 && (x5 = com.ss.android.socialbase.downloader.downloader.cw.x()) != null) {
            List<xt> cw = x5.cw(ae());
            if (cw == null || cw.size() != this.f38583k) {
                return false;
            }
            long j6 = 0;
            for (xt xtVar : cw) {
                if (xtVar != null) {
                    j6 += xtVar.az();
                }
            }
            if (j6 != uq()) {
                up(j6);
            }
        }
        return true;
    }

    public void vl(boolean z5) {
        this.qb = z5;
    }

    public void wf() {
        this.ln = 0L;
    }

    public String wo() {
        return this.ya;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeInt(this.f38582j);
        parcel.writeString(this.xt);
        parcel.writeString(this.cw);
        parcel.writeString(this.f38589r);
        parcel.writeString(this.up);
        parcel.writeString(this.f38585m);
        parcel.writeByte(this.ae ? (byte) 1 : (byte) 0);
        parcel.writeString(this.tl);
        parcel.writeTypedList(this.f38579g);
        parcel.writeInt(this.oq);
        parcel.writeStringArray(this.qv);
        parcel.writeIntArray(this.vl);
        parcel.writeInt(this.jy);
        parcel.writeInt(this.ws);
        parcel.writeByte(this.az ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.av ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f38581i);
        parcel.writeInt(this.f38594w);
        parcel.writeStringList(this.mi);
        parcel.writeByte(this.kt ? (byte) 1 : (byte) 0);
        parcel.writeString(this.tj);
        parcel.writeByte(this.f38578f ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f38593v);
        parcel.writeString(this.ch);
        parcel.writeByte(this.f38573a ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f38587p ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f38580h ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f38584l);
        parcel.writeString(this.la);
        parcel.writeInt(this.gq);
        parcel.writeInt(this.rn.ordinal());
        parcel.writeByte(this.wq ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.qb ? (byte) 1 : (byte) 0);
        parcel.writeString(this.ya);
        parcel.writeInt(this.sm);
        parcel.writeInt(this.xq);
        parcel.writeInt(this.f38583k);
        parcel.writeLong(uq());
        parcel.writeLong(this.ry);
        parcel.writeInt(v());
        parcel.writeLong(this.rr);
        parcel.writeLong(this.st);
        parcel.writeByte(this.pz ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.qa ? (byte) 1 : (byte) 0);
        StringBuffer stringBuffer = this.xp;
        parcel.writeString(stringBuffer != null ? stringBuffer.toString() : "");
        parcel.writeByte(this.f38596y ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.nt ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.uc ? (byte) 1 : (byte) 0);
        parcel.writeStringList(this.ri);
        parcel.writeByte(this.gx ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f38591t.ordinal());
        parcel.writeByte(this.ed ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.ik);
        parcel.writeString(this.ka);
        parcel.writeByte(this.wo ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.qo ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.qe ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.px ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.xw ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.wi, i6);
        parcel.writeInt(this.tk);
        parcel.writeString(fj());
        parcel.writeByte(this.f38586n ? (byte) 1 : (byte) 0);
        parcel.writeString(this.nd);
        parcel.writeInt(this.ll);
        parcel.writeString(this.rh);
        parcel.writeByte(this.hl ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f38574b ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f38577e ? (byte) 1 : (byte) 0);
    }

    public void ws(boolean z5) {
        this.xw = z5;
    }

    public boolean x() {
        return this.ae;
    }

    public boolean xp() {
        return this.gx;
    }

    public void xt(boolean z5) {
        this.f38596y = z5;
    }

    public String xw() {
        return this.tj;
    }

    public boolean y() {
        return this.ed;
    }

    public boolean yl() {
        return this.kt;
    }

    public boolean ym() {
        return this.aq;
    }

    public boolean yu() {
        return TextUtils.isEmpty(this.f38589r) || TextUtils.isEmpty(this.xt) || TextUtils.isEmpty(this.up);
    }

    public boolean zk() {
        return com.ss.android.socialbase.downloader.az.m.xt(this.ry);
    }

    public boolean zs() {
        return this.px;
    }

    private void mm() {
        uo();
        this.ol = this.na.optBoolean("need_sdk_monitor", false);
        this.hh = this.na.optString("monitor_scene", "");
        JSONArray optJSONArray = this.na.optJSONArray("extra_monitor_status");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            this.f38597z = new int[optJSONArray.length()];
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                this.f38597z[i6] = optJSONArray.optInt(i6);
            }
        }
    }

    private int zw() {
        nv();
        try {
            return this.fx.optInt("pause_reserve_on_wifi", 0);
        } catch (Exception unused) {
            return 0;
        }
    }

    public int a() {
        uo();
        return this.na.optInt("ttmd5_check_status", -1);
    }

    public boolean ag() {
        uo();
        return this.na.optBoolean("is_save_path_redirected", false);
    }

    public int b() {
        uo();
        return this.na.optInt("retry_schedule_count", 0);
    }

    public long ch() {
        uo();
        return this.na.optLong("dbjson_key_first_speed_time");
    }

    public void cw(long j6) {
        if (j6 > 0) {
            j("dbjson_key_download_prepare_time", Long.valueOf(p() + j6));
        }
    }

    public boolean dj() {
        if (x() && !com.ss.android.socialbase.downloader.az.m.xt(com.ss.android.socialbase.downloader.downloader.cw.nd())) {
            return false;
        }
        return true;
    }

    public boolean el() {
        if (i() != -3 && this.uf == com.ss.android.socialbase.downloader.xt.j.ASYNC_HANDLE_WAITING) {
            return true;
        }
        return false;
    }

    public long ff() {
        nv();
        try {
            return this.fx.optLong("cache-control/expired_time", -1L);
        } catch (Exception unused) {
            return -1L;
        }
    }

    public boolean fk() {
        if (yu()) {
            return false;
        }
        File file = new File(vl(), jy());
        boolean exists = file.exists();
        boolean isDirectory = file.isDirectory();
        if (exists && !isDirectory) {
            long length = file.length();
            long uq = uq();
            if (com.ss.android.socialbase.downloader.jy.j.cw().j("fix_file_data_valid")) {
                if (uq > 0) {
                    long j6 = this.ry;
                    if (j6 > 0 && this.f38583k > 0 && length >= uq && length <= j6) {
                        return true;
                    }
                }
                com.ss.android.socialbase.downloader.m.j.r("DownloadInfo", "isFileDataValid: cur = " + uq + ",totalBytes =" + this.ry + ",fileLength=" + length);
                return false;
            }
            if (length > 0 && uq > 0) {
                long j7 = this.ry;
                if (j7 > 0 && this.f38583k > 0 && length >= uq && length <= j7 && uq < j7) {
                    return true;
                }
            }
            com.ss.android.socialbase.downloader.m.j.r("DownloadInfo", "isFileDataValid: cur = " + uq + ",totalBytes =" + this.ry + ",fileLength=" + length);
        }
        return false;
    }

    public double gs() {
        double uq = uq() / 1048576.0d;
        double lx = lx() / 1000.0d;
        if (uq > 0.0d && lx > 0.0d) {
            return uq / lx;
        }
        return -1.0d;
    }

    public String hl() {
        uo();
        return this.na.optString("download_setting");
    }

    public boolean hw() {
        return com.ss.android.socialbase.downloader.xt.m.j(i());
    }

    public void i(int i6) {
        nv();
        try {
            this.fx.put("paused_resume_count", i6);
        } catch (Exception e6) {
            vl.j(e6);
        }
    }

    public boolean id() {
        if (i() == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: if, reason: not valid java name */
    public boolean m126if() {
        return com.ss.android.socialbase.downloader.az.m.cw(this);
    }

    public boolean ig() {
        com.ss.android.socialbase.downloader.xt.j jVar;
        int i6 = i();
        if (i6 != 7 && this.rn != g.DELAY_RETRY_WAITING && i6 != 8 && (jVar = this.uf) != com.ss.android.socialbase.downloader.xt.j.ASYNC_HANDLE_WAITING && jVar != com.ss.android.socialbase.downloader.xt.j.ASYNC_HANDLE_RESTART && this.ki != com.ss.android.socialbase.downloader.xt.xt.BYTE_INVALID_RETRY_STATUS_RESTART) {
            return false;
        }
        return true;
    }

    public int jy(String str) {
        nv();
        return this.fx.optInt(str, 0);
    }

    public void k() {
        nv();
        try {
            this.fx.put("pause_reserve_on_wifi", 1);
            ay();
        } catch (Exception unused) {
        }
    }

    public boolean kc() {
        uo();
        if (this.na.optInt("rw_concurrent", 0) != 1) {
            return false;
        }
        return true;
    }

    public boolean ki() {
        if (com.ss.android.socialbase.downloader.jy.j.cw().j("force_close_download_cache_check", 0) == 1) {
            com.ss.android.socialbase.downloader.m.j.cw("isExpiredRedownload force to false, reason(global setting) id=" + ae() + " name=" + tl());
            return false;
        }
        return this.hl;
    }

    public long l() {
        uo();
        if (this.f38590s == null) {
            this.f38590s = new AtomicLong(this.na.optLong("dbjson_key_all_connect_time"));
        }
        return this.f38590s.get();
    }

    public int lc() {
        nv();
        return this.fx.optInt("unins_resume_count", 0);
    }

    public long lg() {
        uo();
        return this.na.optLong("dbjson_last_start_download_time", 0L);
    }

    public int lo() {
        return com.ss.android.socialbase.downloader.az.m.j(qv(), tl(), this.ch);
    }

    public void m(long j6) {
        this.ff.addAndGet(j6);
    }

    public int mp() {
        uo();
        return this.na.optInt("executor_group", 2);
    }

    public boolean o() {
        if (wi() && i() != -3 && this.rn == g.DELAY_RETRY_WAITING) {
            return true;
        }
        return false;
    }

    public void om() {
        this.rh = UUID.randomUUID().toString();
    }

    public void oq(String str) {
        this.tj = str;
    }

    public long p() {
        uo();
        return this.na.optLong("dbjson_key_download_prepare_time");
    }

    public int pm() {
        nv();
        return this.fx.optInt("failed_resume_count", 0);
    }

    public boolean px() {
        uo();
        if (this.na.optInt("auto_install", 1) == 1) {
            return true;
        }
        return false;
    }

    public int q() {
        uo();
        return this.na.optInt("link_mode");
    }

    public boolean qb() {
        if ((zw() & 2) > 0) {
            return true;
        }
        return false;
    }

    public int qf() {
        uo();
        return this.na.optInt("dbjson_key_preconnect_level", 0);
    }

    public void qv(String str) {
        this.ch = str;
    }

    public String ry() {
        nv();
        try {
            return this.fx.optString("cache-control", null);
        } catch (Exception unused) {
            return null;
        }
    }

    public String s() {
        uo();
        return this.na.optString("task_key");
    }

    public boolean sm() {
        if (v() != -2 && v() != -5) {
            return false;
        }
        return true;
    }

    public void tl(String str) {
        this.ya = str;
    }

    public int uh() {
        nv();
        return this.fx.optInt("paused_resume_count", 0);
    }

    public void vl(String str) {
        j(0L, true);
        ae(0L);
        up(str);
        up(1);
        this.rr = 0L;
        this.ln = 0L;
        this.st = 0L;
    }

    public ConcurrentHashMap<String, Object> vm() {
        lw();
        return this.et;
    }

    public boolean vr() {
        int i6 = i();
        if (i6 == 4 || i6 == 3 || i6 == -1 || i6 == 5 || i6 == 8 || ((i6 == 1 || i6 == 2) && uq() > 0)) {
            return true;
        }
        return false;
    }

    public long vu() {
        nv();
        return this.fx.optLong("last_unins_resume_time", 0L);
    }

    public long wq() {
        uo();
        return this.na.optLong("dbjson_key_expect_file_length");
    }

    public void ws(int i6) {
        j("anti_hijack_error_code", Integer.valueOf(i6));
    }

    public long xc() {
        nv();
        return this.fx.optLong("last_failed_resume_time", 0L);
    }

    public boolean xj() {
        if (!fk()) {
            return false;
        }
        return ve();
    }

    public void xq() {
        nv();
        try {
            this.fx.put("pause_reserve_on_wifi", 3);
            ay();
        } catch (Exception unused) {
        }
    }

    public void xt(long j6) {
        if (j6 > 0) {
            l();
            j("dbjson_key_all_connect_time", Long.valueOf(this.f38590s.addAndGet(j6)));
        }
    }

    public boolean ya() {
        if ((zw() & 1) > 0) {
            return true;
        }
        return false;
    }

    public void yb() {
        com.ss.android.socialbase.downloader.xt.j jVar;
        int i6 = i();
        if (i6 == 7 || this.rn == g.DELAY_RETRY_WAITING) {
            j(g.DELAY_RETRY_DOWNLOADING);
        }
        if (i6 == 8 || (jVar = this.uf) == com.ss.android.socialbase.downloader.xt.j.ASYNC_HANDLE_WAITING || jVar == com.ss.android.socialbase.downloader.xt.j.ASYNC_HANDLE_RESTART) {
            j(com.ss.android.socialbase.downloader.xt.j.ASYNC_HANDLE_DOWNLOADING);
        }
        if (this.ki == com.ss.android.socialbase.downloader.xt.xt.BYTE_INVALID_RETRY_STATUS_RESTART) {
            j(com.ss.android.socialbase.downloader.xt.xt.BYTE_INVALID_RETRY_STATUS_DOWNLOADING);
        }
    }

    public void z() {
        this.wf = SystemClock.uptimeMillis();
        j("dbjson_last_start_download_time", Long.valueOf(System.currentTimeMillis()));
    }

    public String zz() {
        nv();
        try {
            return this.fx.optString("last-modified", null);
        } catch (Exception unused) {
            return null;
        }
    }

    public void ae(boolean z5) {
        long nanoTime = System.nanoTime();
        long j6 = this.ln;
        if (j6 <= 0) {
            if (z5) {
                this.ln = nanoTime;
                return;
            }
            return;
        }
        long j7 = nanoTime - j6;
        if (z5) {
            this.ln = nanoTime;
        } else {
            this.ln = 0L;
        }
        if (j7 > 0) {
            this.st += j7;
        }
    }

    public void g(boolean z5) {
        this.kc = z5;
    }

    public void m(String str) {
        this.xt = str;
    }

    public void oq(int i6) {
        this.f38582j = i6;
    }

    public void qv(int i6) {
        nv();
        try {
            this.fx.put("failed_resume_count", i6);
        } catch (Exception e6) {
            vl.j(e6);
        }
    }

    public void r(boolean z5) {
        this.ae = z5;
    }

    public void tl(int i6) {
        this.ll = i6;
    }

    public String ws(String str) {
        uo();
        return this.na.optString(str);
    }

    public void cw(int i6) {
        j("link_mode", Integer.valueOf(i6));
    }

    public void g(String str) {
        this.ka = str;
    }

    public int jy(int i6) {
        uo();
        return this.na.optInt("anti_hijack_error_code", i6);
    }

    public void m(int i6) {
        this.xq = i6;
    }

    public void oq(long j6) {
        nv();
        try {
            this.fx.put("last_unins_resume_time", j6);
        } catch (Exception e6) {
            vl.j(e6);
        }
    }

    public void r(long j6) {
        nv();
        try {
            this.fx.put("cache-control/expired_time", j6);
            ay();
        } catch (Exception unused) {
        }
    }

    public long tl(long j6) {
        int i6 = this.f38581i;
        if (i6 <= 0) {
            i6 = 100;
        }
        long j7 = j6 / (i6 + 1);
        return j7 <= 0 ? PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED : j7;
    }

    public void xt(String str) {
        this.f38595x = str;
    }

    public void cw(String str) {
        nv();
        try {
            this.fx.put("cache-control", str);
            ay();
        } catch (Exception unused) {
        }
    }

    public void g(int i6) {
        int i7 = (this.pz ? this.ws : this.jy) - i6;
        this.gq = i7;
        if (i7 < 0) {
            this.gq = 0;
        }
    }

    public com.ss.android.socialbase.downloader.xt.ae w() {
        return this.f38591t;
    }

    public void xt(int i6) {
        j("retry_schedule_count", Integer.valueOf(i6));
    }

    public void qv(long j6) {
        this.oy = j6;
    }

    public boolean xt(cw cwVar) {
        String str;
        String str2;
        return (cwVar == null || (str = this.f38589r) == null || !str.equals(cwVar.oq()) || (str2 = this.up) == null || !str2.equals(cwVar.qv())) ? false : true;
    }

    public int mi() {
        return this.sm;
    }

    public void r(String str) {
        nv();
        try {
            this.fx.put("last-modified", str);
            ay();
        } catch (Exception unused) {
        }
    }

    public void g(long j6) {
        nv();
        try {
            this.fx.put("last_failed_resume_time", j6);
        } catch (Exception e6) {
            vl.j(e6);
        }
    }

    public void ae(long j6) {
        this.ry = j6;
    }

    public void av(int i6) {
        this.ov = i6;
    }

    public void vl(int i6) {
        nv();
        try {
            this.fx.put("unins_resume_count", i6);
        } catch (Exception e6) {
            vl.j(e6);
        }
    }

    public void ae(String str) {
        this.f38593v = str;
    }

    public void r(int i6) {
        AtomicInteger atomicInteger = this.zz;
        if (atomicInteger != null) {
            atomicInteger.set(i6);
        } else {
            this.zz = new AtomicInteger(i6);
        }
    }

    public void ae(int i6) {
        this.ik = i6;
    }

    public boolean az() {
        return this.f38587p;
    }

    public void az(boolean z5) {
        j("is_save_path_redirected", Boolean.valueOf(z5));
    }

    public void az(int i6) {
        uo();
        j("dbjson_key_preconnect_level", Integer.valueOf(i6));
    }

    private cw(j jVar) {
        this.f38587p = true;
        this.rn = g.DELAY_RETRY_NONE;
        this.wq = false;
        this.uf = com.ss.android.socialbase.downloader.xt.j.ASYNC_HANDLE_NONE;
        this.f38586n = true;
        this.ol = true;
        this.hl = false;
        this.f38574b = false;
        this.f38577e = false;
        this.f38583k = 1;
        this.kc = true;
        this.aq = true;
        this.ki = com.ss.android.socialbase.downloader.xt.xt.BYTE_INVALID_RETRY_STATUS_NONE;
        this.f38591t = com.ss.android.socialbase.downloader.xt.ae.ENQUEUE_NONE;
        this.f38592u = new AtomicLong(0L);
        this.qg = null;
        if (jVar == null) {
            return;
        }
        this.xt = jVar.f38606j;
        this.cw = jVar.xt;
        this.f38589r = jVar.cw;
        String str = jVar.f38612r;
        if (TextUtils.isEmpty(str)) {
            try {
                str = com.ss.android.socialbase.downloader.az.m.up();
            } catch (Throwable th) {
                vl.j(th);
            }
        }
        this.up = str;
        String str2 = jVar.up;
        this.f38585m = str2;
        if (TextUtils.isEmpty(str2) && !com.ss.android.socialbase.downloader.az.m.tl(str)) {
            this.f38585m = com.ss.android.socialbase.downloader.az.m.m();
        }
        j("task_key", (Object) jVar.sm);
        if (jVar.ya) {
            if (com.ss.android.socialbase.downloader.downloader.cw.x().xt(ae()) == null) {
                this.up = com.ss.android.socialbase.downloader.az.m.up(this.up, this.f38589r);
                this.f38585m = com.ss.android.socialbase.downloader.az.m.up(this.f38585m, this.f38589r);
            }
        } else {
            com.ss.android.socialbase.downloader.m.j.up("DownloadInfo", "The distinct directory option is not set, which may cause 1005 problems and file downloads being covered");
        }
        this.zz = new AtomicInteger(0);
        this.ff = new AtomicLong(0L);
        this.tl = jVar.ae;
        this.ae = jVar.f38608m;
        this.f38579g = jVar.tl;
        this.oq = jVar.f38603g;
        this.jy = jVar.vl;
        this.ws = jVar.jy;
        this.az = jVar.ws;
        this.qv = jVar.oq;
        this.vl = jVar.qv;
        this.av = jVar.az;
        this.f38581i = jVar.av;
        this.f38594w = jVar.f38605i;
        this.mi = jVar.f38615w;
        this.kt = jVar.mi;
        this.tj = jVar.tj;
        this.f38578f = jVar.f38602f;
        this.f38573a = jVar.f38604h;
        this.f38584l = jVar.la;
        this.f38596y = jVar.f38614v;
        this.nt = jVar.f38616x;
        this.f38587p = jVar.ch;
        this.f38580h = jVar.f38613s;
        this.f38593v = jVar.f38598a;
        this.ch = jVar.f38607l;
        this.wq = jVar.gq;
        this.gx = jVar.rn;
        this.f38591t = jVar.wq;
        this.ed = jVar.uf;
        this.f38575c = jVar.ed;
        this.qe = jVar.rh;
        this.px = jVar.f38600c;
        this.nd = jVar.gx;
        this.oy = jVar.f38609n;
        this.yl = jVar.nd;
        JSONObject jSONObject = jVar.ol;
        if (jSONObject != null) {
            j("download_setting", (Object) jSONObject.toString());
        }
        j("dbjson_key_expect_file_length", Long.valueOf(jVar.f38610p));
        j("executor_group", Integer.valueOf(jVar.f38599b));
        j("auto_install", Integer.valueOf(jVar.kt ? 1 : 0));
        this.ol = jVar.hh;
        this.hh = jVar.f38617z;
        this.f38597z = jVar.hl;
        this.hl = jVar.f38601e;
        this.f38574b = jVar.f38611q;
        this.zs = jVar.qb;
        this.f38588q = jVar.ya;
        if (this.hl && this.jy <= 0) {
            this.jy = 1;
        }
        ua();
    }

    public void up(boolean z5) {
        this.nu = z5;
    }

    public void up(long j6) {
        AtomicLong atomicLong = this.ff;
        if (atomicLong != null) {
            atomicLong.set(j6);
        } else {
            this.ff = new AtomicLong(j6);
        }
    }

    public void up(String str) {
        this.la = str;
    }

    public void up(int i6) {
        this.f38583k = i6;
    }

    public boolean j() {
        long j6 = this.f38592u.get();
        return j6 == 0 || SystemClock.uptimeMillis() - j6 > 20;
    }

    public void j(String str) {
        this.uq = str;
    }

    public void j(SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement == null) {
            return;
        }
        this.im = 0;
        sQLiteStatement.clearBindings();
        int i6 = this.im + 1;
        this.im = i6;
        sQLiteStatement.bindLong(i6, this.f38582j);
        int i7 = this.im + 1;
        this.im = i7;
        String str = this.f38589r;
        if (str == null) {
            str = "";
        }
        sQLiteStatement.bindString(i7, str);
        int i8 = this.im + 1;
        this.im = i8;
        String str2 = this.up;
        if (str2 == null) {
            str2 = "";
        }
        sQLiteStatement.bindString(i8, str2);
        int i9 = this.im + 1;
        this.im = i9;
        String str3 = this.f38585m;
        if (str3 == null) {
            str3 = "";
        }
        sQLiteStatement.bindString(i9, str3);
        int i10 = this.im + 1;
        this.im = i10;
        String str4 = this.xt;
        if (str4 == null) {
            str4 = "";
        }
        sQLiteStatement.bindString(i10, str4);
        int i11 = this.im + 1;
        this.im = i11;
        sQLiteStatement.bindLong(i11, this.f38583k);
        int i12 = this.im + 1;
        this.im = i12;
        sQLiteStatement.bindLong(i12, i());
        int i13 = this.im + 1;
        this.im = i13;
        sQLiteStatement.bindLong(i13, uq());
        int i14 = this.im + 1;
        this.im = i14;
        sQLiteStatement.bindLong(i14, this.ry);
        int i15 = this.im + 1;
        this.im = i15;
        String str5 = this.la;
        if (str5 == null) {
            str5 = "";
        }
        sQLiteStatement.bindString(i15, str5);
        int i16 = this.im + 1;
        this.im = i16;
        sQLiteStatement.bindLong(i16, this.ae ? 1L : 0L);
        int i17 = this.im + 1;
        this.im = i17;
        sQLiteStatement.bindLong(i17, this.az ? 1L : 0L);
        int i18 = this.im + 1;
        this.im = i18;
        sQLiteStatement.bindLong(i18, this.jy);
        int i19 = this.im + 1;
        this.im = i19;
        String str6 = this.tl;
        if (str6 == null) {
            str6 = "";
        }
        sQLiteStatement.bindString(i19, str6);
        int i20 = this.im + 1;
        this.im = i20;
        String str7 = this.tj;
        if (str7 == null) {
            str7 = "";
        }
        sQLiteStatement.bindString(i20, str7);
        int i21 = this.im + 1;
        this.im = i21;
        String str8 = this.cw;
        if (str8 == null) {
            str8 = "";
        }
        sQLiteStatement.bindString(i21, str8);
        int i22 = this.im + 1;
        this.im = i22;
        sQLiteStatement.bindLong(i22, this.kt ? 1L : 0L);
        int i23 = this.im + 1;
        this.im = i23;
        sQLiteStatement.bindLong(i23, this.xq);
        int i24 = this.im + 1;
        this.im = i24;
        sQLiteStatement.bindLong(i24, this.kc ? 1L : 0L);
        int i25 = this.im + 1;
        this.im = i25;
        sQLiteStatement.bindLong(i25, this.aq ? 1L : 0L);
        int i26 = this.im + 1;
        this.im = i26;
        sQLiteStatement.bindLong(i26, this.f38578f ? 1L : 0L);
        int i27 = this.im + 1;
        this.im = i27;
        sQLiteStatement.bindLong(i27, this.rr);
        int i28 = this.im + 1;
        this.im = i28;
        String str9 = this.f38593v;
        if (str9 == null) {
            str9 = "";
        }
        sQLiteStatement.bindString(i28, str9);
        int i29 = this.im + 1;
        this.im = i29;
        String str10 = this.ch;
        if (str10 == null) {
            str10 = "";
        }
        sQLiteStatement.bindString(i29, str10);
        int i30 = this.im + 1;
        this.im = i30;
        sQLiteStatement.bindLong(i30, this.f38573a ? 1L : 0L);
        int i31 = this.im + 1;
        this.im = i31;
        sQLiteStatement.bindLong(i31, this.gq);
        int i32 = this.im + 1;
        this.im = i32;
        sQLiteStatement.bindLong(i32, this.rn.ordinal());
        int i33 = this.im + 1;
        this.im = i33;
        sQLiteStatement.bindLong(i33, this.f38587p ? 1L : 0L);
        int i34 = this.im + 1;
        this.im = i34;
        sQLiteStatement.bindLong(i34, this.f38580h ? 1L : 0L);
        int i35 = this.im + 1;
        this.im = i35;
        String str11 = this.f38584l;
        if (str11 == null) {
            str11 = "";
        }
        sQLiteStatement.bindString(i35, str11);
        int i36 = this.im + 1;
        this.im = i36;
        sQLiteStatement.bindLong(i36, this.px ? 1L : 0L);
        int i37 = this.im + 1;
        this.im = i37;
        sQLiteStatement.bindString(i37, zi());
        int i38 = this.im + 1;
        this.im = i38;
        sQLiteStatement.bindLong(i38, this.ws);
        int i39 = this.im + 1;
        this.im = i39;
        sQLiteStatement.bindLong(i39, this.st);
        int i40 = this.im + 1;
        this.im = i40;
        sQLiteStatement.bindLong(i40, this.tk);
        int i41 = this.im + 1;
        this.im = i41;
        sQLiteStatement.bindLong(i41, this.gx ? 1L : 0L);
        int i42 = this.im + 1;
        this.im = i42;
        sQLiteStatement.bindString(i42, fj());
        int i43 = this.im + 1;
        this.im = i43;
        String str12 = this.nd;
        if (str12 == null) {
            str12 = "";
        }
        sQLiteStatement.bindString(i43, str12);
        int i44 = this.im + 1;
        this.im = i44;
        sQLiteStatement.bindLong(i44, this.ll);
        int i45 = this.im + 1;
        this.im = i45;
        String str13 = this.rh;
        sQLiteStatement.bindString(i45, str13 != null ? str13 : "");
    }

    protected cw(Parcel parcel) {
        this.f38587p = true;
        this.rn = g.DELAY_RETRY_NONE;
        this.wq = false;
        this.uf = com.ss.android.socialbase.downloader.xt.j.ASYNC_HANDLE_NONE;
        this.f38586n = true;
        this.ol = true;
        this.hl = false;
        this.f38574b = false;
        this.f38577e = false;
        this.f38583k = 1;
        this.kc = true;
        this.aq = true;
        this.ki = com.ss.android.socialbase.downloader.xt.xt.BYTE_INVALID_RETRY_STATUS_NONE;
        this.f38591t = com.ss.android.socialbase.downloader.xt.ae.ENQUEUE_NONE;
        this.f38592u = new AtomicLong(0L);
        this.qg = null;
        j(parcel);
    }

    public void j(long j6) {
        j("dbjson_key_first_speed_time", Long.valueOf(j6));
    }

    public void j(int i6) {
        j("ttmd5_check_status", Integer.valueOf(i6));
    }

    public cw(Cursor cursor) {
        boolean z5 = true;
        this.f38587p = true;
        g gVar = g.DELAY_RETRY_NONE;
        this.rn = gVar;
        this.wq = false;
        this.uf = com.ss.android.socialbase.downloader.xt.j.ASYNC_HANDLE_NONE;
        this.f38586n = true;
        this.ol = true;
        this.hl = false;
        this.f38574b = false;
        this.f38577e = false;
        this.f38583k = 1;
        this.kc = true;
        this.aq = true;
        this.ki = com.ss.android.socialbase.downloader.xt.xt.BYTE_INVALID_RETRY_STATUS_NONE;
        this.f38591t = com.ss.android.socialbase.downloader.xt.ae.ENQUEUE_NONE;
        this.f38592u = new AtomicLong(0L);
        this.qg = null;
        if (cursor == null) {
            return;
        }
        try {
            int columnIndex = cursor.getColumnIndex(bm.f41039d);
            if (columnIndex != -1) {
                this.f38582j = cursor.getInt(columnIndex);
            }
            int columnIndex2 = cursor.getColumnIndex(CommonNetImpl.NAME);
            if (columnIndex2 != -1) {
                this.xt = cursor.getString(columnIndex2);
            }
            int columnIndex3 = cursor.getColumnIndex("title");
            if (columnIndex3 != -1) {
                this.cw = cursor.getString(columnIndex3);
            }
            int columnIndex4 = cursor.getColumnIndex("url");
            if (columnIndex4 != -1) {
                this.f38589r = cursor.getString(columnIndex4);
            }
            int columnIndex5 = cursor.getColumnIndex("savePath");
            if (columnIndex5 != -1) {
                this.up = cursor.getString(columnIndex5);
            }
            int columnIndex6 = cursor.getColumnIndex("tempPath");
            if (columnIndex6 != -1) {
                this.f38585m = cursor.getString(columnIndex6);
            }
            int columnIndex7 = cursor.getColumnIndex("chunkCount");
            if (columnIndex7 != -1) {
                this.f38583k = cursor.getInt(columnIndex7);
            }
            int columnIndex8 = cursor.getColumnIndex(NotificationCompat.CATEGORY_STATUS);
            if (columnIndex8 != -1) {
                this.zz = new AtomicInteger(cursor.getInt(columnIndex8));
            } else {
                this.zz = new AtomicInteger(0);
            }
            int columnIndex9 = cursor.getColumnIndex("curBytes");
            if (columnIndex9 != -1) {
                this.ff = new AtomicLong(cursor.getLong(columnIndex9));
            } else {
                this.ff = new AtomicLong(0L);
            }
            int columnIndex10 = cursor.getColumnIndex("totalBytes");
            if (columnIndex10 != -1) {
                this.ry = cursor.getLong(columnIndex10);
            }
            int columnIndex11 = cursor.getColumnIndex("eTag");
            if (columnIndex11 != -1) {
                this.la = cursor.getString(columnIndex11);
            }
            int columnIndex12 = cursor.getColumnIndex("onlyWifi");
            if (columnIndex12 != -1) {
                this.ae = cursor.getInt(columnIndex12) != 0;
            }
            int columnIndex13 = cursor.getColumnIndex("force");
            if (columnIndex13 != -1) {
                this.az = cursor.getInt(columnIndex13) != 0;
            }
            int columnIndex14 = cursor.getColumnIndex("retryCount");
            if (columnIndex14 != -1) {
                this.jy = cursor.getInt(columnIndex14);
            }
            int columnIndex15 = cursor.getColumnIndex(JThirdPlatFormInterface.KEY_EXTRA);
            if (columnIndex15 != -1) {
                this.tl = cursor.getString(columnIndex15);
            }
            int columnIndex16 = cursor.getColumnIndex("mimeType");
            if (columnIndex16 != -1) {
                this.tj = cursor.getString(columnIndex16);
            }
            int columnIndex17 = cursor.getColumnIndex("notificationEnable");
            if (columnIndex17 != -1) {
                this.kt = cursor.getInt(columnIndex17) != 0;
            }
            int columnIndex18 = cursor.getColumnIndex("notificationVisibility");
            if (columnIndex18 != -1) {
                this.xq = cursor.getInt(columnIndex18);
            }
            int columnIndex19 = cursor.getColumnIndex("isFirstDownload");
            if (columnIndex19 != -1) {
                this.kc = cursor.getInt(columnIndex19) == 1;
            }
            int columnIndex20 = cursor.getColumnIndex("isFirstSuccess");
            if (columnIndex20 != -1) {
                this.aq = cursor.getInt(columnIndex20) == 1;
            }
            int columnIndex21 = cursor.getColumnIndex("needHttpsToHttpRetry");
            if (columnIndex21 != -1) {
                this.f38578f = cursor.getInt(columnIndex21) == 1;
            }
            int columnIndex22 = cursor.getColumnIndex("downloadTime");
            if (columnIndex22 != -1) {
                this.rr = cursor.getLong(columnIndex22);
            }
            int columnIndex23 = cursor.getColumnIndex(MLApplicationSetting.BundleKeyConstants.AppInfo.PACKAGE_NAME);
            if (columnIndex23 != -1) {
                this.f38593v = cursor.getString(columnIndex23);
            }
            int columnIndex24 = cursor.getColumnIndex(TKDownloadReason.KSAD_TK_MD5);
            if (columnIndex24 != -1) {
                this.ch = cursor.getString(columnIndex24);
            }
            int columnIndex25 = cursor.getColumnIndex("retryDelay");
            if (columnIndex25 != -1) {
                this.f38573a = cursor.getInt(columnIndex25) == 1;
            }
            int columnIndex26 = cursor.getColumnIndex("curRetryTime");
            if (columnIndex26 != -1) {
                this.gq = cursor.getInt(columnIndex26);
            }
            int columnIndex27 = cursor.getColumnIndex("retryDelayStatus");
            if (columnIndex27 != -1) {
                int i6 = cursor.getInt(columnIndex27);
                g gVar2 = g.DELAY_RETRY_WAITING;
                if (i6 == gVar2.ordinal()) {
                    this.rn = gVar2;
                } else {
                    g gVar3 = g.DELAY_RETRY_DOWNLOADING;
                    if (i6 == gVar3.ordinal()) {
                        this.rn = gVar3;
                    } else {
                        g gVar4 = g.DELAY_RETRY_DOWNLOADED;
                        if (i6 == gVar4.ordinal()) {
                            this.rn = gVar4;
                        } else {
                            this.rn = gVar;
                        }
                    }
                }
            }
            int columnIndex28 = cursor.getColumnIndex("defaultHttpServiceBackUp");
            if (columnIndex28 != -1) {
                this.f38587p = cursor.getInt(columnIndex28) == 1;
            }
            int columnIndex29 = cursor.getColumnIndex("chunkRunnableReuse");
            if (columnIndex29 != -1) {
                this.f38580h = cursor.getInt(columnIndex29) == 1;
            }
            int columnIndex30 = cursor.getColumnIndex("retryDelayTimeArray");
            if (columnIndex30 != -1) {
                this.f38584l = cursor.getString(columnIndex30);
            }
            int columnIndex31 = cursor.getColumnIndex("chunkDowngradeRetry");
            if (columnIndex31 != -1) {
                this.px = cursor.getInt(columnIndex31) == 1;
            }
            int columnIndex32 = cursor.getColumnIndex("backUpUrlsStr");
            if (columnIndex32 != -1) {
                az(cursor.getString(columnIndex32));
            }
            int columnIndex33 = cursor.getColumnIndex("backUpUrlRetryCount");
            if (columnIndex33 != -1) {
                this.ws = cursor.getInt(columnIndex33);
            }
            int columnIndex34 = cursor.getColumnIndex("realDownloadTime");
            if (columnIndex34 != -1) {
                this.st = cursor.getLong(columnIndex34);
            }
            int columnIndex35 = cursor.getColumnIndex("retryScheduleMinutes");
            if (columnIndex35 != -1) {
                this.tk = cursor.getInt(columnIndex35);
            }
            int columnIndex36 = cursor.getColumnIndex("independentProcess");
            if (columnIndex36 != -1) {
                if (cursor.getInt(columnIndex36) != 1) {
                    z5 = false;
                }
                this.gx = z5;
            }
            int columnIndex37 = cursor.getColumnIndex("auxiliaryJsonobjectString");
            if (columnIndex37 != -1) {
                this.gr = cursor.getString(columnIndex37);
            }
            int columnIndex38 = cursor.getColumnIndex("iconUrl");
            if (columnIndex38 != -1) {
                this.nd = cursor.getString(columnIndex38);
            }
            int columnIndex39 = cursor.getColumnIndex("appVersionCode");
            if (columnIndex39 != -1) {
                this.ll = cursor.getInt(columnIndex39);
            }
            int columnIndex40 = cursor.getColumnIndex("taskId");
            if (columnIndex40 != -1) {
                this.rh = cursor.getString(columnIndex40);
            }
            mm();
        } catch (Exception e6) {
            vl.j(e6);
        }
    }

    public void j(List<String> list, boolean z5) {
        this.ri = list;
        av(z5);
    }

    public void j(String str, Object obj) {
        uo();
        synchronized (this.na) {
            try {
                this.na.put(str, obj);
            } catch (Exception unused) {
            }
            this.gr = null;
        }
    }

    public void j(long j6, boolean z5) {
        if (z5) {
            up(j6);
        } else if (j6 > uq()) {
            up(j6);
        }
    }

    public void j(com.ss.android.socialbase.downloader.xt.xt xtVar) {
        this.ki = xtVar;
    }

    public void j(g gVar) {
        this.rn = gVar;
    }

    public void j(com.ss.android.socialbase.downloader.xt.j jVar) {
        this.uf = jVar;
    }

    public void j(cw cwVar, boolean z5) {
        if (cwVar == null) {
            return;
        }
        up(cwVar.kj());
        ae(cwVar.ka());
        j(cwVar.uq(), true);
        this.st = cwVar.st;
        if (!cwVar.ig() && !ig()) {
            this.gq = 0;
            this.qo = false;
            this.pz = false;
            this.sm = 0;
            this.qa = false;
        } else {
            this.gq = cwVar.fx();
        }
        up(cwVar.u());
        if (z5) {
            r(cwVar.i());
        }
        this.kc = cwVar.fp();
        this.aq = cwVar.ym();
        this.rn = cwVar.rs();
        j(cwVar.na);
    }

    public void j(cw cwVar) {
        if (cwVar == null) {
            return;
        }
        this.rh = cwVar.nu();
    }

    private void j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        uo();
        synchronized (this.na) {
            try {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    Object opt = jSONObject.opt(next);
                    if (!this.na.has(next) && opt != null) {
                        this.na.put(next, opt);
                    }
                }
            } catch (Exception unused) {
            }
            this.gr = null;
        }
        mm();
    }

    public void j(com.ss.android.socialbase.downloader.up.j jVar) {
        this.wi = jVar;
    }

    public void j(String str, String str2) {
        nv();
        try {
            this.fx.put(str, str2);
            ay();
        } catch (Exception e6) {
            vl.j(e6);
        }
    }

    public void j(PackageInfo packageInfo) {
        this.om = new SoftReference<>(packageInfo);
    }
}
