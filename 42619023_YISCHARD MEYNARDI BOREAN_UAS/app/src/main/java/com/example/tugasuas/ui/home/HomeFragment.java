package com.example.tugasuas.ui.home;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ShareCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.example.tugasuas.R;
import com.example.tugasuas.databinding.FragmentHomeBinding;

import static androidx.core.content.ContextCompat.checkSelfPermission;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    public static final String EXTRA_MESSAGE = "com.google.android.intent.extra.MESSAGE";
    private static final int PERMISSIONS_REQUEST_PHONE_CALL = 1;
    EditText mWebsiteEditText, mNumber,mShareTextEditText, mMapEditText;
    Button btnLoc, btnWeb,btnShare, send,mMapButton,mShareTextButton;
    public static final int TEXT_REQUEST = 1;



    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        mWebsiteEditText = view.findViewById(R.id.EtWeb);
        mMapEditText = (EditText) view.findViewById(R.id.map_edittext);
        mMapButton = view.findViewById(R.id.map_button);
//        mNumber = (EditText) view.findViewById(R.id.EtLoc);
        mShareTextEditText = (EditText) view.findViewById(R.id.EtText);
        btnWeb = view.findViewById(R.id.openWeb);
//        btnLoc = view.findViewById(R.id.openLoc);
//        btnShare = view.findViewById(R.id.shareText);
//        send = view.findViewById(R.id.send);
        mShareTextButton = view.findViewById(R.id.shareText);

//        btnShare.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String txt = mShareTextEditText.getText().toString();
//                String mimeType = "text/plain";
//                ShareCompat.IntentBuilder
//                        .from(getActivity())
//                        .setType(mimeType)
//                        .setChooserTitle("Share this text with: ")
//                        .setText(txt)
//                        .startChooser();
//            }
//        });

        mMapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = mMapEditText.getText().toString();
                Uri gmmIntentUri = Uri.parse(url);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

        mShareTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt = mShareTextEditText.getText().toString();
                String mimeType = "text/plain";
                ShareCompat.IntentBuilder
                        .from(getActivity())
                        .setType(mimeType)
                        .setChooserTitle("Share this text with: ")
                        .setText(txt)
                        .startChooser();
            }
        });

        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = mWebsiteEditText.getText().toString();
                Uri webpage = Uri.parse(url);

                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                if (intent.resolveActivity(getActivity().getPackageManager()) != null){
                    startActivity(intent);
                }else {
                    Log.d("Implicit Intents", "Cant't handle this!");
                }
            }

        });

        return view;
    }



}