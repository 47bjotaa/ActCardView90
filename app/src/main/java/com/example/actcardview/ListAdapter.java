package com.example.actcardview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<ListadoDeElementos> mData;
    private LayoutInflater mInflater;

    public ListAdapter(List<ListadoDeElementos> itemList, Context context) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = itemList;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.listado, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, int position) {
        holder.bindData(mData.get(position));
    }

    public void setItems(List<ListadoDeElementos> items) {
        mData = items;
        notifyDataSetChanged(); // Notificar cambios para actualizar la vista
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iconImage;
        TextView nombre, ciudad, descripcion;

        ViewHolder(View itemView) {
            super(itemView);
            iconImage = itemView.findViewById(R.id.IconImageView);
            nombre = itemView.findViewById(R.id.SantoTomas);
            ciudad = itemView.findViewById(R.id.LaSerena);
            descripcion = itemView.findViewById(R.id.statusTextView);
        }

        void bindData(ListadoDeElementos item) {
            iconImage.setImageResource(item.getImageResId()); // Asigna la imagen correspondiente
            iconImage.setColorFilter(Color.parseColor(item.getColor()), PorterDuff.Mode.SRC_IN);
            nombre.setText(item.getNombre());
            ciudad.setText(item.getCiudad());
            descripcion.setText(item.getDescripcion());

            // Cambiar el fondo del item programáticamente
            itemView.setBackgroundColor(Color.parseColor("#d2e8ff")); // Establece el color de fondo
        }
    }
}