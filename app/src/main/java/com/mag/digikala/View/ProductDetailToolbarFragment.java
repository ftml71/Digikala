package com.mag.digikala.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.mag.digikala.R;
import com.mag.digikala.ViewModel.ProductDetailToolbarViewModel;


public class ProductDetailToolbarFragment extends Fragment {

    private ProductDetailToolbarViewModel viewModel;

    private TextView cardNumber;

    public static ProductDetailToolbarFragment newInstance() {

        Bundle args = new Bundle();

        ProductDetailToolbarFragment fragment = new ProductDetailToolbarFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public ProductDetailToolbarFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = ViewModelProviders.of(this).get(ProductDetailToolbarViewModel.class);
        viewModel.loadData();
        viewModel.getNumberOfCardProducts().observe(this, numberOfCardProducts -> {
            cardNumber.setText(numberOfCardProducts.toString());
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_product_detail_toolbar, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        findComponents(view);

    }

    private void findComponents(@NonNull View view) {
        cardNumber = view.findViewById(R.id.product_detail_toolbar_fragment__card_number);
    }

}