package co.anandsun.roomdemo.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import co.anandsun.roomdemo.Product;
import co.anandsun.roomdemo.R;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ViewHolder> {
    private int productItemLayout;
    private List<Product> productList;

    public ProductListAdapter(int layoutId)
    {
        productItemLayout = layoutId;
    }

    public void setProductList(List<Product> products)
    {
        productList = products;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(productItemLayout, parent, false);
        ViewHolder myViewHolder = new ViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductListAdapter.ViewHolder holder, int position) {
        TextView item = holder.item;
        item.setText(productList.get(position).getName() + "  " + productList.get(position).getQuantity());
    }

    @Override
    public int getItemCount() {
        return productList == null ? 0: productList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView item;
        ViewHolder(View itemView){
            super(itemView);
            item = itemView.findViewById(R.id.product_row);
        }
    }
}
