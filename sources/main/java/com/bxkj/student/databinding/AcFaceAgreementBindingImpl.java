package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.bxkj.student.R;
import com.bxkj.student.generated.callback.a;
import com.bxkj.student.v2.ui.face.FaceAgreementActivity;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class AcFaceAgreementBindingImpl extends AcFaceAgreementBinding implements a.InterfaceC0207a {

    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes;

    @Nullable
    private static final SparseIntArray sViewsWithIds;

    @Nullable
    private final View.OnClickListener mCallback24;

    @Nullable
    private final View.OnClickListener mCallback25;
    private long mDirtyFlags;

    @NonNull
    private final RelativeLayout mboundView0;

    public AcFaceAgreementBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }

    @Override // com.bxkj.student.generated.callback.a.InterfaceC0207a
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        FaceAgreementActivity faceAgreementActivity;
        if (sourceId != 1) {
            if (sourceId == 2 && (faceAgreementActivity = this.mActivity) != null) {
                faceAgreementActivity.M();
                return;
            }
            return;
        }
        FaceAgreementActivity faceAgreementActivity2 = this.mActivity;
        if (faceAgreementActivity2 != null) {
            faceAgreementActivity2.z2();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j6;
        synchronized (this) {
            j6 = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        FaceAgreementActivity faceAgreementActivity = this.mActivity;
        long j7 = 6 & j6;
        if ((j6 & 4) != 0) {
            this.btAgree.setOnClickListener(this.mCallback25);
            this.btRefuse.setOnClickListener(this.mCallback24);
            this.llTitle.setTitle("隐私声明");
        }
        if (j7 != 0) {
            this.llTitle.setActivity(faceAgreementActivity);
        }
        ViewDataBinding.executeBindingsOn(this.llTitle);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.mDirtyFlags != 0) {
                    return true;
                }
                return this.llTitle.hasPendingBindings();
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
        this.llTitle.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (1 != variableId) {
            return false;
        }
        setActivity((FaceAgreementActivity) variable);
        return true;
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(5);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"v2_pub_title"}, new int[]{3}, new int[]{R.layout.v2_pub_title});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131298015, 4);
    }

    private AcFaceAgreementBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (Button) bindings[2], (Button) bindings[1], (LinearLayout) bindings[4], (V2PubTitleBinding) bindings[3]);
        this.mDirtyFlags = -1L;
        this.btAgree.setTag(null);
        this.btRefuse.setTag(null);
        setContainedBinding(this.llTitle);
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        setRootTag(root);
        this.mCallback25 = new a(this, 2);
        this.mCallback24 = new a(this, 1);
        invalidateAll();
    }

    private boolean onChangeLlTitle(V2PubTitleBinding LlTitle, int fieldId) {
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
        return onChangeLlTitle((V2PubTitleBinding) object, fieldId);
    }

    @Override // com.bxkj.student.databinding.AcFaceAgreementBinding
    public void setActivity(@Nullable FaceAgreementActivity Activity) {
        this.mActivity = Activity;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.llTitle.setLifecycleOwner(lifecycleOwner);
    }
}
