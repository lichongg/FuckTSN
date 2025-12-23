package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.bxkj.student.R;
import com.bxkj.student.generated.callback.a;
import com.bxkj.student.v2.ui.dialog.NoticeDialog;
import com.google.android.material.imageview.ShapeableImageView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class DialogTipsBindingImpl extends DialogTipsBinding implements a.InterfaceC0207a {

    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;

    @Nullable
    private static final SparseIntArray sViewsWithIds;

    @Nullable
    private final View.OnClickListener mCallback34;

    @Nullable
    private final View.OnClickListener mCallback35;

    @Nullable
    private final View.OnClickListener mCallback36;
    private long mDirtyFlags;

    @NonNull
    private final ConstraintLayout mboundView0;

    @NonNull
    private final ShapeableImageView mboundView1;

    public DialogTipsBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds));
    }

    @Override // com.bxkj.student.generated.callback.a.InterfaceC0207a
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        NoticeDialog noticeDialog;
        if (sourceId == 1) {
            NoticeDialog noticeDialog2 = this.mDialog;
            if (noticeDialog2 != null) {
                noticeDialog2.dismiss();
                return;
            }
            return;
        }
        if (sourceId != 2) {
            if (sourceId == 3 && (noticeDialog = this.mDialog) != null) {
                noticeDialog.O();
                return;
            }
            return;
        }
        NoticeDialog noticeDialog3 = this.mDialog;
        if (noticeDialog3 != null) {
            noticeDialog3.O();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j6;
        synchronized (this) {
            j6 = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        if ((j6 & 2) != 0) {
            this.bt.setOnClickListener(this.mCallback36);
            this.iv.setOnClickListener(this.mCallback35);
            this.mboundView1.setOnClickListener(this.mCallback34);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                return this.mDirtyFlags != 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.ll_msg, 4);
        sparseIntArray.put(2131299164, 5);
        sparseIntArray.put(R.id.divider, 6);
        sparseIntArray.put(2131298844, 7);
    }

    private DialogTipsBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (AppCompatButton) bindings[3], (View) bindings[6], (ImageView) bindings[2], (LinearLayout) bindings[4], (TextView) bindings[7], (TextView) bindings[5]);
        this.mDirtyFlags = -1L;
        this.bt.setTag(null);
        this.iv.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        ShapeableImageView shapeableImageView = (ShapeableImageView) bindings[1];
        this.mboundView1 = shapeableImageView;
        shapeableImageView.setTag(null);
        setRootTag(root);
        this.mCallback36 = new a(this, 3);
        this.mCallback34 = new a(this, 1);
        this.mCallback35 = new a(this, 2);
        invalidateAll();
    }

    @Override // com.bxkj.student.databinding.DialogTipsBinding
    public void setDialog(@Nullable NoticeDialog Dialog) {
        this.mDialog = Dialog;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(9);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (9 != variableId) {
            return false;
        }
        setDialog((NoticeDialog) variable);
        return true;
    }
}
