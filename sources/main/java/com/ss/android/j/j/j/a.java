package com.ss.android.j.j.j;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.j.j.up.a;
import w2.w;

/* loaded from: D:\Downloads\app\classes6.dex */
public class a implements w {

    /* renamed from: com.ss.android.j.j.j.a$a, reason: collision with other inner class name */
    static class DialogInterfaceOnClickListenerC0766a implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.ss.android.j.j.up.a f38243a;

        DialogInterfaceOnClickListenerC0766a(com.ss.android.j.j.up.a aVar) {
            this.f38243a = aVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i6) {
            a.c cVar = this.f38243a.f38254h;
            if (cVar != null) {
                cVar.xt(dialogInterface);
            }
        }
    }

    static class b implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.ss.android.j.j.up.a f38244a;

        b(com.ss.android.j.j.up.a aVar) {
            this.f38244a = aVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i6) {
            a.c cVar = this.f38244a.f38254h;
            if (cVar != null) {
                cVar.j(dialogInterface);
            }
        }
    }

    static class c implements DialogInterface.OnCancelListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.ss.android.j.j.up.a f38245a;

        c(com.ss.android.j.j.up.a aVar) {
            this.f38245a = aVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            a.c cVar = this.f38245a.f38254h;
            if (cVar != null) {
                cVar.cw(dialogInterface);
            }
        }
    }

    @Override // w2.w
    public void j(int i6, @Nullable Context context, com.ss.android.j.j.cw.b bVar, String str, Drawable drawable, int i7) {
        Toast.makeText(context, str, 0).show();
    }

    private static Dialog a(com.ss.android.j.j.up.a aVar) {
        if (aVar == null) {
            return null;
        }
        AlertDialog show = new AlertDialog.Builder(aVar.f38247a).setTitle(aVar.f38248b).setMessage(aVar.f38249c).setPositiveButton(aVar.f38250d, new b(aVar)).setNegativeButton(aVar.f38251e, new DialogInterfaceOnClickListenerC0766a(aVar)).show();
        show.setCanceledOnTouchOutside(aVar.f38252f);
        show.setOnCancelListener(new c(aVar));
        Drawable drawable = aVar.f38253g;
        if (drawable != null) {
            show.setIcon(drawable);
        }
        return show;
    }

    @Override // w2.w
    public Dialog xt(@NonNull com.ss.android.j.j.up.a aVar) {
        return a(aVar);
    }
}
