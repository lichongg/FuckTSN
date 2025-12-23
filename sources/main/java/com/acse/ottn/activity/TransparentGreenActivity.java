package com.acse.ottn.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.acse.ottn.R;
import com.acse.ottn.animator.SwitchOnAnimView;
import com.acse.ottn.c2;
import com.acse.ottn.g0;
import com.acse.ottn.j1;
import com.acse.ottn.k0;
import com.acse.ottn.util.HelpShopAppUtil;
import com.acse.ottn.z;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class TransparentGreenActivity extends z {

    /* renamed from: e, reason: collision with root package name */
    public RelativeLayout f4166e;

    /* renamed from: f, reason: collision with root package name */
    public RelativeLayout f4167f;

    /* renamed from: g, reason: collision with root package name */
    public Handler f4168g = new Handler();

    /* renamed from: h, reason: collision with root package name */
    public SwitchOnAnimView f4169h;

    /* renamed from: i, reason: collision with root package name */
    public SwitchOnAnimView f4170i;

    /* renamed from: j, reason: collision with root package name */
    public ImageView f4171j;

    /* renamed from: k, reason: collision with root package name */
    public TextView f4172k;

    /* renamed from: l, reason: collision with root package name */
    public TextView f4173l;

    /* renamed from: m, reason: collision with root package name */
    public String f4174m;

    /* renamed from: n, reason: collision with root package name */
    public TextView f4175n;

    /* renamed from: o, reason: collision with root package name */
    public TextView f4176o;

    /* renamed from: p, reason: collision with root package name */
    public AnimatorSet f4177p;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AnimatorSet animatorSet = TransparentGreenActivity.this.f4177p;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            if (TransparentGreenActivity.this.f4169h != null) {
                TransparentGreenActivity.this.f4169h.f();
                TransparentGreenActivity.this.f4169h = null;
            }
            if (TransparentGreenActivity.this.f4170i != null) {
                TransparentGreenActivity.this.f4170i.f();
                TransparentGreenActivity.this.f4170i = null;
            }
            TransparentGreenActivity.this.finishAndRemoveTask();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AnimatorSet animatorSet = TransparentGreenActivity.this.f4177p;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            if (TransparentGreenActivity.this.f4169h != null) {
                TransparentGreenActivity.this.f4169h.f();
                TransparentGreenActivity.this.f4169h = null;
            }
            if (TransparentGreenActivity.this.f4170i != null) {
                TransparentGreenActivity.this.f4170i.f();
                TransparentGreenActivity.this.f4170i = null;
            }
            TransparentGreenActivity.this.finishAndRemoveTask();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                TransparentGreenActivity.this.f4169h.b();
                TransparentGreenActivity.this.f4170i.b();
            } catch (Exception e6) {
                c2.b("TransparentActivity", e6.getMessage());
            }
        }
    }

    static {
        StubApp.interface11(9036);
    }

    public static Bitmap d() {
        PackageManager packageManager;
        ApplicationInfo applicationInfo = null;
        try {
            packageManager = HelpShopAppUtil.getContext().getPackageManager();
            try {
                applicationInfo = packageManager.getApplicationInfo(HelpShopAppUtil.getContext().getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        } catch (PackageManager.NameNotFoundException unused2) {
            packageManager = null;
        }
        return a(packageManager.getApplicationIcon(applicationInfo));
    }

    @Override // com.acse.ottn.z, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(Bundle bundle);

    public final void f() {
        ((TextView) findViewById(R.id.tv_step)).setText(Html.fromHtml("滑动列表找到“<font color=" + this.f4174m + ">" + k0.f4665a + "</font>”"));
        Spanned fromHtml = Html.fromHtml("👉【<font color=" + this.f4174m + ">" + k0.f4665a + "</font>】—请启用🏃");
        TextView textView = (TextView) findViewById(R.id.tv_permission_name);
        this.f4176o = textView;
        textView.setText(fromHtml);
        this.f4173l = (TextView) findViewById(R.id.tv_permission);
        ((TextView) findViewById(R.id.tv_step_two)).setText(Html.fromHtml("第二步：滑动列表，找到“<font color=" + this.f4174m + ">" + k0.f4665a + "</font>”"));
        this.f4172k = (TextView) findViewById(R.id.tv_step_one);
        StringBuilder sb = new StringBuilder();
        sb.append("第一步：滑动列表，打开“<font color=");
        sb.append(this.f4174m);
        sb.append(">已安装的服务</font>”");
        this.f4172k.setText(Html.fromHtml(sb.toString()));
    }

    @Override // com.acse.ottn.z, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        AnimatorSet animatorSet = this.f4177p;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        SwitchOnAnimView switchOnAnimView = this.f4169h;
        if (switchOnAnimView != null) {
            switchOnAnimView.f();
            this.f4169h = null;
        }
        SwitchOnAnimView switchOnAnimView2 = this.f4170i;
        if (switchOnAnimView2 != null) {
            switchOnAnimView2.f();
            this.f4170i = null;
        }
        super.onDestroy();
    }

    public static Bitmap a(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return createBitmap;
    }

    public String c() {
        return j1.c().b();
    }

    public final void e() {
        g0.a().b(this, this.f4175n);
        this.f4174m = g0.a().e(this);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x006d, code lost:
    
        if (r0.equals("oppo") == false) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void g() {
        /*
            Method dump skipped, instructions count: 952
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.acse.ottn.activity.TransparentGreenActivity.g():void");
    }

    public void a(ImageView imageView) {
        g0.a().a((Activity) this, imageView);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "translationY", -20.0f, 20.0f, -20.0f);
        ofFloat.setDuration(500L);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.start();
        AnimatorSet animatorSet = new AnimatorSet();
        this.f4177p = animatorSet;
        animatorSet.playTogether(ofFloat);
        this.f4177p.setStartDelay(10000L);
        this.f4177p.start();
    }
}
