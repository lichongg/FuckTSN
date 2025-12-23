package com.beizi.fusion.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.beizi.fusion.R;
import com.beizi.fusion.tool.aa;
import com.beizi.fusion.tool.am;
import com.beizi.fusion.tool.ap;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class TwistView extends RelativeLayout {
    public static final long DELAY_TIME_TWIST = 100;
    private int A;
    private int B;
    private a C;
    private int D;
    private boolean E;
    private int F;
    private int G;
    private int H;
    private boolean I;
    private Handler J;

    /* renamed from: a, reason: collision with root package name */
    private View f13959a;

    /* renamed from: b, reason: collision with root package name */
    private View f13960b;

    /* renamed from: c, reason: collision with root package name */
    private View f13961c;

    /* renamed from: d, reason: collision with root package name */
    private View f13962d;

    /* renamed from: e, reason: collision with root package name */
    private BackArrowView f13963e;

    /* renamed from: f, reason: collision with root package name */
    private BackArrowView f13964f;

    /* renamed from: g, reason: collision with root package name */
    private BackArrowView f13965g;

    /* renamed from: h, reason: collision with root package name */
    private ShakeView f13966h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f13967i;

    /* renamed from: j, reason: collision with root package name */
    private TextView f13968j;

    /* renamed from: k, reason: collision with root package name */
    private int f13969k;

    /* renamed from: l, reason: collision with root package name */
    private ObjectAnimator f13970l;

    /* renamed from: m, reason: collision with root package name */
    private final int f13971m;

    /* renamed from: n, reason: collision with root package name */
    private final int f13972n;

    /* renamed from: o, reason: collision with root package name */
    private final long f13973o;

    /* renamed from: p, reason: collision with root package name */
    private final long f13974p;

    /* renamed from: q, reason: collision with root package name */
    private final long f13975q;

    /* renamed from: r, reason: collision with root package name */
    private String f13976r;

    /* renamed from: s, reason: collision with root package name */
    private String f13977s;

    /* renamed from: t, reason: collision with root package name */
    private String f13978t;

    /* renamed from: u, reason: collision with root package name */
    private long f13979u;

    /* renamed from: v, reason: collision with root package name */
    private Timer f13980v;

    /* renamed from: w, reason: collision with root package name */
    private TimerTask f13981w;

    /* renamed from: x, reason: collision with root package name */
    private Timer f13982x;

    /* renamed from: y, reason: collision with root package name */
    private TimerTask f13983y;

    /* renamed from: z, reason: collision with root package name */
    private int f13984z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a();
    }

    public TwistView(Context context) {
        super(context);
        this.f13971m = 1000;
        this.f13972n = 2000;
        this.f13973o = 500L;
        this.f13974p = 0L;
        this.f13975q = 0L;
        this.f13976r = "#FFFFFFFF";
        this.f13977s = "#99FFFFFF";
        this.f13978t = "#33FFFFFF";
        this.f13979u = 1000L;
        this.f13984z = 0;
        this.A = 0;
        this.B = 0;
        this.D = 0;
        this.E = true;
        this.F = 3;
        this.G = 1;
        this.H = 95;
        this.I = false;
        this.J = new Handler(Looper.getMainLooper()) { // from class: com.beizi.fusion.widget.TwistView.1
            @Override // android.os.Handler
            @RequiresApi(api = 21)
            @SuppressLint({"LongLogTag"})
            public void handleMessage(@NonNull Message message) {
                super.handleMessage(message);
                try {
                    int i6 = message.what;
                    if (i6 == 2000) {
                        TwistView twistView = TwistView.this;
                        twistView.updateStatus(twistView.D);
                    } else if (i6 == 1000) {
                        TwistView.this.a();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        b();
    }

    private void b() {
        try {
            View.inflate(getContext(), R.layout.beizi_twist_view, this);
            c();
            d();
            e();
            startTwistTimerTask();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void c() {
        try {
            this.f13959a = findViewById(R.id.beizi_twist_go_imageview);
            this.f13962d = findViewById(R.id.beizi_twist_shake_total_layout);
            this.f13960b = findViewById(R.id.beizi_twist_total_layout);
            this.f13961c = findViewById(R.id.beizi_twist_right_total_layout);
            this.f13967i = (TextView) findViewById(R.id.beizi_twist_title_text);
            this.f13968j = (TextView) findViewById(R.id.beizi_twist_describe_text);
            this.f13963e = (BackArrowView) findViewById(R.id.beizi_twist_right_first_image);
            this.f13964f = (BackArrowView) findViewById(R.id.beizi_twist_right_second_image);
            this.f13965g = (BackArrowView) findViewById(R.id.beizi_twist_right_third_image);
            ShakeView shakeView = (ShakeView) findViewById(R.id.beizi_twist_top_view);
            this.f13966h = shakeView;
            shakeView.updateTwistRollAnim();
            setTwistTotalLayoutBg("#d9333333");
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void d() {
        try {
            ShakeView shakeView = this.f13966h;
            if (shakeView != null) {
                shakeView.startShake();
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void e() {
        try {
            if (this.f13982x == null) {
                this.f13982x = new Timer();
            }
            if (this.f13983y == null) {
                this.f13983y = new TimerTask() { // from class: com.beizi.fusion.widget.TwistView.6
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        try {
                            if (TwistView.this.J != null) {
                                TwistView.this.J.sendEmptyMessage(1000);
                            }
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                    }
                };
            }
            this.f13982x.schedule(this.f13983y, 0L, 500L);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        return this.B == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCountAnimation() {
        return (int) (this.f13979u / 100);
    }

    public void cancelArrowTimerTask() {
        try {
            Timer timer = this.f13982x;
            if (timer != null) {
                timer.cancel();
                this.f13982x = null;
            }
            TimerTask timerTask = this.f13983y;
            if (timerTask != null) {
                timerTask.cancel();
                this.f13983y = null;
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void cancelTwistTimerTask() {
        try {
            Timer timer = this.f13980v;
            if (timer != null) {
                timer.cancel();
                this.f13980v = null;
            }
            TimerTask timerTask = this.f13981w;
            if (timerTask != null) {
                timerTask.cancel();
                this.f13981w = null;
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void destroyView() {
        try {
            ShakeView shakeView = this.f13966h;
            if (shakeView != null) {
                shakeView.stopShake();
            }
            cancelTwistTimerTask();
            cancelArrowTimerTask();
            removeHandlerMsg();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void removeHandlerMsg() {
        try {
            Handler handler = this.J;
            if (handler != null) {
                handler.removeCallbacks(null);
                this.J = null;
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void setDescribeText(String str) {
        try {
            TextView textView = this.f13968j;
            if (textView != null) {
                textView.setText(str);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void setDurationAnimation(long j6) {
        this.f13979u = j6;
    }

    public void setJumpClickListener(View.OnClickListener onClickListener) {
        View view = this.f13962d;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public void setJumpOnTouchListener(View.OnTouchListener onTouchListener) {
        View view = this.f13962d;
        if (view != null) {
            view.setOnTouchListener(onTouchListener);
        }
    }

    public void setMainTitleText(String str) {
        try {
            TextView textView = this.f13967i;
            if (textView != null) {
                textView.setText(str);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void setRotationEndCallback(a aVar) {
        this.C = aVar;
    }

    public void setTwistTotalLayoutBg(String str) {
        View view = this.f13962d;
        if (view != null) {
            try {
                am.a(view, str, 0, "", 100);
            } catch (Exception e6) {
                aa.b("TwistView", " e : " + e6);
            }
        }
    }

    public void setTwistTotalLayoutWidthAndHeight(int i6, int i7) {
        try {
            View view = this.f13962d;
            if (view != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                layoutParams.width = i6;
                layoutParams.height = i7 - ap.a(getContext(), this.H);
                this.f13962d.setPadding(ap.a(getContext(), 0.0f), ap.a(getContext(), this.F), ap.a(getContext(), 0.0f), ap.a(getContext(), this.F));
                this.f13962d.setLayoutParams(layoutParams);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void startTwistTimerTask() {
        try {
            if (this.f13980v == null) {
                this.f13980v = new Timer();
            }
            if (this.f13981w == null) {
                this.f13981w = new TimerTask() { // from class: com.beizi.fusion.widget.TwistView.2
                    @Override // java.util.TimerTask, java.lang.Runnable
                    @RequiresApi(api = 21)
                    public void run() {
                        try {
                            if (TwistView.this.I || TwistView.this.J == null) {
                                return;
                            }
                            Message obtainMessage = TwistView.this.J.obtainMessage();
                            obtainMessage.what = 2000;
                            TwistView.this.J.sendMessage(obtainMessage);
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                    }
                };
            }
            this.f13980v.scheduleAtFixedRate(this.f13981w, 0L, 100L);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void updateRollStatus(int i6) {
        this.D = i6;
    }

    @RequiresApi(api = 21)
    public void updateStatus(int i6) {
        Throwable th;
        if (i6 != 0) {
            try {
                int countAnimation = getCountAnimation();
                if (this.B != i6) {
                    if (this.E) {
                        try {
                            this.A = 0;
                        } catch (Throwable th2) {
                            th = th2;
                            th.printStackTrace();
                        }
                    } else {
                        this.A = countAnimation - this.A;
                    }
                    this.B = i6;
                }
                if (this.A < 0) {
                    this.A = 0;
                }
                if (this.A >= countAnimation) {
                    if (this.E) {
                        this.A = 0;
                    } else {
                        this.A = countAnimation;
                    }
                }
                int i7 = this.A;
                if (i7 >= 0 && i7 <= countAnimation) {
                    try {
                        a(this.f13960b, this.f13959a, 100L, i6, i7);
                        this.A++;
                    } catch (Throwable th3) {
                        th = th3;
                        th = th;
                        th.printStackTrace();
                    }
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        try {
            int i6 = this.f13969k;
            if (i6 == 0) {
                BackArrowView backArrowView = this.f13963e;
                if (backArrowView != null) {
                    backArrowView.setViewColor(Color.parseColor(this.f13976r));
                }
                BackArrowView backArrowView2 = this.f13964f;
                if (backArrowView2 != null) {
                    backArrowView2.setViewColor(Color.parseColor(this.f13977s));
                }
                BackArrowView backArrowView3 = this.f13965g;
                if (backArrowView3 != null) {
                    backArrowView3.setViewColor(Color.parseColor(this.f13978t));
                }
            } else if (i6 == 1) {
                BackArrowView backArrowView4 = this.f13963e;
                if (backArrowView4 != null) {
                    backArrowView4.setViewColor(Color.parseColor(this.f13978t));
                }
                BackArrowView backArrowView5 = this.f13964f;
                if (backArrowView5 != null) {
                    backArrowView5.setViewColor(Color.parseColor(this.f13976r));
                }
                BackArrowView backArrowView6 = this.f13965g;
                if (backArrowView6 != null) {
                    backArrowView6.setViewColor(Color.parseColor(this.f13977s));
                }
            } else if (i6 == 2) {
                BackArrowView backArrowView7 = this.f13963e;
                if (backArrowView7 != null) {
                    backArrowView7.setViewColor(Color.parseColor(this.f13977s));
                }
                BackArrowView backArrowView8 = this.f13964f;
                if (backArrowView8 != null) {
                    backArrowView8.setViewColor(Color.parseColor(this.f13978t));
                }
                BackArrowView backArrowView9 = this.f13965g;
                if (backArrowView9 != null) {
                    backArrowView9.setViewColor(Color.parseColor(this.f13976r));
                }
            }
            int i7 = this.f13969k;
            if (i7 == 2) {
                this.f13969k = 0;
            } else {
                this.f13969k = i7 + 1;
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @RequiresApi(api = 21)
    public void hideTargetView(View view, long j6, int i6) {
        try {
            int right = view.getRight();
            int top2 = (view.getTop() + view.getBottom()) / 2;
            float max = Math.max(view.getWidth(), view.getHeight());
            float countAnimation = max / getCountAnimation();
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, right, top2, max - (i6 * countAnimation), max - (countAnimation * (i6 + 1)));
            createCircularReveal.setDuration(j6);
            view.clearAnimation();
            createCircularReveal.addListener(new AnimatorListenerAdapter() { // from class: com.beizi.fusion.widget.TwistView.8
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                }
            });
            createCircularReveal.start();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @RequiresApi(api = 21)
    public void showTargetView(View view, long j6, final int i6) {
        try {
            float max = Math.max(view.getWidth(), view.getHeight()) / getCountAnimation();
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, view.getRight(), (view.getTop() + view.getBottom()) / 2, (i6 * max) + 0.0f, max * (i6 + 1));
            createCircularReveal.setDuration(j6);
            view.clearAnimation();
            createCircularReveal.addListener(new AnimatorListenerAdapter() { // from class: com.beizi.fusion.widget.TwistView.7
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (!TwistView.this.f()) {
                        TwistView.this.getCountAnimation();
                    }
                }
            });
            createCircularReveal.start();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void b(View view, float f6, long j6, boolean z5, final int i6) {
        try {
            if (z5) {
                float width = f6 - view.getWidth();
                float countAnimation = width / getCountAnimation();
                float f7 = i6 * countAnimation;
                float f8 = f7 + 0.0f;
                float f9 = countAnimation + f7;
                if (f8 > 0.0f || f9 > 0.0f) {
                    this.E = false;
                }
                if ((f8 >= width || f9 >= width) && i6 >= getCountAnimation()) {
                    return;
                }
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", f8, f9);
                this.f13970l = ofFloat;
                ofFloat.setDuration(j6);
                this.f13970l.start();
                this.f13970l.addListener(new Animator.AnimatorListener() { // from class: com.beizi.fusion.widget.TwistView.3
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        try {
                            if (i6 + 1 < TwistView.this.getCountAnimation() || TwistView.this.C == null) {
                                return;
                            }
                            TwistView.this.I = true;
                            TwistView.this.C.a();
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }
                });
                return;
            }
            float width2 = f6 - view.getWidth();
            float countAnimation2 = width2 / getCountAnimation();
            float f10 = width2 - (i6 * countAnimation2);
            float f11 = width2 - ((i6 + 1) * countAnimation2);
            if (f10 >= 0.0f && f11 >= 0.0f) {
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationX", f10, f11);
                this.f13970l = ofFloat2;
                ofFloat2.setDuration(j6);
                this.f13970l.start();
                return;
            }
            this.E = true;
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public TwistView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13971m = 1000;
        this.f13972n = 2000;
        this.f13973o = 500L;
        this.f13974p = 0L;
        this.f13975q = 0L;
        this.f13976r = "#FFFFFFFF";
        this.f13977s = "#99FFFFFF";
        this.f13978t = "#33FFFFFF";
        this.f13979u = 1000L;
        this.f13984z = 0;
        this.A = 0;
        this.B = 0;
        this.D = 0;
        this.E = true;
        this.F = 3;
        this.G = 1;
        this.H = 95;
        this.I = false;
        this.J = new Handler(Looper.getMainLooper()) { // from class: com.beizi.fusion.widget.TwistView.1
            @Override // android.os.Handler
            @RequiresApi(api = 21)
            @SuppressLint({"LongLogTag"})
            public void handleMessage(@NonNull Message message) {
                super.handleMessage(message);
                try {
                    int i6 = message.what;
                    if (i6 == 2000) {
                        TwistView twistView = TwistView.this;
                        twistView.updateStatus(twistView.D);
                    } else if (i6 == 1000) {
                        TwistView.this.a();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        b();
    }

    @RequiresApi(api = 21)
    private void a(View view, View view2, long j6, int i6, int i7) {
        if (view != null) {
            try {
                if (view.getVisibility() == 0 && view.getParent() != null && view.hasWindowFocus()) {
                    if (i6 == 1) {
                        hideTargetView(view, j6, i7);
                        a(view2, view.getRight(), j6, true, i7);
                    } else {
                        if (i6 != 2 || this.E) {
                            return;
                        }
                        showTargetView(view, j6, i7);
                        a(view2, view.getRight(), j6, false, i7);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void a(View view, float f6, long j6, boolean z5, int i6) {
        try {
            b(view, f6, j6, z5, i6);
            a(view, j6, z5, i6);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void a(View view, long j6, boolean z5, int i6) {
        try {
            if (z5) {
                float countAnimation = 360.0f / getCountAnimation();
                float f6 = (i6 * countAnimation) + 0.0f;
                float f7 = countAnimation * (i6 + 1);
                if (f6 <= 360.0f && f7 <= 360.0f) {
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "rotation", f6, f7);
                    ofFloat.setDuration(j6);
                    ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.beizi.fusion.widget.TwistView.4
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            ((Float) valueAnimator.getAnimatedValue()).getClass();
                        }
                    });
                    ofFloat.start();
                    return;
                }
                return;
            }
            float countAnimation2 = (-360.0f) / getCountAnimation();
            float f8 = (i6 * countAnimation2) + 0.0f;
            float f9 = countAnimation2 * (i6 + 1);
            if (f8 >= -360.0f && f9 >= -360.0f) {
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "rotation", f8, f9);
                ofFloat2.setDuration(j6);
                ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.beizi.fusion.widget.TwistView.5
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        ((Float) valueAnimator.getAnimatedValue()).getClass();
                    }
                });
                ofFloat2.start();
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public TwistView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f13971m = 1000;
        this.f13972n = 2000;
        this.f13973o = 500L;
        this.f13974p = 0L;
        this.f13975q = 0L;
        this.f13976r = "#FFFFFFFF";
        this.f13977s = "#99FFFFFF";
        this.f13978t = "#33FFFFFF";
        this.f13979u = 1000L;
        this.f13984z = 0;
        this.A = 0;
        this.B = 0;
        this.D = 0;
        this.E = true;
        this.F = 3;
        this.G = 1;
        this.H = 95;
        this.I = false;
        this.J = new Handler(Looper.getMainLooper()) { // from class: com.beizi.fusion.widget.TwistView.1
            @Override // android.os.Handler
            @RequiresApi(api = 21)
            @SuppressLint({"LongLogTag"})
            public void handleMessage(@NonNull Message message) {
                super.handleMessage(message);
                try {
                    int i62 = message.what;
                    if (i62 == 2000) {
                        TwistView twistView = TwistView.this;
                        twistView.updateStatus(twistView.D);
                    } else if (i62 == 1000) {
                        TwistView.this.a();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        b();
    }
}
