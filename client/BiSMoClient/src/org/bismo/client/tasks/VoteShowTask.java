package org.bismo.client.tasks;

import java.util.ArrayList;

import org.bismo.client.ApplicationController;
import org.bismo.client.api.BiSMoApi;
import org.bismo.client.models.BiSMoShow;
import org.bismo.client.widgets.ShowListFragment;

import android.os.AsyncTask;

public class VoteShowTask extends AsyncTask<Integer, Void, ArrayList<BiSMoShow>> {
		private ShowListFragment mFragment;
		private ApplicationController ac;
		private Exception mException;
		
		public VoteShowTask(ApplicationController ac, ShowListFragment fragment) {
			// TODO Auto-generated constructor stub
			mFragment = fragment;
			this.ac = ac;
		}
		
		@Override
		protected  ArrayList<BiSMoShow> doInBackground(Integer... params) {
			// TODO Auto-generated method stub
			try{
				return BiSMoApi.voteShow(ac, params[0].intValue());
			}catch (Exception e) {
				mException = e;
				return null;
			}
		}
		
		@Override
		protected void onPostExecute( ArrayList<BiSMoShow> result) {
			if (mException != null) {
				//TODO:handle Exception
				mException = null;
			}else{
				if (result!=null) {
					mFragment.setShows(result);
				}
			}
		}
	}