package com.rickdynasty.tws.core.apidemos.expandablelistview;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.rickdynasty.tws.burgeon.R;
import com.rickdynasty.tws.core.widget.ExpandableListView;
import com.rickdynasty.tws.core.widget.TwsExpandableListAdapter;

public class SimpleExpandableListActivity extends BaseExpandableListActivity 
	implements ExpandableListView.OnChildClickListener {
	
	private MyAdapter adapter;
	
	class MyAdapter extends TwsExpandableListAdapter {

		public MyAdapter(Context context, ExpandableListView listView) {
			super(context, listView);
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public boolean isChildSelectable(int groupPosition, int childPosition) {
			// TODO Auto-generated method stub
			if (groupPosition == 0) {
				return false;
			}
			else {
				return true;
			}
		}
		
		public void removeItem(int groupId, int childId) {
			children.get(groupId).remove(childId);
			setChildTitles(children);
			notifyDataSetChanged();
		}
	}
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.expandablelistview);
        ExpandableListView view = (ExpandableListView)findViewById(R.id.listView);
        
        adapter = new MyAdapter(this, view);
        adapter.setParentTitles(titles);
        adapter.setParentSubtitles(subTitles);
        adapter.setChildTitles(children);
        adapter.setChildInfos(children);
        
        // setParentTitleColor, setParentSubtitleColor, setChildTitleColor
        // 的参数为selector资源id
        // 不能直接设置颜色
//        adapter.setParentTitleColor(R.drawable.expandablelistview_parenttitle);
//        adapter.setParentSubtitleColor(R.drawable.expandablelistview_parentsubtitle);
//        adapter.setChildTitleColor(R.drawable.expandablelistview_childtitle);
        
        adapter.setChildIndicateVisible(false);
        
        view.setAdapter(adapter);
        view.setOnChildClickListener(this);
        
    }
	
	@Override
	public boolean onChildClick(ExpandableListView arg0, View arg1, int arg2,
			int arg3, long arg4) {
		// TODO Auto-generated method stub
		adapter.removeItem(arg2, arg3);
		return true;
	}
}
