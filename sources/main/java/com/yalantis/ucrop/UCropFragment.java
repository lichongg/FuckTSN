package com.yalantis.ucrop;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.transition.AutoTransition;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import com.yalantis.ucrop.b;
import com.yalantis.ucrop.model.AspectRatio;
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
public class UCropFragment extends Fragment {
    public static final int B = 90;
    public static final Bitmap.CompressFormat C = Bitmap.CompressFormat.JPEG;
    public static final int D = 0;
    public static final int E = 1;
    public static final int F = 2;
    public static final int G = 3;
    public static final String H = "UCropFragment";
    private static final long I = 50;
    private static final int J = 3;
    private static final int K = 15000;
    private static final int L = 42;

    /* renamed from: c, reason: collision with root package name */
    private com.yalantis.ucrop.c f42652c;

    /* renamed from: d, reason: collision with root package name */
    private int f42653d;

    /* renamed from: e, reason: collision with root package name */
    private int f42654e;

    /* renamed from: f, reason: collision with root package name */
    @ColorInt
    private int f42655f;

    /* renamed from: g, reason: collision with root package name */
    private int f42656g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f42657h;

    /* renamed from: i, reason: collision with root package name */
    private Transition f42658i;

    /* renamed from: j, reason: collision with root package name */
    private UCropView f42659j;

    /* renamed from: k, reason: collision with root package name */
    private GestureCropImageView f42660k;

    /* renamed from: l, reason: collision with root package name */
    private OverlayView f42661l;

    /* renamed from: m, reason: collision with root package name */
    private ViewGroup f42662m;

    /* renamed from: n, reason: collision with root package name */
    private ViewGroup f42663n;

    /* renamed from: o, reason: collision with root package name */
    private ViewGroup f42664o;

    /* renamed from: p, reason: collision with root package name */
    private ViewGroup f42665p;

    /* renamed from: q, reason: collision with root package name */
    private ViewGroup f42666q;

    /* renamed from: r, reason: collision with root package name */
    private ViewGroup f42667r;

    /* renamed from: t, reason: collision with root package name */
    private TextView f42669t;

    /* renamed from: u, reason: collision with root package name */
    private TextView f42670u;

    /* renamed from: v, reason: collision with root package name */
    private View f42671v;

    /* renamed from: s, reason: collision with root package name */
    private List<ViewGroup> f42668s = new ArrayList();

    /* renamed from: w, reason: collision with root package name */
    private Bitmap.CompressFormat f42672w = C;

    /* renamed from: x, reason: collision with root package name */
    private int f42673x = 90;

    /* renamed from: y, reason: collision with root package name */
    private int[] f42674y = {1, 2, 3};

    /* renamed from: z, reason: collision with root package name */
    private TransformImageView.b f42675z = new a();
    private final View.OnClickListener A = new g();

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
            UCropFragment.this.f42659j.animate().alpha(1.0f).setDuration(300L).setInterpolator(new AccelerateInterpolator());
            UCropFragment.this.f42671v.setClickable(false);
            UCropFragment.this.f42652c.a(false);
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.b
        public void b(@NonNull Exception exc) {
            UCropFragment.this.f42652c.b(UCropFragment.this.M(exc));
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.b
        public void c(float f6) {
            UCropFragment.this.Y(f6);
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.b
        public void d(float f6) {
            UCropFragment.this.U(f6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UCropFragment.this.f42660k.setTargetAspectRatio(((AspectRatioTextView) ((ViewGroup) view).getChildAt(0)).b(view.isSelected()));
            UCropFragment.this.f42660k.y();
            if (view.isSelected()) {
                return;
            }
            for (ViewGroup viewGroup : UCropFragment.this.f42668s) {
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
            UCropFragment.this.f42660k.y();
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
        public void b() {
            UCropFragment.this.f42660k.s();
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
        public void onScroll(float f6, float f7) {
            UCropFragment.this.f42660k.w(f6 / 42.0f);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UCropFragment.this.R();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UCropFragment.this.S(90);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class f implements HorizontalProgressWheelView.a {
        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
        public void onScroll(float f6, float f7) {
            if (f6 > 0.0f) {
                UCropFragment.this.f42660k.B(UCropFragment.this.f42660k.getCurrentScale() + (f6 * ((UCropFragment.this.f42660k.getMaxScale() - UCropFragment.this.f42660k.getMinScale()) / 15000.0f)));
            } else {
                UCropFragment.this.f42660k.D(UCropFragment.this.f42660k.getCurrentScale() + (f6 * ((UCropFragment.this.f42660k.getMaxScale() - UCropFragment.this.f42660k.getMinScale()) / 15000.0f)));
            }
        }

        f() {
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
        public void a() {
            UCropFragment.this.f42660k.y();
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
        public void b() {
            UCropFragment.this.f42660k.s();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!view.isSelected()) {
                UCropFragment.this.Z(view.getId());
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class h implements f3.a {
        h() {
        }

        @Override // f3.a
        public void a(@NonNull Uri uri, int i6, int i7, int i8, int i9) {
            com.yalantis.ucrop.c cVar = UCropFragment.this.f42652c;
            UCropFragment uCropFragment = UCropFragment.this;
            cVar.b(uCropFragment.N(uri, uCropFragment.f42660k.getTargetAspectRatio(), i6, i7, i8, i9));
            UCropFragment.this.f42652c.a(false);
        }

        @Override // f3.a
        public void b(@NonNull Throwable th) {
            UCropFragment.this.f42652c.b(UCropFragment.this.M(th));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class i {

        /* renamed from: a, reason: collision with root package name */
        public int f42684a;

        /* renamed from: b, reason: collision with root package name */
        public Intent f42685b;

        public i(int i6, Intent intent) {
            this.f42684a = i6;
            this.f42685b = intent;
        }
    }

    private void O(View view) {
        UCropView uCropView = (UCropView) view.findViewById(R.id.ucrop);
        this.f42659j = uCropView;
        this.f42660k = uCropView.getCropImageView();
        this.f42661l = this.f42659j.getOverlayView();
        this.f42660k.setTransformImageListener(this.f42675z);
        ((ImageView) view.findViewById(R.id.image_view_logo)).setColorFilter(this.f42656g, PorterDuff.Mode.SRC_ATOP);
        view.findViewById(R.id.ucrop_frame).setBackgroundColor(this.f42655f);
    }

    public static UCropFragment P(Bundle bundle) {
        UCropFragment uCropFragment = new UCropFragment();
        uCropFragment.setArguments(bundle);
        return uCropFragment;
    }

    private void Q(@NonNull Bundle bundle) {
        String string = bundle.getString(b.a.f42711b);
        Bitmap.CompressFormat valueOf = !TextUtils.isEmpty(string) ? Bitmap.CompressFormat.valueOf(string) : null;
        if (valueOf == null) {
            valueOf = C;
        }
        this.f42672w = valueOf;
        this.f42673x = bundle.getInt(b.a.f42712c, 90);
        int[] intArray = bundle.getIntArray(b.a.f42713d);
        if (intArray != null && intArray.length == 3) {
            this.f42674y = intArray;
        }
        this.f42660k.setMaxBitmapSize(bundle.getInt(b.a.f42714e, 0));
        this.f42660k.setMaxScaleMultiplier(bundle.getFloat(b.a.f42715f, 10.0f));
        this.f42660k.setImageToWrapCropBoundsAnimDuration(bundle.getInt(b.a.f42716g, 500));
        this.f42661l.setFreestyleCropEnabled(bundle.getBoolean(b.a.B, false));
        this.f42661l.setDimmedColor(bundle.getInt(b.a.f42717h, getResources().getColor(R.color.ucrop_color_default_dimmed)));
        this.f42661l.setCircleDimmedLayer(bundle.getBoolean(b.a.f42718i, false));
        this.f42661l.setShowCropFrame(bundle.getBoolean(b.a.f42719j, true));
        this.f42661l.setCropFrameColor(bundle.getInt(b.a.f42720k, getResources().getColor(R.color.ucrop_color_default_crop_frame)));
        this.f42661l.setCropFrameStrokeWidth(bundle.getInt(b.a.f42721l, getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_frame_stoke_width)));
        this.f42661l.setShowCropGrid(bundle.getBoolean(b.a.f42722m, true));
        this.f42661l.setCropGridRowCount(bundle.getInt(b.a.f42723n, 2));
        this.f42661l.setCropGridColumnCount(bundle.getInt(b.a.f42724o, 2));
        this.f42661l.setCropGridColor(bundle.getInt(b.a.f42725p, getResources().getColor(R.color.ucrop_color_default_crop_grid)));
        this.f42661l.setCropGridStrokeWidth(bundle.getInt(b.a.f42726q, getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_grid_stoke_width)));
        float f6 = bundle.getFloat(com.yalantis.ucrop.b.f42705o, 0.0f);
        float f7 = bundle.getFloat(com.yalantis.ucrop.b.f42706p, 0.0f);
        int i6 = bundle.getInt(b.a.C, 0);
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(b.a.D);
        if (f6 > 0.0f && f7 > 0.0f) {
            ViewGroup viewGroup = this.f42662m;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            this.f42660k.setTargetAspectRatio(f6 / f7);
        } else if (parcelableArrayList == null || i6 >= parcelableArrayList.size()) {
            this.f42660k.setTargetAspectRatio(0.0f);
        } else {
            this.f42660k.setTargetAspectRatio(((AspectRatio) parcelableArrayList.get(i6)).b() / ((AspectRatio) parcelableArrayList.get(i6)).c());
        }
        int i7 = bundle.getInt(com.yalantis.ucrop.b.f42707q, 0);
        int i8 = bundle.getInt(com.yalantis.ucrop.b.f42708r, 0);
        if (i7 <= 0 || i8 <= 0) {
            return;
        }
        this.f42660k.setMaxResultImageSizeX(i7);
        this.f42660k.setMaxResultImageSizeY(i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        GestureCropImageView gestureCropImageView = this.f42660k;
        gestureCropImageView.w(-gestureCropImageView.getCurrentAngle());
        this.f42660k.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(int i6) {
        this.f42660k.w(i6);
        this.f42660k.y();
    }

    private void T(int i6) {
        GestureCropImageView gestureCropImageView = this.f42660k;
        int i7 = this.f42674y[i6];
        gestureCropImageView.setScaleEnabled(i7 == 3 || i7 == 1);
        GestureCropImageView gestureCropImageView2 = this.f42660k;
        int i8 = this.f42674y[i6];
        gestureCropImageView2.setRotateEnabled(i8 == 3 || i8 == 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(float f6) {
        TextView textView = this.f42669t;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%.1f°", Float.valueOf(f6)));
        }
    }

    private void W(@NonNull Bundle bundle) {
        Uri uri = (Uri) bundle.getParcelable(com.yalantis.ucrop.b.f42697g);
        Uri uri2 = (Uri) bundle.getParcelable(com.yalantis.ucrop.b.f42698h);
        Q(bundle);
        if (uri == null || uri2 == null) {
            this.f42652c.b(M(new NullPointerException(getString(R.string.ucrop_error_input_data_is_absent))));
            return;
        }
        try {
            this.f42660k.m(uri, uri2);
        } catch (Exception e6) {
            this.f42652c.b(M(e6));
        }
    }

    private void X() {
        if (!this.f42657h) {
            T(0);
        } else if (this.f42662m.getVisibility() == 0) {
            Z(R.id.state_aspect_ratio);
        } else {
            Z(R.id.state_scale);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(float f6) {
        TextView textView = this.f42670u;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%d%%", Integer.valueOf((int) (f6 * 100.0f))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(@IdRes int i6) {
        if (this.f42657h) {
            ViewGroup viewGroup = this.f42662m;
            int i7 = R.id.state_aspect_ratio;
            viewGroup.setSelected(i6 == i7);
            ViewGroup viewGroup2 = this.f42663n;
            int i8 = R.id.state_rotate;
            viewGroup2.setSelected(i6 == i8);
            ViewGroup viewGroup3 = this.f42664o;
            int i9 = R.id.state_scale;
            viewGroup3.setSelected(i6 == i9);
            this.f42665p.setVisibility(i6 == i7 ? 0 : 8);
            this.f42666q.setVisibility(i6 == i8 ? 0 : 8);
            this.f42667r.setVisibility(i6 == i9 ? 0 : 8);
            m(i6);
            if (i6 == i9) {
                T(0);
            } else if (i6 == i8) {
                T(1);
            } else {
                T(2);
            }
        }
    }

    private void a0(@NonNull Bundle bundle, View view) {
        int i6 = bundle.getInt(b.a.C, 0);
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(b.a.D);
        if (parcelableArrayList == null || parcelableArrayList.isEmpty()) {
            parcelableArrayList = new ArrayList();
            parcelableArrayList.add(new AspectRatio(null, 1.0f, 1.0f));
            parcelableArrayList.add(new AspectRatio(null, 3.0f, 4.0f));
            parcelableArrayList.add(new AspectRatio(getString(R.string.ucrop_label_original).toUpperCase(), 0.0f, 0.0f));
            parcelableArrayList.add(new AspectRatio(null, 3.0f, 2.0f));
            parcelableArrayList.add(new AspectRatio(null, 16.0f, 9.0f));
            i6 = 2;
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.layout_aspect_ratio);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        Iterator it = parcelableArrayList.iterator();
        while (it.hasNext()) {
            AspectRatio aspectRatio = (AspectRatio) it.next();
            FrameLayout frameLayout = (FrameLayout) getLayoutInflater().inflate(R.layout.ucrop_aspect_ratio, (ViewGroup) null);
            frameLayout.setLayoutParams(layoutParams);
            AspectRatioTextView aspectRatioTextView = (AspectRatioTextView) frameLayout.getChildAt(0);
            aspectRatioTextView.setActiveColor(this.f42654e);
            aspectRatioTextView.setAspectRatio(aspectRatio);
            linearLayout.addView(frameLayout);
            this.f42668s.add(frameLayout);
        }
        this.f42668s.get(i6).setSelected(true);
        Iterator<ViewGroup> it2 = this.f42668s.iterator();
        while (it2.hasNext()) {
            it2.next().setOnClickListener(new b());
        }
    }

    private void b0(View view) {
        this.f42669t = (TextView) view.findViewById(R.id.text_view_rotate);
        int i6 = R.id.rotate_scroll_wheel;
        ((HorizontalProgressWheelView) view.findViewById(i6)).setScrollingListener(new c());
        ((HorizontalProgressWheelView) view.findViewById(i6)).setMiddleLineColor(this.f42654e);
        view.findViewById(R.id.wrapper_reset_rotate).setOnClickListener(new d());
        view.findViewById(R.id.wrapper_rotate_by_angle).setOnClickListener(new e());
    }

    private void c0(View view) {
        this.f42670u = (TextView) view.findViewById(R.id.text_view_scale);
        int i6 = R.id.scale_scroll_wheel;
        ((HorizontalProgressWheelView) view.findViewById(i6)).setScrollingListener(new f());
        ((HorizontalProgressWheelView) view.findViewById(i6)).setMiddleLineColor(this.f42654e);
    }

    private void d0(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.image_view_state_scale);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.image_view_state_rotate);
        ImageView imageView3 = (ImageView) view.findViewById(R.id.image_view_state_aspect_ratio);
        imageView.setImageDrawable(new com.yalantis.ucrop.util.i(imageView.getDrawable(), this.f42653d));
        imageView2.setImageDrawable(new com.yalantis.ucrop.util.i(imageView2.getDrawable(), this.f42653d));
        imageView3.setImageDrawable(new com.yalantis.ucrop.util.i(imageView3.getDrawable(), this.f42653d));
    }

    private void l(View view) {
        if (this.f42671v == null) {
            this.f42671v = new View(getContext());
            this.f42671v.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.f42671v.setClickable(true);
        }
        ((RelativeLayout) view.findViewById(R.id.ucrop_photobox)).addView(this.f42671v);
    }

    protected i M(Throwable th) {
        return new i(96, new Intent().putExtra(com.yalantis.ucrop.b.f42704n, th));
    }

    protected i N(Uri uri, float f6, int i6, int i7, int i8, int i9) {
        return new i(-1, new Intent().putExtra(com.yalantis.ucrop.b.f42698h, uri).putExtra(com.yalantis.ucrop.b.f42699i, f6).putExtra(com.yalantis.ucrop.b.f42700j, i8).putExtra(com.yalantis.ucrop.b.f42701k, i9).putExtra(com.yalantis.ucrop.b.f42702l, i6).putExtra(com.yalantis.ucrop.b.f42703m, i7));
    }

    public void V(com.yalantis.ucrop.c cVar) {
        this.f42652c = cVar;
    }

    public void n() {
        this.f42671v.setClickable(true);
        this.f42652c.a(true);
        this.f42660k.t(this.f42672w, this.f42673x, new h());
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.ucrop_fragment_photobox, viewGroup, false);
        Bundle arguments = getArguments();
        e0(inflate, arguments);
        W(arguments);
        X();
        l(inflate);
        return inflate;
    }

    private void m(int i6) {
        int i7;
        int i8;
        if (getView() != null) {
            TransitionManager.beginDelayedTransition((ViewGroup) getView().findViewById(R.id.ucrop_photobox), this.f42658i);
        }
        View findViewById = this.f42664o.findViewById(R.id.text_view_scale);
        int i9 = 8;
        if (i6 == R.id.state_scale) {
            i7 = 0;
        } else {
            i7 = 8;
        }
        findViewById.setVisibility(i7);
        View findViewById2 = this.f42662m.findViewById(R.id.text_view_crop);
        if (i6 == R.id.state_aspect_ratio) {
            i8 = 0;
        } else {
            i8 = 8;
        }
        findViewById2.setVisibility(i8);
        View findViewById3 = this.f42663n.findViewById(R.id.text_view_rotate);
        if (i6 == R.id.state_rotate) {
            i9 = 0;
        }
        findViewById3.setVisibility(i9);
    }

    public void e0(View view, Bundle bundle) {
        this.f42654e = bundle.getInt(b.a.f42729t, ContextCompat.getColor(getContext(), R.color.ucrop_color_widget_background));
        this.f42653d = bundle.getInt(b.a.f42729t, ContextCompat.getColor(getContext(), R.color.ucrop_color_widget_active));
        this.f42656g = bundle.getInt(b.a.f42735z, ContextCompat.getColor(getContext(), R.color.ucrop_color_default_logo));
        this.f42657h = !bundle.getBoolean(b.a.A, false);
        this.f42655f = bundle.getInt(b.a.E, ContextCompat.getColor(getContext(), R.color.ucrop_color_crop_background));
        O(view);
        this.f42652c.a(true);
        if (this.f42657h) {
            ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.controls_wrapper);
            viewGroup.setVisibility(0);
            viewGroup.setBackgroundColor(this.f42655f);
            LayoutInflater.from(getContext()).inflate(R.layout.ucrop_controls, viewGroup, true);
            AutoTransition autoTransition = new AutoTransition();
            this.f42658i = autoTransition;
            autoTransition.setDuration(50L);
            ViewGroup viewGroup2 = (ViewGroup) view.findViewById(R.id.state_aspect_ratio);
            this.f42662m = viewGroup2;
            viewGroup2.setOnClickListener(this.A);
            ViewGroup viewGroup3 = (ViewGroup) view.findViewById(R.id.state_rotate);
            this.f42663n = viewGroup3;
            viewGroup3.setOnClickListener(this.A);
            ViewGroup viewGroup4 = (ViewGroup) view.findViewById(R.id.state_scale);
            this.f42664o = viewGroup4;
            viewGroup4.setOnClickListener(this.A);
            this.f42665p = (ViewGroup) view.findViewById(R.id.layout_aspect_ratio);
            this.f42666q = (ViewGroup) view.findViewById(R.id.layout_rotate_wheel);
            this.f42667r = (ViewGroup) view.findViewById(R.id.layout_scale_wheel);
            a0(bundle, view);
            b0(view);
            c0(view);
            d0(view);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (getParentFragment() instanceof com.yalantis.ucrop.c) {
            this.f42652c = (com.yalantis.ucrop.c) getParentFragment();
        } else {
            if (context instanceof com.yalantis.ucrop.c) {
                this.f42652c = (com.yalantis.ucrop.c) context;
                return;
            }
            throw new IllegalArgumentException(context.toString() + " must implement UCropFragmentCallback");
        }
    }
}
