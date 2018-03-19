package io.github.owuor91.faodb.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import io.github.owuor91.faodb.R;
import io.github.owuor91.faodb.sql.DbUtil;
import io.github.owuor91.faodb.sql.Farmer;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddFarmerFragment extends Fragment {
  EditText etFarmerName, etFarmerAge, etFarmerAcres, etFarmerLocation;
  Button btnAddFarmer;

  public AddFarmerFragment() {

  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.fragment_add_farmer, container, false);
    etFarmerName = (EditText) view.findViewById(R.id.etFarmerName);
    etFarmerAge = (EditText) view.findViewById(R.id.etFarmerAge);
    etFarmerAcres = (EditText) view.findViewById(R.id.etFarmerAcres);
    etFarmerLocation = (EditText) view.findViewById(R.id.etFarmerLocation);
    btnAddFarmer = (Button) view.findViewById(R.id.btnAddFarmer);
    return view;
  }

  @Override public void onResume() {
    super.onResume();
    btnAddFarmer.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        addFarmer(getValue(etFarmerName), Integer.parseInt(getValue(etFarmerAge)),
            Float.parseFloat(getValue(etFarmerAcres)), getValue(etFarmerLocation));
      }
    });
  }

  private void validateForm() {
    if (TextUtils.isEmpty(getValue(etFarmerName)) || TextUtils.isEmpty(getValue(etFarmerAge)) || TextUtils.isEmpty(
        getValue(etFarmerAcres)) || TextUtils.isEmpty(getValue(etFarmerLocation))) {
      Toast.makeText(getActivity().getBaseContext(), "Fill in all the fields", Toast.LENGTH_LONG).show();
      return;
    }
  }

  private String getValue(EditText editText) {
    return editText.getText().toString();
  }

  private void addFarmer(String name, int age, float acres, String location) {
    validateForm();
    Farmer farmer = new Farmer();
    farmer.setName(name);
    farmer.setAge(age);
    farmer.setAcres(acres);
    farmer.setLocation(location);

    DbUtil dbUtil = new DbUtil(getActivity().getBaseContext());
    dbUtil.addFarmer(farmer);

    Toast.makeText(getActivity().getBaseContext(), "Farmer Added Succesfully", Toast.LENGTH_SHORT).show();
    getFragmentManager().beginTransaction()
        .replace(R.id.fragmentContainer, new FarmersListFragment())
        .addToBackStack(null)
        .commit();
  }
}