package dam.lluchmk.numenerahandbook;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import dam.lluchmk.numenerahandbook2.R;


public class PageFragment extends Fragment {
    public static final int PAGE_CYPHERS = 0;

    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;

    public PageFragment() {
        // Required empty public constructor
    }

    public static PageFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        PageFragment fragment = new PageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_page, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListView lvItems = (ListView)getView().findViewById(R.id.lvItems);
        switch (mPage) {
            case PAGE_CYPHERS:
                final ArrayList<Cypher> cyphers = new ArrayList<>();
                String[] items = getActivity().getResources().getStringArray(R.array.cyphersArray);
                for (int i = 0; i < items.length; i++) {
                    Cypher cypher = new Cypher();
                    cypher.initializeFromItem(items[i]);
                    cyphers.add(cypher);
                }
                lvItems.setAdapter(new CustomArrayAdapter(getActivity(), cyphers.toArray()));
                break;
        }
    }
}
