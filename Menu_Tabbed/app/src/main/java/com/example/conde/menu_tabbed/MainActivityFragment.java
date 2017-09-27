package com.example.conde.menu_tabbed;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import com.example.conde.menu_tabbed.R;
import com.example.conde.menu_tabbed.adapter.NumbersAdapter;
import com.example.conde.menu_tabbed.entity.Number;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    ArrayList<Number> numbers;
    private RecyclerView list;
    private Button btnGetSelected;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnGetSelected = (Button) view.findViewById(R.id.btnGetSelected);
        list = (RecyclerView) view.findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(getActivity()));
        list.setHasFixedSize(true);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        numbers = new ArrayList<>();
        String ONEs[] = { "MESA", "MESA", "MESA", "MESA", "MESA", "MESA", "MESA", "MESA", "MESA", "MESA",
                "MESA", "MESA", "THIRTEEN", "FOURTEEN", "FIFTEEN", "SIXTEEN", "SEVENTEEN", "EIGHTEEN", "NINETEEN", "TWENTY"};
        for (int i = 1; i <= 19; i++) {
            Number number = new Number();
            number.setONEs(i + "");
            number.setTextONEs(ONEs[i]);
            this.numbers.add(number);
        }
        NumbersAdapter adapter = new NumbersAdapter(this.numbers);
        list.setAdapter(adapter);

        btnGetSelected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder stringBuilder = new StringBuilder();
                for (Number number : numbers) {
                    if (number.isSelected()) {
                        if (stringBuilder.length() > 0)
                            stringBuilder.append(", ");
                        stringBuilder.append(number.getONEs());
                    }
                }
                Toast.makeText(getActivity(), stringBuilder.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
