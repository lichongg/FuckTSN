package androidx.constraintlayout.solver.widgets;

import java.util.Arrays;
import java.util.HashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class HelperWidget extends ConstraintWidget implements Helper {
    public ConstraintWidget[] mWidgets = new ConstraintWidget[4];
    public int mWidgetsCount = 0;

    @Override // androidx.constraintlayout.solver.widgets.Helper
    public void removeAllIds() {
        this.mWidgetsCount = 0;
        Arrays.fill(this.mWidgets, (Object) null);
    }

    @Override // androidx.constraintlayout.solver.widgets.Helper
    public void add(ConstraintWidget constraintWidget) {
        if (constraintWidget == this || constraintWidget == null) {
            return;
        }
        int i6 = this.mWidgetsCount + 1;
        ConstraintWidget[] constraintWidgetArr = this.mWidgets;
        if (i6 > constraintWidgetArr.length) {
            this.mWidgets = (ConstraintWidget[]) Arrays.copyOf(constraintWidgetArr, constraintWidgetArr.length * 2);
        }
        ConstraintWidget[] constraintWidgetArr2 = this.mWidgets;
        int i7 = this.mWidgetsCount;
        constraintWidgetArr2[i7] = constraintWidget;
        this.mWidgetsCount = i7 + 1;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.copy(constraintWidget, hashMap);
        HelperWidget helperWidget = (HelperWidget) constraintWidget;
        this.mWidgetsCount = 0;
        int i6 = helperWidget.mWidgetsCount;
        for (int i7 = 0; i7 < i6; i7++) {
            add(hashMap.get(helperWidget.mWidgets[i7]));
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.Helper
    public void updateConstraints(ConstraintWidgetContainer constraintWidgetContainer) {
    }
}
