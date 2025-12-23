package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.Optimizer;
import androidx.constraintlayout.solver.widgets.VirtualLayout;
import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class BasicMeasure {
    public static final int AT_MOST = Integer.MIN_VALUE;
    private static final boolean DEBUG = false;
    public static final int EXACTLY = 1073741824;
    public static final int FIXED = -3;
    public static final int MATCH_PARENT = -1;
    private static final int MODE_SHIFT = 30;
    public static final int UNSPECIFIED = 0;
    public static final int WRAP_CONTENT = -2;
    private ConstraintWidgetContainer constraintWidgetContainer;
    private final ArrayList<ConstraintWidget> mVariableDimensionsWidgets = new ArrayList<>();
    private Measure mMeasure = new Measure();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Measure {
        public ConstraintWidget.DimensionBehaviour horizontalBehavior;
        public int horizontalDimension;
        public int measuredBaseline;
        public boolean measuredHasBaseline;
        public int measuredHeight;
        public boolean measuredNeedsSolverPass;
        public int measuredWidth;
        public boolean useCurrentDimensions;
        public ConstraintWidget.DimensionBehaviour verticalBehavior;
        public int verticalDimension;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum MeasureType {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface Measurer {
        void didMeasures();

        void measure(ConstraintWidget constraintWidget, Measure measure);
    }

    public long solverMeasure(ConstraintWidgetContainer constraintWidgetContainer, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
        long j6;
        boolean z5;
        int i15;
        long j7;
        boolean z6;
        boolean z7;
        int i16;
        Measurer measurer;
        int i17;
        boolean z8;
        int i18;
        boolean z9;
        boolean z10;
        int i19;
        Metrics metrics;
        Measurer measurer2 = constraintWidgetContainer.getMeasurer();
        int size = constraintWidgetContainer.mChildren.size();
        int width = constraintWidgetContainer.getWidth();
        int height = constraintWidgetContainer.getHeight();
        boolean enabled = Optimizer.enabled(i6, 128);
        boolean z11 = enabled || Optimizer.enabled(i6, 64);
        if (z11) {
            for (int i20 = 0; i20 < size; i20++) {
                ConstraintWidget constraintWidget = constraintWidgetContainer.mChildren.get(i20);
                ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = constraintWidget.getHorizontalDimensionBehaviour();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                boolean z12 = (horizontalDimensionBehaviour == dimensionBehaviour) && (constraintWidget.getVerticalDimensionBehaviour() == dimensionBehaviour) && constraintWidget.getDimensionRatio() > 0.0f;
                if ((constraintWidget.isInHorizontalChain() && z12) || ((constraintWidget.isInVerticalChain() && z12) || (constraintWidget instanceof VirtualLayout) || constraintWidget.isInHorizontalChain() || constraintWidget.isInVerticalChain())) {
                    z11 = false;
                    break;
                }
            }
        }
        if (z11 && (metrics = LinearSystem.sMetrics) != null) {
            metrics.measures++;
        }
        if (z11 && ((i9 == 1073741824 && i11 == 1073741824) || enabled)) {
            int min = Math.min(constraintWidgetContainer.getMaxWidth(), i10);
            j6 = 1;
            int min2 = Math.min(constraintWidgetContainer.getMaxHeight(), i12);
            if (i9 == 1073741824 && constraintWidgetContainer.getWidth() != min) {
                constraintWidgetContainer.setWidth(min);
                constraintWidgetContainer.invalidateGraph();
            }
            if (i11 == 1073741824 && constraintWidgetContainer.getHeight() != min2) {
                constraintWidgetContainer.setHeight(min2);
                constraintWidgetContainer.invalidateGraph();
            }
            if (i9 == 1073741824 && i11 == 1073741824) {
                z5 = constraintWidgetContainer.directMeasure(enabled);
                i15 = 2;
            } else {
                boolean directMeasureSetup = constraintWidgetContainer.directMeasureSetup(enabled);
                if (i9 == 1073741824) {
                    z10 = directMeasureSetup & constraintWidgetContainer.directMeasureWithOrientation(enabled, 0);
                    i19 = 1;
                } else {
                    z10 = directMeasureSetup;
                    i19 = 0;
                }
                if (i11 == 1073741824) {
                    boolean directMeasureWithOrientation = constraintWidgetContainer.directMeasureWithOrientation(enabled, 1) & z10;
                    i15 = i19 + 1;
                    z5 = directMeasureWithOrientation;
                } else {
                    i15 = i19;
                    z5 = z10;
                }
            }
            if (z5) {
                constraintWidgetContainer.updateFromRuns(i9 == 1073741824, i11 == 1073741824);
            }
        } else {
            j6 = 1;
            z5 = false;
            i15 = 0;
        }
        long j8 = 0;
        if (z5 && i15 == 2) {
            return 0L;
        }
        if (size > 0) {
            measureChildren(constraintWidgetContainer);
        }
        int optimizationLevel = constraintWidgetContainer.getOptimizationLevel();
        int size2 = this.mVariableDimensionsWidgets.size();
        if (size > 0) {
            solveLinearSystem(constraintWidgetContainer, "First pass", width, height);
        }
        if (size2 > 0) {
            ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour2 = constraintWidgetContainer.getHorizontalDimensionBehaviour();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            boolean z13 = horizontalDimensionBehaviour2 == dimensionBehaviour2;
            boolean z14 = constraintWidgetContainer.getVerticalDimensionBehaviour() == dimensionBehaviour2;
            int max = Math.max(constraintWidgetContainer.getWidth(), this.constraintWidgetContainer.getMinWidth());
            int max2 = Math.max(constraintWidgetContainer.getHeight(), this.constraintWidgetContainer.getMinHeight());
            int i21 = 0;
            boolean z15 = false;
            while (i21 < size2) {
                long j9 = j8;
                ConstraintWidget constraintWidget2 = this.mVariableDimensionsWidgets.get(i21);
                if (constraintWidget2 instanceof VirtualLayout) {
                    int width2 = constraintWidget2.getWidth();
                    int height2 = constraintWidget2.getHeight();
                    boolean measure = z15 | measure(measurer2, constraintWidget2, true);
                    z8 = z14;
                    Metrics metrics2 = constraintWidgetContainer.mMetrics;
                    i18 = i21;
                    if (metrics2 != null) {
                        metrics2.measuredMatchWidgets += j6;
                    }
                    int width3 = constraintWidget2.getWidth();
                    int height3 = constraintWidget2.getHeight();
                    if (width3 != width2) {
                        constraintWidget2.setWidth(width3);
                        if (z13 && constraintWidget2.getRight() > max) {
                            max = Math.max(max, constraintWidget2.getRight() + constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin());
                        }
                        z9 = true;
                    } else {
                        z9 = measure;
                    }
                    if (height3 != height2) {
                        constraintWidget2.setHeight(height3);
                        if (z8 && constraintWidget2.getBottom() > max2) {
                            max2 = Math.max(max2, constraintWidget2.getBottom() + constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin());
                        }
                        z9 = true;
                    }
                    z15 = z9 | ((VirtualLayout) constraintWidget2).needSolverPass();
                } else {
                    z8 = z14;
                    i18 = i21;
                }
                i21 = i18 + 1;
                j8 = j9;
                z14 = z8;
            }
            j7 = j8;
            boolean z16 = z14;
            int i22 = 0;
            while (i22 < 2) {
                int i23 = 0;
                while (i23 < size2) {
                    ConstraintWidget constraintWidget3 = this.mVariableDimensionsWidgets.get(i23);
                    if (((constraintWidget3 instanceof Helper) && !(constraintWidget3 instanceof VirtualLayout)) || (constraintWidget3 instanceof Guideline) || constraintWidget3.getVisibility() == 8 || ((constraintWidget3.horizontalRun.dimension.resolved && constraintWidget3.verticalRun.dimension.resolved) || (constraintWidget3 instanceof VirtualLayout))) {
                        i16 = i22;
                        measurer = measurer2;
                        i17 = i23;
                    } else {
                        int width4 = constraintWidget3.getWidth();
                        int height4 = constraintWidget3.getHeight();
                        int baselineDistance = constraintWidget3.getBaselineDistance();
                        i16 = i22;
                        z15 |= measure(measurer2, constraintWidget3, true);
                        Metrics metrics3 = constraintWidgetContainer.mMetrics;
                        measurer = measurer2;
                        i17 = i23;
                        if (metrics3 != null) {
                            metrics3.measuredMatchWidgets += j6;
                        }
                        int width5 = constraintWidget3.getWidth();
                        int height5 = constraintWidget3.getHeight();
                        if (width5 != width4) {
                            constraintWidget3.setWidth(width5);
                            if (z13 && constraintWidget3.getRight() > max) {
                                max = Math.max(max, constraintWidget3.getRight() + constraintWidget3.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin());
                            }
                            z15 = true;
                        }
                        if (height5 != height4) {
                            constraintWidget3.setHeight(height5);
                            if (z16 && constraintWidget3.getBottom() > max2) {
                                max2 = Math.max(max2, constraintWidget3.getBottom() + constraintWidget3.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin());
                            }
                            z15 = true;
                        }
                        if (constraintWidget3.hasBaseline() && baselineDistance != constraintWidget3.getBaselineDistance()) {
                            z15 = true;
                        }
                    }
                    i23 = i17 + 1;
                    i22 = i16;
                    measurer2 = measurer;
                }
                int i24 = i22;
                Measurer measurer3 = measurer2;
                if (z15) {
                    solveLinearSystem(constraintWidgetContainer, "intermediate pass", width, height);
                    z15 = false;
                }
                i22 = i24 + 1;
                measurer2 = measurer3;
            }
            if (z15) {
                solveLinearSystem(constraintWidgetContainer, "2nd pass", width, height);
                if (constraintWidgetContainer.getWidth() < max) {
                    constraintWidgetContainer.setWidth(max);
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (constraintWidgetContainer.getHeight() < max2) {
                    constraintWidgetContainer.setHeight(max2);
                    z7 = true;
                } else {
                    z7 = z6;
                }
                if (z7) {
                    solveLinearSystem(constraintWidgetContainer, "3rd pass", width, height);
                }
            }
        } else {
            j7 = 0;
        }
        constraintWidgetContainer.setOptimizationLevel(optimizationLevel);
        return j7;
    }

    private boolean measure(Measurer measurer, ConstraintWidget constraintWidget, boolean z5) {
        this.mMeasure.horizontalBehavior = constraintWidget.getHorizontalDimensionBehaviour();
        this.mMeasure.verticalBehavior = constraintWidget.getVerticalDimensionBehaviour();
        this.mMeasure.horizontalDimension = constraintWidget.getWidth();
        this.mMeasure.verticalDimension = constraintWidget.getHeight();
        Measure measure = this.mMeasure;
        measure.measuredNeedsSolverPass = false;
        measure.useCurrentDimensions = z5;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = measure.horizontalBehavior;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z6 = dimensionBehaviour == dimensionBehaviour2;
        boolean z7 = measure.verticalBehavior == dimensionBehaviour2;
        boolean z8 = z6 && constraintWidget.mDimensionRatio > 0.0f;
        boolean z9 = z7 && constraintWidget.mDimensionRatio > 0.0f;
        if (z8 && constraintWidget.mResolvedMatchConstraintDefault[0] == 4) {
            measure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (z9 && constraintWidget.mResolvedMatchConstraintDefault[1] == 4) {
            measure.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        measurer.measure(constraintWidget, measure);
        constraintWidget.setWidth(this.mMeasure.measuredWidth);
        constraintWidget.setHeight(this.mMeasure.measuredHeight);
        constraintWidget.setHasBaseline(this.mMeasure.measuredHasBaseline);
        constraintWidget.setBaselineDistance(this.mMeasure.measuredBaseline);
        Measure measure2 = this.mMeasure;
        measure2.useCurrentDimensions = false;
        return measure2.measuredNeedsSolverPass;
    }

    private void measureChildren(ConstraintWidgetContainer constraintWidgetContainer) {
        int size = constraintWidgetContainer.mChildren.size();
        Measurer measurer = constraintWidgetContainer.getMeasurer();
        for (int i6 = 0; i6 < size; i6++) {
            ConstraintWidget constraintWidget = constraintWidgetContainer.mChildren.get(i6);
            if (!(constraintWidget instanceof Guideline) && (!constraintWidget.horizontalRun.dimension.resolved || !constraintWidget.verticalRun.dimension.resolved)) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget.getDimensionBehaviour(0);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidget.getDimensionBehaviour(1);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviour != dimensionBehaviour3 || constraintWidget.mMatchConstraintDefaultWidth == 1 || dimensionBehaviour2 != dimensionBehaviour3 || constraintWidget.mMatchConstraintDefaultHeight == 1) {
                    measure(measurer, constraintWidget, false);
                    Metrics metrics = constraintWidgetContainer.mMetrics;
                    if (metrics != null) {
                        metrics.measuredWidgets++;
                    }
                }
            }
        }
        measurer.didMeasures();
    }

    public void updateHierarchy(ConstraintWidgetContainer constraintWidgetContainer) {
        int i6;
        this.mVariableDimensionsWidgets.clear();
        int size = constraintWidgetContainer.mChildren.size();
        while (i6 < size) {
            ConstraintWidget constraintWidget = constraintWidgetContainer.mChildren.get(i6);
            ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = constraintWidget.getHorizontalDimensionBehaviour();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (horizontalDimensionBehaviour != dimensionBehaviour) {
                ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour2 = constraintWidget.getHorizontalDimensionBehaviour();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
                i6 = (horizontalDimensionBehaviour2 == dimensionBehaviour2 || constraintWidget.getVerticalDimensionBehaviour() == dimensionBehaviour || constraintWidget.getVerticalDimensionBehaviour() == dimensionBehaviour2) ? 0 : i6 + 1;
            }
            this.mVariableDimensionsWidgets.add(constraintWidget);
        }
        constraintWidgetContainer.invalidateGraph();
    }

    public BasicMeasure(ConstraintWidgetContainer constraintWidgetContainer) {
        this.constraintWidgetContainer = constraintWidgetContainer;
    }

    private void solveLinearSystem(ConstraintWidgetContainer constraintWidgetContainer, String str, int i6, int i7) {
        int minWidth = constraintWidgetContainer.getMinWidth();
        int minHeight = constraintWidgetContainer.getMinHeight();
        constraintWidgetContainer.setMinWidth(0);
        constraintWidgetContainer.setMinHeight(0);
        constraintWidgetContainer.setWidth(i6);
        constraintWidgetContainer.setHeight(i7);
        constraintWidgetContainer.setMinWidth(minWidth);
        constraintWidgetContainer.setMinHeight(minHeight);
        this.constraintWidgetContainer.layout();
    }
}
