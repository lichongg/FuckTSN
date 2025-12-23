package com.acse.ottn;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    public static AlertDialog f4303b;

    /* renamed from: c, reason: collision with root package name */
    public static ImageView f4304c;

    /* renamed from: d, reason: collision with root package name */
    public static TextView f4305d;

    /* renamed from: e, reason: collision with root package name */
    public static TextView f4306e;

    /* renamed from: f, reason: collision with root package name */
    public static TextView f4307f;

    /* renamed from: a, reason: collision with root package name */
    public d f4308a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f4309a;

        public a(Activity activity) {
            this.f4309a = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.a(this.f4309a, c.f4303b);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f4310a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f4311b;

        public b(Activity activity, d dVar) {
            this.f4310a = activity;
            this.f4311b = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.a(this.f4310a, c.f4303b);
            d dVar = this.f4311b;
            if (dVar != null) {
                dVar.onDismiss();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.acse.ottn.c$c, reason: collision with other inner class name */
    public class ViewOnClickListenerC0070c implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f4312a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f4313b;

        public ViewOnClickListenerC0070c(Activity activity, d dVar) {
            this.f4312a = activity;
            this.f4313b = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.a(this.f4312a, c.f4303b);
            d dVar = this.f4313b;
            if (dVar != null) {
                dVar.onOpen();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface d {
        void onDismiss();

        void onOpen();
    }

    public static AlertDialog a(Activity activity, String str, d dVar) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.accessiblity_seeding_green_fragment_dialog, (ViewGroup) null);
        f4304c = (ImageView) inflate.findViewById(R.id.iv_dissmiss);
        f4306e = (TextView) inflate.findViewById(R.id.tv_button);
        f4307f = (TextView) inflate.findViewById(R.id.tv_but2);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_version_info);
        f4305d = textView;
        textView.setText(str + "😭");
        f4304c.setOnClickListener(new a(activity));
        f4306e.setOnClickListener(new b(activity, dVar));
        f4307f.setOnClickListener(new ViewOnClickListenerC0070c(activity, dVar));
        g0.a().b(activity, f4307f);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.AlertDialogCustom);
        builder.setView(inflate);
        builder.setCancelable(true);
        AlertDialog create = builder.create();
        f4303b = create;
        create.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        b(activity, f4303b);
        return f4303b;
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
