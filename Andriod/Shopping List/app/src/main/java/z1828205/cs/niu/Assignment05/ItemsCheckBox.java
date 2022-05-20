package z1828205.cs.niu.Assignment05;

import android.content.Context;
import android.support.v7.widget.AppCompatCheckBox;

public class ItemsCheckBox extends AppCompatCheckBox {
    private Item item;
    public ItemsCheckBox(Context context, Item newItem)
    {
        super(context);
        item = newItem;

    }
}
