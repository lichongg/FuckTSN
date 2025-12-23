package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.bxkj.student.R;
import com.bxkj.student.generated.callback.a;
import com.bxkj.student.v2.ui.face.FaceCollectConfirmActivity;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class V3FaceCollectConfirmBindingImpl extends V3FaceCollectConfirmBinding implements a.InterfaceC0207a {

    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes;

    @Nullable
    private static final SparseIntArray sViewsWithIds;

    @Nullable
    private final View.OnClickListener mCallback79;

    @Nullable
    private final View.OnClickListener mCallback80;
    private long mDirtyFlags;

    @NonNull
    private final NestedScrollView mboundView0;

    @NonNull
    private final ConstraintLayout mboundView1;

    @NonNull
    private final Button mboundView2;

    @NonNull
    private final Button mboundView3;

    public V3FaceCollectConfirmBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds));
    }

    @Override // com.bxkj.student.generated.callback.a.InterfaceC0207a
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        FaceCollectConfirmActivity faceCollectConfirmActivity;
        if (sourceId != 1) {
            if (sourceId == 2 && (faceCollectConfirmActivity = this.mActivity) != null) {
                faceCollectConfirmActivity.M();
                return;
            }
            return;
        }
        FaceCollectConfirmActivity faceCollectConfirmActivity2 = this.mActivity;
        if (faceCollectConfirmActivity2 != null) {
            faceCollectConfirmActivity2.finish();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j6;
        synchronized (this) {
            j6 = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        FaceCollectConfirmActivity faceCollectConfirmActivity = this.mActivity;
        if ((6 & j6) != 0) {
            this.layoutTitle.setActivity(faceCollectConfirmActivity);
        }
        if ((j6 & 4) != 0) {
            this.layoutTitle.setTitle("人脸信息确认");
            this.mboundView2.setOnClickListener(this.mCallback79);
            this.mboundView3.setOnClickListener(this.mCallback80);
        }
        ViewDataBinding.executeBindingsOn(this.layoutTitle);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.mDirtyFlags != 0) {
                    return true;
                }
                return this.layoutTitle.hasPendingBindings();
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
        this.layoutTitle.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (1 != variableId) {
            return false;
        }
        setActivity((FaceCollectConfirmActivity) variable);
        return true;
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(8);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"v3_pub_title"}, new int[]{4}, new int[]{R.layout.v3_pub_title});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.iv_face, 5);
        sparseIntArray.put(R.id.tv_info_title, 6);
        sparseIntArray.put(2131298946, 7);
    }

    private V3FaceCollectConfirmBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (ImageView) bindings[5], (V3PubTitleBinding) bindings[4], (TextView) bindings[7], (TextView) bindings[6]);
        this.mDirtyFlags = -1L;
        setContainedBinding(this.layoutTitle);
        NestedScrollView nestedScrollView = (NestedScrollView) bindings[0];
        this.mboundView0 = nestedScrollView;
        nestedScrollView.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[1];
        this.mboundView1 = constraintLayout;
        constraintLayout.setTag(null);
        Button button = (Button) bindings[2];
        this.mboundView2 = button;
        button.setTag(null);
        Button button2 = (Button) bindings[3];
        this.mboundView3 = button2;
        button2.setTag(null);
        setRootTag(root);
        this.mCallback79 = new a(this, 1);
        this.mCallback80 = new a(this, 2);
        invalidateAll();
    }

    private boolean onChangeLayoutTitle(V3PubTitleBinding LayoutTitle, int fieldId) {
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
        return onChangeLayoutTitle((V3PubTitleBinding) object, fieldId);
    }

    @Override // com.bxkj.student.databinding.V3FaceCollectConfirmBinding
    public void setActivity(@Nullable FaceCollectConfirmActivity Activity) {
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
        this.layoutTitle.setLifecycleOwner(lifecycleOwner);
    }
}
