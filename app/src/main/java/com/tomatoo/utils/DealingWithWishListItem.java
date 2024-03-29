package com.tomatoo.utils;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.tomatoo.Connection.ApiClient;
import com.tomatoo.Connection.ApiServiceInterface;
import com.tomatoo.Main.MainPageActivity;
import com.tomatoo.MenuActivities.WishList.WishlistAdapter;
import com.tomatoo.Models.DelOrAddWishlistModel;
import com.tomatoo.Models.FeaturedProductsModel;
import com.tomatoo.Models.WishListModel;
import com.tomatoo.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DealingWithWishListItem {

    private Context mcontext;


    public DealingWithWishListItem(Context mcontext) {
        this.mcontext = mcontext;
    }

    public void addWishListItem(final FeaturedProductsModel.ProductData item_model, final ProgressBar progressBar, final ImageView imageView) {
        progressBar.setVisibility(View.VISIBLE);
        ApiServiceInterface serviceInterface = ApiClient.getClient().create(ApiServiceInterface.class);
        Call<DelOrAddWishlistModel> call = serviceInterface.addToWishList(MainPageActivity.userData.getId(), item_model.getProduct_id(), MainPageActivity.userData.getToken());
        call.enqueue(new Callback<DelOrAddWishlistModel>() {
            @Override
            public void onResponse(Call<DelOrAddWishlistModel> call, Response<DelOrAddWishlistModel> response) {
                if (response.body().getStatus()) {
                    item_model.setWishlists(1);
                    imageView.setImageResource(R.drawable.wishlist_select);
                    Toast.makeText(mcontext, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                } else {
//                    item_model.setWishlists(1);
//                    imageView.setImageResource(R.drawable.wishlist_not_select);
                    Toast.makeText(mcontext, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<DelOrAddWishlistModel> call, Throwable t) {
                t.printStackTrace();
                progressBar.setVisibility(View.GONE);
            }
        });
    }


    public void deleteWishListItem(final List<WishListModel.WishlistItem> list, final WishlistAdapter adapter, final int position, final int id, String token, int productId, final ProgressBar progressBar) {

        Log.i("id: ", id + "");
        Log.i("token: ", token + "");
        Log.i("prod_id: ", productId + "");

        progressBar.setVisibility(View.VISIBLE);
        ApiServiceInterface serviceInterface = ApiClient.getClient().create(ApiServiceInterface.class);
        Call<DelOrAddWishlistModel> call = serviceInterface.deleteFromWishList(id, token, productId);
        call.enqueue(new Callback<DelOrAddWishlistModel>() {
            @Override
            public void onResponse(Call<DelOrAddWishlistModel> call, Response<DelOrAddWishlistModel> response) {
                if (response.body().getStatus()) {
                    removeItem(adapter, list, position);
                    Toast.makeText(mcontext, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(mcontext, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<DelOrAddWishlistModel> call, Throwable t) {
                t.printStackTrace();
                progressBar.setVisibility(View.GONE);
            }
        });
    }


    public void removeItem(WishlistAdapter adapter, List<WishListModel.WishlistItem> list, int position) {
        list.remove(position);
        adapter.notifyItemRemoved(position);
    }
}
