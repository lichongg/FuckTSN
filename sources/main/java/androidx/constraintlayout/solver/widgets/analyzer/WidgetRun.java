package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class WidgetRun implements Dependency {
    protected ConstraintWidget.DimensionBehaviour dimensionBehavior;
    public int matchConstraintsType;
    RunGroup runGroup;
    ConstraintWidget widget;
    DimensionDependency dimension = new DimensionDependency(this);
    public int orientation = 0;
    boolean resolved = false;
    public DependencyNode start = new DependencyNode(this);
    public DependencyNode end = new DependencyNode(this);
    protected RunType mRunType = RunType.NONE;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    enum RunType {
        NONE,
        START,
        END,
        CENTER
    }

    protected final void addTarget(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i6) {
        dependencyNode.targets.add(dependencyNode2);
        dependencyNode.margin = i6;
        dependencyNode2.dependencies.add(dependencyNode);
    }

    abstract void apply();

    abstract void applyToWidget();

    abstract void clear();

    protected final DependencyNode getTarget(ConstraintAnchor constraintAnchor) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.mOwner;
        int i6 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[constraintAnchor2.mType.ordinal()];
        if (i6 == 1) {
            return constraintWidget.horizontalRun.start;
        }
        if (i6 == 2) {
            return constraintWidget.horizontalRun.end;
        }
        if (i6 == 3) {
            return constraintWidget.verticalRun.start;
        }
        if (i6 == 4) {
            return constraintWidget.verticalRun.baseline;
        }
        if (i6 != 5) {
            return null;
        }
        return constraintWidget.verticalRun.end;
    }

    abstract void reset();

    abstract boolean supportsWrapComputation();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: androidx.constraintlayout.solver.widgets.analyzer.WidgetRun$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type;

        static {
            int[] iArr = new int[ConstraintAnchor.Type.values().length];
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type = iArr;
            try {
                iArr[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BASELINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private void resolveDimension(int i6, int i7) {
        int i8 = this.matchConstraintsType;
        if (i8 == 0) {
            this.dimension.resolve(getLimitedDimension(i7, i6));
            return;
        }
        if (i8 == 1) {
            this.dimension.resolve(Math.min(getLimitedDimension(this.dimension.wrapValue, i6), i7));
            return;
        }
        if (i8 == 2) {
            ConstraintWidget parent = this.widget.getParent();
            if (parent != null) {
                if ((i6 == 0 ? parent.horizontalRun : parent.verticalRun).dimension.resolved) {
                    ConstraintWidget constraintWidget = this.widget;
                    this.dimension.resolve(getLimitedDimension((int) ((r9.value * (i6 == 0 ? constraintWidget.mMatchConstraintPercentWidth : constraintWidget.mMatchConstraintPercentHeight)) + 0.5f), i6));
                    return;
                }
                return;
            }
            return;
        }
        if (i8 != 3) {
            return;
        }
        ConstraintWidget constraintWidget2 = this.widget;
        WidgetRun widgetRun = constraintWidget2.horizontalRun;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = widgetRun.dimensionBehavior;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (dimensionBehaviour == dimensionBehaviour2 && widgetRun.matchConstraintsType == 3) {
            VerticalWidgetRun verticalWidgetRun = constraintWidget2.verticalRun;
            if (verticalWidgetRun.dimensionBehavior == dimensionBehaviour2 && verticalWidgetRun.matchConstraintsType == 3) {
                return;
            }
        }
        if (i6 == 0) {
            widgetRun = constraintWidget2.verticalRun;
        }
        if (widgetRun.dimension.resolved) {
            float dimensionRatio = constraintWidget2.getDimensionRatio();
            this.dimension.resolve(i6 == 1 ? (int) ((widgetRun.dimension.value / dimensionRatio) + 0.5f) : (int) ((dimensionRatio * widgetRun.dimension.value) + 0.5f));
        }
    }

    protected final int getLimitedDimension(int i6, int i7) {
        if (i7 == 0) {
            ConstraintWidget constraintWidget = this.widget;
            int i8 = constraintWidget.mMatchConstraintMaxWidth;
            int max = Math.max(constraintWidget.mMatchConstraintMinWidth, i6);
            if (i8 > 0) {
                max = Math.min(i8, i6);
            }
            if (max != i6) {
                return max;
            }
        } else {
            ConstraintWidget constraintWidget2 = this.widget;
            int i9 = constraintWidget2.mMatchConstraintMaxHeight;
            int max2 = Math.max(constraintWidget2.mMatchConstraintMinHeight, i6);
            if (i9 > 0) {
                max2 = Math.min(i9, i6);
            }
            if (max2 != i6) {
                return max2;
            }
        }
        return i6;
    }

    public long getWrapDimension() {
        if (this.dimension.resolved) {
            return r0.value;
        }
        return 0L;
    }

    public boolean isCenterConnection() {
        int size = this.start.targets.size();
        int i6 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            if (this.start.targets.get(i7).run != this) {
                i6++;
            }
        }
        int size2 = this.end.targets.size();
        for (int i8 = 0; i8 < size2; i8++) {
            if (this.end.targets.get(i8).run != this) {
                i6++;
            }
        }
        return i6 >= 2;
    }

    public boolean isDimensionResolved() {
        return this.dimension.resolved;
    }

    public boolean isResolved() {
        return this.resolved;
    }

    public long wrapSize(int i6) {
        DimensionDependency dimensionDependency = this.dimension;
        if (!dimensionDependency.resolved) {
            return 0L;
        }
        long j6 = dimensionDependency.value;
        return isCenterConnection() ? j6 + (this.start.margin - this.end.margin) : i6 == 0 ? j6 + this.start.margin : j6 - this.end.margin;
    }

    public WidgetRun(ConstraintWidget constraintWidget) {
        this.widget = constraintWidget;
    }

    protected void updateRunCenter(Dependency dependency, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i6) {
        float verticalBiasPercent;
        DependencyNode target = getTarget(constraintAnchor);
        DependencyNode target2 = getTarget(constraintAnchor2);
        if (target.resolved && target2.resolved) {
            int margin = target.value + constraintAnchor.getMargin();
            int margin2 = target2.value - constraintAnchor2.getMargin();
            int i7 = margin2 - margin;
            if (!this.dimension.resolved && this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                resolveDimension(i6, i7);
            }
            DimensionDependency dimensionDependency = this.dimension;
            if (dimensionDependency.resolved) {
                if (dimensionDependency.value == i7) {
                    this.start.resolve(margin);
                    this.end.resolve(margin2);
                    return;
                }
                ConstraintWidget constraintWidget = this.widget;
                if (i6 == 0) {
                    verticalBiasPercent = constraintWidget.getHorizontalBiasPercent();
                } else {
                    verticalBiasPercent = constraintWidget.getVerticalBiasPercent();
                }
                if (target == target2) {
                    margin = target.value;
                    margin2 = target2.value;
                    verticalBiasPercent = 0.5f;
                }
                this.start.resolve((int) (margin + 0.5f + (((margin2 - margin) - this.dimension.value) * verticalBiasPercent)));
                this.end.resolve(this.start.value + this.dimension.value);
            }
        }
    }

    protected final void addTarget(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i6, DimensionDependency dimensionDependency) {
        dependencyNode.targets.add(dependencyNode2);
        dependencyNode.targets.add(this.dimension);
        dependencyNode.marginFactor = i6;
        dependencyNode.marginDependency = dimensionDependency;
        dependencyNode2.dependencies.add(dependencyNode);
        dimensionDependency.dependencies.add(dependencyNode);
    }

    protected final DependencyNode getTarget(ConstraintAnchor constraintAnchor, int i6) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.mOwner;
        WidgetRun widgetRun = i6 == 0 ? constraintWidget.horizontalRun : constraintWidget.verticalRun;
        int i7 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[constraintAnchor2.mType.ordinal()];
        if (i7 != 1) {
            if (i7 != 2) {
                if (i7 != 3) {
                    if (i7 != 5) {
                        return null;
                    }
                }
            }
            return widgetRun.end;
        }
        return widgetRun.start;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.Dependency
    public void update(Dependency dependency) {
    }

    protected void updateRunEnd(Dependency dependency) {
    }

    protected void updateRunStart(Dependency dependency) {
    }
}
