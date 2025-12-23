package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.base.R;
import com.bxkj.base.databinding.NewPubTitleBinding;
import com.bxkj.student.generated.callback.a;
import com.bxkj.student.v2.ui.sports.set.SportsDescriptionActivity;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class AcV2SportsDescriptionBindingImpl extends AcV2SportsDescriptionBinding implements a.InterfaceC0207a {

    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes;

    @Nullable
    private static final SparseIntArray sViewsWithIds;

    @Nullable
    private final View.OnClickListener mCallback37;
    private long mDirtyFlags;

    @NonNull
    private final ConstraintLayout mboundView0;

    public AcV2SportsDescriptionBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j6;
        synchronized (this) {
            j6 = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        Boolean bool = this.mStartButtonEnable;
        Boolean bool2 = this.mShowBottom;
        SportsDescriptionActivity sportsDescriptionActivity = this.mMActivity;
        int i6 = 0;
        boolean safeUnbox = (j6 & 18) != 0 ? ViewDataBinding.safeUnbox(bool) : false;
        long j7 = j6 & 20;
        if (j7 != 0) {
            boolean safeUnbox2 = ViewDataBinding.safeUnbox(bool2);
            if (j7 != 0) {
                j6 |= safeUnbox2 ? 64L : 32L;
            }
            if (!safeUnbox2) {
                i6 = 8;
            }
        }
        long j8 = 24 & j6;
        if ((20 & j6) != 0) {
            this.btStart.setVisibility(i6);
            this.cbIgnore.setVisibility(i6);
        }
        if ((16 & j6) != 0) {
            this.btStart.setOnClickListener(this.mCallback37);
            this.titleLayout.setTitle("锻炼说明");
        }
        if ((j6 & 18) != 0) {
            this.btStart.setEnabled(safeUnbox);
        }
        if (j8 != 0) {
            this.titleLayout.setActivity(sportsDescriptionActivity);
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
            this.mDirtyFlags = 16L;
        }
        this.titleLayout.invalidateAll();
        requestRebind();
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(5);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"new_pub_title"}, new int[]{3}, new int[]{R.layout.new_pub_title});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131298609, 4);
    }

    private AcV2SportsDescriptionBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (Button) bindings[2], (CheckBox) bindings[1], (SmartWebView) bindings[4], (NewPubTitleBinding) bindings[3]);
        this.mDirtyFlags = -1L;
        this.btStart.setTag(null);
        this.cbIgnore.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setContainedBinding(this.titleLayout);
        setRootTag(root);
        this.mCallback37 = new a(this, 1);
        invalidateAll();
    }

    private boolean onChangeTitleLayout(NewPubTitleBinding TitleLayout, int fieldId) {
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
        SportsDescriptionActivity sportsDescriptionActivity = this.mMActivity;
        if (sportsDescriptionActivity != null) {
            sportsDescriptionActivity.M();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId != 0) {
            return false;
        }
        return onChangeTitleLayout((NewPubTitleBinding) object, fieldId);
    }

    @Override // com.bxkj.student.databinding.AcV2SportsDescriptionBinding
    public void setMActivity(@Nullable SportsDescriptionActivity MActivity) {
        this.mMActivity = MActivity;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(17);
        super.requestRebind();
    }

    @Override // com.bxkj.student.databinding.AcV2SportsDescriptionBinding
    public void setShowBottom(@Nullable Boolean ShowBottom) {
        this.mShowBottom = ShowBottom;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(24);
        super.requestRebind();
    }

    @Override // com.bxkj.student.databinding.AcV2SportsDescriptionBinding
    public void setStartButtonEnable(@Nullable Boolean StartButtonEnable) {
        this.mStartButtonEnable = StartButtonEnable;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(27);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (27 == variableId) {
            setStartButtonEnable((Boolean) variable);
            return true;
        }
        if (24 == variableId) {
            setShowBottom((Boolean) variable);
            return true;
        }
        if (17 != variableId) {
            return false;
        }
        setMActivity((SportsDescriptionActivity) variable);
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.titleLayout.setLifecycleOwner(lifecycleOwner);
    }
}
