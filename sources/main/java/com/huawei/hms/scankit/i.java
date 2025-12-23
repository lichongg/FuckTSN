package com.huawei.hms.scankit;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.huawei.hms.feature.DynamicModuleInitializer;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.scankit.p.i8;
import com.huawei.hms.scankit.p.o4;
import com.huawei.hms.scankit.p.w7;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class i extends e {
    protected ViewfinderView A;
    protected ImageView B;
    private ImageView C;
    private TextView D;
    private IObjectWrapper E;
    private RelativeLayout F;
    private int G;
    private int H;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RelativeLayout f33953a;

        a(RelativeLayout relativeLayout) {
            this.f33953a = relativeLayout;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (i.this.G == this.f33953a.getHeight() || i.this.H == this.f33953a.getWidth()) {
                return;
            }
            i.this.G = this.f33953a.getHeight();
            i.this.H = this.f33953a.getWidth();
            i.this.p();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            View.OnClickListener onClickListener = i.this.f33925i;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.isSelected()) {
                i.this.f();
                i.this.o();
                i.this.C.setContentDescription(i.this.C.getResources().getString(R.string.scankit_light));
            } else {
                i.this.g();
                view.setSelected(true);
                TextView textView = i.this.D;
                int i6 = R.string.scankit_light_off;
                textView.setText(i6);
                i.this.C.setContentDescription(i.this.C.getResources().getString(i6));
            }
        }
    }

    public i(Context context, int i6, IObjectWrapper iObjectWrapper, boolean z5, boolean z6) {
        super(context, i6, null, iObjectWrapper, z5, false, z6);
        this.G = 0;
        this.H = 0;
        this.E = iObjectWrapper;
        this.f33919c = context;
        this.f33918b = i6;
        this.f33932p = z5;
        this.f33930n = new Rect(-1, -1, -1, -1);
        this.f33935s = z6;
    }

    private boolean n() {
        return this.f33919c.getResources().getDisplayMetrics().widthPixels > 1990 && this.f33919c.getResources().getDisplayMetrics().widthPixels < 2300 && this.f33919c.getResources().getDisplayMetrics().heightPixels > 2190 && this.f33919c.getResources().getDisplayMetrics().heightPixels < 2600;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        ImageView imageView = this.C;
        if (imageView != null) {
            imageView.setSelected(false);
        }
        TextView textView = this.D;
        if (textView != null) {
            textView.setText(R.string.scankit_light);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if ((w7.f(this.f33919c) && w7.b((Activity) this.f33919c)) || this.F == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.F.getLayoutParams().width, this.F.getLayoutParams().height);
        layoutParams.setMargins(0, m(), 0, 0);
        this.F.setLayoutParams(layoutParams);
    }

    @Override // com.huawei.hms.scankit.e
    protected void c() {
        super.c();
        o4.d("Scankit", "initlight mIsContains " + this.f33926j);
        if (!this.f33926j && this.f33936t && w7.a(this.f33919c)) {
            o4.d("Scankit", "initlight open");
            this.f33939w.setVisibility(0);
        }
    }

    @Override // com.huawei.hms.scankit.e
    protected ProviderRemoteView d() {
        return new ProviderRemoteView(DynamicModuleInitializer.getContext() == null ? this.f33919c : DynamicModuleInitializer.getContext(), false);
    }

    @Override // com.huawei.hms.scankit.e
    protected void e() {
        ProviderRemoteView d6 = d();
        this.f33920d = d6;
        this.F = (RelativeLayout) d6.findViewById(R.id.scan_title);
        p();
        RelativeLayout relativeLayout = (RelativeLayout) this.f33920d.findViewById(R.id.scan_parent_view);
        if (relativeLayout != null) {
            relativeLayout.getViewTreeObserver().addOnGlobalLayoutListener(new a(relativeLayout));
        }
        this.f33921e = (TextureView) this.f33920d.findViewById(R.id.surfaceView);
        this.A = (ViewfinderView) this.f33920d.findViewById(R.id.viewfinderView);
        com.huawei.hms.scankit.b bVar = new com.huawei.hms.scankit.b(this.f33919c, this.f33921e, this.A, this.f33930n, this.f33918b, this.E, this.f33932p, "DefaultView", false);
        this.f33922f = bVar;
        bVar.b(this.f33935s);
        ImageView imageView = (ImageView) this.f33920d.findViewById(R.id.img_btn);
        this.B = imageView;
        imageView.setOnClickListener(new b());
        this.f33939w = (LinearLayout) this.f33920d.findViewById(R.id.flash_light_ll);
        this.C = (ImageView) this.f33920d.findViewById(R.id.ivFlash);
        c();
        this.C.setOnClickListener(new c());
        this.D = (TextView) this.f33920d.findViewById(R.id.flash_light_text);
        a((Point) null, true);
        j();
        k();
    }

    @Override // com.huawei.hms.scankit.e, com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public IObjectWrapper getView() {
        return ObjectWrapper.wrap(this.f33920d);
    }

    protected void i() {
        RelativeLayout relativeLayout = (RelativeLayout) this.f33920d.findViewById(R.id.scan_parent_view);
        this.f33939w = new LinearLayout(this.f33919c);
        o4.d("Scankit", "initlight adJustLightLayout open");
        this.f33939w.setVisibility(0);
        this.f33939w.setOrientation(1);
        ViewGroup viewGroup = (ViewGroup) this.C.getParent();
        viewGroup.removeView(this.C);
        viewGroup.removeView(this.D);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = i8.a(this.f33919c, 6);
        this.f33939w.setGravity(16);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i8.a(this.f33919c, 214), -1);
        layoutParams2.addRule(11);
        layoutParams2.addRule(15);
        LinearLayout linearLayout = new LinearLayout(this.f33919c);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.setMargins(i8.a(this.f33919c, 24), 0, i8.a(this.f33919c, 24), 0);
        linearLayout.setLayoutParams(layoutParams3);
        linearLayout.setGravity(16);
        linearLayout.setOrientation(1);
        ((LinearLayout.LayoutParams) this.C.getLayoutParams()).setMargins(0, 0, 0, 0);
        linearLayout.addView(this.C);
        linearLayout.addView(this.D, layoutParams);
        this.f33939w.addView(linearLayout);
        relativeLayout.addView(this.f33939w, layoutParams2);
    }

    protected void k() {
        ViewGroup.LayoutParams layoutParams = this.f33939w.getLayoutParams();
        Context context = this.f33919c;
        if (context == null || context.getResources() == null || this.f33919c.getResources().getDisplayMetrics() == null || !n() || !(layoutParams instanceof FrameLayout.LayoutParams)) {
            return;
        }
        ((FrameLayout.LayoutParams) layoutParams).bottomMargin = 150;
        this.f33939w.setLayoutParams(layoutParams);
    }

    protected int m() {
        int identifier;
        Context context = this.f33919c;
        if (context == null || context.getResources() == null || (identifier = this.f33919c.getResources().getIdentifier("status_bar_height", "dimen", FaceEnvironment.OS)) <= 0) {
            return 0;
        }
        return this.f33919c.getResources().getDimensionPixelSize(identifier);
    }

    @Override // com.huawei.hms.scankit.e, com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void onResume() {
        com.huawei.hms.scankit.b bVar = this.f33922f;
        if (bVar.f33837i == null) {
            bVar.f33837i = this.f33921e;
        }
        bVar.f();
        o();
        SensorManager sensorManager = this.f33924h;
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(5), 2);
    }

    protected void j() {
        if (Locale.getDefault() != null && w7.d()) {
            TextView textView = (TextView) this.f33920d.findViewById(R.id.title_scan);
            ImageView imageView = (ImageView) this.f33920d.findViewById(R.id.back_img_in);
            if (imageView != null) {
                imageView.setRotation(180.0f);
            }
            if (textView != null) {
                ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
                if (layoutParams instanceof RelativeLayout.LayoutParams) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                    layoutParams2.addRule(1, R.id.img_btn);
                    layoutParams2.rightMargin = 200;
                    textView.setLayoutParams(layoutParams);
                }
            }
            k();
        }
    }

    protected int l() {
        int m6 = m();
        Context context = this.f33919c;
        if (context != null && context.getResources() != null) {
            try {
                int identifier = this.f33919c.getResources().getIdentifier("hw_multiwindow_height_of_drag_bar", "dimen", "androidhwext");
                if (identifier > 0) {
                    return this.f33919c.getResources().getDimensionPixelSize(identifier);
                }
            } catch (Exception e6) {
                e6.getMessage();
            }
        }
        return m6;
    }

    @Override // com.huawei.hms.scankit.e, com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.huawei.hms.scankit.e, com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void setOnClickListener(IObjectWrapper iObjectWrapper) {
        this.f33925i = (View.OnClickListener) ObjectWrapper.unwrap(iObjectWrapper);
    }

    @Override // com.huawei.hms.scankit.e, com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void turnOffLight() throws RemoteException {
    }

    @Override // com.huawei.hms.scankit.e, com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void turnOnLight() throws RemoteException {
    }

    @Override // com.huawei.hms.scankit.e, android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i6) {
    }
}
