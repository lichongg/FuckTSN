package com.acse.ottn;

import android.accessibilityservice.AccessibilityService;
import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityNodeInfo;
import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.io.reactivex.functions.Consumer;
import com.acse.ottn.io.reactivex.schedulers.Schedulers;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.util.HelpShopAppUtil;
import com.alibaba.fastjson.JSON;
import com.tencent.connect.common.Constants;
import com.umeng.analytics.pro.bi;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class z3 {

    /* renamed from: c, reason: collision with root package name */
    public static z3 f5561c = null;

    /* renamed from: d, reason: collision with root package name */
    public static String f5562d = "ScrolledReadUtil";

    /* renamed from: e, reason: collision with root package name */
    public static String f5563e = "";

    /* renamed from: a, reason: collision with root package name */
    public List<String> f5564a;

    /* renamed from: b, reason: collision with root package name */
    public int f5565b = 0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements Consumer<AccessiblityModel> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f5566a;

        public a(String str) {
            this.f5566a = str;
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(AccessiblityModel accessiblityModel) throws Exception {
            c2.a(z3.f5562d, "请求成功 string =" + accessiblityModel.toString());
            if (1 == accessiblityModel.getR()) {
                d.d().a(accessiblityModel, this.f5566a);
            }
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer, rx.functions.b
        public /* synthetic */ void call(Object obj) {
            com.acse.ottn.io.reactivex.functions.c.a(this, obj);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b implements Consumer<Throwable> {
        public b() {
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            c2.b(z3.f5562d, "报错了=" + th.getMessage());
            if (z3.this.f5564a != null) {
                z3.this.f5564a.removeAll(z3.this.f5564a);
            }
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer, rx.functions.b
        public /* synthetic */ void call(Object obj) {
            com.acse.ottn.io.reactivex.functions.c.a(this, obj);
        }
    }

    public static z3 c() {
        if (f5561c == null) {
            synchronized (z3.class) {
                try {
                    if (f5561c == null) {
                        f5561c = new z3();
                    }
                } finally {
                }
            }
        }
        return f5561c;
    }

    public final Object d() throws ObjectStreamException {
        return f5561c;
    }

    public void a(AccessibilityService accessibilityService) {
        if (TextUtils.isEmpty(f5563e)) {
            return;
        }
        if (f5563e.equals(n.c().f4847b) || f5563e.equals(n.c().f4849c) || f5563e.equals(n.c().f4850d) || f5563e.equals(n.c().f4851e) || f5563e.equals(n.c().f4852f) || f5563e.equals(n.c().f4857k) || f5563e.equals(n.c().f4856j) || f5563e.equals(n.c().f4855i) || f5563e.equals(n.c().f4854h)) {
            if (j3.a() == null) {
                new AcseHelpManager.InitSdk().setContext(accessibilityService.getApplication()).build();
            }
            String e6 = j3.a().e("scroll_state");
            c2.a(f5562d, "CommonUtil.SCROLLED_SCREEN_START=" + e6);
            if (e6.equals(k0.f4681q) && b()) {
                String str = n.c().f4866t;
                if (!f5563e.equals(n.c().f4854h) && !f5563e.equals(n.c().f4855i)) {
                    if (f5563e.equals(n.c().f4857k) || f5563e.equals(n.c().f4856j)) {
                        str = n.c().f4867u;
                    }
                } else {
                    str = n.c().f4869w;
                }
                List<String> list = this.f5564a;
                if (list != null) {
                    list.removeAll(list);
                    this.f5564a.clear();
                }
                try {
                    this.f5564a = new ArrayList();
                    a(accessibilityService.getRootInActiveWindow());
                    if (a(this.f5564a)) {
                        j3.a().b("scroll_state", k0.f4680p);
                        a(accessibilityService, this.f5564a, str, str + com.kuaishou.weapon.p0.t.f36152m);
                    }
                } catch (Throwable th) {
                    List<String> list2 = this.f5564a;
                    if (list2 != null) {
                        list2.removeAll(list2);
                        this.f5565b = 0;
                        this.f5564a = new ArrayList();
                        j3.a().b("scroll_state", "0");
                    }
                    c2.a(f5562d, th.getMessage());
                }
            }
        }
    }

    public final boolean b() {
        long d6 = j3.a().d("scrolled_screen_time");
        c2.b(f5562d, "controlCouponShow appPageName =" + (System.currentTimeMillis() - d6));
        if (System.currentTimeMillis() - d6 < 1000) {
            c2.a(f5562d, "controlCouponShow return false ");
            return false;
        }
        j3.a().a("scrolled_screen_time", System.currentTimeMillis());
        c2.a(f5562d, "controlCouponShow return true");
        return true;
    }

    @SuppressLint({"NewApi"})
    public void a(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null || accessibilityNodeInfo.getChildCount() != 0) {
            if (accessibilityNodeInfo != null) {
                for (int i6 = 0; i6 < accessibilityNodeInfo.getChildCount(); i6++) {
                    try {
                        if (accessibilityNodeInfo.getChild(i6) != null) {
                            a(accessibilityNodeInfo.getChild(i6));
                        }
                    } catch (Throwable th) {
                        j3.a().b("scroll_state", "0");
                        c2.a("ScrolledReadUtil", th.getMessage());
                        return;
                    }
                }
                return;
            }
            return;
        }
        if (accessibilityNodeInfo.getText() != null) {
            String trim = accessibilityNodeInfo.getText().toString().trim();
            if (trim.length() >= 25 || trim.length() <= 2) {
                return;
            }
            this.f5565b = s0.a().a(trim, this.f5565b);
            if (s0.a().a(this.f5565b) && this.f5564a.size() < 100) {
                this.f5564a.add(trim);
                return;
            }
            List<String> list = this.f5564a;
            if (list != null) {
                list.removeAll(list);
                this.f5564a.clear();
                this.f5565b = 0;
                j3.a().b("scroll_state", "0");
                return;
            }
            return;
        }
        if (accessibilityNodeInfo.getContentDescription() != null) {
            String trim2 = accessibilityNodeInfo.getContentDescription().toString().trim();
            if (trim2.length() >= 25 || trim2.length() <= 2) {
                return;
            }
            this.f5565b = s0.a().a(trim2, this.f5565b);
            if (s0.a().a(this.f5565b) && this.f5564a.size() < 100) {
                this.f5564a.add(trim2);
                return;
            }
            List<String> list2 = this.f5564a;
            if (list2 != null) {
                list2.removeAll(list2);
                this.f5564a.clear();
                this.f5565b = 0;
                j3.a().b("scroll_state", "0");
            }
        }
    }

    public boolean a(List<String> list) {
        if (list != null && list.size() != 0) {
            c2.a(f5562d, "samon--lists  =" + list);
            for (int i6 = 0; i6 < list.size(); i6++) {
                if (list.get(i6).trim().equals("进店逛逛") || list.get(i6).trim().equals("天猫国际") || list.get(i6).trim().equals("去频道逛逛")) {
                    c2.a("zkj_samon", "包含");
                    return true;
                }
            }
            return false;
        }
        c2.a(f5562d, "lists = null");
        return false;
    }

    public final void a(AccessibilityService accessibilityService, List<String> list, String str, String str2) {
        c2.a(f5562d, "current packageName  =" + str2);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        TreeMap treeMap = new TreeMap();
        treeMap.put(SocializeProtocolConstants.PROTOCOL_KEY_AK, HelpShopAppUtil.getHmKey());
        treeMap.put(Constants.JumpUrlConstants.SRC_TYPE_APP, str);
        HelpShopAppUtil.getInstance();
        treeMap.put("marker", HelpShopAppUtil.sessionExID());
        if (list != null) {
            treeMap.put("data", JSON.toJSONString(list));
            c2.a(f5562d, "getCouponInfo string =" + JSON.toJSONString(list));
        } else {
            treeMap.put("data", "");
        }
        treeMap.put("product_info", j3.a().e("goods_info"));
        treeMap.put("new_version", k0.f4675k);
        treeMap.put("coupon_type", s0.a().j(str));
        treeMap.put("genuine_packagename", str2);
        treeMap.put(bi.F, j4.b());
        treeMap.put("is_snt", k0.f4675k);
        treeMap.put("version", k0.f4688x);
        new g1().j(s0.a().a(treeMap, "")).I3(h.a()).w5(Schedulers.newThread()).u5(new a(str), new b());
    }
}
