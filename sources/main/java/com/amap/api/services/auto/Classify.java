package com.amap.api.services.auto;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class Classify implements Parcelable {
    public static final Parcelable.Creator<Classify> CREATOR = new Parcelable.Creator<Classify>() { // from class: com.amap.api.services.auto.Classify.1
        private static Classify a(Parcel parcel) {
            return new Classify(parcel);
        }

        private static Classify[] a(int i6) {
            return new Classify[i6];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Classify createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Classify[] newArray(int i6) {
            return a(i6);
        }
    };
    public ItermData itermData;
    public RetainState retainState;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Category implements Parcelable {
        public static final Parcelable.Creator<Category> CREATOR = new Parcelable.Creator<Category>() { // from class: com.amap.api.services.auto.Classify.Category.1
            private static Category a(Parcel parcel) {
                return new Category(parcel);
            }

            private static Category[] a(int i6) {
                return new Category[i6];
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Category createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Category[] newArray(int i6) {
                return a(i6);
            }
        };
        public int checked;
        public String classifyItemType;
        public String componentType;
        public int defaultValue;
        public String img;
        public String name;
        public String params;
        public String showType;
        public String value;

        public Category() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        protected Category(Parcel parcel) {
            this.checked = parcel.readInt();
            this.componentType = parcel.readString();
            this.defaultValue = parcel.readInt();
            this.name = parcel.readString();
            this.params = parcel.readString();
            this.value = parcel.readString();
            this.classifyItemType = parcel.readString();
            this.img = parcel.readString();
            this.showType = parcel.readString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            parcel.writeInt(this.checked);
            parcel.writeString(this.componentType);
            parcel.writeInt(this.defaultValue);
            parcel.writeString(this.name);
            parcel.writeString(this.params);
            parcel.writeString(this.value);
            parcel.writeString(this.classifyItemType);
            parcel.writeString(this.img);
            parcel.writeString(this.showType);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class CheckedNode implements Parcelable {
        public static final Parcelable.Creator<CheckedNode> CREATOR = new Parcelable.Creator<CheckedNode>() { // from class: com.amap.api.services.auto.Classify.CheckedNode.1
            private static CheckedNode a(Parcel parcel) {
                return new CheckedNode(parcel);
            }

            private static CheckedNode[] a(int i6) {
                return new CheckedNode[i6];
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ CheckedNode createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ CheckedNode[] newArray(int i6) {
                return a(i6);
            }
        };
        public String id;
        public String name;
        public String value;

        public CheckedNode() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        protected CheckedNode(Parcel parcel) {
            this.id = parcel.readString();
            this.value = parcel.readString();
            this.name = parcel.readString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            parcel.writeString(this.id);
            parcel.writeString(this.value);
            parcel.writeString(this.name);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class CheckedValue implements Parcelable {
        public static final Parcelable.Creator<CheckedValue> CREATOR = new Parcelable.Creator<CheckedValue>() { // from class: com.amap.api.services.auto.Classify.CheckedValue.1
            private static CheckedValue a(Parcel parcel) {
                return new CheckedValue(parcel);
            }

            private static CheckedValue[] a(int i6) {
                return new CheckedValue[i6];
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ CheckedValue createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ CheckedValue[] newArray(int i6) {
                return a(i6);
            }
        };
        public String classifyV2Data;
        public String classifyV2Level2Data;
        public String classifyV2Level3Data;

        public CheckedValue() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        protected CheckedValue(Parcel parcel) {
            this.classifyV2Data = parcel.readString();
            this.classifyV2Level2Data = parcel.readString();
            this.classifyV2Level3Data = parcel.readString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            parcel.writeString(this.classifyV2Data);
            parcel.writeString(this.classifyV2Level2Data);
            parcel.writeString(this.classifyV2Level3Data);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Data implements Parcelable {
        public static final Parcelable.Creator<Data> CREATOR = new Parcelable.Creator<Data>() { // from class: com.amap.api.services.auto.Classify.Data.1
            private static Data a(Parcel parcel) {
                return new Data(parcel);
            }

            private static Data[] a(int i6) {
                return new Data[i6];
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Data createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Data[] newArray(int i6) {
                return a(i6);
            }
        };
        public List<DataCategory> categories;
        public int checked;
        public String classifyItemType;
        public int isCancelDefaultSelect;
        public int isNoBtn;
        public int multiSelect;
        public String name;
        public String params;
        public String separator;
        public String type;
        public int useCommonlyUsedConfig;
        public int useLocalConfig;
        public int useRemoteConfig;

        public Data() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        protected Data(Parcel parcel) {
            this.categories = parcel.createTypedArrayList(DataCategory.CREATOR);
            this.checked = parcel.readInt();
            this.classifyItemType = parcel.readString();
            this.isCancelDefaultSelect = parcel.readInt();
            this.isNoBtn = parcel.readInt();
            this.name = parcel.readString();
            this.params = parcel.readString();
            this.separator = parcel.readString();
            this.type = parcel.readString();
            this.useCommonlyUsedConfig = parcel.readInt();
            this.useLocalConfig = parcel.readInt();
            this.useRemoteConfig = parcel.readInt();
            this.multiSelect = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            parcel.writeTypedList(this.categories);
            parcel.writeInt(this.checked);
            parcel.writeString(this.classifyItemType);
            parcel.writeInt(this.isCancelDefaultSelect);
            parcel.writeInt(this.isNoBtn);
            parcel.writeString(this.name);
            parcel.writeString(this.params);
            parcel.writeString(this.separator);
            parcel.writeString(this.type);
            parcel.writeInt(this.useCommonlyUsedConfig);
            parcel.writeInt(this.useLocalConfig);
            parcel.writeInt(this.useRemoteConfig);
            parcel.writeInt(this.multiSelect);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class DataCategory implements Parcelable {
        public static final Parcelable.Creator<DataCategory> CREATOR = new Parcelable.Creator<DataCategory>() { // from class: com.amap.api.services.auto.Classify.DataCategory.1
            private static DataCategory a(Parcel parcel) {
                return new DataCategory(parcel);
            }

            private static DataCategory[] a(int i6) {
                return new DataCategory[i6];
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DataCategory createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DataCategory[] newArray(int i6) {
                return a(i6);
            }
        };
        public int areaSubwayMark;
        public List<Category> categories;
        public int checked;
        public String classifyItemType;
        public String componentType;
        public int defaultValue;
        public int hideTitle;
        public String img;
        public int maxShowNum;
        public int maxShowNumRow;
        public int multiSelect;
        public String name;
        public String params;
        public String showType;
        public String value;

        public DataCategory() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        protected DataCategory(Parcel parcel) {
            this.categories = parcel.createTypedArrayList(Category.CREATOR);
            this.checked = parcel.readInt();
            this.defaultValue = parcel.readInt();
            this.componentType = parcel.readString();
            this.name = parcel.readString();
            this.params = parcel.readString();
            this.areaSubwayMark = parcel.readInt();
            this.hideTitle = parcel.readInt();
            this.maxShowNum = parcel.readInt();
            this.maxShowNumRow = parcel.readInt();
            this.multiSelect = parcel.readInt();
            this.img = parcel.readString();
            this.showType = parcel.readString();
            this.value = parcel.readString();
            this.classifyItemType = parcel.readString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            parcel.writeTypedList(this.categories);
            parcel.writeInt(this.checked);
            parcel.writeInt(this.defaultValue);
            parcel.writeString(this.componentType);
            parcel.writeString(this.name);
            parcel.writeString(this.params);
            parcel.writeInt(this.areaSubwayMark);
            parcel.writeInt(this.hideTitle);
            parcel.writeInt(this.maxShowNum);
            parcel.writeInt(this.maxShowNumRow);
            parcel.writeInt(this.multiSelect);
            parcel.writeString(this.img);
            parcel.writeString(this.showType);
            parcel.writeString(this.value);
            parcel.writeString(this.classifyItemType);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class ItermData implements Parcelable {
        public static final Parcelable.Creator<ItermData> CREATOR = new Parcelable.Creator<ItermData>() { // from class: com.amap.api.services.auto.Classify.ItermData.1
            private static ItermData a(Parcel parcel) {
                return new ItermData(parcel);
            }

            private static ItermData[] a(int i6) {
                return new ItermData[i6];
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ ItermData createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ ItermData[] newArray(int i6) {
                return a(i6);
            }
        };
        public List<CheckedNode> checkedNodes;
        public CheckedValue checkedValue;
        public List<Data> datas;
        public List<Data> defaultPositionDatas;
        public List<Data> level2Datas;

        public ItermData() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        protected ItermData(Parcel parcel) {
            this.checkedNodes = parcel.createTypedArrayList(CheckedNode.CREATOR);
            this.checkedValue = (CheckedValue) parcel.readParcelable(CheckedValue.class.getClassLoader());
            Parcelable.Creator<Data> creator = Data.CREATOR;
            this.datas = parcel.createTypedArrayList(creator);
            this.defaultPositionDatas = parcel.createTypedArrayList(creator);
            this.level2Datas = parcel.createTypedArrayList(creator);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            parcel.writeTypedList(this.checkedNodes);
            parcel.writeParcelable(this.checkedValue, i6);
            parcel.writeTypedList(this.datas);
            parcel.writeTypedList(this.defaultPositionDatas);
            parcel.writeTypedList(this.level2Datas);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class RetainState implements Parcelable {
        public static final Parcelable.Creator<RetainState> CREATOR = new Parcelable.Creator<RetainState>() { // from class: com.amap.api.services.auto.Classify.RetainState.1
            private static RetainState a(Parcel parcel) {
                return new RetainState(parcel);
            }

            private static RetainState[] a(int i6) {
                return new RetainState[i6];
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ RetainState createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ RetainState[] newArray(int i6) {
                return a(i6);
            }
        };
        public String classifyBusinessType;
        public String classifyConf;
        public String classifyRetainLevel2;
        public String level2All;
        public String newClassifyCityadcode;
        public String newClassifyFlag;

        public RetainState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        protected RetainState(Parcel parcel) {
            this.classifyBusinessType = parcel.readString();
            this.classifyConf = parcel.readString();
            this.classifyRetainLevel2 = parcel.readString();
            this.level2All = parcel.readString();
            this.newClassifyCityadcode = parcel.readString();
            this.newClassifyFlag = parcel.readString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            parcel.writeString(this.classifyBusinessType);
            parcel.writeString(this.classifyConf);
            parcel.writeString(this.classifyRetainLevel2);
            parcel.writeString(this.level2All);
            parcel.writeString(this.newClassifyCityadcode);
            parcel.writeString(this.newClassifyFlag);
        }
    }

    public Classify() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected Classify(Parcel parcel) {
        this.itermData = (ItermData) parcel.readParcelable(ItermData.class.getClassLoader());
        this.retainState = (RetainState) parcel.readParcelable(RetainState.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeParcelable(this.itermData, i6);
        parcel.writeParcelable(this.retainState, i6);
    }
}
