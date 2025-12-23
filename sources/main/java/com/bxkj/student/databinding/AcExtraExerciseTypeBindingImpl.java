package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.bxkj.base.R;
import com.bxkj.base.databinding.NewPubTitleBinding;
import com.bxkj.student.generated.callback.a;
import com.bxkj.student.run.extraclass.SignTypeActivity;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class AcExtraExerciseTypeBindingImpl extends AcExtraExerciseTypeBinding implements a.InterfaceC0207a {

    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes;

    @Nullable
    private static final SparseIntArray sViewsWithIds;

    @Nullable
    private final View.OnClickListener mCallback2;

    @Nullable
    private final View.OnClickListener mCallback3;
    private long mDirtyFlags;

    @NonNull
    private final LinearLayout mboundView0;

    public AcExtraExerciseTypeBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }

    @Override // com.bxkj.student.generated.callback.a.InterfaceC0207a
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        SignTypeActivity signTypeActivity;
        if (sourceId != 1) {
            if (sourceId == 2 && (signTypeActivity = this.mSignTypeActivity) != null) {
                signTypeActivity.N();
                return;
            }
            return;
        }
        SignTypeActivity signTypeActivity2 = this.mSignTypeActivity;
        if (signTypeActivity2 != null) {
            signTypeActivity2.M();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j6;
        synchronized (this) {
            j6 = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        SignTypeActivity signTypeActivity = this.mSignTypeActivity;
        long j7 = 6 & j6;
        if ((j6 & 4) != 0) {
            this.btIn.setOnClickListener(this.mCallback2);
            this.btOut.setOnClickListener(this.mCallback3);
            this.toolbar.setTitle("选择签到类型");
        }
        if (j7 != 0) {
            this.toolbar.setActivity(signTypeActivity);
        }
        ViewDataBinding.executeBindingsOn(this.toolbar);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.mDirtyFlags != 0) {
                    return true;
                }
                return this.toolbar.hasPendingBindings();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4L;
        }
        this.toolbar.invalidateAll();
        requestRebind();
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(4);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"new_pub_title"}, new int[]{3}, new int[]{R.layout.new_pub_title});
        sViewsWithIds = null;
    }

    private AcExtraExerciseTypeBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (Button) bindings[1], (Button) bindings[2], (NewPubTitleBinding) bindings[3]);
        this.mDirtyFlags = -1L;
        this.btIn.setTag(null);
        this.btOut.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        setContainedBinding(this.toolbar);
        setRootTag(root);
        this.mCallback3 = new a(this, 2);
        this.mCallback2 = new a(this, 1);
        invalidateAll();
    }

    private boolean onChangeToolbar(NewPubTitleBinding Toolbar, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId != 0) {
            return false;
        }
        return onChangeToolbar((NewPubTitleBinding) object, fieldId);
    }

    @Override // com.bxkj.student.databinding.AcExtraExerciseTypeBinding
    public void setSignTypeActivity(@Nullable SignTypeActivity SignTypeActivity) {
        this.mSignTypeActivity = SignTypeActivity;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(25);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (25 != variableId) {
            return false;
        }
        setSignTypeActivity((SignTypeActivity) variable);
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.toolbar.setLifecycleOwner(lifecycleOwner);
    }
}
