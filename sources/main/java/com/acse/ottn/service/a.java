package com.acse.ottn.service;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.acse.ottn.R;
import com.acse.ottn.c2;
import com.acse.ottn.g1;
import com.acse.ottn.h4;
import com.acse.ottn.io.reactivex.functions.Consumer;
import com.acse.ottn.io.reactivex.schedulers.Schedulers;
import com.acse.ottn.j3;
import com.acse.ottn.l2;
import com.acse.ottn.m0;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.util.HelpShopAppUtil;
import com.acse.ottn.widget.RoundRectImageView;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.tencent.connect.common.Constants;
import com.umeng.analytics.pro.bi;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.ObjectStreamException;
import java.util.TimerTask;
import java.util.TreeMap;
import org.json.JSONObject;
import pl.droidsonroids.gif.GifImageView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    public static String f5160c = "ViewUtil";

    /* renamed from: d, reason: collision with root package name */
    public static a f5161d;

    /* renamed from: e, reason: collision with root package name */
    public static TimerTask f5162e;

    /* renamed from: a, reason: collision with root package name */
    public float f5163a;

    /* renamed from: b, reason: collision with root package name */
    public float f5164b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.acse.ottn.service.a$a, reason: collision with other inner class name */
    public class C0084a implements m0.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u0 f5165a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.acse.ottn.service.a$a$a, reason: collision with other inner class name */
        public class RunnableC0085a implements Runnable {
            public RunnableC0085a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (com.acse.ottn.k0.f4669e) {
                    return;
                }
                a.a(C0084a.this.f5165a);
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.acse.ottn.service.a$a$b */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.a(C0084a.this.f5165a);
            }
        }

        @Override // com.acse.ottn.m0.d
        public void a(long j6) {
            new Handler(Looper.getMainLooper()).postDelayed(new RunnableC0085a(), 0L);
        }

        public C0084a(u0 u0Var) {
            this.f5165a = u0Var;
        }

        @Override // com.acse.ottn.m0.d
        public void a() {
            c2.a(a.f5160c, "结束了");
            new Handler(Looper.getMainLooper()).postDelayed(new b(), 0L);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a0 implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u0 f5168a;

        public a0(u0 u0Var) {
            this.f5168a = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.a(this.f5168a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u0 f5170a;

        public b(u0 u0Var) {
            this.f5170a = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.a(this.f5170a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b0 implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f5172a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AccessiblityModel f5173b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ u0 f5174c;

        public b0(Context context, AccessiblityModel accessiblityModel, u0 u0Var) {
            this.f5172a = context;
            this.f5173b = accessiblityModel;
            this.f5174c = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.a(this.f5172a, this.f5173b, this.f5174c);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class c implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f5176a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AccessiblityModel f5177b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ u0 f5178c;

        public c(Context context, AccessiblityModel accessiblityModel, u0 u0Var) {
            this.f5176a = context;
            this.f5177b = accessiblityModel;
            this.f5178c = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.a(this.f5176a, this.f5177b, this.f5178c);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class c0 implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u0 f5180a;

        public c0(u0 u0Var) {
            this.f5180a = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.a(this.f5180a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class d implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u0 f5182a;

        public d(u0 u0Var) {
            this.f5182a = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.a(this.f5182a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class d0 implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f5184a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AccessiblityModel f5185b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ u0 f5186c;

        public d0(Context context, AccessiblityModel accessiblityModel, u0 u0Var) {
            this.f5184a = context;
            this.f5185b = accessiblityModel;
            this.f5186c = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.a(this.f5184a, this.f5185b, this.f5186c);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class e implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f5188a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AccessiblityModel f5189b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ u0 f5190c;

        public e(Context context, AccessiblityModel accessiblityModel, u0 u0Var) {
            this.f5188a = context;
            this.f5189b = accessiblityModel;
            this.f5190c = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.a(this.f5188a, this.f5189b, this.f5190c);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class e0 implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u0 f5192a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f5193b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f5194c;

        public e0(u0 u0Var, String str, boolean z5) {
            this.f5192a = u0Var;
            this.f5193b = str;
            this.f5194c = z5;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f5192a != null) {
                a.this.a(this.f5193b, this.f5194c);
                a.a(this.f5192a);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class f implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u0 f5196a;

        public f(u0 u0Var) {
            this.f5196a = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.a(this.f5196a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class f0 implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u0 f5198a;

        public f0(u0 u0Var) {
            this.f5198a = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.a(this.f5198a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class g implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f5200a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AccessiblityModel f5201b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ u0 f5202c;

        public g(Context context, AccessiblityModel accessiblityModel, u0 u0Var) {
            this.f5200a = context;
            this.f5201b = accessiblityModel;
            this.f5202c = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.a(this.f5200a, this.f5201b, this.f5202c);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class g0 implements Consumer<Throwable> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u0 f5204a;

        public g0(u0 u0Var) {
            this.f5204a = u0Var;
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            c2.b(a.f5160c, "报错了=" + th.getMessage());
            a.a(this.f5204a);
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer, rx.functions.b
        public /* synthetic */ void call(Object obj) {
            com.acse.ottn.io.reactivex.functions.c.a(this, obj);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class h implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u0 f5206a;

        public h(u0 u0Var) {
            this.f5206a = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.a(this.f5206a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class h0 implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u0 f5208a;

        public h0(u0 u0Var) {
            this.f5208a = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.a(this.f5208a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class i implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f5210a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AccessiblityModel f5211b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ u0 f5212c;

        public i(Context context, AccessiblityModel accessiblityModel, u0 u0Var) {
            this.f5210a = context;
            this.f5211b = accessiblityModel;
            this.f5212c = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.a(this.f5210a, this.f5211b, this.f5212c);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class i0 implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f5214a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AccessiblityModel f5215b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ u0 f5216c;

        public i0(Context context, AccessiblityModel accessiblityModel, u0 u0Var) {
            this.f5214a = context;
            this.f5215b = accessiblityModel;
            this.f5216c = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.a(this.f5214a, this.f5215b, this.f5216c);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class j implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u0 f5218a;

        public j(u0 u0Var) {
            this.f5218a = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.a(this.f5218a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class j0 implements View.OnTouchListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RelativeLayout f5220a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f5221b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float f5222c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ u0 f5223d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ AccessiblityModel f5224e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Context f5225f;

        public j0(RelativeLayout relativeLayout, float f6, float f7, u0 u0Var, AccessiblityModel accessiblityModel, Context context) {
            this.f5220a = relativeLayout;
            this.f5221b = f6;
            this.f5222c = f7;
            this.f5223d = u0Var;
            this.f5224e = accessiblityModel;
            this.f5225f = context;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            a.d();
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    a.b(4000, this.f5223d);
                    if (a.this.f5164b - motionEvent.getY() > 100.0f) {
                        this.f5220a.scrollTo(-((int) this.f5222c), 300);
                        l2.b().a("close_coupon_window");
                        a.a(this.f5223d);
                    } else if (motionEvent.getX() - a.this.f5163a > j3.a().c("screenWidth") / 3) {
                        this.f5220a.scrollTo(j3.a().c("screenWidth"), (int) this.f5221b);
                        l2.b().a("close_coupon_window");
                        a.a(this.f5223d);
                    } else {
                        this.f5220a.scrollTo(0, 0);
                        if (Math.abs(a.this.f5164b - motionEvent.getY()) < 100.0f && Math.abs(a.this.f5163a - motionEvent.getX()) < 100.0f) {
                            c2.c(a.f5160c, "点击了");
                            if (this.f5224e == null) {
                                return false;
                            }
                            a.d();
                            a.a(this.f5223d);
                            a.this.a(this.f5225f, this.f5224e, this.f5223d);
                        }
                        return false;
                    }
                } else if (action == 2) {
                    if (Math.abs(motionEvent.getX() - a.this.f5163a) > Math.abs(motionEvent.getY() - a.this.f5164b)) {
                        if (motionEvent.getX() - a.this.f5163a < 0.0f) {
                            return false;
                        }
                        this.f5220a.scrollTo(-((int) (motionEvent.getX() - a.this.f5163a)), -((int) this.f5221b));
                    } else {
                        if (motionEvent.getY() - a.this.f5164b > 0.0f) {
                            return false;
                        }
                        this.f5220a.scrollTo(-((int) this.f5222c), -((int) (motionEvent.getY() - a.this.f5164b)));
                    }
                }
            } else {
                a.this.f5163a = motionEvent.getX();
                a.this.f5164b = motionEvent.getY();
            }
            return true;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class k implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f5227a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AccessiblityModel f5228b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ u0 f5229c;

        public k(Context context, AccessiblityModel accessiblityModel, u0 u0Var) {
            this.f5227a = context;
            this.f5228b = accessiblityModel;
            this.f5229c = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.a(this.f5227a, this.f5228b, this.f5229c);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class k0 implements Consumer<String> {
        public k0() {
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(String str) throws Exception {
            c2.b("ShopHelperService", "cutdown=" + str);
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer, rx.functions.b
        public /* synthetic */ void call(Object obj) {
            com.acse.ottn.io.reactivex.functions.c.a(this, obj);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class l implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u0 f5232a;

        public l(u0 u0Var) {
            this.f5232a = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.a(this.f5232a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class l0 implements Consumer<Throwable> {
        public l0() {
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
    public class m implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f5235a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AccessiblityModel f5236b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ u0 f5237c;

        public m(Context context, AccessiblityModel accessiblityModel, u0 u0Var) {
            this.f5235a = context;
            this.f5236b = accessiblityModel;
            this.f5237c = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.a(this.f5235a, this.f5236b, this.f5237c);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class m0 implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u0 f5239a;

        public m0(u0 u0Var) {
            this.f5239a = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.a(this.f5239a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class n implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u0 f5241a;

        public n(u0 u0Var) {
            this.f5241a = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.a(this.f5241a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class n0 implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f5243a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AccessiblityModel f5244b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ u0 f5245c;

        public n0(Context context, AccessiblityModel accessiblityModel, u0 u0Var) {
            this.f5243a = context;
            this.f5244b = accessiblityModel;
            this.f5245c = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.a(this.f5243a, this.f5244b, this.f5245c);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class o implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f5247a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AccessiblityModel f5248b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ u0 f5249c;

        public o(Context context, AccessiblityModel accessiblityModel, u0 u0Var) {
            this.f5247a = context;
            this.f5248b = accessiblityModel;
            this.f5249c = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.a(this.f5247a, this.f5248b, this.f5249c);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class o0 implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u0 f5251a;

        public o0(u0 u0Var) {
            this.f5251a = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.a(this.f5251a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class p implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u0 f5253a;

        public p(u0 u0Var) {
            this.f5253a = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.a(this.f5253a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class p0 implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f5255a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AccessiblityModel f5256b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ u0 f5257c;

        public p0(Context context, AccessiblityModel accessiblityModel, u0 u0Var) {
            this.f5255a = context;
            this.f5256b = accessiblityModel;
            this.f5257c = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.a(this.f5255a, this.f5256b, this.f5257c);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class q implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f5259a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AccessiblityModel f5260b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ u0 f5261c;

        public q(Context context, AccessiblityModel accessiblityModel, u0 u0Var) {
            this.f5259a = context;
            this.f5260b = accessiblityModel;
            this.f5261c = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.a(this.f5259a, this.f5260b, this.f5261c);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class q0 implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u0 f5263a;

        public q0(u0 u0Var) {
            this.f5263a = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.a(this.f5263a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class r implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u0 f5265a;

        public r(u0 u0Var) {
            this.f5265a = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.a(this.f5265a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class r0 implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f5267a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AccessiblityModel f5268b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ u0 f5269c;

        public r0(Context context, AccessiblityModel accessiblityModel, u0 u0Var) {
            this.f5267a = context;
            this.f5268b = accessiblityModel;
            this.f5269c = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.a(this.f5267a, this.f5268b, this.f5269c);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class s implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f5271a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AccessiblityModel f5272b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ u0 f5273c;

        public s(Context context, AccessiblityModel accessiblityModel, u0 u0Var) {
            this.f5271a = context;
            this.f5272b = accessiblityModel;
            this.f5273c = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.a(this.f5271a, this.f5272b, this.f5273c);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class s0 implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u0 f5275a;

        public s0(u0 u0Var) {
            this.f5275a = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.a(this.f5275a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class t implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u0 f5277a;

        public t(u0 u0Var) {
            this.f5277a = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.a(this.f5277a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class t0 implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f5279a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AccessiblityModel f5280b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ u0 f5281c;

        public t0(Context context, AccessiblityModel accessiblityModel, u0 u0Var) {
            this.f5279a = context;
            this.f5280b = accessiblityModel;
            this.f5281c = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.a(this.f5279a, this.f5280b, this.f5281c);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class u implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f5283a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AccessiblityModel f5284b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ u0 f5285c;

        public u(Context context, AccessiblityModel accessiblityModel, u0 u0Var) {
            this.f5283a = context;
            this.f5284b = accessiblityModel;
            this.f5285c = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.a(this.f5283a, this.f5284b, this.f5285c);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface u0 {
        void a();

        void a(String str);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class v implements Consumer<String> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u0 f5287a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AccessiblityModel f5288b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f5289c;

        public v(u0 u0Var, AccessiblityModel accessiblityModel, Context context) {
            this.f5287a = u0Var;
            this.f5288b = accessiblityModel;
            this.f5289c = context;
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(String str) throws Exception {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.getInt(com.kuaishou.weapon.p0.t.f36150k) == 0) {
                a.a(this.f5287a);
                return;
            }
            String string = jSONObject.getString("gwc_link");
            this.f5288b.getData().setSpop_deeplink(jSONObject.getString("gwc_deeplink"));
            this.f5288b.getData().setSpop_link(string);
            h4.c().b(this.f5289c, this.f5288b);
            a.a(this.f5287a);
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer, rx.functions.b
        public /* synthetic */ void call(Object obj) {
            com.acse.ottn.io.reactivex.functions.c.a(this, obj);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class w implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u0 f5291a;

        public w(u0 u0Var) {
            this.f5291a = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.a(this.f5291a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class x implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f5293a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AccessiblityModel f5294b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ u0 f5295c;

        public x(Context context, AccessiblityModel accessiblityModel, u0 u0Var) {
            this.f5293a = context;
            this.f5294b = accessiblityModel;
            this.f5295c = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.a(this.f5293a, this.f5294b, this.f5295c);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class y implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u0 f5297a;

        public y(u0 u0Var) {
            this.f5297a = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l2.b().a("close_coupon_window");
            a.a(this.f5297a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class z implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f5299a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ u0 f5300b;

        public z(String str, u0 u0Var) {
            this.f5299a = str;
            this.f5300b = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.a(this.f5299a, this.f5300b);
        }
    }

    public static a b() {
        if (f5161d == null) {
            synchronized (a.class) {
                try {
                    if (f5161d == null) {
                        f5161d = new a();
                    }
                } finally {
                }
            }
        }
        return f5161d;
    }

    public final Object c() throws ObjectStreamException {
        return f5161d;
    }

    public void d(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.idlefish_small_layout);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_idlefish_smile_close);
        a((ImageView) view.findViewById(R.id.iv_idlefish_smile_setting), accessiblityModel.getData().getPackage_name(), u0Var);
        a(imageView, u0Var);
        a(context, relativeLayout, accessiblityModel, u0Var);
        b(AVMDLDataLoader.KeyIsLiveSetLoaderType, u0Var);
    }

    public void A(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        RoundRectImageView roundRectImageView = (RoundRectImageView) view.findViewById(R.id.iv_tb_big_recommend_icon);
        if (!TextUtils.isEmpty(accessiblityModel.getData().getSpop_pic())) {
            com.bumptech.glide.b.D(context).a(accessiblityModel.getData().getSpop_pic()).m1(roundRectImageView);
        }
        TextView textView = (TextView) view.findViewById(R.id.tb_content);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.tb_small);
        a((ImageView) view.findViewById(R.id.iv_smill_close), u0Var);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_setting);
        if (a(accessiblityModel.getData().getPackage_name()) || a(accessiblityModel.getData().getNew_time_remaining())) {
            return;
        }
        a(imageView, accessiblityModel.getData().getPackage_name(), u0Var);
        a(context, relativeLayout, accessiblityModel, u0Var);
        textView.setText(accessiblityModel.getData().getSpop_title());
        b(AVMDLDataLoader.KeyIsLiveSetLoaderType, u0Var);
    }

    public void B(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        view.findViewById(R.id.jd_lijin_close).setOnClickListener(new n(u0Var));
        ((LinearLayout) view.findViewById(R.id.jd_lijin_big)).setOnClickListener(new o(context, accessiblityModel, u0Var));
        ((GifImageView) view.findViewById(R.id.jd_lijin_coupon_price)).setImageResource(R.drawable.zkj_suiji);
        b(AVMDLDataLoader.KeyIsLiveSetLoaderType, u0Var);
    }

    public void C(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        RoundRectImageView roundRectImageView = (RoundRectImageView) view.findViewById(R.id.iv_tb_big_recommend_icon);
        if (!TextUtils.isEmpty(accessiblityModel.getData().getSpop_pic())) {
            com.bumptech.glide.b.D(context).a(accessiblityModel.getData().getSpop_pic()).m1(roundRectImageView);
        }
        TextView textView = (TextView) view.findViewById(R.id.tb_content_info);
        TextView textView2 = (TextView) view.findViewById(R.id.tb_content);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.tb_small);
        a((ImageView) view.findViewById(R.id.iv_smill_close), u0Var);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_setting);
        if (a(accessiblityModel.getData().getPackage_name()) || a(accessiblityModel.getData().getNew_time_remaining())) {
            return;
        }
        a(imageView, accessiblityModel.getData().getPackage_name(), u0Var);
        a(context, relativeLayout, accessiblityModel, u0Var);
        textView2.setText(accessiblityModel.getData().getSpop_title());
        textView.setText(accessiblityModel.getData().getNew_time_remaining());
        b(AVMDLDataLoader.KeyIsLiveSetLoaderType, u0Var);
    }

    public void D(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        view.findViewById(R.id.xbk_close).setOnClickListener(new c0(u0Var));
        view.setOnClickListener(new d0(context, accessiblityModel, u0Var));
        b(AVMDLDataLoader.KeyIsLiveSetLoaderType, u0Var);
    }

    public void E(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        view.findViewById(R.id.eleme_close).setOnClickListener(new p(u0Var));
        view.setOnClickListener(new q(context, accessiblityModel, u0Var));
        if (a(accessiblityModel.getData().getSpop_coupon_price())) {
            return;
        }
        ((TextView) view.findViewById(R.id.eleme_coupon_price)).setText("¥" + accessiblityModel.getData().getSpop_coupon_price());
        b(AVMDLDataLoader.KeyIsLiveSetLoaderType, u0Var);
    }

    public void F(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        TextView textView = (TextView) view.findViewById(R.id.eleme_content_info);
        TextView textView2 = (TextView) view.findViewById(R.id.eleme_content);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.eleme_small_layout);
        a((ImageView) view.findViewById(R.id.iv_eleme_smile_close), u0Var);
        if (a(accessiblityModel.getData().getPackage_name()) || a(accessiblityModel.getData().getNew_time_remaining())) {
            return;
        }
        a((ImageView) view.findViewById(R.id.iv_eleme_smile_setting), accessiblityModel.getData().getPackage_name(), u0Var);
        a(context, relativeLayout, accessiblityModel, u0Var);
        textView2.setText(accessiblityModel.getData().getSpop_title());
        textView.setText(accessiblityModel.getData().getNew_time_remaining());
        b(AVMDLDataLoader.KeyIsLiveSetLoaderType, u0Var);
    }

    public void G(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.eleme_small_layout);
        a((ImageView) view.findViewById(R.id.iv_eleme_smile_close), u0Var);
        a((ImageView) view.findViewById(R.id.iv_fz_smile_setting), accessiblityModel.getData().getPackage_name(), u0Var);
        a(context, relativeLayout, accessiblityModel, u0Var);
        b(AVMDLDataLoader.KeyIsLiveSetLoaderType, u0Var);
    }

    public void H(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        view.findViewById(R.id.hxz_close).setOnClickListener(new h(u0Var));
        ((LinearLayout) view.findViewById(R.id.hxz_big)).setOnClickListener(new i(context, accessiblityModel, u0Var));
        if (a(accessiblityModel.getData().getNew_time_remaining()) || a(accessiblityModel.getData().getSpop_coupon_title())) {
            return;
        }
        ((TextView) view.findViewById(R.id.hxz_content_info)).setText(accessiblityModel.getData().getNew_time_remaining());
        b(AVMDLDataLoader.KeyIsLiveSetLoaderType, u0Var);
    }

    public void I(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        view.findViewById(R.id.jd_close).setOnClickListener(new j(u0Var));
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.jd_big);
        linearLayout.setOnClickListener(new k(context, accessiblityModel, u0Var));
        linearLayout.setVisibility(0);
        if (a(accessiblityModel.getData().getSpop_coupon_price()) || a(accessiblityModel.getData().getNew_time_remaining())) {
            return;
        }
        ((TextView) view.findViewById(R.id.jd_coupon_price)).setText("¥" + accessiblityModel.getData().getSpop_coupon_price());
        ((TextView) view.findViewById(R.id.jd_action_time)).setText(accessiblityModel.getData().getNew_time_remaining());
        b(AVMDLDataLoader.KeyIsLiveSetLoaderType, u0Var);
    }

    public void J(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        view.findViewById(R.id.jd_lijin_close).setOnClickListener(new l(u0Var));
        ((LinearLayout) view.findViewById(R.id.jd_lijin_big)).setOnClickListener(new m(context, accessiblityModel, u0Var));
        ((GifImageView) view.findViewById(R.id.jd_lijin_coupon_price)).setImageResource(R.drawable.zkj_suiji);
        b(AVMDLDataLoader.KeyIsLiveSetLoaderType, u0Var);
    }

    public void K(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        RoundRectImageView roundRectImageView = (RoundRectImageView) view.findViewById(R.id.iv_jd_recommend_icon);
        TextView textView = (TextView) view.findViewById(R.id.jd_content_info);
        TextView textView2 = (TextView) view.findViewById(R.id.jd_content);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.jd_small);
        a((ImageView) view.findViewById(R.id.iv_jd_smill_close), u0Var);
        if (a(accessiblityModel.getData().getPackage_name()) || a(accessiblityModel.getData().getSpop_pic()) || a(accessiblityModel.getData().getNew_time_remaining())) {
            return;
        }
        a((ImageView) view.findViewById(R.id.iv_jd_smill_setting), accessiblityModel.getData().getPackage_name(), u0Var);
        relativeLayout.setVisibility(0);
        a(context, relativeLayout, accessiblityModel, u0Var);
        com.bumptech.glide.b.D(context).a(accessiblityModel.getData().getSpop_pic()).m1(roundRectImageView);
        textView2.setText(accessiblityModel.getData().getSpop_title());
        textView.setText(accessiblityModel.getData().getNew_time_remaining());
        b(AVMDLDataLoader.KeyIsLiveSetLoaderType, u0Var);
    }

    public void c(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.custom_small_layout);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_custom_smile_close);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_custom);
        a((ImageView) view.findViewById(R.id.iv_custom_smile_setting), accessiblityModel.getData().getPackage_name(), u0Var);
        a(imageView, u0Var);
        if (TextUtils.isEmpty(accessiblityModel.getData().getSpop_pic())) {
            return;
        }
        com.bumptech.glide.b.D(context).a(accessiblityModel.getData().getSpop_pic()).m1(imageView2);
        a(context, relativeLayout, accessiblityModel, u0Var);
        b(AVMDLDataLoader.KeyIsLiveSetLoaderType, u0Var);
    }

    public void e(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.jd_home_small_layout);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_jd_home_smile_close);
        a((ImageView) view.findViewById(R.id.iv_jd_home_smile_setting), accessiblityModel.getData().getPackage_name(), u0Var);
        a(imageView, u0Var);
        a(context, relativeLayout, accessiblityModel, u0Var);
        b(AVMDLDataLoader.KeyIsLiveSetLoaderType, u0Var);
    }

    public void f(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        view.findViewById(R.id.kfc_wp_close).setOnClickListener(new s0(u0Var));
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.kfc_wp);
        linearLayout.setOnClickListener(new t0(context, accessiblityModel, u0Var));
        linearLayout.setVisibility(0);
        b(10000, u0Var);
    }

    public void g(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.ks_small_layout);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_ks_smile_close);
        a((ImageView) view.findViewById(R.id.iv_ks_smile_setting), accessiblityModel.getData().getPackage_name(), u0Var);
        a(imageView, u0Var);
        a(context, relativeLayout, accessiblityModel, u0Var);
        b(AVMDLDataLoader.KeyIsLiveSetLoaderType, u0Var);
    }

    public void h(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.shangou_small_layout);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_shangou_smile_close);
        a((ImageView) view.findViewById(R.id.iv_shangou_smile_setting), accessiblityModel.getData().getPackage_name(), u0Var);
        a(imageView, u0Var);
        a(context, relativeLayout, accessiblityModel, u0Var);
        b(AVMDLDataLoader.KeyIsLiveSetLoaderType, u0Var);
    }

    public void i(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.tb_home_small_layout);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_tb_home_smile_close);
        a((ImageView) view.findViewById(R.id.iv_tb_home_smile_setting), accessiblityModel.getData().getPackage_name(), u0Var);
        a(imageView, u0Var);
        a(context, relativeLayout, accessiblityModel, u0Var);
        b(AVMDLDataLoader.KeyIsLiveSetLoaderType, u0Var);
    }

    public void j(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        view.findViewById(R.id.tencent_close).setOnClickListener(new b(u0Var));
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.tencent_wp);
        linearLayout.setOnClickListener(new c(context, accessiblityModel, u0Var));
        linearLayout.setVisibility(0);
        if (a(accessiblityModel.getData().getSpop_coupon_price()) || a(accessiblityModel.getData().getNew_time_remaining())) {
            return;
        }
        ((TextView) view.findViewById(R.id.tencent_price)).setText(accessiblityModel.getData().getSpop_coupon_price());
        ((TextView) view.findViewById(R.id.tencent_surplus_time)).setText(accessiblityModel.getData().getNew_time_remaining());
        b(10000, u0Var);
    }

    public void k(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        view.findViewById(R.id.aiqiyi_close).setOnClickListener(new o0(u0Var));
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.video_aiqiyi);
        linearLayout.setOnClickListener(new p0(context, accessiblityModel, u0Var));
        linearLayout.setVisibility(0);
        if (a(accessiblityModel.getData().getNew_time_remaining()) || a(accessiblityModel.getData().getSpop_coupon_price()) || a(accessiblityModel.getData().getOriginal_price())) {
            return;
        }
        ((TextView) view.findViewById(R.id.aiqiyi_monery)).setText(accessiblityModel.getData().getSpop_coupon_price());
        TextView textView = (TextView) view.findViewById(R.id.aiqiyi_all_monery);
        textView.setText(accessiblityModel.getData().getOriginal_price());
        textView.getPaint().setFlags(16);
        ((TextView) view.findViewById(R.id.aiqiyi_surplus_time)).setText(accessiblityModel.getData().getNew_time_remaining());
        b(10000, u0Var);
    }

    public void l(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.wph_small_layout);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_wph_smile_close);
        a((ImageView) view.findViewById(R.id.iv_wph_smile_setting), accessiblityModel.getData().getPackage_name(), u0Var);
        a(imageView, u0Var);
        a(context, relativeLayout, accessiblityModel, u0Var);
        b(AVMDLDataLoader.KeyIsLiveSetLoaderType, u0Var);
    }

    public void m(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        view.findViewById(R.id.taobao_close).setOnClickListener(new m0(u0Var));
        ((ImageView) view.findViewById(R.id.taobao_main_box)).setOnClickListener(new n0(context, accessiblityModel, u0Var));
        if (TextUtils.isEmpty(accessiblityModel.getData().getSpop_pic())) {
            return;
        }
        b(10000, u0Var);
    }

    public void n(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        view.findViewById(R.id.youku_close).setOnClickListener(new d(u0Var));
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.youku_wp);
        linearLayout.setOnClickListener(new e(context, accessiblityModel, u0Var));
        linearLayout.setVisibility(0);
        if (a(accessiblityModel.getData().getSpop_coupon_price()) || a(accessiblityModel.getData().getNew_time_remaining())) {
            return;
        }
        ((TextView) view.findViewById(R.id.youku_price)).setText(accessiblityModel.getData().getSpop_coupon_price());
        ((TextView) view.findViewById(R.id.youku_surplus_time)).setText(accessiblityModel.getData().getNew_time_remaining());
        b(10000, u0Var);
    }

    public void o(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.mt_xh_small_layout);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_mt_xh_smile_close);
        a((ImageView) view.findViewById(R.id.iv_mt_xh_smile_setting), accessiblityModel.getData().getPackage_name(), u0Var);
        a(imageView, u0Var);
        a(context, relativeLayout, accessiblityModel, u0Var);
        b(AVMDLDataLoader.KeyIsLiveSetLoaderType, u0Var);
    }

    public void p(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.mt_hotel_small_layout);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_mt_hotel_smile_close);
        a((ImageView) view.findViewById(R.id.iv_mt_hotel_smile_setting), accessiblityModel.getData().getPackage_name(), u0Var);
        a(imageView, u0Var);
        a(context, relativeLayout, accessiblityModel, u0Var);
        b(AVMDLDataLoader.KeyIsLiveSetLoaderType, u0Var);
    }

    public void q(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.mt_yy_small_layout);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_mt_yy_smile_close);
        a((ImageView) view.findViewById(R.id.iv_mt_yy_smile_setting), accessiblityModel.getData().getPackage_name(), u0Var);
        a(imageView, u0Var);
        a(context, relativeLayout, accessiblityModel, u0Var);
        b(AVMDLDataLoader.KeyIsLiveSetLoaderType, u0Var);
    }

    public void r(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.mt_shop_small_layout);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_mt_shop_smile_close);
        a((ImageView) view.findViewById(R.id.iv_mt_shop_smile_setting), accessiblityModel.getData().getPackage_name(), u0Var);
        a(imageView, u0Var);
        a(context, relativeLayout, accessiblityModel, u0Var);
        b(AVMDLDataLoader.KeyIsLiveSetLoaderType, u0Var);
    }

    public void s(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        view.findViewById(R.id.didi_close).setOnClickListener(new w(u0Var));
        ((LinearLayout) view.findViewById(R.id.didi_big)).setOnClickListener(new x(context, accessiblityModel, u0Var));
        b(AVMDLDataLoader.KeyIsLiveSetLoaderType, u0Var);
    }

    public void t(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        TextView textView = (TextView) view.findViewById(R.id.didi_content_info);
        TextView textView2 = (TextView) view.findViewById(R.id.didi_small_content);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.didi_small);
        a((ImageView) view.findViewById(R.id.iv_didi_close), u0Var);
        if (a(accessiblityModel.getData().getPackage_name()) || a(accessiblityModel.getData().getSpop_title())) {
            return;
        }
        a((ImageView) view.findViewById(R.id.iv_didi_setting), accessiblityModel.getData().getPackage_name(), u0Var);
        relativeLayout.setVisibility(0);
        a(context, relativeLayout, accessiblityModel, u0Var);
        textView2.setText(accessiblityModel.getData().getSpop_title());
        textView.setText(accessiblityModel.getData().getNew_time_remaining());
        b(AVMDLDataLoader.KeyIsLiveSetLoaderType, u0Var);
    }

    public void u(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        view.findViewById(R.id.fz_close).setOnClickListener(new t(u0Var));
        view.setOnClickListener(new u(context, accessiblityModel, u0Var));
        if (a(accessiblityModel.getData().getSpop_coupon_price())) {
            return;
        }
        b(AVMDLDataLoader.KeyIsLiveSetLoaderType, u0Var);
    }

    public void v(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        view.findViewById(R.id.jdwm_close).setOnClickListener(new r(u0Var));
        view.setOnClickListener(new s(context, accessiblityModel, u0Var));
        if (a(accessiblityModel.getData().getSpop_coupon_price())) {
            return;
        }
        ((TextView) view.findViewById(R.id.jdwm_coupon_price)).setText(accessiblityModel.getData().getSpop_coupon_price());
        b(AVMDLDataLoader.KeyIsLiveSetLoaderType, u0Var);
    }

    public void w(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        TextView textView = (TextView) view.findViewById(R.id.jdwm_content_info);
        TextView textView2 = (TextView) view.findViewById(R.id.jdwm_content);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.jdwm_small_layout);
        a((ImageView) view.findViewById(R.id.iv_jdwm_smile_close), u0Var);
        if (a(accessiblityModel.getData().getPackage_name()) || a(accessiblityModel.getData().getNew_time_remaining())) {
            return;
        }
        a((ImageView) view.findViewById(R.id.iv_jdwm_smile_setting), accessiblityModel.getData().getPackage_name(), u0Var);
        a(context, relativeLayout, accessiblityModel, u0Var);
        textView2.setText(accessiblityModel.getData().getSpop_title());
        textView.setText(accessiblityModel.getData().getNew_time_remaining());
        b(AVMDLDataLoader.KeyIsLiveSetLoaderType, u0Var);
    }

    public void x(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        TextView textView = (TextView) view.findViewById(R.id.meituan_content_info);
        TextView textView2 = (TextView) view.findViewById(R.id.meituan_content);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.meituan_small_layout);
        a((ImageView) view.findViewById(R.id.iv_meituan_smile_close), u0Var);
        if (a(accessiblityModel.getData().getPackage_name()) || a(accessiblityModel.getData().getSpop_title())) {
            return;
        }
        a((ImageView) view.findViewById(R.id.iv_meituan_smile_setting), accessiblityModel.getData().getPackage_name(), u0Var);
        relativeLayout.setVisibility(0);
        a(context, relativeLayout, accessiblityModel, u0Var);
        textView2.setText(accessiblityModel.getData().getSpop_title());
        textView.setText(accessiblityModel.getData().getNew_time_remaining());
        b(AVMDLDataLoader.KeyIsLiveSetLoaderType, u0Var);
    }

    public void y(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        view.findViewById(R.id.meituan_close).setOnClickListener(new a0(u0Var));
        view.setOnClickListener(new b0(context, accessiblityModel, u0Var));
        b(AVMDLDataLoader.KeyIsLiveSetLoaderType, u0Var);
    }

    public void z(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        view.findViewById(R.id.iv_close).setOnClickListener(new f(u0Var));
        ((ImageView) view.findViewById(R.id.taobao_treasure_box)).setOnClickListener(new g(context, accessiblityModel, u0Var));
        if (a(accessiblityModel.getData().getSpop_coupon_price()) || a(accessiblityModel.getData().getSpop_coupon_title())) {
            return;
        }
        ((TextView) view.findViewById(R.id.tb_coupon_price)).setText("¥" + accessiblityModel.getData().getSpop_coupon_price());
        ((TextView) view.findViewById(R.id.tb_textview)).setText(accessiblityModel.getData().getSpop_coupon_title());
        b(AVMDLDataLoader.KeyIsLiveSetLoaderType, u0Var);
    }

    public static void a(String str, u0 u0Var) {
        d();
        if (u0Var != null) {
            u0Var.a(str);
        }
    }

    public static void a(u0 u0Var) {
        TimerTask timerTask = f5162e;
        if (timerTask != null) {
            timerTask.cancel();
            f5162e = null;
        }
        d();
        if (u0Var != null) {
            u0Var.a();
        }
    }

    public static void b(int i6, u0 u0Var) {
        j3.a().b("currentActivity", "");
        f5162e = com.acse.ottn.m0.a().b(i6, 200, new C0084a(u0Var));
    }

    public static void d() {
        try {
            if (f5162e != null) {
                c2.a(f5160c, "timer is not null");
                f5162e.cancel();
                f5162e = null;
            }
        } catch (Exception unused) {
            c2.a(f5160c, "current window is Destroy");
        }
    }

    public void b(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        view.findViewById(R.id.taobao_close).setOnClickListener(new h0(u0Var));
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.video_taobao_man);
        ImageView imageView = (ImageView) view.findViewById(R.id.taobao_main_box);
        imageView.setOnClickListener(new i0(context, accessiblityModel, u0Var));
        if (TextUtils.isEmpty(accessiblityModel.getData().getSpop_pic())) {
            return;
        }
        com.bumptech.glide.b.D(context).a(accessiblityModel.getData().getSpop_pic()).m1(imageView);
        linearLayout.setVisibility(0);
        b(10000, u0Var);
    }

    public void a(Context context, AccessiblityModel accessiblityModel, u0 u0Var) {
        if (!TextUtils.isEmpty(accessiblityModel.getData().getTkl_url())) {
            if (accessiblityModel.getData().getTkl_url().startsWith(master.flame.danmaku.danmaku.parser.b.f50155b)) {
                Intent intent = new Intent(context, (Class<?>) DemoService.class);
                intent.putExtra("tkl_url", accessiblityModel.getData().getTkl_url());
                context.startService(intent);
            } else {
                com.acse.ottn.n.c().a(context, accessiblityModel.getData().getTkl_url());
            }
        }
        c2.c(f5160c, "开始点击");
        if (a(accessiblityModel.getData().getSpop_link()) || a(accessiblityModel.getData().getSpop_deeplink())) {
            return;
        }
        if (!"1".equals(accessiblityModel.getData().getPic_type()) && !"1".equals(accessiblityModel.getData().getShort_link())) {
            h4.c().b(context, accessiblityModel);
            a(u0Var);
            return;
        }
        TreeMap treeMap = new TreeMap();
        treeMap.put(SocializeProtocolConstants.PROTOCOL_KEY_AK, HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionExID());
        treeMap.put("spop_coupon_price", accessiblityModel.getData().getSpop_coupon_price());
        treeMap.put(Constants.JumpUrlConstants.SRC_TYPE_APP, accessiblityModel.getData().getPackage_name());
        treeMap.put("spop_link", accessiblityModel.getData().getSpop_link());
        new g1().f(com.acse.ottn.s0.a().a(treeMap, "")).w5(Schedulers.newThread()).I3(com.acse.ottn.h.a()).u5(new v(u0Var, accessiblityModel, context), new g0(u0Var));
    }

    public void a(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        view.findViewById(R.id.baidu_wp_close).setOnClickListener(new q0(u0Var));
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.baidu_wp);
        linearLayout.setOnClickListener(new r0(context, accessiblityModel, u0Var));
        linearLayout.setVisibility(0);
        if (a(accessiblityModel.getData().getSpop_coupon_price()) || a(accessiblityModel.getData().getNew_time_remaining())) {
            return;
        }
        ((TextView) view.findViewById(R.id.baidu_wp_price)).setText(accessiblityModel.getData().getSpop_coupon_price());
        ((TextView) view.findViewById(R.id.baidu_wp_surplus_time)).setText(accessiblityModel.getData().getNew_time_remaining());
        b(10000, u0Var);
    }

    public final void a(ImageView imageView, u0 u0Var) {
        imageView.setOnClickListener(new y(u0Var));
    }

    public final void a(ImageView imageView, String str, u0 u0Var) {
        imageView.setOnClickListener(new z(str, u0Var));
    }

    public void a(View view, String str, boolean z5, u0 u0Var) {
        ((TextView) view.findViewById(R.id.tv_close)).setOnClickListener(new e0(u0Var, str, z5));
        ((ImageView) view.findViewById(R.id.iv_no_show_smill_close)).setOnClickListener(new f0(u0Var));
        b(4000, u0Var);
    }

    public final void a(Context context, RelativeLayout relativeLayout, AccessiblityModel accessiblityModel, u0 u0Var) {
        relativeLayout.setOnTouchListener(new j0(relativeLayout, relativeLayout.getY(), relativeLayout.getX(), u0Var, accessiblityModel, context));
    }

    public final void a(String str, boolean z5) {
        TreeMap treeMap = new TreeMap();
        treeMap.put(SocializeProtocolConstants.PROTOCOL_KEY_AK, HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionExID());
        treeMap.put("limitType", z5 ? "coupon" : "lj");
        treeMap.put("is_snt", "0");
        treeMap.put(bi.f40972o, str);
        new com.acse.ottn.f0().o(com.acse.ottn.s0.a().a(treeMap, "")).w5(Schedulers.newThread()).I3(com.acse.ottn.h.a()).u5(new k0(), new l0());
    }

    public final boolean a(String str) {
        return TextUtils.isEmpty(str);
    }
}
