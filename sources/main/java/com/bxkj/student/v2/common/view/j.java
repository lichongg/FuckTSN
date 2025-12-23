package com.bxkj.student.v2.common.view;

import android.R;
import android.app.Activity;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import cn.bluemobi.dylan.base.utils.u;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
class j {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements View.OnTouchListener {

        /* renamed from: a, reason: collision with root package name */
        private int f21093a;

        /* renamed from: b, reason: collision with root package name */
        private int f21094b;

        /* renamed from: c, reason: collision with root package name */
        private float f21095c;

        /* renamed from: d, reason: collision with root package name */
        private float f21096d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f21097e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Activity f21098f;

        a(final int val$screenWidth, final Activity val$activity) {
            this.f21097e = val$screenWidth;
            this.f21098f = val$activity;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View v5, MotionEvent event) {
            int action = event.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                        return false;
                    }
                    v5.animate().x(event.getRawX() + this.f21093a).y(event.getRawY() + this.f21094b).setDuration(0L).start();
                    com.orhanobut.logger.j.c("移动 viewRightEdge=" + (v5.getX() + v5.getWidth()) + " screenWidth=" + this.f21097e);
                } else {
                    float abs = Math.abs(event.getRawX() - this.f21095c);
                    float abs2 = Math.abs(event.getRawY() - this.f21096d);
                    if (abs == 0.0f && abs2 == 0.0f) {
                        com.orhanobut.logger.j.c("提交反馈");
                    }
                    Rect rect = new Rect();
                    this.f21098f.getWindow().getDecorView().getGlobalVisibleRect(rect);
                    if (!rect.contains((int) event.getRawX(), (int) event.getRawY())) {
                        v5.animate().x(this.f21095c + this.f21093a).y(this.f21096d + this.f21094b).setDuration(300L).start();
                    }
                }
            } else {
                this.f21093a = ((int) v5.getX()) - ((int) event.getRawX());
                this.f21094b = ((int) v5.getY()) - ((int) event.getRawY());
                this.f21095c = event.getRawX();
                this.f21096d = event.getRawY();
            }
            return true;
        }
    }

    private View b(final Activity activity) {
        LinearLayout linearLayout = new LinearLayout(activity);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setGravity(53);
        linearLayout.setPadding(0, 0, u.a(10.0f, activity), 0);
        linearLayout.setBackgroundColor(ContextCompat.getColor(activity, R.color.transparent));
        linearLayout.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = u.a(200.0f, activity);
        layoutParams2.topMargin = u.a(200.0f, activity);
        View inflate = LayoutInflater.from(activity).inflate(com.bxkj.student.R.layout.floating_help, (ViewGroup) null);
        inflate.findViewById(com.bxkj.student.R.id.ll_menu);
        linearLayout.addView(inflate, layoutParams2);
        ((ViewGroup) activity.getWindow().getDecorView()).addView(linearLayout);
        inflate.setOnTouchListener(new a(activity.getResources().getDisplayMetrics().widthPixels, activity));
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.common.view.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.orhanobut.logger.j.c("提交反馈");
            }
        });
        return linearLayout;
    }

    j() {
    }
}
