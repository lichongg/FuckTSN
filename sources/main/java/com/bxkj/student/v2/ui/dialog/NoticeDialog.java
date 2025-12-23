package com.bxkj.student.v2.ui.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.FragmentActivity;
import com.bxkj.base.v2.base.BaseDialog;
import com.bxkj.base.v2.common.utils.c0;
import com.bxkj.base.v2.data.ParcelableMap;
import com.bxkj.student.databinding.DialogTipsBinding;
import com.bxkj.student.v2.common.utils.i;
import com.bxkj.student.v2.common.utils.w;
import com.bxkj.student.v2.vm.NoticeVM;
import com.orhanobut.logger.j;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import kotlin.text.u;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nNoticeDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NoticeDialog.kt\ncom/bxkj/student/v2/ui/dialog/NoticeDialog\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,106:1\n256#2,2:107\n256#2,2:109\n256#2,2:111\n256#2,2:113\n*S KotlinDebug\n*F\n+ 1 NoticeDialog.kt\ncom/bxkj/student/v2/ui/dialog/NoticeDialog\n*L\n41#1:107,2\n43#1:109,2\n46#1:111,2\n49#1:113,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class NoticeDialog extends BaseDialog<DialogTipsBinding, NoticeVM> {
    public final void O() {
        c0 c0Var = c0.f16887a;
        String t5 = c0Var.t((Map) D().t().getValue(), "appletId");
        String t6 = c0Var.t((Map) D().t().getValue(), "appletPath");
        String t7 = c0Var.t((Map) D().t().getValue(), "linkUrl");
        if (!u.M3(t5) && !u.M3(t6)) {
            w.f20952a.a(H(), c0Var.t((Map) D().t().getValue(), "appletId"), c0Var.t((Map) D().t().getValue(), "appletPath"));
        } else if (!u.M3(t7)) {
            i iVar = i.f20904a;
            FragmentActivity r5 = r();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(CommonNetImpl.NAME, c0Var.t((Map) D().t().getValue(), "title"));
            linkedHashMap.put("linkUrl", t7);
            n1 n1Var = n1.f44123a;
            iVar.b(r5, linkedHashMap);
        }
        M();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 N(NoticeDialog noticeDialog) {
        noticeDialog.f();
        return n1.f44123a;
    }

    public final void M() {
        D().u(new Function0() { // from class: com.bxkj.student.v2.ui.dialog.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n1 N;
                N = NoticeDialog.N(NoticeDialog.this);
                return N;
            }
        });
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setStyle(2, 2132017957);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setBackgroundDrawableResource(2131100584);
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null) {
            dialog2.setCanceledOnTouchOutside(false);
        }
    }

    @Override // com.bxkj.base.v2.base.a
    public void t() {
        Bundle arguments;
        ParcelableMap parcelableMap;
        int i6;
        int i7;
        int i8;
        boolean z5;
        String str;
        L().setDialog(this);
        Bundle arguments2 = getArguments();
        if (arguments2 != null && arguments2.containsKey("data") && (arguments = getArguments()) != null && (parcelableMap = (ParcelableMap) arguments.getParcelable("data")) != null) {
            Map<String, ? extends Object> a6 = parcelableMap.a();
            int i9 = 0;
            j.d("NoticeDialog=" + a6, new Object[0]);
            D().t().postValue(a6);
            c0 c0Var = c0.f16887a;
            String t5 = c0Var.t(a6, "title");
            L().tvTitle.setText(t5);
            TextView tvTitle = L().tvTitle;
            g0.o(tvTitle, "tvTitle");
            if (!u.M3(t5)) {
                i6 = 0;
            } else {
                i6 = 8;
            }
            tvTitle.setVisibility(i6);
            View divider = L().divider;
            g0.o(divider, "divider");
            if (!u.M3(t5)) {
                i7 = 0;
            } else {
                i7 = 8;
            }
            divider.setVisibility(i7);
            String t6 = c0Var.t(a6, "des");
            TextView tvContent = L().tvContent;
            g0.o(tvContent, "tvContent");
            if (!u.M3(t6)) {
                i8 = 0;
            } else {
                i8 = 8;
            }
            tvContent.setVisibility(i8);
            L().tvContent.setText(t6);
            ImageView iv = L().iv;
            g0.o(iv, "iv");
            if (c0Var.k(a6, "type") != 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (!z5) {
                i9 = 8;
            }
            iv.setVisibility(i9);
            com.bumptech.glide.b.D(H()).a(c0Var.t(a6, "imageUrl")).m1(L().iv);
            String t7 = c0Var.t((Map) D().t().getValue(), "appletId");
            String t8 = c0Var.t((Map) D().t().getValue(), "appletPath");
            String t9 = c0Var.t((Map) D().t().getValue(), "linkUrl");
            AppCompatButton appCompatButton = L().bt;
            if (u.M3(t7) && u.M3(t8) && u.M3(t9)) {
                str = "我已知晓";
            } else {
                str = "立即查看";
            }
            appCompatButton.setText(str);
        }
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
    }
}
