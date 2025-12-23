package com.bxkj.student.common.db;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class HomeMenuDB {
    private String iconResName;
    private int id;
    private String menuName;

    public String getIconResName() {
        return this.iconResName;
    }

    public int getId() {
        return this.id;
    }

    public String getMenuName() {
        return this.menuName;
    }

    public HomeMenuDB setIconResName(String iconResName) {
        this.iconResName = iconResName;
        return this;
    }

    public HomeMenuDB setId(int id) {
        this.id = id;
        return this;
    }

    public HomeMenuDB setMenuName(String menuName) {
        this.menuName = menuName;
        return this;
    }

    public String toString() {
        return "HomeMenuDB{id=" + this.id + ", iconResName='" + this.iconResName + "', menuName='" + this.menuName + "'}";
    }
}
