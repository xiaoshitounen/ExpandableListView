package swu.xl.expandablelistview;

import java.util.ArrayList;
import java.util.List;

public class DataUtil {
    /**
     * 获取组数据
     * @return
     */
    public static List<String> getGroups(){
        //group数据
        List<String> groups = new ArrayList<>();

        //加入数据
        groups.add("我的家人");
        groups.add("我的朋友");
        groups.add("黑名单");

        return groups;
    }

    /**
     * 获取每一项数据
     * @return
     */
    public static List<List<String>> getItems(){
        //item数据
        List<List<String>> items = new ArrayList<>();

        //加入数据
        List<String> group_1_item = new ArrayList<>();
        group_1_item.add("爸爸");
        group_1_item.add("妈妈");
        group_1_item.add("哥哥");
        items.add(group_1_item);
        List<String> group_2_item = new ArrayList<>();
        group_2_item.add("张三");
        group_2_item.add("李四");
        group_2_item.add("王二麻");
        items.add(group_2_item);
        List<String> group_3_item = new ArrayList<>();
        group_3_item.add("卖茶叶");
        group_3_item.add("微商");
        group_3_item.add("盗号");
        items.add(group_3_item);

        return items;
    }
}
