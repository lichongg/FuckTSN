package com.acse.ottn;

import android.app.Activity;
import android.app.Dialog;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.m0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class v3 {

    /* renamed from: a, reason: collision with root package name */
    public static AlertDialog f5380a;

    /* renamed from: b, reason: collision with root package name */
    public static TextView f5381b;

    /* renamed from: c, reason: collision with root package name */
    public static TextView f5382c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f5383a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AcseHelpManager.OnClickCallBack f5384b;

        public a(Activity activity, AcseHelpManager.OnClickCallBack onClickCallBack) {
            this.f5383a = activity;
            this.f5384b = onClickCallBack;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            v3.a(this.f5383a, v3.f5380a);
            AcseHelpManager.startAccessibilityIntroduceActivityForResult(this.f5383a, 10010);
            this.f5384b.onOpen();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b implements m0.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f5385a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AcseHelpManager.OnClickCallBack f5386b;

        @Override // com.acse.ottn.m0.d
        public void a(long j6) {
            v3.f5382c.setText(((j6 / 1000) - 1) + "秒");
        }

        public b(Activity activity, AcseHelpManager.OnClickCallBack onClickCallBack) {
            this.f5385a = activity;
            this.f5386b = onClickCallBack;
        }

        @Override // com.acse.ottn.m0.d
        public void a() {
            if (this.f5385a.isFinishing() || !v3.f5380a.isShowing()) {
                return;
            }
            v3.a(this.f5385a, v3.f5380a);
            this.f5386b.onDismiss();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class c implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f5387a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AcseHelpManager.OnClickCallBack f5388b;

        public c(Activity activity, AcseHelpManager.OnClickCallBack onClickCallBack) {
            this.f5387a = activity;
            this.f5388b = onClickCallBack;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            v3.a(this.f5387a, v3.f5380a);
            AcseHelpManager.startAccessibilityIntroduceActivityForResult(this.f5387a, 10010);
            this.f5388b.onOpen();
        }
    }

    public static AlertDialog a(Activity activity, AcseHelpManager.OnClickCallBack onClickCallBack) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.save_monery_dialog, (ViewGroup) null);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.AlertDialogCustom);
        builder.setView(inflate);
        Spanned fromHtml = Html.fromHtml("<b><big><big><big><font color=#4D230A> 购物省钱神器</font></big></big></big></b><font color=#90713A>  体验机会</font>");
        TextView textView = (TextView) inflate.findViewById(R.id.tv_content);
        f5381b = textView;
        textView.setText(fromHtml);
        ((TextView) inflate.findViewById(R.id.tv_content2)).setText("自动发现隐藏优惠券,淘宝、京东最高省80%!");
        f5382c = (TextView) inflate.findViewById(R.id.iv_dismiss);
        inflate.findViewById(R.id.rl_content).setOnClickListener(new a(activity, onClickCallBack));
        m0.a().b(11000, 1000, new b(activity, onClickCallBack));
        inflate.findViewById(R.id.tv_open).setOnClickListener(new c(activity, onClickCallBack));
        AlertDialog create = builder.create();
        f5380a = create;
        create.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        b(activity, f5380a);
        return f5380a;
    }

    public static void b(Activity activity, Dialog dialog) {
        try {
            if (activity.isFinishing() || dialog == null || dialog.isShowing()) {
                return;
            }
            dialog.setCanceledOnTouchOutside(false);
            dialog.show();
        } catch (Exception unused) {
        }
    }

    public static void a(Activity activity, Dialog dialog) {
        try {
            if (activity.isFinishing() || dialog == null || !dialog.isShowing()) {
                return;
            }
            dialog.dismiss();
        } catch (Exception unused) {
        }
    }
}
