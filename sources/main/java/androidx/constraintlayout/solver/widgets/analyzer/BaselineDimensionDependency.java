package androidx.constraintlayout.solver.widgets.analyzer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
class BaselineDimensionDependency extends DimensionDependency {
    public void update(DependencyNode dependencyNode) {
        WidgetRun widgetRun = this.run;
        ((VerticalWidgetRun) widgetRun).baseline.margin = widgetRun.widget.getBaselineDistance();
        this.resolved = true;
    }

    public BaselineDimensionDependency(WidgetRun widgetRun) {
        super(widgetRun);
    }
}
