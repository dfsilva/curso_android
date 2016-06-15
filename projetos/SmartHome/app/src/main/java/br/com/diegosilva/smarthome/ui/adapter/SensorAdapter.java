package br.com.diegosilva.smarthome.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.com.diegosilva.smarthome.R;
import br.com.diegosilva.smarthome.model.Sensor;
import br.com.diegosilva.smarthome.ui.fragment.SensorFragment;

import java.util.ArrayList;
import java.util.List;


public class SensorAdapter extends RecyclerView.Adapter<SensorAdapter.ViewHolder> {

    private final List<Sensor> valores;
    private final SensorFragment.OnListFragmentInteractionListener mListener;

    public SensorAdapter(List<Sensor> items, SensorFragment.OnListFragmentInteractionListener listener) {
        valores = items;
        mListener = listener;
    }

    public SensorAdapter(SensorFragment.OnListFragmentInteractionListener listener) {
        valores = new ArrayList<>();
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_sensor, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = valores.get(position);
        holder.mIdView.setText(valores.get(position).getId().toString());
        holder.mContentView.setText(valores.get(position).getNome());

        holder.mView.setOnClickListener(v -> {
            if (null != mListener) {
                mListener.onListFragmentInteraction(holder.mItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return valores.size();
    }

    public void addValue(Sensor s){
        this.valores.add(s);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public Sensor mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.id);
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
