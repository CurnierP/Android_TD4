package com.pierrecurnier.android_td4_curnier;

        import android.os.Bundle;
        import android.support.annotation.Nullable;
        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;

/**
 * Created by rr612094 on 26/09/2016.
 */
public class TextFragment extends Fragment {

    TextView mTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_text, null);
        mTextView = (TextView) v.findViewById(R.id.textView);
        return v;
    }

    public void setValueTextView(String value){
        if(mTextView!=null){
            this.mTextView.setText(value);
        }
        else{
            System.out.println("_________________________Null Object Ref");
        }

    }
}
