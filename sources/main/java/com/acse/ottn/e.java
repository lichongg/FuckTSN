package com.acse.ottn;

import android.view.accessibility.AccessibilityEvent;
import com.acse.ottn.io.reactivex.functions.Consumer;
import com.acse.ottn.io.reactivex.schedulers.Schedulers;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.util.HelpShopAppUtil;
import com.tencent.connect.common.Constants;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.ObjectStreamException;
import java.util.TreeMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static e f4486a = null;

    /* renamed from: b, reason: collision with root package name */
    public static String f4487b = "acse_ShopHelperService";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements Consumer<String> {
        public a() {
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer, rx.functions.b
        public /* synthetic */ void call(Object obj) {
            com.acse.ottn.io.reactivex.functions.c.a(this, obj);
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(String str) throws Exception {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b implements Consumer<Throwable> {
        public b() {
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            c2.b(e.f4487b, "报错了=" + th.getMessage());
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer, rx.functions.b
        public /* synthetic */ void call(Object obj) {
            com.acse.ottn.io.reactivex.functions.c.a(this, obj);
        }
    }

    public void a(AccessibilityEvent accessibilityEvent) {
    }

    public static e c() {
        if (f4486a == null) {
            synchronized (e.class) {
                try {
                    if (f4486a == null) {
                        f4486a = new e();
                    }
                } finally {
                }
            }
        }
        return f4486a;
    }

    public final Object d() throws ObjectStreamException {
        return f4486a;
    }

    public void a(AccessiblityModel accessiblityModel) {
        TreeMap treeMap = new TreeMap();
        treeMap.put(SocializeProtocolConstants.PROTOCOL_KEY_AK, HelpShopAppUtil.getHmKey());
        treeMap.put("para", accessiblityModel.getData().getCoupon_activity_name());
        treeMap.put(Constants.JumpUrlConstants.SRC_TYPE_APP, accessiblityModel.getData().getPackage_name());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionExID());
        treeMap.put("is_snt", "0");
        new g1().i(s0.a().a(treeMap, "")).w5(Schedulers.newThread()).I3(h.a()).u5(new a(), new b());
    }

    public void b() {
    }
}
