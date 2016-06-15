package br.com.diegosilva.smarthome.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.diegosilva.smarthome.R;
import br.com.diegosilva.smarthome.api.CameraService;
import br.com.diegosilva.smarthome.api.SensorService;
import br.com.diegosilva.smarthome.api.ServiceFactory;
import br.com.diegosilva.smarthome.model.Camera;
import br.com.diegosilva.smarthome.model.Sensor;
import br.com.diegosilva.smarthome.ui.adapter.CameraAdapter;
import br.com.diegosilva.smarthome.ui.adapter.SensorAdapter;
import br.com.diegosilva.smarthome.utils.URLs;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class CameraFragment extends Fragment {


    private RecyclerView recyclerView;
    private CameraService cameraService =
            ServiceFactory.createRetrofitService(CameraService.class, URLs.endpoint());
    private CameraAdapter cameraAdapter;

    public CameraFragment() {
    }

    public static CameraFragment newInstance() {
        CameraFragment fragment = new CameraFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_camera, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            cameraAdapter = new CameraAdapter();
            recyclerView.setAdapter(cameraAdapter);
        }

        cameraService.getCameras().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Camera>() {
                    @Override
                    public final void onCompleted() {
                        // do nothing
                    }

                    @Override
                    public final void onError(Throwable e) {
                    }

                    @Override
                    public final void onNext(Camera response) {
                        cameraAdapter.addValue(response);
                    }
                });

        return view;
    }
}
