package swu.xl.expandablelistview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

public class XLExpandableListView extends ExpandableListView {

    /**
     * 构造方法：Java代码初始化
     * @param context
     */
    public XLExpandableListView(Context context) {
        super(context);

        //初始化操作
        init();
    }

    /**
     * 构造方法：Xml代码初始化
     * @param context
     * @param attrs
     */
    public XLExpandableListView(Context context, AttributeSet attrs) {
        super(context, attrs);

        //初始化操作
        init();
    }

    /**
     * 初始化操作
     */
    private void init() {
        MyAdapter adapter = new MyAdapter();
        setAdapter(adapter);
    }

    /**
     * 自定义的适配器
     */
    class MyAdapter extends BaseExpandableListAdapter {

        //group的数量
        @Override
        public int getGroupCount() {
            return DataUtil.getGroups().size();
        }

        //某个group的item的数量
        @Override
        public int getChildrenCount(int groupPosition) {
            return DataUtil.getItems().get(groupPosition).size();
        }

        //某个group的数据
        @Override
        public Object getGroup(int groupPosition) {
            return DataUtil.getGroups().get(groupPosition);
        }

        //某个group的某个item的数据
        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return DataUtil.getItems().get(groupPosition).get(childPosition);
        }

        //group的id
        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        //item的id
        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        //刷新相关
        @Override
        public boolean hasStableIds() {
            return false;
        }

        //获取group的View
        @SuppressLint("InflateParams")
        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            if (convertView == null){
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.group_layout,null);
            }

            TextView group_name_view = convertView.findViewById(R.id.group_name);
            group_name_view.setText((String) getGroup(groupPosition));

            return convertView;
        }

        //获取item的View
        @SuppressLint("InflateParams")
        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            if (convertView == null){
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_layout,null);
            }

            TextView item_name_view = convertView.findViewById(R.id.item_name);
            item_name_view.setText((String) getChild(groupPosition,childPosition));

            return convertView;
        }

        //子项是否可选中
        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }
    }


}
