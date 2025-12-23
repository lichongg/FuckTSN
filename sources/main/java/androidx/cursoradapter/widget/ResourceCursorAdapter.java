package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class ResourceCursorAdapter extends CursorAdapter {
    private int mDropDownLayout;
    private LayoutInflater mInflater;
    private int mLayout;

    @Deprecated
    public ResourceCursorAdapter(Context context, int i6, Cursor cursor) {
        super(context, cursor);
        this.mDropDownLayout = i6;
        this.mLayout = i6;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public View newDropDownView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.mInflater.inflate(this.mDropDownLayout, viewGroup, false);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.mInflater.inflate(this.mLayout, viewGroup, false);
    }

    public void setDropDownViewResource(int i6) {
        this.mDropDownLayout = i6;
    }

    public void setViewResource(int i6) {
        this.mLayout = i6;
    }

    @Deprecated
    public ResourceCursorAdapter(Context context, int i6, Cursor cursor, boolean z5) {
        super(context, cursor, z5);
        this.mDropDownLayout = i6;
        this.mLayout = i6;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public ResourceCursorAdapter(Context context, int i6, Cursor cursor, int i7) {
        super(context, cursor, i7);
        this.mDropDownLayout = i6;
        this.mLayout = i6;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
    }
}
