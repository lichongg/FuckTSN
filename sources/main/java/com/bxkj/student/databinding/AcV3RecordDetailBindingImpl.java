package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import cn.bluemobi.dylan.base.view.NoSlidingViewPager;
import com.bxkj.base.view.MarqueeTextView;
import com.bxkj.student.R;
import com.bxkj.student.generated.callback.a;
import com.bxkj.student.v2.ui.sports.v3.detail.V3RecordDetailActivity;
import com.google.android.material.tabs.TabLayout;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class AcV3RecordDetailBindingImpl extends AcV3RecordDetailBinding implements a.InterfaceC0207a {

    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;

    @Nullable
    private static final SparseIntArray sViewsWithIds;

    @Nullable
    private final View.OnClickListener mCallback26;

    @Nullable
    private final View.OnClickListener mCallback27;
    private long mDirtyFlags;

    @NonNull
    private final ConstraintLayout mboundView0;

    public AcV3RecordDetailBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }

    @Override // com.bxkj.student.generated.callback.a.InterfaceC0207a
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        V3RecordDetailActivity v3RecordDetailActivity;
        if (sourceId != 1) {
            if (sourceId == 2 && (v3RecordDetailActivity = this.mMActivity) != null) {
                v3RecordDetailActivity.P();
                return;
            }
            return;
        }
        V3RecordDetailActivity v3RecordDetailActivity2 = this.mMActivity;
        if (v3RecordDetailActivity2 != null) {
            v3RecordDetailActivity2.r1();
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
            this.ibBack.setOnClickListener(this.mCallback26);
            this.toolbar.setOnClickListener(this.mCallback27);
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
        sparseIntArray.put(2131298764, 3);
        sparseIntArray.put(R.id.tb, 4);
        sparseIntArray.put(R.id.viewPager, 5);
    }

    private AcV3RecordDetailBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (AppCompatImageButton) bindings[1], (TabLayout) bindings[4], (TextView) bindings[2], (MarqueeTextView) bindings[3], (NoSlidingViewPager) bindings[5]);
        this.mDirtyFlags = -1L;
        this.ibBack.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.toolbar.setTag(null);
        setRootTag(root);
        this.mCallback27 = new a(this, 2);
        this.mCallback26 = new a(this, 1);
        invalidateAll();
    }

    @Override // com.bxkj.student.databinding.AcV3RecordDetailBinding
    public void setMActivity(@Nullable V3RecordDetailActivity MActivity) {
        this.mMActivity = MActivity;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(17);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (17 != variableId) {
            return false;
        }
        setMActivity((V3RecordDetailActivity) variable);
        return true;
    }
}
