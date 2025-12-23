package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.bxkj.base.v2.common.view.b;
import com.bxkj.student.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class AcFacePrivacyAgreementBindingImpl extends AcFacePrivacyAgreementBinding {

    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes;

    @Nullable
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    @NonNull
    private final RelativeLayout mboundView0;

    public AcFacePrivacyAgreementBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j6;
        synchronized (this) {
            j6 = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        b bVar = this.mMActivity;
        if ((6 & j6) != 0) {
            this.titleLayout.setActivity(bVar);
        }
        if ((j6 & 4) != 0) {
            this.titleLayout.setTitle("欢迎使用体适能App");
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
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(7);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"v2_pub_title"}, new int[]{1}, new int[]{R.layout.v2_pub_title});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.tv_user_agree, 2);
        sparseIntArray.put(R.id.tv_user_private, 3);
        sparseIntArray.put(2131298015, 4);
        sparseIntArray.put(R.id.bt_refuse, 5);
        sparseIntArray.put(R.id.bt_agree, 6);
    }

    private AcFacePrivacyAgreementBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (Button) bindings[6], (Button) bindings[5], (LinearLayout) bindings[4], (V2PubTitleBinding) bindings[1], (TextView) bindings[2], (TextView) bindings[3]);
        this.mDirtyFlags = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        setContainedBinding(this.titleLayout);
        setRootTag(root);
        invalidateAll();
    }

    private boolean onChangeTitleLayout(V2PubTitleBinding TitleLayout, int fieldId) {
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
        return onChangeTitleLayout((V2PubTitleBinding) object, fieldId);
    }

    @Override // com.bxkj.student.databinding.AcFacePrivacyAgreementBinding
    public void setMActivity(@Nullable b MActivity) {
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
        setMActivity((b) variable);
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.titleLayout.setLifecycleOwner(lifecycleOwner);
    }
}
