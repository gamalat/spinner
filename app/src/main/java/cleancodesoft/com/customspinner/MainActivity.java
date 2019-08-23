package cleancodesoft.com.customspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
Spinner customSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customSpinner=findViewById(R.id.customSpinner);
        //spinnerItemList for spinner
        ArrayList<CustomItems> customList = new ArrayList<>();
        customList.add(new CustomItems("Public", R.drawable.puplish_for_public_icon));
        customList.add(new CustomItems("Friends", R.drawable.puplich_for_friend_icon));
        customList.add(new CustomItems("Only me", R.drawable.ic_person_24_px));
        CustomAdapter customAdapter=new CustomAdapter(this,customList);
        if(customSpinner!=null){
            customSpinner.setAdapter(customAdapter);
            customSpinner.setOnItemSelectedListener( this);
        }


}

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        CustomItems items = (CustomItems) adapterView.getSelectedItem();
        Toast.makeText(this, items.getSpinnerText(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
