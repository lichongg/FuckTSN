package xyz.adscope.common.v2.tool.collection;

import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class CollectionFetch {
    public static <ITEM, WHICH> ITEM[] fetchAllFromArray(ITEM[] itemArr, WHICH which, ICollectionFetchCompare<ITEM, WHICH> iCollectionFetchCompare) {
        if (itemArr == null || itemArr.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (ITEM item : itemArr) {
            if (item != null && iCollectionFetchCompare.fetch(item, which)) {
                arrayList.add(item);
            }
        }
        return (ITEM[]) arrayList.toArray(new Object[0]);
    }

    public static <ITEM, WHICH> List<ITEM> fetchAllFromList(List<ITEM> list, WHICH which, ICollectionFetchCompare<ITEM, WHICH> iCollectionFetchCompare) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < list.size(); i6++) {
            ITEM item = list.get(i6);
            if (item != null && iCollectionFetchCompare.fetch(item, which)) {
                arrayList.add(item);
            }
        }
        return arrayList;
    }

    public static <ITEM, WHICH> ITEM fetchFirstFromArray(ITEM[] itemArr, WHICH which, ICollectionFetchCompare<ITEM, WHICH> iCollectionFetchCompare) {
        if (itemArr == null) {
            return null;
        }
        for (ITEM item : itemArr) {
            if (item != null && iCollectionFetchCompare.fetch(item, which)) {
                return item;
            }
        }
        return null;
    }

    public static <ITEM, WHICH> ITEM fetchFirstFromList(List<ITEM> list, WHICH which, ICollectionFetchCompare<ITEM, WHICH> iCollectionFetchCompare) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        for (int i6 = 0; i6 < list.size(); i6++) {
            ITEM item = list.get(i6);
            if (item != null && iCollectionFetchCompare.fetch(item, which)) {
                return item;
            }
        }
        return null;
    }

    private CollectionFetch() {
    }

    public static <ITEM, WHICH> boolean matchFromArray(ITEM[] itemArr, WHICH which, ICollectionFetchCompare<ITEM, WHICH> iCollectionFetchCompare) {
        if (fetchFirstFromArray(itemArr, which, iCollectionFetchCompare) != null) {
            return true;
        }
        return false;
    }

    public static <ITEM, WHICH> boolean matchFromList(List<ITEM> list, WHICH which, ICollectionFetchCompare<ITEM, WHICH> iCollectionFetchCompare) {
        if (fetchFirstFromList(list, which, iCollectionFetchCompare) != null) {
            return true;
        }
        return false;
    }
}
