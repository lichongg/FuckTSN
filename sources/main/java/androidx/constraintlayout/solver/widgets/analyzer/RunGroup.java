package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
class RunGroup {
    public static final int BASELINE = 2;
    public static final int END = 1;
    public static final int START = 0;
    public static int index;
    int direction;
    WidgetRun firstRun;
    int groupIndex;
    WidgetRun lastRun;
    public int position = 0;
    public boolean dual = false;
    ArrayList<WidgetRun> runs = new ArrayList<>();

    private boolean defineTerminalWidget(WidgetRun widgetRun, int i6) {
        DependencyNode dependencyNode;
        WidgetRun widgetRun2;
        DependencyNode dependencyNode2;
        WidgetRun widgetRun3;
        if (!widgetRun.widget.isTerminalWidget[i6]) {
            return false;
        }
        for (Dependency dependency : widgetRun.start.dependencies) {
            if ((dependency instanceof DependencyNode) && (widgetRun3 = (dependencyNode2 = (DependencyNode) dependency).run) != widgetRun && dependencyNode2 == widgetRun3.start) {
                if (widgetRun instanceof ChainRun) {
                    Iterator<WidgetRun> it = ((ChainRun) widgetRun).widgets.iterator();
                    while (it.hasNext()) {
                        defineTerminalWidget(it.next(), i6);
                    }
                } else if (!(widgetRun instanceof HelperReferences)) {
                    widgetRun.widget.isTerminalWidget[i6] = false;
                }
                defineTerminalWidget(dependencyNode2.run, i6);
            }
        }
        for (Dependency dependency2 : widgetRun.end.dependencies) {
            if ((dependency2 instanceof DependencyNode) && (widgetRun2 = (dependencyNode = (DependencyNode) dependency2).run) != widgetRun && dependencyNode == widgetRun2.start) {
                if (widgetRun instanceof ChainRun) {
                    Iterator<WidgetRun> it2 = ((ChainRun) widgetRun).widgets.iterator();
                    while (it2.hasNext()) {
                        defineTerminalWidget(it2.next(), i6);
                    }
                } else if (!(widgetRun instanceof HelperReferences)) {
                    widgetRun.widget.isTerminalWidget[i6] = false;
                }
                defineTerminalWidget(dependencyNode.run, i6);
            }
        }
        return false;
    }

    private long traverseEnd(DependencyNode dependencyNode, long j6) {
        WidgetRun widgetRun = dependencyNode.run;
        if (widgetRun instanceof HelperReferences) {
            return j6;
        }
        int size = dependencyNode.dependencies.size();
        long j7 = j6;
        for (int i6 = 0; i6 < size; i6++) {
            Dependency dependency = dependencyNode.dependencies.get(i6);
            if (dependency instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dependency;
                if (dependencyNode2.run != widgetRun) {
                    j7 = Math.min(j7, traverseEnd(dependencyNode2, dependencyNode2.margin + j6));
                }
            }
        }
        if (dependencyNode != widgetRun.end) {
            return j7;
        }
        long wrapDimension = j6 - widgetRun.getWrapDimension();
        return Math.min(Math.min(j7, traverseEnd(widgetRun.start, wrapDimension)), wrapDimension - widgetRun.start.margin);
    }

    private long traverseStart(DependencyNode dependencyNode, long j6) {
        WidgetRun widgetRun = dependencyNode.run;
        if (widgetRun instanceof HelperReferences) {
            return j6;
        }
        int size = dependencyNode.dependencies.size();
        long j7 = j6;
        for (int i6 = 0; i6 < size; i6++) {
            Dependency dependency = dependencyNode.dependencies.get(i6);
            if (dependency instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dependency;
                if (dependencyNode2.run != widgetRun) {
                    j7 = Math.max(j7, traverseStart(dependencyNode2, dependencyNode2.margin + j6));
                }
            }
        }
        if (dependencyNode != widgetRun.start) {
            return j7;
        }
        long wrapDimension = j6 + widgetRun.getWrapDimension();
        return Math.max(Math.max(j7, traverseStart(widgetRun.end, wrapDimension)), wrapDimension - widgetRun.end.margin);
    }

    public void add(WidgetRun widgetRun) {
        this.runs.add(widgetRun);
        this.lastRun = widgetRun;
    }

    public long computeWrapSize(ConstraintWidgetContainer constraintWidgetContainer, int i6) {
        long wrapDimension;
        int i7;
        WidgetRun widgetRun = this.firstRun;
        if (widgetRun instanceof ChainRun) {
            if (((ChainRun) widgetRun).orientation != i6) {
                return 0L;
            }
        } else if (i6 == 0) {
            if (!(widgetRun instanceof HorizontalWidgetRun)) {
                return 0L;
            }
        } else if (!(widgetRun instanceof VerticalWidgetRun)) {
            return 0L;
        }
        DependencyNode dependencyNode = (i6 == 0 ? constraintWidgetContainer.horizontalRun : constraintWidgetContainer.verticalRun).start;
        DependencyNode dependencyNode2 = (i6 == 0 ? constraintWidgetContainer.horizontalRun : constraintWidgetContainer.verticalRun).end;
        boolean contains = widgetRun.start.targets.contains(dependencyNode);
        boolean contains2 = this.firstRun.end.targets.contains(dependencyNode2);
        long wrapDimension2 = this.firstRun.getWrapDimension();
        if (contains && contains2) {
            long traverseStart = traverseStart(this.firstRun.start, 0L);
            long traverseEnd = traverseEnd(this.firstRun.end, 0L);
            long j6 = traverseStart - wrapDimension2;
            WidgetRun widgetRun2 = this.firstRun;
            int i8 = widgetRun2.end.margin;
            if (j6 >= (-i8)) {
                j6 += i8;
            }
            int i9 = widgetRun2.start.margin;
            long j7 = ((-traverseEnd) - wrapDimension2) - i9;
            if (j7 >= i9) {
                j7 -= i9;
            }
            float biasPercent = widgetRun2.widget.getBiasPercent(i6);
            float f6 = biasPercent > 0.0f ? (long) ((j7 / biasPercent) + (j6 / (1.0f - biasPercent))) : 0L;
            long j8 = ((long) ((f6 * biasPercent) + 0.5f)) + wrapDimension2 + ((long) ((f6 * (1.0f - biasPercent)) + 0.5f));
            wrapDimension = r13.start.margin + j8;
            i7 = this.firstRun.end.margin;
        } else {
            if (contains) {
                return Math.max(traverseStart(this.firstRun.start, r13.margin), this.firstRun.start.margin + wrapDimension2);
            }
            if (contains2) {
                return Math.max(-traverseEnd(this.firstRun.end, r13.margin), (-this.firstRun.end.margin) + wrapDimension2);
            }
            wrapDimension = r13.start.margin + this.firstRun.getWrapDimension();
            i7 = this.firstRun.end.margin;
        }
        return wrapDimension - i7;
    }

    public void defineTerminalWidgets(boolean z5, boolean z6) {
        if (z5) {
            WidgetRun widgetRun = this.firstRun;
            if (widgetRun instanceof HorizontalWidgetRun) {
                defineTerminalWidget(widgetRun, 0);
            }
        }
        if (z6) {
            WidgetRun widgetRun2 = this.firstRun;
            if (widgetRun2 instanceof VerticalWidgetRun) {
                defineTerminalWidget(widgetRun2, 1);
            }
        }
    }

    public RunGroup(WidgetRun widgetRun, int i6) {
        this.firstRun = null;
        this.lastRun = null;
        int i7 = index;
        this.groupIndex = i7;
        index = i7 + 1;
        this.firstRun = widgetRun;
        this.lastRun = widgetRun;
        this.direction = i6;
    }
}
