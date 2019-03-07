package dk.kugelberg.hoek_helper.view.android;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import dk.kugelberg.hoek_helper.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RowFragment extends Fragment {

    double x = Double.NaN;
    double vo = Double.NaN;
    double ve = Double.NaN;
    double domk = Double.NaN;
    EditText xEditText;
    EditText voEditText;
    EditText veEditText;
    EditText domkEditText;

    public RowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // xEditText = getView().findViewById(R.id.x_text_view);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_row, container, false);
    }

    public void initTextViews(){
        xEditText = (EditText) getView().findViewById(R.id.x_text_view);
        /*xEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0){
                    x = Integer.parseInt(s.toString());
                    beregn();
                } else{
                    x = Double.NaN;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });*/

        voEditText = (EditText) getView().findViewById(R.id.vo_text_view);
        /*voEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() > 0){
                    vo = Double.parseDouble(s.toString());
                    System.out.println(vo);
                    beregn();
                } else{
                    vo = Double.NaN;
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });*/

        veEditText = (EditText) getView().findViewById(R.id.ve_text_view);

        domkEditText = (EditText) getView().findViewById(R.id.domk_text_view);
    }

    public void beregn(){
        if(x != Double.NaN && vo != Double.NaN){
            domk = vo + x;
            domkEditText.setText(Double.toString(domk));
        }
    }





}