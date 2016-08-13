package com.taichitiger.client.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;

import com.taichitiger.client.R;
import com.xycode.xylibrary.base.BaseItemView;

/**
 * Created by XY on 2016-07-29.
 */
public class ViewItem extends BaseItemView {

    public ViewItem(Context context) {
        super(context, null);
    }

    public ViewItem(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        switch (itemType) {
            case 0:
                setText(R.id.etAmount, String.valueOf(itemCount));
                final EditText editText = getView(R.id.etAmount);
                OnClickListener clickListener = new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String text = editText.getText().toString();
                        int count = 0;
                        try {
                            count = Integer.parseInt(text);
                        } catch (NumberFormatException e) {
                        }
                        switch (view.getId()) {
                            case R.id.tvPlus:
                                itemCount = ++count;
                                editText.setText(String.valueOf(itemCount));
                                break;
                            case R.id.tvMinus:
                                itemCount = (count < 1 ? 0 : --count);
                                editText.setText(String.valueOf(itemCount));
                                break;
                            default:
                                break;
                        }
                    }
                };
                setClick(R.id.tvPlus, clickListener);
                setClick(R.id.tvMinus, clickListener);
                editText.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void afterTextChanged(Editable editable) {
                        if (editable.toString().isEmpty()) {
                            itemCount = 0;
                            editText.setText(String.valueOf(itemCount));
                        }
                    }
                });
                break;
            default:
                break;
        }
    }

    @Override
    protected int getLayoutId() {
        switch (itemType) {
            case 0:
                return R.layout.view_item_count;
            default:
                return R.layout.layout_blank;
        }
    }

    public int getItemCount() {
        return itemCount;
    }

}
