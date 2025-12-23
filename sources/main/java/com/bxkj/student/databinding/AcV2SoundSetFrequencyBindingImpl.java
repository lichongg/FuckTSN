package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.bxkj.student.R;
import com.bxkj.student.generated.callback.a;
import com.bxkj.student.v2.ui.sports.set.SoundFrequencyActivity;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class AcV2SoundSetFrequencyBindingImpl extends AcV2SoundSetFrequencyBinding implements a.InterfaceC0207a {

    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes;

    @Nullable
    private static final SparseIntArray sViewsWithIds;

    @Nullable
    private final View.OnClickListener mCallback23;
    private long mDirtyFlags;

    @NonNull
    private final LinearLayout mboundView0;

    public AcV2SoundSetFrequencyBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j6;
        synchronized (this) {
            j6 = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        SoundFrequencyActivity soundFrequencyActivity = this.mMActivity;
        long j7 = 6 & j6;
        if ((j6 & 4) != 0) {
            this.btOk.setOnClickListener(this.mCallback23);
            this.titleLayout.setTitle("播报频率设置");
        }
        if (j7 != 0) {
            this.titleLayout.setActivity(soundFrequencyActivity);
        }
        ViewDataBinding.executeBindingsOn(this.titleLayout);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.mDirtyFlags != 0) {
                    return true;
                }
                return this.titleLayout.hasPendingBindings();
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
        this.titleLayout.invalidateAll();
        requestRebind();
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(4);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"v3_pub_title"}, new int[]{2}, new int[]{R.layout.v3_pub_title});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131298361, 3);
    }

    private AcV2SoundSetFrequencyBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (Button) bindings[1], (RadioGroup) bindings[3], (V3PubTitleBinding) bindings[2]);
        this.mDirtyFlags = -1L;
        this.btOk.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        setContainedBinding(this.titleLayout);
        setRootTag(root);
        this.mCallback23 = new a(this, 1);
        invalidateAll();
    }

    private boolean onChangeTitleLayout(V3PubTitleBinding TitleLayout, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    @Override // com.bxkj.student.generated.callback.a.InterfaceC0207a
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        SoundFrequencyActivity soundFrequencyActivity = this.mMActivity;
        if (soundFrequencyActivity != null) {
            soundFrequencyActivity.finish();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId != 0) {
            return false;
        }
        return onChangeTitleLayout((V3PubTitleBinding) object, fieldId);
    }

    @Override // com.bxkj.student.databinding.AcV2SoundSetFrequencyBinding
    public void setMActivity(@Nullable SoundFrequencyActivity MActivity) {
        this.mMActivity = MActivity;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(17);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (17 != variableId) {
            return false;
        }
        setMActivity((SoundFrequencyActivity) variable);
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.titleLayout.setLifecycleOwner(lifecycleOwner);
    }
}
