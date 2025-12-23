package com.acse.ottn;

import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class x3 {

    /* renamed from: m, reason: collision with root package name */
    public static String f5483m = "ScreenLock_Width";

    /* renamed from: n, reason: collision with root package name */
    public static String f5484n = "ScreenLock_Height";

    /* renamed from: o, reason: collision with root package name */
    public static String f5485o = "ScreenLock_PositionX";

    /* renamed from: p, reason: collision with root package name */
    public static String f5486p = "ScreenLock_PositionY";

    /* renamed from: a, reason: collision with root package name */
    public int f5487a;

    /* renamed from: b, reason: collision with root package name */
    public int f5488b;

    /* renamed from: c, reason: collision with root package name */
    public int f5489c;

    /* renamed from: d, reason: collision with root package name */
    public int f5490d;

    /* renamed from: e, reason: collision with root package name */
    public Context f5491e;

    /* renamed from: f, reason: collision with root package name */
    public DevicePolicyManager f5492f;

    /* renamed from: g, reason: collision with root package name */
    public SharedPreferences f5493g;

    /* renamed from: h, reason: collision with root package name */
    public WindowManager f5494h;

    /* renamed from: i, reason: collision with root package name */
    public DisplayMetrics f5495i = new DisplayMetrics();

    /* renamed from: j, reason: collision with root package name */
    public ImageView f5496j;

    /* renamed from: k, reason: collision with root package name */
    public WindowManager.LayoutParams f5497k;

    /* renamed from: l, reason: collision with root package name */
    public View f5498l;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public long f5499a = System.currentTimeMillis();

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f5499a = System.currentTimeMillis();
        }
    }

    public void a() {
        if (this.f5496j != null) {
            return;
        }
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f5497k = layoutParams;
        layoutParams.type = 2032;
        layoutParams.flags = 776;
        layoutParams.format = -2;
        layoutParams.gravity = 8388659;
        layoutParams.alpha = 0.5f;
        layoutParams.width = this.f5487a;
        layoutParams.height = this.f5488b;
        layoutParams.x = this.f5489c;
        layoutParams.y = this.f5490d;
        ImageView imageView = new ImageView(this.f5491e);
        this.f5496j = imageView;
        imageView.setBackgroundColor(0);
        this.f5496j.setOnClickListener(new a());
        this.f5494h.addView(this.f5496j, this.f5497k);
    }

    public x3(Context context) {
        this.f5491e = context;
        this.f5492f = (DevicePolicyManager) context.getSystemService("device_policy");
        this.f5494h = (WindowManager) context.getSystemService("window");
        this.f5493g = context.getSharedPreferences(context.getPackageName(), 0);
        this.f5494h.getDefaultDisplay().getRealMetrics(this.f5495i);
        this.f5487a = this.f5493g.getInt(f5483m, this.f5495i.widthPixels / 20);
        this.f5488b = this.f5493g.getInt(f5484n, this.f5495i.widthPixels / 20);
        this.f5489c = this.f5493g.getInt(f5485o, this.f5495i.widthPixels - this.f5487a);
        this.f5490d = this.f5493g.getInt(f5486p, this.f5495i.heightPixels - this.f5488b);
    }
}
