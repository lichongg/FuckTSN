package com.acse.ottn;

import android.accessibilityservice.AccessibilityService;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.app.Service;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.acse.ottn.io.reactivex.functions.Consumer;
import com.acse.ottn.io.reactivex.schedulers.Schedulers;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.service.a;
import com.acse.ottn.util.HelpShopAppUtil;
import com.acse.ottn.widget.RoundRectImageView;
import com.umeng.analytics.pro.bi;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.ObjectStreamException;
import java.util.TreeMap;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class z1 {

    /* renamed from: c, reason: collision with root package name */
    public static View f5535c = null;

    /* renamed from: d, reason: collision with root package name */
    public static WindowManager f5536d = null;

    /* renamed from: e, reason: collision with root package name */
    public static String f5537e = "MainService";

    /* renamed from: f, reason: collision with root package name */
    public static z1 f5538f;

    /* renamed from: a, reason: collision with root package name */
    public WindowManager.LayoutParams f5539a;

    /* renamed from: b, reason: collision with root package name */
    public AccessiblityModel f5540b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Service f5541a;

        public a(Service service) {
            this.f5541a = service;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l2.b().a("tb_lj_bannner_close");
            k0.f4670f = false;
            z1.this.b(this.f5541a);
            y1.b().a();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Service f5543a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AccessiblityModel f5544b;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            k0.f4670f = false;
            z1.this.b(this.f5543a);
            l2.b().a("tb_lj_bannner_click");
            com.acse.ottn.service.a.b().a(this.f5543a, this.f5544b, (a.u0) null);
            y1.b().a();
        }

        public b(Service service, AccessiblityModel accessiblityModel) {
            this.f5543a = service;
            this.f5544b = accessiblityModel;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RelativeLayout f5546a;

        public c(RelativeLayout relativeLayout) {
            this.f5546a = relativeLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            z1.this.a(this.f5546a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class d implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RelativeLayout f5548a;

        public d(RelativeLayout relativeLayout) {
            this.f5548a = relativeLayout;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.f5548a.setScaleX(floatValue);
            this.f5548a.setScaleY(floatValue);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class e implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RelativeLayout f5550a;

        public e(RelativeLayout relativeLayout) {
            this.f5550a = relativeLayout;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            c2.a("samon-->", "addUpdateListener");
            this.f5550a.setTranslationX(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class f implements Consumer<String> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Service f5552a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f5553b;

        public f(Service service, String str) {
            this.f5552a = service;
            this.f5553b = str;
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(String str) throws Exception {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.getInt(com.kuaishou.weapon.p0.t.f36150k) != 1) {
                k0.f4670f = false;
                z1.this.b(this.f5552a);
            } else if (jSONObject.getInt("code") == 1) {
                k0.f4670f = false;
                z1.this.b(this.f5552a, this.f5553b);
            } else {
                k0.f4670f = false;
                z1.this.b(this.f5552a);
            }
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer, rx.functions.b
        public /* synthetic */ void call(Object obj) {
            com.acse.ottn.io.reactivex.functions.c.a(this, obj);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class g implements Consumer<Throwable> {
        public g() {
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
    public class h implements a.u0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Service f5556a;

        @Override // com.acse.ottn.service.a.u0
        public void a() {
            k0.f4670f = false;
            z1.this.b(this.f5556a);
        }

        public h(Service service) {
            this.f5556a = service;
        }

        @Override // com.acse.ottn.service.a.u0
        public void a(String str) {
            k0.f4670f = false;
            z1.this.b(this.f5556a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class i implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Service f5558a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f5559b;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            k0.f4670f = false;
            l2.b().a("tb_lj_bannner_setting");
            z1.this.a(this.f5558a, this.f5559b);
        }

        public i(Service service, String str) {
            this.f5558a = service;
            this.f5559b = str;
        }
    }

    public final Object b() throws ObjectStreamException {
        return f5538f;
    }

    public static z1 a() {
        if (f5538f == null) {
            synchronized (z1.class) {
                try {
                    if (f5538f == null) {
                        f5538f = new z1();
                    }
                } finally {
                }
            }
        }
        return f5538f;
    }

    public void b(Service service) {
        try {
            View view = f5535c;
            if (view != null) {
                view.setVisibility(8);
            }
            f5536d.removeView(f5535c);
            f5535c = null;
            if (!d4.a().a(service)) {
                service = (AccessibilityService) service;
            }
            service.stopSelf();
        } catch (Throwable unused) {
        }
    }

    public final void b(Service service, String str) {
        c2.c(f5537e, "noShowCoupon ");
        try {
            f5536d.removeView(f5535c);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            a(service, R.layout.coupon_no_showbackground);
            com.acse.ottn.service.a.b().a(f5535c, str, false, (a.u0) new h(service));
            WindowManager.LayoutParams layoutParams = this.f5539a;
            layoutParams.height = -2;
            f5536d.addView(f5535c, layoutParams);
        } catch (Throwable th) {
            c2.c(f5537e, "noShowCoupon e=" + th.getMessage());
        }
    }

    public void a(Service service) {
        this.f5539a = new WindowManager.LayoutParams();
        if (d4.a().a(service)) {
            f5536d = (WindowManager) service.getApplication().getSystemService("window");
            if (Build.VERSION.SDK_INT >= 26) {
                this.f5539a.type = 2038;
            } else {
                this.f5539a.type = 2002;
            }
            this.f5539a.flags = 8;
        } else {
            f5536d = (WindowManager) service.getSystemService("window");
            WindowManager.LayoutParams layoutParams = this.f5539a;
            layoutParams.type = 2032;
            layoutParams.flags = 800;
        }
        WindowManager.LayoutParams layoutParams2 = this.f5539a;
        layoutParams2.format = 1;
        layoutParams2.windowAnimations = android.R.style.Animation.Translucent;
        layoutParams2.gravity = 85;
        layoutParams2.x = 80;
        layoutParams2.y = 400;
        layoutParams2.width = -2;
    }

    public void a(Service service, AccessiblityModel accessiblityModel) {
        a(service, R.layout.lj_first_background);
        this.f5539a.height = u0.a((Context) service, 100.0f);
        TextView textView = (TextView) f5535c.findViewById(R.id.firs_lj);
        View view = f5535c;
        int i6 = R.id.beijing;
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(i6);
        RoundRectImageView roundRectImageView = (RoundRectImageView) f5535c.findViewById(R.id.iv_tb_big_recommend_icon);
        ImageView imageView = (ImageView) f5535c.findViewById(R.id.iv_didi_setting);
        a(service, (ImageView) f5535c.findViewById(R.id.iv_setting2), accessiblityModel.getData().getPackage_name());
        imageView.setOnClickListener(new a(service));
        relativeLayout.setOnClickListener(new b(service, accessiblityModel));
        textView.setText(accessiblityModel.getData().getNew_time_remaining());
        if (!TextUtils.isEmpty(accessiblityModel.getData().getSpop_pic())) {
            com.bumptech.glide.b.D(service).a(accessiblityModel.getData().getSpop_pic()).m1(roundRectImageView);
        }
        RelativeLayout relativeLayout2 = (RelativeLayout) f5535c.findViewById(i6);
        f5536d.addView(f5535c, this.f5539a);
        new Handler(Looper.getMainLooper()).postDelayed(new c(relativeLayout2), accessiblityModel.getData().getSecond_price());
    }

    public final void a(Service service, int i6) {
        try {
            View inflate = LayoutInflater.from(service.getApplication()).inflate(i6, (ViewGroup) null);
            f5535c = inflate;
            inflate.measure(0, 0);
        } catch (Throwable unused) {
        }
    }

    public final void a(RelativeLayout relativeLayout) {
        relativeLayout.setPivotX(relativeLayout.getWidth());
        relativeLayout.setPivotY((relativeLayout.getHeight() * 2) / 3);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.addUpdateListener(new d(relativeLayout));
        ofFloat.setDuration(300L);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(100.0f, 0.0f);
        ofFloat2.addUpdateListener(new e(relativeLayout));
        ofFloat2.setDuration(300L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.start();
    }

    public final void a(Service service, String str) {
        TreeMap treeMap = new TreeMap();
        treeMap.put(SocializeProtocolConstants.PROTOCOL_KEY_AK, HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionExID());
        treeMap.put("limitType", "lj");
        treeMap.put("is_snt", "0");
        treeMap.put(bi.f40972o, str);
        new f0().i(s0.a().a(treeMap, "")).w5(Schedulers.newThread()).I3(com.acse.ottn.h.a()).u5(new f(service, str), new g());
    }

    public final void a(Service service, ImageView imageView, String str) {
        imageView.setOnClickListener(new i(service, str));
    }
}
