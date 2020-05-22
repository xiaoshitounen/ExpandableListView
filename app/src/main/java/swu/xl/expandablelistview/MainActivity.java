package swu.xl.expandablelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        XLExpandableListView listView = findViewById(R.id.expand_list_view);

        //group的点击监听
        listView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                Toast.makeText(MainActivity.this, DataUtil.getGroups().get(groupPosition)+"被点击了", Toast.LENGTH_SHORT).show();
                
                return false;
            }
        });

        //item的点击监听
        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(MainActivity.this, DataUtil.getItems().get(groupPosition).get(childPosition)+"被点击了", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }
}
