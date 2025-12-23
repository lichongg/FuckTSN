package com.acse.ottn;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.activity.AcseHelpManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class p0 {

    /* renamed from: a, reason: collision with root package name */
    public static AlertDialog f4984a;

    /* renamed from: b, reason: collision with root package name */
    public static ImageView f4985b;

    /* renamed from: c, reason: collision with root package name */
    public static TextView f4986c;

    /* renamed from: d, reason: collision with root package name */
    public static TextView f4987d;

    /* renamed from: e, reason: collision with root package name */
    public static TextView f4988e;

    /* renamed from: f, reason: collision with root package name */
    public static TextView f4989f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f4990a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f4991b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f4992c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AcseHelpManager.OnClickCallBack f4993d;

        public a(Activity activity, String str, String str2, AcseHelpManager.OnClickCallBack onClickCallBack) {
            this.f4990a = activity;
            this.f4991b = str;
            this.f4992c = str2;
            this.f4993d = onClickCallBack;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            p0.a(this.f4990a, p0.f4984a);
            l2.b().a(this.f4991b + "_" + this.f4992c + "_close");
            AcseHelpManager.OnClickCallBack onClickCallBack = this.f4993d;
            if (onClickCallBack != null) {
                onClickCallBack.onDismiss();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f4994a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f4995b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f4996c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AcseHelpManager.OnClickCallBack f4997d;

        public b(Activity activity, String str, String str2, AcseHelpManager.OnClickCallBack onClickCallBack) {
            this.f4994a = activity;
            this.f4995b = str;
            this.f4996c = str2;
            this.f4997d = onClickCallBack;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            p0.a(this.f4994a, p0.f4984a);
            l2.b().a(this.f4995b + "_" + this.f4996c + "_open");
            AcseHelpManager.OnClickCallBack onClickCallBack = this.f4997d;
            if (onClickCallBack != null) {
                onClickCallBack.onOpen();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class c implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f4998a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f4999b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Activity f5000c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AcseHelpManager.OnClickCallBack f5001d;

        public c(String str, String str2, Activity activity, AcseHelpManager.OnClickCallBack onClickCallBack) {
            this.f4998a = str;
            this.f4999b = str2;
            this.f5000c = activity;
            this.f5001d = onClickCallBack;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l2.b().a(this.f4998a + "_" + this.f4999b + "_dismiss");
            p0.a(this.f5000c, p0.f4984a);
            AcseHelpManager.OnClickCallBack onClickCallBack = this.f5001d;
            if (onClickCallBack != null) {
                onClickCallBack.onClose();
            }
        }
    }

    public static AlertDialog b(Activity activity, String str, String str2, String str3, String str4, AcseHelpManager.OnClickCallBack onClickCallBack) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.custon_dialog, (ViewGroup) null);
        f4985b = (ImageView) inflate.findViewById(R.id.iv_dismiss);
        f4986c = (TextView) inflate.findViewById(R.id.tv_button);
        f4987d = (TextView) inflate.findViewById(R.id.tv_but2);
        f4988e = (TextView) inflate.findViewById(R.id.tv_content);
        f4989f = (TextView) inflate.findViewById(R.id.tv_version_info);
        if (!TextUtils.isEmpty(str3)) {
            f4987d.setText(str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            f4986c.setText(str4);
        }
        if (!TextUtils.isEmpty(str2)) {
            f4988e.setText(str2);
        }
        if (!TextUtils.isEmpty(str)) {
            f4989f.setText(str);
        }
        g0.a().b(activity, f4987d);
        f4986c.setOnClickListener(new a(activity, str3, str4, onClickCallBack));
        f4987d.setOnClickListener(new b(activity, str3, str4, onClickCallBack));
        f4985b.setOnClickListener(new c(str3, str4, activity, onClickCallBack));
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.AlertDialogCustom);
        builder.setView(inflate);
        builder.setCancelable(true);
        AlertDialog create = builder.create();
        f4984a = create;
        create.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        b(activity, f4984a);
        return f4984a;
    }

    public static AlertDialog a(Activity activity, AcseHelpManager.OnClickCallBack onClickCallBack) {
        return b(activity, null, null, null, null, onClickCallBack);
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
