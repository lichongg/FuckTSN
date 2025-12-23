package org.apache.harmony.awt.datatransfer;

import java.awt.Point;
import java.awt.dnd.DragSourceContext;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DragSourceEventProxy implements Runnable {
    public static final int DRAG_ACTION_CHANGED = 3;
    public static final int DRAG_DROP_END = 6;
    public static final int DRAG_ENTER = 1;
    public static final int DRAG_EXIT = 5;
    public static final int DRAG_MOUSE_MOVED = 4;
    public static final int DRAG_OVER = 2;
    private final DragSourceContext context;
    private final int modifiers;
    private final boolean success;
    private final int targetActions;
    private final int type;
    private final int userAction;

    /* renamed from: x, reason: collision with root package name */
    private final int f51275x;

    /* renamed from: y, reason: collision with root package name */
    private final int f51276y;

    public DragSourceEventProxy(DragSourceContext dragSourceContext, int i6, int i7, int i8, Point point, int i9) {
        this.context = dragSourceContext;
        this.type = i6;
        this.userAction = i7;
        this.targetActions = i8;
        this.f51275x = point.x;
        this.f51276y = point.y;
        this.modifiers = i9;
        this.success = false;
    }

    private DragSourceDragEvent newDragSourceDragEvent() {
        return new DragSourceDragEvent(this.context, this.userAction, this.targetActions, this.modifiers, this.f51275x, this.f51276y);
    }

    @Override // java.lang.Runnable
    public void run() {
        switch (this.type) {
            case 1:
                this.context.dragEnter(newDragSourceDragEvent());
                break;
            case 2:
                this.context.dragOver(newDragSourceDragEvent());
                break;
            case 3:
                this.context.dropActionChanged(newDragSourceDragEvent());
                break;
            case 4:
                this.context.dragMouseMoved(newDragSourceDragEvent());
                break;
            case 5:
                this.context.dragExit(new DragSourceEvent(this.context, this.f51275x, this.f51276y));
                break;
            case 6:
                this.context.dragExit(new DragSourceDropEvent(this.context, this.userAction, this.success, this.f51275x, this.f51276y));
                break;
        }
    }

    public DragSourceEventProxy(DragSourceContext dragSourceContext, int i6, int i7, boolean z5, Point point, int i8) {
        this.context = dragSourceContext;
        this.type = i6;
        this.userAction = i7;
        this.targetActions = i7;
        this.f51275x = point.x;
        this.f51276y = point.y;
        this.modifiers = i8;
        this.success = z5;
    }
}
