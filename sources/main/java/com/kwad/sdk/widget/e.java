package com.kwad.sdk.widget;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;
import com.kwad.sdk.o.m;
import com.kwad.sdk.service.ServiceProvider;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class e extends c {
    private int bdA;
    private String bdB;
    private int bdC;
    private b bdx;
    private String bdy;
    private String bdz;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {
        private int bdA;
        private String bdB;
        private int bdC;
        private b bdx;
        private String bdy;
        private String bdz;
        private Context mContext;

        public final e SO() {
            return new e(this);
        }

        public final a a(b bVar) {
            this.bdx = bVar;
            return this;
        }

        public final a hJ(@NonNull String str) {
            this.bdy = str;
            return this;
        }

        public final a hK(String str) {
            this.bdz = str;
            return this;
        }

        public final a hL(String str) {
            this.bdB = str;
            return this;
        }

        public a(@NonNull Context context) {
            this.mContext = context;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        void a(DialogInterface dialogInterface);

        void b(DialogInterface dialogInterface);

        void c(DialogInterface dialogInterface);
    }

    private void a(a aVar) {
        if (aVar.mContext instanceof Activity) {
            setOwnerActivity((Activity) aVar.mContext);
        }
        this.bdx = aVar.bdx;
        this.bdy = aVar.bdy;
        this.bdz = !TextUtils.isEmpty(aVar.bdz) ? aVar.bdz : aVar.mContext.getString(R.string.ksad_no_title_common_dialog_positivebtn_title);
        this.bdA = aVar.bdA != 0 ? aVar.bdA : aVar.mContext.getResources().getColor(R.color.ksad_no_title_common_dialog_positivebtn_color);
        this.bdB = !TextUtils.isEmpty(aVar.bdB) ? aVar.bdB : aVar.mContext.getString(R.string.ksad_no_title_common_dialog_negativebtn_title);
        this.bdC = aVar.bdC != 0 ? aVar.bdC : aVar.mContext.getResources().getColor(R.color.ksad_no_title_common_dialog_negativebtn_color);
    }

    public e(a aVar) {
        super(aVar.mContext);
        a(aVar);
    }

    private View rO() {
        View inflate = LayoutInflater.from(m.wrapContextIfNeed(getContext())).inflate(R.layout.ksad_no_title_common_dialog_content_layout, (ViewGroup) null, false);
        inflate.findViewById(R.id.ksad_no_title_common_dialog_layout).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.widget.e.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (e.this.bdx != null) {
                    e.this.bdx.c(e.this);
                }
            }
        });
        TextView textView = (TextView) inflate.findViewById(R.id.ksad_no_title_common_positive_btn);
        if (!TextUtils.isEmpty(this.bdz)) {
            textView.setText(this.bdz);
        }
        textView.setTextColor(this.bdA);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.widget.e.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (e.this.bdx != null) {
                    e.this.bdx.a(e.this);
                }
            }
        });
        TextView textView2 = (TextView) inflate.findViewById(R.id.ksad_no_title_common_negative_btn);
        if (!TextUtils.isEmpty(this.bdB)) {
            textView2.setText(this.bdB);
        }
        textView2.setTextColor(this.bdC);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.widget.e.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (e.this.bdx != null) {
                    e.this.bdx.b(e.this);
                }
            }
        });
        ((TextView) inflate.findViewById(R.id.ksad_no_title_common_content_text)).setText(this.bdy);
        return inflate;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            requestWindowFeature(1);
            setContentView(rO());
            setCanceledOnTouchOutside(true);
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getWindow().setLayout(-1, -1);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
