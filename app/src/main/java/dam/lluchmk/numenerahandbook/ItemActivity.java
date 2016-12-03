package dam.lluchmk.numenerahandbook;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import dam.lluchmk.numenerahandbook2.R;

public class ItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        setData();
    }

    private void setData() {
        Class itemClass = getIntent().getParcelableExtra(CustomArrayAdapter.ID_ITEM).getClass();
        if (itemClass == Cypher.class) {
            Cypher cypher = getIntent().getParcelableExtra(CustomArrayAdapter.ID_ITEM);
            ((TextView) findViewById(R.id.cypherName)).setText(cypher.getName());
            ((TextView) findViewById(R.id.cypherLevel)).setText(cypher.getLevel());
            TextView tvWearable = (TextView)findViewById(R.id.tvWearable);
            TextView cypherWearable = (TextView)findViewById(R.id.cypherWearable);
            if (cypher.getWearable() != null) {
                cypherWearable.setText(cypher.getWearable());
            } else  {
                tvWearable.setVisibility(ConstraintLayout.GONE);
                cypherWearable.setVisibility(ConstraintLayout.GONE);
            }
            TextView tvUsable = (TextView)findViewById(R.id.tvUsable);
            TextView cypherUsable = (TextView)findViewById(R.id.cypherUsable);
            if (cypher.getUsable() != null) {
                cypherUsable.setText(cypher.getUsable());
            }else  {
                tvUsable.setVisibility(ConstraintLayout.GONE);
                cypherUsable.setVisibility(ConstraintLayout.GONE);
            }
            TextView tvInternal = (TextView)findViewById(R.id.tvInternal);
            TextView cypherInternal = (TextView)findViewById(R.id.cypherInternal);
            if (cypher.getInternal() != null) {
                cypherInternal.setText(cypher.getInternal());
            }else  {
                tvInternal.setVisibility(ConstraintLayout.GONE);
                cypherInternal.setVisibility(ConstraintLayout.GONE);
            }
            ((TextView) findViewById(R.id.cypherEffect)).setText(cypher.getEffect());
            //TODO - set the type image
            switch (cypher.getType()) {
                case "anoetic":
                    break;
                case "occultic":
                    break;
            }
        }
    }
}
