package com.biz.bank.exec;

import com.biz.bank.service.*;

public class bankExec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String gg = "src/com/biz/bank/exec/bankBalance.txt";
//		bankService bs = new bankService(gg);
		bankService01 bs = new bankService01(gg);
		bs.spliter(gg);
		bs.lanni();
		
		
		
	}

}
