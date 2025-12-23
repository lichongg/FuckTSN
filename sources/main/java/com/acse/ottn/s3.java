package com.acse.ottn;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.activity.AcseHelpManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class s3 {

    /* renamed from: a, reason: collision with root package name */
    public static AlertDialog f5086a;

    /* renamed from: b, reason: collision with root package name */
    public static ImageView f5087b;

    /* renamed from: c, reason: collision with root package name */
    public static TextView f5088c;

    /* renamed from: d, reason: collision with root package name */
    public static TextView f5089d;

    /* renamed from: e, reason: collision with root package name */
    public static ImageView f5090e;

    /* renamed from: f, reason: collision with root package name */
    public static ImageView f5091f;

    /* renamed from: g, reason: collision with root package name */
    public static RelativeLayout f5092g;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f5093a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Activity f5094b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AcseHelpManager.OnClickCallBack f5095c;

        public a(boolean z5, Activity activity, AcseHelpManager.OnClickCallBack onClickCallBack) {
            this.f5093a = z5;
            this.f5094b = activity;
            this.f5095c = onClickCallBack;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f5093a) {
                try {
                    s3.f5086a.dismiss();
                } catch (Exception unused) {
                }
                w4.a(this.f5094b, this.f5095c);
                return;
            }
            l2.b().a("not_now");
            AcseHelpManager.OnClickCallBack onClickCallBack = this.f5095c;
            if (onClickCallBack != null) {
                onClickCallBack.onDismiss();
            }
            try {
                s3.f5086a.dismiss();
            } catch (Exception unused2) {
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AcseHelpManager.OnClickCallBack f5096a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Activity f5097b;

        public b(AcseHelpManager.OnClickCallBack onClickCallBack, Activity activity) {
            this.f5096a = onClickCallBack;
            this.f5097b = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l2.b().a("not_now");
            AcseHelpManager.OnClickCallBack onClickCallBack = this.f5096a;
            if (onClickCallBack != null) {
                onClickCallBack.onClose();
            }
            s3.a(this.f5097b, s3.f5086a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class c implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AcseHelpManager.OnClickCallBack f5098a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Activity f5099b;

        public c(AcseHelpManager.OnClickCallBack onClickCallBack, Activity activity) {
            this.f5098a = onClickCallBack;
            this.f5099b = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AcseHelpManager.OnClickCallBack onClickCallBack = this.f5098a;
            if (onClickCallBack != null) {
                onClickCallBack.onOpen();
            }
            l2.b().a("click_now_start");
            s3.a(this.f5099b, s3.f5086a);
        }
    }

    public static AlertDialog a(Activity activity, String str, String str2, String str3, String str4, AcseHelpManager.OnClickCallBack onClickCallBack) {
        return a(activity, str, str2, str3, str4, false, onClickCallBack);
    }

    public static AlertDialog a(Activity activity, AcseHelpManager.OnClickCallBack onClickCallBack) {
        return a(activity, null, null, null, null, false, onClickCallBack);
    }

    public static void b(Activity activity, Dialog dialog) {
        try {
            if (!activity.isFinishing() && dialog != null && !dialog.isShowing()) {
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
            }
        } catch (Exception unused) {
        }
    }

    public static AlertDialog a(Activity activity, boolean z5, AcseHelpManager.OnClickCallBack onClickCallBack) {
        return a(activity, null, null, null, null, z5, onClickCallBack);
    }

    public static AlertDialog a(Activity activity, String str, String str2, String str3, String str4, boolean z5, AcseHelpManager.OnClickCallBack onClickCallBack) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.seeding_running_dialog, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_version_info);
        if (!TextUtils.isEmpty(str)) {
            textView.setText(str);
        } else {
            textView.setText(activity.getString(R.string.invite_title));
        }
        f5087b = (ImageView) inflate.findViewById(R.id.iv_dismiss);
        f5089d = (TextView) inflate.findViewById(R.id.tv_but2);
        if (!TextUtils.isEmpty(str3)) {
            f5089d.setText(str3);
        } else {
            f5089d.setText(activity.getString(R.string.invite_commit));
        }
        l2.b().a("show_run_dialog");
        ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_icon);
        f5090e = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        f5088c = (TextView) inflate.findViewById(R.id.tv_button);
        f5091f = (ImageView) inflate.findViewById(R.id.iv_icon1);
        f5092g = (RelativeLayout) inflate.findViewById(R.id.rl_bg);
        g0.a().a(activity, (RelativeLayout) inflate.findViewById(R.id.rl_b));
        if (!TextUtils.isEmpty(str4)) {
            f5088c.setText(str4);
        } else {
            f5088c.setText(activity.getString(R.string.invite_cancle));
        }
        TextView textView2 = (TextView) inflate.findViewById(R.id.tv_content);
        if (!TextUtils.isEmpty(str2)) {
            textView2.setText(str2);
        } else if (activity.getPackageName().equals(k0.f4683s)) {
            textView2.setText("请先开启必要权限，以便于持续稳定，准确完整地记录您运动期间的数据！");
        } else {
            textView2.setText(activity.getString(R.string.invite_message));
        }
        g0.a().c(activity, f5088c);
        g0.a().b(activity, f5089d);
        g0.a().a(activity, f5090e, f5091f);
        g0.a().a(activity, textView, textView2);
        g0.a().a(activity, (TextView) null, f5088c);
        f5088c.setOnClickListener(new a(z5, activity, onClickCallBack));
        f5087b.setOnClickListener(new b(onClickCallBack, activity));
        f5089d.setOnClickListener(new c(onClickCallBack, activity));
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.AlertDialogCustom);
        builder.setView(inflate);
        builder.setCancelable(true);
        AlertDialog create = builder.create();
        f5086a = create;
        create.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        b(activity, f5086a);
        return f5086a;
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
