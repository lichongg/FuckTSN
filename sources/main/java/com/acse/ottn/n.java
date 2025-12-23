package com.acse.ottn;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.acse.ottn.io.reactivex.ObservableEmitter;
import com.acse.ottn.io.reactivex.ObservableOnSubscribe;
import com.acse.ottn.io.reactivex.functions.Consumer;
import com.acse.ottn.io.reactivex.schedulers.Schedulers;
import com.acse.ottn.util.HelpShopAppUtil;
import com.alibaba.fastjson.JSON;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class n {

    /* renamed from: c0, reason: collision with root package name */
    public static n f4843c0 = null;

    /* renamed from: d0, reason: collision with root package name */
    public static String f4844d0 = "AppPageNameUtil";

    /* renamed from: a, reason: collision with root package name */
    public boolean f4845a = false;

    /* renamed from: b, reason: collision with root package name */
    public String f4847b = "com.taobao.android.detail.wrapper.activity.DetailActivity";

    /* renamed from: c, reason: collision with root package name */
    public String f4849c = "com.taobao.tao.detail.activity.DetailActivity";

    /* renamed from: d, reason: collision with root package name */
    public String f4850d = "com.taobao.android.tbabilitykit.pop.StdPopActivityGroup";

    /* renamed from: e, reason: collision with root package name */
    public String f4851e = "com.taobao.live.liveshop.detail.DTLiveShopDetailActivity";

    /* renamed from: f, reason: collision with root package name */
    public String f4852f = "com.taobao.android.detail.alittdetail.TTDetailActivity";

    /* renamed from: g, reason: collision with root package name */
    public String f4853g = "com.taobao.homepage.page.MagicWindowActivity";

    /* renamed from: h, reason: collision with root package name */
    public String f4854h = "com.jd.lib.productdetail.ProductDetailActivity";

    /* renamed from: i, reason: collision with root package name */
    public String f4855i = "com.jd.lib.productdetail.ProductDetailPopActivity";

    /* renamed from: j, reason: collision with root package name */
    public String f4856j = "com.tmall.wireless.xdetail.activity.TMXDetailActivity";

    /* renamed from: k, reason: collision with root package name */
    public String f4857k = "com.tmall.wireless.newdetail.activity.NewDetailActivity";

    /* renamed from: l, reason: collision with root package name */
    public String f4858l = "com.sankuai.meituan.takeoutnew";

    /* renamed from: m, reason: collision with root package name */
    public String f4859m = "com.taobao.taobao.fz";

    /* renamed from: n, reason: collision with root package name */
    public String f4860n = "com.xingin.xhs";

    /* renamed from: o, reason: collision with root package name */
    public String f4861o = "com.kuaishou.nebulam";

    /* renamed from: p, reason: collision with root package name */
    public String f4862p = "com.smile.gifmakerm";

    /* renamed from: q, reason: collision with root package name */
    public String f4863q = "com.baidu.netdiskm";

    /* renamed from: r, reason: collision with root package name */
    public String f4864r = "com.huaxiaozhu";

    /* renamed from: s, reason: collision with root package name */
    public String f4865s = "com.yek.android.kfc.activitys";

    /* renamed from: t, reason: collision with root package name */
    public String f4866t = "com.taobao.taobao";

    /* renamed from: u, reason: collision with root package name */
    public String f4867u = "com.tmall.wireless";

    /* renamed from: v, reason: collision with root package name */
    public String f4868v = "com.alipay.video";

    /* renamed from: w, reason: collision with root package name */
    public String f4869w = "com.jingdong.app.mall";

    /* renamed from: x, reason: collision with root package name */
    public String f4870x = "com.jingdong.app.wm";

    /* renamed from: y, reason: collision with root package name */
    public String f4871y = "com.sankuai.meituan.flower";

    /* renamed from: z, reason: collision with root package name */
    public String f4872z = "com.sankuai.meituan.video";
    public String A = "com.sankuai.meituan.medicine";
    public String B = "com.sankuai.meituan.hotel";
    public String C = "com.sina.weibo.main";
    public String D = "com.sankuai.meituan.shop";
    public String E = "com.sankuai.meituan.vegetable";
    public String F = "com.taobao.idlefish.home";
    public String G = "com.taobao.shangou";
    public String H = "com.ss.android.ugc.aweme.mall";
    public String I = "com.ss.android.ugc.awemem";
    public String J = "com.sankuai.meituan";
    public String K = "me.didi";
    public String L = "com.tencent.qqlive";
    public String M = "com.youku.phone";
    public String N = "com.sankuai.waimai.details";
    public String O = "me.ele";
    public String P = "com.acse.xcx";
    public String Q = "com.starbucks.cn";
    public String R = "me.ele.detail";
    public String S = "com.qiyi.video";
    public String T = "com.taobao.tao.main";
    public String U = e0.f4491b;
    public String V = "com.tmall.wireless.main";
    public String W = "com.jingdong.app.mall.main";
    public String X = "com.suning.mobile.main";
    public String Y = "com.ct.client.main";
    public String Z = "com.sinovatech.unicom.main";

    /* renamed from: a0, reason: collision with root package name */
    public String f4846a0 = "com.mc10086.cmcc.main";

    /* renamed from: b0, reason: collision with root package name */
    public String f4848b0 = "com.achievo.vipshop.main";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f4873a;

        public a(Activity activity) {
            this.f4873a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            ClipData primaryClip = ((ClipboardManager) this.f4873a.getSystemService("clipboard")).getPrimaryClip();
            if (primaryClip == null || primaryClip.getItemCount() <= 0) {
                return;
            }
            c2.a("ShopHelpManager", "getFromClipboard text=" + primaryClip.getItemAt(0).getText().toString());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b implements Consumer<List<String>> {
        public b() {
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(List<String> list) throws Exception {
            n.this.a(list);
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer, rx.functions.b
        public /* synthetic */ void call(Object obj) {
            com.acse.ottn.io.reactivex.functions.c.a(this, obj);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class c implements Consumer<Throwable> {
        public c() {
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer, rx.functions.b
        public /* synthetic */ void call(Object obj) {
            com.acse.ottn.io.reactivex.functions.c.a(this, obj);
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class d implements ObservableOnSubscribe<List<String>> {
        @Override // com.acse.ottn.io.reactivex.ObservableOnSubscribe, rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.l) obj);
        }

        public d() {
        }

        @Override // com.acse.ottn.io.reactivex.ObservableOnSubscribe
        public /* synthetic */ void call(rx.l<? super List<String>> lVar) {
            com.acse.ottn.io.reactivex.a.b(this, lVar);
        }

        @Override // com.acse.ottn.io.reactivex.ObservableOnSubscribe
        public void subscribe(ObservableEmitter<List<String>> observableEmitter) throws Exception {
            PackageManager packageManager = HelpShopAppUtil.getContext().getPackageManager();
            List<ApplicationInfo> installedApplications = packageManager.getInstalledApplications(0);
            ArrayList arrayList = new ArrayList();
            for (ApplicationInfo applicationInfo : installedApplications) {
                arrayList.add(packageManager.getApplicationLabel(applicationInfo).toString() + "<---->" + applicationInfo.packageName);
            }
            observableEmitter.onNext(arrayList);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class e implements Consumer<String> {
        public e() {
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(String str) throws Exception {
            c2.a(n.f4844d0, "请求成功 string =" + str);
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer, rx.functions.b
        public /* synthetic */ void call(Object obj) {
            com.acse.ottn.io.reactivex.functions.c.a(this, obj);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class f implements Consumer<Throwable> {
        public f() {
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer, rx.functions.b
        public /* synthetic */ void call(Object obj) {
            com.acse.ottn.io.reactivex.functions.c.a(this, obj);
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
        }
    }

    public static n c() {
        if (f4843c0 == null) {
            synchronized (n.class) {
                try {
                    if (f4843c0 == null) {
                        f4843c0 = new n();
                    }
                } finally {
                }
            }
        }
        return f4843c0;
    }

    public void b() {
        rx.e.j1(new d()).w5(Schedulers.newThread()).I3(h.a()).u5(new b(), new c());
    }

    public final Object d() throws ObjectStreamException {
        return f4843c0;
    }

    public void a(Context context, String str) {
        c2.a("setClipboard", str);
        ((ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, str));
    }

    public final void a(Activity activity) {
        try {
            activity.runOnUiThread(new a(activity));
        } catch (Exception e6) {
            c2.a("ShopHelpManager", "getFromClipboard error");
            e6.printStackTrace();
        }
    }

    public List<String> a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        List<ApplicationInfo> installedApplications = packageManager.getInstalledApplications(0);
        ArrayList arrayList = new ArrayList();
        for (ApplicationInfo applicationInfo : installedApplications) {
            arrayList.add(packageManager.getApplicationLabel(applicationInfo).toString() + "<---->" + applicationInfo.packageName);
        }
        return arrayList;
    }

    public final void a(List<String> list) {
        TreeMap treeMap = new TreeMap();
        treeMap.put(SocializeProtocolConstants.PROTOCOL_KEY_AK, HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionExID());
        if (list != null) {
            treeMap.put("data", JSON.toJSONString(list));
        } else {
            treeMap.put("data", "");
        }
        new g1().d(s0.a().a(treeMap, "")).w5(Schedulers.newThread()).I3(h.a()).u5(new e(), new f());
    }
}
