package com.company.dao;

import java.util.ArrayList;
import java.util.Iterator;

import main.com.company.bean.ReferralCode;

public class DataDeletion {
	public void deleteData() {
		ArrayList<ReferralCode> list = new ArrayList<>();
		list.removeAll(list);
		Iterator<ReferralCode> itr = list.iterator(); // Iterator
		while (itr.hasNext()) {// check if iterator has the elements
			ReferralCode view = (ReferralCode) itr.next();
			System.out.println(view.getName() + " " + view.getNumber() + " " + ReferralCode.referral);
		}

	}

}
