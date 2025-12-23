package com.bxkj.student.run.app.face.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bxkj.student.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class a extends Dialog {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.bxkj.student.run.app.face.widget.a$a, reason: collision with other inner class name */
    public static class C0265a {

        /* renamed from: a, reason: collision with root package name */
        private Context f19811a;

        /* renamed from: b, reason: collision with root package name */
        private String f19812b;

        /* renamed from: c, reason: collision with root package name */
        private String f19813c;

        /* renamed from: d, reason: collision with root package name */
        private String f19814d;

        /* renamed from: e, reason: collision with root package name */
        private DialogInterface.OnClickListener f19815e;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.student.run.app.face.widget.a$a$a, reason: collision with other inner class name */
        class ViewOnClickListenerC0266a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ a f19816a;

            ViewOnClickListenerC0266a(final a val$dialog) {
                this.f19816a = val$dialog;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v5) {
                C0265a.this.f19815e.onClick(this.f19816a, -2);
            }
        }

        public a b() {
            LayoutInflater layoutInflater = (LayoutInflater) this.f19811a.getSystemService("layout_inflater");
            a aVar = new a(this.f19811a, 2132017470);
            View inflate = layoutInflater.inflate(R.layout.widget_face_dialog, (ViewGroup) null);
            aVar.addContentView(inflate, new ViewGroup.LayoutParams(-2, -2));
            ((TextView) inflate.findViewById(2131296867)).setText(this.f19812b);
            if (this.f19814d != null) {
                ((TextView) inflate.findViewById(2131296860)).setText(this.f19814d);
                if (this.f19815e != null) {
                    inflate.findViewById(2131296860).setOnClickListener(new ViewOnClickListenerC0266a(aVar));
                }
            } else {
                inflate.findViewById(2131296860).setVisibility(8);
            }
            if (this.f19813c != null) {
                ((TextView) inflate.findViewById(2131296862)).setText(this.f19813c);
            }
            aVar.setContentView(inflate);
            return aVar;
        }

        public C0265a c(int message) {
            this.f19813c = (String) this.f19811a.getText(message);
            return this;
        }

        public C0265a d(String message) {
            this.f19813c = message;
            return this;
        }

        public C0265a e(int negativeButtonText, DialogInterface.OnClickListener listener) {
            this.f19814d = (String) this.f19811a.getText(negativeButtonText);
            this.f19815e = listener;
            return this;
        }

        public C0265a f(String negativeButtonText, DialogInterface.OnClickListener listener) {
            this.f19814d = negativeButtonText;
            this.f19815e = listener;
            return this;
        }

        public C0265a g(int title) {
            this.f19812b = (String) this.f19811a.getText(title);
            return this;
        }

        public C0265a h(String title) {
            this.f19812b = title;
            return this;
        }

        public C0265a(Context context) {
            this.f19811a = context;
        }
    }

    public a(Context context) {
        super(context);
    }

    public a(Context context, int theme) {
        super(context, theme);
    }
}
