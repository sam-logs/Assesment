package com.bhavna.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bhavna.bean.Referral;

public class ReferralDao {
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public int save(Referral r){    
	    String sql="insert into referral(name,id,referrals) values('"+r.getName()+"',"+r.getId()+",'"+r.getReferrals()+"')";    
	    return template.update(sql);    
	}  

	public List<Referral> getReferral() {
		return template.query("select * from referral", new RowMapper<Referral>() {
			public Referral mapRow(ResultSet rs, int row) throws SQLException {
				Referral e = new Referral();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setReferrals(rs.getInt(3));
				return e;
			}

		});
	}
}
