package dk.itu.mmad.hackme;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FirstPageFragment extends Fragment {

    private final String PASSWORD = "my_password";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View layout = inflater.inflate(R.layout.first_page, container, false);

        Button submit = (Button) layout.findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText passwordField = (EditText) layout.findViewById(R.id.password);
                String password = passwordField.getText().toString();
                if(PASSWORD.equals(password)) {
                    ((MainActivity)getActivity()).goToSecretArea();
                }
            }
        });


        return layout;
    }

}
