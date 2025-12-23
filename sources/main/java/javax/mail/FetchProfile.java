package javax.mail;

import java.util.Vector;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class FetchProfile {
    private Vector specials = null;
    private Vector headers = null;

    public void add(Item item) {
        if (this.specials == null) {
            this.specials = new Vector();
        }
        this.specials.addElement(item);
    }

    public boolean contains(Item item) {
        Vector vector = this.specials;
        return vector != null && vector.contains(item);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Item {
        private String name;
        public static final Item ENVELOPE = new Item("ENVELOPE");
        public static final Item CONTENT_INFO = new Item("CONTENT_INFO");
        public static final Item FLAGS = new Item("FLAGS");

        protected Item(String str) {
            this.name = str;
        }
    }

    public boolean contains(String str) {
        Vector vector = this.headers;
        return vector != null && vector.contains(str);
    }

    public String[] getHeaderNames() {
        Vector vector = this.headers;
        if (vector == null) {
            return new String[0];
        }
        String[] strArr = new String[vector.size()];
        this.headers.copyInto(strArr);
        return strArr;
    }

    public Item[] getItems() {
        Vector vector = this.specials;
        if (vector == null) {
            return new Item[0];
        }
        Item[] itemArr = new Item[vector.size()];
        this.specials.copyInto(itemArr);
        return itemArr;
    }

    public void add(String str) {
        if (this.headers == null) {
            this.headers = new Vector();
        }
        this.headers.addElement(str);
    }
}
