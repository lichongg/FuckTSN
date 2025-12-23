package com.acse.ottn;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class w0 {

    /* renamed from: a, reason: collision with root package name */
    public static AlertDialog f5405a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f5406a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f5407b;

        public a(Activity activity, c cVar) {
            this.f5406a = activity;
            this.f5407b = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            w0.a(this.f5406a, w0.f5405a);
            this.f5407b.b();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f5408a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f5409b;

        public b(Activity activity, c cVar) {
            this.f5408a = activity;
            this.f5409b = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            w0.a(this.f5408a, w0.f5405a);
            this.f5409b.a();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface c {
        void a();

        void b();
    }

    public static AlertDialog a(Activity activity, String str, String str2, String str3, boolean z5, c cVar) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.dialog_single_green_button_dialog, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_content);
        TextView textView2 = (TextView) inflate.findViewById(R.id.tv_button2);
        TextView textView3 = (TextView) inflate.findViewById(R.id.tv_version_info);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_dissmiss);
        g0.a().a(activity, (RelativeLayout) inflate.findViewById(R.id.rl_bg));
        g0.a().a(activity, textView, textView3);
        if (str == null) {
            textView.setVisibility(8);
            imageView.setVisibility(8);
            textView3.setGravity(1);
        } else {
            textView.setText(str);
        }
        textView3.setText(str2);
        textView2.setText(str3);
        g0.a().b(activity, textView2);
        textView2.setOnClickListener(new a(activity, cVar));
        imageView.setOnClickListener(new b(activity, cVar));
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.AlertDialogCustom);
        builder.setView(inflate);
        builder.setCancelable(true);
        AlertDialog create = builder.create();
        f5405a = create;
        create.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        b(activity, f5405a);
        return f5405a;
    }

    public static void b(Activity activity, Dialog dialog) {
        try {
            if (!activity.isFinishing() && dialog != null && !dialog.isShowing()) {
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
            }
        } catch (Exception e6) {
            c2.a("samop", "error =" + e6.getMessage());
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
