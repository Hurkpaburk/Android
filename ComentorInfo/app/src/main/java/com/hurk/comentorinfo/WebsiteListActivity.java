package com.hurk.comentorinfo;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * An activity representing a list of Websites. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link WebsiteDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 * <p/>
 * The activity makes heavy use of fragments. The list of items is a
 * {@link WebsiteListFragment} and the item details
 * (if present) is a {@link WebsiteDetailFragment}.
 * <p/>
 * This activity also implements the required
 * {@link WebsiteListFragment.Callbacks} interface
 * to listen for item selections.
 */
public class WebsiteListActivity extends AppCompatActivity
        implements WebsiteListFragment.Callbacks, OnMapReadyCallback {

    static final LatLng OFFICE = new LatLng(57.707240, 11.939818);
    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;
    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website_app_bar);

        if (findViewById(R.id.website_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-large and
            // res/values-sw600dp). If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
            // In two-pane mode, list items should be given the
            // 'activated' state when touched.
            ((WebsiteListFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.website_list))
                    .setActivateOnItemClick(true);
        }
    }

    /**
     * Callback method from {@link WebsiteListFragment.Callbacks}
     * indicating that the item with the given ID was selected.
     */
    @Override
    public void onItemSelected(String id) {

        if (mTwoPane) {
            // In two-pane mode, show the detail view in this activity by
            // adding or replacing the detail fragment using a
            // fragment transaction.

            Bundle arguments = new Bundle();

            if (id == WorkContent.COMENTORADDRESS) {

                SupportMapFragment mapFragment = new SupportMapFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.website_detail_container, mapFragment).commit();
                mapFragment.getMapAsync(this);
            } else if (id == WorkContent.ABOUT) {
                AboutFragment textFrag = new AboutFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.website_detail_container, textFrag).commit();
            } else {
                arguments.putString(WebsiteDetailFragment.ARG_ITEM_ID, id);
                WebsiteDetailFragment fragment = new WebsiteDetailFragment();
                fragment.setArguments(arguments);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.website_detail_container, fragment)
                        .commit();
            }
        } else {

            if (id == WorkContent.COMENTORADDRESS) {
                Intent mapIntent = new Intent(this, MapActivity.class);
                startActivity(mapIntent);
            } else if (id == WorkContent.ABOUT) {
                Intent aboutIntent = new Intent(this, AboutActivity.class);
                startActivity(aboutIntent);
            } else {
                // In single-pane mode, simply start the detail activity
                // for the selected item ID.
                Intent detailIntent = new Intent(this, WebsiteDetailActivity.class);
                detailIntent.putExtra(WebsiteDetailFragment.ARG_ITEM_ID, id);
                startActivity(detailIntent);
            }
        }
    }

    @Override
    public void onMapReady(GoogleMap map) {
        map.addMarker(new MarkerOptions().position(OFFICE).title("Comentor AB\nLindholmspiren 5A"));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(OFFICE, 17));
    }
}
