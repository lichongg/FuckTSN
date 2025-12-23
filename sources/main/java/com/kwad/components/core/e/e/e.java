package com.kwad.components.core.e.e;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.proxy.j;
import org.apache.commons.net.ftp.l;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class e extends j {
    private a.C0616a PT;
    private Activity mActivity;

    public static void a(Activity activity, a.C0616a c0616a) {
        if (activity == null || c0616a == null) {
            return;
        }
        e eVar = new e();
        eVar.PT = c0616a;
        eVar.mActivity = activity;
        eVar.show(activity.getFragmentManager(), "second_confirm_dialog");
    }

    @Override // android.app.DialogFragment
    @NonNull
    public final Dialog onCreateDialog(Bundle bundle) {
        g.pY().pZ();
        com.kwad.sdk.core.adlog.c.b(this.PT.getAdTemplate(), l.f50690q, (JSONObject) null);
        return super.onCreateDialog(bundle);
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        g.pY().qa();
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onStart() {
        super.onStart();
    }

    @Override // com.kwad.components.core.proxy.j
    public final View a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getDialog().setCanceledOnTouchOutside(false);
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kwad.components.core.e.e.e.1
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i6, KeyEvent keyEvent) {
                return i6 == 4;
            }
        });
        return new a(this.mActivity, this, this.PT);
    }
}
