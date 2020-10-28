package com.chimemoo.fooddeliveryapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chimemoo.fooddeliveryapp.R;
import com.chimemoo.fooddeliveryapp.adapter.ListMainProductAdapter;
import com.chimemoo.fooddeliveryapp.data.ProductData;
import com.chimemoo.fooddeliveryapp.model.ProductModel;

import java.util.ArrayList;

public class MainProductFragment extends Fragment {

    private ArrayList<ProductModel> list = new ArrayList<>();
    private RecyclerView rvProduct;
    private View mView;

    public MainProductFragment(String foodType) {
        if(foodType.equals("All")){
            list.addAll(ProductData.getListData());
        } else {
            list.addAll(ProductData.getFilteredListData(foodType));
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_main_product, container, false);
        rvProduct = (RecyclerView) mView.findViewById(R.id.rv_main_product);
        ListMainProductAdapter listMainProductAdapter = new ListMainProductAdapter(list);


        rvProduct.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        rvProduct.setHasFixedSize(true);

        rvProduct.setAdapter(listMainProductAdapter);
        return mView;
    }

}
