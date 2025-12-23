package com.acse.ottn;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.activity.SeedWebViewActivity;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class c4 {

    /* renamed from: a, reason: collision with root package name */
    public static AlertDialog f4320a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f4321a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Activity f4322b;

        public a(e eVar, Activity activity) {
            this.f4321a = eVar;
            this.f4322b = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f4321a.onOpen();
            c4.a(this.f4322b, c4.f4320a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f4323a;

        public b(Activity activity) {
            this.f4323a = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c4.a(this.f4323a, c4.f4320a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class c implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f4324a;

        public c(Activity activity) {
            this.f4324a = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent(this.f4324a, (Class<?>) SeedWebViewActivity.class);
            intent.putExtra("url", g0.a().b(this.f4324a));
            this.f4324a.startActivity(intent);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class d implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f4325a;

        public d(Activity activity) {
            this.f4325a = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent(this.f4325a, (Class<?>) SeedWebViewActivity.class);
            intent.putExtra("url", g0.a().d(this.f4325a));
            this.f4325a.startActivity(intent);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface e {
        void onDismiss();

        void onOpen();
    }

    public static AlertDialog a(Activity activity, e eVar) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.main_dialog, (ViewGroup) null);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.AlertDialogCustom);
        builder.setView(inflate);
        builder.setCancelable(true);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_but2);
        textView.setOnClickListener(new a(eVar, activity));
        ((TextView) inflate.findViewById(R.id.tv_button)).setOnClickListener(new b(activity));
        ((TextView) inflate.findViewById(R.id.title)).setText("请先同意" + k0.f4666b);
        TextView textView2 = (TextView) inflate.findViewById(R.id.tv_privacy);
        textView2.setOnClickListener(new c(activity));
        TextView textView3 = (TextView) inflate.findViewById(R.id.tv_service);
        textView3.setOnClickListener(new d(activity));
        g0.a().d(activity, textView3);
        g0.a().d(activity, textView2);
        g0.a().d(activity, textView);
        AlertDialog create = builder.create();
        f4320a = create;
        create.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        b(activity, f4320a);
        return f4320a;
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
