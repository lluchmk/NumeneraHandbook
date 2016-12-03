package dam.lluchmk.numenerahandbook;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import dam.lluchmk.numenerahandbook2.R;

public class CustomArrayAdapter extends ArrayAdapter {
    public static final String ID_ITEM = "ID_ITEM";

    private final Context context;
    private final Object[] values;

    static class ViewHolder {
        public TextView text;
    }

    public CustomArrayAdapter(Context context, Object[] values) {
        super(context, -1, values);
        this.context = context;
        this.values = values;
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        if (rowView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.row_layout, parent, false);

            ViewHolder viewHolder = new ViewHolder();
            viewHolder.text = (TextView) rowView.findViewById(R.id.tvRowText);
            rowView.setTag(viewHolder);
        }

        ViewHolder holder = (ViewHolder) rowView.getTag();
        if (values[position] instanceof Cypher) {
            Cypher cypher = (Cypher)values[position];
            holder.text.setText(cypher.getName());
        }

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ItemActivity.class);
                if (values[position] instanceof Cypher) {
                    Cypher cypher = (Cypher)values[position];
                    intent.putExtra(ID_ITEM, cypher);
                    context.startActivity(intent);
                }
            }
        });

        return rowView;
    }
}
