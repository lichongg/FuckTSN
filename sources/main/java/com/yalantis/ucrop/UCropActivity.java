package com.yalantis.ucrop;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.transition.AutoTransition;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import com.stub.StubApp;
import com.yalantis.ucrop.b;
import com.yalantis.ucrop.model.AspectRatio;
import com.yalantis.ucrop.util.i;
import com.yalantis.ucrop.view.GestureCropImageView;
import com.yalantis.ucrop.view.OverlayView;
import com.yalantis.ucrop.view.TransformImageView;
import com.yalantis.ucrop.view.UCropView;
import com.yalantis.ucrop.view.widget.AspectRatioTextView;
import com.yalantis.ucrop.view.widget.HorizontalProgressWheelView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class UCropActivity extends AppCompatActivity {
    public static final int R0 = 90;
    public static final Bitmap.CompressFormat S0;
    public static final int T0 = 0;
    public static final int U0 = 1;
    public static final int V0 = 2;
    public static final int W0 = 3;
    private static final String X0 = "UCropActivity";
    private static final long Y0 = 50;
    private static final int Z0 = 3;

    /* renamed from: a1, reason: collision with root package name */
    private static final int f42637a1 = 15000;

    /* renamed from: b1, reason: collision with root package name */
    private static final int f42638b1 = 42;
    private ViewGroup F0;
    private ViewGroup G0;
    private TextView I0;
    private TextView J0;
    private View K0;
    private Transition L0;
    private String M;
    private int N;
    private int O;
    private int P;
    private int Q;
    private int R;

    @ColorInt
    private int S;

    @DrawableRes
    private int T;

    @DrawableRes
    private int U;
    private int V;
    private boolean W;
    private UCropView Y;
    private GestureCropImageView Z;

    /* renamed from: a0, reason: collision with root package name */
    private OverlayView f42639a0;

    /* renamed from: b0, reason: collision with root package name */
    private ViewGroup f42640b0;

    /* renamed from: c0, reason: collision with root package name */
    private ViewGroup f42641c0;

    /* renamed from: k0, reason: collision with root package name */
    private ViewGroup f42642k0;

    /* renamed from: p0, reason: collision with root package name */
    private ViewGroup f42643p0;
    private boolean X = true;
    private List<ViewGroup> H0 = new ArrayList();
    private Bitmap.CompressFormat M0 = S0;
    private int N0 = 90;
    private int[] O0 = {1, 2, 3};
    private TransformImageView.b P0 = new a();
    private final View.OnClickListener Q0 = new g();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface GestureTypes {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements TransformImageView.b {
        a() {
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.b
        public void a() {
            UCropActivity.this.Y.animate().alpha(1.0f).setDuration(300L).setInterpolator(new AccelerateInterpolator());
            UCropActivity.this.K0.setClickable(false);
            UCropActivity.this.X = false;
            UCropActivity.this.supportInvalidateOptionsMenu();
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.b
        public void b(@NonNull Exception exc) {
            UCropActivity.this.X(exc);
            UCropActivity.this.finish();
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.b
        public void c(float f6) {
            UCropActivity.this.Z(f6);
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.b
        public void d(float f6) {
            UCropActivity.this.U(f6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UCropActivity.this.Z.setTargetAspectRatio(((AspectRatioTextView) ((ViewGroup) view).getChildAt(0)).b(view.isSelected()));
            UCropActivity.this.Z.y();
            if (view.isSelected()) {
                return;
            }
            for (ViewGroup viewGroup : UCropActivity.this.H0) {
                viewGroup.setSelected(viewGroup == view);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements HorizontalProgressWheelView.a {
        c() {
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
        public void a() {
            UCropActivity.this.Z.y();
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
        public void b() {
            UCropActivity.this.Z.s();
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
        public void onScroll(float f6, float f7) {
            UCropActivity.this.Z.w(f6 / 42.0f);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UCropActivity.this.R();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UCropActivity.this.S(90);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class f implements HorizontalProgressWheelView.a {
        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
        public void onScroll(float f6, float f7) {
            if (f6 > 0.0f) {
                UCropActivity.this.Z.B(UCropActivity.this.Z.getCurrentScale() + (f6 * ((UCropActivity.this.Z.getMaxScale() - UCropActivity.this.Z.getMinScale()) / 15000.0f)));
            } else {
                UCropActivity.this.Z.D(UCropActivity.this.Z.getCurrentScale() + (f6 * ((UCropActivity.this.Z.getMaxScale() - UCropActivity.this.Z.getMinScale()) / 15000.0f)));
            }
        }

        f() {
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
        public void a() {
            UCropActivity.this.Z.y();
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
        public void b() {
            UCropActivity.this.Z.s();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!view.isSelected()) {
                UCropActivity.this.b0(view.getId());
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class h implements f3.a {
        h() {
        }

        @Override // f3.a
        public void a(@NonNull Uri uri, int i6, int i7, int i8, int i9) {
            UCropActivity uCropActivity = UCropActivity.this;
            uCropActivity.Y(uri, uCropActivity.Z.getTargetAspectRatio(), i6, i7, i8, i9);
            UCropActivity.this.finish();
        }

        @Override // f3.a
        public void b(@NonNull Throwable th) {
            UCropActivity.this.X(th);
            UCropActivity.this.finish();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(Bundle bundle);

    static {
        StubApp.interface11(43572);
        S0 = Bitmap.CompressFormat.JPEG;
    }

    private void M() {
        if (this.K0 == null) {
            this.K0 = new View(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(3, R.id.toolbar);
            this.K0.setLayoutParams(layoutParams);
            this.K0.setClickable(true);
        }
        ((RelativeLayout) findViewById(R.id.ucrop_photobox)).addView(this.K0);
    }

    private void N(int i6) {
        TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.ucrop_photobox), this.L0);
        this.f42642k0.findViewById(R.id.text_view_scale).setVisibility(i6 == R.id.state_scale ? 0 : 8);
        this.f42640b0.findViewById(R.id.text_view_crop).setVisibility(i6 == R.id.state_aspect_ratio ? 0 : 8);
        this.f42641c0.findViewById(R.id.text_view_rotate).setVisibility(i6 == R.id.state_rotate ? 0 : 8);
    }

    private void P() {
        UCropView uCropView = (UCropView) findViewById(R.id.ucrop);
        this.Y = uCropView;
        this.Z = uCropView.getCropImageView();
        this.f42639a0 = this.Y.getOverlayView();
        this.Z.setTransformImageListener(this.P0);
        ((ImageView) findViewById(R.id.image_view_logo)).setColorFilter(this.V, PorterDuff.Mode.SRC_ATOP);
        findViewById(R.id.ucrop_frame).setBackgroundColor(this.S);
    }

    private void Q(@NonNull Intent intent) {
        String stringExtra = intent.getStringExtra(b.a.f42711b);
        Bitmap.CompressFormat valueOf = !TextUtils.isEmpty(stringExtra) ? Bitmap.CompressFormat.valueOf(stringExtra) : null;
        if (valueOf == null) {
            valueOf = S0;
        }
        this.M0 = valueOf;
        this.N0 = intent.getIntExtra(b.a.f42712c, 90);
        int[] intArrayExtra = intent.getIntArrayExtra(b.a.f42713d);
        if (intArrayExtra != null && intArrayExtra.length == 3) {
            this.O0 = intArrayExtra;
        }
        this.Z.setMaxBitmapSize(intent.getIntExtra(b.a.f42714e, 0));
        this.Z.setMaxScaleMultiplier(intent.getFloatExtra(b.a.f42715f, 10.0f));
        this.Z.setImageToWrapCropBoundsAnimDuration(intent.getIntExtra(b.a.f42716g, 500));
        this.f42639a0.setFreestyleCropEnabled(intent.getBooleanExtra(b.a.B, false));
        this.f42639a0.setDimmedColor(intent.getIntExtra(b.a.f42717h, getResources().getColor(R.color.ucrop_color_default_dimmed)));
        this.f42639a0.setCircleDimmedLayer(intent.getBooleanExtra(b.a.f42718i, false));
        this.f42639a0.setShowCropFrame(intent.getBooleanExtra(b.a.f42719j, true));
        this.f42639a0.setCropFrameColor(intent.getIntExtra(b.a.f42720k, getResources().getColor(R.color.ucrop_color_default_crop_frame)));
        this.f42639a0.setCropFrameStrokeWidth(intent.getIntExtra(b.a.f42721l, getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_frame_stoke_width)));
        this.f42639a0.setShowCropGrid(intent.getBooleanExtra(b.a.f42722m, true));
        this.f42639a0.setCropGridRowCount(intent.getIntExtra(b.a.f42723n, 2));
        this.f42639a0.setCropGridColumnCount(intent.getIntExtra(b.a.f42724o, 2));
        this.f42639a0.setCropGridColor(intent.getIntExtra(b.a.f42725p, getResources().getColor(R.color.ucrop_color_default_crop_grid)));
        this.f42639a0.setCropGridStrokeWidth(intent.getIntExtra(b.a.f42726q, getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_grid_stoke_width)));
        float floatExtra = intent.getFloatExtra(com.yalantis.ucrop.b.f42705o, 0.0f);
        float floatExtra2 = intent.getFloatExtra(com.yalantis.ucrop.b.f42706p, 0.0f);
        int intExtra = intent.getIntExtra(b.a.C, 0);
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(b.a.D);
        if (floatExtra > 0.0f && floatExtra2 > 0.0f) {
            ViewGroup viewGroup = this.f42640b0;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            this.Z.setTargetAspectRatio(floatExtra / floatExtra2);
        } else if (parcelableArrayListExtra == null || intExtra >= parcelableArrayListExtra.size()) {
            this.Z.setTargetAspectRatio(0.0f);
        } else {
            this.Z.setTargetAspectRatio(((AspectRatio) parcelableArrayListExtra.get(intExtra)).b() / ((AspectRatio) parcelableArrayListExtra.get(intExtra)).c());
        }
        int intExtra2 = intent.getIntExtra(com.yalantis.ucrop.b.f42707q, 0);
        int intExtra3 = intent.getIntExtra(com.yalantis.ucrop.b.f42708r, 0);
        if (intExtra2 <= 0 || intExtra3 <= 0) {
            return;
        }
        this.Z.setMaxResultImageSizeX(intExtra2);
        this.Z.setMaxResultImageSizeY(intExtra3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        GestureCropImageView gestureCropImageView = this.Z;
        gestureCropImageView.w(-gestureCropImageView.getCurrentAngle());
        this.Z.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(int i6) {
        this.Z.w(i6);
        this.Z.y();
    }

    private void T(int i6) {
        GestureCropImageView gestureCropImageView = this.Z;
        int i7 = this.O0[i6];
        gestureCropImageView.setScaleEnabled(i7 == 3 || i7 == 1);
        GestureCropImageView gestureCropImageView2 = this.Z;
        int i8 = this.O0[i6];
        gestureCropImageView2.setRotateEnabled(i8 == 3 || i8 == 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(float f6) {
        TextView textView = this.I0;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%.1f°", Float.valueOf(f6)));
        }
    }

    private void V(@NonNull Intent intent) {
        Uri uri = (Uri) intent.getParcelableExtra(com.yalantis.ucrop.b.f42697g);
        Uri uri2 = (Uri) intent.getParcelableExtra(com.yalantis.ucrop.b.f42698h);
        Q(intent);
        if (uri == null || uri2 == null) {
            X(new NullPointerException(getString(R.string.ucrop_error_input_data_is_absent)));
            finish();
            return;
        }
        try {
            this.Z.m(uri, uri2);
        } catch (Exception e6) {
            X(e6);
            finish();
        }
    }

    private void W() {
        if (!this.W) {
            T(0);
        } else if (this.f42640b0.getVisibility() == 0) {
            b0(R.id.state_aspect_ratio);
        } else {
            b0(R.id.state_scale);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(float f6) {
        TextView textView = this.J0;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%d%%", Integer.valueOf((int) (f6 * 100.0f))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0(@IdRes int i6) {
        if (this.W) {
            ViewGroup viewGroup = this.f42640b0;
            int i7 = R.id.state_aspect_ratio;
            viewGroup.setSelected(i6 == i7);
            ViewGroup viewGroup2 = this.f42641c0;
            int i8 = R.id.state_rotate;
            viewGroup2.setSelected(i6 == i8);
            ViewGroup viewGroup3 = this.f42642k0;
            int i9 = R.id.state_scale;
            viewGroup3.setSelected(i6 == i9);
            this.f42643p0.setVisibility(i6 == i7 ? 0 : 8);
            this.F0.setVisibility(i6 == i8 ? 0 : 8);
            this.G0.setVisibility(i6 == i9 ? 0 : 8);
            N(i6);
            if (i6 == i9) {
                T(0);
            } else if (i6 == i8) {
                T(1);
            } else {
                T(2);
            }
        }
    }

    private void c0() {
        a0(this.O);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(this.N);
        toolbar.setTitleTextColor(this.R);
        TextView textView = (TextView) toolbar.findViewById(R.id.toolbar_title);
        textView.setTextColor(this.R);
        textView.setText(this.M);
        Drawable mutate = ContextCompat.getDrawable(this, this.T).mutate();
        mutate.setColorFilter(this.R, PorterDuff.Mode.SRC_ATOP);
        toolbar.setNavigationIcon(mutate);
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayShowTitleEnabled(false);
        }
    }

    private void d0(@NonNull Intent intent) {
        int intExtra = intent.getIntExtra(b.a.C, 0);
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(b.a.D);
        if (parcelableArrayListExtra == null || parcelableArrayListExtra.isEmpty()) {
            parcelableArrayListExtra = new ArrayList();
            parcelableArrayListExtra.add(new AspectRatio(null, 1.0f, 1.0f));
            parcelableArrayListExtra.add(new AspectRatio(null, 3.0f, 4.0f));
            parcelableArrayListExtra.add(new AspectRatio(getString(R.string.ucrop_label_original).toUpperCase(), 0.0f, 0.0f));
            parcelableArrayListExtra.add(new AspectRatio(null, 3.0f, 2.0f));
            parcelableArrayListExtra.add(new AspectRatio(null, 16.0f, 9.0f));
            intExtra = 2;
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.layout_aspect_ratio);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        Iterator it = parcelableArrayListExtra.iterator();
        while (it.hasNext()) {
            AspectRatio aspectRatio = (AspectRatio) it.next();
            FrameLayout frameLayout = (FrameLayout) getLayoutInflater().inflate(R.layout.ucrop_aspect_ratio, (ViewGroup) null);
            frameLayout.setLayoutParams(layoutParams);
            AspectRatioTextView aspectRatioTextView = (AspectRatioTextView) frameLayout.getChildAt(0);
            aspectRatioTextView.setActiveColor(this.P);
            aspectRatioTextView.setAspectRatio(aspectRatio);
            linearLayout.addView(frameLayout);
            this.H0.add(frameLayout);
        }
        this.H0.get(intExtra).setSelected(true);
        Iterator<ViewGroup> it2 = this.H0.iterator();
        while (it2.hasNext()) {
            it2.next().setOnClickListener(new b());
        }
    }

    private void e0() {
        this.I0 = (TextView) findViewById(R.id.text_view_rotate);
        int i6 = R.id.rotate_scroll_wheel;
        ((HorizontalProgressWheelView) findViewById(i6)).setScrollingListener(new c());
        ((HorizontalProgressWheelView) findViewById(i6)).setMiddleLineColor(this.P);
        findViewById(R.id.wrapper_reset_rotate).setOnClickListener(new d());
        findViewById(R.id.wrapper_rotate_by_angle).setOnClickListener(new e());
    }

    private void f0() {
        this.J0 = (TextView) findViewById(R.id.text_view_scale);
        int i6 = R.id.scale_scroll_wheel;
        ((HorizontalProgressWheelView) findViewById(i6)).setScrollingListener(new f());
        ((HorizontalProgressWheelView) findViewById(i6)).setMiddleLineColor(this.P);
    }

    private void g0() {
        ImageView imageView = (ImageView) findViewById(R.id.image_view_state_scale);
        ImageView imageView2 = (ImageView) findViewById(R.id.image_view_state_rotate);
        ImageView imageView3 = (ImageView) findViewById(R.id.image_view_state_aspect_ratio);
        imageView.setImageDrawable(new i(imageView.getDrawable(), this.Q));
        imageView2.setImageDrawable(new i(imageView2.getDrawable(), this.Q));
        imageView3.setImageDrawable(new i(imageView3.getDrawable(), this.Q));
    }

    private void h0(@NonNull Intent intent) {
        this.O = intent.getIntExtra(b.a.f42728s, ContextCompat.getColor(this, R.color.ucrop_color_statusbar));
        this.N = intent.getIntExtra(b.a.f42727r, ContextCompat.getColor(this, R.color.ucrop_color_toolbar));
        this.P = intent.getIntExtra(b.a.f42729t, ContextCompat.getColor(this, R.color.ucrop_color_widget_background));
        this.Q = intent.getIntExtra(b.a.f42730u, ContextCompat.getColor(this, R.color.ucrop_color_active_controls_color));
        this.R = intent.getIntExtra(b.a.f42731v, ContextCompat.getColor(this, R.color.ucrop_color_toolbar_widget));
        this.T = intent.getIntExtra(b.a.f42733x, R.drawable.ucrop_ic_cross);
        this.U = intent.getIntExtra(b.a.f42734y, R.drawable.ucrop_ic_done);
        String stringExtra = intent.getStringExtra(b.a.f42732w);
        this.M = stringExtra;
        if (stringExtra == null) {
            stringExtra = getResources().getString(R.string.ucrop_label_edit_photo);
        }
        this.M = stringExtra;
        this.V = intent.getIntExtra(b.a.f42735z, ContextCompat.getColor(this, R.color.ucrop_color_default_logo));
        this.W = !intent.getBooleanExtra(b.a.A, false);
        this.S = intent.getIntExtra(b.a.E, ContextCompat.getColor(this, R.color.ucrop_color_crop_background));
        c0();
        P();
        if (this.W) {
            ViewGroup viewGroup = (ViewGroup) ((ViewGroup) findViewById(R.id.ucrop_photobox)).findViewById(R.id.controls_wrapper);
            viewGroup.setVisibility(0);
            viewGroup.setBackgroundColor(this.S);
            LayoutInflater.from(this).inflate(R.layout.ucrop_controls, viewGroup, true);
            AutoTransition autoTransition = new AutoTransition();
            this.L0 = autoTransition;
            autoTransition.setDuration(50L);
            ViewGroup viewGroup2 = (ViewGroup) findViewById(R.id.state_aspect_ratio);
            this.f42640b0 = viewGroup2;
            viewGroup2.setOnClickListener(this.Q0);
            ViewGroup viewGroup3 = (ViewGroup) findViewById(R.id.state_rotate);
            this.f42641c0 = viewGroup3;
            viewGroup3.setOnClickListener(this.Q0);
            ViewGroup viewGroup4 = (ViewGroup) findViewById(R.id.state_scale);
            this.f42642k0 = viewGroup4;
            viewGroup4.setOnClickListener(this.Q0);
            this.f42643p0 = (ViewGroup) findViewById(R.id.layout_aspect_ratio);
            this.F0 = (ViewGroup) findViewById(R.id.layout_rotate_wheel);
            this.G0 = (ViewGroup) findViewById(R.id.layout_scale_wheel);
            d0(intent);
            e0();
            f0();
            g0();
        }
    }

    protected void O() {
        this.K0.setClickable(true);
        this.X = true;
        supportInvalidateOptionsMenu();
        this.Z.t(this.M0, this.N0, new h());
    }

    protected void X(Throwable th) {
        setResult(96, new Intent().putExtra(com.yalantis.ucrop.b.f42704n, th));
    }

    protected void Y(Uri uri, float f6, int i6, int i7, int i8, int i9) {
        setResult(-1, new Intent().putExtra(com.yalantis.ucrop.b.f42698h, uri).putExtra(com.yalantis.ucrop.b.f42699i, f6).putExtra(com.yalantis.ucrop.b.f42700j, i8).putExtra(com.yalantis.ucrop.b.f42701k, i9).putExtra(com.yalantis.ucrop.b.f42702l, i6).putExtra(com.yalantis.ucrop.b.f42703m, i7));
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.menu_crop).setVisible(!this.X);
        menu.findItem(R.id.menu_loader).setVisible(this.X);
        return super.onPrepareOptionsMenu(menu);
    }

    @TargetApi(21)
    private void a0(@ColorInt int i6) {
        Window window = getWindow();
        if (window != null) {
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(i6);
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.ucrop_menu_activity, menu);
        MenuItem findItem = menu.findItem(R.id.menu_loader);
        Drawable icon = findItem.getIcon();
        if (icon != null) {
            try {
                icon.mutate();
                icon.setColorFilter(this.R, PorterDuff.Mode.SRC_ATOP);
                findItem.setIcon(icon);
            } catch (IllegalStateException e6) {
                String.format("%s - %s", e6.getMessage(), getString(R.string.ucrop_mutate_exception_hint));
            }
            ((Animatable) findItem.getIcon()).start();
        }
        MenuItem findItem2 = menu.findItem(R.id.menu_crop);
        Drawable drawable = ContextCompat.getDrawable(this, this.U);
        if (drawable != null) {
            drawable.mutate();
            drawable.setColorFilter(this.R, PorterDuff.Mode.SRC_ATOP);
            findItem2.setIcon(drawable);
        }
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.menu_crop) {
            O();
            return true;
        }
        if (menuItem.getItemId() == 16908332) {
            s0();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        GestureCropImageView gestureCropImageView = this.Z;
        if (gestureCropImageView != null) {
            gestureCropImageView.s();
        }
    }
}
