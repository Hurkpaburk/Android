package com.hurk.comentorinfo;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

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
        implements WebsiteListFragment.Callbacks {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website_list);
        Log.d("TWO PANE", "BEFORE");

        if (findViewById(R.id.website_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-large and
            // res/values-sw600dp). If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
            Log.d("TWO PANE","TRUE");
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

        Log.d("id", id);
        if (mTwoPane) {
            // In two-pane mode, show the detail view in this activity by
            // adding or replacing the detail fragment using a
            // fragment transaction.

            Bundle arguments = new Bundle();

            if (id == WorkContent.COMENTORADDRESS) {
                Fragment mapFragment = new Fragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.map_fragment, mapFragment).commit();
            }
            else {
                arguments.putString(WebsiteDetailFragment.ARG_ITEM_ID, id);
                WebsiteDetailFragment fragment = new WebsiteDetailFragment();
                fragment.setArguments(arguments);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.website_detail_container, fragment)
                        .commit();
            }
        } else {

            if (id == WorkContent.COMENTORADDRESS) {
                Intent mapIntent = new Intent(this, MapFragment.class);
                startActivity(mapIntent);
            } else {
                // In single-pane mode, simply start the detail activity
                // for the selected item ID.
                Intent detailIntent = new Intent(this, WebsiteDetailActivity.class);
                detailIntent.putExtra(WebsiteDetailFragment.ARG_ITEM_ID, id);
                startActivity(detailIntent);
            }
        }
    }
}
