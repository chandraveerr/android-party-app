package com.example.cv;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.ImageLoader.ImageContainer;
import com.android.volley.toolbox.NetworkImageView;
import com.example.cv.entity.InventoryDetail;
import com.example.cv.entity.InventoryWrapper;
import com.google.gson.Gson;

public class MainActivity extends Activity{
	
	private RequestQueue mVolleyQueue;
	private InventoryWrapper mInventoryWrapper;
	private List<InventoryDetail> usedCarDataList=null;
	private ListView mListView=null;
	private EfficientAdapter mEfficientAdapter=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
//		mVolleyQueue = Volley.newRequestQueue(this);
		setContentView(R.layout.main);
		ListView mListView  = (ListView) findViewById(R.id.listView1);
		mEfficientAdapter = new EfficientAdapter(getApplicationContext());
		mListView.setAdapter(mEfficientAdapter);
		makepostJsonReq();
	}

	private void makepostJsonReq() {
		// TODO Auto-generated method stub
		String tag_json_obj = "json_obj_req";
		 
		String url = "";
		         
		final ProgressDialog pDialog = new ProgressDialog(this);
		pDialog.setMessage("Loading...");
		pDialog.show();     
		         
		        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Method.POST,
		                url, null,
		                new Response.Listener<JSONObject>() {
		 
		                    @Override
		                    public void onResponse(JSONObject response) {
//		                        Log.d(TAG, response.toString());
		                    	Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_LONG).show();
		                    	makeDataModel(response);
		                        pDialog.hide();
		                    }
		                }, new Response.ErrorListener() {
		 
		                    @Override
		                    public void onErrorResponse(VolleyError error) {
//		                        VolleyLog.d(TAG, "Error: " + error.getMessage());
		                        pDialog.hide();
		                    }
		                }) {
		 
		            @Override
		            protected Map<String, String> getParams() {
		                Map<String, String> params = new HashMap<String, String>();
		              /*  params.put("name", "Androidhive");
		                params.put("email", "abc@androidhive.info");
		                params.put("password", "password123");*/
		 
		                return params;
		            }
		 
		        };
		 
		// Adding request to request queue
	    jsonObjReq.setRetryPolicy(new DefaultRetryPolicy(5000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));	
		AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);
	}

	private void makegetJsonReq() {
		// TODO Auto-generated method stub
		// Tag used to cancel the request
		String tag_json_obj = "json_obj_req";
		 
		String url = "http://api.androidhive.info/volley/person_object.json";
		         
		final ProgressDialog pDialog = new ProgressDialog(this);
		pDialog.setMessage("Loading...");
		pDialog.show();     
		         
		        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Method.GET,
		                url, null,
		                new Response.Listener<JSONObject>() {
		 
		                    @Override
		                    public void onResponse(JSONObject response) {
//		                        Log.d(TAG, response.toString());
		                        pDialog.hide();
		                    }
		                }, new Response.ErrorListener() {
		 
		                    @Override
		                    public void onErrorResponse(VolleyError error) {
//		                        VolleyLog.d(TAG, "Error: " + error.getMessage());
		                        // hide the progress dialog
		                        pDialog.hide();
		                    }
		                });
		 
		// Adding request to request queue
		      //Set a retry policy in case of SocketTimeout & ConnectionTimeout Exceptions. Volley does retry for you if you have specified the policy.
		jsonObjReq.setRetryPolicy(new DefaultRetryPolicy(5000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));	
		AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);
	}

	private void makeDataModel(JSONObject response){
		Gson gson = new Gson();
	    mInventoryWrapper = gson.fromJson(response.toString(), InventoryWrapper.class);
	    usedCarDataList =  mInventoryWrapper.getUsedCarDataList();
        Log.e("TAG", "none");
        mEfficientAdapter.notifyDataSetChanged();
	}
	
private  class EfficientAdapter extends BaseAdapter {
		
        private LayoutInflater mInflater;
        
        public EfficientAdapter(Context context) {
            mInflater = LayoutInflater.from(context);
        }

        public int getCount() {
        	if(usedCarDataList!=null)
            return usedCarDataList.size();
        	return 0;
        }
        
        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            final ViewHolder holder;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.listitem, null);
                holder = new ViewHolder();
                holder.image = (ImageView) convertView.findViewById(R.id.imageView1);
                holder.title = (TextView) convertView.findViewById(R.id.textView1);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            
            holder.title.setText(usedCarDataList.get(position).getCarVariantId());
            AppController.getInstance().getImageLoader().get(usedCarDataList.get(position).getCardekhoUrl(), new FadeInImageListener(holder.image,MainActivity.this));
            
/*            mImageLoader.get(mDataList.get(position).getImageUrl(), 
            							ImageLoader.getImageListener(holder.image, R.drawable.flickr, android.R.drawable.ic_dialog_alert),
            							//You can specify width & height of the bitmap to be scaled down when the image is downloaded.
            							50,50); */
            return convertView;
        }
        
        class ViewHolder {
            TextView title;
            ImageView image;
        }	
        
	}	
	
}
