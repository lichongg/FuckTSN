package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyGraph;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class ConstraintWidgetContainer extends WidgetContainer {
    private static final boolean DEBUG = false;
    static final boolean DEBUG_GRAPH = false;
    private static final boolean DEBUG_LAYOUT = false;
    private static final int MAX_ITERATIONS = 8;
    BasicMeasure mBasicMeasureSolver;
    int mDebugSolverPassCount;
    public DependencyGraph mDependencyGraph;
    public boolean mGroupsWrapOptimized;
    private boolean mHeightMeasuredTooSmall;
    ChainHead[] mHorizontalChainsArray;
    int mHorizontalChainsSize;
    public boolean mHorizontalWrapOptimized;
    private boolean mIsRtl;
    protected BasicMeasure.Measurer mMeasurer;
    public Metrics mMetrics;
    private int mOptimizationLevel;
    int mPaddingBottom;
    int mPaddingLeft;
    int mPaddingRight;
    int mPaddingTop;
    public boolean mSkipSolver;
    protected LinearSystem mSystem;
    ChainHead[] mVerticalChainsArray;
    int mVerticalChainsSize;
    public boolean mVerticalWrapOptimized;
    private boolean mWidthMeasuredTooSmall;
    public int mWrapFixedHeight;
    public int mWrapFixedWidth;

    public ConstraintWidgetContainer() {
        this.mBasicMeasureSolver = new BasicMeasure(this);
        this.mDependencyGraph = new DependencyGraph(this);
        this.mMeasurer = null;
        this.mIsRtl = false;
        this.mSystem = new LinearSystem();
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.mVerticalChainsArray = new ChainHead[4];
        this.mHorizontalChainsArray = new ChainHead[4];
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.mOptimizationLevel = 263;
        this.mSkipSolver = false;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        this.mDebugSolverPassCount = 0;
    }

    private void resetChains() {
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
    }

    public boolean handlesInternalConstraints() {
        return false;
    }

    public void updateChildrenFromSolver(LinearSystem linearSystem, boolean[] zArr) {
        zArr[2] = false;
        updateFromSolver(linearSystem);
        int size = this.mChildren.size();
        for (int i6 = 0; i6 < size; i6++) {
            this.mChildren.get(i6).updateFromSolver(linearSystem);
        }
    }

    private void addHorizontalChain(ConstraintWidget constraintWidget) {
        int i6 = this.mHorizontalChainsSize + 1;
        ChainHead[] chainHeadArr = this.mHorizontalChainsArray;
        if (i6 >= chainHeadArr.length) {
            this.mHorizontalChainsArray = (ChainHead[]) Arrays.copyOf(chainHeadArr, chainHeadArr.length * 2);
        }
        this.mHorizontalChainsArray[this.mHorizontalChainsSize] = new ChainHead(constraintWidget, 0, isRtl());
        this.mHorizontalChainsSize++;
    }

    private void addVerticalChain(ConstraintWidget constraintWidget) {
        int i6 = this.mVerticalChainsSize + 1;
        ChainHead[] chainHeadArr = this.mVerticalChainsArray;
        if (i6 >= chainHeadArr.length) {
            this.mVerticalChainsArray = (ChainHead[]) Arrays.copyOf(chainHeadArr, chainHeadArr.length * 2);
        }
        this.mVerticalChainsArray[this.mVerticalChainsSize] = new ChainHead(constraintWidget, 1, isRtl());
        this.mVerticalChainsSize++;
    }

    void addChain(ConstraintWidget constraintWidget, int i6) {
        if (i6 == 0) {
            addHorizontalChain(constraintWidget);
        } else if (i6 == 1) {
            addVerticalChain(constraintWidget);
        }
    }

    public void defineTerminalWidgets() {
        this.mDependencyGraph.defineTerminalWidgets(getHorizontalDimensionBehaviour(), getVerticalDimensionBehaviour());
    }

    public boolean directMeasure(boolean z5) {
        return this.mDependencyGraph.directMeasure(z5);
    }

    public boolean directMeasureSetup(boolean z5) {
        return this.mDependencyGraph.directMeasureSetup(z5);
    }

    public boolean directMeasureWithOrientation(boolean z5, int i6) {
        return this.mDependencyGraph.directMeasureWithOrientation(z5, i6);
    }

    public void fillMetrics(Metrics metrics) {
        this.mMetrics = metrics;
        this.mSystem.fillMetrics(metrics);
    }

    public ArrayList<Guideline> getHorizontalGuidelines() {
        ArrayList<Guideline> arrayList = new ArrayList<>();
        int size = this.mChildren.size();
        for (int i6 = 0; i6 < size; i6++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i6);
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                if (guideline.getOrientation() == 0) {
                    arrayList.add(guideline);
                }
            }
        }
        return arrayList;
    }

    public BasicMeasure.Measurer getMeasurer() {
        return this.mMeasurer;
    }

    public int getOptimizationLevel() {
        return this.mOptimizationLevel;
    }

    public LinearSystem getSystem() {
        return this.mSystem;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public String getType() {
        return "ConstraintLayout";
    }

    public ArrayList<Guideline> getVerticalGuidelines() {
        ArrayList<Guideline> arrayList = new ArrayList<>();
        int size = this.mChildren.size();
        for (int i6 = 0; i6 < size; i6++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i6);
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                if (guideline.getOrientation() == 1) {
                    arrayList.add(guideline);
                }
            }
        }
        return arrayList;
    }

    public void invalidateGraph() {
        this.mDependencyGraph.invalidateGraph();
    }

    public void invalidateMeasures() {
        this.mDependencyGraph.invalidateMeasures();
    }

    public boolean isHeightMeasuredTooSmall() {
        return this.mHeightMeasuredTooSmall;
    }

    public boolean isRtl() {
        return this.mIsRtl;
    }

    public boolean isWidthMeasuredTooSmall() {
        return this.mWidthMeasuredTooSmall;
    }

    @Override // androidx.constraintlayout.solver.widgets.WidgetContainer
    public void layout() {
        char c6;
        boolean z5;
        this.mX = 0;
        this.mY = 0;
        int max = Math.max(0, getWidth());
        int max2 = Math.max(0, getHeight());
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        boolean z6 = optimizeFor(64) || optimizeFor(128);
        LinearSystem linearSystem = this.mSystem;
        linearSystem.graphOptimizer = false;
        linearSystem.newgraphOptimizer = false;
        if (this.mOptimizationLevel != 0 && z6) {
            linearSystem.newgraphOptimizer = true;
        }
        ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[1];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[0];
        ArrayList<ConstraintWidget> arrayList = this.mChildren;
        ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        boolean z7 = horizontalDimensionBehaviour == dimensionBehaviour3 || getVerticalDimensionBehaviour() == dimensionBehaviour3;
        resetChains();
        int size = this.mChildren.size();
        for (int i6 = 0; i6 < size; i6++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i6);
            if (constraintWidget instanceof WidgetContainer) {
                ((WidgetContainer) constraintWidget).layout();
            }
        }
        int i7 = 0;
        boolean z8 = true;
        boolean z9 = false;
        while (z8) {
            int i8 = i7 + 1;
            try {
                this.mSystem.reset();
                resetChains();
                createObjectVariables(this.mSystem);
                for (int i9 = 0; i9 < size; i9++) {
                    this.mChildren.get(i9).createObjectVariables(this.mSystem);
                }
                z8 = addChildrenToSolver(this.mSystem);
                if (z8) {
                    this.mSystem.minimize();
                }
            } catch (Exception e6) {
                e6.printStackTrace();
                PrintStream printStream = System.out;
                e6.toString();
                printStream.getClass();
            }
            if (z8) {
                updateChildrenFromSolver(this.mSystem, Optimizer.flags);
            } else {
                updateFromSolver(this.mSystem);
                for (int i10 = 0; i10 < size; i10++) {
                    this.mChildren.get(i10).updateFromSolver(this.mSystem);
                }
            }
            if (z7 && i8 < 8 && Optimizer.flags[2]) {
                int i11 = 0;
                int i12 = 0;
                for (int i13 = 0; i13 < size; i13++) {
                    ConstraintWidget constraintWidget2 = this.mChildren.get(i13);
                    i11 = Math.max(i11, constraintWidget2.mX + constraintWidget2.getWidth());
                    i12 = Math.max(i12, constraintWidget2.mY + constraintWidget2.getHeight());
                }
                c6 = 0;
                int max3 = Math.max(this.mMinWidth, i11);
                int max4 = Math.max(this.mMinHeight, i12);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (dimensionBehaviour2 != dimensionBehaviour4 || getWidth() >= max3) {
                    z5 = false;
                } else {
                    setWidth(max3);
                    this.mListDimensionBehaviors[0] = dimensionBehaviour4;
                    z5 = true;
                    z9 = true;
                }
                if (dimensionBehaviour == dimensionBehaviour4 && getHeight() < max4) {
                    setHeight(max4);
                    this.mListDimensionBehaviors[1] = dimensionBehaviour4;
                    z5 = true;
                    z9 = true;
                }
            } else {
                c6 = 0;
                z5 = false;
            }
            int max5 = Math.max(this.mMinWidth, getWidth());
            if (max5 > getWidth()) {
                setWidth(max5);
                this.mListDimensionBehaviors[c6] = ConstraintWidget.DimensionBehaviour.FIXED;
                z5 = true;
                z9 = true;
            }
            int max6 = Math.max(this.mMinHeight, getHeight());
            if (max6 > getHeight()) {
                setHeight(max6);
                this.mListDimensionBehaviors[1] = ConstraintWidget.DimensionBehaviour.FIXED;
                z5 = true;
                z9 = true;
            }
            if (!z9) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = this.mListDimensionBehaviors[c6];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (dimensionBehaviour5 == dimensionBehaviour6 && max > 0 && getWidth() > max) {
                    this.mWidthMeasuredTooSmall = true;
                    this.mListDimensionBehaviors[c6] = ConstraintWidget.DimensionBehaviour.FIXED;
                    setWidth(max);
                    z5 = true;
                    z9 = true;
                }
                if (this.mListDimensionBehaviors[1] == dimensionBehaviour6 && max2 > 0 && getHeight() > max2) {
                    this.mHeightMeasuredTooSmall = true;
                    this.mListDimensionBehaviors[1] = ConstraintWidget.DimensionBehaviour.FIXED;
                    setHeight(max2);
                    z8 = true;
                    z9 = true;
                    i7 = i8;
                }
            }
            z8 = z5;
            i7 = i8;
        }
        this.mChildren = arrayList;
        if (z9) {
            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr2 = this.mListDimensionBehaviors;
            dimensionBehaviourArr2[0] = dimensionBehaviour2;
            dimensionBehaviourArr2[1] = dimensionBehaviour;
        }
        resetSolverVariables(this.mSystem.getCache());
    }

    public long measure(int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
        this.mPaddingLeft = i13;
        this.mPaddingTop = i14;
        return this.mBasicMeasureSolver.solverMeasure(this, i6, i13, i14, i7, i8, i9, i10, i11, i12);
    }

    public boolean optimizeFor(int i6) {
        return (this.mOptimizationLevel & i6) == i6;
    }

    @Override // androidx.constraintlayout.solver.widgets.WidgetContainer, androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void reset() {
        this.mSystem.reset();
        this.mPaddingLeft = 0;
        this.mPaddingRight = 0;
        this.mPaddingTop = 0;
        this.mPaddingBottom = 0;
        this.mSkipSolver = false;
        super.reset();
    }

    public void setMeasurer(BasicMeasure.Measurer measurer) {
        this.mMeasurer = measurer;
        this.mDependencyGraph.setMeasurer(measurer);
    }

    public void setOptimizationLevel(int i6) {
        this.mOptimizationLevel = i6;
        LinearSystem.OPTIMIZED_ENGINE = Optimizer.enabled(i6, 256);
    }

    public void setPadding(int i6, int i7, int i8, int i9) {
        this.mPaddingLeft = i6;
        this.mPaddingTop = i7;
        this.mPaddingRight = i8;
        this.mPaddingBottom = i9;
    }

    public void setRtl(boolean z5) {
        this.mIsRtl = z5;
    }

    public void updateHierarchy() {
        this.mBasicMeasureSolver.updateHierarchy(this);
    }

    public boolean addChildrenToSolver(LinearSystem linearSystem) {
        addToSolver(linearSystem);
        int size = this.mChildren.size();
        boolean z5 = false;
        for (int i6 = 0; i6 < size; i6++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i6);
            constraintWidget.setInBarrier(0, false);
            constraintWidget.setInBarrier(1, false);
            if (constraintWidget instanceof Barrier) {
                z5 = true;
            }
        }
        if (z5) {
            for (int i7 = 0; i7 < size; i7++) {
                ConstraintWidget constraintWidget2 = this.mChildren.get(i7);
                if (constraintWidget2 instanceof Barrier) {
                    ((Barrier) constraintWidget2).markWidgets();
                }
            }
        }
        for (int i8 = 0; i8 < size; i8++) {
            ConstraintWidget constraintWidget3 = this.mChildren.get(i8);
            if (constraintWidget3.addFirst()) {
                constraintWidget3.addToSolver(linearSystem);
            }
        }
        for (int i9 = 0; i9 < size; i9++) {
            ConstraintWidget constraintWidget4 = this.mChildren.get(i9);
            if (constraintWidget4 instanceof ConstraintWidgetContainer) {
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget4.mListDimensionBehaviors;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (dimensionBehaviour == dimensionBehaviour3) {
                    constraintWidget4.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                }
                if (dimensionBehaviour2 == dimensionBehaviour3) {
                    constraintWidget4.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                }
                constraintWidget4.addToSolver(linearSystem);
                if (dimensionBehaviour == dimensionBehaviour3) {
                    constraintWidget4.setHorizontalDimensionBehaviour(dimensionBehaviour);
                }
                if (dimensionBehaviour2 == dimensionBehaviour3) {
                    constraintWidget4.setVerticalDimensionBehaviour(dimensionBehaviour2);
                }
            } else {
                Optimizer.checkMatchParent(this, linearSystem, constraintWidget4);
                if (!constraintWidget4.addFirst()) {
                    constraintWidget4.addToSolver(linearSystem);
                }
            }
        }
        if (this.mHorizontalChainsSize > 0) {
            Chain.applyChainConstraints(this, linearSystem, 0);
        }
        if (this.mVerticalChainsSize > 0) {
            Chain.applyChainConstraints(this, linearSystem, 1);
        }
        return true;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void updateFromRuns(boolean z5, boolean z6) {
        super.updateFromRuns(z5, z6);
        int size = this.mChildren.size();
        for (int i6 = 0; i6 < size; i6++) {
            this.mChildren.get(i6).updateFromRuns(z5, z6);
        }
    }

    public ConstraintWidgetContainer(int i6, int i7, int i8, int i9) {
        super(i6, i7, i8, i9);
        this.mBasicMeasureSolver = new BasicMeasure(this);
        this.mDependencyGraph = new DependencyGraph(this);
        this.mMeasurer = null;
        this.mIsRtl = false;
        this.mSystem = new LinearSystem();
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.mVerticalChainsArray = new ChainHead[4];
        this.mHorizontalChainsArray = new ChainHead[4];
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.mOptimizationLevel = 263;
        this.mSkipSolver = false;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        this.mDebugSolverPassCount = 0;
    }

    public ConstraintWidgetContainer(int i6, int i7) {
        super(i6, i7);
        this.mBasicMeasureSolver = new BasicMeasure(this);
        this.mDependencyGraph = new DependencyGraph(this);
        this.mMeasurer = null;
        this.mIsRtl = false;
        this.mSystem = new LinearSystem();
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.mVerticalChainsArray = new ChainHead[4];
        this.mHorizontalChainsArray = new ChainHead[4];
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.mOptimizationLevel = 263;
        this.mSkipSolver = false;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        this.mDebugSolverPassCount = 0;
    }
}
