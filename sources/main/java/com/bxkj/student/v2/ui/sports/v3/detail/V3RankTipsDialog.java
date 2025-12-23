package com.bxkj.student.v2.ui.sports.v3.detail;

import android.app.Dialog;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
import com.bxkj.base.v2.base.BaseAdapter;
import com.bxkj.base.v2.base.BaseDialog;
import com.bxkj.student.databinding.ItemForV3PassPointDialogBinding;
import com.bxkj.student.databinding.V3RankDialogBinding;
import com.bxkj.student.v2.vm.sports.SportsVM;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class V3RankTipsDialog extends BaseDialog<V3RankDialogBinding, SportsVM> {

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    private final List<Map<String, Object>> f21610k = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    private BaseAdapter<Map<String, Object>, ItemForV3PassPointDialogBinding> f21611l;

    @NotNull
    public final List<Map<String, Object>> M() {
        return this.f21610k;
    }

    public final void N(@Nullable BaseAdapter<Map<String, Object>, ItemForV3PassPointDialogBinding> baseAdapter) {
        this.f21611l = baseAdapter;
    }

    @Nullable
    public final BaseAdapter<Map<String, Object>, ItemForV3PassPointDialogBinding> n() {
        return this.f21611l;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setStyle(2, 2132017771);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            r().getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
            Window window = dialog.getWindow();
            if (window != null) {
                window.setBackgroundDrawableResource(2131100584);
                WindowManager.LayoutParams attributes = window.getAttributes();
                g0.o(attributes, "getAttributes(...)");
                attributes.width = (int) (r1.widthPixels * 0.9d);
                attributes.height = -2;
                attributes.gravity = 17;
                window.setGravity(17);
                window.setAttributes(attributes);
            }
        }
    }

    @Override // com.bxkj.base.v2.base.a
    public void t() {
        L().setDialog(this);
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
    }
}
