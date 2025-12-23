package com.google.android.material.button;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ToggleButton;
import androidx.annotation.BoolRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class MaterialButtonToggleGroup extends LinearLayout {
    private static final int DEF_STYLE_RES = R.style.Widget_MaterialComponents_MaterialButtonToggleGroup;
    private static final String LOG_TAG = "MButtonToggleGroup";
    private Set<Integer> checkedIds;
    private Integer[] childOrder;
    private final Comparator<MaterialButton> childOrderComparator;

    @IdRes
    private final int defaultCheckId;
    private final LinkedHashSet<OnButtonCheckedListener> onButtonCheckedListeners;
    private final List<CornerData> originalCornerData;
    private final PressedStateTracker pressedStateTracker;
    private boolean selectionRequired;
    private boolean singleSelection;
    private boolean skipCheckedStateTracker;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class CornerData {
        private static final CornerSize noCorner = new AbsoluteCornerSize(0.0f);
        CornerSize bottomLeft;
        CornerSize bottomRight;
        CornerSize topLeft;
        CornerSize topRight;

        public static CornerData bottom(CornerData cornerData) {
            CornerSize cornerSize = noCorner;
            return new CornerData(cornerSize, cornerData.bottomLeft, cornerSize, cornerData.bottomRight);
        }

        public static CornerData left(CornerData cornerData) {
            CornerSize cornerSize = cornerData.topLeft;
            CornerSize cornerSize2 = cornerData.bottomLeft;
            CornerSize cornerSize3 = noCorner;
            return new CornerData(cornerSize, cornerSize2, cornerSize3, cornerSize3);
        }

        public static CornerData right(CornerData cornerData) {
            CornerSize cornerSize = noCorner;
            return new CornerData(cornerSize, cornerSize, cornerData.topRight, cornerData.bottomRight);
        }

        public static CornerData top(CornerData cornerData) {
            CornerSize cornerSize = cornerData.topLeft;
            CornerSize cornerSize2 = noCorner;
            return new CornerData(cornerSize, cornerSize2, cornerData.topRight, cornerSize2);
        }

        CornerData(CornerSize cornerSize, CornerSize cornerSize2, CornerSize cornerSize3, CornerSize cornerSize4) {
            this.topLeft = cornerSize;
            this.topRight = cornerSize3;
            this.bottomRight = cornerSize4;
            this.bottomLeft = cornerSize2;
        }

        public static CornerData end(CornerData cornerData, View view) {
            if (ViewUtils.isLayoutRtl(view)) {
                return left(cornerData);
            }
            return right(cornerData);
        }

        public static CornerData start(CornerData cornerData, View view) {
            if (ViewUtils.isLayoutRtl(view)) {
                return right(cornerData);
            }
            return left(cornerData);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface OnButtonCheckedListener {
        void onButtonChecked(MaterialButtonToggleGroup materialButtonToggleGroup, @IdRes int i6, boolean z5);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class PressedStateTracker implements MaterialButton.OnPressedChangeListener {
        private PressedStateTracker() {
        }

        @Override // com.google.android.material.button.MaterialButton.OnPressedChangeListener
        public void onPressedChanged(@NonNull MaterialButton materialButton, boolean z5) {
            MaterialButtonToggleGroup.this.invalidate();
        }
    }

    public MaterialButtonToggleGroup(@NonNull Context context) {
        this(context, null);
    }

    private void checkInternal(@IdRes int i6, boolean z5) {
        if (i6 == -1) {
            return;
        }
        HashSet hashSet = new HashSet(this.checkedIds);
        if (z5 && !hashSet.contains(Integer.valueOf(i6))) {
            if (this.singleSelection && !hashSet.isEmpty()) {
                hashSet.clear();
            }
            hashSet.add(Integer.valueOf(i6));
        } else {
            if (z5 || !hashSet.contains(Integer.valueOf(i6))) {
                return;
            }
            if (!this.selectionRequired || hashSet.size() > 1) {
                hashSet.remove(Integer.valueOf(i6));
            }
        }
        updateCheckedIds(hashSet);
    }

    private int getVisibleButtonCount() {
        int i6 = 0;
        for (int i7 = 0; i7 < getChildCount(); i7++) {
            if ((getChildAt(i7) instanceof MaterialButton) && isChildVisible(i7)) {
                i6++;
            }
        }
        return i6;
    }

    private void setupButtonChild(@NonNull MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.setOnPressedChangeListenerInternal(this.pressedStateTracker);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    private void updateChildrenA11yClassName() {
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            getChildButton(i6).setA11yClassName((this.singleSelection ? RadioButton.class : ToggleButton.class).getName());
        }
    }

    public void check(@IdRes int i6) {
        checkInternal(i6, true);
    }

    public void setSingleSelection(boolean z5) {
        if (this.singleSelection != z5) {
            this.singleSelection = z5;
            clearChecked();
        }
        updateChildrenA11yClassName();
    }

    public void uncheck(@IdRes int i6) {
        checkInternal(i6, false);
    }

    public MaterialButtonToggleGroup(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialButtonToggleGroupStyle);
    }

    private void dispatchOnButtonChecked(@IdRes int i6, boolean z5) {
        Iterator<OnButtonCheckedListener> it = this.onButtonCheckedListeners.iterator();
        while (it.hasNext()) {
            it.next().onButtonChecked(this, i6, z5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getIndexWithinVisibleButtons(@Nullable View view) {
        if (!(view instanceof MaterialButton)) {
            return -1;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < getChildCount(); i7++) {
            if (getChildAt(i7) == view) {
                return i6;
            }
            if ((getChildAt(i7) instanceof MaterialButton) && isChildVisible(i7)) {
                i6++;
            }
        }
        return -1;
    }

    @Nullable
    private CornerData getNewCornerData(int i6, int i7, int i8) {
        CornerData cornerData = this.originalCornerData.get(i6);
        if (i7 == i8) {
            return cornerData;
        }
        boolean z5 = getOrientation() == 0;
        if (i6 == i7) {
            return z5 ? CornerData.start(cornerData, this) : CornerData.top(cornerData);
        }
        if (i6 == i8) {
            return z5 ? CornerData.end(cornerData, this) : CornerData.bottom(cornerData);
        }
        return null;
    }

    private static void updateBuilderWithCornerData(ShapeAppearanceModel.Builder builder, @Nullable CornerData cornerData) {
        if (cornerData == null) {
            builder.setAllCornerSizes(0.0f);
        } else {
            builder.setTopLeftCornerSize(cornerData.topLeft).setBottomLeftCornerSize(cornerData.bottomLeft).setTopRightCornerSize(cornerData.topRight).setBottomRightCornerSize(cornerData.bottomRight);
        }
    }

    private void updateCheckedIds(Set<Integer> set) {
        Set<Integer> set2 = this.checkedIds;
        this.checkedIds = new HashSet(set);
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            int id = getChildButton(i6).getId();
            setCheckedStateForView(id, set.contains(Integer.valueOf(id)));
            if (set2.contains(Integer.valueOf(id)) != set.contains(Integer.valueOf(id))) {
                dispatchOnButtonChecked(id, set.contains(Integer.valueOf(id)));
            }
        }
        invalidate();
    }

    private void updateChildOrder() {
        TreeMap treeMap = new TreeMap(this.childOrderComparator);
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            treeMap.put(getChildButton(i6), Integer.valueOf(i6));
        }
        this.childOrder = (Integer[]) treeMap.values().toArray(new Integer[0]);
    }

    public void addOnButtonCheckedListener(@NonNull OnButtonCheckedListener onButtonCheckedListener) {
        this.onButtonCheckedListeners.add(onButtonCheckedListener);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i6, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof MaterialButton) {
            super.addView(view, i6, layoutParams);
            MaterialButton materialButton = (MaterialButton) view;
            setGeneratedIdIfNeeded(materialButton);
            setupButtonChild(materialButton);
            checkInternal(materialButton.getId(), materialButton.isChecked());
            ShapeAppearanceModel shapeAppearanceModel = materialButton.getShapeAppearanceModel();
            this.originalCornerData.add(new CornerData(shapeAppearanceModel.getTopLeftCornerSize(), shapeAppearanceModel.getBottomLeftCornerSize(), shapeAppearanceModel.getTopRightCornerSize(), shapeAppearanceModel.getBottomRightCornerSize()));
            materialButton.setEnabled(isEnabled());
            ViewCompat.setAccessibilityDelegate(materialButton, new AccessibilityDelegateCompat() { // from class: com.google.android.material.button.MaterialButtonToggleGroup.2
                @Override // androidx.core.view.AccessibilityDelegateCompat
                public void onInitializeAccessibilityNodeInfo(View view2, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                    super.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfoCompat);
                    accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, MaterialButtonToggleGroup.this.getIndexWithinVisibleButtons(view2), 1, false, ((MaterialButton) view2).isChecked()));
                }
            });
        }
    }

    public void clearChecked() {
        updateCheckedIds(new HashSet());
    }

    public void clearOnButtonCheckedListeners() {
        this.onButtonCheckedListeners.clear();
    }

    @IdRes
    public int getCheckedButtonId() {
        if (!this.singleSelection || this.checkedIds.isEmpty()) {
            return -1;
        }
        return this.checkedIds.iterator().next().intValue();
    }

    @NonNull
    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            int id = getChildButton(i6).getId();
            if (this.checkedIds.contains(Integer.valueOf(id))) {
                arrayList.add(Integer.valueOf(id));
            }
        }
        return arrayList;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i6, int i7) {
        Integer[] numArr = this.childOrder;
        return (numArr == null || i7 >= numArr.length) ? i7 : numArr[i7].intValue();
    }

    public boolean isSelectionRequired() {
        return this.selectionRequired;
    }

    public boolean isSingleSelection() {
        return this.singleSelection;
    }

    void onButtonCheckedStateChanged(@NonNull MaterialButton materialButton, boolean z5) {
        if (this.skipCheckedStateTracker) {
            return;
        }
        checkInternal(materialButton.getId(), z5);
    }

    public void removeOnButtonCheckedListener(@NonNull OnButtonCheckedListener onButtonCheckedListener) {
        this.onButtonCheckedListeners.remove(onButtonCheckedListener);
    }

    public void setSelectionRequired(boolean z5) {
        this.selectionRequired = z5;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public MaterialButtonToggleGroup(@androidx.annotation.NonNull android.content.Context r7, @androidx.annotation.Nullable android.util.AttributeSet r8, int r9) {
        /*
            r6 = this;
            int r4 = com.google.android.material.button.MaterialButtonToggleGroup.DEF_STYLE_RES
            android.content.Context r7 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r7, r8, r9, r4)
            r6.<init>(r7, r8, r9)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r6.originalCornerData = r7
            com.google.android.material.button.MaterialButtonToggleGroup$PressedStateTracker r7 = new com.google.android.material.button.MaterialButtonToggleGroup$PressedStateTracker
            r0 = 0
            r7.<init>()
            r6.pressedStateTracker = r7
            java.util.LinkedHashSet r7 = new java.util.LinkedHashSet
            r7.<init>()
            r6.onButtonCheckedListeners = r7
            com.google.android.material.button.MaterialButtonToggleGroup$1 r7 = new com.google.android.material.button.MaterialButtonToggleGroup$1
            r7.<init>()
            r6.childOrderComparator = r7
            r7 = 0
            r6.skipCheckedStateTracker = r7
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r6.checkedIds = r0
            android.content.Context r0 = r6.getContext()
            int[] r2 = com.google.android.material.R.styleable.MaterialButtonToggleGroup
            int[] r5 = new int[r7]
            r1 = r8
            r3 = r9
            android.content.res.TypedArray r8 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r0, r1, r2, r3, r4, r5)
            int r9 = com.google.android.material.R.styleable.MaterialButtonToggleGroup_singleSelection
            boolean r9 = r8.getBoolean(r9, r7)
            r6.setSingleSelection(r9)
            int r9 = com.google.android.material.R.styleable.MaterialButtonToggleGroup_checkedButton
            r0 = -1
            int r9 = r8.getResourceId(r9, r0)
            r6.defaultCheckId = r9
            int r9 = com.google.android.material.R.styleable.MaterialButtonToggleGroup_selectionRequired
            boolean r7 = r8.getBoolean(r9, r7)
            r6.selectionRequired = r7
            r7 = 1
            r6.setChildrenDrawingOrderEnabled(r7)
            int r9 = com.google.android.material.R.styleable.MaterialButtonToggleGroup_android_enabled
            boolean r9 = r8.getBoolean(r9, r7)
            r6.setEnabled(r9)
            r8.recycle()
            androidx.core.view.ViewCompat.setImportantForAccessibility(r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.button.MaterialButtonToggleGroup.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    private void adjustChildMarginsAndUpdateLayout() {
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
            return;
        }
        for (int i6 = firstVisibleChildIndex + 1; i6 < getChildCount(); i6++) {
            MaterialButton childButton = getChildButton(i6);
            int min = Math.min(childButton.getStrokeWidth(), getChildButton(i6 - 1).getStrokeWidth());
            LinearLayout.LayoutParams buildLayoutParams = buildLayoutParams(childButton);
            if (getOrientation() == 0) {
                MarginLayoutParamsCompat.setMarginEnd(buildLayoutParams, 0);
                MarginLayoutParamsCompat.setMarginStart(buildLayoutParams, -min);
                buildLayoutParams.topMargin = 0;
            } else {
                buildLayoutParams.bottomMargin = 0;
                buildLayoutParams.topMargin = -min;
                MarginLayoutParamsCompat.setMarginStart(buildLayoutParams, 0);
            }
            childButton.setLayoutParams(buildLayoutParams);
        }
        resetChildMargins(firstVisibleChildIndex);
    }

    @NonNull
    private LinearLayout.LayoutParams buildLayoutParams(@NonNull View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return (LinearLayout.LayoutParams) layoutParams;
        }
        return new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
    }

    private MaterialButton getChildButton(int i6) {
        return (MaterialButton) getChildAt(i6);
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            if (isChildVisible(i6)) {
                return i6;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (isChildVisible(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private boolean isChildVisible(int i6) {
        if (getChildAt(i6).getVisibility() != 8) {
            return true;
        }
        return false;
    }

    private void resetChildMargins(int i6) {
        if (getChildCount() != 0 && i6 != -1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildButton(i6).getLayoutParams();
            if (getOrientation() == 1) {
                layoutParams.topMargin = 0;
                layoutParams.bottomMargin = 0;
            } else {
                MarginLayoutParamsCompat.setMarginEnd(layoutParams, 0);
                MarginLayoutParamsCompat.setMarginStart(layoutParams, 0);
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
            }
        }
    }

    private void setCheckedStateForView(@IdRes int i6, boolean z5) {
        View findViewById = findViewById(i6);
        if (findViewById instanceof MaterialButton) {
            this.skipCheckedStateTracker = true;
            ((MaterialButton) findViewById).setChecked(z5);
            this.skipCheckedStateTracker = false;
        }
    }

    private void setGeneratedIdIfNeeded(@NonNull MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(ViewCompat.generateViewId());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@NonNull Canvas canvas) {
        updateChildOrder();
        super.dispatchDraw(canvas);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int i6 = this.defaultCheckId;
        if (i6 != -1) {
            updateCheckedIds(Collections.singleton(Integer.valueOf(i6)));
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        int i6;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat wrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
        int visibleButtonCount = getVisibleButtonCount();
        if (isSingleSelection()) {
            i6 = 1;
        } else {
            i6 = 2;
        }
        wrap.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, visibleButtonCount, false, i6));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i6, int i7) {
        updateChildShapes();
        adjustChildMarginsAndUpdateLayout();
        super.onMeasure(i6, i7);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            ((MaterialButton) view).setOnPressedChangeListenerInternal(null);
        }
        int indexOfChild = indexOfChild(view);
        if (indexOfChild >= 0) {
            this.originalCornerData.remove(indexOfChild);
        }
        updateChildShapes();
        adjustChildMarginsAndUpdateLayout();
    }

    @Override // android.view.View
    public void setEnabled(boolean z5) {
        super.setEnabled(z5);
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            getChildButton(i6).setEnabled(z5);
        }
    }

    @VisibleForTesting
    void updateChildShapes() {
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i6 = 0; i6 < childCount; i6++) {
            MaterialButton childButton = getChildButton(i6);
            if (childButton.getVisibility() != 8) {
                ShapeAppearanceModel.Builder builder = childButton.getShapeAppearanceModel().toBuilder();
                updateBuilderWithCornerData(builder, getNewCornerData(i6, firstVisibleChildIndex, lastVisibleChildIndex));
                childButton.setShapeAppearanceModel(builder.build());
            }
        }
    }

    public void setSingleSelection(@BoolRes int i6) {
        setSingleSelection(getResources().getBoolean(i6));
    }
}
