package testinc.chart_test;

import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

public class MainActivity extends AppCompatActivity {

    private GraphicalView mChart;
    private XYMultipleSeriesDataset mDataset = new XYMultipleSeriesDataset();
    private XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer();
    private XYSeries mCurrentSeries;
    private XYSeriesRenderer mCurrentRenderer;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void initChart() {
        mCurrentSeries = new XYSeries("Sample Data");
        mDataset.addSeries(mCurrentSeries);
        mCurrentSeries.add(1, 1);
        mCurrentSeries.add(2, 2);
        mCurrentSeries.add(3, 1);
        mCurrentSeries.add(4, 4);
        mCurrentSeries.add(5, 5);

        mCurrentRenderer = new XYSeriesRenderer();
        mCurrentRenderer.setLineWidth(4);//set line width to 4

        mRenderer.addSeriesRenderer(mCurrentRenderer);
        mRenderer.setShowGrid(true);//show grid
        mRenderer.setPanEnabled(false, false);//turn off pan
        mRenderer.setLabelsTextSize(25);// sets the labels text size
        mRenderer.setYLabelsAlign(Paint.Align.RIGHT);// fixes the yaxis labels
        mRenderer.setMarginsColor(Color.WHITE);// set the background color to white
        mRenderer.setYLabelsColor(0, Color.BLACK);// set y axis label color
        mRenderer.setXLabelsColor(Color.BLACK);// set the x axis label color

    }

    protected void onResume() {
        super.onResume();
        LinearLayout layout = findViewById(R.id.chart);
        if (mChart == null) {
            initChart();
            mChart = ChartFactory.getCubeLineChartView(this, mDataset, mRenderer,0);
            layout.addView(mChart);
        } else {
            mChart.repaint();
        }
    }
}
