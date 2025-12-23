package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
class DimensionDependency extends DependencyNode {
    public int wrapValue;

    @Override // androidx.constraintlayout.solver.widgets.analyzer.DependencyNode
    public void resolve(int i6) {
        if (this.resolved) {
            return;
        }
        this.resolved = true;
        this.value = i6;
        for (Dependency dependency : this.dependencies) {
            dependency.update(dependency);
        }
    }

    public DimensionDependency(WidgetRun widgetRun) {
        super(widgetRun);
        if (widgetRun instanceof HorizontalWidgetRun) {
            this.type = DependencyNode.Type.HORIZONTAL_DIMENSION;
        } else {
            this.type = DependencyNode.Type.VERTICAL_DIMENSION;
        }
    }
}
