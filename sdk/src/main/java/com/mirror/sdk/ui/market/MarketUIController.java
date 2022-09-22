package com.mirror.sdk.ui.market;

import android.view.View;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.mirror.sdk.ui.market.apis.responses.CollectionInfo;
import com.mirror.sdk.ui.market.widgets.ExpandButtonBase;
import com.mirror.sdk.ui.market.widgets.MarketMainFilterDetailRecyclerViewAdapter;
import com.mirror.sdk.ui.market.widgets.TabExpandButton;
import com.mirror.sdk.utils.MirrorGsonUtils;

public class MarketUIController {
    private static volatile MarketUIController instance;
    public static MarketUIController getInstance(){
        if (instance == null){
            synchronized(MarketUIController.class){
                instance = new MarketUIController();
            }
        }
        return instance;
    }

    //scroll collection tabs
    private RecyclerView mMainParent;
    public void setMainParent(RecyclerView view){
        mMainParent = view;
    }
    public void mainCollectionTabScrollTo(int position){
        if(mMainParent == null) return;
        mMainParent.scrollToPosition(position);
    }

    //
    private CollectionInfo mCurCollection;
    public void selectCollection(CollectionInfo collectionInfo){
        mCurCollection = collectionInfo;
    }
    public CollectionInfo getCurCollection(){
        return mCurCollection;
    }

    //current expand filter
    private TabExpandButton mCurTab;
    public void setCurTab(TabExpandButton curTab){
        mCurTab = curTab;
    }
    public TabExpandButton getCurTab(){
        return mCurTab;
    }

    //Main page event handle
    public RecyclerView mMainInnerRecycler;
    //Main filter detail
    public boolean IsFilterDetailExpanded;
    public ConstraintLayout FilterDetailLayout;
    private ExpandButtonBase ExpandingButton;
    public void expandFilterDetail(ExpandButtonBase button){
        IsFilterDetailExpanded = true;
        FilterDetailLayout.setVisibility(View.VISIBLE);
        ExpandingButton = button;
    }
    public void foldFilterDetail(boolean needFold){
        IsFilterDetailExpanded = false;
        FilterDetailLayout.setVisibility(View.GONE);
        if(needFold) ExpandingButton.fold();
        ExpandingButton = null;
    }
}
