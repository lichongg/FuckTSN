package com.bxkj.base.v2.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bjtsn.dylan.lifecycleobserver.LifecycleObserver;
import com.bxkj.base.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    protected Dialog f16741a;

    /* renamed from: b, reason: collision with root package name */
    protected Context f16742b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f16743c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends com.bjtsn.dylan.lifecycleobserver.b {
        a() {
        }

        @Override // com.bjtsn.dylan.lifecycleobserver.b
        public void onDestroy() {
            Dialog dialog = p.this.f16741a;
            if (dialog != null && dialog.isShowing()) {
                p.this.f16741a.dismiss();
            }
            super.onDestroy();
        }
    }

    public Dialog h() {
        return i(null);
    }

    private void a(Context context) {
        if (context instanceof FragmentActivity) {
            new LifecycleObserver((FragmentActivity) context).c(new a());
        }
    }

    public void c() {
        Dialog dialog = this.f16741a;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        Context baseContext = ((ContextWrapper) this.f16741a.getContext()).getBaseContext();
        if (!(baseContext instanceof Activity)) {
            this.f16741a.dismiss();
            return;
        }
        Activity activity = (Activity) baseContext;
        if (activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        this.f16741a.dismiss();
    }

    public boolean d() {
        Dialog dialog = this.f16741a;
        if (dialog != null) {
            return dialog.isShowing();
        }
        return false;
    }

    public void e(String str) {
        TextView textView = this.f16743c;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void f(DialogInterface.OnDismissListener onDismissListener) {
        this.f16741a.setOnDismissListener(onDismissListener);
    }

    public void g(DialogInterface.OnKeyListener onKeyListener) {
        this.f16741a.setOnKeyListener(onKeyListener);
    }

    public Dialog i(String str) {
        try {
            if (this.f16743c != null && !TextUtils.isEmpty(str)) {
                this.f16743c.setText(str);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        if (!this.f16741a.isShowing()) {
            if (((ContextWrapper) this.f16741a.getContext()).getBaseContext() instanceof Activity) {
                Activity activity = (Activity) this.f16742b;
                if (!activity.isFinishing() && !activity.isDestroyed()) {
                    this.f16741a.show();
                }
            } else {
                this.f16741a.show();
            }
        }
        return this.f16741a;
    }

    public Dialog j(String str) {
        this.f16741a.setContentView(LayoutInflater.from(this.f16742b).inflate(R.layout.pub_loading, (ViewGroup) null));
        try {
            TextView textView = (TextView) this.f16741a.findViewById(R.id.tv_text);
            this.f16743c = textView;
            if (textView != null && !TextUtils.isEmpty(str)) {
                this.f16743c.setText(str);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        if (!this.f16741a.isShowing()) {
            Context baseContext = ((ContextWrapper) this.f16741a.getContext()).getBaseContext();
            if (!(baseContext instanceof Activity)) {
                this.f16741a.show();
            } else if (!((Activity) baseContext).isFinishing()) {
                this.f16741a.show();
            }
        }
        return this.f16741a;
    }

    public p(Context context) {
        this.f16742b = context;
        this.f16741a = new Dialog(context, R.style.loadingDialogStyle);
        View inflate = LayoutInflater.from(context).inflate(R.layout.fragment_progress_dialog, (ViewGroup) null);
        this.f16743c = (TextView) inflate.findViewById(R.id.tv_msg);
        this.f16741a.setContentView(inflate);
        this.f16741a.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.f16741a.setCanceledOnTouchOutside(false);
        a(context);
    }

    public void b() {
        c();
    }
}
