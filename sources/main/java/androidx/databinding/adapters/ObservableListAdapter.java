package androidx.databinding.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.databinding.ObservableList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: D:\Downloads\app\classes.dex */
class ObservableListAdapter<T> extends BaseAdapter {
    private final Context mContext;
    private final int mDropDownResourceId;
    private final LayoutInflater mLayoutInflater;
    private List<T> mList;
    private ObservableList.OnListChangedCallback mListChangedCallback;
    private final int mResourceId;
    private final int mTextViewResourceId;

    @Override // android.widget.Adapter
    public long getItemId(int i6) {
        return i6;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mList.size();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i6, View view, ViewGroup viewGroup) {
        return getViewForResource(this.mDropDownResourceId, i6, view, viewGroup);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i6) {
        return this.mList.get(i6);
    }

    @Override // android.widget.Adapter
    public View getView(int i6, View view, ViewGroup viewGroup) {
        return getViewForResource(this.mResourceId, i6, view, viewGroup);
    }

    public View getViewForResource(int i6, int i7, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = i6 == 0 ? new TextView(this.mContext) : this.mLayoutInflater.inflate(i6, viewGroup, false);
        }
        int i8 = this.mTextViewResourceId;
        TextView textView = (TextView) (i8 == 0 ? view : view.findViewById(i8));
        T t5 = this.mList.get(i7);
        textView.setText(t5 instanceof CharSequence ? (CharSequence) t5 : String.valueOf(t5));
        return view;
    }

    public void setList(List<T> list) {
        List<T> list2 = this.mList;
        if (list2 == list) {
            return;
        }
        if (list2 instanceof ObservableList) {
            ((ObservableList) list2).removeOnListChangedCallback(this.mListChangedCallback);
        }
        this.mList = list;
        if (list instanceof ObservableList) {
            if (this.mListChangedCallback == null) {
                this.mListChangedCallback = new ObservableList.OnListChangedCallback() { // from class: androidx.databinding.adapters.ObservableListAdapter.1
                    @Override // androidx.databinding.ObservableList.OnListChangedCallback
                    public void onChanged(ObservableList observableList) {
                        ObservableListAdapter.this.notifyDataSetChanged();
                    }

                    @Override // androidx.databinding.ObservableList.OnListChangedCallback
                    public void onItemRangeChanged(ObservableList observableList, int i6, int i7) {
                        ObservableListAdapter.this.notifyDataSetChanged();
                    }

                    @Override // androidx.databinding.ObservableList.OnListChangedCallback
                    public void onItemRangeInserted(ObservableList observableList, int i6, int i7) {
                        ObservableListAdapter.this.notifyDataSetChanged();
                    }

                    @Override // androidx.databinding.ObservableList.OnListChangedCallback
                    public void onItemRangeMoved(ObservableList observableList, int i6, int i7, int i8) {
                        ObservableListAdapter.this.notifyDataSetChanged();
                    }

                    @Override // androidx.databinding.ObservableList.OnListChangedCallback
                    public void onItemRangeRemoved(ObservableList observableList, int i6, int i7) {
                        ObservableListAdapter.this.notifyDataSetChanged();
                    }
                };
            }
            ((ObservableList) this.mList).addOnListChangedCallback(this.mListChangedCallback);
        }
        notifyDataSetChanged();
    }

    public ObservableListAdapter(Context context, List<T> list, int i6, int i7, int i8) {
        LayoutInflater layoutInflater;
        this.mContext = context;
        this.mResourceId = i6;
        this.mDropDownResourceId = i7;
        this.mTextViewResourceId = i8;
        if (i6 == 0) {
            layoutInflater = null;
        } else {
            layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        }
        this.mLayoutInflater = layoutInflater;
        setList(list);
    }
}
