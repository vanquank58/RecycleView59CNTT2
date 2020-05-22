package vn.edu.ntu.vanquan.recycleview59cntt2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import vn.edu.ntu.vanquan.contronler.ICartContronller;
import vn.edu.ntu.vanquan.model.Product;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvListMH;
    Adapter adapter ;
    List <Product>  listProduct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addView();
    }

    private void addView()
    {
        rvListMH = findViewById(R.id.rvMatHang);
        rvListMH.setLayoutManager(new LinearLayoutManager(this));
        ICartContronller contronller = (ICartContronller) getApplication();
        listProduct = contronller.getALlProduct();
        adapter = new Adapter(listProduct);
        rvListMH.setAdapter(adapter);
    }

    private class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtPrice,txtDesc;
        ImageView imvAddToCart;
        Product product;
        public ProductViewHolder(@NonNull View itemView) {

            super(itemView);
            txtName = this.itemView.findViewById(R.id.txtName);
            txtPrice = this.itemView.findViewById(R.id.txtPrice);
            txtDesc = this.itemView.findViewById(R.id.txtDesc);
            imvAddToCart = this.itemView.findViewById(R.id.imvAddToCart);

        }
        public void bind(Product p)
        {
            this.product = p;
            txtName.setText(p.getName());
            txtDesc.setText(p.getDesc());
            txtPrice.setText(new Integer(p.getPrice()).toString());

        }
    }

    private class Adapter extends RecyclerView.Adapter<ProductViewHolder>
    {
        List<Product> productList;

        public Adapter(List<Product> productList) {
            this.productList = productList;

        }

        @NonNull
        @Override
        public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.product,parent,false);
                    //LayoutInflater khai bao bởi các biên contex, chuyển file XML sang code để tưởng tác
            return new ProductViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
            holder.bind(productList.get(position));
        }

        @Override
        public int getItemCount() {
            return productList.size();
        }
    }
}
