package br.com.diegosilva.smarthome.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.diegosilva.smarthome.R;
import br.com.diegosilva.smarthome.model.Camera;


public class CameraAdapter extends RecyclerView.Adapter<CameraAdapter.ViewHolder> {

    private List<Camera> valores;

    public CameraAdapter() {
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_sensor, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.camera = valores.get(position);
        holder.nome.setText(valores.get(position).getNome());
    }

    @Override
    public int getItemCount() {
        return valores.size();
    }

    public void addValue(Camera camera){
        this.valores.add(camera);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;

        public final ImageView imgCamera;
        public final TextView nome;
        public Camera camera;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            imgCamera = (ImageView) view.findViewById(R.id.imgSnapshot);
            nome = (TextView) view.findViewById(R.id.txNome);


        }

    }
}
