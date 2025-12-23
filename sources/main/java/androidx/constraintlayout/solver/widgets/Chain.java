package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
class Chain {
    private static final boolean DEBUG = false;

    static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i6) {
        int i7;
        ChainHead[] chainHeadArr;
        int i8;
        if (i6 == 0) {
            i7 = constraintWidgetContainer.mHorizontalChainsSize;
            chainHeadArr = constraintWidgetContainer.mHorizontalChainsArray;
            i8 = 0;
        } else {
            i7 = constraintWidgetContainer.mVerticalChainsSize;
            chainHeadArr = constraintWidgetContainer.mVerticalChainsArray;
            i8 = 2;
        }
        for (int i9 = 0; i9 < i7; i9++) {
            ChainHead chainHead = chainHeadArr[i9];
            chainHead.define();
            applyChainConstraints(constraintWidgetContainer, linearSystem, i6, i8, chainHead);
        }
    }

    Chain() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002d, code lost:
    
        if (r8 == 2) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002f, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:302:0x0031, code lost:
    
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:310:0x0041, code lost:
    
        if (r8 == 2) goto L16;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:117:0x024b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x04a3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x04b9  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x04c2  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x04c9  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x04d9  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x04dd A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:157:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x04c5  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x04bc  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x02a1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0387 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:231:0x038f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:239:0x03a2  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x046b  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01bf  */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v2, types: [androidx.constraintlayout.solver.widgets.ConstraintWidget] */
    /* JADX WARN: Type inference failed for: r13v41 */
    /* JADX WARN: Type inference failed for: r13v42 */
    /* JADX WARN: Type inference failed for: r13v43 */
    /* JADX WARN: Type inference failed for: r4v45, types: [androidx.constraintlayout.solver.widgets.ConstraintWidget] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void applyChainConstraints(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r36, androidx.constraintlayout.solver.LinearSystem r37, int r38, int r39, androidx.constraintlayout.solver.widgets.ChainHead r40) {
        /*
            Method dump skipped, instructions count: 1278
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.Chain.applyChainConstraints(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer, androidx.constraintlayout.solver.LinearSystem, int, int, androidx.constraintlayout.solver.widgets.ChainHead):void");
    }
}
