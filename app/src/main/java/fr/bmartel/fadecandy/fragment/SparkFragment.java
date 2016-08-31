package fr.bmartel.fadecandy.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.larswerkman.holocolorpicker.ColorPicker;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

import fr.bmartel.fadecandy.FadecandySingleton;
import fr.bmartel.fadecandy.R;

/**
 * Created by akinaru on 31/08/16.
 */
public class SparkFragment extends android.support.v4.app.Fragment implements ColorPicker.OnColorChangedListener {

    private FadecandySingleton mSingleton;

    private final static String TAG = FullColorFragment.class.getSimpleName();

    public SparkFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.spark_fragment, container, false);

        mSingleton = FadecandySingleton.getInstance(getActivity().getApplicationContext());

        //init color picker
        ColorPicker picker = (ColorPicker) view.findViewById(R.id.picker);
        picker.setOnColorChangedListener(this);
        picker.setShowOldCenterColor(false);

        DiscreteSeekBar discreteSeekBar = (DiscreteSeekBar) view.findViewById(R.id.seekbar_brightness);

        discreteSeekBar.setNumericTransformer(new DiscreteSeekBar.NumericTransformer() {
            @Override
            public int transform(int value) {
                return value * 1;
            }
        });

        discreteSeekBar.setOnProgressChangeListener(new DiscreteSeekBar.OnProgressChangeListener() {

            @Override
            public void onProgressChanged(DiscreteSeekBar seekBar, int value, boolean fromUser) {
            }

            @Override
            public void onStartTrackingTouch(DiscreteSeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(DiscreteSeekBar seekBar) {

            }
        });

        DiscreteSeekBar speedSeekbar = (DiscreteSeekBar) view.findViewById(R.id.seekbar_speed);

        speedSeekbar.setNumericTransformer(new DiscreteSeekBar.NumericTransformer() {
            @Override
            public int transform(int value) {
                return value * 1;
            }
        });

        speedSeekbar.setOnProgressChangeListener(new DiscreteSeekBar.OnProgressChangeListener() {

            @Override
            public void onProgressChanged(DiscreteSeekBar seekBar, int value, boolean fromUser) {
            }

            @Override
            public void onStartTrackingTouch(DiscreteSeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(DiscreteSeekBar seekBar) {

            }
        });

        return view;
    }

    @Override
    public void onColorChanged(int color) {

        Log.i(TAG, "color changed : " + Color.red(color) + " - " + Color.green(color) + " - " + Color.blue(color));

        mSingleton.setFullColor(color);
    }

}
