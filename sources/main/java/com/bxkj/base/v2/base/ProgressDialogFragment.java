package com.bxkj.base.v2.base;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.bxkj.base.R;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class ProgressDialogFragment extends DialogFragment {

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private String f16722c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private Integer f16723d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private DialogInterface.OnKeyListener f16724e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private String f16725f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    private TextView f16726g;

    public ProgressDialogFragment() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public ProgressDialogFragment(@Nullable String str) {
        this.f16722c = str;
        this.f16725f = "Loading...";
    }

    public static /* synthetic */ void f(ProgressDialogFragment progressDialogFragment, FragmentManager fragmentManager, int i6, boolean z5, int i7, Object obj) {
        if ((i7 & 4) != 0) {
            z5 = false;
        }
        progressDialogFragment.d(fragmentManager, i6, z5);
    }

    public static /* synthetic */ void g(ProgressDialogFragment progressDialogFragment, FragmentManager fragmentManager, String str, boolean z5, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            z5 = false;
        }
        progressDialogFragment.e(fragmentManager, str, z5);
    }

    @Nullable
    public final DialogInterface.OnKeyListener b() {
        return this.f16724e;
    }

    public final void c(@Nullable DialogInterface.OnKeyListener onKeyListener) {
        this.f16724e = onKeyListener;
    }

    public final void d(@NotNull FragmentManager fragmentManager, int i6, boolean z5) {
        g0.p(fragmentManager, "fragmentManager");
        this.f16723d = Integer.valueOf(i6);
        setCancelable(z5);
        show(fragmentManager, "TSNProgressDialogFragment");
    }

    public final void e(@NotNull FragmentManager fragmentManager, @Nullable String str, boolean z5) {
        g0.p(fragmentManager, "fragmentManager");
        try {
            if (fragmentManager.isDestroyed()) {
                return;
            }
            this.f16722c = str;
            setCancelable(z5);
            if (str != null) {
                this.f16725f = str;
                TextView textView = this.f16726g;
                if (textView != null) {
                    textView.setText(str);
                }
            }
            if (isAdded() || isVisible() || isRemoving()) {
                return;
            }
            showNow(fragmentManager, "TSNProgressDialogFragment");
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        g0.p(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_progress_dialog, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        g0.p(view, "view");
        super.onViewCreated(view, bundle);
        TextView textView = (TextView) view.findViewById(R.id.tv_msg);
        this.f16726g = textView;
        if (textView != null && textView != null) {
            textView.setText(this.f16725f);
        }
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setOnKeyListener(this.f16724e);
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null) {
            dialog2.setCanceledOnTouchOutside(false);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, R.style.loadingDialogStyle);
    }

    public /* synthetic */ ProgressDialogFragment(String str, int i6, v vVar) {
        this((i6 & 1) != 0 ? "loading" : str);
    }
}
