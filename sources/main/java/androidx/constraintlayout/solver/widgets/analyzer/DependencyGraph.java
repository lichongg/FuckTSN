package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import com.snail.antifake.deviceid.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class DependencyGraph {
    private static final boolean USE_GROUPS = true;
    private ConstraintWidgetContainer container;
    private ConstraintWidgetContainer mContainer;
    private boolean mNeedBuildGraph = true;
    private boolean mNeedRedoMeasures = true;
    private ArrayList<WidgetRun> mRuns = new ArrayList<>();
    private ArrayList<RunGroup> runGroups = new ArrayList<>();
    private BasicMeasure.Measurer mMeasurer = null;
    private BasicMeasure.Measure mMeasure = new BasicMeasure.Measure();
    ArrayList<RunGroup> mGroups = new ArrayList<>();

    public void buildGraph() {
        buildGraph(this.mRuns);
        this.mGroups.clear();
        RunGroup.index = 0;
        findGroup(this.container.horizontalRun, 0, this.mGroups);
        findGroup(this.container.verticalRun, 1, this.mGroups);
        this.mNeedBuildGraph = false;
    }

    public void invalidateGraph() {
        this.mNeedBuildGraph = true;
    }

    public void invalidateMeasures() {
        this.mNeedRedoMeasures = true;
    }

    private void applyGroup(DependencyNode dependencyNode, int i6, int i7, DependencyNode dependencyNode2, ArrayList<RunGroup> arrayList, RunGroup runGroup) {
        int i8;
        DependencyNode dependencyNode3;
        ArrayList<RunGroup> arrayList2;
        WidgetRun widgetRun = dependencyNode.run;
        if (widgetRun.runGroup == null) {
            ConstraintWidgetContainer constraintWidgetContainer = this.container;
            if (widgetRun == constraintWidgetContainer.horizontalRun || widgetRun == constraintWidgetContainer.verticalRun) {
                return;
            }
            if (runGroup == null) {
                runGroup = new RunGroup(widgetRun, i7);
                arrayList.add(runGroup);
            }
            RunGroup runGroup2 = runGroup;
            widgetRun.runGroup = runGroup2;
            runGroup2.add(widgetRun);
            for (Dependency dependency : widgetRun.start.dependencies) {
                if (dependency instanceof DependencyNode) {
                    i8 = i6;
                    dependencyNode3 = dependencyNode2;
                    arrayList2 = arrayList;
                    applyGroup((DependencyNode) dependency, i8, 0, dependencyNode3, arrayList2, runGroup2);
                } else {
                    i8 = i6;
                    dependencyNode3 = dependencyNode2;
                    arrayList2 = arrayList;
                }
                i6 = i8;
                dependencyNode2 = dependencyNode3;
                arrayList = arrayList2;
            }
            int i9 = i6;
            DependencyNode dependencyNode4 = dependencyNode2;
            ArrayList<RunGroup> arrayList3 = arrayList;
            for (Dependency dependency2 : widgetRun.end.dependencies) {
                if (dependency2 instanceof DependencyNode) {
                    applyGroup((DependencyNode) dependency2, i9, 1, dependencyNode4, arrayList3, runGroup2);
                }
            }
            if (i9 == 1 && (widgetRun instanceof VerticalWidgetRun)) {
                for (Dependency dependency3 : ((VerticalWidgetRun) widgetRun).baseline.dependencies) {
                    if (dependency3 instanceof DependencyNode) {
                        applyGroup((DependencyNode) dependency3, i9, 2, dependencyNode4, arrayList3, runGroup2);
                    }
                }
            }
            for (DependencyNode dependencyNode5 : widgetRun.start.targets) {
                if (dependencyNode5 == dependencyNode4) {
                    runGroup2.dual = true;
                }
                applyGroup(dependencyNode5, i9, 0, dependencyNode4, arrayList3, runGroup2);
            }
            for (DependencyNode dependencyNode6 : widgetRun.end.targets) {
                if (dependencyNode6 == dependencyNode4) {
                    runGroup2.dual = true;
                }
                applyGroup(dependencyNode6, i9, 1, dependencyNode4, arrayList3, runGroup2);
            }
            if (i9 == 1 && (widgetRun instanceof VerticalWidgetRun)) {
                Iterator<DependencyNode> it = ((VerticalWidgetRun) widgetRun).baseline.targets.iterator();
                while (it.hasNext()) {
                    applyGroup(it.next(), i9, 2, dependencyNode4, arrayList3, runGroup2);
                }
            }
        }
    }

    private boolean basicMeasureWidgets(ConstraintWidgetContainer constraintWidgetContainer) {
        char c6;
        float f6;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour4;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour5;
        Iterator<ConstraintWidget> it = constraintWidgetContainer.mChildren.iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr2 = next.mListDimensionBehaviors;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = dimensionBehaviourArr2[0];
            ConstraintWidget.DimensionBehaviour dimensionBehaviour7 = dimensionBehaviourArr2[1];
            if (next.getVisibility() == 8) {
                next.measured = true;
            } else {
                if (next.mMatchConstraintPercentWidth < 1.0f && dimensionBehaviour6 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    next.mMatchConstraintDefaultWidth = 2;
                }
                if (next.mMatchConstraintPercentHeight < 1.0f && dimensionBehaviour7 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    next.mMatchConstraintDefaultHeight = 2;
                }
                if (next.getDimensionRatio() > 0.0f) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour8 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (dimensionBehaviour6 == dimensionBehaviour8 && (dimensionBehaviour7 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour7 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        next.mMatchConstraintDefaultWidth = 3;
                    } else if (dimensionBehaviour7 == dimensionBehaviour8 && (dimensionBehaviour6 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour6 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        next.mMatchConstraintDefaultHeight = 3;
                    } else if (dimensionBehaviour6 == dimensionBehaviour8 && dimensionBehaviour7 == dimensionBehaviour8) {
                        if (next.mMatchConstraintDefaultWidth == 0) {
                            next.mMatchConstraintDefaultWidth = 3;
                        }
                        if (next.mMatchConstraintDefaultHeight == 0) {
                            next.mMatchConstraintDefaultHeight = 3;
                        }
                    }
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour9 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviour6 == dimensionBehaviour9 && next.mMatchConstraintDefaultWidth == 1 && (next.mLeft.mTarget == null || next.mRight.mTarget == null)) {
                    dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                }
                if (dimensionBehaviour7 == dimensionBehaviour9 && next.mMatchConstraintDefaultHeight == 1 && (next.mTop.mTarget == null || next.mBottom.mTarget == null)) {
                    dimensionBehaviour7 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour10 = dimensionBehaviour7;
                HorizontalWidgetRun horizontalWidgetRun = next.horizontalRun;
                horizontalWidgetRun.dimensionBehavior = dimensionBehaviour6;
                int i6 = next.mMatchConstraintDefaultWidth;
                horizontalWidgetRun.matchConstraintsType = i6;
                VerticalWidgetRun verticalWidgetRun = next.verticalRun;
                verticalWidgetRun.dimensionBehavior = dimensionBehaviour10;
                int i7 = next.mMatchConstraintDefaultHeight;
                verticalWidgetRun.matchConstraintsType = i7;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour11 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
                if ((dimensionBehaviour6 == dimensionBehaviour11 || dimensionBehaviour6 == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviour6 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && (dimensionBehaviour10 == dimensionBehaviour11 || dimensionBehaviour10 == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviour10 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour12 = dimensionBehaviour6;
                    int width = next.getWidth();
                    if (dimensionBehaviour12 == dimensionBehaviour11) {
                        width = (constraintWidgetContainer.getWidth() - next.mLeft.mMargin) - next.mRight.mMargin;
                        dimensionBehaviour12 = ConstraintWidget.DimensionBehaviour.FIXED;
                    }
                    int i8 = width;
                    int height = next.getHeight();
                    if (dimensionBehaviour10 == dimensionBehaviour11) {
                        height = (constraintWidgetContainer.getHeight() - next.mTop.mMargin) - next.mBottom.mMargin;
                        dimensionBehaviour10 = ConstraintWidget.DimensionBehaviour.FIXED;
                    }
                    measure(next, dimensionBehaviour12, i8, dimensionBehaviour10, height);
                    next.horizontalRun.dimension.resolve(next.getWidth());
                    next.verticalRun.dimension.resolve(next.getHeight());
                    next.measured = true;
                } else {
                    if (dimensionBehaviour6 == dimensionBehaviour9) {
                        ConstraintWidget.DimensionBehaviour dimensionBehaviour13 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                        c6 = 0;
                        if (dimensionBehaviour10 == dimensionBehaviour13 || dimensionBehaviour10 == ConstraintWidget.DimensionBehaviour.FIXED) {
                            if (i6 == 3) {
                                if (dimensionBehaviour10 == dimensionBehaviour13) {
                                    measure(next, dimensionBehaviour13, 0, dimensionBehaviour13, 0);
                                }
                                int height2 = next.getHeight();
                                int i9 = (int) ((height2 * next.mDimensionRatio) + 0.5f);
                                ConstraintWidget.DimensionBehaviour dimensionBehaviour14 = ConstraintWidget.DimensionBehaviour.FIXED;
                                measure(next, dimensionBehaviour14, i9, dimensionBehaviour14, height2);
                                next.horizontalRun.dimension.resolve(next.getWidth());
                                next.verticalRun.dimension.resolve(next.getHeight());
                                next.measured = true;
                            } else if (i6 == 1) {
                                measure(next, dimensionBehaviour13, 0, dimensionBehaviour10, 0);
                                next.horizontalRun.dimension.wrapValue = next.getWidth();
                            } else if (i6 == 2) {
                                ConstraintWidget.DimensionBehaviour dimensionBehaviour15 = constraintWidgetContainer.mListDimensionBehaviors[0];
                                ConstraintWidget.DimensionBehaviour dimensionBehaviour16 = ConstraintWidget.DimensionBehaviour.FIXED;
                                if (dimensionBehaviour15 == dimensionBehaviour16 || dimensionBehaviour15 == dimensionBehaviour11) {
                                    measure(next, dimensionBehaviour16, (int) ((next.mMatchConstraintPercentWidth * constraintWidgetContainer.getWidth()) + 0.5f), dimensionBehaviour10, next.getHeight());
                                    next.horizontalRun.dimension.resolve(next.getWidth());
                                    next.verticalRun.dimension.resolve(next.getHeight());
                                    next.measured = true;
                                }
                            } else {
                                ConstraintAnchor[] constraintAnchorArr = next.mListAnchors;
                                f6 = 1.0f;
                                if (constraintAnchorArr[0].mTarget == null || constraintAnchorArr[1].mTarget == null) {
                                    measure(next, dimensionBehaviour13, 0, dimensionBehaviour10, 0);
                                    next.horizontalRun.dimension.resolve(next.getWidth());
                                    next.verticalRun.dimension.resolve(next.getHeight());
                                    next.measured = true;
                                } else {
                                    if (dimensionBehaviour10 == dimensionBehaviour9 || !(dimensionBehaviour6 == (dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || dimensionBehaviour6 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                                        dimensionBehaviour = dimensionBehaviour6;
                                    } else if (i7 == 3) {
                                        if (dimensionBehaviour6 == dimensionBehaviour4) {
                                            measure(next, dimensionBehaviour4, 0, dimensionBehaviour4, 0);
                                        }
                                        int width2 = next.getWidth();
                                        float f7 = next.mDimensionRatio;
                                        if (next.getDimensionRatioSide() == -1) {
                                            f7 = f6 / f7;
                                        }
                                        ConstraintWidget.DimensionBehaviour dimensionBehaviour17 = ConstraintWidget.DimensionBehaviour.FIXED;
                                        measure(next, dimensionBehaviour17, width2, dimensionBehaviour17, (int) ((width2 * f7) + 0.5f));
                                        next.horizontalRun.dimension.resolve(next.getWidth());
                                        next.verticalRun.dimension.resolve(next.getHeight());
                                        next.measured = true;
                                    } else if (i7 == 1) {
                                        measure(next, dimensionBehaviour6, 0, dimensionBehaviour4, 0);
                                        next.verticalRun.dimension.wrapValue = next.getHeight();
                                    } else {
                                        dimensionBehaviour = dimensionBehaviour6;
                                        if (i7 == 2) {
                                            ConstraintWidget.DimensionBehaviour dimensionBehaviour18 = constraintWidgetContainer.mListDimensionBehaviors[1];
                                            dimensionBehaviour5 = dimensionBehaviour10;
                                            ConstraintWidget.DimensionBehaviour dimensionBehaviour19 = ConstraintWidget.DimensionBehaviour.FIXED;
                                            if (dimensionBehaviour18 == dimensionBehaviour19 || dimensionBehaviour18 == dimensionBehaviour11) {
                                                measure(next, dimensionBehaviour, next.getWidth(), dimensionBehaviour19, (int) ((next.mMatchConstraintPercentHeight * constraintWidgetContainer.getHeight()) + 0.5f));
                                                next.horizontalRun.dimension.resolve(next.getWidth());
                                                next.verticalRun.dimension.resolve(next.getHeight());
                                                next.measured = true;
                                            } else {
                                                dimensionBehaviour10 = dimensionBehaviour5;
                                            }
                                        } else {
                                            dimensionBehaviour5 = dimensionBehaviour10;
                                            ConstraintAnchor[] constraintAnchorArr2 = next.mListAnchors;
                                            if (constraintAnchorArr2[2].mTarget == null || constraintAnchorArr2[3].mTarget == null) {
                                                measure(next, dimensionBehaviour4, 0, dimensionBehaviour5, 0);
                                                next.horizontalRun.dimension.resolve(next.getWidth());
                                                next.verticalRun.dimension.resolve(next.getHeight());
                                                next.measured = true;
                                            } else {
                                                dimensionBehaviour10 = dimensionBehaviour5;
                                            }
                                        }
                                    }
                                    if (dimensionBehaviour == dimensionBehaviour9 && dimensionBehaviour10 == dimensionBehaviour9) {
                                        if (i6 != 1 || i7 == 1) {
                                            ConstraintWidget.DimensionBehaviour dimensionBehaviour20 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                                            measure(next, dimensionBehaviour20, 0, dimensionBehaviour20, 0);
                                            next.horizontalRun.dimension.wrapValue = next.getWidth();
                                            next.verticalRun.dimension.wrapValue = next.getHeight();
                                        } else if (i7 == 2 && i6 == 2 && ((dimensionBehaviour2 = (dimensionBehaviourArr = constraintWidgetContainer.mListDimensionBehaviors)[c6]) == (dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.FIXED) || dimensionBehaviour2 == dimensionBehaviour3)) {
                                            ConstraintWidget.DimensionBehaviour dimensionBehaviour21 = dimensionBehaviourArr[1];
                                            if (dimensionBehaviour21 == dimensionBehaviour3 || dimensionBehaviour21 == dimensionBehaviour3) {
                                                measure(next, dimensionBehaviour3, (int) ((next.mMatchConstraintPercentWidth * constraintWidgetContainer.getWidth()) + 0.5f), dimensionBehaviour3, (int) ((next.mMatchConstraintPercentHeight * constraintWidgetContainer.getHeight()) + 0.5f));
                                                next.horizontalRun.dimension.resolve(next.getWidth());
                                                next.verticalRun.dimension.resolve(next.getHeight());
                                                next.measured = true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        c6 = 0;
                    }
                    f6 = 1.0f;
                    if (dimensionBehaviour10 == dimensionBehaviour9) {
                    }
                    dimensionBehaviour = dimensionBehaviour6;
                    if (dimensionBehaviour == dimensionBehaviour9) {
                        if (i6 != 1) {
                        }
                        ConstraintWidget.DimensionBehaviour dimensionBehaviour202 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                        measure(next, dimensionBehaviour202, 0, dimensionBehaviour202, 0);
                        next.horizontalRun.dimension.wrapValue = next.getWidth();
                        next.verticalRun.dimension.wrapValue = next.getHeight();
                    }
                }
            }
        }
        return false;
    }

    private int computeWrap(ConstraintWidgetContainer constraintWidgetContainer, int i6) {
        int size = this.mGroups.size();
        long j6 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            j6 = Math.max(j6, this.mGroups.get(i7).computeWrapSize(constraintWidgetContainer, i6));
        }
        return (int) j6;
    }

    private void displayGraph() {
        Iterator<WidgetRun> it = this.mRuns.iterator();
        String str = "digraph {\n";
        while (it.hasNext()) {
            str = generateDisplayGraph(it.next(), str);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("\n}\n");
        System.out.getClass();
    }

    private void findGroup(WidgetRun widgetRun, int i6, ArrayList<RunGroup> arrayList) {
        for (Dependency dependency : widgetRun.start.dependencies) {
            if (dependency instanceof DependencyNode) {
                applyGroup((DependencyNode) dependency, i6, 0, widgetRun.end, arrayList, null);
            } else if (dependency instanceof WidgetRun) {
                applyGroup(((WidgetRun) dependency).start, i6, 0, widgetRun.end, arrayList, null);
            }
        }
        for (Dependency dependency2 : widgetRun.end.dependencies) {
            if (dependency2 instanceof DependencyNode) {
                applyGroup((DependencyNode) dependency2, i6, 1, widgetRun.start, arrayList, null);
            } else if (dependency2 instanceof WidgetRun) {
                applyGroup(((WidgetRun) dependency2).end, i6, 1, widgetRun.start, arrayList, null);
            }
        }
        int i7 = i6;
        if (i7 == 1) {
            for (Dependency dependency3 : ((VerticalWidgetRun) widgetRun).baseline.dependencies) {
                if (dependency3 instanceof DependencyNode) {
                    applyGroup((DependencyNode) dependency3, i7, 2, null, arrayList, null);
                }
                i7 = i6;
            }
        }
    }

    private String generateChainDisplayGraph(ChainRun chainRun, String str) {
        String str2;
        String str3;
        int i6 = chainRun.orientation;
        String str4 = "cluster_" + chainRun.widget.getDebugName();
        if (i6 == 0) {
            str2 = str4 + "_h";
        } else {
            str2 = str4 + "_v";
        }
        String str5 = "subgraph " + str2 + " {\n";
        Iterator<WidgetRun> it = chainRun.widgets.iterator();
        String str6 = "";
        while (it.hasNext()) {
            WidgetRun next = it.next();
            String debugName = next.widget.getDebugName();
            if (i6 == 0) {
                str3 = debugName + "_HORIZONTAL";
            } else {
                str3 = debugName + "_VERTICAL";
            }
            str5 = str5 + str3 + ";\n";
            str6 = generateDisplayGraph(next, str6);
        }
        return str + str6 + (str5 + "}\n");
    }

    private String generateDisplayGraph(WidgetRun widgetRun, String str) {
        boolean z5;
        DependencyNode dependencyNode = widgetRun.start;
        DependencyNode dependencyNode2 = widgetRun.end;
        if (!(widgetRun instanceof HelperReferences) && dependencyNode.dependencies.isEmpty() && (dependencyNode2.dependencies.isEmpty() && dependencyNode.targets.isEmpty()) && dependencyNode2.targets.isEmpty()) {
            return str;
        }
        String str2 = str + nodeDefinition(widgetRun);
        boolean isCenteredConnection = isCenteredConnection(dependencyNode, dependencyNode2);
        String generateDisplayNode = generateDisplayNode(dependencyNode2, isCenteredConnection, generateDisplayNode(dependencyNode, isCenteredConnection, str2));
        boolean z6 = widgetRun instanceof VerticalWidgetRun;
        if (z6) {
            generateDisplayNode = generateDisplayNode(((VerticalWidgetRun) widgetRun).baseline, isCenteredConnection, generateDisplayNode);
        }
        if ((widgetRun instanceof HorizontalWidgetRun) || (((z5 = widgetRun instanceof ChainRun)) && ((ChainRun) widgetRun).orientation == 0)) {
            ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = widgetRun.widget.getHorizontalDimensionBehaviour();
            if (horizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.FIXED || horizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                if (!dependencyNode.targets.isEmpty() && dependencyNode2.targets.isEmpty()) {
                    generateDisplayNode = generateDisplayNode + (e.f37542d + dependencyNode2.name() + " -> " + dependencyNode.name() + e.f37542d);
                } else if (dependencyNode.targets.isEmpty() && !dependencyNode2.targets.isEmpty()) {
                    generateDisplayNode = generateDisplayNode + (e.f37542d + dependencyNode.name() + " -> " + dependencyNode2.name() + e.f37542d);
                }
            } else if (horizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun.widget.getDimensionRatio() > 0.0f) {
                widgetRun.widget.getDebugName();
            }
        } else if (z6 || (z5 && ((ChainRun) widgetRun).orientation == 1)) {
            ConstraintWidget.DimensionBehaviour verticalDimensionBehaviour = widgetRun.widget.getVerticalDimensionBehaviour();
            if (verticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.FIXED || verticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                if (!dependencyNode.targets.isEmpty() && dependencyNode2.targets.isEmpty()) {
                    generateDisplayNode = generateDisplayNode + (e.f37542d + dependencyNode2.name() + " -> " + dependencyNode.name() + e.f37542d);
                } else if (dependencyNode.targets.isEmpty() && !dependencyNode2.targets.isEmpty()) {
                    generateDisplayNode = generateDisplayNode + (e.f37542d + dependencyNode.name() + " -> " + dependencyNode2.name() + e.f37542d);
                }
            } else if (verticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun.widget.getDimensionRatio() > 0.0f) {
                widgetRun.widget.getDebugName();
            }
        }
        return widgetRun instanceof ChainRun ? generateChainDisplayGraph((ChainRun) widgetRun, generateDisplayNode) : generateDisplayNode;
    }

    private String generateDisplayNode(DependencyNode dependencyNode, boolean z5, String str) {
        for (DependencyNode dependencyNode2 : dependencyNode.targets) {
            String str2 = (e.f37542d + dependencyNode.name()) + " -> " + dependencyNode2.name();
            if (dependencyNode.margin > 0 || z5 || (dependencyNode.run instanceof HelperReferences)) {
                String str3 = str2 + "[";
                if (dependencyNode.margin > 0) {
                    str3 = str3 + "label=\"" + dependencyNode.margin + "\"";
                    if (z5) {
                        str3 = str3 + ",";
                    }
                }
                if (z5) {
                    str3 = str3 + " style=dashed ";
                }
                if (dependencyNode.run instanceof HelperReferences) {
                    str3 = str3 + " style=bold,color=gray ";
                }
                str2 = str3 + "]";
            }
            str = str + (str2 + e.f37542d);
        }
        return str;
    }

    private boolean isCenteredConnection(DependencyNode dependencyNode, DependencyNode dependencyNode2) {
        Iterator<DependencyNode> it = dependencyNode.targets.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            if (it.next() != dependencyNode2) {
                i6++;
            }
        }
        Iterator<DependencyNode> it2 = dependencyNode2.targets.iterator();
        int i7 = 0;
        while (it2.hasNext()) {
            if (it2.next() != dependencyNode) {
                i7++;
            }
        }
        return i6 > 0 && i7 > 0;
    }

    private void measure(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i6, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i7) {
        BasicMeasure.Measure measure = this.mMeasure;
        measure.horizontalBehavior = dimensionBehaviour;
        measure.verticalBehavior = dimensionBehaviour2;
        measure.horizontalDimension = i6;
        measure.verticalDimension = i7;
        this.mMeasurer.measure(constraintWidget, measure);
        constraintWidget.setWidth(this.mMeasure.measuredWidth);
        constraintWidget.setHeight(this.mMeasure.measuredHeight);
        constraintWidget.setHasBaseline(this.mMeasure.measuredHasBaseline);
        constraintWidget.setBaselineDistance(this.mMeasure.measuredBaseline);
    }

    private String nodeDefinition(WidgetRun widgetRun) {
        String str;
        String str2;
        String str3;
        String str4;
        boolean z5 = widgetRun instanceof VerticalWidgetRun;
        String debugName = widgetRun.widget.getDebugName();
        ConstraintWidget constraintWidget = widgetRun.widget;
        ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = !z5 ? constraintWidget.getHorizontalDimensionBehaviour() : constraintWidget.getVerticalDimensionBehaviour();
        RunGroup runGroup = widgetRun.runGroup;
        if (z5) {
            str = debugName + "_VERTICAL";
        } else {
            str = debugName + "_HORIZONTAL";
        }
        String str5 = ((str + " [shape=none, label=<") + "<TABLE BORDER=\"0\" CELLSPACING=\"0\" CELLPADDING=\"2\">") + "  <TR>";
        if (z5) {
            String str6 = str5 + "    <TD ";
            if (widgetRun.start.resolved) {
                str6 = str6 + " BGCOLOR=\"green\"";
            }
            str2 = str6 + " PORT=\"TOP\" BORDER=\"1\">T</TD>";
        } else {
            String str7 = str5 + "    <TD ";
            if (widgetRun.start.resolved) {
                str7 = str7 + " BGCOLOR=\"green\"";
            }
            str2 = str7 + " PORT=\"LEFT\" BORDER=\"1\">L</TD>";
        }
        String str8 = str2 + "    <TD BORDER=\"1\" ";
        boolean z6 = widgetRun.dimension.resolved;
        if (z6 && !widgetRun.widget.measured) {
            str8 = str8 + " BGCOLOR=\"green\" ";
        } else if (z6 && widgetRun.widget.measured) {
            str8 = str8 + " BGCOLOR=\"lightgray\" ";
        } else if (!z6 && widgetRun.widget.measured) {
            str8 = str8 + " BGCOLOR=\"yellow\" ";
        }
        if (horizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            str8 = str8 + "style=\"dashed\"";
        }
        if (runGroup != null) {
            str3 = " [" + (runGroup.groupIndex + 1) + "/" + RunGroup.index + "]";
        } else {
            str3 = "";
        }
        String str9 = str8 + ">" + debugName + str3 + " </TD>";
        if (z5) {
            String str10 = str9 + "    <TD ";
            if ((widgetRun instanceof VerticalWidgetRun) && ((VerticalWidgetRun) widgetRun).baseline.resolved) {
                str10 = str10 + " BGCOLOR=\"green\"";
            }
            String str11 = (str10 + " PORT=\"BASELINE\" BORDER=\"1\">b</TD>") + "    <TD ";
            if (widgetRun.end.resolved) {
                str11 = str11 + " BGCOLOR=\"green\"";
            }
            str4 = str11 + " PORT=\"BOTTOM\" BORDER=\"1\">B</TD>";
        } else {
            String str12 = str9 + "    <TD ";
            if (widgetRun.end.resolved) {
                str12 = str12 + " BGCOLOR=\"green\"";
            }
            str4 = str12 + " PORT=\"RIGHT\" BORDER=\"1\">R</TD>";
        }
        return (str4 + "  </TR></TABLE>") + ">];\n";
    }

    public void defineTerminalWidgets(ConstraintWidget.DimensionBehaviour dimensionBehaviour, ConstraintWidget.DimensionBehaviour dimensionBehaviour2) {
        if (this.mNeedBuildGraph) {
            buildGraph();
            Iterator<ConstraintWidget> it = this.container.mChildren.iterator();
            boolean z5 = false;
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                boolean[] zArr = next.isTerminalWidget;
                zArr[0] = true;
                zArr[1] = true;
                if (next instanceof Barrier) {
                    z5 = true;
                }
            }
            if (z5) {
                return;
            }
            Iterator<RunGroup> it2 = this.mGroups.iterator();
            while (it2.hasNext()) {
                RunGroup next2 = it2.next();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                next2.defineTerminalWidgets(dimensionBehaviour == dimensionBehaviour3, dimensionBehaviour2 == dimensionBehaviour3);
            }
        }
    }

    public boolean directMeasure(boolean z5) {
        boolean z6;
        boolean z7 = false;
        if (this.mNeedBuildGraph || this.mNeedRedoMeasures) {
            Iterator<ConstraintWidget> it = this.container.mChildren.iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                next.measured = false;
                next.horizontalRun.reset();
                next.verticalRun.reset();
            }
            ConstraintWidgetContainer constraintWidgetContainer = this.container;
            constraintWidgetContainer.measured = false;
            constraintWidgetContainer.horizontalRun.reset();
            this.container.verticalRun.reset();
            this.mNeedRedoMeasures = false;
        }
        if (basicMeasureWidgets(this.mContainer)) {
            return false;
        }
        this.container.setX(0);
        this.container.setY(0);
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = this.container.getDimensionBehaviour(0);
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.container.getDimensionBehaviour(1);
        if (this.mNeedBuildGraph) {
            buildGraph();
        }
        int x5 = this.container.getX();
        int y5 = this.container.getY();
        this.container.horizontalRun.start.resolve(x5);
        this.container.verticalRun.start.resolve(y5);
        measureWidgets();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (dimensionBehaviour == dimensionBehaviour3 || dimensionBehaviour2 == dimensionBehaviour3) {
            if (z5) {
                Iterator<WidgetRun> it2 = this.mRuns.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    if (!it2.next().supportsWrapComputation()) {
                        z5 = false;
                        break;
                    }
                }
            }
            if (z5 && dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.container.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                ConstraintWidgetContainer constraintWidgetContainer2 = this.container;
                constraintWidgetContainer2.setWidth(computeWrap(constraintWidgetContainer2, 0));
                ConstraintWidgetContainer constraintWidgetContainer3 = this.container;
                constraintWidgetContainer3.horizontalRun.dimension.resolve(constraintWidgetContainer3.getWidth());
            }
            if (z5 && dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.container.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                ConstraintWidgetContainer constraintWidgetContainer4 = this.container;
                constraintWidgetContainer4.setHeight(computeWrap(constraintWidgetContainer4, 1));
                ConstraintWidgetContainer constraintWidgetContainer5 = this.container;
                constraintWidgetContainer5.verticalRun.dimension.resolve(constraintWidgetContainer5.getHeight());
            }
        }
        ConstraintWidgetContainer constraintWidgetContainer6 = this.container;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = constraintWidgetContainer6.mListDimensionBehaviors[0];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (dimensionBehaviour4 == dimensionBehaviour5 || dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int width = constraintWidgetContainer6.getWidth() + x5;
            this.container.horizontalRun.end.resolve(width);
            this.container.horizontalRun.dimension.resolve(width - x5);
            measureWidgets();
            ConstraintWidgetContainer constraintWidgetContainer7 = this.container;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = constraintWidgetContainer7.mListDimensionBehaviors[1];
            if (dimensionBehaviour6 == dimensionBehaviour5 || dimensionBehaviour6 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int height = constraintWidgetContainer7.getHeight() + y5;
                this.container.verticalRun.end.resolve(height);
                this.container.verticalRun.dimension.resolve(height - y5);
            }
            measureWidgets();
            z6 = true;
        } else {
            z6 = false;
        }
        Iterator<WidgetRun> it3 = this.mRuns.iterator();
        while (it3.hasNext()) {
            WidgetRun next2 = it3.next();
            if (next2.widget != this.container || next2.resolved) {
                next2.applyToWidget();
            }
        }
        Iterator<WidgetRun> it4 = this.mRuns.iterator();
        while (true) {
            if (!it4.hasNext()) {
                z7 = true;
                break;
            }
            WidgetRun next3 = it4.next();
            if (z6 || next3.widget != this.container) {
                if (!next3.start.resolved) {
                    break;
                }
                if (!next3.end.resolved) {
                    if (!(next3 instanceof GuidelineReference)) {
                        break;
                    }
                }
                if (!next3.dimension.resolved && !(next3 instanceof ChainRun) && !(next3 instanceof GuidelineReference)) {
                    break;
                }
            }
        }
        this.container.setHorizontalDimensionBehaviour(dimensionBehaviour);
        this.container.setVerticalDimensionBehaviour(dimensionBehaviour2);
        return z7;
    }

    public boolean directMeasureSetup(boolean z5) {
        if (this.mNeedBuildGraph) {
            Iterator<ConstraintWidget> it = this.container.mChildren.iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                next.measured = false;
                HorizontalWidgetRun horizontalWidgetRun = next.horizontalRun;
                horizontalWidgetRun.dimension.resolved = false;
                horizontalWidgetRun.resolved = false;
                horizontalWidgetRun.reset();
                VerticalWidgetRun verticalWidgetRun = next.verticalRun;
                verticalWidgetRun.dimension.resolved = false;
                verticalWidgetRun.resolved = false;
                verticalWidgetRun.reset();
            }
            ConstraintWidgetContainer constraintWidgetContainer = this.container;
            constraintWidgetContainer.measured = false;
            HorizontalWidgetRun horizontalWidgetRun2 = constraintWidgetContainer.horizontalRun;
            horizontalWidgetRun2.dimension.resolved = false;
            horizontalWidgetRun2.resolved = false;
            horizontalWidgetRun2.reset();
            VerticalWidgetRun verticalWidgetRun2 = this.container.verticalRun;
            verticalWidgetRun2.dimension.resolved = false;
            verticalWidgetRun2.resolved = false;
            verticalWidgetRun2.reset();
            buildGraph();
        }
        if (basicMeasureWidgets(this.mContainer)) {
            return false;
        }
        this.container.setX(0);
        this.container.setY(0);
        this.container.horizontalRun.start.resolve(0);
        this.container.verticalRun.start.resolve(0);
        return true;
    }

    public boolean directMeasureWithOrientation(boolean z5, int i6) {
        boolean z6;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        boolean z7 = false;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.container.getDimensionBehaviour(0);
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = this.container.getDimensionBehaviour(1);
        int x5 = this.container.getX();
        int y5 = this.container.getY();
        if (z5 && (dimensionBehaviour2 == (dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || dimensionBehaviour3 == dimensionBehaviour)) {
            Iterator<WidgetRun> it = this.mRuns.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WidgetRun next = it.next();
                if (next.orientation == i6 && !next.supportsWrapComputation()) {
                    z5 = false;
                    break;
                }
            }
            if (i6 == 0) {
                if (z5 && dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    this.container.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                    ConstraintWidgetContainer constraintWidgetContainer = this.container;
                    constraintWidgetContainer.setWidth(computeWrap(constraintWidgetContainer, 0));
                    ConstraintWidgetContainer constraintWidgetContainer2 = this.container;
                    constraintWidgetContainer2.horizontalRun.dimension.resolve(constraintWidgetContainer2.getWidth());
                }
            } else if (z5 && dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.container.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                ConstraintWidgetContainer constraintWidgetContainer3 = this.container;
                constraintWidgetContainer3.setHeight(computeWrap(constraintWidgetContainer3, 1));
                ConstraintWidgetContainer constraintWidgetContainer4 = this.container;
                constraintWidgetContainer4.verticalRun.dimension.resolve(constraintWidgetContainer4.getHeight());
            }
        }
        if (i6 == 0) {
            ConstraintWidgetContainer constraintWidgetContainer5 = this.container;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = constraintWidgetContainer5.mListDimensionBehaviors[0];
            if (dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int width = constraintWidgetContainer5.getWidth() + x5;
                this.container.horizontalRun.end.resolve(width);
                this.container.horizontalRun.dimension.resolve(width - x5);
                z6 = true;
            }
            z6 = false;
        } else {
            ConstraintWidgetContainer constraintWidgetContainer6 = this.container;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = constraintWidgetContainer6.mListDimensionBehaviors[1];
            if (dimensionBehaviour5 == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviour5 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int height = constraintWidgetContainer6.getHeight() + y5;
                this.container.verticalRun.end.resolve(height);
                this.container.verticalRun.dimension.resolve(height - y5);
                z6 = true;
            }
            z6 = false;
        }
        measureWidgets();
        Iterator<WidgetRun> it2 = this.mRuns.iterator();
        while (it2.hasNext()) {
            WidgetRun next2 = it2.next();
            if (next2.orientation == i6 && (next2.widget != this.container || next2.resolved)) {
                next2.applyToWidget();
            }
        }
        Iterator<WidgetRun> it3 = this.mRuns.iterator();
        while (true) {
            if (!it3.hasNext()) {
                z7 = true;
                break;
            }
            WidgetRun next3 = it3.next();
            if (next3.orientation == i6 && (z6 || next3.widget != this.container)) {
                if (!next3.start.resolved) {
                    break;
                }
                if (!next3.end.resolved) {
                    break;
                }
                if (!(next3 instanceof ChainRun) && !next3.dimension.resolved) {
                    break;
                }
            }
        }
        this.container.setHorizontalDimensionBehaviour(dimensionBehaviour2);
        this.container.setVerticalDimensionBehaviour(dimensionBehaviour3);
        return z7;
    }

    public void measureWidgets() {
        DimensionDependency dimensionDependency;
        Iterator<ConstraintWidget> it = this.container.mChildren.iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            if (!next.measured) {
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = next.mListDimensionBehaviors;
                boolean z5 = false;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
                int i6 = next.mMatchConstraintDefaultWidth;
                int i7 = next.mMatchConstraintDefaultHeight;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                boolean z6 = dimensionBehaviour == dimensionBehaviour3 || (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && i6 == 1);
                if (dimensionBehaviour2 == dimensionBehaviour3 || (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && i7 == 1)) {
                    z5 = true;
                }
                DimensionDependency dimensionDependency2 = next.horizontalRun.dimension;
                boolean z7 = dimensionDependency2.resolved;
                DimensionDependency dimensionDependency3 = next.verticalRun.dimension;
                boolean z8 = dimensionDependency3.resolved;
                if (z7 && z8) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
                    measure(next, dimensionBehaviour4, dimensionDependency2.value, dimensionBehaviour4, dimensionDependency3.value);
                    next.measured = true;
                } else if (z7 && z5) {
                    measure(next, ConstraintWidget.DimensionBehaviour.FIXED, dimensionDependency2.value, dimensionBehaviour3, dimensionDependency3.value);
                    if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        next.verticalRun.dimension.wrapValue = next.getHeight();
                    } else {
                        next.verticalRun.dimension.resolve(next.getHeight());
                        next.measured = true;
                    }
                } else if (z8 && z6) {
                    measure(next, dimensionBehaviour3, dimensionDependency2.value, ConstraintWidget.DimensionBehaviour.FIXED, dimensionDependency3.value);
                    if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        next.horizontalRun.dimension.wrapValue = next.getWidth();
                    } else {
                        next.horizontalRun.dimension.resolve(next.getWidth());
                        next.measured = true;
                    }
                }
                if (next.measured && (dimensionDependency = next.verticalRun.baselineDimension) != null) {
                    dimensionDependency.resolve(next.getBaselineDistance());
                }
            }
        }
    }

    public void setMeasurer(BasicMeasure.Measurer measurer) {
        this.mMeasurer = measurer;
    }

    public DependencyGraph(ConstraintWidgetContainer constraintWidgetContainer) {
        this.container = constraintWidgetContainer;
        this.mContainer = constraintWidgetContainer;
    }

    public void buildGraph(ArrayList<WidgetRun> arrayList) {
        arrayList.clear();
        this.mContainer.horizontalRun.clear();
        this.mContainer.verticalRun.clear();
        arrayList.add(this.mContainer.horizontalRun);
        arrayList.add(this.mContainer.verticalRun);
        Iterator<ConstraintWidget> it = this.mContainer.mChildren.iterator();
        HashSet hashSet = null;
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            if (next instanceof Guideline) {
                arrayList.add(new GuidelineReference(next));
            } else {
                if (next.isInHorizontalChain()) {
                    if (next.horizontalChainRun == null) {
                        next.horizontalChainRun = new ChainRun(next, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.horizontalChainRun);
                } else {
                    arrayList.add(next.horizontalRun);
                }
                if (next.isInVerticalChain()) {
                    if (next.verticalChainRun == null) {
                        next.verticalChainRun = new ChainRun(next, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.verticalChainRun);
                } else {
                    arrayList.add(next.verticalRun);
                }
                if (next instanceof HelperWidget) {
                    arrayList.add(new HelperReferences(next));
                }
            }
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator<WidgetRun> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            it2.next().clear();
        }
        Iterator<WidgetRun> it3 = arrayList.iterator();
        while (it3.hasNext()) {
            WidgetRun next2 = it3.next();
            if (next2.widget != this.mContainer) {
                next2.apply();
            }
        }
    }
}
