package com.taichitiger.client.view;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.util.AttributeSet;
import android.widget.TextView;

import com.taichitiger.client.R;
import com.xycode.xylibrary.base.BaseItemView;

/**
 * Created by XY on 2016-07-29.
 */
public class ListItem extends BaseItemView {

    public ListItem(Context context) {
        super(context, null);
    }

    public ListItem(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        switch (itemType) {
            case 0:
            case 3:
                if (itemIcon != 0) setImageRes(R.id.ivIcon, itemIcon);
                break;
            case 4:
                if (itemIcon != 0) setImageRes(R.id.ivIcon, itemIcon);
                if (itemColor != 0)
                    ((TextView) getView(R.id.tvContent)).setTextColor(getResources().getColor(itemColor));
                setText(R.id.tvContent, itemContent);
                break;
            case 2:
                if (itemIcon != 0) setImageRes(R.id.ivIcon, itemIcon);
                setText(R.id.tvContent, itemContent);
                setText(R.id.tvDetail, itemDetail);
                setVisibilility(R.id.ivIcon, itemVisible);
                break;
            default:
                setText(R.id.tvContent, itemContent);
                break;
        }
        setText(R.id.tvName, itemName);
    }

    @Override
    protected int getLayoutId() {
        @LayoutRes int layout;
        switch (itemType) {
            case 0:
                layout = R.layout.list_item_icon_text;
                break;
            case 2:
                layout = R.layout.list_item_icon_text_small;
                break;
            case 3:
                layout = R.layout.list_item_icon_text_up_down;
                break;
            case 4:
                layout = R.layout.list_item_icon_money;
                break;
            default:
                layout = R.layout.list_item_text_img;
                break;
        }
        return layout;
    }


}
