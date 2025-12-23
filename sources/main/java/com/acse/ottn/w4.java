package com.acse.ottn;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
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
public class w4 {

    /* renamed from: a, reason: collision with root package name */
    public static AlertDialog f5437a;

    /* renamed from: b, reason: collision with root package name */
    public static ImageView f5438b;

    /* renamed from: c, reason: collision with root package name */
    public static ImageView f5439c;

    /* renamed from: d, reason: collision with root package name */
    public static TextView f5440d;

    /* renamed from: e, reason: collision with root package name */
    public static TextView f5441e;

    /* renamed from: f, reason: collision with root package name */
    public static TextView f5442f;

    /* renamed from: g, reason: collision with root package name */
    public static TextView f5443g;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AcseHelpManager.OnClickCallBack f5444a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Activity f5445b;

        public a(AcseHelpManager.OnClickCallBack onClickCallBack, Activity activity) {
            this.f5444a = onClickCallBack;
            this.f5445b = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (w4.f5441e.getVisibility() == 0) {
                AcseHelpManager.OnClickCallBack onClickCallBack = this.f5444a;
                if (onClickCallBack != null) {
                    onClickCallBack.onDismiss();
                }
            } else {
                AcseHelpManager.OnClickCallBack onClickCallBack2 = this.f5444a;
                if (onClickCallBack2 != null) {
                    onClickCallBack2.onOpen();
                }
            }
            w4.a(this.f5445b, w4.f5437a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AcseHelpManager.OnClickCallBack f5446a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Activity f5447b;

        public b(AcseHelpManager.OnClickCallBack onClickCallBack, Activity activity) {
            this.f5446a = onClickCallBack;
            this.f5447b = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l2.b().a("warning_start_run");
            AcseHelpManager.OnClickCallBack onClickCallBack = this.f5446a;
            if (onClickCallBack != null) {
                onClickCallBack.onOpen();
            }
            w4.a(this.f5447b, w4.f5437a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class c implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AcseHelpManager.OnClickCallBack f5448a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Activity f5449b;

        public c(AcseHelpManager.OnClickCallBack onClickCallBack, Activity activity) {
            this.f5448a = onClickCallBack;
            this.f5449b = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AcseHelpManager.OnClickCallBack onClickCallBack = this.f5448a;
            if (onClickCallBack != null) {
                onClickCallBack.onClose();
            }
            w4.a(this.f5449b, w4.f5437a);
        }
    }

    public static AlertDialog a(Activity activity, AcseHelpManager.OnClickCallBack onClickCallBack) {
        return b(activity, null, null, null, null, onClickCallBack);
    }

    public static AlertDialog b(Activity activity, String str, String str2, String str3, String str4, AcseHelpManager.OnClickCallBack onClickCallBack) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.warning_dialog, (ViewGroup) null);
        f5438b = (ImageView) inflate.findViewById(R.id.iv_dismiss);
        f5440d = (TextView) inflate.findViewById(R.id.tv_button);
        f5441e = (TextView) inflate.findViewById(R.id.tv_but2);
        f5439c = (ImageView) inflate.findViewById(R.id.iv_icon);
        f5442f = (TextView) inflate.findViewById(R.id.tv_content);
        f5443g = (TextView) inflate.findViewById(R.id.tv_version_info);
        f5441e.setVisibility(0);
        f5440d.setTextColor(Color.parseColor("#999999"));
        f5440d.setBackground(null);
        g0.a().a(activity, (RelativeLayout) inflate.findViewById(R.id.rl_bg));
        g0.a().a(activity, f5443g, f5442f);
        g0.a().a(activity, (TextView) null, f5440d);
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            f5443g.setText(activity.getString(R.string.warning_dialog_title));
            if (activity.getPackageName().equals(k0.f4683s)) {
                f5442f.setText(activity.getString(R.string.sd_warning_message));
                f5440d.setText("继续开启权限");
            } else {
                f5442f.setText(activity.getString(R.string.warning_message));
                f5440d.setText(activity.getString(R.string.warning_commit));
            }
            f5441e.setText(activity.getString(R.string.warning_cancle));
        } else {
            f5441e.setText(str3);
            f5440d.setText(str4);
            f5442f.setText(str2);
            f5443g.setText(str);
        }
        g0.a().b(activity, f5441e);
        g0.a().b(activity, f5439c);
        f5440d.setOnClickListener(new a(onClickCallBack, activity));
        f5441e.setOnClickListener(new b(onClickCallBack, activity));
        f5438b.setOnClickListener(new c(onClickCallBack, activity));
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.AlertDialogCustom);
        builder.setView(inflate);
        builder.setCancelable(true);
        AlertDialog create = builder.create();
        f5437a = create;
        create.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        b(activity, f5437a);
        return f5437a;
    }

    public static AlertDialog a(Activity activity, String str, String str2, String str3, String str4, AcseHelpManager.OnClickCallBack onClickCallBack) {
        return b(activity, str, str2, str3, str4, onClickCallBack);
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
}
