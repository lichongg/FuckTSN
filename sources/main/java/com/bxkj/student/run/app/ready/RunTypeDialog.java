package com.bxkj.student.run.app.ready;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bxkj.student.R;
import com.bxkj.student.run.app.set.RunPermissionSetActivity;
import com.orhanobut.logger.j;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class RunTypeDialog extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    private Context f19935a;

    /* renamed from: b, reason: collision with root package name */
    private a f19936b;

    /* renamed from: c, reason: collision with root package name */
    private ImageView f19937c;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f19938d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f19939e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f19940f;

    /* renamed from: g, reason: collision with root package name */
    private ImageView f19941g;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f19942h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f19943i;

    /* renamed from: j, reason: collision with root package name */
    private ImageView f19944j;

    /* renamed from: k, reason: collision with root package name */
    private Button f19945k;

    /* renamed from: l, reason: collision with root package name */
    private View f19946l;

    /* renamed from: m, reason: collision with root package name */
    private View f19947m;

    /* renamed from: n, reason: collision with root package name */
    private View f19948n;

    /* renamed from: o, reason: collision with root package name */
    private View f19949o;

    /* renamed from: p, reason: collision with root package name */
    private TextView f19950p;

    /* renamed from: q, reason: collision with root package name */
    private ImageView f19951q;

    /* renamed from: r, reason: collision with root package name */
    private TextView f19952r;

    /* renamed from: s, reason: collision with root package name */
    private TextView f19953s;

    /* renamed from: t, reason: collision with root package name */
    private TextView f19954t;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a();

        void b();

        void c();

        void d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.f19951q.setVisibility(8);
        this.f19952r.setVisibility(8);
        this.f19953s.setVisibility(8);
        this.f19954t.setVisibility(8);
        this.f19950p.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(View view) {
        this.f19936b.c();
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(View view) {
        this.f19936b.d();
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(View view) {
        this.f19936b.a();
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(View view) {
        this.f19936b.b();
        dismiss();
    }

    private void w(ImageView view) {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f19935a, R.anim.img_animation_clockwise);
        loadAnimation.setInterpolator(new LinearInterpolator());
        view.startAnimation(loadAnimation);
    }

    private void x(ImageView view) {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f19935a, R.anim.img_animation_counterclockwise);
        loadAnimation.setInterpolator(new LinearInterpolator());
        view.startAnimation(loadAnimation);
    }

    private void y(String healthRunName) {
        StringBuilder sb = new StringBuilder("如已设置运动权限,请直接点击下方");
        if (this.f19946l.getVisibility() == 0) {
            sb.append("【早操跑步】");
        }
        if (this.f19947m.getVisibility() == 0) {
            sb.append("【阳光跑步】");
        }
        if (this.f19949o.getVisibility() == 0) {
            sb.append("【自由跑步】");
        }
        if (this.f19948n.getVisibility() == 0) {
            this.f19945k.setText(healthRunName);
            sb.append("【" + healthRunName + "】");
        }
        sb.append("按钮开始跑步");
        this.f19950p.setText(sb);
    }

    public RunTypeDialog r(a clickListener) {
        this.f19936b = clickListener;
        return this;
    }

    public RunTypeDialog s(boolean isVisibalse) {
        if (isVisibalse) {
            this.f19949o.setVisibility(0);
            return this;
        }
        this.f19949o.setVisibility(8);
        return this;
    }

    public RunTypeDialog t(boolean isVisibalse, String healthRunName) {
        if (isVisibalse) {
            this.f19948n.setVisibility(0);
        } else {
            this.f19948n.setVisibility(8);
        }
        y(healthRunName);
        return this;
    }

    public RunTypeDialog u(boolean isVisibalse) {
        if (isVisibalse) {
            this.f19946l.setVisibility(0);
            return this;
        }
        this.f19946l.setVisibility(8);
        return this;
    }

    public RunTypeDialog v(boolean isVisibalse) {
        if (isVisibalse) {
            this.f19947m.setVisibility(0);
            return this;
        }
        this.f19947m.setVisibility(8);
        return this;
    }

    public RunTypeDialog(Context context) {
        super(context, R.style.run_type_dialog);
        setContentView(R.layout.dialog_run_type);
        this.f19935a = context;
        k();
        j();
        if (context instanceof FragmentActivity) {
            ((FragmentActivity) context).getLifecycle().addObserver(new LifecycleObserver() { // from class: com.bxkj.student.run.app.ready.RunTypeDialog.1
                @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
                public void onResume() {
                    j.c("重新检查权限是否开启");
                    RunTypeDialog.this.j();
                }
            });
        }
    }

    private void k() {
        this.f19951q = (ImageView) findViewById(R.id.iv_permission);
        this.f19952r = (TextView) findViewById(R.id.tv_hint);
        this.f19953s = (TextView) findViewById(R.id.tv_choose_shoe_name);
        this.f19937c = (ImageView) findViewById(R.id.iv_in);
        this.f19939e = (ImageView) findViewById(R.id.iv_in_in);
        this.f19940f = (ImageView) findViewById(R.id.iv_out_out);
        this.f19938d = (ImageView) findViewById(R.id.iv_out);
        this.f19941g = (ImageView) findViewById(R.id.iv_free_in);
        this.f19942h = (ImageView) findViewById(R.id.iv_free_out);
        this.f19945k = (Button) findViewById(R.id.bt_health);
        this.f19946l = findViewById(R.id.rl_morning_exercise);
        this.f19947m = findViewById(R.id.rl_sunshine_running);
        this.f19948n = findViewById(R.id.rl_health_running);
        this.f19944j = (ImageView) findViewById(R.id.iv_health_circle_in);
        this.f19943i = (ImageView) findViewById(R.id.iv_health_circle_out);
        this.f19949o = findViewById(R.id.rl_free_run);
        this.f19950p = (TextView) findViewById(2131298879);
        TextView textView = (TextView) findViewById(R.id.bt_check);
        this.f19954t = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.ready.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunTypeDialog.this.l(view);
            }
        });
        findViewById(R.id.iv_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.ready.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunTypeDialog.this.m(view);
            }
        });
        this.f19946l.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.ready.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunTypeDialog.this.n(view);
            }
        });
        this.f19947m.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.ready.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunTypeDialog.this.o(view);
            }
        });
        this.f19948n.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.ready.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunTypeDialog.this.p(view);
            }
        });
        this.f19949o.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.ready.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunTypeDialog.this.q(view);
            }
        });
        x(this.f19937c);
        x(this.f19938d);
        w(this.f19940f);
        w(this.f19939e);
        x(this.f19941g);
        w(this.f19942h);
        x(this.f19944j);
        w(this.f19943i);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        Window window = getWindow();
        window.setWindowAnimations(R.style.ios_bottom_dialog_anim);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = i((Activity) this.f19935a);
        attributes.height = h((Activity) this.f19935a);
        window.setAttributes(attributes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(View view) {
        getContext().startActivity(new Intent(getContext(), (Class<?>) RunPermissionSetActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(View view) {
        dismiss();
    }

    public int h(Activity activity) {
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point.y;
    }

    public int i(Activity activity) {
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point.x;
    }
}
