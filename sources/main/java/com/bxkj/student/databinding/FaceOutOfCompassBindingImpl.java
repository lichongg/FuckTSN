package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.bxkj.student.generated.callback.a;
import com.bxkj.student.v2.ui.dialog.FaceOutDialog;
import com.google.android.material.card.MaterialCardView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class FaceOutOfCompassBindingImpl extends FaceOutOfCompassBinding implements a.InterfaceC0207a {

    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;

    @Nullable
    private static final SparseIntArray sViewsWithIds;

    @Nullable
    private final View.OnClickListener mCallback66;

    @Nullable
    private final View.OnClickListener mCallback67;
    private long mDirtyFlags;

    @NonNull
    private final MaterialCardView mboundView0;

    public FaceOutOfCompassBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }

    @Override // com.bxkj.student.generated.callback.a.InterfaceC0207a
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        FaceOutDialog faceOutDialog;
        if (sourceId != 1) {
            if (sourceId == 2 && (faceOutDialog = this.mDialog) != null) {
                faceOutDialog.M();
                return;
            }
            return;
        }
        FaceOutDialog faceOutDialog2 = this.mDialog;
        if (faceOutDialog2 != null) {
            faceOutDialog2.n();
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
            this.btnOne.setOnClickListener(this.mCallback66);
            this.btnTwo.setOnClickListener(this.mCallback67);
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
        sparseIntArray.put(2131299164, 3);
        sparseIntArray.put(2131297985, 4);
        sparseIntArray.put(2131298672, 5);
        sparseIntArray.put(2131297959, 6);
    }

    private FaceOutOfCompassBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (Button) bindings[1], (Button) bindings[2], (LinearLayout) bindings[6], (View) bindings[4], (TextView) bindings[5], (TextView) bindings[3]);
        this.mDirtyFlags = -1L;
        this.btnOne.setTag(null);
        this.btnTwo.setTag(null);
        MaterialCardView materialCardView = (MaterialCardView) bindings[0];
        this.mboundView0 = materialCardView;
        materialCardView.setTag(null);
        setRootTag(root);
        this.mCallback67 = new a(this, 2);
        this.mCallback66 = new a(this, 1);
        invalidateAll();
    }

    @Override // com.bxkj.student.databinding.FaceOutOfCompassBinding
    public void setDialog(@Nullable FaceOutDialog Dialog) {
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
        setDialog((FaceOutDialog) variable);
        return true;
    }
}
