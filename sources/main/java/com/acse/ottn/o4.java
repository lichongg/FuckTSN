package com.acse.ottn;

import android.annotation.SuppressLint;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;
import com.acse.ottn.m0;
import com.acse.ottn.service.ShopHelperService;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class o4 {

    /* renamed from: b, reason: collision with root package name */
    public static o4 f4977b = null;

    /* renamed from: c, reason: collision with root package name */
    public static String f4978c = "VideoSoftwareUtil";

    /* renamed from: d, reason: collision with root package name */
    public static CountDownTimer f4979d;

    /* renamed from: a, reason: collision with root package name */
    public List<String> f4980a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements m0.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityNodeInfo f4981a;

        @Override // com.acse.ottn.m0.d
        public void a() {
        }

        public a(AccessibilityNodeInfo accessibilityNodeInfo) {
            this.f4981a = accessibilityNodeInfo;
        }

        @Override // com.acse.ottn.m0.d
        @RequiresApi(api = 16)
        public void a(long j6) {
            CountDownTimer countDownTimer;
            o4.this.f4980a = new ArrayList();
            o4.this.a(this.f4981a);
            o4 o4Var = o4.this;
            if (!o4Var.a(o4Var.f4980a) || (countDownTimer = o4.f4979d) == null) {
                return;
            }
            countDownTimer.cancel();
            o4.f4979d = null;
        }
    }

    public static o4 a() {
        if (f4977b == null) {
            synchronized (o4.class) {
                try {
                    if (f4977b == null) {
                        f4977b = new o4();
                    }
                } finally {
                }
            }
        }
        return f4977b;
    }

    public final Object b() throws ObjectStreamException {
        return f4977b;
    }

    @RequiresApi(api = 16)
    public void a(ShopHelperService shopHelperService) {
        CountDownTimer a6 = m0.a().a(3500, 1000, new a(shopHelperService.getRootInActiveWindow()));
        f4979d = a6;
        a6.start();
    }

    @SuppressLint({"NewApi"})
    public void a(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null && accessibilityNodeInfo.getChildCount() == 0) {
            if (accessibilityNodeInfo.getText() != null) {
                String trim = accessibilityNodeInfo.getText().toString().trim();
                if (TextUtils.isEmpty(trim)) {
                    return;
                }
                this.f4980a.add(trim);
                return;
            }
            return;
        }
        if (accessibilityNodeInfo != null) {
            for (int i6 = 0; i6 < accessibilityNodeInfo.getChildCount(); i6++) {
                if (accessibilityNodeInfo.getChild(i6) != null) {
                    a(accessibilityNodeInfo.getChild(i6));
                }
            }
        }
    }

    public boolean a(List<String> list) {
        if (list != null && list.size() != 0) {
            for (int i6 = 0; i6 < list.size(); i6++) {
                if (list.get(i6).trim().equals("合计:")) {
                    c2.a(f4978c, "合计:" + i6);
                    int i7 = i6 + 1;
                    if (list.size() <= i7) {
                        return false;
                    }
                    if (list.get(i7).trim().length() > 0) {
                        c2.a(f4978c, "合计:" + list.get(i7));
                        return true;
                    }
                }
            }
            return false;
        }
        c2.a(f4978c, "lists = null");
        return false;
    }
}
